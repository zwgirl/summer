/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.summer.ss.core.typing;

import static com.google.common.collect.Iterables.*;
import static java.util.Collections.*;

import java.util.List;
import java.util.Set;

import org.summer.ss.core.jvmmodel.IXtendJvmAssociations;
import org.summer.dsl.model.types.JvmDeclaredType;
import org.summer.dsl.model.types.JvmFeature;
import org.summer.dsl.model.types.JvmOperation;
import org.summer.dsl.model.types.JvmTypeParameter;
import org.summer.dsl.model.types.JvmTypeParameterDeclarator;
import org.summer.dsl.model.types.JvmTypeReference;
import org.summer.dsl.model.types.JvmVisibility;
import org.summer.dsl.model.types.util.FeatureOverridesService;
import org.summer.dsl.model.types.util.ITypeArgumentContext;
import org.summer.dsl.model.types.util.SuperTypeCollector;
import org.summer.dsl.model.types.util.TypeArgumentContextProvider;
import org.summer.dsl.model.types.util.TypeReferences;

import com.google.common.base.Function;
import com.google.common.collect.Lists;
import com.google.inject.Inject;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
@Deprecated
public class XtendOverridesService {
	
	@Inject
	private IXtendJvmAssociations xtendjvmAssociations;

	@Inject
	private FeatureOverridesService featureOverridesService;
	
	@Inject
	private TypeArgumentContextProvider typeArgumentContextProvider;
	
	@Inject
	private TypeReferences typeReferences;
	
	@Inject
	private SuperTypeCollector superTypeCollector;
	
//	public JvmOperation findOverriddenOperation(XtendFunction function) {
//		JvmOperation inferredOperation = xtendjvmAssociations.getDirectlyInferredOperation(function);
//		if (inferredOperation == null)
//			return null;
//		return findOverriddenOperation(inferredOperation);
//	}

	public JvmOperation findOverriddenOperation(JvmOperation operation) {
		final JvmTypeReference typeRef = typeReferences.createTypeRef(operation.getDeclaringType());
		ITypeArgumentContext typeArgumentContext = typeArgumentContextProvider.getTypeArgumentContext(
				new TypeArgumentContextProvider.ReceiverRequest(typeRef));
		for (JvmOperation superOperation : allSuperOperations(operation.getDeclaringType())) {
			if (superOperation.getVisibility() != JvmVisibility.PRIVATE) {
				if (featureOverridesService.isOverridden(operation, superOperation, typeArgumentContext,
						false)) {
					return superOperation;
				}
			}
		}
		return null;
	}
	
	protected Iterable<JvmOperation> allSuperOperations(final JvmDeclaredType type) {
		Set<JvmTypeReference> superTypes = superTypeCollector.collectSuperTypes(type);
		if (superTypes.isEmpty())
			superTypes.add(typeReferences.getTypeForName(Object.class, type));
		Iterable<JvmOperation> result = filter(concat(transform(
			superTypes, new Function<JvmTypeReference, Iterable<JvmFeature>>() {
				public Iterable<JvmFeature> apply(JvmTypeReference from) {
					if (from == null || from.getType() == null)
						return emptyList();
					return ((JvmDeclaredType)from.getType()).getAllFeatures();
				}
			})), JvmOperation.class);
		return result;
	}
	
//	public JvmTypeReference getOverriddenReturnType(XtendFunction func) {
//		final JvmOperation operation = findOverriddenOperation(func);
//		if (operation==null)
//			return null;
//		final JvmTypeReference overriddenReturnType = operation.getReturnType();
//		final JvmOperation inferredOperation = xtendjvmAssociations.getDirectlyInferredOperation(func);
//		ITypeArgumentContext typeArgumentContext = typeArgumentContextProvider.getTypeArgumentContext(new TypeArgumentContextProvider.AbstractRequest() {
//			@Override
//			public JvmTypeParameterDeclarator getNearestDeclarator() {
//				return inferredOperation;
//			}
//			@Override
//			public JvmTypeReference getReceiverType() {
//				return typeReferences.createTypeRef(inferredOperation.getDeclaringType());
//			}
//			@Override
//			public JvmFeature getFeature() {
//				return operation;
//			}
//			@Override
//			public List<JvmTypeReference> getExplicitTypeArgument() {
//				List<JvmTypeParameter> parameters = inferredOperation.getTypeParameters();
//				List<JvmTypeReference> result = Lists.newArrayList();
//				for(JvmTypeParameter typeParameter: parameters) {
//					result.add(typeReferences.createTypeRef(typeParameter));
//				}
//				return result;
//			}
//		});
//		JvmTypeReference resolved = typeArgumentContext.resolve(overriddenReturnType);
//		return resolved;
//	}
}
