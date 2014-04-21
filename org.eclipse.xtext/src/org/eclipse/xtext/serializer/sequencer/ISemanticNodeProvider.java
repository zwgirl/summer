/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.serializer.sequencer;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.INode;

import com.google.inject.ImplementedBy;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
@ImplementedBy(SemanticNodeProvider.class)
public interface ISemanticNodeProvider {

	public interface INodesForEObjectProvider {
		INode getNodeForMultiValue(EStructuralFeature feature, int indexInFeature, int indexInNonTransient, Object value);

		INode getNodeForSingelValue(EStructuralFeature feature, Object value);
	}

	public class NullNodesForEObjectProvider implements INodesForEObjectProvider {
		public INode getNodeForMultiValue(EStructuralFeature feature, int indexInFeature, int indexAmongNonTransient,
				Object value) {
			return null;
		}

		public INode getNodeForSingelValue(EStructuralFeature feature, Object value) {
			return null;
		}
	}

	public INodesForEObjectProvider NULL_NODES_PROVIDER = new NullNodesForEObjectProvider();

	INodesForEObjectProvider getNodesForSemanticObject(EObject semanticObject, ICompositeNode suggestedComposite);

}