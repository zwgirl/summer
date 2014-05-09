/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.summer.dsl.xbase.serializer;

import java.util.List;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.xtext.Action;
import org.eclipse.xtext.RuleCall;
import org.summer.dsl.model.types.JvmTypeReference;
import org.eclipse.xtext.naming.IQualifiedNameConverter;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.IScopeProvider;
import org.eclipse.xtext.serializer.acceptor.SequenceFeeder;
import org.eclipse.xtext.serializer.diagnostic.SerializationDiagnostic;
import org.eclipse.xtext.serializer.sequencer.ISemanticNodeProvider.INodesForEObjectProvider;
import org.eclipse.xtext.serializer.tokens.IValueSerializer;
import org.eclipse.xtext.serializer.tokens.SerializerScopeProviderBinding;
import org.summer.dsl.model.xbase.XAssignment;
import org.summer.dsl.model.xbase.XBinaryOperation;
import org.summer.dsl.model.xbase.XClosure;
import org.summer.dsl.model.xbase.XConstructorCall;
import org.summer.dsl.model.xbase.XExpression;
import org.summer.dsl.model.xbase.XFeatureCall;
import org.summer.dsl.model.xbase.XMemberFeatureCall;
import org.summer.dsl.model.xbase.XNullLiteral;
import org.summer.dsl.model.xbase.XbasePackage;
import org.summer.dsl.xbase.services.XbaseGrammarAccess;
import org.summer.dsl.xbase.services.XbaseGrammarAccess.XAdditiveExpressionElements;
import org.summer.dsl.xbase.services.XbaseGrammarAccess.XAndExpressionElements;
import org.summer.dsl.xbase.services.XbaseGrammarAccess.XAssignmentElements;
import org.summer.dsl.xbase.services.XbaseGrammarAccess.XConstructorCallElements;
import org.summer.dsl.xbase.services.XbaseGrammarAccess.XEqualityExpressionElements;
import org.summer.dsl.xbase.services.XbaseGrammarAccess.XFeatureCallElements;
import org.summer.dsl.xbase.services.XbaseGrammarAccess.XMemberFeatureCallElements;
import org.summer.dsl.xbase.services.XbaseGrammarAccess.XMultiplicativeExpressionElements;
import org.summer.dsl.xbase.services.XbaseGrammarAccess.XOrExpressionElements;
import org.summer.dsl.xbase.services.XbaseGrammarAccess.XRelationalExpressionElements;

import com.google.common.collect.Sets;
import com.google.inject.Inject;

public class XbaseSemanticSequencer extends AbstractXbaseSemanticSequencer {
	
	public static final String OPERATOR_NOT_SUPPORTED = "operation not supported";
	
	@Inject
	private XbaseGrammarAccess grammarAccess;
	
	@Inject
	private IQualifiedNameConverter qualifiedNameConverter;

	@Inject
	@SerializerScopeProviderBinding
	private IScopeProvider scopeProvider;
	
	@Inject
	private IValueSerializer valueSerializer;
	
