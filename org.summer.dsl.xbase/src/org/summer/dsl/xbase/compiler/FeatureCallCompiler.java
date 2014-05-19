/*******************************************************************************
is * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse protected License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.summer.dsl.xbase.compiler;

import java.util.Collection;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.NonNullByDefault;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.xtext.Assignment;
import org.eclipse.xtext.CrossReference;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.generator.trace.ILocationData;
import org.eclipse.xtext.generator.trace.LocationData;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.ILeafNode;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.resource.ILocationInFileProvider;
import org.eclipse.xtext.util.ITextRegionWithLineInformation;
import org.eclipse.xtext.util.TextRegionWithLineInformation;
import org.summer.dsl.model.types.JvmAnnotationReference;
import org.summer.dsl.model.types.JvmAnnotationValue;
import org.summer.dsl.model.types.JvmBooleanAnnotationValue;
import org.summer.dsl.model.types.JvmConstructor;
import org.summer.dsl.model.types.JvmDeclaredType;
import org.summer.dsl.model.types.JvmExecutable;
import org.summer.dsl.model.types.JvmFeature;
import org.summer.dsl.model.types.JvmField;
import org.summer.dsl.model.types.JvmFormalParameter;
import org.summer.dsl.model.types.JvmIdentifiableElement;
import org.summer.dsl.model.types.JvmMember;
import org.summer.dsl.model.types.JvmOperation;
import org.summer.dsl.model.types.JvmPrimitiveType;
import org.summer.dsl.model.types.JvmStringAnnotationValue;
import org.summer.dsl.model.types.JvmType;
import org.summer.dsl.model.types.JvmTypeAnnotationValue;
import org.summer.dsl.model.types.JvmTypeConstraint;
import org.summer.dsl.model.types.JvmTypeParameter;
import org.summer.dsl.model.types.JvmTypeParameterDeclarator;
import org.summer.dsl.model.types.JvmTypeReference;
import org.summer.dsl.model.types.JvmVoid;
import org.summer.dsl.model.types.JvmWildcardTypeReference;
import org.summer.dsl.model.types.util.ITypeArgumentContext;
import org.summer.dsl.model.types.util.Primitives;
import org.summer.dsl.model.xbase.XAbstractFeatureCall;
import org.summer.dsl.model.xbase.XAssignment;
import org.summer.dsl.model.xbase.XBinaryOperation;
import org.summer.dsl.model.xbase.XBlockStatment;
import org.summer.dsl.model.xbase.XExpression;
import org.summer.dsl.model.xbase.XFeatureCall;
import org.summer.dsl.model.xbase.XMemberFeatureCall;
import org.summer.dsl.model.xbase.XUnaryOperation;
import org.summer.dsl.model.xbase.XVariableDeclaration;
import org.summer.dsl.model.xbase.XVariableDeclarationList;
import org.summer.dsl.model.xbase.XbasePackage;
import org.summer.dsl.xbase.compiler.output.ITreeAppendable;
import org.summer.dsl.xbase.featurecalls.IdentifiableSimpleNameProvider;
import org.summer.dsl.xbase.impl.FeatureCallToJavaMapping;
import org.summer.dsl.xbase.jvmmodel.ILogicalContainerProvider;
import org.summer.dsl.xbase.typesystem.IBatchTypeResolver;
import org.summer.dsl.xbase.typesystem.IResolvedTypes;
import org.summer.dsl.xbase.typesystem.references.LightweightTypeReference;
import org.summer.dsl.xbase.typing.JvmOnlyTypeConformanceComputer;
import org.summer.dsl.xbase.typing.XbaseTypeArgumentContextProvider;
import org.summer.dsl.xbase.util.XExpressionHelper;

import com.google.common.collect.Lists;
import com.google.inject.Inject;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
@NonNullByDefault
@SuppressWarnings("deprecation")
public class FeatureCallCompiler extends LiteralsCompiler {

	@Inject
	private FeatureCallToJavaMapping featureCallToJavaMapping;

	@Inject
	private IdentifiableSimpleNameProvider featureNameProvider;

	@Inject
	private XExpressionHelper expressionHelper;

	@Inject
	private JvmOnlyTypeConformanceComputer jvmConformance;

	@Inject
	private Primitives primitives;

	@Inject
	private ILogicalContainerProvider contextProvider;
	
	@Inject
	private ILocationInFileProvider locationInFileProvider;

	@Override
	protected void internalToConvertedExpression(XExpression obj, ITreeAppendable appendable) {
		if (obj instanceof XAbstractFeatureCall) {
			_toJavaExpression((XAbstractFeatureCall) obj, appendable);
		} else {
			super.internalToConvertedExpression(obj, appendable);
		}
	}

	protected boolean nullSafeMemberFeatureCallExpressionNeedsPreparation(XExpression argument, ITreeAppendable b) {
		if (b.hasName(argument))
			return false;
		if (argument instanceof JvmField || argument instanceof JvmFormalParameter)
			return false;
		return true;
	}
	
	protected List<XExpression> getActualArguments(final XAbstractFeatureCall expr) {
		return featureCallToJavaMapping.getActualArguments(expr);
	}

	@Nullable
	protected XExpression getActualReceiver(final XAbstractFeatureCall expr) {
		return featureCallToJavaMapping.getActualReceiver(expr);
	}
	
//	protected void _toJavaStatement(final XFeatureCall expr, final ITreeAppendable b, boolean isReferenced) {
//		// if it's a call to this() or super() make sure the arguments are forced to be compiled to expressions.
//		if (expr.getFeature() instanceof JvmConstructor) {
//			b.newLine();
//			featureCalltoJavaExpression(expr, b, false);
//			b.append(";");
//		} else {
//			_toJavaStatement((XAbstractFeatureCall) expr, b, isReferenced);
//		}
//	}

//	protected void generateShortCircuitInvocation(final XAbstractFeatureCall binaryOperation, final ITreeAppendable b) {
//		final XExpression leftOperand = ((XBinaryOperation) binaryOperation).getLeftOperand();
//		declareSyntheticVariable(binaryOperation, b);
//		boolean isElvis = binaryOperation.getConcreteSyntaxFeatureName().equals(expressionHelper.getElvisOperator());
//		prepareExpression(leftOperand, b);
//		if(isElvis) {
//			b.newLine().append("if (");
//			toJavaExpression(leftOperand, b);
//			b.append(" != null) {").increaseIndentation();
//			b.newLine().append(b.getName(binaryOperation)).append(" = ");
//			toJavaExpression(leftOperand, b);
//			b.append(";");
//		} else {
//			b.newLine().append("if (");
//			if (binaryOperation.getConcreteSyntaxFeatureName().equals(expressionHelper.getAndOperator())) {
//				b.append("!");
//			}
//			toJavaExpression(leftOperand, b);
//			b.append(") {").increaseIndentation();
//			boolean rightOperand = binaryOperation.getConcreteSyntaxFeatureName().equals(expressionHelper.getOrOperator());
//			b.newLine().append(b.getName(binaryOperation)).append(" = ");
//			b.append(Boolean.toString(rightOperand)).append(";");
//		}
//		b.decreaseIndentation().newLine().append("} else {").increaseIndentation();
//		if (binaryOperation.getImplicitReceiver() != null) {
//			internalToJavaStatement(binaryOperation.getImplicitReceiver(), b, true);
//		}
//		for (XExpression arg : binaryOperation.getExplicitArguments()) {
//			if (arg != leftOperand)
//				prepareExpression(arg, b);
//		}
//		b.newLine().append(b.getName(binaryOperation)).append(" = ");
//		featureCalltoJavaExpression(binaryOperation, b, true);
//		b.append(";");
//		b.decreaseIndentation().newLine().append("}");
//	}
	
	@Override
	protected boolean internalCanCompileToJavaExpression(XExpression expression, ITreeAppendable appendable) {
		if (expression instanceof XAbstractFeatureCall) {
			XAbstractFeatureCall featureCall = (XAbstractFeatureCall) expression;
			for (XExpression arg : featureCall.getActualArguments()) {
				if (!this.internalCanCompileToJavaExpression(arg, appendable)) {
					return false;
				}
			}
			if (featureCall.getActualReceiver() != null && !internalCanCompileToJavaExpression(featureCall.getActualReceiver(), appendable)) {
				return false;
			}
			return true;
		}
		return super.internalCanCompileToJavaExpression(expression, appendable);
	}
	
	protected boolean isVariableDeclarationRequired(XMemberFeatureCall expr, @SuppressWarnings("unused") ITreeAppendable b) {
		return expr.isNullSafe();
	}
	
	@Override
	protected boolean isVariableDeclarationRequired(XExpression expr, ITreeAppendable b) {
		if (expr instanceof XAssignment)
			return true;
		if (expr.eContainingFeature() == XbasePackage.Literals.XMEMBER_FEATURE_CALL__MEMBER_CALL_TARGET) {
			if (((XMemberFeatureCall) expr.eContainer()).isNullSafe()) {
				if (expr instanceof XFeatureCall) {
					JvmIdentifiableElement feature = ((XFeatureCall) expr).getFeature();
					if (feature instanceof JvmField || feature instanceof JvmFormalParameter)
						return false;
					return !b.hasName(feature);
				}
				return !b.hasName(expr);
			}
		}
		if (expr instanceof XAbstractFeatureCall) {
			XAbstractFeatureCall featureCall = (XAbstractFeatureCall) expr;
			if (featureCall.isTypeLiteral() || featureCall.isPackageFragment()) {
				return false;
			}
			// we need to prefer expressions for constant expressions, so they get compiled correctly.
			// a binary or unary operator is constant if it's method is annotated with @Inline(..., constantExpression=true)
			// and all arguments don't require variableDeclarations.
			if (featureCall instanceof XBinaryOperation || featureCall instanceof XUnaryOperation) {
				JvmAnnotationReference inlineAnnotation = expressionHelper.findInlineAnnotation(featureCall);
				if (inlineAnnotation == null)
					return true;
				for (XExpression argument : featureCall.getActualArguments()) {
					if (isVariableDeclarationRequired(argument, b)) {
						return true;
					}
				}
				for (JvmAnnotationValue value: inlineAnnotation.getValues()) {
					if (value instanceof JvmBooleanAnnotationValue && value.getValueName().equals("constantExpression")) {
						EList<Boolean> values = ((JvmBooleanAnnotationValue )value).getValues();
						if (!values.isEmpty()) {
							return !values.get(0);
						}
					}
				}
				return true;
			}
			
			if (featureCall instanceof XMemberFeatureCall && isVariableDeclarationRequired((XMemberFeatureCall) featureCall, b))
				return true;
			JvmIdentifiableElement feature = featureCall.getFeature();
			if (feature instanceof JvmField || feature instanceof JvmFormalParameter)
				return false;
			return !b.hasName(feature);
		}
		return super.isVariableDeclarationRequired(expr, b);
	}

//	protected void prepareExpression(XExpression arg, ITreeAppendable b) {
//		if (arg instanceof XAbstractFeatureCall && !(((XAbstractFeatureCall) arg).getFeature() instanceof JvmField)
//				&& !isVariableDeclarationRequired(arg, b)) {
//			// we have to convert the given value in a later step and the
//			// conversion code may produce an anonymous class of the expected type
//			// where the implementation needs to reference the value of this expression
//			// thus we have to make sure that the value is stored in a final variable
//			XAbstractFeatureCall featureCall = (XAbstractFeatureCall) arg;
//			// check for final modifier
//			if (featureCall.getFeature() instanceof XVariableDeclaration) {
//				XVariableDeclaration variableDeclaration = (XVariableDeclaration) featureCall.getFeature();
//				if (!((XVariableDeclarationList)variableDeclaration.eContainer()).isReadonly()) {
//					internalToJavaStatement(arg, b, true);
//					return;
//				}
//			} else if (featureCall.getFeature() instanceof JvmFormalParameter) {
//				// always final
//				internalToJavaStatement(arg, b, true);
//				return;
//			}
//			JvmTypeReference expectedType = getTypeProvider().getExpectedType(arg);
//			JvmTypeReference type = getType(arg);
//			if (expectedType != null && !jvmConformance.isConformant(expectedType, type)) {
//				String varName = getVarName(((XAbstractFeatureCall) arg).getFeature(), b);
//				String finalVariable = b.declareSyntheticVariable(arg, "_converted_" + varName);
//				b.newLine().append("final ");
//				serialize(type, arg, b);
//				b.append(" ").append(finalVariable).append(" = ").append("(");
//				serialize(type, arg, b);
//				b.append(")").append(varName).append(";");
//			}
//		} else {
//			internalToJavaStatement(arg, b, true);
//		}
//	}

	protected void _toJavaExpression(XAbstractFeatureCall call, ITreeAppendable b) {
		if (call.isTypeLiteral()) {
			b.append((JvmType) call.getFeature()).append(".class");
		} else if (isPrimitiveVoid(call)) {
			throw new IllegalArgumentException("feature yields 'void'");
		} else {
			final String referenceName = getReferenceName(call, b);
			if (referenceName != null) {
				if (call instanceof XFeatureCall || call instanceof XMemberFeatureCall) {
					b.trace(call, XbasePackage.Literals.XABSTRACT_FEATURE_CALL__FEATURE, 0).append(referenceName);
				} else {
					b.trace(call, false).append(referenceName);
				}
			} else {
				featureCalltoJavaExpression(call, b, true);
			}
		}
	}

	protected void featureCalltoJavaExpression(final XAbstractFeatureCall call, ITreeAppendable b, boolean isExpressionContext) {
		if (call instanceof XAssignment) {
			assignmentToJavaExpression((XAssignment) call, b, isExpressionContext);
		} else {
			boolean hasReceiver = appendReceiver(call, b, isExpressionContext);
			if (hasReceiver) {
				b.append(".");
				b = appendTypeArguments(call, b);
			}
			appendFeatureCall(call, b);
		}
	}

	protected ITreeAppendable appendTypeArguments(final XAbstractFeatureCall call, ITreeAppendable original) {
		ILocationData completeLocationData = getLocationWithTypeArguments(call);
		ITreeAppendable completeFeatureCallAppendable = completeLocationData != null ? original.trace(completeLocationData) : original;
		if (!call.getTypeArguments().isEmpty()) {
			/*
			 * We want to create the following trace regions
			 *  receiver.  < type ,  arguments >   name ( 'param' )
			 * |         || [    ]  [         ] ||[    ] [       ] |||
			 * |         |[                     ][                 ]||
			 * |         [                                          ]|
			 * [                                                     ]
			 */
			ILocationData argumentsLocationData = null;
			if (completeLocationData != null) {
				argumentsLocationData = getLocationOfTypeArguments(call);
			}
			ITreeAppendable typeArgumentsAppendable = argumentsLocationData != null ? completeFeatureCallAppendable.trace(argumentsLocationData) : completeFeatureCallAppendable;
			typeArgumentsAppendable.append("<");
			for (int i = 0; i < call.getTypeArguments().size(); i++) {
				if (i != 0) {
					typeArgumentsAppendable.append(", ");
				}
				JvmTypeReference typeArgument = call.getTypeArguments().get(i);
				ITreeAppendable singleTypeArgumentAppendable = typeArgumentsAppendable.trace(typeArgument, false);
				serialize(typeArgument, call, singleTypeArgumentAppendable);
			}
			typeArgumentsAppendable.append(">");
			ILocationData featureAndArgumentLocation = null;
			if (completeLocationData != null) {
				if (argumentsLocationData != null) {
					featureAndArgumentLocation = getLocationWithoutTypeArguments(call);
				}
			}
			ITreeAppendable result = featureAndArgumentLocation != null ? completeFeatureCallAppendable.trace(featureAndArgumentLocation) : completeFeatureCallAppendable;
			return result;
		} else if (call.getFeature() instanceof JvmExecutable) {
			final JvmExecutable executable = (JvmExecutable) call.getFeature();
			if (!executable.getTypeParameters().isEmpty()) {
				XExpression receiver = getActualReceiver(call);
				final JvmTypeReference receiverType = receiver != null ? getType(receiver) : null;
				final JvmTypeReference expectedType = getTypeProvider().getExpectedType(call);
				final List<JvmTypeReference> argumentTypes = Lists.newArrayList();
				for (XExpression argument : getActualArguments(call)) {
					argumentTypes.add(getTypeProvider().getType(argument));
				}

				ITypeArgumentContext typeArgumentContext = getContextProvider().getTypeArgumentContext(
						new XbaseTypeArgumentContextProvider.AbstractFeatureCallRequest() {
							@Override
							public JvmFeature getFeature() {
								return executable;
							}
							
							@Override
							public XAbstractFeatureCall getFeatureCall() {
								return call;
							}

							@Nullable
							@Override
							public JvmTypeParameterDeclarator getNearestDeclarator() {
								EObject context = call;
								JvmTypeParameterDeclarator result = null;
								while (context != null && result == null) {
									if (context instanceof JvmTypeParameterDeclarator) {
										result = (JvmTypeParameterDeclarator) context;
									} else {
										JvmIdentifiableElement logicalContainer = contextProvider
												.getLogicalContainer(context);
										if (logicalContainer != null) {
											context = logicalContainer;
										} else {
											context = context.eContainer();
										}
									}
								}
								return result;
							}

							@Nullable
							@Override
							public JvmTypeReference getDeclaredType() {
								if (executable instanceof JvmOperation)
									return ((JvmOperation) executable).getReturnType();
								return null;
							}

							@Nullable
							@Override
							public JvmTypeReference getReceiverType() {
								return receiverType;
							}

							@Override
							public JvmTypeReference getExpectedType() {
								return expectedType;
							}

							@Override
							public List<JvmTypeReference> getArgumentTypes() {
								return argumentTypes;
							}

							@Override
							public String toString() {
								return "FeatureCallCompiler.featureCalltoJavaExpression [call=" + call + "]";
							}
						});
				List<JvmTypeReference> resolvedTypeArguments = Lists.newArrayList();
				boolean containedUnresolved = false;
				for (int i = 0; i < executable.getTypeParameters().size() && !containedUnresolved; i++) {
					JvmTypeParameter typeParameter = executable.getTypeParameters().get(i);
					JvmTypeReference typeArgument = typeArgumentContext.getBoundArgument(typeParameter);
					if (typeArgument != null) {
						if (isReferenceToForeignTypeParameter(typeArgument, call)) {
							containedUnresolved = true;
						} else if (typeArgument instanceof JvmWildcardTypeReference) {
							containedUnresolved = true;
						} else {
							typeArgument = getPrimitives().asWrapperTypeIfPrimitive(typeArgument);
							if (typeArgument == null)
								throw new IllegalStateException("typeArgument may not be null");
							typeArgument = resolveMultiType(typeArgument, call);
							resolvedTypeArguments.add(typeArgument);
						}
					} else {
						containedUnresolved = true;
					}
				}
				if (!containedUnresolved) {
					completeFeatureCallAppendable.append("<");
					for (int i = 0; i < resolvedTypeArguments.size(); i++) {
						if (i != 0) {
							completeFeatureCallAppendable.append(", ");
						}
						JvmTypeReference typeArgument = resolvedTypeArguments.get(i);
						serialize(typeArgument, call, completeFeatureCallAppendable);
					}
					completeFeatureCallAppendable.append(">");
				}
			}
		}
		return completeFeatureCallAppendable;
	}
	
	@Nullable
	protected ILocationData getLocationWithoutTypeArguments(XAbstractFeatureCall call) {
		final ICompositeNode startNode = NodeModelUtils.getNode(call);
		if (startNode != null) {
			List<INode> resultNodes = Lists.newArrayList();
			if (call instanceof XFeatureCall || call instanceof XMemberFeatureCall) {
				boolean featureReferenceSeen = false;
				for (INode child : startNode.getChildren()) {
					if (featureReferenceSeen) {
						resultNodes.add(child);
					} else {
						EObject grammarElement = child.getGrammarElement();
						if (grammarElement instanceof CrossReference) {
							Assignment assignment = GrammarUtil.containingAssignment(grammarElement);
							if (assignment != null && "feature".equals(assignment.getFeature())) {
								featureReferenceSeen = true;
								resultNodes.add(child);
							}
						}
					}
				}
			}
			return toLocationData(resultNodes);
		}
		return null;
	}

	@Nullable
	protected ILocationData getLocationWithTypeArguments(XAbstractFeatureCall call) {
		final ICompositeNode startNode = NodeModelUtils.getNode(call);
		if (startNode != null) {
			List<INode> resultNodes = Lists.newArrayList();
			if (call instanceof XFeatureCall) {
				for (INode child : startNode.getChildren()) {
					resultNodes.add(child);
				}
			} else if (call instanceof XMemberFeatureCall) {
				boolean keywordSeen = false;
				for (INode child : startNode.getChildren()) {
					if (keywordSeen) {
						resultNodes.add(child);
					} else {
						EObject grammarElement = child.getGrammarElement();
						if (grammarElement instanceof Keyword) {
							keywordSeen = true;
						}
					}
				}
			}
			return toLocationData(resultNodes);
		}
		return null;
	}
	
	@Nullable
	protected ILocationData getLocationOfTypeArguments(XAbstractFeatureCall call) {
		final ICompositeNode startNode = NodeModelUtils.getNode(call);
		if (startNode != null) {
			List<INode> resultNodes = Lists.newArrayList();
			if (call instanceof XFeatureCall) {
				for (INode child : startNode.getChildren()) {
					if (child.getGrammarElement() instanceof CrossReference)
						break;
					resultNodes.add(child);
				}
			} else if (call instanceof XMemberFeatureCall) {
				boolean keywordSeen = false;
				for (INode child : startNode.getChildren()) {
					if (keywordSeen) {
						if (child.getGrammarElement() instanceof CrossReference)
							break;
						resultNodes.add(child);
					} else {
						EObject grammarElement = child.getGrammarElement();
						if (grammarElement instanceof Keyword) {
							keywordSeen = true;
						}
					}
				}
			}
			return toLocationData(resultNodes);
		}
		return null;
	}

	@Nullable
	protected ILocationData toLocationData(List<INode> nodes) {
		ITextRegionWithLineInformation result = ITextRegionWithLineInformation.EMPTY_REGION;
		for (INode node : nodes) {
			if (!isHidden(node)) {
				ITextRegionWithLineInformation region = node.getTextRegionWithLineInformation();
				if (region.getLength() != 0) {
					result = result.merge(new TextRegionWithLineInformation(region.getOffset(), region.getLength(), region.getLineNumber() - 1, region.getEndLineNumber() - 1));
				}
			}
		}
		if (result.getLength() == 0)
			return null;
		return new LocationData(result.getOffset(), result.getLength(), result.getLineNumber(),
				result.getEndLineNumber(), null);
	}

	protected boolean isHidden(INode node) {
		return node instanceof ILeafNode && ((ILeafNode) node).isHidden();
	}

	protected boolean appendReceiver(XAbstractFeatureCall call, ITreeAppendable b, @SuppressWarnings("unused") boolean isExpressionContext) {
		if (call.isStatic()) {
			if (expressionHelper.findInlineAnnotation(call) != null) {
				return false;
			}
			if (call instanceof XMemberFeatureCall) {
				XMemberFeatureCall memberFeatureCall = (XMemberFeatureCall) call;
				if (memberFeatureCall.isStaticWithDeclaringType()) {
					XAbstractFeatureCall target = (XAbstractFeatureCall) memberFeatureCall.getMemberCallTarget();
					JvmType declaringType = (JvmType) target.getFeature();
					b.trace(target, false).append(declaringType);
					return true;
				}
			}
			b.append(((JvmFeature) call.getFeature()).getDeclaringType());
			return true;
		}
		XExpression receiver = getActualReceiver(call);
		if (receiver != null) {
			internalToJavaExpression(receiver, b);
			return true;
		} else {
			return false;
		}
	}
	
	protected void appendNullValue(JvmTypeReference type, EObject context, ITreeAppendable b) {
		if (!primitives.isPrimitive(type)) {
			if (!(type.getType() instanceof JvmVoid)) {
				b.append("(");
				serialize(type, context, b);
				b.append(")");
			}
			b.append("null");
		} else {
			b.append(getDefaultLiteral((JvmPrimitiveType) type.getType()));
		}
	}
	
	protected void appendNullValueUntyped(JvmTypeReference type, @SuppressWarnings("unused") EObject context, ITreeAppendable b) {
		if (!primitives.isPrimitive(type)) {
			b.append("null");
		} else {
			b.append(getDefaultLiteral((JvmPrimitiveType) type.getType()));
		}
	}

	protected String getDefaultLiteral(JvmPrimitiveType primitiveType) {
		final String name = primitiveType.getIdentifier();
		if (Boolean.TYPE.getName().equals(name)) {
			return "false";
		}
		if (Integer.TYPE.getName().equals(name)) {
			return "0";
		}
		if (Byte.TYPE.getName().equals(name)) {
			return "(byte) 0";
		}
		if (Short.TYPE.getName().equals(name)) {
			return "(short) 0";
		}
		if (Character.TYPE.getName().equals(name)) {
			return "(char) 0";
		}
		if (Long.TYPE.getName().equals(name)) {
			return "0l";
		}
		if (Float.TYPE.getName().equals(name)) {
			return "0f";
		}
		if (Double.TYPE.getName().equals(name)) {
			return "0.0";
		}
		throw new IllegalArgumentException("Unkown primitive " + name);
	}

	protected boolean isMemberCall(XAbstractFeatureCall call) {
		return featureCallToJavaMapping.isTargetsMemberSyntaxCall(call, call.getFeature(), call.getImplicitReceiver());
	}

	protected void assignmentToJavaExpression(XAssignment expr, ITreeAppendable b, boolean isExpressionContext) {
		final JvmIdentifiableElement feature = expr.getFeature();
		if (feature instanceof JvmOperation) {
			boolean appendReceiver = appendReceiver(expr, b, isExpressionContext);
			if (appendReceiver)
				b.append(".");
			appendFeatureCall(expr, b);
		} else {
			if (feature instanceof JvmField) {
				boolean appendReceiver = appendReceiver(expr, b, isExpressionContext);
				if (appendReceiver)
					b.append(".");
				appendFeatureCall(expr, b);
			} else {
				String name = b.getName(expr.getFeature());
				b.append(name);
			}
			b.append(" = ");
			internalToJavaExpression(expr.getValue(), b);
		}
	}

	protected void appendFeatureCall(XAbstractFeatureCall call, ITreeAppendable b) {
		if (expressionHelper.isInlined(call)) {
			appendInlineFeatureCall(call, b);
			return;
		}
		JvmIdentifiableElement feature = call.getFeature();
		String name;
		if (feature instanceof JvmConstructor) {
			JvmDeclaredType constructorContainer = ((JvmConstructor) feature).getDeclaringType();
			JvmIdentifiableElement logicalContainer = contextProvider.getNearestLogicalContainer(call);
			JvmDeclaredType contextType = ((JvmMember) logicalContainer).getDeclaringType();
			if (contextType == constructorContainer)
				name = "this";
			else
				name = "super";
		} else {
			if (b.hasName(feature)) {
				name = b.getName(feature);
			} else {
				name = featureNameProvider.getSimpleName(feature);
			}
		}
		if(name == null)
			name = "/* name is null */";
		b.trace(call, XbasePackage.Literals.XABSTRACT_FEATURE_CALL__FEATURE, 0).append(name);
		if (feature instanceof JvmExecutable) {
			b.append("(");
			List<XExpression> arguments = getActualArguments(call);
			if (!arguments.isEmpty()) {
				XExpression receiver = (call instanceof XMemberFeatureCall) ? ((XMemberFeatureCall)call).getMemberCallTarget() : null;
				boolean shouldBreakFirstArgument = receiver == null || arguments.get(0) != receiver;
				appendArguments(arguments, b, shouldBreakFirstArgument);
			}
			b.append(")");
		}
	}

	private Pattern pattern = Pattern.compile("\\$(\\$|[0-9]+)");
	
	@Inject IBatchTypeResolver batchTypeResolver;
	
	protected void appendInlineFeatureCall(XAbstractFeatureCall call, ITreeAppendable b) {
		JvmAnnotationReference inlineAnnotation = expressionHelper.findInlineAnnotation(call);
		String formatString = null;
		List<JvmTypeReference> importedTypes = Lists.newArrayListWithCapacity(2);
		for(JvmAnnotationValue annotationValue: inlineAnnotation.getValues()) {
			if ("value".equals(annotationValue.getValueName())) {
				formatString = ((JvmStringAnnotationValue)annotationValue).getValues().get(0);
			} else if ("imported".equals(annotationValue.getValueName())) {
				JvmTypeAnnotationValue typeAnnotationValue = (JvmTypeAnnotationValue) annotationValue;
				importedTypes.addAll(typeAnnotationValue.getValues());
			}
		}
		if (formatString == null)
			throw new IllegalStateException();
		IResolvedTypes resolvedTypes = batchTypeResolver.resolveTypes(call);
		List<XExpression> arguments = getActualArguments(call);
		Matcher matcher = pattern.matcher(formatString);
		int prevEnd = 0;
		while(matcher.find()) {
			int start = matcher.start();
			if (start != prevEnd) {
				b.append(formatString.substring(prevEnd, start));
			}
			String indexOrDollar = matcher.group(1);
			if ("$".equals(indexOrDollar)) {
				b.append("$");
			} else {
				int index = Integer.parseInt(indexOrDollar) - 1;
				int numberImports = importedTypes.size();
				int numberArguments = arguments.size();
				if (index > numberArguments+numberImports) {
					List<LightweightTypeReference> typeArguments = resolvedTypes.getActualTypeArguments(call);
					LightweightTypeReference typeArgument = typeArguments.get(index - (numberArguments+numberImports+1));
					serialize(typeArgument.getUpperBoundSubstitute().toTypeReference(), call, b);
				} else if (index >= numberArguments && index < numberArguments + numberImports) {
					serialize(importedTypes.get(index - numberArguments), call, b);
				} else if (index == numberArguments + numberImports) {
					appendTypeArguments(call, b);
				} else {
					XExpression argument = arguments.get(index);
					appendArgument(argument, b, index > 0);
				}
			}
			prevEnd = matcher.end();
		}
		if (prevEnd != formatString.length()) {
			b.append(formatString.substring(prevEnd));
		}
	}
	
	protected void appendArguments(List<? extends XExpression> arguments, ITreeAppendable b) {
		appendArguments(arguments, b, true);
	}
	
	protected void appendArguments(List<? extends XExpression> arguments, ITreeAppendable b, boolean shouldWrapLine) {
		for (int i = 0; i < arguments.size(); i++) {
			XExpression argument = arguments.get(i);
			appendArgument(argument, b, shouldWrapLine || i > 0);
			if (i + 1 < arguments.size())
				b.append(", ");
		}
	}
	
	protected void appendArgument(XExpression argument, ITreeAppendable b) {
		appendArgument(argument, b, true);
	}
	
	protected void appendArgument(XExpression argument, ITreeAppendable b, boolean doLineWrappingIfSourceWasWrapped) {
		final String referenceName = getReferenceName(argument, b);
		/*
		 * This is done to support better debugging experience.
		 * Consider the following xbase expression:
		 * 
		 * foo(
		 *   new String())
		 *   
		 *  The compiler could translate that to a single line, but then the two lines in the source would map
		 *  to the same line in the Java code, so it's not possible to have two steps. 
		 *  Therefore we add a newline in the Java if the user had one the expression defined in a new line.
		 */
		final boolean needsNewLine = doLineWrappingIfSourceWasWrapped && referenceName == null && isDeclaredInNewLine(argument);
		if (needsNewLine) {
			b.increaseIndentation();
			b.newLine();
		}
		if (referenceName == null && isVariableDeclarationRequired(argument, b)) {
			JvmTypeReference type = getTypeProvider().getExpectedType(argument);
			if (type == null)
				type = getTypeProvider().getType(argument);
			compileAsJavaExpression(argument, b, type);
		} else {
			internalToJavaExpression(argument, b);
		}
		if (needsNewLine) {
			b.decreaseIndentation();
		}
	}
	
	protected boolean isDeclaredInNewLine(XExpression obj) {
		ICompositeNode node = NodeModelUtils.getNode(obj);
		if (node != null) {
			int line = -1;
			for(ILeafNode n : node.getLeafNodes()) {
				if (n.isHidden() && line == -1)
					line = n.getStartLine();
				if (!n.isHidden() && line != -1)
					return line != n.getStartLine();
			}
		}
		return false;
	}

	protected JvmTypeReference getUpperBound(XAbstractFeatureCall call, final EList<JvmTypeConstraint> constraints) {
		JvmTypeReference typeArg;
		if (constraints.isEmpty()) {
			typeArg = getTypeReferences().getTypeForName(Object.class, call);
		} else {
			typeArg = constraints.get(0).getTypeReference();
		}
		return typeArg;
	}

	protected ILogicalContainerProvider getLogicalContainerProvider() {
		return contextProvider;
	}
	
	protected ILocationInFileProvider getLocationInFileProvider() {
		return locationInFileProvider;
	}
}
