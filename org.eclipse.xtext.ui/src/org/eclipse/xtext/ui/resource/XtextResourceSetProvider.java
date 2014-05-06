/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.resource;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.eclipse.core.resources.IProject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.ui.shared.contribution.ISharedStateContributionRegistry;

import com.google.common.collect.ImmutableList;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.Singleton;

/**
 * An extensible implementation of the {@link IResourceSetProvider}.
 * It accepts a list of contributed {@link IResourceSetInitializer initializers}
 * which may configure the newly created resource set in the context of the given
 * {@link IProject project}.
 * 
 * @author Sven Efftinge - Initial contribution and API
 */
@Singleton
public class XtextResourceSetProvider implements IResourceSetProvider {

	@Inject
	private Provider<XtextResourceSet> resourceSetProvider;
	
	private XtextResourceSet xrs;
	
	private static final XtextResourceSetProvider _INSTANCE = new XtextResourceSetProvider();
	
	private static final Map<IProject, XtextResourceSet> cache = new ConcurrentHashMap<IProject, XtextResourceSet>();

	private ImmutableList<? extends IResourceSetInitializer> initializers = ImmutableList.of();

	@Inject
	private void setContributions(ISharedStateContributionRegistry contributionRegistry) {
		initializers = contributionRegistry.getContributedInstances(IResourceSetInitializer.class);
	}
	
	public static XtextResourceSetProvider getInstance() {
		return _INSTANCE;
	}

//	public ResourceSet get(IProject project) {
//		XtextResourceSet set = resourceSetProvider.get();
//		for(int i = 0; i < initializers.size(); i++) {
//			initializers.get(i).initialize(set, project);
//		}
//		return set;
//	}
	
//	public ResourceSet get(IProject project) {
//		
//		XtextResourceSet set = cache.get(project);
//		if(set == null){
//			set = resourceSetProvider.get();
//			set.setProject(project);
//			for(int i = 0; i < initializers.size(); i++) {
//				initializers.get(i).initialize(set, project);
//			}
//			cache.put(project, set);
//		}
//		return set;
//	}
	
	public ResourceSet get(IProject project) {
		
		if(xrs !=null){
			return xrs;
		}
		xrs = new XtextResourceSet();
		return xrs;
	}

}
