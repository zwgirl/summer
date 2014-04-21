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
import org.eclipse.jdt.annotation.Nullable;
import org.summer.dsl.model.types.JvmType;
import org.summer.dsl.model.types.JvmTypeParameter;
import org.summer.dsl.model.types.JvmTypeParameterDeclarator;
import org.eclipse.xtext.util.Strings;
import org.summer.dsl.xbase.typesystem.references.AnyTypeReference;
import org.summer.dsl.xbase.typesystem.references.ArrayTypeReference;
import org.summer.dsl.xbase.typesystem.references.CompoundTypeReference;
import org.summer.dsl.xbase.typesystem.references.ITypeReferenceOwner;
import org.summer.dsl.xbase.typesystem.references.LightweightMergedBoundTypeArgument;
import org.summer.dsl.xbase.typesystem.references.LightweightTypeReference;
import org.summer.dsl.xbase.typesystem.references.ParameterizedTypeReference;
import org.summer.dsl.xbase.typesystem.references.TypeReferenceVisitorWithParameter;
import org.summer.dsl.xbase.typesystem.references.UnboundTypeReference;
import org.summer.dsl.xbase.typesystem.references.UnknownTypeReference;
import org.summer.dsl.xbase.typesystem.references.WildcardTypeReference;

import com.google.common.collect.Sets;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * TODO JavaDoc, toString implementation
 */
@NonNullByDefault
public abstract class AbstractTypeReferencePairWalker extends TypeReferenceVisitorWithParameter<LightweightTypeReference> {

	protected class ArrayTypeReferenceTraverser extends	TypeReferenceVisitorWithParameter<ArrayTypeReference> {
		@Override
		protected void doVisitArrayTypeReference(ArrayTypeReference reference, ArrayTypeReference declaration) {
			outerVisit(declaration.getComponentType(), reference.getComponentType());
		}
		
		@Override
		protected void doVisitParameterizedTypeReference(ParameterizedTypeReference reference, ArrayTypeReference declaration) {
			JvmType type = reference.getType();
			if (type instanceof JvmTypeParameter) {
				if (shouldProcess((JvmTypeParameter) type)) {
					JvmTypeParameter typeParameter = (JvmTypeParameter) type;
					processTypeParameter(typeParameter, declaration);
				}
			} else {
				ParameterizedTypeReference declarationAsList = declaration.tryConvertToListType();
				outerVisit(declarationAsList, reference);
			}
		}
		
		@Override
		protected void doVisitAnyTypeReference(AnyTypeReference reference, ArrayTypeReference param) {
			// nothing to do
		}
		
		@Override
		protected void doVisitUnknownTypeReference(UnknownTypeReference reference, ArrayTypeReference param) {
			// nothing to do
		}
		
		@Override
		protected void doVisitUnboundTypeReference(UnboundTypeReference reference, ArrayTypeReference declaration) {
			if (shouldProcess(reference.getTypeParameter())) {
				processTypeParameter(reference.getTypeParameter(), declaration);
			}
		}
	}
	
	protected class CompoundTypeReferenceTraverser extends TypeReferenceVisitorWithParameter<CompoundTypeReference> {
		@Override
		protected void doVisitTypeReference(LightweightTypeReference reference, CompoundTypeReference declaration) {
			List<LightweightTypeReference> components = declaration.getMultiTypeComponents();
			if (!components.isEmpty()) {
				for (LightweightTypeReference component: components) {
					outerVisit(component, reference);
				}
			}
		}
	}

	protected class WildcardTypeReferenceTraverser extends
			TypeReferenceVisitorWithParameter<WildcardTypeReference> {
		
		@Override
		protected void doVisitWildcardTypeReference(WildcardTypeReference reference, WildcardTypeReference declaration) {
			LightweightTypeReference declaredLowerBound = declaration.getLowerBound();
			if (declaredLowerBound != null) {
				LightweightTypeReference actualLowerBound = reference.getLowerBound();
				if (actualLowerBound != null) {
					outerVisit(declaredLowerBound, actualLowerBound, declaration, VarianceInfo.IN, VarianceInfo.IN);
				} else {
					for (LightweightTypeReference actualUpperBound : reference.getUpperBounds()) {
						outerVisit(declaredLowerBound, actualUpperBound, declaration, VarianceInfo.IN, VarianceInfo.OUT);
					}
				}
			} else {
				LightweightTypeReference actualLowerBound = reference.getLowerBound();
				for (LightweightTypeReference declaredUpperBound : declaration.getUpperBounds()) {
					for (LightweightTypeReference actualUpperBound : reference.getUpperBounds()) {
						outerVisit(declaredUpperBound, actualUpperBound, declaration, VarianceInfo.OUT, VarianceInfo.OUT);
					}
					if (actualLowerBound != null) {
						outerVisit(declaredUpperBound, actualLowerBound, declaration, VarianceInfo.OUT, VarianceInfo.IN);
					}
				}
			}
		}
		
		@Override
		protected void doVisitCompoundTypeReference(CompoundTypeReference reference, WildcardTypeReference param) {
			if (!reference.isSynonym()) {
				doVisitTypeReference(reference, param);
			} else {
				super.doVisitCompoundTypeReference(reference, param);
			}
		}
		
		@Override
		public void doVisitTypeReference(LightweightTypeReference reference, WildcardTypeReference declaration) {
			LightweightTypeReference declaredLowerBound = declaration.getLowerBound();
			if (declaredLowerBound != null) {
				outerVisit(declaredLowerBound, reference, declaration, VarianceInfo.IN, VarianceInfo.INVARIANT);
			} else {
				for (LightweightTypeReference declaredUpperBound : declaration.getUpperBounds()) {
					outerVisit(declaredUpperBound, reference, declaration, VarianceInfo.OUT, VarianceInfo.INVARIANT);
				}
			}
		}
	}
	
