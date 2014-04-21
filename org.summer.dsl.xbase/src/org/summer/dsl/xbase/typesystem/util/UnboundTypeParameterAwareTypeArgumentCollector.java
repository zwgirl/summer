/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.summer.dsl.xbase.typesystem.util;

import java.util.Collection;
import java.util.Map;

import org.eclipse.jdt.annotation.NonNullByDefault;
import org.summer.dsl.model.types.JvmType;
import org.summer.dsl.model.types.JvmTypeParameter;
import org.summer.dsl.xbase.typesystem.references.CompoundTypeReference;
import org.summer.dsl.xbase.typesystem.references.ITypeReferenceOwner;
import org.summer.dsl.xbase.typesystem.references.LightweightMergedBoundTypeArgument;
import org.summer.dsl.xbase.typesystem.references.LightweightTypeReference;
import org.summer.dsl.xbase.typesystem.references.ParameterizedTypeReference;
import org.summer.dsl.xbase.typesystem.references.UnboundTypeReference;

/**
 * @author Sebastian Zarnekow - Initial contribution and API 
 * TODO JavaDoc, toString, inline into super type if only subtype and super type not used besides in tests
 */
@NonNullByDefault
public class UnboundTypeParameterAwareTypeArgumentCollector extends ActualTypeArgumentCollector {

	protected class UnboundTypeParameterAwareUnboundTypeReferenceTraverser extends UnboundTypeReferenceTraverser {
		@Override
		protected void doVisitTypeReference(LightweightTypeReference reference, UnboundTypeReference declaration) {
			if (declaration.internalIsResolved() || getOwner().isResolved(declaration.getHandle())) {
				declaration.tryResolve();
				outerVisit(declaration, reference, declaration, getExpectedVariance(), getActualVariance());
			} else {
				acceptHint(declaration, reference);
			}
			
		}
		@Override
		protected void doVisitCompoundTypeReference(CompoundTypeReference reference, UnboundTypeReference param) {
			doVisitTypeReference(reference, param);
		}
	}

	protected class UnboundTypeParameterAwareParameterizedTypeReferenceTraverser extends
			ActualParameterizedTypeReferenceTraverser {
		@Override
		public void doVisitUnboundTypeReference(UnboundTypeReference reference,
				ParameterizedTypeReference declaration) {
			JvmType type = declaration.getType();
			if (type instanceof JvmTypeParameter) {
				JvmTypeParameter unboundTypeParameter = (JvmTypeParameter) type;
				if (unboundTypeParameter != reference.getTypeParameter() && shouldProcess(unboundTypeParameter)) {
					processTypeParameter(unboundTypeParameter, reference);
				} else {
					// register synonym type param resolution et al for the actual type in the given UnboundTypeParameter
				}
			} else {
				acceptHint(reference, declaration);
			}
		}

		@Override
		protected void doVisitCompoundTypeReference(CompoundTypeReference reference,
				ParameterizedTypeReference declaration) {
			JvmType type = declaration.getType();
			if (type instanceof JvmTypeParameter) {
				JvmTypeParameter unboundTypeParameter = (JvmTypeParameter) type;
				if (shouldProcess(unboundTypeParameter)) {
					processTypeParameter(unboundTypeParameter, reference);
				}
			} else {
				super.doVisitCompoundTypeReference(reference, declaration);
			}
		}
	}

	public UnboundTypeParameterAwareTypeArgumentCollector(Collection<JvmTypeParameter> parametersToBeMapped,
			BoundTypeArgumentSource defaultSource, ITypeReferenceOwner owner) {
		super(parametersToBeMapped, defaultSource, owner);
	}

	@Override
	protected TypeParameterSubstitutor<?> createTypeParameterSubstitutor(Map<JvmTypeParameter, LightweightMergedBoundTypeArgument> mapping) {
		return new UnboundTypeParameterPreservingSubstitutor(mapping, getOwner());
	}

	@Override
	protected UnboundTypeReferenceTraverser createUnboundTypeReferenceTraverser() {
		return new UnboundTypeParameterAwareUnboundTypeReferenceTraverser();
	}
	
	protected void acceptHint(UnboundTypeReference reference, LightweightTypeReference param) {
		reference.acceptHint(boundByDefaultSource(param));
	}

	@Override
	protected ParameterizedTypeReferenceTraverser createParameterizedTypeReferenceTraverser() {
		return new UnboundTypeParameterAwareParameterizedTypeReferenceTraverser();
	}

	@Override
	protected JvmTypeParameter findMappedParameter(JvmTypeParameter parameter,
			Map<JvmTypeParameter, LightweightMergedBoundTypeArgument> mapping, Collection<JvmTypeParameter> visited) {
		return UnboundTypeReferences.findMappedParameter(parameter, mapping, visited);
	}
	
}