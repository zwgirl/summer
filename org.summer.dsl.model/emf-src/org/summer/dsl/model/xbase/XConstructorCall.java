/**
 */
package org.summer.dsl.model.xbase;

import org.eclipse.emf.common.util.EList;
import org.summer.dsl.model.types.JvmConstructor;
import org.summer.dsl.model.types.JvmTypeReference;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>XConstructor Call</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.summer.dsl.model.xbase.XConstructorCall#getConstructor <em>Constructor</em>}</li>
 *   <li>{@link org.summer.dsl.model.xbase.XConstructorCall#getArguments <em>Arguments</em>}</li>
 *   <li>{@link org.summer.dsl.model.xbase.XConstructorCall#getTypeArguments <em>Type Arguments</em>}</li>
 *   <li>{@link org.summer.dsl.model.xbase.XConstructorCall#getInvalidFeatureIssueCode <em>Invalid Feature Issue Code</em>}</li>
 *   <li>{@link org.summer.dsl.model.xbase.XConstructorCall#isValidFeature <em>Valid Feature</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.summer.dsl.model.xbase.XbasePackage#getXConstructorCall()
 * @model
 * @generated
 */
public interface XConstructorCall extends XExpression {
	/**
	 * Returns the value of the '<em><b>Constructor</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Constructor</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Constructor</em>' reference.
	 * @see #setConstructor(JvmConstructor)
	 * @see org.summer.dsl.model.xbase.XbasePackage#getXConstructorCall_Constructor()
	 * @model
	 * @generated
	 */
	JvmConstructor getConstructor();

	/**
	 * Sets the value of the '{@link org.summer.dsl.model.xbase.XConstructorCall#getConstructor <em>Constructor</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Constructor</em>' reference.
	 * @see #getConstructor()
	 * @generated
	 */
	void setConstructor(JvmConstructor value);

	/**
	 * Returns the value of the '<em><b>Arguments</b></em>' containment reference list.
	 * The list contents are of type {@link org.summer.dsl.model.xbase.XExpression}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Arguments</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Arguments</em>' containment reference list.
	 * @see org.summer.dsl.model.xbase.XbasePackage#getXConstructorCall_Arguments()
	 * @model containment="true"
	 * @generated
	 */
	EList<XExpression> getArguments();

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
	 * @see org.summer.dsl.model.xbase.XbasePackage#getXConstructorCall_TypeArguments()
	 * @model containment="true"
	 * @generated
	 */
	EList<JvmTypeReference> getTypeArguments();

	/**
	 * Returns the value of the '<em><b>Invalid Feature Issue Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Invalid Feature Issue Code</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Invalid Feature Issue Code</em>' attribute.
	 * @see #setInvalidFeatureIssueCode(String)
	 * @see org.summer.dsl.model.xbase.XbasePackage#getXConstructorCall_InvalidFeatureIssueCode()
	 * @model transient="true"
	 * @generated
	 */
	String getInvalidFeatureIssueCode();

	/**
	 * Sets the value of the '{@link org.summer.dsl.model.xbase.XConstructorCall#getInvalidFeatureIssueCode <em>Invalid Feature Issue Code</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Invalid Feature Issue Code</em>' attribute.
	 * @see #getInvalidFeatureIssueCode()
	 * @generated
	 */
	void setInvalidFeatureIssueCode(String value);

	/**
	 * Returns the value of the '<em><b>Valid Feature</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Valid Feature</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Valid Feature</em>' attribute.
	 * @see org.summer.dsl.model.xbase.XbasePackage#getXConstructorCall_ValidFeature()
	 * @model transient="true" changeable="false" derived="true"
	 * @generated
	 */
	boolean isValidFeature();

} // XConstructorCall
