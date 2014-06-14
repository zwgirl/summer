/**
 */
package org.summer.dsl.model.types.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;
import org.summer.dsl.model.types.JvmConstraintOwner;
import org.summer.dsl.model.types.JvmTypeConstraint;
import org.summer.dsl.model.types.JvmTypeParameter;
import org.summer.dsl.model.types.JvmTypeParameterDeclarator;
import org.summer.dsl.model.types.TypesPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Jvm Type Parameter</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.summer.dsl.model.types.impl.JvmTypeParameterImpl#getConstraints <em>Constraints</em>}</li>
 *   <li>{@link org.summer.dsl.model.types.impl.JvmTypeParameterImpl#getSimpleName <em>Simple Name</em>}</li>
 *   <li>{@link org.summer.dsl.model.types.impl.JvmTypeParameterImpl#getDeclarator <em>Declarator</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class JvmTypeParameterImpl extends JvmComponentTypeImpl implements JvmTypeParameter {
	/**
	 * The cached value of the '{@link #getConstraints() <em>Constraints</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConstraints()
	 * @generated
	 * @ordered
	 */
	protected EList<JvmTypeConstraint> constraints;

	/**
	 * The default value of the '{@link #getSimpleName() <em>Simple Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSimpleName()
	 * @generated
	 * @ordered
	 */
	protected static final String SIMPLE_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSimpleName() <em>Simple Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSimpleName()
	 * @generated
	 * @ordered
	 */
	protected String simpleName = SIMPLE_NAME_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected JvmTypeParameterImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TypesPackage.Literals.JVM_TYPE_PARAMETER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<JvmTypeConstraint> getConstraints() {
		if (constraints == null) {
			constraints = new EObjectContainmentWithInverseEList<JvmTypeConstraint>(JvmTypeConstraint.class, this, TypesPackage.JVM_TYPE_PARAMETER__CONSTRAINTS, TypesPackage.JVM_TYPE_CONSTRAINT__OWNER);
		}
		return constraints;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getSimpleName() {
		return simpleName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSimpleName(String newSimpleName) {
		String oldSimpleName = simpleName;
		simpleName = newSimpleName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TypesPackage.JVM_TYPE_PARAMETER__SIMPLE_NAME, oldSimpleName, simpleName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public JvmTypeParameterDeclarator getDeclarator() {
		if (eContainerFeatureID() != TypesPackage.JVM_TYPE_PARAMETER__DECLARATOR) return null;
		return (JvmTypeParameterDeclarator)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetDeclarator(JvmTypeParameterDeclarator newDeclarator, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newDeclarator, TypesPackage.JVM_TYPE_PARAMETER__DECLARATOR, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDeclarator(JvmTypeParameterDeclarator newDeclarator) {
		if (newDeclarator != eInternalContainer() || (eContainerFeatureID() != TypesPackage.JVM_TYPE_PARAMETER__DECLARATOR && newDeclarator != null)) {
			if (EcoreUtil.isAncestor(this, newDeclarator))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newDeclarator != null)
				msgs = ((InternalEObject)newDeclarator).eInverseAdd(this, TypesPackage.JVM_TYPE_PARAMETER_DECLARATOR__TYPE_PARAMETERS, JvmTypeParameterDeclarator.class, msgs);
			msgs = basicSetDeclarator(newDeclarator, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TypesPackage.JVM_TYPE_PARAMETER__DECLARATOR, newDeclarator, newDeclarator));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case TypesPackage.JVM_TYPE_PARAMETER__CONSTRAINTS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getConstraints()).basicAdd(otherEnd, msgs);
			case TypesPackage.JVM_TYPE_PARAMETER__DECLARATOR:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetDeclarator((JvmTypeParameterDeclarator)otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case TypesPackage.JVM_TYPE_PARAMETER__CONSTRAINTS:
				return ((InternalEList<?>)getConstraints()).basicRemove(otherEnd, msgs);
			case TypesPackage.JVM_TYPE_PARAMETER__DECLARATOR:
				return basicSetDeclarator(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID()) {
			case TypesPackage.JVM_TYPE_PARAMETER__DECLARATOR:
				return eInternalContainer().eInverseRemove(this, TypesPackage.JVM_TYPE_PARAMETER_DECLARATOR__TYPE_PARAMETERS, JvmTypeParameterDeclarator.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case TypesPackage.JVM_TYPE_PARAMETER__CONSTRAINTS:
				return getConstraints();
			case TypesPackage.JVM_TYPE_PARAMETER__SIMPLE_NAME:
				return getSimpleName();
			case TypesPackage.JVM_TYPE_PARAMETER__DECLARATOR:
				return getDeclarator();
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
			case TypesPackage.JVM_TYPE_PARAMETER__CONSTRAINTS:
				getConstraints().clear();
				getConstraints().addAll((Collection<? extends JvmTypeConstraint>)newValue);
				return;
			case TypesPackage.JVM_TYPE_PARAMETER__SIMPLE_NAME:
				setSimpleName((String)newValue);
				return;
			case TypesPackage.JVM_TYPE_PARAMETER__DECLARATOR:
				setDeclarator((JvmTypeParameterDeclarator)newValue);
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
			case TypesPackage.JVM_TYPE_PARAMETER__CONSTRAINTS:
				getConstraints().clear();
				return;
			case TypesPackage.JVM_TYPE_PARAMETER__SIMPLE_NAME:
				setSimpleName(SIMPLE_NAME_EDEFAULT);
				return;
			case TypesPackage.JVM_TYPE_PARAMETER__DECLARATOR:
				setDeclarator((JvmTypeParameterDeclarator)null);
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
			case TypesPackage.JVM_TYPE_PARAMETER__CONSTRAINTS:
				return constraints != null && !constraints.isEmpty();
			case TypesPackage.JVM_TYPE_PARAMETER__SIMPLE_NAME:
				return SIMPLE_NAME_EDEFAULT == null ? simpleName != null : !SIMPLE_NAME_EDEFAULT.equals(simpleName);
			case TypesPackage.JVM_TYPE_PARAMETER__DECLARATOR:
				return getDeclarator() != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
		if (baseClass == JvmConstraintOwner.class) {
			switch (derivedFeatureID) {
				case TypesPackage.JVM_TYPE_PARAMETER__CONSTRAINTS: return TypesPackage.JVM_CONSTRAINT_OWNER__CONSTRAINTS;
				default: return -1;
			}
		}
		return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass) {
		if (baseClass == JvmConstraintOwner.class) {
			switch (baseFeatureID) {
				case TypesPackage.JVM_CONSTRAINT_OWNER__CONSTRAINTS: return TypesPackage.JVM_TYPE_PARAMETER__CONSTRAINTS;
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (simpleName: ");
		result.append(simpleName);
		result.append(')');
		return result.toString();
	}

} //JvmTypeParameterImpl
