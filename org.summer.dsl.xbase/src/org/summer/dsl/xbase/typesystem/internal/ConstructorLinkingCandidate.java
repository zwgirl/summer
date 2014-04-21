/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.summer.dsl.xbase.typesystem.internal;

import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EReference;
import org.eclipse.jdt.annotation.NonNullByDefault;
import org.eclipse.jdt.annotation.Nullable;
import org.summer.dsl.model.types.JvmConstructor;
import org.summer.dsl.model.types.JvmDeclaredType;
import org.summer.dsl.model.types.JvmTypeParameter;
import org.eclipse.xtext.diagnostics.AbstractDiagnostic;
import org.eclipse.xtext.diagnostics.Severity;
import org.eclipse.xtext.util.IAcceptor;
import org.eclipse.xtext.validation.EObjectDiagnosticImpl;
import org.summer.dsl.model.xbase.XConstructorCall;
import org.summer.dsl.model.xbase.XExpression;
import org.summer.dsl.model.xbase.XbasePackage;
import org.summer.dsl.xbase.scoping.batch.IIdentifiableElementDescription;
import org.summer.dsl.xbase.typesystem.computation.IConstructorLinkingCandidate;
import org.summer.dsl.xbase.typesystem.computation.ILinkingCandidate;
import org.summer.dsl.xbase.typesystem.computation.ITypeExpectation;
import org.summer.dsl.xbase.typesystem.conformance.TypeConformanceComputationArgument;
import org.summer.dsl.xbase.typesystem.references.ITypeReferenceOwner;
import org.summer.dsl.xbase.typesystem.references.LightweightMergedBoundTypeArgument;
import org.summer.dsl.xbase.typesystem.references.LightweightTypeReference;
import org.summer.dsl.xbase.validation.IssueCodes;

import com.google.common.collect.Lists;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * TODO JavaDoc, toString
 */
@NonNullByDefault
public class ConstructorLinkingCandidate extends AbstractPendingLinkingCandidate<XConstructorCall> implements IConstructorLinkingCandidate {

	public ConstructorLinkingCandidate(
			XConstructorCall constructorCall,
			IIdentifiableElementDescription description,
			ITypeExpectation expectation,
			ExpressionTypeComputationState state) {
		super(constructorCall, description, expectation, state);
	}

	public JvmConstructor getConstructor() {
		return (JvmConstructor) getFeature();
	}
	
	public XConstructorCall getConstructorCall() {
		return getExpression();
	}
	
	@Override
	protected ILinkingCandidate createAmbiguousLinkingCandidate(AbstractPendingLinkingCandidate<?> second) {
		return new AmbiguousConstructorLinkingCandidate(this, second);
	}

	@Override
	protected List<XExpression> getArguments() {
		return getConstructorCall().getArguments();
	}
	
	@Override
	protected LightweightTypeReference deferredBindTypeArgument(ITypeExpectation expectation, LightweightTypeReference type) {
		LightweightTypeReference result = super.deferredBindTypeArgument(expectation, type);
		LightweightTypeReference expectedType = expectation.getExpectedType();
		if (expectedType != null && getSyntacticTypeArguments().isEmpty() && !result.isRawType() && !getDeclaredTypeParameters().isEmpty()) {
			if (!expectedType.isAssignableFrom(result, new TypeConformanceComputationArgument())) {
				LightweightTypeReference rawFeatureType = result.getRawTypeReference();
				if (expectedType.isAssignableFrom(rawFeatureType)) {
					result = rawFeatureType;
					getTypeParameterMapping().clear();
				}
			}
		}
		return result;
	}
	
	@Override
	public boolean validate(IAcceptor<? super AbstractDiagnostic> result) {
		JvmDeclaredType declaringType = getConstructor().getDeclaringType();
		if (declaringType.isAbstract()) {
			String message = "Cannot instantiate the abstract type " + declaringType.getSimpleName();
			AbstractDiagnostic diagnostic = new EObjectDiagnosticImpl(
					Severity.ERROR, 
					IssueCodes.ABSTRACT_CLASS_INSTANTIATION, 
					message, 
					getExpression(), 
					getDefaultValidationFeature(), -1, null);
			result.accept(diagnostic);
			return false;
		}
		return super.validate(result);
	}
	
	@Override
	protected boolean isBoundTypeArgumentSkipped(JvmTypeParameter type, Map<JvmTypeParameter, LightweightMergedBoundTypeArgument> mapping,
			ITypeReferenceOwner owner) {
		if (super.isBoundTypeArgumentSkipped(type, mapping, owner)) {
			if (getConstructor().getDeclaringType() != type.getDeclarator()) {
				return true;
			}
		}
		return false;
	}
	
	@Override
	protected EReference getDefaultValidationFeature() {
		return XbasePackage.Literals.XCONSTRUCTOR_CALL__CONSTRUCTOR;
	}
	
	@Nullable
	@Override
	protected EReference getInvalidArgumentsValidationFeature() {
		return null;
	}
	
	@Override
	protected String getFeatureTypeName() {
		return "constructor";
	}
	
	@Override
	protected List<LightweightTypeReference> getSyntacticTypeArguments() {
		return Lists.transform(getConstructorCall().getTypeArguments(), getState().getResolvedTypes().getConverter());
	}
	
	public void applyToModel() {
		resolveLinkingProxy(XbasePackage.Literals.XCONSTRUCTOR_CALL__CONSTRUCTOR, XbasePackage.XCONSTRUCTOR_CALL__CONSTRUCTOR);
	}
	
	@Override
	public List<JvmTypeParameter> getDeclaredTypeParameters() {
		return new FeatureLinkHelper().getDeclaredTypeParameters(getConstructor());
	}
	
}
