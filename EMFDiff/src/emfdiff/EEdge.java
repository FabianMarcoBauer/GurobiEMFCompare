package emfdiff;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

public class EEdge {
	public final EObject source;
	public final EObject target;
	public final EStructuralFeature type;
	
	public EEdge(EObject source, EStructuralFeature type, EObject target) {
		super();
		this.source = source;
		this.target = target;
		this.type = type;
	}
	
}
