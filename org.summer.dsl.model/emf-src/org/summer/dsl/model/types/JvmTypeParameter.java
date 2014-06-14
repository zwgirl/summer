/**
 */
package org.summer.dsl.model.types;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Jvm Type Parameter</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.summer.dsl.model.types.JvmTypeParameter#getSimpleName <em>Simple Name</em>}</li>
 *   <li>{@link org.summer.dsl.model.types.JvmTypeParameter#getDeclarator <em>Declarator</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.summer.dsl.model.types.TypesPackage#getJvmTypeParameter()
 * @model
 * @generated
 */
public interface JvmTypeParameter extends JvmComponentType, JvmConstraintOwner {
	/**
	 * Returns the value of the '<em><b>Simple Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Simple Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Simple Name</em>' attribute.
	 * @see #setSimpleName(String)
	 * @see org.summer.dsl.model.types.TypesPackage#getJvmTypeParameter_SimpleName()
	 * @model
	 * @generated
	 */
	String getSimpleName();

	/**
	 * Sets the value of the '{@link org.summer.dsl.model.types.JvmTypeParameter#getSimpleName <em>Simple Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Simple Name</em>' attribute.
	 * @see #getSimpleName()
	 * @generated
	 */
	void setSimpleName(String value);

	/**
	 * Returns the value of the '<em><b>Declarator</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.summer.dsl.model.types.JvmTypeParameterDeclarator#getTypeParameters <em>Type Parameters</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Declarator</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Declarator</em>' container reference.
	 * @see #setDeclarator(JvmTypeParameterDeclarator)
	 * @see org.summer.dsl.model.types.TypesPackage#getJvmTypeParameter_Declarator()
	 * @see org.summer.dsl.model.types.JvmTypeParameterDeclarator#getTypeParameters
	 * @model opposite="typeParameters" transient="false"
	 * @generated
	 */
	JvmTypeParameterDeclarator getDeclarator();

	/**
	 * Sets the value of the '{@link org.summer.dsl.model.types.JvmTypeParameter#getDeclarator <em>Declarator</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Declarator</em>' container reference.
	 * @see #getDeclarator()
	 * @generated
	 */
	void setDeclarator(JvmTypeParameterDeclarator value);

} // JvmTypeParameter
