/**
 */
package eMFDelta.impl;

import eMFDelta.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class EMFDeltaFactoryImpl extends EFactoryImpl implements EMFDeltaFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static EMFDeltaFactory init() {
		try {
			EMFDeltaFactory theEMFDeltaFactory = (EMFDeltaFactory)EPackage.Registry.INSTANCE.getEFactory(EMFDeltaPackage.eNS_URI);
			if (theEMFDeltaFactory != null) {
				return theEMFDeltaFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new EMFDeltaFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EMFDeltaFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case EMFDeltaPackage.DELTA: return createDelta();
			case EMFDeltaPackage.EEDGE: return createEEdge();
			case EMFDeltaPackage.EATTRIBUTE_EDGE: return createEAttributeEdge();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Delta createDelta() {
		DeltaImpl delta = new DeltaImpl();
		return delta;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEdge createEEdge() {
		EEdgeImpl eEdge = new EEdgeImpl();
		return eEdge;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttributeEdge createEAttributeEdge() {
		EAttributeEdgeImpl eAttributeEdge = new EAttributeEdgeImpl();
		return eAttributeEdge;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EMFDeltaPackage getEMFDeltaPackage() {
		return (EMFDeltaPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static EMFDeltaPackage getPackage() {
		return EMFDeltaPackage.eINSTANCE;
	}

} //EMFDeltaFactoryImpl
