/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.summer.ss.core.validation;

import static com.google.common.collect.Iterables.filter;
import static com.google.common.collect.Iterables.size;
import static com.google.common.collect.Iterables.toArray;
import static com.google.common.collect.Lists.newArrayList;
import static com.google.common.collect.Lists.transform;
import static com.google.common.collect.Sets.newLinkedHashSet;
import static org.eclipse.xtext.util.Strings.equal;
import static org.eclipse.xtext.util.Strings.notNull;
import static org.summer.dsl.xbase.validation.IssueCodes.ANNOTATIONS_MISSING_ATTRIBUTE_DEFINITION;
import static org.summer.dsl.xbase.validation.IssueCodes.ASSIGNMENT_TO_FINAL;
import static org.summer.dsl.xbase.validation.IssueCodes.INCOMPATIBLE_RETURN_TYPE;
import static org.summer.dsl.xbase.validation.IssueCodes.INVALID_IDENTIFIER;
import static org.summer.dsl.xbase.validation.IssueCodes.INVALID_USE_OF_TYPE;
import static org.summer.dsl.xbase.validation.IssueCodes.TOO_LITTLE_TYPE_INFORMATION;
import static org.summer.dsl.xbase.validation.IssueCodes.VARIABLE_NAME_DISCOURAGED;
import static org.summer.ss.core.validation.IssueCodes.ABSTRACT_METHOD_MISSING_RETURN_TYPE;
import static org.summer.ss.core.validation.IssueCodes.ABSTRACT_METHOD_WITH_BODY;
import static org.summer.ss.core.validation.IssueCodes.CLASS_EXPECTED;
import static org.summer.ss.core.validation.IssueCodes.CLASS_MUST_BE_ABSTRACT;
import static org.summer.ss.core.validation.IssueCodes.CONSTRUCTOR_NOT_PERMITTED;
import static org.summer.ss.core.validation.IssueCodes.CONSTRUCTOR_TYPE_PARAMS_NOT_SUPPORTED;
import static org.summer.ss.core.validation.IssueCodes.CYCLIC_INHERITANCE;
import static org.summer.ss.core.validation.IssueCodes.DUPLICATE_FIELD;
import static org.summer.ss.core.validation.IssueCodes.DUPLICATE_METHOD;
import static org.summer.ss.core.validation.IssueCodes.DUPLICATE_PARAMETER_NAME;
import static org.summer.ss.core.validation.IssueCodes.EXCEPTION_DECLARED_TWICE;
import static org.summer.ss.core.validation.IssueCodes.EXCEPTION_NOT_THROWABLE;
import static org.summer.ss.core.validation.IssueCodes.INCOMPATIBLE_THROWS_CLAUSE;
import static org.summer.ss.core.validation.IssueCodes.INTERFACE_EXPECTED;
import static org.summer.ss.core.validation.IssueCodes.INVALID_EXTENSION_TYPE;
import static org.summer.ss.core.validation.IssueCodes.INVALID_MEMBER_NAME;
import static org.summer.ss.core.validation.IssueCodes.INVALID_MODIFIER;
import static org.summer.ss.core.validation.IssueCodes.INVALID_USE_OF_VAR_ARG;
import static org.summer.ss.core.validation.IssueCodes.LEFT_HAND_SIDE_MUST_BE_VARIABLE;
import static org.summer.ss.core.validation.IssueCodes.MISSING_ABSTRACT;
import static org.summer.ss.core.validation.IssueCodes.MISSING_CONSTRUCTOR;
import static org.summer.ss.core.validation.IssueCodes.MISSING_OVERRIDE;
import static org.summer.ss.core.validation.IssueCodes.MUST_INVOKE_SUPER_CONSTRUCTOR;
import static org.summer.ss.core.validation.IssueCodes.OBSOLETE_OVERRIDE;
import static org.summer.ss.core.validation.IssueCodes.OVERRIDDEN_FINAL;
import static org.summer.ss.core.validation.IssueCodes.OVERRIDE_REDUCES_VISIBILITY;
import static org.summer.ss.core.validation.IssueCodes.STATIC_PROPERTY;
import static org.summer.ss.core.validation.IssueCodes.UNUSED_PRIVATE_MEMBER;
import static org.summer.ss.core.validation.IssueCodes.WILDCARD_IN_SUPERTYPE;

import java.util.Collection;
import java.util.Collections;
import java.util.EnumSet;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.xtext.diagnostics.Severity;
import org.eclipse.xtext.documentation.IEObjectDocumentationProvider;
import org.eclipse.xtext.documentation.IEObjectDocumentationProviderExtension;
import org.eclipse.xtext.documentation.IJavaDocTypeReferenceProvider;
import org.eclipse.xtext.naming.IQualifiedNameConverter;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.IScopeProvider;
import org.eclipse.xtext.util.ReplaceRegion;
import org.eclipse.xtext.validation.Check;
import org.eclipse.xtext.validation.ComposedChecks;
import org.eclipse.xtext.validation.ValidationMessageAcceptor;
import org.summer.dsl.model.types.JvmAnnotationReference;
import org.summer.dsl.model.types.JvmAnnotationTarget;
import org.summer.dsl.model.types.JvmAnnotationType;
import org.summer.dsl.model.types.JvmConstructor;
import org.summer.dsl.model.types.JvmDeclaredType;
import org.summer.dsl.model.types.JvmEnumerationType;
import org.summer.dsl.model.types.JvmExecutable;
import org.summer.dsl.model.types.JvmField;
import org.summer.dsl.model.types.JvmFormalParameter;
import org.summer.dsl.model.types.JvmGenericType;
import org.summer.dsl.model.types.JvmIdentifiableElement;
import org.summer.dsl.model.types.JvmInterfaceType;
import org.summer.dsl.model.types.JvmMember;
import org.summer.dsl.model.types.JvmModule;
import org.summer.dsl.model.types.JvmOperation;
import org.summer.dsl.model.types.JvmParameterizedTypeReference;
import org.summer.dsl.model.types.JvmType;
import org.summer.dsl.model.types.JvmTypeParameter;
import org.summer.dsl.model.types.JvmTypeReference;
import org.summer.dsl.model.types.JvmVisibility;
import org.summer.dsl.model.types.JvmWildcardTypeReference;
import org.summer.dsl.model.types.TypesPackage;
import org.summer.dsl.model.xbase.XAssignment;
import org.summer.dsl.model.xbase.XBlockStatment;
import org.summer.dsl.model.xbase.XClosure;
import org.summer.dsl.model.xbase.XExpression;
import org.summer.dsl.model.xbase.XExpressionStatment;
import org.summer.dsl.model.xbase.XFeatureCall;
import org.summer.dsl.model.xbase.XReturnStatment;
import org.summer.dsl.model.xbase.XStatment;
import org.summer.dsl.model.xbase.XVariableDeclaration;
import org.summer.dsl.model.xbase.XbasePackage;
import org.summer.dsl.model.xbase.XbasePackage.Literals;
import org.summer.dsl.xbase.compiler.JavaKeywords;
import org.summer.dsl.xbase.jvmmodel.ILogicalContainerProvider;
import org.summer.dsl.xbase.jvmmodel.JvmTypeExtensions;
import org.summer.dsl.xbase.scoping.batch.IFeatureNames;
import org.summer.dsl.xbase.typesystem.legacy.StandardTypeReferenceOwner;
import org.summer.dsl.xbase.typesystem.override.IOverrideCheckResult.OverrideCheckDetails;
import org.summer.dsl.xbase.typesystem.override.IResolvedConstructor;
import org.summer.dsl.xbase.typesystem.override.IResolvedExecutable;
import org.summer.dsl.xbase.typesystem.override.IResolvedOperation;
import org.summer.dsl.xbase.typesystem.override.OverrideHelper;
import org.summer.dsl.xbase.typesystem.override.ResolvedOperations;
import org.summer.dsl.xbase.typesystem.references.ITypeReferenceOwner;
import org.summer.dsl.xbase.typesystem.references.LightweightTypeReference;
import org.summer.dsl.xbase.typesystem.references.OwnedConverter;
import org.summer.dsl.xbase.typesystem.util.ContextualVisibilityHelper;
import org.summer.dsl.xbase.typesystem.util.IVisibilityHelper;
import org.summer.dsl.xbase.validation.UIStrings;
import org.summer.dsl.xbase.validation.XbaseJavaValidator;
import org.summer.ss.core.jvmmodel.DispatchHelper;
import org.summer.ss.core.jvmmodel.IXtendJvmAssociations;
import org.summer.ss.core.typing.XAnnotationUtil;
import org.summer.ss.lib.Data;
import org.summer.ss.lib.Property;

