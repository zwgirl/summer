/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.summer.dsl.xbase.typesystem.computation;

import org.eclipse.jdt.annotation.NonNullByDefault;
import org.eclipse.jdt.annotation.Nullable;
import org.summer.dsl.model.xbase.XClosure;
import org.summer.dsl.model.xtype.XFunctionTypeRef;
import org.summer.dsl.xbase.typesystem.internal.AbstractTypeComputationState;
import org.summer.dsl.xbase.typesystem.references.FunctionTypeReference;
import org.summer.dsl.xbase.typesystem.references.LightweightTypeReference;
import org.summer.dsl.xbase.typesystem.references.ParameterizedTypeReference;
import org.summer.dsl.xbase.typesystem.references.UnboundTypeReference;
import org.summer.dsl.xbase.typesystem.util.BoundTypeArgumentSource;
import org.summer.dsl.xbase.typesystem.util.CommonTypeComputationServices;
import org.summer.dsl.xbase.typesystem.util.ExpectationTypeParameterHintCollector;

/**
 * Base strategy to compute the type of lambda expressions.
 *
 * @noextend This class is not intended to be subclassed by clients.
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@NonNullByDefault
public abstract class AbstractClosureTypeHelper {

	protected final XClosure closure;
	private final AbstractTypeComputationState state;
	private final CommonTypeComputationServices services;
	private final ITypeExpectation expectation;
	
	protected AbstractClosureTypeHelper(XClosure closure, ITypeExpectation expectation, AbstractTypeComputationState state) {
		this.closure = closure;
		this.expectation = expectation;
		this.state = state;
		this.services = state.getReferenceOwner().getServices();
	}
	
	protected AbstractTypeComputationState getState() {
		return state;
	}
	
	protected ITypeExpectation getExpectation() {
		return expectation;
	}
	
	protected XClosure getClosure() {
		return closure;
	}
	
	protected CommonTypeComputationServices getServices() {
		return services;
	}
	
	/**
	 * @noreference This method is not intended to be referenced by clients.
	 */
	protected abstract void computeTypes();

	/**
	 * This method is only public for testing purpose.
	 * 
	 * @noreference This method is not intended to be referenced by clients.
	 */
	@Nullable
	public abstract FunctionTypeReference getExpectedClosureType();

	/**
	 * This method is only public for testing purpose.
	 * 
	 * @noreference This method is not intended to be referenced by clients.
	 */
	@Nullable
	public abstract FunctionTypeReference getFunction();

	protected void deferredBindTypeArgument(@Nullable LightweightTypeReference declared, LightweightTypeReference actual, final BoundTypeArgumentSource source) {
		if (declared != null) { 
			// TODO double check other clients of the ExpectationTypeParameterHintCollector
			// It may be possible / necessary to use the very same implementation instead of anonymous 
			// specializations or it may be possible that this specialization is no longer necessary.
			ExpectationTypeParameterHintCollector collector = new ExpectationTypeParameterHintCollector(expectation.getReferenceOwner()) {
				
				class UnboundTypeReferencePreserver extends DeferredParameterizedTypeReferenceTraverser {
					@Override
					public void doVisitUnboundTypeReference(UnboundTypeReference reference,
							ParameterizedTypeReference declaration) {
						if (reference.internalIsResolved() || getOwner().isResolved(reference.getHandle())) {
							reference.tryResolve();
							outerVisit(reference, declaration);
						} else {
							addHint(reference, declaration);
						}
					}
					
				}
				
				@Override
				protected void addHint(UnboundTypeReference typeParameter, LightweightTypeReference reference) {
					LightweightTypeReference wrapped = reference.getWrapperTypeIfPrimitive();
					if (source == BoundTypeArgumentSource.INFERRED_CONSTRAINT) {
						wrapped = getStricterConstraint(typeParameter, wrapped);
					}
					typeParameter.acceptHint(wrapped, source, getOrigin(), getExpectedVariance(), getActualVariance());
				}
				
				@Override
				protected ParameterizedTypeReferenceTraverser createParameterizedTypeReferenceTraverser() {
					return new UnboundTypeReferencePreserver();
				}
			};
			collector.processPairedReferences(declared, actual);
		}
	}

}
