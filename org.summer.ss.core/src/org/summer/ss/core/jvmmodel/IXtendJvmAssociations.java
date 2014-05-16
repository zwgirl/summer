/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.summer.ss.core.jvmmodel;

import static com.google.common.collect.Iterables.filter;

import java.util.Iterator;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.summer.dsl.model.types.JvmAnnotationType;
import org.summer.dsl.model.types.JvmConstructor;
import org.summer.dsl.model.types.JvmDeclaredType;
import org.summer.dsl.model.types.JvmEnumerationLiteral;
import org.summer.dsl.model.types.JvmEnumerationType;
import org.summer.dsl.model.types.JvmField;
import org.summer.dsl.model.types.JvmFormalParameter;
import org.summer.dsl.model.types.JvmGenericType;
import org.summer.dsl.model.types.JvmInterfaceType;
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

	JvmDeclaredType getInferredType(JvmDeclaredType xtendClass);
	
	JvmGenericType getInferredType(JvmGenericType xtendClass);

	JvmGenericType getInferredType(JvmInterfaceType xtendInterfaceClass);

	JvmAnnotationType getInferredAnnotationType(JvmAnnotationType xtendAnnotation);
	
	JvmEnumerationType getInferredEnumerationType(JvmEnumerationType xtendInterfaceClass);
	
	JvmConstructor getInferredConstructor(JvmGenericType xtendClass);

	JvmConstructor getInferredConstructor(JvmConstructor xtendConstructor);
	
	JvmOperation getDirectlyInferredOperation(JvmOperation xtendFunction);
	
	JvmOperation getDispatchOperation(JvmOperation dispatchFunction);
	
	JvmField getJvmField(JvmField field);
	
	JvmField getJvmField(JvmEnumerationLiteral field);
	
	JvmFormalParameter getJvmParameter(JvmFormalParameter parameter);
	
	JvmGenericType getXtendClass(JvmGenericType jvmType);
	
	JvmInterfaceType getXtendInterface(JvmGenericType jvmType);
	
	JvmOperation getXtendFunction(JvmOperation jvmOperation);

	JvmConstructor getXtendConstructor(JvmConstructor jvmConstructor);
	
	JvmField getXtendField(JvmField jvmField);
	
	@Singleton
	static class Impl extends JvmModelAssociator implements IXtendJvmAssociations {

		public JvmDeclaredType getInferredType(JvmDeclaredType xtendType) {
			final JvmDeclaredType firstOrNull = getFirstOrNull(getJvmElements(xtendType), JvmDeclaredType.class);
			return firstOrNull;
		}
		
		public JvmGenericType getInferredType(JvmGenericType xtendClass) {
			final JvmGenericType firstOrNull = getFirstOrNull(getJvmElements(xtendClass), JvmGenericType.class);
			return firstOrNull;
		}

		public JvmGenericType getInferredType(JvmInterfaceType xtendInterface) {
			final JvmGenericType firstOrNull = getFirstOrNull(getJvmElements(xtendInterface), JvmGenericType.class);
			return firstOrNull;
		}

		public JvmAnnotationType getInferredAnnotationType(JvmAnnotationType xtendAnnotation) {
			final JvmAnnotationType firstOrNull = getFirstOrNull(getJvmElements(xtendAnnotation), JvmAnnotationType.class);
			return firstOrNull;
		}

		public JvmEnumerationType getInferredEnumerationType(JvmEnumerationType xtendEnum) {
			final JvmEnumerationType firstOrNull = getFirstOrNull(getJvmElements(xtendEnum), JvmEnumerationType.class);
			return firstOrNull;
		}

		public JvmConstructor getInferredConstructor(JvmGenericType xtendClass) {
			final JvmConstructor firstOrNull = getFirstOrNull(getJvmElements(xtendClass), JvmConstructor.class);
			return firstOrNull;
		}

		public JvmConstructor getInferredConstructor(JvmConstructor xtendConstructor) {
			final JvmConstructor firstOrNull = getFirstOrNull(getJvmElements(xtendConstructor), JvmConstructor.class);
			return firstOrNull;
		}

		public JvmOperation getDirectlyInferredOperation(JvmOperation xtendFunction) {
			final Iterable<JvmOperation> jvmElements = filter(getJvmElements(xtendFunction), JvmOperation.class);
			String expectedName = xtendFunction.getSimpleName();
//			if (xtendFunction.isDispatch()) {
//				expectedName = "_"+expectedName;
//			}
			for (JvmOperation jvmOperation : jvmElements) {
				if (jvmOperation.getSimpleName().equals(expectedName)) {
					return jvmOperation;
				}
			}
			return null;
		}
		
//		public JvmOperation getDispatchOperation(JvmOperation dispatchFunction) {
//			if (!dispatchFunction.isDispatch())
//				throw new IllegalArgumentException("Function " + dispatchFunction.getName() + " is not a dispatch function");
//			Set<EObject> jvmElements = getJvmElements(dispatchFunction);
//			for(EObject candidate: jvmElements) {
//				if (candidate instanceof JvmOperation) {
//					// other operation has '_' prefix
//					if (dispatchFunction.getName().equals(((JvmOperation) candidate).getSimpleName())) {
//						return (JvmOperation) candidate;
//					}
//				}
//			}
//			return null;
//		}

		public JvmGenericType getXtendClass(JvmGenericType jvmType) {
			final EObject primarySourceElement = getPrimarySourceElement(jvmType);
			if (primarySourceElement instanceof JvmGenericType) 
				return (JvmGenericType) primarySourceElement;
			return null;
		}

		public JvmInterfaceType getXtendInterface(JvmGenericType jvmType) {
			final EObject primarySourceElement = getPrimarySourceElement(jvmType);
			if (primarySourceElement instanceof JvmInterfaceType) 
				return (JvmInterfaceType) primarySourceElement;
			return null;
		}

		public JvmOperation getXtendFunction(JvmOperation jvmOperation) {
			return (JvmOperation) getPrimarySourceElement(jvmOperation);
		}

		public JvmConstructor getXtendConstructor(JvmConstructor jvmConstructor) {
			EObject primarySourceElement = getPrimarySourceElement(jvmConstructor);
			return primarySourceElement instanceof JvmConstructor ? (JvmConstructor) primarySourceElement : null;
		}

		protected <T> T getFirstOrNull(Iterable<EObject> elements, Class<T> type) {
			Iterator<T> iterator = filter(elements, type).iterator();
			return iterator.hasNext() ? iterator.next() : null;
		}

		public JvmField getJvmField(JvmField field) {
			return getFirstOrNull(getJvmElements(field), JvmField.class);
		}
		
//		public JvmEnumerationLiteral getJvmField(JvmEnumerationLiteral field) {
//			return getFirstOrNull(getJvmElements(field), JvmEnumerationLiteral.class);
//		}
		
		public JvmFormalParameter getJvmParameter(JvmFormalParameter parameter) {
			return getFirstOrNull(getJvmElements(parameter), JvmFormalParameter.class);
		}

		public JvmField getXtendField(JvmField jvmField) {
			EObject primarySourceElement = getPrimarySourceElement(jvmField);
			if (primarySourceElement instanceof JvmField)
				return (JvmField) primarySourceElement;
			return null;
		}

		@Override
		public JvmOperation getDispatchOperation(JvmOperation dispatchFunction) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public JvmField getJvmField(JvmEnumerationLiteral field) {
			// TODO Auto-generated method stub
			return null;
		}

	}
	
}
