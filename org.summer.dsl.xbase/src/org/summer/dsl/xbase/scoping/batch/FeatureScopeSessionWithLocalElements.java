/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.summer.dsl.xbase.scoping.batch;

import java.util.List;
import java.util.Map;

import org.eclipse.jdt.annotation.NonNullByDefault;
import org.eclipse.jdt.annotation.Nullable;
import org.summer.dsl.model.types.JvmIdentifiableElement;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.EObjectDescription;
import org.eclipse.xtext.resource.IEObjectDescription;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@NonNullByDefault
public class FeatureScopeSessionWithLocalElements extends AbstractNestedFeatureScopeSession {

	private final Map<QualifiedName, JvmIdentifiableElement> map;

	public FeatureScopeSessionWithLocalElements(AbstractFeatureScopeSession parent, Map<QualifiedName, JvmIdentifiableElement> map) {
		super(parent);
		this.map = map;
	}
	
	@Nullable
	@Override
	public IEObjectDescription getLocalElement(QualifiedName name) {
		JvmIdentifiableElement result = map.get(name);
		if (result != null)
			return EObjectDescription.create(name, result);
		return super.getLocalElement(name);
	}

	@Override
	protected void addLocalElements(List<IEObjectDescription> result) {
		for(Map.Entry<QualifiedName, JvmIdentifiableElement> entry: map.entrySet()) {
			result.add(EObjectDescription.create(entry.getKey(), entry.getValue()));
		}
		super.addLocalElements(result);
	}
}
