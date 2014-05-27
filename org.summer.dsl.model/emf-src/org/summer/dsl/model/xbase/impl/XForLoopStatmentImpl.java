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
import org.summer.dsl.model.xbase.XExpression;
import org.summer.dsl.model.xbase.XForLoopStatment;
import org.summer.dsl.model.xbase.XStatment;
import org.summer.dsl.model.xbase.XbasePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>XFor Loop Expression</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.summer.dsl.model.xbase.impl.XForLoopStatmentImpl#getInitial <em>Initial</em>}</li>
 *   <li>{@link org.summer.dsl.model.xbase.impl.XForLoopStatmentImpl#getVariableDeclarations <em>Variable Declarations</em>}</li>
 *   <li>{@link org.summer.dsl.model.xbase.impl.XForLoopStatmentImpl#getCondition <em>Condition</em>}</li>
 *   <li>{@link org.summer.dsl.model.xbase.impl.XForLoopStatmentImpl#getIncrement <em>Increment</em>}</li>
 *   <li>{@link org.summer.dsl.model.xbase.impl.XForLoopStatmentImpl#getStatment <em>Statment</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class XForLoopStatmentImpl extends XStatmentImpl implements XForLoopStatment {
	/**
	 * The cached value of the '{@link #getInitial() <em>Initial</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInitial()
	 * @generated
	 * @ordered
	 */
	protected XExpression initial;

	/**
	 * The cached value of the '{@link #getVariableDeclarations() <em>Variable Declarations</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVariableDeclarations()
	 * @generated
	 * @ordered
	 */
	protected EList<XExpression> variableDeclarations;

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
	 * The cached value of the '{@link #getIncrement() <em>Increment</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIncrement()
	 * @generated
	 * @ordered
	 */
	protected XExpression increment;

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
	protected XForLoopStatmentImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return XbasePackage.Literals.XFOR_LOOP_STATMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public XExpression getInitial() {
		return initial;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetInitial(XExpression newInitial, NotificationChain msgs) {
		XExpression oldInitial = initial;
		initial = newInitial;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, XbasePackage.XFOR_LOOP_STATMENT__INITIAL, oldInitial, newInitial);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInitial(XExpression newInitial) {
		if (newInitial != initial) {
			NotificationChain msgs = null;
			if (initial != null)
				msgs = ((InternalEObject)initial).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - XbasePackage.XFOR_LOOP_STATMENT__INITIAL, null, msgs);
			if (newInitial != null)
				msgs = ((InternalEObject)newInitial).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - XbasePackage.XFOR_LOOP_STATMENT__INITIAL, null, msgs);
			msgs = basicSetInitial(newInitial, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, XbasePackage.XFOR_LOOP_STATMENT__INITIAL, newInitial, newInitial));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<XExpression> getVariableDeclarations() {
		if (variableDeclarations == null) {
			variableDeclarations = new EObjectContainmentEList<XExpression>(XExpression.class, this, XbasePackage.XFOR_LOOP_STATMENT__VARIABLE_DECLARATIONS);
		}
		return variableDeclarations;
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, XbasePackage.XFOR_LOOP_STATMENT__CONDITION, oldCondition, newCondition);
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
				msgs = ((InternalEObject)condition).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - XbasePackage.XFOR_LOOP_STATMENT__CONDITION, null, msgs);
			if (newCondition != null)
				msgs = ((InternalEObject)newCondition).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - XbasePackage.XFOR_LOOP_STATMENT__CONDITION, null, msgs);
			msgs = basicSetCondition(newCondition, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, XbasePackage.XFOR_LOOP_STATMENT__CONDITION, newCondition, newCondition));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public XExpression getIncrement() {
		return increment;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetIncrement(XExpression newIncrement, NotificationChain msgs) {
		XExpression oldIncrement = increment;
		increment = newIncrement;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, XbasePackage.XFOR_LOOP_STATMENT__INCREMENT, oldIncrement, newIncrement);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIncrement(XExpression newIncrement) {
		if (newIncrement != increment) {
			NotificationChain msgs = null;
			if (increment != null)
				msgs = ((InternalEObject)increment).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - XbasePackage.XFOR_LOOP_STATMENT__INCREMENT, null, msgs);
			if (newIncrement != null)
				msgs = ((InternalEObject)newIncrement).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - XbasePackage.XFOR_LOOP_STATMENT__INCREMENT, null, msgs);
			msgs = basicSetIncrement(newIncrement, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, XbasePackage.XFOR_LOOP_STATMENT__INCREMENT, newIncrement, newIncrement));
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, XbasePackage.XFOR_LOOP_STATMENT__STATMENT, oldStatment, newStatment);
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
				msgs = ((InternalEObject)statment).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - XbasePackage.XFOR_LOOP_STATMENT__STATMENT, null, msgs);
			if (newStatment != null)
				msgs = ((InternalEObject)newStatment).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - XbasePackage.XFOR_LOOP_STATMENT__STATMENT, null, msgs);
			msgs = basicSetStatment(newStatment, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, XbasePackage.XFOR_LOOP_STATMENT__STATMENT, newStatment, newStatment));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case XbasePackage.XFOR_LOOP_STATMENT__INITIAL:
				return basicSetInitial(null, msgs);
			case XbasePackage.XFOR_LOOP_STATMENT__VARIABLE_DECLARATIONS:
				return ((InternalEList<?>)getVariableDeclarations()).basicRemove(otherEnd, msgs);
			case XbasePackage.XFOR_LOOP_STATMENT__CONDITION:
				return basicSetCondition(null, msgs);
			case XbasePackage.XFOR_LOOP_STATMENT__INCREMENT:
				return basicSetIncrement(null, msgs);
			case XbasePackage.XFOR_LOOP_STATMENT__STATMENT:
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
			case XbasePackage.XFOR_LOOP_STATMENT__INITIAL:
				return getInitial();
			case XbasePackage.XFOR_LOOP_STATMENT__VARIABLE_DECLARATIONS:
				return getVariableDeclarations();
			case XbasePackage.XFOR_LOOP_STATMENT__CONDITION:
				return getCondition();
			case XbasePackage.XFOR_LOOP_STATMENT__INCREMENT:
				return getIncrement();
			case XbasePackage.XFOR_LOOP_STATMENT__STATMENT:
				return getStatment();
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
			case XbasePackage.XFOR_LOOP_STATMENT__INITIAL:
				setInitial((XExpression)newValue);
				return;
			case XbasePackage.XFOR_LOOP_STATMENT__VARIABLE_DECLARATIONS:
				getVariableDeclarations().clear();
				getVariableDeclarations().addAll((Collection<? extends XExpression>)newValue);
				return;
			case XbasePackage.XFOR_LOOP_STATMENT__CONDITION:
				setCondition((XExpression)newValue);
				return;
			case XbasePackage.XFOR_LOOP_STATMENT__INCREMENT:
				setIncrement((XExpression)newValue);
				return;
			case XbasePackage.XFOR_LOOP_STATMENT__STATMENT:
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
			case XbasePackage.XFOR_LOOP_STATMENT__INITIAL:
				setInitial((XExpression)null);
				return;
			case XbasePackage.XFOR_LOOP_STATMENT__VARIABLE_DECLARATIONS:
				getVariableDeclarations().clear();
				return;
			case XbasePackage.XFOR_LOOP_STATMENT__CONDITION:
				setCondition((XExpression)null);
				return;
			case XbasePackage.XFOR_LOOP_STATMENT__INCREMENT:
				setIncrement((XExpression)null);
				return;
			case XbasePackage.XFOR_LOOP_STATMENT__STATMENT:
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
			case XbasePackage.XFOR_LOOP_STATMENT__INITIAL:
				return initial != null;
			case XbasePackage.XFOR_LOOP_STATMENT__VARIABLE_DECLARATIONS:
				return variableDeclarations != null && !variableDeclarations.isEmpty();
			case XbasePackage.XFOR_LOOP_STATMENT__CONDITION:
				return condition != null;
			case XbasePackage.XFOR_LOOP_STATMENT__INCREMENT:
				return increment != null;
			case XbasePackage.XFOR_LOOP_STATMENT__STATMENT:
				return statment != null;
		}
		return super.eIsSet(featureID);
	}

} //XForLoopExpressionImpl
