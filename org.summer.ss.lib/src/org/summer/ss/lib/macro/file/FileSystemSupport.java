/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.summer.ss.lib.macro.file;

import java.io.InputStream;
import java.net.URI;

import com.google.common.annotations.Beta;

/**
 * 
 * Support for accessing the file system.
 * 
 * @author Anton Kosyakov
 * @author Sven Efftinge
 */
@Beta
public interface FileSystemSupport {

	/**
	 * @param path
	 * @return the children of the folder the given path points to; 
	 * 		   empty iterable if the path points to a non existent resource or to an existent file 
	 */
	Iterable<? extends Path> getChildren(Path path);
	
	/**
	 * @param path the path
	 * @return whether the given path points to an existent file.
	 */
	boolean exists(Path path);
	
	/**
	 * @param path
	 * @return whether the given path points to an existent folder
	 */
	boolean isFolder(Path path);
	
	/**
	 * @param path
	 * @return whether the given path points to an existent file
	 */
	boolean isFile(Path path);
	
	/**
	 * @param path
	 * @return  A <code>long</code> value representing the time the file was
     *          last modified, measured in milliseconds since the epoch
     *          (00:00:00 GMT, January 1, 1970), or <code>0L</code> if the
     *          file does not exist.
	 */
	long getLastModification(Path path);
	
	/**
	 * Returns the name of a charset to be used when decoding the contents of this 
	 * file into characters. 
	 * 
	 * @param path the path
	 * @return the name of a charset
	 */
	String getCharset(Path path);

	/**
	 * Returns the contents of this file as a char sequence.
	 * 
	 * @param path the path
	 * @return an input stream containing the contents of the file
	 * @exception IllegalArgumentException if the path points a non existent resource or a folder
	 */
	CharSequence getContents(Path path);
	
	/**
	 * Returns an open input stream on the contents of this file.
	 * 
	 * @param path the path
	 * @return an input stream containing the contents of the file
	 * @exception IllegalArgumentException if the path points a non existent resource or a folder
	 */
	InputStream getContentsAsStream(Path path);
	
	/**
	 * Returns the URI representing the given path.
	 * 
	 * <p>
	 * <b>Warning</b>: Don't use this method to get write access.
	 * </p>
	 * 
	 * @param path
	 *            the path
	 * @return the URI representing the given path
	 */
	URI toURI(Path path);
}
