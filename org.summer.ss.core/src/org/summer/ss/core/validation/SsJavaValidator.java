/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.summer.ss.core.validation;

import static com.google.common.collect.Iterables.*;
import static com.google.common.collect.Lists.*;
import static com.google.common.collect.Sets.*;
import static org.summer.ss.core.validation.IssueCodes.*;
import static org.summer.dsl.model.ss.SsPackage.Literals.*;
import static org.eclipse.xtext.util.Strings.*;
import static org.summer.dsl.xbase.validation.IssueCodes.*;

import java.lang.annotation.ElementType;
import java.util.Collection;
import java.util.Collections;
import java.util.EnumSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jdt.annotation.Nullable;
import org.summer.ss.core.jvmmodel.DispatchHelper;
import org.summer.ss.core.jvmmodel.IXtendJvmAssociations;
import org.summer.ss.core.richstring.RichStringProcessor;
import org.summer.dsl.model.ss.RichString;
import org.summer.dsl.model.ss.RichStringElseIf;
import org.summer.dsl.model.ss.RichStringForLoop;
import org.summer.dsl.model.ss.RichStringIf;
import org.summer.dsl.model.ss.XtendAnnotationTarget;
import org.summer.dsl.model.ss.XtendAnnotationType;
import org.summer.dsl.model.ss.XtendClass;
import org.summer.dsl.model.ss.XtendConstructor;
import org.summer.dsl.model.ss.XtendEnum;
import org.summer.dsl.model.ss.XtendField;
import org.summer.dsl.model.ss.XModule;
import org.summer.dsl.model.ss.XtendFormalParameter;
import org.summer.dsl.model.ss.XtendFunction;
import org.summer.dsl.model.ss.XtendInterface;
import org.summer.dsl.model.ss.XtendMember;
import org.summer.dsl.model.ss.SsPackage;
import org.summer.dsl.model.ss.XtendParameter;
import org.summer.dsl.model.ss.XtendTypeDeclaration;
import org.summer.dsl.model.ss.XtendVariableDeclaration;
import org.summer.ss.lib.Data;
import org.summer.ss.lib.Property;
import org.summer.dsl.model.types.JvmAnnotationType;
import org.summer.dsl.model.types.JvmConstructor;
import org.summer.dsl.model.types.JvmDeclaredType;
import org.summer.dsl.model.types.JvmExecutable;
import org.summer.dsl.model.types.JvmField;
import org.summer.dsl.model.types.JvmFormalParameter;
import org.summer.dsl.model.types.JvmGenericType;
import org.summer.dsl.model.types.JvmIdentifiableElement;
import org.summer.dsl.model.types.JvmOperation;
import org.summer.dsl.model.types.JvmParameterizedTypeReference;
import org.summer.dsl.model.types.JvmType;
import org.summer.dsl.model.types.JvmTypeParameter;
import org.summer.dsl.model.types.JvmTypeReference;
import org.summer.dsl.model.types.JvmVisibility;
import org.summer.dsl.model.types.JvmWildcardTypeReference;
import org.summer.dsl.model.types.TypesPackage;
import org.summer.dsl.model.types.util.TypeReferences;
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
import org.summer.dsl.model.xbase.XAssignment;
import org.summer.dsl.model.xbase.XBlockExpression;
import org.summer.dsl.model.xbase.XCatchClause;
import org.summer.dsl.model.xbase.XClosure;
import org.summer.dsl.model.xbase.XExpression;
import org.summer.dsl.model.xbase.XFeatureCall;
import org.summer.dsl.model.xbase.XReturnExpression;
import org.summer.dsl.model.xbase.XbasePackage;
import org.summer.dsl.model.xbase.XbasePackage.Literals;
import org.summer.dsl.model.xannotation.XAnnotation;
import org.summer.dsl.xannotation.typing.XAnnotationUtil;
import org.summer.dsl.xannotation.validation.XbaseWithAnnotationsJavaValidator;
import org.summer.dsl.xbase.compiler.JavaKeywords;
import org.summer.dsl.xbase.jvmmodel.ILogicalContainerProvider;
import org.summer.dsl.xbase.jvmmodel.JvmTypeExtensions;
import org.summer.dsl.xbase.lib.Extension;
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

import com.google.common.base.Function;
import com.google.common.base.Predicate;
import com.google.common.collect.HashMultimap;
import com.google.common.collect.ImmutableMap;
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
public class SsJavaValidator extends XbaseWithAnnotationsJavaValidator {

	@Inject
	private RichStringProcessor richStringProcessor;

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
	protected final Map<Class<?>, ElementType> targetInfos;
	
	{
		ImmutableMap.Builder<Class<?>, ElementType> result = ImmutableMap.builder();
		result.put(XtendClass.class, ElementType.TYPE);
		result.put(XtendInterface.class, ElementType.TYPE);
		result.put(XtendEnum.class, ElementType.TYPE);
		result.put(XtendAnnotationType.class, ElementType.ANNOTATION_TYPE);
		result.put(XtendField.class, ElementType.FIELD);
		result.put(XtendFunction.class, ElementType.METHOD);
		result.put(XtendParameter.class, ElementType.PARAMETER);
		targetInfos = result.build();
	}

	@Override
	protected List<EPackage> getEPackages() {
		List<EPackage> ePackages = newArrayList(super.getEPackages());
		ePackages.add(SsPackage.eINSTANCE);
		return ePackages;
	}

	@Check
	public void checkPropertyAnnotation(XtendField field) {
		if (hasAnnotation(field, Property.class) && field.isStatic()) {
			error("A property must not be static", SsPackage.Literals.XTEND_MEMBER__MODIFIERS, 
					field.getModifiers().indexOf("static"), STATIC_PROPERTY);
		}
	}
	
	protected boolean hasAnnotation(XtendAnnotationTarget source, Class<?> class1) {
		for (XAnnotation anno : source.getAnnotations()) {
			if (anno != null && anno.getAnnotationType() != null && class1.getName().equals(anno.getAnnotationType().getIdentifier()))
				return true;
 		}
		return false;
	}
	
	@Check
	public void checkValidExtension(XtendField field) {
		if (field.isExtension()) {
			JvmField jvmField = associations.getJvmField(field);
			if (jvmField != null) {
				checkValidExtensionType(jvmField, field, SsPackage.Literals.XTEND_FIELD__TYPE);
			}
		}
	}
	
	@Check
	public void checkValidExtension(XtendFormalParameter parameter) {
		// catch clauses validate their types against java.lang.Throwable
		if (parameter.isExtension() && !(parameter.eContainer() instanceof XCatchClause))
			checkValidExtensionType(parameter, parameter, TypesPackage.Literals.JVM_FORMAL_PARAMETER__PARAMETER_TYPE);
	}
	
