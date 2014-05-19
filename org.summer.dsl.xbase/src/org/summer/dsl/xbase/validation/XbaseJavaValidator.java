/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.summer.dsl.xbase.validation;

import static com.google.common.collect.Iterables.concat;
import static com.google.common.collect.Iterables.contains;
import static com.google.common.collect.Sets.newHashSet;
import static org.summer.dsl.model.xbase.XbasePackage.Literals.XABSTRACT_FEATURE_CALL__FEATURE;
import static org.summer.dsl.xbase.validation.IssueCodes.ASSIGNMENT_TO_FINAL;
import static org.summer.dsl.xbase.validation.IssueCodes.CIRCULAR_CONSTRUCTOR_INVOCATION;
import static org.summer.dsl.xbase.validation.IssueCodes.EQUALS_WITH_NULL;
import static org.summer.dsl.xbase.validation.IssueCodes.FIELD_ALREADY_INITIALIZED;
import static org.summer.dsl.xbase.validation.IssueCodes.ILLEGAL_FORWARD_REFERENCE;
import static org.summer.dsl.xbase.validation.IssueCodes.IMPORT_UNUSED;
import static org.summer.dsl.xbase.validation.IssueCodes.IMPORT_WILDCARD_DEPRECATED;
import static org.summer.dsl.xbase.validation.IssueCodes.INCOMPATIBLE_TYPES;
import static org.summer.dsl.xbase.validation.IssueCodes.INVALID_CAST;
import static org.summer.dsl.xbase.validation.IssueCodes.INVALID_CONSTRUCTOR_ARGUMENT;
import static org.summer.dsl.xbase.validation.IssueCodes.INVALID_CONSTRUCTOR_INVOCATION;
import static org.summer.dsl.xbase.validation.IssueCodes.INVALID_INNER_EXPRESSION;
import static org.summer.dsl.xbase.validation.IssueCodes.INVALID_INSTANCEOF;
import static org.summer.dsl.xbase.validation.IssueCodes.INVALID_NUMBER_FORMAT;
import static org.summer.dsl.xbase.validation.IssueCodes.INVALID_RETURN;
import static org.summer.dsl.xbase.validation.IssueCodes.INVALID_TYPE;
import static org.summer.dsl.xbase.validation.IssueCodes.INVALID_TYPE_PARAMETER_BOUNDS;
import static org.summer.dsl.xbase.validation.IssueCodes.INVALID_USE_OF_TYPE;
import static org.summer.dsl.xbase.validation.IssueCodes.INVALID_USE_OF_WILDCARD;
import static org.summer.dsl.xbase.validation.IssueCodes.JAVA_STYLE_TYPE_CAST;
import static org.summer.dsl.xbase.validation.IssueCodes.MISSING_INITIALIZATION;
import static org.summer.dsl.xbase.validation.IssueCodes.MISSING_TYPE;
import static org.summer.dsl.xbase.validation.IssueCodes.NULL_SAFE_FEATURE_CALL_OF_PRIMITIVE_VALUED_FEATURE;
import static org.summer.dsl.xbase.validation.IssueCodes.NULL_SAFE_FEATURE_CALL_ON_PRIMITIVE;
import static org.summer.dsl.xbase.validation.IssueCodes.OBSOLETE_INSTANCEOF;
import static org.summer.dsl.xbase.validation.IssueCodes.PRIMITIVE_COMPARED_TO_NULL;
import static org.summer.dsl.xbase.validation.IssueCodes.STATIC_ACCESS_TO_INSTANCE_MEMBER;
import static org.summer.dsl.xbase.validation.IssueCodes.TOO_MANY_PARAMS_IN_CLOSURE;
import static org.summer.dsl.xbase.validation.IssueCodes.TYPE_PARAMETER_FORWARD_REFERENCE;
import static org.summer.dsl.xbase.validation.IssueCodes.UNUSED_LOCAL_VARIABLE;

import java.io.Serializable;
import java.util.Collection;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.jdt.annotation.NonNullByDefault;
import org.eclipse.xtext.CrossReference;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.EcoreUtil2.ElementReferenceAcceptor;
import org.eclipse.xtext.TerminalRule;
import org.eclipse.xtext.documentation.IJavaDocTypeReferenceProvider;
import org.eclipse.xtext.nodemodel.BidiTreeIterator;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.ILeafNode;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.util.ITextRegion;
import org.eclipse.xtext.util.ReplaceRegion;
import org.eclipse.xtext.validation.Check;
import org.eclipse.xtext.validation.ComposedChecks;
import org.eclipse.xtext.validation.ValidationMessageAcceptor;
import org.summer.dsl.model.types.JvmConstructor;
import org.summer.dsl.model.types.JvmDeclaredType;
import org.summer.dsl.model.types.JvmExecutable;
import org.summer.dsl.model.types.JvmFeature;
import org.summer.dsl.model.types.JvmField;
import org.summer.dsl.model.types.JvmFormalParameter;
import org.summer.dsl.model.types.JvmGenericArrayTypeReference;
import org.summer.dsl.model.types.JvmGenericType;
import org.summer.dsl.model.types.JvmIdentifiableElement;
import org.summer.dsl.model.types.JvmInterfaceType;
import org.summer.dsl.model.types.JvmMember;
import org.summer.dsl.model.types.JvmModule;
import org.summer.dsl.model.types.JvmOperation;
import org.summer.dsl.model.types.JvmType;
import org.summer.dsl.model.types.JvmTypeConstraint;
import org.summer.dsl.model.types.JvmTypeParameter;
import org.summer.dsl.model.types.JvmTypeReference;
import org.summer.dsl.model.types.JvmVoid;
import org.summer.dsl.model.types.TypesPackage;
import org.summer.dsl.model.xbase.XAbstractFeatureCall;
import org.summer.dsl.model.xbase.XAbstractWhileStatment;
import org.summer.dsl.model.xbase.XAssignment;
import org.summer.dsl.model.xbase.XBinaryOperation;
import org.summer.dsl.model.xbase.XBlockStatment;
import org.summer.dsl.model.xbase.XCasePart;
import org.summer.dsl.model.xbase.XCastedExpression;
import org.summer.dsl.model.xbase.XCatchClause;
import org.summer.dsl.model.xbase.XClosure;
import org.summer.dsl.model.xbase.XConstructorCall;
import org.summer.dsl.model.xbase.XExpression;
import org.summer.dsl.model.xbase.XFeatureCall;
import org.summer.dsl.model.xbase.XForEachStatment;
import org.summer.dsl.model.xbase.XIfStatment;
import org.summer.dsl.model.xbase.XInstanceOfExpression;
import org.summer.dsl.model.xbase.XMemberFeatureCall;
import org.summer.dsl.model.xbase.XNullLiteral;
import org.summer.dsl.model.xbase.XNumberLiteral;
import org.summer.dsl.model.xbase.XReturnStatment;
import org.summer.dsl.model.xbase.XStatment;
import org.summer.dsl.model.xbase.XSwitchStatment;
import org.summer.dsl.model.xbase.XThrowStatment;
import org.summer.dsl.model.xbase.XTryCatchFinallyStatment;
import org.summer.dsl.model.xbase.XTypeLiteral;
import org.summer.dsl.model.xbase.XVariableDeclaration;
import org.summer.dsl.model.xbase.XVariableDeclarationList;
import org.summer.dsl.model.xbase.XbasePackage;
import org.summer.dsl.model.xbase.XbasePackage.Literals;
import org.summer.dsl.model.xbase.util.XbaseUsageCrossReferencer;
import org.summer.dsl.model.xtype.XImportDeclaration;
import org.summer.dsl.model.xtype.XImportSection;
import org.summer.dsl.model.xtype.XtypePackage;
import org.summer.dsl.xbase.controlflow.IEarlyExitComputer;
import org.summer.dsl.xbase.imports.IImportsConfiguration;
import org.summer.dsl.xbase.jvmmodel.IJvmModelAssociations;
import org.summer.dsl.xbase.jvmmodel.ILogicalContainerProvider;
import org.summer.dsl.xbase.lib.ObjectExtensions;
import org.summer.dsl.xbase.scoping.batch.Buildin;
import org.summer.dsl.xbase.scoping.featurecalls.OperatorMapping;
import org.summer.dsl.xbase.services.XbaseGrammarAccess;
import org.summer.dsl.xbase.typesystem.IBatchTypeResolver;
import org.summer.dsl.xbase.typesystem.IResolvedTypes;
import org.summer.dsl.xbase.typesystem.computation.NumberLiterals;
import org.summer.dsl.xbase.typesystem.computation.SynonymTypesProvider;
import org.summer.dsl.xbase.typesystem.conformance.ConformanceHint;
import org.summer.dsl.xbase.typesystem.conformance.TypeConformanceComputationArgument;
import org.summer.dsl.xbase.typesystem.legacy.StandardTypeReferenceOwner;
import org.summer.dsl.xbase.typesystem.references.ArrayTypeReference;
import org.summer.dsl.xbase.typesystem.references.LightweightTypeReference;
import org.summer.dsl.xbase.typesystem.references.OwnedConverter;
import org.summer.dsl.xbase.typesystem.references.ParameterizedTypeReference;
import org.summer.dsl.xbase.typesystem.references.TypeReferenceVisitorWithNonNullResult;
import org.summer.dsl.xbase.typesystem.references.WildcardTypeReference;
import org.summer.dsl.xbase.typesystem.util.CommonTypeComputationServices;
import org.summer.dsl.xbase.util.XExpressionHelper;

