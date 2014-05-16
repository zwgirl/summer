/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.summer.ss.ide.refactoring;

import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.jface.text.ITextSelection;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.summer.dsl.model.types.JvmOperation;
import org.summer.dsl.xbase.ui.jvmmodel.refactoring.jdt.CombinedJvmJdtRenameContext;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public class DispatchMethodRenameContext extends CombinedJvmJdtRenameContext {

	public DispatchMethodRenameContext(JvmOperation dispatchFunction, Map<URI, IJavaElement> jvm2javaElements,
			XtextEditor editor, ITextSelection selection, XtextResource contextResource) {
		super(dispatchFunction, jvm2javaElements, editor, selection, contextResource);
	}

	
}
