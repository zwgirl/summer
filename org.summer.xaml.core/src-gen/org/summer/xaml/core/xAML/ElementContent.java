/**
 */
package org.summer.xaml.core.xAML;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Element Content</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.summer.xaml.core.xAML.ElementContent#getContents <em>Contents</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.summer.xaml.core.xAML.XAMLPackage#getElementContent()
 * @model
 * @generated
 */
public interface ElementContent extends EObject
{
  /**
   * Returns the value of the '<em><b>Contents</b></em>' containment reference list.
   * The list contents are of type {@link org.summer.xaml.core.xAML.ElementContent}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Contents</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Contents</em>' containment reference list.
   * @see org.summer.xaml.core.xAML.XAMLPackage#getElementContent_Contents()
   * @model containment="true"
   * @generated
   */
  EList<ElementContent> getContents();

} // ElementContent
