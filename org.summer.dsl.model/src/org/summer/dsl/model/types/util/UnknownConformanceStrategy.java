/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.summer.dsl.model.types.util;

import org.summer.dsl.model.types.JvmTypeReference;
import org.summer.dsl.model.types.JvmUnknownTypeReference;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@Deprecated
class UnknownConformanceStrategy extends TypeConformanceStrategy<JvmUnknownTypeReference> {
	protected UnknownConformanceStrategy(TypeConformanceComputer conformanceComputer) {
		super(conformanceComputer);
	}

	@Override
	public TypeConformanceResult doVisitTypeReference(JvmUnknownTypeReference left, JvmTypeReference reference, TypeConformanceComputationArgument.Internal<JvmUnknownTypeReference> param) {
		if (reference instanceof JvmUnknownTypeReference) 
			return TypeConformanceResult.SUCCESS;
		return TypeConformanceResult.FAILED;
	}
}