	/**
	 * Constraint:
	 *     (
	 *         (leftOperand=XAdditiveExpression_XBinaryOperation_1_0_0_0 feature=[JvmIdentifiableElement|OpAdd] rightOperand=XMultiplicativeExpression) | 
	 *         (leftOperand=XMultiplicativeExpression_XBinaryOperation_1_0_0_0 feature=[JvmIdentifiableElement|OpMulti] rightOperand=XUnaryOperation) | 
	 *         (leftOperand=XOtherOperatorExpression_XBinaryOperation_1_0_0_0 feature=[JvmIdentifiableElement|OpOther] rightOperand=XAdditiveExpression) | 
	 *         (leftOperand=XRelationalExpression_XBinaryOperation_1_1_0_0_0 feature=[JvmIdentifiableElement|OpCompare] rightOperand=XOtherOperatorExpression) | 
	 *         (leftOperand=XEqualityExpression_XBinaryOperation_1_0_0_0 feature=[JvmIdentifiableElement|OpEquality] rightOperand=XRelationalExpression) | 
	 *         (leftOperand=XAndExpression_XBinaryOperation_1_0_0_0 feature=[JvmIdentifiableElement|OpAnd] rightOperand=XEqualityExpression) | 
	 *         (leftOperand=XOrExpression_XBinaryOperation_1_0_0_0 feature=[JvmIdentifiableElement|OpOr] rightOperand=XAndExpression) | 
	 *         (leftOperand=XAssignment_XBinaryOperation_1_1_0_0_0 feature=[JvmIdentifiableElement|OpMultiAssign] rightOperand=XAssignment)
	 *     )
	 */
//	@Override
//	protected void sequence_XAdditiveExpression_XAndExpression_XAssignment_XEqualityExpression_XMultiplicativeExpression_XOrExpression_XOtherOperatorExpression_XRelationalExpression(EObject context, XBinaryOperation operation) {
//		INodesForEObjectProvider nodes = createNodeProvider(operation);
//		SequenceFeeder acceptor = createSequencerFeeder(operation, nodes);
//		XAdditiveExpressionElements opAdd = grammarAccess.getXAdditiveExpressionAccess();
//		XMultiplicativeExpressionElements opMulti = grammarAccess.getXMultiplicativeExpressionAccess();
//		XOtherOperatorExpressionElements opOther = grammarAccess.getXOtherOperatorExpressionAccess();
//		XRelationalExpressionElements opCompare = grammarAccess.getXRelationalExpressionAccess();
//		XEqualityExpressionElements opEquality = grammarAccess.getXEqualityExpressionAccess();
//		XAndExpressionElements opAnd = grammarAccess.getXAndExpressionAccess();
//		XOrExpressionElements opOr = grammarAccess.getXOrExpressionAccess();
//		XAssignmentElements opMultiAssign = grammarAccess.getXAssignmentAccess();
//		
//		IScope scope = scopeProvider.getScope(operation, XbasePackage.Literals.XABSTRACT_FEATURE_CALL__FEATURE);
//		Set<String> operatorNames = Sets.newHashSet();
//		for (IEObjectDescription desc : scope.getElements(operation.getFeature()))
//			operatorNames.add(qualifiedNameConverter.toString(desc.getName()));
//				
//		ICompositeNode featureNode = (ICompositeNode) nodes.getNodeForSingelValue(XbasePackage.Literals.XABSTRACT_FEATURE_CALL__FEATURE, operation.getFeature());
//		String featureToken;
//		
//		if((featureToken = getValidOperator(operation, opAdd.getFeatureJvmIdentifiableElementOpAddParserRuleCall_1_0_0_1_0_1(), operatorNames, featureNode)) != null) {
//			acceptor.accept(opAdd.getXBinaryOperationLeftOperandAction_1_0_0_0(), operation.getLeftOperand());
//			acceptor.accept(opAdd.getFeatureJvmIdentifiableElementOpAddParserRuleCall_1_0_0_1_0_1(), operation.getFeature(), featureToken, featureNode);
//			acceptor.accept(opAdd.getRightOperandXMultiplicativeExpressionParserRuleCall_1_1_0(), operation.getRightOperand());
//		} else if((featureToken = getValidOperator(operation, opMulti.getFeatureJvmIdentifiableElementOpMultiParserRuleCall_1_0_0_1_0_1(), operatorNames, featureNode)) != null) {
//			acceptor.accept(opMulti.getXBinaryOperationLeftOperandAction_1_0_0_0(), operation.getLeftOperand());
//			acceptor.accept(opMulti.getFeatureJvmIdentifiableElementOpMultiParserRuleCall_1_0_0_1_0_1(), operation.getFeature(), featureToken, featureNode);
//			acceptor.accept(opMulti.getRightOperandXPostfixOperationParserRuleCall_1_1_0(), operation.getRightOperand());
//		} else if((featureToken = getValidOperator(operation, opOther.getFeatureJvmIdentifiableElementOpOtherParserRuleCall_1_0_0_1_0_1(), operatorNames, featureNode)) != null) {
//			acceptor.accept(opOther.getXBinaryOperationLeftOperandAction_1_0_0_0(), operation.getLeftOperand());
//			acceptor.accept(opOther.getFeatureJvmIdentifiableElementOpOtherParserRuleCall_1_0_0_1_0_1(), operation.getFeature(), featureToken, featureNode);
//			acceptor.accept(opOther.getRightOperandXAdditiveExpressionParserRuleCall_1_1_0(), operation.getRightOperand());
//		} else if((featureToken = getValidOperator(operation, opCompare.getFeatureJvmIdentifiableElementOpCompareParserRuleCall_1_1_0_0_1_0_1(), operatorNames, featureNode)) != null) {
//			acceptor.accept(opCompare.getXBinaryOperationLeftOperandAction_1_1_0_0_0(), operation.getLeftOperand());
//			acceptor.accept(opCompare.getFeatureJvmIdentifiableElementOpCompareParserRuleCall_1_1_0_0_1_0_1(), operation.getFeature(), featureToken, featureNode);
//			acceptor.accept(opCompare.getRightOperandXOtherOperatorExpressionParserRuleCall_1_1_1_0(), operation.getRightOperand());
//		} else if((featureToken = getValidOperator(operation, opEquality.getFeatureJvmIdentifiableElementOpEqualityParserRuleCall_1_0_0_1_0_1(), operatorNames, featureNode)) != null) {
//			acceptor.accept(opEquality.getXBinaryOperationLeftOperandAction_1_0_0_0(), operation.getLeftOperand());
//			acceptor.accept(opEquality.getFeatureJvmIdentifiableElementOpEqualityParserRuleCall_1_0_0_1_0_1(), operation.getFeature(), featureToken, featureNode);
//			acceptor.accept(opEquality.getRightOperandXRelationalExpressionParserRuleCall_1_1_0(), operation.getRightOperand());
//		} else if((featureToken = getValidOperator(operation, opAnd.getFeatureJvmIdentifiableElementOpAndParserRuleCall_1_0_0_1_0_1(), operatorNames, featureNode)) != null) {
//			acceptor.accept(opAnd.getXBinaryOperationLeftOperandAction_1_0_0_0(), operation.getLeftOperand());
//			acceptor.accept(opAnd.getFeatureJvmIdentifiableElementOpAndParserRuleCall_1_0_0_1_0_1(), operation.getFeature(), featureToken, featureNode);
//			acceptor.accept(opAnd.getRightOperandXEqualityExpressionParserRuleCall_1_1_0(), operation.getRightOperand());
//		} else if((featureToken = getValidOperator(operation, opOr.getFeatureJvmIdentifiableElementOpOrParserRuleCall_1_0_0_1_0_1(), operatorNames, featureNode)) != null) {
//			acceptor.accept(opOr.getXBinaryOperationLeftOperandAction_1_0_0_0(), operation.getLeftOperand());
//			acceptor.accept(opOr.getFeatureJvmIdentifiableElementOpOrParserRuleCall_1_0_0_1_0_1(), operation.getFeature(), featureToken, featureNode);
//			acceptor.accept(opOr.getRightOperandXAndExpressionParserRuleCall_1_1_0(), operation.getRightOperand());
//		} else if((featureToken = getValidOperator(operation, opMultiAssign.getFeatureJvmIdentifiableElementOpMultiAssignParserRuleCall_1_1_0_0_1_0_1(), operatorNames, featureNode)) != null) {
//			acceptor.accept(opMultiAssign.getXBinaryOperationLeftOperandAction_1_1_0_0_0(), operation.getLeftOperand());
//			acceptor.accept(opMultiAssign.getFeatureJvmIdentifiableElementOpMultiAssignParserRuleCall_1_1_0_0_1_0_1(), operation.getFeature(), featureToken, featureNode);
//			acceptor.accept(opMultiAssign.getRightOperandXAssignmentParserRuleCall_1_1_1_0(), operation.getRightOperand());
//		} else if (errorAcceptor != null) {
//			errorAcceptor.accept(new SerializationDiagnostic(OPERATOR_NOT_SUPPORTED, operation, context, "Operator "+operatorNames+" is not supported."));
//		} 
//		acceptor.finish();
//	}
	
