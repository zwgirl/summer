/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.summer.dsl.model.types.util;

import org.summer.dsl.model.types.JvmAnyTypeReference;
import org.summer.dsl.model.types.JvmGenericArrayTypeReference;
import org.summer.dsl.model.types.JvmMultiTypeReference;
import org.summer.dsl.model.types.JvmParameterizedTypeReference;
import org.summer.dsl.model.types.JvmSynonymTypeReference;
import org.summer.dsl.model.types.JvmTypeReference;
import org.summer.dsl.model.types.JvmUnknownTypeReference;
import org.summer.dsl.model.types.JvmWildcardTypeReference;

// TODO use injection?
/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@Deprecated
public class TypeConformanceStrategySelector extends AbstractConformanceVisitor<JvmTypeReference> {

	private final TypeConformanceComputer conformanceComputer;

	private final TypeConformanceStrategy<JvmAnyTypeReference> anyTypeDispatcher;
	private final TypeConformanceStrategy<JvmGenericArrayTypeReference> genericArrayTypeDispatcher;
	private final TypeConformanceStrategy<JvmMultiTypeReference> multiTypeDispatcher;
	private final TypeConformanceStrategy<JvmParameterizedTypeReference> parameterizedTypeDispatcher;
	private final TypeConformanceStrategy<JvmSynonymTypeReference> synonymTypeDispatcher;
	private final TypeConformanceStrategy<JvmUnknownTypeReference> unknownTypeDispatcher;
	private final TypeConformanceStrategy<JvmWildcardTypeReference> wildcardTypeDispatcher;

	public TypeConformanceStrategySelector(TypeConformanceComputer typeConformanceComputer) {
		conformanceComputer = typeConformanceComputer;
		anyTypeDispatcher = createAnyTypeDispatcher();
		genericArrayTypeDispatcher = createGenericArrayTypeDispatcher();
		multiTypeDispatcher = createMultiTypeDispatcher();
		parameterizedTypeDispatcher = createParameterizedTypeDispatcher();
		synonymTypeDispatcher = createSynonymTypeDispatcher();
		unknownTypeDispatcher = createUnknownTypeDispatcher();
		wildcardTypeDispatcher = createWildcardTypeDispatcher();
	}

	protected <T extends JvmTypeReference> TypeConformanceComputationArgument.Internal<T> copyArgument(T t, TypeConformanceComputationArgument.Internal<JvmTypeReference> param) {
		return TypeConformanceComputationArgument.Internal.create(t, param.rawType, param.asTypeArgument, param.allowPrimitiveConversion);
	}
	
	@Override
	public TypeConformanceResult doVisitAnyTypeReference(JvmAnyTypeReference reference,
			TypeConformanceComputationArgument.Internal<JvmTypeReference> param) {
		return anyTypeDispatcher.visit(param.reference, copyArgument(reference, param));
	}

	@Override
	public TypeConformanceResult doVisitGenericArrayTypeReference(JvmGenericArrayTypeReference reference,
			TypeConformanceComputationArgument.Internal<JvmTypeReference> param) {
		return genericArrayTypeDispatcher.visit(param.reference, copyArgument(reference, param));
	}

	@Override
	public TypeConformanceResult doVisitMultiTypeReference(JvmMultiTypeReference reference,
			TypeConformanceComputationArgument.Internal<JvmTypeReference> param) {
		return multiTypeDispatcher.visit(param.reference, copyArgument(reference, param));
	}

	@Override
	public TypeConformanceResult doVisitParameterizedTypeReference(JvmParameterizedTypeReference reference,
			TypeConformanceComputationArgument.Internal<JvmTypeReference> param) {
		return parameterizedTypeDispatcher.visit(param.reference, copyArgument(reference, param));
	}

	@Override
	public TypeConformanceResult doVisitSynonymTypeReference(JvmSynonymTypeReference reference,
			TypeConformanceComputationArgument.Internal<JvmTypeReference> param) {
		return synonymTypeDispatcher.visit(param.reference, copyArgument(reference, param));
	}

	@Override
	public TypeConformanceResult doVisitUnknownTypeReference(JvmUnknownTypeReference reference,
			TypeConformanceComputationArgument.Internal<JvmTypeReference> param) {
		return unknownTypeDispatcher.visit(param.reference, copyArgument(reference, param));
	}

	@Override
	public TypeConformanceResult doVisitWildcardTypeReference(JvmWildcardTypeReference reference,
			TypeConformanceComputationArgument.Internal<JvmTypeReference> param) {
		return wildcardTypeDispatcher.visit(param.reference, copyArgument(reference, param));
	}

	protected TypeConformanceStrategy<JvmAnyTypeReference> createAnyTypeDispatcher() {
		return new AnyTypeConformanceStrategy(conformanceComputer);
	}

	protected TypeConformanceStrategy<JvmGenericArrayTypeReference> createGenericArrayTypeDispatcher() {
		return new GenericArrayConformanceStrategy(conformanceComputer);
	}

	protected TypeConformanceStrategy<JvmMultiTypeReference> createMultiTypeDispatcher() {
		return new MultiTypeConformanceStrategy(conformanceComputer);
	}

	protected TypeConformanceStrategy<JvmParameterizedTypeReference> createParameterizedTypeDispatcher() {
		return new ParameterizedTypeConformanceStrategy(conformanceComputer);
	}

	protected TypeConformanceStrategy<JvmSynonymTypeReference> createSynonymTypeDispatcher() {
		return new SynonymConformanceStrategy(conformanceComputer);
	}

	protected TypeConformanceStrategy<JvmUnknownTypeReference> createUnknownTypeDispatcher() {
		return new UnknownConformanceStrategy(conformanceComputer);
	}

	protected TypeConformanceStrategy<JvmWildcardTypeReference> createWildcardTypeDispatcher() {
		return new WildcardConformanceStrategy(conformanceComputer);
	}
}