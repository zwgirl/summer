/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.summer.ss.ide.refactoring;

import static com.google.common.collect.Lists.newArrayList;
import static org.eclipse.xtext.util.Strings.equal;

import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.Assert;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.ltk.core.refactoring.RefactoringStatus;
import org.eclipse.xtext.ui.refactoring.IRefactoringUpdateAcceptor;
import org.eclipse.xtext.ui.refactoring.IRenameStrategy;
import org.eclipse.xtext.ui.refactoring.impl.DefaultRenameStrategyProvider.IInitializable;
import org.eclipse.xtext.ui.refactoring.ui.IRenameElementContext;
import org.summer.dsl.model.types.JvmOperation;
import org.summer.dsl.model.ui.refactoring.participant.JvmMemberRenameStrategy;
import org.summer.dsl.xbase.ui.jvmmodel.refactoring.DefaultJvmModelRenameStrategy;
import org.summer.ss.core.jvmmodel.IXtendJvmAssociations;

import com.google.inject.Inject;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public class DispatchMethodRenameStrategy implements IInitializable {

	@Inject
	private IXtendJvmAssociations associations;
	
	@Inject
	private com.google.inject.Provider<XtendDispatchMethodChildStrategy> childStrategyProvider; 
	
	@Inject
	private com.google.inject.Provider<JavaDispatchMethodChildStrategy> javaStrategyProvider; 
	
	private List<IRenameStrategy> children = newArrayList(); 
	
	private List<JvmOperation> dispatchers = newArrayList();
	
	public boolean initialize(EObject xtendMethod, IRenameElementContext context) {
		Assert.isLegal(xtendMethod instanceof JvmOperation);
//		Assert.isLegal(((JvmOperation) xtendMethod).isDispatch());
		Assert.isLegal(context instanceof DispatchMethodRenameContext);
		ResourceSet resourceSet = xtendMethod.eResource().getResourceSet();
		Map<URI, IJavaElement> jvm2JavaElements = ((DispatchMethodRenameContext)context).getJvm2JavaElements();
		for(URI dispatchOperationURI: jvm2JavaElements.keySet()) {
			JvmOperation dispatchOperation = (JvmOperation) resourceSet.getEObject(dispatchOperationURI, true);
			JvmOperation xtendDispatchMethod = associations.getXtendFunction(dispatchOperation);
			if(xtendDispatchMethod != null) {
				if(equal(xtendDispatchMethod.getSimpleName(),dispatchOperation.getSimpleName())) {
					// synthetic dispatcher
					dispatchers.add(dispatchOperation);
				} else {
					// xtend dispatch method
					XtendDispatchMethodChildStrategy xtendChildStrategy = childStrategyProvider.get();
					xtendChildStrategy.initialize(xtendDispatchMethod, context);
					children.add(xtendChildStrategy);
				}
			} else {
				// a dispatch method form a Java class
				JavaDispatchMethodChildStrategy jvmChildStrategy = javaStrategyProvider.get();
				jvmChildStrategy.initialize(dispatchOperation, context);
				children.add(jvmChildStrategy);
			}
		}
		return !children.isEmpty();
	}

	public static class XtendDispatchMethodChildStrategy extends DefaultJvmModelRenameStrategy {
		@Override
		protected void setInferredJvmElementName(String name, EObject renamedElement) {
			super.setInferredJvmElementName("_" + name, renamedElement);
		}
	}

	public static class JavaDispatchMethodChildStrategy extends JvmMemberRenameStrategy {
		@Override
		public void applyDeclarationChange(String newName, ResourceSet resourceSet) {
			super.applyDeclarationChange("_" + newName, resourceSet);
		}
	}
	
	public String getOriginalName() {
		return children.get(0).getOriginalName();
	}

	public RefactoringStatus validateNewName(String newName) {
		RefactoringStatus status = new RefactoringStatus();
		for(IRenameStrategy child: children)
			status.merge(child.validateNewName(newName));
		return status;
	}

	public void applyDeclarationChange(String newName, ResourceSet resourceSet) {
		for(IRenameStrategy child: children)
			child.applyDeclarationChange(newName, resourceSet);
		for(JvmOperation dispatcher: dispatchers) {
			dispatcher.setSimpleName(newName);
		}
	}

	public void revertDeclarationChange(ResourceSet resourceSet) {
		for(IRenameStrategy child: children)
			child.revertDeclarationChange(resourceSet);
		for(JvmOperation dispatcher: dispatchers) {
			dispatcher.setSimpleName(getOriginalName());
		}
	}

	public void createDeclarationUpdates(String newName, ResourceSet resourceSet,
			IRefactoringUpdateAcceptor updateAcceptor) {
		for(IRenameStrategy child: children)
			child.createDeclarationUpdates(newName, resourceSet, updateAcceptor);
	}
	
}
