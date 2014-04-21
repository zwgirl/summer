/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.scoping.impl;

import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.ISelectable;

import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import com.google.common.collect.LinkedHashMultimap;
import com.google.common.collect.Lists;
import com.google.common.collect.Multimap;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class MultimapBasedSelectable implements ISelectable {

	private Multimap<QualifiedName, IEObjectDescription> nameToObjects;
	private List<IEObjectDescription> allDescriptions;
	
	public MultimapBasedSelectable(Iterable<IEObjectDescription> allDescriptions) {
		setExportedObjects(allDescriptions);
	}
	
	public boolean isEmpty() {
		return allDescriptions.isEmpty();
	}
	
	public Iterable<IEObjectDescription> getExportedObjectsByType(final EClass type) {
		if (allDescriptions.isEmpty())
			return Collections.emptyList();
		return Iterables.filter(allDescriptions, new Predicate<IEObjectDescription>() {
			public boolean apply(IEObjectDescription input) {
				return EcoreUtil2.isAssignableFrom(type, input.getEClass());
			}
		});
	}
	
	public Iterable<IEObjectDescription> getExportedObjectsByObject(final EObject object) {
		if (allDescriptions.isEmpty())
			return Collections.emptyList();
		final URI uri = EcoreUtil2.getPlatformResourceOrNormalizedURI(object);
		return Iterables.filter(allDescriptions, new Predicate<IEObjectDescription>() {
			public boolean apply(IEObjectDescription input) {
				if (input.getEObjectOrProxy() == object)
					return true;
				if (uri.equals(input.getEObjectURI())) {
					return true;
				}
				return false;
			}
		});
	}
	
	public Iterable<IEObjectDescription> getExportedObjects(final EClass type, final QualifiedName name, boolean ignoreCase) {
		if (allDescriptions.isEmpty())
			return Collections.emptyList();
		QualifiedName lowerCase = name.toLowerCase();
		if (nameToObjects.containsKey(lowerCase)) {
			Predicate<IEObjectDescription> predicate = ignoreCase 
				?	new Predicate<IEObjectDescription>() {
						public boolean apply(IEObjectDescription input) {
							return EcoreUtil2.isAssignableFrom(type, input.getEClass());
						}
					}
				:	new Predicate<IEObjectDescription>() {
					public boolean apply(IEObjectDescription input) {
						return name.equals(input.getName()) && EcoreUtil2.isAssignableFrom(type, input.getEClass());
					}
				};
			return Iterables.filter(nameToObjects.get(lowerCase), predicate);
		} else
			return Collections.emptyList();
	}
	
	public Iterable<IEObjectDescription> getExportedObjects() {
		return allDescriptions;
	}

	public void setExportedObjects(Iterable<IEObjectDescription> allDescriptions) {
		this.allDescriptions = Lists.newArrayList();
		this.nameToObjects = LinkedHashMultimap.create(); 
		for(IEObjectDescription description: allDescriptions) {
			this.allDescriptions.add(description);
			nameToObjects.put(description.getName().toLowerCase(), description);
		}
	}

}
