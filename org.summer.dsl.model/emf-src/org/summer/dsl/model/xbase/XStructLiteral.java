/**
 */
package org.summer.dsl.model.xbase;

import org.eclipse.emf.common.util.EList;
import org.summer.dsl.model.types.JvmDeclaredType;
import org.summer.dsl.model.types.JvmTypeReference;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>XStruct Literal</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.summer.dsl.model.xbase.XStructLiteral#getProperties <em>Properties</em>}</li>
 *   <li>{@link org.summer.dsl.model.xbase.XStructLiteral#getType <em>Type</em>}</li>
 *   <li>{@link org.summer.dsl.model.xbase.XStructLiteral#getTypeArguments <em>Type Arguments</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.summer.dsl.model.xbase.XbasePackage#getXStructLiteral()
 * @model
 * @generated
 */
public interface XStructLiteral extends XExpression {
	/**
	 * Returns the value of the '<em><b>Properties</b></em>' containment reference list.
	 * The list contents are of type {@link org.summer.dsl.model.xbase.XFieldLiteralPart}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Properties</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Properties</em>' containment reference list.
	 * @see org.summer.dsl.model.xbase.XbasePackage#getXStructLiteral_Properties()
	 * @model containment="true"
	 * @generated
	 */
	EList<XFieldLiteralPart> getProperties();

	/**
	 * Returns the value of the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' reference.
	 * @see #setType(JvmDeclaredType)
	 * @see org.summer.dsl.model.xbase.XbasePackage#getXStructLiteral_Type()
	 * @model
	 * @generated
	 */
	JvmDeclaredType getType();

	/**
	 * Sets the value of the '{@link org.summer.dsl.model.xbase.XStructLiteral#getType <em>Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' reference.
	 * @see #getType()
	 * @generated
	 */
	void setType(JvmDeclaredType value);

	/**
	 * Returns the value of the '<em><b>Type Arguments</b></em>' containment reference list.
	 * The list contents are of type {@link org.summer.dsl.model.types.JvmTypeReference}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type Arguments</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type Arguments</em>' containment reference list.
	 * @see org.summer.dsl.model.xbase.XbasePackage#getXStructLiteral_TypeArguments()
	 * @model containment="true"
	 * @generated
	 */
	EList<JvmTypeReference> getTypeArguments();

} // XStructLiteral
