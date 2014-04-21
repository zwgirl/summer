/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.summer.dsl.model.types.access;

import org.eclipse.emf.ecore.resource.ResourceSet;
import org.summer.dsl.model.types.access.impl.ClasspathTypeProvider;
import org.eclipse.xtext.resource.XtextResourceSet;

import com.google.inject.Inject;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class ClasspathTypeProviderFactory extends AbstractTypeProviderFactory {

	private final ClassLoader classLoader;
	
	@Inject
	public ClasspathTypeProviderFactory(ClassLoader classLoader) {
		this.classLoader = classLoader;
	}
	
	public ClasspathTypeProvider createTypeProvider(ResourceSet resourceSet) {
		if (resourceSet == null)
			throw new IllegalArgumentException("resourceSet may not be null.");
		ClasspathTypeProvider result = createClasspathTypeProvider(resourceSet);
		return result;
	}

	protected ClasspathTypeProvider createClasspathTypeProvider(ResourceSet resourceSet) {
		return new ClasspathTypeProvider(getClassLoader(resourceSet), resourceSet, getIndexedJvmTypeAccess());
	}
	
	public ClassLoader getClassLoader(ResourceSet resourceSet) {
		if (resourceSet instanceof XtextResourceSet) {
			XtextResourceSet xtextResourceSet = (XtextResourceSet) resourceSet;
			Object ctx = xtextResourceSet.getClasspathURIContext();
			if (ctx != null) {
		        if (ctx instanceof Class<?>) {
		            return ((Class<?>)ctx).getClassLoader();
		        }
		        if (!(ctx instanceof ClassLoader)) {
		        	return ctx.getClass().getClassLoader();
		        }
		        return (ClassLoader) ctx;
			}
		}
		return classLoader;
	}
	
	@Override
	public ClasspathTypeProvider createTypeProvider() {
		return (ClasspathTypeProvider) super.createTypeProvider();
	}
	
	@Override
	public ClasspathTypeProvider findTypeProvider(ResourceSet resourceSet) {
		return (ClasspathTypeProvider) super.findTypeProvider(resourceSet);
	}
	
}
