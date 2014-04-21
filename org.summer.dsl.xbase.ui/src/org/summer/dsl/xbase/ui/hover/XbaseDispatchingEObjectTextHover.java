/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.summer.dsl.xbase.ui.hover;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.internal.ui.text.JavaWordFinder;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.ITextViewer;
import org.eclipse.jface.text.Region;
import org.summer.dsl.model.types.JvmExecutable;
import org.summer.dsl.model.types.JvmField;
import org.summer.dsl.model.types.JvmIdentifiableElement;
import org.eclipse.xtext.resource.EObjectAtOffsetHelper;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.hover.DispatchingEObjectTextHover;
import org.eclipse.xtext.ui.editor.model.IXtextDocument;
import org.eclipse.xtext.ui.editor.model.XtextDocumentUtil;
import org.eclipse.xtext.util.Pair;
import org.eclipse.xtext.util.Tuples;
import org.summer.dsl.model.xbase.XAbstractFeatureCall;
import org.summer.dsl.model.xbase.XConstructorCall;

import com.google.inject.Inject;

/**
 * @author Holger Schill - Initial contribution and API
 * @since 2.3
 */
public class XbaseDispatchingEObjectTextHover extends DispatchingEObjectTextHover {
	
	@Inject
	private EObjectAtOffsetHelper eObjectAtOffsetHelper;
	
	@Override
	public IRegion getHoverRegion(ITextViewer textViewer, int offset) {
		IXtextDocument xtextDocument = XtextDocumentUtil.get(textViewer);
		if(xtextDocument == null || offset<0 || xtextDocument.getLength() < offset) 
			return null;
		IRegion word = JavaWordFinder.findWord(xtextDocument, offset);
		if (word!= null)
			return word;
		//TODO return null for non-operators.
		return new Region(offset, 0);
	}

	@Override
	protected Pair<EObject, IRegion> getXtextElementAt(XtextResource resource, int offset) {
		Pair<EObject, IRegion> original = super.getXtextElementAt(resource, offset);
		EObject object = eObjectAtOffsetHelper.resolveContainedElementAt(resource, offset);
		if (object != null && object instanceof XAbstractFeatureCall){
			JvmIdentifiableElement feature = ((XAbstractFeatureCall) object).getFeature();
			if(feature instanceof JvmExecutable || feature instanceof JvmField || object instanceof XConstructorCall)
					if (original != null)
						return Tuples.create(object, original.getSecond());
		}
		return original;
	}
}
