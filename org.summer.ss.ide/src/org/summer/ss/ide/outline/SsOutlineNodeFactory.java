/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.summer.ss.ide.outline;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.ui.editor.outline.IOutlineNode;
import org.eclipse.xtext.ui.editor.outline.impl.OutlineNodeFactory;
import org.summer.dsl.model.types.JvmField;
import org.summer.dsl.model.types.JvmOperation;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public class SsOutlineNodeFactory extends OutlineNodeFactory {

	public SsFeatureNode createXtendFeatureNode(IOutlineNode parentNode, EObject modelElement, ImageDescriptor imageDescriptor,
			Object text, boolean isLeaf, boolean synthetic, int inheritanceDepth) {
		SsFeatureNode featureNode = new SsFeatureNode(modelElement, parentNode, imageDescriptor, text, isLeaf);
		ICompositeNode parserNode = NodeModelUtils.getNode(modelElement);
		if (parserNode != null)
			featureNode.setTextRegion(parserNode.getTextRegion());
		if (isLocalElement(parentNode, modelElement))
			featureNode.setShortTextRegion(getLocationInFileProvider().getSignificantTextRegion(modelElement));
		featureNode.setStatic(isStatic(modelElement));
		featureNode.setSynthetic(synthetic);
		featureNode.setInheritanceDepth(inheritanceDepth);
		return featureNode;
	}

	protected boolean isStatic(EObject element) {
		if (element instanceof JvmField)
			return ((JvmField) element).isStatic();
		else if (element instanceof JvmOperation)
			return ((JvmOperation) element).isStatic();
		else
			return false;
	}

}
