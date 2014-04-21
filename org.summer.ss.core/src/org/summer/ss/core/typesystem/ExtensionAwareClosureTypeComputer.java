/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.summer.ss.core.typesystem;

import java.util.List;

import org.eclipse.jdt.annotation.NonNullByDefault;
import org.summer.dsl.model.ss.XtendFormalParameter;
import org.summer.dsl.model.types.JvmFormalParameter;
import org.summer.dsl.model.types.JvmOperation;
import org.summer.dsl.model.xbase.XClosure;
import org.summer.dsl.xbase.typesystem.computation.ClosureTypeComputer;
import org.summer.dsl.xbase.typesystem.computation.ClosureWithExpectationHelper;
import org.summer.dsl.xbase.typesystem.computation.ClosureWithoutExpectationHelper;
import org.summer.dsl.xbase.typesystem.computation.ITypeAssigner;
import org.summer.dsl.xbase.typesystem.computation.ITypeComputationState;
import org.summer.dsl.xbase.typesystem.computation.ITypeExpectation;
import org.summer.dsl.xbase.typesystem.computation.UnknownClosureTypeHelper;
import org.summer.dsl.xbase.typesystem.references.FunctionTypeReference;

import com.google.common.collect.Lists;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@NonNullByDefault
public class ExtensionAwareClosureTypeComputer extends ClosureTypeComputer {
	protected ExtensionAwareClosureTypeComputer(XClosure closure, ITypeExpectation expectation,
			ITypeComputationState state) {
		super(closure, expectation, state);
	}

	@Override
	protected ClosureWithExpectationHelper createClosureWithExpectationHelper(JvmOperation operation) {
		return new ClosureWithExpectationHelper(getClosure(), operation, getExpectation(), getState()) {
			@Override
			protected ITypeComputationState getClosureBodyTypeComputationState(ITypeAssigner typeAssigner) {
				ITypeComputationState result = super.getClosureBodyTypeComputationState(typeAssigner);
				addExtensions(result);
				return result;
			}
		};
	}

	@Override
	protected UnknownClosureTypeHelper createUnknownClosureTypeHelper() {
		return new UnknownClosureTypeHelper(getClosure(), getExpectation(), getState()) {
			@Override
			protected ITypeComputationState getClosureBodyTypeComputationState(ITypeAssigner typeAssigner) {
				ITypeComputationState result = super.getClosureBodyTypeComputationState(typeAssigner);
				addExtensions(result);
				return result;
			}
		};
	}

	@Override
	protected ClosureWithoutExpectationHelper createClosureWithoutExpectationHelper() {
		return new ClosureWithoutExpectationHelper(getClosure(), getExpectation(), getState()) {
			@Override
			protected ITypeComputationState getClosureBodyTypeComputationState(ITypeAssigner typeAssigner,
					FunctionTypeReference incompleteClosureType) {
				ITypeComputationState result = super.getClosureBodyTypeComputationState(typeAssigner, incompleteClosureType);
				addExtensions(result);
				return result;
			}
		};
	}
	
	protected void addExtensions(ITypeComputationState state) {
		List<JvmFormalParameter> extensionProviders = null;
		for(JvmFormalParameter parameter: getClosure().getDeclaredFormalParameters()) {
			if (parameter instanceof XtendFormalParameter && ((XtendFormalParameter) parameter).isExtension()) {
				if (extensionProviders == null)
					extensionProviders = Lists.newLinkedList();
				extensionProviders.add(parameter);
			}
		}
		if (extensionProviders != null)
			state.addExtensionsToCurrentScope(extensionProviders);
	}
}