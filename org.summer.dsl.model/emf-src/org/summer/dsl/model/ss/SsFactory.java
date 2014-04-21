/**
 */
package org.summer.dsl.model.ss;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.summer.dsl.model.ss.SsPackage
 * @generated
 */
public interface SsFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	SsFactory eINSTANCE = org.summer.dsl.model.ss.impl.SsFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Xtend File</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Xtend File</em>'.
	 * @generated
	 */
	XtendFile createXtendFile();

	/**
	 * Returns a new object of class '<em>Xtend Class</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Xtend Class</em>'.
	 * @generated
	 */
	XtendClass createXtendClass();

	/**
	 * Returns a new object of class '<em>Xtend Member</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Xtend Member</em>'.
	 * @generated
	 */
	XtendMember createXtendMember();

	/**
	 * Returns a new object of class '<em>Xtend Function</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Xtend Function</em>'.
	 * @generated
	 */
	XtendFunction createXtendFunction();

	/**
	 * Returns a new object of class '<em>Xtend Field</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Xtend Field</em>'.
	 * @generated
	 */
	XtendField createXtendField();

	/**
	 * Returns a new object of class '<em>Xtend Parameter</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Xtend Parameter</em>'.
	 * @generated
	 */
	XtendParameter createXtendParameter();

	/**
	 * Returns a new object of class '<em>Rich String</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Rich String</em>'.
	 * @generated
	 */
	RichString createRichString();

	/**
	 * Returns a new object of class '<em>Rich String Literal</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Rich String Literal</em>'.
	 * @generated
	 */
	RichStringLiteral createRichStringLiteral();

	/**
	 * Returns a new object of class '<em>Rich String For Loop</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Rich String For Loop</em>'.
	 * @generated
	 */
	RichStringForLoop createRichStringForLoop();

	/**
	 * Returns a new object of class '<em>Rich String If</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Rich String If</em>'.
	 * @generated
	 */
	RichStringIf createRichStringIf();

	/**
	 * Returns a new object of class '<em>Rich String Else If</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Rich String Else If</em>'.
	 * @generated
	 */
	RichStringElseIf createRichStringElseIf();

	/**
	 * Returns a new object of class '<em>Create Extension Info</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Create Extension Info</em>'.
	 * @generated
	 */
	CreateExtensionInfo createCreateExtensionInfo();

	/**
	 * Returns a new object of class '<em>Xtend Constructor</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Xtend Constructor</em>'.
	 * @generated
	 */
	XtendConstructor createXtendConstructor();

	/**
	 * Returns a new object of class '<em>Xtend Type Declaration</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Xtend Type Declaration</em>'.
	 * @generated
	 */
	XtendTypeDeclaration createXtendTypeDeclaration();

	/**
	 * Returns a new object of class '<em>Xtend Annotation Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Xtend Annotation Type</em>'.
	 * @generated
	 */
	XtendAnnotationType createXtendAnnotationType();

	/**
	 * Returns a new object of class '<em>Xtend Interface</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Xtend Interface</em>'.
	 * @generated
	 */
	XtendInterface createXtendInterface();

	/**
	 * Returns a new object of class '<em>Xtend Enum</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Xtend Enum</em>'.
	 * @generated
	 */
	XtendEnum createXtendEnum();

	/**
	 * Returns a new object of class '<em>Xtend Enum Literal</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Xtend Enum Literal</em>'.
	 * @generated
	 */
	XtendEnumLiteral createXtendEnumLiteral();

	/**
	 * Returns a new object of class '<em>Xtend Variable Declaration</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Xtend Variable Declaration</em>'.
	 * @generated
	 */
	XtendVariableDeclaration createXtendVariableDeclaration();

	/**
	 * Returns a new object of class '<em>Xtend Formal Parameter</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Xtend Formal Parameter</em>'.
	 * @generated
	 */
	XtendFormalParameter createXtendFormalParameter();

	/**
	 * Returns a new object of class '<em>Xtend Delegate</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Xtend Delegate</em>'.
	 * @generated
	 */
	XtendDelegate createXtendDelegate();

	/**
	 * Returns a new object of class '<em>Xtend Event</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Xtend Event</em>'.
	 * @generated
	 */
	XtendEvent createXtendEvent();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	SsPackage getSsPackage();

} //SsFactory
