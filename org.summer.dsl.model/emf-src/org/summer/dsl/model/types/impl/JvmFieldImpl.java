/**
 */
package org.summer.dsl.model.types.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.summer.dsl.model.types.JvmField;
import org.summer.dsl.model.types.JvmTypeReference;
import org.summer.dsl.model.types.TypesPackage;
import org.summer.dsl.model.xbase.XExpression;
import org.summer.dsl.model.xbase.XStatment;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Jvm Field</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.summer.dsl.model.types.impl.JvmFieldImpl#isStatic <em>Static</em>}</li>
 *   <li>{@link org.summer.dsl.model.types.impl.JvmFieldImpl#isConst <em>Const</em>}</li>
 *   <li>{@link org.summer.dsl.model.types.impl.JvmFieldImpl#isTransient <em>Transient</em>}</li>
 *   <li>{@link org.summer.dsl.model.types.impl.JvmFieldImpl#isVirtaul <em>Virtaul</em>}</li>
 *   <li>{@link org.summer.dsl.model.types.impl.JvmFieldImpl#isOverride <em>Override</em>}</li>
 *   <li>{@link org.summer.dsl.model.types.impl.JvmFieldImpl#isProperty <em>Property</em>}</li>
 *   <li>{@link org.summer.dsl.model.types.impl.JvmFieldImpl#getType <em>Type</em>}</li>
 *   <li>{@link org.summer.dsl.model.types.impl.JvmFieldImpl#getDefaultValue <em>Default Value</em>}</li>
 *   <li>{@link org.summer.dsl.model.types.impl.JvmFieldImpl#getSet <em>Set</em>}</li>
 *   <li>{@link org.summer.dsl.model.types.impl.JvmFieldImpl#getGet <em>Get</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class JvmFieldImpl extends JvmFeatureImpl implements JvmField {
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
	 * The default value of the '{@link #isConst() <em>Const</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isConst()
	 * @generated
	 * @ordered
	 */
	protected static final boolean CONST_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isConst() <em>Const</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isConst()
	 * @generated
	 * @ordered
	 */
	protected boolean const_ = CONST_EDEFAULT;

	/**
	 * The default value of the '{@link #isTransient() <em>Transient</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isTransient()
	 * @generated
	 * @ordered
	 */
	protected static final boolean TRANSIENT_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isTransient() <em>Transient</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isTransient()
	 * @generated
	 * @ordered
	 */
	protected boolean transient_ = TRANSIENT_EDEFAULT;

	/**
	 * The default value of the '{@link #isVirtaul() <em>Virtaul</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isVirtaul()
	 * @generated
	 * @ordered
	 */
	protected static final boolean VIRTAUL_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isVirtaul() <em>Virtaul</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isVirtaul()
	 * @generated
	 * @ordered
	 */
	protected boolean virtaul = VIRTAUL_EDEFAULT;

	/**
	 * The default value of the '{@link #isOverride() <em>Override</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isOverride()
	 * @generated
	 * @ordered
	 */
	protected static final boolean OVERRIDE_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isOverride() <em>Override</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isOverride()
	 * @generated
	 * @ordered
	 */
	protected boolean override = OVERRIDE_EDEFAULT;

	/**
	 * The default value of the '{@link #isProperty() <em>Property</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isProperty()
	 * @generated
	 * @ordered
	 */
	protected static final boolean PROPERTY_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isProperty() <em>Property</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isProperty()
	 * @generated
	 * @ordered
	 */
	protected boolean property = PROPERTY_EDEFAULT;

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
	 * The cached value of the '{@link #getDefaultValue() <em>Default Value</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDefaultValue()
	 * @generated
	 * @ordered
	 */
	protected XExpression defaultValue;

	/**
	 * The cached value of the '{@link #getSet() <em>Set</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSet()
	 * @generated
	 * @ordered
	 */
	protected XStatment set;

	/**
	 * The cached value of the '{@link #getGet() <em>Get</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGet()
	 * @generated
	 * @ordered
	 */
	protected XStatment get;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected JvmFieldImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TypesPackage.Literals.JVM_FIELD;
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
			eNotify(new ENotificationImpl(this, Notification.SET, TypesPackage.JVM_FIELD__STATIC, oldStatic, static_));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isConst() {
		return const_;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setConst(boolean newConst) {
		boolean oldConst = const_;
		const_ = newConst;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TypesPackage.JVM_FIELD__CONST, oldConst, const_));
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, TypesPackage.JVM_FIELD__TYPE, oldType, newType);
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
				msgs = ((InternalEObject)type).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - TypesPackage.JVM_FIELD__TYPE, null, msgs);
			if (newType != null)
				msgs = ((InternalEObject)newType).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - TypesPackage.JVM_FIELD__TYPE, null, msgs);
			msgs = basicSetType(newType, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TypesPackage.JVM_FIELD__TYPE, newType, newType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isTransient() {
		return transient_;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTransient(boolean newTransient) {
		boolean oldTransient = transient_;
		transient_ = newTransient;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TypesPackage.JVM_FIELD__TRANSIENT, oldTransient, transient_));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isVirtaul() {
		return virtaul;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setVirtaul(boolean newVirtaul) {
		boolean oldVirtaul = virtaul;
		virtaul = newVirtaul;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TypesPackage.JVM_FIELD__VIRTAUL, oldVirtaul, virtaul));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isOverride() {
		return override;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOverride(boolean newOverride) {
		boolean oldOverride = override;
		override = newOverride;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TypesPackage.JVM_FIELD__OVERRIDE, oldOverride, override));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isProperty() {
		return property;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setProperty(boolean newProperty) {
		boolean oldProperty = property;
		property = newProperty;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TypesPackage.JVM_FIELD__PROPERTY, oldProperty, property));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public XExpression getDefaultValue() {
		return defaultValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetDefaultValue(XExpression newDefaultValue, NotificationChain msgs) {
		XExpression oldDefaultValue = defaultValue;
		defaultValue = newDefaultValue;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, TypesPackage.JVM_FIELD__DEFAULT_VALUE, oldDefaultValue, newDefaultValue);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDefaultValue(XExpression newDefaultValue) {
		if (newDefaultValue != defaultValue) {
			NotificationChain msgs = null;
			if (defaultValue != null)
				msgs = ((InternalEObject)defaultValue).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - TypesPackage.JVM_FIELD__DEFAULT_VALUE, null, msgs);
			if (newDefaultValue != null)
				msgs = ((InternalEObject)newDefaultValue).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - TypesPackage.JVM_FIELD__DEFAULT_VALUE, null, msgs);
			msgs = basicSetDefaultValue(newDefaultValue, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TypesPackage.JVM_FIELD__DEFAULT_VALUE, newDefaultValue, newDefaultValue));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public XStatment getSet() {
		return set;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSet(XStatment newSet, NotificationChain msgs) {
		XStatment oldSet = set;
		set = newSet;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, TypesPackage.JVM_FIELD__SET, oldSet, newSet);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSet(XStatment newSet) {
		if (newSet != set) {
			NotificationChain msgs = null;
			if (set != null)
				msgs = ((InternalEObject)set).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - TypesPackage.JVM_FIELD__SET, null, msgs);
			if (newSet != null)
				msgs = ((InternalEObject)newSet).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - TypesPackage.JVM_FIELD__SET, null, msgs);
			msgs = basicSetSet(newSet, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TypesPackage.JVM_FIELD__SET, newSet, newSet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public XStatment getGet() {
		return get;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetGet(XStatment newGet, NotificationChain msgs) {
		XStatment oldGet = get;
		get = newGet;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, TypesPackage.JVM_FIELD__GET, oldGet, newGet);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setGet(XStatment newGet) {
		if (newGet != get) {
			NotificationChain msgs = null;
			if (get != null)
				msgs = ((InternalEObject)get).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - TypesPackage.JVM_FIELD__GET, null, msgs);
			if (newGet != null)
				msgs = ((InternalEObject)newGet).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - TypesPackage.JVM_FIELD__GET, null, msgs);
			msgs = basicSetGet(newGet, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TypesPackage.JVM_FIELD__GET, newGet, newGet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case TypesPackage.JVM_FIELD__TYPE:
				return basicSetType(null, msgs);
			case TypesPackage.JVM_FIELD__DEFAULT_VALUE:
				return basicSetDefaultValue(null, msgs);
			case TypesPackage.JVM_FIELD__SET:
				return basicSetSet(null, msgs);
			case TypesPackage.JVM_FIELD__GET:
				return basicSetGet(null, msgs);
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
			case TypesPackage.JVM_FIELD__STATIC:
				return isStatic();
			case TypesPackage.JVM_FIELD__CONST:
				return isConst();
			case TypesPackage.JVM_FIELD__TRANSIENT:
				return isTransient();
			case TypesPackage.JVM_FIELD__VIRTAUL:
				return isVirtaul();
			case TypesPackage.JVM_FIELD__OVERRIDE:
				return isOverride();
			case TypesPackage.JVM_FIELD__PROPERTY:
				return isProperty();
			case TypesPackage.JVM_FIELD__TYPE:
				return getType();
			case TypesPackage.JVM_FIELD__DEFAULT_VALUE:
				return getDefaultValue();
			case TypesPackage.JVM_FIELD__SET:
				return getSet();
			case TypesPackage.JVM_FIELD__GET:
				return getGet();
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
			case TypesPackage.JVM_FIELD__STATIC:
				setStatic((Boolean)newValue);
				return;
			case TypesPackage.JVM_FIELD__CONST:
				setConst((Boolean)newValue);
				return;
			case TypesPackage.JVM_FIELD__TRANSIENT:
				setTransient((Boolean)newValue);
				return;
			case TypesPackage.JVM_FIELD__VIRTAUL:
				setVirtaul((Boolean)newValue);
				return;
			case TypesPackage.JVM_FIELD__OVERRIDE:
				setOverride((Boolean)newValue);
				return;
			case TypesPackage.JVM_FIELD__PROPERTY:
				setProperty((Boolean)newValue);
				return;
			case TypesPackage.JVM_FIELD__TYPE:
				setType((JvmTypeReference)newValue);
				return;
			case TypesPackage.JVM_FIELD__DEFAULT_VALUE:
				setDefaultValue((XExpression)newValue);
				return;
			case TypesPackage.JVM_FIELD__SET:
				setSet((XStatment)newValue);
				return;
			case TypesPackage.JVM_FIELD__GET:
				setGet((XStatment)newValue);
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
			case TypesPackage.JVM_FIELD__STATIC:
				setStatic(STATIC_EDEFAULT);
				return;
			case TypesPackage.JVM_FIELD__CONST:
				setConst(CONST_EDEFAULT);
				return;
			case TypesPackage.JVM_FIELD__TRANSIENT:
				setTransient(TRANSIENT_EDEFAULT);
				return;
			case TypesPackage.JVM_FIELD__VIRTAUL:
				setVirtaul(VIRTAUL_EDEFAULT);
				return;
			case TypesPackage.JVM_FIELD__OVERRIDE:
				setOverride(OVERRIDE_EDEFAULT);
				return;
			case TypesPackage.JVM_FIELD__PROPERTY:
				setProperty(PROPERTY_EDEFAULT);
				return;
			case TypesPackage.JVM_FIELD__TYPE:
				setType((JvmTypeReference)null);
				return;
			case TypesPackage.JVM_FIELD__DEFAULT_VALUE:
				setDefaultValue((XExpression)null);
				return;
			case TypesPackage.JVM_FIELD__SET:
				setSet((XStatment)null);
				return;
			case TypesPackage.JVM_FIELD__GET:
				setGet((XStatment)null);
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
			case TypesPackage.JVM_FIELD__STATIC:
				return static_ != STATIC_EDEFAULT;
			case TypesPackage.JVM_FIELD__CONST:
				return const_ != CONST_EDEFAULT;
			case TypesPackage.JVM_FIELD__TRANSIENT:
				return transient_ != TRANSIENT_EDEFAULT;
			case TypesPackage.JVM_FIELD__VIRTAUL:
				return virtaul != VIRTAUL_EDEFAULT;
			case TypesPackage.JVM_FIELD__OVERRIDE:
				return override != OVERRIDE_EDEFAULT;
			case TypesPackage.JVM_FIELD__PROPERTY:
				return property != PROPERTY_EDEFAULT;
			case TypesPackage.JVM_FIELD__TYPE:
				return type != null;
			case TypesPackage.JVM_FIELD__DEFAULT_VALUE:
				return defaultValue != null;
			case TypesPackage.JVM_FIELD__SET:
				return set != null;
			case TypesPackage.JVM_FIELD__GET:
				return get != null;
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
		result.append(", const: ");
		result.append(const_);
		result.append(", transient: ");
		result.append(transient_);
		result.append(", virtaul: ");
		result.append(virtaul);
		result.append(", override: ");
		result.append(override);
		result.append(", property: ");
		result.append(property);
		result.append(')');
		return result.toString();
	}

} //JvmFieldImpl
