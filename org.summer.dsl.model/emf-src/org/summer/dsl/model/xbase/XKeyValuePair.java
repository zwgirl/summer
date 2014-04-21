/**
 */
package org.summer.dsl.model.xbase;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>XKey Value Pair</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.summer.dsl.model.xbase.XKeyValuePair#getKey1 <em>Key1</em>}</li>
 *   <li>{@link org.summer.dsl.model.xbase.XKeyValuePair#getValue <em>Value</em>}</li>
 *   <li>{@link org.summer.dsl.model.xbase.XKeyValuePair#getKey <em>Key</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.summer.dsl.model.xbase.XbasePackage#getXKeyValuePair()
 * @model
 * @generated
 */
public interface XKeyValuePair extends XExpression {
	/**
	 * Returns the value of the '<em><b>Key</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Key</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Key</em>' containment reference.
	 * @see #setKey(XExpression)
	 * @see org.summer.dsl.model.xbase.XbasePackage#getXKeyValuePair_Key()
	 * @model containment="true"
	 * @generated
	 */
	XExpression getKey();

	/**
	 * Sets the value of the '{@link org.summer.dsl.model.xbase.XKeyValuePair#getKey <em>Key</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Key</em>' containment reference.
	 * @see #getKey()
	 * @generated
	 */
	void setKey(XExpression value);

	/**
	 * Returns the value of the '<em><b>Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Value</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Value</em>' containment reference.
	 * @see #setValue(XExpression)
	 * @see org.summer.dsl.model.xbase.XbasePackage#getXKeyValuePair_Value()
	 * @model containment="true"
	 * @generated
	 */
	XExpression getValue();

	/**
	 * Sets the value of the '{@link org.summer.dsl.model.xbase.XKeyValuePair#getValue <em>Value</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value</em>' containment reference.
	 * @see #getValue()
	 * @generated
	 */
	void setValue(XExpression value);

	/**
	 * Returns the value of the '<em><b>Key1</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Key1</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Key1</em>' attribute.
	 * @see #setKey1(String)
	 * @see org.summer.dsl.model.xbase.XbasePackage#getXKeyValuePair_Key1()
	 * @model
	 * @generated
	 */
	String getKey1();

	/**
	 * Sets the value of the '{@link org.summer.dsl.model.xbase.XKeyValuePair#getKey1 <em>Key1</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Key1</em>' attribute.
	 * @see #getKey1()
	 * @generated
	 */
	void setKey1(String value);

} // XKeyValuePair
