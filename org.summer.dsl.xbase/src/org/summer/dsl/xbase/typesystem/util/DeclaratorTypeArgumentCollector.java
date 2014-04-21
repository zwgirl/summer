/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.summer.dsl.xbase.typesystem.util;

import java.util.List;
import java.util.Map;

import org.eclipse.jdt.annotation.NonNullByDefault;
import org.summer.dsl.model.types.JvmDeclaredType;
import org.summer.dsl.model.types.JvmType;
import org.summer.dsl.model.types.JvmTypeConstraint;
import org.summer.dsl.model.types.JvmTypeParameter;
import org.summer.dsl.model.types.JvmTypeParameterDeclarator;
import org.summer.dsl.model.types.JvmTypeReference;
import org.summer.dsl.model.types.JvmUpperBound;
import org.summer.dsl.xbase.typesystem.references.ArrayTypeReference;
import org.summer.dsl.xbase.typesystem.references.CompoundTypeReference;
import org.summer.dsl.xbase.typesystem.references.ITypeReferenceOwner;
import org.summer.dsl.xbase.typesystem.references.LightweightMergedBoundTypeArgument;
import org.summer.dsl.xbase.typesystem.references.LightweightTraversalData;
import org.summer.dsl.xbase.typesystem.references.LightweightTypeReference;
import org.summer.dsl.xbase.typesystem.references.OwnedConverter;
import org.summer.dsl.xbase.typesystem.references.ParameterizedTypeReference;
import org.summer.dsl.xbase.typesystem.references.TypeReferenceVisitorWithParameterAndResult;
import org.summer.dsl.xbase.typesystem.references.WildcardTypeReference;

import com.google.common.collect.Lists;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * TODO JavaDoc, toString
 */
@NonNullByDefault
public class DeclaratorTypeArgumentCollector extends TypeReferenceVisitorWithParameterAndResult<LightweightTraversalData, Boolean> {
	
	@Override
	protected Boolean doVisitTypeReference(LightweightTypeReference reference, LightweightTraversalData data) {
		return Boolean.FALSE;
	}

	@Override
	public Boolean doVisitCompoundTypeReference(CompoundTypeReference reference, LightweightTraversalData data) {
		// TODO error message, cannot extend compound reference - error handling does not belong here
		boolean result = true;
		for(LightweightTypeReference component: reference.getMultiTypeComponents()) {
			Boolean componentsDone = component.accept(this, data);
			result &= componentsDone != null && componentsDone.booleanValue();
		}
		return result;
	}

	@Override
	public Boolean doVisitArrayTypeReference(ArrayTypeReference reference, LightweightTraversalData data) {
		// TODO error message, cannot extend array type - error handling does not belong here
		return Boolean.FALSE;
	}
	
	@Override
	public Boolean doVisitWildcardTypeReference(WildcardTypeReference reference, LightweightTraversalData data) {
		// TODO error message, cannot extend wildcard type - error handling does not belong here
		return Boolean.FALSE;
	}

	@Override
	public Boolean doVisitParameterizedTypeReference(ParameterizedTypeReference reference, LightweightTraversalData data) {
		JvmType type = reference.getType();
		// TODO improve handling of redundant super types where a better path to the supertype exists
		/*
		 * e.g. MyList extends AbstractList implements List<String> {}
		 * the implements clause seems to be redundant but provides more reliable information
		 */
		if (!type.eIsProxy() && data.getVisited().add(type)) {
			return doVisitParameterizedTypeReference(reference, type, data);
		}
		return Boolean.FALSE;
	}
	