	@Check
	public void checkValidExtension(XtendVariableDeclaration variableDeclaration) {
		if (variableDeclaration.isExtension())
			checkValidExtensionType(variableDeclaration, variableDeclaration, XbasePackage.Literals.XVARIABLE_DECLARATION__NAME);
	}
	
	@Check
	public void checkValidExtension(XtendParameter parameter) {
		if (parameter.isExtension()) {
			JvmFormalParameter jvmParameter = associations.getJvmParameter(parameter);
			if (jvmParameter != null)
				checkValidExtensionType(jvmParameter, parameter, SsPackage.Literals.XTEND_PARAMETER__PARAMETER_TYPE);
		}
	}
	
	protected void checkValidExtensionType(JvmIdentifiableElement identifiable, EObject source, EStructuralFeature feature) {
		LightweightTypeReference type = getActualType(identifiable);
		if (type != null && type.isPrimitive()) {
			error(String.format("The primitive type %s is not a valid extension", type.getSimpleName()), source, feature, INVALID_EXTENSION_TYPE);
		}
	}

	@Check
	public void checkAnnotationTarget(XAnnotation annotation) {
		JvmType annotationType = annotation.getAnnotationType();
		if (annotationType == null || annotationType.eIsProxy() || !(annotationType instanceof JvmAnnotationType)) {
			return;
		}
		Set<ElementType> targets = annotationUtil.getAnnotationTargets((JvmAnnotationType) annotationType);
		if (targets.isEmpty())
			return;
		final EObject eContainer = getContainingAnnotationTarget(annotation);
		for (Entry<Class<?>, ElementType> mapping : targetInfos.entrySet()) {
			if (mapping.getKey().isInstance(eContainer)) {
				if (!targets.contains(mapping.getValue())) {
					error("The annotation @" + annotation.getAnnotationType().getSimpleName()
							+ " is disallowed for this location.", annotation, null, INSIGNIFICANT_INDEX,
							ANNOTATION_WRONG_TARGET);
				}
			}
		}
	}

	protected EObject getContainingAnnotationTarget(XAnnotation annotation) {
		final EObject eContainer = annotation.eContainer();
		// skip synthetic container
		if (eContainer.eClass() == SsPackage.Literals.XTEND_MEMBER || eContainer.eClass() == SsPackage.Literals.XTEND_TYPE_DECLARATION) {
			return eContainer.eContainer();
		}
		return eContainer;
	}

	@Override
	@Check
	public void checkAssignment(XAssignment assignment) {
		JvmIdentifiableElement assignmentFeature = assignment.getFeature();
		if (assignmentFeature instanceof XtendParameter)
			error("Assignment to final parameter", Literals.XASSIGNMENT__ASSIGNABLE,
					ValidationMessageAcceptor.INSIGNIFICANT_INDEX, ASSIGNMENT_TO_FINAL);
		else
			super.checkAssignment(assignment);
	}

	@Check
	public void checkNoVoidInDependencyDeclaration(XtendField dep) {
		JvmTypeReference declaredFieldType = dep.getType();
		if (isPrimitiveVoid(declaredFieldType)) {
			error("Primitive void cannot be a dependency.", dep.getType(), null, INVALID_USE_OF_TYPE);
		}
	}
	
	@Check
	public void checkMemberNamesAreUnique(XtendTypeDeclaration xtendType) {
		final Multimap<String, XtendField> name2field = HashMultimap.create();
		final Multimap<JvmType, XtendField> type2extension = HashMultimap.create();
		for(XtendMember member: xtendType.getMembers()) {
			if(member instanceof XtendField) {
				XtendField field = (XtendField)member;
				 if(isEmpty(field.getName())) {
					 if(field.isExtension()) {
						 JvmTypeReference typeReference = field.getType();
						 if (typeReference != null) {
							 JvmType type = typeReference.getType();
							 if(type != null) 
								 type2extension.put(type, field);
						 }
					 }
				 } else {
					 name2field.put(field.getName(), field);
				 }
			}
		}
		for(String name: name2field.keySet()) {
			Collection<XtendField> fields = name2field.get(name);
			if(fields.size() >1) {
				for(XtendField field: fields)
					error("Duplicate field " + name, field, SsPackage.Literals.XTEND_FIELD__NAME, DUPLICATE_FIELD);
			}
		}
		for(JvmType type: type2extension.keySet()) {
			Collection<XtendField> fields = type2extension.get(type);
			if(fields.size() >1) {
				for(XtendField field: fields)
					error("Duplicate extension with same type", field, XTEND_FIELD__TYPE, DUPLICATE_FIELD);
			}
		}
	}


	@Check
	public void checkXtendParameterNotPrimitiveVoid(XtendParameter param) {
		if (isPrimitiveVoid(param.getParameterType())) {
			XtendFunction function = (XtendFunction) (param.eContainer() instanceof XtendFunction ? param.eContainer()
					: null);
			if (function != null)
				error("void is an invalid type for the parameter " + param.getName() + " of the method "
						+ function.getName(), param.getParameterType(), null, INVALID_USE_OF_TYPE);
			else
				error("void is an invalid type for the parameter " + param.getName(), param.getParameterType(), null,
						INVALID_USE_OF_TYPE);
		}
	}
	
	@Check
	public void checkVarArgIsNotExtension(XtendParameter param) {
		if (param.isVarArg() && param.isExtension()) {
			error("A vararg may not be an extension.", param, XTEND_PARAMETER__EXTENSION, INVALID_USE_OF_VAR_ARG);
		}
	}
	
	@Check
	public void checkVarArgComesLast(XtendParameter param) {
		if (param.isVarArg()) {
			@SuppressWarnings("unchecked")
			List<XtendParameter> params = (List<XtendParameter>) param.eContainer().eGet(param.eContainingFeature());
			if (param != Iterables.getLast(params)) {
				error("A vararg must be the last parameter.", param, XTEND_PARAMETER__VAR_ARG, INVALID_USE_OF_VAR_ARG);
			}
		}
	}
	
