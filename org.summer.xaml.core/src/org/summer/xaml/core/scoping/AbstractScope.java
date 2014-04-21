/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.summer.xaml.core.scoping;

import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.summer.dsl.model.types.JvmType;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.IScope;

import com.google.common.collect.Lists;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public abstract class AbstractScope implements IScope {

	public IEObjectDescription getSingleElement(QualifiedName name) {
		throw new UnsupportedOperationException();
	}

	public Iterable<IEObjectDescription> getElements(QualifiedName name) {
		throw new UnsupportedOperationException();
	}

	public IEObjectDescription getSingleElement(EObject object) {
		Iterator<IEObjectDescription> elements = getElements(object).iterator();
		if (elements.hasNext()) {
			IEObjectDescription result = elements.next();
			String resultName = result.getName().toString();
			while(elements.hasNext()) {
				IEObjectDescription candidate = elements.next();
				String candidateName = candidate.getName().toString();
				if (candidateName.length() < resultName.length()) {
					result = candidate;
					resultName = candidateName;
				} else if (candidateName.length() == resultName.length()) {
					// prefer '.' over '$'
					if (candidate.getQualifiedName().getSegmentCount() > result.getQualifiedName().getSegmentCount()) {
						result = candidate;
						resultName = candidateName;
					}
				}
			}
			return result;
		}
		return null;
	}

	public final Iterable<IEObjectDescription> getElements(EObject object) {
		if (!(object instanceof JvmType) || object.eIsProxy()) {
			throw new IllegalArgumentException(String.valueOf(object));
		}
		List<IEObjectDescription> result = Lists.newLinkedList();
		doGetElements((JvmType) object, result);
		Iterator<IEObjectDescription> iterator = result.iterator();
		while(iterator.hasNext()) {
			IEObjectDescription description = iterator.next();
			IEObjectDescription lookUp = getSingleElement(description.getName());
			if (lookUp == null || lookUp.getEObjectOrProxy() != object) {
				iterator.remove();
			}
		}
		return result;
	}

	protected abstract void doGetElements(JvmType type, List<IEObjectDescription> result);

	public Iterable<IEObjectDescription> getAllElements() {
		throw new UnsupportedOperationException();
	}

}
