/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.summer.ss.core.imports;

import static com.google.common.collect.Lists.*;
import static java.util.Collections.*;
import static org.eclipse.xtext.util.Strings.*;

import java.util.List;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.summer.ss.core.jvmmodel.IXtendJvmAssociations;
import org.summer.ss.core.scoping.SsImportedNamespaceScopeProvider;
import org.summer.dsl.model.ss.XtendFile;
import org.summer.dsl.model.ss.SsPackage;
import org.summer.dsl.model.ss.XtendTypeDeclaration;
import org.eclipse.xtext.EcoreUtil2;
import org.summer.dsl.model.types.JvmDeclaredType;
import org.eclipse.xtext.nodemodel.ILeafNode;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.util.IAcceptor;
import org.summer.dsl.xbase.imports.DefaultImportsConfiguration;
import org.summer.dsl.model.xtype.XImportSection;
import org.summer.dsl.model.xtype.XImportSection1;

import com.google.inject.Inject;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public class SsImportsConfiguration extends DefaultImportsConfiguration {
	
	@Inject
	private IXtendJvmAssociations associations;
	
	@Override
	public XImportSection1 getImportSection(XtextResource resource) {
		XtendFile xtendFile = getXtendFile(resource);
		if(xtendFile != null)
			return xtendFile.getImportSection();
		else
			return null;
	}

	protected String getCommonPackageName(XtextResource resource) {
		XtendFile xtendFile = getXtendFile(resource);
		return xtendFile == null ? null : xtendFile.getPackage();
	}
	
	@Override
	public Iterable<JvmDeclaredType> getLocallyDefinedTypes(XtextResource resource) {
		XtendFile xtendFile = getXtendFile(resource);
		if(xtendFile == null)
			return emptyList();
		final List<JvmDeclaredType> locallyDefinedTypes = newArrayList();
		for(XtendTypeDeclaration xtendType: xtendFile.getXtendTypes())  {
			for(EObject inferredElement: associations.getJvmElements(xtendType)) {
				if(inferredElement instanceof JvmDeclaredType) {
					JvmDeclaredType declaredType = (JvmDeclaredType) inferredElement;
					locallyDefinedTypes.add(declaredType);
					addInnerTypes(declaredType, new IAcceptor<JvmDeclaredType>() {
						public void accept(JvmDeclaredType t) {
							locallyDefinedTypes.add(t);
						}
					});
				}
			}
		}
		return locallyDefinedTypes;
	}

	protected XtendFile getXtendFile(XtextResource resource) {
		if(resource == null || resource.getContents().isEmpty() || !(resource.getContents().get(0) instanceof XtendFile))
			return null;
		else 
			return (XtendFile) resource.getContents().get(0);
	}
	
	@Override
	public Set<String> getImplicitlyImportedPackages(XtextResource resource) {
		Set<String> implicitlyImportedPackages = super.getImplicitlyImportedPackages(resource);
		implicitlyImportedPackages.add(SsImportedNamespaceScopeProvider.XTEND_LIB.toString("."));
		XtendFile xtendFile = getXtendFile(resource);
		String commonPackageName = xtendFile == null ? null : xtendFile.getPackage();
		if(!isEmpty(commonPackageName))  
			implicitlyImportedPackages.add(commonPackageName);
		return implicitlyImportedPackages;
	}
	
	@Override
	public int getImportSectionOffset(XtextResource resource) {
		XtendFile xtendFile = getXtendFile(resource);
		if(xtendFile != null) {
			if(!isEmpty(xtendFile.getPackage())) {
				List<INode> nodes = NodeModelUtils.findNodesForFeature(xtendFile, SsPackage.Literals.XTEND_FILE__PACKAGE);
				if(!nodes.isEmpty()) {
					INode lastNode = nodes.get(nodes.size()-1);
					INode nextSibling = lastNode.getNextSibling();
					while(nextSibling instanceof ILeafNode && ((ILeafNode)nextSibling).isHidden())
						nextSibling = nextSibling.getNextSibling();
					if(nextSibling != null && ";".equals(nextSibling.getText()))
						return nextSibling.getOffset() + 1;
					else
						return lastNode.getTotalEndOffset();
				}
			}
		}
		return 0;
	}
	
	@Override
	public JvmDeclaredType getContextJvmDeclaredType(EObject model) {
		XtendTypeDeclaration xtendType = EcoreUtil2.getContainerOfType(model, XtendTypeDeclaration.class);
		if(xtendType != null && xtendType.eContainingFeature() == SsPackage.Literals.XTEND_MEMBER__ANNOTATION_INFO) 
			xtendType = (XtendTypeDeclaration) xtendType.eContainer();
		return associations.getInferredType(xtendType);
	}
}
