package org.summer.dsl.xbase.resource;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.EObjectDescription;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.IScope;
import org.summer.dsl.model.types.JvmDeclaredType;
import org.summer.dsl.model.types.JvmDelegateType;
import org.summer.dsl.model.types.JvmModule;
import org.summer.dsl.model.types.JvmType;
import org.summer.dsl.model.xbase.XClosure;
import org.summer.dsl.model.xbase.XExpression;
import org.summer.dsl.model.xbase.XFunctionDeclaration;
import org.summer.dsl.model.xbase.XVariableDeclaration;
import org.summer.dsl.model.xbase.XVariableDeclarationList;
import org.summer.dsl.xbase.scoping.AbstractScope;

import com.google.common.collect.Lists;

public class RootScope extends AbstractScope{
	
	private IScope parent;

	private final Resource resource;
	
	public RootScope(Resource resource, IScope parent){
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
		
		if(parent!=null){
			return parent.getSingleElement(name);
		}
		
		return null;
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


	public Iterable<IEObjectDescription> getAllElements() {
		List<IEObjectDescription> result = Lists.newLinkedList();
		JvmModule file = (JvmModule) resource.getContents().get(0);
		
		List<EObject> contents = file.getContents();
		for(EObject obj: contents){
			if(obj instanceof JvmDeclaredType){
				JvmDeclaredType jvmType = (JvmDeclaredType) obj;
				if(!(jvmType.getSimpleName() == null || jvmType.getSimpleName().isEmpty())){
					result.add(EObjectDescription.create(jvmType.getSimpleName(), jvmType));
				}
				
			} else if(obj instanceof JvmDelegateType){
				JvmDelegateType delegate  = (JvmDelegateType) obj;
				if(delegate.getSimpleName()!=null && !delegate.getSimpleName().isEmpty()){
					result.add(EObjectDescription.create(delegate.getSimpleName(), delegate));
				}
			} else if(obj instanceof XVariableDeclarationList){
				XVariableDeclarationList declList = (XVariableDeclarationList) obj;
				List<XExpression> decls = declList.getDeclarations();
				for(XExpression exp : decls){
					XVariableDeclaration varDecl = (XVariableDeclaration) exp;
					if(varDecl.getName()!=null && !varDecl.getName().isEmpty()){
						result.add(EObjectDescription.create(varDecl.getSimpleName(), varDecl));
					}
				}
				
			} else if(obj instanceof XFunctionDeclaration){
				XFunctionDeclaration function  = (XFunctionDeclaration) obj;
				if(function.getSimpleName() == null || function.getSimpleName().isEmpty()){
					continue;
				}
				result.add(EObjectDescription.create(function.getSimpleName(), function));
			}
		}
		
		return result;
	}

	@Override
	public void doGetElements(JvmType type, List<IEObjectDescription> result) {
		// FIXME Auto-generated method stub
		
	}

}
