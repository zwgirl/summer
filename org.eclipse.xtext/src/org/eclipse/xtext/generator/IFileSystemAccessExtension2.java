/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.generator;

import org.eclipse.emf.common.util.URI;

/**
 * @author Jan Koehnlein - Initial contribution and API
 * @since 2.3
 */
public interface IFileSystemAccessExtension2 {
	
	/**
	 * Returns an URI for the specified file.
	 * 
	 * For workspace files a platform:/resource URI should be returned in order to pick up project specific preferences.
	 */
	URI getURI(String fileName, String outputConfiguration);

	/**
	 * Returns an URI for the specified file in the default output location.
	 * 
	 * For workspace files a platform:/resource URI should be returned in order to pick up project specific preferences.
	 */
	URI getURI(String fileName);

}
