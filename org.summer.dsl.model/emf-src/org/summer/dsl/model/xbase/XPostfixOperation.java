/**
 */
package org.summer.dsl.model.xbase;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>XPostfix Operation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.summer.dsl.model.xbase.XPostfixOperation#getOperand <em>Operand</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.summer.dsl.model.xbase.XbasePackage#getXPostfixOperation()
 * @model
 * @generated
 */
public interface XPostfixOperation extends XAbstractFeatureCall {
	/**
	 * Returns the value of the '<em><b>Operand</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Operand</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Operand</em>' containment reference.
	 * @see #setOperand(XExpression)
	 * @see org.summer.dsl.model.xbase.XbasePackage#getXPostfixOperation_Operand()
	 * @model containment="true"
	 * @generated
	 */
	XExpression getOperand();

	/**
	 * Sets the value of the '{@link org.summer.dsl.model.xbase.XPostfixOperation#getOperand <em>Operand</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Operand</em>' containment reference.
	 * @see #getOperand()
	 * @generated
	 */
	void setOperand(XExpression value);

} // XPostfixOperation
