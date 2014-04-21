/**
 */
package org.summer.xaml.core.xAML;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.summer.xaml.core.xAML.XAMLPackage
 * @generated
 */
public interface XAMLFactory extends EFactory
{
  /**
   * The singleton instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  XAMLFactory eINSTANCE = org.summer.xaml.core.xAML.impl.XAMLFactoryImpl.init();

  /**
   * Returns a new object of class '<em>Document</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Document</em>'.
   * @generated
   */
  Document createDocument();

  /**
   * Returns a new object of class '<em>Element Content</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Element Content</em>'.
   * @generated
   */
  ElementContent createElementContent();

  /**
   * Returns a new object of class '<em>Object Element</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Object Element</em>'.
   * @generated
   */
  ObjectElement createObjectElement();

  /**
   * Returns a new object of class '<em>Attribute Element</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Attribute Element</em>'.
   * @generated
   */
  AttributeElement createAttributeElement();

  /**
   * Returns a new object of class '<em>Abstract Property</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Abstract Property</em>'.
   * @generated
   */
  AbstractProperty createAbstractProperty();

  /**
   * Returns a new object of class '<em>Property</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Property</em>'.
   * @generated
   */
  Property createProperty();

  /**
   * Returns a new object of class '<em>Markup Extenson</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Markup Extenson</em>'.
   * @generated
   */
  MarkupExtenson createMarkupExtenson();

  /**
   * Returns the package supported by this factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the package supported by this factory.
   * @generated
   */
  XAMLPackage getXAMLPackage();

} //XAMLFactory