	protected class UnboundTypeReferenceTraverser extends TypeReferenceVisitorWithParameter<UnboundTypeReference> {
		
		@Override
		protected void doVisitTypeReference(LightweightTypeReference reference, UnboundTypeReference declaration) {
			if (declaration.internalIsResolved() || getOwner().isResolved(declaration.getHandle())) {
				declaration.tryResolve();
				outerVisit(declaration, reference, declaration, getExpectedVariance(), getActualVariance());
			} else {
				processTypeParameter(declaration.getTypeParameter(), reference);
			}
		}
		
		@Override
		protected void doVisitWildcardTypeReference(WildcardTypeReference reference, UnboundTypeReference declaration) {
			LightweightTypeReference lowerBound = reference.getLowerBound();
			if (lowerBound != null) {
				outerVisit(declaration, lowerBound, declaration, getExpectedVariance(), VarianceInfo.IN);
			} else {
				for (LightweightTypeReference upperBound : reference.getUpperBounds()) {
					outerVisit(declaration, upperBound, declaration, getExpectedVariance(), VarianceInfo.OUT);
				}
			}
		}
		
		@Override
		protected void doVisitUnboundTypeReference(UnboundTypeReference reference, UnboundTypeReference param) {
			if (param.equalHandles(reference))
				return;
			super.doVisitUnboundTypeReference(reference, param);
		}
		
	}
	
