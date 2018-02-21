/**
 */
package eMFDelta;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>EAttribute Edge</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link eMFDelta.EAttributeEdge#getSource <em>Source</em>}</li>
 *   <li>{@link eMFDelta.EAttributeEdge#getType <em>Type</em>}</li>
 * </ul>
 *
 * @see eMFDelta.EMFDeltaPackage#getEAttributeEdge()
 * @model
 * @generated
 */
public interface EAttributeEdge extends EObject {
	/**
	 * Returns the value of the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source</em>' reference.
	 * @see #setSource(EObject)
	 * @see eMFDelta.EMFDeltaPackage#getEAttributeEdge_Source()
	 * @model
	 * @generated
	 */
	EObject getSource();

	/**
	 * Sets the value of the '{@link eMFDelta.EAttributeEdge#getSource <em>Source</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source</em>' reference.
	 * @see #getSource()
	 * @generated
	 */
	void setSource(EObject value);

	/**
	 * Returns the value of the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' attribute.
	 * @see #setType(String)
	 * @see eMFDelta.EMFDeltaPackage#getEAttributeEdge_Type()
	 * @model
	 * @generated
	 */
	String getType();

	/**
	 * Sets the value of the '{@link eMFDelta.EAttributeEdge#getType <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' attribute.
	 * @see #getType()
	 * @generated
	 */
	void setType(String value);

} // EAttributeEdge
