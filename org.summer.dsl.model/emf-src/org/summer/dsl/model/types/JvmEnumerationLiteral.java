/**
 */
package org.summer.dsl.model.types;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Jvm Enumeration Literal</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.summer.dsl.model.types.JvmEnumerationLiteral#getOrdinal <em>Ordinal</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.summer.dsl.model.types.TypesPackage#getJvmEnumerationLiteral()
 * @model
 * @generated
 */
public interface JvmEnumerationLiteral extends JvmField {
	/**
	 * Returns the value of the '<em><b>Ordinal</b></em>' attribute.
	 * The default value is <code>"-1"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Ordinal</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Ordinal</em>' attribute.
	 * @see #setOrdinal(int)
	 * @see org.summer.dsl.model.types.TypesPackage#getJvmEnumerationLiteral_Ordinal()
	 * @model default="-1"
	 * @generated
	 */
	int getOrdinal();

	/**
	 * Sets the value of the '{@link org.summer.dsl.model.types.JvmEnumerationLiteral#getOrdinal <em>Ordinal</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Ordinal</em>' attribute.
	 * @see #getOrdinal()
	 * @generated
	 */
	void setOrdinal(int value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	JvmEnumerationType getEnumType();

} // JvmEnumerationLiteral
