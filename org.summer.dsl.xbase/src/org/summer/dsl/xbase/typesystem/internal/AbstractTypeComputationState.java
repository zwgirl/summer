/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.summer.dsl.xbase.typesystem.internal;

import java.util.Arrays;
import java.util.Collections;
import java.util.EnumSet;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.NonNullByDefault;
import org.eclipse.jdt.annotation.Nullable;
import org.summer.dsl.model.types.JvmConstructor;
import org.summer.dsl.model.types.JvmDeclaredType;
import org.summer.dsl.model.types.JvmIdentifiableElement;
import org.summer.dsl.model.types.JvmType;
import org.summer.dsl.model.types.JvmTypeParameter;
import org.summer.dsl.model.types.util.TypeReferences;
import org.eclipse.xtext.diagnostics.AbstractDiagnostic;
import org.eclipse.xtext.diagnostics.Severity;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.validation.EObjectDiagnosticImpl;
import org.eclipse.xtext.validation.IssueSeverities;
import org.summer.dsl.model.xbase.XAbstractFeatureCall;
import org.summer.dsl.model.xbase.XConstructorCall;
import org.summer.dsl.model.xbase.XExpression;
import org.summer.dsl.model.xbase.XFeatureCall;
import org.summer.dsl.model.xbase.XbasePackage;
import org.summer.dsl.xbase.scoping.batch.IFeatureScopeSession;
import org.summer.dsl.xbase.scoping.batch.IIdentifiableElementDescription;
import org.summer.dsl.xbase.scoping.batch.SimpleIdentifiableElementDescription;
import org.summer.dsl.xbase.typesystem.IResolvedTypes;
import org.summer.dsl.xbase.typesystem.computation.IConstructorLinkingCandidate;
import org.summer.dsl.xbase.typesystem.computation.IFeatureLinkingCandidate;
import org.summer.dsl.xbase.typesystem.computation.ITypeComputationResult;
import org.summer.dsl.xbase.typesystem.computation.ITypeComputationState;
import org.summer.dsl.xbase.typesystem.computation.ITypeComputer;
import org.summer.dsl.xbase.typesystem.computation.ITypeExpectation;
import org.summer.dsl.xbase.typesystem.conformance.ConformanceHint;
import org.summer.dsl.xbase.typesystem.references.AnyTypeReference;
import org.summer.dsl.xbase.typesystem.references.ITypeReferenceOwner;
import org.summer.dsl.xbase.typesystem.references.LightweightTypeReference;
import org.summer.dsl.xbase.typesystem.references.OwnedConverter;
import org.summer.dsl.xbase.typesystem.references.UnboundTypeReference;
import org.summer.dsl.xbase.typesystem.util.Maps2;
import org.summer.dsl.xbase.validation.IssueCodes;

import com.google.common.base.Strings;
import com.google.common.collect.Lists;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * @author Moritz Eysholdt
 * 
 * TODO JavaDoc
 */
@NonNullByDefault
public abstract class AbstractTypeComputationState implements ITypeComputationState {
	protected final ResolvedTypes resolvedTypes;
	protected IFeatureScopeSession featureScopeSession;
	private final DefaultReentrantTypeResolver reentrantTypeResolver;
	private List<AbstractTypeExpectation> expectations;
	
	// is this field actually used?
	private List<AbstractTypeExpectation> returnExpectations;
	
	protected AbstractTypeComputationState(ResolvedTypes resolvedTypes,
			IFeatureScopeSession featureScopeSession) {
		this.resolvedTypes = resolvedTypes;
		this.featureScopeSession = featureScopeSession;
		this.reentrantTypeResolver = resolvedTypes.getResolver();
	}
	
	public ResolvedTypes getResolvedTypes() {
		return resolvedTypes;
	}
	
	public IFeatureScopeSession getFeatureScopeSession() {
		return featureScopeSession;
	}
	
