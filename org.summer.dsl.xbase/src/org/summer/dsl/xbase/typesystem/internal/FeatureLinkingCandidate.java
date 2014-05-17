/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.summer.dsl.xbase.typesystem.internal;

import java.util.EnumSet;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jdt.annotation.NonNullByDefault;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.diagnostics.AbstractDiagnostic;
import org.eclipse.xtext.diagnostics.Severity;
import org.eclipse.xtext.util.IAcceptor;
import org.eclipse.xtext.validation.EObjectDiagnosticImpl;
import org.summer.dsl.model.types.JvmConstructor;
import org.summer.dsl.model.types.JvmDeclaredType;
import org.summer.dsl.model.types.JvmExecutable;
import org.summer.dsl.model.types.JvmField;
import org.summer.dsl.model.types.JvmIdentifiableElement;
import org.summer.dsl.model.types.JvmOperation;
import org.summer.dsl.model.types.JvmType;
import org.summer.dsl.model.types.JvmTypeParameter;
import org.summer.dsl.model.xbase.XAbstractFeatureCall;
import org.summer.dsl.model.xbase.XAssignment;
import org.summer.dsl.model.xbase.XBinaryOperation;
import org.summer.dsl.model.xbase.XClosure;
import org.summer.dsl.model.xbase.XExpression;
import org.summer.dsl.model.xbase.XMemberFeatureCall;
import org.summer.dsl.model.xbase.XVariableDeclaration;
import org.summer.dsl.model.xbase.XVariableDeclarationList;
import org.summer.dsl.model.xbase.XbasePackage;
import org.summer.dsl.model.xtype.XFunctionTypeRef;
import org.summer.dsl.xbase.scoping.batch.IFeatureNames;
import org.summer.dsl.xbase.scoping.batch.IIdentifiableElementDescription;
import org.summer.dsl.xbase.typesystem.arguments.IFeatureCallArgumentSlot;
import org.summer.dsl.xbase.typesystem.computation.IFeatureLinkingCandidate;
import org.summer.dsl.xbase.typesystem.computation.ILinkingCandidate;
import org.summer.dsl.xbase.typesystem.computation.ITypeComputationState;
import org.summer.dsl.xbase.typesystem.computation.ITypeExpectation;
import org.summer.dsl.xbase.typesystem.conformance.ConformanceHint;
import org.summer.dsl.xbase.typesystem.internal.util.FeatureKinds;
import org.summer.dsl.xbase.typesystem.references.ITypeReferenceOwner;
import org.summer.dsl.xbase.typesystem.references.LightweightMergedBoundTypeArgument;
import org.summer.dsl.xbase.typesystem.references.LightweightTypeReference;
import org.summer.dsl.xbase.typesystem.references.ParameterizedTypeReference;
import org.summer.dsl.xbase.typesystem.references.WildcardTypeReference;
import org.summer.dsl.xbase.typesystem.util.DeferredTypeParameterHintCollector;
import org.summer.dsl.xbase.typesystem.util.TypeParameterSubstitutor;
import org.summer.dsl.xbase.typesystem.util.VarianceInfo;
import org.summer.dsl.xbase.validation.IssueCodes;

import com.google.common.collect.Lists;

