/**
 */
package org.summer.dsl.model.types.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.summer.dsl.model.types.JvmFormalParameter;
import org.summer.dsl.model.types.JvmOperation;
import org.summer.dsl.model.types.JvmTypeReference;
import org.summer.dsl.model.types.TypesPackage;
import org.summer.dsl.model.xbase.XStatment;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Jvm Operation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.summer.dsl.model.types.impl.JvmOperationImpl#isStatic <em>Static</em>}</li>
 *   <li>{@link org.summer.dsl.model.types.impl.JvmOperationImpl#isAbstract <em>Abstract</em>}</li>
 *   <li>{@link org.summer.dsl.model.types.impl.JvmOperationImpl#isVirtaul <em>Virtaul</em>}</li>
 *   <li>{@link org.summer.dsl.model.types.impl.JvmOperationImpl#isOverride <em>Override</em>}</li>
 *   <li>{@link org.summer.dsl.model.types.impl.JvmOperationImpl#isNative <em>Native</em>}</li>
 *   <li>{@link org.summer.dsl.model.types.impl.JvmOperationImpl#isOverload <em>Overload</em>}</li>
 *   <li>{@link org.summer.dsl.model.types.impl.JvmOperationImpl#getReturnType <em>Return Type</em>}</li>
 *   <li>{@link org.summer.dsl.model.types.impl.JvmOperationImpl#getBody <em>Body</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class JvmOperationImpl extends JvmExecutableImpl implements JvmOperation {
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
	 * The default value of the '{@link #isAbstract() <em>Abstract</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isAbstract()
	 * @generated
	 * @ordered
	 */
	protected static final boolean ABSTRACT_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isAbstract() <em>Abstract</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isAbstract()
	 * @generated
	 * @ordered
	 */
	protected boolean abstract_ = ABSTRACT_EDEFAULT;

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
	 * The default value of the '{@link #isOverload() <em>Overload</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isOverload()
	 * @generated
	 * @ordered
	 */
	protected static final boolean OVERLOAD_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isOverload() <em>Overload</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isOverload()
	 * @generated
	 * @ordered
	 */
	protected boolean overload = OVERLOAD_EDEFAULT;

	/**
	 * The cached value of the '{@link #getReturnType() <em>Return Type</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReturnType()
	 * @generated
	 * @ordered
	 */
	protected JvmTypeReference returnType;

	/**
	 * The cached value of the '{@link #getBody() <em>Body</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBody()
	 * @generated
	 * @ordered
	 */
	protected XStatment body;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected JvmOperationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TypesPackage.Literals.JVM_OPERATION;
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
			eNotify(new ENotificationImpl(this, Notification.SET, TypesPackage.JVM_OPERATION__STATIC, oldStatic, static_));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isAbstract() {
		return abstract_;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAbstract(boolean newAbstract) {
		boolean oldAbstract = abstract_;
		abstract_ = newAbstract;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TypesPackage.JVM_OPERATION__ABSTRACT, oldAbstract, abstract_));
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
			eNotify(new ENotificationImpl(this, Notification.SET, TypesPackage.JVM_OPERATION__VIRTAUL, oldVirtaul, virtaul));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public JvmTypeReference getReturnType() {
//		if(function != null){
//			XClosure closure  = (XClosure) function;
//			return closure.getReturnType();
//		}
		return returnType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetReturnType(JvmTypeReference newReturnType, NotificationChain msgs) {
		JvmTypeReference oldReturnType = returnType;
		returnType = newReturnType;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, TypesPackage.JVM_OPERATION__RETURN_TYPE, oldReturnType, newReturnType);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setReturnType(JvmTypeReference newReturnType) {
		if (newReturnType != returnType) {
			NotificationChain msgs = null;
			if (returnType != null)
				msgs = ((InternalEObject)returnType).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - TypesPackage.JVM_OPERATION__RETURN_TYPE, null, msgs);
			if (newReturnType != null)
				msgs = ((InternalEObject)newReturnType).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - TypesPackage.JVM_OPERATION__RETURN_TYPE, null, msgs);
			msgs = basicSetReturnType(newReturnType, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TypesPackage.JVM_OPERATION__RETURN_TYPE, newReturnType, newReturnType));
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
			eNotify(new ENotificationImpl(this, Notification.SET, TypesPackage.JVM_OPERATION__NATIVE, oldNative, native_));
	}

	
	
//	@Override
//	public String getSimpleName() {
//		XClosure closure = (XClosure) function;
//		return closure.getName();
//	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isOverload() {
		return overload;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOverload(boolean newOverload) {
		boolean oldOverload = overload;
		overload = newOverload;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TypesPackage.JVM_OPERATION__OVERLOAD, oldOverload, overload));
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
			eNotify(new ENotificationImpl(this, Notification.SET, TypesPackage.JVM_OPERATION__OVERRIDE, oldOverride, override));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public XStatment getBody() {
		return body;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetBody(XStatment newBody, NotificationChain msgs) {
		XStatment oldBody = body;
		body = newBody;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, TypesPackage.JVM_OPERATION__BODY, oldBody, newBody);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBody(XStatment newBody) {
		if (newBody != body) {
			NotificationChain msgs = null;
			if (body != null)
				msgs = ((InternalEObject)body).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - TypesPackage.JVM_OPERATION__BODY, null, msgs);
			if (newBody != null)
				msgs = ((InternalEObject)newBody).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - TypesPackage.JVM_OPERATION__BODY, null, msgs);
			msgs = basicSetBody(newBody, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TypesPackage.JVM_OPERATION__BODY, newBody, newBody));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case TypesPackage.JVM_OPERATION__RETURN_TYPE:
				return basicSetReturnType(null, msgs);
			case TypesPackage.JVM_OPERATION__BODY:
				return basicSetBody(null, msgs);
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
			case TypesPackage.JVM_OPERATION__STATIC:
				return isStatic();
			case TypesPackage.JVM_OPERATION__ABSTRACT:
				return isAbstract();
			case TypesPackage.JVM_OPERATION__VIRTAUL:
				return isVirtaul();
			case TypesPackage.JVM_OPERATION__OVERRIDE:
				return isOverride();
			case TypesPackage.JVM_OPERATION__NATIVE:
				return isNative();
			case TypesPackage.JVM_OPERATION__OVERLOAD:
				return isOverload();
			case TypesPackage.JVM_OPERATION__RETURN_TYPE:
				return getReturnType();
			case TypesPackage.JVM_OPERATION__BODY:
				return getBody();
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
			case TypesPackage.JVM_OPERATION__STATIC:
				setStatic((Boolean)newValue);
				return;
			case TypesPackage.JVM_OPERATION__ABSTRACT:
				setAbstract((Boolean)newValue);
				return;
			case TypesPackage.JVM_OPERATION__VIRTAUL:
				setVirtaul((Boolean)newValue);
				return;
			case TypesPackage.JVM_OPERATION__OVERRIDE:
				setOverride((Boolean)newValue);
				return;
			case TypesPackage.JVM_OPERATION__NATIVE:
				setNative((Boolean)newValue);
				return;
			case TypesPackage.JVM_OPERATION__OVERLOAD:
				setOverload((Boolean)newValue);
				return;
			case TypesPackage.JVM_OPERATION__RETURN_TYPE:
				setReturnType((JvmTypeReference)newValue);
				return;
			case TypesPackage.JVM_OPERATION__BODY:
				setBody((XStatment)newValue);
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
			case TypesPackage.JVM_OPERATION__STATIC:
				setStatic(STATIC_EDEFAULT);
				return;
			case TypesPackage.JVM_OPERATION__ABSTRACT:
				setAbstract(ABSTRACT_EDEFAULT);
				return;
			case TypesPackage.JVM_OPERATION__VIRTAUL:
				setVirtaul(VIRTAUL_EDEFAULT);
				return;
			case TypesPackage.JVM_OPERATION__OVERRIDE:
				setOverride(OVERRIDE_EDEFAULT);
				return;
			case TypesPackage.JVM_OPERATION__NATIVE:
				setNative(NATIVE_EDEFAULT);
				return;
			case TypesPackage.JVM_OPERATION__OVERLOAD:
				setOverload(OVERLOAD_EDEFAULT);
				return;
			case TypesPackage.JVM_OPERATION__RETURN_TYPE:
				setReturnType((JvmTypeReference)null);
				return;
			case TypesPackage.JVM_OPERATION__BODY:
				setBody((XStatment)null);
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
			case TypesPackage.JVM_OPERATION__STATIC:
				return static_ != STATIC_EDEFAULT;
			case TypesPackage.JVM_OPERATION__ABSTRACT:
				return abstract_ != ABSTRACT_EDEFAULT;
			case TypesPackage.JVM_OPERATION__VIRTAUL:
				return virtaul != VIRTAUL_EDEFAULT;
			case TypesPackage.JVM_OPERATION__OVERRIDE:
				return override != OVERRIDE_EDEFAULT;
			case TypesPackage.JVM_OPERATION__NATIVE:
				return native_ != NATIVE_EDEFAULT;
			case TypesPackage.JVM_OPERATION__OVERLOAD:
				return overload != OVERLOAD_EDEFAULT;
			case TypesPackage.JVM_OPERATION__RETURN_TYPE:
				return returnType != null;
			case TypesPackage.JVM_OPERATION__BODY:
				return body != null;
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
		result.append(", abstract: ");
		result.append(abstract_);
		result.append(", virtaul: ");
		result.append(virtaul);
		result.append(", override: ");
		result.append(override);
		result.append(", native: ");
		result.append(native_);
		result.append(", overload: ");
		result.append(overload);
		result.append(')');
		return result.toString();
	}
	
	@Override
	public EList<JvmFormalParameter> getParameters() {
//		if(getFunction() != null){
//			XClosure closure = (XClosure) getFunction() ;
//			return closure.getDeclaredFormalParameters();
//		}
		return super.getParameters();
	}

} //JvmOperationImpl