import com.google.common.base.Function;
import com.google.common.collect.HashMultimap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.common.collect.Multimap;
import com.google.common.collect.Sets;
import com.google.inject.Inject;

/**
 * @author Jan Koehnlein - Initial contribution and API
 * @author Sebastian Zarnekow
 * @author Sven Efftinge
 * @author Holger Schill
 */
@ComposedChecks(validators = { AnnotationValidation.class })
public class SsJavaValidator extends XbaseJavaValidator {

//	@Inject
//	private RichStringProcessor richStringProcessor;

	@Inject
	private IXtendJvmAssociations associations;

	@Inject
	private OverrideHelper overrideHelper;

	@Inject
	private DispatchHelper dispatchHelper;

	@Inject
	private XAnnotationUtil annotationUtil;
	
	@Inject 
	private JavaKeywords javaUtils;
	
	@Inject 
	private UIStrings uiStrings;
	
	@Inject
	private ILogicalContainerProvider containerProvider;
	
	@Inject
	private JvmTypeExtensions typeExtensions;
	
	@Inject
	private IVisibilityHelper visibilityHelper;
	@Inject
	private IJavaDocTypeReferenceProvider javaDocTypeReferenceProvider;

	@Inject
	private IScopeProvider scopeProvider;

	@Inject
	private IEObjectDocumentationProvider documentationProvider;

	@Inject
	private IQualifiedNameConverter qualifiedNameConverter;
	
	protected final Set<String> visibilityModifers = ImmutableSet.of("public", "private", "protected", "package");
//	protected final Map<Class<?>, ElementType> targetInfos;
//	
//	{
//		ImmutableMap.Builder<Class<?>, ElementType> result = ImmutableMap.builder();
//		result.put(XtendClass.class, ElementType.TYPE);
//		result.put(XtendInterface.class, ElementType.TYPE);
//		result.put(XtendEnum.class, ElementType.TYPE);
//		result.put(XtendAnnotationType.class, ElementType.ANNOTATION_TYPE);
//		result.put(XtendField.class, ElementType.FIELD);
//		result.put(XtendFunction.class, ElementType.METHOD);
//		result.put(XtendParameter.class, ElementType.PARAMETER);
//		targetInfos = result.build();
//	}
	
//	@Inject
//	private XAnnotationUtil annotationUtil;
	
	@Inject
	private AnnotationValueValidator annotationValueValidator;
	
//	@Override
//	protected List<EPackage> getEPackages() {
//		final List<EPackage> ePackages = newArrayList(super.getEPackages());
//		ePackages.add(XannotationPackage.eINSTANCE);
//		return ePackages;
//	}

	@Check
	public void checkAllAttributesConfigured(JvmAnnotationReference annotation) {
		JvmType annotationType = annotation.getAnnotation();
		if (annotationType == null || annotationType.eIsProxy() || !(annotationType instanceof JvmAnnotationType))
			return;
		Iterable<JvmField> attributes = ((JvmAnnotationType) annotationType).getDeclaredFields();
		for (JvmField jvmField : attributes) {
			XExpression value = annotationUtil.findValue(annotation, jvmField);
			if(value == null) {
				if (jvmField.getDefaultValue() == null) {
					error("The annotation must define the attribute '"+jvmField.getSimpleName()+"'.", annotation, null, 
							ValidationMessageAcceptor.INSIGNIFICANT_INDEX, ANNOTATIONS_MISSING_ATTRIBUTE_DEFINITION);
				}
			} else
				annotationValueValidator.validateAnnotationValue(value, this);
		}
	}

	@Override
	protected List<EPackage> getEPackages() {
		List<EPackage> ePackages = newArrayList(super.getEPackages());
		ePackages.add(TypesPackage.eINSTANCE);
		return ePackages;
	}

	@Check
	public void checkPropertyAnnotation(JvmField field) {
		if (hasAnnotation(field, Property.class) && field.isStatic()) {
			error("A property must not be static", TypesPackage.Literals.JVM_MEMBER__MODIFIERS, 
					field.getModifiers().indexOf("static"), STATIC_PROPERTY);
		}
	}
	
	protected boolean hasAnnotation(JvmAnnotationTarget source, Class<?> class1) {
		for (JvmAnnotationReference anno : source.getAnnotations()) {
			if (anno != null && anno.getAnnotation() != null && class1.getName().equals(anno.getAnnotation().getIdentifier()))
				return true;
 		}
		return false;
	}
	
	protected void checkValidExtensionType(JvmIdentifiableElement identifiable, EObject source, EStructuralFeature feature) {
		LightweightTypeReference type = getActualType(identifiable);
		if (type != null && type.isPrimitive()) {
			error(String.format("The primitive type %s is not a valid extension", type.getSimpleName()), source, feature, INVALID_EXTENSION_TYPE);
		}
	}

//	@Check
//	public void checkAnnotationTarget(JvmAnnotationReference annotation) {
//		JvmType annotationType = annotation.getAnnotation();
//		if (annotationType == null || annotationType.eIsProxy() || !(annotationType instanceof JvmAnnotationType)) {
//			return;
//		}
//		Set<ElementType> targets = annotationUtil.getAnnotationTargets((JvmAnnotationType) annotationType);
//		if (targets.isEmpty())
//			return;
//		final EObject eContainer = getContainingAnnotationTarget(annotation);
//		for (Entry<Class<?>, ElementType> mapping : targetInfos.entrySet()) {
//			if (mapping.getKey().isInstance(eContainer)) {
//				if (!targets.contains(mapping.getValue())) {
//					error("The annotation @" + annotation.getAnnotation().getSimpleName()
//							+ " is disallowed for this location.", annotation, null, INSIGNIFICANT_INDEX,
//							ANNOTATION_WRONG_TARGET);
//				}
//			}
//		}
//	}

	protected EObject getContainingAnnotationTarget(JvmAnnotationReference annotation) {
		final EObject eContainer = annotation.eContainer();
		// skip synthetic container
		if (eContainer.eClass() == TypesPackage.Literals.JVM_MEMBER || eContainer.eClass() == TypesPackage.Literals.JVM_DECLARED_TYPE) {
			return eContainer.eContainer();
		}
		return eContainer;
	}

	@Override
	@Check
	public void checkAssignment(XAssignment assignment) {
		JvmIdentifiableElement assignmentFeature = assignment.getFeature();
		if (assignmentFeature instanceof JvmFormalParameter)
			error("Assignment to final parameter", Literals.XASSIGNMENT__ASSIGNABLE,
					ValidationMessageAcceptor.INSIGNIFICANT_INDEX, ASSIGNMENT_TO_FINAL);
		else
			super.checkAssignment(assignment);
	}

	@Check
	public void checkNoVoidInDependencyDeclaration(JvmField dep) {
		JvmTypeReference declaredFieldType = dep.getType();
		if (isPrimitiveVoid(declaredFieldType)) {
			error("Primitive void cannot be a dependency.", dep.getType(), null, INVALID_USE_OF_TYPE);
		}
	}
	
