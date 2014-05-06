package org.summer.ss.core.resource;

import java.util.List;
import java.util.Map.Entry;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.EObjectDescription;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.IScope;
import org.summer.dsl.model.types.JvmType;
import org.summer.dsl.model.types.access.impl.Primitives;
import org.summer.dsl.xbase.scoping.batch.Buildin;
import org.summer.ss.core.scoping.AbstractScope;

import com.google.common.collect.Lists;

public class PrimitivesScope extends AbstractScope{
	private final IScope parent;
	private final Resource resource;
	public PrimitivesScope(IScope parent, Resource resource){
		this.parent = parent;
		this.resource = resource;
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

//cym comment
//	public Iterable<IEObjectDescription> getAllElements() {
//		List<IEObjectDescription> result = Lists.newLinkedList();
//		for(Entry<String, String> entry: Primitives.ALL_PRIMITIVE_TYPES1.entrySet()) {
//			JvmType object = BuildInTypes.getInstance().getJvmType(resource, entry.getValue());
//			IEObjectDescription primitive = EObjectDescription.create(QualifiedName.create(entry.getKey()), object);
//			if (primitive != null)
//				result.add(primitive);
//		}
//		
//		return result;
//	}
	
	public Iterable<IEObjectDescription> getAllElements() {
		List<IEObjectDescription> result = Lists.newLinkedList();
		for(Entry<String, String> entry: Primitives.ALL_PRIMITIVE_TYPES1.entrySet()) {
			JvmType object = Buildin.valueOf(entry.getValue()).JvmType;
			IEObjectDescription primitive = EObjectDescription.create(QualifiedName.create(entry.getKey()), object);
			if (primitive != null)
				result.add(primitive);
		}
		
		return result;
	}

	@Override
	protected void doGetElements(JvmType type, List<IEObjectDescription> result) {
		// FIXME Auto-generated method stub
		
	}

}
