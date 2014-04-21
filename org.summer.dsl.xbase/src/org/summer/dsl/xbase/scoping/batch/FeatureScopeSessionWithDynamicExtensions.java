/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.summer.dsl.xbase.scoping.batch;

import java.util.List;
import java.util.Map;

import org.eclipse.jdt.annotation.NonNullByDefault;
import org.summer.dsl.model.xbase.XExpression;
import org.summer.dsl.xbase.typesystem.override.IResolvedFeatures;
import org.summer.dsl.xbase.typesystem.references.LightweightTypeReference;

import com.google.common.collect.Lists;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@NonNullByDefault
public class FeatureScopeSessionWithDynamicExtensions extends AbstractNestedFeatureScopeSession {

	private final Map<XExpression, LightweightTypeReference> extensionProviders;
	private final IResolvedFeatures.Provider resolvedFeaturesProvider;

	public FeatureScopeSessionWithDynamicExtensions(AbstractFeatureScopeSession parent,
			Map<XExpression, LightweightTypeReference> extensionProviders,
			IResolvedFeatures.Provider resolvedFeaturesProvider) {
		super(parent);
		this.extensionProviders = extensionProviders;
		this.resolvedFeaturesProvider = resolvedFeaturesProvider;
	}
	
	@Override
	protected void addExtensionProviders(List<ExpressionBucket> result) {
		ExpressionBucket bucket = new ExpressionBucket(getId(), extensionProviders, resolvedFeaturesProvider);
		result.add(bucket);
		super.addExtensionProviders(result);
	}
	
	@Override
	public List<ExpressionBucket> getExtensionProviders() {
		List<ExpressionBucket> result = Lists.newArrayListWithCapacity(3);
		addExtensionProviders(result);
		return result;
	}

}