	@Check
	public void checkMemberNamesAreUnique(JvmDeclaredType xtendType) {
		final Multimap<String, JvmMember> name2field = HashMultimap.create();
		for(JvmMember member: xtendType.getMembers()) {
			if(member instanceof JvmField) {
				name2field.put(member.getSimpleName(), member);
			}
		}
		for(String name: name2field.keySet()) {
			Collection<JvmMember> members = name2field.get(name);
			if(members.size() >1) {
				for(JvmMember member: members)
					error("Duplicate member " + name, member, TypesPackage.Literals.JVM_MEMBER__SIMPLE_NAME, DUPLICATE_FIELD);
			}
		}
	}
	
	@Check
	public void checkVarArgComesLast(JvmFormalParameter param) {
		if (param.isVarArg()) {
			@SuppressWarnings("unchecked")
			List<JvmFormalParameter> params = (List<JvmFormalParameter>) param.eContainer().eGet(param.eContainingFeature());
			if (param != Iterables.getLast(params)) {
				error("A vararg must be the last parameter.", param, TypesPackage.Literals.JVM_FORMAL_PARAMETER__VAR_ARG, INVALID_USE_OF_VAR_ARG);
			}
		}
	}
	
	@Check  
	public void checkClassPath(JvmModule xtendFile) {
		//cym comment
//		TypeReferences typeReferences = getServices().getTypeReferences();
//		final JvmGenericType listType = (JvmGenericType) typeReferences.findDeclaredType(List.class, xtendFile);
//		if (listType == null || listType.getTypeParameters().isEmpty()) {
//			error("Couldn't find a JDK 1.5 or higher on the project's classpath.", xtendFile, XTEND_FILE__PACKAGE,
//					IssueCodes.JDK_NOT_ON_CLASSPATH);
//		} else if (typeReferences.findDeclaredType(Extension.class, xtendFile) == null) {
//			error("Couldn't find the mandatory library 'org.summer.dsl.xbase.lib' 2.4.0 or higher on the project's classpath.",
//					xtendFile, XTEND_FILE__PACKAGE, IssueCodes.XBASE_LIB_NOT_ON_CLASSPATH);
//		}
	}

	@Check
	public void checkSuperTypes(JvmGenericType genericType) {
		JvmTypeReference superType = genericType.getExtends();
		if (superType != null && superType.getType() != null) {
			if (!(superType.getType() instanceof JvmGenericType)
					|| superType.getType() instanceof JvmInterfaceType) {
				error("Superclass must be a class", TypesPackage.Literals.JVM_GENERIC_TYPE__EXTENDS, CLASS_EXPECTED);
			} else {
				if (((JvmGenericType) superType.getType()).isFinal()) {
					error("Attempt to override final class", TypesPackage.Literals.JVM_GENERIC_TYPE__EXTENDS, OVERRIDDEN_FINAL);
				}
				if (genericType != null && hasCycleInHierarchy(genericType, Sets.<JvmGenericType> newHashSet())) {
					error("The inheritance hierarchy of " + notNull(genericType.getSimpleName()) + " contains cycles",
							TypesPackage.Literals.JVM_MEMBER__SIMPLE_NAME, CYCLIC_INHERITANCE);
				}
				checkWildcardSupertype(genericType, superType, TypesPackage.Literals.JVM_GENERIC_TYPE__EXTENDS, INSIGNIFICANT_INDEX);
			}
		}
		for (int i = 0; i < genericType.getImplements().size(); ++i) {
			JvmTypeReference implementedType = genericType.getImplements().get(i);
			if (!(implementedType.getType() instanceof JvmGenericType)
					|| !(implementedType.getType() instanceof JvmGenericType)) {
				error("Implemented interface must be an interface", TypesPackage.Literals.JVM_GENERIC_TYPE__IMPLEMENTS, i, INTERFACE_EXPECTED);
			}
			checkWildcardSupertype(genericType, implementedType, TypesPackage.Literals.JVM_GENERIC_TYPE__IMPLEMENTS, i);
		}
	}

//	@Check
//	public void checkSuperTypes(JvmGenericType xtendInterface) {
//		for (int i = 0; i < xtendInterface.getExtends().size(); ++i) {
//			JvmTypeReference implementedType = xtendInterface.getExtends().get(i);
//			if (!(implementedType.getType() instanceof JvmGenericType)
//					|| !((JvmGenericType) implementedType.getType()).isInterface()) {
//				error("Extended interface must be an interface", XTEND_INTERFACE__EXTENDS, i, INTERFACE_EXPECTED);
//			}
//			checkWildcardSupertype(xtendInterface, implementedType, XTEND_INTERFACE__EXTENDS, i);
//		}
//		JvmGenericType inferredType = xtendInterface;
//		if(inferredType != null && hasCycleInHierarchy(inferredType, Sets.<JvmGenericType> newHashSet())) {
//			error("The inheritance hierarchy of " + notNull(xtendInterface.getSimpleName()) + " contains cycles",
//					XTEND_TYPE_DECLARATION__NAME, CYCLIC_INHERITANCE);
//		}
//	}
	
	protected void checkWildcardSupertype(JvmGenericType xtendType, JvmTypeReference superTypeReference,
			EStructuralFeature feature, int index) { 
		if(isInvalidWildcard(superTypeReference)) 
			error("The type " 
					+ notNull(xtendType.getSimpleName()) 
					+ " cannot extend or implement "
					+ superTypeReference.getIdentifier() 
					+ ". A supertype may not specify any wildcard", feature, index, WILDCARD_IN_SUPERTYPE);
	}
	
	protected boolean isInvalidWildcard(JvmTypeReference typeRef) {
		if (typeRef instanceof JvmWildcardTypeReference)
			return true;
		else if (typeRef instanceof JvmParameterizedTypeReference) {
			for(JvmTypeReference typeArgument: ((JvmParameterizedTypeReference) typeRef).getArguments()) {
				if(typeArgument instanceof JvmWildcardTypeReference) 
					return true;
			}
		}
		return false;
	}

	protected boolean hasCycleInHierarchy(JvmGenericType type, Set<JvmGenericType> processedSuperTypes) {
		if (processedSuperTypes.contains(type))
			return true;
		processedSuperTypes.add(type);
		for (JvmTypeReference superTypeRef : type.getSuperTypes()) {
			if (superTypeRef.getType() instanceof JvmGenericType) {
				if (hasCycleInHierarchy((JvmGenericType) superTypeRef.getType(), processedSuperTypes))
					return true;
			}
		}
		processedSuperTypes.remove(type);
		return false;
	}
	
	@Check
	public void checkDuplicateAndOverriddenFunctions(JvmGenericType xtendType) {
//		final JvmDeclaredType inferredType = associations.getInferredType(xtendType);
//		if (inferredType instanceof JvmGenericType) {
			ResolvedOperations resolvedOperations = overrideHelper.getResolvedOperations(xtendType);
			
			Set<EObject> flaggedOperations = Sets.newHashSet();
			doCheckDuplicateExecutables((JvmGenericType) xtendType, resolvedOperations, flaggedOperations);
			doCheckOverriddenMethods(xtendType, (JvmGenericType) xtendType, resolvedOperations, flaggedOperations);
			doCheckFunctionOverrides(resolvedOperations, flaggedOperations);
//		}
	}
	
