/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.resource.impl;

import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.ContentHandler;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.eclipse.emf.ecore.resource.URIHandler;
import org.eclipse.emf.ecore.resource.impl.ExtensibleURIConverterImpl;
import org.eclipse.emf.ecore.resource.impl.ResourceFactoryRegistryImpl;
import org.eclipse.xtext.resource.IResourceServiceProvider;

import com.google.common.collect.Lists;
import com.google.inject.Provider;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * @author Sven Efftinge
 */
public class ResourceServiceProviderRegistryImpl implements IResourceServiceProvider.Registry {

	/**
	 * @author Sven Efftinge - Initial contribution and API
	 */
	public static class InternalData extends ResourceFactoryRegistryImpl {

		@SuppressWarnings({ "unchecked" })
		public IResourceServiceProvider getServiceProvider(URI uri, String contentType) {
			Object object = getFactory(uri, protocolToFactoryMap, extensionToFactoryMap,
					contentTypeIdentifierToFactoryMap, contentType, false);
			if (object instanceof IResourceServiceProvider.Provider) {
				return ((IResourceServiceProvider.Provider) object).get(uri, contentType);
			} else if (object instanceof Provider<?>) {
				return ((Provider<IResourceServiceProvider>) object).get();
			}
			return (IResourceServiceProvider) object;
		}

		private ExtensibleURIConverterImpl uriConverter;

		@Override
		protected synchronized URIConverter getURIConverter() {
			if (this.uriConverter == null) {
				List<ContentHandler> withoutPlatformDelegate = Lists.newArrayList();
				for (ContentHandler contentHandler : ContentHandler.Registry.INSTANCE.contentHandlers()) {
					if (!isTooEager(contentHandler))
						withoutPlatformDelegate.add(contentHandler);
				}
				this.uriConverter = new ExtensibleURIConverterImpl(URIHandler.DEFAULT_HANDLERS, withoutPlatformDelegate);
			}
			return this.uriConverter;
		}

		private boolean isTooEager(ContentHandler contentHandler) {
			try {
				return contentHandler.canHandle(null);
			} catch (RuntimeException e) {
			} catch (AssertionError e) {
			}
			return false;
		}
	}

	private final InternalData data = new InternalData();

	public IResourceServiceProvider getResourceServiceProvider(URI uri, String contentType) {
		if (uri == null)
			return null;
		return data.getServiceProvider(uri, contentType);
	}

	public Map<String, Object> getContentTypeToFactoryMap() {
		return data.getContentTypeToFactoryMap();
	}

	public Map<String, Object> getExtensionToFactoryMap() {
		return data.getExtensionToFactoryMap();
	}

	public Map<String, Object> getProtocolToFactoryMap() {
		return data.getProtocolToFactoryMap();
	}

	public IResourceServiceProvider getResourceServiceProvider(URI uri) {
		return getResourceServiceProvider(uri, ContentHandler.UNSPECIFIED_CONTENT_TYPE);
	}

}