	@Check  
	public void checkClassPath(XModule xtendFile) {
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
	public void checkWhitespaceInRichStrings(RichString richString) {
		// don't check the indentation of nested rich strings in 
		// IF and FOR individually
		if (richString.eContainer() instanceof RichStringIf) {
			RichStringIf container = (RichStringIf) richString.eContainer();
			if (container.getThen() == richString || container.getElse() == richString)
				return;
		}
		if (richString.eContainer() instanceof RichStringElseIf) {
			RichStringElseIf container = (RichStringElseIf) richString.eContainer();
			if (container.getThen() == richString)
				return;
		}
		if (richString.eContainer() instanceof RichStringForLoop) {
			RichStringForLoop container = (RichStringForLoop) richString.eContainer();
			if (container.getEachExpression() == richString)
				return;
		}
		doCheckWhitespaceIn(richString);
	}

	protected void doCheckWhitespaceIn(RichString richString) {
		ValidatingRichStringAcceptor helper = new ValidatingRichStringAcceptor(this);
		richStringProcessor.process(richString, helper, helper);
	}

	@Check
	public void checkSuperTypes(XtendClass xtendClass) {
		JvmTypeReference superClass = xtendClass.getExtends();
		if (superClass != null && superClass.getType() != null) {
			if (!(superClass.getType() instanceof JvmGenericType)
					|| ((JvmGenericType) superClass.getType()).isInterface()) {
				error("Superclass must be a class", XTEND_CLASS__EXTENDS, CLASS_EXPECTED);
			} else {
				if (((JvmGenericType) superClass.getType()).isFinal()) {
					error("Attempt to override final class", XTEND_CLASS__EXTENDS, OVERRIDDEN_FINAL);
				}
				JvmGenericType inferredType = associations.getInferredType(xtendClass);
				if (inferredType != null && hasCycleInHierarchy(inferredType, Sets.<JvmGenericType> newHashSet())) {
					error("The inheritance hierarchy of " + notNull(xtendClass.getName()) + " contains cycles",
							XTEND_TYPE_DECLARATION__NAME, CYCLIC_INHERITANCE);
				}
				checkWildcardSupertype(xtendClass, superClass, XTEND_CLASS__EXTENDS, INSIGNIFICANT_INDEX);
			}
		}
		for (int i = 0; i < xtendClass.getImplements().size(); ++i) {
			JvmTypeReference implementedType = xtendClass.getImplements().get(i);
			if (!(implementedType.getType() instanceof JvmGenericType)
					|| !((JvmGenericType) implementedType.getType()).isInterface()) {
				error("Implemented interface must be an interface", XTEND_CLASS__IMPLEMENTS, i, INTERFACE_EXPECTED);
			}
			checkWildcardSupertype(xtendClass, implementedType, XTEND_CLASS__IMPLEMENTS, i);
		}
	}

	@Check
	public void checkSuperTypes(XtendInterface xtendInterface) {
		for (int i = 0; i < xtendInterface.getExtends().size(); ++i) {
			JvmTypeReference implementedType = xtendInterface.getExtends().get(i);
			if (!(implementedType.getType() instanceof JvmGenericType)
					|| !((JvmGenericType) implementedType.getType()).isInterface()) {
				error("Extended interface must be an interface", XTEND_INTERFACE__EXTENDS, i, INTERFACE_EXPECTED);
			}
			checkWildcardSupertype(xtendInterface, implementedType, XTEND_INTERFACE__EXTENDS, i);
		}
		JvmGenericType inferredType = associations.getInferredType(xtendInterface);
		if(inferredType != null && hasCycleInHierarchy(inferredType, Sets.<JvmGenericType> newHashSet())) {
			error("The inheritance hierarchy of " + notNull(xtendInterface.getName()) + " contains cycles",
					XTEND_TYPE_DECLARATION__NAME, CYCLIC_INHERITANCE);
		}
	}
	
	protected void checkWildcardSupertype(XtendTypeDeclaration xtendType, JvmTypeReference superTypeReference,
			EStructuralFeature feature, int index) { 
		if(isInvalidWildcard(superTypeReference)) 
			error("The type " 
					+ notNull(xtendType.getName()) 
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
	public void checkDuplicateAndOverriddenFunctions(XtendTypeDeclaration xtendType) {
		final JvmDeclaredType inferredType = associations.getInferredType(xtendType);
		if (inferredType instanceof JvmGenericType) {
			ResolvedOperations resolvedOperations = overrideHelper.getResolvedOperations(inferredType);
			
			Set<EObject> flaggedOperations = Sets.newHashSet();
			doCheckDuplicateExecutables((JvmGenericType) inferredType, resolvedOperations, flaggedOperations);
			doCheckOverriddenMethods(xtendType, (JvmGenericType) inferredType, resolvedOperations, flaggedOperations);
			doCheckFunctionOverrides(resolvedOperations, flaggedOperations);
		}
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
		if (member instanceof XtendFunction) 
			return XTEND_FUNCTION__NAME;
		else if(member instanceof XtendConstructor)
			return null;
		else if(member instanceof XtendField)
			return XTEND_FIELD__NAME;
		else
			return null;
	}
	
	
	protected void doCheckOverriddenMethods(XtendTypeDeclaration xtendType, JvmGenericType inferredType,
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
							XtendFunction source = findXtendFunction(localOperation);
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
										source, XTEND_FUNCTION__NAME, DUPLICATE_METHOD);
							}
						}
					}
				}
			}
		}
		if(xtendType instanceof XtendClass && operationsMissingImplementation != null && !operationsMissingImplementation.isEmpty()) {
			reportMissingImplementations((XtendClass) xtendType, operationsMissingImplementation);
		}
	}

	protected void reportMissingImplementations(XtendClass xtendClass, List<IResolvedOperation> operationsMissingImplementation) {
		StringBuilder errorMsg = new StringBuilder();
		errorMsg.append("The class ").append(xtendClass.getName()).append(" must be defined abstract because it does not implement ");
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
		error(errorMsg.toString(), xtendClass, XTEND_TYPE_DECLARATION__NAME, CLASS_MUST_BE_ABSTRACT, 
						toArray(uris, String.class));
	}
	
	protected void doCheckFunctionOverrides(ResolvedOperations resolvedOperations, Set<EObject> flaggedOperations) {
		for(IResolvedOperation operation: resolvedOperations.getDeclaredOperations()) {
			doCheckFunctionOverrides(operation, flaggedOperations);
		}
	}

	protected void doCheckFunctionOverrides(IResolvedOperation operation, Set<EObject> flaggedOperations) {
		XtendFunction function = findXtendFunction(operation);
		if (function != null && flaggedOperations.add(function)) {
			List<IResolvedOperation> allInherited = operation.getOverriddenAndImplementedMethods();
			if (allInherited.isEmpty()) {
				if (function.isOverride()) {
					error("The method "+ operation.getSimpleSignature() +" of type "+operation.getDeclaration().getDeclaringType().getSimpleName()+" must override a superclass method.", 
							function, XTEND_MEMBER__MODIFIERS, function.getModifiers().indexOf("override"), OBSOLETE_OVERRIDE);
				}
			} else {
				doCheckFunctionOverrides(function, operation, allInherited);
			}
		}
	}

	protected void doCheckFunctionOverrides(XtendFunction function, IResolvedOperation resolved,
			List<IResolvedOperation> allInherited) {
		boolean overrideProblems = false;
		List<IResolvedOperation> exceptionMismatch = null;
		for(IResolvedOperation inherited: allInherited) {
			if (inherited.getOverrideCheckResult().hasProblems()) {
				overrideProblems = true;
				EnumSet<OverrideCheckDetails> details = inherited.getOverrideCheckResult().getDetails();
				if (details.contains(OverrideCheckDetails.IS_FINAL)) {
					error("Attempt to override final method " + inherited.getSimpleSignature(), function,
							XTEND_FUNCTION__NAME, OVERRIDDEN_FINAL);
				} else if (details.contains(OverrideCheckDetails.REDUCED_VISIBILITY)) {
					error("Cannot reduce the visibility of the overridden method " + inherited.getSimpleSignature(),
							function, XTEND_FUNCTION__NAME, OVERRIDE_REDUCES_VISIBILITY);
				} else if (details.contains(OverrideCheckDetails.EXCEPTION_MISMATCH)) {
					if (exceptionMismatch == null)
						exceptionMismatch = Lists.newArrayListWithCapacity(allInherited.size());
					exceptionMismatch.add(inherited);
				} else if (details.contains(OverrideCheckDetails.RETURN_MISMATCH)) {
					error("The return type is incompatible with " + inherited.getSimpleSignature(), function,
							XTEND_FUNCTION__RETURN_TYPE, INCOMPATIBLE_RETURN_TYPE);
				}
			}
		}
		if (exceptionMismatch != null) {
			createExceptionMismatchError(resolved, function, exceptionMismatch);
		}
		if (!overrideProblems && !function.isOverride() && !function.isStatic()) {
			error("The method " + resolved.getSimpleSignature() + " of type " + resolved.getDeclaration().getDeclaringType().getSimpleName() +
					" must use override keyword since it actually overrides a supertype method.", function,
					XTEND_FUNCTION__NAME, MISSING_OVERRIDE);
		} 
		if (!overrideProblems && function.isOverride() && function.isStatic()) {
			for(IResolvedOperation inherited: allInherited) {
				error("The method " + resolved.getSimpleSignature() + " of type " + resolved.getDeclaration().getDeclaringType().getSimpleName() + 
					" shadows the method " + resolved.getSimpleSignature() + " of type " + inherited.getDeclaration().getDeclaringType().getSimpleName() + 
					", but does not override it.", function, XTEND_FUNCTION__NAME, function.getModifiers().indexOf("override"), OBSOLETE_OVERRIDE);
			}
		}
	}
	
	protected void createExceptionMismatchError(IResolvedOperation operation, XtendFunction function,
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
		error(message.toString(), function, XTEND_FUNCTION__EXCEPTIONS, INCOMPATIBLE_THROWS_CLAUSE);
	}

	@Nullable
	protected XtendFunction findXtendFunction(IResolvedOperation operation) {
		EObject sourceElement = associations.getPrimarySourceElement(operation.getDeclaration());
		if (sourceElement instanceof XtendFunction)
			return (XtendFunction) sourceElement;
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
	public void checkDefaultSuperConstructor(XtendClass xtendClass) {
		JvmGenericType inferredType = associations.getInferredType(xtendClass);
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
						issueData.add(doGetReadableSignature(xtendClass.getName(), superConstructor.getParameters()));
					}
					error("No default constructor in super type " + superType.getSimpleName() + "." +
							xtendClass.getName() + " must define an explicit constructor.",
							xtendClass, XTEND_TYPE_DECLARATION__NAME, MISSING_CONSTRUCTOR, toArray(issueData, String.class));
				} else {
					for(JvmConstructor constructor: constructors) {
						XExpression expression = containerProvider.getAssociatedExpression(constructor);
						if (expression instanceof XBlockExpression) {
							List<XExpression> expressions = ((XBlockExpression) expression).getExpressions();
							if(expressions.isEmpty() || !isDelegatConstructorCall(expressions.get(0))) {
								XtendConstructor xtendConstructor = associations.getXtendConstructor(constructor);
								error("No default constructor in super type " + superType.getSimpleName() 
										+ ". Another constructor must be invoked explicitly.",
										xtendConstructor, null, MUST_INVOKE_SUPER_CONSTRUCTOR);
							}
						}
					}
				}
			}
		} 
	}

	protected boolean isDelegatConstructorCall(XExpression expression) {
		if(expression instanceof XFeatureCall) {
			JvmIdentifiableElement feature = ((XFeatureCall)expression).getFeature();
			return (feature != null && !feature.eIsProxy() && feature instanceof JvmConstructor);
		}
		return false;
	}

	protected boolean isInterface(JvmDeclaredType type) {
		return type instanceof JvmGenericType && ((JvmGenericType) type).isInterface();
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
	public void checkParameterNames(XtendFunction function) {
		for (int i = 0; i < function.getParameters().size(); ++i) {
			String leftParameterName = function.getParameters().get(i).getName();
			for (int j = i + 1; j < function.getParameters().size(); ++j) {
				if (equal(leftParameterName, function.getParameters().get(j).getName())) {
					error("Duplicate parameter " + leftParameterName, XTEND_FUNCTION__PARAMETERS, i, DUPLICATE_PARAMETER_NAME);
					error("Duplicate parameter " + leftParameterName, XTEND_FUNCTION__PARAMETERS, j, DUPLICATE_PARAMETER_NAME);
				}
			}
			if (function.getCreateExtensionInfo() != null) {
				if (equal(leftParameterName, function.getCreateExtensionInfo().getName())) {
					error("Duplicate parameter " + leftParameterName, XTEND_FUNCTION__PARAMETERS, i, DUPLICATE_PARAMETER_NAME);
					if (function.getCreateExtensionInfo().eIsSet(CREATE_EXTENSION_INFO__NAME))
						error("Duplicate parameter " + leftParameterName, function.getCreateExtensionInfo(),
								CREATE_EXTENSION_INFO__NAME, DUPLICATE_PARAMETER_NAME);
					else
						error("Duplicate implicit parameter 'it'", function.getCreateExtensionInfo(),
								CREATE_EXTENSION_INFO__NAME, DUPLICATE_PARAMETER_NAME);
				}
			}
		}
	}
	
	@Check
	public void checkAbstract(XtendFunction function) {
		if (function.getExpression() == null) {
			if(function.getDeclaringType() instanceof XtendClass) {
				XtendClass declarator = (XtendClass) function.getDeclaringType();
				if (function.isDispatch()) {
					error("The dispatch method " + function.getName() + " in type " + declarator.getName() + " must not be abstract",XTEND_FUNCTION__NAME, -1, DISPATCH_FUNCTIONS_MUST_NOT_BE_ABSTRACT);
					return;
				}
				if (function.getCreateExtensionInfo() != null) {
					error("The 'create'-method " + function.getName() + " in type " + declarator.getName() + " must not be abstract",XTEND_FUNCTION__NAME, -1, CREATE_FUNCTIONS_MUST_NOT_BE_ABSTRACT);
					return;
				}
				if (!declarator.isAbstract()) {
					error("The abstract method " + function.getName() + " in type " + declarator.getName() + " can only be defined by an abstract class.", 
							XTEND_FUNCTION__NAME, -1, MISSING_ABSTRACT);
				}
				if(function.getReturnType() == null) {
					error("The abstract method " + function.getName() + " in type " + declarator.getName() + " must declare a return type",
							XTEND_FUNCTION__NAME, -1, ABSTRACT_METHOD_MISSING_RETURN_TYPE);
				}
			} else if(function.eContainer() instanceof XtendInterface) {
				XtendInterface declarator = (XtendInterface) function.eContainer();
				if (function.getCreateExtensionInfo() != null) {
					error("'Create'-method " + function.getName() + " is not permitted in an interface", XTEND_FUNCTION__NAME, -1, CREATE_FUNCTIONS_MUST_NOT_BE_ABSTRACT);
					return;
				}
				if(function.getReturnType() == null && !function.isOverride()) {
					error("The abstract method " + function.getName() + " in type " + declarator.getName() + " must declare a return type",
							XTEND_FUNCTION__NAME, -1, ABSTRACT_METHOD_MISSING_RETURN_TYPE);
				}
			}
		} else if(function.getDeclaringType() instanceof XtendInterface) {
			error("Abstract methods do not specify a body", XTEND_FUNCTION__NAME, -1, ABSTRACT_METHOD_WITH_BODY);
		}
	}
	
	@Check
	public void checkParameterNames(XtendConstructor constructor) {
		for (int i = 0; i < constructor.getParameters().size(); ++i) {
			String leftParameterName = constructor.getParameters().get(i).getName();
			for (int j = i + 1; j < constructor.getParameters().size(); ++j) {
				if (equal(leftParameterName, constructor.getParameters().get(j).getName())) {
					error("Duplicate parameter " + leftParameterName, XTEND_CONSTRUCTOR__PARAMETERS, i, DUPLICATE_PARAMETER_NAME);
					error("Duplicate parameter " + leftParameterName, XTEND_CONSTRUCTOR__PARAMETERS, j, DUPLICATE_PARAMETER_NAME);
				}
			}
		}
	}

	@Check
	public void dispatchFuncWithTypeParams(XtendFunction func) {
		if (func.isDispatch()) {
			if (func.getParameters().isEmpty()) {
				error("A dispatch method must at least have one parameter declared.", func, 
						XTEND_MEMBER__MODIFIERS, func.getModifiers().indexOf("dispatch"),
						IssueCodes.DISPATCH_FUNC_WITHOUT_PARAMS);
			}
			if (!func.getTypeParameters().isEmpty()) {
				error("A dispatch method must not declare any type parameters.", func,
						XTEND_MEMBER__MODIFIERS, func.getModifiers().indexOf("dispatch"),
						IssueCodes.DISPATCH_FUNC_WITH_TYPE_PARAMS);
			}
			if (func.getName().startsWith("_")) {
				error("A dispatch method's name must not start with an underscore.", func, XTEND_FUNCTION__NAME,
						IssueCodes.DISPATCH_FUNC_NAME_STARTS_WITH_UNDERSCORE);
			}
		}
	}

	@Check
	public void checkDispatchFunctions(XtendClass clazz) {
		JvmGenericType type = associations.getInferredType(clazz);
		if (type != null) {
			Multimap<DispatchHelper.DispatchSignature, JvmOperation> dispatchMethods = dispatchHelper.getDeclaredOrEnhancedDispatchMethods(type);
			checkDispatchNonDispatchConflict(clazz, dispatchMethods);
			for (DispatchHelper.DispatchSignature signature : dispatchMethods.keySet()) {
				Collection<JvmOperation> dispatchOperations = dispatchMethods.get(signature);
				JvmOperation syntheticDispatchMethod = dispatchHelper.getDispatcherOperation(type, signature);
				if (syntheticDispatchMethod != null) {
					JvmOperation overriddenOperation = overrideHelper.findOverriddenOperation(syntheticDispatchMethod);
					Boolean expectStatic = null;
					if(overriddenOperation != null) { 
						if (isMorePrivateThan(syntheticDispatchMethod.getVisibility(), overriddenOperation.getVisibility())) {
							String msg = "Synthetic dispatch method reduces visibility of overridden method " + overriddenOperation.getIdentifier();
							addDispatchError(type, dispatchOperations, msg, null, OVERRIDE_REDUCES_VISIBILITY);
						}
						expectStatic = overriddenOperation.isStatic();
					} 
					LightweightTypeReference dispatchMethodReturnType = getActualType(clazz, syntheticDispatchMethod);
					if (dispatchOperations.size() == 1) {
						JvmOperation singleOp = dispatchOperations.iterator().next();
						XtendFunction function = associations.getXtendFunction(singleOp);
						addIssue("Single dispatch method.", function, XTEND_MEMBER__MODIFIERS,
								function.getModifiers().indexOf("dispatch"), SINGLE_DISPATCH_FUNCTION);
					} else {
						Multimap<List<JvmType>, JvmOperation> signatures = HashMultimap.create();
						boolean isFirstLocalOperation = true;
						JvmVisibility commonVisibility = null;
						Boolean commonStatic = null;
						for (JvmOperation jvmOperation : dispatchOperations) {
							signatures.put(getParamTypes(jvmOperation, true), jvmOperation);
							if(jvmOperation.getDeclaringType() == type) {
								if(expectStatic != null) {
									if (expectStatic && !jvmOperation.isStatic()) {
										String msg = "The dispatch method must be static because the dispatch methods in the superclass are static.";
										addDispatchError(jvmOperation, msg, "static", DISPATCH_FUNCTIONS_STATIC_EXPECTED);
									}
									if (!expectStatic && jvmOperation.isStatic()) {
										String msg = "The dispatch method must not be static because the dispatch methods in the superclass are not static.";
										addDispatchError(jvmOperation, msg, "static", DISPATCH_FUNCTIONS_NON_STATIC_EXPECTED);
									}
								}
								if (isFirstLocalOperation) {
									commonVisibility = jvmOperation.getVisibility();
									commonStatic = jvmOperation.isStatic();
									isFirstLocalOperation = false;
								} else {
									if (jvmOperation.getVisibility() != commonVisibility) {
										commonVisibility = null;
									}
									if (commonStatic != null && commonStatic != jvmOperation.isStatic()) {
										commonStatic = null;
									}
								}
							}
							// TODO move validation to type computation
							if (dispatchMethodReturnType != null) {
								XtendFunction function = associations.getXtendFunction(jvmOperation);
								if (function != null) {
									LightweightTypeReference operationType = getActualType(function.getExpression(), jvmOperation);
									if (!dispatchMethodReturnType.isAssignableFrom(operationType)) {
										error("Incompatible return type of dispatch method. Expected "
												+ syntheticDispatchMethod.getSimpleName() + " but was "
												+ operationType.getSimpleName(), function,
												SsPackage.Literals.XTEND_FUNCTION__RETURN_TYPE,
												ValidationMessageAcceptor.INSIGNIFICANT_INDEX, INCOMPATIBLE_RETURN_TYPE);
									}
								}
							}
						}
						if (commonVisibility == null) {
							addDispatchError(type, dispatchOperations, "All local dispatch methods must have the same visibility.", 
									null, DISPATCH_FUNCTIONS_WITH_DIFFERENT_VISIBILITY);
						}
						if (expectStatic == null && commonStatic == null) {
							addDispatchError(type, dispatchOperations, "Static and non-static dispatch methods can not be mixed.", 
									"static",	DISPATCH_FUNCTIONS_MIXED_STATIC_AND_NON_STATIC);
						}
						for (final List<JvmType> paramTypes : signatures.keySet()) {
							Collection<JvmOperation> ops = signatures.get(paramTypes);
							if (ops.size() > 1) {
								if (Iterables.any(ops, new Predicate<JvmOperation>() {
									public boolean apply(JvmOperation input) {
										return !getParamTypes(input, false).equals(paramTypes);
									}
								})) {
									for (JvmOperation jvmOperation : ops) {
										XtendFunction function = associations.getXtendFunction(jvmOperation);
										error("Duplicate dispatch methods. Primitives cannot overload their wrapper types in dispatch methods.",
												function, null, DUPLICATE_METHOD);
									}
								}
							}
						}
					}
				}
			}
		}
	}

	protected void checkDispatchNonDispatchConflict(XtendClass clazz,
			Multimap<DispatchHelper.DispatchSignature, JvmOperation> dispatchMethods) {
		if(isIgnored(DISPATCH_PLAIN_FUNCTION_NAME_CLASH)) {
			return;
		}
		Multimap<DispatchHelper.DispatchSignature, XtendFunction> nonDispatchMethods = HashMultimap.create();
		for(XtendFunction method: filter(clazz.getMembers(), XtendFunction.class)) {
			if(!method.isDispatch()) {
				nonDispatchMethods.put(new DispatchHelper.DispatchSignature(method.getName(), method.getParameters().size()), method);
			}
		}
		for (DispatchHelper.DispatchSignature dispatchSignature : dispatchMethods.keySet()) {
			if (nonDispatchMethods.containsKey(dispatchSignature)) {
				for (XtendFunction function : nonDispatchMethods.get(dispatchSignature))
					addIssue("Non-dispatch method has same name and number of parameters as dispatch method", function,
							XTEND_FUNCTION__NAME,
							DISPATCH_PLAIN_FUNCTION_NAME_CLASH);
				for (JvmOperation operation : dispatchMethods.get(dispatchSignature))
					addIssue("Dispatch method has same name and number of parameters as non-dispatch method", associations.getXtendFunction(operation),
							XTEND_FUNCTION__NAME,
							DISPATCH_PLAIN_FUNCTION_NAME_CLASH);
			}
		}
	}

	protected void addDispatchError(JvmGenericType type, Iterable<JvmOperation> operations, String message, String modifier, String ISSUE_ID) {
		for (JvmOperation jvmOperation : operations)
			if (jvmOperation.getDeclaringType() == type)
				addDispatchError(jvmOperation, message, modifier, ISSUE_ID);
	}
	
	protected void addDispatchError(JvmOperation jvmOperation, String message, String modifier, String ISSUE_ID) {
		XtendFunction function = associations.getXtendFunction(jvmOperation);
		if (function != null) {
			int modifierIndex = -1;
			if(modifier != null) {
				modifierIndex = function.getModifiers().indexOf(modifier);
			} else {
				for(int i = 0; i < function.getModifiers().size(); ++i) {
					if(visibilityModifers.contains(function.getModifiers().get(i))) {
						modifierIndex = i;
						break;
					}
				}
			}
			if(modifierIndex == -1)
				modifierIndex = function.getModifiers().indexOf("dispatch");
			error(message, function, XTEND_MEMBER__MODIFIERS, modifierIndex, ISSUE_ID);
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

	@Check
	public void checkNoReturnsInCreateExtensions(XtendFunction func) {
		if (func.getCreateExtensionInfo() == null)
			return;
		List<XReturnExpression> found = newArrayList();
		collectReturnExpressions(func.getCreateExtensionInfo().getCreateExpression(), found);
		for (XReturnExpression xReturnExpression : found) {
			error("Return is not allowed in creation expression", xReturnExpression, null, INVALID_EARLY_EXIT);
		}
	}

	@Check
	public void checkCreateFunctionIsNotTypeVoid(XtendFunction func) {
		if (func.getCreateExtensionInfo() == null)
			return;
		JvmOperation operation = associations.getDirectlyInferredOperation(func);
		if (func.getReturnType() == null) {
			if (isPrimitiveVoid(operation.getReturnType())) {
				error("void is an invalid type for the create method " + func.getName(), func,
						SsPackage.Literals.XTEND_FUNCTION__NAME, INVALID_USE_OF_TYPE);
			}
		} else if (isPrimitiveVoid(func.getReturnType())) {
			if (func.getReturnType() != null)
				error("Create method " + func.getName() + " may not declare return type void.", func.getReturnType(),
						null, INVALID_USE_OF_TYPE);
			else
				error("The inherited return type void of " + func.getName() + " is invalid for create method.",
						func.getReturnType(), null, INVALID_USE_OF_TYPE);
		}
	}
	
	@Check
	public void checkCreateFunctionIsNotGeneric(XtendFunction func) {
		if (func.getCreateExtensionInfo() == null)
			return;
		if (!func.getTypeParameters().isEmpty())
			error("Create methods can not have type parameters.", func, 
					XTEND_MEMBER__MODIFIERS, func.getModifiers().indexOf("static"),
					INVALID_USE_OF_STATIC);
	}
	
	@Check
	public void checkCreateFunctionIsNotStatic(XtendFunction func) {
		if (func.getCreateExtensionInfo() == null)
			return;
		if (func.isStatic())
			error("Create methods can not be static.", func, 
					XTEND_MEMBER__MODIFIERS, func.getModifiers().indexOf("static"),
					INVALID_USE_OF_STATIC);
	}

	@Override
	protected boolean isValueExpectedRecursive(XExpression expr) {
		EObject container = expr.eContainer();
		if (container instanceof RichString 
			|| container instanceof RichStringForLoop
			|| container instanceof XtendField) {
			return true;
		}
		return super.isValueExpectedRecursive(expr);
	}

	protected void collectReturnExpressions(EObject expr, List<XReturnExpression> found) {
		if (expr instanceof XReturnExpression) {
			found.add((XReturnExpression) expr);
		} else if (expr instanceof XClosure) {
			return;
		}
		for (EObject child : expr.eContents()) {
			collectReturnExpressions(child, found);
		}
	}

	@Check
	public void checkClasses(XModule file) {
		//TODO this check should not be file local, but instead check for any other sources which might declare a
		// java type with the same name. Also this then belongs to Xbase and should be defined on JvmDeclaredType
		Set<String> names = newLinkedHashSet();
		for (XtendTypeDeclaration clazz : file.getXtendTypes()) {	
			if (!names.add(clazz.getName()))
				error("The type "+clazz.getName()+" is already defined.", clazz, SsPackage.Literals.XTEND_TYPE_DECLARATION__NAME, -1, IssueCodes.DUPLICATE_TYPE_NAME);
		}
	}
	
	public boolean doCheckValidMemberName(XtendMember member) {
		EStructuralFeature nameAttribute = member.eClass().getEStructuralFeature("name");
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
	public void checkLocalUsageOfDeclaredFields(XtendField field){
		if(doCheckValidMemberName(field) && !isIgnored(UNUSED_PRIVATE_MEMBER)) {
			JvmField jvmField = associations.getJvmField(field);
			if (jvmField == null || jvmField.getVisibility() != JvmVisibility.PRIVATE)
				return;
			if (hasAnnotation(field.getAnnotations(), Property.class))
				return;
			if (hasAnnotation(((XtendAnnotationTarget)field.eContainer()).getAnnotations(), Data.class))
				return;
			if (isLocallyUsed(jvmField, field.eContainer())) 
				return;
			String message;
			if(field.isExtension()) {
				if(field.getName() == null && jvmField.getType() != null)
					message = "The extension " + jvmField.getType().getIdentifier() 
						+ " is not used in " + jvmField.getDeclaringType().getSimpleName();
				else
					message = "The extension " + jvmField.getDeclaringType().getSimpleName() + "."
							+ jvmField.getSimpleName() + " is not used";
			} else {
				message = "The value of the field " + jvmField.getDeclaringType().getSimpleName() + "."
					+ jvmField.getSimpleName() + " is not used";
			}
			addIssueToState(UNUSED_PRIVATE_MEMBER, message, SsPackage.Literals.XTEND_FIELD__NAME);
		}
	}
	
	@Check
	public void checkLocalUsageOfDeclaredXtendFunction(XtendFunction function){
		if(doCheckValidMemberName(function) && !isIgnored(UNUSED_PRIVATE_MEMBER)) {
			JvmOperation jvmOperation = function.isDispatch()?associations.getDispatchOperation(function):associations.getDirectlyInferredOperation(function);
			if(jvmOperation != null && jvmOperation.getVisibility() == JvmVisibility.PRIVATE && !isLocallyUsed(jvmOperation, function.eContainer())){
				String message = "The method " + jvmOperation.getSimpleName() 
						+  uiStrings.parameters(jvmOperation)  
						+ " from the type "+jvmOperation.getDeclaringType().getSimpleName()+" is never used locally.";
				addIssueToState(UNUSED_PRIVATE_MEMBER, message, SsPackage.Literals.XTEND_FUNCTION__NAME);
			}
		}
	}
	
	@Check
	public void checkDeclaredExceptions(XtendConstructor constructor){
		JvmConstructor jvmType = associations.getInferredConstructor(constructor);
		checkExceptions(constructor, jvmType.getExceptions(), SsPackage.Literals.XTEND_CONSTRUCTOR__EXCEPTIONS);
	}
	
	@Check
	public void checkTypeParameterForwardReferences(XtendClass xtendClass) {
		doCheckTypeParameterForwardReference(xtendClass.getTypeParameters());
	}
	
	@Check
	public void checkTypeParameterForwardReferences(XtendInterface xtendInterface) {
		doCheckTypeParameterForwardReference(xtendInterface.getTypeParameters());
	}
	
	@Check
	public void checkTypeParameterForwardReferences(XtendFunction xtendFunction) {
		doCheckTypeParameterForwardReference(xtendFunction.getTypeParameters());
	}
	
	@Check
	public void checkTypeParametersAreUnsupported(XtendConstructor constructor){
		if (!constructor.getTypeParameters().isEmpty()) {
			error("Type parameters are not supported for constructors", SsPackage.Literals.XTEND_CONSTRUCTOR__TYPE_PARAMETERS, INSIGNIFICANT_INDEX, CONSTRUCTOR_TYPE_PARAMS_NOT_SUPPORTED);
		}
	}
	
	@Check
	public void checkDeclaredExceptions(XtendFunction function){
		JvmOperation jvmOperation = associations.getDirectlyInferredOperation(function);
		if (jvmOperation != null) {
			checkExceptions(function,jvmOperation.getExceptions(), SsPackage.Literals.XTEND_FUNCTION__EXCEPTIONS);
		}
	}
	
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
	public void checkJavaKeywordConflict(XtendField member) {
		checkNoJavaKeyword(member, SsPackage.Literals.XTEND_FIELD__NAME);
	}
	
	@Check
	public void checkJavaKeywordConflict(XtendFunction member) {
		if (member.eContainer() instanceof XtendAnnotationType && "do".equals(member.getName()))
			return;
		checkNoJavaKeyword(member, SsPackage.Literals.XTEND_FUNCTION__NAME);
		for (JvmTypeParameter p : member.getTypeParameters()) {
			checkNoJavaKeyword(p, TypesPackage.Literals.JVM_TYPE_PARAMETER__NAME);
		}
	}
	
	@Check
	public void checkJavaKeywordConflict(XtendConstructor member) {
		for (JvmTypeParameter p : member.getTypeParameters()) {
			checkNoJavaKeyword(p, TypesPackage.Literals.JVM_TYPE_PARAMETER__NAME);
		}
	}
	
	@Check
	public void checkJavaKeywordConflict(XtendTypeDeclaration member) {
		checkNoJavaKeyword(member, SsPackage.Literals.XTEND_TYPE_DECLARATION__NAME);
	}

	@Check
	public void checkJavaKeywordConflict(XtendClass member) {
		for (JvmTypeParameter p : member.getTypeParameters()) {
			checkNoJavaKeyword(p, TypesPackage.Literals.JVM_TYPE_PARAMETER__NAME);
		}
	}
	
	@Check
	public void checkJavaKeywordConflict(XtendInterface member) {
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
	public void checkNonInitializedFieldsHaveAType(XtendField field) {
		if (field.getType() == null && field.getInitialValue() == null) {
			error("The field "+field.getName()+" needs an explicit type since there is no initialization expression to infer the type from.", field, XTEND_FIELD__NAME, TOO_LITTLE_TYPE_INFORMATION);
		}
	}
	
	@Check
	public void checkFieldsAreCalledSelf(XtendField field) {
		if ("self".equals(field.getName())) {
			addIssue("'self' is a discouraged name", field, XTEND_FIELD__NAME, VARIABLE_NAME_DISCOURAGED);
		}
	}
	
	@Check
	public void checkFinalFieldInitialization(XtendClass clazz) {
		JvmGenericType inferredType = associations.getInferredType(clazz);
		if (inferredType == null)
			return;
		JvmConstructor inferredConstructor = associations.getInferredConstructor(clazz);
		if(inferredConstructor != null)
			for (XAnnotation anno : clazz.getAnnotations()) {
				if (anno.getAnnotationType() != null && Data.class.getName().equals(anno.getAnnotationType().getIdentifier()))
					return;
			}
		super.checkFinalFieldInitialization(inferredType);
	}
	
	@Check
	public void checkFinalFieldInitialization(XtendInterface xtendInterface) {
		JvmGenericType inferredType = associations.getInferredType(xtendInterface);
		super.checkFinalFieldInitialization(inferredType);
	}
	
	@Check
	public void checkJavaDocRefs(XtendMember member){
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

	@Override
	protected void reportUninitializedField(JvmField field) {
		EObject element = associations.getPrimarySourceElement(field);
		if (element instanceof XtendField) {
			XtendField xtendField = (XtendField) element;
			error("The blank final field "+xtendField.getName()+" may not have been initialized.", xtendField, XTEND_FIELD__NAME, FIELD_NOT_INITIALIZED);
		}
	}
	
	protected boolean hasAnnotation(Iterable<? extends XAnnotation> annotations, Class<?> annotationType) {
		for (XAnnotation anno : annotations) {
			if (anno.getAnnotationType() != null && annotationType.getName().equals(anno.getAnnotationType().getIdentifier()))
				return true;
		}
		return false;
	}
	
	private ModifierValidator classModifierValidator = new ModifierValidator(
			newArrayList("public", "package", "static", "final", "abstract"), this);
		
	private ModifierValidator interfaceModifierValidator = new ModifierValidator(
			newArrayList("public", "package", "abstract"), this);
		
	private ModifierValidator enumModifierValidator = new ModifierValidator(
			newArrayList("public", "package"), this);
		
	private ModifierValidator fieldModifierValidator = new ModifierValidator(
			newArrayList("public", "protected", "package", "private", "static", "final", "val", "var", "extension"), this);
		
	private ModifierValidator fieldInInterfaceModifierValidator = new ModifierValidator(
			newArrayList("public", "static", "final", "val"), this);
		
	private ModifierValidator constructorModifierValidator = new ModifierValidator(
			newArrayList(visibilityModifers), this);
		
	private ModifierValidator methodModifierValidator = new ModifierValidator(
			newArrayList("public", "protected", "package", "private", "static", "abstract", "dispatch", "final", "function", "override"), this);
		
	private ModifierValidator methodInInterfaceModifierValidator = new ModifierValidator(
			newArrayList("public", "abstract", "def", "override"), this);
		
	private ModifierValidator annotationTypeModifierValidator = new ModifierValidator(
			newArrayList("public", "package", "abstract"), this);
		
	@Check
	protected void checkModifiers(XtendClass xtendClass) {
		classModifierValidator.checkModifiers(xtendClass, "class " + xtendClass.getName());
	}
	
	@Check
	protected void checkModifiers(XtendInterface xtendInterface) {
		interfaceModifierValidator.checkModifiers(xtendInterface, "interface " + xtendInterface.getName());
	}
	
	@Check
	protected void checkModifiers(XtendEnum xtendEnum) {
		enumModifierValidator.checkModifiers(xtendEnum, "enum " + xtendEnum.getName());
	}
	
	@Check
	protected void checkModifiers(XtendField field) {
		if(field.getDeclaringType() instanceof XtendClass)
			fieldModifierValidator.checkModifiers(field, "field " + field.getName());
		else if(field.getDeclaringType() instanceof XtendInterface 
				|| field.getDeclaringType() instanceof XtendAnnotationType)
			fieldInInterfaceModifierValidator.checkModifiers(field,  "field " + field.getName());
	}
	
	@Check
	protected void checkModifiers(XtendConstructor constructor) {
		if(!(constructor.getDeclaringType() instanceof XtendClass)) {
			error("Contructors are only permitted within classes", null, CONSTRUCTOR_NOT_PERMITTED);
		} else {
			String typeName = ((XtendTypeDeclaration) constructor.eContainer()).getName();
			constructorModifierValidator.checkModifiers(constructor, "type " + typeName);
		}
	}

	@Check
	protected void checkModifiers(XtendFunction method) {
		if(method.getDeclaringType() instanceof XtendClass) {
			methodModifierValidator.checkModifiers(method, "method " + method.getName());
			int abstractIndex = method.getModifiers().indexOf("abstract");
			if (method.getExpression() != null) {
				if (abstractIndex != -1) 
					error("Method " + method.getName() + " with a body cannot be abstract", XTEND_MEMBER__MODIFIERS, abstractIndex, INVALID_MODIFIER);
			} else {
				int finalIndex = method.getModifiers().indexOf("final");
				if(finalIndex != -1) 
					error("Abstract method " + method.getName() + " cannot be final", XTEND_MEMBER__MODIFIERS, finalIndex, INVALID_MODIFIER);
			}
		} else if(method.getDeclaringType() instanceof XtendInterface) {
			methodInInterfaceModifierValidator.checkModifiers(method, "method " + method.getName());			
		}
	}

	@Check
	protected void checkModifiers(XtendAnnotationType annotation) {
		annotationTypeModifierValidator.checkModifiers(annotation, "annotation type " + annotation.getName());
	}
	
}
