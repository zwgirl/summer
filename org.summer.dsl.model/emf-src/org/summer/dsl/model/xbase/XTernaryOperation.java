/**
 */
package org.summer.dsl.model.xbase;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>XTernary Operation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.summer.dsl.model.xbase.XTernaryOperation#getTrueOperand <em>True Operand</em>}</li>
 *   <li>{@link org.summer.dsl.model.xbase.XTernaryOperation#getFalseOperand <em>False Operand</em>}</li>
 *   <li>{@link org.summer.dsl.model.xbase.XTernaryOperation#getCondition <em>Condition</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.summer.dsl.model.xbase.XbasePackage#getXTernaryOperation()
 * @model
 * @generated
 */
public interface XTernaryOperation extends XExpression {
	/**
	 * Returns the value of the '<em><b>True Operand</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>True Operand</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>True Operand</em>' containment reference.
	 * @see #setTrueOperand(XExpression)
	 * @see org.summer.dsl.model.xbase.XbasePackage#getXTernaryOperation_TrueOperand()
	 * @model containment="true"
	 * @generated
	 */
	XExpression getTrueOperand();

	/**
	 * Sets the value of the '{@link org.summer.dsl.model.xbase.XTernaryOperation#getTrueOperand <em>True Operand</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>True Operand</em>' containment reference.
	 * @see #getTrueOperand()
	 * @generated
	 */
	void setTrueOperand(XExpression value);

	/**
	 * Returns the value of the '<em><b>False Operand</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>False Operand</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>False Operand</em>' containment reference.
	 * @see #setFalseOperand(XExpression)
	 * @see org.summer.dsl.model.xbase.XbasePackage#getXTernaryOperation_FalseOperand()
	 * @model containment="true"
	 * @generated
	 */
	XExpression getFalseOperand();

	/**
	 * Sets the value of the '{@link org.summer.dsl.model.xbase.XTernaryOperation#getFalseOperand <em>False Operand</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>False Operand</em>' containment reference.
	 * @see #getFalseOperand()
	 * @generated
	 */
	void setFalseOperand(XExpression value);

	/**
	 * Returns the value of the '<em><b>Condition</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Condition</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Condition</em>' containment reference.
	 * @see #setCondition(XExpression)
	 * @see org.summer.dsl.model.xbase.XbasePackage#getXTernaryOperation_Condition()
	 * @model containment="true"
	 * @generated
	 */
	XExpression getCondition();

	/**
	 * Sets the value of the '{@link org.summer.dsl.model.xbase.XTernaryOperation#getCondition <em>Condition</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Condition</em>' containment reference.
	 * @see #getCondition()
	 * @generated
	 */
	void setCondition(XExpression value);

} // XTernaryOperation
