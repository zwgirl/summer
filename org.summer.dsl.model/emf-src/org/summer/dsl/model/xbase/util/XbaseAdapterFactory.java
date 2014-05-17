/**
 */
package org.summer.dsl.model.xbase.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;
import org.eclipse.emf.ecore.EObject;
import org.summer.dsl.model.types.JvmAnnotationTarget;
import org.summer.dsl.model.types.JvmComponentType;
import org.summer.dsl.model.types.JvmDeclaredType;
import org.summer.dsl.model.types.JvmFeature;
import org.summer.dsl.model.types.JvmField;
import org.summer.dsl.model.types.JvmIdentifiableElement;
import org.summer.dsl.model.types.JvmMember;
import org.summer.dsl.model.types.JvmType;
import org.summer.dsl.model.xbase.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see org.summer.dsl.model.xbase.XbasePackage
 * @generated
 */
public class XbaseAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static XbasePackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public XbaseAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = XbasePackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected XbaseSwitch<Adapter> modelSwitch =
		new XbaseSwitch<Adapter>() {
			@Override
			public Adapter caseXExpression(XExpression object) {
				return createXExpressionAdapter();
			}
			@Override
			public Adapter caseXIfExpression(XIfExpression object) {
				return createXIfExpressionAdapter();
			}
			@Override
			public Adapter caseXSwitchExpression(XSwitchExpression object) {
				return createXSwitchExpressionAdapter();
			}
			@Override
			public Adapter caseXCasePart(XCasePart object) {
				return createXCasePartAdapter();
			}
			@Override
			public Adapter caseXBlockExpression(XBlockExpression object) {
				return createXBlockExpressionAdapter();
			}
			@Override
			public Adapter caseXVariableDeclaration(XVariableDeclaration object) {
				return createXVariableDeclarationAdapter();
			}
			@Override
			public Adapter caseXVariableDeclarationList(XVariableDeclarationList object) {
				return createXVariableDeclarationListAdapter();
			}
			@Override
			public Adapter caseXAbstractFeatureCall(XAbstractFeatureCall object) {
				return createXAbstractFeatureCallAdapter();
			}
			@Override
			public Adapter caseXMemberFeatureCall(XMemberFeatureCall object) {
				return createXMemberFeatureCallAdapter();
			}
			@Override
			public Adapter caseXMemberFeatureCall1(XMemberFeatureCall1 object) {
				return createXMemberFeatureCall1Adapter();
			}
			@Override
			public Adapter caseXFeatureCall(XFeatureCall object) {
				return createXFeatureCallAdapter();
			}
			@Override
			public Adapter caseXConstructorCall(XConstructorCall object) {
				return createXConstructorCallAdapter();
			}
			@Override
			public Adapter caseXBooleanLiteral(XBooleanLiteral object) {
				return createXBooleanLiteralAdapter();
			}
			@Override
			public Adapter caseXNullLiteral(XNullLiteral object) {
				return createXNullLiteralAdapter();
			}
			@Override
			public Adapter caseXNumberLiteral(XNumberLiteral object) {
				return createXNumberLiteralAdapter();
			}
			@Override
			public Adapter caseXStringLiteral(XStringLiteral object) {
				return createXStringLiteralAdapter();
			}
			@Override
			public Adapter caseXCollectionLiteral(XCollectionLiteral object) {
				return createXCollectionLiteralAdapter();
			}
			@Override
			public Adapter caseXListLiteral(XListLiteral object) {
				return createXListLiteralAdapter();
			}
			@Override
			public Adapter caseXKeyValuePair(XKeyValuePair object) {
				return createXKeyValuePairAdapter();
			}
			@Override
			public Adapter caseXSetLiteral(XSetLiteral object) {
				return createXSetLiteralAdapter();
			}
			@Override
			public Adapter caseXClosure(XClosure object) {
				return createXClosureAdapter();
			}
			@Override
			public Adapter caseXCastedExpression(XCastedExpression object) {
				return createXCastedExpressionAdapter();
			}
			@Override
			public Adapter caseXBinaryOperation(XBinaryOperation object) {
				return createXBinaryOperationAdapter();
			}
			@Override
			public Adapter caseXUnaryOperation(XUnaryOperation object) {
				return createXUnaryOperationAdapter();
			}
			@Override
			public Adapter caseXForLoopExpression(XForLoopExpression object) {
				return createXForLoopExpressionAdapter();
			}
			@Override
			public Adapter caseXForEachExpression(XForEachExpression object) {
				return createXForEachExpressionAdapter();
			}
			@Override
			public Adapter caseXAbstractWhileExpression(XAbstractWhileExpression object) {
				return createXAbstractWhileExpressionAdapter();
			}
			@Override
			public Adapter caseXDoWhileExpression(XDoWhileExpression object) {
				return createXDoWhileExpressionAdapter();
			}
			@Override
			public Adapter caseXWhileExpression(XWhileExpression object) {
				return createXWhileExpressionAdapter();
			}
			@Override
			public Adapter caseXTypeLiteral(XTypeLiteral object) {
				return createXTypeLiteralAdapter();
			}
			@Override
			public Adapter caseXInstanceOfExpression(XInstanceOfExpression object) {
				return createXInstanceOfExpressionAdapter();
			}
			@Override
			public Adapter caseXThrowExpression(XThrowExpression object) {
				return createXThrowExpressionAdapter();
			}
			@Override
			public Adapter caseXTryCatchFinallyExpression(XTryCatchFinallyExpression object) {
				return createXTryCatchFinallyExpressionAdapter();
			}
			@Override
			public Adapter caseXCatchClause(XCatchClause object) {
				return createXCatchClauseAdapter();
			}
			@Override
			public Adapter caseXAssignment(XAssignment object) {
				return createXAssignmentAdapter();
			}
			@Override
			public Adapter caseXReturnExpression(XReturnExpression object) {
				return createXReturnExpressionAdapter();
			}
			@Override
			public Adapter caseXBreakExpression(XBreakExpression object) {
				return createXBreakExpressionAdapter();
			}
			@Override
			public Adapter caseXContinueExpression(XContinueExpression object) {
				return createXContinueExpressionAdapter();
			}
			@Override
			public Adapter caseXPostfixOperation(XPostfixOperation object) {
				return createXPostfixOperationAdapter();
			}
			@Override
			public Adapter caseXTernaryOperation(XTernaryOperation object) {
				return createXTernaryOperationAdapter();
			}
			@Override
			public Adapter caseXIndexOperation(XIndexOperation object) {
				return createXIndexOperationAdapter();
			}
			@Override
			public Adapter caseXFunctionDeclaration(XFunctionDeclaration object) {
				return createXFunctionDeclarationAdapter();
			}
			@Override
			public Adapter caseXObjectLiteral(XObjectLiteral object) {
				return createXObjectLiteralAdapter();
			}
			@Override
			public Adapter caseXObjectLiteralPart(XObjectLiteralPart object) {
				return createXObjectLiteralPartAdapter();
			}
			@Override
			public Adapter caseXArrayLiteral(XArrayLiteral object) {
				return createXArrayLiteralAdapter();
			}
			@Override
			public Adapter caseXStructLiteral(XStructLiteral object) {
				return createXStructLiteralAdapter();
			}
			@Override
			public Adapter caseXFieldLiteralPart(XFieldLiteralPart object) {
				return createXFieldLiteralPartAdapter();
			}
			@Override
			public Adapter caseXTemplate(XTemplate object) {
				return createXTemplateAdapter();
			}
			@Override
			public Adapter caseRichStringLiteral(RichStringLiteral object) {
				return createRichStringLiteralAdapter();
			}
			@Override
			public Adapter caseJvmIdentifiableElement(JvmIdentifiableElement object) {
				return createJvmIdentifiableElementAdapter();
			}
			@Override
			public Adapter caseJvmAnnotationTarget(JvmAnnotationTarget object) {
				return createJvmAnnotationTargetAdapter();
			}
			@Override
			public Adapter caseJvmMember(JvmMember object) {
				return createJvmMemberAdapter();
			}
			@Override
			public Adapter caseJvmType(JvmType object) {
				return createJvmTypeAdapter();
			}
			@Override
			public Adapter caseJvmComponentType(JvmComponentType object) {
				return createJvmComponentTypeAdapter();
			}
			@Override
			public Adapter caseJvmDeclaredType(JvmDeclaredType object) {
				return createJvmDeclaredTypeAdapter();
			}
			@Override
			public Adapter caseJvmFeature(JvmFeature object) {
				return createJvmFeatureAdapter();
			}
			@Override
			public Adapter caseJvmField(JvmField object) {
				return createJvmFieldAdapter();
			}
			@Override
			public Adapter defaultCase(EObject object) {
				return createEObjectAdapter();
			}
		};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject)target);
	}


	/**
	 * Creates a new adapter for an object of class '{@link org.summer.dsl.model.xbase.XExpression <em>XExpression</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.summer.dsl.model.xbase.XExpression
	 * @generated
	 */
	public Adapter createXExpressionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.summer.dsl.model.xbase.XIfExpression <em>XIf Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.summer.dsl.model.xbase.XIfExpression
	 * @generated
	 */
	public Adapter createXIfExpressionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.summer.dsl.model.xbase.XSwitchExpression <em>XSwitch Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.summer.dsl.model.xbase.XSwitchExpression
	 * @generated
	 */
	public Adapter createXSwitchExpressionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.summer.dsl.model.xbase.XCasePart <em>XCase Part</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.summer.dsl.model.xbase.XCasePart
	 * @generated
	 */
	public Adapter createXCasePartAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.summer.dsl.model.xbase.XBlockExpression <em>XBlock Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.summer.dsl.model.xbase.XBlockExpression
	 * @generated
	 */
	public Adapter createXBlockExpressionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.summer.dsl.model.xbase.XVariableDeclaration <em>XVariable Declaration</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.summer.dsl.model.xbase.XVariableDeclaration
	 * @generated
	 */
	public Adapter createXVariableDeclarationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.summer.dsl.model.xbase.XVariableDeclarationList <em>XVariable Declaration List</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.summer.dsl.model.xbase.XVariableDeclarationList
	 * @generated
	 */
	public Adapter createXVariableDeclarationListAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.summer.dsl.model.xbase.XAbstractFeatureCall <em>XAbstract Feature Call</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.summer.dsl.model.xbase.XAbstractFeatureCall
	 * @generated
	 */
	public Adapter createXAbstractFeatureCallAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.summer.dsl.model.xbase.XMemberFeatureCall <em>XMember Feature Call</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.summer.dsl.model.xbase.XMemberFeatureCall
	 * @generated
	 */
	public Adapter createXMemberFeatureCallAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.summer.dsl.model.xbase.XMemberFeatureCall1 <em>XMember Feature Call1</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.summer.dsl.model.xbase.XMemberFeatureCall1
	 * @generated
	 */
	public Adapter createXMemberFeatureCall1Adapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.summer.dsl.model.xbase.XFeatureCall <em>XFeature Call</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.summer.dsl.model.xbase.XFeatureCall
	 * @generated
	 */
	public Adapter createXFeatureCallAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.summer.dsl.model.xbase.XConstructorCall <em>XConstructor Call</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.summer.dsl.model.xbase.XConstructorCall
	 * @generated
	 */
	public Adapter createXConstructorCallAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.summer.dsl.model.xbase.XBooleanLiteral <em>XBoolean Literal</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.summer.dsl.model.xbase.XBooleanLiteral
	 * @generated
	 */
	public Adapter createXBooleanLiteralAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.summer.dsl.model.xbase.XNullLiteral <em>XNull Literal</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.summer.dsl.model.xbase.XNullLiteral
	 * @generated
	 */
	public Adapter createXNullLiteralAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.summer.dsl.model.xbase.XNumberLiteral <em>XNumber Literal</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.summer.dsl.model.xbase.XNumberLiteral
	 * @generated
	 */
	public Adapter createXNumberLiteralAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.summer.dsl.model.xbase.XStringLiteral <em>XString Literal</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.summer.dsl.model.xbase.XStringLiteral
	 * @generated
	 */
	public Adapter createXStringLiteralAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.summer.dsl.model.xbase.XCollectionLiteral <em>XCollection Literal</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.summer.dsl.model.xbase.XCollectionLiteral
	 * @generated
	 */
	public Adapter createXCollectionLiteralAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.summer.dsl.model.xbase.XListLiteral <em>XList Literal</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.summer.dsl.model.xbase.XListLiteral
	 * @generated
	 */
	public Adapter createXListLiteralAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.summer.dsl.model.xbase.XKeyValuePair <em>XKey Value Pair</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.summer.dsl.model.xbase.XKeyValuePair
	 * @generated
	 */
	public Adapter createXKeyValuePairAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.summer.dsl.model.xbase.XSetLiteral <em>XSet Literal</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.summer.dsl.model.xbase.XSetLiteral
	 * @generated
	 */
	public Adapter createXSetLiteralAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.summer.dsl.model.xbase.XClosure <em>XClosure</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.summer.dsl.model.xbase.XClosure
	 * @generated
	 */
	public Adapter createXClosureAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.summer.dsl.model.xbase.XCastedExpression <em>XCasted Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.summer.dsl.model.xbase.XCastedExpression
	 * @generated
	 */
	public Adapter createXCastedExpressionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.summer.dsl.model.xbase.XBinaryOperation <em>XBinary Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.summer.dsl.model.xbase.XBinaryOperation
	 * @generated
	 */
	public Adapter createXBinaryOperationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.summer.dsl.model.xbase.XUnaryOperation <em>XUnary Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.summer.dsl.model.xbase.XUnaryOperation
	 * @generated
	 */
	public Adapter createXUnaryOperationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.summer.dsl.model.xbase.XForLoopExpression <em>XFor Loop Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.summer.dsl.model.xbase.XForLoopExpression
	 * @generated
	 */
	public Adapter createXForLoopExpressionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.summer.dsl.model.xbase.XForEachExpression <em>XFor Each Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.summer.dsl.model.xbase.XForEachExpression
	 * @generated
	 */
	public Adapter createXForEachExpressionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.summer.dsl.model.xbase.XAbstractWhileExpression <em>XAbstract While Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.summer.dsl.model.xbase.XAbstractWhileExpression
	 * @generated
	 */
	public Adapter createXAbstractWhileExpressionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.summer.dsl.model.xbase.XDoWhileExpression <em>XDo While Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.summer.dsl.model.xbase.XDoWhileExpression
	 * @generated
	 */
	public Adapter createXDoWhileExpressionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.summer.dsl.model.xbase.XWhileExpression <em>XWhile Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.summer.dsl.model.xbase.XWhileExpression
	 * @generated
	 */
	public Adapter createXWhileExpressionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.summer.dsl.model.xbase.XTypeLiteral <em>XType Literal</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.summer.dsl.model.xbase.XTypeLiteral
	 * @generated
	 */
	public Adapter createXTypeLiteralAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.summer.dsl.model.xbase.XInstanceOfExpression <em>XInstance Of Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.summer.dsl.model.xbase.XInstanceOfExpression
	 * @generated
	 */
	public Adapter createXInstanceOfExpressionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.summer.dsl.model.xbase.XThrowExpression <em>XThrow Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.summer.dsl.model.xbase.XThrowExpression
	 * @generated
	 */
	public Adapter createXThrowExpressionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.summer.dsl.model.xbase.XTryCatchFinallyExpression <em>XTry Catch Finally Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.summer.dsl.model.xbase.XTryCatchFinallyExpression
	 * @generated
	 */
	public Adapter createXTryCatchFinallyExpressionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.summer.dsl.model.xbase.XCatchClause <em>XCatch Clause</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.summer.dsl.model.xbase.XCatchClause
	 * @generated
	 */
	public Adapter createXCatchClauseAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.summer.dsl.model.xbase.XAssignment <em>XAssignment</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.summer.dsl.model.xbase.XAssignment
	 * @generated
	 */
	public Adapter createXAssignmentAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.summer.dsl.model.xbase.XReturnExpression <em>XReturn Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.summer.dsl.model.xbase.XReturnExpression
	 * @generated
	 */
	public Adapter createXReturnExpressionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.summer.dsl.model.xbase.XBreakExpression <em>XBreak Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.summer.dsl.model.xbase.XBreakExpression
	 * @generated
	 */
	public Adapter createXBreakExpressionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.summer.dsl.model.xbase.XContinueExpression <em>XContinue Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.summer.dsl.model.xbase.XContinueExpression
	 * @generated
	 */
	public Adapter createXContinueExpressionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.summer.dsl.model.xbase.XPostfixOperation <em>XPostfix Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.summer.dsl.model.xbase.XPostfixOperation
	 * @generated
	 */
	public Adapter createXPostfixOperationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.summer.dsl.model.xbase.XTernaryOperation <em>XTernary Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.summer.dsl.model.xbase.XTernaryOperation
	 * @generated
	 */
	public Adapter createXTernaryOperationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.summer.dsl.model.xbase.XIndexOperation <em>XIndex Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.summer.dsl.model.xbase.XIndexOperation
	 * @generated
	 */
	public Adapter createXIndexOperationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.summer.dsl.model.xbase.XFunctionDeclaration <em>XFunction Declaration</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.summer.dsl.model.xbase.XFunctionDeclaration
	 * @generated
	 */
	public Adapter createXFunctionDeclarationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.summer.dsl.model.xbase.XObjectLiteral <em>XObject Literal</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.summer.dsl.model.xbase.XObjectLiteral
	 * @generated
	 */
	public Adapter createXObjectLiteralAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.summer.dsl.model.xbase.XObjectLiteralPart <em>XObject Literal Part</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.summer.dsl.model.xbase.XObjectLiteralPart
	 * @generated
	 */
	public Adapter createXObjectLiteralPartAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.summer.dsl.model.xbase.XArrayLiteral <em>XArray Literal</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.summer.dsl.model.xbase.XArrayLiteral
	 * @generated
	 */
	public Adapter createXArrayLiteralAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.summer.dsl.model.xbase.XStructLiteral <em>XStruct Literal</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.summer.dsl.model.xbase.XStructLiteral
	 * @generated
	 */
	public Adapter createXStructLiteralAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.summer.dsl.model.xbase.XFieldLiteralPart <em>XField Literal Part</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.summer.dsl.model.xbase.XFieldLiteralPart
	 * @generated
	 */
	public Adapter createXFieldLiteralPartAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.summer.dsl.model.xbase.XTemplate <em>XTemplate</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.summer.dsl.model.xbase.XTemplate
	 * @generated
	 */
	public Adapter createXTemplateAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.summer.dsl.model.xbase.RichStringLiteral <em>Rich String Literal</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.summer.dsl.model.xbase.RichStringLiteral
	 * @generated
	 */
	public Adapter createRichStringLiteralAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.summer.dsl.model.types.JvmIdentifiableElement <em>Jvm Identifiable Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.summer.dsl.model.types.JvmIdentifiableElement
	 * @generated
	 */
	public Adapter createJvmIdentifiableElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.summer.dsl.model.types.JvmAnnotationTarget <em>Jvm Annotation Target</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.summer.dsl.model.types.JvmAnnotationTarget
	 * @generated
	 */
	public Adapter createJvmAnnotationTargetAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.summer.dsl.model.types.JvmMember <em>Jvm Member</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.summer.dsl.model.types.JvmMember
	 * @generated
	 */
	public Adapter createJvmMemberAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.summer.dsl.model.types.JvmType <em>Jvm Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.summer.dsl.model.types.JvmType
	 * @generated
	 */
	public Adapter createJvmTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.summer.dsl.model.types.JvmComponentType <em>Jvm Component Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.summer.dsl.model.types.JvmComponentType
	 * @generated
	 */
	public Adapter createJvmComponentTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.summer.dsl.model.types.JvmDeclaredType <em>Jvm Declared Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.summer.dsl.model.types.JvmDeclaredType
	 * @generated
	 */
	public Adapter createJvmDeclaredTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.summer.dsl.model.types.JvmFeature <em>Jvm Feature</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.summer.dsl.model.types.JvmFeature
	 * @generated
	 */
	public Adapter createJvmFeatureAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.summer.dsl.model.types.JvmField <em>Jvm Field</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.summer.dsl.model.types.JvmField
	 * @generated
	 */
	public Adapter createJvmFieldAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} //XbaseAdapterFactory
