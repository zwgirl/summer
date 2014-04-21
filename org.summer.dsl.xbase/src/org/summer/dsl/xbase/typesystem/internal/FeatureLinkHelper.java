/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.summer.dsl.xbase.typesystem.internal;

import java.util.Collections;
import java.util.List;

import org.eclipse.jdt.annotation.NonNullByDefault;
import org.eclipse.jdt.annotation.Nullable;
import org.summer.dsl.model.types.JvmConstructor;
import org.summer.dsl.model.types.JvmDeclaredType;
import org.summer.dsl.model.types.JvmIdentifiableElement;
import org.summer.dsl.model.types.JvmMember;
import org.summer.dsl.model.types.JvmTypeParameter;
import org.summer.dsl.model.types.JvmTypeParameterDeclarator;
import org.summer.dsl.model.xbase.XAbstractFeatureCall;
import org.summer.dsl.model.xbase.XAssignment;
import org.summer.dsl.model.xbase.XBinaryOperation;
import org.summer.dsl.model.xbase.XExpression;
import org.summer.dsl.model.xbase.XFeatureCall;
import org.summer.dsl.model.xbase.XMemberFeatureCall;
import org.summer.dsl.model.xbase.XUnaryOperation;
import org.summer.dsl.xbase.typesystem.references.LightweightTypeReference;
import org.summer.dsl.xbase.typesystem.references.ParameterizedTypeReference;

import com.google.common.collect.Lists;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@NonNullByDefault
public class FeatureLinkHelper {
	
	@Nullable
	public XExpression getSyntacticReceiver(XExpression expression) {
		if (expression instanceof XAbstractFeatureCall) {
			if (expression instanceof XFeatureCall) {
				return null;
			}
			if (expression instanceof XMemberFeatureCall) {
				return ((XMemberFeatureCall) expression).getMemberCallTarget();
			}
			if (expression instanceof XAssignment) {
				return ((XAssignment) expression).getAssignable();
			}
			if (expression instanceof XBinaryOperation) {
				return ((XBinaryOperation) expression).getLeftOperand();
			}
			if (expression instanceof XUnaryOperation) {
				return ((XUnaryOperation) expression).getOperand();
			}
		}
		return null;
	}

	public List<XExpression> getSyntacticArguments(XAbstractFeatureCall expression) {
		if (expression instanceof XFeatureCall) {
			return ((XFeatureCall) expression).getFeatureCallArguments();
		}
		if (expression instanceof XMemberFeatureCall) {
			return ((XMemberFeatureCall) expression).getMemberCallArguments();
		}
		if (expression instanceof XAssignment) {
			return Collections.singletonList(((XAssignment) expression).getValue());
		}
		if (expression instanceof XBinaryOperation) {
			return Collections.singletonList(((XBinaryOperation) expression).getRightOperand());
		}
		// explicit condition to make sure we thought about it
		if (expression instanceof XUnaryOperation) {
			return Collections.emptyList();
		}
		return Collections.emptyList();
	}
	
	public List<JvmTypeParameter> getDeclaredTypeParameters(JvmConstructor constructor) {
		List<JvmTypeParameter> constructorTypeParameters = constructor.getTypeParameters();
		if (constructorTypeParameters.isEmpty()) {
			JvmDeclaredType createdType = constructor.getDeclaringType();
			if (createdType instanceof JvmTypeParameterDeclarator) {
				return ((JvmTypeParameterDeclarator) createdType).getTypeParameters();
			}
		} else {
			JvmDeclaredType createdType = constructor.getDeclaringType();
			if (createdType instanceof JvmTypeParameterDeclarator) {
				List<JvmTypeParameter> typeParameters = ((JvmTypeParameterDeclarator) createdType).getTypeParameters();
				if (typeParameters.isEmpty()) {
					return constructorTypeParameters;
				}
				List<JvmTypeParameter> result = Lists.newArrayList(constructorTypeParameters);
				result.addAll(typeParameters);
				return result;
			}
			return constructorTypeParameters;
		}
		return Collections.emptyList();
	}
	
	@Nullable
	public LightweightTypeReference getExpectedReceiverType(JvmIdentifiableElement linkedFeature, LightweightTypeReference receiverType) {
		if (receiverType.isMultiType() && linkedFeature instanceof JvmMember) {
			ParameterizedTypeReference declaratorReference = new ParameterizedTypeReference(receiverType.getOwner(), ((JvmMember) linkedFeature).getDeclaringType());
			if (!declaratorReference.isAssignableFrom(receiverType.toJavaType())) {
				for(LightweightTypeReference multiTypeComponent: receiverType.getMultiTypeComponents()) {
					if (declaratorReference.isAssignableFrom(multiTypeComponent)) {
						return multiTypeComponent;
					}
				}
			}
		} else if (receiverType.isSynonym() && linkedFeature instanceof JvmMember) {
			List<LightweightTypeReference> components = receiverType.getMultiTypeComponents();
			return components.get(components.size() - 1);
		}
		return receiverType;
	}
	
}
