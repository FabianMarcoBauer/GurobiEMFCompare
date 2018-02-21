package emfdiff;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.eclipse.emf.ecore.EObject;

import gurobi.GRB;
import gurobi.GRBException;
import gurobi.GRBModel;
import gurobi.GRBVar;

public class GurobiMappedModel {
	private final GRBModel model;
	private final Map<GRBVar, GurobiVariableMapping<EObject>> objectMappings;
	private final Map<GRBVar, GurobiVariableMapping<EEdge>> edgeMappings;

	public GurobiMappedModel(GRBModel model, Map<GRBVar, GurobiVariableMapping<EObject>> objectMappings,
			Map<GRBVar, GurobiVariableMapping<EEdge>> edgeMappings) {
		super();
		this.model = model;
		this.objectMappings = objectMappings;
		this.edgeMappings = edgeMappings;
	}

	public GRBModel getModel() {
		return model;
	}

	public Map<GRBVar, GurobiVariableMapping<EObject>> getObjectMappings() {
		return objectMappings;
	}

	public Map<GRBVar, GurobiVariableMapping<EEdge>> getEdgeMappings() {
		return edgeMappings;
	}

	public GurobiMappedModel optimize() throws GRBException {
		model.optimize();
		return this;
	}

	public List<GurobiVariableMapping<EObject>> getSelectedEObjectMappings() {
		return objectMappings.entrySet().stream().filter(selected()).map(Entry::getValue).collect(Collectors.toList());
	}
	

	public List<GurobiVariableMapping<EEdge>> getSelectedEEdgeMappings() {
		return edgeMappings.entrySet().stream().filter(selected()).map(Entry::getValue).collect(Collectors.toList());
	}
	
	public <T> List<T> getSelectedContents(Function<? super GurobiVariableMapping<? extends Object>, T> mapper) {
		return Stream.concat(objectMappings.entrySet().stream(), edgeMappings.entrySet().stream()).filter(selected()).map(Entry::getValue).map(mapper).collect(Collectors.toList());
	}


	public List<Object> getSelectedMappings() {
		return getSelectedContents(e -> e);
	}

	public List<Object> getSelectedAContents() {
		return getSelectedContents(GurobiVariableMapping::getaObject);
	}

	public List<Object> getSelectedBContents() {
		return getSelectedContents(GurobiVariableMapping::getbObject);
	}
	

	private Predicate<? super Entry<GRBVar, ? extends GurobiVariableMapping<? extends Object>>> selected() {
		return e -> {
			try {
				return e.getKey().get(GRB.DoubleAttr.X) > 0;
			} catch (GRBException e1) {
				throw new RuntimeException(e1);
			}
		};
	}

}