	protected class ParameterizedTypeReferenceTraverser extends
			TypeReferenceVisitorWithParameter<ParameterizedTypeReference> {
		@Override
		protected void doVisitParameterizedTypeReference(ParameterizedTypeReference reference, ParameterizedTypeReference declaration) {
			JvmType type = declaration.getType();
			if (type instanceof JvmTypeParameter) {
				if (type != reference.getType() && shouldProcess((JvmTypeParameter) type)) {
					JvmTypeParameter typeParameter = (JvmTypeParameter) type;
					processTypeParameter(typeParameter, reference);
				}
			} else if (type instanceof JvmTypeParameterDeclarator
					&& !((JvmTypeParameterDeclarator) type).getTypeParameters().isEmpty()
					&& !declaration.getTypeArguments().isEmpty()) {
				doVisitMatchingTypeParameters(reference, declaration);
			}
		}

		@Override
		protected void doVisitAnyTypeReference(AnyTypeReference reference, ParameterizedTypeReference param) {
			// nothing to do
		}
		
		@Override
		protected void doVisitUnknownTypeReference(UnknownTypeReference reference, ParameterizedTypeReference param) {
			// nothing to do
		}

		protected void doVisitMatchingTypeParameters(ParameterizedTypeReference reference,
				ParameterizedTypeReference declaration) {
			Map<JvmTypeParameter, LightweightMergedBoundTypeArgument> actualMapping = getTypeParameterMapping(reference);
			TypeParameterSubstitutor<?> actualSubstitutor = createTypeParameterSubstitutor(actualMapping);
			Map<JvmTypeParameter, LightweightMergedBoundTypeArgument> declaredMapping = getTypeParameterMapping(declaration);
			TypeParameterSubstitutor<?> declaredSubstitutor = createTypeParameterSubstitutor(declaredMapping);
			Set<JvmTypeParameter> actualBoundParameters = actualMapping.keySet();
			Set<JvmTypeParameter> visited = Sets.newHashSet();
			outer: for (JvmTypeParameter actualBoundParameter : actualBoundParameters) {
				if (visited.add(actualBoundParameter)) {
					LightweightMergedBoundTypeArgument declaredBoundArgument = declaredMapping.get(actualBoundParameter);
					while(declaredBoundArgument == null && actualBoundParameter != null) {
						actualBoundParameter = findMappedParameter(actualBoundParameter, actualMapping, visited);
						if (actualBoundParameter == null)
							continue outer;
						declaredBoundArgument = declaredMapping.get(actualBoundParameter);
					}
					if (declaredBoundArgument != null) {
						LightweightTypeReference declaredTypeReference = declaredBoundArgument.getTypeReference();
						JvmType declaredType = declaredTypeReference.getType();
						if (declaredType instanceof JvmTypeParameter) {
							JvmTypeParameter declaredTypeParameter = (JvmTypeParameter) declaredType;
							if (!shouldProcessInContextOf(declaredTypeParameter, actualBoundParameters, visited))
								continue;
							declaredTypeReference = declaredSubstitutor.substitute(declaredTypeReference);
						}
						LightweightTypeReference actual = actualSubstitutor.substitute(actualMapping.get(actualBoundParameter).getTypeReference());
						if (!actual.isResolved() || !declaredTypeReference.isResolved() || !Strings.equal(actual.getIdentifier(), declaredTypeReference.getIdentifier())) {
							if (reference.getType() != actual.getType() 
									|| declaredTypeReference.getType() != declaration.getType() 
									|| !reference.getIdentifier().equals(actual.getIdentifier())
									|| !declaredTypeReference.getIdentifier().equals(declaration.getIdentifier())) {
								outerVisit(declaredTypeReference, actual, declaration, VarianceInfo.INVARIANT, VarianceInfo.INVARIANT);
							}
						}
					}
				}
			}
		}

		public Map<JvmTypeParameter, LightweightMergedBoundTypeArgument> getTypeParameterMapping(
				ParameterizedTypeReference reference) {
			DeclaratorTypeArgumentCollector collector = new DeclaratorTypeArgumentCollector();
			return collector.getTypeParameterMapping(reference);
		}
		
		/**
		 * @param typeParameter the considered type parameter.
		 * @param boundParameters all bound type parameters.
		 * @param visited the parameters that were already visited.
		 */
		protected boolean shouldProcessInContextOf(JvmTypeParameter typeParameter, Set<JvmTypeParameter> boundParameters, Set<JvmTypeParameter> visited) {
			return true;
		}

		@Override
		protected void doVisitArrayTypeReference(ArrayTypeReference reference, ParameterizedTypeReference declaration) {
			JvmType type = declaration.getType();
			if (type instanceof JvmTypeParameter) {
				if (shouldProcess((JvmTypeParameter) type)) {
					JvmTypeParameter typeParameter = (JvmTypeParameter) type;
					processTypeParameter(typeParameter, reference);
				}
			}
		}

		@Override
		protected void doVisitWildcardTypeReference(WildcardTypeReference reference, ParameterizedTypeReference declaration) {
			LightweightTypeReference lowerBound = reference.getLowerBound();
			if (lowerBound != null) {
				outerVisit(declaration, lowerBound, declaration, expectedVariance, VarianceInfo.IN);
			} else {
				for(LightweightTypeReference upperBound: reference.getUpperBounds()) {
					outerVisit(declaration, upperBound, declaration, expectedVariance, VarianceInfo.OUT);
				}
			}
		}

	}
	
	private final ITypeReferenceOwner owner;
	
	private final ParameterizedTypeReferenceTraverser parameterizedTypeReferenceTraverser;
	private final WildcardTypeReferenceTraverser wildcardTypeReferenceTraverser;
	private final ArrayTypeReferenceTraverser arrayTypeReferenceTraverser;
	private final CompoundTypeReferenceTraverser compoundTypeReferenceTraverser;
	private final UnboundTypeReferenceTraverser unboundTypeReferenceTraverser;
	
	private VarianceInfo expectedVariance;

	private VarianceInfo actualVariance;

	private Object origin;
	
	private final Set<String> recursionGuard;
	
	protected AbstractTypeReferencePairWalker(ITypeReferenceOwner owner) {
		this.owner = owner;
		this.recursionGuard = Sets.newHashSetWithExpectedSize(3);
		parameterizedTypeReferenceTraverser = createParameterizedTypeReferenceTraverser();
		wildcardTypeReferenceTraverser = createWildcardTypeReferenceTraverser();
		arrayTypeReferenceTraverser = createArrayTypeReferenceTraverser();
		compoundTypeReferenceTraverser = createCompoundTypeReferenceTraverser();
		unboundTypeReferenceTraverser = createUnboundTypeReferenceTraverser();
	}
	
	/**
	 * @param typeParameter the to-be-processed type parameter.
	 * @param reference the reference that is bound to the given type parameter.
	 */
	protected void processTypeParameter(JvmTypeParameter typeParameter, LightweightTypeReference reference) {
	}
	
	/**
	 * Allows to veto the processing of a given type parameter.
	 * @param typeParameter the to-be-processed type parameter.
	 * @return always <code>true</code>.
	 */
	protected boolean shouldProcess(JvmTypeParameter typeParameter) {
		return true;
	}
	
