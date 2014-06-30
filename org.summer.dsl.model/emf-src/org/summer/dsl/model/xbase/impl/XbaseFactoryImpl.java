/**
 */
package org.summer.dsl.model.xbase.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.summer.dsl.model.xbase.RichStringLiteral;
import org.summer.dsl.model.xbase.XArgument;
import org.summer.dsl.model.xbase.XArrayLiteral;
import org.summer.dsl.model.xbase.XAssignment;
import org.summer.dsl.model.xbase.XAssignment1;
import org.summer.dsl.model.xbase.XBinaryOperation;
import org.summer.dsl.model.xbase.XBlockStatment;
import org.summer.dsl.model.xbase.XBooleanLiteral;
import org.summer.dsl.model.xbase.XBreakStatment;
import org.summer.dsl.model.xbase.XCaller;
import org.summer.dsl.model.xbase.XCasePart;
import org.summer.dsl.model.xbase.XCastedExpression;
import org.summer.dsl.model.xbase.XCatchClause;
import org.summer.dsl.model.xbase.XClosure;
import org.summer.dsl.model.xbase.XConstructorCall;
import org.summer.dsl.model.xbase.XContinueStatment;
import org.summer.dsl.model.xbase.XDoWhileStatment;
import org.summer.dsl.model.xbase.XExpressionStatment;
import org.summer.dsl.model.xbase.XFeatureCall;
import org.summer.dsl.model.xbase.XFieldLiteralPart;
import org.summer.dsl.model.xbase.XForEachStatment;
import org.summer.dsl.model.xbase.XForLoopStatment;
import org.summer.dsl.model.xbase.XFunctionDeclaration;
import org.summer.dsl.model.xbase.XIfStatment;
import org.summer.dsl.model.xbase.XIndexer;
import org.summer.dsl.model.xbase.XInstanceOfExpression;
import org.summer.dsl.model.xbase.XListLiteral;
import org.summer.dsl.model.xbase.XMemberFeatureCall;
import org.summer.dsl.model.xbase.XNullLiteral;
import org.summer.dsl.model.xbase.XNumberLiteral;
import org.summer.dsl.model.xbase.XObjectLiteral;
import org.summer.dsl.model.xbase.XObjectLiteralPart;
import org.summer.dsl.model.xbase.XParenthesizedExpression;
import org.summer.dsl.model.xbase.XPostfixOperation;
import org.summer.dsl.model.xbase.XReturnStatment;
import org.summer.dsl.model.xbase.XSetLiteral;
import org.summer.dsl.model.xbase.XStringLiteral;
import org.summer.dsl.model.xbase.XStructLiteral;
import org.summer.dsl.model.xbase.XSwitchStatment;
import org.summer.dsl.model.xbase.XTemplate;
import org.summer.dsl.model.xbase.XTernaryOperation;
import org.summer.dsl.model.xbase.XThrowStatment;
import org.summer.dsl.model.xbase.XTryCatchFinallyStatment;
import org.summer.dsl.model.xbase.XTypeLiteral;
import org.summer.dsl.model.xbase.XUnaryOperation;
import org.summer.dsl.model.xbase.XVariableDeclaration;
import org.summer.dsl.model.xbase.XVariableDeclarationList;
import org.summer.dsl.model.xbase.XWhileStatment;
import org.summer.dsl.model.xbase.XbaseFactory;
import org.summer.dsl.model.xbase.XbasePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated NOT
 */
