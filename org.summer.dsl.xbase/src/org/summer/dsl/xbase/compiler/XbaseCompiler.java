/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.summer.dsl.xbase.compiler;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jdt.annotation.NonNullByDefault;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.generator.trace.ILocationData;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.util.Tuples;
import org.summer.dsl.model.types.JvmAnyTypeReference;
import org.summer.dsl.model.types.JvmConstructor;
import org.summer.dsl.model.types.JvmDeclaredType;
import org.summer.dsl.model.types.JvmField;
import org.summer.dsl.model.types.JvmFormalParameter;
import org.summer.dsl.model.types.JvmGenericType;
import org.summer.dsl.model.types.JvmMember;
import org.summer.dsl.model.types.JvmOperation;
import org.summer.dsl.model.types.JvmSynonymTypeReference;
import org.summer.dsl.model.types.JvmType;
import org.summer.dsl.model.types.JvmTypeParameter;
import org.summer.dsl.model.types.JvmTypeParameterDeclarator;
import org.summer.dsl.model.types.JvmTypeReference;
import org.summer.dsl.model.types.TypesPackage;
import org.summer.dsl.model.xannotation.XAnnotation;
import org.summer.dsl.model.xannotation.XAnnotationElementValuePair;
import org.summer.dsl.model.xannotation.XannotationPackage;
import org.summer.dsl.model.xbase.XAbstractFeatureCall;
import org.summer.dsl.model.xbase.XArrayLiteral;
import org.summer.dsl.model.xbase.XAssignment;
import org.summer.dsl.model.xbase.XBinaryOperation;
import org.summer.dsl.model.xbase.XBlockExpression;
import org.summer.dsl.model.xbase.XBreakExpression;
import org.summer.dsl.model.xbase.XCasePart;
import org.summer.dsl.model.xbase.XCastedExpression;
import org.summer.dsl.model.xbase.XCatchClause;
import org.summer.dsl.model.xbase.XClosure;
import org.summer.dsl.model.xbase.XCollectionLiteral;
import org.summer.dsl.model.xbase.XConstructorCall;
import org.summer.dsl.model.xbase.XContinueExpression;
import org.summer.dsl.model.xbase.XDoWhileExpression;
import org.summer.dsl.model.xbase.XExpression;
import org.summer.dsl.model.xbase.XFeatureCall;
import org.summer.dsl.model.xbase.XForEachExpression;
import org.summer.dsl.model.xbase.XForLoopExpression;
import org.summer.dsl.model.xbase.XIfExpression;
import org.summer.dsl.model.xbase.XIndexOperation;
import org.summer.dsl.model.xbase.XInstanceOfExpression;
import org.summer.dsl.model.xbase.XListLiteral;
import org.summer.dsl.model.xbase.XMemberFeatureCall;
import org.summer.dsl.model.xbase.XNullLiteral;
import org.summer.dsl.model.xbase.XObjectLiteral;
import org.summer.dsl.model.xbase.XPostfixOperation;
import org.summer.dsl.model.xbase.XPrefixOperation;
import org.summer.dsl.model.xbase.XReturnExpression;
import org.summer.dsl.model.xbase.XSetLiteral;
import org.summer.dsl.model.xbase.XSwitchExpression;
import org.summer.dsl.model.xbase.XTernaryOperation;
import org.summer.dsl.model.xbase.XThrowExpression;
import org.summer.dsl.model.xbase.XTryCatchFinallyExpression;
import org.summer.dsl.model.xbase.XVariableDeclaration;
import org.summer.dsl.model.xbase.XVariableDeclarationList;
import org.summer.dsl.model.xbase.XWhileExpression;
import org.summer.dsl.model.xbase.XbasePackage;
import org.summer.dsl.xbase.compiler.output.ITreeAppendable;
import org.summer.dsl.xbase.controlflow.IEarlyExitComputer;
import org.summer.dsl.xbase.lib.ObjectExtensions;
import org.summer.dsl.xbase.lib.Pair;
import org.summer.dsl.xbase.scoping.batch.Buildin;
import org.summer.dsl.xbase.scoping.featurecalls.OperatorMapping;
import org.summer.dsl.xbase.typesystem.IBatchTypeResolver;
import org.summer.dsl.xbase.typesystem.IResolvedTypes;
import org.summer.dsl.xbase.typesystem.references.FunctionTypeReference;
import org.summer.dsl.xbase.typesystem.references.ITypeReferenceOwner;
import org.summer.dsl.xbase.typesystem.references.LightweightMergedBoundTypeArgument;
import org.summer.dsl.xbase.typesystem.references.LightweightTypeReference;
import org.summer.dsl.xbase.typesystem.references.OwnedConverter;
import org.summer.dsl.xbase.typesystem.references.ParameterizedTypeReference;
import org.summer.dsl.xbase.typesystem.references.UnknownTypeReference;
import org.summer.dsl.xbase.typesystem.util.DeclaratorTypeArgumentCollector;
import org.summer.dsl.xbase.typesystem.util.StandardTypeParameterSubstitutor;
import org.summer.dsl.xbase.util.XExpressionHelper;

import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.google.inject.Inject;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
@NonNullByDefault
public class XbaseCompiler extends FeatureCallCompiler {
	
	@Inject 
	private XExpressionHelper expressionHelper;
	
	@Inject 
	private IEarlyExitComputer earlyExitComputer;
	
	@Inject 
	private IBatchTypeResolver batchTypeResolver;
	
	@SuppressWarnings("deprecation")
	@Inject
	private org.summer.dsl.xbase.typing.Closures closures;
	
	/**
	 * @param isReferenced unused in this context but necessary for dispatch signature 
	 */
	protected void _toJavaStatement(XListLiteral literal, ITreeAppendable b, boolean isReferenced) {
		for(XExpression element: literal.getElements()) 
			internalToJavaStatement(element, b, true);
	}

	protected void _toJavaStatement(final XSetLiteral literal, ITreeAppendable b, boolean isReferenced) {
//		LightweightTypeReference literalType = resolveType(literal, Map.class);  // cym comment
		LightweightTypeReference literalType = resolveType(literal, Buildin.Map.JvmType);
		if(literalType != null) {
			if(isReferenced)
				declareSyntheticVariable(literal, b);
//			for(XExpression element: literal.getElements()) {  // cym comment
//				if (expressionHelper.isOperatorFromExtension(element, OperatorMapping.MAPPED_TO, ObjectExtensions.class)) {
//					XBinaryOperation binaryOperation = (XBinaryOperation) element;
//					internalToJavaStatement(binaryOperation.getLeftOperand(), b, true);
//					internalToJavaStatement(binaryOperation.getRightOperand(), b, true);
//				} else if (isType(element, Pair.class)) { 
//					internalToJavaStatement(element, b, true);
//				}
//			}
			LightweightTypeReference keyType = literalType.getTypeArguments().get(0);
			LightweightTypeReference valueType = literalType.getTypeArguments().get(1);
			JvmType mapsClass = getTypeReferences().findDeclaredType(Maps.class, literal);
			
			final String tempMapName = b.declareSyntheticVariable(Tuples.create(literal,  "_tempMap"), "_tempMap");
			b.newLine();
			serialize(literalType.toTypeReference(), literal, b);
			b.append(" ").append(tempMapName).append(" = ");
			b.append(mapsClass).append(".<").append(keyType).append(", ").append(valueType).append(">newHashMap()").append(";").newLine();
			for(XExpression element: literal.getElements())  {
				if (expressionHelper.isOperatorFromExtension(element, OperatorMapping.MAPPED_TO, ObjectExtensions.class)) {
					XBinaryOperation binaryOperation = (XBinaryOperation) element;
					b.append(tempMapName).append(".put(");
					internalToJavaExpression(binaryOperation.getLeftOperand(), b);
					b.append(", ");
					internalToJavaExpression(binaryOperation.getRightOperand(), b);
					b.append(");").newLine();
				}
//				else if (isType(element, Pair.class)) {   //cym comment
//					b.append(tempMapName).append(".put(");
//					internalToJavaExpression(element, b);
//					b.append(" == null ? null : ");
//					internalToJavaExpression(element, b);
//					b.append(".getKey()");
//					b.append(", ");
//					internalToJavaExpression(element, b);
//					b.append(" == null ? null : ");
//					internalToJavaExpression(element, b);
//					b.append(".getValue()");
//					b.append(");").newLine();
//				}
			}
			if(isReferenced) 
				b.append(getVarName(literal, b)).append(" = ");
			JvmType collectionsClass = getTypeReferences().findDeclaredType(Collections.class, literal);
			b.append(collectionsClass)
				.append(".<").append(keyType).append(", ").append(valueType)
				.append(">unmodifiableMap(").append(tempMapName).append(");");
		} else {
			for(XExpression element: literal.getElements()) 
				internalToJavaStatement(element, b, true);
		}
	}

	
	//cym comment
//	protected boolean isType(XExpression element, Class<?> clazz) {
//		return resolveType(element, clazz) != null;
//	}
	
	protected boolean isType(XExpression element, JvmType type) {
		return resolveType(element, type) != null;
	}

	//cym comment
//	@Nullable
//	protected LightweightTypeReference resolveType(XExpression element, Class<?> clazz) {
//		LightweightTypeReference elementType = batchTypeResolver.resolveTypes(element).getActualType(element);
//		return elementType != null && elementType.isType(clazz) ? elementType : null;
//	}
	
	@Nullable
	protected LightweightTypeReference resolveType(XExpression element, JvmType type) {
		LightweightTypeReference elementType = batchTypeResolver.resolveTypes(element).getActualType(element);
		return elementType != null && elementType.isType(type) ? elementType : null;
	}
	
