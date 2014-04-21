/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.summer.dsl.xbase.scoping.batch

import java.util.EnumSet
import java.util.List
import java.util.Map
import org.summer.dsl.model.types.JvmType
import org.summer.dsl.model.types.JvmTypeReference
import org.summer.dsl.model.xbase.XExpression
import org.summer.dsl.xbase.typesystem.conformance.ConformanceHint
import org.summer.dsl.xbase.typesystem.^override.IResolvedFeatures
import org.summer.dsl.xbase.typesystem.references.LightweightTypeReference

/**
 * A type bucket collects a number of types that originate in the 
 * very same source, e.g. all imported types are contained in the 
 * same bucket where all types that are available via wildcard imports
 * are contained in a different bucket.
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@Data
class TypeBucket {
	int id
	List<? extends JvmType> types
	IResolvedFeatures.Provider resolvedFeaturesProvider
	def getHints() {
		EnumSet.of(ConformanceHint.CHECKED, ConformanceHint.SUCCESS)
	}
}

/**
 * A type bucket collects a number of types that originate in the 
 * very same source, e.g. all imported types are contained in the 
 * same bucket where all types that are available via wildcard imports
 * are contained in a different bucket.
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@Data
class ExpressionBucket {
    int id
    Map<XExpression, LightweightTypeReference> extensionProviders
    IResolvedFeatures.Provider resolvedFeaturesProvider
}

/**
 * A type bucket that was produced from the synonym of a type.
 * It tracks the conformance hints for a synonym, e.g. boxing or unboxing information.
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@Data
class SynonymTypeBucket extends org.summer.dsl.xbase.scoping.batch.TypeBucket {
	EnumSet<ConformanceHint> hints
}

/**
 * A type bucket collects a number of types that originate in the 
 * very same source, e.g. all implicit receiver types are contained
 * in the very same bucket.
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@Data
class TypeReferenceBucket {
	int id
	List<JvmTypeReference> types
}