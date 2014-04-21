/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.summer.dsl.xbase.ui.hierarchy;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.jdt.internal.ui.util.OpenTypeHierarchyUtil;
import org.eclipse.xtext.ui.editor.XtextEditor;

/**
 * @author Holger Schill - Initial contribution and API
 */
public class OpenTypeHierarchyHandler extends AbstractHierarchyHandler {

	@Override
	protected void openPresentation(final XtextEditor editor, IJavaElement javaElement,  final EObject selectedElement) {
		OpenTypeHierarchyUtil.open(javaElement, editor.getSite().getWorkbenchWindow());
	}

}
