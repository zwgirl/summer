/**
 */
package org.summer.dsl.model.types.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.summer.dsl.model.types.JvmEvent;
import org.summer.dsl.model.types.JvmTypeReference;
import org.summer.dsl.model.types.TypesPackage;

import org.summer.dsl.model.xbase.XExpression;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Jvm Event</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.summer.dsl.model.types.impl.JvmEventImpl#isStatic <em>Static</em>}</li>
 *   <li>{@link org.summer.dsl.model.types.impl.JvmEventImpl#isNative <em>Native</em>}</li>
 *   <li>{@link org.summer.dsl.model.types.impl.JvmEventImpl#getType <em>Type</em>}</li>
 *   <li>{@link org.summer.dsl.model.types.impl.JvmEventImpl#getAdd <em>Add</em>}</li>
 *   <li>{@link org.summer.dsl.model.types.impl.JvmEventImpl#getRemove <em>Remove</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class JvmEventImpl extends JvmFeatureImpl implements JvmEvent {
	/**
	 * The default value of the '{@link #isStatic() <em>Static</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isStatic()
	 * @generated
	 * @ordered
	 */
	protected static final boolean STATIC_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isStatic() <em>Static</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isStatic()
	 * @generated
	 * @ordered
	 */
	protected boolean static_ = STATIC_EDEFAULT;

	/**
	 * The default value of the '{@link #isNative() <em>Native</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isNative()
	 * @generated
	 * @ordered
	 */
	protected static final boolean NATIVE_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isNative() <em>Native</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isNative()
	 * @generated
	 * @ordered
	 */
	protected boolean native_ = NATIVE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getType() <em>Type</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected JvmTypeReference type;

	/**
	 * The cached value of the '{@link #getAdd() <em>Add</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAdd()
	 * @generated
	 * @ordered
	 */
	protected XExpression add;

	/**
	 * The cached value of the '{@link #getRemove() <em>Remove</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRemove()
	 * @generated
	 * @ordered
	 */
	protected XExpression remove;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected JvmEventImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TypesPackage.Literals.JVM_EVENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isStatic() {
		return static_;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStatic(boolean newStatic) {
		boolean oldStatic = static_;
		static_ = newStatic;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TypesPackage.JVM_EVENT__STATIC, oldStatic, static_));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isNative() {
		return native_;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNative(boolean newNative) {
		boolean oldNative = native_;
		native_ = newNative;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TypesPackage.JVM_EVENT__NATIVE, oldNative, native_));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public JvmTypeReference getType() {
		return type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetType(JvmTypeReference newType, NotificationChain msgs) {
		JvmTypeReference oldType = type;
		type = newType;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, TypesPackage.JVM_EVENT__TYPE, oldType, newType);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setType(JvmTypeReference newType) {
		if (newType != type) {
			NotificationChain msgs = null;
			if (type != null)
				msgs = ((InternalEObject)type).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - TypesPackage.JVM_EVENT__TYPE, null, msgs);
			if (newType != null)
				msgs = ((InternalEObject)newType).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - TypesPackage.JVM_EVENT__TYPE, null, msgs);
			msgs = basicSetType(newType, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TypesPackage.JVM_EVENT__TYPE, newType, newType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public XExpression getAdd() {
		return add;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetAdd(XExpression newAdd, NotificationChain msgs) {
		XExpression oldAdd = add;
		add = newAdd;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, TypesPackage.JVM_EVENT__ADD, oldAdd, newAdd);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAdd(XExpression newAdd) {
		if (newAdd != add) {
			NotificationChain msgs = null;
			if (add != null)
				msgs = ((InternalEObject)add).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - TypesPackage.JVM_EVENT__ADD, null, msgs);
			if (newAdd != null)
				msgs = ((InternalEObject)newAdd).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - TypesPackage.JVM_EVENT__ADD, null, msgs);
			msgs = basicSetAdd(newAdd, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TypesPackage.JVM_EVENT__ADD, newAdd, newAdd));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public XExpression getRemove() {
		return remove;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetRemove(XExpression newRemove, NotificationChain msgs) {
		XExpression oldRemove = remove;
		remove = newRemove;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, TypesPackage.JVM_EVENT__REMOVE, oldRemove, newRemove);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRemove(XExpression newRemove) {
		if (newRemove != remove) {
			NotificationChain msgs = null;
			if (remove != null)
				msgs = ((InternalEObject)remove).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - TypesPackage.JVM_EVENT__REMOVE, null, msgs);
			if (newRemove != null)
				msgs = ((InternalEObject)newRemove).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - TypesPackage.JVM_EVENT__REMOVE, null, msgs);
			msgs = basicSetRemove(newRemove, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TypesPackage.JVM_EVENT__REMOVE, newRemove, newRemove));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case TypesPackage.JVM_EVENT__TYPE:
				return basicSetType(null, msgs);
			case TypesPackage.JVM_EVENT__ADD:
				return basicSetAdd(null, msgs);
			case TypesPackage.JVM_EVENT__REMOVE:
				return basicSetRemove(null, msgs);
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
			case TypesPackage.JVM_EVENT__STATIC:
				return isStatic();
			case TypesPackage.JVM_EVENT__NATIVE:
				return isNative();
			case TypesPackage.JVM_EVENT__TYPE:
				return getType();
			case TypesPackage.JVM_EVENT__ADD:
				return getAdd();
			case TypesPackage.JVM_EVENT__REMOVE:
				return getRemove();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case TypesPackage.JVM_EVENT__STATIC:
				setStatic((Boolean)newValue);
				return;
			case TypesPackage.JVM_EVENT__NATIVE:
				setNative((Boolean)newValue);
				return;
			case TypesPackage.JVM_EVENT__TYPE:
				setType((JvmTypeReference)newValue);
				return;
			case TypesPackage.JVM_EVENT__ADD:
				setAdd((XExpression)newValue);
				return;
			case TypesPackage.JVM_EVENT__REMOVE:
				setRemove((XExpression)newValue);
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
			case TypesPackage.JVM_EVENT__STATIC:
				setStatic(STATIC_EDEFAULT);
				return;
			case TypesPackage.JVM_EVENT__NATIVE:
				setNative(NATIVE_EDEFAULT);
				return;
			case TypesPackage.JVM_EVENT__TYPE:
				setType((JvmTypeReference)null);
				return;
			case TypesPackage.JVM_EVENT__ADD:
				setAdd((XExpression)null);
				return;
			case TypesPackage.JVM_EVENT__REMOVE:
				setRemove((XExpression)null);
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
			case TypesPackage.JVM_EVENT__STATIC:
				return static_ != STATIC_EDEFAULT;
			case TypesPackage.JVM_EVENT__NATIVE:
				return native_ != NATIVE_EDEFAULT;
			case TypesPackage.JVM_EVENT__TYPE:
				return type != null;
			case TypesPackage.JVM_EVENT__ADD:
				return add != null;
			case TypesPackage.JVM_EVENT__REMOVE:
				return remove != null;
		}
		return super.eIsSet(featureID);
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
		result.append(" (static: ");
		result.append(static_);
		result.append(", native: ");
		result.append(native_);
		result.append(')');
		return result.toString();
	}

} //JvmEventImpl
