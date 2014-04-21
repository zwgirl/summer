/**
 */
package org.summer.dsl.model.xbase;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>XPrefix Operation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.summer.dsl.model.xbase.XPrefixOperation#getOperand <em>Operand</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.summer.dsl.model.xbase.XbasePackage#getXPrefixOperation()
 * @model
 * @generated
 */
public interface XPrefixOperation extends XAbstractFeatureCall {
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
	 * @see org.summer.dsl.model.xbase.XbasePackage#getXPrefixOperation_Operand()
	 * @model containment="true"
	 * @generated
	 */
	XExpression getOperand();

	/**
	 * Sets the value of the '{@link org.summer.dsl.model.xbase.XPrefixOperation#getOperand <em>Operand</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Operand</em>' containment reference.
	 * @see #getOperand()
	 * @generated
	 */
	void setOperand(XExpression value);

} // XPrefixOperation
