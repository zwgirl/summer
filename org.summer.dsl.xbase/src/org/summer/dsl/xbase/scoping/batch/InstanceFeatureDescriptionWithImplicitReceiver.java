/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.summer.dsl.xbase.scoping.batch;

import java.util.Collections;
import java.util.EnumSet;
import java.util.Map;

import org.eclipse.emf.ecore.util.EcoreUtil;
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
public class InstanceFeatureDescriptionWithImplicitReceiver extends InstanceFeatureDescription {

	protected InstanceFeatureDescriptionWithImplicitReceiver(
			QualifiedName qualifiedName,
			JvmFeature feature,
			XExpression receiver,
			LightweightTypeReference receiverType,
			Map<JvmTypeParameter, LightweightMergedBoundTypeArgument> typeParameterMapping,
			EnumSet<ConformanceHint> receiverConformanceHints,
			int bucketId,
			boolean visible) {
		super(qualifiedName, feature, EcoreUtil.copy(receiver), receiverType, typeParameterMapping, receiverConformanceHints, bucketId, visible);
	}
	
	@Override
	@Nullable
	public XExpression getImplicitReceiver() {
		return super.getSyntacticReceiver();
	}
	
	@Override
	@Nullable
	public LightweightTypeReference getImplicitReceiverType() {
		return super.getSyntacticReceiverType();
	}

	@Override
	public Map<JvmTypeParameter, LightweightMergedBoundTypeArgument> getImplicitReceiverTypeParameterMapping() {
		return super.getSyntacticReceiverTypeParameterMapping();
	}
	
	@Override
	public EnumSet<ConformanceHint> getImplicitReceiverConformanceHints() {
		return super.getSyntacticReceiverConformanceHints();
	}
	
	@Override
	@Nullable
	public XExpression getSyntacticReceiver() {
		return null;
	}
	
	@Override
	@Nullable
	public LightweightTypeReference getSyntacticReceiverType() {
		return null;
	}
	
	@Override
	public Map<JvmTypeParameter, LightweightMergedBoundTypeArgument> getSyntacticReceiverTypeParameterMapping() {
		return Collections.emptyMap();
	}

	@Override
	public EnumSet<ConformanceHint> getSyntacticReceiverConformanceHints() {
		return EnumSet.noneOf(ConformanceHint.class);
	}
}
