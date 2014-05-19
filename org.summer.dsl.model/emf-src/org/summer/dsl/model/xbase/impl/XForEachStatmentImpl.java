/**
 */
package org.summer.dsl.model.xbase.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.summer.dsl.model.types.JvmFormalParameter;

import org.summer.dsl.model.xbase.XExpression;
import org.summer.dsl.model.xbase.XForEachStatment;
import org.summer.dsl.model.xbase.XStatment;
import org.summer.dsl.model.xbase.XbasePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>XFor Each Expression</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.summer.dsl.model.xbase.impl.XForEachStatmentImpl#getDeclaredParam <em>Declared Param</em>}</li>
 *   <li>{@link org.summer.dsl.model.xbase.impl.XForEachStatmentImpl#getExpression <em>Expression</em>}</li>
 *   <li>{@link org.summer.dsl.model.xbase.impl.XForEachStatmentImpl#getStatment <em>Statment</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class XForEachStatmentImpl extends XStatmentImpl implements XForEachStatment {
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
	 * The cached value of the '{@link #getExpression() <em>Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExpression()
	 * @generated
	 * @ordered
	 */
	protected XExpression expression;

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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected XForEachStatmentImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return XbasePackage.Literals.XFOR_EACH_STATMENT;
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, XbasePackage.XFOR_EACH_STATMENT__DECLARED_PARAM, oldDeclaredParam, newDeclaredParam);
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
				msgs = ((InternalEObject)declaredParam).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - XbasePackage.XFOR_EACH_STATMENT__DECLARED_PARAM, null, msgs);
			if (newDeclaredParam != null)
				msgs = ((InternalEObject)newDeclaredParam).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - XbasePackage.XFOR_EACH_STATMENT__DECLARED_PARAM, null, msgs);
			msgs = basicSetDeclaredParam(newDeclaredParam, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, XbasePackage.XFOR_EACH_STATMENT__DECLARED_PARAM, newDeclaredParam, newDeclaredParam));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public XExpression getExpression() {
		return expression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetExpression(XExpression newExpression, NotificationChain msgs) {
		XExpression oldExpression = expression;
		expression = newExpression;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, XbasePackage.XFOR_EACH_STATMENT__EXPRESSION, oldExpression, newExpression);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setExpression(XExpression newExpression) {
		if (newExpression != expression) {
			NotificationChain msgs = null;
			if (expression != null)
				msgs = ((InternalEObject)expression).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - XbasePackage.XFOR_EACH_STATMENT__EXPRESSION, null, msgs);
			if (newExpression != null)
				msgs = ((InternalEObject)newExpression).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - XbasePackage.XFOR_EACH_STATMENT__EXPRESSION, null, msgs);
			msgs = basicSetExpression(newExpression, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, XbasePackage.XFOR_EACH_STATMENT__EXPRESSION, newExpression, newExpression));
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, XbasePackage.XFOR_EACH_STATMENT__STATMENT, oldStatment, newStatment);
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
				msgs = ((InternalEObject)statment).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - XbasePackage.XFOR_EACH_STATMENT__STATMENT, null, msgs);
			if (newStatment != null)
				msgs = ((InternalEObject)newStatment).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - XbasePackage.XFOR_EACH_STATMENT__STATMENT, null, msgs);
			msgs = basicSetStatment(newStatment, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, XbasePackage.XFOR_EACH_STATMENT__STATMENT, newStatment, newStatment));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case XbasePackage.XFOR_EACH_STATMENT__DECLARED_PARAM:
				return basicSetDeclaredParam(null, msgs);
			case XbasePackage.XFOR_EACH_STATMENT__EXPRESSION:
				return basicSetExpression(null, msgs);
			case XbasePackage.XFOR_EACH_STATMENT__STATMENT:
				return basicSetStatment(null, msgs);
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
			case XbasePackage.XFOR_EACH_STATMENT__DECLARED_PARAM:
				return getDeclaredParam();
			case XbasePackage.XFOR_EACH_STATMENT__EXPRESSION:
				return getExpression();
			case XbasePackage.XFOR_EACH_STATMENT__STATMENT:
				return getStatment();
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
			case XbasePackage.XFOR_EACH_STATMENT__DECLARED_PARAM:
				setDeclaredParam((JvmFormalParameter)newValue);
				return;
			case XbasePackage.XFOR_EACH_STATMENT__EXPRESSION:
				setExpression((XExpression)newValue);
				return;
			case XbasePackage.XFOR_EACH_STATMENT__STATMENT:
				setStatment((XStatment)newValue);
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
			case XbasePackage.XFOR_EACH_STATMENT__DECLARED_PARAM:
				setDeclaredParam((JvmFormalParameter)null);
				return;
			case XbasePackage.XFOR_EACH_STATMENT__EXPRESSION:
				setExpression((XExpression)null);
				return;
			case XbasePackage.XFOR_EACH_STATMENT__STATMENT:
				setStatment((XStatment)null);
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
			case XbasePackage.XFOR_EACH_STATMENT__DECLARED_PARAM:
				return declaredParam != null;
			case XbasePackage.XFOR_EACH_STATMENT__EXPRESSION:
				return expression != null;
			case XbasePackage.XFOR_EACH_STATMENT__STATMENT:
				return statment != null;
		}
		return super.eIsSet(featureID);
	}

} //XForEachExpressionImpl
