package org.summer.dsl.xbase.resource;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.EObjectDescription;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.IScope;
import org.summer.dsl.model.ss.XtendFile;
import org.summer.dsl.model.types.JvmDeclaredType;
import org.summer.dsl.model.xbase.XClosure;
import org.summer.dsl.model.xbase.XExpression;
import org.summer.dsl.model.xbase.XVariableDeclaration;
import org.summer.dsl.model.xbase.XVariableDeclarationList;

import com.google.common.collect.Lists;

public class RootScope implements IScope{
	
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
		XtendFile file = (XtendFile) resource.getContents().get(0);
		
		List<EObject> contents = file.getContents();
		for(EObject obj: contents){
			if(obj instanceof JvmDeclaredType){
				JvmDeclaredType jvmType = (JvmDeclaredType) obj;
				result.add(EObjectDescription.create(jvmType.getSimpleName(), jvmType));
				
			}else if(obj instanceof XVariableDeclarationList){
				XVariableDeclarationList varDeclList  = (XVariableDeclarationList) obj;
				for(XExpression exp : varDeclList.getDeclarations()){
					XVariableDeclaration var = (XVariableDeclaration) exp;
					if(var.getName()!=null && !var.getName().isEmpty()){
						result.add(EObjectDescription.create(var.getSimpleName(), var));
					}
				}
			} else if(obj instanceof XClosure){
				XClosure closure  = (XClosure) obj;
				if(closure.getName() == null || closure.getName().isEmpty()){
					continue;
				}
				result.add(EObjectDescription.create(closure.getName(), obj));
			}
		}
		
		return result;
	}

	public IEObjectDescription getSingleElement(EObject object) {
		// FIXME Auto-generated method stub
		return null;
	}

	public Iterable<IEObjectDescription> getElements(EObject object) {
		// FIXME Auto-generated method stub
		return null;
	}

}
