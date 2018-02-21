package emfdiff;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

import eMFDelta.EMFDeltaFactory;

public class EEdge {
	public final EObject source;
	public final EObject target;
	public final EStructuralFeature type;

	@SuppressWarnings("null")
	public EEdge(EObject source, EStructuralFeature type, EObject target) {
		super();
		this.source = source;
		this.target = target;
		this.type = type;
	}

	public EObject getSource() {
		return source;
	}

	public EObject getTarget() {
		return target;
	}

	public EStructuralFeature getType() {
		return type;
	}

	@Override
	public String toString() {
		return "[" + source + "-" + type.getName() + "->" + target + "]";
	}

	public eMFDelta.EEdge toDeltaEdge() {
		eMFDelta.EEdge edge = EMFDeltaFactory.eINSTANCE.createEEdge();
		edge.setSource(source);
		edge.setTarget(target);
		edge.setType(type.getName());
		return edge;
	}
}
