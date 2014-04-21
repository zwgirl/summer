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
 *   <li>{@link org.summer.dsl.model.xbase.XForEachExpression#getForExpression <em>For Expression</em>}</li>
 *   <li>{@link org.summer.dsl.model.xbase.XForEachExpression#getEachExpression <em>Each Expression</em>}</li>
 *   <li>{@link org.summer.dsl.model.xbase.XForEachExpression#getDeclaredParam <em>Declared Param</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.summer.dsl.model.xbase.XbasePackage#getXForEachExpression()
 * @model
 * @generated
 */
public interface XForEachExpression extends XExpression {
	/**
	 * Returns the value of the '<em><b>For Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>For Expression</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>For Expression</em>' containment reference.
	 * @see #setForExpression(XExpression)
	 * @see org.summer.dsl.model.xbase.XbasePackage#getXForEachExpression_ForExpression()
	 * @model containment="true"
	 * @generated
	 */
	XExpression getForExpression();

	/**
	 * Sets the value of the '{@link org.summer.dsl.model.xbase.XForEachExpression#getForExpression <em>For Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>For Expression</em>' containment reference.
	 * @see #getForExpression()
	 * @generated
	 */
	void setForExpression(XExpression value);

	/**
	 * Returns the value of the '<em><b>Each Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Each Expression</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Each Expression</em>' containment reference.
	 * @see #setEachExpression(XExpression)
	 * @see org.summer.dsl.model.xbase.XbasePackage#getXForEachExpression_EachExpression()
	 * @model containment="true"
	 * @generated
	 */
	XExpression getEachExpression();

	/**
	 * Sets the value of the '{@link org.summer.dsl.model.xbase.XForEachExpression#getEachExpression <em>Each Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Each Expression</em>' containment reference.
	 * @see #getEachExpression()
	 * @generated
	 */
	void setEachExpression(XExpression value);

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
	 * @see org.summer.dsl.model.xbase.XbasePackage#getXForEachExpression_DeclaredParam()
	 * @model containment="true"
	 * @generated
	 */
	JvmFormalParameter getDeclaredParam();

	/**
	 * Sets the value of the '{@link org.summer.dsl.model.xbase.XForEachExpression#getDeclaredParam <em>Declared Param</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Declared Param</em>' containment reference.
	 * @see #getDeclaredParam()
	 * @generated
	 */
	void setDeclaredParam(JvmFormalParameter value);

} // XForEachExpression
