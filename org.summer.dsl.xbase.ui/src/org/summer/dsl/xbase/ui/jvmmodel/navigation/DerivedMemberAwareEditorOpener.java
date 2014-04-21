/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.summer.dsl.xbase.ui.jvmmodel.navigation;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jdt.core.IMember;
import org.eclipse.ui.IEditorPart;
import org.summer.dsl.model.types.JvmIdentifiableElement;
import org.summer.dsl.model.types.JvmMember;
import org.summer.dsl.model.types.access.jdt.TypeURIHelper;
import org.summer.dsl.model.ui.navigation.IDerivedMemberAwareEditorOpener;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.LanguageSpecificURIEditorOpener;
import org.summer.dsl.xbase.jvmmodel.IJvmModelAssociations;

import com.google.inject.Inject;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class DerivedMemberAwareEditorOpener extends LanguageSpecificURIEditorOpener implements IDerivedMemberAwareEditorOpener{

	@Inject
	private IJvmModelAssociations associations;
	
	public IEditorPart open(URI uri, IMember member, boolean select) {
		if (member != null) {
			URI memberURI = new TypeURIHelper().getFullURI(member);
			String identifier = memberURI.fragment();
			URI uriWithQuery = uri.appendQuery(identifier);
			super.open(uriWithQuery, select);
		}
		return open(uri, select);
	}
	
	@Override
	protected EObject findEObjectByURI(URI uri, XtextResource resource) {
		if (uri.query() != null) {
			String identifier = uri.query();
			TreeIterator<EObject> contents = EcoreUtil.<EObject>getAllContents(resource, true);
			while(contents.hasNext()) {
				EObject content = contents.next();
				if (content instanceof JvmMember) {
					String identifierFromResource = ((JvmIdentifiableElement) content).getIdentifier();
					if (identifier.equals(identifierFromResource)) {
						EObject sourceElement = associations.getPrimarySourceElement(content);
						return sourceElement;
					}
				}
			}
		}
		return super.findEObjectByURI(uri, resource);
	}

}
