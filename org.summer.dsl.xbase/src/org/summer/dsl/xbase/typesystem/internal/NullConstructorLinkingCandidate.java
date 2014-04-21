/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.summer.dsl.xbase.typesystem.internal;

import org.eclipse.jdt.annotation.NonNullByDefault;
import org.summer.dsl.model.types.JvmConstructor;
import org.summer.dsl.model.xbase.XConstructorCall;
import org.summer.dsl.model.xbase.XExpression;
import org.summer.dsl.xbase.typesystem.computation.IConstructorLinkingCandidate;
import org.summer.dsl.xbase.typesystem.computation.ILinkingCandidate;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@NonNullByDefault
public class NullConstructorLinkingCandidate extends AbstractNullLinkingCandidate implements IConstructorLinkingCandidate {

	private AbstractTypeComputationState state;

	public NullConstructorLinkingCandidate(XConstructorCall constructorCall, AbstractTypeComputationState state) {
		super(constructorCall);
		this.state = state;
	}
	
	public ILinkingCandidate getPreferredCandidate(ILinkingCandidate other) {
		return other;
	}

	public XConstructorCall getConstructorCall() {
		return (XConstructorCall) featureOrConstructorCall;
	}

	public JvmConstructor getConstructor() {
		throw new UnsupportedOperationException();
	}
	
	public void applyToComputationState() {
		for(XExpression argument: getConstructorCall().getArguments()) {
			state.withNonVoidExpectation().computeTypes(argument);
		}
	}

}
