/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.summer.dsl.xbase.typesystem.arguments;

import java.util.List;
import java.util.NoSuchElementException;

import org.eclipse.jdt.annotation.NonNullByDefault;
import org.eclipse.jdt.annotation.Nullable;
import org.summer.dsl.model.types.JvmFormalParameter;
import org.summer.dsl.model.xbase.XExpression;
import org.summer.dsl.xbase.typesystem.references.LightweightTypeReference;
import org.summer.dsl.xbase.typesystem.references.OwnedConverter;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@NonNullByDefault
public class ReorderedVarArgFeatureCallArguments extends ReorderedFeatureCallArguments {

	public ReorderedVarArgFeatureCallArguments(List<XExpression> arguments, List<JvmFormalParameter> parameters,
			List<XExpression> shiftedArguments, List<JvmFormalParameter> shiftedParameters, boolean hasReceiver,
			OwnedConverter converter) {
		super(arguments, parameters, shiftedArguments, shiftedParameters, hasReceiver, converter);
	}
	
	@Override
	public IFeatureCallArgumentSlot getNextUnprocessedArgumentSlot() {
		if (!hasUnprocessedArguments()) {
			throw new NoSuchElementException();
		}
		if (nextUnprocessedArgument >= parameters.size()) {
			if (nextUnprocessedArgument < arguments.size()) {
				throw new IllegalStateException();
			}
			return new StandardFeatureCallArgumentSlot(this, nextUnprocessedArgument); 
		}
		if (nextUnprocessedArgument == parameters.size() - 1) {
			return new VarArgsFeatureCallArgumentSlot(this, nextUnprocessedArgument);
		}
		return new StandardFeatureCallArgumentSlot(this, nextUnprocessedArgument);
	}
	
	@Override
	public int getArgumentCount() {
		return super.getArgumentCount() + shiftedArguments.size();
	}
	
	@Override
	public XExpression internalGetArgument(int idx) {
		if (idx >= arguments.size()) {
			return shiftedArguments.get(idx - arguments.size());
		}
		return arguments.get(idx);
	}
	
	@Override
	@Nullable
	protected LightweightTypeReference internalGetParameterType(int idx) {
		if (idx >= parameters.size()) {
			JvmFormalParameter parameter = shiftedParameters.get(idx - arguments.size());
			return toLightweightTypeReference(parameter);
		}
		JvmFormalParameter parameter = parameters.get(idx);
		return toLightweightTypeReference(parameter);
	}
}
