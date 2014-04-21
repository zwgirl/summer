/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.summer.dsl.xbase.ui.jvmmodel.findrefs;

import static com.google.common.collect.Iterables.*;
import static com.google.common.collect.Lists.*;
import static java.util.Collections.*;

import java.util.List;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.core.IJavaElement;
import org.summer.dsl.model.types.JvmIdentifiableElement;
import org.summer.dsl.model.types.TypesPackage;
import org.summer.dsl.model.types.util.jdt.IJavaElementFinder;
import org.eclipse.xtext.ui.editor.findrefs.FindReferencesHandler;
import org.eclipse.xtext.ui.editor.findrefs.ReferenceQueryExecutor;
import org.summer.dsl.xbase.jvmmodel.IJvmModelAssociations;

import com.google.inject.Inject;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public class JvmModelFindReferenceHandler extends FindReferencesHandler {

	@Inject
	private IJvmModelAssociations associations;

	@Inject
	private IJavaElementFinder javaElementFinder;

	@Inject
	private JdtReferenceFinder jdtReferenceFinder;

	@Override
	protected void findReferences(EObject target) {
		ReferenceQueryExecutor queryExecutor = getQueryExecutor(target);
		if (queryExecutor != null) {
			Iterable<IJavaElement> javaElements = getJavaElements(target);
			if (size(javaElements) > 0) {
				jdtReferenceFinder.run(queryExecutor.getLabel(target), javaElements);
			} else {
				queryExecutor.execute();
			}
		}
	}

	public Iterable<IJavaElement> getJavaElements(EObject target) {
		Set<EObject> jvmElements;
		if(isJvmElement(target))
			jvmElements = singleton(target);
		else 
			jvmElements = associations.getJvmElements(target);
		if (!jvmElements.isEmpty()) {
			List<IJavaElement> javaElements = newArrayList();
			for (EObject jvmElement : jvmElements) {
				if (jvmElement instanceof JvmIdentifiableElement) {
					IJavaElement javaElement = javaElementFinder
							.findExactElementFor((JvmIdentifiableElement) jvmElement);
					if (javaElement != null)
						javaElements.add(javaElement);
				}
			}
			return javaElements;
		}
		return emptyList();
	}

	protected boolean isJvmElement(EObject target) {
		return target.eClass().getEPackage() == TypesPackage.eINSTANCE; 
	}
}
