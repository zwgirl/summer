/**
 */
package org.summer.dsl.model.xbase.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.summer.dsl.model.xbase.XExpression;
import org.summer.dsl.model.xbase.XForLoopExpression;
import org.summer.dsl.model.xbase.XbasePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>XFor Loop Expression</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.summer.dsl.model.xbase.impl.XForLoopExpressionImpl#getCondition <em>Condition</em>}</li>
 *   <li>{@link org.summer.dsl.model.xbase.impl.XForLoopExpressionImpl#getLoop <em>Loop</em>}</li>
 *   <li>{@link org.summer.dsl.model.xbase.impl.XForLoopExpressionImpl#getInit <em>Init</em>}</li>
 *   <li>{@link org.summer.dsl.model.xbase.impl.XForLoopExpressionImpl#getEachExpression <em>Each Expression</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class XForLoopExpressionImpl extends XExpressionImpl implements XForLoopExpression {
	/**
	 * The cached value of the '{@link #getCondition() <em>Condition</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCondition()
	 * @generated
	 * @ordered
	 */
	protected XExpression condition;

	/**
	 * The cached value of the '{@link #getLoop() <em>Loop</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLoop()
	 * @generated
	 * @ordered
	 */
	protected XExpression loop;

	/**
	 * The cached value of the '{@link #getInit() <em>Init</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInit()
	 * @generated
	 * @ordered
	 */
	protected XExpression init;

	/**
	 * The cached value of the '{@link #getEachExpression() <em>Each Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEachExpression()
	 * @generated
	 * @ordered
	 */
	protected XExpression eachExpression;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected XForLoopExpressionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return XbasePackage.Literals.XFOR_LOOP_EXPRESSION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public XExpression getEachExpression() {
		return eachExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetEachExpression(XExpression newEachExpression, NotificationChain msgs) {
		XExpression oldEachExpression = eachExpression;
		eachExpression = newEachExpression;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, XbasePackage.XFOR_LOOP_EXPRESSION__EACH_EXPRESSION, oldEachExpression, newEachExpression);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEachExpression(XExpression newEachExpression) {
		if (newEachExpression != eachExpression) {
			NotificationChain msgs = null;
			if (eachExpression != null)
				msgs = ((InternalEObject)eachExpression).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - XbasePackage.XFOR_LOOP_EXPRESSION__EACH_EXPRESSION, null, msgs);
			if (newEachExpression != null)
				msgs = ((InternalEObject)newEachExpression).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - XbasePackage.XFOR_LOOP_EXPRESSION__EACH_EXPRESSION, null, msgs);
			msgs = basicSetEachExpression(newEachExpression, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, XbasePackage.XFOR_LOOP_EXPRESSION__EACH_EXPRESSION, newEachExpression, newEachExpression));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public XExpression getCondition() {
		return condition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCondition(XExpression newCondition, NotificationChain msgs) {
		XExpression oldCondition = condition;
		condition = newCondition;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, XbasePackage.XFOR_LOOP_EXPRESSION__CONDITION, oldCondition, newCondition);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCondition(XExpression newCondition) {
		if (newCondition != condition) {
			NotificationChain msgs = null;
			if (condition != null)
				msgs = ((InternalEObject)condition).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - XbasePackage.XFOR_LOOP_EXPRESSION__CONDITION, null, msgs);
			if (newCondition != null)
				msgs = ((InternalEObject)newCondition).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - XbasePackage.XFOR_LOOP_EXPRESSION__CONDITION, null, msgs);
			msgs = basicSetCondition(newCondition, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, XbasePackage.XFOR_LOOP_EXPRESSION__CONDITION, newCondition, newCondition));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public XExpression getLoop() {
		return loop;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetLoop(XExpression newLoop, NotificationChain msgs) {
		XExpression oldLoop = loop;
		loop = newLoop;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, XbasePackage.XFOR_LOOP_EXPRESSION__LOOP, oldLoop, newLoop);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLoop(XExpression newLoop) {
		if (newLoop != loop) {
			NotificationChain msgs = null;
			if (loop != null)
				msgs = ((InternalEObject)loop).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - XbasePackage.XFOR_LOOP_EXPRESSION__LOOP, null, msgs);
			if (newLoop != null)
				msgs = ((InternalEObject)newLoop).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - XbasePackage.XFOR_LOOP_EXPRESSION__LOOP, null, msgs);
			msgs = basicSetLoop(newLoop, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, XbasePackage.XFOR_LOOP_EXPRESSION__LOOP, newLoop, newLoop));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public XExpression getInit() {
		return init;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetInit(XExpression newInit, NotificationChain msgs) {
		XExpression oldInit = init;
		init = newInit;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, XbasePackage.XFOR_LOOP_EXPRESSION__INIT, oldInit, newInit);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInit(XExpression newInit) {
		if (newInit != init) {
			NotificationChain msgs = null;
			if (init != null)
				msgs = ((InternalEObject)init).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - XbasePackage.XFOR_LOOP_EXPRESSION__INIT, null, msgs);
			if (newInit != null)
				msgs = ((InternalEObject)newInit).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - XbasePackage.XFOR_LOOP_EXPRESSION__INIT, null, msgs);
			msgs = basicSetInit(newInit, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, XbasePackage.XFOR_LOOP_EXPRESSION__INIT, newInit, newInit));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case XbasePackage.XFOR_LOOP_EXPRESSION__CONDITION:
				return basicSetCondition(null, msgs);
			case XbasePackage.XFOR_LOOP_EXPRESSION__LOOP:
				return basicSetLoop(null, msgs);
			case XbasePackage.XFOR_LOOP_EXPRESSION__INIT:
				return basicSetInit(null, msgs);
			case XbasePackage.XFOR_LOOP_EXPRESSION__EACH_EXPRESSION:
				return basicSetEachExpression(null, msgs);
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
			case XbasePackage.XFOR_LOOP_EXPRESSION__CONDITION:
				return getCondition();
			case XbasePackage.XFOR_LOOP_EXPRESSION__LOOP:
				return getLoop();
			case XbasePackage.XFOR_LOOP_EXPRESSION__INIT:
				return getInit();
			case XbasePackage.XFOR_LOOP_EXPRESSION__EACH_EXPRESSION:
				return getEachExpression();
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
			case XbasePackage.XFOR_LOOP_EXPRESSION__CONDITION:
				setCondition((XExpression)newValue);
				return;
			case XbasePackage.XFOR_LOOP_EXPRESSION__LOOP:
				setLoop((XExpression)newValue);
				return;
			case XbasePackage.XFOR_LOOP_EXPRESSION__INIT:
				setInit((XExpression)newValue);
				return;
			case XbasePackage.XFOR_LOOP_EXPRESSION__EACH_EXPRESSION:
				setEachExpression((XExpression)newValue);
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
			case XbasePackage.XFOR_LOOP_EXPRESSION__CONDITION:
				setCondition((XExpression)null);
				return;
			case XbasePackage.XFOR_LOOP_EXPRESSION__LOOP:
				setLoop((XExpression)null);
				return;
			case XbasePackage.XFOR_LOOP_EXPRESSION__INIT:
				setInit((XExpression)null);
				return;
			case XbasePackage.XFOR_LOOP_EXPRESSION__EACH_EXPRESSION:
				setEachExpression((XExpression)null);
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
			case XbasePackage.XFOR_LOOP_EXPRESSION__CONDITION:
				return condition != null;
			case XbasePackage.XFOR_LOOP_EXPRESSION__LOOP:
				return loop != null;
			case XbasePackage.XFOR_LOOP_EXPRESSION__INIT:
				return init != null;
			case XbasePackage.XFOR_LOOP_EXPRESSION__EACH_EXPRESSION:
				return eachExpression != null;
		}
		return super.eIsSet(featureID);
	}

} //XForLoopExpressionImpl
