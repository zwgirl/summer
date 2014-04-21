/**
 */
package org.summer.xaml.core.xAML;

import org.summer.dsl.model.types.JvmField;
import org.summer.dsl.model.types.JvmType;

import org.summer.dsl.model.xbase.XExpression;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Property</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.summer.xaml.core.xAML.Property#getType <em>Type</em>}</li>
 *   <li>{@link org.summer.xaml.core.xAML.Property#getProperty <em>Property</em>}</li>
 *   <li>{@link org.summer.xaml.core.xAML.Property#getValue <em>Value</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.summer.xaml.core.xAML.XAMLPackage#getProperty()
 * @model
 * @generated
 */
public interface Property extends AbstractProperty
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
   * @see org.summer.xaml.core.xAML.XAMLPackage#getProperty_Type()
   * @model
   * @generated
   */
  JvmType getType();

  /**
   * Sets the value of the '{@link org.summer.xaml.core.xAML.Property#getType <em>Type</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Type</em>' reference.
   * @see #getType()
   * @generated
   */
  void setType(JvmType value);

  /**
   * Returns the value of the '<em><b>Property</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Property</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Property</em>' reference.
   * @see #setProperty(JvmField)
   * @see org.summer.xaml.core.xAML.XAMLPackage#getProperty_Property()
   * @model
   * @generated
   */
  JvmField getProperty();

  /**
   * Sets the value of the '{@link org.summer.xaml.core.xAML.Property#getProperty <em>Property</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Property</em>' reference.
   * @see #getProperty()
   * @generated
   */
  void setProperty(JvmField value);

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
   * @see org.summer.xaml.core.xAML.XAMLPackage#getProperty_Value()
   * @model containment="true"
   * @generated
   */
  XExpression getValue();

  /**
   * Sets the value of the '{@link org.summer.xaml.core.xAML.Property#getValue <em>Value</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Value</em>' containment reference.
   * @see #getValue()
   * @generated
   */
  void setValue(XExpression value);

} // Property
