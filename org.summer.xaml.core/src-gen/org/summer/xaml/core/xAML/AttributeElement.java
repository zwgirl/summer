/**
 */
package org.summer.xaml.core.xAML;

import org.summer.dsl.model.types.JvmField;
import org.summer.dsl.model.types.JvmType;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Attribute Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.summer.xaml.core.xAML.AttributeElement#getType <em>Type</em>}</li>
 *   <li>{@link org.summer.xaml.core.xAML.AttributeElement#getAttribute <em>Attribute</em>}</li>
 *   <li>{@link org.summer.xaml.core.xAML.AttributeElement#getClose <em>Close</em>}</li>
 *   <li>{@link org.summer.xaml.core.xAML.AttributeElement#getCloseAttribute <em>Close Attribute</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.summer.xaml.core.xAML.XAMLPackage#getAttributeElement()
 * @model
 * @generated
 */
public interface AttributeElement extends ElementContent
{
  /**
   * Returns the value of the '<em><b>Type</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Type</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Type</em>' reference.
   * @see #setType(JvmType)
   * @see org.summer.xaml.core.xAML.XAMLPackage#getAttributeElement_Type()
   * @model
   * @generated
   */
  JvmType getType();

  /**
   * Sets the value of the '{@link org.summer.xaml.core.xAML.AttributeElement#getType <em>Type</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Type</em>' reference.
   * @see #getType()
   * @generated
   */
  void setType(JvmType value);

  /**
   * Returns the value of the '<em><b>Attribute</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Attribute</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Attribute</em>' reference.
   * @see #setAttribute(JvmField)
   * @see org.summer.xaml.core.xAML.XAMLPackage#getAttributeElement_Attribute()
   * @model
   * @generated
   */
  JvmField getAttribute();

  /**
   * Sets the value of the '{@link org.summer.xaml.core.xAML.AttributeElement#getAttribute <em>Attribute</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Attribute</em>' reference.
   * @see #getAttribute()
   * @generated
   */
  void setAttribute(JvmField value);

  /**
   * Returns the value of the '<em><b>Close</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Close</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Close</em>' reference.
   * @see #setClose(JvmType)
   * @see org.summer.xaml.core.xAML.XAMLPackage#getAttributeElement_Close()
   * @model
   * @generated
   */
  JvmType getClose();

  /**
   * Sets the value of the '{@link org.summer.xaml.core.xAML.AttributeElement#getClose <em>Close</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Close</em>' reference.
   * @see #getClose()
   * @generated
   */
  void setClose(JvmType value);

  /**
   * Returns the value of the '<em><b>Close Attribute</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Close Attribute</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Close Attribute</em>' reference.
   * @see #setCloseAttribute(JvmField)
   * @see org.summer.xaml.core.xAML.XAMLPackage#getAttributeElement_CloseAttribute()
   * @model
   * @generated
   */
  JvmField getCloseAttribute();

  /**
   * Sets the value of the '{@link org.summer.xaml.core.xAML.AttributeElement#getCloseAttribute <em>Close Attribute</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Close Attribute</em>' reference.
   * @see #getCloseAttribute()
   * @generated
   */
  void setCloseAttribute(JvmField value);

} // AttributeElement
