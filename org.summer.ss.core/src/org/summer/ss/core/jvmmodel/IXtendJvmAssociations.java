/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.summer.ss.core.jvmmodel;

import static com.google.common.collect.Iterables.*;

import java.util.Iterator;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.summer.dsl.model.ss.XtendAnnotationType;
import org.summer.dsl.model.ss.XtendClass;
import org.summer.dsl.model.ss.XtendConstructor;
import org.summer.dsl.model.ss.XtendEnum;
import org.summer.dsl.model.ss.XtendEnumLiteral;
import org.summer.dsl.model.ss.XtendField;
import org.summer.dsl.model.ss.XtendFunction;
import org.summer.dsl.model.ss.XtendInterface;
import org.summer.dsl.model.ss.XtendParameter;
import org.summer.dsl.model.ss.XtendTypeDeclaration;
import org.summer.dsl.model.types.JvmAnnotationType;
import org.summer.dsl.model.types.JvmConstructor;
import org.summer.dsl.model.types.JvmDeclaredType;
import org.summer.dsl.model.types.JvmEnumerationType;
import org.summer.dsl.model.types.JvmField;
import org.summer.dsl.model.types.JvmFormalParameter;
import org.summer.dsl.model.types.JvmGenericType;
import org.summer.dsl.model.types.JvmOperation;
import org.summer.dsl.xbase.jvmmodel.IJvmModelAssociations;
import org.summer.dsl.xbase.jvmmodel.JvmModelAssociator;

import com.google.inject.ImplementedBy;
import com.google.inject.Singleton;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
@ImplementedBy(IXtendJvmAssociations.Impl.class)
public interface IXtendJvmAssociations extends IJvmModelAssociations {

	JvmDeclaredType getInferredType(XtendTypeDeclaration xtendClass);
	
	JvmGenericType getInferredType(XtendClass xtendClass);

	JvmGenericType getInferredType(XtendInterface xtendInterfaceClass);

	JvmAnnotationType getInferredAnnotationType(XtendAnnotationType xtendAnnotation);
	
	JvmEnumerationType getInferredEnumerationType(XtendEnum xtendInterfaceClass);
	
	JvmConstructor getInferredConstructor(XtendClass xtendClass);

	JvmConstructor getInferredConstructor(XtendConstructor xtendConstructor);
	
	JvmOperation getDirectlyInferredOperation(XtendFunction xtendFunction);
	
	JvmOperation getDispatchOperation(XtendFunction dispatchFunction);
	
	JvmField getJvmField(XtendField field);
	
	JvmField getJvmField(XtendEnumLiteral field);
	
	JvmFormalParameter getJvmParameter(XtendParameter parameter);
	
	XtendClass getXtendClass(JvmGenericType jvmType);
	
	XtendInterface getXtendInterface(JvmGenericType jvmType);
	
	XtendFunction getXtendFunction(JvmOperation jvmOperation);

	XtendConstructor getXtendConstructor(JvmConstructor jvmConstructor);
	
	XtendField getXtendField(JvmField jvmField);
	
	@Singleton
	static class Impl extends JvmModelAssociator implements IXtendJvmAssociations {

		public JvmDeclaredType getInferredType(XtendTypeDeclaration xtendType) {
			final JvmDeclaredType firstOrNull = getFirstOrNull(getJvmElements(xtendType), JvmDeclaredType.class);
			return firstOrNull;
		}
		
		public JvmGenericType getInferredType(XtendClass xtendClass) {
			final JvmGenericType firstOrNull = getFirstOrNull(getJvmElements(xtendClass), JvmGenericType.class);
			return firstOrNull;
		}

		public JvmGenericType getInferredType(XtendInterface xtendInterface) {
			final JvmGenericType firstOrNull = getFirstOrNull(getJvmElements(xtendInterface), JvmGenericType.class);
			return firstOrNull;
		}