	public TypeReferences getTypeReferences() {
		return reentrantTypeResolver.getServices().getTypeReferences();
	}
	
	public ITypeComputer getTypeComputer() {
		return reentrantTypeResolver.getTypeComputer();
	}
	
	public DefaultReentrantTypeResolver getResolver() {
		return reentrantTypeResolver;
	}
	
	protected abstract LightweightTypeReference acceptType(ResolvedTypes types, AbstractTypeExpectation expectation, LightweightTypeReference type, boolean returnType, ConformanceHint... conformanceHint);
	protected abstract LightweightTypeReference acceptType(XExpression alreadyHandled, ResolvedTypes types, AbstractTypeExpectation expectation, LightweightTypeReference type, boolean returnType, ConformanceHint... conformanceHint);
	
	public final ITypeComputationResult computeTypes(@Nullable XExpression expression) {
		if (expression != null) {
			if (expression.eContainer() == null && expression.eResource() == null)
				throw new IllegalStateException("Dangling expression: " + expression);
			assert getResolvedTypes().doGetTypeData(expression) == null : "Expression was already resolved: " + expression;  
			ExpressionAwareStackedResolvedTypes stackedResolvedTypes = doComputeTypes(expression);
			stackedResolvedTypes.performMergeIntoParent();
			return new ResolutionBasedComputationResult(expression, resolvedTypes);
		} else {
			return new NoTypeResult(null, getReferenceOwner());
		}
	}
	
	protected ExpressionAwareStackedResolvedTypes doComputeTypes(XExpression expression) {
		ExpressionAwareStackedResolvedTypes stackedResolvedTypes = pushTypes(expression);
		ExpressionTypeComputationState state = createExpressionComputationState(expression, stackedResolvedTypes);
		getResolver().getTypeComputer().computeTypes(expression, state);
		stackedResolvedTypes.prepareMergeIntoParent();
		if (stackedResolvedTypes.doGetTypeData(expression) == null) {
			state.acceptActualType(new AnyTypeReference(stackedResolvedTypes.getReferenceOwner()));
		}
		return stackedResolvedTypes;
	}
	
	protected ExpressionAwareStackedResolvedTypes pushTypes(XExpression expression) {
		return getResolvedTypes().pushTypes(expression);
	}
	
	protected ExpressionTypeComputationState createExpressionComputationState(XExpression expression,
			StackedResolvedTypes typeResolution) {
		return new ExpressionTypeComputationState(typeResolution, featureScopeSession, this, expression);
	}
	
	/*
	 * Clients who override this method have to be careful with AbstractPendingLinkingCandidate#computeArgumentTypes where
	 * a subtype of TypeComputationStateWithExpectation is used.
	 */
	public TypeComputationStateWithExpectation withExpectation(@Nullable LightweightTypeReference expectation) {
		return new TypeComputationStateWithExpectation(resolvedTypes, featureScopeSession, this, expectation);
	}
	
	public void refineExpectedType(XExpression expression, LightweightTypeReference expectation) {
		TypeExpectation typeExpectation = new TypeExpectation(expectation, this, false);
		getResolvedTypes().refineExpectedType(expression, typeExpectation);
	}
	
	public TypeComputationStateWithRootExpectation withRootExpectation(@Nullable LightweightTypeReference expectation) {
		return new TypeComputationStateWithRootExpectation(resolvedTypes, featureScopeSession, this, expectation);
	}
	
	public TypeComputationStateWithRootExpectation withoutRootExpectation() {
		return new TypeComputationStateWithRootExpectation(resolvedTypes, featureScopeSession, this, null);
	}
	
	public AbstractTypeComputationState withNonVoidExpectation() {
		return withNonVoidExpectation(resolvedTypes);
	}
	
	protected AbstractTypeComputationState withNonVoidExpectation(ResolvedTypes resolvedTypes) {
		return new TypeComputationStateWithNonVoidExpectation(resolvedTypes, featureScopeSession, this);
	}

