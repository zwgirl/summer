/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.summer.ss.core.scoping;

import java.util.Collections;
import java.util.List;

import org.summer.dsl.model.types.JvmType;
import org.summer.dsl.model.types.JvmTypeParameter;
import org.summer.dsl.xbase.scoping.AbstractScope;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.EObjectDescription;
import org.eclipse.xtext.resource.IEObjectDescription;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class TypeParameterScope extends AbstractScope {

	private final AbstractScope parent;
	private final List<List<JvmTypeParameter>> typeParameters;

	public TypeParameterScope(List<List<JvmTypeParameter>> typeParameters, AbstractScope parent) {
		this.typeParameters = typeParameters;
		this.parent = parent;
	}

	@Override
	public IEObjectDescription getSingleElement(QualifiedName name) {
		IEObjectDescription result = doGetSingleElement(name);
		if (result != null)
			return result;
		return parent.getSingleElement(name);
	}

	protected IEObjectDescription doGetSingleElement(QualifiedName name) {
		if (name.getSegmentCount() == 1) {
			String singleSegment = name.getFirstSegment();
			for(int i = 0; i < typeParameters.size(); i++) {
				List<JvmTypeParameter> chunk = typeParameters.get(i);
				for(int j = 0; j < chunk.size(); j++) {
					JvmTypeParameter candidate = chunk.get(j);
					if (singleSegment.equals(candidate.getSimpleName())) {
						return EObjectDescription.create(name, candidate);
					}	
				}
			}
		}
		return null;
	}
	
	@Override
	public Iterable<IEObjectDescription> getElements(QualifiedName name) {
		IEObjectDescription result = doGetSingleElement(name);
		if (result != null)
			return Collections.singletonList(result);
		return parent.getElements(name);
	}
	
	@Override
	public void doGetElements(JvmType type, List<IEObjectDescription> result) {
		if (type instanceof JvmTypeParameter) {
			JvmTypeParameter casted = (JvmTypeParameter) type;
			QualifiedName name = QualifiedName.create(casted.getSimpleName());
			IEObjectDescription candidate = doGetSingleElement(name);
			if (candidate != null) {
				if (candidate.getEObjectOrProxy() == type) {
					result.add(candidate);
				}
			}
			return;
		}
		parent.doGetElements(type, result);
	}
}