	protected void doCheckDuplicateExecutables(JvmGenericType inferredType,	final ResolvedOperations resolvedOperations, Set<EObject> flaggedOperations) {
		List<IResolvedOperation> declaredOperations = resolvedOperations.getDeclaredOperations();
		doCheckDuplicateExecutables(inferredType, declaredOperations, new Function<String, List<IResolvedOperation>>() {
			public List<IResolvedOperation> apply(String erasedSignature) {
				return resolvedOperations.getDeclaredOperations(erasedSignature);
			}
		}, flaggedOperations);
		final List<IResolvedConstructor> declaredConstructors = resolvedOperations.getDeclaredConstructors();
		doCheckDuplicateExecutables(inferredType, declaredConstructors, new Function<String, List<IResolvedConstructor>>() {
			public List<IResolvedConstructor> apply(String erasedSignature) {
				if (declaredConstructors.size() == 1) {
					if (erasedSignature.equals(declaredConstructors.get(0).getResolvedErasureSignature())) {
						return declaredConstructors;
					}
					return Collections.emptyList();
				}
				List<IResolvedConstructor> result = Lists.newArrayListWithCapacity(declaredConstructors.size());
				for(IResolvedConstructor constructor: declaredConstructors) {
					if (erasedSignature.equals(constructor.getResolvedErasureSignature())) {
						result.add(constructor);
					}
				}
				return result;
			}
		}, flaggedOperations);
	}

	protected <Executable extends IResolvedExecutable> void doCheckDuplicateExecutables(JvmGenericType inferredType,
			List<Executable> declaredOperations, Function<String, List<Executable>> bySignature, Set<EObject> flaggedOperations) {
		Set<Executable> processed = Sets.newHashSet();
		for(Executable declaredExecutable: declaredOperations) {
			if (!processed.contains(declaredExecutable)) {
				List<Executable> sameErasure = bySignature.apply(declaredExecutable.getResolvedErasureSignature());
				if (sameErasure.size() > 1) {
					Multimap<String, Executable> perSignature = HashMultimap.create(sameErasure.size(), 2);
					outer: for(Executable executable: sameErasure) {
						for(LightweightTypeReference parameterType: executable.getResolvedParameterTypes()) {
							if (parameterType.isUnknown())
								continue outer;
						}
						perSignature.put(executable.getResolvedSignature(), executable);
					}
					if (perSignature.size() > 1) {
						for(Collection<Executable> sameSignature: perSignature.asMap().values()) {
							for(Executable operationWithSameSignature: sameSignature) {
								JvmExecutable executable = operationWithSameSignature.getDeclaration();
								EObject otherSource = associations.getPrimarySourceElement(executable);
								if (flaggedOperations.add(otherSource)) {
									if (sameSignature.size() > 1) {
										error("Duplicate " + typeLabel(executable) + " " + operationWithSameSignature.getSimpleSignature()
												+ " in type " + inferredType.getSimpleName(), otherSource,
												nameFeature(otherSource), DUPLICATE_METHOD);
									} else {
										error("The " + typeLabel(executable) + " " + operationWithSameSignature.getSimpleSignature()
												+ " has the same erasure "
												+ operationWithSameSignature.getResolvedErasureSignature()
												+ " as another " + typeLabel(executable) + " in type " + inferredType.getSimpleName(), otherSource,
												nameFeature(otherSource), DUPLICATE_METHOD);
									}
								}
							}
						}
					}
				}
			}
		}
	}
	
	protected String typeLabel(JvmExecutable executable) {
		if (executable instanceof JvmOperation) 
			return "method";
		else if(executable instanceof JvmConstructor) 
			return "constructor";
		else 
			return "?";
	}
	
	protected EStructuralFeature nameFeature(EObject member) {
		if (member instanceof JvmOperation) 
			return TypesPackage.Literals.JVM_MEMBER__SIMPLE_NAME;
		else if(member instanceof JvmConstructor)
			return null;
		else if(member instanceof JvmField)
			return TypesPackage.Literals.JVM_MEMBER__SIMPLE_NAME;
		else
			return null;
	}
	
	
	protected void doCheckOverriddenMethods(JvmGenericType xtendType, JvmGenericType inferredType,
			ResolvedOperations resolvedOperations, Set<EObject> flaggedOperations) {
		List<IResolvedOperation> operationsMissingImplementation = null;
		boolean doCheckAbstract = !inferredType.isAbstract();
		if (doCheckAbstract) {
			operationsMissingImplementation = Lists.newArrayList();
		}
		IVisibilityHelper visibilityHelper = new ContextualVisibilityHelper(this.visibilityHelper, resolvedOperations.getType());
		for (IResolvedOperation operation : resolvedOperations.getAllOperations()) {
			if (operation.getDeclaration().getDeclaringType() != inferredType) {
				if (operationsMissingImplementation != null && operation.getDeclaration().isAbstract()) {
					operationsMissingImplementation.add(operation);
				}
				if (visibilityHelper.isVisible(operation.getDeclaration())) {
					List<IResolvedOperation> declaredOperationsWithSameErasure = 
							resolvedOperations.getDeclaredOperations(operation.getResolvedErasureSignature());
					for(IResolvedOperation localOperation: declaredOperationsWithSameErasure) {
						if (!localOperation.isOverridingOrImplementing(operation.getDeclaration()).isOverridingOrImplementing()) {
							JvmOperation source = findXtendFunction(localOperation);
							if (flaggedOperations.add(source)) {
								error("Name clash: The method "
										+ localOperation.getSimpleSignature() + " of type "
										+ inferredType.getSimpleName()
										+ " has the same erasure as "
										+
										// use source with other operations parameters to avoid confusion
										// due to name transformations in JVM model inference
										operation.getSimpleSignature() + " of type "
										+ operation.getDeclaration().getDeclaringType().getSimpleName() + " but does not override it.",
										source, TypesPackage.Literals.JVM_MEMBER__SIMPLE_NAME, DUPLICATE_METHOD);
							}
						}
					}
				}
			}
		}
		if(xtendType instanceof JvmDeclaredType && operationsMissingImplementation != null && !operationsMissingImplementation.isEmpty()) {
			reportMissingImplementations((JvmDeclaredType) xtendType, operationsMissingImplementation);
		}
	}

	protected void reportMissingImplementations(JvmDeclaredType xtendClass, List<IResolvedOperation> operationsMissingImplementation) {
		StringBuilder errorMsg = new StringBuilder();
		errorMsg.append("The class ").append(xtendClass.getSimpleName()).append(" must be defined abstract because it does not implement ");
		boolean needsNewLine = operationsMissingImplementation.size() > 1;
		IResolvedOperation operation;
		for(int i=0; i<operationsMissingImplementation.size() && i<3; ++i) {
			operation = operationsMissingImplementation.get(i);
			if(needsNewLine)
				errorMsg.append("\n- ");
			errorMsg.append(operation.getSimpleSignature());
		}
		int numUnshownOperations = operationsMissingImplementation.size() - 3;
		if(numUnshownOperations >0)
			errorMsg.append("\nand " +  numUnshownOperations + " more.");
		List<String> uris = transform(operationsMissingImplementation, new Function<IResolvedOperation, String>() {
			public String apply(IResolvedOperation from) {
				return EcoreUtil.getURI(from.getDeclaration()).toString();
			}
		});
		error(errorMsg.toString(), xtendClass, TypesPackage.Literals.JVM_MEMBER__SIMPLE_NAME, CLASS_MUST_BE_ABSTRACT, 
						toArray(uris, String.class));
	}
	
	protected void doCheckFunctionOverrides(ResolvedOperations resolvedOperations, Set<EObject> flaggedOperations) {
		for(IResolvedOperation operation: resolvedOperations.getDeclaredOperations()) {
			doCheckFunctionOverrides(operation, flaggedOperations);
		}
	}

	protected void doCheckFunctionOverrides(IResolvedOperation operation, Set<EObject> flaggedOperations) {
		JvmOperation function = findXtendFunction(operation);
		if (function != null && flaggedOperations.add(function)) {
			List<IResolvedOperation> allInherited = operation.getOverriddenAndImplementedMethods();
			if (allInherited.isEmpty()) {
				if (function.isOverride()) {
					error("The method "+ operation.getSimpleSignature() +" of type "+operation.getDeclaration().getDeclaringType().getSimpleName()+" must override a superclass method.", 
							function, TypesPackage.Literals.JVM_MEMBER__MODIFIERS, function.getModifiers().indexOf("override"), OBSOLETE_OVERRIDE);
				}
			} else {
				doCheckFunctionOverrides(function, operation, allInherited);
			}
		}
	}