	protected String getValidOperator(EObject semanticObject, RuleCall ruleCall, Iterable<String> names, ICompositeNode node) {
		for (String name : names)
			if (valueSerializer.isValid(semanticObject, ruleCall, name, null))
				return valueSerializer.serializeAssignedValue(semanticObject, ruleCall, name, node, errorAcceptor);
		return null;
	}
	
	
	
	/**
	 * Constraint:
	 *     (
	 *         declaringType=[JvmDeclaredType|StaticQualifier]?
	 *         (typeArguments+=JvmArgumentTypeReference typeArguments+=JvmArgumentTypeReference*)?
	 *         feature=[JvmIdentifiableElement|IdOrSuper]
	 *         (explicitOperationCall?='(' (featureCallArguments+=XShortClosure | (featureCallArguments+=XExpression featureCallArguments+=XExpression*))?)?
	 *     )
	 *     
	 *
	 * Features:
	 *    feature[1, 1]
	 *    typeArguments[0, *]
	 *    featureCallArguments[1, *]
	 *         EXCLUDE_IF_UNSET explicitOperationCall
	 *    explicitOperationCall[0, 1]
	 *         MANDATORY_IF_SET featureCallArguments
	 *         EXCLUDE_IF_UNSET featureCallArguments
	 *         MANDATORY_IF_SET featureCallArguments
	 *         MANDATORY_IF_SET featureCallArguments
	 *    declaringType[0, 1]
	 */
	@Override
	protected void sequence_XFeatureCall(EObject context, XFeatureCall featureCall) {
		INodesForEObjectProvider nodes = createNodeProvider(featureCall);
		SequenceFeeder acceptor = createSequencerFeeder(featureCall, nodes);
		XFeatureCallElements featureCallElements = grammarAccess.getXFeatureCallAccess();

		// (typeArguments+=JvmArgumentTypeReference typeArguments+=JvmArgumentTypeReference*)?
		List<JvmTypeReference> typeArguments = featureCall.getTypeArguments();
		if (!typeArguments.isEmpty()) {
			acceptor.accept(featureCallElements.getTypeArgumentsJvmArgumentTypeReferenceParserRuleCall_1_1_0(), typeArguments.get(0), 0);
			for (int i = 1; i < typeArguments.size(); i++)
				acceptor.accept(featureCallElements.getTypeArgumentsJvmArgumentTypeReferenceParserRuleCall_1_2_1_0(), typeArguments.get(i), i);
		}

		// feature=[JvmIdentifiableElement|IdOrSuper]
		acceptor.accept(featureCallElements.getFeatureJvmIdentifiableElementIdOrSuperParserRuleCall_2_0_1(), featureCall.getFeature());

		// (explicitOperationCall?='(' (featureCallArguments+=XShortClosure | (featureCallArguments+=XExpression featureCallArguments+=XExpression*))?)? featureCallArguments+=XClosure?
		if (featureCall.isExplicitOperationCallOrBuilderSyntax()) {
			if (featureCall.isExplicitOperationCall())
				acceptor.accept(featureCallElements.getExplicitOperationCallLeftParenthesisKeyword_3_0_0());
			List<XExpression> arguments = featureCall.getFeatureCallArguments();
			if (!arguments.isEmpty()) {
					int diff = 0;
					if (isBuilderSyntax(featureCall, XbasePackage.Literals.XFEATURE_CALL__FEATURE_CALL_ARGUMENTS, featureCall.isExplicitOperationCall(), nodes)) {
						diff = 1;
					}
					if (featureCall.isExplicitOperationCall()) {
						if (arguments.size() - diff > 0)
							acceptor.accept(featureCallElements.getFeatureCallArgumentsXExpressionParserRuleCall_3_1_0_0(), arguments.get(0), 0);
						for (int i = 1; i < arguments.size() - diff; i++)
							acceptor.accept(featureCallElements.getFeatureCallArgumentsXExpressionParserRuleCall_3_1_0_0(), arguments.get(i), i);
					}
					if (diff != 0) {
						int lastIdx = arguments.size() - 1;
//						acceptor.accept(featureCallElements.getFeatureCallArgumentsXClosureParserRuleCall_4_0(), arguments.get(lastIdx), lastIdx);
					}
			}
		}
		acceptor.finish();
	}
	
	
	protected boolean isBuilderSyntax(EObject expression, EReference reference, boolean explicitOperationCall, INodesForEObjectProvider nodes) {
		List<?> values = (List<?>) expression.eGet(reference);
		if (values.size() < 1)
			return false;
		if (values.size() == 1 && !explicitOperationCall)
			return true;
		return isBuilderSyntax(values, reference, nodes);
	}

