/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.summer.dsl.xbase.typesystem.util;

import org.eclipse.jdt.annotation.NonNullByDefault;
import org.summer.dsl.model.types.JvmType;
import org.summer.dsl.model.types.JvmTypeParameter;
import org.summer.dsl.xbase.typesystem.references.ITypeReferenceOwner;
import org.summer.dsl.xbase.typesystem.references.LightweightTraversalData;
import org.summer.dsl.xbase.typesystem.references.ParameterizedTypeReference;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * TODO JavaDoc, toString
 */
@NonNullByDefault
public class ConstraintAwareTypeArgumentCollector extends DeclaratorTypeArgumentCollector {

	private ITypeReferenceOwner owner;

	public ConstraintAwareTypeArgumentCollector(ITypeReferenceOwner owner) {
		this.owner = owner;
	}
	
	@Override
	public Boolean doVisitParameterizedTypeReference(ParameterizedTypeReference reference, LightweightTraversalData data) {
		JvmType type = reference.getType();
		if (!type.eIsProxy() && data.getVisited().add(type)) {
			if (type instanceof JvmTypeParameter) {
				JvmTypeParameter typeParameter = (JvmTypeParameter) type;
				if (!data.getTypeParameterMapping().containsKey(type)) {
					return addConstraintMapping(typeParameter, owner, data);
				}
			} else {
				return doVisitParameterizedTypeReference(reference, type, data);
			}
		}
		return Boolean.FALSE;
	}

}
