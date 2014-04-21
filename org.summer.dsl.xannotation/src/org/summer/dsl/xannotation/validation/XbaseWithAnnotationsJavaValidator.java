/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.summer.dsl.xannotation.validation;

import static com.google.common.collect.Lists.*;
import static org.summer.dsl.xbase.validation.IssueCodes.*;

import java.util.List;

import org.eclipse.emf.ecore.EPackage;
import org.summer.dsl.model.types.JvmAnnotationType;
import org.summer.dsl.model.types.JvmOperation;
import org.summer.dsl.model.types.JvmType;
import org.eclipse.xtext.validation.Check;
import org.eclipse.xtext.validation.ValidationMessageAcceptor;
import org.summer.dsl.model.xbase.XExpression;
import org.summer.dsl.xannotation.validation.AnnotationValueValidator;
import org.summer.dsl.model.xannotation.XAnnotation;
import org.summer.dsl.model.xannotation.XannotationPackage;
import org.summer.dsl.xannotation.typing.XAnnotationUtil;
import org.summer.dsl.xbase.validation.XbaseJavaValidator;

import com.google.inject.Inject;
 
public class XbaseWithAnnotationsJavaValidator extends XbaseJavaValidator {
	
	@Inject
	private XAnnotationUtil annotationUtil;
	
	@Inject
	private AnnotationValueValidator annotationValueValidator;
	
	@Override
	protected List<EPackage> getEPackages() {
		final List<EPackage> ePackages = newArrayList(super.getEPackages());
		ePackages.add(XannotationPackage.eINSTANCE);
		return ePackages;
	}

	@Check
	public void checkAllAttributesConfigured(XAnnotation annotation) {
		JvmType annotationType = annotation.getAnnotationType();
		if (annotationType == null || annotationType.eIsProxy() || !(annotationType instanceof JvmAnnotationType))
			return;
		Iterable<JvmOperation> attributes = ((JvmAnnotationType) annotationType).getDeclaredOperations();
		for (JvmOperation jvmOperation : attributes) {
			XExpression value = annotationUtil.findValue(annotation, jvmOperation);
			if(value == null) {
				if (jvmOperation.getDefaultValue() == null) {
					error("The annotation must define the attribute '"+jvmOperation.getSimpleName()+"'.", annotation, null, 
							ValidationMessageAcceptor.INSIGNIFICANT_INDEX, ANNOTATIONS_MISSING_ATTRIBUTE_DEFINITION);
				}
			} else
				annotationValueValidator.validateAnnotationValue(value, this);
		}
	}
	
	@Override
	protected boolean isImplicitReturn(XExpression expr) {
		if (expr instanceof XAnnotation)
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
