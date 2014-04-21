/**
 */
package org.summer.dsl.model.xbase.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.summer.dsl.model.xbase.XExpression;
import org.summer.dsl.model.xbase.XTernaryOperation;
import org.summer.dsl.model.xbase.XbasePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>XTernary Operation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.summer.dsl.model.xbase.impl.XTernaryOperationImpl#getTrueOperand <em>True Operand</em>}</li>
 *   <li>{@link org.summer.dsl.model.xbase.impl.XTernaryOperationImpl#getFalseOperand <em>False Operand</em>}</li>
 *   <li>{@link org.summer.dsl.model.xbase.impl.XTernaryOperationImpl#getCondition <em>Condition</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class XTernaryOperationImpl extends XExpressionImpl implements XTernaryOperation {
	/**
	 * The cached value of the '{@link #getTrueOperand() <em>True Operand</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTrueOperand()
	 * @generated
	 * @ordered
	 */
	protected XExpression trueOperand;

	/**
	 * The cached value of the '{@link #getFalseOperand() <em>False Operand</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFalseOperand()
	 * @generated
	 * @ordered
	 */
	protected XExpression falseOperand;

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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected XTernaryOperationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return XbasePackage.Literals.XTERNARY_OPERATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public XExpression getTrueOperand() {
		return trueOperand;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetTrueOperand(XExpression newTrueOperand, NotificationChain msgs) {
		XExpression oldTrueOperand = trueOperand;
		trueOperand = newTrueOperand;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, XbasePackage.XTERNARY_OPERATION__TRUE_OPERAND, oldTrueOperand, newTrueOperand);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTrueOperand(XExpression newTrueOperand) {
		if (newTrueOperand != trueOperand) {
			NotificationChain msgs = null;
			if (trueOperand != null)
				msgs = ((InternalEObject)trueOperand).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - XbasePackage.XTERNARY_OPERATION__TRUE_OPERAND, null, msgs);
			if (newTrueOperand != null)
				msgs = ((InternalEObject)newTrueOperand).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - XbasePackage.XTERNARY_OPERATION__TRUE_OPERAND, null, msgs);
			msgs = basicSetTrueOperand(newTrueOperand, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, XbasePackage.XTERNARY_OPERATION__TRUE_OPERAND, newTrueOperand, newTrueOperand));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public XExpression getFalseOperand() {
		return falseOperand;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetFalseOperand(XExpression newFalseOperand, NotificationChain msgs) {
		XExpression oldFalseOperand = falseOperand;
		falseOperand = newFalseOperand;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, XbasePackage.XTERNARY_OPERATION__FALSE_OPERAND, oldFalseOperand, newFalseOperand);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFalseOperand(XExpression newFalseOperand) {
		if (newFalseOperand != falseOperand) {
			NotificationChain msgs = null;
			if (falseOperand != null)
				msgs = ((InternalEObject)falseOperand).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - XbasePackage.XTERNARY_OPERATION__FALSE_OPERAND, null, msgs);
			if (newFalseOperand != null)
				msgs = ((InternalEObject)newFalseOperand).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - XbasePackage.XTERNARY_OPERATION__FALSE_OPERAND, null, msgs);
			msgs = basicSetFalseOperand(newFalseOperand, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, XbasePackage.XTERNARY_OPERATION__FALSE_OPERAND, newFalseOperand, newFalseOperand));
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, XbasePackage.XTERNARY_OPERATION__CONDITION, oldCondition, newCondition);
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
				msgs = ((InternalEObject)condition).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - XbasePackage.XTERNARY_OPERATION__CONDITION, null, msgs);
			if (newCondition != null)
				msgs = ((InternalEObject)newCondition).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - XbasePackage.XTERNARY_OPERATION__CONDITION, null, msgs);
			msgs = basicSetCondition(newCondition, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, XbasePackage.XTERNARY_OPERATION__CONDITION, newCondition, newCondition));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case XbasePackage.XTERNARY_OPERATION__TRUE_OPERAND:
				return basicSetTrueOperand(null, msgs);
			case XbasePackage.XTERNARY_OPERATION__FALSE_OPERAND:
				return basicSetFalseOperand(null, msgs);
			case XbasePackage.XTERNARY_OPERATION__CONDITION:
				return basicSetCondition(null, msgs);
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
			case XbasePackage.XTERNARY_OPERATION__TRUE_OPERAND:
				return getTrueOperand();
			case XbasePackage.XTERNARY_OPERATION__FALSE_OPERAND:
				return getFalseOperand();
			case XbasePackage.XTERNARY_OPERATION__CONDITION:
				return getCondition();
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
			case XbasePackage.XTERNARY_OPERATION__TRUE_OPERAND:
				setTrueOperand((XExpression)newValue);
				return;
			case XbasePackage.XTERNARY_OPERATION__FALSE_OPERAND:
				setFalseOperand((XExpression)newValue);
				return;
			case XbasePackage.XTERNARY_OPERATION__CONDITION:
				setCondition((XExpression)newValue);
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
			case XbasePackage.XTERNARY_OPERATION__TRUE_OPERAND:
				setTrueOperand((XExpression)null);
				return;
			case XbasePackage.XTERNARY_OPERATION__FALSE_OPERAND:
				setFalseOperand((XExpression)null);
				return;
			case XbasePackage.XTERNARY_OPERATION__CONDITION:
				setCondition((XExpression)null);
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
			case XbasePackage.XTERNARY_OPERATION__TRUE_OPERAND:
				return trueOperand != null;
			case XbasePackage.XTERNARY_OPERATION__FALSE_OPERAND:
				return falseOperand != null;
			case XbasePackage.XTERNARY_OPERATION__CONDITION:
				return condition != null;
		}
		return super.eIsSet(featureID);
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EList<XExpression> getExplicitArguments() {
		BasicEList<XExpression> result = new BasicEList<XExpression>();
		return result;
	}

} //XTernaryOperationImpl
