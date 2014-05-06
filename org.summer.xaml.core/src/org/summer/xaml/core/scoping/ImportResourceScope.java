package org.summer.xaml.core.scoping;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.EObjectDescription;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.IScope;
import org.summer.dsl.model.ss.XModule;
import org.summer.dsl.model.types.JvmDeclaredType;
import org.summer.dsl.model.xbase.XClosure;
import org.summer.dsl.model.xbase.XVariableDeclaration;

import com.google.common.collect.Lists;

public class ImportResourceScope implements IScope{
	private final Resource resource;
	public ImportResourceScope(Resource resource){
		this.resource = resource;
	}

	public IEObjectDescription getSingleElement(QualifiedName name) {
		Iterable<IEObjectDescription> elements = getAllElements();
		for(IEObjectDescription ed: elements){
			if(ed.getQualifiedName().equals(name)){
				return ed;
			}
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

	public Iterable<IEObjectDescription> getAllElements() {
		List<IEObjectDescription> result = Lists.newLinkedList();
		XModule file = (XModule) resource.getContents().get(0);
		
		List<EObject> contents = file.getContents();
		for(EObject obj: contents){
			if(obj instanceof JvmDeclaredType){
				JvmDeclaredType jvmType = (JvmDeclaredType) obj;
				if(!jvmType.isExported()){
					continue;
				}
				result.add(EObjectDescription.create(jvmType.getSimpleName(), jvmType));
			}else if(obj instanceof XVariableDeclaration){
				XVariableDeclaration var  = (XVariableDeclaration) obj;
				if(!var.isExported()){
					continue;
				}
				result.add(EObjectDescription.create(var.getSimpleName(), var));
			} else if(obj instanceof XClosure){
				XClosure closure  = (XClosure) obj;
				if(!closure.isExported()){
					continue;
				}
				if(closure.getName() == null || closure.getName().isEmpty()){
					continue;
				}
				result.add(EObjectDescription.create(closure.getName(), obj));
			}
		}
		
		return result;
	}

}