	public AbstractTypeComputationState withReturnExpectation() {
		return new ReturnExpectationTypeComputationState(resolvedTypes, featureScopeSession, this);
	}

	public AbstractTypeComputationState withoutExpectation() {
		return new TypeComputationStateWithExpectation(resolvedTypes, featureScopeSession, this, null);
	}
	
	public TypeCheckpointComputationState withTypeCheckpoint(@Nullable EObject context) {
		return new TypeCheckpointComputationState(resolvedTypes, featureScopeSession, this);
	}
	
	public AbstractTypeComputationState withExpectedExceptions(List<LightweightTypeReference> declaredExceptionTypes) {
		return new ExpectedExceptionTypeComputationState(resolvedTypes, featureScopeSession, this, declaredExceptionTypes);
	}
	
	public AbstractTypeComputationState assignType(JvmIdentifiableElement element, @Nullable  LightweightTypeReference type) {
		return assignType(element, type, true);
	}
	
	public AbstractTypeComputationState assignType(JvmIdentifiableElement element, @Nullable  LightweightTypeReference type, boolean addToChildScope) {
		TypeAssigner assigner = assignTypes();
		assigner.assignType(element, type, addToChildScope);
		return assigner.getForkedState();
	}
	
	public void addLocalToCurrentScope(JvmIdentifiableElement element) {
		String simpleName = element.getSimpleName();
		if (Strings.isNullOrEmpty(simpleName))
			return;
		QualifiedName elementName = QualifiedName.create(simpleName);
		addLocalToCurrentScope(elementName, element, !getResolver().isShadowingAllowed(elementName));
	}
	
	public void addExtensionToCurrentScope(JvmIdentifiableElement extensionProvider) {
		LightweightTypeReference knownType = getResolvedTypes().getActualType(extensionProvider);
		if (knownType != null && !knownType.isAny() && !knownType.isUnknown()) {
			XFeatureCall prototype = getResolver().getXbaseFactory().createXFeatureCall();
			prototype.setFeature(extensionProvider);
			featureScopeSession = featureScopeSession.addToExtensionScope(Collections.<XExpression, LightweightTypeReference>singletonMap(prototype, knownType));
		}
	}
	
	public void addTypeToStaticImportScope(JvmDeclaredType type) {
		featureScopeSession = featureScopeSession.addTypesToStaticScope(Collections.<JvmType>singletonList(type), Collections.<JvmType>emptyList());
	}
	
	public void addExtensionsToCurrentScope(List<? extends JvmIdentifiableElement> extensionProviders) {
		if (extensionProviders.isEmpty())
			return;
		if (extensionProviders.size() == 1) {
			addExtensionToCurrentScope(extensionProviders.get(0));
			return;
		}
		Map<XExpression, LightweightTypeReference> prototypeToType = Maps2.newLinkedHashMapWithExpectedSize(extensionProviders.size());
		for(JvmIdentifiableElement extensionProvider: extensionProviders) {
			LightweightTypeReference knownType = getResolvedTypes().getActualType(extensionProvider);
			if (knownType != null && !knownType.isAny() && !knownType.isUnknown()) {
				XFeatureCall prototype = getResolver().getXbaseFactory().createXFeatureCall();
				prototype.setFeature(extensionProvider);
				prototypeToType.put(prototype, knownType);
			}
		}
		if (!prototypeToType.isEmpty())
			featureScopeSession = featureScopeSession.addToExtensionScope(prototypeToType);
	}
	
