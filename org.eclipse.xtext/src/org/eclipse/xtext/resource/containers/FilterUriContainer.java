/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.resource.containers;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.IContainer;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.impl.AbstractContainer;

import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;

/**
 * A container that virtually removes a {@link IResourceDescription resource description}
 * with a given {@link URI uri} from another container.
 * 
 * @author Holger Schill - Initial contribution and API
 * @author Sebastian Zarnekow - Optimizations and Javadoc
 */
public class FilterUriContainer extends AbstractContainer {
	private final URI filterMe;
	private final IContainer delegate;

	public FilterUriContainer(URI filterMe, IContainer delegate) {
		this.filterMe = filterMe;
		this.delegate = delegate;
	}
	
	@Override
	public boolean isEmpty() {
		return getResourceDescriptionCount() == 0;
	}
	
	@Override
	public boolean hasResourceDescription(URI uri) {
		if (filterMe.equals(uri))
			return false;
		return delegate.hasResourceDescription(uri);
	}
	
	@Override
	public int getResourceDescriptionCount() {
		int delegateCount = delegate.getResourceDescriptionCount();
		if (delegate.hasResourceDescription(filterMe))
			return delegateCount-1;
		return delegateCount;
	}
	
	public Iterable<IResourceDescription> getResourceDescriptions() {
		return Iterables.filter(delegate.getResourceDescriptions(), new Predicate<IResourceDescription>() {
			public boolean apply(IResourceDescription input) {
				return !input.getURI().equals(filterMe);
			}
		});
	}
	
	@Override
	public Iterable<IEObjectDescription> getExportedObjects(EClass type, QualifiedName qualifiedName, boolean ignoreCase) {
		Iterable<IEObjectDescription> unfiltered = delegate.getExportedObjects(type, qualifiedName, ignoreCase);
		return Iterables.filter(unfiltered, new Predicate<IEObjectDescription>() {
			public boolean apply(IEObjectDescription input) {
				URI resourceURI = input.getEObjectURI().trimFragment();
				return !resourceURI.equals(filterMe);
			}
		});
	}

	@Override
	public Iterable<IEObjectDescription> getExportedObjectsByType(EClass type) {
		Iterable<IEObjectDescription> unfiltered = delegate.getExportedObjectsByType(type);
		return Iterables.filter(unfiltered, new Predicate<IEObjectDescription>() {
			public boolean apply(IEObjectDescription input) {
				URI resourceURI = input.getEObjectURI().trimFragment();
				return !resourceURI.equals(filterMe);
			}
		});
	}

	@Override
	public IResourceDescription getResourceDescription(URI uri) {
		if (uri.equals(filterMe))
			return null;
		return delegate.getResourceDescription(uri);
	}
}
