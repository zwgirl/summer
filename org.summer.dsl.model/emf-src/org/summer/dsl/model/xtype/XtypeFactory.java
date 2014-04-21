/**
 */
package org.summer.dsl.model.xtype;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.summer.dsl.model.xtype.XtypePackage
 * @generated
 */
public interface XtypeFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	XtypeFactory eINSTANCE = org.summer.dsl.model.xtype.impl.XtypeFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>XFunction Type Ref</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>XFunction Type Ref</em>'.
	 * @generated
	 */
	XFunctionTypeRef createXFunctionTypeRef();

	/**
	 * Returns a new object of class '<em>XComputed Type Reference</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>XComputed Type Reference</em>'.
	 * @generated
	 */
	XComputedTypeReference createXComputedTypeReference();

	/**
	 * Returns a new object of class '<em>XImport Section</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>XImport Section</em>'.
	 * @generated
	 */
	XImportSection createXImportSection();

	/**
	 * Returns a new object of class '<em>XImport Declaration</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>XImport Declaration</em>'.
	 * @generated
	 */
	XImportDeclaration createXImportDeclaration();

	/**
	 * Returns a new object of class '<em>XImport Section1</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>XImport Section1</em>'.
	 * @generated
	 */
	XImportSection1 createXImportSection1();

	/**
	 * Returns a new object of class '<em>XImport Declaration1</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>XImport Declaration1</em>'.
	 * @generated
	 */
	XImportDeclaration1 createXImportDeclaration1();

	/**
	 * Returns a new object of class '<em>XImport Item</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>XImport Item</em>'.
	 * @generated
	 */
	XImportItem createXImportItem();

	/**
	 * Returns a new object of class '<em>XExport Section</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>XExport Section</em>'.
	 * @generated
	 */
	XExportSection createXExportSection();

	/**
	 * Returns a new object of class '<em>XExport Declaration</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>XExport Declaration</em>'.
	 * @generated
	 */
	XExportDeclaration createXExportDeclaration();

	/**
	 * Returns a new object of class '<em>XExport Item</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>XExport Item</em>'.
	 * @generated
	 */
	XExportItem createXExportItem();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	XtypePackage getXtypePackage();

} //XtypeFactory
