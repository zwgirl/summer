/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.summer.dsl.xbase.typesystem.util;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.jdt.annotation.NonNullByDefault;
import org.summer.dsl.model.types.JvmTypeConstraint;
import org.summer.dsl.model.types.JvmTypeParameter;
import org.summer.dsl.model.types.JvmTypeReference;
import org.summer.dsl.xbase.typesystem.references.CompoundTypeReference;
import org.summer.dsl.xbase.typesystem.references.ITypeReferenceOwner;
import org.summer.dsl.xbase.typesystem.references.LightweightMergedBoundTypeArgument;
import org.summer.dsl.xbase.typesystem.references.LightweightTypeReference;
import org.summer.dsl.xbase.typesystem.references.OwnedConverter;
import org.summer.dsl.xbase.typesystem.references.ParameterizedTypeReference;
import org.summer.dsl.xbase.typesystem.references.UnboundTypeReference;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * TODO JavaDoc, toString - focus on differences to ActualTypeArgumentCollector and UnboundTypeParameterAwareTypeArgumentCollector
 */
@NonNullByDefault
public class DeferredTypeParameterHintCollector extends AbstractTypeReferencePairWalker {
	
	protected class UnboundTypeParameterHintCollector extends UnboundTypeReferenceTraverser {
		@Override
		protected void doVisitTypeReference(LightweightTypeReference reference, UnboundTypeReference declaration) {
			if (declaration.internalIsResolved() || getOwner().isResolved(declaration.getHandle())) {
				declaration.tryResolve();
				outerVisit(declaration, reference, declaration, getExpectedVariance(), getActualVariance());
			} else if (reference.isValidHint()) {
				addHint(declaration, reference);
			}
		}

		@Override
		protected void doVisitCompoundTypeReference(CompoundTypeReference reference, UnboundTypeReference param) {
			doVisitTypeReference(reference, param);
		}
	}

	public DeferredTypeParameterHintCollector(ITypeReferenceOwner owner) {
		super(owner);
	}
	
	@Override
	protected TypeParameterSubstitutor<?> createTypeParameterSubstitutor(Map<JvmTypeParameter, LightweightMergedBoundTypeArgument> mapping) {
		return new UnboundTypeParameterPreservingSubstitutor(mapping, getOwner());
	}

	protected LightweightTypeReference copy(UnboundTypeReference reference) {
		return reference.copyInto(getOwner());
	}
	
	@Override
	protected UnboundTypeReferenceTraverser createUnboundTypeReferenceTraverser() {
		return new UnboundTypeParameterHintCollector();
	}
	
	@Override
	protected CompoundTypeReferenceTraverser createCompoundTypeReferenceTraverser() {
		return new CompoundTypeReferenceTraverser() {
			@Override
			protected void doVisitUnboundTypeReference(UnboundTypeReference reference, CompoundTypeReference declaration) {
				if (declaration.isSynonym()) {
					super.doVisitUnboundTypeReference(reference, declaration);
				} else {
					addHint(reference, declaration);
				}
			}
		};
	}

	@Override
	protected ParameterizedTypeReferenceTraverser createParameterizedTypeReferenceTraverser() {
		return new ParameterizedTypeReferenceTraverser() {
			@Override
			public void doVisitUnboundTypeReference(UnboundTypeReference reference,
					ParameterizedTypeReference declaration) {
				addHint(reference, declaration);
			}
			
			@Override
			protected boolean shouldProcessInContextOf(JvmTypeParameter declaredTypeParameter, Set<JvmTypeParameter> boundParameters,
					Set<JvmTypeParameter> visited) {
				if (boundParameters.contains(declaredTypeParameter) && !visited.add(declaredTypeParameter)) {
					return false;
				}
				return true;
			}
		};
	}
	
	@Override
	protected JvmTypeParameter findMappedParameter(JvmTypeParameter parameter,
			Map<JvmTypeParameter, LightweightMergedBoundTypeArgument> mapping, Collection<JvmTypeParameter> visited) {
		return UnboundTypeReferences.findMappedParameter(parameter, mapping, visited);
	}

	protected void addHint(UnboundTypeReference typeParameter, LightweightTypeReference reference) {
		LightweightTypeReference wrapped = getStricterConstraint(typeParameter, reference.getWrapperTypeIfPrimitive());
		typeParameter.acceptHint(wrapped, BoundTypeArgumentSource.INFERRED_LATER, getOrigin(), getExpectedVariance(), getActualVariance());
	}
	

	protected LightweightTypeReference getStricterConstraint(UnboundTypeReference typeParameter, LightweightTypeReference hint) {
		JvmTypeParameter parameter = typeParameter.getTypeParameter();
		List<JvmTypeConstraint> constraints = parameter.getConstraints();
		for(JvmTypeConstraint constraint: constraints) {
			JvmTypeReference constraintReference = constraint.getTypeReference();
			if (constraintReference != null) {
				LightweightTypeReference lightweightReference = new OwnedConverter(hint.getOwner()).toLightweightReference(constraintReference);
				if (hint.isAssignableFrom(lightweightReference)) {
					hint = lightweightReference;
				}
			}
		}
		return hint;
	}

}