	protected void doCheckFunctionOverrides(JvmOperation function, IResolvedOperation resolved,
			List<IResolvedOperation> allInherited) {
		boolean overrideProblems = false;
		List<IResolvedOperation> exceptionMismatch = null;
		for(IResolvedOperation inherited: allInherited) {
			if (inherited.getOverrideCheckResult().hasProblems()) {
				overrideProblems = true;
				EnumSet<OverrideCheckDetails> details = inherited.getOverrideCheckResult().getDetails();
				if (details.contains(OverrideCheckDetails.IS_FINAL)) {
					error("Attempt to override final method " + inherited.getSimpleSignature(), function,
							TypesPackage.Literals.JVM_MEMBER__SIMPLE_NAME, OVERRIDDEN_FINAL);
				} else if (details.contains(OverrideCheckDetails.REDUCED_VISIBILITY)) {
					error("Cannot reduce the visibility of the overridden method " + inherited.getSimpleSignature(),
							function, TypesPackage.Literals.JVM_MEMBER__SIMPLE_NAME, OVERRIDE_REDUCES_VISIBILITY);
				} else if (details.contains(OverrideCheckDetails.EXCEPTION_MISMATCH)) {
					if (exceptionMismatch == null)
						exceptionMismatch = Lists.newArrayListWithCapacity(allInherited.size());
					exceptionMismatch.add(inherited);
				} else if (details.contains(OverrideCheckDetails.RETURN_MISMATCH)) {
					error("The return type is incompatible with " + inherited.getSimpleSignature(), function,
							TypesPackage.Literals.JVM_OPERATION__RETURN_TYPE, INCOMPATIBLE_RETURN_TYPE);
				}
			}
		}
		if (exceptionMismatch != null) {
			createExceptionMismatchError(resolved, function, exceptionMismatch);
		}
		if (!overrideProblems && !function.isOverride() && !function.isStatic()) {
			error("The method " + resolved.getSimpleSignature() + " of type " + resolved.getDeclaration().getDeclaringType().getSimpleName() +
					" must use override keyword since it actually overrides a supertype method.", function,
					TypesPackage.Literals.JVM_MEMBER__SIMPLE_NAME, MISSING_OVERRIDE);
		} 
		if (!overrideProblems && function.isOverride() && function.isStatic()) {
			for(IResolvedOperation inherited: allInherited) {
				error("The method " + resolved.getSimpleSignature() + " of type " + resolved.getDeclaration().getDeclaringType().getSimpleName() + 
					" shadows the method " + resolved.getSimpleSignature() + " of type " + inherited.getDeclaration().getDeclaringType().getSimpleName() + 
					", but does not override it.", function, TypesPackage.Literals.JVM_MEMBER__SIMPLE_NAME, function.getModifiers().indexOf("override"), OBSOLETE_OVERRIDE);
			}
		}
	}
	
	protected void createExceptionMismatchError(IResolvedOperation operation, JvmOperation function,
			List<IResolvedOperation> exceptionMismatch) {
		List<LightweightTypeReference> exceptions = operation.getIllegallyDeclaredExceptions();
		StringBuilder message = new StringBuilder(100);
		message.append("The declared exception");
		if (exceptions.size() > 1) {
			message.append('s');
		}
		message.append(' ');
		for(int i = 0; i < exceptions.size(); i++) {
			if (i != 0) {
				if (i != exceptions.size() - 1)
					message.append(", ");
				else
					message.append(" and ");
			}
			message.append(exceptions.get(i).getSimpleName());
		}
		if (exceptions.size() > 1) {
			message.append(" are");
		} else {
			message.append(" is");
		}
		message.append(" not compatible with throws clause in ");
		for(int i = 0; i < exceptionMismatch.size(); i++) {
			if (i != 0) {
				if (i != exceptionMismatch.size() - 1)
					message.append(", ");
				else
					message.append(" and ");
			}
			IResolvedOperation resolvedOperation = exceptionMismatch.get(i);
			message.append(resolvedOperation.getDeclaration().getDeclaringType().getSimpleName());
			message.append('.');
			message.append(exceptionMismatch.get(i).getSimpleSignature());
		}
		error(message.toString(), function, TypesPackage.Literals.JVM_EXECUTABLE__EXCEPTIONS, INCOMPATIBLE_THROWS_CLAUSE);
	}

	@Nullable
	protected JvmOperation findXtendFunction(IResolvedOperation operation) {
		EObject sourceElement = associations.getPrimarySourceElement(operation.getDeclaration());
		if (sourceElement instanceof JvmOperation)
			return (JvmOperation) sourceElement;
		return null;
	}
	
	protected boolean isMorePrivateThan(JvmVisibility o1, JvmVisibility o2) {
		if (o1 == o2) {
			return false;
		} else {
			switch (o1) {
//				case DEFAULT:  //cym comment
//					return o2 != JvmVisibility.PRIVATE;
				case PRIVATE:
					return true;
//				case PROTECTED:   //cym comment
//					return o2 == JvmVisibility.PUBLIC;
				case PUBLIC:
					return false;
				default:
					throw new IllegalArgumentException("Unknown JvmVisibility " + o1);
			}
		}
	}

	@Check
	public void checkDefaultSuperConstructor(JvmGenericType xtendClass) {
		JvmGenericType inferredType = xtendClass; //associations.getInferredType(xtendClass);
		if (inferredType == null)
			return;
		Iterable<JvmConstructor> constructors = filter(inferredType.getMembers(), JvmConstructor.class);
		if(inferredType.getExtendedClass() != null) {
			JvmType superType = inferredType.getExtendedClass().getType();
			if(superType instanceof JvmGenericType) {
				Iterable<JvmConstructor> superConstructors = ((JvmGenericType) superType).getDeclaredConstructors();
				for(JvmConstructor superConstructor: superConstructors) {
					if(superConstructor.getParameters().isEmpty()) 
						// there is a default super constructor. nothing more to check
						return;
				}
				if(size(constructors) == 1 && typeExtensions.isSingleSyntheticDefaultConstructor(constructors.iterator().next())) {
					List<String> issueData = newArrayList();
					for(JvmConstructor superConstructor:superConstructors) {
						issueData.add(EcoreUtil.getURI(superConstructor).toString());
						issueData.add(doGetReadableSignature(xtendClass.getSimpleName(), superConstructor.getParameters()));
					}
					error("No default constructor in super type " + superType.getSimpleName() + "." +
							xtendClass.getSimpleName() + " must define an explicit constructor.",
							xtendClass, TypesPackage.Literals.JVM_DELEGATE_TYPE__SIMPLE_NAME, MISSING_CONSTRUCTOR, toArray(issueData, String.class));
				} else {
//					for(JvmConstructor constructor: constructors) {
//						XExpression expression = containerProvider.getAssociatedExpression(constructor);
//						if (expression instanceof XBlockStatment) {
//							List<XStatment> expressions = ((XBlockStatment) expression).getStatments();
//							if(expressions.isEmpty() || !isDelegatConstructorCall(expressions.get(0))) {
//								JvmConstructor xtendConstructor = constructor; //associations.getXtendConstructor(constructor);
//								error("No default constructor in super type " + superType.getSimpleName() 
//										+ ". Another constructor must be invoked explicitly.",
//										xtendConstructor, null, MUST_INVOKE_SUPER_CONSTRUCTOR);
//							}
//						}
//					}
					
					for(JvmConstructor constructor: constructors) {
						XStatment statment = constructor.getBody();
						if (statment instanceof XBlockStatment) {
							List<XStatment> expressions = ((XBlockStatment) statment).getStatments();
							if(expressions.isEmpty() || !isDelegatConstructorCall(expressions.get(0))) {
								error("No default constructor in super type " + superType.getSimpleName() 
										+ ". Another constructor must be invoked explicitly.",
										constructor, null, MUST_INVOKE_SUPER_CONSTRUCTOR);
							}
						}
					}
				}
			}
		} 
	}

