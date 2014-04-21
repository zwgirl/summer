/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.summer.dsl.xbase.typesystem.computation;

import org.eclipse.jdt.annotation.NonNullByDefault;
import org.eclipse.jdt.annotation.Nullable;
import org.summer.dsl.model.types.JvmOperation;
import org.summer.dsl.model.types.JvmType;
import org.summer.dsl.model.xbase.XClosure;
import org.summer.dsl.xbase.typesystem.references.FunctionTypeReference;
import org.summer.dsl.xbase.typesystem.references.FunctionTypes;
import org.summer.dsl.xbase.typesystem.references.LightweightTypeReference;
import org.summer.dsl.xbase.typesystem.util.CommonTypeComputationServices;

/**
 * Externalized strategy for closure type computation which allows for easier unit testing.
 * Clients will usually not alter the implementation. Public methods are mostly public 
 * for testing purpose.
 * 
 * @see XbaseTypeComputer#_computeTypes(XClosure, ITypeComputationState)
 * @noinstantiate This class is not intended to be instantiated by clients.
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@NonNullByDefault
public class ClosureTypeComputer {

	private final XClosure closure;
	private final ITypeComputationState state;
	
	private final CommonTypeComputationServices services;
	private final FunctionTypes functionTypes;
	private final ITypeExpectation expectation;
	private AbstractClosureTypeHelper strategy;
	
	public ClosureTypeComputer(XClosure closure, ITypeExpectation expectation, ITypeComputationState state) {
		this.closure = closure;
		this.expectation = expectation;
		this.state = state;
		this.services = state.getReferenceOwner().getServices();
		this.functionTypes = services.getFunctionTypes();
	}
	
	public void computeTypes() {
		selectStrategy();
		strategy.computeTypes();
	}
	
	/**
	 * This method is only public for testing purpose.
	 * 
	 * @noreference This method is not intended to be referenced by clients.
	 */
	public void selectStrategy() {
		LightweightTypeReference expectedType = expectation.getExpectedType();
		if (expectedType == null) {
			strategy = getClosureWithoutExpectationHelper();
		} else {
			JvmOperation operation = functionTypes.findImplementingOperation(expectedType);
			JvmType type = expectedType.getType();
			int closureParameterSize = closure.getFormalParameters().size();
			if (operation == null || operation.getParameters().size() != closureParameterSize || type == null) {
				strategy = getClosureWithoutExpectationHelper();
			} else {
				strategy = createClosureWithExpectationHelper(operation);
			}
		}
		
	}


	protected AbstractClosureTypeHelper getClosureWithoutExpectationHelper() {
		if (functionTypes.isFunctionAndProcedureAvailable(expectation.getReferenceOwner()))
			return createClosureWithoutExpectationHelper();
		return createUnknownClosureTypeHelper();
	}
	
//	//cym add
//	protected AbstractClosureTypeHelper getClosureWithoutExpectationHelper() {
////		if (functionTypes.isFunctionAndProcedureAvailable(expectation.getReferenceOwner()))
//			return createClosureWithoutExpectationHelper();
////		return createUnknownClosureTypeHelper();
//	}

	protected ClosureWithExpectationHelper createClosureWithExpectationHelper(JvmOperation operation) {
		return new ClosureWithExpectationHelper(closure, operation, expectation, state);
	}
	
	protected UnknownClosureTypeHelper createUnknownClosureTypeHelper() {
		return new UnknownClosureTypeHelper(closure, expectation, state);
	}

	protected ClosureWithoutExpectationHelper createClosureWithoutExpectationHelper() {
		return new ClosureWithoutExpectationHelper(closure, expectation, state);
	}

	protected XClosure getClosure() {
		return closure;
	}
	
	protected ITypeExpectation getExpectation() {
		return expectation;
	}
	
	protected ITypeComputationState getState() {
		return state;
	}
	
	/**
	 * This method is only public for testing purpose.
	 * 
	 * @noreference This method is not intended to be referenced by clients.
	 */
	@Nullable
	public FunctionTypeReference getExpectedClosureType() {
		if (strategy == null)
			selectStrategy();
		return strategy.getExpectedClosureType();
	}

	/**
	 * This method is only public for testing purpose.
	 * 
	 * @noreference This method is not intended to be referenced by clients.
	 */
	@Nullable
	public JvmOperation getOperation() {
		if (strategy == null)
			selectStrategy();
		return strategy.getOperation();
	}
}