import com.google.common.base.Joiner;
import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.google.inject.Inject;

/**
 * Xbase Validator that does use the scope provider or the type argument context. 
 * It basically disables or replaces all call-outs to the scope and some
 * validations that will be superseded by immediate error annotations during type resolution.
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@ComposedChecks(validators = { EarlyExitValidator.class })
public class XbaseJavaValidator extends AbstractXbaseJavaValidator {
	
	@Inject
	private XbaseGrammarAccess grammarAccess;

	@Inject
	private XExpressionHelper expressionHelper;

	@Inject
	private IEarlyExitComputer earlyExitComputer;

	@Inject
	private ILogicalContainerProvider logicalContainerProvider;
	
	@Inject
	private NumberLiterals numberLiterals;
	
	@Inject
	private IJvmModelAssociations associations;
	
	@Inject
	private CommonTypeComputationServices services;
	
	@Inject
	private IBatchTypeResolver typeResolver;
	
	@Inject
	private IJavaDocTypeReferenceProvider javaDocTypeReferenceProvider;
	
	@Inject 
	private IImportsConfiguration importsConfiguration;
	
	protected CommonTypeComputationServices getServices() {
		return services;
	}
	
	protected LightweightTypeReference getActualType(EObject context, JvmIdentifiableElement element) {
		return typeResolver.resolveTypes(context).getActualType(element);
	}

	protected LightweightTypeReference getActualType(XExpression expression) {
		return typeResolver.resolveTypes(expression).getActualType(expression);
	}
	
	protected LightweightTypeReference getActualType(JvmIdentifiableElement identifiable) {
		return typeResolver.resolveTypes(identifiable).getActualType(identifiable);
	}

	protected LightweightTypeReference getExpectedType(XExpression expression) {
		return typeResolver.resolveTypes(expression).getExpectedType(expression);
	}
	
	protected void checkCast(JvmTypeReference concreteSyntax, LightweightTypeReference toType, LightweightTypeReference fromType) {
		if (toType == null || fromType == null)
			return;
		if (fromType.getType() instanceof JvmDeclaredType || fromType.isPrimitive()) {
			// if one of the types is an interface and the other is a non final class (or interface) there always can be a subtype
			if ((!isInterface(fromType) || isFinal(toType)) && (!isInterface(toType) || isFinal(fromType))) { 
				if (!toType.isAssignableFrom(fromType)) {
					if (   isFinal(fromType) || isFinal(toType)
						|| isClass(fromType) && isClass(toType)) {
						if (!fromType.isAssignableFrom(toType)) { // no upcast
							error("Cannot cast from " + getNameOfTypes(fromType) + " to "
									+ canonicalName(toType), concreteSyntax, null, ValidationMessageAcceptor.INSIGNIFICANT_INDEX,
									INVALID_CAST);
						}
					}
				}
			}
		} else if (fromType.isPrimitiveVoid()) {
			error("Cannot cast from void to "
					+ canonicalName(toType), concreteSyntax, null, ValidationMessageAcceptor.INSIGNIFICANT_INDEX,
					INVALID_CAST);
		}
		if(toType.isPrimitive() && !(fromType.isPrimitive() || fromType.isWrapper())) {
				error("Cannot cast from " + getNameOfTypes(fromType) + " to "
						+ canonicalName(toType), concreteSyntax, null, ValidationMessageAcceptor.INSIGNIFICANT_INDEX,
						INVALID_CAST);
		}
		/*
		 * TODO: JDT reports no unnecessary cast of List<?> but for List<String> ... why is there an exception?
		 * 
		 * 
		 */
//			List<? extends String> list = Collections.emptyList();
//			if (((List<? extends String>)list).isEmpty()) {}
//			List<String> list = Collections.emptyList();
//			if (((List<String>)list).isEmpty()) {}
//			List list = Collections.emptyList();
//			if (((List)list).isEmpty()) {}
		if (toType.getIdentifier().equals(fromType.getIdentifier())) {
			addIssue("Unnecessary cast from " + fromType.getSimpleName() + " to " + toType.getSimpleName(), concreteSyntax, IssueCodes.OBSOLETE_CAST);
		}
	}
	
	private boolean isInterface(LightweightTypeReference typeRef) {
		return isInterface(typeRef.getType());
	}
	
	private boolean isClass(LightweightTypeReference typeRef) {
		return typeRef.getType() instanceof JvmGenericType;
	}
	
	@Check
	protected void checkNumberFormat(XNumberLiteral literal) {
		try {
			numberLiterals.numberValue(literal, numberLiterals.getJavaType(literal));
		} catch (Exception e) {
			error("Invalid number format: " + e.getMessage(), Literals.XNUMBER_LITERAL__VALUE, INVALID_NUMBER_FORMAT);
		}
	}
	
	@Check
	public void checkTypeReferenceIsNotVoid(XExpression expression) {
		for (EObject eObject : expression.eContents()) {
			if (eObject instanceof JvmTypeReference) {
				JvmTypeReference typeRef = (JvmTypeReference) eObject;
				if (isPrimitiveVoid(typeRef)) {
					error("Primitive void cannot be used here.", typeRef, null, INVALID_USE_OF_TYPE);
				}
			}
		}
	}

	protected boolean isPrimitiveVoid(JvmTypeReference typeReference) {
		return typeReference != null && typeReference.getType() != null && !typeReference.getType().eIsProxy() && typeReference.getType() instanceof JvmVoid;
	}

	@Check
	public void checkVariableIsNotInferredAsVoid(XVariableDeclaration declaration) {
		if (declaration.getType() != null)
			return;
		LightweightTypeReference variableType = typeResolver.resolveTypes(declaration).getActualType((JvmIdentifiableElement) declaration);
		// TODO move to type resolver
		if (variableType != null && variableType.isPrimitiveVoid()) {
			error("void is an invalid type for the variable " + declaration.getName(), declaration,
					XbasePackage.Literals.XVARIABLE_DECLARATION__NAME, INVALID_USE_OF_TYPE);
		}
	}
	
	@Check
	public void checkClosureParameterTypes(XClosure closure) {
		if (closure.getFormalParameters().isEmpty())
			return;
		LightweightTypeReference closureType = getActualType((XExpression)closure);  //cym add XExpression cast
		if (closureType != null && closureType.isUnknown())
			return;
		boolean checkedClosure = false;
		for (JvmFormalParameter p : closure.getFormalParameters()) {
			if (p.getParameterType() == null) {
				if (!checkedClosure) {
					LightweightTypeReference type = getExpectedType(closure);
					//cym modified
//					if (type == null) {
//						error("There is no context to infer the closure's argument types from. Consider typing the arguments or put the closures into a typed context.",
//								closure, null, INSIGNIFICANT_INDEX, TOO_LITTLE_TYPE_INFORMATION);
//						return;
//					} else {
//						JvmOperation operation = getServices().getFunctionTypes().findImplementingOperation(type);
//						if (operation == null) {
//							error("There is no context to infer the closure's argument types from. Consider typing the arguments or use the closures in a more specific context.",
//									closure, null, INSIGNIFICANT_INDEX, TOO_LITTLE_TYPE_INFORMATION);
//							return;
//						}
//					}
					checkedClosure = true;
				}
				//cym modified
//				LightweightTypeReference parameterType = getActualType(closure, p);
//				if (parameterType == null) {
//					error("There is no context to infer the closure's argument types from. Consider typing the arguments or use the closures in a more specific context.",
//							closure, null, INSIGNIFICANT_INDEX, TOO_LITTLE_TYPE_INFORMATION);
//					return;
//				}
			}
		}
	}

	@Check
	public void checkTypeArguments(XAbstractFeatureCall expression) {
		for (JvmTypeReference typeRef : expression.getTypeArguments()) {
			ensureNotPrimitiveNorWildcard(typeRef);
		}
	}

	@Check
	public void checkTypeArguments(XConstructorCall expression) {
		for (JvmTypeReference typeRef : expression.getTypeArguments()) {
			ensureNotPrimitiveNorWildcard(typeRef);
		}
	}

	protected void ensureNotPrimitiveNorWildcard(JvmTypeReference typeRef) {
		LightweightTypeReference reference = toLightweightTypeReference(typeRef);
		if (reference.isPrimitive()) {
			error("Primitives cannot be used as type arguments.", typeRef, null, INVALID_USE_OF_TYPE);
		}
		if (reference.isWildcard()) {
			error("Wildcard types are not allowed in this context", typeRef, null, INSIGNIFICANT_INDEX,
					INVALID_USE_OF_WILDCARD);
		}
	}

	protected LightweightTypeReference toLightweightTypeReference(JvmTypeReference typeRef) {
		return toLightweightTypeReference(typeRef, false);
	}
	
	protected LightweightTypeReference toLightweightTypeReference(JvmTypeReference typeRef, boolean keepUnboundWildcardInformation) {
		OwnedConverter converter = new OwnedConverter(new StandardTypeReferenceOwner(getServices(), typeRef), keepUnboundWildcardInformation);
		LightweightTypeReference reference = converter.toLightweightReference(typeRef);
		return reference;
	}
	
	@Check
	public void checkReturn(XReturnStatment expr) {
		IResolvedTypes resolvedTypes = typeResolver.resolveTypes(expr);
		
//		LightweightTypeReference expectedReturnType = resolvedTypes.getExpectedReturnType(expr);
//		if (expectedReturnType == null) {
//			return;
//		}
//		if (expectedReturnType.isPrimitiveVoid()) {
//			if (expr.getExpression() != null)
//				error("Void functions cannot return a value.", expr, null,
//						ValidationMessageAcceptor.INSIGNIFICANT_INDEX, INVALID_RETURN);
//		} else {
//			if (expr.getExpression() == null)
//				error("The function must return a result of type " + expectedReturnType.getSimpleName() + ".", expr, null,
//						ValidationMessageAcceptor.INSIGNIFICANT_INDEX, INVALID_RETURN);
//			else {
//				LightweightTypeReference expressionType = getActualType(expr.getExpression());
//				if (expressionType.isPrimitiveVoid()) {
//					error("Incompatible types. Expected " + getNameOfTypes(expectedReturnType) + " but was "
//							+ canonicalName(expressionType), expr.getExpression(), null,
//							ValidationMessageAcceptor.INSIGNIFICANT_INDEX, INCOMPATIBLE_TYPES);
//				}
//			}
//
//		}
	}

