/**
 */
package org.summer.dsl.model.xbase;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>XBinary Operation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.summer.dsl.model.xbase.XBinaryOperation#getLeftOperand <em>Left Operand</em>}</li>
 *   <li>{@link org.summer.dsl.model.xbase.XBinaryOperation#getRightOperand <em>Right Operand</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.summer.dsl.model.xbase.XbasePackage#getXBinaryOperation()
 * @model
 * @generated
 */
public interface XBinaryOperation extends XAbstractFeatureCall {
	/**
	 * Returns the value of the '<em><b>Left Operand</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Left Operand</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Left Operand</em>' containment reference.
	 * @see #setLeftOperand(XExpression)
	 * @see org.summer.dsl.model.xbase.XbasePackage#getXBinaryOperation_LeftOperand()
	 * @model containment="true"
	 * @generated
	 */
	XExpression getLeftOperand();

	/**
	 * Sets the value of the '{@link org.summer.dsl.model.xbase.XBinaryOperation#getLeftOperand <em>Left Operand</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Left Operand</em>' containment reference.
	 * @see #getLeftOperand()
	 * @generated
	 */
	void setLeftOperand(XExpression value);

	/**
	 * Returns the value of the '<em><b>Right Operand</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Right Operand</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Right Operand</em>' containment reference.
	 * @see #setRightOperand(XExpression)
	 * @see org.summer.dsl.model.xbase.XbasePackage#getXBinaryOperation_RightOperand()
	 * @model containment="true"
	 * @generated
	 */
	XExpression getRightOperand();

	/**
	 * Sets the value of the '{@link org.summer.dsl.model.xbase.XBinaryOperation#getRightOperand <em>Right Operand</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Right Operand</em>' containment reference.
	 * @see #getRightOperand()
	 * @generated
	 */
	void setRightOperand(XExpression value);

} // XBinaryOperation