	protected boolean isDelegatConstructorCall(XStatment statment) {
		if(statment instanceof XExpressionStatment){
			XExpressionStatment expressionStat = (XExpressionStatment) statment;
			if(expressionStat.getExpression() instanceof XFeatureCall) {
				JvmIdentifiableElement feature = ((XFeatureCall)expressionStat).getFeature();
				return (feature != null && !feature.eIsProxy() && feature instanceof JvmConstructor);
			}
		}
		return false;
	}

	protected boolean isInterface(JvmDeclaredType type) {
		return type instanceof JvmInterfaceType;
	}

	protected String canonicalName(JvmIdentifiableElement element) {
		return (element != null) ? notNull(element.getIdentifier()) : null;
	}

	protected String getReadableSignature(JvmExecutable executable) {
		if (executable == null)
			return "null";
		return doGetReadableSignature(executable.getSimpleName(), executable.getParameters());
	}

	protected String doGetReadableSignature(String simpleName, List<JvmFormalParameter> parameters) {
		return getReadableSignature(simpleName,
				Lists.transform(parameters, new Function<JvmFormalParameter, JvmTypeReference>() {
					public JvmTypeReference apply(JvmFormalParameter from) {
						return from.getParameterType();
					}
				}));
	}

	protected String getReadableSignature(String elementName, List<JvmTypeReference> parameterTypes) {
		StringBuilder result = new StringBuilder(elementName);
		result.append('(');
		for (int i = 0; i < parameterTypes.size(); i++) {
			if (i != 0) {
				result.append(", ");
			}
			JvmTypeReference parameterType = parameterTypes.get(i);
			if (parameterType != null)
				result.append(parameterType.getSimpleName());
			else
				result.append("null");
		}
		result.append(')');
		return result.toString();
	}

	@Check
	public void checkParameterNames(JvmOperation function) {
		for (int i = 0; i < function.getParameters().size(); ++i) {
			String leftParameterName = function.getParameters().get(i).getName();
			for (int j = i + 1; j < function.getParameters().size(); ++j) {
				if (equal(leftParameterName, function.getParameters().get(j).getName())) {
					error("Duplicate parameter " + leftParameterName, TypesPackage.Literals.JVM_EXECUTABLE__PARAMETERS, i, DUPLICATE_PARAMETER_NAME);
					error("Duplicate parameter " + leftParameterName, TypesPackage.Literals.JVM_EXECUTABLE__PARAMETERS, j, DUPLICATE_PARAMETER_NAME);
				}
			}
//			if (function.getCreateExtensionInfo() != null) {
//				if (equal(leftParameterName, function.getCreateExtensionInfo().getName())) {
//					error("Duplicate parameter " + leftParameterName, TypesPackage.Literals.JVM_EXECUTABLE__PARAMETERS, i, DUPLICATE_PARAMETER_NAME);
//					if (function.getCreateExtensionInfo().eIsSet(CREATE_EXTENSION_INFO__NAME))
//						error("Duplicate parameter " + leftParameterName, function.getCreateExtensionInfo(),
//								CREATE_EXTENSION_INFO__NAME, DUPLICATE_PARAMETER_NAME);
//					else
//						error("Duplicate implicit parameter 'it'", function.getCreateExtensionInfo(),
//								CREATE_EXTENSION_INFO__NAME, DUPLICATE_PARAMETER_NAME);
//				}
//			}
		}
	}
	
	@Check
	public void checkAbstract(JvmOperation function) {
		if (function.getBody() == null) {
			if(function.getDeclaringType() instanceof JvmGenericType) {
				JvmGenericType declarator = (JvmGenericType) function.getDeclaringType();
//				if (function.isDispatch()) {
//					error("The dispatch method " + function.getName() + " in type " + declarator.getName() + " must not be abstract",XTEND_FUNCTION__NAME, -1, DISPATCH_FUNCTIONS_MUST_NOT_BE_ABSTRACT);
//					return;
//				}
//				if (function.getCreateExtensionInfo() != null) {
//					error("The 'create'-method " + function.getName() + " in type " + declarator.getName() + " must not be abstract",XTEND_FUNCTION__NAME, -1, CREATE_FUNCTIONS_MUST_NOT_BE_ABSTRACT);
//					return;
//				}
				if (!declarator.isAbstract()) {
					error("The abstract method " + function.getSimpleName() + " in type " + declarator.getSimpleName() + " can only be defined by an abstract class.", 
							TypesPackage.Literals.JVM_MEMBER__SIMPLE_NAME, -1, MISSING_ABSTRACT);
				}
				if(function.getReturnType() == null) {
					error("The abstract method " + function.getSimpleName() + " in type " + declarator.getSimpleName() + " must declare a return type",
							TypesPackage.Literals.JVM_MEMBER__SIMPLE_NAME, -1, ABSTRACT_METHOD_MISSING_RETURN_TYPE);
				}
			} else if(function.eContainer() instanceof JvmInterfaceType) {
				JvmGenericType declarator = (JvmGenericType) function.eContainer();
//				if (function.getCreateExtensionInfo() != null) {
//					error("'Create'-method " + function.getSimpleName() + " is not permitted in an interface", TypesPackage.Literals.JVM_MEMBER__SIMPLE_NAME, -1, CREATE_FUNCTIONS_MUST_NOT_BE_ABSTRACT);
//					return;
//				}
				if(function.getReturnType() == null && !function.isOverride()) {
					error("The abstract method " + function.getSimpleName() + " in type " + declarator.getSimpleName() + " must declare a return type",
							TypesPackage.Literals.JVM_MEMBER__SIMPLE_NAME, -1, ABSTRACT_METHOD_MISSING_RETURN_TYPE);
				}
			}
		} else if(function.getDeclaringType() instanceof JvmInterfaceType) {
			error("Abstract methods do not specify a body", TypesPackage.Literals.JVM_MEMBER__SIMPLE_NAME, -1, ABSTRACT_METHOD_WITH_BODY);
		}
	}
	
	@Check
	public void checkParameterNames(JvmConstructor constructor) {
		for (int i = 0; i < constructor.getParameters().size(); ++i) {
			String leftParameterName = constructor.getParameters().get(i).getName();
			for (int j = i + 1; j < constructor.getParameters().size(); ++j) {
				if (equal(leftParameterName, constructor.getParameters().get(j).getName())) {
					error("Duplicate parameter " + leftParameterName, TypesPackage.Literals.JVM_EXECUTABLE__PARAMETERS, i, DUPLICATE_PARAMETER_NAME);
					error("Duplicate parameter " + leftParameterName, TypesPackage.Literals.JVM_EXECUTABLE__PARAMETERS, j, DUPLICATE_PARAMETER_NAME);
				}
			}
		}
	}

	protected List<JvmType> getParamTypes(JvmOperation jvmOperation, boolean wrapPrimitives) {
		List<JvmType> types = newArrayList();
		for (JvmFormalParameter p : jvmOperation.getParameters()) {
			LightweightTypeReference typeReference = toLightweightTypeReference(p.getParameterType());
			if (wrapPrimitives) {
				typeReference = typeReference.getWrapperTypeIfPrimitive();
			}
			types.add(typeReference.getType());
		}
		return types;
	}

//	@Override
//	protected boolean isValueExpectedRecursive(XExpression expr) {
//		EObject container = expr.eContainer();
//		if (container instanceof RichString 
//			|| container instanceof RichStringForLoop
//			|| container instanceof XtendField) {
//			return true;
//		}
//		return super.isValueExpectedRecursive(expr);
//	}