//	protected boolean isImplicitReturn(XExpression expr) {
//		JvmIdentifiableElement logicalContainer = logicalContainerProvider.getLogicalContainer(expr);
//		return (logicalContainer instanceof JvmExecutable || logicalContainer instanceof JvmField || expr.eContainer() instanceof XClosure)
//				&& !earlyExitComputer.isEarlyExit(expr);
//	}

	protected String getNameOfTypes(LightweightTypeReference expectedType) {
		final StringBuilder result = new StringBuilder(canonicalName(expectedType));
		getServices().getSynonymTypesProvider().collectSynonymTypes(expectedType, new SynonymTypesProvider.Acceptor() {
			@Override
			@NonNullByDefault
			protected boolean accept(LightweightTypeReference synonym, EnumSet<ConformanceHint> hints) {
				result.append(" or ").append(canonicalName(synonym));
				return true;
			}
		});
		return result.toString();
	}

	@Check
	public void checkTypes(XCatchClause catchClause) {
		LightweightTypeReference parameterType = getActualType(catchClause, catchClause.getDeclaredParam());
		
		//cym comment
//		if (parameterType != null && !parameterType.isSubtypeOf(Throwable.class)) {
//			error("No exception of type " + parameterType.getSimpleName()
//					+ " can be thrown; an exception type must be a subclass of Throwable",
//					catchClause.getDeclaredParam(), TypesPackage.Literals.JVM_FORMAL_PARAMETER__PARAMETER_TYPE,
//					ValidationMessageAcceptor.INSIGNIFICANT_INDEX, INCOMPATIBLE_TYPES);
//		}
	}

	@Check 
	public void checkTypeParameterNotUsedInStaticContext(JvmTypeReference ref) {
		if(ref.getType() instanceof JvmTypeParameter) {
			JvmTypeParameter typeParameter = (JvmTypeParameter) ref.getType();
			EObject currentParent = logicalContainerProvider.getNearestLogicalContainer(ref);
			while(currentParent != null) {
				if(currentParent == typeParameter.eContainer())
					return;
				else if(isStaticContext(currentParent)) 
					error("Cannot make a static reference to the non-static type " + typeParameter.getName(), 
							ref, TypesPackage.Literals.JVM_PARAMETERIZED_TYPE_REFERENCE__TYPE, -1, STATIC_ACCESS_TO_INSTANCE_MEMBER);
				currentParent = currentParent.eContainer();
			}
		}
	}
		
	protected boolean isStaticContext(EObject element) {
		if(element instanceof JvmConstructor)
			return false;
		if(element instanceof JvmFeature)
			return ((JvmFeature) element).isStatic();
		if(element instanceof JvmModule)
			return true;
		return false;
	}
	
	@Check
	public void checkTypeParameterConstraintIsValid(JvmTypeParameter typeParameter) {
		if(!typeParameter.getConstraints().isEmpty()) {
			for(JvmTypeConstraint constraint: typeParameter.getConstraints()) {
				JvmTypeReference typeReference = constraint.getTypeReference();
				if(typeReference instanceof JvmGenericArrayTypeReference)
					error(String.format("The array type %s cannot be used as a type parameter bound", typeReference.toString()),
							typeReference, null, INVALID_TYPE_PARAMETER_BOUNDS);
			}
		}
	}
	
	/**
	 * Java 5 does not allow forward references in type parameters, so we have to validate this, too
	 */
	public void doCheckTypeParameterForwardReference(List<JvmTypeParameter> sourceTypeParameters) {
		if (sourceTypeParameters.size() > 1) {
			final Set<JvmTypeParameter> forbidden = newHashSet(); 
			for (int i=sourceTypeParameters.size()-2; i>=0; --i) {
				JvmTypeParameter current = sourceTypeParameters.get(i);
				for (EObject jvmElement: associations.getJvmElements(sourceTypeParameters.get(i+1))) 
					if(jvmElement instanceof JvmTypeParameter)
						forbidden.add((JvmTypeParameter) jvmElement);
				for (JvmTypeConstraint constraint: current.getConstraints()) {
					EcoreUtil2.findCrossReferences(constraint.getTypeReference(), forbidden, new ElementReferenceAcceptor() {
						public void accept(EObject referrer, EObject referenced, EReference reference, int index) {
							error("Illegal forward reference to type parameter " + ((JvmTypeParameter)referenced).getSimpleName(), 
									referrer, reference, index, TYPE_PARAMETER_FORWARD_REFERENCE);
						}
					});
				}
			}
		}
	}
	
	@Check
	public void checkAssignment(XAssignment assignment) {
		JvmIdentifiableElement assignmentFeature = assignment.getFeature();
		if (assignmentFeature instanceof XVariableDeclaration
				&& !((XVariableDeclarationList)((XVariableDeclaration) assignmentFeature).eContainer()).isReadonly())  //cym modified
			error("Assignment to final variable", Literals.XASSIGNMENT__ASSIGNABLE,
					ValidationMessageAcceptor.INSIGNIFICANT_INDEX, ASSIGNMENT_TO_FINAL);
		else if (assignmentFeature instanceof JvmFormalParameter)
			error("Assignment to final parameter", Literals.XASSIGNMENT__ASSIGNABLE,
					ValidationMessageAcceptor.INSIGNIFICANT_INDEX, ASSIGNMENT_TO_FINAL);
		else if (assignmentFeature instanceof JvmField && ((JvmField) assignmentFeature).isConst()) {
			JvmField field = (JvmField) assignmentFeature;
			JvmIdentifiableElement container = logicalContainerProvider.getNearestLogicalContainer(assignment);
			
			// don't issue an error if it's an assignment of a local final field within a constructor.
			if (container != null && container instanceof JvmConstructor) {
				JvmConstructor constructor = (JvmConstructor) container;
				if (field.getDeclaringType() == constructor.getDeclaringType())
					return;
			}
			error("Assignment to final field", Literals.XASSIGNMENT__ASSIGNABLE,
					ValidationMessageAcceptor.INSIGNIFICANT_INDEX, ASSIGNMENT_TO_FINAL);
		}
	}

	/**
	 * can be called by subclasses to have proper final field initialization checks.
	 */
	protected void checkFinalFieldInitialization(JvmGenericType type) {
		final Set<JvmField> finalFields = Sets.newLinkedHashSet(Iterables.filter(type.getDeclaredFields(), new Predicate<JvmField>() {
			public boolean apply(JvmField input) {
				return input.isConst();
			}
		}));
		if (finalFields.isEmpty())
			return;
		final Set<JvmField> initializedFields = Sets.newLinkedHashSet(Iterables.filter(finalFields, new Predicate<JvmField>() {
			public boolean apply(JvmField input) {
				return isInitialized(input);
			}

		}));
		for (JvmConstructor constr : type.getDeclaredConstructors()) {
			final Set<JvmField> localInitializedFields = Sets.newLinkedHashSet(initializedFields);
			XExpression expression = logicalContainerProvider.getAssociatedExpression(constr);
			if (expression != null) {
				checkInitializationRec(expression, finalFields, localInitializedFields, Sets.newLinkedHashSet(localInitializedFields), Sets.newHashSet(constr));
			}
			for (JvmField field : finalFields) {
				if (!localInitializedFields.contains(field)) {
					reportUninitializedField(field);
				}
			}
		}
		if (Iterables.isEmpty(type.getDeclaredConstructors())) {
			finalFields.removeAll(initializedFields);
			for (JvmField jvmField : finalFields) {
				reportUninitializedField(jvmField);
			}
		}
	}
	
	protected boolean isInitialized(JvmField input) {
		return logicalContainerProvider.getAssociatedExpression(input) != null;
	}
	
	protected void reportUninitializedField(JvmField field) {
	}

	protected void reportFieldAlreadyInitialized(XAssignment assignment, JvmField field) {
		error("The final field "+field.getSimpleName()+" may already have been assigned", assignment, null, FIELD_ALREADY_INITIALIZED );
	}
	
	
	protected void checkInitializationRec(EObject expr, Set<JvmField> fields, Set<JvmField> initializedForSure, Set<JvmField> initializedMaybe, Set<JvmConstructor> visited) {
		if (expr instanceof XAssignment) {
			XAssignment assignment = (XAssignment) expr;
			if (assignment.getAssignable() != null)
				checkInitializationRec(assignment.getAssignable(), fields, initializedForSure, initializedMaybe, visited);
			if (fields.contains(assignment.getFeature())) {
				JvmField field = (JvmField) assignment.getFeature();
				if (fields.contains(field) && (initializedForSure.contains(field) || initializedMaybe.contains(field))) {
					reportFieldAlreadyInitialized(assignment, field);
				}
				initializedForSure.add(field);
				initializedMaybe.add(field);
			}
		} else if (expr instanceof XForEachStatment) {
			XForEachStatment loopExpression = (XForEachStatment) expr;
			checkInitializationRec(loopExpression.getExpression(), fields, initializedForSure, initializedMaybe, visited);
			checkInitializationRec(loopExpression.getStatment(), fields, initializedMaybe, Sets.newLinkedHashSet(fields), visited);
		} else if (expr instanceof XAbstractWhileStatment) {
			XAbstractWhileStatment loopExpression = (XAbstractWhileStatment) expr;
			checkInitializationRec(loopExpression.getPredicate(), fields, initializedForSure, Sets.newLinkedHashSet(fields), visited);
			checkInitializationRec(loopExpression.getBody(), fields, initializedMaybe, Sets.newLinkedHashSet(fields), visited);
		} else if (expr instanceof XTryCatchFinallyStatment) {
			XTryCatchFinallyStatment tryExpr = (XTryCatchFinallyStatment) expr;
			checkInitializationRec(tryExpr.getStatment(),fields,  initializedForSure, initializedMaybe, visited);
			checkInitializationRec(tryExpr.getFinallyStatment(), fields, initializedForSure, initializedMaybe, visited);
		} else if (expr instanceof XIfStatment) {
			XIfStatment ifExpr = (XIfStatment) expr;
			checkInitializationRec(ifExpr.getIf(), fields, initializedForSure, initializedMaybe, visited);
			
			Set<JvmField> initializedThenForSure = Sets.newLinkedHashSet(initializedForSure);
			Set<JvmField> initializedThenMaybe = Sets.newLinkedHashSet(initializedMaybe);
			checkInitializationRec(ifExpr.getThen(), fields, initializedThenForSure, initializedThenMaybe, visited);
			
			if (ifExpr.getElse() != null) {
				Set<JvmField> initializedElseForSure = Sets.newLinkedHashSet(initializedForSure);
				Set<JvmField> initializedElseMaybe = Sets.newLinkedHashSet(initializedMaybe);
				checkInitializationRec(ifExpr.getElse(), fields, initializedElseForSure, initializedElseMaybe, visited);
				
				initializedThenForSure.retainAll(initializedElseForSure);
				initializedForSure.addAll(initializedThenForSure);
				initializedMaybe.addAll(initializedThenMaybe);
				initializedMaybe.addAll(initializedElseMaybe);
			}
		} else if (expr instanceof XSwitchStatment) {
			XSwitchStatment switchExpr = (XSwitchStatment) expr;
			checkInitializationRec(switchExpr.getSwitch(), fields, initializedForSure, initializedMaybe, visited);
			Set<JvmField> initializedAllCasesForSure = null;
			Set<JvmField> initializedAllCasesMaybe = Sets.newLinkedHashSet(initializedMaybe);
			for (XCasePart casepart : switchExpr.getCases()) {
				if (casepart.getCase() != null) 
					checkInitializationRec(casepart.getCase(), fields, initializedForSure, initializedMaybe, visited);
				Set<JvmField> initializedInCaseForSure = Sets.newLinkedHashSet(initializedForSure);
				Set<JvmField> initializedInCaseMaybe = Sets.newLinkedHashSet(initializedMaybe);
				checkInitializationRec(casepart.getThen(), fields, initializedInCaseForSure, initializedInCaseMaybe, visited);
				if (initializedAllCasesForSure == null)
					initializedAllCasesForSure = initializedInCaseForSure;
				else {
					initializedAllCasesForSure.retainAll(initializedInCaseForSure);
				}
				initializedAllCasesMaybe.addAll(initializedInCaseMaybe);
			}
			if (switchExpr.getDefault() != null) {
				Set<JvmField> initializedInCaseForSure = Sets.newLinkedHashSet(initializedForSure);
				Set<JvmField> initializedInCaseMaybe = Sets.newLinkedHashSet(initializedMaybe);
				checkInitializationRec(switchExpr.getDefault(), fields, initializedInCaseForSure, initializedInCaseMaybe, visited);
				if (initializedAllCasesForSure == null)
					initializedAllCasesForSure = initializedInCaseForSure;
				else {
					initializedAllCasesForSure.retainAll(initializedInCaseForSure);
				}
				initializedAllCasesMaybe.addAll(initializedInCaseMaybe);
				
				initializedForSure.addAll(initializedAllCasesForSure);
			}
			initializedMaybe.addAll(initializedAllCasesMaybe);
		} else if (expr instanceof XFeatureCall) {
			XFeatureCall xFeatureCall = (XFeatureCall) expr;
			if (xFeatureCall.getFeature() instanceof JvmConstructor) {
				JvmConstructor constructor = (JvmConstructor) xFeatureCall.getFeature();
				if (constructor.getDeclaringType() == fields.iterator().next().getDeclaringType()) {
					XExpression expression = logicalContainerProvider.getAssociatedExpression(constructor);
					if (expression != null) {
						HashSet<JvmConstructor> visitedCopy = Sets.newHashSet(visited);
						if (visitedCopy.add(constructor)) {
							checkInitializationRec(expression, fields, initializedForSure, initializedMaybe, visitedCopy);
						} else {
							// recursive compiler invocation is checked elsewhere 
						}
					}
				}
			}
			for (EObject child : expr.eContents()) {
				checkInitializationRec(child, fields, initializedForSure, initializedMaybe, visited);
			}
		} else if (expr instanceof XClosure) {
			// don't go into closures.
			return;
		} else {
			for (EObject child : expr.eContents()) {
				checkInitializationRec(child, fields, initializedForSure, initializedMaybe, visited);
			}
		}
	}


	@Check
	public void checkVariableDeclaration(XVariableDeclaration declaration) {
		if (declaration.getRight() == null) {
			if (!((XVariableDeclarationList)declaration.eContainer()).isReadonly())  // cym modified
				error("Value must be initialized", declaration.eContainer(), Literals.XVARIABLE_DECLARATION_LIST__READONLY,
						ValidationMessageAcceptor.INSIGNIFICANT_INDEX, MISSING_INITIALIZATION);
			if (declaration.getType() == null)
				error("Type cannot be derived", declaration, Literals.XVARIABLE_DECLARATION__NAME,
						ValidationMessageAcceptor.INSIGNIFICANT_INDEX, MISSING_TYPE);
		}
	}
	
	@Check
	public void checkInnerExpressions(XExpression expr) {
		if (!expressionHelper.hasSideEffects(expr) && !isValueExpectedRecursive(expr)) {
			mustBeJavaStatementExpression(expr);
		}
	}
	
	protected boolean isValueExpectedRecursive(XExpression expr) {
		EStructuralFeature feature = expr.eContainingFeature();
		EObject container = expr.eContainer();
		
		// is part of block
		if (container instanceof XBlockStatment) {
			XBlockStatment blockExpression = (XBlockStatment) container;
			final List<XStatment> expressions = blockExpression.getStatments();
			if (expressions.get(expressions.size()-1) != expr) {
				return false;
			}
		}
		// no expectation cases
		if (feature == XbasePackage.Literals.XTRY_CATCH_FINALLY_STATMENT__FINALLY_STATMENT
			|| feature == XbasePackage.Literals.XABSTRACT_WHILE_STATMENT__BODY
			|| feature == XbasePackage.Literals.XFOR_LOOP_STATMENT__STATMENT) {
			return false;
		}
		// is value expected
		if (container instanceof XAbstractFeatureCall 
			|| container instanceof XConstructorCall
			|| container instanceof XAssignment
			|| container instanceof XVariableDeclaration
			|| container instanceof XReturnStatment
			|| container instanceof XThrowStatment
			|| feature == XbasePackage.Literals.XFOR_EACH_STATMENT__EXPRESSION
			|| feature == XbasePackage.Literals.XSWITCH_STATMENT__SWITCH
			|| feature == XbasePackage.Literals.XCASE_PART__CASE
			|| feature == XbasePackage.Literals.XIF_STATMENT__IF
			|| feature == XbasePackage.Literals.XABSTRACT_WHILE_STATMENT__PREDICATE) {
			return true;
		}
		if (container instanceof XClosure || logicalContainerProvider.getLogicalContainer(expr) != null) {
			LightweightTypeReference expectedReturnType = typeResolver.resolveTypes(expr).getExpectedReturnType(expr);
			return expectedReturnType == null || !expectedReturnType.isPrimitiveVoid();
		}
		if (container instanceof XCasePart || container instanceof XCatchClause) {
			container = container.eContainer();
		}
		if (container instanceof XExpression) {
			return isValueExpectedRecursive((XExpression) container);
		}
		return true;
	}

	protected void mustBeJavaStatementExpression(XExpression expr) {
		if (expr != null) {
			error("This expression is not allowed in this context, since it doesn't cause any side effects.", expr, null,
					ValidationMessageAcceptor.INSIGNIFICANT_INDEX, INVALID_INNER_EXPRESSION);
		}
	}

	@Check
	public void checkCasts(XCastedExpression cast) {
		LightweightTypeReference toType = toLightweightTypeReference(cast.getType());
		LightweightTypeReference fromType = getActualType(cast.getTarget());
		checkCast(cast.getType(), toType, fromType);
	}

