/*******************************************************************************
 * Copyright (c) 2011 Sigasi NV (http://www.sigasi.com) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Lieven Lemiengre - initial API and implementation and/or initial documentation
 *******************************************************************************/
package org.summer.dsl.builder.resourceloader;

import java.util.Collection;
import java.util.Queue;

import org.eclipse.core.resources.IProject;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.ui.resource.IResourceSetProvider;

import com.google.common.collect.Lists;

/**
 * Loads resources in sequentially in the same thread as it was invoked.
 *
 * @author Lieven Lemiengre - Initial contribution and API
 * @author Sebastian Zarnekow - Use IProject aware IResourceSetProvider instead of Provider<XtextResourceSet>
 * @since 2.1
 */
public class SerialResourceLoader extends AbstractResourceLoader {

	public SerialResourceLoader(IResourceSetProvider resourceSetProvider, Sorter sorter) {
		super(resourceSetProvider, sorter);
	}

	public LoadOperation create(final ResourceSet parent, IProject project) {
		final Queue<URI> queue = Lists.newLinkedList();
		return new CheckedLoadOperation(new LoadOperation() {

			public LoadResult next() {
				URI uri = queue.poll();
				try {
					Resource resource = parent.getResource(uri, true);
					return new LoadResult(resource, uri);
				} catch(WrappedException e) {
					throw new LoadOperationException(uri, (Exception) e.getCause() );
				}
			}

			public boolean hasNext() {
				return !queue.isEmpty();
			}

			public Collection<URI> cancel() {
				return queue;
			}

			public void load(Collection<URI> uris) {
				queue.addAll(getSorter().sort(uris));
			}
		});
	}

}
