/**
 */
package eMFDelta;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see eMFDelta.EMFDeltaFactory
 * @model kind="package"
 * @generated
 */
public interface EMFDeltaPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "eMFDelta";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.example.org/eMFDelta";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "eMFDelta";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	EMFDeltaPackage eINSTANCE = eMFDelta.impl.EMFDeltaPackageImpl.init();

	/**
	 * The meta object id for the '{@link eMFDelta.impl.DeltaImpl <em>Delta</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see eMFDelta.impl.DeltaImpl
	 * @see eMFDelta.impl.EMFDeltaPackageImpl#getDelta()
	 * @generated
	 */
	int DELTA = 0;

	/**
	 * The feature id for the '<em><b>Edges</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DELTA__EDGES = 0;

	/**
	 * The feature id for the '<em><b>Objects</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DELTA__OBJECTS = 1;

	/**
	 * The feature id for the '<em><b>Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DELTA__ATTRIBUTES = 2;

	/**
	 * The number of structural features of the '<em>Delta</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DELTA_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>Delta</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DELTA_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link eMFDelta.impl.EEdgeImpl <em>EEdge</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see eMFDelta.impl.EEdgeImpl
	 * @see eMFDelta.impl.EMFDeltaPackageImpl#getEEdge()
	 * @generated
	 */
	int EEDGE = 1;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EEDGE__TYPE = 0;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EEDGE__SOURCE = 1;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EEDGE__TARGET = 2;

	/**
	 * The number of structural features of the '<em>EEdge</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EEDGE_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>EEdge</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EEDGE_OPERATION_COUNT = 0;


	/**
	 * The meta object id for the '{@link eMFDelta.impl.EAttributeEdgeImpl <em>EAttribute Edge</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see eMFDelta.impl.EAttributeEdgeImpl
	 * @see eMFDelta.impl.EMFDeltaPackageImpl#getEAttributeEdge()
	 * @generated
	 */
	int EATTRIBUTE_EDGE = 2;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EATTRIBUTE_EDGE__SOURCE = 0;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EATTRIBUTE_EDGE__TYPE = 1;

	/**
	 * The number of structural features of the '<em>EAttribute Edge</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EATTRIBUTE_EDGE_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>EAttribute Edge</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EATTRIBUTE_EDGE_OPERATION_COUNT = 0;


	/**
	 * Returns the meta object for class '{@link eMFDelta.Delta <em>Delta</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Delta</em>'.
	 * @see eMFDelta.Delta
	 * @generated
	 */
	EClass getDelta();

	/**
	 * Returns the meta object for the containment reference list '{@link eMFDelta.Delta#getEdges <em>Edges</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Edges</em>'.
	 * @see eMFDelta.Delta#getEdges()
	 * @see #getDelta()
	 * @generated
	 */
	EReference getDelta_Edges();

	/**
	 * Returns the meta object for the reference list '{@link eMFDelta.Delta#getObjects <em>Objects</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Objects</em>'.
	 * @see eMFDelta.Delta#getObjects()
	 * @see #getDelta()
	 * @generated
	 */
	EReference getDelta_Objects();

	/**
	 * Returns the meta object for the containment reference list '{@link eMFDelta.Delta#getAttributes <em>Attributes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Attributes</em>'.
	 * @see eMFDelta.Delta#getAttributes()
	 * @see #getDelta()
	 * @generated
	 */
	EReference getDelta_Attributes();

	/**
	 * Returns the meta object for class '{@link eMFDelta.EEdge <em>EEdge</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>EEdge</em>'.
	 * @see eMFDelta.EEdge
	 * @generated
	 */
	EClass getEEdge();

	/**
	 * Returns the meta object for the attribute '{@link eMFDelta.EEdge#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see eMFDelta.EEdge#getType()
	 * @see #getEEdge()
	 * @generated
	 */
	EAttribute getEEdge_Type();

	/**
	 * Returns the meta object for the reference '{@link eMFDelta.EEdge#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Source</em>'.
	 * @see eMFDelta.EEdge#getSource()
	 * @see #getEEdge()
	 * @generated
	 */
	EReference getEEdge_Source();

	/**
	 * Returns the meta object for the reference '{@link eMFDelta.EEdge#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target</em>'.
	 * @see eMFDelta.EEdge#getTarget()
	 * @see #getEEdge()
	 * @generated
	 */
	EReference getEEdge_Target();

	/**
	 * Returns the meta object for class '{@link eMFDelta.EAttributeEdge <em>EAttribute Edge</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>EAttribute Edge</em>'.
	 * @see eMFDelta.EAttributeEdge
	 * @generated
	 */
	EClass getEAttributeEdge();

	/**
	 * Returns the meta object for the reference '{@link eMFDelta.EAttributeEdge#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Source</em>'.
	 * @see eMFDelta.EAttributeEdge#getSource()
	 * @see #getEAttributeEdge()
	 * @generated
	 */
	EReference getEAttributeEdge_Source();

	/**
	 * Returns the meta object for the attribute '{@link eMFDelta.EAttributeEdge#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see eMFDelta.EAttributeEdge#getType()
	 * @see #getEAttributeEdge()
	 * @generated
	 */
	EAttribute getEAttributeEdge_Type();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	EMFDeltaFactory getEMFDeltaFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each operation of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link eMFDelta.impl.DeltaImpl <em>Delta</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see eMFDelta.impl.DeltaImpl
		 * @see eMFDelta.impl.EMFDeltaPackageImpl#getDelta()
		 * @generated
		 */
		EClass DELTA = eINSTANCE.getDelta();

		/**
		 * The meta object literal for the '<em><b>Edges</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DELTA__EDGES = eINSTANCE.getDelta_Edges();

		/**
		 * The meta object literal for the '<em><b>Objects</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DELTA__OBJECTS = eINSTANCE.getDelta_Objects();

		/**
		 * The meta object literal for the '<em><b>Attributes</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DELTA__ATTRIBUTES = eINSTANCE.getDelta_Attributes();

		/**
		 * The meta object literal for the '{@link eMFDelta.impl.EEdgeImpl <em>EEdge</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see eMFDelta.impl.EEdgeImpl
		 * @see eMFDelta.impl.EMFDeltaPackageImpl#getEEdge()
		 * @generated
		 */
		EClass EEDGE = eINSTANCE.getEEdge();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EEDGE__TYPE = eINSTANCE.getEEdge_Type();

		/**
		 * The meta object literal for the '<em><b>Source</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EEDGE__SOURCE = eINSTANCE.getEEdge_Source();

		/**
		 * The meta object literal for the '<em><b>Target</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EEDGE__TARGET = eINSTANCE.getEEdge_Target();

		/**
		 * The meta object literal for the '{@link eMFDelta.impl.EAttributeEdgeImpl <em>EAttribute Edge</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see eMFDelta.impl.EAttributeEdgeImpl
		 * @see eMFDelta.impl.EMFDeltaPackageImpl#getEAttributeEdge()
		 * @generated
		 */
		EClass EATTRIBUTE_EDGE = eINSTANCE.getEAttributeEdge();

		/**
		 * The meta object literal for the '<em><b>Source</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EATTRIBUTE_EDGE__SOURCE = eINSTANCE.getEAttributeEdge_Source();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EATTRIBUTE_EDGE__TYPE = eINSTANCE.getEAttributeEdge_Type();

	}

} //EMFDeltaPackage