	protected LightweightTypeReference getCollectionElementType(XCollectionLiteral literal) {
		LightweightTypeReference type = batchTypeResolver.resolveTypes(literal).getActualType(literal);
		if (type == null)
			throw new IllegalStateException();
		if(type.isArray()) {
			LightweightTypeReference result = type.getComponentType();
			if (result == null)
				throw new IllegalStateException();
			return result;
		}
//		else if(type.isSubtypeOf(Collection.class) && !type.getTypeArguments().isEmpty())  //cym comment
		else if(type.isSubtypeOf(Buildin.Collection.JvmType) && !type.getTypeArguments().isEmpty()) 
			return type.getTypeArguments().get(0).getInvariantBoundSubstitute();
//		return new ParameterizedTypeReference(type.getOwner(), getTypeReferences().findDeclaredType(Object.class, literal));  // cym comment
		return new ParameterizedTypeReference(type.getOwner(), Buildin.Object.JvmType);
		
	}

//	protected void _toJavaExpression(XListLiteral literal, ITreeAppendable b) {
//		LightweightTypeReference literalType = batchTypeResolver.resolveTypes(literal).getActualType(literal);
//		if (literalType != null && literalType.isArray()) {
//			LightweightTypeReference expectedType = batchTypeResolver.resolveTypes(literal).getExpectedType(literal);
//			boolean skipTypeName = false;
//			if (expectedType != null && expectedType.isArray()) {
//				if (canUseArrayInitializer(literal, b)) {
//					skipTypeName = true;
//				}
//			}
//			if (!skipTypeName) {
//				b.append("new ")
//					.append(literalType)
//					.append(" ");
//			}
//			if (literal.getElements().isEmpty()) {
//				b.append("{}");
//			} else {
//				b.append("{ ");
//				boolean isFirst = true;
//				for(XExpression element: literal.getElements())  {
//					if(!isFirst)
//						b.append(", ");
//					isFirst = false;
//					internalToJavaExpression(element, b);
//				}
//				b.append(" }");
//			}
//			return;
//		} else {
//			appendImmutableCollectionExpression(literal, b, "unmodifiableList", Lists.class, "newArrayList");
//		}
//	}
	
	protected void _toJavaExpression(XListLiteral literal, ITreeAppendable b) {
		LightweightTypeReference literalType = batchTypeResolver.resolveTypes(literal).getActualType(literal);
		if (literalType != null && literalType.isArray()) {
			LightweightTypeReference expectedType = batchTypeResolver.resolveTypes(literal).getExpectedType(literal);
			boolean skipTypeName = false;
			if (expectedType != null && expectedType.isArray()) {
				if (canUseArrayInitializer(literal, b)) {
					skipTypeName = true;
				}
			}
//			if (!skipTypeName) {
//				b.append("new ")
//					.append(literalType)
//					.append(" ");
//			}
			if (literal.getElements().isEmpty()) {
				b.append("[]");
			} else {
				b.append("[ ");
				boolean isFirst = true;
				for(XExpression element: literal.getElements())  {
					if(!isFirst)
						b.append(", ");
					isFirst = false;
					internalToJavaExpression(element, b);
				}
				b.append(" ]");
			}
			return;
		} else {
			appendImmutableCollectionExpression(literal, b, "unmodifiableList", Lists.class, "newArrayList");
		}
	}

	protected void _toJavaExpression(XSetLiteral literal, ITreeAppendable b) {
		LightweightTypeReference literalType = batchTypeResolver.resolveTypes(literal).getActualType(literal);
//		if(literalType != null && !literalType.isType(Map.class))  //cym comment
		if(literalType != null && !literalType.isType(Buildin.Map.JvmType)) 
			appendImmutableCollectionExpression(literal, b, "unmodifiableSet", Sets.class, "newHashSet");
		else
			b.trace(literal, false).append(getVarName(literal, b));
	}
	
	protected void appendImmutableCollectionExpression(XCollectionLiteral literal,
			ITreeAppendable b, String collectionsMethod, Class<?> guavaHelper, String guavaHelperMethod) {
		LightweightTypeReference collectionElementType = getCollectionElementType(literal);
		ITypeReferenceOwner owner = collectionElementType.getOwner();
		JvmType collectionsClass = getTypeReferences().findDeclaredType(Collections.class, literal);
		JvmType guavaHelperType = getTypeReferences().findDeclaredType(guavaHelper, literal);
		LightweightTypeReference guavaClass = guavaHelperType == null ? new UnknownTypeReference(owner, guavaHelper.getName()) :new ParameterizedTypeReference(owner, guavaHelperType);
		b.append(collectionsClass)
			.append(".<").append(collectionElementType).append(">").append(collectionsMethod).append("(")
			.append(guavaClass).append(".<").append(collectionElementType).append(">").append(guavaHelperMethod).append("(");
		boolean isFirst = true;
		for(XExpression element: literal.getElements())  {
			if(!isFirst)
				b.append(", ");
			isFirst = false;
			if(element instanceof XNullLiteral) {
				b.append("(").append(collectionElementType).append(")");
			}
			internalToJavaExpression(element, b);
		}
		b.append("))");
		return;
	}
	
	protected boolean canUseArrayInitializer(XListLiteral literal, ITreeAppendable appendable) {
		if (literal.eContainingFeature() == XbasePackage.Literals.XVARIABLE_DECLARATION__RIGHT
			|| literal.eContainingFeature() == XannotationPackage.Literals.XANNOTATION_ELEMENT_VALUE_PAIR__VALUE
			|| literal.eContainingFeature() == XannotationPackage.Literals.XANNOTATION__VALUE
			) {
			return canUseArrayInitializerImpl(literal, appendable);
		}
		return false;
	}
	
	protected boolean canUseArrayInitializerImpl(XListLiteral literal, ITreeAppendable appendable) {
		for(XExpression element: literal.getElements()) {
			if (isVariableDeclarationRequired(element, appendable))
				return false;
		}
		return true;
	}

	@Override
	protected List<XExpression> getActualArguments(XAbstractFeatureCall featureCall) {
		EList<XExpression> actualArguments = featureCall.getActualArguments();
		List<XExpression> normalizedArguments = normalizeBlockExpression(actualArguments);
		return normalizedArguments;
	}
	
	@Nullable
	@Override
	protected XExpression getActualReceiver(XAbstractFeatureCall featureCall) {
		return featureCall.getActualReceiver();
	}
	@Override
	protected boolean isMemberCall(XAbstractFeatureCall call) {
		return !call.isStatic();
	}
	
	@Override
	protected ITreeAppendable appendTypeArguments(XAbstractFeatureCall call, ITreeAppendable original) {
		if (!call.getTypeArguments().isEmpty()) {
			return super.appendTypeArguments(call, original);
		}
		ILocationData completeLocationData = getLocationWithTypeArguments(call);
		ITreeAppendable completeFeatureCallAppendable = completeLocationData != null ? original.trace(completeLocationData) : original;
		IResolvedTypes resolvedTypes = batchTypeResolver.resolveTypes(call);
		List<LightweightTypeReference> typeArguments = resolvedTypes.getActualTypeArguments(call);
		if (!typeArguments.isEmpty()) {
			List<JvmTypeReference> resolvedTypeArguments = Lists.newArrayListWithCapacity(typeArguments.size());
			for(LightweightTypeReference typeArgument: typeArguments) {
				if (typeArgument.isWildcard()) {
					return completeFeatureCallAppendable;
				}
				JvmTypeReference jvmTypeReference = typeArgument.toJavaCompliantTypeReference();
				resolvedTypeArguments.add(jvmTypeReference);
			}
			completeFeatureCallAppendable.append("<");
			for (int i = 0; i < resolvedTypeArguments.size(); i++) {
				if (i != 0) {
					completeFeatureCallAppendable.append(", ");
				}
				JvmTypeReference typeArgument = resolvedTypeArguments.get(i);
				serialize(typeArgument, call, completeFeatureCallAppendable);
			}
			completeFeatureCallAppendable.append(">");
		}
		return completeFeatureCallAppendable;
	}
	
	@SuppressWarnings("deprecation")
	@Override
	protected void convertFunctionType(JvmTypeReference expectedType, final JvmTypeReference functionType,
			ITreeAppendable appendable, Later expression, XExpression context) {
		if (expectedType.getIdentifier().equals(Object.class.getName())
				|| EcoreUtil.equals(expectedType.getType(), functionType.getType())
				|| ((expectedType instanceof JvmSynonymTypeReference) 
					&& Iterables.any(((JvmSynonymTypeReference)expectedType).getReferences(), new Predicate<JvmTypeReference>() {
						public boolean apply(@Nullable JvmTypeReference ref) {
							if (ref == null) {
								throw new IllegalStateException();
							}
							return EcoreUtil.equals(ref.getType(), functionType.getType());
						}
					}))) {
			// same raw type but different type parameters
			// at this point we know that we are compatible so we have to convince the Java compiler about that ;-)
			if (!getTypeConformanceComputer().isConformant(expectedType, functionType)) {
				// insert a cast
				appendable.append("(");
				serialize(expectedType, context, appendable);
				appendable.append(")");
			}
			expression.exec(appendable);
			return;
		}
		JvmOperation operation = getClosures().findImplementingOperation(expectedType, context.eResource());
		if (operation == null) {
			throw new IllegalStateException("expected type " + expectedType + " not mappable from " + functionType);
		}
		appendable.append("new ");
		LightweightTypeReference lightweightExpectedType = new OwnedConverter(newTypeReferenceOwner(context))
			.toLightweightReference(expectedType);
		FunctionTypeReference functionTypeReference = lightweightExpectedType.tryConvertToFunctionTypeReference(false);
		if (functionTypeReference == null)
			throw new IllegalStateException("Expected type does not seem to be a SAM type");
		JvmTypeReference convertedExpectedType = functionTypeReference.toInstanceTypeReference().toTypeReference();
		serialize(convertedExpectedType, context, appendable, false, false);
		appendable.append("() {");
		appendable.increaseIndentation().increaseIndentation();
		appendable.newLine().append("public ");
		LightweightTypeReference returnType = functionTypeReference.getReturnType();
		if (returnType == null)
			throw new IllegalStateException("Could not find return type");
		serialize(returnType.toTypeReference(), context, appendable, false, false);
		appendable.append(" ").append(operation.getSimpleName()).append("(");
		List<JvmFormalParameter> params = operation.getParameters();
		for (int i = 0; i < params.size(); i++) {
			if (i != 0)
				appendable.append(",");
			JvmFormalParameter p = params.get(i);
			final String name = p.getName();
			serialize(functionTypeReference.getParameterTypes().get(i).toTypeReference(), context, appendable, false, false);
			appendable.append(" ").append(name);
		}
		appendable.append(") {");
		appendable.increaseIndentation();
		try {
			appendable.openScope();
			reassignThisInClosure(appendable, operation.getDeclaringType());
			if (!getTypeReferences().is(operation.getReturnType(), Void.TYPE))
				appendable.newLine().append("return ");
			else
				appendable.newLine();
			expression.exec(appendable);
			appendable.append(".");
			JvmOperation actualOperation = getClosures().findImplementingOperation(functionType, context.eResource());
			appendable.append(actualOperation.getSimpleName());
			appendable.append("(");
			for (Iterator<JvmFormalParameter> iterator = params.iterator(); iterator.hasNext();) {
				JvmFormalParameter p = iterator.next();
				final String name = p.getName();
				appendable.append(name);
				if (iterator.hasNext())
					appendable.append(",");
			}
			appendable.append(");");
		} finally {
			appendable.closeScope();
		}
		appendable.decreaseIndentation();
		appendable.newLine().append("}");
		appendable.decreaseIndentation().decreaseIndentation();
		appendable.newLine().append("}");
	}
	
