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
import org.summer.dsl.model.types.JvmIdentifiableElement;
import org.summer.dsl.model.types.JvmTypeParameter;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.summer.dsl.model.xbase.XExpression;
import org.summer.dsl.xbase.typesystem.conformance.ConformanceHint;
import org.summer.dsl.xbase.typesystem.references.LightweightMergedBoundTypeArgument;
import org.summer.dsl.xbase.typesystem.references.LightweightTypeReference;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * TODO JavaDoc
 */
@NonNullByDefault
public interface IIdentifiableElementDescription extends IEObjectDescription {

	JvmIdentifiableElement getElementOrProxy();
	
	String getShadowingKey();
	
	int getBucketId();
	
	@Nullable
	LightweightTypeReference getImplicitReceiverType();

	@Nullable
	XExpression getImplicitReceiver();
	
	Map<JvmTypeParameter, LightweightMergedBoundTypeArgument> getImplicitReceiverTypeParameterMapping();
	
	EnumSet<ConformanceHint> getImplicitReceiverConformanceHints();
	
	@Nullable
	LightweightTypeReference getSyntacticReceiverType();
	
	@Nullable
	XExpression getSyntacticReceiver();
	
	boolean isSyntacticReceiverPossibleArgument();
	
	Map<JvmTypeParameter, LightweightMergedBoundTypeArgument> getSyntacticReceiverTypeParameterMapping();
	
	EnumSet<ConformanceHint> getSyntacticReceiverConformanceHints();
	
	@Nullable
	XExpression getImplicitFirstArgument();
	
	@Nullable
	LightweightTypeReference getImplicitFirstArgumentType();
	
	boolean isVisible();

	boolean isStatic();
	
	boolean isTypeLiteral();
	
	boolean isExtension();
	
}
