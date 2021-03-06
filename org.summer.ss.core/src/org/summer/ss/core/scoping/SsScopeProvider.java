/*
 * generated by Xtext
 */
package org.summer.ss.core.scoping;

import java.util.List;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.summer.ss.core.jvmmodel.IXtendJvmAssociations;
import org.summer.dsl.model.ss.XtendClass;
import org.summer.dsl.model.ss.XtendField;
import org.summer.dsl.model.ss.XtendFormalParameter;
import org.summer.dsl.model.ss.XtendFunction;
import org.summer.dsl.model.ss.XtendMember;
import org.summer.dsl.model.ss.XtendParameter;
import org.summer.dsl.model.ss.XtendVariableDeclaration;
import org.eclipse.xtext.EcoreUtil2;
import org.summer.dsl.model.types.JvmAnnotationTarget;
import org.summer.dsl.model.types.JvmDeclaredType;
import org.summer.dsl.model.types.JvmField;
import org.summer.dsl.model.types.JvmFormalParameter;
import org.summer.dsl.model.types.JvmGenericType;
import org.summer.dsl.model.types.JvmIdentifiableElement;
import org.summer.dsl.model.types.JvmType;
import org.summer.dsl.model.types.JvmTypeReference;
import org.summer.dsl.model.types.JvmVisibility;
import org.summer.dsl.model.types.util.AnnotationLookup;
import org.summer.dsl.model.types.util.TypeReferences;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.util.IAcceptor;
import org.summer.dsl.model.xbase.XExpression;
import org.summer.dsl.model.xbase.XFeatureCall;
import org.summer.dsl.model.xbase.XMemberFeatureCall;
import org.summer.dsl.model.xbase.XbaseFactory;
import org.summer.dsl.model.xbase.XbasePackage;
import org.summer.dsl.xannotation.scoping.XbaseWithAnnotationsScopeProvider;
import org.summer.dsl.xbase.lib.Extension;
import org.summer.dsl.xbase.scoping.LocalVariableScopeContext;
import org.summer.dsl.xbase.scoping.featurecalls.IJvmFeatureDescriptionProvider;
import org.summer.dsl.xbase.scoping.featurecalls.IValidatedEObjectDescription;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.Singleton;

/**
 * @author Sven Efftinge
 * @author Sebastian Zarnekow - Implicit first argument
 */
@Deprecated
@Singleton
public class SsScopeProvider extends XbaseWithAnnotationsScopeProvider {

	private static final int IMPORTED_STATIC_FEATURE_PRIORITY = 50;
	private static final int DEFAULT_EXTENSION_PRIORITY = 45;
	private static final int IMPLICIT_ARGUMENT_PRIORITY = 400;
	
	private static final int THIS_EXTENSION_PRIORITY_OFFSET = 200;
	private static final int DYNAMIC_EXTENSION_PRIORITY_OFFSET = 210;
	private static final int STATIC_EXTENSION_PRIORITY_OFFSET = 220;
	
	@Inject
	private IXtendJvmAssociations xtendjvmAssociations;

	@Inject
	private Provider<StaticallyImportedFeaturesProvider> staticallyImportedFeaturesProvider;

	@Inject
	private Provider<ExtensionMethodsFeaturesProvider> extensionMethodsFeaturesProvider;

	@Inject
	private TypeReferences typeReferences;
	
	@Inject
	private AnnotationLookup annotationLookup;

	@Override
	protected void addStaticFeatureDescriptionProviders(
			Resource resource, 
			JvmDeclaredType contextType,
			IAcceptor<IJvmFeatureDescriptionProvider> acceptor) {
		super.addStaticFeatureDescriptionProviders(resource, contextType, acceptor);
		
		StaticallyImportedFeaturesProvider staticProvider = staticallyImportedFeaturesProvider.get();
		staticProvider.setResourceContext(resource);
		staticProvider.setExtensionProvider(false);
		
		addFeatureDescriptionProviders(contextType, staticProvider, null, null, IMPORTED_STATIC_FEATURE_PRIORITY, true, acceptor);
	}
	
