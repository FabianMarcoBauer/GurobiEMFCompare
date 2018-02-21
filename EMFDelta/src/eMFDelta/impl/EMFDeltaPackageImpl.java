/**
 */
package eMFDelta.impl;

import eMFDelta.Delta;
import eMFDelta.EAttributeEdge;
import eMFDelta.EEdge;
import eMFDelta.EMFDeltaFactory;
import eMFDelta.EMFDeltaPackage;

import ecore.EcorePackage;

import ecore.impl.EcorePackageImpl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class EMFDeltaPackageImpl extends EPackageImpl implements EMFDeltaPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass deltaEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass eEdgeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass eAttributeEdgeEClass = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see eMFDelta.EMFDeltaPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private EMFDeltaPackageImpl() {
		super(eNS_URI, EMFDeltaFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * 
	 * <p>This method is used to initialize {@link EMFDeltaPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static EMFDeltaPackage init() {
		if (isInited) return (EMFDeltaPackage)EPackage.Registry.INSTANCE.getEPackage(EMFDeltaPackage.eNS_URI);

		// Obtain or create and register package
		EMFDeltaPackageImpl theEMFDeltaPackage = (EMFDeltaPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof EMFDeltaPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new EMFDeltaPackageImpl());

		isInited = true;

		// Obtain or create and register interdependencies
		EcorePackageImpl theEcorePackage = (EcorePackageImpl)(EPackage.Registry.INSTANCE.getEPackage(EcorePackage.eNS_URI) instanceof EcorePackageImpl ? EPackage.Registry.INSTANCE.getEPackage(EcorePackage.eNS_URI) : EcorePackage.eINSTANCE);

		// Create package meta-data objects
		theEMFDeltaPackage.createPackageContents();
		theEcorePackage.createPackageContents();

		// Initialize created meta-data
		theEMFDeltaPackage.initializePackageContents();
		theEcorePackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theEMFDeltaPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(EMFDeltaPackage.eNS_URI, theEMFDeltaPackage);
		return theEMFDeltaPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDelta() {
		return deltaEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDelta_Edges() {
		return (EReference)deltaEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDelta_Objects() {
		return (EReference)deltaEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDelta_Attributes() {
		return (EReference)deltaEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEEdge() {
		return eEdgeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEEdge_Type() {
		return (EAttribute)eEdgeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEEdge_Source() {
		return (EReference)eEdgeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEEdge_Target() {
		return (EReference)eEdgeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEAttributeEdge() {
		return eAttributeEdgeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEAttributeEdge_Source() {
		return (EReference)eAttributeEdgeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEAttributeEdge_Type() {
		return (EAttribute)eAttributeEdgeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EMFDeltaFactory getEMFDeltaFactory() {
		return (EMFDeltaFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		deltaEClass = createEClass(DELTA);
		createEReference(deltaEClass, DELTA__EDGES);
		createEReference(deltaEClass, DELTA__OBJECTS);
		createEReference(deltaEClass, DELTA__ATTRIBUTES);

		eEdgeEClass = createEClass(EEDGE);
		createEAttribute(eEdgeEClass, EEDGE__TYPE);
		createEReference(eEdgeEClass, EEDGE__SOURCE);
		createEReference(eEdgeEClass, EEDGE__TARGET);

		eAttributeEdgeEClass = createEClass(EATTRIBUTE_EDGE);
		createEReference(eAttributeEdgeEClass, EATTRIBUTE_EDGE__SOURCE);
		createEAttribute(eAttributeEdgeEClass, EATTRIBUTE_EDGE__TYPE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes

		// Initialize classes, features, and operations; add parameters
		initEClass(deltaEClass, Delta.class, "Delta", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDelta_Edges(), this.getEEdge(), null, "edges", null, 0, -1, Delta.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDelta_Objects(), ecorePackage.getEObject(), null, "objects", null, 0, -1, Delta.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDelta_Attributes(), this.getEAttributeEdge(), null, "attributes", null, 0, -1, Delta.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(eEdgeEClass, EEdge.class, "EEdge", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getEEdge_Type(), ecorePackage.getEString(), "type", null, 0, 1, EEdge.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEEdge_Source(), ecorePackage.getEObject(), null, "source", null, 0, 1, EEdge.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEEdge_Target(), ecorePackage.getEObject(), null, "target", null, 0, 1, EEdge.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(eAttributeEdgeEClass, EAttributeEdge.class, "EAttributeEdge", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getEAttributeEdge_Source(), ecorePackage.getEObject(), null, "source", null, 0, 1, EAttributeEdge.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEAttributeEdge_Type(), ecorePackage.getEString(), "type", null, 0, 1, EAttributeEdge.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);
	}

} //EMFDeltaPackageImpl
