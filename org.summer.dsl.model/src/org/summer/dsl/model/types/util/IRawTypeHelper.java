/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.summer.dsl.model.types.util;

import java.util.List;

import org.eclipse.emf.ecore.resource.Resource;
import org.summer.dsl.model.types.JvmType;
import org.summer.dsl.model.types.JvmTypeReference;

import com.google.inject.ImplementedBy;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@ImplementedBy(RawTypeHelper.class)
public interface IRawTypeHelper {
	
	List<JvmType> getAllRawTypes(JvmTypeReference reference, Resource resource);
	
	JvmTypeReference getRawTypeReference(JvmTypeReference reference, Resource resource);
	
}
