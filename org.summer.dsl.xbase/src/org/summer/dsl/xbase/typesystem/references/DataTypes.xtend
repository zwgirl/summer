/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.summer.dsl.xbase.typesystem.references

import java.util.Map
import java.util.Set
import org.summer.dsl.model.types.JvmType
import org.summer.dsl.model.types.JvmTypeParameter
import org.summer.dsl.xbase.typesystem.util.BoundTypeArgumentSource
import org.summer.dsl.xbase.typesystem.util.VarianceInfo

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * TODO JavaDoc
 */
@Data
class LightweightTraversalData {
	Set<JvmType> visited = newHashSet
	Map<JvmTypeParameter, LightweightMergedBoundTypeArgument> typeParameterMapping = newLinkedHashMap
}

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * TODO JavaDoc
 */
@Data
class LightweightBoundTypeArgument {
	LightweightTypeReference typeReference
	BoundTypeArgumentSource source
	Object origin
	VarianceInfo declaredVariance
	VarianceInfo actualVariance
	
	def isValidVariancePair() {
		declaredVariance.mergeDeclaredWithActual(actualVariance) != null
	}
}

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * TODO JavaDoc
 */
@Data
class LightweightMergedBoundTypeArgument {
	LightweightTypeReference typeReference
	VarianceInfo variance
}