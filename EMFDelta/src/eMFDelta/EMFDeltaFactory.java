/**
 */
package eMFDelta;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see eMFDelta.EMFDeltaPackage
 * @generated
 */
public interface EMFDeltaFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	EMFDeltaFactory eINSTANCE = eMFDelta.impl.EMFDeltaFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Delta</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Delta</em>'.
	 * @generated
	 */
	Delta createDelta();

	/**
	 * Returns a new object of class '<em>EEdge</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>EEdge</em>'.
	 * @generated
	 */
	EEdge createEEdge();

	/**
	 * Returns a new object of class '<em>EAttribute Edge</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>EAttribute Edge</em>'.
	 * @generated
	 */
	EAttributeEdge createEAttributeEdge();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	EMFDeltaPackage getEMFDeltaPackage();

} //EMFDeltaFactory