public class XbaseFactoryImpl extends EFactoryImpl implements XbaseFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static XbaseFactory init() {
		try {
			XbaseFactory theXbaseFactory = (XbaseFactory)EPackage.Registry.INSTANCE.getEFactory(XbasePackage.eNS_URI);
			if (theXbaseFactory != null) {
				return theXbaseFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new XbaseFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public XbaseFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case XbasePackage.XIF_STATMENT: return createXIfStatment();
			case XbasePackage.XARGUMENT: return createXArgument();
			case XbasePackage.XSWITCH_STATMENT: return createXSwitchStatment();
			case XbasePackage.XCASE_PART: return createXCasePart();
			case XbasePackage.XBLOCK_STATMENT: return createXBlockStatment();
			case XbasePackage.XVARIABLE_DECLARATION: return createXVariableDeclaration();
			case XbasePackage.XMEMBER_FEATURE_CALL: return createXMemberFeatureCall();
			case XbasePackage.XFEATURE_CALL: return createXFeatureCall();
			case XbasePackage.XCONSTRUCTOR_CALL: return createXConstructorCall();
			case XbasePackage.XBOOLEAN_LITERAL: return createXBooleanLiteral();
			case XbasePackage.XNULL_LITERAL: return createXNullLiteral();
			case XbasePackage.XNUMBER_LITERAL: return createXNumberLiteral();
			case XbasePackage.XSTRING_LITERAL: return createXStringLiteral();
			case XbasePackage.XLIST_LITERAL: return createXListLiteral();
			case XbasePackage.XSET_LITERAL: return createXSetLiteral();
			case XbasePackage.XCLOSURE: return createXClosure();
			case XbasePackage.XCASTED_EXPRESSION: return createXCastedExpression();
			case XbasePackage.XBINARY_OPERATION: return createXBinaryOperation();
			case XbasePackage.XUNARY_OPERATION: return createXUnaryOperation();
			case XbasePackage.XFOR_LOOP_STATMENT: return createXForLoopStatment();
			case XbasePackage.XFOR_EACH_STATMENT: return createXForEachStatment();
			case XbasePackage.XDO_WHILE_STATMENT: return createXDoWhileStatment();
			case XbasePackage.XWHILE_STATMENT: return createXWhileStatment();
			case XbasePackage.XTYPE_LITERAL: return createXTypeLiteral();
			case XbasePackage.XINSTANCE_OF_EXPRESSION: return createXInstanceOfExpression();
			case XbasePackage.XTHROW_STATMENT: return createXThrowStatment();
			case XbasePackage.XTRY_CATCH_FINALLY_STATMENT: return createXTryCatchFinallyStatment();
			case XbasePackage.XCATCH_CLAUSE: return createXCatchClause();
			case XbasePackage.XASSIGNMENT: return createXAssignment();
			case XbasePackage.XASSIGNMENT1: return createXAssignment1();
			case XbasePackage.XRETURN_STATMENT: return createXReturnStatment();
			case XbasePackage.XBREAK_STATMENT: return createXBreakStatment();
			case XbasePackage.XCONTINUE_STATMENT: return createXContinueStatment();
			case XbasePackage.XPOSTFIX_OPERATION: return createXPostfixOperation();
			case XbasePackage.XTERNARY_OPERATION: return createXTernaryOperation();
			case XbasePackage.XINDEXER: return createXIndexer();
			case XbasePackage.XCALLER: return createXCaller();
			case XbasePackage.XOBJECT_LITERAL: return createXObjectLiteral();
			case XbasePackage.XARRAY_LITERAL: return createXArrayLiteral();
			case XbasePackage.XOBJECT_LITERAL_PART: return createXObjectLiteralPart();
			case XbasePackage.XVARIABLE_DECLARATION_LIST: return createXVariableDeclarationList();
			case XbasePackage.XSTRUCT_LITERAL: return createXStructLiteral();
			case XbasePackage.XFIELD_LITERAL_PART: return createXFieldLiteralPart();
			case XbasePackage.XTEMPLATE: return createXTemplate();
			case XbasePackage.RICH_STRING_LITERAL: return createRichStringLiteral();
			case XbasePackage.XFUNCTION_DECLARATION: return createXFunctionDeclaration();
			case XbasePackage.XEXPRESSION_STATMENT: return createXExpressionStatment();
			case XbasePackage.XPARENTHESIZED_EXPRESSION: return createXParenthesizedExpression();
			
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object createFromString(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID()) {
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID()) {
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public XIfStatment createXIfStatment()
	{
		XIfStatmentImpl xIfExpression = new XIfStatmentImpl();
		return xIfExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public XSwitchStatment createXSwitchStatment()
	{
		XSwitchStatmentImpl xSwitchExpression = new XSwitchStatmentImpl();
		return xSwitchExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public XCasePart createXCasePart()
	{
		XCasePartImpl xCasePart = new XCasePartImpl();
		return xCasePart;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public XBlockStatment createXBlockStatment()
	{
		XBlockStatmentImpl xBlockExpression = new XBlockStatmentImpl();
		return xBlockExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public XVariableDeclaration createXVariableDeclaration()
	{
		XVariableDeclarationImpl xVariableDeclaration = new XVariableDeclarationImpl();
		return xVariableDeclaration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public XMemberFeatureCall createXMemberFeatureCall()
	{
		XMemberFeatureCallImplCustom xMemberFeatureCall = new XMemberFeatureCallImplCustom();
		return xMemberFeatureCall;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public XFeatureCall createXFeatureCall()
	{
		XFeatureCallImplCustom xFeatureCall = new XFeatureCallImplCustom();
		return xFeatureCall;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public XConstructorCall createXConstructorCall()
	{
		XConstructorCallImplCustom xConstructorCall = new XConstructorCallImplCustom();
		return xConstructorCall;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public XBooleanLiteral createXBooleanLiteral()
	{
		XBooleanLiteralImpl xBooleanLiteral = new XBooleanLiteralImpl();
		return xBooleanLiteral;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public XNullLiteral createXNullLiteral()
	{
		XNullLiteralImpl xNullLiteral = new XNullLiteralImpl();
		return xNullLiteral;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public XNumberLiteral createXNumberLiteral()
	{
		XNumberLiteralImpl xNumberLiteral = new XNumberLiteralImpl();
		return xNumberLiteral;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public XStringLiteral createXStringLiteral()
	{
		XStringLiteralImpl xStringLiteral = new XStringLiteralImpl();
		return xStringLiteral;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public XListLiteral createXListLiteral()
	{
		XListLiteralImpl xListLiteral = new XListLiteralImpl();
		return xListLiteral;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public XSetLiteral createXSetLiteral()
	{
		XSetLiteralImpl xSetLiteral = new XSetLiteralImpl();
		return xSetLiteral;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public XClosure createXClosure()
	{
		XClosureImplCustom xClosure = new XClosureImplCustom();
		return xClosure;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public XCastedExpression createXCastedExpression()
	{
		XCastedExpressionImpl xCastedExpression = new XCastedExpressionImpl();
		return xCastedExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public XBinaryOperation createXBinaryOperation()
	{
		XBinaryOperationImplCustom xBinaryOperation = new XBinaryOperationImplCustom();
		return xBinaryOperation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public XUnaryOperation createXUnaryOperation()
	{
		XUnaryOperationImplCustom xUnaryOperation = new XUnaryOperationImplCustom();
		return xUnaryOperation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public XForLoopStatment createXForLoopStatment()
	{
		XForLoopStatmentImpl xForLoopExpression = new XForLoopStatmentImpl();
		return xForLoopExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public XDoWhileStatment createXDoWhileStatment()
	{
		XDoWhileStatmentImpl xDoWhileExpression = new XDoWhileStatmentImpl();
		return xDoWhileExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public XWhileStatment createXWhileStatment()
	{
		XWhileStatmentImpl xWhileExpression = new XWhileStatmentImpl();
		return xWhileExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public XTypeLiteral createXTypeLiteral()
	{
		XTypeLiteralImpl xTypeLiteral = new XTypeLiteralImpl();
		return xTypeLiteral;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public XInstanceOfExpression createXInstanceOfExpression()
	{
		XInstanceOfExpressionImpl xInstanceOfExpression = new XInstanceOfExpressionImpl();
		return xInstanceOfExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public XThrowStatment createXThrowStatment()
	{
		XThrowStatmentImpl xThrowExpression = new XThrowStatmentImpl();
		return xThrowExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public XTryCatchFinallyStatment createXTryCatchFinallyStatment()
	{
		XTryCatchFinallyStatmentImpl xTryCatchFinallyExpression = new XTryCatchFinallyStatmentImpl();
		return xTryCatchFinallyExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public XCatchClause createXCatchClause()
	{
		XCatchClauseImpl xCatchClause = new XCatchClauseImpl();
		return xCatchClause;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public XAssignment createXAssignment()
	{
		XAssignmentImplCustom xAssignment = new XAssignmentImplCustom();
		return xAssignment;
	}
	
	public XAssignment1 createXAssignment1()
	{
		XAssignment1Impl xAssignment = new XAssignment1Impl();
		return xAssignment;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public XReturnStatment createXReturnStatment()
	{
		XReturnStatmentmplCustom xReturnExpression = new XReturnStatmentmplCustom();
		return xReturnExpression;
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public XBreakStatment createXBreakStatment() {
		XBreakStatmentImpl xBreakExpression = new XBreakStatmentImpl();
		return xBreakExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public XContinueStatment createXContinueStatment() {
		XContinueStatmentImpl xContinueExpression = new XContinueStatmentImpl();
		return xContinueExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public XPostfixOperation createXPostfixOperation() {
		XPostfixOperationImplCustom xPostfixOperation = new XPostfixOperationImplCustom();
		return xPostfixOperation;
	}
	
	public XTernaryOperation createXTernaryOperation() {
		return new XTernaryOperationImpl();
	}

	public XIndexer createXIndexer() {
		return new XIndexerImpl();
	}
	
	public XCaller createXCaller() {
		return new XCallerImpl();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public XbasePackage getXbasePackage() {
		return (XbasePackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static XbasePackage getPackage() {
		return XbasePackage.eINSTANCE;
	}

	public XObjectLiteral createXObjectLiteral() {
		return new XObjectLiteralImpl();
	}

	public XObjectLiteralPart createXObjectLiteralPart() {
		return new XObjectLiteralPartImpl();
	}

	public XArrayLiteral createXArrayLiteral() {
		return new XArrayLiteralImpl();
	}

	public XVariableDeclarationList createXVariableDeclarationList() {
		return new XVariableDeclarationListImpl();
	}

	public XForEachStatment createXForEachStatment() {
		return new XForEachStatmentImpl();
	}

	public XStructLiteral createXStructLiteral() {
		return new XStructLiteralImpl();
	}

	public XFieldLiteralPart createXFieldLiteralPart() {
		return new XFieldLiteralPartImpl();
	}

	public XTemplate createXTemplate() {
		return new XTemplateImpl();
	}

	public RichStringLiteral createRichStringLiteral() {
		return new RichStringLiteralImpl();
	}

	public XFunctionDeclaration createXFunctionDeclaration() {
		return new XFunctionDeclarationImpl();
	}

	public XExpressionStatment createXExpressionStatment() {
		return new XExpressionStatmentImpl();
	}

	public XParenthesizedExpression createXParenthesizedExpression() {
		return new XParenthesizedExpressionImpl();
	}

	public XArgument createXArgument() {
		return new XArgumentImpl();
	}

} //XbaseFactoryImpl
