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

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.ui.resource.IResourceSetProvider;

/**
 * @author Lieven Lemiengre - Initial contribution and API
 * @author Sebastian Zarnekow - Use IProject aware IResourceSetProvider instead of Provider<XtextResourceSet>
 * @since 2.1
 */
public abstract class AbstractResourceLoader implements IResourceLoader {

	private final IResourceSetProvider resourceSetProvider;
	private final Sorter sorter;

	public AbstractResourceLoader(IResourceSetProvider resourceSetProvider, Sorter sorter) {
		this.resourceSetProvider = resourceSetProvider;
		this.sorter = sorter;
	}

	public IResourceSetProvider getResourceSetProvider() {
		return resourceSetProvider;
	}

	public Sorter getSorter() {
		return sorter;
	}

	protected Resource loadResource(URI uri, ResourceSet localResourceSet, ResourceSet parentResourceSet) {
		return localResourceSet.getResource(uri, true);
	}

	protected class CheckedLoadOperation implements LoadOperation {

		private final LoadOperation parent;
		private boolean isLoading = false;
		private boolean isCancelled = false;

		public CheckedLoadOperation(LoadOperation parent) {
			this.parent = parent;
		}

		public void load(Collection<URI> uris) {
			if(isLoading) {
				throw new IllegalStateException("The load operation has already been started.");
			}
			isLoading = true;
			parent.load(uris);
		}

		public boolean hasNext() {
			checkIsLoading();
			checkIsNotCancelled();
			return parent.hasNext();
		}

		public LoadResult next() throws LoadOperationException {
			checkIsLoading();
			checkIsNotCancelled();
			return parent.next();
		}

		public Collection<URI> cancel() {
			checkIsLoading();
			isCancelled = true;
			return parent.cancel();
		}

		private void checkIsLoading() {
			if(!isLoading) {
				throw new IllegalStateException("The load operation hasn't started yet.");
			}
		}

		private void checkIsNotCancelled() {
			if(isCancelled) {
				throw new IllegalStateException("The load operation was cancelled.");
			}
		}
	}
}