	@Override
	protected void internalToConvertedExpression(XExpression obj, ITreeAppendable appendable) {
		if (obj instanceof XBlockExpression) {
			_toJavaExpression((XBlockExpression) obj, appendable);
		} else if (obj instanceof XAssignment) {
			_toJavaExpression((XAssignment) obj, appendable);
		} else if (obj instanceof XCastedExpression) {
			_toJavaExpression((XCastedExpression) obj, appendable);
		} else if (obj instanceof XClosure) {
			_toJavaExpression((XClosure) obj, appendable);
		} else if (obj instanceof XAnnotation) {
			_toJavaExpression((XAnnotation) obj, appendable);
		} else if (obj instanceof XConstructorCall) {
			_toJavaExpression((XConstructorCall) obj, appendable);
		} else if (obj instanceof XIfExpression) {
			_toJavaExpression((XIfExpression) obj, appendable);
		} else if (obj instanceof XInstanceOfExpression) {
			_toJavaExpression((XInstanceOfExpression) obj, appendable);
		} else if (obj instanceof XSwitchExpression) {
			_toJavaExpression((XSwitchExpression) obj, appendable);
		} else if (obj instanceof XTryCatchFinallyExpression) {
			_toJavaExpression((XTryCatchFinallyExpression) obj, appendable);
		} else if (obj instanceof XListLiteral) {
			_toJavaExpression((XListLiteral) obj, appendable);
		} else if (obj instanceof XArrayLiteral) {
			_toJavaExpression((XArrayLiteral) obj, appendable);
		} else if (obj instanceof XObjectLiteral) {
			_toJavaExpression((XObjectLiteral) obj, appendable);
		} else if (obj instanceof XSetLiteral) {
			_toJavaExpression((XSetLiteral) obj, appendable);
		} else if (obj instanceof XBreakExpression) {
			_toJavaExpression((XBreakExpression) obj, appendable);
		} else if (obj instanceof XContinueExpression) {
			_toJavaExpression((XContinueExpression) obj, appendable);
		} else if (obj instanceof XPostfixOperation) {
			_toJavaExpression((XPostfixOperation) obj, appendable);
		} else if (obj instanceof XPostfixOperation) {
			_toJavaExpression((XPostfixOperation) obj, appendable);
		} else if (obj instanceof XIndexOperation) {
			_toJavaExpression((XIndexOperation) obj, appendable);
		} else if (obj instanceof XTernaryOperation) {
			_toJavaExpression((XTernaryOperation) obj, appendable);
		} else if (obj instanceof XVariableDeclarationList) {
			_toJavaExpression((XVariableDeclarationList) obj, appendable);
		} else {
			super.internalToConvertedExpression(obj, appendable);
		}
	}
	
	@Override
	protected void doInternalToJavaStatement(XExpression obj, ITreeAppendable appendable, boolean isReferenced) {
		if (obj instanceof XBlockExpression) {
			_toJavaStatement((XBlockExpression) obj, appendable, isReferenced);
		} else if (obj instanceof XCastedExpression) {
			_toJavaStatement((XCastedExpression) obj, appendable, isReferenced);
		} else if (obj instanceof XClosure) {
			_toJavaStatement((XClosure) obj, appendable, isReferenced);
		} else if (obj instanceof XConstructorCall) {
			_toJavaStatement((XConstructorCall) obj, appendable, isReferenced);
		} else if (obj instanceof XDoWhileExpression) {
			_toJavaStatement((XDoWhileExpression) obj, appendable, isReferenced);
		} else if (obj instanceof XForLoopExpression) {
			_toJavaStatement((XForLoopExpression) obj, appendable, isReferenced);
		} else if (obj instanceof XForLoopExpression) {
			_toJavaStatement((XForEachExpression) obj, appendable, isReferenced);
		} else if (obj instanceof XIfExpression) {
			_toJavaStatement((XIfExpression) obj, appendable, isReferenced);
		} else if (obj instanceof XInstanceOfExpression) {
			_toJavaStatement((XInstanceOfExpression) obj, appendable, isReferenced);
		} else if (obj instanceof XReturnExpression) {
			_toJavaStatement((XReturnExpression) obj, appendable, isReferenced);
		} else if (obj instanceof XSwitchExpression) {
			_toJavaStatement((XSwitchExpression) obj, appendable, isReferenced);
		} else if (obj instanceof XThrowExpression) {
			_toJavaStatement((XThrowExpression) obj, appendable, isReferenced);
		} else if (obj instanceof XTryCatchFinallyExpression) {
			_toJavaStatement((XTryCatchFinallyExpression) obj, appendable, isReferenced);
		} else if (obj instanceof XVariableDeclaration) {
			_toJavaStatement((XVariableDeclaration) obj, appendable, isReferenced);
		} else if (obj instanceof XVariableDeclarationList) {
			_toJavaStatement((XVariableDeclarationList) obj, appendable, isReferenced);
		} else if (obj instanceof XWhileExpression) {
			_toJavaStatement((XWhileExpression) obj, appendable, isReferenced);
		} else if (obj instanceof XListLiteral) {
			_toJavaStatement((XListLiteral) obj, appendable, isReferenced);
		} else if (obj instanceof XSetLiteral) {
			_toJavaStatement((XSetLiteral) obj, appendable, isReferenced);
		} else if (obj instanceof XBreakExpression) {
			_toJavaStatement((XBreakExpression) obj, appendable, isReferenced);
		} else if (obj instanceof XContinueExpression) {
			_toJavaStatement((XContinueExpression) obj, appendable, isReferenced);
		} else if (obj instanceof XPostfixOperation) {
			_toJavaStatement((XPostfixOperation) obj, appendable, isReferenced);
		} else if (obj instanceof XPrefixOperation) {
			_toJavaStatement((XPrefixOperation) obj, appendable, isReferenced);
		} else if (obj instanceof XIndexOperation) {
			_toJavaStatement((XIndexOperation) obj, appendable, isReferenced);
		} else if (obj instanceof XTernaryOperation) {
			_toJavaStatement((XTernaryOperation) obj, appendable, isReferenced);
		} else {
			super.doInternalToJavaStatement(obj, appendable, isReferenced);
		}
	}
	
	protected void _toJavaStatement(XBreakExpression expr, ITreeAppendable outerAppendable, boolean isReferenced) {
		outerAppendable.append("break");
	}
	
	protected void _toJavaStatement(XContinueExpression expr, ITreeAppendable outerAppendable, boolean isReferenced) {
		outerAppendable.append("continue");
	}
	
	protected void _toJavaStatement(XPostfixOperation expr, ITreeAppendable outerAppendable, boolean isReferenced) {
		internalToConvertedExpression(expr, outerAppendable, null);
		outerAppendable.append(";");
		
	}
	
	protected void _toJavaStatement(XPrefixOperation expr, ITreeAppendable outerAppendable, boolean isReferenced) {
		internalToConvertedExpression(expr, outerAppendable, null);
		outerAppendable.append(";");
		
	}
	
	protected void _toJavaStatement(XIndexOperation expr, ITreeAppendable outerAppendable, boolean isReferenced) {
		internalToConvertedExpression(expr, outerAppendable, null);
		outerAppendable.append(";");
		
	}
	
	protected void _toJavaStatement(XTernaryOperation expr, ITreeAppendable outerAppendable, boolean isReferenced) {
		internalToConvertedExpression(expr.getCondition(), outerAppendable, null);
		outerAppendable.append(" ? ");
		internalToConvertedExpression(expr.getTrueOperand(), outerAppendable, null);
		outerAppendable.append(" : ");
		internalToConvertedExpression(expr.getFalseOperand(), outerAppendable, null);
		outerAppendable.append(";");
		
	}
	
	protected void _toJavaStatement(XBlockExpression expr, ITreeAppendable b, boolean isReferenced) {
		b = b.trace(expr, false);
		if (expr.getExpressions().isEmpty())
			return;
		if (expr.getExpressions().size()==1) {
			internalToJavaStatement(expr.getExpressions().get(0), b, isReferenced);
			return;
		}
		if (isReferenced)
			declareSyntheticVariable(expr, b);
		boolean needsBraces = isReferenced || !bracesAreAddedByOuterStructure(expr);
		if (needsBraces) {
			b.newLine().append("{").increaseIndentation();
			b.openPseudoScope();
		}
		final EList<XExpression> expressions = expr.getExpressions();
		for (int i = 0; i < expressions.size(); i++) {
			XExpression ex = expressions.get(i);
			if (i < expressions.size() - 1) {
				internalToJavaStatement(ex, b, false);
			} else {
				internalToJavaStatement(ex, b, isReferenced);
				if (isReferenced) {
					b.newLine().append(getVarName(expr, b)).append(" = (");
					internalToConvertedExpression(ex, b, getType(expr));
					b.append(");");
				}
			}
		}
		if (needsBraces) {
			b.closeScope();
			b.decreaseIndentation().newLine().append("}");
		}
	}
	
	protected boolean bracesAreAddedByOuterStructure(XBlockExpression block) {
		EObject container = block.eContainer();
		if (container instanceof XTryCatchFinallyExpression 
				|| container instanceof XIfExpression
				|| container instanceof XClosure) {
			return true;
		}
		if (!(container instanceof XExpression)) {
			return true;
		}
		return false;
	}
	
	protected void _toJavaExpression(XAssignment expr, ITreeAppendable b) {
		internalToJavaExpression(expr.getAssignable(), b);
		if(expr.getFeature()!=null){
			b.append(expr.getFeature().getSimpleName());
		}
		b.append(" = ");
		internalToJavaExpression(expr.getValue(), b);
	}

	protected void _toJavaExpression(XBlockExpression expr, ITreeAppendable b) {
		if (expr.getExpressions().isEmpty()) {
			b.append("null");
			return;
		}
		if (expr.getExpressions().size()==1) {
			// conversion was already performed for single expression blocks
			internalToConvertedExpression(expr.getExpressions().get(0), b, null);
			return;
		}
		b = b.trace(expr, false);
		b.append(getVarName(expr, b));
	}

