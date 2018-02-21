/**
 */
package eMFDelta.impl;

import eMFDelta.Delta;
import eMFDelta.EAttributeEdge;
import eMFDelta.EEdge;
import eMFDelta.EMFDeltaPackage;

import java.util.Collection;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Delta</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link eMFDelta.impl.DeltaImpl#getEdges <em>Edges</em>}</li>
 *   <li>{@link eMFDelta.impl.DeltaImpl#getObjects <em>Objects</em>}</li>
 *   <li>{@link eMFDelta.impl.DeltaImpl#getAttributes <em>Attributes</em>}</li>
 * </ul>
 *
 * @generated
 */
public class DeltaImpl extends MinimalEObjectImpl.Container implements Delta {
	/**
	 * The cached value of the '{@link #getEdges() <em>Edges</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEdges()
	 * @generated
	 * @ordered
	 */
	protected EList<EEdge> edges;

	/**
	 * The cached value of the '{@link #getObjects() <em>Objects</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getObjects()
	 * @generated
	 * @ordered
	 */
	protected EList<EObject> objects;

	/**
	 * The cached value of the '{@link #getAttributes() <em>Attributes</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAttributes()
	 * @generated
	 * @ordered
	 */
	protected EList<EAttributeEdge> attributes;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DeltaImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EMFDeltaPackage.Literals.DELTA;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<EEdge> getEdges() {
		if (edges == null) {
			edges = new EObjectContainmentEList<EEdge>(EEdge.class, this, EMFDeltaPackage.DELTA__EDGES);
		}
		return edges;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<EObject> getObjects() {
		if (objects == null) {
			objects = new EObjectResolvingEList<EObject>(EObject.class, this, EMFDeltaPackage.DELTA__OBJECTS);
		}
		return objects;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<EAttributeEdge> getAttributes() {
		if (attributes == null) {
			attributes = new EObjectContainmentEList<EAttributeEdge>(EAttributeEdge.class, this, EMFDeltaPackage.DELTA__ATTRIBUTES);
		}
		return attributes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case EMFDeltaPackage.DELTA__EDGES:
				return ((InternalEList<?>)getEdges()).basicRemove(otherEnd, msgs);
			case EMFDeltaPackage.DELTA__ATTRIBUTES:
				return ((InternalEList<?>)getAttributes()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case EMFDeltaPackage.DELTA__EDGES:
				return getEdges();
			case EMFDeltaPackage.DELTA__OBJECTS:
				return getObjects();
			case EMFDeltaPackage.DELTA__ATTRIBUTES:
				return getAttributes();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case EMFDeltaPackage.DELTA__EDGES:
				getEdges().clear();
				getEdges().addAll((Collection<? extends EEdge>)newValue);
				return;
			case EMFDeltaPackage.DELTA__OBJECTS:
				getObjects().clear();
				getObjects().addAll((Collection<? extends EObject>)newValue);
				return;
			case EMFDeltaPackage.DELTA__ATTRIBUTES:
				getAttributes().clear();
				getAttributes().addAll((Collection<? extends EAttributeEdge>)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case EMFDeltaPackage.DELTA__EDGES:
				getEdges().clear();
				return;
			case EMFDeltaPackage.DELTA__OBJECTS:
				getObjects().clear();
				return;
			case EMFDeltaPackage.DELTA__ATTRIBUTES:
				getAttributes().clear();
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case EMFDeltaPackage.DELTA__EDGES:
				return edges != null && !edges.isEmpty();
			case EMFDeltaPackage.DELTA__OBJECTS:
				return objects != null && !objects.isEmpty();
			case EMFDeltaPackage.DELTA__ATTRIBUTES:
				return attributes != null && !attributes.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //DeltaImpl