		public JvmAnnotationType getInferredAnnotationType(XtendAnnotationType xtendAnnotation) {
			final JvmAnnotationType firstOrNull = getFirstOrNull(getJvmElements(xtendAnnotation), JvmAnnotationType.class);
			return firstOrNull;
		}

		public JvmEnumerationType getInferredEnumerationType(XtendEnum xtendEnum) {
			final JvmEnumerationType firstOrNull = getFirstOrNull(getJvmElements(xtendEnum), JvmEnumerationType.class);
			return firstOrNull;
		}

		public JvmConstructor getInferredConstructor(XtendClass xtendClass) {
			final JvmConstructor firstOrNull = getFirstOrNull(getJvmElements(xtendClass), JvmConstructor.class);
			return firstOrNull;
		}

		public JvmConstructor getInferredConstructor(XtendConstructor xtendConstructor) {
			final JvmConstructor firstOrNull = getFirstOrNull(getJvmElements(xtendConstructor), JvmConstructor.class);
			return firstOrNull;
		}

		public JvmOperation getDirectlyInferredOperation(XtendFunction xtendFunction) {
			final Iterable<JvmOperation> jvmElements = filter(getJvmElements(xtendFunction), JvmOperation.class);
			String expectedName = xtendFunction.getName();
			if (xtendFunction.isDispatch()) {
				expectedName = "_"+expectedName;
			}
			for (JvmOperation jvmOperation : jvmElements) {
				if (jvmOperation.getSimpleName().equals(expectedName)) {
					return jvmOperation;
				}
			}
			return null;
		}
		
		public JvmOperation getDispatchOperation(XtendFunction dispatchFunction) {
			if (!dispatchFunction.isDispatch())
				throw new IllegalArgumentException("Function " + dispatchFunction.getName() + " is not a dispatch function");
			Set<EObject> jvmElements = getJvmElements(dispatchFunction);
			for(EObject candidate: jvmElements) {
				if (candidate instanceof JvmOperation) {
					// other operation has '_' prefix
					if (dispatchFunction.getName().equals(((JvmOperation) candidate).getSimpleName())) {
						return (JvmOperation) candidate;
					}
				}
			}
			return null;
		}

		public XtendClass getXtendClass(JvmGenericType jvmType) {
			final EObject primarySourceElement = getPrimarySourceElement(jvmType);
			if (primarySourceElement instanceof XtendClass) 
				return (XtendClass) primarySourceElement;
			return null;
		}

		public XtendInterface getXtendInterface(JvmGenericType jvmType) {
			final EObject primarySourceElement = getPrimarySourceElement(jvmType);
			if (primarySourceElement instanceof XtendInterface) 
				return (XtendInterface) primarySourceElement;
			return null;
		}

		public XtendFunction getXtendFunction(JvmOperation jvmOperation) {
			return (XtendFunction) getPrimarySourceElement(jvmOperation);
		}

		public XtendConstructor getXtendConstructor(JvmConstructor jvmConstructor) {
			EObject primarySourceElement = getPrimarySourceElement(jvmConstructor);
			return primarySourceElement instanceof XtendConstructor ? (XtendConstructor) primarySourceElement : null;
		}

		protected <T> T getFirstOrNull(Iterable<EObject> elements, Class<T> type) {
			Iterator<T> iterator = filter(elements, type).iterator();
			return iterator.hasNext() ? iterator.next() : null;
		}

		public JvmField getJvmField(XtendField field) {
			return getFirstOrNull(getJvmElements(field), JvmField.class);
		}
		
		public JvmField getJvmField(XtendEnumLiteral field) {
			return getFirstOrNull(getJvmElements(field), JvmField.class);
		}
		
		public JvmFormalParameter getJvmParameter(XtendParameter parameter) {
			return getFirstOrNull(getJvmElements(parameter), JvmFormalParameter.class);
		}

		public XtendField getXtendField(JvmField jvmField) {
			EObject primarySourceElement = getPrimarySourceElement(jvmField);
			if (primarySourceElement instanceof XtendField)
				return (XtendField) primarySourceElement;
			return null;
		}

	}
	
}