	protected void addLocalToCurrentScope(QualifiedName elementName, JvmIdentifiableElement element, boolean raiseIssueIfShadowing) {
		if (getResolver().isDisallowedName(elementName)) {
			resolvedTypes.addDiagnostic(new EObjectDiagnosticImpl(
					Severity.ERROR,
					IssueCodes.VARIABLE_NAME_DISALLOWED, 
					"'" + elementName + "' is not a valid name", 
					getResolver().getSourceElement(element),
					element.eClass().getEStructuralFeature("name"),
					-1,
					null));
			return;
		}
		if (getResolver().isDiscouragedName(elementName)) {
			if (!isIgnored(IssueCodes.VARIABLE_NAME_DISCOURAGED)) {
				resolvedTypes.addDiagnostic(new EObjectDiagnosticImpl(
						getSeverity(IssueCodes.VARIABLE_NAME_DISCOURAGED),
						IssueCodes.VARIABLE_NAME_DISCOURAGED, 
						"'" + elementName + "' is a discouraged name", 
						getResolver().getSourceElement(element),
						element.eClass().getEStructuralFeature("name"),
						-1,
						null));
			}
		}
		if (raiseIssueIfShadowing) {
			IEObjectDescription existingElement = featureScopeSession.getLocalElement(elementName);
			if (existingElement != null) {
				resolvedTypes.addDiagnostic(new EObjectDiagnosticImpl(
						Severity.ERROR,
						IssueCodes.VARIABLE_NAME_SHADOWING, 
						"Duplicate local variable " + elementName, 
						getResolver().getSourceElement(element),
						element.eClass().getEStructuralFeature("name"),
						-1,
						null));
			}
		}
		featureScopeSession = featureScopeSession.addLocalElement(elementName, element, getReferenceOwner());
	}
	
	public void assignType(QualifiedName name, JvmType rawType, LightweightTypeReference actualType) {
		resolvedTypes.reassignTypeWithoutMerge(rawType, actualType);
		featureScopeSession = featureScopeSession.addLocalElement(name, rawType, getReferenceOwner());
	}
	
	public TypeAssigner assignTypes() {
		TypeCheckpointComputationState state = withTypeCheckpoint(null);
		return createTypeAssigner(state);
	}
	
	public void addDiagnostic(AbstractDiagnostic diagnostic) {
		resolvedTypes.addDiagnostic(diagnostic);
	}

	protected TypeAssigner createTypeAssigner(final AbstractTypeComputationState state) {
		return new TypeAssigner(state);
	}

	public final List<? extends ITypeExpectation> getExpectations() {
		if (expectations == null)
			expectations = getExpectations(this);
		return expectations;
	}
	
	//TODO not referenced
	protected final List<? extends ITypeExpectation> getReturnExpectations() {
		if (returnExpectations == null)
			returnExpectations = getReturnExpectations(this, false);
		return returnExpectations;
	}
	
	protected abstract List<AbstractTypeExpectation> getExpectations(AbstractTypeComputationState actualState);
	
	protected abstract List<AbstractTypeExpectation> getReturnExpectations(AbstractTypeComputationState actualState, boolean asActualExpectation);
	
	public void acceptActualType(LightweightTypeReference type) {
		for(ITypeExpectation expectation: getExpectations()) {
			expectation.acceptActualType(type, ConformanceHint.UNCHECKED, ConformanceHint.EXPECTATION_INDEPENDENT);
		}
	}
	
	public void acceptActualType(LightweightTypeReference type, ConformanceHint... hints) {
		EnumSet<ConformanceHint> actualHints = EnumSet.copyOf(Arrays.asList(hints));
		actualHints.add(ConformanceHint.UNCHECKED);
		actualHints.add(ConformanceHint.EXPECTATION_INDEPENDENT);
		ConformanceHint[] actualHintsAsArray = actualHints.toArray(new ConformanceHint[actualHints.size()]);
		List<? extends ITypeExpectation> expectations = actualHints.contains(ConformanceHint.EXPLICIT_VOID_RETURN) ? getReturnExpectations() : getExpectations();
		for(ITypeExpectation expectation: expectations) {
			expectation.acceptActualType(type, actualHintsAsArray);
		}
	}

