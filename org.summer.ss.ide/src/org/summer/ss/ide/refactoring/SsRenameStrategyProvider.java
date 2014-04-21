/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.summer.ss.ide.refactoring;

import org.eclipse.emf.ecore.EObject;
import org.summer.dsl.model.ss.XtendConstructor;
import org.eclipse.xtext.ui.refactoring.IRenameStrategy;
import org.eclipse.xtext.ui.refactoring.impl.DefaultRenameStrategyProvider;
import org.eclipse.xtext.ui.refactoring.ui.IRenameElementContext;

import com.google.inject.Inject;

public class SsRenameStrategyProvider extends DefaultRenameStrategyProvider {
	@Inject
	private com.google.inject.Provider<DispatchMethodRenameStrategy> dispatchStrategyProvider;
	
	@Override
	public IRenameStrategy get(EObject targetEObject, IRenameElementContext renameElementContext) throws NoSuchStrategyException {
		if(targetEObject instanceof XtendConstructor)
			// Xtend constructors can be ignored in rename refactorings
			return null;
		return super.get(targetEObject, renameElementContext);
	}
	
	@Override
	protected IRenameStrategy createRenameStrategy(EObject targetEObject, IRenameElementContext renameElementContext) {
		if (renameElementContext instanceof DispatchMethodRenameContext) 
			return dispatchStrategyProvider.get();
		else
			return super.createRenameStrategy(targetEObject, renameElementContext);
	}
}