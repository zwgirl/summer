/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.summer.dsl.model.types.access;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.summer.dsl.model.types.JvmTypeReference;
import org.summer.dsl.model.types.access.impl.IndexedJvmTypeAccess;
import org.eclipse.xtext.resource.IFragmentProvider;
import org.eclipse.xtext.resource.ISynchronizable;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class TypeResource extends ResourceImpl implements ISynchronizable<TypeResource>{

	private IMirror mirror;
	
	private IndexedJvmTypeAccess indexedJvmTypeAccess;
	
	private IFragmentProvider.Fallback fragmentProviderFallback = new IFragmentProvider.Fallback() {
		
		public String getFragment(EObject obj) {
			return TypeResource.super.getURIFragment(obj);
		}
		
		public EObject getEObject(String fragment) {
			return TypeResource.super.getEObject(fragment);
		}
	};
	
	public TypeResource() {
		super();
	}

	public TypeResource(URI uri) {
		super(uri);
	}
	
	@Override
	public NotificationChain basicSetResourceSet(ResourceSet resourceSet, NotificationChain notifications) {
		if (resourceSet == null) {
			ResourceSet oldResourceSet = this.resourceSet;
			if (oldResourceSet != null && !oldResourceSet.eDeliver()) {
				oldResourceSet.eAdapters().remove(mirror);
				mirror = null;
				eSetDeliver(false);
				if (contents != null)
					contents.clear();
				unload();
			}
		}
		return super.basicSetResourceSet(resourceSet, notifications);
	}
	
	@Override
	public EObject getEObject(String uriFragment) {
		if (mirror != null) {
			EObject result = mirror.getEObject(this, uriFragment, fragmentProviderFallback);
			return result;
		}
		return super.getEObject(uriFragment);
	}
	
	@Override
	public String getURIFragment(EObject eObject) {
		if (mirror != null) {
			String result = mirror.getFragment(eObject, fragmentProviderFallback);
			return result;
		}
		return super.getURIFragment(eObject);
	}

	public void setMirror(IMirror mirror) {
		this.mirror = mirror;
	}

	public IMirror getMirror() {
		return mirror;
	}
	
	@Override
	public void load(Map<?, ?> options) throws IOException {
		if (!isLoaded) {
			load(null, options);
		}
	}
	
	@Override
	public void save(Map<?, ?> options) throws IOException {
		throw new UnsupportedOperationException();
	}
	
	@Override
	protected void doLoad(InputStream inputStream, Map<?, ?> options) throws IOException {
		try {
			if (getURI() != null && mirror != null) {
				mirror.initialize(this);
			}
		} catch(Exception e) {
			throw new CannotLoadTypeResourceException(e);
		}
	}
	
	protected static class CannotLoadTypeResourceException extends IOException {

		private static final long serialVersionUID = 1L;

		public CannotLoadTypeResourceException(Exception e) {
			super(e.getMessage());
			initCause(e);
		}
	}
	
	public EObject resolveJavaObjectURIProxy(InternalEObject proxy, JvmTypeReference sender) {
		if (indexedJvmTypeAccess != null) {
			EObject result = indexedJvmTypeAccess.getIndexedJvmType(proxy.eProxyURI(), getResourceSet());
			if (result != null) {
				return result;
			}
		}
		return EcoreUtil.resolve(proxy, sender);
	}

	public IndexedJvmTypeAccess getIndexedJvmTypeAccess() {
		return indexedJvmTypeAccess;
	}

	public void setIndexedJvmTypeAccess(IndexedJvmTypeAccess indexedJvmTypeAccess) {
		this.indexedJvmTypeAccess = indexedJvmTypeAccess;
	}

	/**
	 * Returns the lock of the owning {@link ResourceSet}, if it exposes such a lock.
	 * Otherwise this resource itself is used as the lock context.
	 */
	@NonNull
	public Object getLock() {
		ResourceSet resourceSet = getResourceSet();
		if (resourceSet instanceof ISynchronizable<?>) {
			return ((ISynchronizable<?>) resourceSet).getLock();
		}
		return this;
	}
	
	/**
	 * {@inheritDoc}
	 * 
	 * @since 2.4
	 */
	@Nullable
	public <Result> Result execute(@NonNull IUnitOfWork<Result, ? super TypeResource> unit) throws Exception {
		synchronized (getLock()) {
			return unit.exec(this);
		}
	}
	
}
