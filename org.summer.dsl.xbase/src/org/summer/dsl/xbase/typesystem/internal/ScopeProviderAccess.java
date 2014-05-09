/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.summer.dsl.xbase.typesystem.internal;

import java.util.Collections;
import java.util.EnumSet;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.NonNullByDefault;
import org.eclipse.jdt.annotation.Nullable;
import org.summer.dsl.model.types.JvmConstructor;
import org.summer.dsl.model.types.JvmIdentifiableElement;
import org.summer.dsl.model.types.JvmTypeParameter;
import org.eclipse.xtext.linking.impl.IllegalNodeException;
import org.eclipse.xtext.linking.impl.LinkingHelper;
import org.eclipse.xtext.linking.lazy.LazyURIEncoder;
import org.eclipse.xtext.naming.IQualifiedNameConverter;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.nodemodel.ILeafNode;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.util.Strings;
import org.summer.dsl.model.xbase.XAbstractFeatureCall;
import org.summer.dsl.model.xbase.XConstructorCall;
import org.summer.dsl.model.xbase.XExpression;
import org.summer.dsl.model.xbase.XFeatureCall;
import org.summer.dsl.model.xbase.XMemberFeatureCall;
import org.summer.dsl.model.xbase.XMemberFeatureCall1;
import org.summer.dsl.model.xbase.XbasePackage;
import org.summer.dsl.xbase.scoping.batch.IFeatureScopeSession;
import org.summer.dsl.xbase.scoping.batch.IIdentifiableElementDescription;
import org.summer.dsl.xbase.typesystem.IResolvedTypes;
import org.summer.dsl.xbase.typesystem.computation.IConstructorLinkingCandidate;
import org.summer.dsl.xbase.typesystem.computation.IFeatureLinkingCandidate;
import org.summer.dsl.xbase.typesystem.conformance.ConformanceHint;
import org.summer.dsl.xbase.typesystem.references.LightweightMergedBoundTypeArgument;
import org.summer.dsl.xbase.typesystem.references.LightweightTypeReference;

import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.inject.Inject;

/**
 * @author Sebastian Zarnekow - Initial contribution and API 
 * TODO JavaDoc, toString
 */
public class ScopeProviderAccess {

	@Inject
	private LinkingHelper linkingHelper;

	@Inject
	private IQualifiedNameConverter qualifiedNameConverter;

	@Inject
	private LazyURIEncoder encoder;

	@NonNullByDefault
	@Nullable
	protected IFeatureLinkingCandidate getKnownFeature(XAbstractFeatureCall featureCall, AbstractTypeComputationState state, ResolvedTypes resolvedTypes) {
		IFeatureLinkingCandidate result = resolvedTypes.getFeature(featureCall);
		if (result != null ) {
			return new AppliedFeatureLinkingCandidate(result);
		}
		EObject proxyOrResolved = (EObject) featureCall.eGet(XbasePackage.Literals.XABSTRACT_FEATURE_CALL__FEATURE, false);
		if (proxyOrResolved == null && !(featureCall instanceof XMemberFeatureCall1 &&((XMemberFeatureCall1)featureCall).isIndexedOperation())) {
			return new NullFeatureLinkingCandidate(featureCall, state);
		}
		
		if(proxyOrResolved == null){
			return null;
		}
		if (!proxyOrResolved.eIsProxy()) {
			return state.createResolvedLink(featureCall, (JvmIdentifiableElement) proxyOrResolved);
		}
		if (!encoder.isCrossLinkFragment(featureCall.eResource(), EcoreUtil.getURI(proxyOrResolved).fragment())) {
			JvmIdentifiableElement feature = featureCall.getFeature();
			if (!feature.eIsProxy()) {
				return state.createResolvedLink(featureCall, feature);
			}
		}
		return null;
	}
	
	@NonNullByDefault
	@Nullable
	protected IConstructorLinkingCandidate getKnownConstructor(XConstructorCall constructorCall, AbstractTypeComputationState state,
			ResolvedTypes resolvedTypes) {
		IConstructorLinkingCandidate result = resolvedTypes.getConstructor(constructorCall);
		if (result != null) {
			return result;
		}
		EObject proxyOrResolved = (EObject) constructorCall.eGet(XbasePackage.Literals.XCONSTRUCTOR_CALL__CONSTRUCTOR, false);
		if (proxyOrResolved == null) {
			result = new NullConstructorLinkingCandidate(constructorCall, state);
			return result;
		}
		if (!proxyOrResolved.eIsProxy()) {
			result = state.createResolvedLink(constructorCall, (JvmConstructor) proxyOrResolved);
			return result;
		}
		if (!encoder.isCrossLinkFragment(constructorCall.eResource(), EcoreUtil.getURI(proxyOrResolved).fragment())) {
			JvmConstructor constructor = constructorCall.getConstructor();
			if (!constructor.eIsProxy()) {
				return state.createResolvedLink(constructorCall, constructor);
			}
		}
		return null;
	}

