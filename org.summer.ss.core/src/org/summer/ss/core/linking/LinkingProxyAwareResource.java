/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.summer.ss.core.linking;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.util.Triple;
import org.eclipse.xtext.util.Tuples;
import org.summer.dsl.xbase.resource.BatchLinkableResource;

import com.google.common.collect.Lists;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class LinkingProxyAwareResource extends BatchLinkableResource {

	private List<Triple<EObject, EReference, INode>> uris = Lists.newArrayList();
	
	public LinkingProxyAwareResource(){
		System.out.println("LinkingProxyAwareResource constructor!");
	}
	
	int registerEncodedURI(EObject object, EReference reference, INode node) {
		uris.add(Tuples.create(object, reference, node));
		return uris.size() - 1;
	}
	
	public Triple<EObject, EReference, INode> getEncodedURI(int idx) {
//		if(idx >= uris.size()){
//			System.out.println("index error: " +idx);
//			return null;
//		}
		return uris.get(idx);
	}
	
	void clearEncodeURIs() {
		System.out.println("LinkingProxyAwareResource:" + getURI() +", clearEncodeURIs!");
		uris = Lists.newArrayListWithCapacity(uris.size());
	}
	
}