	protected void _toJavaStatement(XTryCatchFinallyExpression expr, ITreeAppendable outerAppendable, boolean isReferenced) {
		ITreeAppendable b = outerAppendable.trace(expr, false);
		if (isReferenced && !isPrimitiveVoid(expr)) {
			declareSyntheticVariable(expr, b);
		}
		b.newLine().append("try {").increaseIndentation();
		final boolean canBeReferenced = isReferenced && !isPrimitiveVoid(expr.getExpression());
		internalToJavaStatement(expr.getExpression(), b, canBeReferenced);
		if (canBeReferenced) {
			b.newLine().append(getVarName(expr, b)).append(" = ");
			internalToConvertedExpression(expr.getExpression(), b, getType(expr));
			b.append(";");
		}
		b.decreaseIndentation().newLine().append("}");
		appendCatchAndFinally(expr, b, isReferenced);
	}

//	protected void appendCatchAndFinally(XTryCatchFinallyExpression expr, ITreeAppendable b, boolean isReferenced) {
//		final EList<XCatchClause> catchClauses = expr.getCatchClauses();
//		if (!catchClauses.isEmpty()) {
//			String variable = b.declareSyntheticVariable(Tuples.pair(expr, "_catchedThrowable"), "_t");
//			b.append(" catch (final Throwable ").append(variable).append(") ");
//			b.append("{").increaseIndentation();
//			b.newLine();
//			Iterator<XCatchClause> iterator = catchClauses.iterator();
//			while (iterator.hasNext()) {
//				XCatchClause catchClause = iterator.next();
//				ITreeAppendable catchClauseAppendable = b.trace(catchClause);
//				appendCatchClause(catchClause, isReferenced, variable, catchClauseAppendable);
//				if (iterator.hasNext()) {
//					b.append(" else ");
//				}
//			}
//			b.append(" else {");
//			b.increaseIndentation();
//			final JvmType sneakyThrowType = getTypeReferences().findDeclaredType(Exceptions.class, expr);
//			if (sneakyThrowType == null) {
//				b.append("COMPILE ERROR : '"+Exceptions.class.getCanonicalName()+"' could not be found on the classpath!");
//			} else {
//				b.newLine().append("throw ");
//				b.append(sneakyThrowType);
//				b.append(".sneakyThrow(");
//				b.append(variable);
//				b.append(");");
//			}
//			b.decreaseIndentation();
//			b.newLine().append("}");
//			b.decreaseIndentation();
//			b.newLine().append("}");
//		}
//		final XExpression finallyExp = expr.getFinallyExpression();
//		if (finallyExp != null) {
//			b.append(" finally {").increaseIndentation();
//			internalToJavaStatement(finallyExp, b, false);
//			b.decreaseIndentation().newLine().append("}");
//		}
//	}
	
	protected void appendCatchAndFinally(XTryCatchFinallyExpression expr, ITreeAppendable b, boolean isReferenced) {
		XCatchClause catchClause = expr.getCatchClause();
		if (catchClause != null) {
			b.append(" catch ( ").append(catchClause.getIdentifier()).append(") ");
			b.append("{").increaseIndentation();
			b.newLine();
			
			doInternalToJavaStatement(catchClause.getExpression(), b, false);
			
			b.decreaseIndentation();
			b.newLine().append("}");
		}
		
		final XExpression finallyExp = expr.getFinallyExpression();
		if (finallyExp != null) {
			b.append(" finally {").increaseIndentation();
			b.newLine();
			internalToJavaStatement(finallyExp, b, false);
			b.decreaseIndentation().newLine().append("}");
		}
	}

//	protected void appendCatchClause(XCatchClause catchClause, boolean parentIsReferenced, String parentVariable,
//			ITreeAppendable appendable) {
//		JvmTypeReference type = catchClause.getDeclaredParam().getParameterType();
//		final String declaredParamName = makeJavaIdentifier(catchClause.getDeclaredParam().getName());
//		final String name = appendable.declareVariable(catchClause.getDeclaredParam(), declaredParamName);
//		appendable.append("if (").append(parentVariable).append(" instanceof ");
//		serialize(type, catchClause, appendable);
//		appendable.append(") ").append("{");
//		appendable.increaseIndentation();
//		ITreeAppendable withDebugging = appendable.trace(catchClause, true);
//		ITreeAppendable parameterAppendable = withDebugging.trace(catchClause.getDeclaredParam());
//		appendCatchClauseParameter(catchClause, type, name, parameterAppendable.newLine());
//		withDebugging.append(" = (");
//		serialize(type, catchClause, withDebugging);
//		withDebugging.append(")").append(parentVariable).append(";");
//		final boolean canBeReferenced = parentIsReferenced && ! isPrimitiveVoid(catchClause.getExpression());
//		internalToJavaStatement(catchClause.getExpression(), withDebugging, canBeReferenced);
//		if (canBeReferenced) {
//			appendable.newLine().append(getVarName(catchClause.eContainer(), appendable)).append(" = ");
//			internalToConvertedExpression(catchClause.getExpression(), appendable, getType((XExpression) catchClause.eContainer()));
//			appendable.append(";");
//		}
//		appendable.decreaseIndentation();
//		appendable.newLine().append("}");
//	}
	
	protected void appendCatchClause(XCatchClause catchClause, boolean parentIsReferenced, String parentVariable,
			ITreeAppendable appendable) {
		internalToJavaStatement(catchClause.getExpression(), appendable, parentIsReferenced);
		appendable.decreaseIndentation();
		appendable.newLine().append("}");
	}

	protected void appendCatchClauseParameter(XCatchClause catchClause, JvmTypeReference parameterType, final String parameterName, ITreeAppendable appendable) {
		appendable.append("final ");
		serialize(parameterType, catchClause, appendable);
		appendable.append(" ");
		appendable.trace(catchClause.getDeclaredParam(), TypesPackage.Literals.JVM_FORMAL_PARAMETER__NAME, 0).append(parameterName);
	}

	protected void _toJavaExpression(XTryCatchFinallyExpression expr, ITreeAppendable b) {
		b.trace(expr, false).append(getVarName(expr, b));
	}

	/**
	 * @param isReferenced unused in this context but necessary for dispatch signature 
	 */
	protected void _toJavaStatement(XThrowExpression expr, ITreeAppendable b, boolean isReferenced) {
		internalToJavaStatement(expr.getExpression(), b, true);
		b.newLine().append("throw ");
		internalToJavaExpression(expr.getExpression(), b);
		b.append(";");
	}

	protected void _toJavaExpression(XInstanceOfExpression expr, ITreeAppendable b) {
//		b.append("(");
		internalToJavaExpression(expr.getExpression(), b);
		b.append(" instanceof ");
		serialize(expr.getType(), expr, b);
//		b.append(")");
	}

	/**
	 * @param isReferenced unused in this context but necessary for dispatch signature 
	 */
	protected void _toJavaStatement(XInstanceOfExpression expr, ITreeAppendable b, boolean isReferenced) {
		internalToJavaStatement(expr.getExpression(), b, true);
	}
	
	
	//cym added
	protected void _toJavaStatement(XVariableDeclarationList varDeclarationList, ITreeAppendable b, boolean isReferenced) {
//		if (varDeclaration.getRight() != null) {
//			internalToJavaStatement(varDeclaration.getRight(), b, true);
//		}
		b.newLine();
//		JvmTypeReference type = 
//				appendVariableTypeAndName(varDeclaration, b);
		b.append("var ");
		boolean commaFlag = false;
		for(XExpression exp : varDeclarationList.getDeclarations()){
			if(commaFlag){
				b.append(",");
			}
			XVariableDeclaration decl = (XVariableDeclaration) exp;
			b.append(makeJavaIdentifier(decl.getName()));
			b.append(" = ");
			if (decl.getRight() != null) {
				internalToConvertedExpression(decl.getRight(), b, null);
			} else {
//				appendDefaultLiteral(b, type);
				b.append("null");
			}
			b.append(";");
		}
		
	}

	/**
	 * @param isReferenced unused in this context but necessary for dispatch signature 
	 */
//	protected void _toJavaStatement(XVariableDeclaration varDeclaration, ITreeAppendable b, boolean isReferenced) {
//		if (varDeclaration.getRight() != null) {
//			internalToJavaStatement(varDeclaration.getRight(), b, true);
//		}
//		b.newLine();
//		JvmTypeReference type = appendVariableTypeAndName(varDeclaration, b);
//		b.append(" = ");
//		if (varDeclaration.getRight() != null) {
//			internalToConvertedExpression(varDeclaration.getRight(), b, type);
//		} else {
//			appendDefaultLiteral(b, type);
//		}
//		b.append(";");
//	}
	
	protected void _toJavaStatement(XVariableDeclaration varDeclaration, ITreeAppendable b, boolean isReferenced) {
//		if (varDeclaration.getRight() != null) {
//			internalToJavaStatement(varDeclaration.getRight(), b, true);
//		}
		b.newLine();
		JvmTypeReference type = 
				appendVariableTypeAndName(varDeclaration, b);
		b.append("var ");
		b.append(makeJavaIdentifier(varDeclaration.getName()));
		b.append(" = ");
		if (varDeclaration.getRight() != null) {
			internalToConvertedExpression(varDeclaration.getRight(), b, null);
		} else {
//			appendDefaultLiteral(b, type);
			b.append("null");
		}
		b.append(";");
	}

//	protected JvmTypeReference appendVariableTypeAndName(XVariableDeclaration varDeclaration, ITreeAppendable appendable) {
//		if (!varDeclaration.isWriteable()) {
//			appendable.append("final ");
//		}
//		JvmTypeReference type = null;
//		if (varDeclaration.getType() != null) {
//			type = varDeclaration.getType();
//		} else {
//			type = getType(varDeclaration.getRight());
//			if (type instanceof JvmAnyTypeReference) {
//				type = getTypeForVariableDeclaration(varDeclaration.getRight());
//			}
//		}
//		serialize(type, varDeclaration, appendable);
//		appendable.append(" ");
//		appendable.append(appendable.declareVariable(varDeclaration, makeJavaIdentifier(varDeclaration.getName())));
//		return type;
//	}
	
