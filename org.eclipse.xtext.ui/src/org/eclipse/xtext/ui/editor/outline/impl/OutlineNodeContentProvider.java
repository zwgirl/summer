/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.outline.impl;

import org.eclipse.core.runtime.Assert;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.xtext.ui.editor.outline.IOutlineNode;

/**
 * The JFace/SWT content provider. The tree of visible IOutlineNodes has already been pre-computed.
 * 
 * @author Jan Koehnlein - Initial contribution and API
 */
public class OutlineNodeContentProvider implements ITreeContentProvider {

	private OutlineFilterAndSorter filterSorter;

	/**
	 * @since 2.2
	 */
	public void setFilterAndSorter(OutlineFilterAndSorter filterSorter) {
		this.filterSorter = filterSorter;
	}
	
	public void dispose() {
	}

	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		Assert.isLegal(newInput == null || newInput instanceof IOutlineNode);
	}

	public Object[] getElements(Object inputElement) {
		return getChildren(inputElement);
	}

	public Object[] getChildren(Object parentElement) {
		return filterSorter.filterAndSort(asOutlineNode(parentElement).getChildren());
	}

	public Object getParent(Object element) {
		return asOutlineNode(element).getParent();
	}

	public boolean hasChildren(Object element) {
		return asOutlineNode(element).hasChildren();
	}

	protected IOutlineNode asOutlineNode(Object element) {
		Assert.isLegal(element instanceof IOutlineNode);
		return (IOutlineNode) element;
	}

}
