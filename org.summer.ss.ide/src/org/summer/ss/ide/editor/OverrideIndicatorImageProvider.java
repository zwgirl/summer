/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.summer.ss.ide.editor;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.text.source.Annotation;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.texteditor.IAnnotationImageProvider;
import org.summer.ss.ide.labeling.SsImages;

import com.google.inject.Inject;

/**
 * @author Michael Clay - Initial contribution and API
 */
public class OverrideIndicatorImageProvider implements IAnnotationImageProvider {
	private static final String OVERRIDE_IMG_DESC_ID = "SsImages.DESC_OBJ_OVERRIDES"; //$NON-NLS-1$
	private static final String IMPLEMENTS_IMG_DESC_ID = "SsImages.DESC_OBJ_IMPLEMENTS"; //$NON-NLS-1$
	private SsImages xtendImages;

	@Inject
	public void setXtendImages(SsImages xtendImages) {
		this.xtendImages = xtendImages;
	}

	public Image getManagedImage(Annotation annotation) {
		return null;
	}

	public String getImageDescriptorId(Annotation annotation) {
		if (!(annotation instanceof OverrideIndicatorAnnotation)) {
			return null;
		}
		OverrideIndicatorAnnotation overrideIndicatorAnnotation = (OverrideIndicatorAnnotation) annotation;
		return overrideIndicatorAnnotation.isOverwriteIndicator() ? OVERRIDE_IMG_DESC_ID : IMPLEMENTS_IMG_DESC_ID;
	}

	public ImageDescriptor getImageDescriptor(String imageDescritporId) {
		ImageDescriptor imageDescriptor = null;
		if (IMPLEMENTS_IMG_DESC_ID.equals(imageDescritporId)) {
			imageDescriptor = xtendImages.forImplementsAnnotation();
		} else if (OVERRIDE_IMG_DESC_ID.equals(imageDescritporId)) {
			imageDescriptor = xtendImages.forOverridesAnnotation();
		}
		return imageDescriptor;
	}

}