	protected boolean isBuilderSyntax(List<?> values, EReference reference, INodesForEObjectProvider nodes) {
		if (values.isEmpty())
			return false;
		int lastIndex = values.size() - 1;
		Object lastValue = values.get(lastIndex);
		if (!(lastValue instanceof XClosure))
			return false;
		INode node = nodes.getNodeForMultiValue(reference, lastIndex, lastIndex, values.get(lastIndex));
		if (node != null) {
			if (node.getGrammarElement() instanceof RuleCall)
				return ((RuleCall) node.getGrammarElement()).getRule() == grammarAccess.getXClosureRule();
			if (node.getGrammarElement() instanceof Action) 
				return node.getGrammarElement() == grammarAccess.getXClosureAccess().getXClosureAction_0();
			return false;
		}
		return true;
	}
	
	
	/**
	 * Constraint:
	 *     (
	 *         memberCallTarget=XMemberFeatureCall_XMemberFeatureCall_1_1_0_0_0
	 *         (nullSafe?='?.' | spreading?='*.')?
	 *         (typeArguments+=JvmArgumentTypeReference typeArguments+=JvmArgumentTypeReference*)?
	 *         feature=[JvmIdentifiableElement|ID]
	 *         (explicitOperationCall?='(' (memberCallArguments+=XShortClosure | (memberCallArguments+=XExpression memberCallArguments+=XExpression*))?)?
	 *     )
	 *     
	 *
	 * Features:
	 *    feature[1, 1]
	 *    typeArguments[0, *]
	 *    memberCallTarget[1, 1]
	 *    memberCallArguments[1, *]
	 *         EXCLUDE_IF_UNSET explicitOperationCall
	 *    explicitOperationCall[0, 1]
	 *         MANDATORY_IF_SET memberCallArguments
	 *         EXCLUDE_IF_UNSET memberCallArguments
	 *         MANDATORY_IF_SET memberCallArguments
	 *         MANDATORY_IF_SET memberCallArguments
	 *    spreading[0, 1]
	 *         EXCLUDE_IF_SET nullSafe
	 *    nullSafe[0, 1]
	 *         EXCLUDE_IF_SET spreading
	 */
	@Override
	protected void sequence_XMemberFeatureCall(EObject context, XMemberFeatureCall featureCall) {
		INodesForEObjectProvider nodes = createNodeProvider(featureCall);
		SequenceFeeder acceptor = createSequencerFeeder(featureCall, nodes);
		XMemberFeatureCallElements memberFeatureCallElements= grammarAccess.getXMemberFeatureCallAccess();

		// memberCallTarget=XMemberFeatureCall_XMemberFeatureCall_1_1_0_0_0
		acceptor.accept(memberFeatureCallElements.getXMemberFeatureCallMemberCallTargetAction_1_3_0_0_0(), featureCall.getMemberCallTarget());

		// (nullSafe?='?.' | explicitStatic?='::')?
		if (featureCall.isNullSafe())
			acceptor.accept(memberFeatureCallElements.getNullSafeQuestionMarkFullStopKeyword_1_3_0_0_1_1_0());
//		else if (featureCall.isExplicitStatic())
//			acceptor.accept(memberFeatureCallElements.getExplicitStaticColonColonKeyword_1_1_0_0_1_1_0());

		// (typeArguments+=JvmArgumentTypeReference typeArguments+=JvmArgumentTypeReference*)?
		List<JvmTypeReference> typeArguments = featureCall.getTypeArguments();
		if (!typeArguments.isEmpty()) {
			acceptor.accept(memberFeatureCallElements.getTypeArgumentsJvmArgumentTypeReferenceParserRuleCall_1_3_1_1_0(), typeArguments.get(0), 0);
			for (int i = 1; i < typeArguments.size(); i++)
				acceptor.accept(memberFeatureCallElements.getTypeArgumentsJvmArgumentTypeReferenceParserRuleCall_1_3_1_1_0(), typeArguments.get(i), i);
		}

		// feature=[JvmIdentifiableElement|ID]
		acceptor.accept(memberFeatureCallElements.getFeatureJvmIdentifiableElementFeatureCallIDParserRuleCall_1_2_0_0_2_0_1(), featureCall.getFeature());

		// (explicitOperationCall?='(' (memberCallArguments+=XShortClosure | (memberCallArguments+=XExpression memberCallArguments+=XExpression*))?)? memberCallArguments+=XClosure? 
		if (featureCall.isExplicitOperationCallOrBuilderSyntax()) {
			if (featureCall.isExplicitOperationCall())
				acceptor.accept(memberFeatureCallElements.getExplicitOperationCallLeftParenthesisKeyword_1_0_0_0_1_0());
			List<XExpression> arguments = featureCall.getMemberCallArguments();
			if (!arguments.isEmpty()) {
					int diff = 0;
					if (isBuilderSyntax(featureCall, XbasePackage.Literals.XMEMBER_FEATURE_CALL__MEMBER_CALL_ARGUMENTS, featureCall.isExplicitOperationCall(), nodes)) {
						diff = 1;
					}
					if (featureCall.isExplicitOperationCall()) {
						if (arguments.size() - diff > 0)
							acceptor.accept(memberFeatureCallElements.getMemberCallArgumentsXExpressionParserRuleCall_1_0_1_0_0(), arguments.get(0), 0);
						for (int i = 1; i < arguments.size() - diff; i++)
							acceptor.accept(memberFeatureCallElements.getMemberCallArgumentsXExpressionParserRuleCall_1_0_1_0_0(), arguments.get(i), i);
					}
					if (diff != 0) {
						int lastIdx = arguments.size() - 1;
//						acceptor.accept(memberFeatureCallElements.getMemberCallArgumentsXClosureParserRuleCall_1_2_4_0(), arguments.get(lastIdx), lastIdx);
					}
			}
		}
		acceptor.finish();
	}
	
