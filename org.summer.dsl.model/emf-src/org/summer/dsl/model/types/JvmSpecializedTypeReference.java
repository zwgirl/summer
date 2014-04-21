/**
 */
package org.summer.dsl.model.types;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Jvm Specialized Type Reference</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.summer.dsl.model.types.JvmSpecializedTypeReference#getEquivalent <em>Equivalent</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.summer.dsl.model.types.TypesPackage#getJvmSpecializedTypeReference()
 * @model abstract="true"
 * @generated
 */
public interface JvmSpecializedTypeReference extends JvmTypeReference {
	/**
	 * Returns the value of the '<em><b>Equivalent</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Equivalent</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Equivalent</em>' containment reference.
	 * @see #setEquivalent(JvmTypeReference)
	 * @see org.summer.dsl.model.types.TypesPackage#getJvmSpecializedTypeReference_Equivalent()
	 * @model containment="true" transient="true"
	 * @generated
	 */
	JvmTypeReference getEquivalent();

	/**
	 * Sets the value of the '{@link org.summer.dsl.model.types.JvmSpecializedTypeReference#getEquivalent <em>Equivalent</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Equivalent</em>' containment reference.
	 * @see #getEquivalent()
	 * @generated
	 */
	void setEquivalent(JvmTypeReference value);

} // JvmSpecializedTypeReference
