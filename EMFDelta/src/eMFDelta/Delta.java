/**
 */
package eMFDelta;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Delta</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link eMFDelta.Delta#getEdges <em>Edges</em>}</li>
 *   <li>{@link eMFDelta.Delta#getObjects <em>Objects</em>}</li>
 *   <li>{@link eMFDelta.Delta#getAttributes <em>Attributes</em>}</li>
 * </ul>
 *
 * @see eMFDelta.EMFDeltaPackage#getDelta()
 * @model
 * @generated
 */
public interface Delta extends EObject {
	/**
	 * Returns the value of the '<em><b>Edges</b></em>' containment reference list.
	 * The list contents are of type {@link eMFDelta.EEdge}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Edges</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Edges</em>' containment reference list.
	 * @see eMFDelta.EMFDeltaPackage#getDelta_Edges()
	 * @model containment="true"
	 * @generated
	 */
	EList<EEdge> getEdges();

	/**
	 * Returns the value of the '<em><b>Objects</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.emf.ecore.EObject}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Objects</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Objects</em>' reference list.
	 * @see eMFDelta.EMFDeltaPackage#getDelta_Objects()
	 * @model
	 * @generated
	 */
	EList<EObject> getObjects();

	/**
	 * Returns the value of the '<em><b>Attributes</b></em>' containment reference list.
	 * The list contents are of type {@link eMFDelta.EAttributeEdge}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Attributes</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Attributes</em>' containment reference list.
	 * @see eMFDelta.EMFDeltaPackage#getDelta_Attributes()
	 * @model containment="true"
	 * @generated
	 */
	EList<EAttributeEdge> getAttributes();

} // Delta
