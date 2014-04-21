/**
 */
package org.summer.dsl.model.richstring.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.summer.dsl.model.richstring.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class RichstringFactoryImpl extends EFactoryImpl implements RichstringFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static RichstringFactory init() {
		try {
			RichstringFactory theRichstringFactory = (RichstringFactory)EPackage.Registry.INSTANCE.getEFactory(RichstringPackage.eNS_URI);
			if (theRichstringFactory != null) {
				return theRichstringFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new RichstringFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RichstringFactoryImpl() {
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
			case RichstringPackage.PROCESSED_RICH_STRING: return createProcessedRichString();
			case RichstringPackage.LINE: return createLine();
			case RichstringPackage.LINE_PART: return createLinePart();
			case RichstringPackage.LITERAL: return createLiteral();
			case RichstringPackage.LINE_BREAK: return createLineBreak();
			case RichstringPackage.FOR_LOOP_START: return createForLoopStart();
			case RichstringPackage.FOR_LOOP_END: return createForLoopEnd();
			case RichstringPackage.PRINTED_EXPRESSION: return createPrintedExpression();
			case RichstringPackage.IF_CONDITION_START: return createIfConditionStart();
			case RichstringPackage.ELSE_IF_CONDITION: return createElseIfCondition();
			case RichstringPackage.ELSE_START: return createElseStart();
			case RichstringPackage.END_IF: return createEndIf();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ProcessedRichString createProcessedRichString() {
		ProcessedRichStringImpl processedRichString = new ProcessedRichStringImpl();
		return processedRichString;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Line createLine() {
		LineImpl line = new LineImpl();
		return line;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LinePart createLinePart() {
		LinePartImpl linePart = new LinePartImpl();
		return linePart;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Literal createLiteral() {
		LiteralImpl literal = new LiteralImpl();
		return literal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LineBreak createLineBreak() {
		LineBreakImpl lineBreak = new LineBreakImpl();
		return lineBreak;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ForLoopStart createForLoopStart() {
		ForLoopStartImpl forLoopStart = new ForLoopStartImpl();
		return forLoopStart;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ForLoopEnd createForLoopEnd() {
		ForLoopEndImpl forLoopEnd = new ForLoopEndImpl();
		return forLoopEnd;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PrintedExpression createPrintedExpression() {
		PrintedExpressionImpl printedExpression = new PrintedExpressionImpl();
		return printedExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfConditionStart createIfConditionStart() {
		IfConditionStartImpl ifConditionStart = new IfConditionStartImpl();
		return ifConditionStart;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ElseIfCondition createElseIfCondition() {
		ElseIfConditionImpl elseIfCondition = new ElseIfConditionImpl();
		return elseIfCondition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ElseStart createElseStart() {
		ElseStartImpl elseStart = new ElseStartImpl();
		return elseStart;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EndIf createEndIf() {
		EndIfImpl endIf = new EndIfImpl();
		return endIf;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RichstringPackage getRichstringPackage() {
		return (RichstringPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static RichstringPackage getPackage() {
		return RichstringPackage.eINSTANCE;
	}

} //RichstringFactoryImpl