//	@Check
//	public void checkTypeGuards(XCasePart casePart) {
//		if (casePart.getTypeGuard() == null)
//			return;
//		LightweightTypeReference typeGuard = toLightweightTypeReference(casePart.getTypeGuard());
//		if (typeGuard.isPrimitive()) {
//			error("Primitives are not allowed as type guards", Literals.XCASE_PART__TYPE_GUARD, INVALID_USE_OF_TYPE);
//			return;
//		}
//		LightweightTypeReference targetTypeRef = getActualType(((XSwitchStatment) casePart.eContainer()).getSwitch());
//		checkCast(casePart.getTypeGuard(), typeGuard, targetTypeRef);
//	}

	@Check
	public void checkInstanceOf(XInstanceOfExpression instanceOfExpression) {
		LightweightTypeReference leftType = getActualType(instanceOfExpression.getExpression());
		final LightweightTypeReference rightType = toLightweightTypeReference(instanceOfExpression.getType(), true);
		if (leftType == null || rightType == null || rightType.getType() == null || rightType.getType().eIsProxy()) {
			return;
		}
		if (containsTypeArgs(rightType)) {
			error("Cannot perform instanceof check against parameterized type " + getNameOfTypes(rightType), null, ValidationMessageAcceptor.INSIGNIFICANT_INDEX, INVALID_INSTANCEOF);
			return;
		}
		if (leftType.isAny() || leftType.isUnknown()) {
			return; // null / unknown is ok
		}
		if (rightType.isPrimitive()) {
			error("Cannot perform instanceof check against primitive type " + this.getNameOfTypes(rightType), null, ValidationMessageAcceptor.INSIGNIFICANT_INDEX, INVALID_INSTANCEOF);
			return;
		}
		if (leftType.isPrimitive() 
//			|| rightType.isArray() && !(leftType.isArray() || leftType.isType(Object.class) || leftType.isType(Cloneable.class) || leftType.isType(Serializable.class)) //cym comment
			|| rightType.isArray() && !(leftType.isArray() || leftType.isType(Buildin.Object.JvmType) /*|| leftType.isType(Cloneable.class) || leftType.isType(Serializable.class)*/)
			|| isFinal(rightType) && !memberOfTypeHierarchy(rightType, leftType)
			|| isFinal(leftType) && !memberOfTypeHierarchy(leftType, rightType)) {
			error("Incompatible conditional operand types " + this.getNameOfTypes(leftType)+" and "+this.getNameOfTypes(rightType), null, ValidationMessageAcceptor.INSIGNIFICANT_INDEX, INVALID_INSTANCEOF);
			return;
		}
		if (!isIgnored(OBSOLETE_INSTANCEOF) && rightType.isAssignableFrom(leftType, new TypeConformanceComputationArgument(false, false, true, true, false, false))) {
			addIssueToState(OBSOLETE_INSTANCEOF, "The expression of type " + getNameOfTypes(leftType)
					+ " is already of type " + canonicalName(rightType), null);
		}
	}

	protected boolean memberOfTypeHierarchy(LightweightTypeReference type, LightweightTypeReference potentialMember) {
		return potentialMember.isAssignableFrom(type, new TypeConformanceComputationArgument(false, false, false, true, false, false));
	}

	@NonNullByDefault
	protected boolean containsTypeArgs(LightweightTypeReference instanceOfType) {
		return instanceOfType.accept(new TypeReferenceVisitorWithNonNullResult<Boolean>() {
			@Override
			protected Boolean doVisitTypeReference(LightweightTypeReference reference) {
				return Boolean.FALSE;
			}
			
			@Override
			protected Boolean doVisitParameterizedTypeReference(ParameterizedTypeReference reference) {
				for(LightweightTypeReference argument: reference.getTypeArguments()) {
					if (argument.isWildcard()) {
						if (!((WildcardTypeReference)argument).isUnbounded()) {
							return Boolean.TRUE;
						}
					} else {
						return Boolean.TRUE;
					}
				}
				return Boolean.FALSE;
			}
			@Override
			protected Boolean doVisitArrayTypeReference(ArrayTypeReference reference) {
				return reference.getComponentType().accept(this);
			}
		});
	}

	protected boolean isFinal(LightweightTypeReference expressionTypeRef) {
		if (expressionTypeRef.isArray()) {
			return isFinal(expressionTypeRef.getComponentType());
		}
		if (expressionTypeRef.isPrimitive())
			return true;
		return expressionTypeRef.getType() instanceof JvmDeclaredType
				&& ((JvmDeclaredType) expressionTypeRef.getType()).isFinal();
	}

	@Check
	public void checkDelegateConstructorIsFirst(XFeatureCall featureCall) {
		JvmIdentifiableElement feature = featureCall.getFeature();
		if (feature != null && !feature.eIsProxy() && feature instanceof JvmConstructor) {
			JvmIdentifiableElement container = logicalContainerProvider.getNearestLogicalContainer(featureCall);
			if (container != null) {
				if (container instanceof JvmConstructor) {
					XExpression body = logicalContainerProvider.getAssociatedExpression(container);
					if (body == featureCall)
						return;
					if (body instanceof XBlockStatment) {
						List<XStatment> expressions = ((XBlockStatment) body).getStatments();
						if (expressions.isEmpty() || expressions.get(0) != featureCall) {
							error("Constructor call must be the first expression in a constructor", null, INVALID_CONSTRUCTOR_INVOCATION);
						}
					}
				} else {
					error("Constructor call must be the first expression in a constructor", null, INVALID_CONSTRUCTOR_INVOCATION);
				}
			}
		}
	}
	
	@Check
	public void checkConstructorArgumentsAreValid(XFeatureCall featureCall) {
		JvmIdentifiableElement feature = featureCall.getFeature();
		if (feature != null && !feature.eIsProxy() && feature instanceof JvmConstructor) {
			JvmType containerType = EcoreUtil2.getContainerOfType(logicalContainerProvider.getNearestLogicalContainer(featureCall), JvmType.class);
			for(XExpression argument: featureCall.getFeatureCallArguments()) {
				checkIsValidConstructorArgument(argument, containerType);
			}
		}
	}
	
	protected void checkIsValidConstructorArgument(XExpression argument, JvmType containerType) {
		TreeIterator<EObject> iterator = EcoreUtil2.eAll(argument);
		while(iterator.hasNext()) {
			EObject partOfArgumentExpression = iterator.next();
			if (partOfArgumentExpression instanceof XFeatureCall || partOfArgumentExpression instanceof XMemberFeatureCall) {				
				XAbstractFeatureCall featureCall = (XAbstractFeatureCall) partOfArgumentExpression;
				XExpression actualReceiver = featureCall.getActualReceiver();
				if(actualReceiver instanceof XFeatureCall && ((XFeatureCall)actualReceiver).getFeature() == containerType) {
					JvmIdentifiableElement feature = featureCall.getFeature();
					if (feature != null && !feature.eIsProxy()) {
						if (feature instanceof JvmField) {
							if (!((JvmField) feature).isStatic())
								error("Cannot refer to an instance field " + feature.getSimpleName() + " while explicitly invoking a constructor", 
										partOfArgumentExpression, null, INVALID_CONSTRUCTOR_ARGUMENT);
						} else if (feature instanceof JvmOperation) {
							if (!((JvmOperation) feature).isStatic())
								error("Cannot refer to an instance method while explicitly invoking a constructor", 
										partOfArgumentExpression, null, INVALID_CONSTRUCTOR_ARGUMENT);	
						}
					}
				}
			} else if(partOfArgumentExpression instanceof XClosure) {
				iterator.prune();
			}
		}
	}

	
	@Check
	public void checkNoCircularConstructorCall(XFeatureCall featureCall) {
		JvmIdentifiableElement feature = featureCall.getFeature();
		if (feature != null && !feature.eIsProxy() && feature instanceof JvmConstructor) {
			JvmIdentifiableElement logicalContainer = logicalContainerProvider.getNearestLogicalContainer(featureCall);
			if (logicalContainer instanceof JvmConstructor) {
				JvmConstructor currentConstructor = (JvmConstructor) logicalContainer;
				JvmConstructor calledConstructor = (JvmConstructor) feature;
				Set<JvmConstructor> visited = Sets.newHashSet(currentConstructor);
				while(calledConstructor.getDeclaringType() == currentConstructor.getDeclaringType()) {
					if (!visited.add(calledConstructor)) {
						error("Recursive constructor invocation", XABSTRACT_FEATURE_CALL__FEATURE, CIRCULAR_CONSTRUCTOR_INVOCATION);
						return;
					}
					XExpression constructorBody = logicalContainerProvider.getAssociatedExpression(calledConstructor);
					if (constructorBody instanceof XBlockStatment) {
						List<XStatment> expressions = ((XBlockStatment) constructorBody).getStatments();
						if (expressions.isEmpty())
							return;
						XStatment firstInBody = ((XBlockStatment) constructorBody).getStatments().get(0);
						if (firstInBody instanceof XFeatureCall) {
							JvmIdentifiableElement calledFeature = ((XFeatureCall) firstInBody).getFeature();
							if (calledFeature != null && !calledFeature.eIsProxy() && calledFeature instanceof JvmConstructor) {
								calledConstructor = (JvmConstructor) calledFeature;
								continue;
							} 
						} 
					} 
					return;
				}
			}
		}
	}

	@Check
	public void checkNoForwardReferences(XExpression fieldInitializer) {
		JvmIdentifiableElement container = logicalContainerProvider.getLogicalContainer(fieldInitializer);
		if (container instanceof JvmField) {
			JvmField field = (JvmField) container;
			boolean staticField = field.isStatic();
			JvmDeclaredType declaredType = field.getDeclaringType();
			Collection<JvmField> illegalFields = Sets.newHashSet();
			for(int i = declaredType.getMembers().size() - 1; i>=0; i--) {
				JvmMember member = declaredType.getMembers().get(i);
				if (member instanceof JvmField) {
					if (((JvmField) member).isStatic() == staticField) {
						illegalFields.add((JvmField) member);
					}
				}
				if (member == field)
					break;
			}
			TreeIterator<EObject> iterator = EcoreUtil2.eAll(fieldInitializer);
			while(iterator.hasNext()) {
				EObject object = iterator.next();
				if (object instanceof XFeatureCall) {
					JvmIdentifiableElement feature = ((XFeatureCall) object).getFeature();
					if (illegalFields.contains(((XFeatureCall) object).getFeature())) {
						error("Cannot reference the field '" + feature.getSimpleName() + "' before it is defined", 
								object, null, INSIGNIFICANT_INDEX, ILLEGAL_FORWARD_REFERENCE);
					}
				} else if (object instanceof XClosure) {
					iterator.prune();
				}
			}
		}
	}

	@Check
	public void checkClosureParams(XClosure closure) {
		if (closure.getFormalParameters().size() > 6) {
			error("The maximum number of parameters for a closure is six.", closure,
					Literals.XCLOSURE__DECLARED_FORMAL_PARAMETERS, 6, TOO_MANY_PARAMS_IN_CLOSURE);
		}
	}

	//TODO switch expression not of type boolean
	//TODO apply cast rules case's type guards
	//TODO null guard is not allowed with any other primitives but boolean (null -> false)

	@Check
	void checkNullSafeFeatureCallWithPrimitives(XMemberFeatureCall featureCall) {
		if (featureCall.isNullSafe() && getActualType(featureCall.getMemberCallTarget()).isPrimitive()) {
			error("Cannot use null-safe feature call on primitive receiver", featureCall,
					Literals.XMEMBER_FEATURE_CALL__NULL_SAFE, NULL_SAFE_FEATURE_CALL_ON_PRIMITIVE);
		}
		if (featureCall.isNullSafe() && getActualType(featureCall).isPrimitive()) {
			addIssue("Null-safe feature call of feature with primitive type", featureCall, 
					NULL_SAFE_FEATURE_CALL_OF_PRIMITIVE_VALUED_FEATURE);
		}
	}

	@Check
	public  void checkLocalUsageOfDeclared(XVariableDeclaration variableDeclaration) {
		if(!isIgnored(UNUSED_LOCAL_VARIABLE) && !isLocallyUsed(variableDeclaration, variableDeclaration.eContainer())){
			String message = "The value of the local variable " + variableDeclaration.getName() + " is not used";
			addIssueToState(UNUSED_LOCAL_VARIABLE, message, XbasePackage.Literals.XVARIABLE_DECLARATION__NAME);
		}
	}
	
	@Check
	public void checkTypeLiteral(XTypeLiteral typeLiteral) {
		if (!typeLiteral.getArrayDimensions().isEmpty() && typeLiteral.getType().getIdentifier().equals("void")) {
			error("'void"+Joiner.on("").join(typeLiteral.getArrayDimensions()) +"' is not a valid type", null, INVALID_TYPE);
		}
	}

	@Check
	public void checkImports(XImportSection importSection) {
		if (importSection.getImportDeclarations().isEmpty())
			return;
		
		final Map<JvmType, XImportDeclaration> imports = Maps.newHashMap();
		final Map<JvmType, XImportDeclaration> staticImports = Maps.newHashMap();
		final Map<JvmType, XImportDeclaration> extensionImports = Maps.newHashMap();
		final Map<String, JvmType> importedNames = Maps.newHashMap();
		
		populateMaps(importSection, imports, staticImports, extensionImports, importedNames);
		Set<EObject> primarySourceElements = collectPrimarySourceElements(importSection, imports, importedNames);
		if(!isIgnored(IMPORT_UNUSED)) {
			for(EObject primarySourceElement: primarySourceElements) {
				ICompositeNode node = NodeModelUtils.findActualNodeFor(primarySourceElement);
				if (node != null) {
					for (INode n : node.getAsTreeIterable()) {
						if (n.getGrammarElement() instanceof CrossReference) {
							handleTypeUsageInCrossReference(imports, importedNames, n);
						} else if (n.getGrammarElement() instanceof TerminalRule && ((TerminalRule) n.getGrammarElement()).getName().equals("ML_COMMENT")){
							handleTypeUsageInComment(imports, importedNames, n);
						} else if (n.hasDirectSemanticElement() && n.getSemanticElement() instanceof XAbstractFeatureCall) {
							handleTypeUsageInTypeLiteral(imports, importedNames, (XAbstractFeatureCall) n.getSemanticElement(), n);
							handleTypeUsageInStaticFeatureCall(staticImports, extensionImports, n);
						}
					}
				}
			}
		
			Iterable<XImportDeclaration> obsoleteImports = concat(imports.values(), staticImports.values(), extensionImports.values());
			for (XImportDeclaration imp : obsoleteImports) {
				addIssue("The import '" + imp.getAlias() + "' is never used.", imp, IMPORT_UNUSED);
			}
		}
	}

	protected void handleTypeUsageInStaticFeatureCall(final Map<JvmType, XImportDeclaration> staticImports,
			final Map<JvmType, XImportDeclaration> extensionImports, INode node) {
		XAbstractFeatureCall featureCall = (XAbstractFeatureCall) node.getSemanticElement();
		boolean isExtension = featureCall.isExtension();
		if (featureCall.isStatic() || isExtension) {
			JvmIdentifiableElement element = featureCall.getFeature();
			if (!element.eIsProxy()) {
				JvmFeature feature = (JvmFeature) element;
				JvmDeclaredType declaringType = feature.getDeclaringType();
				if (declaringType != null) {
					JvmIdentifiableElement logicalContainer = logicalContainerProvider.getNearestLogicalContainer(featureCall);
					JvmDeclaredType featureCallOwner = EcoreUtil2.getContainerOfType(logicalContainer, JvmDeclaredType.class);
					if (!contains(featureCallOwner.getAllFeatures(), feature)) {
						if (isExtension) {
							extensionImports.remove(declaringType);
						} else {
							staticImports.remove(declaringType);
						}
					}
				}
			}
		}
	}

	protected void handleTypeUsageInComment(final Map<JvmType, XImportDeclaration> imports, final Map<String, JvmType> importedNames, INode n) {
		List<ReplaceRegion> typeRefRegions = javaDocTypeReferenceProvider.computeTypeRefRegions(n);
		for(ReplaceRegion replaceRegion : typeRefRegions){
			String simpleName = replaceRegion.getText();
			if (importedNames.containsKey(simpleName)) {
				imports.remove(importedNames.remove(simpleName));
			}
		}
	}
	
	protected void handleTypeUsageInTypeLiteral(final Map<JvmType, XImportDeclaration> imports, final Map<String, JvmType> importedNames, XAbstractFeatureCall featureCall, INode node) {
		if (featureCall instanceof XFeatureCall) {
			XFeatureCall casted = (XFeatureCall) featureCall;
			if (casted.isPackageFragment() || !casted.isTypeLiteral())
				return;
			doHandleTypeReference(imports, importedNames, node);
		}
	}

	protected void handleTypeUsageInCrossReference(final Map<JvmType, XImportDeclaration> imports, final Map<String, JvmType> importedNames, INode n) {
		CrossReference crossReference = (CrossReference) n.getGrammarElement();
		EClassifier classifier = crossReference.getType().getClassifier();
		if (classifier instanceof EClass
			 && (TypesPackage.Literals.JVM_TYPE.isSuperTypeOf((EClass) classifier) 
					|| TypesPackage.Literals.JVM_CONSTRUCTOR.isSuperTypeOf((EClass) classifier))) {
			doHandleTypeReference(imports, importedNames, n);
		}
	}

	private void doHandleTypeReference(final Map<JvmType, XImportDeclaration> imports, final Map<String, JvmType> importedNames, INode n) {
		// Filter out HiddenLeafNodes to avoid confusion by comments etc.
		StringBuilder builder = new StringBuilder();
		for(ILeafNode leafNode : n.getLeafNodes()){
			if(!leafNode.isHidden()){
				builder.append(leafNode.getText());
			}
		}
		String simpleName = builder.toString();
		if (importedNames.containsKey(simpleName)) {
			JvmType type = importedNames.remove(simpleName);
			imports.remove(type);
		} else {
			if (markImportUsed(imports, importedNames, simpleName, "$")) {
				return;
			}
			if (markImportUsed(imports, importedNames, simpleName, ".")) {
				return;
			}
			if (markImportUsed(imports, importedNames, simpleName, "::")) {
				return;
			}
		}
	}
	
	protected boolean markImportUsed(Map<JvmType, XImportDeclaration> imports, Map<String, JvmType> importedNames, String simpleName, String delimiter) {
		int idx = simpleName.indexOf(delimiter);
		if (idx < 0)
			return false;
		String firstSegment = simpleName.substring(0, idx);
		if (importedNames.containsKey(firstSegment)) {
			imports.remove(importedNames.remove(firstSegment));
		}
		return true;
	}

	protected Set<EObject> collectPrimarySourceElements(XImportSection importSection, final Map<JvmType, XImportDeclaration> imports,
			final Map<String, JvmType> importedNames) {
		Set<EObject> primarySourceElements = Sets.newHashSet();
		for (JvmDeclaredType declaredType : importsConfiguration.getLocallyDefinedTypes((XtextResource)importSection.eResource())) {
			if(importedNames.containsKey(declaredType.getSimpleName())){
				JvmType importedType = importedNames.get(declaredType.getSimpleName());
				if (importedType != declaredType  && importedType.eResource() != importSection.eResource()) {
					XImportDeclaration importDeclaration = imports.get(importedType);
					if(importDeclaration != null)
						error("The import '" 
								+ importedType.getIdentifier() 
								+ "' conflicts with a type defined in the same file", 
								importDeclaration, null, IssueCodes.IMPORT_CONFLICT );
				}
			}
			EObject primarySourceElement = associations.getPrimarySourceElement(declaredType);
			if(primarySourceElement != null)
				primarySourceElements.add(primarySourceElement);
		}
		return primarySourceElements;
	}

	protected void populateMaps(XImportSection importSection, final Map<JvmType, XImportDeclaration> imports,
			final Map<JvmType, XImportDeclaration> staticImports, final Map<JvmType, XImportDeclaration> extensionImports,
			final Map<String, JvmType> importedNames) {
//		for (XImportDeclaration imp : importSection.getImportDeclarations()) {
//			if (imp.getImportedNamespace() != null) { 
//				addIssue("The use of wildcard imports is deprecated.", imp, IMPORT_WILDCARD_DEPRECATED);
//			} else {
//				JvmType importedType = imp.getImportedType();
//				if (importedType != null && !importedType.eIsProxy()) {
//					Map<JvmType, XImportDeclaration> map = imp.isStatic() 
//							? (imp.isExtension() ? extensionImports : staticImports) 
//						    : imports;
//					if(imp.isStatic()) {
//						if(imp.isExtension()) {
//							XImportDeclaration staticImport = staticImports.get(importedType);
//							if(staticImport != null) {
//								addIssue("Obsolete static import of '" + importedType.getSimpleName() + "'.", staticImport, IssueCodes.IMPORT_DUPLICATE);
//							}
//						} else if(extensionImports.containsKey(importedType)) {
//							addIssue("Obsolete static import of '" + importedType.getSimpleName() + "'.", imp, IssueCodes.IMPORT_DUPLICATE);
//						}
//					}
//					if (map.containsKey(importedType)) {
//						addIssue("Duplicate import of '" + importedType.getSimpleName() + "'.", imp, IssueCodes.IMPORT_DUPLICATE);
//					} else {
//						map.put(importedType, imp);
//						if (!imp.isStatic()) {
//							JvmType currentType = importedType;
//							String currentSuffix = currentType.getSimpleName();
//							JvmType collidingImport = importedNames.put(currentSuffix, importedType);
//							if(collidingImport != null)
//								error("The import '" + importedType.getIdentifier() + "' collides with the import '" 
//										+ collidingImport.getIdentifier() + "'.", imp, null, IssueCodes.IMPORT_COLLISION);
//							while (currentType.eContainer() instanceof JvmType) {
//								currentType = (JvmType) currentType.eContainer();
//								currentSuffix = currentType.getSimpleName()+"$"+currentSuffix;
//								JvmType collidingImport2 = importedNames.put(currentSuffix, importedType);
//								if(collidingImport2 != null)
//									error("The import '" + importedType.getIdentifier() + "' collides with the import '" 
//											+ collidingImport2.getIdentifier() + "'.", imp, null, IssueCodes.IMPORT_COLLISION);
//							}
//						}
//					}
//				}
//			}
//		}
	}
	
	@Check
	public void checkPrimitiveComparedToNull(XBinaryOperation binaryOperation) {
		String operatorSymbol = binaryOperation.getConcreteSyntaxFeatureName();
		XExpression left = binaryOperation.getLeftOperand();
		XExpression right = binaryOperation.getRightOperand();
		boolean equalsComparison = expressionHelper.isOperatorFromExtension(binaryOperation, OperatorMapping.EQUALS, ObjectExtensions.class)
				|| expressionHelper.isOperatorFromExtension(binaryOperation, OperatorMapping.NOT_EQUALS, ObjectExtensions.class);
		if(equalsComparison
				|| expressionHelper.isOperatorFromExtension(binaryOperation, OperatorMapping.TRIPLE_NOT_EQUALS, ObjectExtensions.class)
				|| expressionHelper.isOperatorFromExtension(binaryOperation, OperatorMapping.TRIPLE_EQUALS, ObjectExtensions.class)) {
			if(right instanceof XNullLiteral) {
				LightweightTypeReference leftType = typeResolver.resolveTypes(left).getActualType(left);
				if(leftType != null) {
					if (leftType.isPrimitive()) { 
						error("The operator '" + operatorSymbol + "' is undefined for the argument types " + leftType.getSimpleName() + " and null", binaryOperation, null, PRIMITIVE_COMPARED_TO_NULL);
					} else if (equalsComparison) {
						addIssue("The operator '" + operatorSymbol + "' should be replaced by '" + operatorSymbol + "=' when null is one of the arguments.", binaryOperation, EQUALS_WITH_NULL);
					}
				}
			}
			if(left instanceof XNullLiteral) {
				LightweightTypeReference rightType = typeResolver.resolveTypes(right).getActualType(right);
				if(rightType != null) {
					if (rightType.isPrimitive()) { 
						error("The operator '" + operatorSymbol + "' is undefined for the argument types null and " + rightType.getSimpleName(), binaryOperation, null, PRIMITIVE_COMPARED_TO_NULL);
					} else if (equalsComparison && !(right instanceof XNullLiteral)) {
						addIssue("The operator '" + operatorSymbol + "' should be replaced by '" + operatorSymbol + "=' when null is one of the arguments.", binaryOperation, EQUALS_WITH_NULL);
					}
				}
			}
		} else if(expressionHelper.isOperatorFromExtension(binaryOperation, OperatorMapping.ELVIS, ObjectExtensions.class)) {
			LightweightTypeReference leftType = getActualType(left);
			if(leftType.isPrimitive()) 
				error("The operator '" + operatorSymbol + "' is undefined for arguments of type " + leftType.getSimpleName(), binaryOperation, null, PRIMITIVE_COMPARED_TO_NULL);
		}
	}
		
	protected boolean isLocallyUsed(EObject target, EObject containerToFindUsage) {
		return !XbaseUsageCrossReferencer.find(target, containerToFindUsage).isEmpty();
	}

	@Override
	protected List<EPackage> getEPackages() {
		return Lists.newArrayList(XbasePackage.eINSTANCE, XtypePackage.eINSTANCE, TypesPackage.eINSTANCE);
	}

	protected String canonicalName(LightweightTypeReference typeRef) {
		return (typeRef == null) ? "<null>" : typeRef.getSimpleName();
	}

	protected boolean isInterface(JvmType type) {
		return type instanceof JvmInterfaceType;
	}
	
	protected XExpressionHelper getExpressionHelper() {
		return expressionHelper;
	}
	
	@Check
	public void checkNoJavaStyleTypeCasting(XBlockStatment blockExpression) {
		if(isIgnored(JAVA_STYLE_TYPE_CAST)) {
			return;
		}
		if (blockExpression.getStatments().size() <= 1) {
			return;
		}
		ICompositeNode node = NodeModelUtils.getNode(blockExpression);
		if (node == null) {
			return;
		}
		INode expressionNode = null;
		for (INode child : node.getChildren()) {
//			if (isSemicolon(child)) {
//				expressionNode = null;
//			} else 
			if (isXExpressionInsideBlock(child)) {
				if (expressionNode != null) {
					checkNoJavaStyleTypeCasting(expressionNode);
				}
				expressionNode = child;
			}
		}
	}

	protected boolean isXExpressionInsideBlock(INode child) {
		return child.getGrammarElement() == grammarAccess.getXBlockStatmentAccess().getStatmentsXStatmentParserRuleCall_2_0()
				/*|| child.getGrammarElement() == grammarAccess.getXExpressionInClosureAccess().getExpressionsXExpressionInsideBlockParserRuleCall_1_0_0()*/;
	}

