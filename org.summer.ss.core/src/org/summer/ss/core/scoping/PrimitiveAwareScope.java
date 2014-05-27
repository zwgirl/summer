/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.summer.ss.core.scoping;

import java.util.List;

import org.summer.dsl.model.types.JvmPrimitiveType;
import org.summer.dsl.model.types.JvmType;
import org.summer.dsl.model.types.JvmVoid;
import org.summer.dsl.model.types.access.impl.Primitives;
import org.summer.dsl.model.types.xtext.AbstractTypeScope;
import org.summer.dsl.xbase.scoping.AbstractScope;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.EObjectDescription;
import org.eclipse.xtext.resource.IEObjectDescription;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class PrimitiveAwareScope extends AbstractScope {

	private AbstractTypeScope typeScope;
	private AbstractScope parent;

	protected PrimitiveAwareScope(AbstractScope parent, AbstractTypeScope typeScope) {
		this.parent = parent;
		this.typeScope = typeScope;
	}
	
	@Override
	public IEObjectDescription getSingleElement(QualifiedName name) {
		if (isPrimitive(name)) {
			return typeScope.getSingleElement(name, true);
		}
		return parent.getSingleElement(name);
	}
	
	protected boolean isPrimitive(QualifiedName name) {
		return name.getSegmentCount() == 1 && Primitives.forName(name.getFirstSegment()) != null;
	}
	
	@Override
	public void doGetElements(JvmType type, List<IEObjectDescription> result) {
		if (type instanceof JvmVoid) {
			result.add(EObjectDescription.create("void", type));
			return;
		}
		if (type instanceof JvmPrimitiveType) {
			result.add(EObjectDescription.create(((JvmPrimitiveType) type).getSimpleName(), type));
			return;
		}
		parent.doGetElements(type, result);
	}
	
}