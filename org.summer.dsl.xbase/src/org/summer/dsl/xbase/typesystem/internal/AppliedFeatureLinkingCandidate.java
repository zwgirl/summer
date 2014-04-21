/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.summer.dsl.xbase.typesystem.internal;

import java.util.List;

import org.eclipse.jdt.annotation.NonNullByDefault;
import org.eclipse.jdt.annotation.Nullable;
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
public class AppliedFeatureLinkingCandidate implements IFeatureLinkingCandidate {

	private final IFeatureLinkingCandidate delegate;

	protected AppliedFeatureLinkingCandidate(IFeatureLinkingCandidate delegate) {
		this.delegate = delegate;
	}
	
	public void applyToComputationState() {
		// nothing to do
	}

	public void applyToModel() {
		// nothing to do
	}
	
	public boolean validate(IAcceptor<? super AbstractDiagnostic> result) {
		// nothing to do
		return true;
	}

	public ILinkingCandidate getPreferredCandidate(ILinkingCandidate other) {
		return this;
	}

	@Nullable
	public JvmIdentifiableElement getFeature() {
		return delegate.getFeature();
	}

	public List<LightweightTypeReference> getTypeArguments() {
		return delegate.getTypeArguments();
	}
	
	public XExpression getExpression() {
		return delegate.getExpression();
	}

	public XAbstractFeatureCall getFeatureCall() {
		return delegate.getFeatureCall();
	}

	public boolean isStatic() {
		return delegate.isStatic();
	}

	public boolean isExtension() {
		return delegate.isExtension();
	}
	
	public boolean isTypeLiteral() {
		return delegate.isTypeLiteral();
	}

}
