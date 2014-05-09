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

import org.eclipse.jdt.annotation.NonNullByDefault;
import org.summer.dsl.model.types.JvmType;
import org.summer.dsl.model.types.JvmTypeParameter;
import org.summer.dsl.xbase.scoping.batch.Buildin;
import org.summer.dsl.xbase.typesystem.references.ArrayTypeReference;
import org.summer.dsl.xbase.typesystem.references.FunctionTypeReference;
import org.summer.dsl.xbase.typesystem.references.ITypeReferenceOwner;
import org.summer.dsl.xbase.typesystem.references.LightweightBoundTypeArgument;
import org.summer.dsl.xbase.typesystem.references.LightweightMergedBoundTypeArgument;
import org.summer.dsl.xbase.typesystem.references.LightweightTypeReference;
import org.summer.dsl.xbase.typesystem.references.ParameterizedTypeReference;
import org.summer.dsl.xbase.typesystem.references.UnboundTypeReference;
import org.summer.dsl.xbase.typesystem.references.WildcardTypeReference;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@NonNullByDefault
public class TypeArgumentFromComputedTypeCollector extends UnboundTypeParameterAwareTypeArgumentCollector {

	public static void resolveAgainstActualType(final LightweightTypeReference declaredType, LightweightTypeReference actualType,
			Collection<JvmTypeParameter> typeParameters, Map<JvmTypeParameter, LightweightMergedBoundTypeArgument> typeParameterMapping,
			BoundTypeArgumentSource source,
			ITypeReferenceOwner owner) {
		if (declaredType.isRawType() || actualType.isRawType())
			return;
		TypeArgumentFromComputedTypeCollector implementation = new TypeArgumentFromComputedTypeCollector(typeParameters, source, owner);
		implementation.populateTypeParameterMapping(declaredType, actualType);
		Map<JvmTypeParameter, List<LightweightBoundTypeArgument>> parameterMapping = implementation.rawGetTypeParameterMapping();
		for(Map.Entry<JvmTypeParameter, List<LightweightBoundTypeArgument>> entry: parameterMapping.entrySet()) {
			LightweightMergedBoundTypeArgument boundTypeArgument = typeParameterMapping.get(entry.getKey());
			if (boundTypeArgument != null ) {
				List<LightweightBoundTypeArgument> computedBoundTypeArguments = entry.getValue();
				for(LightweightBoundTypeArgument computedBoundTypeArgument: computedBoundTypeArguments) { 
					if (computedBoundTypeArgument.getSource() == BoundTypeArgumentSource.RESOLVED) {
						VarianceInfo varianceInfo = computedBoundTypeArgument.getDeclaredVariance().mergeDeclaredWithActual(computedBoundTypeArgument.getActualVariance());
						typeParameterMapping.put(entry.getKey(), new LightweightMergedBoundTypeArgument(computedBoundTypeArgument.getTypeReference(), varianceInfo));
					} else if (boundTypeArgument.getTypeReference() instanceof UnboundTypeReference) {
						UnboundTypeReference typeReference = (UnboundTypeReference) boundTypeArgument.getTypeReference();
						if (!typeReference.internalIsResolved()) {
							if (!(computedBoundTypeArgument.getTypeReference() instanceof UnboundTypeReference) || 
									((UnboundTypeReference) computedBoundTypeArgument.getTypeReference()).getHandle() != typeReference.getHandle())
								typeReference.acceptHint(computedBoundTypeArgument);
						}
					}
				}
			}
		}
	}
	
	public TypeArgumentFromComputedTypeCollector(Collection<JvmTypeParameter> parametersToBeMapped,
			BoundTypeArgumentSource defaultSource, ITypeReferenceOwner owner) {
		super(parametersToBeMapped, defaultSource, owner);
	}

	@Override
	protected void acceptHint(UnboundTypeReference reference, LightweightTypeReference param) {
		if (!shouldProcess(reference.getTypeParameter())) {
			reference.tryResolve();
			if (reference.internalIsResolved()) {
				outerVisit(reference, param);
			} else {
				super.acceptHint(reference, param);
			}
		} else {
			reference.acceptHint(boundByInference(param));
		}
	}
	
