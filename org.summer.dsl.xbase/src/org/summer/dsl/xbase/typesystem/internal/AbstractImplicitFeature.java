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

import org.eclipse.jdt.annotation.NonNullByDefault;
import org.summer.dsl.model.types.JvmIdentifiableElement;
import org.eclipse.xtext.diagnostics.AbstractDiagnostic;
import org.eclipse.xtext.util.IAcceptor;
import org.summer.dsl.model.xbase.XAbstractFeatureCall;
import org.summer.dsl.model.xbase.XExpression;
import org.summer.dsl.xbase.typesystem.computation.IFeatureLinkingCandidate;
import org.summer.dsl.xbase.typesystem.computation.ILinkingCandidate;
import org.summer.dsl.xbase.typesystem.references.LightweightTypeReference;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@NonNullByDefault
public abstract class AbstractImplicitFeature implements IFeatureLinkingCandidate {

	private final XAbstractFeatureCall featureCall;
	private final XAbstractFeatureCall implicit;
	private final ExpressionTypeComputationState state;

	protected AbstractImplicitFeature(XAbstractFeatureCall featureCall, XAbstractFeatureCall implicit, ExpressionTypeComputationState state) {
		this.featureCall = featureCall;
		this.implicit = implicit;
		this.state = state;
	}
	
	protected ExpressionTypeComputationState getState() {
		return state;
	}
	
	public void applyToComputationState() {
		state.getResolvedTypes().acceptLinkingInformation(implicit, this);
		getState().markAsRefinedTypeIfNecessary(this);
	}
	
	protected XAbstractFeatureCall getOwner() {
		return featureCall;
	}

	public ILinkingCandidate getPreferredCandidate(ILinkingCandidate other) {
		return this;
	}

	public JvmIdentifiableElement getFeature() {
		return implicit.getFeature();
	}
	
	public boolean validate(IAcceptor<? super AbstractDiagnostic> result) {
		return true;
	}

	public List<LightweightTypeReference> getTypeArguments() {
		return Collections.emptyList();
	}

	public XAbstractFeatureCall getFeatureCall() {
		return implicit;
	}
	
	public XExpression getExpression() {
		return implicit;
	}

	public boolean isStatic() {
		return false;
	}
	
	public boolean isTypeLiteral() {
		return false;
	}

	public boolean isExtension() {
		return false;
	}

}
