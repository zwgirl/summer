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
import java.util.Iterator;
import java.util.List;

import org.summer.dsl.model.types.JvmDeclaredType;
import org.summer.dsl.model.types.JvmMember;
import org.summer.dsl.model.types.JvmType;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.EObjectDescription;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.util.Strings;
import org.summer.dsl.model.xbase.XAbstractFeatureCall;
import org.summer.dsl.xbase.typesystem.references.LightweightTypeReference;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class NestedTypeLiteralScope extends AbstractSessionBasedScope {

	private final JvmType outerType;
	private final LightweightTypeReference receiverType;

	protected NestedTypeLiteralScope(IScope parent, IFeatureScopeSession session, XAbstractFeatureCall featureCall, LightweightTypeReference receiverType, JvmType outerType) {
		super(parent, session, featureCall);
		this.outerType = outerType;
		this.receiverType = receiverType;
	}

	@Override
	protected Collection<IEObjectDescription> getLocalElementsByName(QualifiedName name) {
		XAbstractFeatureCall featureCall = getFeatureCall();
		if (featureCall.isExplicitOperationCallOrBuilderSyntax())
			return Collections.emptyList();
		if (outerType instanceof JvmDeclaredType && name.getSegmentCount() == 1) {
			String singleSegment = name.getFirstSegment();
			List<String> lookup = Collections.singletonList(singleSegment);
			if (singleSegment.indexOf('$') != -1) {
				lookup = Strings.split(singleSegment, '$');
			}
			JvmType result = findNestedType((JvmDeclaredType)outerType, lookup.iterator());
			if (result != null) {
				IEObjectDescription description = EObjectDescription.create(name, result);
				return Collections.<IEObjectDescription>singletonList(new TypeLiteralDescription(description, receiverType, isVisible(result)));
			}
		}
		return Collections.emptyList();
	}
	
	protected JvmType findNestedType(JvmDeclaredType outerType, Iterator<String> iterator) {
		String current = iterator.next();
		for(JvmMember member: outerType.getMembers()) {
			if (member instanceof JvmDeclaredType && member.getSimpleName().equals(current)) {
				if (iterator.hasNext()) {
					return findNestedType((JvmDeclaredType) member, iterator);
				}
				return (JvmDeclaredType) member;
			}
		}
		return null;
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