/**
 * A linking candidate that represents a feature call and allows to resolve
 * overloaded members.
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@NonNullByDefault
public class FeatureLinkingCandidate extends AbstractPendingLinkingCandidate<XAbstractFeatureCall> implements IFeatureLinkingCandidate, IFeatureNames {

	public FeatureLinkingCandidate(
			XAbstractFeatureCall featureCall,
			IIdentifiableElementDescription description,
			ITypeExpectation expectation,
			ExpressionTypeComputationState state) {
		super(featureCall, description, expectation, state);
	}
	
	@Override
	protected ILinkingCandidate createAmbiguousLinkingCandidate(AbstractPendingLinkingCandidate<?> second) {
		return new AmbiguousFeatureLinkingCandidate(this, second);
	}
	
	@Override
	protected ILinkingCandidate createSuspiciousLinkingCandidate(AbstractPendingLinkingCandidate<?> chosenCandidate) {
		return new SuspiciouslyOverloadedCandidate((FeatureLinkingCandidate) chosenCandidate, this);
	}
	
	@Override
	protected boolean isRawTypeContext() {
		LightweightTypeReference receiverType = getReceiverType();
		if(receiverType != null && receiverType.isRawType()) {
			return true;
		}
		return false;
	}
	
	@Override
	protected void initializeMapping(JvmTypeParameter typeParameter, Map<JvmTypeParameter, LightweightMergedBoundTypeArgument> result) {
		ITypeReferenceOwner owner = getState().getReferenceOwner();
		if (typeParameter.getDeclarator() instanceof JvmType && owner.getDeclaredTypeParameters().contains(typeParameter)) {
			ParameterizedTypeReference typeReference = new ParameterizedTypeReference(owner, typeParameter);
			result.put(typeParameter, new LightweightMergedBoundTypeArgument(typeReference, VarianceInfo.INVARIANT));
		} else {
			super.initializeMapping(typeParameter, result);
		}
	}

	/**
	 * Returns the actual arguments of the expression. These do not include the
	 * receiver.  
	 */
	@Override
	protected List<XExpression> getArguments() {
		List<XExpression> syntacticArguments = getSyntacticArguments();
		XExpression firstArgument = getFirstArgument();
		if (firstArgument != null) {
			return createArgumentList(firstArgument, syntacticArguments);
		}
		return syntacticArguments;
	}
	
	/**
	 * Validates this linking candidate and adds respective diagnostics to the given queue.
	 * 
	 * In addition to the checks that are inherited from {@link AbstractPendingLinkingCandidate#validate(IAcceptor)},
	 * the candidate is validated according these criteria:
	 * 
	 * <ol>
	 * <li>{@link #isInvalidStaticSyntax() syntax for static feature calls},</li>
	 * <li>{@link #isStatic() static context for static members},</li>
	 * <li>field accessed as a method, e.g. with parentheses,</li>
	 * <li>attempt to access {@code this} in a static context,</li>
	 * <li>attempt to enclose a non-final local variable in a lambda expression,</li>
	 * <li>{@link #isGetClassOnTypeLiteral() errorprone invocation of getClass()}.</li>
	 * </ol>
	 */
	@Override
	public boolean validate(IAcceptor<? super AbstractDiagnostic> result) {
		if (isInvalidStaticSyntax()) {
			String message = String.format("The static %1$s %2$s%3$s should be accessed in a static way",
					getFeatureTypeName(),
					getFeature().getSimpleName(),
					getFeatureParameterTypesAsString());
			AbstractDiagnostic diagnostic = new EObjectDiagnosticImpl(Severity.ERROR,
					IssueCodes.INSTANCE_ACCESS_TO_STATIC_MEMBER, message, getExpression(),
					XbasePackage.Literals.XABSTRACT_FEATURE_CALL__FEATURE, -1, null);
			result.accept(diagnostic);
			return false;
		} else if (!isStatic() && isStaticAccessSyntax()) {
			EObject featureOwner = getFeature().eContainer();
			String message = String.format("Cannot make a static reference to the non-static %1$s %2$s%3$s",
					getFeatureTypeName(),
					getFeature().getSimpleName(),
					getFeatureParameterTypesAsString());
			if(featureOwner instanceof JvmDeclaredType) 
				message += " from the type " + ((JvmDeclaredType) featureOwner).getSimpleName();
			AbstractDiagnostic diagnostic = new EObjectDiagnosticImpl(Severity.ERROR,
					IssueCodes.STATIC_ACCESS_TO_INSTANCE_MEMBER, message, getExpression(),
					XbasePackage.Literals.XABSTRACT_FEATURE_CALL__FEATURE, -1, null);
			result.accept(diagnostic);
			return false;
		} else if (super.validate(result)) {   
//			if (isExplicitOperationCallOrBuilderSyntax() && !(getFeature() instanceof JvmExecutable)) {   // cym comment
			if (isExplicitOperationCallOrBuilderSyntax() && !(getFeature() instanceof JvmExecutable || getFeature() instanceof XClosure 
					|| (getFeature() instanceof XVariableDeclaration && ((XVariableDeclaration)getFeature()).getType() instanceof XFunctionTypeRef) )
					) {   
				String typeName = getFeatureTypeName();
				String code = IssueCodes.FIELD_ACCESS_WITH_PARENTHESES;
				if (!(getFeature() instanceof JvmField)) {
					code = IssueCodes.LOCAL_VAR_ACCESS_WITH_PARENTHESES;
				}
				String message = "Cannot access the " + typeName + " " + getFeature().getSimpleName() + " with parentheses";
				AbstractDiagnostic diagnostic = new EObjectDiagnosticImpl(Severity.ERROR, code, message,
						getExpression(), XbasePackage.Literals.XABSTRACT_FEATURE_CALL__FEATURE, -1, null);
				result.accept(diagnostic);
				return false;
			}
			if (getFeature() instanceof JvmType && !getState().isInstanceContext()) {
				String featureName = getFeatureCall().getConcreteSyntaxFeatureName();
				if (!(SELF.getFirstSegment().equals(featureName))) {
					String message = String.format("Cannot use %s in a static context", getFeatureCall().getConcreteSyntaxFeatureName());
					AbstractDiagnostic diagnostic = new EObjectDiagnosticImpl(Severity.ERROR,
							IssueCodes.STATIC_ACCESS_TO_INSTANCE_MEMBER, message, getExpression(),
							XbasePackage.Literals.XABSTRACT_FEATURE_CALL__FEATURE, -1, null);
					result.accept(diagnostic);
					return false;
				}
			}
			JvmIdentifiableElement feature = getFeature();
			if (feature instanceof XVariableDeclaration && ((XVariableDeclarationList)((XVariableDeclaration) feature).eContainer()).isReadonly()) {
				XClosure containingClosure = EcoreUtil2.getContainerOfType(getExpression(), XClosure.class);
				if (containingClosure != null && !EcoreUtil.isAncestor(containingClosure, feature)) {
					String message = String.format("Cannot refer to the non-final variable %s inside a lambda expression", feature.getSimpleName());
					AbstractDiagnostic diagnostic = new EObjectDiagnosticImpl(Severity.ERROR,
							IssueCodes.INVALID_MUTABLE_VARIABLE_ACCESS, message, getExpression(),
							XbasePackage.Literals.XABSTRACT_FEATURE_CALL__FEATURE, -1, null);
					result.accept(diagnostic);
					return false;
				}
			}
		}
		if (isGetClassOnTypeLiteral()) {
			if ("class".equals(description.getName().getFirstSegment())) {
				LightweightTypeReference receiverType = getSyntacticReceiverType();
				if (receiverType == null) {
					throw new IllegalStateException();
				}
				receiverType = receiverType.getTypeArguments().get(0);
				String message = String.format("The syntax for type literals is typeof(%s) or %s.", receiverType.getSimpleName(), receiverType.getSimpleName());
				AbstractDiagnostic diagnostic = new EObjectDiagnosticImpl(
						Severity.ERROR,
						IssueCodes.UNEXPECTED_INVOCATION_ON_TYPE_LITERAL,
						message, 
						getExpression(),
						XbasePackage.Literals.XABSTRACT_FEATURE_CALL__FEATURE, 
						-1, 
						null);
				result.accept(diagnostic);
				return false;
			}
		}
		return true;
	}
	
	/**
	 * Returns <code>true</code> if a static member is accessed with an instance receiver,
	 * e.g. {@code myLocalVariable.STATIC_METHOD(..)} or {@code myLocalVariable.STATIC_FIELD = null}.
	 */
	protected boolean isInvalidStaticSyntax() {
		boolean result = isStatic() && !isExtension() && isAssignmentOrMemberFeatureCall() && !isStaticWithDeclaringType();
		if (result)
			return true;
		return false;
	}

	protected boolean isStaticWithDeclaringType() {
		XAbstractFeatureCall featureCall = getFeatureCall();
		if (featureCall instanceof XMemberFeatureCall) {
			return ((XMemberFeatureCall) featureCall).isStaticWithDeclaringType();
		}
		if (featureCall instanceof XAssignment) {
			return isStaticWithDeclaringType((XAssignment) featureCall);
		}
		return false;
	}

	protected boolean isStaticWithDeclaringType(XAssignment assignment) {
		return  assignment.isExplicitStatic() || isImplicitlyStatic(assignment);
	}

	protected boolean isImplicitlyStatic(XAssignment assignment) {
		return assignment.isStatic() && isTypeLiteral(assignment.getAssignable());
	}

	protected boolean isTypeLiteral(XExpression expression) {
		return expression instanceof XAbstractFeatureCall && ((XAbstractFeatureCall) expression).isTypeLiteral();
	}

	protected boolean isExplicitOperationCallOrBuilderSyntax() {
		XAbstractFeatureCall featureCall = getFeatureCall();
		if (featureCall instanceof XBinaryOperation || featureCall instanceof XAssignment) {
			return false;
		}
		return featureCall.isExplicitOperationCallOrBuilderSyntax();
	}

	@Override
	protected String getFeatureTypeName() {
		JvmIdentifiableElement feature = getFeature();
		String result = FeatureKinds.getTypeName(feature);
		return result;
	}

	protected boolean isStaticAccessSyntax() {
		XAbstractFeatureCall featureCall = getFeatureCall();
		if (featureCall instanceof XMemberFeatureCall) {
			return ((XMemberFeatureCall) featureCall).isExplicitStatic();
		}
		return false;
	}
	
	protected boolean isAssignmentOrMemberFeatureCall() {
		if (getImplicitReceiverType() != null)
			return true;
		XAbstractFeatureCall featureCall = getFeatureCall();
		if (featureCall instanceof XAssignment) {
			return isSimpleAssignment((XAssignment) featureCall);
		}
		return featureCall instanceof XMemberFeatureCall;
	}

	protected boolean isSimpleAssignment(XAssignment assignment) {
		return assignment.getAssignable() != null;
	}

	protected List<XExpression> createArgumentList(XExpression head, List<XExpression> tail) {
		// TODO investigate in optimized List impls like HEAD, syntacticArguments
		List<XExpression> result = Lists.newArrayListWithExpectedSize(tail.size() + 1);
		result.add(head);
		for(XExpression expression: tail) {
			// addAll will convert the tail to an array, first which is not necessary at all
			result.add(expression);
		}
		return result;
	}
	
	@Override
	public int getArityMismatch() {
		int result = super.getArityMismatch();
		if (isStatic() && (getImplicitReceiver() != null || getSyntacticReceiverIfPossibleArgument() != null && !isExtension())) {
			if (result < 0)
				result--;
			else
				result++;
		}
		return result;
	}
	
	@Override
	protected List<XExpression> getSyntacticArguments() {
		return new FeatureLinkHelper().getSyntacticArguments(getFeatureCall());
	}
	
	@Override
	public boolean isExtension() {
		return description.isExtension();
	}
	
	@Override
	protected boolean hasReceiver() {
		return !isStatic();
	}
	
	public boolean isStatic() {
		return description.isStatic();
	}
	
	/**
	 * Returns <code>true</code> if the linked receiver could be 
	 * a possible argument of this feature. Basically it's false if
	 * this feature is an error feature, a local variable or a if the
	 * receiver is a type literal that's treated as a static qualifier
	 * rather than a literal expression.
	 */
	protected boolean isSyntacticReceiverPossibleArgument() {
		return description.isSyntacticReceiverPossibleArgument();
	}
	
	@Override
	public boolean isTypeLiteral() {
		return false;
	}
	
	@Override
	protected CandidateCompareResult getExpectedTypeCompareResultOther(AbstractPendingLinkingCandidate<?> right) {
		if (!(right instanceof FeatureLinkingCandidate) || getState().isIgnored(IssueCodes.SUSPICIOUSLY_OVERLOADED_FEATURE))
			return CandidateCompareResult.OTHER;
		
		FeatureLinkingCandidate casted = (FeatureLinkingCandidate) right;
		XExpression otherImplicitReceiver = casted.getImplicitReceiver();
		if (otherImplicitReceiver instanceof XAbstractFeatureCall && getImplicitReceiver() instanceof XAbstractFeatureCall) {
			JvmIdentifiableElement otherImplicitReceiverFeature = ((XAbstractFeatureCall) otherImplicitReceiver).getFeature();
			if (otherImplicitReceiverFeature != ((XAbstractFeatureCall) getImplicitReceiver()).getFeature())
				return CandidateCompareResult.SUSPICIOUS_OTHER;
		}
		return CandidateCompareResult.OTHER;
	}
	
	@Override
	protected EnumSet<ConformanceHint> getConformanceHints(int idx, boolean recompute) {
		if (idx == 0) {
			if (getReceiver() != null) {
				EnumSet<ConformanceHint> result = getReceiverConformanceHints();
				return result;
			}
		}
		return super.getConformanceHints(idx, recompute);
	}
	
	@Override
	@Nullable
	protected LightweightTypeReference getSubstitutedExpectedType(int idx) {
		if (idx == 0) {
			if (getReceiver() != null) {
				return null;
			}
		}
		return super.getSubstitutedExpectedType(idx);
	}
	
	protected boolean isExplicitOperationCall() {
		return getFeatureCall().isExplicitOperationCallOrBuilderSyntax();
	}
	
	@Override
	protected CandidateCompareResult compareByBucket(AbstractPendingLinkingCandidate<?> right) {
		if (isExtension() && right.isExtension()) {
			if (description.getShadowingKey().equals(right.description.getShadowingKey())) {
				if (description.getBucketId() == right.description.getBucketId()) {
					return CandidateCompareResult.AMBIGUOUS;
				}
				if (isAmbiguousExtensionProvider(right)) {
					return CandidateCompareResult.AMBIGUOUS;
				}
				return CandidateCompareResult.THIS;
			}
			return CandidateCompareResult.AMBIGUOUS;
		}
		return super.compareByBucket(right);
	}
	
	protected boolean isAmbiguousExtensionProvider(AbstractPendingLinkingCandidate<?> right) {
		XExpression implicitReceiver = getImplicitReceiver();
		if (implicitReceiver instanceof XAbstractFeatureCall) {
			XExpression otherImplicitReceiver = right.description.getImplicitReceiver();
			if (otherImplicitReceiver instanceof XAbstractFeatureCall) {
				JvmIdentifiableElement feature = ((XAbstractFeatureCall) implicitReceiver).getFeature();
				JvmIdentifiableElement otherFeature = ((XAbstractFeatureCall) otherImplicitReceiver).getFeature();
				// e.g. two local variables in same block
				if (feature.eContainer() == otherFeature.eContainer()) {
					return true;
				}
			}
		}
		return false;
	}
	
	@Override
	protected CandidateCompareResult compareByArityWith(AbstractPendingLinkingCandidate<?> right) {
		CandidateCompareResult result = super.compareByArityWith(right);
		if (result == CandidateCompareResult.AMBIGUOUS) {
			boolean isExecutable = getFeature() instanceof JvmExecutable;
			if (isExecutable != right.getFeature() instanceof JvmExecutable && isVisible() == right.isVisible() && isTypeLiteral() == right.isTypeLiteral()) {
				// TODO this code looks bogus to me (we need to verify why / if we need this)
				if (getExpression() instanceof XAssignment) {
					if (isExecutable)
						return CandidateCompareResult.OTHER;
					return CandidateCompareResult.THIS;
				} else {
					if (isExplicitOperationCall()) {
						if (isExecutable)
							return CandidateCompareResult.THIS;
						return CandidateCompareResult.OTHER;
					} else {
						if (isExecutable)
							return CandidateCompareResult.OTHER;
						return CandidateCompareResult.THIS;
					}
				}
			} else if (getFeature() == right.getFeature() && right instanceof FeatureLinkingCandidate) {
				FeatureLinkingCandidate casted = (FeatureLinkingCandidate) right;
				// we link to identical static features with equal assumptions
				// stop comparison and take this one
				if (isStatic() && casted.isStatic() && getReceiver() == casted.getReceiver()) {
					return CandidateCompareResult.THIS;
				}
			}
		}
		return result;
	}
	
	@Override
	protected CandidateCompareResult compareByArgumentTypes(AbstractPendingLinkingCandidate<?> right, int argumentIndex, EnumSet<ConformanceHint> leftConformance,
			EnumSet<ConformanceHint> rightConformance) {
		CandidateCompareResult result = super.compareByArgumentTypes(right, argumentIndex, leftConformance, rightConformance);
		if ((result != CandidateCompareResult.EQUALLY_INVALID && result != CandidateCompareResult.AMBIGUOUS) 
				|| leftConformance.contains(ConformanceHint.SUCCESS) || !(right instanceof FeatureLinkingCandidate))
			return result;
		// both types do not match - pick the one which is not an extension
		boolean firstArgumentMismatch = isFirstArgument(argumentIndex);
		boolean rightFirstArgumentMismatch = ((FeatureLinkingCandidate) right).isFirstArgument(argumentIndex);
		if (firstArgumentMismatch != rightFirstArgumentMismatch) {
			if (firstArgumentMismatch)
				return CandidateCompareResult.OTHER;
			return CandidateCompareResult.THIS;
		}
		return result;
	}
	
	protected boolean isFirstArgument(int argumentIndex) {
		if (argumentIndex > 1 || getFirstArgument() == null)
			return false;
		if (isStatic())
			return argumentIndex == 0;
		return argumentIndex == 1;
	}
	
	@Override
	protected CandidateCompareResult compareByArgumentTypes(AbstractPendingLinkingCandidate<?> right, int leftBoxing, int rightBoxing, int leftDemand, int rightDemand) {
		if (leftDemand != rightDemand) {
			if (leftDemand < rightDemand)
				return CandidateCompareResult.THIS;
			return CandidateCompareResult.OTHER;
		}
		if (right instanceof FeatureLinkingCandidate) {
			FeatureLinkingCandidate casted = (FeatureLinkingCandidate) right;
			if (isExtension() != casted.isExtension()) {
				if (isExtension())
					return CandidateCompareResult.OTHER;
				return CandidateCompareResult.THIS;
			}
			if (isStatic() != casted.isStatic()) {
				if (isSyntacticReceiverPossibleArgument() == casted.isSyntacticReceiverPossibleArgument()) {
					if (isStatic()) {
						return CandidateCompareResult.OTHER;
					}
					return CandidateCompareResult.THIS;
				} else {
					if (isStatic() && !isSyntacticReceiverPossibleArgument())
						return CandidateCompareResult.THIS;
					if (casted.isStatic() && !casted.isSyntacticReceiverPossibleArgument()) {
						return CandidateCompareResult.OTHER;
					}
				}
			}
		}
		if (leftBoxing != rightBoxing) {
			if (leftBoxing < rightBoxing)
				return CandidateCompareResult.THIS;
			return CandidateCompareResult.OTHER;
		}
		return CandidateCompareResult.AMBIGUOUS;
	}
	
	@Override
	protected void preApply() {
		applyImplicitReceiver();
		super.preApply();
		XExpression implicitFirstArgument = getImplicitFirstArgument();
		if (implicitFirstArgument != null) {
			new ImplicitFirstArgument(getFeatureCall(), (XAbstractFeatureCall) implicitFirstArgument, getState()).applyToComputationState();
		}
		getState().markAsRefinedTypeIfNecessary(this);
	}
	
	protected void applyImplicitReceiver() {
		if (!isStatic()) {
			XExpression implicitReceiver = getImplicitReceiver();
			if (implicitReceiver != null) {
				ResolvedTypes resolvedTypes = getState().getResolvedTypes();
				LightweightTypeReference receiverType = getImplicitReceiverType();
				if (receiverType == null) {
					throw new IllegalStateException("Cannot determine the receiver's type");
				}
				LightweightTypeReference expectedReceiverType = new FeatureLinkHelper().getExpectedReceiverType(getFeature(), receiverType);
				if (expectedReceiverType != null)
					expectedReceiverType = expectedReceiverType.copyInto(resolvedTypes.getReferenceOwner());
				if (receiverType.isSynonym()) {
					receiverType = receiverType.getMultiTypeComponents().get(0);
				}
				TypeExpectation expectation = new TypeExpectation(expectedReceiverType, getState(), false);
				resolvedTypes.acceptType(implicitReceiver, expectation, receiverType.copyInto(resolvedTypes.getReferenceOwner()), false, ConformanceHint.UNCHECKED);
				if (implicitReceiver instanceof XAbstractFeatureCall) {
					new ImplicitReceiver(getFeatureCall(), (XAbstractFeatureCall) implicitReceiver, getState()).applyToComputationState();
				} else {
					throw new IllegalStateException("unexpected implicit receiver, was: " + implicitReceiver);
				}
			}
		}
	}

	@Override
	protected void resolveAgainstActualType(LightweightTypeReference declaredType, LightweightTypeReference actualType, final AbstractTypeComputationState state) {
		super.resolveAgainstActualType(declaredType, actualType, state);
		if (!isStatic() || ((!actualType.getTypeArguments().isEmpty() || actualType.isArray()) && getDeclaredTypeParameters().isEmpty())) {
			DeferredTypeParameterHintCollector collector = new DeferredTypeParameterHintCollector(state.getReferenceOwner());
			collector.processPairedReferences(declaredType, actualType);
		}
	}

	public XAbstractFeatureCall getFeatureCall() {
		return getExpression();
	}
	
	@Override
	protected List<LightweightTypeReference> getSyntacticTypeArguments() {
		return Lists.transform(getFeatureCall().getTypeArguments(), getState().getResolvedTypes().getConverter());
	}
	
	@Override
	protected void resolveArgumentType(XExpression argument, @Nullable LightweightTypeReference declaredType, ITypeComputationState argumentState) {
		if (argument == getSyntacticReceiverIfPossibleArgument()) {
			LightweightTypeReference receiverType = getSyntacticReceiverType();
			if (receiverType != null) {
				resolveKnownArgumentType(argument, receiverType, declaredType, argumentState);
			}
		} else if (argument == getImplicitFirstArgument()) {
			LightweightTypeReference argumentType = getImplicitFirstArgumentType();
			if (argumentType != null) {
				resolveKnownArgumentType(argument, argumentType, declaredType, argumentState);
			}
		} else {
			super.resolveArgumentType(argument, declaredType, argumentState);
		}
	}

	// TODO some code is duplicated in ResolvedFeature - extract delegator
	protected void resolveKnownArgumentType(XExpression argument, LightweightTypeReference knownType,
			@Nullable LightweightTypeReference declaredType, ITypeComputationState argumentState) {
		if (!(argumentState instanceof AbstractLinkingCandidate.ArgumentTypeComputationState))
			throw new IllegalArgumentException("argumentState was " + argumentState);
		AbstractLinkingCandidate<?>.ArgumentTypeComputationState castedArgumentState = (AbstractLinkingCandidate<?>.ArgumentTypeComputationState) argumentState;
		ResolvedTypes resolvedTypes = getState().getResolvedTypes();
		LightweightTypeReference copiedDeclaredType = declaredType != null ? declaredType.copyInto(resolvedTypes.getReferenceOwner()) : null;
		TypeExpectation expectation = new TypeExpectation(copiedDeclaredType, castedArgumentState, false);
		LightweightTypeReference copiedReceiverType = knownType.copyInto(resolvedTypes.getReferenceOwner());
		// TODO should we use the result of #acceptType?
		ConformanceHint defaultHint = castedArgumentState.getDefaultHint();
		if (defaultHint == null)
			resolvedTypes.acceptType(argument, expectation, copiedReceiverType, false, ConformanceHint.UNCHECKED);
		else
			resolvedTypes.acceptType(argument, expectation, copiedReceiverType, false, ConformanceHint.UNCHECKED, defaultHint);
		if (copiedDeclaredType != null)
			resolveAgainstActualType(copiedDeclaredType, copiedReceiverType, castedArgumentState);
	}
	
	@Override
	protected void computeVarArgumentType(IFeatureCallArgumentSlot slot, TypeParameterSubstitutor<?> substitutor) {
		if (isExtension()) {
			List<XExpression> arguments = slot.getArgumentExpressions();
			if (arguments.size() == 1 && arguments.get(0) == getFirstArgument()) {
				computeFixedArityArgumentType(slot, substitutor);
				return;
			}
		}
		super.computeVarArgumentType(slot, substitutor);
	}
	
	@Override
	protected Map<JvmTypeParameter, LightweightMergedBoundTypeArgument> getDeclaratorParameterMapping() {
		if (isStatic()) {
			if (getFeature() instanceof JvmConstructor) // this() or super()
				return description.getImplicitReceiverTypeParameterMapping();
			return super.getDeclaratorParameterMapping();
		}
		if (getImplicitReceiver() != null)
			return description.getImplicitReceiverTypeParameterMapping();
		return description.getSyntacticReceiverTypeParameterMapping();
	}
	
	@Nullable
	protected XExpression getReceiver() {
		if (isStatic())
			return null;
		XExpression result = getImplicitReceiver();
		if (result != null)
			return result;
		return getSyntacticReceiverIfPossibleArgument();
	}

	@Nullable
	protected LightweightTypeReference getReceiverType() {
		if (isStatic())
			return null;
		LightweightTypeReference result;
		if (getImplicitReceiver() != null)
			result = getImplicitReceiverType();
		else
			result = getSyntacticReceiverType();
		return result;
	}
	
	protected EnumSet<ConformanceHint> getReceiverConformanceHints() {
		if (isStatic())
			throw new IllegalStateException();
		if (getImplicitReceiver() != null) {
			return description.getImplicitReceiverConformanceHints();
		} else if (getSyntacticReceiverIfPossibleArgument() != null) {
			return description.getSyntacticReceiverConformanceHints();
		}
		throw new IllegalStateException();
	}
	
	/**
	 * Returns the first argument if this is an extension. This may be
	 * the implicit first argument or the syntactic receiver of the feature call.
	 */
	@Nullable
	protected XExpression getFirstArgument() {
		if (!isExtension())
			return null;
		XExpression firstArgument = getImplicitFirstArgument();
		if (firstArgument != null)
			return firstArgument;
		return getSyntacticReceiverIfPossibleArgument();
	}

	@Nullable
	protected LightweightTypeReference getFirstArgumentType() {
		if (!isExtension())
			return null;
		LightweightTypeReference result = getImplicitFirstArgumentType();
		if (result != null)
			return result;
		return getSyntacticReceiverType();
	}
	
	@Nullable
	protected XExpression getImplicitReceiver() {
		return description.getImplicitReceiver();
	}
	
	@Nullable
	protected LightweightTypeReference getImplicitReceiverType() {
		return description.getImplicitReceiverType();
	}
	
	@Nullable
	protected XExpression getSyntacticReceiver() {
		return description.getSyntacticReceiver();
	}
	
	/**
	 * Returns the syntactic receiver if it is an expression.
	 * Type literals are not considered to be expressions thus <code>null</code>
	 * is returned as the syntactic receiver of the expression <code>valueOf(..)</code>
	 * in <code>java.lang.String.valueOf(..)</code>.
	 */
	@Nullable
	protected XExpression getSyntacticReceiverIfPossibleArgument() {
		if (description.isSyntacticReceiverPossibleArgument())
			return getSyntacticReceiver();
		return null;
	}
	
	@Nullable
	protected LightweightTypeReference getSyntacticReceiverType() {
		return description.getSyntacticReceiverType();
	}
	
	@Nullable
	protected XExpression getImplicitFirstArgument() {
		return description.getImplicitFirstArgument();
	}
	
	@Nullable
	protected LightweightTypeReference getImplicitFirstArgumentType() {
		return description.getImplicitFirstArgumentType();
	}
	
	@Override
	protected LightweightTypeReference getDeclaredType(JvmIdentifiableElement feature) {
		if (feature instanceof JvmConstructor) {
			return getState().getConverter().toLightweightReference(getState().getTypeReferences().getTypeForName(Void.TYPE, feature));
		}
		/*
		 * The actual result type is Class<? extends |X|> where |X| is the erasure of 
		 * the static type of the expression on which getClass is called. For example, 
		 * no cast is required in this code fragment:
		 *   Number n = 0;
		 *   Class<? extends Number> c = n.getClass();
		 */
		if (isGetClass(feature)) {
			LightweightTypeReference receiverType = getReceiverType();
			if (receiverType == null) {
				throw new IllegalStateException("Cannot determine the receiver's type");
			}
			List<JvmType> rawTypes = receiverType.getRawTypes();
			if (rawTypes.isEmpty()) {
				return super.getDeclaredType(feature);
			}
			ParameterizedTypeReference result = new ParameterizedTypeReference(receiverType.getOwner(), ((JvmOperation) feature).getReturnType().getType());
			WildcardTypeReference wildcard = new WildcardTypeReference(receiverType.getOwner());
			wildcard.addUpperBound(new ParameterizedTypeReference(receiverType.getOwner(), rawTypes.get(0)));
			result.addTypeArgument(wildcard);
			return result;
		}
		return super.getDeclaredType(feature);
	}
	
	/**
	 * Returns <code>true</code> if the method {@link Class#getClass()} is bound and
	 * the receiver is a type literal. This may indicate a bug.
	 */
	protected boolean isGetClassOnTypeLiteral() {
		JvmIdentifiableElement feature = getFeature();
		if (isGetClass(feature)) {
			XExpression receiver = getSyntacticReceiver();
			if (receiver instanceof XAbstractFeatureCall) {
				IFeatureLinkingCandidate linkingCandidate = getState().getResolvedTypes().getLinkingCandidate((XAbstractFeatureCall) receiver);
				if (linkingCandidate != null && linkingCandidate.isTypeLiteral()) {
					return true;
				}
			}
		}
		return false;
	}
	
	protected boolean isGetClass(JvmIdentifiableElement feature) {
		if (feature instanceof JvmOperation && feature.getSimpleName().equals("getClass")) {
			JvmOperation getClassOperation = (JvmOperation) feature;
			if (getClassOperation.getParameters().isEmpty() && "java.lang.Object".equals(getClassOperation.getDeclaringType().getIdentifier())) {
				return true;
			}
		}
		return false;
	}
	
	public void applyToModel() {
		resolveLinkingProxy(XbasePackage.Literals.XABSTRACT_FEATURE_CALL__FEATURE, XbasePackage.XABSTRACT_FEATURE_CALL__FEATURE);
		XAbstractFeatureCall featureCall = getFeatureCall();
		if (featureCall instanceof XMemberFeatureCall) {
			XMemberFeatureCall casted = (XMemberFeatureCall) featureCall;
			XExpression syntacticReceiver = casted.getMemberCallTarget();
			if (isStatic() && syntacticReceiver instanceof XAbstractFeatureCall && !isExtension()) {
				IFeatureLinkingCandidate candidate = getState().getResolvedTypes().getLinkingCandidate((XAbstractFeatureCall) syntacticReceiver);
				if (candidate != null && candidate.isTypeLiteral()) {
					((XMemberFeatureCall) featureCall).setStaticWithDeclaringType(true);
				}
			}
		}
	}

}
