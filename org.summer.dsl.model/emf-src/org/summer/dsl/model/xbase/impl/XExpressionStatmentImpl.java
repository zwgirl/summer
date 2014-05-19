/**
 */
package org.summer.dsl.model.xbase.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.summer.dsl.model.xbase.XExpression;
import org.summer.dsl.model.xbase.XExpressionStatment;
import org.summer.dsl.model.xbase.XbasePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>XExpression Statment</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.summer.dsl.model.xbase.impl.XExpressionStatmentImpl#getExpression <em>Expression</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class XExpressionStatmentImpl extends XStatmentImpl implements XExpressionStatment {
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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected XExpressionStatmentImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return XbasePackage.Literals.XEXPRESSION_STATMENT;
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, XbasePackage.XEXPRESSION_STATMENT__EXPRESSION, oldExpression, newExpression);
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
				msgs = ((InternalEObject)expression).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - XbasePackage.XEXPRESSION_STATMENT__EXPRESSION, null, msgs);
			if (newExpression != null)
				msgs = ((InternalEObject)newExpression).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - XbasePackage.XEXPRESSION_STATMENT__EXPRESSION, null, msgs);
			msgs = basicSetExpression(newExpression, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, XbasePackage.XEXPRESSION_STATMENT__EXPRESSION, newExpression, newExpression));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case XbasePackage.XEXPRESSION_STATMENT__EXPRESSION:
				return basicSetExpression(null, msgs);
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
			case XbasePackage.XEXPRESSION_STATMENT__EXPRESSION:
				return getExpression();
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
			case XbasePackage.XEXPRESSION_STATMENT__EXPRESSION:
				setExpression((XExpression)newValue);
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
			case XbasePackage.XEXPRESSION_STATMENT__EXPRESSION:
				setExpression((XExpression)null);
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
			case XbasePackage.XEXPRESSION_STATMENT__EXPRESSION:
				return expression != null;
		}
		return super.eIsSet(featureID);
	}

} //XExpressionStatmentImpl
