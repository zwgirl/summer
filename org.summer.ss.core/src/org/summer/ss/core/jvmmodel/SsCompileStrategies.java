/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.summer.ss.core.jvmmodel;

import java.util.List;

import org.summer.dsl.model.ss.CreateExtensionInfo;
import org.summer.dsl.model.ss.XtendFunction;
import org.summer.dsl.model.types.JvmField;
import org.summer.dsl.model.types.JvmOperation;
import org.summer.dsl.xbase.compiler.output.ITreeAppendable;
import org.eclipse.xtext.xbase.lib.Procedures;

import com.google.inject.Inject;
import com.google.inject.Provider;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public class SsCompileStrategies {

	@Inject
	private Provider<DispatchMethodCompileStrategy> dispatchMethodProvider;

	public Procedures.Procedure1<ITreeAppendable> forDispatcher(JvmOperation dispatchOperation,
			List<JvmOperation> sortedDispatchOperations) {
		DispatchMethodCompileStrategy strategy = dispatchMethodProvider.get();
		strategy.initialize(dispatchOperation, sortedDispatchOperations);
		return strategy;
	}

	@Inject
	private Provider<CacheMethodCompileStrategy> cacheMethodProvider;

	public Procedures.Procedure1<ITreeAppendable> forCacheMethod(CreateExtensionInfo createExtensionInfo,
			JvmField cacheField, JvmOperation initializerMethod) {
		CacheMethodCompileStrategy strategy = cacheMethodProvider.get();
		strategy.init(createExtensionInfo, cacheField, initializerMethod);
		return strategy;
	}

	@Inject
	private Provider<CacheVariableCompileStrategy> cacheVarProvider;

	public Procedures.Procedure1<ITreeAppendable> forCacheVariable(XtendFunction function) {
		CacheVariableCompileStrategy strategy = cacheVarProvider.get();
		strategy.init(function);
		return strategy;
	}
}