	@Override
	protected void addFeatureDescriptionProvidersForAssignment(
			Resource resource, JvmDeclaredType contextType,
			XExpression implicitReceiver, XExpression implicitArgument, int priority,
			IAcceptor<IJvmFeatureDescriptionProvider> acceptor) {
		super.addFeatureDescriptionProvidersForAssignment(resource, contextType, implicitReceiver, implicitArgument, priority, acceptor);
		
		if (implicitReceiver == null || implicitArgument != null) {
			final StaticallyImportedFeaturesProvider staticProvider = staticallyImportedFeaturesProvider.get();
			staticProvider.setResourceContext(resource);
			staticProvider.setExtensionProvider(true);
			if (implicitArgument != null) {
				// use the implicit argument as implicit receiver
				SimpleAcceptor casted = (SimpleAcceptor) acceptor;
				JvmTypeReference implicitArgumentType = getTypeProvider().getType(implicitArgument, true);
				IAcceptor<IJvmFeatureDescriptionProvider> myAcceptor = casted.getParent().curry(implicitArgumentType, casted.getExpression());
				addFeatureDescriptionProvidersForAssignment(contextType, staticProvider, implicitArgument, null, priority + STATIC_EXTENSION_PRIORITY_OFFSET, true, myAcceptor);
			} else {
				addFeatureDescriptionProvidersForAssignment(contextType, staticProvider, implicitReceiver, implicitArgument, priority + STATIC_EXTENSION_PRIORITY_OFFSET, true, acceptor);
			}
		}
		// extensions for this
		if (contextType instanceof JvmGenericType) { 
			JvmGenericType inferredJvmType = (JvmGenericType) contextType;
			XtendClass xtendClass = xtendjvmAssociations.getXtendClass(inferredJvmType);
			if (xtendClass == null) {
				return;
			}
			boolean isThis = false;
			if (implicitReceiver instanceof XFeatureCall) {
				isThis = ((XFeatureCall) implicitReceiver).getFeature() == inferredJvmType;
			}
			if (implicitReceiver == null || isThis) {
				XFeatureCall callToThis = XbaseFactory.eINSTANCE.createXFeatureCall();
				callToThis.setFeature(inferredJvmType);
				// injected extensions
				Iterable<JvmField> extensionFields = getExtensionDependencies(xtendClass);
				int extensionPriority = priority + DYNAMIC_EXTENSION_PRIORITY_OFFSET;
				if (isThis && implicitArgument == null)
					extensionPriority = DEFAULT_EXTENSION_PRIORITY;
				for (JvmField dependencyImplicitReceiver : extensionFields) {
					XMemberFeatureCall callToDependency = XbaseFactory.eINSTANCE.createXMemberFeatureCall();
					callToDependency.setMemberCallTarget(EcoreUtil2.clone(callToThis));
					callToDependency.setFeature(dependencyImplicitReceiver);
					if (dependencyImplicitReceiver != null) {
						ExtensionMethodsFeaturesProvider extensionFeatureProvider = extensionMethodsFeaturesProvider.get();
						extensionFeatureProvider.setContext(dependencyImplicitReceiver.getType());
						extensionFeatureProvider.setExpectNoParameters(isThis);
						addFeatureDescriptionProvidersForAssignment(contextType, extensionFeatureProvider, callToDependency, implicitArgument, extensionPriority, false, acceptor);
					}
				}
				JvmTypeReference typeRef = typeReferences.createTypeRef(inferredJvmType);
				ExtensionMethodsFeaturesProvider featureProvider = extensionMethodsFeaturesProvider.get();
				featureProvider.setContext(typeRef);
				featureProvider.setExpectNoParameters(isThis);
				addFeatureDescriptionProvidersForAssignment(contextType, featureProvider, callToThis, implicitArgument, priority + THIS_EXTENSION_PRIORITY_OFFSET, false, acceptor);
			}
		}
	}
	