	/**
	 * Returns a bunch of descriptions most of which are actually {@link IIdentifiableElementDescription describing identifiables}. 
	 * The provided iterable is never empty but it may contain a single {@link ErrorDescription error description}.
	 * 
	 * @return the available descriptions.
	 */
	@NonNullByDefault
	public Iterable<IEObjectDescription> getCandidateDescriptions(XExpression expression, EReference reference, @Nullable EObject toBeLinked,
			IFeatureScopeSession session, IResolvedTypes types) throws IllegalNodeException {
		if (toBeLinked == null) {
			return Collections.emptyList();
		}
		if (!toBeLinked.eIsProxy()) {
			throw new IllegalStateException(expression + " was already linked to " + toBeLinked);
		}
		URI uri = EcoreUtil.getURI(toBeLinked);
		String fragment = uri.fragment();
		if (encoder.isCrossLinkFragment(expression.eResource(), fragment)) {
			INode node = encoder.getNode(expression, fragment);
			final EClass requiredType = reference.getEReferenceType();
			if (requiredType == null)
				return Collections.emptyList();

			final String crossRefString = linkingHelper.getCrossRefNodeAsString(node, true);
			if (crossRefString != null && !crossRefString.equals("")) {
				final IScope scope = session.getScope(expression, reference, types);
				QualifiedName qualifiedLinkName = qualifiedNameConverter.toQualifiedName(crossRefString);
				Iterable<IEObjectDescription> descriptions = scope.getElements(qualifiedLinkName);
				if (Iterables.isEmpty(descriptions)) {
					INode errorNode = getErrorNode(expression, node);
					if (errorNode != node) {
						qualifiedLinkName = getErrorName(errorNode);
					}
					return Collections.<IEObjectDescription>singletonList(new ErrorDescription(getErrorNode(expression, node), qualifiedLinkName));
				}
				return descriptions;
			}
			return Collections.emptyList();
		} else {
			throw new IllegalStateException(expression + " uses unsupported uri fragment " + uri);
		}
	}
	
	private QualifiedName getErrorName(INode errorNode) {
		List<String> segments = Lists.newArrayListWithCapacity(4);
		for(ILeafNode leaf: errorNode.getLeafNodes()) {
			if (!leaf.isHidden()) {
				String text = leaf.getText();
				// XParenthesizedExpression
				if (text.equals("(") || text.equals(")")) {
					continue;
				}
				if (!text.equals(".") && !text.equals("::")) {
					if (text.charAt(0) == '^')
						segments.add(text.substring(1));
					else
						segments.add(text);
				}
			}
		}
		return QualifiedName.create(segments);
	}
	
	/**
	 * Returns the node that best describes the error, e.g. if there is an expression
	 * <code>com::foo::DoesNotExist::method()</code> the error will be rooted at <code>com</code>, but
	 * the real problem is <code>com::foo::DoesNotExist</code>.
	 */
	private INode getErrorNode(XExpression expression, INode node) {
		if (expression instanceof XFeatureCall) {
			XFeatureCall featureCall = (XFeatureCall) expression;
			if (!canBeTypeLiteral(featureCall)) {
				return node;
			}
			if (featureCall.eContainingFeature() == XbasePackage.Literals.XMEMBER_FEATURE_CALL__MEMBER_CALL_TARGET) {
				XMemberFeatureCall container = (XMemberFeatureCall) featureCall.eContainer();
				if (canBeTypeLiteral(container)) {
					boolean explicitStatic = container.isExplicitStatic();
					XMemberFeatureCall outerMost = getLongestTypeLiteralCandidate(container, explicitStatic);
					if (outerMost != null)
						return NodeModelUtils.getNode(outerMost);
				}
			}
		}
		return node;
	}