	protected JvmTypeReference appendVariableTypeAndName(XVariableDeclaration varDeclaration, ITreeAppendable appendable) {
//		if (!varDeclaration.isWriteable()) {
//			appendable.append("final ");
//		}
		JvmTypeReference type = null;
		if (varDeclaration.getType() != null) {
			type = varDeclaration.getType();
		} else {
			type = getType(varDeclaration.getRight());
			if (type instanceof JvmAnyTypeReference) {
				type = getTypeForVariableDeclaration(varDeclaration.getRight());
			}
		}
//		serialize(type, varDeclaration, appendable);
//		appendable.append(" ");
		appendable.declareVariable(varDeclaration, makeJavaIdentifier(varDeclaration.getName()));
		return type;
	}
	
//	/**
//	 * @param isReferenced unused in this context but necessary for dispatch signature 
//	 */
//	protected void _toJavaStatement(XWhileExpression expr, ITreeAppendable b, boolean isReferenced) {
//		internalToJavaStatement(expr.getPredicate(), b, true);
//		final String varName = b.declareSyntheticVariable(expr, "_while");
//		b.newLine().append("boolean ").append(varName).append(" = ");
//		internalToJavaExpression(expr.getPredicate(), b);
//		b.append(";");
//		b.newLine().append("while (");
//		b.append(varName);
//		b.append(") {").increaseIndentation();
//		b.openPseudoScope();
//		internalToJavaStatement(expr.getBody(), b, false);
//		internalToJavaStatement(expr.getPredicate(), b, true);
//		if (!earlyExitComputer.isEarlyExit(expr.getBody())) {
//			b.newLine();
//			b.append(varName).append(" = ");
//			internalToJavaExpression(expr.getPredicate(), b);
//			b.append(";");
//		}
//		b.closeScope();
//		b.decreaseIndentation().newLine().append("}");
//	}
	
	/**
	 * @param isReferenced unused in this context but necessary for dispatch signature 
	 */
	protected void _toJavaStatement(XWhileExpression expr, ITreeAppendable b, boolean isReferenced) {
		b.append(";");
		b.newLine().append("while (");
		internalToJavaExpression(expr.getPredicate(), b);
		b.append(") {").increaseIndentation();
		b.openPseudoScope();
		internalToJavaStatement(expr.getBody(), b, false);
		b.closeScope();
		b.decreaseIndentation().newLine().append("}");
	}

//	/**
//	 * @param isReferenced unused in this context but necessary for dispatch signature  
//	 */
//	protected void _toJavaStatement(XDoWhileExpression expr, ITreeAppendable b, boolean isReferenced) {
//		String variable = b.declareSyntheticVariable(expr, "_dowhile");
//		b.newLine().append("boolean ").append(variable).append(" = false;");
//		b.newLine().append("do {").increaseIndentation();
//		internalToJavaStatement(expr.getBody(), b, false);
//		internalToJavaStatement(expr.getPredicate(), b, true);
//		b.newLine();
//		if (!earlyExitComputer.isEarlyExit(expr.getBody())) {
//			b.append(variable).append(" = ");
//			internalToJavaExpression(expr.getPredicate(), b);
//			b.append(";");
//		}
//		b.decreaseIndentation().newLine().append("} while(");
//		b.append(variable);
//		b.append(");");
//	}
	
	/**
	 * @param isReferenced unused in this context but necessary for dispatch signature  
	 */
	protected void _toJavaStatement(XDoWhileExpression expr, ITreeAppendable b, boolean isReferenced) {
		b.newLine().append("do {").increaseIndentation();
		internalToJavaStatement(expr.getBody(), b, false);
		b.newLine();
		b.decreaseIndentation().newLine().append("} while(");
		internalToJavaExpression(expr.getPredicate(), b);
		b.append(");");
	}
	
	/**
	 * @param isReferenced unused in this context but necessary for dispatch signature 
	 */
	protected void _toJavaStatement(XForLoopExpression expr, ITreeAppendable b, boolean isReferenced) {
		b.newLine();
		b.append("for (");
		internalToJavaExpression(expr.getInit(), b);
		b.append(";");
		internalToJavaExpression(expr.getCondition(), b);
		b.append(";");
		internalToJavaExpression(expr.getLoop(), b);
		b.append("){").increaseIndentation().newLine();
		internalToJavaStatement(expr.getEachExpression(), b, false);
		b.decreaseIndentation().newLine().append("}");
	}

	/**
	 * @param isReferenced unused in this context but necessary for dispatch signature 
	 */
	protected void _toJavaStatement(XForEachExpression expr, ITreeAppendable b, boolean isReferenced) {
		internalToJavaStatement(expr.getForExpression(), b, true);
		b.newLine();
		ITreeAppendable loopAppendable = b.trace(expr);
		loopAppendable.append("for (");
		ITreeAppendable parameterAppendable = loopAppendable.trace(expr.getDeclaredParam());
		appendForLoopParameter(expr, parameterAppendable);
		loopAppendable.append(" : ");
		internalToJavaExpression(expr.getForExpression(), loopAppendable);
		loopAppendable.append(") {").increaseIndentation();
		internalToJavaStatement(expr.getEachExpression(), loopAppendable, false);
		loopAppendable.decreaseIndentation().newLine().append("}");
	}

	protected void appendForLoopParameter(XForEachExpression expr, ITreeAppendable appendable) {
		appendable.append("final ");
		JvmTypeReference paramType = getForLoopParameterType(expr);
		serialize(paramType, expr, appendable);
		appendable.append(" ");
		final String name = makeJavaIdentifier(expr.getDeclaredParam().getName());
		String varName = appendable.declareVariable(expr.getDeclaredParam(), name);
		appendable.trace(expr.getDeclaredParam(), TypesPackage.Literals.JVM_FORMAL_PARAMETER__NAME, 0).append(varName);
	}

	@SuppressWarnings("deprecation")
	protected JvmTypeReference getForLoopParameterType(XForEachExpression expr) {
		JvmTypeReference declaredType = expr.getDeclaredParam().getParameterType();
		if (declaredType != null) {
			return declaredType;
		}
		return getTypeProvider().getTypeForIdentifiable(expr.getDeclaredParam());
	}

//	protected void _toJavaStatement(final XConstructorCall expr, ITreeAppendable b, final boolean isReferenced) {
//		for (XExpression arg : expr.getArguments()) {
//			internalToJavaStatement(arg, b, true);
//		}
//		
//		Later later = new Later() {
//			public void exec(ITreeAppendable constructorCallAppendable) {
//				ILocationData locationWithNewKeyword = getLocationWithNewKeyword(expr);
//				ITreeAppendable appendableWithNewKeyword = locationWithNewKeyword != null ? constructorCallAppendable.trace(locationWithNewKeyword) : constructorCallAppendable;
//				appendableWithNewKeyword.append("new ");
//				List<LightweightTypeReference> typeArguments = batchTypeResolver.resolveTypes(expr).getActualTypeArguments(expr);
//				JvmConstructor constructor = expr.getConstructor();
//				JvmDeclaredType declaringType = constructor.getDeclaringType();
//				List<JvmTypeParameter> typeParameters = declaringType instanceof JvmTypeParameterDeclarator 
//						? ((JvmTypeParameterDeclarator) declaringType).getTypeParameters() 
//						: Collections.<JvmTypeParameter>emptyList(); 
//				List<JvmTypeParameter> constructorTypeParameters = constructor.getTypeParameters();
//				boolean hasTypeArguments = !typeArguments.isEmpty() && (typeParameters.size() + constructorTypeParameters.size() == typeArguments.size());
//				List<JvmTypeReference> explicitTypeArguments = expr.getTypeArguments();
//				List<LightweightTypeReference> constructorTypeArguments = Collections.emptyList();
//				if (hasTypeArguments) {
//					constructorTypeArguments = typeArguments.subList(0, constructorTypeParameters.size());
//					typeArguments = typeArguments.subList(constructorTypeParameters.size(), typeArguments.size());
//					hasTypeArguments = !typeArguments.isEmpty();
//					for(LightweightTypeReference typeArgument: typeArguments) {
//						if (typeArgument.isWildcard()) {
//							// cannot serialize wildcard as constructor type argument in Java5 as explicit type argument, skip all
//							hasTypeArguments = false;
//							break;
//							// diamond operator would work in later versions
//						}
//					}
//					for(LightweightTypeReference typeArgument: constructorTypeArguments) {
//						if (typeArgument.isWildcard()) {
//							// cannot serialize wildcard as constructor type argument in Java5 as explicit type argument, skip all
//							constructorTypeArguments = Collections.emptyList();
//							break;
//							// diamond operator would work in later versions
//						}
//					}
//				}
//				
//				if (!constructorTypeArguments.isEmpty()) {
//					appendableWithNewKeyword.append("<");
//					for(int i = 0; i < constructorTypeArguments.size(); i++) {
//						if (i != 0) {
//							appendableWithNewKeyword.append(", ");
//						}
//						appendableWithNewKeyword.append(constructorTypeArguments.get(i));
//					}
//					appendableWithNewKeyword.append(">");
//				}
//				ITreeAppendable typeAppendable = appendableWithNewKeyword.trace(expr, XbasePackage.Literals.XCONSTRUCTOR_CALL__CONSTRUCTOR, 0);
//				typeAppendable.append(declaringType);
//				if (hasTypeArguments) {
//					typeAppendable.append("<");
//					for(int i = 0; i < typeArguments.size(); i++) {
//						if (i != 0) {
//							typeAppendable.append(", ");
//						}
//						if (explicitTypeArguments.isEmpty()) {
//							typeAppendable.append(typeArguments.get(i));
//						} else {
//							typeAppendable.trace(explicitTypeArguments.get(i), false).append(typeArguments.get(i));
//						}
//					}
//					typeAppendable.append(">");
//				}
//				constructorCallAppendable.append("(");
//				appendArguments(expr.getArguments(), constructorCallAppendable);
//				constructorCallAppendable.append(")");
//			}
//		};
//		if (isReferenced) {
//			declareFreshLocalVariable(expr, b, later);
//		} else {
//			b.newLine();
//			later.exec(b);
//			b.append(";");
//		}
//	}
	
