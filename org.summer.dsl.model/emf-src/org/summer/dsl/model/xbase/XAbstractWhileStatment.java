/**
 */
package org.summer.dsl.model.xbase;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>XAbstract While Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.summer.dsl.model.xbase.XAbstractWhileStatment#getPredicate <em>Predicate</em>}</li>
 *   <li>{@link org.summer.dsl.model.xbase.XAbstractWhileStatment#getBody <em>Body</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.summer.dsl.model.xbase.XbasePackage#getXAbstractWhileStatment()
 * @model abstract="true"
 * @generated
 */
public interface XAbstractWhileStatment extends XStatment {
	/**
	 * Returns the value of the '<em><b>Predicate</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Predicate</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Predicate</em>' containment reference.
	 * @see #setPredicate(XExpression)
	 * @see org.summer.dsl.model.xbase.XbasePackage#getXAbstractWhileStatment_Predicate()
	 * @model containment="true"
	 * @generated
	 */
	XExpression getPredicate();

	/**
	 * Sets the value of the '{@link org.summer.dsl.model.xbase.XAbstractWhileStatment#getPredicate <em>Predicate</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Predicate</em>' containment reference.
	 * @see #getPredicate()
	 * @generated
	 */
	void setPredicate(XExpression value);

	/**
	 * Returns the value of the '<em><b>Body</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Body</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Body</em>' containment reference.
	 * @see #setBody(XStatment)
	 * @see org.summer.dsl.model.xbase.XbasePackage#getXAbstractWhileStatment_Body()
	 * @model containment="true"
	 * @generated
	 */
	XStatment getBody();

	/**
	 * Sets the value of the '{@link org.summer.dsl.model.xbase.XAbstractWhileStatment#getBody <em>Body</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Body</em>' containment reference.
	 * @see #getBody()
	 * @generated
	 */
	void setBody(XStatment value);

} // XAbstractWhileExpression
