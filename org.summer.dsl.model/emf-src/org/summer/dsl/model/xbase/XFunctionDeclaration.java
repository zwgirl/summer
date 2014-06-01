/**
 */
package org.summer.dsl.model.xbase;

import org.eclipse.emf.common.util.EList;
import org.summer.dsl.model.types.JvmFormalParameter;
import org.summer.dsl.model.types.JvmIdentifiableElement;
import org.summer.dsl.model.types.JvmTypeParameterDeclarator;
import org.summer.dsl.model.types.JvmTypeReference;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>XFunction</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.summer.dsl.model.xbase.XFunctionDeclaration#getDeclaredFormalParameters <em>Declared Formal Parameters</em>}</li>
 *   <li>{@link org.summer.dsl.model.xbase.XFunctionDeclaration#getBody <em>Body</em>}</li>
 *   <li>{@link org.summer.dsl.model.xbase.XFunctionDeclaration#getSimpleName <em>Simple Name</em>}</li>
 *   <li>{@link org.summer.dsl.model.xbase.XFunctionDeclaration#getReturnType <em>Return Type</em>}</li>
 *   <li>{@link org.summer.dsl.model.xbase.XFunctionDeclaration#isExported <em>Exported</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.summer.dsl.model.xbase.XbasePackage#getXFunctionDeclaration()
 * @model
 * @generated
 */
public interface XFunctionDeclaration extends JvmTypeParameterDeclarator, XStatment, JvmIdentifiableElement {
	/**
	 * Returns the value of the '<em><b>Declared Formal Parameters</b></em>' containment reference list.
	 * The list contents are of type {@link org.summer.dsl.model.types.JvmFormalParameter}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Declared Formal Parameters</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Declared Formal Parameters</em>' containment reference list.
	 * @see org.summer.dsl.model.xbase.XbasePackage#getXFunctionDeclaration_DeclaredFormalParameters()
	 * @model containment="true"
	 * @generated
	 */
	EList<JvmFormalParameter> getDeclaredFormalParameters();

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
	 * @see org.summer.dsl.model.xbase.XbasePackage#getXFunctionDeclaration_Body()
	 * @model containment="true"
	 * @generated
	 */
	XStatment getBody();

	/**
	 * Sets the value of the '{@link org.summer.dsl.model.xbase.XFunctionDeclaration#getBody <em>Body</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Body</em>' containment reference.
	 * @see #getBody()
	 * @generated
	 */
	void setBody(XStatment value);

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
	 * @see org.summer.dsl.model.xbase.XbasePackage#getXFunctionDeclaration_SimpleName()
	 * @model
	 * @generated
	 */
	String getSimpleName();

	/**
	 * Sets the value of the '{@link org.summer.dsl.model.xbase.XFunctionDeclaration#getSimpleName <em>Simple Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Simple Name</em>' attribute.
	 * @see #getSimpleName()
	 * @generated
	 */
	void setSimpleName(String value);

	/**
	 * Returns the value of the '<em><b>Return Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Return Type</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Return Type</em>' containment reference.
	 * @see #setReturnType(JvmTypeReference)
	 * @see org.summer.dsl.model.xbase.XbasePackage#getXFunctionDeclaration_ReturnType()
	 * @model containment="true"
	 * @generated
	 */
	JvmTypeReference getReturnType();

	/**
	 * Sets the value of the '{@link org.summer.dsl.model.xbase.XFunctionDeclaration#getReturnType <em>Return Type</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Return Type</em>' containment reference.
	 * @see #getReturnType()
	 * @generated
	 */
	void setReturnType(JvmTypeReference value);

	/**
	 * Returns the value of the '<em><b>Exported</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Exported</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Exported</em>' attribute.
	 * @see #setExported(boolean)
	 * @see org.summer.dsl.model.xbase.XbasePackage#getXFunctionDeclaration_Exported()
	 * @model default="false"
	 * @generated
	 */
	boolean isExported();

	/**
	 * Sets the value of the '{@link org.summer.dsl.model.xbase.XFunctionDeclaration#isExported <em>Exported</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Exported</em>' attribute.
	 * @see #isExported()
	 * @generated
	 */
	void setExported(boolean value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	EList<JvmFormalParameter> getFormalParameters();

} // XFunction
