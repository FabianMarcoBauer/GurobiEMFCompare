package emfdiff;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.uml2.uml.UMLPackage;

import ArtificialSource.SourceContainer;
import eMFDelta.Delta;
import eMFDelta.EAttributeEdge;
import eMFDelta.EMFDeltaFactory;
import eMFDelta.EMFDeltaPackage;
import gurobi.GRB;
import gurobi.GRBEnv;
import gurobi.GRBException;
import gurobi.GRBLinExpr;
import gurobi.GRBModel;
import gurobi.GRBVar;

public class EMFDiff {

	private EObject aRoot;
	private EObject bRoot;

	private boolean extractedA;
	private boolean extractedB;

	private Map<EClass, List<EObject>> aObjects = new HashMap<>();
	private Map<EClass, List<EObject>> bObjects = new HashMap<>();

	private Map<EStructuralFeature, List<EEdge>> aEdges = new HashMap<>();
	private Map<EStructuralFeature, List<EEdge>> bEdges = new HashMap<>();
	private GurobiMappedModel gurobiMappedModel;

	public EMFDiff(EObject aRoot, EObject bRoot) {
		this.aRoot = aRoot;
		this.bRoot = bRoot;
	}

	private int constrCounter = 0;
	private int varCounter = 0;

	public GurobiMappedModel createGurobiModel() {
		extractElements();
		System.out.println("found " + aObjects.values().stream().flatMap(List::stream).count() + " objects and "
				+ aEdges.values().stream().flatMap(List::stream).count() + " edges in model A");
		System.out.println("found " + bObjects.values().stream().flatMap(List::stream).count() + " objects and "
				+ bEdges.values().stream().flatMap(List::stream).count() + " edges in model B");

		Map<EObject, List<GRBVar>> BOtoVars = new HashMap<>();
		Map<EEdge, List<GRBVar>> BEtoVars = new HashMap<>();
		Map<EObject, Map<EObject, GRBVar>> ABtoVar = new HashMap<>();

		Map<GRBVar, GurobiVariableMapping<EObject>> objectVars = new HashMap<>();
		Map<GRBVar, GurobiVariableMapping<EEdge>> edgeVars = new HashMap<>();
		try {
			GRBEnv env = new GRBEnv("Gurobi_ILP.log");
			GRBModel model = new GRBModel(env);

			GRBLinExpr objective = new GRBLinExpr();

			generateFwdObjectConstraints(BOtoVars, ABtoVar, objectVars, model, objective);
			generateBedObjectConstraints(BOtoVars, model);
			generateFwdEdgeConstraints(BEtoVars, ABtoVar, edgeVars, model, objective);
			generateBwdEdgeConstraints(BEtoVars, model);

			System.out.println("gurobi model generated successfully");
			model.setObjective(objective, GRB.MAXIMIZE);

			gurobiMappedModel = new GurobiMappedModel(model, objectVars, edgeVars);
			return gurobiMappedModel;
		} catch (GRBException e) {
			throw new RuntimeException(e);
		}
	}

	private void generateBwdEdgeConstraints(Map<EEdge, List<GRBVar>> BEtoVars, GRBModel model) throws GRBException {
		System.out.println("generating edge constraints (2/2)");
		for (List<GRBVar> vars : BEtoVars.values()) {
			GRBLinExpr expr = new GRBLinExpr();
			for (GRBVar var : vars) {
				expr.addTerm(1, var);
			}
			model.addConstr(expr, GRB.LESS_EQUAL, 1.0, "edgeMapB" + ++constrCounter);
		}
	}

