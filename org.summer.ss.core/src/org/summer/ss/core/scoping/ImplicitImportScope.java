package org.summer.ss.core.scoping;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.IScope;

public class ImplicitImportScope implements IScope{

	private final Resource resource;
	
	private ImplicitImportScope(Resource resource){
		this.resource = resource;
	}
	
	public IEObjectDescription getSingleElement(QualifiedName name) {
		// FIXME Auto-generated method stub
		return null;
	}

	public Iterable<IEObjectDescription> getElements(QualifiedName name) {
		// FIXME Auto-generated method stub
		return null;
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
		// FIXME Auto-generated method stub
		return null;
	}

}
