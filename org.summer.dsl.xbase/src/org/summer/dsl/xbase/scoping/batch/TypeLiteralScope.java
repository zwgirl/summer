/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.summer.dsl.xbase.scoping.batch;

import java.util.Collection;
import java.util.Collections;

import org.eclipse.emf.ecore.EObject;
import org.summer.dsl.model.types.JvmMember;
import org.summer.dsl.model.types.JvmType;
import org.summer.dsl.model.types.TypesPackage;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.IScope;
import org.summer.dsl.model.xbase.XAbstractFeatureCall;
import org.summer.dsl.xbase.typesystem.IResolvedTypes;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class TypeLiteralScope extends AbstractSessionBasedScope {

	private final QualifiedName parentSegments;
	private final IResolvedTypes resolvedTypes;

	protected TypeLiteralScope(IScope parent, IFeatureScopeSession session, XAbstractFeatureCall featureCall, IResolvedTypes resolvedTypes, QualifiedName parentSegments) {
		super(parent, session, featureCall);
		this.resolvedTypes = resolvedTypes;
		this.parentSegments = parentSegments;
	}

	@Override
	protected Collection<IEObjectDescription> getLocalElementsByName(QualifiedName name) {
		XAbstractFeatureCall featureCall = getFeatureCall();
		if (featureCall.isExplicitOperationCallOrBuilderSyntax())
			return Collections.emptyList();
		QualifiedName fqn = parentSegments.append(name);
		IScope typeScope = getSession().getScope(getFeatureCall(), TypesPackage.Literals.JVM_PARAMETERIZED_TYPE_REFERENCE__TYPE, resolvedTypes);
		IEObjectDescription typeDescription = typeScope.getSingleElement(fqn);
		if (typeDescription != null) {
			EObject type = typeDescription.getEObjectOrProxy();
			if (type instanceof JvmType)  
				return Collections.<IEObjectDescription>singletonList(new TypeLiteralDescription(typeDescription, isVisible((JvmType) type)));
		}
		return Collections.emptyList();
	}
	
	@Override
	protected boolean isShadowed(IEObjectDescription fromParent) {
		if (fromParent.getName() == null)
			return true;
		return super.isShadowed(fromParent);
	}

	protected boolean isVisible(JvmType type) {
		if (type instanceof JvmMember)
			return getSession().isVisible((JvmMember) type);
		return true; // primitives et. al
	}

	@Override
	protected Iterable<IEObjectDescription> getAllLocalElements() {
		return Collections.emptyList();
	}

}
