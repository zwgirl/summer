/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.summer.dsl.model.ui.refactoring;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.text.ITextSelection;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.ui.refactoring.ui.DefaultRenameElementHandler;
import org.eclipse.xtext.ui.refactoring.ui.IRenameElementContext;

import com.google.inject.Inject;

/**
 * Creates a {@link JdtRefactoringContext} if a reference to a JVM element is the target to be refactored.
 * 
 * @author Jan Koehnlein - Initial contribution and API
 * @deprecated left for backward compatibility only. Use {@link DefaultRenameElementHandler} instead.
 */
@Deprecated
public class JvmRenameElementHandler extends DefaultRenameElementHandler {
	
	@Inject
	private JdtRefactoringContextFactory contextFactory;
	
	@Override
	public IRenameElementContext createRenameElementContext(EObject targetElement, XtextEditor editor,
			ITextSelection selection, XtextResource resource) {
		return contextFactory.createRenameElementContext(targetElement, editor, selection, resource);
	}
}