	protected Boolean addConstraintMapping(JvmTypeParameter typeParameter, ITypeReferenceOwner owner, LightweightTraversalData data) {
		List<JvmTypeConstraint> constraints = typeParameter.getConstraints();
		List<LightweightTypeReference> upperBounds = Lists.newArrayList();
		OwnedConverter converter = new OwnedConverter(owner);
		for(JvmTypeConstraint constraint: constraints) {
			if (constraint instanceof JvmUpperBound && constraint.getTypeReference() != null) {
				LightweightTypeReference upperBound = converter.toLightweightReference(constraint.getTypeReference());
				upperBound.accept(this, data);
				upperBounds.add(upperBound);
			}
		}
		if (upperBounds.size() > 1) {
			CompoundTypeReference result = new CompoundTypeReference(owner, false);
			for(LightweightTypeReference upperBound: upperBounds) {
				result.addComponent(upperBound);
			}
			data.getTypeParameterMapping().put(typeParameter, new LightweightMergedBoundTypeArgument(result, VarianceInfo.INVARIANT));
		} else if (upperBounds.size() == 1) {
			data.getTypeParameterMapping().put(typeParameter, new LightweightMergedBoundTypeArgument(upperBounds.get(0), VarianceInfo.INVARIANT));
		}
		return Boolean.FALSE;
	}

	protected Boolean doVisitParameterizedTypeReference(ParameterizedTypeReference reference, JvmType type,
			LightweightTraversalData data) {
		// TODO check constraints, add validation messages if necessary - error handling does not belong here
		if (reference.isRawType()) {
			if (type instanceof JvmTypeParameterDeclarator) {
				List<JvmTypeParameter> typeParameters = ((JvmTypeParameterDeclarator) type).getTypeParameters();
				for(JvmTypeParameter typeParameter: typeParameters) {
					addConstraintMapping(typeParameter, reference.getOwner(), data);
				}
			}
		} else if (type instanceof JvmTypeParameterDeclarator) {
			List<JvmTypeParameter> typeParameters = ((JvmTypeParameterDeclarator) type).getTypeParameters();
			List<LightweightTypeReference> typeArguments = reference.getTypeArguments();
			int size = Math.min(typeArguments.size(), typeParameters.size());
			for (int i = 0; i <  size; i++) {
				JvmTypeParameter param = typeParameters.get(i);
				LightweightTypeReference argument = typeArguments.get(i);
				if (param != null && argument != null) {
					data.getTypeParameterMapping().put(param, new LightweightMergedBoundTypeArgument(argument, VarianceInfo.INVARIANT));
				}
			}
		}
		if (type instanceof JvmDeclaredType) {
			ITypeReferenceOwner owner = reference.getOwner();
			OwnedConverter converter = new OwnedConverter(owner);
			List<JvmTypeReference> superTypes = ((JvmDeclaredType) type).getSuperTypes();
			for(JvmTypeReference superType: superTypes) {
				LightweightTypeReference lightweightSuperType = converter.toLightweightReference(superType);
				Boolean recursion = lightweightSuperType.accept(this, data);
				if (recursion != null && recursion.booleanValue()) {
					return Boolean.TRUE;
				}
			}
		} else if (type instanceof JvmTypeParameter) {
			ITypeReferenceOwner owner = reference.getOwner();
			OwnedConverter converter = new OwnedConverter(owner);
			List<JvmTypeConstraint> constraints = ((JvmTypeParameter) type).getConstraints();
			for(JvmTypeConstraint constraint: constraints) {
				JvmTypeReference constraintReference = constraint.getTypeReference();
				if (constraintReference != null) {
					LightweightTypeReference lightweightSuperType = converter.toLightweightReference(constraintReference);
					Boolean recursion = lightweightSuperType.accept(this, data);
					if (recursion != null && recursion.booleanValue()) {
						return Boolean.TRUE;
					}
				}
			}
		}
		return Boolean.FALSE;
	}
	
	public Map<JvmTypeParameter, LightweightMergedBoundTypeArgument> getTypeParameterMapping(LightweightTypeReference reference) {
		LightweightTraversalData data = new LightweightTraversalData();
		reference.accept(this, data);
		return data.getTypeParameterMapping();
	}
	
}