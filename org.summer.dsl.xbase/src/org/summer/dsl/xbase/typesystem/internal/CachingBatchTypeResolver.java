/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.summer.dsl.xbase.typesystem.internal;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.NonNullByDefault;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.xtext.resource.ISynchronizable;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.util.OnChangeEvictingCache;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;
import org.summer.dsl.model.xbase.XAbstractFeatureCall;
import org.summer.dsl.xbase.typesystem.IBatchTypeResolver;
import org.summer.dsl.xbase.typesystem.IResolvedTypes;

import com.google.inject.Inject;
import com.google.inject.Provider;

/**
 * A batch type resolver that uses the resource scope cache to 
 * return a cached result of the computed types.
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class CachingBatchTypeResolver implements IBatchTypeResolver {

	@Inject
	private OnChangeEvictingCache cache;
	
	@Inject
	private DefaultBatchTypeResolver delegate;
	
	@NonNull
	public IResolvedTypes resolveTypes(final @Nullable EObject object) {
		if (object == null || object.eIsProxy()) {
			return IResolvedTypes.NULL;
		}
		// TODO: remove when we switch to an Xtend scope provider without artificial feature calls  
		EObject nonArtificialObject = object;
		if(object.eResource() == null && object instanceof XAbstractFeatureCall) {
			nonArtificialObject = ((XAbstractFeatureCall) object).getFeature();
		}
		// TODO
		final Resource resource = nonArtificialObject.eResource();
		final LazyResolvedTypes result = cache.get(CachingBatchTypeResolver.class, resource, new Provider<LazyResolvedTypes>() {
			public LazyResolvedTypes get() {
				final IReentrantTypeResolver resolver = delegate.getTypeResolver(object);
				return new LazyResolvedTypes(resolver, resource);
			}
		});
		cache.execWithoutCacheClear(resource, new IUnitOfWork.Void<Resource>() {
			@Override
			public void process(Resource state) throws Exception {
				result.delegate(); // trigger the actual resolution after the thing was cached
			}
		});
		return result;
	}
	
	@NonNull
	public IScope getFeatureScope(@Nullable XAbstractFeatureCall featureCall) {
		if (featureCall != null) {
			Resource resource = featureCall.eResource();
			if (resource instanceof ISynchronizable<?>) {
				synchronized(((ISynchronizable<?>) resource).getLock()) {
					return delegate.getFeatureScope(featureCall);
				}
			}
			return delegate.getFeatureScope(featureCall);
		}
		return IScope.NULLSCOPE;
	}
	
	@NonNull
	public IResolvedTypes getResolvedTypesInContextOf(@Nullable EObject context) {
		if (context != null) {
			Resource resource = context.eResource();
			if (resource instanceof ISynchronizable<?>) {
				synchronized(((ISynchronizable<?>) resource).getLock()) {
					return delegate.getResolvedTypesInContextOf(context);
				}
			}
			return delegate.getResolvedTypesInContextOf(context);
		}
		return IResolvedTypes.NULL;
	}
	
	@NonNullByDefault
	protected static class LazyResolvedTypes extends ForwardingResolvedTypes {

		private final IReentrantTypeResolver resolver;

		private final Resource resource;
		
		private volatile IResolvedTypes delegate;
		
		public LazyResolvedTypes(IReentrantTypeResolver resolver, Resource resource) {
			this.resolver = resolver;
			this.resource = resource;
		}

		@Override
		protected IResolvedTypes delegate() {
			if (this.delegate == null) {
				synchronized (getLock()) {
					if (this.delegate == null) {
						IResolvedTypes result = resolver.reentrantResolve();
						this.delegate = result;
						return result;
					}
				}
			}
			return delegate;
		}
		
		protected Object getLock() {
			if (resource instanceof ISynchronizable<?>) {
				return ((ISynchronizable<?>) resource).getLock();
			}
			return resource;
		}
		
	}

}
