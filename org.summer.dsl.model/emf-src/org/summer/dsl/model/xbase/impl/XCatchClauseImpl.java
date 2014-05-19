/**
 */
package org.summer.dsl.model.xbase.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.summer.dsl.model.types.JvmFormalParameter;
import org.summer.dsl.model.xbase.XCatchClause;
import org.summer.dsl.model.xbase.XStatment;
import org.summer.dsl.model.xbase.XbasePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>XCatch Clause</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.summer.dsl.model.xbase.impl.XCatchClauseImpl#getStatment <em>Statment</em>}</li>
 *   <li>{@link org.summer.dsl.model.xbase.impl.XCatchClauseImpl#getDeclaredParam <em>Declared Param</em>}</li>
 *   <li>{@link org.summer.dsl.model.xbase.impl.XCatchClauseImpl#getIdentifier <em>Identifier</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class XCatchClauseImpl extends MinimalEObjectImpl.Container implements XCatchClause {
	/**
	 * The cached value of the '{@link #getStatment() <em>Statment</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStatment()
	 * @generated
	 * @ordered
	 */
	protected XStatment statment;

	/**
	 * The cached value of the '{@link #getDeclaredParam() <em>Declared Param</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDeclaredParam()
	 * @generated
	 * @ordered
	 */
	protected JvmFormalParameter declaredParam;

	/**
	 * The default value of the '{@link #getIdentifier() <em>Identifier</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIdentifier()
	 * @generated
	 * @ordered
	 */
	protected static final String IDENTIFIER_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getIdentifier() <em>Identifier</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIdentifier()
	 * @generated
	 * @ordered
	 */
	protected String identifier = IDENTIFIER_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected XCatchClauseImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return XbasePackage.Literals.XCATCH_CLAUSE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public XStatment getStatment() {
		return statment;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetStatment(XStatment newStatment, NotificationChain msgs) {
		XStatment oldStatment = statment;
		statment = newStatment;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, XbasePackage.XCATCH_CLAUSE__STATMENT, oldStatment, newStatment);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStatment(XStatment newStatment) {
		if (newStatment != statment) {
			NotificationChain msgs = null;
			if (statment != null)
				msgs = ((InternalEObject)statment).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - XbasePackage.XCATCH_CLAUSE__STATMENT, null, msgs);
			if (newStatment != null)
				msgs = ((InternalEObject)newStatment).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - XbasePackage.XCATCH_CLAUSE__STATMENT, null, msgs);
			msgs = basicSetStatment(newStatment, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, XbasePackage.XCATCH_CLAUSE__STATMENT, newStatment, newStatment));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public JvmFormalParameter getDeclaredParam() {
		return declaredParam;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetDeclaredParam(JvmFormalParameter newDeclaredParam, NotificationChain msgs) {
		JvmFormalParameter oldDeclaredParam = declaredParam;
		declaredParam = newDeclaredParam;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, XbasePackage.XCATCH_CLAUSE__DECLARED_PARAM, oldDeclaredParam, newDeclaredParam);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDeclaredParam(JvmFormalParameter newDeclaredParam) {
		if (newDeclaredParam != declaredParam) {
			NotificationChain msgs = null;
			if (declaredParam != null)
				msgs = ((InternalEObject)declaredParam).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - XbasePackage.XCATCH_CLAUSE__DECLARED_PARAM, null, msgs);
			if (newDeclaredParam != null)
				msgs = ((InternalEObject)newDeclaredParam).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - XbasePackage.XCATCH_CLAUSE__DECLARED_PARAM, null, msgs);
			msgs = basicSetDeclaredParam(newDeclaredParam, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, XbasePackage.XCATCH_CLAUSE__DECLARED_PARAM, newDeclaredParam, newDeclaredParam));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getIdentifier() {
		return identifier;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIdentifier(String newIdentifier) {
		String oldIdentifier = identifier;
		identifier = newIdentifier;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, XbasePackage.XCATCH_CLAUSE__IDENTIFIER, oldIdentifier, identifier));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case XbasePackage.XCATCH_CLAUSE__STATMENT:
				return basicSetStatment(null, msgs);
			case XbasePackage.XCATCH_CLAUSE__DECLARED_PARAM:
				return basicSetDeclaredParam(null, msgs);
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
			case XbasePackage.XCATCH_CLAUSE__STATMENT:
				return getStatment();
			case XbasePackage.XCATCH_CLAUSE__DECLARED_PARAM:
				return getDeclaredParam();
			case XbasePackage.XCATCH_CLAUSE__IDENTIFIER:
				return getIdentifier();
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
			case XbasePackage.XCATCH_CLAUSE__STATMENT:
				setStatment((XStatment)newValue);
				return;
			case XbasePackage.XCATCH_CLAUSE__DECLARED_PARAM:
				setDeclaredParam((JvmFormalParameter)newValue);
				return;
			case XbasePackage.XCATCH_CLAUSE__IDENTIFIER:
				setIdentifier((String)newValue);
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
			case XbasePackage.XCATCH_CLAUSE__STATMENT:
				setStatment((XStatment)null);
				return;
			case XbasePackage.XCATCH_CLAUSE__DECLARED_PARAM:
				setDeclaredParam((JvmFormalParameter)null);
				return;
			case XbasePackage.XCATCH_CLAUSE__IDENTIFIER:
				setIdentifier(IDENTIFIER_EDEFAULT);
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
			case XbasePackage.XCATCH_CLAUSE__STATMENT:
				return statment != null;
			case XbasePackage.XCATCH_CLAUSE__DECLARED_PARAM:
				return declaredParam != null;
			case XbasePackage.XCATCH_CLAUSE__IDENTIFIER:
				return IDENTIFIER_EDEFAULT == null ? identifier != null : !IDENTIFIER_EDEFAULT.equals(identifier);
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
		result.append(" (identifier: ");
		result.append(identifier);
		result.append(')');
		return result.toString();
	}

} //XCatchClauseImpl
