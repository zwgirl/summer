/**
 */
package org.summer.dsl.model.types;

import org.eclipse.emf.common.util.EList;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Jvm Member</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.summer.dsl.model.types.JvmMember#getDeclaringType <em>Declaring Type</em>}</li>
 *   <li>{@link org.summer.dsl.model.types.JvmMember#getVisibility <em>Visibility</em>}</li>
 *   <li>{@link org.summer.dsl.model.types.JvmMember#getSimpleName <em>Simple Name</em>}</li>
 *   <li>{@link org.summer.dsl.model.types.JvmMember#getIdentifier <em>Identifier</em>}</li>
 *   <li>{@link org.summer.dsl.model.types.JvmMember#getAnnotationInfo <em>Annotation Info</em>}</li>
 *   <li>{@link org.summer.dsl.model.types.JvmMember#getModifiers <em>Modifiers</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.summer.dsl.model.types.TypesPackage#getJvmMember()
 * @model
 * @generated
 */
public interface JvmMember extends JvmAnnotationTarget {
	/**
	 * Returns the value of the '<em><b>Declaring Type</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.summer.dsl.model.types.JvmDeclaredType#getMembers <em>Members</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Declaring Type</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Declaring Type</em>' container reference.
	 * @see #setDeclaringType(JvmDeclaredType)
	 * @see org.summer.dsl.model.types.TypesPackage#getJvmMember_DeclaringType()
	 * @see org.summer.dsl.model.types.JvmDeclaredType#getMembers
	 * @model opposite="members" transient="false"
	 * @generated
	 */
	JvmDeclaredType getDeclaringType();

	/**
	 * Sets the value of the '{@link org.summer.dsl.model.types.JvmMember#getDeclaringType <em>Declaring Type</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Declaring Type</em>' container reference.
	 * @see #getDeclaringType()
	 * @generated
	 */
	void setDeclaringType(JvmDeclaredType value);

	/**
	 * Returns the value of the '<em><b>Visibility</b></em>' attribute.
	 * The default value is <code>"PUBLIC"</code>.
	 * The literals are from the enumeration {@link org.summer.dsl.model.types.JvmVisibility}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Visibility</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Visibility</em>' attribute.
	 * @see org.summer.dsl.model.types.JvmVisibility
	 * @see #setVisibility(JvmVisibility)
	 * @see org.summer.dsl.model.types.TypesPackage#getJvmMember_Visibility()
	 * @model default="PUBLIC"
	 * @generated
	 */
	JvmVisibility getVisibility();

	/**
	 * Sets the value of the '{@link org.summer.dsl.model.types.JvmMember#getVisibility <em>Visibility</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Visibility</em>' attribute.
	 * @see org.summer.dsl.model.types.JvmVisibility
	 * @see #getVisibility()
	 * @generated
	 */
	void setVisibility(JvmVisibility value);

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
	 * @see org.summer.dsl.model.types.TypesPackage#getJvmMember_SimpleName()
	 * @model
	 * @generated
	 */
	String getSimpleName();

	/**
	 * Sets the value of the '{@link org.summer.dsl.model.types.JvmMember#getSimpleName <em>Simple Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Simple Name</em>' attribute.
	 * @see #getSimpleName()
	 * @generated
	 */
	void setSimpleName(String value);

	/**
	 * Returns the value of the '<em><b>Identifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Identifier</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Identifier</em>' attribute.
	 * @see org.summer.dsl.model.types.TypesPackage#getJvmMember_Identifier()
	 * @model transient="true" changeable="false" derived="true"
	 * @generated
	 */
	String getIdentifier();

	/**
	 * Returns the value of the '<em><b>Annotation Info</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Annotation Info</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Annotation Info</em>' containment reference.
	 * @see #setAnnotationInfo(JvmAnnotationTarget)
	 * @see org.summer.dsl.model.types.TypesPackage#getJvmMember_AnnotationInfo()
	 * @model containment="true"
	 * @generated
	 */
	JvmAnnotationTarget getAnnotationInfo();

	/**
	 * Sets the value of the '{@link org.summer.dsl.model.types.JvmMember#getAnnotationInfo <em>Annotation Info</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Annotation Info</em>' containment reference.
	 * @see #getAnnotationInfo()
	 * @generated
	 */
	void setAnnotationInfo(JvmAnnotationTarget value);

	/**
	 * Returns the value of the '<em><b>Modifiers</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Modifiers</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Modifiers</em>' attribute list.
	 * @see org.summer.dsl.model.types.TypesPackage#getJvmMember_Modifiers()
	 * @model unique="false"
	 * @generated
	 */
	EList<String> getModifiers();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void internalSetIdentifier(String identifier);

} // JvmMember
