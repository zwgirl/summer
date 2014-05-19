/**
 */
package org.summer.dsl.model.xbase.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.summer.dsl.model.xbase.XAbstractWhileStatment;
import org.summer.dsl.model.xbase.XExpression;
import org.summer.dsl.model.xbase.XStatment;
import org.summer.dsl.model.xbase.XbasePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>XAbstract While Expression</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.summer.dsl.model.xbase.impl.XAbstractWhileStatmentImpl#getPredicate <em>Predicate</em>}</li>
 *   <li>{@link org.summer.dsl.model.xbase.impl.XAbstractWhileStatmentImpl#getBody <em>Body</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class XAbstractWhileStatmentImpl extends XStatmentImpl implements XAbstractWhileStatment {
	/**
	 * The cached value of the '{@link #getPredicate() <em>Predicate</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPredicate()
	 * @generated
	 * @ordered
	 */
	protected XExpression predicate;

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
	protected XAbstractWhileStatmentImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return XbasePackage.Literals.XABSTRACT_WHILE_STATMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public XExpression getPredicate() {
		return predicate;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetPredicate(XExpression newPredicate, NotificationChain msgs) {
		XExpression oldPredicate = predicate;
		predicate = newPredicate;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, XbasePackage.XABSTRACT_WHILE_STATMENT__PREDICATE, oldPredicate, newPredicate);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPredicate(XExpression newPredicate) {
		if (newPredicate != predicate) {
			NotificationChain msgs = null;
			if (predicate != null)
				msgs = ((InternalEObject)predicate).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - XbasePackage.XABSTRACT_WHILE_STATMENT__PREDICATE, null, msgs);
			if (newPredicate != null)
				msgs = ((InternalEObject)newPredicate).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - XbasePackage.XABSTRACT_WHILE_STATMENT__PREDICATE, null, msgs);
			msgs = basicSetPredicate(newPredicate, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, XbasePackage.XABSTRACT_WHILE_STATMENT__PREDICATE, newPredicate, newPredicate));
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, XbasePackage.XABSTRACT_WHILE_STATMENT__BODY, oldBody, newBody);
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
				msgs = ((InternalEObject)body).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - XbasePackage.XABSTRACT_WHILE_STATMENT__BODY, null, msgs);
			if (newBody != null)
				msgs = ((InternalEObject)newBody).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - XbasePackage.XABSTRACT_WHILE_STATMENT__BODY, null, msgs);
			msgs = basicSetBody(newBody, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, XbasePackage.XABSTRACT_WHILE_STATMENT__BODY, newBody, newBody));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case XbasePackage.XABSTRACT_WHILE_STATMENT__PREDICATE:
				return basicSetPredicate(null, msgs);
			case XbasePackage.XABSTRACT_WHILE_STATMENT__BODY:
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
			case XbasePackage.XABSTRACT_WHILE_STATMENT__PREDICATE:
				return getPredicate();
			case XbasePackage.XABSTRACT_WHILE_STATMENT__BODY:
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
			case XbasePackage.XABSTRACT_WHILE_STATMENT__PREDICATE:
				setPredicate((XExpression)newValue);
				return;
			case XbasePackage.XABSTRACT_WHILE_STATMENT__BODY:
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
			case XbasePackage.XABSTRACT_WHILE_STATMENT__PREDICATE:
				setPredicate((XExpression)null);
				return;
			case XbasePackage.XABSTRACT_WHILE_STATMENT__BODY:
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
			case XbasePackage.XABSTRACT_WHILE_STATMENT__PREDICATE:
				return predicate != null;
			case XbasePackage.XABSTRACT_WHILE_STATMENT__BODY:
				return body != null;
		}
		return super.eIsSet(featureID);
	}

} //XAbstractWhileExpressionImpl
