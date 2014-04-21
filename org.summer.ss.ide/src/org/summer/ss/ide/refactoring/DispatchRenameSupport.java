/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.summer.ss.ide.refactoring;

import static com.google.common.collect.Lists.*;
import static com.google.common.collect.Sets.*;

import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.jdt.core.IType;
import org.eclipse.jdt.core.ITypeHierarchy;
import org.eclipse.jdt.core.JavaModelException;
import org.summer.ss.core.dispatch.DispatchingSupport;
import org.summer.ss.core.jvmmodel.IXtendJvmAssociations;
import org.summer.dsl.model.ss.XtendClass;
import org.summer.dsl.model.ss.XtendFunction;
import org.eclipse.xtext.EcoreUtil2;
import org.summer.dsl.model.types.JvmGenericType;
import org.summer.dsl.model.types.JvmOperation;
import org.summer.dsl.model.types.JvmType;
import org.summer.dsl.model.types.JvmTypeReference;
import org.summer.dsl.model.ui.refactoring.participant.JvmElementFinder;
import org.summer.dsl.model.types.util.jdt.JavaElementFinder;
import org.eclipse.xtext.ui.refactoring.impl.ProjectUtil;
import org.eclipse.xtext.ui.resource.IResourceSetProvider;
import org.eclipse.xtext.util.IAcceptor;
import org.eclipse.xtext.util.Pair;
import org.eclipse.xtext.util.Tuples;

import com.google.inject.Inject;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
@SuppressWarnings("deprecation")
public class DispatchRenameSupport {
	private static final Logger LOG = Logger.getLogger(DispatchRenameSupport.class);

	@Inject
	private DispatchingSupport dispatchingSupport;

	@Inject
	private IXtendJvmAssociations associations;

	@Inject
	private JavaElementFinder javaElementFinder;

	@Inject
	private JvmElementFinder jvmElementFinder;

	@Inject
	private IResourceSetProvider resourceSetProvider;

	@Inject
	private ProjectUtil projectUtil;

	/**
	 * Returns all operations of the declaring type that have to be renamed with the given Xtend function. I.e. all
	 * dispatch functions with the same name of all sub- and super types as well as the artificial dispatchers.
	 * 
	 * The method will likely load all subtypes into the resource set of the dispatch function, so you might want to
	 * hand in a reloaded instance instead.
	 */
	public Iterable<JvmOperation> getAllDispatchOperations(XtendFunction dispatchFunction) {
		Assert.isLegal(dispatchFunction.isDispatch());
		IProject project = projectUtil.getProject(dispatchFunction.eResource().getURI());
		final ResourceSet tempResourceSet = resourceSetProvider.get(project);

		JvmOperation localDispatcher = associations.getDispatchOperation(dispatchFunction);
		XtendClass xtendClass = (XtendClass) dispatchFunction.eContainer();

		final Set<JvmOperation> dispatchCases = newLinkedHashSet();
		IAcceptor<JvmOperation> operationAcceptor = new IAcceptor<JvmOperation>() {
			public void accept(JvmOperation operation) {
				dispatchCases.add(operation);
			}
		};
		final Set<JvmGenericType> processedTypes = newHashSet();
		addDispatcher(associations.getInferredType(xtendClass),
				Tuples.create(localDispatcher.getSimpleName(), localDispatcher.getParameters().size()),
				operationAcceptor, processedTypes, tempResourceSet);
		return dispatchCases;
	}

	protected boolean addDispatcher(JvmGenericType type, final Pair<String, Integer> signature,
			final IAcceptor<JvmOperation> acceptor, final Set<JvmGenericType> processedTypes, ResourceSet tempResourceSet) {
		if (processedTypes.contains(type))
			return false;
		processedTypes.add(type);
		boolean needProcessSubclasses = false;
		XtendClass xtendClass = associations.getXtendClass(type);
		if (xtendClass != null) {
			JvmOperation dispatcher = dispatchingSupport.findSyntheticDispatchMethod(xtendClass, signature);
			if (dispatcher != null) {
				needProcessSubclasses = true;
				acceptor.accept(dispatcher);
			}
		}
		for (JvmOperation dispatchCase : dispatchingSupport.getDispatchMethods(type).get(signature)) {
			if (dispatchCase.getDeclaringType() == type) {
				needProcessSubclasses = true;
				acceptor.accept(dispatchCase);
			}
		}
		for (JvmTypeReference superTypeRef : type.getSuperTypes()) {
			JvmType superType = superTypeRef.getType();
			if (superType instanceof JvmGenericType)
				needProcessSubclasses |= addDispatcher((JvmGenericType) superType, signature, acceptor, processedTypes, tempResourceSet);
		}
		if (needProcessSubclasses) {
			for (JvmGenericType subType : getSubTypes(type, tempResourceSet))
				needProcessSubclasses |= addDispatcher(subType, signature, acceptor, processedTypes, tempResourceSet);
		}
		return needProcessSubclasses;
	}

	protected Iterable<JvmGenericType> getSubTypes(JvmGenericType type, ResourceSet tempResourceSet) {
		IType javaType = (IType) javaElementFinder.findExactElementFor(type);
		List<JvmGenericType> allSubTypes = newArrayList();
		try {
			ITypeHierarchy typeHierarchy = javaType.newTypeHierarchy(javaType.getJavaProject(),
					new NullProgressMonitor());
			for (IType subType : typeHierarchy.getSubtypes(javaType)) {
				EObject jvmSubType = jvmElementFinder.getCorrespondingJvmElement(subType, tempResourceSet);
				if (jvmSubType instanceof JvmGenericType) {
					EObject indexJvmSubType = jvmElementFinder.findJvmElementDeclarationInIndex(jvmSubType, subType
							.getJavaProject().getProject(), type.eResource().getResourceSet());
					if (indexJvmSubType instanceof JvmGenericType) {
						allSubTypes.add((JvmGenericType) indexJvmSubType);
					} else {
						EObject jvmSubTypeInOtherResourceSet = type.eResource().getResourceSet().getEObject(EcoreUtil2.getPlatformResourceOrNormalizedURI(jvmSubType), true);
						if(jvmSubTypeInOtherResourceSet instanceof JvmGenericType)
							allSubTypes.add((JvmGenericType) jvmSubTypeInOtherResourceSet);
					}
				}
			}
		} catch (JavaModelException e) {
			LOG.error("Error calculating subtypes", e);
		}
		return allSubTypes;

	}
}
