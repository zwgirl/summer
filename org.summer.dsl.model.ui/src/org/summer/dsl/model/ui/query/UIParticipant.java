/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.summer.dsl.model.ui.query;

import org.eclipse.emf.common.util.URI;
import org.eclipse.jdt.ui.search.IMatchPresentation;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.search.ui.text.Match;
import org.eclipse.swt.graphics.Image;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.IReferenceDescription;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.IResourceDescriptions;
import org.eclipse.xtext.ui.editor.IURIEditorOpener;
import org.eclipse.xtext.ui.label.GlobalDescriptionLabelProvider;

import com.google.inject.Inject;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class UIParticipant implements IMatchPresentation {

	@Inject
	private GlobalDescriptionLabelProvider globalDescriptionsLabelProvider;

	@Inject
	private IURIEditorOpener uriEditorOpener;

	@Inject
	private IResourceDescriptions resourceDescriptions;

	public ILabelProvider createLabelProvider() {
		return new ILabelProvider() {
			public void removeListener(ILabelProviderListener listener) {
			}

			public boolean isLabelProperty(Object element, String property) {
				return false;
			}

			public void dispose() {
			}

			public void addListener(ILabelProviderListener listener) {
			}

			public String getText(Object element) {
				IReferenceDescription referenceDescription = (IReferenceDescription) element;
				URI containerEObjectURI = referenceDescription.getContainerEObjectURI();
				final URI eObjectURI = (containerEObjectURI == null) ? referenceDescription.getSourceEObjectUri()
						: containerEObjectURI;
				IResourceDescription resourceDescription = resourceDescriptions.getResourceDescription(eObjectURI
						.trimFragment());
				if (resourceDescription != null) {
					for (IEObjectDescription eObjectDescription : resourceDescription.getExportedObjects()) {
						if (eObjectDescription.getEObjectURI().equals(eObjectURI)) {
							return globalDescriptionsLabelProvider.getText(eObjectDescription);
						}
					}
				}
				return "unknown";
			}

			public Image getImage(Object element) {
				IReferenceDescription referenceDescription = (IReferenceDescription) element;
				URI containerEObjectURI = referenceDescription.getContainerEObjectURI();
				final URI eObjectURI = (containerEObjectURI == null) ? referenceDescription.getSourceEObjectUri()
						: containerEObjectURI;
				IResourceDescription resourceDescription = resourceDescriptions.getResourceDescription(eObjectURI
						.trimFragment());
				if (resourceDescription != null) {
					for (IEObjectDescription eObjectDescription : resourceDescription.getExportedObjects()) {
						if (eObjectDescription.getEObjectURI().equals(eObjectURI)) {
							return globalDescriptionsLabelProvider.getImage(eObjectDescription);
						}
					}
				}
				return null;
			}
		};
	}

	public void showMatch(Match match, int currentOffset, int currentLength, boolean activate) {
		Object o = match.getElement();
		if (o instanceof IReferenceDescription) {
			IReferenceDescription descr = (IReferenceDescription) o;
			if (activate) {
				uriEditorOpener.open(descr.getSourceEObjectUri(), descr.getEReference(), descr.getIndexInList(),
						true);
			}
		}
	}
}