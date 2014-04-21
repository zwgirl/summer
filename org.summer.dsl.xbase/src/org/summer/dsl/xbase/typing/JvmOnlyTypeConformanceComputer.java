/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.summer.dsl.xbase.typing;

import java.util.EnumSet;

import org.summer.dsl.model.types.JvmTypeReference;
import org.summer.dsl.model.types.util.TypeConformanceComputationArgument;
import org.summer.dsl.model.types.util.TypeConformanceComputer;
import org.summer.dsl.model.types.util.TypeConformanceResult;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
@Deprecated
public class JvmOnlyTypeConformanceComputer extends TypeConformanceComputer {
	
	@Override
	public TypeConformanceResult isConformant(JvmTypeReference left, JvmTypeReference right,
			TypeConformanceComputationArgument flags) {
		TypeConformanceResult result = super.isConformant(left, right, flags);
		if (result.isConformant()) {
			EnumSet<TypeConformanceResult.Kind> kinds = result.getKinds();
			if (kinds.contains(TypeConformanceResult.Kind.DEMAND_CONVERSION) ||
					kinds.contains(TypeConformanceResult.Kind.SYNONYM)) {
				return TypeConformanceResult.FAILED;
			}
		}
		return result;
	}
	
}
