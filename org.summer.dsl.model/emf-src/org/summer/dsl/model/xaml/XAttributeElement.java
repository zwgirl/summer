/**
 */
package org.summer.dsl.model.xaml;

import org.summer.dsl.model.types.JvmField;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>XAttribute Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.summer.dsl.model.xaml.XAttributeElement#getField <em>Field</em>}</li>
 *   <li>{@link org.summer.dsl.model.xaml.XAttributeElement#getCloseField <em>Close Field</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.summer.dsl.model.xaml.XamlPackage#getXAttributeElement()
 * @model
 * @generated
 */
public interface XAttributeElement extends XElement {
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
	 * @see org.summer.dsl.model.xaml.XamlPackage#getXAttributeElement_Field()
	 * @model
	 * @generated
	 */
	JvmField getField();

	/**
	 * Sets the value of the '{@link org.summer.dsl.model.xaml.XAttributeElement#getField <em>Field</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Field</em>' reference.
	 * @see #getField()
	 * @generated
	 */
	void setField(JvmField value);

	/**
	 * Returns the value of the '<em><b>Close Field</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Close Field</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Close Field</em>' reference.
	 * @see #setCloseField(JvmField)
	 * @see org.summer.dsl.model.xaml.XamlPackage#getXAttributeElement_CloseField()
	 * @model
	 * @generated
	 */
	JvmField getCloseField();

	/**
	 * Sets the value of the '{@link org.summer.dsl.model.xaml.XAttributeElement#getCloseField <em>Close Field</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Close Field</em>' reference.
	 * @see #getCloseField()
	 * @generated
	 */
	void setCloseField(JvmField value);

} // XAttributeElement
