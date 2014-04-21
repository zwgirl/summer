/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.summer.dsl.xbase.scoping.batch;

import java.util.EnumSet;
import java.util.Map;

import org.eclipse.jdt.annotation.NonNullByDefault;
import org.eclipse.jdt.annotation.Nullable;
import org.summer.dsl.model.types.JvmFeature;
import org.summer.dsl.model.types.JvmTypeParameter;
import org.eclipse.xtext.naming.QualifiedName;
import org.summer.dsl.model.xbase.XExpression;
import org.summer.dsl.xbase.typesystem.conformance.ConformanceHint;
import org.summer.dsl.xbase.typesystem.references.LightweightMergedBoundTypeArgument;
import org.summer.dsl.xbase.typesystem.references.LightweightTypeReference;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@NonNullByDefault
public class InstanceFeatureDescription extends BucketedEObjectDescription {

	private final XExpression receiver;
	private final LightweightTypeReference receiverType;
	private final Map<JvmTypeParameter, LightweightMergedBoundTypeArgument> receiverTypeParameterMapping;
	private final EnumSet<ConformanceHint> receiverConformanceHints;

	protected InstanceFeatureDescription(
			QualifiedName qualifiedName, 
			JvmFeature feature,
			XExpression receiver,
			LightweightTypeReference receiverType,
			Map<JvmTypeParameter, LightweightMergedBoundTypeArgument> receiverTypeParameterMapping,
			EnumSet<ConformanceHint> receiverConformanceHints,
			int bucketId,
			boolean visible) {
		super(qualifiedName, feature, bucketId, visible);
		if (feature.isStatic()) {
			throw new IllegalArgumentException(String.valueOf(feature));
		}
		if (receiverConformanceHints.isEmpty()) {
			throw new IllegalArgumentException(String.valueOf(receiverConformanceHints));
		}
		this.receiver = receiver;
		this.receiverType = receiverType;
		this.receiverTypeParameterMapping = receiverTypeParameterMapping;
		this.receiverConformanceHints = receiverConformanceHints;
	}
	
	@Override
	@Nullable
	public XExpression getSyntacticReceiver() {
		return receiver;
	}
	
	@Override
	@Nullable
	public LightweightTypeReference getSyntacticReceiverType() {
		return receiverType;
	}
	
	@Override
	public Map<JvmTypeParameter, LightweightMergedBoundTypeArgument> getSyntacticReceiverTypeParameterMapping() {
		return receiverTypeParameterMapping;
	}
	
	@Override
	public EnumSet<ConformanceHint> getSyntacticReceiverConformanceHints() {
		return receiverConformanceHints;
	}
	
	public boolean isStatic() {
		return false;
	}
	
	public boolean isExtension() {
		return false;
	}

}
