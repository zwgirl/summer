/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.summer.dsl.xbase.file

import com.google.common.io.ByteStreams
import java.io.File
import java.io.FileInputStream
import java.io.FileOutputStream
import java.io.InputStream
import org.eclipse.emf.common.util.URI
import org.summer.ss.lib.macro.file.Path
import org.eclipse.xtext.util.Files
import com.google.inject.Inject
import com.google.inject.Provider
import java.io.BufferedInputStream
import java.io.BufferedOutputStream
import org.eclipse.emf.ecore.resource.Resource

/**
 * @author Sven Efftinge - Initial contribution and API
 */
class JavaIOFileSystemSupport extends org.summer.dsl.xbase.file.AbstractFileSystemSupport {
	
	@Inject @Property Provider<WorkspaceConfig> projectInformationProvider
	
	override Iterable<? extends Path> getChildren(Path path) {
		if (!path.exists) {
			return emptyList
		}
		if (path.isFile) {
			return emptyList
		}
		path.getJavaIOFile.list.map[path.getAbsolutePath(it)]
	}

	protected def File getJavaIOFile(Path path) {
		return new File(getProjectInformationProvider.get.getAbsoluteFileSystemPath, path.toString())
	}

	override boolean exists(Path path) {
		path.getJavaIOFile.exists
	}

	override boolean isFolder(Path path) {
		path.getJavaIOFile.isDirectory
	}

	override boolean isFile(Path path) {
		path.getJavaIOFile.isFile
	}

	override long getLastModification(Path path) {
		path.getJavaIOFile.lastModified
	}

	override String getCharset(Path path) {
		return getEncodingProvider.getEncoding(URI.createFileURI(path.getJavaIOFile.absolutePath))
	}

	override InputStream getContentsAsStream(Path path) {
		return new BufferedInputStream(new FileInputStream(path.getJavaIOFile))
	}
	
	override boolean mkdir(Path path) {
		if (path.exists)
			return false;
		val parent = path.parent
		if (parent != null) {
			parent.mkdir
		}
		path.getJavaIOFile.mkdir
		return true
	}
	
	override boolean delete(Path path) {
		if (!path.exists)
			return false;
		if (path.getJavaIOFile.directory) {
			Files.sweepFolder(path.getJavaIOFile)
		}
		path.getJavaIOFile.delete
		return true
	}

	override void setContentsAsStream(Path path, InputStream stream) {
		path.parent.mkdir
		ByteStreams.copy(|stream) [| new BufferedOutputStream(new FileOutputStream(path.getJavaIOFile))]
	}
	
	override toURI(Path path) {
		path.getJavaIOFile.toURI
	}
	
	override getPath(Resource res) {
		val uri = res.resourceSet.getURIConverter.normalize(res.getURI)
		if (uri.file) {
			val workspacePath = new File(getProjectInformationProvider.get.getAbsoluteFileSystemPath).toURI.path
			val absolutefilePath = new File(uri.toFileString).toURI.path
			if (!absolutefilePath.startsWith(workspacePath)) {
				throw new IllegalStateException("Couldn't determine file path. The file ('"+absolutefilePath+"') doesn't seem to be contained in the workspace ('"+workspacePath+"')")
			}
			val filePath = absolutefilePath.substring(workspacePath.length)
			return new Path('/'+filePath.toString)
		}
	}
	
}