	protected void collectReturnExpressions(EObject expr, List<XReturnStatment> found) {
		if (expr instanceof XReturnStatment) {
			found.add((XReturnStatment) expr);
		} else if (expr instanceof XClosure) {
			return;
		}
		for (EObject child : expr.eContents()) {
			collectReturnExpressions(child, found);
		}
	}

	//cym comment
//	@Check
//	public void checkClasses(XModule file) {
//		//TODO this check should not be file local, but instead check for any other sources which might declare a
//		// java type with the same name. Also this then belongs to Xbase and should be defined on JvmDeclaredType
//		Set<String> names = newLinkedHashSet();
//		for (XtendTypeDeclaration clazz : file.getXtendTypes()) {	
//			if (!names.add(clazz.getName()))
//				error("The type "+clazz.getName()+" is already defined.", clazz, SsPackage.Literals.XTEND_TYPE_DECLARATION__NAME, -1, IssueCodes.DUPLICATE_TYPE_NAME);
//		}
//	}
	
	@Check
	public void checkClasses(JvmModule file) {
		//TODO this check should not be file local, but instead check for any other sources which might declare a
		// java type with the same name. Also this then belongs to Xbase and should be defined on JvmDeclaredType
		Set<String> names = newLinkedHashSet();
		for (EObject object : file.getContents()) {	
			if(object instanceof JvmIdentifiableElement){
				JvmIdentifiableElement id = (JvmIdentifiableElement) object;
				if (!names.add(id.getSimpleName())){
					if(id instanceof JvmDeclaredType){
						error("The element "+id.getSimpleName()+" is already defined.", id, TypesPackage.Literals.JVM_MEMBER__SIMPLE_NAME, -1, IssueCodes.DUPLICATE_TYPE_NAME);
					}else if(id instanceof XVariableDeclaration){
						error("The element "+id.getSimpleName()+" is already defined.", id, XbasePackage.Literals.XVARIABLE_DECLARATION__NAME, -1, IssueCodes.DUPLICATE_TYPE_NAME);
					}else if(id instanceof XClosure){
						error("The element "+id.getSimpleName()+" is already defined.", id, XbasePackage.Literals.XCLOSURE__NAME, -1, IssueCodes.DUPLICATE_TYPE_NAME);
					}
				}
			}
		}
	}
	
	public boolean doCheckValidMemberName(JvmMember member) {
		EStructuralFeature nameAttribute = member.eClass().getEStructuralFeature("simpleName");
		if(nameAttribute != null) {
			String name = (String) member.eGet(nameAttribute);
			if(name != null && (name.equals("this") || name.equals("it"))) { 
				error("'it' and 'this' are not allowed as member names", nameAttribute, INVALID_MEMBER_NAME);
				return false;
			}
		}
		return true;
	}
	
	@Check
	public void checkLocalUsageOfDeclaredFields(JvmField field){
		if(doCheckValidMemberName(field) && !isIgnored(UNUSED_PRIVATE_MEMBER)) {
			if (field == null || field.getVisibility() != JvmVisibility.PRIVATE)
				return;
			if (hasAnnotation(field.getAnnotations(), Property.class))
				return;
			if (hasAnnotation(((JvmAnnotationTarget)field.eContainer()).getAnnotations(), Data.class))
				return;
			if (isLocallyUsed(field, field.eContainer())) 
				return;
			String message= "The value of the field " + field.getDeclaringType().getSimpleName() + "."
					+ field.getSimpleName() + " is not used";
			addIssueToState(UNUSED_PRIVATE_MEMBER, message, TypesPackage.Literals.JVM_MEMBER__SIMPLE_NAME);
		}
	}
	
	@Check
	public void checkLocalUsageOfDeclaredXtendFunction(JvmOperation jvmOperation){
		if(doCheckValidMemberName(jvmOperation) && !isIgnored(UNUSED_PRIVATE_MEMBER)) {
//			JvmOperation jvmOperation = function.isDispatch()?associations.getDispatchOperation(function):associations.getDirectlyInferredOperation(function);
			if(jvmOperation != null && jvmOperation.getVisibility() == JvmVisibility.PRIVATE && !isLocallyUsed(jvmOperation, jvmOperation.eContainer())){
				String message = "The method " + jvmOperation.getSimpleName() 
						+  uiStrings.parameters(jvmOperation)  
						+ " from the type "+jvmOperation.getDeclaringType().getSimpleName()+" is never used locally.";
				addIssueToState(UNUSED_PRIVATE_MEMBER, message, TypesPackage.Literals.JVM_MEMBER__SIMPLE_NAME);
			}
		}
	}
	
	@Check
	public void checkDeclaredExceptions(JvmConstructor constructor){
//		JvmConstructor jvmType = associations.getInferredConstructor(constructor);
		checkExceptions(constructor, constructor.getExceptions(), TypesPackage.Literals.JVM_EXECUTABLE__EXCEPTIONS);
	}
	
	@Check
	public void checkTypeParameterForwardReferences(JvmGenericType xtendClass) {
		doCheckTypeParameterForwardReference(xtendClass.getTypeParameters());
	}
	
	@Check
	public void checkTypeParameterForwardReferences(JvmInterfaceType xtendInterface) {
		doCheckTypeParameterForwardReference(xtendInterface.getTypeParameters());
	}
	
	@Check
	public void checkTypeParameterForwardReferences(JvmOperation xtendFunction) {
		doCheckTypeParameterForwardReference(xtendFunction.getTypeParameters());
	}
	
	@Check
	public void checkTypeParametersAreUnsupported(JvmConstructor constructor){
		if (!constructor.getTypeParameters().isEmpty()) {
			error("Type parameters are not supported for constructors", TypesPackage.Literals.JVM_TYPE_PARAMETER_DECLARATOR__TYPE_PARAMETERS, INSIGNIFICANT_INDEX, CONSTRUCTOR_TYPE_PARAMS_NOT_SUPPORTED);
		}
	}
	
//	@Check
//	public void checkDeclaredExceptions(XtendFunction function){
//		JvmOperation jvmOperation = associations.getDirectlyInferredOperation(function);
//		if (jvmOperation != null) {
//			checkExceptions(function,jvmOperation.getExceptions(), SsPackage.Literals.XTEND_FUNCTION__EXCEPTIONS);
//		}
//	}
	
	private void checkExceptions(EObject context, List<JvmTypeReference> exceptions, EReference reference) {
		Set<String> declaredExceptionNames = Sets.newHashSet();
		JvmTypeReference throwableType = getServices().getTypeReferences().getTypeForName(Throwable.class, context);
		if (throwableType == null) {
			return;
		}
		ITypeReferenceOwner owner = new StandardTypeReferenceOwner(getServices(), context);
		LightweightTypeReference throwableReference = new OwnedConverter(owner).toLightweightReference(throwableType);
		for(int i = 0; i < exceptions.size(); i++) {
			JvmTypeReference exception = exceptions.get(i);
			// throwables may not carry generics thus the raw comparison is sufficient
			if (exception.getType() != null && !exception.getType().eIsProxy()) {
				if(!throwableReference.isAssignableFrom(exception.getType()))
					error("No exception of type " + exception.getSimpleName() + " can be thrown; an exception type must be a subclass of Throwable",
							reference, i, EXCEPTION_NOT_THROWABLE);
				if(!declaredExceptionNames.add(exception.getQualifiedName()))
					error("Exception " + exception.getSimpleName() + " is declared twice", reference, i, EXCEPTION_DECLARED_TWICE);
			}
		}
	}
	
	@Check
    public void checkLeftHandSideIsVariable(XAssignment assignment){
        String concreteSyntaxFeatureName = assignment.getConcreteSyntaxFeatureName();
        if(concreteSyntaxFeatureName.equals(IFeatureNames.THIS.toString()))
            error("Left-hand side of an assignment must be an variable", XbasePackage.Literals.XABSTRACT_FEATURE_CALL__FEATURE, LEFT_HAND_SIDE_MUST_BE_VARIABLE);
    }
	
