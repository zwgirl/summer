/**
 */
package org.summer.xaml.core.xAML;

import org.eclipse.emf.common.util.EList;

import org.summer.dsl.model.types.JvmTypeReference;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Object Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.summer.xaml.core.xAML.ObjectElement#getType <em>Type</em>}</li>
 *   <li>{@link org.summer.xaml.core.xAML.ObjectElement#getProperties <em>Properties</em>}</li>
 *   <li>{@link org.summer.xaml.core.xAML.ObjectElement#getClose <em>Close</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.summer.xaml.core.xAML.XAMLPackage#getObjectElement()
 * @model
 * @generated
 */
public interface ObjectElement extends ElementContent
{
  /**
   * Returns the value of the '<em><b>Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Type</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Type</em>' containment reference.
   * @see #setType(JvmTypeReference)
   * @see org.summer.xaml.core.xAML.XAMLPackage#getObjectElement_Type()
   * @model containment="true"
   * @generated
   */
  JvmTypeReference getType();

  /**
   * Sets the value of the '{@link org.summer.xaml.core.xAML.ObjectElement#getType <em>Type</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Type</em>' containment reference.
   * @see #getType()
   * @generated
   */
  void setType(JvmTypeReference value);

  /**
   * Returns the value of the '<em><b>Properties</b></em>' containment reference list.
   * The list contents are of type {@link org.summer.xaml.core.xAML.AbstractProperty}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Properties</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Properties</em>' containment reference list.
   * @see org.summer.xaml.core.xAML.XAMLPackage#getObjectElement_Properties()
   * @model containment="true"
   * @generated
   */
  EList<AbstractProperty> getProperties();

  /**
   * Returns the value of the '<em><b>Close</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Close</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Close</em>' containment reference.
   * @see #setClose(JvmTypeReference)
   * @see org.summer.xaml.core.xAML.XAMLPackage#getObjectElement_Close()
   * @model containment="true"
   * @generated
   */
  JvmTypeReference getClose();

  /**
   * Sets the value of the '{@link org.summer.xaml.core.xAML.ObjectElement#getClose <em>Close</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Close</em>' containment reference.
   * @see #getClose()
   * @generated
   */
  void setClose(JvmTypeReference value);

} // ObjectElement
