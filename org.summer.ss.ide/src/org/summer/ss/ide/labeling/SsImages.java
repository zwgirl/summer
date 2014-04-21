/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.summer.ss.ide.labeling;

import org.eclipse.jdt.internal.ui.JavaPluginImages;
import org.eclipse.jface.resource.ImageDescriptor;
import org.summer.dsl.model.types.JvmVisibility;
import org.eclipse.xtext.ui.IImageHelper.IImageDescriptorHelper;
import org.summer.dsl.xbase.ui.labeling.XbaseImages2;

import com.google.inject.Inject;


/**
 * @author Jan Koehnlein - Initial contribution and API
 * @author Holger Schill
 */
public class SsImages extends XbaseImages2 {

	@Inject
	private IImageDescriptorHelper imageHelper;
	
	public ImageDescriptor forFilter() {
		return JavaPluginImages.DESC_ELCL_FILTER;
	}

	public ImageDescriptor forImplementsAnnotation() {
		return JavaPluginImages.DESC_OBJ_IMPLEMENTS;
	}

	public ImageDescriptor forOverridesAnnotation() {
		return JavaPluginImages.DESC_OBJ_OVERRIDES;
	}

	public ImageDescriptor forPackage() {
		return JavaPluginImages.DESC_OBJS_PACKDECL;
	}

	public ImageDescriptor forDispatcherFunction(JvmVisibility visibility, int adornments) {
		String fileName = new StringBuilder("dispatch_method_")
			.append(visibility.getName().toLowerCase())
			.append(".png").toString();
		return getDecorated(imageHelper.getImageDescriptor(fileName), adornments);
	}

	public ImageDescriptor forFile() {
		return imageHelper.getImageDescriptor("xtend.gif");
	}
}
