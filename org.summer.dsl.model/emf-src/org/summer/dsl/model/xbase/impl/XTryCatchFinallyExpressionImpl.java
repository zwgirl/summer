/**
 */
package org.summer.dsl.model.xbase.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.summer.dsl.model.xbase.XCatchClause;
import org.summer.dsl.model.xbase.XExpression;
import org.summer.dsl.model.xbase.XTryCatchFinallyExpression;
import org.summer.dsl.model.xbase.XbasePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>XTry Catch Finally Expression</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.summer.dsl.model.xbase.impl.XTryCatchFinallyExpressionImpl#getExpression <em>Expression</em>}</li>
 *   <li>{@link org.summer.dsl.model.xbase.impl.XTryCatchFinallyExpressionImpl#getFinallyExpression <em>Finally Expression</em>}</li>
 *   <li>{@link org.summer.dsl.model.xbase.impl.XTryCatchFinallyExpressionImpl#getCatchClause <em>Catch Clause</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class XTryCatchFinallyExpressionImpl extends XExpressionImpl implements XTryCatchFinallyExpression {
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
	 * The cached value of the '{@link #getFinallyExpression() <em>Finally Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFinallyExpression()
	 * @generated
	 * @ordered
	 */
	protected XExpression finallyExpression;

	/**
	 * The cached value of the '{@link #getCatchClause() <em>Catch Clause</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCatchClause()
	 * @generated
	 * @ordered
	 */
	protected XCatchClause catchClause;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected XTryCatchFinallyExpressionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return XbasePackage.Literals.XTRY_CATCH_FINALLY_EXPRESSION;
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, XbasePackage.XTRY_CATCH_FINALLY_EXPRESSION__EXPRESSION, oldExpression, newExpression);
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
				msgs = ((InternalEObject)expression).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - XbasePackage.XTRY_CATCH_FINALLY_EXPRESSION__EXPRESSION, null, msgs);
			if (newExpression != null)
				msgs = ((InternalEObject)newExpression).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - XbasePackage.XTRY_CATCH_FINALLY_EXPRESSION__EXPRESSION, null, msgs);
			msgs = basicSetExpression(newExpression, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, XbasePackage.XTRY_CATCH_FINALLY_EXPRESSION__EXPRESSION, newExpression, newExpression));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public XExpression getFinallyExpression() {
		return finallyExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetFinallyExpression(XExpression newFinallyExpression, NotificationChain msgs) {
		XExpression oldFinallyExpression = finallyExpression;
		finallyExpression = newFinallyExpression;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, XbasePackage.XTRY_CATCH_FINALLY_EXPRESSION__FINALLY_EXPRESSION, oldFinallyExpression, newFinallyExpression);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFinallyExpression(XExpression newFinallyExpression) {
		if (newFinallyExpression != finallyExpression) {
			NotificationChain msgs = null;
			if (finallyExpression != null)
				msgs = ((InternalEObject)finallyExpression).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - XbasePackage.XTRY_CATCH_FINALLY_EXPRESSION__FINALLY_EXPRESSION, null, msgs);
			if (newFinallyExpression != null)
				msgs = ((InternalEObject)newFinallyExpression).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - XbasePackage.XTRY_CATCH_FINALLY_EXPRESSION__FINALLY_EXPRESSION, null, msgs);
			msgs = basicSetFinallyExpression(newFinallyExpression, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, XbasePackage.XTRY_CATCH_FINALLY_EXPRESSION__FINALLY_EXPRESSION, newFinallyExpression, newFinallyExpression));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public XCatchClause getCatchClause() {
		return catchClause;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCatchClause(XCatchClause newCatchClause, NotificationChain msgs) {
		XCatchClause oldCatchClause = catchClause;
		catchClause = newCatchClause;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, XbasePackage.XTRY_CATCH_FINALLY_EXPRESSION__CATCH_CLAUSE, oldCatchClause, newCatchClause);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCatchClause(XCatchClause newCatchClause) {
		if (newCatchClause != catchClause) {
			NotificationChain msgs = null;
			if (catchClause != null)
				msgs = ((InternalEObject)catchClause).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - XbasePackage.XTRY_CATCH_FINALLY_EXPRESSION__CATCH_CLAUSE, null, msgs);
			if (newCatchClause != null)
				msgs = ((InternalEObject)newCatchClause).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - XbasePackage.XTRY_CATCH_FINALLY_EXPRESSION__CATCH_CLAUSE, null, msgs);
			msgs = basicSetCatchClause(newCatchClause, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, XbasePackage.XTRY_CATCH_FINALLY_EXPRESSION__CATCH_CLAUSE, newCatchClause, newCatchClause));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case XbasePackage.XTRY_CATCH_FINALLY_EXPRESSION__EXPRESSION:
				return basicSetExpression(null, msgs);
			case XbasePackage.XTRY_CATCH_FINALLY_EXPRESSION__FINALLY_EXPRESSION:
				return basicSetFinallyExpression(null, msgs);
			case XbasePackage.XTRY_CATCH_FINALLY_EXPRESSION__CATCH_CLAUSE:
				return basicSetCatchClause(null, msgs);
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
			case XbasePackage.XTRY_CATCH_FINALLY_EXPRESSION__EXPRESSION:
				return getExpression();
			case XbasePackage.XTRY_CATCH_FINALLY_EXPRESSION__FINALLY_EXPRESSION:
				return getFinallyExpression();
			case XbasePackage.XTRY_CATCH_FINALLY_EXPRESSION__CATCH_CLAUSE:
				return getCatchClause();
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
			case XbasePackage.XTRY_CATCH_FINALLY_EXPRESSION__EXPRESSION:
				setExpression((XExpression)newValue);
				return;
			case XbasePackage.XTRY_CATCH_FINALLY_EXPRESSION__FINALLY_EXPRESSION:
				setFinallyExpression((XExpression)newValue);
				return;
			case XbasePackage.XTRY_CATCH_FINALLY_EXPRESSION__CATCH_CLAUSE:
				setCatchClause((XCatchClause)newValue);
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
			case XbasePackage.XTRY_CATCH_FINALLY_EXPRESSION__EXPRESSION:
				setExpression((XExpression)null);
				return;
			case XbasePackage.XTRY_CATCH_FINALLY_EXPRESSION__FINALLY_EXPRESSION:
				setFinallyExpression((XExpression)null);
				return;
			case XbasePackage.XTRY_CATCH_FINALLY_EXPRESSION__CATCH_CLAUSE:
				setCatchClause((XCatchClause)null);
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
			case XbasePackage.XTRY_CATCH_FINALLY_EXPRESSION__EXPRESSION:
				return expression != null;
			case XbasePackage.XTRY_CATCH_FINALLY_EXPRESSION__FINALLY_EXPRESSION:
				return finallyExpression != null;
			case XbasePackage.XTRY_CATCH_FINALLY_EXPRESSION__CATCH_CLAUSE:
				return catchClause != null;
		}
		return super.eIsSet(featureID);
	}

} //XTryCatchFinallyExpressionImpl