	@Nullable
	private XMemberFeatureCall getLongestTypeLiteralCandidate(XMemberFeatureCall current, boolean mustBeStatic) {
		if (current.eContainingFeature() == XbasePackage.Literals.XMEMBER_FEATURE_CALL__MEMBER_CALL_TARGET) {
			XMemberFeatureCall container = (XMemberFeatureCall) current.eContainer();
			if (canBeTypeLiteral(container)) {
				if (!mustBeStatic && !container.isExplicitStatic()) {
					return null;
				}
				if (mustBeStatic != container.isExplicitStatic()) {
					return current;
				}
				if (mustBeStatic && container.eContainingFeature() != XbasePackage.Literals.XMEMBER_FEATURE_CALL__MEMBER_CALL_TARGET) {
					return current;
				}
				return getLongestTypeLiteralCandidate(container, mustBeStatic);
			}
		}
		if (mustBeStatic) {
			return null;
		}
		if (!mustBeStatic && !current.isExplicitStatic()) {
			return null;
		}
		return current;
	}

	private boolean canBeTypeLiteral(XAbstractFeatureCall featureCall) {
		return !featureCall.isExplicitOperationCallOrBuilderSyntax() && featureCall.getTypeArguments().isEmpty();
	}

	public static class ErrorDescription implements IIdentifiableElementDescription {

		private final QualifiedName name;
		private final INode node;
		private final boolean followUp;
		private final LightweightTypeReference syntacticReceiverType;

		public ErrorDescription(INode node, QualifiedName name) {
			this.node = node;
			this.name = name;
			this.followUp = false;
			this.syntacticReceiverType = null;
		}
		
		public ErrorDescription(@Nullable LightweightTypeReference syntacticReceiverType) {
			this.node = null;
			this.name = null;
			this.followUp = true;
			this.syntacticReceiverType = syntacticReceiverType;
		}
		
		public boolean isFollowUpError() {
			return followUp;
		}
		
		public QualifiedName getName() {
			return name;
		}
		
		public INode getNode() {
			return node;
		}

		public QualifiedName getQualifiedName() {
			return name;
		}

		public EObject getEObjectOrProxy() {
			return null;
		}

		public URI getEObjectURI() {
			return null;
		}

		public EClass getEClass() {
			return null;
		}

		public String getUserData(String key) {
			return null;
		}

		public String[] getUserDataKeys() {
			return Strings.EMPTY_ARRAY;
		}

		@NonNull 
		public JvmIdentifiableElement getElementOrProxy() {
			throw new UnsupportedOperationException();
		}

		@NonNull 
		public String getShadowingKey() {
			return "ErrorDescription";
		}

		public int getBucketId() {
			return 0;
		}

		@Nullable
		public LightweightTypeReference getImplicitReceiverType() {
			return null;
		}

		@Nullable
		public XExpression getImplicitReceiver() {
			return null;
		}

		@NonNull
		public Map<JvmTypeParameter, LightweightMergedBoundTypeArgument> getImplicitReceiverTypeParameterMapping() {
			return Collections.emptyMap();
		}
		
		@NonNull
		public EnumSet<ConformanceHint> getImplicitReceiverConformanceHints() {
			return EnumSet.noneOf(ConformanceHint.class);
		}

		@Nullable
		public LightweightTypeReference getSyntacticReceiverType() {
			return syntacticReceiverType;
		}

		@Nullable
		public XExpression getSyntacticReceiver() {
			return null;
		}
		
		public boolean isSyntacticReceiverPossibleArgument() {
			return false;
		}

		@NonNull
		public Map<JvmTypeParameter, LightweightMergedBoundTypeArgument> getSyntacticReceiverTypeParameterMapping() {
			return Collections.emptyMap();
		}
		
		@NonNull
		public EnumSet<ConformanceHint> getSyntacticReceiverConformanceHints() {
			return EnumSet.noneOf(ConformanceHint.class);
		}

		@Nullable
		public XExpression getImplicitFirstArgument() {
			return null;
		}

		@Nullable
		public LightweightTypeReference getImplicitFirstArgumentType() {
			return null;
		}

		@NonNull 
		public Map<JvmTypeParameter, LightweightMergedBoundTypeArgument> getImplicitFirstArgumentTypeParameterMapping() {
			return Collections.emptyMap();
		}
		
		@NonNull
		public EnumSet<ConformanceHint> getImplicitFirstArgumentConformanceHints() {
			return EnumSet.noneOf(ConformanceHint.class);
		}

		public boolean isVisible() {
			return true;
		}

		public boolean isStatic() {
			return false;
		}

		public boolean isExtension() {
			return false;
		}
		
		public boolean isTypeLiteral() {
			return false;
		}

	}

}