	private void generateFwdEdgeConstraints(Map<EEdge, List<GRBVar>> BEtoVars,
			Map<EObject, Map<EObject, GRBVar>> ABtoVar, Map<GRBVar, GurobiVariableMapping<EEdge>> edgeVars,
			GRBModel model, GRBLinExpr objective) throws GRBException {
		System.out.println("generating edge constraints (1/2)");
		for (Entry<EStructuralFeature, List<EEdge>> es : aEdges.entrySet()) {
			List<EEdge> bEdgs = bEdges.get(es.getKey());
			if (bEdgs == null)
				continue;
			List<EEdge> aEdges = es.getValue();
			for (EEdge aEdge : aEdges) {
				GRBLinExpr expr = new GRBLinExpr();
				for (EEdge bEdge : bEdgs) {
					if (aEdge.source.eClass() != bEdge.source.eClass())
						continue;
					if (aEdge.target.eClass() != bEdge.target.eClass())
						continue;

					GRBVar var = model.addVar(0.0, 1.0, 0.0, GRB.BINARY, "edge" + ++varCounter);
					BEtoVars.computeIfAbsent(bEdge, e -> new ArrayList<>()).add(var);

					objective.addTerm(1, var);
					expr.addTerm(1, var);
					edgeVars.put(var, new GurobiVariableMapping<EEdge>(var, aEdge, bEdge));

					GRBLinExpr implExprA = new GRBLinExpr();
					implExprA.addTerm(1, var);
					implExprA.addTerm(-1, ABtoVar.get(aEdge.source).get(bEdge.source));
					model.addConstr(implExprA, GRB.LESS_EQUAL, 0.0, "implS" + ++constrCounter);

					GRBLinExpr implExprB = new GRBLinExpr();
					implExprB.addTerm(1, var);
					implExprB.addTerm(-1, ABtoVar.get(aEdge.target).get(bEdge.target));
					model.addConstr(implExprB, GRB.LESS_EQUAL, 0.0, "implT" + ++constrCounter);
				}
				model.addConstr(expr, GRB.LESS_EQUAL, 1.0, "edgeMap" + ++constrCounter);
			}
		}
	}

	private void generateBedObjectConstraints(Map<EObject, List<GRBVar>> BOtoVars, GRBModel model) throws GRBException {
		System.out.println("generating object constraints (2/2)");
		for (List<GRBVar> vars : BOtoVars.values()) {
			GRBLinExpr expr = new GRBLinExpr();
			for (GRBVar var : vars) {
				expr.addTerm(1, var);
			}
			model.addConstr(expr, GRB.LESS_EQUAL, 1.0, "varMapB" + ++constrCounter);
		}
	}

	private void generateFwdObjectConstraints(Map<EObject, List<GRBVar>> BOtoVars,
			Map<EObject, Map<EObject, GRBVar>> ABtoVar, Map<GRBVar, GurobiVariableMapping<EObject>> objectVars,
			GRBModel model, GRBLinExpr objective) throws GRBException {
		System.out.println("generating object constraints (1/2)");
		for (Entry<EClass, List<EObject>> es : aObjects.entrySet()) {
			List<EObject> bVals = bObjects.get(es.getKey());
			if (bVals == null)
				continue;
			List<EObject> aVals = es.getValue();
			for (EObject aObj : aVals) {
				GRBLinExpr expr = new GRBLinExpr();
				Map<EObject, GRBVar> aVars = new HashMap<>();
				ABtoVar.put(aObj, aVars);
				EList<EAttribute> attributes = aObj.eClass().getEAllAttributes();
				for (EObject bObj : bVals) {
					if (aObj.eClass() != bObj.eClass())
						continue;

					long weight = attributes.stream().filter(attr -> Objects.equals(aObj.eGet(attr), bObj.eGet(attr)))
							.count() + 1;

					GRBVar var = model.addVar(0.0, 1.0, 0.0, GRB.BINARY, "obj" + ++varCounter);
					aVars.put(bObj, var);
					BOtoVars.computeIfAbsent(bObj, e -> new ArrayList<>()).add(var);

					objective.addTerm(weight, var);
					expr.addTerm(1, var);
					objectVars.put(var, new GurobiVariableMapping<EObject>(var, aObj, bObj));
				}
				model.addConstr(expr, GRB.LESS_EQUAL, 1.0, "varMap" + ++constrCounter);
			}
		}
	}