	@Check
	public void checkJavaKeywordConflict(JvmOperation member) {
		if (member.eContainer() instanceof JvmAnnotationType && "do".equals(member.getSimpleName()))
			return;
		checkNoJavaKeyword(member, TypesPackage.Literals.JVM_MEMBER__SIMPLE_NAME);
		for (JvmTypeParameter p : member.getTypeParameters()) {
			checkNoJavaKeyword(p, TypesPackage.Literals.JVM_TYPE_PARAMETER__NAME);
		}
	}
	
	@Check
	public void checkJavaKeywordConflict(JvmConstructor member) {
		for (JvmTypeParameter p : member.getTypeParameters()) {
			checkNoJavaKeyword(p, TypesPackage.Literals.JVM_TYPE_PARAMETER__NAME);
		}
	}
	
	@Check
	public void checkJavaKeywordConflict(JvmDeclaredType member) {
		checkNoJavaKeyword(member, TypesPackage.Literals.JVM_MEMBER__SIMPLE_NAME);
	}
	
	@Check
	public void checkJavaKeywordConflict(JvmInterfaceType member) {
		for (JvmTypeParameter p : member.getTypeParameters()) {
			checkNoJavaKeyword(p, TypesPackage.Literals.JVM_TYPE_PARAMETER__NAME);
		}
	}
	
	protected void checkNoJavaKeyword(EObject obj, EAttribute attribute) {
		Object name = obj.eGet(attribute);
		if (name != null) {
			if (javaUtils.isJavaKeyword(name.toString()))
				error("'"+name+"' is not a valid identifier.", obj, attribute, -1, INVALID_IDENTIFIER);
		}
	}
	
	@Check
	public void checkNonInitializedFieldsHaveAType(JvmField field) {
		if (field.getType() == null && field.getDefaultValue() == null) {
			error("The field "+field.getSimpleName()+" needs an explicit type since there is no initialization expression to infer the type from.", field, TypesPackage.Literals.JVM_MEMBER__SIMPLE_NAME, TOO_LITTLE_TYPE_INFORMATION);
		}
	}
	
	@Check
	public void checkFieldsAreCalledSelf(JvmField field) {
		if ("self".equals(field.getSimpleName())) {
			addIssue("'self' is a discouraged name", field, TypesPackage.Literals.JVM_MEMBER__SIMPLE_NAME, VARIABLE_NAME_DISCOURAGED);
		}
	}
	
	@Check
	public void checkJavaDocRefs(JvmMember member){
		if(isIgnored(IssueCodes.JAVA_DOC_LINKING_DIAGNOSTIC))
			return;
		List<INode> documentationNodes = ((IEObjectDocumentationProviderExtension) documentationProvider).getDocumentationNodes(member);
		for(INode node : documentationNodes){
			for(ReplaceRegion region : javaDocTypeReferenceProvider.computeTypeRefRegions(node)){
				String typeRefString = region.getText();
				if(typeRefString != null && typeRefString.length() > 0){
					IScope scope = scopeProvider.getScope(member, TypesPackage.Literals.JVM_PARAMETERIZED_TYPE_REFERENCE__TYPE);
					IEObjectDescription candidate = scope.getSingleElement(qualifiedNameConverter.toQualifiedName(typeRefString));
					if(candidate == null){
						Severity severity = getIssueSeverities(getContext(), getCurrentObject()).getSeverity(IssueCodes.JAVA_DOC_LINKING_DIAGNOSTIC);
						if (severity != null)
							getChain().add(createDiagnostic(severity, "javaDoc: " + typeRefString + " cannot be resolved to a type", member, region.getOffset(), region.getLength(), IssueCodes.JAVA_DOC_LINKING_DIAGNOSTIC));
					}
				}
			}
		}
	}

	protected boolean hasAnnotation(Iterable<? extends JvmAnnotationReference> annotations, Class<?> annotationType) {
		for (JvmAnnotationReference anno : annotations) {
			if (anno.getAnnotation() != null && annotationType.getName().equals(anno.getAnnotation().getIdentifier()))
				return true;
		}
		return false;
	}
	
	private ModifierValidator classModifierValidator = new ModifierValidator(
			newArrayList("abstract"), this);
		
	private ModifierValidator interfaceModifierValidator = new ModifierValidator(
			Collections.<String>emptyList(), this);
		
	private ModifierValidator enumModifierValidator = new ModifierValidator(
			Collections.<String>emptyList(), this);
		
	private ModifierValidator fieldModifierValidator = new ModifierValidator(
			newArrayList("static", "virtual", "const"), this);
		
	private ModifierValidator fieldInInterfaceModifierValidator = new ModifierValidator(
			Collections.<String>emptyList(), this);
		
	private ModifierValidator constructorModifierValidator = new ModifierValidator(
			Collections.<String>emptyList(), this);
		
	private ModifierValidator methodModifierValidator = new ModifierValidator(
			newArrayList("static", "abstract", "overload", "function", "override", "native", "virtual"), this);
		
	private ModifierValidator methodInInterfaceModifierValidator = new ModifierValidator(
			newArrayList("abstract", "override"), this);
		
	private ModifierValidator annotationTypeModifierValidator = new ModifierValidator(
			Collections.<String>emptyList(), this);
		
	@Check
	protected void checkModifiers(JvmGenericType xtendClass) {
		classModifierValidator.checkModifiers(xtendClass, "class " + xtendClass.getSimpleName());
	}
	
	@Check
	protected void checkModifiers(JvmEnumerationType xtendEnum) {
		enumModifierValidator.checkModifiers(xtendEnum, "enum " + xtendEnum.getSimpleName());
	}
	
	@Check
	protected void checkModifiers(JvmField field) {
		if(field.getDeclaringType() instanceof JvmGenericType)
			fieldModifierValidator.checkModifiers(field, "field " + field.getSimpleName());
		else if((field.getDeclaringType() instanceof JvmInterfaceType) 
				|| field.getDeclaringType() instanceof JvmAnnotationType)
			fieldInInterfaceModifierValidator.checkModifiers(field,  "field " + field.getSimpleName());
	}
	
	@Check
	protected void checkModifiers(JvmConstructor constructor) {
		if(!(constructor.getDeclaringType() instanceof JvmGenericType)) {
			error("Contructors are only permitted within classes", null, CONSTRUCTOR_NOT_PERMITTED);
		} else {
			String typeName = ((JvmGenericType) constructor.eContainer()).getSimpleName();
			constructorModifierValidator.checkModifiers(constructor, "type " + typeName);
		}
	}

	@Check
	protected void checkModifiers(JvmOperation method) {
		if(method.getDeclaringType() instanceof JvmGenericType) {
			methodModifierValidator.checkModifiers(method, "method " + method.getSimpleName());
			int abstractIndex = method.getModifiers().indexOf("abstract");
			if (method.getBody() != null) {
				if (abstractIndex != -1) 
					error("Method " + method.getSimpleName() + " with a body cannot be abstract", TypesPackage.Literals.JVM_MEMBER__MODIFIERS, abstractIndex, INVALID_MODIFIER);
			} else {
				int finalIndex = method.getModifiers().indexOf("final");
				if(finalIndex != -1) 
					error("Abstract method " + method.getSimpleName() + " cannot be final", TypesPackage.Literals.JVM_MEMBER__MODIFIERS, finalIndex, INVALID_MODIFIER);
			}
		} else if(method.getDeclaringType() instanceof JvmInterfaceType) {
			methodInInterfaceModifierValidator.checkModifiers(method, "method " + method.getSimpleName());			
		}
	}

	@Check
	protected void checkModifiers(JvmAnnotationType annotation) {
		annotationTypeModifierValidator.checkModifiers(annotation, "annotation type " + annotation.getSimpleName());
	}
	
}
