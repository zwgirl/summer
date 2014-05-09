/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.summer.dsl.builder.impl;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.core.resources.IProject;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.summer.dsl.builder.IXtextBuilderParticipant.BuildType;
import org.summer.dsl.builder.IXtextBuilderParticipant.IBuildContext;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.IResourceDescription.Delta;

public class BuildContext implements IBuildContext {
//	private final ResourceSet resourceSet;
//	private final List<IResourceDescription.Delta> deltas;
	private final List<URI> uris = new LinkedList<URI>();
	private final XtextBuilder builder;
	private final BuildType type;

//	public BuildContext(XtextBuilder builder, ResourceSet resourceSet, List<Delta> deltas, BuildType type) {
//		super();
//		this.type = type;
//		this.builder = builder;
//		this.resourceSet = resourceSet;
//		this.deltas = deltas;
//	}
	
	public BuildContext(XtextBuilder builder, /*ResourceSet resourceSet,*/ Collection<URI> uris, BuildType type) {
		super();
		this.type = type;
		this.builder = builder;
//		this.resourceSet = resourceSet;
		this.uris.addAll(uris);
	}

	public IProject getBuiltProject() {
		return builder.getProject();
	}

//	public List<IResourceDescription.Delta> getDeltas() {
//		return deltas;
//	}
//
//	public ResourceSet getResourceSet() {
//		return resourceSet;
//	}
	
	@Override
	public List<URI> getURIs() {
		return uris;
	}
	
	public void needRebuild() {
		builder.needRebuild();
	}
	
	public BuildType getBuildType() {
		return type;
	}
}