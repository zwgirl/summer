/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.summer.dsl.xbase.ui.hover;

import org.summer.dsl.model.xbase.XAbstractFeatureCall;
import org.summer.dsl.xbase.ui.hover.FeatureCallRequest.IFeatureCallRequestProvider;

import com.google.inject.Inject;
import com.google.inject.Provider;

/**
 * 
 * @author Holger Schill - Initial contribution and API
 * @since 2.3
 */
public class FeatureCallRequestProvider implements IFeatureCallRequestProvider{
	
	@Inject
	private Provider<FeatureCallRequest> featureCallRequestProvider;
	public FeatureCallRequest get(XAbstractFeatureCall featureCall) {
		FeatureCallRequest featureCallRequest = featureCallRequestProvider.get();
		featureCallRequest.setFeatureCall(featureCall);
		return featureCallRequest;
	}
}