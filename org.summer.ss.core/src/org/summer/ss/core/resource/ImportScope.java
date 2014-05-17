/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.summer.ss.core.resource;

import java.util.List;

import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.EObjectDescription;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.scoping.IScope;
import org.summer.dsl.model.types.JvmDeclaredType;
import org.summer.dsl.model.types.JvmIdentifiableElement;
import org.summer.dsl.model.types.JvmModule;
import org.summer.dsl.model.xbase.XClosure;
import org.summer.dsl.model.xbase.XVariableDeclaration;
import org.summer.dsl.model.xtype.XImportDeclaration;
import org.summer.dsl.model.xtype.XImportItem;
import org.summer.dsl.model.xtype.XImportSection;
import org.summer.ss.core.scoping.NamespaceUtil;

import com.google.common.collect.Lists;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class ImportScope implements IScope {

	private final Resource resource;
	private IScope parent;
	
	public ImportScope(Resource resource, IScope parent){
		this.resource = resource;
		this.parent = parent;
	}
	
	public IEObjectDescription getSingleElement(QualifiedName name) {
		Iterable<IEObjectDescription> elements = getAllElements();
		for(IEObjectDescription ed: elements){
			if(ed.getQualifiedName().equals(name)){
				return ed;
			}
		}
		
		return parent.getSingleElement(name);
	}

	public Iterable<IEObjectDescription> getElements(QualifiedName name) {
		List<IEObjectDescription> result = Lists.newLinkedList();
		Iterable<IEObjectDescription> elements = getAllElements();
		for(IEObjectDescription ed: elements){
			if(ed.getQualifiedName().equals(name)){
				result.add(ed);
			}
		}
		
		if(parent!=null){
			result.addAll(Lists.newLinkedList(parent.getElements(name)));
		}
		
		return result;
	}

	public IEObjectDescription getSingleElement(EObject object) {
		return null;

	}

	public final Iterable<IEObjectDescription> getElements(EObject object) {
		List<IEObjectDescription> result = Lists.newLinkedList();
		
		return result;
	}

	public Iterable<IEObjectDescription> getAllElements() {
		List<IEObjectDescription> result = Lists.newLinkedList();
		JvmModule module = (JvmModule) resource.getContents().get(0);
		XImportSection importSection = module.getImportSection();
		if(importSection == null){
			return result;
		}
		List<XImportDeclaration> importDecls = importSection.getImportDeclarations();
		for(XImportDeclaration importDecl : importDecls){
//			String uriStr = importDecl.getModuleName();
//			XtextResourceSet resourceSet = (XtextResourceSet) resource.getResourceSet();
//			IPath path = ResourcesPlugin.getWorkspace().getRoot().getLocation().append(uriStr);
//			URI uri = URI.createFileURI(path.toOSString());
//			Resource resource = resourceSet.getResource(uri, true);
//			result.add(EObjectDescription.create(importDecl.getModuleName(), resource.getContents().get(0)));
			Resource res = NamespaceUtil.getResource(importDecl);
			if(res.getContents().size()>0){
				result.add(EObjectDescription.create(importDecl.getModuleName(), resource.getContents().get(0)));
			}
			
			List<XImportItem> items = importDecl.getImportItems();
			for(XImportItem item : items){
				if(item.getAlias()!=null && !item.getAlias().isEmpty()){
					result.add(EObjectDescription.create(item.getAlias(), item.getImportedId()));
					result.add(EObjectDescription.create(QualifiedName.create(importDecl.getModuleName(),item.getAlias()) , item.getImportedId()));
				}else {
					EObject obj = item.getImportedId();
					if(obj == null || obj.eIsProxy()){
						continue;
					}
					JvmIdentifiableElement idEle = (JvmIdentifiableElement) obj;
					if(idEle instanceof JvmDeclaredType){
						JvmDeclaredType declType = (JvmDeclaredType) idEle;
						result.add(EObjectDescription.create(declType.getSimpleName(), item.getImportedId()));
						result.add(EObjectDescription.create(QualifiedName.create(importDecl.getModuleName(),declType.getSimpleName()) , item.getImportedId()));
					} else if(idEle instanceof XVariableDeclaration){
						XVariableDeclaration var  = (XVariableDeclaration) idEle;
						result.add(EObjectDescription.create(var.getSimpleName(), item.getImportedId()));
						result.add(EObjectDescription.create(QualifiedName.create(importDecl.getModuleName(),var.getSimpleName()) , item.getImportedId()));
					} else if(idEle instanceof XClosure){
						XClosure closure  = (XClosure) idEle;
						if(closure.getName() == null || closure.getName().isEmpty()){
							continue;
						}
						result.add(EObjectDescription.create(closure.getName(), item.getImportedId()));
						result.add(EObjectDescription.create(QualifiedName.create(importDecl.getModuleName(),closure.getName()) , item.getImportedId()));
					}
				}
			}
		}
		
		return result;
	}

}
