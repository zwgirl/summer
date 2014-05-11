package org.summer.xaml.core.scoping;
import static com.google.common.collect.Iterables.*;
import static com.google.common.collect.Lists.*;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.summer.dsl.model.types.JvmField;
import org.summer.dsl.model.types.JvmGenericType;
import org.summer.dsl.model.types.util.TypeReferences;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.EObjectDescription;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.impl.MapBasedScope;
import org.summer.dsl.xannotation.scoping.XbaseWithAnnotationsScopeProvider;
import org.summer.xaml.core.xAML.AttributeElement;
import org.summer.xaml.core.xAML.MarkupExtenson;
import org.summer.xaml.core.xAML.ObjectElement;
import org.summer.xaml.core.xAML.Property;
import org.summer.xaml.core.xAML.XAMLPackage;

import com.google.common.base.Function;
import com.google.inject.Inject;

@SuppressWarnings("all")
public class XAMLScopingProvider extends XbaseWithAnnotationsScopeProvider{

	@Inject
	private TypeReferences typeReferences;
	
	@Override
	public IScope getScope(EObject context, EReference reference) {
		System.out.println("Context= " + context + " reference : " +reference);
		if(context instanceof ObjectElement && (reference==XAMLPackage.Literals.OBJECT_ELEMENT__PROPERTIES)){
			ObjectElement element = (ObjectElement) context;
			if(element.getType().getType() instanceof JvmGenericType){
				JvmGenericType genericType = (JvmGenericType) element.getType().getType(); //.getType();
			
				List descs=new LinkedList<IEObjectDescription>();
				Iterable<JvmField> fields = genericType.getDeclaredFields();
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
		}else if(context instanceof ObjectElement && (reference==XAMLPackage.Literals.PROPERTY__PROPERTY)){
			ObjectElement element = (ObjectElement) context;
			if(element.getType().getType() instanceof JvmGenericType){
				JvmGenericType genericType = (JvmGenericType) element.getType().getType(); //.getType();
			
				List descs=new LinkedList<IEObjectDescription>();
				Iterable<JvmField> fields = genericType.getDeclaredFields();
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
		else if(context instanceof Property && (reference==XAMLPackage.Literals.PROPERTY__PROPERTY)){
			Property property = (Property) context;
			if(property.eContainer() instanceof ObjectElement){
				ObjectElement element = (ObjectElement) property.eContainer();
				if(element.getType().getType() instanceof JvmGenericType){
					JvmGenericType genericType = (JvmGenericType) element.getType().getType(); //.getType();
				
					List descs=new LinkedList<IEObjectDescription>();
					Iterable<JvmField> fields = genericType.getDeclaredFields();
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
			}else if(property.eContainer() instanceof MarkupExtenson){
				MarkupExtenson markupExtension = (MarkupExtenson) property.eContainer();
				if(markupExtension.getType().getType() instanceof JvmGenericType){
					JvmGenericType genericType = (JvmGenericType) markupExtension.getType().getType(); //.getType();
				
					List descs=new LinkedList<IEObjectDescription>();
					Iterable<JvmField> fields = genericType.getDeclaredFields();
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
			
		}else if(context instanceof AttributeElement && (reference==XAMLPackage.Literals.ATTRIBUTE_ELEMENT__ATTRIBUTE)){
			AttributeElement attributeElement = (AttributeElement) context;
			if(attributeElement.getType() instanceof JvmGenericType){
				JvmGenericType genericType = (JvmGenericType) attributeElement.getType(); //.getType();
			
				List descs=new LinkedList<IEObjectDescription>();
				Iterable<JvmField> fields = genericType.getDeclaredFields();
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
		}else if(context instanceof MarkupExtenson && (reference==XAMLPackage.Literals.PROPERTY__PROPERTY)){
			MarkupExtenson markupExtension = (MarkupExtenson) context;
			if(markupExtension.getType().getType() instanceof JvmGenericType){
				JvmGenericType genericType = (JvmGenericType) markupExtension.getType().getType(); //.getType();
			
				List descs=new LinkedList<IEObjectDescription>();
				Iterable<JvmField> fields = genericType.getDeclaredFields();
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

		
		
		return super.getScope(context, reference);
	}
	
	
	
}