/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.summer.dsl.xbase.typesystem.legacy;

import org.summer.dsl.model.types.JvmTypeReference;
import org.summer.dsl.model.types.util.ITypeArgumentContext;
import org.summer.dsl.model.types.util.TypeArgumentContextProvider;
import org.summer.dsl.model.xbase.XAbstractFeatureCall;
import org.summer.dsl.xbase.typesystem.IBatchTypeResolver;
import org.summer.dsl.xbase.typesystem.references.LightweightTypeReference;
import org.summer.dsl.xbase.typesystem.references.OwnedConverter;
import org.summer.dsl.xbase.typesystem.util.CommonTypeComputationServices;
import org.summer.dsl.xbase.typing.XbaseTypeArgumentContextProvider;

import com.google.inject.Inject;
import com.google.inject.Singleton;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@Deprecated
@Singleton
public class LegacyTypeArgumentContextProvider extends XbaseTypeArgumentContextProvider {

	@Inject
	private CommonTypeComputationServices services;
	
	@Inject
	private IBatchTypeResolver typeResolver;
	
	@Override
	public ITypeArgumentContext getTypeArgumentContext(TypeArgumentContextProvider.Request request) {
		if (request instanceof XbaseTypeArgumentContextProvider.AbstractFeatureCallRequest) {
			XAbstractFeatureCall featureCall = ((XbaseTypeArgumentContextProvider.AbstractFeatureCallRequest) request).getFeatureCall();
			JvmTypeReference receiverType = request.getReceiverType();
			LightweightTypeReference receiver = null;
			if (receiverType != null) {
				StandardTypeReferenceOwner owner = new StandardTypeReferenceOwner(services, featureCall);
				receiver = new OwnedConverter(owner).toLightweightReference(receiverType);
			}
			return new FeatureCallTypeArgumentContext(featureCall, receiver, typeResolver);
		}
		return new LegacyTypeArgumentContext(request, services);
	}
	
}
