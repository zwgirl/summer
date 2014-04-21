/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.summer.dsl.xbase.ui.file

import com.google.inject.Inject
import javax.inject.Provider
import org.eclipse.core.resources.IProject
import org.summer.ss.lib.macro.file.Path
import org.summer.dsl.builder.EclipseOutputConfigurationProvider
import org.summer.dsl.xbase.file.ProjectConfig
import org.summer.dsl.xbase.file.WorkspaceConfig
import org.eclipse.jdt.core.JavaCore
import org.eclipse.jdt.core.IPackageFragmentRoot
import org.eclipse.core.resources.IContainer
import org.eclipse.core.resources.IWorkspaceRoot

class EclipseWorkspaceConfigProvider implements Provider<WorkspaceConfig> {
	
	@Property @Inject IWorkspaceRoot workspaceRoot
	
	@Property @Inject EclipseOutputConfigurationProvider configurationProvider
	
	override get() {
		val wsRoot = getWorkspaceRoot.location.toString
		val result = new WorkspaceConfig(wsRoot)
		getWorkspaceRoot.projects.forEach [
			result.projects.put(name, new org.summer.dsl.xbase.ui.file.EclipseProjectConfig(it, getConfigurationProvider))
		]
		return result
	}
	
}

class EclipseProjectConfig extends ProjectConfig {
	
	IProject project
	EclipseOutputConfigurationProvider configurationProvider
	
	new(IProject project, EclipseOutputConfigurationProvider configurationProvider) {
		super(project.name)
		this.project = project;
		this.configurationProvider = configurationProvider
	}
	
	override getSourceFolderMappings() {
		val map = super.sourceFolderMappings
		if (map.empty) {
			val config = configurationProvider.getOutputConfigurations(project).head
			val jp  = JavaCore.create(project)
			for (root : jp.packageFragmentRoots) {
				if (root.kind == IPackageFragmentRoot.K_SOURCE && root.underlyingResource != null) {
					val container = root.underlyingResource as IContainer
					val target = container.parent.getFolder(new org.eclipse.core.runtime.Path(config.outputDirectory))
					if (container != target) {
						map.put(new Path(container.fullPath.toString), new Path(target.fullPath.toString))
					}
				}
			}
		}
		return map;
	}
	
}