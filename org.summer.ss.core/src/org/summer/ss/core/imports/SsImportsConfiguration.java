/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.summer.ss.core.imports;

import static com.google.common.collect.Lists.newArrayList;
import static java.util.Collections.emptyList;
import static org.eclipse.xtext.util.Strings.isEmpty;

import java.util.List;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.nodemodel.ILeafNode;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.resource.XtextResource;
import org.summer.dsl.model.types.JvmDeclaredType;
import org.summer.dsl.model.types.JvmModule;
import org.summer.dsl.model.types.TypesPackage;
import org.summer.dsl.model.xtype.XImportSection;
import org.summer.dsl.xbase.imports.DefaultImportsConfiguration;
import org.summer.ss.core.jvmmodel.IXtendJvmAssociations;
import org.summer.ss.core.scoping.SsImportedNamespaceScopeProvider;

import com.google.inject.Inject;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public class SsImportsConfiguration extends DefaultImportsConfiguration {
	
	@Inject
	private IXtendJvmAssociations associations;
	
	@Override
	public XImportSection getImportSection(XtextResource resource) {
		JvmModule xtendFile = getXtendFile(resource);
		if(xtendFile != null)
			return xtendFile.getImportSection();
		else
			return null;
	}

	protected String getCommonPackageName(XtextResource resource) {
		JvmModule xtendFile = getXtendFile(resource);
		return xtendFile == null ? null : xtendFile.getSimpleName();
	}
	
	//cym comment
//	@Override
//	public Iterable<JvmDeclaredType> getLocallyDefinedTypes(XtextResource resource) {
//		XModule xtendFile = getXtendFile(resource);
//		if(xtendFile == null)
//			return emptyList();
//		final List<JvmDeclaredType> locallyDefinedTypes = newArrayList();
//		for(XtendTypeDeclaration xtendType: xtendFile.getXtendTypes())  {
//			for(EObject inferredElement: associations.getJvmElements(xtendType)) {
//				if(inferredElement instanceof JvmDeclaredType) {
//					JvmDeclaredType declaredType = (JvmDeclaredType) inferredElement;
//					locallyDefinedTypes.add(declaredType);
//					addInnerTypes(declaredType, new IAcceptor<JvmDeclaredType>() {
//						public void accept(JvmDeclaredType t) {
//							locallyDefinedTypes.add(t);
//						}
//					});
//				}
//			}
//		}
//		return locallyDefinedTypes;
//	}
	
	@Override
	public Iterable<JvmDeclaredType> getLocallyDefinedTypes(XtextResource resource) {
		JvmModule xtendFile = getXtendFile(resource);
		if(xtendFile == null)
			return emptyList();
		final List<JvmDeclaredType> locallyDefinedTypes = newArrayList();
		for(EObject object: xtendFile.getContents())  {
			if(!(object instanceof JvmDeclaredType)){
				continue;
				
			}
			JvmDeclaredType type = (JvmDeclaredType) object;
			locallyDefinedTypes.add(type);
		}
		return locallyDefinedTypes;
	}

	protected JvmModule getXtendFile(XtextResource resource) {
		if(resource == null || resource.getContents().isEmpty() || !(resource.getContents().get(0) instanceof JvmModule))
			return null;
		else 
			return (JvmModule) resource.getContents().get(0);
	}
	
	@Override
	public Set<String> getImplicitlyImportedPackages(XtextResource resource) {
		Set<String> implicitlyImportedPackages = super.getImplicitlyImportedPackages(resource);
		implicitlyImportedPackages.add(SsImportedNamespaceScopeProvider.XTEND_LIB.toString("."));
		JvmModule xtendFile = getXtendFile(resource);
		String commonPackageName = xtendFile == null ? null : xtendFile.getSimpleName();
		if(!isEmpty(commonPackageName))  
			implicitlyImportedPackages.add(commonPackageName);
		return implicitlyImportedPackages;
	}
	
	@Override
	public int getImportSectionOffset(XtextResource resource) {
		JvmModule xtendFile = getXtendFile(resource);
		if(xtendFile != null) {
			if(!isEmpty(xtendFile.getSimpleName())) {
				List<INode> nodes = NodeModelUtils.findNodesForFeature(xtendFile, TypesPackage.Literals.JVM_MODULE__SIMPLE_NAME);
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
//		XtendTypeDeclaration xtendType = EcoreUtil2.getContainerOfType(model, XtendTypeDeclaration.class);
//		if(xtendType != null && xtendType.eContainingFeature() == SsPackage.Literals.XTEND_MEMBER__ANNOTATION_INFO) 
//			xtendType = (XtendTypeDeclaration) xtendType.eContainer();
//		return associations.getInferredType(xtendType);
		
		JvmDeclaredType type = EcoreUtil2.getContainerOfType(model, JvmDeclaredType.class);
		return type;
	}
}
