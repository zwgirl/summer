/**
 */
package org.summer.xaml.core.xAML;

import org.eclipse.emf.common.util.EList;

import org.summer.dsl.model.types.JvmTypeReference;

import org.summer.dsl.model.xbase.XExpression;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Markup Extenson</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.summer.xaml.core.xAML.MarkupExtenson#getType <em>Type</em>}</li>
 *   <li>{@link org.summer.xaml.core.xAML.MarkupExtenson#getProperties <em>Properties</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.summer.xaml.core.xAML.XAMLPackage#getMarkupExtenson()
 * @model
 * @generated
 */
public interface MarkupExtenson extends XExpression
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
   * @see org.summer.xaml.core.xAML.XAMLPackage#getMarkupExtenson_Type()
   * @model containment="true"
   * @generated
   */
  JvmTypeReference getType();

  /**
   * Sets the value of the '{@link org.summer.xaml.core.xAML.MarkupExtenson#getType <em>Type</em>}' containment reference.
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
   * @see org.summer.xaml.core.xAML.XAMLPackage#getMarkupExtenson_Properties()
   * @model containment="true"
   * @generated
   */
  EList<AbstractProperty> getProperties();

} // MarkupExtenson
