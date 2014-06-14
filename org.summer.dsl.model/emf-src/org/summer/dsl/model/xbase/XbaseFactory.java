/**
 */
package org.summer.dsl.model.xbase;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.summer.dsl.model.xbase.XbasePackage
 * @generated
 */
public interface XbaseFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	XbaseFactory eINSTANCE = org.summer.dsl.model.xbase.impl.XbaseFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>XIf Statment</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>XIf Statment</em>'.
	 * @generated
	 */
	XIfStatment createXIfStatment();

	/**
	 * Returns a new object of class '<em>XExpression Statment</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>XExpression Statment</em>'.
	 * @generated
	 */
	XExpressionStatment createXExpressionStatment();

	/**
	 * Returns a new object of class '<em>XSwitch Statment</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>XSwitch Statment</em>'.
	 * @generated
	 */
	XSwitchStatment createXSwitchStatment();

	/**
	 * Returns a new object of class '<em>XCase Part</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>XCase Part</em>'.
	 * @generated
	 */
	XCasePart createXCasePart();

	/**
	 * Returns a new object of class '<em>XBlock Statment</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>XBlock Statment</em>'.
	 * @generated
	 */
	XBlockStatment createXBlockStatment();

	/**
	 * Returns a new object of class '<em>XVariable Declaration</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>XVariable Declaration</em>'.
	 * @generated
	 */
	XVariableDeclaration createXVariableDeclaration();

	/**
	 * Returns a new object of class '<em>XVariable Declaration List</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>XVariable Declaration List</em>'.
	 * @generated
	 */
	XVariableDeclarationList createXVariableDeclarationList();

	/**
	 * Returns a new object of class '<em>XMember Feature Call</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>XMember Feature Call</em>'.
	 * @generated
	 */
	XMemberFeatureCall createXMemberFeatureCall();

	/**
	 * Returns a new object of class '<em>XCaller</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>XCaller</em>'.
	 * @generated
	 */
	XCaller createXCaller();

	/**
	 * Returns a new object of class '<em>XFeature Call</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>XFeature Call</em>'.
	 * @generated
	 */
	XFeatureCall createXFeatureCall();

	/**
	 * Returns a new object of class '<em>XConstructor Call</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>XConstructor Call</em>'.
	 * @generated
	 */
	XConstructorCall createXConstructorCall();

	/**
	 * Returns a new object of class '<em>XBoolean Literal</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>XBoolean Literal</em>'.
	 * @generated
	 */
	XBooleanLiteral createXBooleanLiteral();

	/**
	 * Returns a new object of class '<em>XNull Literal</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>XNull Literal</em>'.
	 * @generated
	 */
	XNullLiteral createXNullLiteral();

	/**
	 * Returns a new object of class '<em>XNumber Literal</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>XNumber Literal</em>'.
	 * @generated
	 */
	XNumberLiteral createXNumberLiteral();

	/**
	 * Returns a new object of class '<em>XString Literal</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>XString Literal</em>'.
	 * @generated
	 */
	XStringLiteral createXStringLiteral();

	/**
	 * Returns a new object of class '<em>XList Literal</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>XList Literal</em>'.
	 * @generated
	 */
	XListLiteral createXListLiteral();

	/**
	 * Returns a new object of class '<em>XSet Literal</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>XSet Literal</em>'.
	 * @generated
	 */
	XSetLiteral createXSetLiteral();

	/**
	 * Returns a new object of class '<em>XClosure</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>XClosure</em>'.
	 * @generated
	 */
	XClosure createXClosure();

	/**
	 * Returns a new object of class '<em>XCasted Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>XCasted Expression</em>'.
	 * @generated
	 */
	XCastedExpression createXCastedExpression();

	/**
	 * Returns a new object of class '<em>XBinary Operation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>XBinary Operation</em>'.
	 * @generated
	 */
	XBinaryOperation createXBinaryOperation();

	/**
	 * Returns a new object of class '<em>XUnary Operation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>XUnary Operation</em>'.
	 * @generated
	 */
	XUnaryOperation createXUnaryOperation();

	/**
	 * Returns a new object of class '<em>XFor Loop Statment</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>XFor Loop Statment</em>'.
	 * @generated
	 */
	XForLoopStatment createXForLoopStatment();

	/**
	 * Returns a new object of class '<em>XFor Each Statment</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>XFor Each Statment</em>'.
	 * @generated
	 */
	XForEachStatment createXForEachStatment();

	/**
	 * Returns a new object of class '<em>XDo While Statment</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>XDo While Statment</em>'.
	 * @generated
	 */
	XDoWhileStatment createXDoWhileStatment();

	/**
	 * Returns a new object of class '<em>XWhile Statment</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>XWhile Statment</em>'.
	 * @generated
	 */
	XWhileStatment createXWhileStatment();

	/**
	 * Returns a new object of class '<em>XType Literal</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>XType Literal</em>'.
	 * @generated
	 */
	XTypeLiteral createXTypeLiteral();

	/**
	 * Returns a new object of class '<em>XInstance Of Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>XInstance Of Expression</em>'.
	 * @generated
	 */
	XInstanceOfExpression createXInstanceOfExpression();

	/**
	 * Returns a new object of class '<em>XThrow Statment</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>XThrow Statment</em>'.
	 * @generated
	 */
	XThrowStatment createXThrowStatment();

	/**
	 * Returns a new object of class '<em>XTry Catch Finally Statment</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>XTry Catch Finally Statment</em>'.
	 * @generated
	 */
	XTryCatchFinallyStatment createXTryCatchFinallyStatment();

	/**
	 * Returns a new object of class '<em>XCatch Clause</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>XCatch Clause</em>'.
	 * @generated
	 */
	XCatchClause createXCatchClause();

	/**
	 * Returns a new object of class '<em>XAssignment</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>XAssignment</em>'.
	 * @generated
	 */
	XAssignment createXAssignment();

	/**
	 * Returns a new object of class '<em>XReturn Statment</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>XReturn Statment</em>'.
	 * @generated
	 */
	XReturnStatment createXReturnStatment();

	/**
	 * Returns a new object of class '<em>XBreak Statment</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>XBreak Statment</em>'.
	 * @generated
	 */
	XBreakStatment createXBreakStatment();

	/**
	 * Returns a new object of class '<em>XContinue Statment</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>XContinue Statment</em>'.
	 * @generated
	 */
	XContinueStatment createXContinueStatment();

	/**
	 * Returns a new object of class '<em>XPostfix Operation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>XPostfix Operation</em>'.
	 * @generated
	 */
	XPostfixOperation createXPostfixOperation();

	/**
	 * Returns a new object of class '<em>XTernary Operation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>XTernary Operation</em>'.
	 * @generated
	 */
	XTernaryOperation createXTernaryOperation();

	/**
	 * Returns a new object of class '<em>XIndexer</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>XIndexer</em>'.
	 * @generated
	 */
	XIndexer createXIndexer();

	/**
	 * Returns a new object of class '<em>XFunction Declaration</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>XFunction Declaration</em>'.
	 * @generated
	 */
	XFunctionDeclaration createXFunctionDeclaration();

	/**
	 * Returns a new object of class '<em>XParenthesized Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>XParenthesized Expression</em>'.
	 * @generated
	 */
	XParenthesizedExpression createXParenthesizedExpression();

	/**
	 * Returns a new object of class '<em>XObject Literal</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>XObject Literal</em>'.
	 * @generated
	 */
	XObjectLiteral createXObjectLiteral();

	/**
	 * Returns a new object of class '<em>XObject Literal Part</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>XObject Literal Part</em>'.
	 * @generated
	 */
	XObjectLiteralPart createXObjectLiteralPart();

	/**
	 * Returns a new object of class '<em>XArray Literal</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>XArray Literal</em>'.
	 * @generated
	 */
	XArrayLiteral createXArrayLiteral();

	/**
	 * Returns a new object of class '<em>XStruct Literal</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>XStruct Literal</em>'.
	 * @generated
	 */
	XStructLiteral createXStructLiteral();

	/**
	 * Returns a new object of class '<em>XField Literal Part</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>XField Literal Part</em>'.
	 * @generated
	 */
	XFieldLiteralPart createXFieldLiteralPart();

	/**
	 * Returns a new object of class '<em>XTemplate</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>XTemplate</em>'.
	 * @generated
	 */
	XTemplate createXTemplate();

	/**
	 * Returns a new object of class '<em>Rich String Literal</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Rich String Literal</em>'.
	 * @generated
	 */
	RichStringLiteral createRichStringLiteral();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	XbasePackage getXbasePackage();

} //XbaseFactory