//	protected boolean isSemicolon(INode child) {
//		return child.getGrammarElement() == grammarAccess.getXBlockStatmentAccess().getSemicolonKeyword_2_1()
//				/*|| child.getGrammarElement() == grammarAccess.getXExpressionInClosureAccess().getSemicolonKeyword_1_1()*/;
//	}

	protected void checkNoJavaStyleTypeCasting(INode node) {
		BidiTreeIterator<INode> iterator = node.getAsTreeIterable().reverse().iterator();
		ILeafNode child = getFirstLeafNode(iterator);
		if (child != null && child.getGrammarElement() == grammarAccess.getXParenthesizedExpressionAccess().getRightParenthesisKeyword_2()) {
			INode expressionNode = getNode(iterator, grammarAccess.getXParenthesizedExpressionAccess().getXExpressionParserRuleCall_1());
			EObject semanticObject = NodeModelUtils.findActualSemanticObjectFor(expressionNode);
			if (semanticObject instanceof XFeatureCall || semanticObject instanceof XMemberFeatureCall) {
				XAbstractFeatureCall featureCall = (XAbstractFeatureCall) semanticObject;
				if (featureCall.isTypeLiteral()) {
					ICompositeNode parenthesizedNode = child.getParent();
					ITextRegion parenthesizedRegion = parenthesizedNode.getTextRegion();
					addIssue("Use 'as' keyword for type casting.", featureCall, parenthesizedRegion.getOffset(), parenthesizedRegion.getLength(), JAVA_STYLE_TYPE_CAST);
				}
			}
		}
	}

	protected INode getNode(BidiTreeIterator<INode> iterator, EObject... grammarElements) {
		while (iterator.hasNext()) {
			INode node = iterator.next();
			EObject grammarElement = node.getGrammarElement();
			for (EObject expectedGrammarElement : grammarElements) {
				if (grammarElement == expectedGrammarElement) {
					return node;
				}
			}
		}
		return null;
	}

	protected ILeafNode getFirstLeafNode(BidiTreeIterator<INode> iterator) {
		while(iterator.hasNext()) {
			INode child = iterator.next();
			if (isHidden(child)) {
				continue;
			}
			if (child instanceof ILeafNode) {
				return (ILeafNode) child;
			}
		}
		return null;
	}

	protected boolean isHidden(INode child) {
		return child instanceof ILeafNode && ((ILeafNode) child).isHidden();
	}
	
}