/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.summer.dsl.xbase.scoping.batch;

import java.util.Collection;
import java.util.Collections;

import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.IScope;
import org.summer.dsl.model.xbase.XAbstractFeatureCall;
import org.summer.dsl.model.xbase.XAssignment;
import org.summer.dsl.model.xbase.XFeatureCall;

import com.google.common.collect.Iterables;
import com.google.inject.Provider;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class LocalVariableScope extends AbstractSessionBasedScope {
	
	public LocalVariableScope(IScope parent, IFeatureScopeSession session, XAbstractFeatureCall featureCall) {
		super(parent, session, featureCall);
	}
	
	@Override
	protected Iterable<IEObjectDescription> getAllLocalElements() {
		return getSession().getLocalElements();
	}
	
	@Override
	protected Collection<IEObjectDescription> getLocalElementsByName(QualifiedName name) {
		if (canBeLocalVariable())
			return Collections.emptyList();
		IEObjectDescription element = getSession().getLocalElement(name);
		if (element == null)
			return Collections.emptyList();
		return Collections.singletonList(element);
	}

	protected boolean canBeLocalVariable() {
		return !looksLikeLocalVariable() && !(getFeatureCall() instanceof XAssignment);
	}
	
	protected boolean looksLikeLocalVariable() {
		XAbstractFeatureCall featureCall = getFeatureCall();
		if (featureCall instanceof XFeatureCall) {
			boolean result = !featureCall.isExplicitOperationCallOrBuilderSyntax() && featureCall.getTypeArguments().isEmpty();
			return result;
		}
		return false;
	}
	
	@Override
	public Iterable<IEObjectDescription> getElements(final QualifiedName name) {
		Collection<IEObjectDescription> localElements = getLocalElementsByName(name);
		if (localElements.isEmpty())
			return getParent().getElements(name);
		if (looksLikeLocalVariable()) {
			return localElements;
		}
		Iterable<IEObjectDescription> parentElements = getParentElements(new Provider<Iterable<IEObjectDescription>>() {
			public Iterable<IEObjectDescription> get() {
				return getParent().getElements(name);
			}
		});
		// TODO evaluate optimizing this by avoiding the concat thing and doing something smarter than the ParentIterable 
		Iterable<IEObjectDescription> result = Iterables.concat(localElements, parentElements);
		return result;
	}
	
	@Override
	protected boolean isShadowed(IEObjectDescription fromParent) {
		if (getShadowingKey(fromParent).equals(fromParent.getName().toString())) {
			boolean result = getSession().getLocalElement(fromParent.getName()) != null;
			return result;
		}
		return false;
	}

}
