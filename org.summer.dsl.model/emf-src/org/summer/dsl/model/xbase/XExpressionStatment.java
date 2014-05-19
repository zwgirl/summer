/**
 */
package org.summer.dsl.model.xbase;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>XExpression Statment</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.summer.dsl.model.xbase.XExpressionStatment#getExpression <em>Expression</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.summer.dsl.model.xbase.XbasePackage#getXExpressionStatment()
 * @model
 * @generated
 */
public interface XExpressionStatment extends XStatment {
	/**
	 * Returns the value of the '<em><b>Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Expression</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Expression</em>' containment reference.
	 * @see #setExpression(XExpression)
	 * @see org.summer.dsl.model.xbase.XbasePackage#getXExpressionStatment_Expression()
	 * @model containment="true"
	 * @generated
	 */
	XExpression getExpression();

	/**
	 * Sets the value of the '{@link org.summer.dsl.model.xbase.XExpressionStatment#getExpression <em>Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Expression</em>' containment reference.
	 * @see #getExpression()
	 * @generated
	 */
	void setExpression(XExpression value);

} // XExpressionStatment
