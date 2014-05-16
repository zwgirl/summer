/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.summer.dsl.xannotation.typing;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.summer.dsl.model.types.JvmAnnotationReference;
import org.summer.dsl.model.types.JvmAnnotationType;
import org.summer.dsl.model.types.JvmField;
import org.summer.dsl.model.types.JvmType;
import org.summer.dsl.model.types.JvmTypeReference;
import org.summer.dsl.model.types.TypesPackage;
import org.summer.dsl.model.xbase.XExpression;
import org.summer.dsl.xbase.typing.XbaseTypeProvider;

import com.google.inject.Inject;
import com.google.inject.Singleton;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
@SuppressWarnings("deprecation")
@Singleton
public class XbaseWithAnnotationsTypeProvider extends XbaseTypeProvider {
	
	@Inject
	private XAnnotationUtil annotationUtil;
	
	@Override
	protected JvmTypeReference expectedType(EObject container, EReference reference, int index,
			boolean rawType) {
		if (container instanceof JvmAnnotationReference) {
			return _expectedType((JvmAnnotationReference)container, reference, index, rawType);
//		} else if (container instanceof XAnnotationElementValuePair) {
//			return _expectedType((XAnnotationElementValuePair)container, reference, index, rawType);
		} else {
			return super.expectedType(container, reference, index, rawType);
		}
	}
	
	/**
	 * @param index unused but required in dispatch signature 
	 * @param rawType unused but required in dispatch signature
	 */
	protected JvmTypeReference _expectedType(JvmAnnotationReference annotation, EReference reference, int index,
			boolean rawType) {
		if (reference == TypesPackage.Literals.JVM_ANNOTATION_REFERENCE__VALUE) {
			JvmType annotationType = annotation.getAnnotation();
			if (annotationType == null || annotationType.eIsProxy() || !(annotationType instanceof JvmAnnotationType))
				return null;
			JvmField valueField = annotationUtil.findSingleValueAttribute((JvmAnnotationType) annotationType);
			if (valueField==null)
				return null;
			return valueField.getType();
		}
		return null;
	}
	
	/**
	 * @param index unused but required in dispatch signature 
	 * @param rawType unused but required in dispatch signature
	 */
//	protected JvmTypeReference _expectedType(XAnnotationElementValuePair annotation, EReference reference, int index,
//			boolean rawType) {
//		if (reference == XannotationPackage.Literals.XANNOTATION_ELEMENT_VALUE_PAIR__VALUE) {
//			if (annotation.getElement() != null) {
//				return annotation.getElement().getReturnType();
//			}
//		}
//		return null;
//	}
	
	@Override
	protected JvmTypeReference type(XExpression expression, JvmTypeReference rawExpectation, boolean rawType) {
		if (expression instanceof JvmAnnotationReference) {
			return _type((JvmAnnotationReference)expression, rawExpectation, rawType);
		} else {
			return super.type(expression, rawExpectation, rawType);
		}
	}

	/**
	 * @param rawExpectation unused but required in dispatch signature 
	 * @param rawType unused but required in dispatch signature
	 */
	protected JvmTypeReference _type(JvmAnnotationReference annotation, JvmTypeReference rawExpectation, boolean rawType) {
		final JvmType annotationType = annotation.getAnnotation();
		if (annotationType == null) {
			return null;
		}
		return getTypeReferences().createTypeRef(annotationType);
	}
	
}
