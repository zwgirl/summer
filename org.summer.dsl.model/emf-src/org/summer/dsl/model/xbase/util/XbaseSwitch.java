/**
 */
package org.summer.dsl.model.xbase.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.Switch;
import org.summer.dsl.model.types.JvmAnnotationTarget;
import org.summer.dsl.model.types.JvmComponentType;
import org.summer.dsl.model.types.JvmDeclaredType;
import org.summer.dsl.model.types.JvmFeature;
import org.summer.dsl.model.types.JvmField;
import org.summer.dsl.model.types.JvmIdentifiableElement;
import org.summer.dsl.model.types.JvmMember;
import org.summer.dsl.model.types.JvmType;
import org.summer.dsl.model.types.JvmTypeParameterDeclarator;
import org.summer.dsl.model.xbase.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see org.summer.dsl.model.xbase.XbasePackage
 * @generated
 */
public class XbaseSwitch<T> extends Switch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static XbasePackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public XbaseSwitch() {
		if (modelPackage == null) {
			modelPackage = XbasePackage.eINSTANCE;
		}
	}

	/**
	 * Checks whether this is a switch for the given package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @parameter ePackage the package in question.
	 * @return whether this is a switch for the given package.
	 * @generated
	 */
	@Override
	protected boolean isSwitchFor(EPackage ePackage) {
		return ePackage == modelPackage;
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	@Override
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case XbasePackage.XEXPRESSION: {
				XExpression xExpression = (XExpression)theEObject;
				T result = caseXExpression(xExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case XbasePackage.XSTATMENT: {
				XStatment xStatment = (XStatment)theEObject;
				T result = caseXStatment(xStatment);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case XbasePackage.XIF_STATMENT: {
				XIfStatment xIfStatment = (XIfStatment)theEObject;
				T result = caseXIfStatment(xIfStatment);
				if (result == null) result = caseXStatment(xIfStatment);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case XbasePackage.XEXPRESSION_STATMENT: {
				XExpressionStatment xExpressionStatment = (XExpressionStatment)theEObject;
				T result = caseXExpressionStatment(xExpressionStatment);
				if (result == null) result = caseXStatment(xExpressionStatment);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case XbasePackage.XSWITCH_STATMENT: {
				XSwitchStatment xSwitchStatment = (XSwitchStatment)theEObject;
				T result = caseXSwitchStatment(xSwitchStatment);
				if (result == null) result = caseXStatment(xSwitchStatment);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case XbasePackage.XCASE_PART: {
				XCasePart xCasePart = (XCasePart)theEObject;
				T result = caseXCasePart(xCasePart);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case XbasePackage.XBLOCK_STATMENT: {
				XBlockStatment xBlockStatment = (XBlockStatment)theEObject;
				T result = caseXBlockStatment(xBlockStatment);
				if (result == null) result = caseXStatment(xBlockStatment);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case XbasePackage.XVARIABLE_DECLARATION: {
				XVariableDeclaration xVariableDeclaration = (XVariableDeclaration)theEObject;
				T result = caseXVariableDeclaration(xVariableDeclaration);
				if (result == null) result = caseXExpression(xVariableDeclaration);
				if (result == null) result = caseJvmIdentifiableElement(xVariableDeclaration);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case XbasePackage.XVARIABLE_DECLARATION_LIST: {
				XVariableDeclarationList xVariableDeclarationList = (XVariableDeclarationList)theEObject;
				T result = caseXVariableDeclarationList(xVariableDeclarationList);
				if (result == null) result = caseXStatment(xVariableDeclarationList);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case XbasePackage.XABSTRACT_FEATURE_CALL: {
				XAbstractFeatureCall xAbstractFeatureCall = (XAbstractFeatureCall)theEObject;
				T result = caseXAbstractFeatureCall(xAbstractFeatureCall);
				if (result == null) result = caseXExpression(xAbstractFeatureCall);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case XbasePackage.XMEMBER_FEATURE_CALL: {
				XMemberFeatureCall xMemberFeatureCall = (XMemberFeatureCall)theEObject;
				T result = caseXMemberFeatureCall(xMemberFeatureCall);
				if (result == null) result = caseXAbstractFeatureCall(xMemberFeatureCall);
				if (result == null) result = caseXExpression(xMemberFeatureCall);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case XbasePackage.XCALLER: {
				XCaller xCaller = (XCaller)theEObject;
				T result = caseXCaller(xCaller);
				if (result == null) result = caseXExpression(xCaller);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case XbasePackage.XINDEXER: {
				XIndexer xIndexer = (XIndexer)theEObject;
				T result = caseXIndexer(xIndexer);
				if (result == null) result = caseXExpression(xIndexer);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case XbasePackage.XFEATURE_CALL: {
				XFeatureCall xFeatureCall = (XFeatureCall)theEObject;
				T result = caseXFeatureCall(xFeatureCall);
				if (result == null) result = caseXAbstractFeatureCall(xFeatureCall);
				if (result == null) result = caseXExpression(xFeatureCall);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case XbasePackage.XCONSTRUCTOR_CALL: {
				XConstructorCall xConstructorCall = (XConstructorCall)theEObject;
				T result = caseXConstructorCall(xConstructorCall);
				if (result == null) result = caseXExpression(xConstructorCall);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case XbasePackage.XBOOLEAN_LITERAL: {
				XBooleanLiteral xBooleanLiteral = (XBooleanLiteral)theEObject;
				T result = caseXBooleanLiteral(xBooleanLiteral);
				if (result == null) result = caseXExpression(xBooleanLiteral);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case XbasePackage.XNULL_LITERAL: {
				XNullLiteral xNullLiteral = (XNullLiteral)theEObject;
				T result = caseXNullLiteral(xNullLiteral);
				if (result == null) result = caseXExpression(xNullLiteral);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case XbasePackage.XNUMBER_LITERAL: {
				XNumberLiteral xNumberLiteral = (XNumberLiteral)theEObject;
				T result = caseXNumberLiteral(xNumberLiteral);
				if (result == null) result = caseXExpression(xNumberLiteral);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case XbasePackage.XSTRING_LITERAL: {
				XStringLiteral xStringLiteral = (XStringLiteral)theEObject;
				T result = caseXStringLiteral(xStringLiteral);
				if (result == null) result = caseXExpression(xStringLiteral);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case XbasePackage.XCOLLECTION_LITERAL: {
				XCollectionLiteral xCollectionLiteral = (XCollectionLiteral)theEObject;
				T result = caseXCollectionLiteral(xCollectionLiteral);
				if (result == null) result = caseXExpression(xCollectionLiteral);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case XbasePackage.XLIST_LITERAL: {
				XListLiteral xListLiteral = (XListLiteral)theEObject;
				T result = caseXListLiteral(xListLiteral);
				if (result == null) result = caseXCollectionLiteral(xListLiteral);
				if (result == null) result = caseXExpression(xListLiteral);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case XbasePackage.XSET_LITERAL: {
				XSetLiteral xSetLiteral = (XSetLiteral)theEObject;
				T result = caseXSetLiteral(xSetLiteral);
				if (result == null) result = caseXCollectionLiteral(xSetLiteral);
				if (result == null) result = caseXExpression(xSetLiteral);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case XbasePackage.XCLOSURE: {
				XClosure xClosure = (XClosure)theEObject;
				T result = caseXClosure(xClosure);
				if (result == null) result = caseXExpression(xClosure);
				if (result == null) result = caseJvmIdentifiableElement(xClosure);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case XbasePackage.XCASTED_EXPRESSION: {
				XCastedExpression xCastedExpression = (XCastedExpression)theEObject;
				T result = caseXCastedExpression(xCastedExpression);
				if (result == null) result = caseXExpression(xCastedExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case XbasePackage.XBINARY_OPERATION: {
				XBinaryOperation xBinaryOperation = (XBinaryOperation)theEObject;
				T result = caseXBinaryOperation(xBinaryOperation);
				if (result == null) result = caseXAbstractFeatureCall(xBinaryOperation);
				if (result == null) result = caseXExpression(xBinaryOperation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case XbasePackage.XUNARY_OPERATION: {
				XUnaryOperation xUnaryOperation = (XUnaryOperation)theEObject;
				T result = caseXUnaryOperation(xUnaryOperation);
				if (result == null) result = caseXAbstractFeatureCall(xUnaryOperation);
				if (result == null) result = caseXExpression(xUnaryOperation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case XbasePackage.XFOR_LOOP_STATMENT: {
				XForLoopStatment xForLoopStatment = (XForLoopStatment)theEObject;
				T result = caseXForLoopStatment(xForLoopStatment);
				if (result == null) result = caseXStatment(xForLoopStatment);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case XbasePackage.XFOR_EACH_STATMENT: {
				XForEachStatment xForEachStatment = (XForEachStatment)theEObject;
				T result = caseXForEachStatment(xForEachStatment);
				if (result == null) result = caseXStatment(xForEachStatment);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case XbasePackage.XABSTRACT_WHILE_STATMENT: {
				XAbstractWhileStatment xAbstractWhileStatment = (XAbstractWhileStatment)theEObject;
				T result = caseXAbstractWhileStatment(xAbstractWhileStatment);
				if (result == null) result = caseXStatment(xAbstractWhileStatment);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case XbasePackage.XDO_WHILE_STATMENT: {
				XDoWhileStatment xDoWhileStatment = (XDoWhileStatment)theEObject;
				T result = caseXDoWhileStatment(xDoWhileStatment);
				if (result == null) result = caseXAbstractWhileStatment(xDoWhileStatment);
				if (result == null) result = caseXStatment(xDoWhileStatment);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case XbasePackage.XWHILE_STATMENT: {
				XWhileStatment xWhileStatment = (XWhileStatment)theEObject;
				T result = caseXWhileStatment(xWhileStatment);
				if (result == null) result = caseXAbstractWhileStatment(xWhileStatment);
				if (result == null) result = caseXStatment(xWhileStatment);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case XbasePackage.XTYPE_LITERAL: {
				XTypeLiteral xTypeLiteral = (XTypeLiteral)theEObject;
				T result = caseXTypeLiteral(xTypeLiteral);
				if (result == null) result = caseXExpression(xTypeLiteral);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case XbasePackage.XINSTANCE_OF_EXPRESSION: {
				XInstanceOfExpression xInstanceOfExpression = (XInstanceOfExpression)theEObject;
				T result = caseXInstanceOfExpression(xInstanceOfExpression);
				if (result == null) result = caseXExpression(xInstanceOfExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case XbasePackage.XTHROW_STATMENT: {
				XThrowStatment xThrowStatment = (XThrowStatment)theEObject;
				T result = caseXThrowStatment(xThrowStatment);
				if (result == null) result = caseXStatment(xThrowStatment);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case XbasePackage.XTRY_CATCH_FINALLY_STATMENT: {
				XTryCatchFinallyStatment xTryCatchFinallyStatment = (XTryCatchFinallyStatment)theEObject;
				T result = caseXTryCatchFinallyStatment(xTryCatchFinallyStatment);
				if (result == null) result = caseXStatment(xTryCatchFinallyStatment);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case XbasePackage.XCATCH_CLAUSE: {
				XCatchClause xCatchClause = (XCatchClause)theEObject;
				T result = caseXCatchClause(xCatchClause);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case XbasePackage.XASSIGNMENT: {
				XAssignment xAssignment = (XAssignment)theEObject;
				T result = caseXAssignment(xAssignment);
				if (result == null) result = caseXAbstractFeatureCall(xAssignment);
				if (result == null) result = caseXExpression(xAssignment);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case XbasePackage.XRETURN_STATMENT: {
				XReturnStatment xReturnStatment = (XReturnStatment)theEObject;
				T result = caseXReturnStatment(xReturnStatment);
				if (result == null) result = caseXStatment(xReturnStatment);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case XbasePackage.XBREAK_STATMENT: {
				XBreakStatment xBreakStatment = (XBreakStatment)theEObject;
				T result = caseXBreakStatment(xBreakStatment);
				if (result == null) result = caseXStatment(xBreakStatment);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case XbasePackage.XCONTINUE_STATMENT: {
				XContinueStatment xContinueStatment = (XContinueStatment)theEObject;
				T result = caseXContinueStatment(xContinueStatment);
				if (result == null) result = caseXStatment(xContinueStatment);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case XbasePackage.XPOSTFIX_OPERATION: {
				XPostfixOperation xPostfixOperation = (XPostfixOperation)theEObject;
				T result = caseXPostfixOperation(xPostfixOperation);
				if (result == null) result = caseXAbstractFeatureCall(xPostfixOperation);
				if (result == null) result = caseXExpression(xPostfixOperation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case XbasePackage.XTERNARY_OPERATION: {
				XTernaryOperation xTernaryOperation = (XTernaryOperation)theEObject;
				T result = caseXTernaryOperation(xTernaryOperation);
				if (result == null) result = caseXExpression(xTernaryOperation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case XbasePackage.XOBJECT_LITERAL: {
				XObjectLiteral xObjectLiteral = (XObjectLiteral)theEObject;
				T result = caseXObjectLiteral(xObjectLiteral);
				if (result == null) result = caseJvmDeclaredType(xObjectLiteral);
				if (result == null) result = caseXExpression(xObjectLiteral);
				if (result == null) result = caseJvmMember(xObjectLiteral);
				if (result == null) result = caseJvmComponentType(xObjectLiteral);
				if (result == null) result = caseJvmAnnotationTarget(xObjectLiteral);
				if (result == null) result = caseJvmType(xObjectLiteral);
				if (result == null) result = caseJvmIdentifiableElement(xObjectLiteral);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case XbasePackage.XOBJECT_LITERAL_PART: {
				XObjectLiteralPart xObjectLiteralPart = (XObjectLiteralPart)theEObject;
				T result = caseXObjectLiteralPart(xObjectLiteralPart);
				if (result == null) result = caseJvmField(xObjectLiteralPart);
				if (result == null) result = caseJvmFeature(xObjectLiteralPart);
				if (result == null) result = caseJvmMember(xObjectLiteralPart);
				if (result == null) result = caseJvmAnnotationTarget(xObjectLiteralPart);
				if (result == null) result = caseJvmIdentifiableElement(xObjectLiteralPart);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case XbasePackage.XARRAY_LITERAL: {
				XArrayLiteral xArrayLiteral = (XArrayLiteral)theEObject;
				T result = caseXArrayLiteral(xArrayLiteral);
				if (result == null) result = caseXExpression(xArrayLiteral);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case XbasePackage.XSTRUCT_LITERAL: {
				XStructLiteral xStructLiteral = (XStructLiteral)theEObject;
				T result = caseXStructLiteral(xStructLiteral);
				if (result == null) result = caseXExpression(xStructLiteral);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case XbasePackage.XFIELD_LITERAL_PART: {
				XFieldLiteralPart xFieldLiteralPart = (XFieldLiteralPart)theEObject;
				T result = caseXFieldLiteralPart(xFieldLiteralPart);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case XbasePackage.XTEMPLATE: {
				XTemplate xTemplate = (XTemplate)theEObject;
				T result = caseXTemplate(xTemplate);
				if (result == null) result = caseXExpression(xTemplate);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case XbasePackage.RICH_STRING_LITERAL: {
				RichStringLiteral richStringLiteral = (RichStringLiteral)theEObject;
				T result = caseRichStringLiteral(richStringLiteral);
				if (result == null) result = caseXStringLiteral(richStringLiteral);
				if (result == null) result = caseXExpression(richStringLiteral);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case XbasePackage.XFUNCTION_DECLARATION: {
				XFunctionDeclaration xFunctionDeclaration = (XFunctionDeclaration)theEObject;
				T result = caseXFunctionDeclaration(xFunctionDeclaration);
				if (result == null) result = caseJvmTypeParameterDeclarator(xFunctionDeclaration);
				if (result == null) result = caseXStatment(xFunctionDeclaration);
				if (result == null) result = caseJvmIdentifiableElement(xFunctionDeclaration);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>XExpression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>XExpression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseXExpression(XExpression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>XStatment</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>XStatment</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseXStatment(XStatment object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>XIf Statment</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>XIf Statment</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseXIfStatment(XIfStatment object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>XExpression Statment</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>XExpression Statment</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseXExpressionStatment(XExpressionStatment object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>XSwitch Statment</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>XSwitch Statment</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseXSwitchStatment(XSwitchStatment object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>XCase Part</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>XCase Part</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseXCasePart(XCasePart object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>XBlock Statment</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>XBlock Statment</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseXBlockStatment(XBlockStatment object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>XVariable Declaration</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>XVariable Declaration</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseXVariableDeclaration(XVariableDeclaration object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>XVariable Declaration List</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>XVariable Declaration List</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseXVariableDeclarationList(XVariableDeclarationList object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>XAbstract Feature Call</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>XAbstract Feature Call</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseXAbstractFeatureCall(XAbstractFeatureCall object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>XMember Feature Call</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>XMember Feature Call</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseXMemberFeatureCall(XMemberFeatureCall object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>XCaller</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>XCaller</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseXCaller(XCaller object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>XIndexer</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>XIndexer</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseXIndexer(XIndexer object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>XFeature Call</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>XFeature Call</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseXFeatureCall(XFeatureCall object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>XConstructor Call</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>XConstructor Call</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseXConstructorCall(XConstructorCall object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>XBoolean Literal</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>XBoolean Literal</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseXBooleanLiteral(XBooleanLiteral object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>XNull Literal</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>XNull Literal</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseXNullLiteral(XNullLiteral object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>XNumber Literal</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>XNumber Literal</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseXNumberLiteral(XNumberLiteral object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>XString Literal</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>XString Literal</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseXStringLiteral(XStringLiteral object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>XCollection Literal</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>XCollection Literal</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseXCollectionLiteral(XCollectionLiteral object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>XList Literal</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>XList Literal</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseXListLiteral(XListLiteral object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>XSet Literal</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>XSet Literal</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseXSetLiteral(XSetLiteral object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>XClosure</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>XClosure</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseXClosure(XClosure object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>XCasted Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>XCasted Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseXCastedExpression(XCastedExpression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>XBinary Operation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>XBinary Operation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseXBinaryOperation(XBinaryOperation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>XUnary Operation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>XUnary Operation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseXUnaryOperation(XUnaryOperation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>XFor Loop Statment</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>XFor Loop Statment</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseXForLoopStatment(XForLoopStatment object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>XFor Each Statment</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>XFor Each Statment</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseXForEachStatment(XForEachStatment object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>XAbstract While Statment</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>XAbstract While Statment</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseXAbstractWhileStatment(XAbstractWhileStatment object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>XDo While Statment</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>XDo While Statment</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseXDoWhileStatment(XDoWhileStatment object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>XWhile Statment</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>XWhile Statment</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseXWhileStatment(XWhileStatment object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>XType Literal</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>XType Literal</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseXTypeLiteral(XTypeLiteral object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>XInstance Of Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>XInstance Of Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseXInstanceOfExpression(XInstanceOfExpression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>XThrow Statment</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>XThrow Statment</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseXThrowStatment(XThrowStatment object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>XTry Catch Finally Statment</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>XTry Catch Finally Statment</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseXTryCatchFinallyStatment(XTryCatchFinallyStatment object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>XCatch Clause</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>XCatch Clause</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseXCatchClause(XCatchClause object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>XAssignment</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>XAssignment</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseXAssignment(XAssignment object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>XReturn Statment</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>XReturn Statment</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseXReturnStatment(XReturnStatment object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>XBreak Statment</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>XBreak Statment</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseXBreakStatment(XBreakStatment object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>XContinue Statment</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>XContinue Statment</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseXContinueStatment(XContinueStatment object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>XPostfix Operation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>XPostfix Operation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseXPostfixOperation(XPostfixOperation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>XTernary Operation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>XTernary Operation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseXTernaryOperation(XTernaryOperation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>XFunction Declaration</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>XFunction Declaration</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseXFunctionDeclaration(XFunctionDeclaration object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>XObject Literal</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>XObject Literal</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseXObjectLiteral(XObjectLiteral object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>XObject Literal Part</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>XObject Literal Part</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseXObjectLiteralPart(XObjectLiteralPart object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>XArray Literal</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>XArray Literal</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseXArrayLiteral(XArrayLiteral object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>XStruct Literal</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>XStruct Literal</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseXStructLiteral(XStructLiteral object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>XField Literal Part</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>XField Literal Part</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseXFieldLiteralPart(XFieldLiteralPart object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>XTemplate</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>XTemplate</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseXTemplate(XTemplate object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Rich String Literal</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Rich String Literal</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRichStringLiteral(RichStringLiteral object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Jvm Identifiable Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Jvm Identifiable Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseJvmIdentifiableElement(JvmIdentifiableElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Jvm Annotation Target</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Jvm Annotation Target</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseJvmAnnotationTarget(JvmAnnotationTarget object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Jvm Member</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Jvm Member</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseJvmMember(JvmMember object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Jvm Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Jvm Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseJvmType(JvmType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Jvm Component Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Jvm Component Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseJvmComponentType(JvmComponentType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Jvm Declared Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Jvm Declared Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseJvmDeclaredType(JvmDeclaredType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Jvm Feature</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Jvm Feature</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseJvmFeature(JvmFeature object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Jvm Field</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Jvm Field</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseJvmField(JvmField object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Jvm Type Parameter Declarator</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Jvm Type Parameter Declarator</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseJvmTypeParameterDeclarator(JvmTypeParameterDeclarator object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	@Override
	public T defaultCase(EObject object) {
		return null;
	}

} //XbaseSwitch
