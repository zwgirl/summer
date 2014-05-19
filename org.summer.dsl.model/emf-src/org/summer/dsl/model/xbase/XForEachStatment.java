/**
 */
package org.summer.dsl.model.xbase;

import org.summer.dsl.model.types.JvmFormalParameter;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>XFor Each Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.summer.dsl.model.xbase.XForEachStatment#getDeclaredParam <em>Declared Param</em>}</li>
 *   <li>{@link org.summer.dsl.model.xbase.XForEachStatment#getExpression <em>Expression</em>}</li>
 *   <li>{@link org.summer.dsl.model.xbase.XForEachStatment#getStatment <em>Statment</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.summer.dsl.model.xbase.XbasePackage#getXForEachStatment()
 * @model
 * @generated
 */
public interface XForEachStatment extends XStatment {
	/**
	 * Returns the value of the '<em><b>Declared Param</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Declared Param</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Declared Param</em>' containment reference.
	 * @see #setDeclaredParam(JvmFormalParameter)
	 * @see org.summer.dsl.model.xbase.XbasePackage#getXForEachStatment_DeclaredParam()
	 * @model containment="true"
	 * @generated
	 */
	JvmFormalParameter getDeclaredParam();

	/**
	 * Sets the value of the '{@link org.summer.dsl.model.xbase.XForEachStatment#getDeclaredParam <em>Declared Param</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Declared Param</em>' containment reference.
	 * @see #getDeclaredParam()
	 * @generated
	 */
	void setDeclaredParam(JvmFormalParameter value);

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
	 * @see org.summer.dsl.model.xbase.XbasePackage#getXForEachStatment_Expression()
	 * @model containment="true"
	 * @generated
	 */
	XExpression getExpression();

	/**
	 * Sets the value of the '{@link org.summer.dsl.model.xbase.XForEachStatment#getExpression <em>Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Expression</em>' containment reference.
	 * @see #getExpression()
	 * @generated
	 */
	void setExpression(XExpression value);

	/**
	 * Returns the value of the '<em><b>Statment</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Statment</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Statment</em>' containment reference.
	 * @see #setStatment(XStatment)
	 * @see org.summer.dsl.model.xbase.XbasePackage#getXForEachStatment_Statment()
	 * @model containment="true"
	 * @generated
	 */
	XStatment getStatment();

	/**
	 * Sets the value of the '{@link org.summer.dsl.model.xbase.XForEachStatment#getStatment <em>Statment</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Statment</em>' containment reference.
	 * @see #getStatment()
	 * @generated
	 */
	void setStatment(XStatment value);

} // XForEachExpression
