/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.summer.dsl.xbase.ui.hover;

import org.eclipse.xtext.resource.FileExtensionProvider;
import org.eclipse.xtext.ui.editor.embedded.EmbeddedEditorFactory;

import com.google.inject.Inject;

/**
 * @author Holger Schill - Initial contribution and API
 * @since 2.3
 */
public class XbaseHoverConfiguration {

	@Inject
	private EmbeddedEditorFactory editorFactory;
	
	@Inject
	private FileExtensionProvider fileExtensionProvider;

	
	public EmbeddedEditorFactory getEditorFactory() {
		return editorFactory;
	}

	public String getFileExtension() {
		return fileExtensionProvider.getPrimaryFileExtension();
	}
}
