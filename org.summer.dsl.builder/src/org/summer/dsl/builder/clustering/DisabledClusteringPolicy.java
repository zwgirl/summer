/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.summer.dsl.builder.clustering;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.ResourceSet;

/**
 * A clustering policy that effectively disables the clustering.
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 * @since 2.4
 */
public class DisabledClusteringPolicy implements IResourceClusteringPolicy  {

	/**
	 * Returns always {@code true} to continue the processing in the very same resource set.
	 * @return {@code true}.
	 */
	public boolean continueProcessing(ResourceSet resourceSet, URI next, int alreadyProcessed) {
		return true;
	}

}
