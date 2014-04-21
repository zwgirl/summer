/**
 */
package org.summer.xaml.core.xAML;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

import org.summer.dsl.model.xtype.XImportSection1;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Document</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.summer.xaml.core.xAML.Document#getImportSection <em>Import Section</em>}</li>
 *   <li>{@link org.summer.xaml.core.xAML.Document#getRoot <em>Root</em>}</li>
 *   <li>{@link org.summer.xaml.core.xAML.Document#getContents <em>Contents</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.summer.xaml.core.xAML.XAMLPackage#getDocument()
 * @model
 * @generated
 */
public interface Document extends EObject
{
  /**
   * Returns the value of the '<em><b>Import Section</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Import Section</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Import Section</em>' containment reference.
   * @see #setImportSection(XImportSection1)
   * @see org.summer.xaml.core.xAML.XAMLPackage#getDocument_ImportSection()
   * @model containment="true"
   * @generated
   */
  XImportSection1 getImportSection();

  /**
   * Sets the value of the '{@link org.summer.xaml.core.xAML.Document#getImportSection <em>Import Section</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Import Section</em>' containment reference.
   * @see #getImportSection()
   * @generated
   */
  void setImportSection(XImportSection1 value);

  /**
   * Returns the value of the '<em><b>Root</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Root</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Root</em>' containment reference.
   * @see #setRoot(ObjectElement)
   * @see org.summer.xaml.core.xAML.XAMLPackage#getDocument_Root()
   * @model containment="true"
   * @generated
   */
  ObjectElement getRoot();

  /**
   * Sets the value of the '{@link org.summer.xaml.core.xAML.Document#getRoot <em>Root</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Root</em>' containment reference.
   * @see #getRoot()
   * @generated
   */
  void setRoot(ObjectElement value);

  /**
   * Returns the value of the '<em><b>Contents</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.emf.ecore.EObject}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Contents</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Contents</em>' containment reference list.
   * @see org.summer.xaml.core.xAML.XAMLPackage#getDocument_Contents()
   * @model containment="true"
   * @generated
   */
  EList<EObject> getContents();

} // Document