	public void reassignType(JvmIdentifiableElement refinable, LightweightTypeReference type) {
		if (type == null)
			throw new IllegalArgumentException("Reassigned type may not be null");
		resolvedTypes.reassignType(refinable, type);
	}

	public void discardReassignedTypes(JvmIdentifiableElement refinable) {
		resolvedTypes.reassignType(refinable, (LightweightTypeReference) null);
	}

	public List<IFeatureLinkingCandidate> getLinkingCandidates(XAbstractFeatureCall featureCall) {
		IFeatureLinkingCandidate result = reentrantTypeResolver.getScopeProviderAccess().getKnownFeature(featureCall, this, resolvedTypes);
		if (result != null) {
			return Collections.singletonList(result);
		}
		EObject proxyOrResolved = (EObject) featureCall.eGet(XbasePackage.Literals.XABSTRACT_FEATURE_CALL__FEATURE, false);
		StackedResolvedTypes demandComputedTypes = resolvedTypes.pushTypes();
		final AbstractTypeComputationState forked = withNonVoidExpectation(demandComputedTypes);
		ForwardingResolvedTypes demandResolvedTypes = new ForwardingResolvedTypes() {
			@Override
			protected IResolvedTypes delegate() {
				return forked.getResolvedTypes();
			}
			
			@Override
			@Nullable
			public LightweightTypeReference getActualType(XExpression expression) {
				LightweightTypeReference type = super.getActualType(expression);
				if (type == null) {
					ITypeComputationResult result = forked.computeTypes(expression);
					return result.getActualExpressionType();
				}
				return type;
			}
		};
		Iterable<IEObjectDescription> descriptions = reentrantTypeResolver.getScopeProviderAccess().getCandidateDescriptions(
				featureCall, XbasePackage.Literals.XABSTRACT_FEATURE_CALL__FEATURE, proxyOrResolved, featureScopeSession, demandResolvedTypes);
		List<IFeatureLinkingCandidate> resultList = Lists.newArrayList();
		for(IEObjectDescription description: descriptions) {
			resultList.add(createCandidate(featureCall, demandComputedTypes, toIdentifiableDescription(description)));
		}
		if (resultList.isEmpty()) {
			resultList.add(new NullFeatureLinkingCandidate(featureCall, this));
		}
		return resultList;
	}
	
	protected IFeatureLinkingCandidate createResolvedLink(XAbstractFeatureCall featureCall, JvmIdentifiableElement resolvedTo) {
		ExpressionAwareStackedResolvedTypes resolvedTypes = this.resolvedTypes.pushTypes(featureCall);
		ExpressionTypeComputationState state = createExpressionComputationState(featureCall, resolvedTypes);
		
		FeatureLinkHelper helper = new FeatureLinkHelper();
		XExpression syntacticReceiver = helper.getSyntacticReceiver(featureCall);
		if (syntacticReceiver != null) {
			AbstractTypeComputationState child = state.withNonVoidExpectation();
			child.computeTypes(syntacticReceiver);
		}
		XExpression implicitReceiver = featureCall.getImplicitReceiver();
		if (implicitReceiver != null) {
			AbstractTypeComputationState child = state.withNonVoidExpectation();
			child.computeTypes(implicitReceiver);
		}
		XExpression implicitFirstArgument = featureCall.getImplicitFirstArgument();
		if (implicitFirstArgument != null) {
			AbstractTypeComputationState child = state.withNonVoidExpectation();
			child.computeTypes(implicitFirstArgument);
		}
		if (featureCall.isTypeLiteral() || featureCall.isPackageFragment()) {
			return new ResolvedTypeLiteral(featureCall, resolvedTo, getSingleExpectation(state), state);
		}
		return new ResolvedFeature(featureCall, resolvedTo, helper, getSingleExpectation(state), state);
	}
	
