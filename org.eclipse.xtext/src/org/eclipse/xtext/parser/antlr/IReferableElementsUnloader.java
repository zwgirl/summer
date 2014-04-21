/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.parser.antlr;

import static com.google.common.collect.Lists.*;

import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.util.Pair;
import org.eclipse.xtext.util.Tuples;

import com.google.inject.ImplementedBy;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * @author Jan Koehnlein
 */
@ImplementedBy(IReferableElementsUnloader.NullUnloader.class)
public interface IReferableElementsUnloader {

	void unloadRoot(EObject root);

	final class NullUnloader implements IReferableElementsUnloader {

		public void unloadRoot(EObject root) {
			// do nothing
		}

	}

	class GenericUnloader implements IReferableElementsUnloader {

		public void unloadRoot(EObject root) {
			// Content adapters should be removed the same way as they are added: top-down. 
			// Fragments are recursive, so we need them to be calculated before proxifying the container.
			// OTOH, some model elements resolve their children when being proxified (e.g. EPackageImpl).
			// => first calculate all fragments, then proxify elements starting form root.
			List<Pair<EObject, URI>> elementsToUnload = newArrayList();
			elementsToUnload.add(Tuples.create(root, EcoreUtil.getURI(root)));
			root.eAdapters().clear();
			for (Iterator<EObject> i = EcoreUtil.getAllProperContents(root, false); i.hasNext();) {
				EObject element = i.next();
				elementsToUnload.add(Tuples.create(element, EcoreUtil.getURI(element)));
				element.eAdapters().clear();
			}
			for (Pair<EObject,URI> elementToUnload : elementsToUnload) {
				((InternalEObject) elementToUnload.getFirst()).eSetProxyURI(elementToUnload.getSecond());
			}
		}
	}

}
