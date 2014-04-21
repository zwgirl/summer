/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.summer.dsl.model.types.access.impl;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.summer.dsl.model.types.JvmType;
import org.summer.dsl.model.types.access.IJvmTypeProvider;
import org.summer.dsl.model.types.access.IMirror;
import org.summer.dsl.model.types.access.TypeResource;

import com.google.common.collect.AbstractIterator;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public abstract class AbstractJvmTypeProvider implements IJvmTypeProvider, Resource.Factory {

	/**
	 * An iterator over all permutations of a given name that are not equal to the original name.
	 * In other words, the iterator yields these values for the input {@code java.lang.String}:
	 * <ol>
	 * <li>{@code java.lang$String}</li>
	 * <li>{@code java$lang$String}</li>
	 * </ol>
	 * 
	 * @noextend This class is not intended to be subclassed by clients.
	 * @noinstantiate This class is not intended to be instantiated by clients.
	 * @since 2.4
	 */
	protected static class ClassNameVariants extends AbstractIterator<String> {

		private StringBuilder buffer;
		private int index;

		public ClassNameVariants(String initial) {
			buffer = new StringBuilder(initial);
			index = buffer.length();
		}
		
		@Override
		protected String computeNext() {
			int newIndex = buffer.lastIndexOf(".", index);
			if (newIndex == -1)
				return endOfData();
			index = newIndex - 1;
			buffer.setCharAt(newIndex, '$');
			return buffer.toString();
		}
		
	}
	
	private final ResourceSet resourceSet;
	
	private final PrimitiveTypeFactory primitiveTypeFactory;

	private final IndexedJvmTypeAccess indexedJvmTypeAccess;
	
	protected AbstractJvmTypeProvider(ResourceSet resourceSet, IndexedJvmTypeAccess indexedJvmTypeAccess) {
		if (resourceSet == null)
			throw new IllegalArgumentException("resourceSet may not be null");
		this.indexedJvmTypeAccess = indexedJvmTypeAccess;
		this.resourceSet = resourceSet;
		registerProtocol(resourceSet);
		primitiveTypeFactory = new PrimitiveTypeFactory();
	}

	protected void registerProtocol(ResourceSet resourceSet) {
		resourceSet.getResourceFactoryRegistry().getProtocolToFactoryMap().put(URIHelperConstants.PROTOCOL, this);
	}

	public abstract JvmType findTypeByName(String name);
	
	protected boolean isBinaryNestedTypeDelimiter(String name, boolean binaryNestedTypeDelimiter) {
		return binaryNestedTypeDelimiter || name.indexOf('$') >= 0 || name.indexOf('.') < 0;
	}
	
	/**
	 * @since 2.4
	 */
	public abstract JvmType findTypeByName(String name, boolean binaryNestedTypeDelimiter);

	public TypeResource createResource(URI uri) {
		TypeResource result = doCreateResource(uri);
		final IMirror createMirror = createMirror(uri);
		if (createMirror !=  null) 
			result.setMirror(createMirror);
		return result;
	}

	protected TypeResource doCreateResource(URI uri) {
		TypeResource result = new TypeResource(uri);
		result.setIndexedJvmTypeAccess(indexedJvmTypeAccess);
		return result;
	}

	public ResourceSet getResourceSet() {
		return resourceSet;
	}
	
	public IMirror createMirror(URI resourceURI) {
		if (resourceURI.hasFragment())
			throw new IllegalArgumentException("Cannot create mirror for uri '" + resourceURI.toString() + "'");
		String name = resourceURI.path();
		if (URIHelperConstants.PRIMITIVES.equals(name))
			return new PrimitiveMirror(primitiveTypeFactory);
		if (!name.startsWith(URIHelperConstants.OBJECTS))
			throw new IllegalArgumentException("Invalid resource uri '" + resourceURI.toString() + "'");
		name = name.substring(URIHelperConstants.OBJECTS.length());
		return createMirrorForFQN(name);
	}

	protected abstract IMirror createMirrorForFQN(String name);

	protected IndexedJvmTypeAccess getIndexedJvmTypeAccess() {
		return indexedJvmTypeAccess;
	}
}
