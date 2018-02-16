package emfdiff;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
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

import gurobi.GRB;
import gurobi.GRBEnv;
import gurobi.GRBException;
import gurobi.GRBLinExpr;
import gurobi.GRBModel;
import gurobi.GRBVar;

public class EMFDiff {

	public static void main(String[] args) throws GRBException {
		Resource.Factory.Registry reg = Resource.Factory.Registry.INSTANCE;
		Map<String, Object> m = reg.getExtensionToFactoryMap();
		m.put("xmi", new XMIResourceFactoryImpl());
		UMLPackage.eINSTANCE.getName();

		ResourceSet rs = new ResourceSetImpl();
		Resource r1 = rs.getResource(URI.createFileURI(new File("instances/UML.xmi").getAbsolutePath()), true);
		Resource r2 = rs.getResource(URI.createFileURI(new File("instances/UML.xmi").getAbsolutePath()), true);

		EObject o = r1.getContents().get(0);
		EObject o2 = r2.getContents().get(0);

		List<Object> selectedMappings = new EMFDiff(o, o2).createGurobiModel().optimize().getSelectedMappings();
		selectedMappings.stream().map(NameUtil::getNameString).sorted().forEach(System.out::println);
	}

	private EObject aRoot;
	private EObject bRoot;

	private boolean extractedA;
	private boolean extractedB;

	private Map<EClass, List<EObject>> aObjects = new HashMap<>();
	private Map<EClass, List<EObject>> bObjects = new HashMap<>();

	private Map<EStructuralFeature, List<EEdge>> aEdges = new HashMap<>();
	private Map<EStructuralFeature, List<EEdge>> bEdges = new HashMap<>();

	public EMFDiff(EObject aRoot, EObject bRoot) {
		this.aRoot = aRoot;
		this.bRoot = bRoot;
	}

	public GurobiMappedModel createGurobiModel() throws GRBException {
		extractElements();
		System.out.println(aObjects);
		System.out.println(aEdges);

		Map<EObject, List<GRBVar>> BOtoVars = new HashMap<>();
		Map<EEdge, List<GRBVar>> BEtoVars = new HashMap<>();
		Map<EObject, Map<EObject, GRBVar>> ABtoVar = new HashMap<>();

		Map<GRBVar, GurobiVariableMapping<EObject>> objectVars = new HashMap<>();
		Map<GRBVar, GurobiVariableMapping<EEdge>> edgeVars = new HashMap<>();

		int varCounter = 0;
		int constrCounter = 0;

		GRBEnv env = new GRBEnv("Gurobi_ILP.log");
		GRBModel model = new GRBModel(env);

		GRBLinExpr objective = new GRBLinExpr();

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
		for (List<GRBVar> vars : BOtoVars.values()) {
			GRBLinExpr expr = new GRBLinExpr();
			for (GRBVar var : vars) {
				expr.addTerm(1, var);
			}
			model.addConstr(expr, GRB.LESS_EQUAL, 1.0, "varMapB" + ++constrCounter);
		}

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
		for (List<GRBVar> vars : BEtoVars.values()) {
			GRBLinExpr expr = new GRBLinExpr();
			for (GRBVar var : vars) {
				expr.addTerm(1, var);
			}
			model.addConstr(expr, GRB.LESS_EQUAL, 1.0, "edgeMapB" + ++constrCounter);
		}

		model.setObjective(objective, GRB.MAXIMIZE);

		return new GurobiMappedModel(model, objectVars, edgeVars);
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
			if (!(o instanceof EObject))
				return;
			EObject eo = (EObject) o;
			objects.computeIfAbsent(eo.eClass(), c -> new ArrayList<>()).add(eo);
			eo.eClass().getEAllStructuralFeatures().stream().filter(sf -> true).<EEdge>flatMap(sf -> {
				Object e = eo.eGet(sf);
				if (!(e instanceof EObject))
					return Stream.<EEdge>empty();
				if (e instanceof EList)
					return ((EList<?>) e).stream().filter(e2 -> e2 instanceof EObject)
							.<EEdge>map(e2 -> new EEdge(eo, sf, (EObject) e2));
				else
					return Stream.<EEdge>of(new EEdge(eo, sf, (EObject) e));
			}).forEach(e -> edges.computeIfAbsent(e.type, e2 -> new ArrayList<>()).add(e));
		});

		objects.computeIfAbsent(root.eClass(), c -> new ArrayList<>()).add(root);
	}
}
