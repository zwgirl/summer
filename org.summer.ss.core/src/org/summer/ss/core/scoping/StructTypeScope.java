package org.summer.ss.core.scoping;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.Scopes;
import org.eclipse.xtext.util.SimpleAttributeResolver;
import org.summer.dsl.model.types.JvmDeclaredType;

import com.google.common.collect.Lists;

public class StructTypeScope implements IScope {
	private final JvmDeclaredType structType;
	public StructTypeScope(JvmDeclaredType type) {
		this.structType = type;
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

	@Override
	public Iterable<IEObjectDescription> getAllElements() {
		
		return Scopes.scopedElementsFor(structType.getMembers(), QualifiedName.wrapper(SimpleAttributeResolver.newResolver(String.class, "simpleName")));
	}

	@Override
	public IEObjectDescription getSingleElement(EObject object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<IEObjectDescription> getElements(EObject object) {
		// TODO Auto-generated method stub
		return null;
	}

}
