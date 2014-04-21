/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.summer.dsl.xbase.scoping.batch;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.summer.dsl.model.types.JvmConstructor;
import org.summer.dsl.model.types.JvmGenericType;
import org.summer.dsl.model.types.JvmTypeParameter;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.IScope;
import org.summer.dsl.model.xbase.XAbstractFeatureCall;
import org.summer.dsl.xbase.typesystem.references.LightweightMergedBoundTypeArgument;
import org.summer.dsl.xbase.typesystem.references.LightweightTypeReference;
import org.summer.dsl.xbase.typesystem.util.DeclaratorTypeArgumentCollector;

import com.google.common.collect.Lists;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class ConstructorDelegateScope extends AbstractSessionBasedScope implements IFeatureNames {
	
	private Map<JvmTypeParameter, LightweightMergedBoundTypeArgument> receiverTypeParameterMapping;
	private LightweightTypeReference contextType;
	
	public ConstructorDelegateScope(IScope parent, LightweightTypeReference contextType, IFeatureScopeSession session, XAbstractFeatureCall featureCall) {
		super(parent, session, featureCall);
		this.contextType = contextType;
	}
	
	@Override
	protected Iterable<IEObjectDescription> getAllLocalElements() {
		throw new UnsupportedOperationException();
	}
	
	@Override
	protected Collection<IEObjectDescription> getLocalElementsByName(QualifiedName name) {
		if (THIS.equals(name) || SUPER.equals(name)) {
			IEObjectDescription description = getSession().getLocalElement(name);
			if (description != null) {
				EObject objectOrProxy = description.getEObjectOrProxy();
				if (objectOrProxy instanceof JvmGenericType && !objectOrProxy.eIsProxy()) {
					return createConstructorDescriptions(name, (JvmGenericType) objectOrProxy, SUPER.equals(name));
				}
			}
		}
		return Collections.emptyList();
	}
	
	protected Map<JvmTypeParameter, LightweightMergedBoundTypeArgument> getReceiverTypeParameterMapping() {
		if (receiverTypeParameterMapping == null) {
			receiverTypeParameterMapping = Collections.emptyMap();
			if (contextType != null) {
				receiverTypeParameterMapping = new DeclaratorTypeArgumentCollector().getTypeParameterMapping(contextType);
			}
		}
		return receiverTypeParameterMapping;
	}
	
	protected Collection<IEObjectDescription> createConstructorDescriptions(QualifiedName name, JvmGenericType type, boolean superType) {
		Iterable<JvmConstructor> constructors = type.getDeclaredConstructors();
		List<IEObjectDescription> result = Lists.newArrayListWithCapacity(3);
		for(JvmConstructor constructor: constructors) {
			result.add(createDescription(name, constructor, superType));
		}
		return result;
	}

	protected IEObjectDescription createDescription(QualifiedName name, JvmConstructor constructor, boolean superType) {
		if (superType)
			return new SuperConstructorDescription(name, constructor, getReceiverTypeParameterMapping(), 0, getSession().isVisible(constructor));
		return new ConstructorDescription(name, constructor, 0, getSession().isVisible(constructor));
	}

}
