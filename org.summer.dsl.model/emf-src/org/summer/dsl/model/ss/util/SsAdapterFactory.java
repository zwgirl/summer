/**
 */
package org.summer.dsl.model.ss.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;
import org.eclipse.emf.ecore.EObject;
import org.summer.dsl.model.ss.*;
import org.summer.dsl.model.types.JvmAnnotationTarget;
import org.summer.dsl.model.types.JvmFormalParameter;
import org.summer.dsl.model.types.JvmIdentifiableElement;
import org.summer.dsl.model.xbase.XBlockExpression;
import org.summer.dsl.model.xbase.XExpression;
import org.summer.dsl.model.xbase.XForEachExpression;
import org.summer.dsl.model.xbase.XStringLiteral;
import org.summer.dsl.model.xbase.XVariableDeclaration;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see org.summer.dsl.model.ss.SsPackage
 * @generated
 */
public class SsAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static SsPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SsAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = SsPackage.eINSTANCE;
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
	protected SsSwitch<Adapter> modelSwitch =
		new SsSwitch<Adapter>() {
			@Override
			public Adapter caseXtendFile(XtendFile object) {
				return createXtendFileAdapter();
			}
			@Override
			public Adapter caseXtendClass(XtendClass object) {
				return createXtendClassAdapter();
			}
			@Override
			public Adapter caseXtendAnnotationTarget(XtendAnnotationTarget object) {
				return createXtendAnnotationTargetAdapter();
			}
			@Override
			public Adapter caseXtendMember(XtendMember object) {
				return createXtendMemberAdapter();
			}
			@Override
			public Adapter caseXtendFunction(XtendFunction object) {
				return createXtendFunctionAdapter();
			}
			@Override
			public Adapter caseXtendField(XtendField object) {
				return createXtendFieldAdapter();
			}
			@Override
			public Adapter caseXtendParameter(XtendParameter object) {
				return createXtendParameterAdapter();
			}
			@Override
			public Adapter caseRichString(RichString object) {
				return createRichStringAdapter();
			}
			@Override
			public Adapter caseRichStringLiteral(RichStringLiteral object) {
				return createRichStringLiteralAdapter();
			}
			@Override
			public Adapter caseRichStringForLoop(RichStringForLoop object) {
				return createRichStringForLoopAdapter();
			}
			@Override
			public Adapter caseRichStringIf(RichStringIf object) {
				return createRichStringIfAdapter();
			}
			@Override
			public Adapter caseRichStringElseIf(RichStringElseIf object) {
				return createRichStringElseIfAdapter();
			}
			@Override
			public Adapter caseCreateExtensionInfo(CreateExtensionInfo object) {
				return createCreateExtensionInfoAdapter();
			}
			@Override
			public Adapter caseXtendConstructor(XtendConstructor object) {
				return createXtendConstructorAdapter();
			}
			@Override
			public Adapter caseXtendTypeDeclaration(XtendTypeDeclaration object) {
				return createXtendTypeDeclarationAdapter();
			}
			@Override
			public Adapter caseXtendAnnotationType(XtendAnnotationType object) {
				return createXtendAnnotationTypeAdapter();
			}
			@Override
			public Adapter caseXtendInterface(XtendInterface object) {
				return createXtendInterfaceAdapter();
			}
			@Override
			public Adapter caseXtendEnum(XtendEnum object) {
				return createXtendEnumAdapter();
			}
			@Override
			public Adapter caseXtendEnumLiteral(XtendEnumLiteral object) {
				return createXtendEnumLiteralAdapter();
			}
			@Override
			public Adapter caseXtendVariableDeclaration(XtendVariableDeclaration object) {
				return createXtendVariableDeclarationAdapter();
			}
			@Override
			public Adapter caseXtendFormalParameter(XtendFormalParameter object) {
				return createXtendFormalParameterAdapter();
			}
			@Override
			public Adapter caseXtendDelegate(XtendDelegate object) {
				return createXtendDelegateAdapter();
			}
			@Override
			public Adapter caseXtendEvent(XtendEvent object) {
				return createXtendEventAdapter();
			}
			@Override
			public Adapter caseXExpression(XExpression object) {
				return createXExpressionAdapter();
			}
			@Override
			public Adapter caseXBlockExpression(XBlockExpression object) {
				return createXBlockExpressionAdapter();
			}
			@Override
			public Adapter caseXStringLiteral(XStringLiteral object) {
				return createXStringLiteralAdapter();
			}
			@Override
			public Adapter caseXForEachExpression(XForEachExpression object) {
				return createXForEachExpressionAdapter();
			}
			@Override
			public Adapter caseJvmIdentifiableElement(JvmIdentifiableElement object) {
				return createJvmIdentifiableElementAdapter();
			}
			@Override
			public Adapter caseXVariableDeclaration(XVariableDeclaration object) {
				return createXVariableDeclarationAdapter();
			}
			@Override
			public Adapter caseJvmAnnotationTarget(JvmAnnotationTarget object) {
				return createJvmAnnotationTargetAdapter();
			}
			@Override
			public Adapter caseJvmFormalParameter(JvmFormalParameter object) {
				return createJvmFormalParameterAdapter();
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
	 * Creates a new adapter for an object of class '{@link org.summer.dsl.model.ss.XtendFile <em>Xtend File</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.summer.dsl.model.ss.XtendFile
	 * @generated
	 */
	public Adapter createXtendFileAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.summer.dsl.model.ss.XtendClass <em>Xtend Class</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.summer.dsl.model.ss.XtendClass
	 * @generated
	 */
	public Adapter createXtendClassAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.summer.dsl.model.ss.XtendAnnotationTarget <em>Xtend Annotation Target</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.summer.dsl.model.ss.XtendAnnotationTarget
	 * @generated
	 */
	public Adapter createXtendAnnotationTargetAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.summer.dsl.model.ss.XtendMember <em>Xtend Member</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.summer.dsl.model.ss.XtendMember
	 * @generated
	 */
	public Adapter createXtendMemberAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.summer.dsl.model.ss.XtendFunction <em>Xtend Function</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.summer.dsl.model.ss.XtendFunction
	 * @generated
	 */
	public Adapter createXtendFunctionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.summer.dsl.model.ss.XtendField <em>Xtend Field</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.summer.dsl.model.ss.XtendField
	 * @generated
	 */
	public Adapter createXtendFieldAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.summer.dsl.model.ss.XtendParameter <em>Xtend Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.summer.dsl.model.ss.XtendParameter
	 * @generated
	 */
	public Adapter createXtendParameterAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.summer.dsl.model.ss.RichString <em>Rich String</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.summer.dsl.model.ss.RichString
	 * @generated
	 */
	public Adapter createRichStringAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.summer.dsl.model.ss.RichStringLiteral <em>Rich String Literal</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.summer.dsl.model.ss.RichStringLiteral
	 * @generated
	 */
	public Adapter createRichStringLiteralAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.summer.dsl.model.ss.RichStringForLoop <em>Rich String For Loop</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.summer.dsl.model.ss.RichStringForLoop
	 * @generated
	 */
	public Adapter createRichStringForLoopAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.summer.dsl.model.ss.RichStringIf <em>Rich String If</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.summer.dsl.model.ss.RichStringIf
	 * @generated
	 */
	public Adapter createRichStringIfAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.summer.dsl.model.ss.RichStringElseIf <em>Rich String Else If</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.summer.dsl.model.ss.RichStringElseIf
	 * @generated
	 */
	public Adapter createRichStringElseIfAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.summer.dsl.model.ss.CreateExtensionInfo <em>Create Extension Info</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.summer.dsl.model.ss.CreateExtensionInfo
	 * @generated
	 */
	public Adapter createCreateExtensionInfoAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.summer.dsl.model.ss.XtendConstructor <em>Xtend Constructor</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.summer.dsl.model.ss.XtendConstructor
	 * @generated
	 */
	public Adapter createXtendConstructorAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.summer.dsl.model.ss.XtendTypeDeclaration <em>Xtend Type Declaration</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.summer.dsl.model.ss.XtendTypeDeclaration
	 * @generated
	 */
	public Adapter createXtendTypeDeclarationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.summer.dsl.model.ss.XtendAnnotationType <em>Xtend Annotation Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.summer.dsl.model.ss.XtendAnnotationType
	 * @generated
	 */
	public Adapter createXtendAnnotationTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.summer.dsl.model.ss.XtendInterface <em>Xtend Interface</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.summer.dsl.model.ss.XtendInterface
	 * @generated
	 */
	public Adapter createXtendInterfaceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.summer.dsl.model.ss.XtendEnum <em>Xtend Enum</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.summer.dsl.model.ss.XtendEnum
	 * @generated
	 */
	public Adapter createXtendEnumAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.summer.dsl.model.ss.XtendEnumLiteral <em>Xtend Enum Literal</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.summer.dsl.model.ss.XtendEnumLiteral
	 * @generated
	 */
	public Adapter createXtendEnumLiteralAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.summer.dsl.model.ss.XtendVariableDeclaration <em>Xtend Variable Declaration</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.summer.dsl.model.ss.XtendVariableDeclaration
	 * @generated
	 */
	public Adapter createXtendVariableDeclarationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.summer.dsl.model.ss.XtendFormalParameter <em>Xtend Formal Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.summer.dsl.model.ss.XtendFormalParameter
	 * @generated
	 */
	public Adapter createXtendFormalParameterAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.summer.dsl.model.ss.XtendDelegate <em>Xtend Delegate</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.summer.dsl.model.ss.XtendDelegate
	 * @generated
	 */
	public Adapter createXtendDelegateAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.summer.dsl.model.ss.XtendEvent <em>Xtend Event</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.summer.dsl.model.ss.XtendEvent
	 * @generated
	 */
	public Adapter createXtendEventAdapter() {
		return null;
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
	 * Creates a new adapter for an object of class '{@link org.summer.dsl.model.types.JvmFormalParameter <em>Jvm Formal Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.summer.dsl.model.types.JvmFormalParameter
	 * @generated
	 */
	public Adapter createJvmFormalParameterAdapter() {
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

} //SsAdapterFactory
