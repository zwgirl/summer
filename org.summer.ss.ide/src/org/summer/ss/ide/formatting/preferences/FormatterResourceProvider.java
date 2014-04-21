/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.summer.ss.ide.formatting.preferences;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.resource.XtextResource;
import org.summer.dsl.ui.codetemplates.ui.preferences.TemplateResourceProvider;
import org.eclipse.xtext.ui.editor.embedded.IEditedResourceProvider;
import org.eclipse.xtext.ui.resource.IResourceSetProvider;

import com.google.inject.Inject;

/**
 * @author Dennis Huebner - Initial contribution and API
 */
public class FormatterResourceProvider implements IEditedResourceProvider {
	
	@Inject
	private IResourceSetProvider resourceSetProvider;
	
	public XtextResource createResource() {
		ResourceSet resourceSet = resourceSetProvider.get(null);
		XtextResource result = (XtextResource) resourceSet.createResource(URI
				.createURI(TemplateResourceProvider.SYNTHETIC_SCHEME + ":/" + "FormatterPreview.xtend"));
		result.setValidationDisabled(true);
		return result;
	}
	
}