	@Override
	protected void addFeatureScopes(
			JvmTypeReference receiverType, 
			EObject expression, 
			final JvmDeclaredType contextType,
			final XExpression implicitReceiver,
			final XExpression implicitArgument, 
			final int priority, 
			final IJvmFeatureScopeAcceptor acceptor) {
		super.addFeatureScopes(receiverType, expression, contextType, implicitReceiver, implicitArgument, priority, acceptor);
		final IAcceptor<IJvmFeatureDescriptionProvider> curried = acceptor.curry(receiverType, expression);
		LocalVariableAcceptor extensionScopeBuilder = new LocalVariableAcceptor() {
			
			public void accept(String s, List<? extends IValidatedEObjectDescription> descriptions) {
				if (descriptions.isEmpty())
					return;
				for(IValidatedEObjectDescription description: descriptions) {
					addLocalExtension(description);
				}
			}
			
			public void accept(String s, IValidatedEObjectDescription description) {
				if (description != null) {
					addLocalExtension(description);
				}
			}
			
			protected void addLocalExtension(IValidatedEObjectDescription description) {
				if (isExtensionProvider(description)) {
					JvmIdentifiableElement receiver = description.getEObjectOrProxy();
					if (receiver != null) {
						XFeatureCall localVariableAccessor = XbaseFactory.eINSTANCE.createXFeatureCall();
						localVariableAccessor.setFeature(receiver);
						ExtensionMethodsFeaturesProvider extensionFeatureProvider = extensionMethodsFeaturesProvider.get();
						JvmTypeReference receiverType = getTypeProvider().getTypeForIdentifiable(receiver);
						extensionFeatureProvider.setContext(receiverType);
						boolean isThis = false;
						if (implicitReceiver instanceof XFeatureCall) {
							isThis = ((XFeatureCall) implicitReceiver).getFeature() instanceof JvmType;
						}
						extensionFeatureProvider.setExpectNoParameters(isThis);
						addFeatureDescriptionProviders(
								contextType, 
								extensionFeatureProvider, 
								localVariableAccessor, 
								implicitArgument, 
								priority + DYNAMIC_EXTENSION_PRIORITY_OFFSET, 
								false, 
								curried);
					}
				}
			}
			
			protected boolean isExtensionProvider(IValidatedEObjectDescription description) {
				JvmIdentifiableElement identifiableElement = description.getEObjectOrProxy();
				if (identifiableElement instanceof XtendFormalParameter) {
					return ((XtendFormalParameter) identifiableElement).isExtension();
				} else if (identifiableElement instanceof XtendVariableDeclaration) {
					return ((XtendVariableDeclaration) identifiableElement).isExtension();
				} else if (identifiableElement instanceof JvmFormalParameter) {
					EObject sourceParameter = xtendjvmAssociations.getPrimarySourceElement(identifiableElement);
					if (sourceParameter instanceof XtendParameter) {
						return ((XtendParameter) sourceParameter).isExtension();
					}
				}
				return false;
			}
		};
		LocalVariableScopeContext scopeContext = createLocalVariableScopeContext(expression, XbasePackage.Literals.XABSTRACT_FEATURE_CALL__FEATURE, true, -1);
		createLocalVarScope(extensionScopeBuilder, scopeContext);
		if (expression instanceof XtendVariableDeclaration) {
			IValidatedEObjectDescription localVarDescription = createLocalVarDescription((XtendVariableDeclaration)expression);
			extensionScopeBuilder.accept("local variable", localVarDescription);
		}
	}