	public void generateDeltas(Resource aPath, Resource bPath) {
		Set<EObject> unselectedAObjects = aObjects.values().stream().flatMap(List::stream)
				.collect(Collectors.toCollection(HashSet::new));
		Set<EObject> unselectedBObjects = bObjects.values().stream().flatMap(List::stream)
				.collect(Collectors.toCollection(HashSet::new));

		List<EAttributeEdge> mismatchedAAttributes = new ArrayList<>();
		List<EAttributeEdge> mismatchedBAttributes = new ArrayList<>();

		Set<EEdge> unselectedAEdges = aEdges.values().stream().flatMap(List::stream)
				.collect(Collectors.toCollection(HashSet::new));
		Set<EEdge> unselectedBEdges = bEdges.values().stream().flatMap(List::stream)
				.collect(Collectors.toCollection(HashSet::new));

		gurobiMappedModel.getSelectedEObjectMappings().forEach(mapping -> {
			EObject aObject = mapping.getaObject();
			EObject bObject = mapping.getbObject();
			if (unselectedAObjects.remove(aObject)) {
				EList<EAttribute> attributes = aObject.eClass().getEAllAttributes();
				attributes.stream().filter(attr -> !Objects.equals(aObject.eGet(attr), bObject.eGet(attr)))
						.forEach(attr -> {
							EAttributeEdge e = EMFDeltaFactory.eINSTANCE.createEAttributeEdge();
							e.setSource(aObject);
							e.setType(attr.getName());
							mismatchedAAttributes.add(e);
						});
				;
			}
			if (unselectedBObjects.remove(bObject)) {
				EList<EAttribute> attributes = bObject.eClass().getEAllAttributes();
				attributes.stream().filter(attr -> !Objects.equals(aObject.eGet(attr), bObject.eGet(attr)))
						.forEach(attr -> {
							EAttributeEdge e = EMFDeltaFactory.eINSTANCE.createEAttributeEdge();
							e.setSource(bObject);
							e.setType(attr.getName());
							mismatchedBAttributes.add(e);
						});
				;
			}

		});

		gurobiMappedModel.getSelectedEEdgeMappings().forEach(mapping -> {
			unselectedAEdges.remove(mapping.getaObject());
			unselectedBEdges.remove(mapping.getbObject());
		});

		Delta aDelta = EMFDeltaFactory.eINSTANCE.createDelta();
		aDelta.getObjects().addAll(unselectedAObjects);
		aDelta.getAttributes().addAll(mismatchedAAttributes);
		aDelta.getEdges().addAll(unselectedAEdges.stream().map(EEdge::toDeltaEdge).collect(Collectors.toList()));
		System.out.println("ADelta: " + unselectedAObjects.size() + " objects, " + mismatchedAAttributes.size()
				+ " attributes, " + unselectedAEdges.size() + " edges");

		Delta bDelta = EMFDeltaFactory.eINSTANCE.createDelta();
		bDelta.getObjects().addAll(unselectedBObjects);
		bDelta.getAttributes().addAll(mismatchedBAttributes);
		bDelta.getEdges().addAll(unselectedBEdges.stream().map(EEdge::toDeltaEdge).collect(Collectors.toList()));
		System.out.println("BDelta: " + unselectedBObjects.size() + " objects, " + mismatchedBAttributes.size()
				+ " attributes, " + unselectedBEdges.size() + " edges");

		aPath.getContents().add(aDelta);
		bPath.getContents().add(bDelta);
	}

	private synchronized void extractElements() {
		if (!extractedA) {
			extractElements(aRoot, aObjects, aEdges);
			extractedA = true;
		}
		if (!extractedB) {
			extractElements(bRoot, bObjects, bEdges);
			extractedB = true;
		}
	}

	private void extractElements(EObject root, Map<EClass, List<EObject>> objects,
			Map<EStructuralFeature, List<EEdge>> edges) {
		TreeIterator<Object> allContents = EcoreUtil.getAllContents(root, true);
		allContents.forEachRemaining(o -> {
			processElement(objects, edges, o);
		});

		processElement(objects, edges, root);
		System.out.println(edges.entrySet().stream().map(e -> e.getKey().getName() + "::" + e.getValue().size()).collect(Collectors.toList()));
	}

	private void processElement(Map<EClass, List<EObject>> objects, Map<EStructuralFeature, List<EEdge>> edges, Object o) {
		if (!(o instanceof EObject))
			return;
		EObject eo = (EObject) o;
		objects.computeIfAbsent(eo.eClass(), c -> new ArrayList<>()).add(eo);
		eo.eClass().getEAllStructuralFeatures().stream().<EEdge>flatMap(sf -> {
			Object e = eo.eGet(sf);
			if (e instanceof EList) {
				return ((EList<?>) e).stream().filter(e2 -> e2 instanceof EObject)
						.<EEdge>map(e2 -> new EEdge(eo, sf, (EObject) e2));
			} else if (e instanceof EObject) {
				return Stream.<EEdge>of(new EEdge(eo, sf, (EObject) e));
			} else {
				return Stream.<EEdge>empty();
			}
		}).forEach(e -> edges.computeIfAbsent(e.type, e2 -> new ArrayList<>()).add(e));
	}
}
