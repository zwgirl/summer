/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.summer.dsl.model.types.util;

import java.lang.annotation.Annotation;

import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.xtext.EcoreUtil2;
import org.summer.dsl.model.types.JvmAnnotationReference;
import org.summer.dsl.model.types.JvmAnnotationTarget;
import org.summer.dsl.model.types.JvmAnnotationType;
import org.summer.dsl.model.types.JvmType;
import org.summer.dsl.model.types.TypesFactory;
import org.summer.dsl.model.types.TypesPackage;
import org.summer.dsl.model.types.access.IJvmTypeProvider;

import com.google.common.annotations.Beta;
import com.google.inject.Inject;
import com.google.inject.Singleton;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@Beta
@Singleton
public class AnnotationLookup {

	@Inject
	private IJvmTypeProvider.Factory typeProviderFactory;
	
	@Inject
	private TypesFactory typesFactory;
	
	@Nullable
	public JvmAnnotationReference findAnnotation(@NonNull JvmAnnotationTarget annotationTarget, @NonNull Class<? extends Annotation> lookupType) {
		// avoid creating an empty list for all given targets but check for #eIsSet first
		if (annotationTarget.eIsSet(TypesPackage.Literals.JVM_ANNOTATION_TARGET__ANNOTATIONS)) {
			for(JvmAnnotationReference annotation: annotationTarget.getAnnotations()) {
				JvmAnnotationType annotationType = annotation.getAnnotation();
				if (annotationType != null && lookupType.getCanonicalName().equals(annotationType.getQualifiedName())) {
					return annotation;
				}
			}
		}
		return null;
	}
	

	@Nullable
	public JvmAnnotationReference removeAnnotation(@NonNull JvmAnnotationTarget annotationTarget, @NonNull Class<? extends Annotation> type) {
		JvmAnnotationReference result = findAnnotation(annotationTarget, type);
		if (result != null) {
			annotationTarget.getAnnotations().remove(result);
			return result;
		}
		return null;
	}
	
	@Nullable
	public JvmAnnotationReference findOrAddAnnotation(@NonNull JvmAnnotationTarget annotationTarget, @NonNull Notifier context, @NonNull Class<? extends Annotation> type) {
		JvmAnnotationReference result = findAnnotation(annotationTarget, type);
		if (result != null)
			return result;
		JvmAnnotationType annotationType = findAnnotationType(type, context);
		if (annotationType != null) {
			result = typesFactory.createJvmAnnotationReference();
			result.setAnnotation(annotationType);
			return result;
		}
		return null;
	}
	
	@Nullable
	private JvmAnnotationType findAnnotationType(Class<? extends Annotation> type, Notifier context) {
		ResourceSet resourceSet = EcoreUtil2.getResourceSet(context);
		if (resourceSet == null)
			return null;
		IJvmTypeProvider typeProvider = typeProviderFactory.findOrCreateTypeProvider(resourceSet);
		try {
			final JvmType result = typeProvider.findTypeByName(type.getName());
			if (result instanceof JvmAnnotationType)
				return (JvmAnnotationType) result;
			return null;
		} catch (RuntimeException e) {
			return null;
		}
	}

}
