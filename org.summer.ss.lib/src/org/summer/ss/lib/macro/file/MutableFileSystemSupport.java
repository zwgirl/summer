/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.summer.ss.lib.macro.file;

import java.io.InputStream;

import com.google.common.annotations.Beta;

/**
 * Allows modifications on the file system.
 * 
 * @author Sven Efftinge
 */
@Beta
public interface MutableFileSystemSupport extends FileSystemSupport {

	/**
	 * Writes the given contents to the given path.
	 * It will create the file if it doesn't exist, and create folders for all parents if the don't exist.
	 * 
	 * @param path the path to write the contents to
	 * @param contents the contents of the file
	 * @throws IllegalArgumentException - if the given path points to a folder
	 */
	void setContents(Path path, CharSequence contents);
	
	/**
	 * Sets the contents of this file to the bytes in the given input stream.
	 * The stream will be closed after the operation has finished.
	 *
	 * @param path the path to the file
	 * @param source an input stream containing the new contents of the file
	 */
	void setContentsAsStream(Path path, InputStream source);
	
	/**
	 * Creates a directory for the given path and all its parents if necessary.
	 * @param path the path to the file
	 * @return <code>true</code> if the folder has been created <code>false</code> if it already existed
	 * @throws IllegalArgumentException if the given path points to an existent file
	 */
	boolean mkdir(Path path);
	
	/**
	 * Deletes the file or folder the given path points to. 
	 * If path points to a folder this method will also delet all its contents.
	 * 
	 * @param path
	 * @return <code>true</code> if the resource was deleted, <code>false</code> if it didn't exist 
	 */
	boolean delete(Path path);

}