	protected UnboundTypeReferenceTraverser createUnboundTypeReferenceTraverser() {
		return new UnboundTypeReferenceTraverser();
	}

	protected ArrayTypeReferenceTraverser createArrayTypeReferenceTraverser() {
		return new ArrayTypeReferenceTraverser();
	}
	
	protected CompoundTypeReferenceTraverser createCompoundTypeReferenceTraverser() {
		return new CompoundTypeReferenceTraverser();
	}

	protected WildcardTypeReferenceTraverser createWildcardTypeReferenceTraverser() {
		return new WildcardTypeReferenceTraverser();
	}

	protected ParameterizedTypeReferenceTraverser createParameterizedTypeReferenceTraverser() {
		return new ParameterizedTypeReferenceTraverser();
	}
	
	@Override
	protected void doVisitParameterizedTypeReference(ParameterizedTypeReference reference,
			LightweightTypeReference param) {
		param.accept(parameterizedTypeReferenceTraverser, reference);
	}
	
	@Override
	protected void doVisitWildcardTypeReference(WildcardTypeReference declaredReference, LightweightTypeReference param) {
		param.accept(wildcardTypeReferenceTraverser, declaredReference);
	}

	@Override
	protected void doVisitArrayTypeReference(ArrayTypeReference declaredReference,
			LightweightTypeReference param) {
		param.accept(arrayTypeReferenceTraverser, declaredReference);
	}
	
	@Override
	protected void doVisitCompoundTypeReference(CompoundTypeReference declaredReference, LightweightTypeReference param) {
		param.accept(compoundTypeReferenceTraverser, declaredReference);
	}
	
	@Override
	protected void doVisitUnboundTypeReference(UnboundTypeReference reference, LightweightTypeReference param) {
		param.accept(unboundTypeReferenceTraverser, reference);
	}
	
	@Override
	protected void doVisitAnyTypeReference(AnyTypeReference reference, LightweightTypeReference param) {
		// nothing to do
	}
	
	@Override
	protected void doVisitUnknownTypeReference(UnknownTypeReference reference, LightweightTypeReference param) {
		// nothing to do
	}

	protected void outerVisit(LightweightTypeReference declaredType, LightweightTypeReference actualType, Object origin, VarianceInfo expectedVariance, VarianceInfo actualVariance) {
		VarianceInfo oldExpectedVariance = this.expectedVariance;
		VarianceInfo oldActualVariance = this.actualVariance;
		Object oldOrigin = this.origin;
		try {
			this.expectedVariance = expectedVariance;
			this.actualVariance = actualVariance;
			this.origin = origin;
			outerVisit(declaredType, actualType);
		} finally {
			this.expectedVariance = oldExpectedVariance;
			this.actualVariance = oldActualVariance;
			this.origin = oldOrigin;
		}
	}
	
	protected void outerVisit(LightweightTypeReference declaredType, LightweightTypeReference actualType) {
		if (declaredType == actualType)
			return;
		String declaredKey = declaredType.getUniqueIdentifier();
		String actualKey = actualType.getUniqueIdentifier();
		if (!declaredKey.equals(actualKey)) {
			final String key = declaredKey + "//" + actualKey;
			if (recursionGuard.add(key)) {
				try {
					declaredType.accept(this, actualType);
				} finally {
					recursionGuard.remove(key);
				}
			}
		}
	}

	public void processPairedReferences(LightweightTypeReference declaredType, LightweightTypeReference actualType) {
		outerVisit(declaredType, actualType, declaredType, VarianceInfo.OUT, VarianceInfo.OUT);
	}
	
	protected VarianceInfo getActualVariance() {
		return actualVariance;
	}
	protected VarianceInfo getExpectedVariance() {
		return expectedVariance;
	}
	
	protected Object getOrigin() {
		return origin;
	}
	
	protected ITypeReferenceOwner getOwner() {
		return owner;
	}

	protected TypeParameterSubstitutor<?> createTypeParameterSubstitutor(Map<JvmTypeParameter, LightweightMergedBoundTypeArgument> mapping) {
		return new StandardTypeParameterSubstitutor(mapping, owner);
	}
	
	@Nullable
	protected JvmTypeParameter findMappedParameter(JvmTypeParameter parameter,
			Map<JvmTypeParameter, LightweightMergedBoundTypeArgument> mapping, Collection<JvmTypeParameter> visited) {
		for(Map.Entry<JvmTypeParameter, LightweightMergedBoundTypeArgument> entry: mapping.entrySet()) {
			LightweightMergedBoundTypeArgument reference = entry.getValue();
			JvmType type = reference.getTypeReference().getType();
			if (parameter == type) {
				if (visited.add(entry.getKey()))
					return entry.getKey();
				return null;
			}
		}
		return null;
	}
}