	protected void _toJavaStatement(final XConstructorCall expr, ITreeAppendable b, final boolean isReferenced) {
		for (XExpression arg : expr.getArguments()) {
			internalToJavaStatement(arg, b, true);
		}
		
		Later later = new Later() {
			public void exec(ITreeAppendable constructorCallAppendable) {
				ILocationData locationWithNewKeyword = getLocationWithNewKeyword(expr);
				ITreeAppendable appendableWithNewKeyword = locationWithNewKeyword != null ? constructorCallAppendable.trace(locationWithNewKeyword) : constructorCallAppendable;
				appendableWithNewKeyword.append("new ");
				List<LightweightTypeReference> typeArguments = batchTypeResolver.resolveTypes(expr).getActualTypeArguments(expr);
				JvmConstructor constructor = expr.getConstructor();
				JvmDeclaredType declaringType = constructor.getDeclaringType();
				List<JvmTypeParameter> typeParameters = declaringType instanceof JvmTypeParameterDeclarator 
						? ((JvmTypeParameterDeclarator) declaringType).getTypeParameters() 
						: Collections.<JvmTypeParameter>emptyList(); 
				List<JvmTypeParameter> constructorTypeParameters = constructor.getTypeParameters();
				boolean hasTypeArguments = !typeArguments.isEmpty() && (typeParameters.size() + constructorTypeParameters.size() == typeArguments.size());
				List<JvmTypeReference> explicitTypeArguments = expr.getTypeArguments();
				List<LightweightTypeReference> constructorTypeArguments = Collections.emptyList();
				if (hasTypeArguments) {
					constructorTypeArguments = typeArguments.subList(0, constructorTypeParameters.size());
					typeArguments = typeArguments.subList(constructorTypeParameters.size(), typeArguments.size());
					hasTypeArguments = !typeArguments.isEmpty();
					for(LightweightTypeReference typeArgument: typeArguments) {
						if (typeArgument.isWildcard()) {
							// cannot serialize wildcard as constructor type argument in Java5 as explicit type argument, skip all
							hasTypeArguments = false;
							break;
							// diamond operator would work in later versions
						}
					}
					for(LightweightTypeReference typeArgument: constructorTypeArguments) {
						if (typeArgument.isWildcard()) {
							// cannot serialize wildcard as constructor type argument in Java5 as explicit type argument, skip all
							constructorTypeArguments = Collections.emptyList();
							break;
							// diamond operator would work in later versions
						}
					}
				}
				
				if (!constructorTypeArguments.isEmpty()) {
					appendableWithNewKeyword.append("<");
					for(int i = 0; i < constructorTypeArguments.size(); i++) {
						if (i != 0) {
							appendableWithNewKeyword.append(", ");
						}
						appendableWithNewKeyword.append(constructorTypeArguments.get(i));
					}
					appendableWithNewKeyword.append(">");
				}
				ITreeAppendable typeAppendable = appendableWithNewKeyword.trace(expr, XbasePackage.Literals.XCONSTRUCTOR_CALL__CONSTRUCTOR, 0);
				typeAppendable.append(declaringType);
				if (hasTypeArguments) {
					typeAppendable.append("<");
					for(int i = 0; i < typeArguments.size(); i++) {
						if (i != 0) {
							typeAppendable.append(", ");
						}
						if (explicitTypeArguments.isEmpty()) {
							typeAppendable.append(typeArguments.get(i));
						} else {
							typeAppendable.trace(explicitTypeArguments.get(i), false).append(typeArguments.get(i));
						}
					}
					typeAppendable.append(">");
				}
				constructorCallAppendable.append("(");
				appendArguments(expr.getArguments(), constructorCallAppendable);
				constructorCallAppendable.append(")");
			}
		};
		if (isReferenced) {
			declareFreshLocalVariable(expr, b, later);
		} else {
			b.newLine();
			later.exec(b);
			b.append(";");
		}
	}
	
	@Nullable
	protected ILocationData getLocationWithNewKeyword(XConstructorCall call) {
		final ICompositeNode startNode = NodeModelUtils.getNode(call);
		if (startNode != null) {
			List<INode> resultNodes = Lists.newArrayList();
			for (INode child : startNode.getChildren()) {
				if (child.getGrammarElement() instanceof Keyword && "(".equals(child.getText()))
					break;
				resultNodes.add(child);
			}
			return toLocationData(resultNodes);
		}
		return null;
	}

	//cym comment
//	protected void _toJavaExpression(XConstructorCall expr, ITreeAppendable b) {
//		String varName = getVarName(expr, b);
//		b.trace(expr, false).append(varName);
//	}
	
	protected void _toJavaExpression(XConstructorCall expr, ITreeAppendable b) {
//		String varName = getVarName(expr, b);
//		b.trace(expr, false).append(varName);
		b.append("new ").append(expr.getConstructor().getDeclaringType().getSimpleName()).append("(");
		List<XExpression> arguments = expr.getArguments();
		if(arguments.size() > 0){
			b.append("[");
		}
		for (int i = 0; i < arguments.size(); i++) {
			XExpression argument = arguments.get(i);
			
			internalToJavaExpression(argument, b);
			if (i + 1 < arguments.size())
				b.append(", ");
		}
		
		if(arguments.size() > 0){
			b.append("]");
		}
		
		b.append(")");

	}
	
	protected void _toJavaExpression(XBreakExpression expr, ITreeAppendable b) {
		b.append("break");
	}
	
	protected void _toJavaExpression(XContinueExpression expr, ITreeAppendable b) {
		b.append("continue");
	}
	
	protected void _toJavaExpression(XPostfixOperation expr, ITreeAppendable b) {
//		String varName = getVarName(expr, b);
//		b.trace(expr, false).append(varName);
		internalToJavaExpression(expr.getOperand(), b);
		b.append("++");
	}
	
	protected void _toJavaExpression(XPrefixOperation expr, ITreeAppendable b) {
//		String varName = getVarName(expr, b);
//		b.trace(expr, false).append(varName);
		b.append("--");
		internalToJavaExpression(expr.getOperand(), b);
	}
	
	protected void _toJavaExpression(XIndexOperation expr, ITreeAppendable b) {
//		String varName = getVarName(expr, b);
//		b.trace(expr, false).append(varName);
		b.append("[");
		internalToJavaExpression(expr.getIndex(), b);
		b.append("]");
	}
	
	protected void _toJavaExpression(XTernaryOperation expr, ITreeAppendable b) {
		internalToConvertedExpression(expr.getCondition(), b, null);
		b.append(" ? ");
		internalToConvertedExpression(expr.getTrueOperand(), b, null);
		b.append(" : ");
		internalToConvertedExpression(expr.getFalseOperand(), b, null);
	}
	
	/**
	 * @param isReferenced unused in this context but necessary for dispatch signature 
	 */
	protected void _toJavaStatement(XReturnExpression expr, ITreeAppendable b, boolean isReferenced) {
		if (expr.getExpression()!=null) {
			internalToJavaStatement(expr.getExpression(), b, true);
			b.append("return ");
			internalToJavaExpression(expr.getExpression(), b);
			b.append(";");
		} else {
			b.append("return;");
		}
	}
	
	protected void _toJavaExpression(XCastedExpression expr, ITreeAppendable b) {
		b.append("((");
		serialize(expr.getType(), expr, b);
		b.append(") ");
		internalToConvertedExpression(expr.getTarget(), b, expr.getType());
		b.append(")");
	}

	protected void _toJavaStatement(XCastedExpression expr, ITreeAppendable b, boolean isReferenced) {
		internalToJavaStatement(expr.getTarget(), b, isReferenced);
	}

	protected void _toJavaStatement(XIfExpression expr, ITreeAppendable b, boolean isReferenced) {
		if (isReferenced)
			declareSyntheticVariable(expr, b);
		internalToJavaStatement(expr.getIf(), b, true);
		b.newLine().append("if (");
		internalToJavaExpression(expr.getIf(), b);
		b.append(") {").increaseIndentation();
		final boolean canBeReferenced = isReferenced && !isPrimitiveVoid(expr.getThen());
		internalToJavaStatement(expr.getThen(), b, canBeReferenced);
		if (canBeReferenced) {
			b.newLine();
			b.append(getVarName(expr, b));
			b.append(" = ");
			internalToConvertedExpression(expr.getThen(), b, getType(expr));
			b.append(";");
		}
		b.decreaseIndentation().newLine().append("}");
		if (expr.getElse() != null) {
			b.append(" else {").increaseIndentation();
			final boolean canElseBeReferenced = isReferenced && !isPrimitiveVoid(expr.getElse());
			internalToJavaStatement(expr.getElse(), b, canElseBeReferenced);
			if (canElseBeReferenced) {
				b.newLine();
				b.append(getVarName(expr, b));
				b.append(" = ");
				internalToConvertedExpression(expr.getElse(), b, getType(expr));
				b.append(";");
			}
			b.decreaseIndentation().newLine().append("}");
		}
	}

