/**
 */
package org.summer.dsl.model.xbase.impl;

import java.util.Collection;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.summer.dsl.model.types.JvmFormalParameter;
import org.summer.dsl.model.types.JvmTypeParameter;
import org.summer.dsl.model.types.JvmTypeReference;
import org.summer.dsl.model.xbase.XFunction;
import org.summer.dsl.model.xbase.XStatment;
import org.summer.dsl.model.xbase.XbasePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>XFunction</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.summer.dsl.model.xbase.impl.XFunctionImpl#getDeclaredFormalParameters <em>Declared Formal Parameters</em>}</li>
 *   <li>{@link org.summer.dsl.model.xbase.impl.XFunctionImpl#getBody <em>Body</em>}</li>
 *   <li>{@link org.summer.dsl.model.xbase.impl.XFunctionImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.summer.dsl.model.xbase.impl.XFunctionImpl#getReturnType <em>Return Type</em>}</li>
 *   <li>{@link org.summer.dsl.model.xbase.impl.XFunctionImpl#getTypeParameters <em>Type Parameters</em>}</li>
 *   <li>{@link org.summer.dsl.model.xbase.impl.XFunctionImpl#isExported <em>Exported</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class XFunctionImpl extends XStatmentImpl implements XFunction {
	/**
	 * The cached value of the '{@link #getDeclaredFormalParameters() <em>Declared Formal Parameters</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDeclaredFormalParameters()
	 * @generated
	 * @ordered
	 */
	protected EList<JvmFormalParameter> declaredFormalParameters;

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
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

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
	 * The cached value of the '{@link #getTypeParameters() <em>Type Parameters</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTypeParameters()
	 * @generated
	 * @ordered
	 */
	protected EList<JvmTypeParameter> typeParameters;

	/**
	 * The default value of the '{@link #isExported() <em>Exported</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isExported()
	 * @generated
	 * @ordered
	 */
	protected static final boolean EXPORTED_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isExported() <em>Exported</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isExported()
	 * @generated
	 * @ordered
	 */
	protected boolean exported = EXPORTED_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected XFunctionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return XbasePackage.Literals.XFUNCTION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<JvmFormalParameter> getDeclaredFormalParameters() {
		if (declaredFormalParameters == null) {
			declaredFormalParameters = new EObjectContainmentEList<JvmFormalParameter>(JvmFormalParameter.class, this, XbasePackage.XFUNCTION__DECLARED_FORMAL_PARAMETERS);
		}
		return declaredFormalParameters;
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, XbasePackage.XFUNCTION__BODY, oldBody, newBody);
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
				msgs = ((InternalEObject)body).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - XbasePackage.XFUNCTION__BODY, null, msgs);
			if (newBody != null)
				msgs = ((InternalEObject)newBody).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - XbasePackage.XFUNCTION__BODY, null, msgs);
			msgs = basicSetBody(newBody, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, XbasePackage.XFUNCTION__BODY, newBody, newBody));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, XbasePackage.XFUNCTION__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public JvmTypeReference getReturnType() {
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, XbasePackage.XFUNCTION__RETURN_TYPE, oldReturnType, newReturnType);
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
				msgs = ((InternalEObject)returnType).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - XbasePackage.XFUNCTION__RETURN_TYPE, null, msgs);
			if (newReturnType != null)
				msgs = ((InternalEObject)newReturnType).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - XbasePackage.XFUNCTION__RETURN_TYPE, null, msgs);
			msgs = basicSetReturnType(newReturnType, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, XbasePackage.XFUNCTION__RETURN_TYPE, newReturnType, newReturnType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<JvmTypeParameter> getTypeParameters() {
		if (typeParameters == null) {
			typeParameters = new EObjectContainmentEList<JvmTypeParameter>(JvmTypeParameter.class, this, XbasePackage.XFUNCTION__TYPE_PARAMETERS);
		}
		return typeParameters;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isExported() {
		return exported;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setExported(boolean newExported) {
		boolean oldExported = exported;
		exported = newExported;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, XbasePackage.XFUNCTION__EXPORTED, oldExported, exported));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<JvmFormalParameter> getFormalParameters() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getIdentifier() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getSimpleName() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getQualifiedName() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getQualifiedName(char innerClassDelimiter) {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case XbasePackage.XFUNCTION__DECLARED_FORMAL_PARAMETERS:
				return ((InternalEList<?>)getDeclaredFormalParameters()).basicRemove(otherEnd, msgs);
			case XbasePackage.XFUNCTION__BODY:
				return basicSetBody(null, msgs);
			case XbasePackage.XFUNCTION__RETURN_TYPE:
				return basicSetReturnType(null, msgs);
			case XbasePackage.XFUNCTION__TYPE_PARAMETERS:
				return ((InternalEList<?>)getTypeParameters()).basicRemove(otherEnd, msgs);
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
			case XbasePackage.XFUNCTION__DECLARED_FORMAL_PARAMETERS:
				return getDeclaredFormalParameters();
			case XbasePackage.XFUNCTION__BODY:
				return getBody();
			case XbasePackage.XFUNCTION__NAME:
				return getName();
			case XbasePackage.XFUNCTION__RETURN_TYPE:
				return getReturnType();
			case XbasePackage.XFUNCTION__TYPE_PARAMETERS:
				return getTypeParameters();
			case XbasePackage.XFUNCTION__EXPORTED:
				return isExported();
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
			case XbasePackage.XFUNCTION__DECLARED_FORMAL_PARAMETERS:
				getDeclaredFormalParameters().clear();
				getDeclaredFormalParameters().addAll((Collection<? extends JvmFormalParameter>)newValue);
				return;
			case XbasePackage.XFUNCTION__BODY:
				setBody((XStatment)newValue);
				return;
			case XbasePackage.XFUNCTION__NAME:
				setName((String)newValue);
				return;
			case XbasePackage.XFUNCTION__RETURN_TYPE:
				setReturnType((JvmTypeReference)newValue);
				return;
			case XbasePackage.XFUNCTION__TYPE_PARAMETERS:
				getTypeParameters().clear();
				getTypeParameters().addAll((Collection<? extends JvmTypeParameter>)newValue);
				return;
			case XbasePackage.XFUNCTION__EXPORTED:
				setExported((Boolean)newValue);
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
			case XbasePackage.XFUNCTION__DECLARED_FORMAL_PARAMETERS:
				getDeclaredFormalParameters().clear();
				return;
			case XbasePackage.XFUNCTION__BODY:
				setBody((XStatment)null);
				return;
			case XbasePackage.XFUNCTION__NAME:
				setName(NAME_EDEFAULT);
				return;
			case XbasePackage.XFUNCTION__RETURN_TYPE:
				setReturnType((JvmTypeReference)null);
				return;
			case XbasePackage.XFUNCTION__TYPE_PARAMETERS:
				getTypeParameters().clear();
				return;
			case XbasePackage.XFUNCTION__EXPORTED:
				setExported(EXPORTED_EDEFAULT);
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
			case XbasePackage.XFUNCTION__DECLARED_FORMAL_PARAMETERS:
				return declaredFormalParameters != null && !declaredFormalParameters.isEmpty();
			case XbasePackage.XFUNCTION__BODY:
				return body != null;
			case XbasePackage.XFUNCTION__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case XbasePackage.XFUNCTION__RETURN_TYPE:
				return returnType != null;
			case XbasePackage.XFUNCTION__TYPE_PARAMETERS:
				return typeParameters != null && !typeParameters.isEmpty();
			case XbasePackage.XFUNCTION__EXPORTED:
				return exported != EXPORTED_EDEFAULT;
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
		result.append(" (name: ");
		result.append(name);
		result.append(", exported: ");
		result.append(exported);
		result.append(')');
		return result.toString();
	}

} //XFunctionImpl
