package org.summer.ss.core.scoping;

import static com.google.common.collect.Iterables.transform;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.EObjectDescription;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.impl.MapBasedScope;
import org.summer.dsl.model.types.JvmField;
import org.summer.dsl.model.types.JvmGenericType;
import org.summer.dsl.model.xaml.XAbstractAttribute;
import org.summer.dsl.model.xaml.XAttachAttribute;
import org.summer.dsl.model.xaml.XAttributeElement;
import org.summer.dsl.model.xaml.XElement;
import org.summer.dsl.model.xaml.XGeneralAttribute;
import org.summer.dsl.model.xaml.XamlPackage;
import org.summer.dsl.xannotation.typesystem.XbaseWithAnnotationsBatchScopeProvider;

import com.google.common.base.Function;

public class XSsBatchScopeProvider extends XbaseWithAnnotationsBatchScopeProvider{
	@Override
	public IScope getScope(EObject context, EReference reference) {
		if(reference==XamlPackage.Literals.XABSTRACT_ATTRIBUTE__FIELD){
			XAbstractAttribute abstarctParperty = (XAbstractAttribute) context;
			XElement element = (XElement) abstarctParperty.eContainer();
//			if(element instanceof XAttributeElement){
//				XAttributeElement attrElement = (XAttributeElement) element;
//				if(attrElement.getField().getDeclaringType() instanceof JvmGenericType){
//					return getFieldScope((JvmGenericType) attrElement.getField().getType().getType());
//				}else{
//					return IScope.NULLSCOPE;
//				}
//			}
			
			if(abstarctParperty instanceof XAttachAttribute){
				XAttachAttribute attachProperty = (XAttachAttribute) context;
				if(attachProperty.getType() instanceof JvmGenericType){
					return getFieldScope((JvmGenericType) attachProperty.getType());					
				}else{
					return IScope.NULLSCOPE;
				}
			}
			if(abstarctParperty instanceof XGeneralAttribute){
				if(element.getType() instanceof JvmGenericType){
					return getFieldScope((JvmGenericType) element.getType());
				}else{
					return IScope.NULLSCOPE;
				}
			}
		}else if(reference==XamlPackage.Literals.XATTRIBUTE_ELEMENT__FIELD || reference==XamlPackage.Literals.XATTRIBUTE_ELEMENT__CLOSE_FIELD){
			XElement element = (XElement) context;
			if(element.getType() instanceof JvmGenericType){
				return getFieldScope((JvmGenericType) element.getType());					
			}else{
				return IScope.NULLSCOPE;
			}
		}
		
		return super.getScope(context, reference);
	}

	private IScope getFieldScope(
			JvmGenericType type) {
		List<IEObjectDescription> descs=new LinkedList<IEObjectDescription>();
		Iterable<JvmField> fields = type.getDeclaredFields();
		Iterable<IEObjectDescription> descriptions = transform(fields, new Function<JvmField, IEObjectDescription>() {
			public IEObjectDescription apply(JvmField from) {
				return EObjectDescription.create(QualifiedName.create(from.getSimpleName()), from);
			}
		});
		Iterator<IEObjectDescription> ite=descriptions.iterator();
		while(ite.hasNext()){
			descs.add(ite.next());
		}
		return MapBasedScope.createScope(IScope.NULLSCOPE, descs);	
	}
}
