/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.summer.dsl.xbase.typesystem.computation;

import java.util.List;

import org.eclipse.jdt.annotation.NonNullByDefault;
import org.eclipse.jdt.annotation.Nullable;
import org.summer.dsl.model.types.JvmFormalParameter;
import org.summer.dsl.model.types.JvmOperation;
import org.summer.dsl.model.xbase.XClosure;
import org.summer.dsl.model.xbase.XbasePackage;
import org.summer.dsl.xbase.typesystem.conformance.ConformanceHint;
import org.summer.dsl.xbase.typesystem.references.FunctionTypeReference;
import org.summer.dsl.xbase.typesystem.references.LightweightTypeReference;
import org.summer.dsl.xbase.typesystem.references.UnknownTypeReference;

import com.google.inject.Inject;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@NonNullByDefault
public class UnknownClosureTypeHelper extends AbstractClosureTypeHelper {
	@Inject
	ITypeComputer computer;

	protected UnknownClosureTypeHelper(XClosure closure, ITypeExpectation expectation, ITypeComputationState state) {
		super(closure, expectation, state);
	}

	@Override
	protected void computeTypes() {
		ITypeAssigner typeAssigner = getState().withoutRootExpectation().assignTypes();
		ITypeComputationState closureBodyTypeComputationState = getClosureBodyTypeComputationState(typeAssigner);
//		closureBodyTypeComputationState.computeTypes(getClosure().getExpression());  //cym comment
		computer.computeTypes(getClosure().getStatment(), closureBodyTypeComputationState);
		getExpectation().acceptActualType(new UnknownTypeReference(getExpectation().getReferenceOwner()), ConformanceHint.UNCHECKED);
	}

	@Nullable
	@Override
	public FunctionTypeReference getExpectedClosureType() {
		return null;
	}

	@Nullable
	@Override
	public JvmOperation getFunction() {
		return null;
	}

	protected ITypeComputationState getClosureBodyTypeComputationState(ITypeAssigner typeAssigner) {
		List<JvmFormalParameter> closureParameters = getClosure().getFormalParameters();
		int paramCount = closureParameters.size();
		for(int i = 0; i < paramCount; i++) {
			JvmFormalParameter closureParameter = closureParameters.get(i);
			if (closureParameter.eContainingFeature() != XbasePackage.Literals.XCLOSURE__IMPLICIT_PARAMETER && closureParameter.getParameterType() != null) {
				final LightweightTypeReference closureParameterType = typeAssigner.toLightweightTypeReference(closureParameter.getParameterType());
				typeAssigner.assignType(closureParameter, closureParameterType);
			} else {
				typeAssigner.assignType(closureParameter, new UnknownTypeReference(typeAssigner.getReferenceOwner()));
			}
		}
		ITypeComputationState result = typeAssigner.getForkedState();
		return result;
	}
}