	protected void _toJavaExpression(XIfExpression expr, ITreeAppendable b) {
		b.trace(expr, false).append(getVarName(expr, b));
	}

//	protected void _toJavaStatement(XSwitchExpression expr, ITreeAppendable b, boolean isReferenced) {
//		// declare variable
//		JvmTypeReference type = getTypeForVariableDeclaration(expr);
//		String switchResultName = b.declareSyntheticVariable(getSwitchExpressionKey(expr), "_switchResult");
//		if (isReferenced) {
//			b.newLine();
//			serialize(type, expr, b);
//			b.append(" ").append(switchResultName).append(" = ");
//			b.append(getDefaultValueLiteral(expr));
//			b.append(";");
//		}
//		
//		internalToJavaStatement(expr.getSwitch(), b, true);
//		
//		// declare the matched variable outside the pseudo scope
//		String matchedVariable = b.declareSyntheticVariable(Tuples.pair(expr, "matches"), "_matched");
//
//		// declare local var for the switch expression
//		String variableName = null;
//		if(expr.getLocalVarName() == null && expr.getSwitch() instanceof XFeatureCall) {
//			JvmIdentifiableElement feature = ((XFeatureCall) expr.getSwitch()).getFeature();
//			if (b.hasName(feature))
//				variableName = b.getName(feature);
//		} 
//		if(variableName == null) {
//			String name = getNameProvider().getSimpleName(expr);
//			if (name!=null) { 
//				name = makeJavaIdentifier(name);
//			} else {
//				// define synthetic name
//				name = "_switchValue";
//			}
//			JvmTypeReference typeReference = getType(expr.getSwitch());
//			b.newLine().append("final ");
//			serialize(typeReference, expr, b);
//			b.append(" ");
//			variableName = b.declareSyntheticVariable(expr, name);
//			if (expr.getLocalVarName() != null)
//				b.trace(expr, XbasePackage.Literals.XSWITCH_EXPRESSION__LOCAL_VAR_NAME, 0).append(variableName);
//			else
//				b.append(variableName);
//			b.append(" = ");
//			internalToJavaExpression(expr.getSwitch(), b);
//			b.append(";");
//		}
//		// declare 'boolean matched' to check whether a case has matched already
//		b.newLine().append("boolean ");
//		b.append(matchedVariable).append(" = false;");
//		for (XCasePart casePart : expr.getCases()) {
//			ITreeAppendable caseAppendable = b.trace(casePart, true);
//			caseAppendable.newLine().append("if (!").append(matchedVariable).append(") {");
//			caseAppendable.increaseIndentation();
//			if (casePart.getTypeGuard() != null) {
//				ITreeAppendable typeGuardAppendable = caseAppendable.trace(casePart.getTypeGuard(), true);
//				typeGuardAppendable.newLine().append("if (");
//				typeGuardAppendable.append(variableName);
//				typeGuardAppendable.append(" instanceof ");
//				typeGuardAppendable.trace(casePart.getTypeGuard()).append(casePart.getTypeGuard().getType());
//				typeGuardAppendable.append(") {");
//				typeGuardAppendable.increaseIndentation();
//				typeGuardAppendable.openPseudoScope();
//			}
//			if (casePart.getCase() != null) {
//				ITreeAppendable conditionAppendable = caseAppendable.trace(casePart.getCase(), true);
//				internalToJavaStatement(casePart.getCase(), conditionAppendable, true);
//				conditionAppendable.newLine().append("if (");
//				JvmTypeReference convertedType = getType(casePart.getCase());
//				if (getTypeReferences().is(convertedType, Boolean.TYPE) || getTypeReferences().is(convertedType, Boolean.class)) {
//					internalToJavaExpression(casePart.getCase(), conditionAppendable);
//				} else {
//					JvmTypeReference typeRef = getTypeReferences().getTypeForName(Objects.class, expr);
//					serialize(typeRef, casePart, conditionAppendable);
//					conditionAppendable.append(".equal(").append(variableName).append(",");
//					internalToJavaExpression(casePart.getCase(), conditionAppendable);
//					conditionAppendable.append(")");
//				}
//				conditionAppendable.append(")");
//				caseAppendable.append(" {");
//				caseAppendable.increaseIndentation();
//			}
//			// set matched to true
//			caseAppendable.newLine().append(matchedVariable).append("=true;");
//
//			// execute then part
//			final boolean canBeReferenced = isReferenced && !isPrimitiveVoid(casePart.getThen());
//			internalToJavaStatement(casePart.getThen(), caseAppendable, canBeReferenced);
//			if (canBeReferenced) {
//				caseAppendable.newLine().append(switchResultName).append(" = ");
//				internalToConvertedExpression(casePart.getThen(), caseAppendable, getType(expr));
//				caseAppendable.append(";");
//			}
//
//			// close surrounding if statements
//			if (casePart.getCase() != null) {
//				caseAppendable.decreaseIndentation().newLine().append("}");
//			}
//			if (casePart.getTypeGuard() != null) {
//				caseAppendable.decreaseIndentation().newLine().append("}");
//				caseAppendable.closeScope();
//			}
//			caseAppendable.decreaseIndentation();
//			caseAppendable.newLine().append("}");
//		}
//		if (expr.getDefault()!=null) {
//			ILocationData location = getLocationOfDefault(expr);
//			ITreeAppendable defaultAppendable = location != null ? b.trace(location) : b;
//			boolean needsMatcherIf = isReferenced || !allCasesAreExitedEarly(expr);
//			if(needsMatcherIf) {
//				defaultAppendable.newLine().append("if (!").append(matchedVariable).append(") {");
//				defaultAppendable.increaseIndentation();
//			}
//			final boolean canBeReferenced = isReferenced && !isPrimitiveVoid(expr.getDefault());
//			internalToJavaStatement(expr.getDefault(), defaultAppendable, canBeReferenced);
//			if (canBeReferenced) {
//				defaultAppendable.newLine().append(switchResultName).append(" = ");
//				internalToConvertedExpression(expr.getDefault(), defaultAppendable, getType(expr));
//				defaultAppendable.append(";");
//			}
//			if(needsMatcherIf) {
//				defaultAppendable.decreaseIndentation();
//				defaultAppendable.newLine().append("}");
//			}
//		}
//	}
	
	protected void _toJavaStatement(XSwitchExpression expr, ITreeAppendable b, boolean isReferenced) {
		b.newLine();
		
		b.append("switch(");
		
		internalToJavaExpression(expr.getSwitch(), b);
		b.append(")");
		
		b.append(" {");
		for (XCasePart casePart : expr.getCases()) {
			b.increaseIndentation();
			b.newLine().append("case ");
			
			internalToJavaExpression(casePart.getCase(), b);
			b.append(": {");
			b.newLine();
			b.increaseIndentation();
			// set matched to true
			b.newLine();
			internalToJavaStatement(casePart.getThen(), b, isReferenced);
			b.append(";");
			b.decreaseIndentation();
			b.newLine().append("}");
			b.decreaseIndentation();
		}
		if (expr.getDefault()!=null) {
			b.newLine();
			b.increaseIndentation();
			b.append("default: {");
			b.newLine().increaseIndentation();
			internalToJavaStatement(expr.getDefault(), b, isReferenced);
			b.append(";");
			b.decreaseIndentation();
			b.newLine().append("}");
		}
		b.decreaseIndentation();
		b.newLine();
		b.append("}");
	}
	
	protected boolean allCasesAreExitedEarly(XSwitchExpression expr) {
		for(XCasePart casePart: expr.getCases()) {
			if(!earlyExitComputer.isEarlyExit(casePart.getThen())) {
				return false;
			}
		}
		return true;
	}
	
	protected boolean isSimpleFeatureCall(XExpression switch1) {
		if (switch1 instanceof XFeatureCall)  {
			XFeatureCall featureCall = (XFeatureCall) switch1;
			return !(featureCall.getFeature() instanceof JvmOperation);
		}
		return false;
	}

	protected Object getSwitchExpressionKey(XSwitchExpression expr) {
		return new Pair<XSwitchExpression, String>(expr, "key");
	}
	
	@Override
	@Nullable
	protected String getReferenceName(XExpression expr, ITreeAppendable b) {
		if (expr instanceof XSwitchExpression) {
			Object key = getSwitchExpressionKey((XSwitchExpression) expr);
			if (b.hasName(key))
				return b.getName(key);
		}
		return super.getReferenceName(expr, b);
	}

	@Nullable
	protected ILocationData getLocationOfDefault(XSwitchExpression expression) {
		final ICompositeNode startNode = NodeModelUtils.getNode(expression);
		if (startNode != null) {
			List<INode> resultNodes = Lists.newArrayList();
			boolean defaultSeen = false;
			for (INode child : startNode.getChildren()) {
				if (defaultSeen) {
					resultNodes.add(child);
					if (GrammarUtil.containingAssignment(child.getGrammarElement()) != null) {
						break;
					}
				} else if (child.getGrammarElement() instanceof Keyword && "default".equals(child.getText())) {
					defaultSeen = true;
					resultNodes.add(child);
				}
			}
			return toLocationData(resultNodes);
		}
		return null;
	}

	protected void _toJavaExpression(XSwitchExpression expr, ITreeAppendable b) {
		final String referenceName = getReferenceName(expr, b);
		if (referenceName != null)
			b.trace(expr, false).append(referenceName);
		else
			throw new IllegalStateException("Switch expression wasn't translated to Java statements before.");
	}

//	protected void _toJavaStatement(final XClosure closure, final ITreeAppendable b, boolean isReferenced) {
//		if (!isReferenced)
//			throw new IllegalArgumentException("a closure definition does not cause any side-effects");
//		JvmTypeReference type = getType(closure);
//		b.newLine().append("final ");
//		serialize(type, closure, b);
//		b.append(" ");
//		String variableName = b.declareSyntheticVariable(closure, "_function");
//		b.append(variableName).append(" = ");
//		toAnonymousClass(closure, b, type).append(";");
//	}
	
	protected void _toJavaStatement(final XClosure closure, final ITreeAppendable b, boolean isReferenced) {
		if (!isReferenced)
			throw new IllegalArgumentException("a closure definition does not cause any side-effects");
//		JvmTypeReference type = getType(closure);
//		b.newLine().append("final ");
//		serialize(type, closure, b);
//		b.append(" ");
//		String variableName = b.declareSyntheticVariable(closure, "_function");
//		b.append(variableName).append(" = ");
		toAnonymousClass(closure, b, null).append(";");
	}

//	protected ITreeAppendable toAnonymousClass(final XClosure closure, final ITreeAppendable b, JvmTypeReference type) {
//		b.append("new ");
//		// TODO parameters in type arguments are safe to be a wildcard
//		serialize(type, closure, b, false, false, true, false);
//		b.append("() {");
//		b.increaseIndentation();
//		try {
//			b.openScope();
//			JvmOperation operation = findImplementingOperation(type, closure);
//			if (operation != null) {
//				final JvmTypeReference returnType = getClosureOperationReturnType(type, operation);
//				appendOperationVisibility(b, operation);
//				serialize(returnType, closure, b, false, false, true, true);
//				b.append(" ").append(operation.getSimpleName());
//				b.append("(");
//				List<JvmFormalParameter> closureParams = closure.getFormalParameters();
//				for (int i = 0; i < closureParams.size(); i++) {
//					JvmFormalParameter closureParam = closureParams.get(i);
//					JvmTypeReference parameterType = getClosureOperationParameterType(type, operation, i);
//					appendClosureParameter(closureParam, parameterType, closure, b);
//					if (i != closureParams.size() - 1)
//						b.append(", ");
//				}
//				b.append(")");
//				if(!operation.getExceptions().isEmpty()) {
//					b.append(" throws ");
//					for (int i = 0; i < operation.getExceptions().size(); ++i) {
//						serialize(operation.getExceptions().get(i), closure, b, false, false, false, false);
//						if(i != operation.getExceptions().size() -1)
//							b.append(", ");
//					}
//				}
//				b.append(" {");
//				b.increaseIndentation();
//				reassignThisInClosure(b, type.getType());
//				compile(closure.getExpression(), b, operation.getReturnType(), newHashSet(operation.getExceptions()));
//				b.decreaseIndentation();
//				b.newLine().append("}");
//			}
//		} finally {
//			b.closeScope();
//		}
//		return b.decreaseIndentation().newLine().append("}");
//	}
	
