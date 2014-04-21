/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.summer.dsl.xbase.ui.file

import com.google.inject.Inject
import java.io.InputStream
import org.eclipse.core.resources.IFile
import org.eclipse.core.resources.IFolder
import org.eclipse.core.resources.IWorkspaceRoot
import org.summer.ss.lib.macro.file.Path
import org.summer.dsl.xbase.file.AbstractFileSystemSupport
import com.google.common.base.Preconditions
import org.eclipse.core.resources.IContainer
import org.eclipse.core.resources.IProject
import org.eclipse.core.filesystem.URIUtil
import org.eclipse.emf.ecore.resource.Resource

/**
 * A FileSystemSupport implementation which maps to the Eclipse Resources API.
 * 
 * @author Sven Efftinge
 */
class EclipseFileSystemSupportImpl extends AbstractFileSystemSupport {
	
	@Property @Inject IWorkspaceRoot workspaceRoot
	
	protected def getEclipseFile(Path path) {
		getWorkspaceRoot.getFile(new org.eclipse.core.runtime.Path(path.toString))
	}
	
	protected def getEclipseFolder(Path path) {
		getWorkspaceRoot.getFolder(new org.eclipse.core.runtime.Path(path.toString))
	}
	
	protected def IContainer getEclipseContainer(Path path) {
		Preconditions.checkState(path.absolute, '''The given path has to be absolute: '�path�'.''')
		switch segments : path.segments {
			case segments.size == 0: {
				getWorkspaceRoot
			}
			case segments.size == 1: {
				getWorkspaceRoot.getProject(path.segments.head)	
			}
			default: {
				getWorkspaceRoot.getFolder(new org.eclipse.core.runtime.Path(path.toString))
			}
		}
	}
	
	protected def findResource(Path path) {
		getWorkspaceRoot.findMember(new org.eclipse.core.runtime.Path(path.toString))
	}
	
	protected def toEclipsePath(Path path) {
		new org.eclipse.core.runtime.Path(path.toString)
	}

	override Iterable<? extends Path> getChildren(Path path) {
		val container = path.getEclipseContainer
		if (!container.exists) {
			return emptyList
		} 
		container.members.map[new Path(fullPath.toString)]
	}

	override boolean exists(Path path) {
		path.findResource != null
	}

	override boolean isFolder(Path path) {
		path.findResource instanceof IContainer
	}

	override boolean isFile(Path path) {
		path.findResource instanceof IFile
	}

	override long getLastModification(Path path) {
		path.findResource.modificationStamp
	}

	override String getCharset(Path path) {
		if (path.isFile) {
			return path.getEclipseFile.charset
		} else if (path.isFolder) {
			return path.getEclipseContainer.defaultCharset
		} else {
			return path.parent.getCharset
		}
	}

	override InputStream getContentsAsStream(Path path) {
		path.getEclipseFile.contents
	}
	
	override delete(Path path) {
		if (path.exists) {
			path.findResource.delete(true, null)
			return true
		}
		return false
	}
	
	override mkdir(Path path) {
		if (path.exists)
			return false;
		if (!path.parent.exists) {
			path.parent.mkdir
		}
		switch container : path.getEclipseContainer {
			IFolder: {
				container.create(true, true, null)
				true
			}
			IProject: {
				container.create(null)
				true
			}
			default: 
				false
		}
	}
	
	override setContentsAsStream(Path path, InputStream stream) {
		if (path.exists) {
			path.getEclipseFile.setContents(stream, true, true, null)
		} else {
			path.parent.mkdir
			path.getEclipseFile.create(stream, true, null)
		}
	}
	
	override toURI(Path path) {
		URIUtil.toURI(getWorkspaceRoot.location.append(path.toString))
	}
	
	override getPath(Resource res) {
		if (!res.getURI.platform) {
			throw new IllegalStateException("Expecting platform URI but was : " + res.getURI)
		}
		return new Path(res.getURI.toPlatformString(false))
	}
	
}