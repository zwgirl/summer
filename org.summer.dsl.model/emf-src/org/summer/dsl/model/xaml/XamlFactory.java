/**
 */
package org.summer.dsl.model.xaml;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.summer.dsl.model.xaml.XamlPackage
 * @generated
 */
public interface XamlFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	XamlFactory eINSTANCE = org.summer.dsl.model.xaml.impl.XamlFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>XElement</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>XElement</em>'.
	 * @generated
	 */
	XElement createXElement();

	/**
	 * Returns a new object of class '<em>XObject Element</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>XObject Element</em>'.
	 * @generated
	 */
	XObjectElement createXObjectElement();

	/**
	 * Returns a new object of class '<em>XAttribute Element</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>XAttribute Element</em>'.
	 * @generated
	 */
	XAttributeElement createXAttributeElement();

	/**
	 * Returns a new object of class '<em>XAbstract Attribute</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>XAbstract Attribute</em>'.
	 * @generated
	 */
	XAbstractAttribute createXAbstractAttribute();

	/**
	 * Returns a new object of class '<em>XMarkup Extenson</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>XMarkup Extenson</em>'.
	 * @generated
	 */
	XMarkupExtenson createXMarkupExtenson();

	/**
	 * Returns a new object of class '<em>XAttach Attribute</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>XAttach Attribute</em>'.
	 * @generated
	 */
	XAttachAttribute createXAttachAttribute();

	/**
	 * Returns a new object of class '<em>XGeneral Attribute</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>XGeneral Attribute</em>'.
	 * @generated
	 */
	XGeneralAttribute createXGeneralAttribute();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	XamlPackage getXamlPackage();

} //XamlFactory