	protected IFeatureLinkingCandidate createCandidate(XAbstractFeatureCall featureCall, final StackedResolvedTypes demandComputedTypes, IIdentifiableElementDescription description) {
		if (description.getSyntacticReceiverType() != null) { 
			return createCandidateWithReceiverType(featureCall, demandComputedTypes, description);
		}
		// pretty much the same constraints as in #createCandidateWithReceiverType 
		ExpressionAwareStackedResolvedTypes resolvedTypes = this.resolvedTypes.pushTypes(featureCall);
		ExpressionTypeComputationState state = createExpressionComputationState(featureCall, resolvedTypes);
		if (description instanceof ScopeProviderAccess.ErrorDescription) {
			ScopeProviderAccess.ErrorDescription errorDescription = (ScopeProviderAccess.ErrorDescription) description;
			boolean followUpError = errorDescription.isFollowUpError();
			if (followUpError) {
				return new FollowUpError(featureCall, state);
			}
			return new UnresolvableFeatureCall(featureCall, errorDescription.getNode(), description.getName().toString(), state);
		} else if (description.isTypeLiteral()) {
			return new TypeLiteralLinkingCandidate(featureCall, description, getSingleExpectation(state), state);
		} else {
			return new FeatureLinkingCandidate(featureCall, description, getSingleExpectation(state), state);
		}
	}
	
	protected ITypeExpectation getSingleExpectation(ITypeComputationState state) {
		List<? extends ITypeExpectation> result = state.getExpectations();
		if (result.size() != 1) {
			throw new IllegalStateException();
		}
		return result.get(0);
	}

	protected IFeatureLinkingCandidate createCandidateWithReceiverType(XAbstractFeatureCall featureCall, final StackedResolvedTypes demandComputedTypes,
			IIdentifiableElementDescription description) {
		final ExpressionAwareStackedResolvedTypes resolvedTypes = demandComputedTypes.pushTypes(featureCall);
		ExpressionTypeComputationState state = createExpressionComputationState(featureCall, resolvedTypes);
		if (description instanceof ScopeProviderAccess.ErrorDescription) {
			ScopeProviderAccess.ErrorDescription errorDescription = (ScopeProviderAccess.ErrorDescription) description;
			boolean followUpError = errorDescription.isFollowUpError();
			if (followUpError) {
				return new FollowUpError(featureCall, state) {
					@Override
					public void applyToComputationState() {
						super.applyToComputationState();
						demandComputedTypes.mergeIntoParent();
					}
				};
			}
			return new UnresolvableFeatureCall(featureCall, errorDescription.getNode(), description.getName().toString(), state) {
				@Override
				public void applyToComputationState() {
					super.applyToComputationState();
					demandComputedTypes.mergeIntoParent();
				}
			};
		} else if (description.isTypeLiteral()) {
			return new TypeLiteralLinkingCandidate(featureCall, description, getSingleExpectation(state), state) {
				@Override
				public void applyToComputationState() {
					super.applyToComputationState();
					demandComputedTypes.mergeIntoParent();
				}
			};
		} 
		return new FeatureLinkingCandidate(featureCall, description, getSingleExpectation(state), state) {
			@Override
			public void applyToComputationState() {
				super.applyToComputationState();
				XExpression receiver = getReceiver();
				if (receiver != null) {
					LightweightTypeReference receiverType = getReceiverType();
					if (receiverType == null) {
						throw new IllegalStateException("Cannot determine receiver's type");
					}
					LightweightTypeReference expectedReceiverType = new FeatureLinkHelper().getExpectedReceiverType(getFeature(), receiverType);
					TypeExpectation refinedExpectation = new TypeExpectation(expectedReceiverType, getState(), false);
					demandComputedTypes.refineExpectedType(receiver, refinedExpectation);
				}
				demandComputedTypes.mergeIntoParent();
			}
		};
	}
	