	@Override
	protected void addFeatureDescriptionProviders(
			Resource resource, 
			JvmDeclaredType contextType,
			XExpression implicitReceiver,
			XExpression implicitArgument,
			int priority,
			IAcceptor<IJvmFeatureDescriptionProvider> acceptor) {
		super.addFeatureDescriptionProviders(resource, contextType, implicitReceiver, implicitArgument, priority, acceptor);
		
		if (implicitReceiver == null || implicitArgument != null) {
			final StaticallyImportedFeaturesProvider staticProvider = staticallyImportedFeaturesProvider.get();
			staticProvider.setResourceContext(resource);
			staticProvider.setExtensionProvider(true);
			if (implicitArgument != null) {
				// use the implicit argument as implicit receiver
				SimpleAcceptor casted = (SimpleAcceptor) acceptor;
				JvmTypeReference implicitArgumentType = getTypeProvider().getType(implicitArgument, true);
				IAcceptor<IJvmFeatureDescriptionProvider> myAcceptor = casted.getParent().curry(implicitArgumentType, casted.getExpression());
				addFeatureDescriptionProviders(contextType, staticProvider, implicitArgument, null, priority + STATIC_EXTENSION_PRIORITY_OFFSET, true, myAcceptor);
			} else {
				addFeatureDescriptionProviders(contextType, staticProvider, implicitReceiver, implicitArgument, priority + STATIC_EXTENSION_PRIORITY_OFFSET, true, acceptor);
			}
		}
		
		// extensions for this
		if (contextType instanceof JvmGenericType) {
			JvmGenericType inferredJvmType = (JvmGenericType) contextType;
			final XtendClass xtendClass = this.xtendjvmAssociations.getXtendClass(inferredJvmType);
			if (xtendClass == null) {
				return;
			}
			boolean isThis = false;
			if (implicitReceiver instanceof XFeatureCall) {
				isThis = ((XFeatureCall) implicitReceiver).getFeature() == inferredJvmType;
			}
			if (implicitReceiver == null || isThis) {
				XFeatureCall callToThis = XbaseFactory.eINSTANCE.createXFeatureCall();
				callToThis.setFeature(inferredJvmType);
				// injected extensions
				Iterable<JvmField> extensionFields = getExtensionDependencies(xtendClass);
				int extensionPriority = priority + DYNAMIC_EXTENSION_PRIORITY_OFFSET;
				if (isThis && implicitArgument == null)
					extensionPriority = DEFAULT_EXTENSION_PRIORITY;
				boolean isStatic = isStaticContext(((SimpleAcceptor)acceptor).getExpression());
				for (JvmField dependencyImplicitReceiver : extensionFields) {
					XMemberFeatureCall callToDependency = XbaseFactory.eINSTANCE.createXMemberFeatureCall();
					callToDependency.setMemberCallTarget(EcoreUtil2.clone(callToThis));
					callToDependency.setFeature(dependencyImplicitReceiver);
					if (dependencyImplicitReceiver != null) {
						ExtensionMethodsFeaturesProvider extensionFeatureProvider = extensionMethodsFeaturesProvider.get();
						extensionFeatureProvider.setContext(dependencyImplicitReceiver.getType());
						extensionFeatureProvider.setExpectNoParameters(isThis);
						addFeatureDescriptionProviders(contextType, extensionFeatureProvider, callToDependency, implicitArgument, extensionPriority, isStatic, acceptor);
					}
				}
				JvmTypeReference typeRef = typeReferences.createTypeRef(inferredJvmType);
				ExtensionMethodsFeaturesProvider featureProvider = extensionMethodsFeaturesProvider.get();
				featureProvider.setContext(typeRef);
				featureProvider.setExpectNoParameters(isThis);
				addFeatureDescriptionProviders(contextType, featureProvider, callToThis, implicitArgument, priority + THIS_EXTENSION_PRIORITY_OFFSET, isStatic, acceptor);
			}
		}
	}
	
	protected boolean isStaticContext(EObject expression) {
		XtendMember feature = EcoreUtil2.getContainerOfType(expression, XtendMember.class);
		if (feature instanceof XtendFunction)
			return ((XtendFunction) feature).isStatic();
		if (feature instanceof XtendField)
			return ((XtendField) feature).isStatic();
		return false;
	}
	
