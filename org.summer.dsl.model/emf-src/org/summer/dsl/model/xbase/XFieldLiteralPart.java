/**
 */
package org.summer.dsl.model.xbase;

import org.eclipse.emf.ecore.EObject;

import org.summer.dsl.model.types.JvmField;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>XField Literal Part</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.summer.dsl.model.xbase.XFieldLiteralPart#getField <em>Field</em>}</li>
 *   <li>{@link org.summer.dsl.model.xbase.XFieldLiteralPart#getValue <em>Value</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.summer.dsl.model.xbase.XbasePackage#getXFieldLiteralPart()
 * @model
 * @generated
 */
public interface XFieldLiteralPart extends EObject {
	/**
	 * Returns the value of the '<em><b>Field</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Field</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Field</em>' reference.
	 * @see #setField(JvmField)
	 * @see org.summer.dsl.model.xbase.XbasePackage#getXFieldLiteralPart_Field()
	 * @model
	 * @generated
	 */
	JvmField getField();

	/**
	 * Sets the value of the '{@link org.summer.dsl.model.xbase.XFieldLiteralPart#getField <em>Field</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Field</em>' reference.
	 * @see #getField()
	 * @generated
	 */
	void setField(JvmField value);

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
	 * @see org.summer.dsl.model.xbase.XbasePackage#getXFieldLiteralPart_Value()
	 * @model containment="true"
	 * @generated
	 */
	XExpression getValue();

	/**
	 * Sets the value of the '{@link org.summer.dsl.model.xbase.XFieldLiteralPart#getValue <em>Value</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value</em>' containment reference.
	 * @see #getValue()
	 * @generated
	 */
	void setValue(XExpression value);

} // XFieldLiteralPart
