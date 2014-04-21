/**
 */
package org.summer.dsl.model.ss;

import org.eclipse.emf.common.util.EList;

import org.summer.dsl.model.types.JvmVisibility;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Xtend Member</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.summer.dsl.model.ss.XtendMember#getAnnotationInfo <em>Annotation Info</em>}</li>
 *   <li>{@link org.summer.dsl.model.ss.XtendMember#getModifiers <em>Modifiers</em>}</li>
 *   <li>{@link org.summer.dsl.model.ss.XtendMember#getDeclaringType <em>Declaring Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.summer.dsl.model.ss.SsPackage#getXtendMember()
 * @model
 * @generated
 */
public interface XtendMember extends XtendAnnotationTarget {
	/**
	 * Returns the value of the '<em><b>Annotation Info</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Annotation Info</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Annotation Info</em>' containment reference.
	 * @see #setAnnotationInfo(XtendAnnotationTarget)
	 * @see org.summer.dsl.model.ss.SsPackage#getXtendMember_AnnotationInfo()
	 * @model containment="true"
	 * @generated
	 */
	XtendAnnotationTarget getAnnotationInfo();

	/**
	 * Sets the value of the '{@link org.summer.dsl.model.ss.XtendMember#getAnnotationInfo <em>Annotation Info</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Annotation Info</em>' containment reference.
	 * @see #getAnnotationInfo()
	 * @generated
	 */
	void setAnnotationInfo(XtendAnnotationTarget value);

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
	 * @see org.summer.dsl.model.ss.SsPackage#getXtendMember_Modifiers()
	 * @model unique="false"
	 * @generated
	 */
	EList<String> getModifiers();

	/**
	 * Returns the value of the '<em><b>Declaring Type</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.summer.dsl.model.ss.XtendTypeDeclaration#getMembers <em>Members</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Declaring Type</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Declaring Type</em>' container reference.
	 * @see #setDeclaringType(XtendTypeDeclaration)
	 * @see org.summer.dsl.model.ss.SsPackage#getXtendMember_DeclaringType()
	 * @see org.summer.dsl.model.ss.XtendTypeDeclaration#getMembers
	 * @model opposite="members" transient="false"
	 * @generated
	 */
	XtendTypeDeclaration getDeclaringType();

	/**
	 * Sets the value of the '{@link org.summer.dsl.model.ss.XtendMember#getDeclaringType <em>Declaring Type</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Declaring Type</em>' container reference.
	 * @see #getDeclaringType()
	 * @generated
	 */
	void setDeclaringType(XtendTypeDeclaration value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	JvmVisibility getVisibility();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	JvmVisibility getDeclaredVisibility();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	boolean isStatic();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	boolean isFinal();

} // XtendMember