	@Override
	protected ArrayTypeReferenceTraverser createArrayTypeReferenceTraverser() {
		return new ArrayTypeReferenceTraverser() {
			@Override
			protected void doVisitParameterizedTypeReference(ParameterizedTypeReference reference, ArrayTypeReference declaration) {
				JvmType type = reference.getType();
				if (type instanceof JvmTypeParameter) {
					if (shouldProcess((JvmTypeParameter) type)) {
						JvmTypeParameter typeParameter = (JvmTypeParameter) type;
						processTypeParameter(typeParameter, declaration);
					}
//				} else if (reference.isSubtypeOf(Iterable.class)) {  //cym comment
				} else if (reference.isSubtypeOf(Buildin.Iterable.JvmType)) {
					ArrayTypeReference array = reference.tryConvertToArray();
					if (array != null) {
						outerVisit(declaration, array);
					}
				}
			}
			@Override
			protected void doVisitWildcardTypeReference(WildcardTypeReference reference, ArrayTypeReference declaration) {
				LightweightTypeReference lowerBound = reference.getLowerBound();
				if (lowerBound != null) {
					outerVisit(declaration, lowerBound);
				} else {
					for(LightweightTypeReference upperBound: reference.getUpperBounds()) {
						outerVisit(declaration, upperBound);	
					}
				}
			}
		};
	}
	
	@Override
	protected ParameterizedTypeReferenceTraverser createParameterizedTypeReferenceTraverser() {
		return new UnboundTypeParameterAwareParameterizedTypeReferenceTraverser() {
			@Override
			protected void doVisitArrayTypeReference(ArrayTypeReference reference, ParameterizedTypeReference declaration) {
				JvmType type = declaration.getType();
				if (type instanceof JvmTypeParameter) {
					if (shouldProcess((JvmTypeParameter) type)) {
						JvmTypeParameter typeParameter = (JvmTypeParameter) type;
						processTypeParameter(typeParameter, reference);
					}
//				} else if (declaration.isSubtypeOf(Iterable.class)) {  //cym comment
				} else if (declaration.isSubtypeOf(Buildin.Iterable.JvmType)) {
					ArrayTypeReference array = declaration.tryConvertToArray();
					if (array != null) {
						outerVisit(array, reference);
					}
				}
			}
			
			@Override
			protected void doVisitMatchingTypeParameters(ParameterizedTypeReference actual,
					ParameterizedTypeReference declaration) {
				if (actual.isFunctionType() ^ declaration.isFunctionType() /* one or the other is a function type but not both */) {
					FunctionTypeReference actualFunctionType = actual.tryConvertToFunctionTypeReference(false);
					if (actualFunctionType != null) {
						FunctionTypeReference declarationFunctionType = declaration.tryConvertToFunctionTypeReference(false);
						if (declarationFunctionType != null) {
							List<LightweightTypeReference> actualParameterTypes = actualFunctionType.getParameterTypes();
							List<LightweightTypeReference> declarationParameterTypes = declarationFunctionType.getParameterTypes();
							int max = Math.min(actualParameterTypes.size(), declarationParameterTypes.size());
							for(int i = 0; i < max; i++) {
								LightweightTypeReference actualParameterType = actualParameterTypes.get(i);
								LightweightTypeReference declarationParameterType = declarationParameterTypes.get(i);
								outerVisit(declarationParameterType, actualParameterType, declaration, VarianceInfo.IN, VarianceInfo.IN);
							}
							LightweightTypeReference actualReturnType = actualFunctionType.getReturnType();
							LightweightTypeReference declarationReturnType = declarationFunctionType.getReturnType();
							if (actualReturnType != null && declarationReturnType != null) {
								outerVisit(declarationReturnType, actualReturnType, declaration, VarianceInfo.OUT, VarianceInfo.OUT);
							}
							return;
						}
					}
				}
				super.doVisitMatchingTypeParameters(actual, declaration);
			}
		};
	}
	
	@Override
	protected UnboundTypeReferenceTraverser createUnboundTypeReferenceTraverser() {
		return new UnboundTypeParameterAwareUnboundTypeReferenceTraverser() {
			@Override
			protected void doVisitWildcardTypeReference(WildcardTypeReference reference,
					UnboundTypeReference declaration) {
				if (shouldProcess(declaration.getTypeParameter())) {
					declaration.acceptHint(boundByInference(reference));
				} else {
					super.doVisitWildcardTypeReference(reference, declaration);
				}
			}
		};
	}
	private LightweightBoundTypeArgument boundByInference(LightweightTypeReference reference) {
		return new LightweightBoundTypeArgument(reference.getWrapperTypeIfPrimitive(), BoundTypeArgumentSource.INFERRED, getOrigin(), getExpectedVariance(), getActualVariance());
	}
}

