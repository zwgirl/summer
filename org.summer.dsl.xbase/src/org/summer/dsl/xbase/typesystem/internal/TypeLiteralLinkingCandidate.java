/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.summer.dsl.xbase.typesystem.internal;

import java.util.Collections;
import java.util.List;

import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.jdt.annotation.NonNullByDefault;
import org.eclipse.jdt.annotation.Nullable;
import org.summer.dsl.model.types.JvmIdentifiableElement;
import org.summer.dsl.model.types.JvmType;
import org.summer.dsl.model.types.JvmTypeParameter;
import org.eclipse.xtext.diagnostics.AbstractDiagnostic;
import org.eclipse.xtext.util.IAcceptor;
import org.summer.dsl.model.xbase.XAbstractFeatureCall;
import org.summer.dsl.model.xbase.XExpression;
import org.summer.dsl.model.xbase.XFeatureCall;
import org.summer.dsl.model.xbase.XMemberFeatureCall;
import org.summer.dsl.model.xbase.XbasePackage;
import org.summer.dsl.xbase.scoping.batch.IIdentifiableElementDescription;
import org.summer.dsl.xbase.typesystem.computation.IFeatureLinkingCandidate;
import org.summer.dsl.xbase.typesystem.computation.ILinkingCandidate;
import org.summer.dsl.xbase.typesystem.computation.ITypeExpectation;
import org.summer.dsl.xbase.typesystem.references.LightweightTypeReference;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * TODO JavaDoc, toString
 */
@NonNullByDefault
public class TypeLiteralLinkingCandidate extends AbstractPendingLinkingCandidate<XAbstractFeatureCall> implements ITypeLiteralLinkingCandidate {

	private TypeLiteralHelper helper;

	public TypeLiteralLinkingCandidate(
			XAbstractFeatureCall featureCall, 
			IIdentifiableElementDescription description,
			ITypeExpectation expectation, 
			ExpressionTypeComputationState state) {
		super(featureCall, description, expectation, state);
		if (featureCall.isExplicitOperationCallOrBuilderSyntax()) {
			throw new IllegalArgumentException("Cannot be a type literal: " + String.valueOf(featureCall));
		}
		this.helper = new TypeLiteralHelper(state);
	}
	
	@Override
	public void computeArgumentTypes() {
		// nothing to do
	}
	
	// TODO java.awt.List / java.util.List
	@Override
	protected ILinkingCandidate createAmbiguousLinkingCandidate(AbstractPendingLinkingCandidate<?> second) {
		return this;
	}

	/**
	 * Returns the actual arguments of the expression. These do not include the
	 * receiver.  
	 */
	@Override
	protected List<XExpression> getArguments() {
		return Collections.emptyList();
	}

	@Override
	protected String getFeatureTypeName() {
		return "type";
	}

	@Override
	public int getArityMismatch() {
		return 0;
	}
	
	@Override
	protected List<XExpression> getSyntacticArguments() {
		return Collections.emptyList();
	}
	
	@Override
	public boolean isExtension() {
		return false;
	}
	
	@Override
	protected boolean hasReceiver() {
		return false;
	}
	
	public boolean isStatic() {
		return false;
	}
	
	@Override
	public boolean isTypeLiteral() {
		return true;
	}

	public XAbstractFeatureCall getFeatureCall() {
		return getExpression();
	}
	
	@Override
	protected List<LightweightTypeReference> getSyntacticTypeArguments() {
		return Collections.emptyList();
	}
	
	@Override
	protected LightweightTypeReference getDeclaredType(JvmIdentifiableElement feature) {
		return helper.getAsClassLiteral(feature);
	}
	
	@Override
	protected List<JvmTypeParameter> getDeclaredTypeParameters() {
		return Collections.emptyList();
	}
	
	@Override
	public int getTypeArityMismatch() {
		return 0;
	}
	
	@Override
	protected int getTypeArgumentConformanceFailures(@Nullable IAcceptor<? super AbstractDiagnostic> acceptor) {
		return 0;
	}
	
	@Override
	public List<LightweightTypeReference> getTypeArguments() {
		return Collections.emptyList();
	}
	
	@Override
	protected void preApply() {
		helper.applyPackageFragment(getExpression(), getType());
	}
	
	public JvmType getType() {
		return (JvmType) getFeature();
	}
	
	public void applyToModel() {
		resolveLinkingProxy(XbasePackage.Literals.XABSTRACT_FEATURE_CALL__FEATURE, XbasePackage.XABSTRACT_FEATURE_CALL__FEATURE);
	}
	
	@Override
	protected void internalSetValue(InternalEObject featureCall, EReference structuralFeature, JvmIdentifiableElement newValue) {
		super.internalSetValue(featureCall, structuralFeature, newValue);
		if (featureCall instanceof XFeatureCall) {
			XFeatureCall casted = (XFeatureCall) featureCall;
			if (casted != getExpression()) {
				casted.setPackageFragment(true);
			} else {
				casted.setTypeLiteral(true);
			}
		} else if (featureCall instanceof XMemberFeatureCall) {
			XMemberFeatureCall casted = (XMemberFeatureCall) featureCall;
			if (casted != getExpression()) {
				casted.setPackageFragment(true);
			} else {
				casted.setTypeLiteral(true);
			}
			XExpression target = casted.getMemberCallTarget();
			IFeatureLinkingCandidate candidate = getState().getResolvedTypes().getLinkingCandidate((XAbstractFeatureCall) target);
			if (candidate == null || !candidate.isTypeLiteral()) {
				resolveLinkingProxy((InternalEObject) target, newValue, structuralFeature, XbasePackage.XABSTRACT_FEATURE_CALL__FEATURE);
			}
		}
	}

}
