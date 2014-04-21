/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.summer.dsl.xbase.typing;

import org.summer.dsl.model.types.JvmGenericType;
import org.summer.dsl.model.types.JvmTypeReference;
import org.summer.dsl.model.types.util.TypeConformanceComputationArgument;
import org.summer.dsl.model.types.util.TypeConformanceComputer;
import org.summer.dsl.model.types.util.TypeConformanceResult;
import org.summer.dsl.xbase.lib.Functions;
import org.summer.dsl.xbase.lib.Procedures;
import org.summer.dsl.model.xtype.XFunctionTypeRef;

import com.google.inject.Inject;
import com.google.inject.Singleton;

/**
 * @author Jan Koehnlein - Initial contribution and API
 * @author Sven Efftinge
 */
@Deprecated
@Singleton
public class XbaseTypeConformanceComputer extends TypeConformanceComputer {
	
	@Inject 
	private Closures closures;
	
	@Inject
	private SynonymTypesProvider synonymTypeProvider;
	
	@Inject
	private XbaseTypeArgumentContextProvider typeArgumentContextProvider;

	@Override
	public TypeConformanceResult isConformant(JvmTypeReference left, JvmTypeReference right,
			TypeConformanceComputationArgument flags) {
		TypeConformanceResult result = super.isConformant(left, right, flags);
		if (result.isConformant()) {
			return result;
		}
		if (!flags.isAsTypeArgument() && flags.isAllowPrimitiveConversion() 
				&& (isXbaseFunctionType(left)|| isXbaseFunctionType(right))) {
			// entry call - try to convert function types
			JvmTypeReference leftFunction = closures.getCompatibleFunctionType(left, false, flags.isRawType());
			JvmTypeReference rightFunction = closures.getCompatibleFunctionType(right, false, flags.isRawType());
			if (leftFunction != null && rightFunction != null && (left != leftFunction || right != rightFunction)) {
				result = super.isConformant(leftFunction, rightFunction, flags);
				if (result.isConformant()) {
					result = TypeConformanceResult.merge(result, new TypeConformanceResult(TypeConformanceResult.Kind.DEMAND_CONVERSION));
					return result;
				}
			}
		}
		// TODO remove this code here since the type references should be wrapped as soon
		// as they are created
		Iterable<JvmTypeReference> synonymTypes = synonymTypeProvider.getSynonymTypes(right, true);
		for (JvmTypeReference synonymType : synonymTypes) {
			result = super.isConformant(left, synonymType, flags);
			if (result.isConformant())
				return result;
		}
		return result;
	}

	protected boolean isXbaseFunctionType(JvmTypeReference ref) {
		if (ref instanceof XFunctionTypeRef) {
			return true;
		} 
		if (ref != null && !ref.eIsProxy()) {
			if (ref.getType() instanceof JvmGenericType) {
				JvmGenericType type = (JvmGenericType) ref.getType();
				if (type.getDeclaringType() instanceof JvmGenericType) {
					final String qualifiedName = type.getDeclaringType().getQualifiedName();
					return qualifiedName.equals(Functions.class.getCanonicalName()) || qualifiedName.equals(Procedures.class.getCanonicalName());
				}
			}
		}
		return false;
	}
	
	@Override
	protected XbaseTypeArgumentContextProvider getTypeArgumentContextProvider() {
		return typeArgumentContextProvider;
	}
	
}