	public List<IConstructorLinkingCandidate> getLinkingCandidates(XConstructorCall constructorCall) {
		IConstructorLinkingCandidate result = reentrantTypeResolver.getScopeProviderAccess().getKnownConstructor(constructorCall, this, resolvedTypes);
		if(result != null) {
			return Collections.singletonList(result);
		}
		EObject proxyOrResolved = (EObject) constructorCall.eGet(XbasePackage.Literals.XCONSTRUCTOR_CALL__CONSTRUCTOR, false);
		Iterable<IEObjectDescription> descriptions = reentrantTypeResolver.getScopeProviderAccess().getCandidateDescriptions(
				constructorCall, XbasePackage.Literals.XCONSTRUCTOR_CALL__CONSTRUCTOR, proxyOrResolved, featureScopeSession, resolvedTypes);
		List<IConstructorLinkingCandidate> resultList = Lists.newArrayList();
		for(IEObjectDescription description: descriptions) {
			resultList.add(createCandidate(constructorCall, toIdentifiableDescription(description)));
		}
		if (resultList.isEmpty()) {
			resultList.add(new NullConstructorLinkingCandidate(constructorCall, this));
		}
		return resultList;
	}

	protected IIdentifiableElementDescription toIdentifiableDescription(IEObjectDescription description) {
		if (description instanceof IIdentifiableElementDescription)
			return (IIdentifiableElementDescription) description;
		if (!(description.getEObjectOrProxy() instanceof JvmIdentifiableElement)) {
			throw new IllegalStateException("Given description does not describe an identifable element");
		}
		return new SimpleIdentifiableElementDescription(description);
	}

	protected IConstructorLinkingCandidate createResolvedLink(XConstructorCall constructorCall, JvmConstructor resolvedTo) {
		StackedResolvedTypes stackedResolvedTypes = resolvedTypes.pushTypes(constructorCall);
		ExpressionTypeComputationState state = createExpressionComputationState(constructorCall, stackedResolvedTypes);
		return new ResolvedConstructor(constructorCall, resolvedTo, getSingleExpectation(state), state);
	}
	
	protected IConstructorLinkingCandidate createCandidate(XConstructorCall constructorCall, IIdentifiableElementDescription description) {
		StackedResolvedTypes stackedResolvedTypes = resolvedTypes.pushTypes(constructorCall);
		ExpressionTypeComputationState state = createExpressionComputationState(constructorCall, stackedResolvedTypes);
		if (description instanceof ScopeProviderAccess.ErrorDescription) {
			return new UnresolvableConstructorCall(constructorCall, ((ScopeProviderAccess.ErrorDescription) description).getNode(), description.getName().toString(), state);
		} else if (description.getElementOrProxy() instanceof JvmType) {
			return new TypeInsteadOfConstructorLinkingCandidate(constructorCall, description, state);
		} else {
			return new ConstructorLinkingCandidate(constructorCall, description, getSingleExpectation(state), state);
		}
	}

	@Override
	public String toString() {
		return String.format("%s: %s", getClass().getSimpleName(), resolvedTypes);
	}

	public ITypeReferenceOwner getReferenceOwner() {
		return resolvedTypes.getReferenceOwner();
	}
	
	public UnboundTypeReference createUnboundTypeReference(XExpression expression, JvmTypeParameter typeParameter) {
		return getResolvedTypes().createUnboundTypeReference(expression, typeParameter);
	}
	
	public OwnedConverter getConverter() {
		return new OwnedConverter(getReferenceOwner());
	}
	
	public List<LightweightTypeReference> getExpectedExceptions() {
		return resolvedTypes.getExpectedExceptions();
	}
	
	protected IssueSeverities getSeverities() {
		return resolvedTypes.getSeverities();
	}

	public Severity getSeverity(String issueCode) {
		return getSeverities().getSeverity(issueCode);
	}

	public boolean isIgnored(String issueCode) {
		return getSeverities().isIgnored(issueCode);
	}
}