	/**
	 * Constraint:
	 *     (
	 *         constructor=[JvmConstructor|QualifiedName] 
	 *         (typeArguments+=JvmArgumentTypeReference typeArguments+=JvmArgumentTypeReference*)? 
	 *         (arguments+=XShortClosure | (arguments+=XExpression arguments+=XExpression*))? 
	 *         arguments+=XClosure?
	 *     )
	 */
	@Override
	protected void sequence_XConstructorCall(EObject context, XConstructorCall constructorCall) {
		INodesForEObjectProvider nodes = createNodeProvider(constructorCall);
		SequenceFeeder acceptor = createSequencerFeeder(constructorCall, nodes);
		XConstructorCallElements constructorCallElements = grammarAccess.getXConstructorCallAccess();

		// constructor=[types::JvmConstructor|QualifiedName]
		acceptor.accept(constructorCallElements.getConstructorJvmConstructorQualifiedNameParserRuleCall_2_0_1(), constructorCall.getConstructor());

		// '<' typeArguments+=JvmArgumentTypeReference (',' typeArguments+=JvmArgumentTypeReference)* '>'
		List<JvmTypeReference> typeArguments = constructorCall.getTypeArguments();
		if (!typeArguments.isEmpty()) {
			acceptor.accept(constructorCallElements.getTypeArgumentsJvmArgumentTypeReferenceParserRuleCall_3_1_0(), typeArguments.get(0), 0);
			for (int i = 1; i < typeArguments.size(); i++)
				acceptor.accept(constructorCallElements.getTypeArgumentsJvmArgumentTypeReferenceParserRuleCall_3_2_1_0(), typeArguments.get(i), i);
		}

		/*
		 *  (=>'(' 
		 *    (
		 *        arguments+=XShortClosure
		 *      | arguments+=XExpression (',' arguments+=XExpression)*
		 *    )? 
		 *  ')')?
		 *  =>arguments+=XClosure? 
		 */
		List<XExpression> arguments = constructorCall.getArguments();
		if (!arguments.isEmpty()) {
				int diff = 0;
				if (isBuilderSyntax(arguments, XbasePackage.Literals.XCONSTRUCTOR_CALL__ARGUMENTS, nodes)) {
					diff = 1;
				}
				if (arguments.size() - diff > 0)
					acceptor.accept(constructorCallElements.getArgumentsXExpressionParserRuleCall_4_1_0_0(), arguments.get(0), 0);
				for (int i = 1; i < arguments.size() - diff; i++)
//					acceptor.accept(constructorCallElements.getArgumentsXExpressionParserRuleCall_4_1_1_1_1_0(), arguments.get(i), i);
				if (diff != 0) {
					int lastIdx = arguments.size() - 1;
//					acceptor.accept(constructorCallElements.getArgumentsXClosureParserRuleCall_5_0(), arguments.get(lastIdx), lastIdx);
				}
		}
		acceptor.finish();
	}
	
//	/**
//	 * This is for backwards compatibility < 2.3RC2 due to change in the naming strategy for sequencer methods
//	 */
//	@Deprecated
//	protected void sequence_XExpression(EObject context, XNullLiteral semanticObject) {
//		super.sequence_XNullLiteral(context, semanticObject);
//	}
	
	/**
	 * This is for backwards compatibility < 2.3RC3 due to change in the naming strategy for sequencer methods
	 */
//	@Deprecated
//	protected void sequence_XAdditiveExpression(EObject context, XBinaryOperation operation) {
//		sequence_XAdditiveExpression_XAndExpression_XAssignment_XEqualityExpression_XMultiplicativeExpression_XOrExpression_XOtherOperatorExpression_XRelationalExpression(context, operation);
//	}
	
	/**
	 * This is for backwards compatibility < 2.3RC3 due to change in the naming strategy for sequencer methods
	 */
	@Deprecated
	protected void sequence_XAssignment(EObject context, XAssignment semanticObject) {
		super.sequence_XAssignment_XMemberFeatureCall(context, semanticObject);
	}
	
}
