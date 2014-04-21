/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.summer.dsl.xbase.scoping.batch;

import org.eclipse.jdt.annotation.Nullable;
import org.summer.dsl.model.types.JvmFeature;
import org.eclipse.xtext.naming.QualifiedName;
import org.summer.dsl.model.xbase.XExpression;
import org.summer.dsl.model.xbase.XbaseFactory;
import org.summer.dsl.xbase.typesystem.references.LightweightTypeReference;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class StaticFeatureDescriptionWithImplicitReceiver extends StaticFeatureDescription {

	private final LightweightTypeReference implicitReceiverType;
	private final XExpression implicitReceiver;

	public StaticFeatureDescriptionWithImplicitReceiver(QualifiedName qualifiedName, JvmFeature feature, 
			LightweightTypeReference receiverType,
			int bucketId, boolean visible) {
		super(qualifiedName, feature, bucketId, visible);
		this.implicitReceiverType = receiverType;
		this.implicitReceiver = XbaseFactory.eINSTANCE.createXFeatureCall();
	}
	
	@Override
	@Nullable
	public LightweightTypeReference getImplicitReceiverType() {
		return implicitReceiverType;
	}
	
	@Override
	public XExpression getImplicitReceiver() {
		return implicitReceiver;
	}

}
