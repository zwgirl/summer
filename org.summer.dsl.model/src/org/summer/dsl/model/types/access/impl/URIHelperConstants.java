/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.summer.dsl.model.types.access.impl;

import org.eclipse.emf.common.util.URI;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public interface URIHelperConstants {

	URI PRIMITIVES_URI = URI.createURI("java:/Primitives");
	URI OBJECTS_URI = URI.createURI("java:/Objects");

	String PRIMITIVES = "/Primitives"; //$NON-NLS-1$
	String OBJECTS = "/Objects/"; //$NON-NLS-1$
	String PROTOCOL = "java"; //$NON-NLS-1$
	
}
