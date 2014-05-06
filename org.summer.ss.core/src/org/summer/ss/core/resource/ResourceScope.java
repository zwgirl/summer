package org.summer.ss.core.resource;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.Scopes;
import org.eclipse.xtext.scoping.impl.AbstractScope;
import org.eclipse.xtext.util.SimpleAttributeResolver;
import org.summer.dsl.model.ss.XModule;
import org.summer.dsl.model.types.JvmModule;

import com.google.common.collect.Lists;

public class ResourceScope extends AbstractScope {
	private final Resource resource;
	
	public ResourceScope(IScope parent, boolean ignoreCase, Resource resource){
		super(parent, ignoreCase);
		
		if(resource == null){
			throw new IllegalArgumentException("resource may not be null!");
		}
		
		this.resource = resource;
	}

	@Override
	protected Iterable<IEObjectDescription> getAllLocalElements() {
		

		XModule file = (XModule) resource.getContents().get(0);
		EObject module = file.getContents().get(0);
		if(module instanceof JvmModule){
			return Scopes.scopedElementsFor(Lists.newArrayList(module), QualifiedName.wrapper(SimpleAttributeResolver.newResolver(String.class, "simpleName")));
		}
		return null;
	}

}