	protected ITreeAppendable toAnonymousClass(final XClosure closure, final ITreeAppendable b, JvmTypeReference type) {
//		b.append("new ");
//		// TODO parameters in type arguments are safe to be a wildcard
//		serialize(type, closure, b, false, false, true, false);
//		b.append("() {");
//		b.increaseIndentation();
//		try {
//			b.openScope();
//			JvmOperation operation = findImplementingOperation(type, closure);
//			if (operation != null) {
//				final JvmTypeReference returnType = getClosureOperationReturnType(type, operation);
//				appendOperationVisibility(b, operation);
//				serialize(returnType, closure, b, false, false, true, true);
				b.append(" function ");
				b.append("(");
				List<JvmFormalParameter> closureParams = closure.getFormalParameters();
				for (int i = 0; i < closureParams.size(); i++) {
					JvmFormalParameter closureParam = closureParams.get(i);
//					JvmTypeReference parameterType = getClosureOperationParameterType(type, operation, i);
					appendClosureParameter(closureParam, null, closure, b);
					if (i != closureParams.size() - 1)
						b.append(", ");
				}
				b.append(")");
//				if(!operation.getExceptions().isEmpty()) {
//					b.append(" throws ");
//					for (int i = 0; i < operation.getExceptions().size(); ++i) {
//						serialize(operation.getExceptions().get(i), closure, b, false, false, false, false);
//						if(i != operation.getExceptions().size() -1)
//							b.append(", ");
//					}
//				}
				b.append(" {");
				b.increaseIndentation();
//				reassignThisInClosure(b, type.getType());
//				compile(closure.getExpression(), b, operation.getReturnType(), newHashSet(operation.getExceptions()));
				b.decreaseIndentation();
				b.newLine().append("}");
//			}
//		} finally {
//			b.closeScope();
//		}
//		return b.decreaseIndentation().newLine().append("}");
		return b;
	}

//	protected void appendClosureParameter(JvmFormalParameter closureParam, JvmTypeReference parameterType, final XClosure closure,
//			final ITreeAppendable appendable) {
//		appendable.append("final ");
//		serialize(parameterType, closure, appendable, false, false, true, true);
//		appendable.append(" ");
//		final String proposedParamName = makeJavaIdentifier(closureParam.getName());
//		String name = appendable.declareVariable(closureParam, proposedParamName);
//		appendable.append(name);
//	}
	
	protected void appendClosureParameter(JvmFormalParameter closureParam, JvmTypeReference parameterType, final XClosure closure,
			final ITreeAppendable appendable) {
//		appendable.append("final ");
//		serialize(parameterType, closure, appendable, false, false, true, true);
//		appendable.append(" ");
		final String proposedParamName = makeJavaIdentifier(closureParam.getName());
		String name = appendable.declareVariable(closureParam, proposedParamName);
		appendable.append(name);
	}

	protected void appendOperationVisibility(final ITreeAppendable b, JvmOperation operation) {
		b.newLine();
		JvmDeclaredType declaringType = operation.getDeclaringType();
		if (declaringType instanceof JvmGenericType && !((JvmGenericType) declaringType).isInterface()) {
			b.append("@Override").newLine();
		}
		switch(operation.getVisibility()) {
//			case DEFAULT: break;  // cym comment
			case PUBLIC: b.append("public "); return;
//			case PROTECTED: b.append("protected "); return;  // cym comment
			case PRIVATE: b.append("private "); return;
		}
	}

	@Nullable
	protected JvmOperation findImplementingOperation(JvmTypeReference closureType, EObject context) {
		LightweightTypeReference lightweightTypeReference = new OwnedConverter(newTypeReferenceOwner(context)).toLightweightReference(closureType);
		return getTypeComputationServices().getFunctionTypes().findImplementingOperation(lightweightTypeReference);
	}
	
	private final static String REASSIGNED_THIS_IN_LAMBDA = "!reassigned_this_for_lambda!";
	
	protected void reassignThisInClosure(final ITreeAppendable b, JvmType rawClosureType) {
		boolean registerClosureAsThis = rawClosureType instanceof JvmGenericType;
		boolean isAlreadyInALambda = b.hasObject(REASSIGNED_THIS_IN_LAMBDA);
		if (b.hasObject("this") && !isAlreadyInALambda) {
			Object element = b.getObject("this");
			if (element instanceof JvmType) {
				final String proposedName = ((JvmType) element).getSimpleName()+".this";
				if (!b.hasObject(proposedName)) {
					b.declareSyntheticVariable(element, proposedName);
					if (b.hasObject("super")) {
						Object superElement = b.getObject("super");
						if (superElement instanceof JvmType) {
							b.declareSyntheticVariable(superElement, ((JvmType) element).getSimpleName()+".super");
						}
					}
				}
			} else {
				registerClosureAsThis = false;
			}
		}
		if (!isAlreadyInALambda) {
			// add a synthetic marker so we don't reassign this and super more than once.
			b.declareSyntheticVariable(REASSIGNED_THIS_IN_LAMBDA, REASSIGNED_THIS_IN_LAMBDA);
		}
		if (registerClosureAsThis) {
			b.declareVariable(rawClosureType, "this");
		}
	}
	
	protected JvmTypeReference getClosureOperationParameterType(JvmTypeReference closureType, JvmOperation operation, int i) {
		ITypeReferenceOwner owner = newTypeReferenceOwner(operation);
		OwnedConverter converter = new OwnedConverter(newTypeReferenceOwner(operation));
		LightweightTypeReference lightweightTypeReference = converter.toLightweightReference(closureType);
		Map<JvmTypeParameter, LightweightMergedBoundTypeArgument> mapping = new DeclaratorTypeArgumentCollector().getTypeParameterMapping(lightweightTypeReference);
		LightweightTypeReference parameterType = converter.toLightweightReference(operation.getParameters().get(i).getParameterType());
		return new StandardTypeParameterSubstitutor(mapping, owner).substitute(parameterType).toJavaCompliantTypeReference();
	}

	protected JvmTypeReference getClosureOperationReturnType(JvmTypeReference closureType, JvmOperation operation) {
		ITypeReferenceOwner owner = newTypeReferenceOwner(operation);
		OwnedConverter converter = new OwnedConverter(owner);
		LightweightTypeReference lightweightTypeReference = converter.toLightweightReference(closureType);
		Map<JvmTypeParameter, LightweightMergedBoundTypeArgument> mapping = new DeclaratorTypeArgumentCollector().getTypeParameterMapping(lightweightTypeReference);
		LightweightTypeReference parameterType = converter.toLightweightReference(operation.getReturnType());
		return new StandardTypeParameterSubstitutor(mapping, owner).substitute(parameterType).toJavaCompliantTypeReference();
	}
	
	protected void _toJavaExpression(final XClosure closure, final ITreeAppendable b) {
		if (b.hasName(closure)) {
			b.trace(closure, false).append(getVarName(closure, b));
		} else {
			toAnonymousClass(closure, b.trace(closure, false), getType(closure));
		}
	}
	
	@Override
	protected boolean internalCanCompileToJavaExpression(XExpression expression, ITreeAppendable appendable) {
		if (expression instanceof XSwitchExpression) {
			XSwitchExpression switchExpression = (XSwitchExpression) expression;
			return appendable.hasName(getSwitchExpressionKey(switchExpression)) || !isVariableDeclarationRequired(expression, appendable);
		} else {
			return super.internalCanCompileToJavaExpression(expression, appendable);
		}
	}
	
	
	@Override
	protected boolean isVariableDeclarationRequired(XExpression expr, ITreeAppendable b) {
		if (expr instanceof XAnnotation) {
			return false;
		}
		if (expr instanceof XListLiteral) {
			return false;
		}
//		if (expr instanceof XSetLiteral) {   //cym comment
//			LightweightTypeReference literalType = batchTypeResolver.resolveTypes(expr).getActualType(expr);
//			return literalType != null && literalType.isType(Map.class);
//		}
		
		if (expr instanceof XSetLiteral) {
			LightweightTypeReference literalType = batchTypeResolver.resolveTypes(expr).getActualType(expr);
			return literalType != null && literalType.isType(Buildin.Map.JvmType);
		}
		if (expr instanceof XCastedExpression) {
			return false;
		}
		if (expr instanceof XInstanceOfExpression) {
			return false;
		}
		if (expr instanceof XMemberFeatureCall && isVariableDeclarationRequired((XMemberFeatureCall) expr, b))
			return true;
		final EObject container = expr.eContainer();
		if ((container instanceof XVariableDeclaration)
			|| (container instanceof XReturnExpression) 
			|| (container instanceof XThrowExpression)){
			return false;
		}
		return super.isVariableDeclarationRequired(expr, b);
	}
	
	@SuppressWarnings("deprecation")
	protected org.summer.dsl.xbase.typing.Closures getClosures() {
		return closures;
	}
	
	//cym added
	protected void _toJavaExpression(XVariableDeclarationList varDeclarationList, ITreeAppendable b) {
//		if (varDeclaration.getRight() != null) {
//			internalToJavaStatement(varDeclaration.getRight(), b, true);
//		}
//		b.newLine();
//		JvmTypeReference type = 
//				appendVariableTypeAndName(varDeclaration, b);
		b.append("var ");
		boolean commaFlag = false;
		for(XExpression exp : varDeclarationList.getDeclarations()){
			if(commaFlag){
				b.append(",");
			}
			XVariableDeclaration decl = (XVariableDeclaration) exp;
			b.append(makeJavaIdentifier(decl.getName()));
			b.append(" = ");
			if (decl.getRight() != null) {
				internalToConvertedExpression(decl.getRight(), b, null);
			} else {
//				appendDefaultLiteral(b, type);
				b.append("null");
			}
//			b.append(";");
		}
		
	}
	
	protected void _toJavaExpression(final XArrayLiteral arrayLiteral, final ITreeAppendable b) {
		b.append("[");
		boolean commaFlag = false;
		for(XExpression element : arrayLiteral.getElements()){
			if(commaFlag ){
				b.append(", ");
			}
			
			toJavaExpression(element, b);
			commaFlag = true;
		}
		b.append("]");
	}
	
	protected void _toJavaExpression(final XObjectLiteral objectLiteral, final ITreeAppendable b) {
		b.append("{");
		b.increaseIndentation();
		boolean commaFlag = false;
		for(JvmMember member : objectLiteral.getMembers()){
			if(commaFlag ){
				b.append(", ");
			}
			
			b.newLine();
			b.append(member.getSimpleName()).append(" : ");
			
			JvmField field = (JvmField) member;
			if(field.getDefaultValue() != null){
				toJavaExpression(field.getDefaultValue(), b);
			}
			
			commaFlag = true;
		}
		b.decreaseIndentation();
		b.newLine();
		b.append("}");
	}
	
	protected void _toJavaExpression(final XAnnotation annotation, final ITreeAppendable b) {
		b.append("@");
		b.append(annotation.getAnnotationType());
		XExpression value = annotation.getValue();
		if (value != null) {
			b.append("(");
			internalToJavaExpression(value, b);
			b.append(")");
		} else {
			EList<XAnnotationElementValuePair> valuePairs = annotation.getElementValuePairs();
			if (valuePairs.isEmpty())
				return;
			b.append("(");
			for (int i = 0; i < valuePairs.size(); i++) {
				XAnnotationElementValuePair pair = valuePairs.get(i);
				b.append(pair.getElement().getSimpleName());
				b.append(" = ");
				internalToJavaExpression(pair.getValue(), b);
				if (i < valuePairs.size()-1) {
					b.append(", ");
				}
			}
			b.append(")");
		}
	}
}
