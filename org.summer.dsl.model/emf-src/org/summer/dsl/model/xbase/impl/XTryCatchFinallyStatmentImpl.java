/**
 */
package org.summer.dsl.model.xbase.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.summer.dsl.model.xbase.XCatchClause;
import org.summer.dsl.model.xbase.XStatment;
import org.summer.dsl.model.xbase.XTryCatchFinallyStatment;
import org.summer.dsl.model.xbase.XbasePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>XTry Catch Finally Expression</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.summer.dsl.model.xbase.impl.XTryCatchFinallyStatmentImpl#getStatment <em>Statment</em>}</li>
 *   <li>{@link org.summer.dsl.model.xbase.impl.XTryCatchFinallyStatmentImpl#getFinallyStatment <em>Finally Statment</em>}</li>
 *   <li>{@link org.summer.dsl.model.xbase.impl.XTryCatchFinallyStatmentImpl#getCatchClause <em>Catch Clause</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class XTryCatchFinallyStatmentImpl extends XStatmentImpl implements XTryCatchFinallyStatment {
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
	 * The cached value of the '{@link #getFinallyStatment() <em>Finally Statment</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFinallyStatment()
	 * @generated
	 * @ordered
	 */
	protected XStatment finallyStatment;

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
	protected XTryCatchFinallyStatmentImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return XbasePackage.Literals.XTRY_CATCH_FINALLY_STATMENT;
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, XbasePackage.XTRY_CATCH_FINALLY_STATMENT__STATMENT, oldStatment, newStatment);
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
				msgs = ((InternalEObject)statment).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - XbasePackage.XTRY_CATCH_FINALLY_STATMENT__STATMENT, null, msgs);
			if (newStatment != null)
				msgs = ((InternalEObject)newStatment).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - XbasePackage.XTRY_CATCH_FINALLY_STATMENT__STATMENT, null, msgs);
			msgs = basicSetStatment(newStatment, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, XbasePackage.XTRY_CATCH_FINALLY_STATMENT__STATMENT, newStatment, newStatment));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public XStatment getFinallyStatment() {
		return finallyStatment;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetFinallyStatment(XStatment newFinallyStatment, NotificationChain msgs) {
		XStatment oldFinallyStatment = finallyStatment;
		finallyStatment = newFinallyStatment;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, XbasePackage.XTRY_CATCH_FINALLY_STATMENT__FINALLY_STATMENT, oldFinallyStatment, newFinallyStatment);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFinallyStatment(XStatment newFinallyStatment) {
		if (newFinallyStatment != finallyStatment) {
			NotificationChain msgs = null;
			if (finallyStatment != null)
				msgs = ((InternalEObject)finallyStatment).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - XbasePackage.XTRY_CATCH_FINALLY_STATMENT__FINALLY_STATMENT, null, msgs);
			if (newFinallyStatment != null)
				msgs = ((InternalEObject)newFinallyStatment).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - XbasePackage.XTRY_CATCH_FINALLY_STATMENT__FINALLY_STATMENT, null, msgs);
			msgs = basicSetFinallyStatment(newFinallyStatment, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, XbasePackage.XTRY_CATCH_FINALLY_STATMENT__FINALLY_STATMENT, newFinallyStatment, newFinallyStatment));
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, XbasePackage.XTRY_CATCH_FINALLY_STATMENT__CATCH_CLAUSE, oldCatchClause, newCatchClause);
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
				msgs = ((InternalEObject)catchClause).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - XbasePackage.XTRY_CATCH_FINALLY_STATMENT__CATCH_CLAUSE, null, msgs);
			if (newCatchClause != null)
				msgs = ((InternalEObject)newCatchClause).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - XbasePackage.XTRY_CATCH_FINALLY_STATMENT__CATCH_CLAUSE, null, msgs);
			msgs = basicSetCatchClause(newCatchClause, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, XbasePackage.XTRY_CATCH_FINALLY_STATMENT__CATCH_CLAUSE, newCatchClause, newCatchClause));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case XbasePackage.XTRY_CATCH_FINALLY_STATMENT__STATMENT:
				return basicSetStatment(null, msgs);
			case XbasePackage.XTRY_CATCH_FINALLY_STATMENT__FINALLY_STATMENT:
				return basicSetFinallyStatment(null, msgs);
			case XbasePackage.XTRY_CATCH_FINALLY_STATMENT__CATCH_CLAUSE:
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
			case XbasePackage.XTRY_CATCH_FINALLY_STATMENT__STATMENT:
				return getStatment();
			case XbasePackage.XTRY_CATCH_FINALLY_STATMENT__FINALLY_STATMENT:
				return getFinallyStatment();
			case XbasePackage.XTRY_CATCH_FINALLY_STATMENT__CATCH_CLAUSE:
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
			case XbasePackage.XTRY_CATCH_FINALLY_STATMENT__STATMENT:
				setStatment((XStatment)newValue);
				return;
			case XbasePackage.XTRY_CATCH_FINALLY_STATMENT__FINALLY_STATMENT:
				setFinallyStatment((XStatment)newValue);
				return;
			case XbasePackage.XTRY_CATCH_FINALLY_STATMENT__CATCH_CLAUSE:
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
			case XbasePackage.XTRY_CATCH_FINALLY_STATMENT__STATMENT:
				setStatment((XStatment)null);
				return;
			case XbasePackage.XTRY_CATCH_FINALLY_STATMENT__FINALLY_STATMENT:
				setFinallyStatment((XStatment)null);
				return;
			case XbasePackage.XTRY_CATCH_FINALLY_STATMENT__CATCH_CLAUSE:
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
			case XbasePackage.XTRY_CATCH_FINALLY_STATMENT__STATMENT:
				return statment != null;
			case XbasePackage.XTRY_CATCH_FINALLY_STATMENT__FINALLY_STATMENT:
				return finallyStatment != null;
			case XbasePackage.XTRY_CATCH_FINALLY_STATMENT__CATCH_CLAUSE:
				return catchClause != null;
		}
		return super.eIsSet(featureID);
	}

} //XTryCatchFinallyExpressionImpl
