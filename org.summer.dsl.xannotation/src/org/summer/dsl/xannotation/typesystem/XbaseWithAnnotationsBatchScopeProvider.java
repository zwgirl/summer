/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.summer.dsl.xannotation.typesystem;

import static com.google.common.collect.Iterables.transform;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.EObjectDescription;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.impl.MapBasedScope;
import org.summer.dsl.model.types.JvmAnnotationReference;
import org.summer.dsl.model.types.JvmAnnotationType;
import org.summer.dsl.model.types.JvmAnnotationValue;
import org.summer.dsl.model.types.JvmField;
import org.summer.dsl.model.types.JvmType;
import org.summer.dsl.xbase.scoping.batch.XbaseBatchScopeProvider;

import com.google.common.base.Function;
import com.google.inject.Singleton;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@Singleton
public class XbaseWithAnnotationsBatchScopeProvider extends XbaseBatchScopeProvider {

	@Override
	public IScope getScope(EObject context, EReference reference) {
//		if (reference == XannotationPackage.Literals.XANNOTATION_ELEMENT_VALUE_PAIR__ELEMENT) {
//			XAnnotation annotation = EcoreUtil2.getContainerOfType(context, XAnnotation.class);
//			JvmType annotationType = annotation.getAnnotationType();
//			if (annotationType == null || annotationType.eIsProxy() || !(annotationType instanceof JvmAnnotationType)) {
//				return IScope.NULLSCOPE;
//			}
//			Iterable<JvmOperation> operations = ((JvmAnnotationType) annotationType).getDeclaredOperations();
//			Iterable<IEObjectDescription> descriptions = transform(operations, new Function<JvmOperation, IEObjectDescription>() {
//				public IEObjectDescription apply(JvmOperation from) {
//					return EObjectDescription.create(QualifiedName.create(from.getSimpleName()), from);
//				}
//			});
//			return MapBasedScope.createScope(IScope.NULLSCOPE, descriptions);
//		}
		
		if (context instanceof JvmAnnotationValue ) { //reference == XannotationPackage.Literals.XANNOTATION_ELEMENT_VALUE_PAIR__ELEMENT) {
			JvmAnnotationValue annValue = (JvmAnnotationValue)context;
			JvmAnnotationReference annoRef = (JvmAnnotationReference) annValue.eContainer();
			JvmType annotationType = annoRef.getAnnotation();
			if (annotationType == null || annotationType.eIsProxy() || !(annotationType instanceof JvmAnnotationType)) {
				return IScope.NULLSCOPE;
			}
			Iterable<JvmField> fields = ((JvmAnnotationType) annotationType).getDeclaredFields();
			Iterable<IEObjectDescription> descriptions = transform(fields, new Function<JvmField, IEObjectDescription>() {
				public IEObjectDescription apply(JvmField from) {
					return EObjectDescription.create(QualifiedName.create(from.getSimpleName()), from);
				}
			});
			return MapBasedScope.createScope(IScope.NULLSCOPE, descriptions);
		}
		return super.getScope(context, reference);
	}
	
}