	protected Iterable<JvmField> getExtensionDependencies(XtendClass context) {
		List<JvmField> result = Lists.newLinkedList();
		JvmGenericType type = xtendjvmAssociations.getInferredType(context);
		collectExtensionDependencies(type, result, true, Sets.<String>newHashSet(), Sets.<JvmType>newHashSet());
		return result;
	}
	
	protected void collectExtensionDependencies(JvmDeclaredType type, List<JvmField> result, boolean allowPrivate, Set<String> seenNames, Set<JvmType> seenTypes) {
		if (seenTypes.add(type)) {
			Iterable<JvmField> fields = type.getDeclaredFields();
			for(JvmField field: fields) {
				if ((allowPrivate || (field.getVisibility() != JvmVisibility.PRIVATE)) && seenNames.add(field.getSimpleName()) && isExtensionProvider(field)) {
					result.add(field);
				}
			}
			JvmTypeReference superType = getExtendedClass(type);
			if (superType != null) {
				collectExtensionDependencies((JvmDeclaredType) superType.getType(), result, false, seenNames, seenTypes);
			}
		}
	}
	
	protected boolean isExtensionProvider(JvmAnnotationTarget annotatedElement) {
		// coding style to simplify debugging
		if (annotationLookup.findAnnotation(annotatedElement, Extension.class) != null) {
			return true;
		}
		return false;
	}
	
	public JvmTypeReference getExtendedClass(JvmDeclaredType type) {
		for(JvmTypeReference candidate: type.getSuperTypes()) {
			if (candidate.getType() instanceof JvmGenericType && !((JvmGenericType) candidate.getType()).isInterface())
				return candidate;
		}
		return null;
	}

	@Override
	protected JvmDeclaredType getContextType(EObject call) {
		if (call == null)
			return null;
		
		//cym comment
//		XtendClass containerClass = EcoreUtil2.getContainerOfType(call, XtendClass.class);
//		if (containerClass != null && containerClass.getName() != null)
//			return xtendjvmAssociations.getInferredType(containerClass);
//		else
//			return super.getContextType(call);
		
		JvmDeclaredType containerClass = EcoreUtil2.getContainerOfType(call, JvmDeclaredType.class);
		if (containerClass != null && containerClass.getSimpleName() != null)
			return containerClass;
		else
			return super.getContextType(call);
	}
	
	@Override
	protected void addFeatureCallScopes(
			EObject featureCall, 
			final IScope localVariableScope,
			final IJvmFeatureScopeAcceptor featureScopeDescriptions) {
		IEObjectDescription implicitThis = localVariableScope.getSingleElement(THIS);
		if (implicitThis != null) {
			EObject implicitReceiver = implicitThis.getEObjectOrProxy();
			if (implicitReceiver instanceof JvmIdentifiableElement) {
				JvmTypeReference receiverType = getTypeProvider().getTypeForIdentifiable((JvmIdentifiableElement) implicitReceiver);
				receiverType = unkownToObject(receiverType, featureCall);
				if (receiverType != null) {
					XFeatureCall receiver = XbaseFactory.eINSTANCE.createXFeatureCall();
					receiver.setFeature((JvmIdentifiableElement) implicitReceiver);
					IEObjectDescription implicitIt = localVariableScope.getSingleElement(IT);
					if (implicitIt != null) {
						EObject implicitArgument = implicitIt.getEObjectOrProxy();
						if (implicitArgument instanceof JvmIdentifiableElement) {
							JvmTypeReference argumentType = getTypeProvider().getTypeForIdentifiable((JvmIdentifiableElement) implicitArgument);
							if (argumentType != null) {
								XFeatureCall argument = XbaseFactory.eINSTANCE.createXFeatureCall();
								argument.setFeature((JvmIdentifiableElement) implicitArgument);
								addFeatureScopes(receiverType, featureCall, getContextType(featureCall), receiver, argument, IMPLICIT_ARGUMENT_PRIORITY, featureScopeDescriptions);
							}
						}
					}
				}
			}
		}
		super.addFeatureCallScopes(featureCall, localVariableScope, featureScopeDescriptions);
	}
}
