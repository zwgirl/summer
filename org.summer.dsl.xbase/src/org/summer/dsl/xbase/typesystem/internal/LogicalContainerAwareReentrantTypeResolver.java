/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.summer.dsl.xbase.typesystem.internal;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.NonNullByDefault;
import org.summer.dsl.model.types.JvmModule;
import org.summer.dsl.xbase.scoping.batch.IFeatureScopeSession;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * TODO JavaDoc, toString
 */
@NonNullByDefault
public class LogicalContainerAwareReentrantTypeResolver extends DefaultReentrantTypeResolver {
	
	@Override
	protected void computeTypes(ResolvedTypes resolvedTypes, IFeatureScopeSession session) {
		EObject element = getRoot();
		if (element instanceof JvmModule) {
			JvmModule module = (JvmModule) element;
			ModuleComputationState state = new ModuleComputationState(resolvedTypes, session , module);
			state.computeTypes();
		}else{
			throw new IllegalStateException();
		}
	}

}
