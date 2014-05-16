/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.summer.dsl.xannotation.validation;

import static org.summer.dsl.xbase.validation.IssueCodes.ANNOTATIONS_MISSING_ATTRIBUTE_DEFINITION;

import org.eclipse.xtext.validation.Check;
import org.eclipse.xtext.validation.ValidationMessageAcceptor;
import org.summer.dsl.model.types.JvmAnnotationReference;
import org.summer.dsl.model.types.JvmAnnotationType;
import org.summer.dsl.model.types.JvmField;
import org.summer.dsl.model.types.JvmType;
import org.summer.dsl.model.xbase.XExpression;
import org.summer.dsl.xannotation.typing.XAnnotationUtil;
import org.summer.dsl.xbase.validation.XbaseJavaValidator;

import com.google.inject.Inject;
 
public class XbaseWithAnnotationsJavaValidator extends XbaseJavaValidator {
	
	@Inject
	private XAnnotationUtil annotationUtil;
	
	@Inject
	private AnnotationValueValidator annotationValueValidator;
	
//	@Override
//	protected List<EPackage> getEPackages() {
//		final List<EPackage> ePackages = newArrayList(super.getEPackages());
//		ePackages.add(XannotationPackage.eINSTANCE);
//		return ePackages;
//	}

	@Check
	public void checkAllAttributesConfigured(JvmAnnotationReference annotation) {
		JvmType annotationType = annotation.getAnnotation();
		if (annotationType == null || annotationType.eIsProxy() || !(annotationType instanceof JvmAnnotationType))
			return;
		Iterable<JvmField> attributes = ((JvmAnnotationType) annotationType).getDeclaredFields();
		for (JvmField jvmField : attributes) {
			XExpression value = annotationUtil.findValue(annotation, jvmField);
			if(value == null) {
				if (jvmField.getDefaultValue() == null) {
					error("The annotation must define the attribute '"+jvmField.getSimpleName()+"'.", annotation, null, 
							ValidationMessageAcceptor.INSIGNIFICANT_INDEX, ANNOTATIONS_MISSING_ATTRIBUTE_DEFINITION);
				}
			} else
				annotationValueValidator.validateAnnotationValue(value, this);
		}
	}
	
	@Override
	protected boolean isImplicitReturn(XExpression expr) {
		if (expr instanceof JvmAnnotationReference)
			return false;
		return super.isImplicitReturn(expr);
	}

	/*
	 * validations :
	 * - check @Target
	 * - check elements 
	 * 		- are all elements without default values configured
	 * 		- check whether referenced fields can be evaluated by the compiler, or more generally all expressions need to be static literals
	 */
}
