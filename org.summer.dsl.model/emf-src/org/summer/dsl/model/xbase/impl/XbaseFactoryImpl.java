/**
 */
package org.summer.dsl.model.xbase.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.summer.dsl.model.xbase.XArrayLiteral;
import org.summer.dsl.model.xbase.XAssignment;
import org.summer.dsl.model.xbase.XBinaryOperation;
import org.summer.dsl.model.xbase.XBlockExpression;
import org.summer.dsl.model.xbase.XBooleanLiteral;
import org.summer.dsl.model.xbase.XBreakExpression;
import org.summer.dsl.model.xbase.XCasePart;
import org.summer.dsl.model.xbase.XCastedExpression;
import org.summer.dsl.model.xbase.XCatchClause;
import org.summer.dsl.model.xbase.XClosure;
import org.summer.dsl.model.xbase.XConstructorCall;
import org.summer.dsl.model.xbase.XContinueExpression;
import org.summer.dsl.model.xbase.XDoWhileExpression;
import org.summer.dsl.model.xbase.XFeatureCall;
import org.summer.dsl.model.xbase.XFieldLiteralPart;
import org.summer.dsl.model.xbase.XForEachExpression;
import org.summer.dsl.model.xbase.XForLoopExpression;
import org.summer.dsl.model.xbase.XFunctionDeclaration;
import org.summer.dsl.model.xbase.XIfExpression;
import org.summer.dsl.model.xbase.XIndexOperation;
import org.summer.dsl.model.xbase.XInstanceOfExpression;
import org.summer.dsl.model.xbase.XKeyValuePair;
import org.summer.dsl.model.xbase.XListLiteral;
import org.summer.dsl.model.xbase.XMemberFeatureCall;
import org.summer.dsl.model.xbase.XMemberFeatureCall1;
import org.summer.dsl.model.xbase.XNullLiteral;
import org.summer.dsl.model.xbase.XNumberLiteral;
import org.summer.dsl.model.xbase.XObjectLiteral;
import org.summer.dsl.model.xbase.XObjectLiteralPart;
import org.summer.dsl.model.xbase.XPostfixOperation;
import org.summer.dsl.model.xbase.XPrefixOperation;
import org.summer.dsl.model.xbase.XReturnExpression;
import org.summer.dsl.model.xbase.XSetLiteral;
import org.summer.dsl.model.xbase.XStringLiteral;
import org.summer.dsl.model.xbase.XStructLiteral;
import org.summer.dsl.model.xbase.XSwitchExpression;
import org.summer.dsl.model.xbase.XTernaryOperation;
import org.summer.dsl.model.xbase.XThrowExpression;
import org.summer.dsl.model.xbase.XTryCatchFinallyExpression;
import org.summer.dsl.model.xbase.XTypeLiteral;
import org.summer.dsl.model.xbase.XUnaryOperation;
import org.summer.dsl.model.xbase.XVariableDeclaration;
import org.summer.dsl.model.xbase.XVariableDeclarationList;
import org.summer.dsl.model.xbase.XWhileExpression;
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
			case XbasePackage.XIF_EXPRESSION: return createXIfExpression();
			case XbasePackage.XSWITCH_EXPRESSION: return createXSwitchExpression();
			case XbasePackage.XCASE_PART: return createXCasePart();
			case XbasePackage.XBLOCK_EXPRESSION: return createXBlockExpression();
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
			case XbasePackage.XFOR_LOOP_EXPRESSION: return createXForLoopExpression();
			case XbasePackage.XFOR_EACH_EXPRESSION: return createXForEachExpression();
			case XbasePackage.XDO_WHILE_EXPRESSION: return createXDoWhileExpression();
			case XbasePackage.XWHILE_EXPRESSION: return createXWhileExpression();
			case XbasePackage.XTYPE_LITERAL: return createXTypeLiteral();
			case XbasePackage.XINSTANCE_OF_EXPRESSION: return createXInstanceOfExpression();
			case XbasePackage.XTHROW_EXPRESSION: return createXThrowExpression();
			case XbasePackage.XTRY_CATCH_FINALLY_EXPRESSION: return createXTryCatchFinallyExpression();
			case XbasePackage.XCATCH_CLAUSE: return createXCatchClause();
			case XbasePackage.XASSIGNMENT: return createXAssignment();
			case XbasePackage.XRETURN_EXPRESSION: return createXReturnExpression();
			case XbasePackage.XBREAK_EXPRESSION: return createXBreakExpression();
			case XbasePackage.XCONTINUE_EXPRESSION: return createXContinueExpression();
			case XbasePackage.XPOSTFIX_OPERATION: return createXPostfixOperation();
			case XbasePackage.XTERNARY_OPERATION: return createXTernaryOperation();
			case XbasePackage.XINDEX_OPERATION: return createXIndexOperation();
			case XbasePackage.XPREFIX_OPERATION: return createXPrefixOperation();
			case XbasePackage.XMEMBER_FEATURE_CALL1: return createXMemberFeatureCall1();
			case XbasePackage.XKEY_VALUE_PAIR: return createXKeyValuePair();
			case XbasePackage.XOBJECT_LITERAL: return createXObjectLiteral();
			case XbasePackage.XARRAY_LITERAL: return createXArrayLiteral();
			case XbasePackage.XOBJECT_LITERAL_PART: return createXObjectLiteralPart();
			case XbasePackage.XVARIABLE_DECLARATION_LIST: return createXVariableDeclarationList();
			case XbasePackage.XSTRUCT_LITERAL: return createXStructLiteral();
			case XbasePackage.XFIELD_LITERAL_PART: return createXFieldLiteralPart();
			
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public XIfExpression createXIfExpression()
	{
		XIfExpressionImpl xIfExpression = new XIfExpressionImpl();
		return xIfExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public XSwitchExpression createXSwitchExpression()
	{
		XSwitchExpressionImplCustom xSwitchExpression = new XSwitchExpressionImplCustom();
		return xSwitchExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public XCasePart createXCasePart()
	{
		XCasePartImplCustom xCasePart = new XCasePartImplCustom();
		return xCasePart;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public XBlockExpression createXBlockExpression()
	{
		XBlockExpressionImplCustom xBlockExpression = new XBlockExpressionImplCustom();
		return xBlockExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public XVariableDeclaration createXVariableDeclaration()
	{
		XVariableDeclarationImplCustom xVariableDeclaration = new XVariableDeclarationImplCustom();
		return xVariableDeclaration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public XMemberFeatureCall createXMemberFeatureCall()
	{
		XMemberFeatureCallImplCustom xMemberFeatureCall = new XMemberFeatureCallImplCustom();
		return xMemberFeatureCall;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public XFeatureCall createXFeatureCall()
	{
		XFeatureCallImplCustom xFeatureCall = new XFeatureCallImplCustom();
		return xFeatureCall;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
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
		XNullLiteralImplCustom xNullLiteral = new XNullLiteralImplCustom();
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
	 * @generated
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
	 * @generated
	 */
	public XBinaryOperation createXBinaryOperation()
	{
		XBinaryOperationImplCustom xBinaryOperation = new XBinaryOperationImplCustom();
		return xBinaryOperation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
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
	public XForLoopExpression createXForLoopExpression()
	{
		XForLoopExpressionImpl xForLoopExpression = new XForLoopExpressionImpl();
		return xForLoopExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public XDoWhileExpression createXDoWhileExpression()
	{
		XDoWhileExpressionImpl xDoWhileExpression = new XDoWhileExpressionImpl();
		return xDoWhileExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public XWhileExpression createXWhileExpression()
	{
		XWhileExpressionImpl xWhileExpression = new XWhileExpressionImpl();
		return xWhileExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public XTypeLiteral createXTypeLiteral()
	{
		XTypeLiteralImplCustom xTypeLiteral = new XTypeLiteralImplCustom();
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
	public XThrowExpression createXThrowExpression()
	{
		XThrowExpressionImpl xThrowExpression = new XThrowExpressionImpl();
		return xThrowExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public XTryCatchFinallyExpression createXTryCatchFinallyExpression()
	{
		XTryCatchFinallyExpressionImpl xTryCatchFinallyExpression = new XTryCatchFinallyExpressionImpl();
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
	 * @generated
	 */
	public XAssignment createXAssignment()
	{
		XAssignmentImplCustom xAssignment = new XAssignmentImplCustom();
		return xAssignment;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public XReturnExpression createXReturnExpression()
	{
		XReturnExpressionImplCustom xReturnExpression = new XReturnExpressionImplCustom();
		return xReturnExpression;
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public XBreakExpression createXBreakExpression() {
		XBreakExpression xBreakExpression = new XBreakExpressionImpl();
		return xBreakExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public XContinueExpression createXContinueExpression() {
		XContinueExpression xContinueExpression = new XContinueExpressionImpl();
		return xContinueExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public XPostfixOperation createXPostfixOperation() {
		XPostfixOperation xPostfixOperation = new XPostfixOperationImpl();
		return xPostfixOperation;
	}
	
	public XTernaryOperation createXTernaryOperation() {
		return new XTernaryOperationImpl();
	}
	
	public XPrefixOperation createXPrefixOperation() {
		return new XPrefixOperationImpl();
	}

	public XIndexOperation createXIndexOperation() {
		return new XIndexOperationImpl();
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

	public XMemberFeatureCall1 createXMemberFeatureCall1() {
		XMemberFeatureCall1ImplCustom xMemberFeatureCall = new XMemberFeatureCall1ImplCustom();
		return xMemberFeatureCall;
	}

	public XFunctionDeclaration createXFunctionDeclaration() {
		// TODO Auto-generated method stub
		return new XFunctionDeclarationImpl();
	}

	public XKeyValuePair createXKeyValuePair() {
		return new XKeyValuePairImpl();
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

	public XForEachExpression createXForEachExpression() {
		return new XForEachExpressionImpl();
	}

	@Override
	public XStructLiteral createXStructLiteral() {
		return new XStructLiteralImpl();
	}

	@Override
	public XFieldLiteralPart createXFieldLiteralPart() {
		return new XFieldLiteralPartImpl();
	}



} //XbaseFactoryImpl
