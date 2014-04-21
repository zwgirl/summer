/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.summer.dsl.xbase.impl;

import static com.google.common.collect.Lists.newArrayList;
import static java.util.Collections.emptyList;

import java.util.List;

import org.summer.dsl.model.types.JvmConstructor;
import org.summer.dsl.model.types.JvmIdentifiableElement;
import org.summer.dsl.model.types.JvmOperation;
import org.summer.dsl.model.xbase.XAbstractFeatureCall;
import org.summer.dsl.model.xbase.XExpression;
import org.summer.dsl.xbase.resource.BatchLinkableResource;
import org.summer.dsl.xbase.resource.LinkingAssumptions;

import com.google.common.collect.Lists;
import com.google.inject.Inject;
import com.google.inject.Singleton;

/**
 * @author Sven Efftinge - Initial contribution and API
 * @author Sebastian Zarnekow - Support for linking assumptions
 * @deprecated Query the XAbstractFeatureCall directly
 */
@Deprecated
@Singleton
public class FeatureCallToJavaMapping {
	
	@Inject
	private LinkingAssumptions linkingAssumptions;
	
	protected boolean isStaticJavaFeature(JvmIdentifiableElement feature) {
		if (feature instanceof JvmOperation) {
			return ((JvmOperation) feature).isStatic();
		}
		return false;
	}
	
	public XExpression getActualReceiver(XAbstractFeatureCall call) {
		if (call.eResource() instanceof BatchLinkableResource) {
			return call.getActualReceiver();
		}
		return getActualReceiver(call, getFeature(call), getImplicitReceiver(call));
	}

	public XExpression getActualReceiver(XAbstractFeatureCall featureCall, JvmIdentifiableElement feature, XExpression implicitReceiver) {
		if (isStaticJavaFeature(feature) || feature instanceof JvmConstructor) {
			return null;
		}
		if (implicitReceiver!=null)
			return implicitReceiver;
		final List<? extends XExpression> allArguments = featureCall.getExplicitArguments();
		if (allArguments.isEmpty())
			return null;
		return allArguments.get(0);
	}
	
	protected JvmIdentifiableElement getFeature(XAbstractFeatureCall expr) {
		return linkingAssumptions.getFeature(expr, true);
	}
	
	protected XExpression getImplicitReceiver(XAbstractFeatureCall expr) {
		return linkingAssumptions.getImplicitReceiver(expr);
	}

	protected XExpression getImplicitFirstArgument(XAbstractFeatureCall expr) {
		return linkingAssumptions.getImplicitFirstArgument(expr);
	}
	
	public List<XExpression> getActualArguments(XAbstractFeatureCall featureCall) {
		if (featureCall.eResource() instanceof BatchLinkableResource) {
			return featureCall.getActualArguments();
		}
		return getActualArguments(
				featureCall, 
				getFeature(featureCall), 
				getImplicitReceiver(featureCall), 
				getImplicitFirstArgument(featureCall));
	}
	
	public List<XExpression> getActualArguments(
			XAbstractFeatureCall featureCall, 
			JvmIdentifiableElement feature, 
			XExpression implicitReceiver, 
			XExpression implicitFirstArgument) {
		final List<XExpression> explicitArguments = featureCall.getExplicitArguments();
		if (isStaticJavaFeature(feature)) {
			if (implicitReceiver == null || explicitArguments.contains(implicitReceiver))
				return newArrayList(explicitArguments);
			List<XExpression> result = newArrayList(implicitReceiver);
			result.addAll(explicitArguments);
			return result;
		} else if (implicitReceiver != null) {
			if (implicitFirstArgument != null) {
				List<XExpression> result = Lists.newArrayList(implicitFirstArgument);
				result.addAll(explicitArguments);
				return result;
			}
			return newArrayList(explicitArguments);
		}
		if (feature instanceof JvmConstructor) {
			// this or super call in constructor - don't strip the receiver
			return explicitArguments;
		}
		if (explicitArguments.size()<=1)
			return emptyList();
		return newArrayList(explicitArguments.subList(1, explicitArguments.size()));
	}
	
	/**
	 * @param featureCall may be used by inheritors  
	 * @param implicitReceiver may be used by inheritors
	 */
	public boolean isTargetsMemberSyntaxCall(XAbstractFeatureCall featureCall, JvmIdentifiableElement feature, XExpression implicitReceiver) {
		return !isStaticJavaFeature(feature);
	}
	
}
