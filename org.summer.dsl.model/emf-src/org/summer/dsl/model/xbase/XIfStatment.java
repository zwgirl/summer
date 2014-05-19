/**
 */
package org.summer.dsl.model.xbase;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>XIf Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.summer.dsl.model.xbase.XIfStatment#getIf <em>If</em>}</li>
 *   <li>{@link org.summer.dsl.model.xbase.XIfStatment#getThen <em>Then</em>}</li>
 *   <li>{@link org.summer.dsl.model.xbase.XIfStatment#getElse <em>Else</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.summer.dsl.model.xbase.XbasePackage#getXIfStatment()
 * @model
 * @generated
 */
public interface XIfStatment extends XStatment {
	/**
	 * Returns the value of the '<em><b>If</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>If</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>If</em>' containment reference.
	 * @see #setIf(XExpression)
	 * @see org.summer.dsl.model.xbase.XbasePackage#getXIfStatment_If()
	 * @model containment="true"
	 * @generated
	 */
	XExpression getIf();

	/**
	 * Sets the value of the '{@link org.summer.dsl.model.xbase.XIfStatment#getIf <em>If</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>If</em>' containment reference.
	 * @see #getIf()
	 * @generated
	 */
	void setIf(XExpression value);

	/**
	 * Returns the value of the '<em><b>Then</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Then</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Then</em>' containment reference.
	 * @see #setThen(XStatment)
	 * @see org.summer.dsl.model.xbase.XbasePackage#getXIfStatment_Then()
	 * @model containment="true"
	 * @generated
	 */
	XStatment getThen();

	/**
	 * Sets the value of the '{@link org.summer.dsl.model.xbase.XIfStatment#getThen <em>Then</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Then</em>' containment reference.
	 * @see #getThen()
	 * @generated
	 */
	void setThen(XStatment value);

	/**
	 * Returns the value of the '<em><b>Else</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Else</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Else</em>' containment reference.
	 * @see #setElse(XStatment)
	 * @see org.summer.dsl.model.xbase.XbasePackage#getXIfStatment_Else()
	 * @model containment="true"
	 * @generated
	 */
	XStatment getElse();

	/**
	 * Sets the value of the '{@link org.summer.dsl.model.xbase.XIfStatment#getElse <em>Else</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Else</em>' containment reference.
	 * @see #getElse()
	 * @generated
	 */
	void setElse(XStatment value);

} // XIfExpression
