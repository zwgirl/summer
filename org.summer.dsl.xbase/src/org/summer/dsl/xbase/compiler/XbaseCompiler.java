/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.summer.dsl.xbase.compiler;

import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.NonNullByDefault;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.generator.trace.ILocationData;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.summer.dsl.model.types.JvmAnnotationReference;
import org.summer.dsl.model.types.JvmAnnotationValue;
import org.summer.dsl.model.types.JvmDeclaredType;
import org.summer.dsl.model.types.JvmField;
import org.summer.dsl.model.types.JvmFormalParameter;
import org.summer.dsl.model.types.JvmGenericType;
import org.summer.dsl.model.types.JvmInterfaceType;
import org.summer.dsl.model.types.JvmMember;
import org.summer.dsl.model.types.JvmOperation;
import org.summer.dsl.model.types.JvmType;
import org.summer.dsl.model.types.JvmTypeParameter;
import org.summer.dsl.model.types.JvmTypeReference;
import org.summer.dsl.model.types.TypesPackage;
import org.summer.dsl.model.xbase.XAbstractFeatureCall;
import org.summer.dsl.model.xbase.XArrayLiteral;
import org.summer.dsl.model.xbase.XAssignment;
import org.summer.dsl.model.xbase.XBlockStatment;
import org.summer.dsl.model.xbase.XBreakStatment;
import org.summer.dsl.model.xbase.XCaller;
import org.summer.dsl.model.xbase.XCasePart;
import org.summer.dsl.model.xbase.XCastedExpression;
import org.summer.dsl.model.xbase.XCatchClause;
import org.summer.dsl.model.xbase.XClosure;
import org.summer.dsl.model.xbase.XCollectionLiteral;
import org.summer.dsl.model.xbase.XConstructorCall;
import org.summer.dsl.model.xbase.XContinueStatment;
import org.summer.dsl.model.xbase.XDoWhileStatment;
import org.summer.dsl.model.xbase.XExpression;
import org.summer.dsl.model.xbase.XExpressionStatment;
import org.summer.dsl.model.xbase.XFeatureCall;
import org.summer.dsl.model.xbase.XForEachStatment;
import org.summer.dsl.model.xbase.XForLoopStatment;
import org.summer.dsl.model.xbase.XFunctionDeclaration;
import org.summer.dsl.model.xbase.XIfStatment;
import org.summer.dsl.model.xbase.XIndexer;
import org.summer.dsl.model.xbase.XInstanceOfExpression;
import org.summer.dsl.model.xbase.XListLiteral;
import org.summer.dsl.model.xbase.XMemberFeatureCall;
import org.summer.dsl.model.xbase.XObjectLiteral;
import org.summer.dsl.model.xbase.XParenthesizedExpression;
import org.summer.dsl.model.xbase.XPostfixOperation;
import org.summer.dsl.model.xbase.XReturnStatment;
import org.summer.dsl.model.xbase.XSetLiteral;
import org.summer.dsl.model.xbase.XStatment;
import org.summer.dsl.model.xbase.XSwitchStatment;
import org.summer.dsl.model.xbase.XTernaryOperation;
import org.summer.dsl.model.xbase.XThrowStatment;
import org.summer.dsl.model.xbase.XTryCatchFinallyStatment;
import org.summer.dsl.model.xbase.XVariableDeclaration;
import org.summer.dsl.model.xbase.XVariableDeclarationList;
import org.summer.dsl.model.xbase.XWhileStatment;
import org.summer.dsl.model.xbase.XbasePackage;
import org.summer.dsl.xbase.compiler.output.ITreeAppendable;
import org.summer.dsl.xbase.controlflow.IEarlyExitComputer;
import org.summer.dsl.xbase.lib.Pair;
import org.summer.dsl.xbase.scoping.batch.Buildin;
import org.summer.dsl.xbase.typesystem.IBatchTypeResolver;
import org.summer.dsl.xbase.typesystem.IResolvedTypes;
import org.summer.dsl.xbase.typesystem.references.ITypeReferenceOwner;
import org.summer.dsl.xbase.typesystem.references.LightweightMergedBoundTypeArgument;
import org.summer.dsl.xbase.typesystem.references.LightweightTypeReference;
import org.summer.dsl.xbase.typesystem.references.OwnedConverter;
import org.summer.dsl.xbase.typesystem.references.ParameterizedTypeReference;
import org.summer.dsl.xbase.typesystem.util.DeclaratorTypeArgumentCollector;
import org.summer.dsl.xbase.typesystem.util.StandardTypeParameterSubstitutor;
import org.summer.dsl.xbase.util.XExpressionHelper;

import com.google.common.collect.Lists;
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
	
//	/**
//	 * @param isReferenced unused in this context but necessary for dispatch signature 
//	 */
//	protected void _toJavaStatement(XListLiteral literal, ITreeAppendable b, boolean isReferenced) {
//		for(XExpression element: literal.getElements()) 
//			internalToJavaStatement(element, b, true);
//	}

//	protected void _toJavaStatement(final XSetLiteral literal, ITreeAppendable b, boolean isReferenced) {
////		LightweightTypeReference literalType = resolveType(literal, Map.class);  // cym comment
//		LightweightTypeReference literalType = resolveType(literal, Buildin.Map.JvmType);
//		if(literalType != null) {
//			if(isReferenced)
//				declareSyntheticVariable(literal, b);
////			for(XExpression element: literal.getElements()) {  // cym comment
////				if (expressionHelper.isOperatorFromExtension(element, OperatorMapping.MAPPED_TO, ObjectExtensions.class)) {
////					XBinaryOperation binaryOperation = (XBinaryOperation) element;
////					internalToJavaStatement(binaryOperation.getLeftOperand(), b, true);
////					internalToJavaStatement(binaryOperation.getRightOperand(), b, true);
////				} else if (isType(element, Pair.class)) { 
////					internalToJavaStatement(element, b, true);
////				}
////			}
//			LightweightTypeReference keyType = literalType.getTypeArguments().get(0);
//			LightweightTypeReference valueType = literalType.getTypeArguments().get(1);
//			JvmType mapsClass = getTypeReferences().findDeclaredType(Maps.class, literal);
//			
//			final String tempMapName = b.declareSyntheticVariable(Tuples.create(literal,  "_tempMap"), "_tempMap");
//			b.newLine();
//			serialize(literalType.toTypeReference(), literal, b);
//			b.append(" ").append(tempMapName).append(" = ");
//			b.append(mapsClass).append(".<").append(keyType).append(", ").append(valueType).append(">newHashMap()").append(";").newLine();
//			for(XExpression element: literal.getElements())  {
//				if (expressionHelper.isOperatorFromExtension(element, OperatorMapping.MAPPED_TO, ObjectExtensions.class)) {
//					XBinaryOperation binaryOperation = (XBinaryOperation) element;
//					b.append(tempMapName).append(".put(");
//					internalToJavaExpression(binaryOperation.getLeftOperand(), b);
//					b.append(", ");
//					internalToJavaExpression(binaryOperation.getRightOperand(), b);
//					b.append(");").newLine();
//				}
////				else if (isType(element, Pair.class)) {   //cym comment
////					b.append(tempMapName).append(".put(");
////					internalToJavaExpression(element, b);
////					b.append(" == null ? null : ");
////					internalToJavaExpression(element, b);
////					b.append(".getKey()");
////					b.append(", ");
////					internalToJavaExpression(element, b);
////					b.append(" == null ? null : ");
////					internalToJavaExpression(element, b);
////					b.append(".getValue()");
////					b.append(");").newLine();
////				}
//			}
//			if(isReferenced) 
//				b.append(getVarName(literal, b)).append(" = ");
//			JvmType collectionsClass = getTypeReferences().findDeclaredType(Collections.class, literal);
//			b.append(collectionsClass)
//				.append(".<").append(keyType).append(", ").append(valueType)
//				.append(">unmodifiableMap(").append(tempMapName).append(");");
//		} else {
//			for(XExpression element: literal.getElements()) 
//				internalToJavaStatement(element, b, true);
//		}
//	}

	
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
//			appendImmutableCollectionExpression(literal, b, "unmodifiableList", Lists.class, "newArrayList");
		}
	}

//	protected void _toJavaExpression(XSetLiteral literal, ITreeAppendable b) {
//		LightweightTypeReference literalType = batchTypeResolver.resolveTypes(literal).getActualType(literal);
////		if(literalType != null && !literalType.isType(Map.class))  //cym comment
//		if(literalType != null && !literalType.isType(Buildin.Map.JvmType)) 
////			appendImmutableCollectionExpression(literal, b, "unmodifiableSet", Sets.class, "newHashSet");
//		else
//			b.trace(literal, false).append(getVarName(literal, b));
//	}
	
//	protected void appendImmutableCollectionExpression(XCollectionLiteral literal,
//			ITreeAppendable b, String collectionsMethod, Class<?> guavaHelper, String guavaHelperMethod) {
//		LightweightTypeReference collectionElementType = getCollectionElementType(literal);
//		ITypeReferenceOwner owner = collectionElementType.getOwner();
//		JvmType collectionsClass = getTypeReferences().findDeclaredType(Collections.class, literal);
//		JvmType guavaHelperType = getTypeReferences().findDeclaredType(guavaHelper, literal);
//		LightweightTypeReference guavaClass = guavaHelperType == null ? new UnknownTypeReference(owner, guavaHelper.getName()) :new ParameterizedTypeReference(owner, guavaHelperType);
//		b.append(collectionsClass)
//			.append(".<").append(collectionElementType).append(">").append(collectionsMethod).append("(")
//			.append(guavaClass).append(".<").append(collectionElementType).append(">").append(guavaHelperMethod).append("(");
//		boolean isFirst = true;
//		for(XExpression element: literal.getElements())  {
//			if(!isFirst)
//				b.append(", ");
//			isFirst = false;
//			if(element instanceof XNullLiteral) {
//				b.append("(").append(collectionElementType).append(")");
//			}
//			internalToJavaExpression(element, b);
//		}
//		b.append("))");
//		return;
//	}
	
	protected boolean canUseArrayInitializer(XListLiteral literal, ITreeAppendable appendable) {
		if (literal.eContainingFeature() == XbasePackage.Literals.XVARIABLE_DECLARATION__RIGHT
			|| literal.eContainingFeature() == TypesPackage.Literals.JVM_ANNOTATION_REFERENCE__VALUE
			|| literal.eContainingFeature() == TypesPackage.Literals.JVM_ANNOTATION_VALUE__VALUE
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

	//cym comment
//	@Override
//	protected List<XExpression> getActualArguments(XAbstractFeatureCall featureCall) {
//		EList<XExpression> actualArguments = featureCall.getActualArguments();
//		List<XExpression> normalizedArguments = normalizeBlockExpression(actualArguments);
//		return normalizedArguments;
//	}
	
	@Override
	protected List<XExpression> getActualArguments(XAbstractFeatureCall featureCall) {
		return featureCall.getActualArguments();
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
	
//	@SuppressWarnings("deprecation")
//	@Override
//	protected void convertFunctionType(JvmTypeReference expectedType, final JvmTypeReference functionType,
//			ITreeAppendable appendable, Later expression, XExpression context) {
//		if (expectedType.getIdentifier().equals(Object.class.getName())
//				|| EcoreUtil.equals(expectedType.getType(), functionType.getType())
//				|| ((expectedType instanceof JvmSynonymTypeReference) 
//					&& Iterables.any(((JvmSynonymTypeReference)expectedType).getReferences(), new Predicate<JvmTypeReference>() {
//						public boolean apply(@Nullable JvmTypeReference ref) {
//							if (ref == null) {
//								throw new IllegalStateException();
//							}
//							return EcoreUtil.equals(ref.getType(), functionType.getType());
//						}
//					}))) {
//			// same raw type but different type parameters
//			// at this point we know that we are compatible so we have to convince the Java compiler about that ;-)
//			if (!getTypeConformanceComputer().isConformant(expectedType, functionType)) {
//				// insert a cast
//				appendable.append("(");
//				serialize(expectedType, context, appendable);
//				appendable.append(")");
//			}
//			expression.exec(appendable);
//			return;
//		}
//		JvmOperation operation = getClosures().findImplementingOperation(expectedType, context.eResource());
//		if (operation == null) {
//			throw new IllegalStateException("expected type " + expectedType + " not mappable from " + functionType);
//		}
//		appendable.append("new ");
//		LightweightTypeReference lightweightExpectedType = new OwnedConverter(newTypeReferenceOwner(context))
//			.toLightweightReference(expectedType);
//		FunctionTypeReference functionTypeReference = lightweightExpectedType.tryConvertToFunctionTypeReference(false);
//		if (functionTypeReference == null)
//			throw new IllegalStateException("Expected type does not seem to be a SAM type");
//		JvmTypeReference convertedExpectedType = functionTypeReference.toInstanceTypeReference().toTypeReference();
//		serialize(convertedExpectedType, context, appendable, false, false);
//		appendable.append("() {");
//		appendable.increaseIndentation().increaseIndentation();
//		appendable.newLine().append("public ");
//		LightweightTypeReference returnType = functionTypeReference.getReturnType();
//		if (returnType == null)
//			throw new IllegalStateException("Could not find return type");
//		serialize(returnType.toTypeReference(), context, appendable, false, false);
//		appendable.append(" ").append(operation.getSimpleName()).append("(");
//		List<JvmFormalParameter> params = operation.getParameters();
//		for (int i = 0; i < params.size(); i++) {
//			if (i != 0)
//				appendable.append(",");
//			JvmFormalParameter p = params.get(i);
//			final String name = p.getName();
//			serialize(functionTypeReference.getParameterTypes().get(i).toTypeReference(), context, appendable, false, false);
//			appendable.append(" ").append(name);
//		}
//		appendable.append(") {");
//		appendable.increaseIndentation();
//		try {
//			appendable.openScope();
//			reassignThisInClosure(appendable, operation.getDeclaringType());
//			if (!getTypeReferences().is(operation.getReturnType(), Void.TYPE))
//				appendable.newLine().append("return ");
//			else
//				appendable.newLine();
//			expression.exec(appendable);
//			appendable.append(".");
//			JvmOperation actualOperation = getClosures().findImplementingOperation(functionType, context.eResource());
//			appendable.append(actualOperation.getSimpleName());
//			appendable.append("(");
//			for (Iterator<JvmFormalParameter> iterator = params.iterator(); iterator.hasNext();) {
//				JvmFormalParameter p = iterator.next();
//				final String name = p.getName();
//				appendable.append(name);
//				if (iterator.hasNext())
//					appendable.append(",");
//			}
//			appendable.append(");");
//		} finally {
//			appendable.closeScope();
//		}
//		appendable.decreaseIndentation();
//		appendable.newLine().append("}");
//		appendable.decreaseIndentation().decreaseIndentation();
//		appendable.newLine().append("}");
//	}
	
	@Override
	protected void internalToConvertedExpression(XExpression obj, ITreeAppendable appendable) {
		if (obj instanceof XAssignment) {
			_toJavaExpression((XAssignment) obj, appendable);
		} else if (obj instanceof XCastedExpression) {
			_toJavaExpression((XCastedExpression) obj, appendable);
		} else if (obj instanceof XClosure) {
			_toJavaExpression((XClosure) obj, appendable);
		} else if (obj instanceof JvmAnnotationReference) {
			_toJavaExpression((JvmAnnotationReference) obj, appendable);
		} else if (obj instanceof XConstructorCall) {
			_toJavaExpression((XConstructorCall) obj, appendable);
		} else if (obj instanceof XInstanceOfExpression) {
			_toJavaExpression((XInstanceOfExpression) obj, appendable);
		} else if (obj instanceof XListLiteral) {
			_toJavaExpression((XListLiteral) obj, appendable);
		} else if (obj instanceof XArrayLiteral) {
			_toJavaExpression((XArrayLiteral) obj, appendable);
		} else if (obj instanceof XObjectLiteral) {
			_toJavaExpression((XObjectLiteral) obj, appendable);
		} else if (obj instanceof XSetLiteral) {
			_toJavaExpression((XSetLiteral) obj, appendable);
		} else if (obj instanceof XPostfixOperation) {
			_toJavaExpression((XPostfixOperation) obj, appendable);
		} else if (obj instanceof XPostfixOperation) {
			_toJavaExpression((XPostfixOperation) obj, appendable);
		} else if (obj instanceof XIndexer) {
			_toJavaExpression((XIndexer) obj, appendable);
		} else if (obj instanceof XTernaryOperation) {
			_toJavaExpression((XTernaryOperation) obj, appendable);
		} else if (obj instanceof XVariableDeclarationList) {
			_toJavaExpression((XVariableDeclarationList) obj, appendable);
		} else if (obj instanceof XParenthesizedExpression) {
			_toJavaExpression((XParenthesizedExpression) obj, appendable);
		} else if (obj instanceof XCaller) {
			_toJavaExpression((XCaller) obj, appendable);
		} else {
			super.internalToConvertedExpression(obj, appendable);
		}
	}
	
	@Override
	protected void doInternalToJavaStatement(XStatment obj, ITreeAppendable appendable, boolean isReferenced) {
		if (obj instanceof XBlockStatment) {
			_toJavaStatement((XBlockStatment) obj, appendable, isReferenced);
		} else if (obj instanceof XFunctionDeclaration) {
			_toJavaStatement((XFunctionDeclaration) obj, appendable, isReferenced);
		} else if (obj instanceof XExpressionStatment) {
			_toJavaStatement((XExpressionStatment) obj, appendable, isReferenced);
		} else if (obj instanceof XDoWhileStatment) {
			_toJavaStatement((XDoWhileStatment) obj, appendable, isReferenced);
		} else if (obj instanceof XForLoopStatment) {
			_toJavaStatement((XForLoopStatment) obj, appendable, isReferenced);
		} else if (obj instanceof XForLoopStatment) {
			_toJavaStatement((XForEachStatment) obj, appendable, isReferenced);
		} else if (obj instanceof XIfStatment) {
			_toJavaStatement((XIfStatment) obj, appendable, isReferenced);
		} else if (obj instanceof XReturnStatment) {
			_toJavaStatement((XReturnStatment) obj, appendable, isReferenced);
		} else if (obj instanceof XSwitchStatment) {
			_toJavaStatement((XSwitchStatment) obj, appendable, isReferenced);
		} else if (obj instanceof XThrowStatment) {
			_toJavaStatement((XThrowStatment) obj, appendable, isReferenced);
		} else if (obj instanceof XTryCatchFinallyStatment) {
			_toJavaStatement((XTryCatchFinallyStatment) obj, appendable, isReferenced);
		} else if (obj instanceof XVariableDeclarationList) {
			_toJavaStatement((XVariableDeclarationList) obj, appendable, isReferenced);
		} else if (obj instanceof XWhileStatment) {
			_toJavaStatement((XWhileStatment) obj, appendable, isReferenced);
		} else if (obj instanceof XBreakStatment) {
			_toJavaStatement((XBreakStatment) obj, appendable, isReferenced);
		} else if (obj instanceof XContinueStatment) {
			_toJavaStatement((XContinueStatment) obj, appendable, isReferenced);
		} else {
			super.doInternalToJavaStatement(obj, appendable, isReferenced);
		}
	}
	
	protected void _toJavaStatement(XExpressionStatment stat, ITreeAppendable b, boolean isReferenced) {
		b.newLine();
		internalToConvertedExpression(stat.getExpression(), b);
		b.append(";");
	}
	
	protected void _toJavaStatement(XBreakStatment expr, ITreeAppendable outerAppendable, boolean isReferenced) {
		outerAppendable.append("break;");
	}
	
	protected void _toJavaStatement(XContinueStatment expr, ITreeAppendable outerAppendable, boolean isReferenced) {
		outerAppendable.append("continue;");
	}
	
	protected void _toJavaStatement(XBlockStatment statment, ITreeAppendable b, boolean isReferenced) {
		b.append("{");
		b.increaseIndentation().newLine();
	
		final EList<XStatment> statments = statment.getStatments();
		for (int i = 0; i < statments.size(); i++) {
			XStatment ex = statments.get(i);
			internalToJavaStatement(ex, b, false);
		}
		b.decreaseIndentation().newLine().append("}");
	}
	
	protected boolean bracesAreAddedByOuterStructure(XBlockStatment block) {
		EObject container = block.eContainer();
		if (container instanceof XTryCatchFinallyStatment 
				|| container instanceof XIfStatment
				|| container instanceof XClosure) {
			return true;
		}
		if (!(container instanceof XExpression)) {
			return true;
		}
		return false;
	}
	
	protected void _toJavaExpression(XAssignment expr, ITreeAppendable b) {
		internalToConvertedExpression(expr.getAssignable(), b);
		if(expr.getFeature()!=null){
			b.append(expr.getFeature().getSimpleName());
		}
		b.append(" = ");
		internalToConvertedExpression(expr.getValue(), b);
	}

//	protected void _toJavaExpression(XBlockStatment expr, ITreeAppendable b) {
//		if (expr.getStatments().isEmpty()) {
//			b.append("null");
//			return;
//		}
//		if (expr.getStatments().size()==1) {
//			// conversion was already performed for single expression blocks
//			internalToConvertedExpression(expr.getStatments().get(0), b, null);
//			return;
//		}
//		b = b.trace(expr, false);
//		b.append(getVarName(expr, b));
//	}

	protected void _toJavaStatement(XTryCatchFinallyStatment expr, ITreeAppendable b, boolean isReferenced) {
		b.newLine().append("try {").increaseIndentation();
		internalToJavaStatement(expr.getStatment(), b, false);
		b.decreaseIndentation().newLine().append("}");
		appendCatchAndFinally(expr, b, isReferenced);
	}
	
	protected void appendCatchAndFinally(XTryCatchFinallyStatment expr, ITreeAppendable b, boolean isReferenced) {
		XCatchClause catchClause = expr.getCatchClause();
		if (catchClause != null) {
			b.append(" catch ( ").append(catchClause.getIdentifier()).append(") ");
			b.append("{").increaseIndentation();
			b.newLine();
			
			doInternalToJavaStatement(catchClause.getStatment(), b, false);
			
			b.decreaseIndentation();
			b.newLine().append("}");
		}
		
		final XStatment finallyStat = expr.getFinallyStatment();
		if (finallyStat != null) {
			b.append(" finally {").increaseIndentation();
			b.newLine();
			internalToJavaStatement(finallyStat, b, false);
			b.decreaseIndentation().newLine().append("}");
		}
	}

	/**
	 * @param isReferenced unused in this context but necessary for dispatch signature 
	 */
	protected void _toJavaStatement(XThrowStatment statment, ITreeAppendable b, boolean isReferenced) {
		b.newLine().append("throw ");
		internalToJavaExpression(statment.getExpression(), b);
		b.append(";");
	}

	protected void _toJavaExpression(XInstanceOfExpression expr, ITreeAppendable b) {
		internalToJavaExpression(expr.getExpression(), b);
		b.append(" instanceof ");
		serialize(expr.getType(), expr, b);
	}
	
	//cym added
	protected void _toJavaStatement(XVariableDeclarationList varDeclarationList, ITreeAppendable b, boolean isReferenced) {
		b.newLine();
		b.append("var ");
		boolean commaFlag = false;
		for(XExpression exp : varDeclarationList.getDeclarations()){
			if(commaFlag){
				b.append(", ");
			}
			XVariableDeclaration decl = (XVariableDeclaration) exp;
			b.append(makeJavaIdentifier(decl.getSimpleName()));
			b.append(" = ");
			if (decl.getRight() != null) {
				internalToConvertedExpression(decl.getRight(), b, null);
			} else {
				b.append("null");
			}
			commaFlag = true;
		}
		
		b.append(";");
		
	}

	/**
	 * @param isReferenced unused in this context but necessary for dispatch signature 
	 */
	protected void _toJavaStatement(XWhileStatment expr, ITreeAppendable b, boolean isReferenced) {
		b.newLine().append("while (");
		internalToJavaExpression(expr.getPredicate(), b);
		b.append(")");
		b.openPseudoScope();
		internalToJavaStatement(expr.getBody(), b, false);
		b.closeScope();
	}

	/**
	 * @param isReferenced unused in this context but necessary for dispatch signature  
	 */
	protected void _toJavaStatement(XDoWhileStatment expr, ITreeAppendable b, boolean isReferenced) {
		b.newLine().append("do ");
		internalToJavaStatement(expr.getBody(), b, false);
		b.append(" while(");
		internalToJavaExpression(expr.getPredicate(), b);
		b.append(")");
	}
	
	/**
	 * @param isReferenced unused in this context but necessary for dispatch signature 
	 */
	protected void _toJavaStatement(XForLoopStatment expr, ITreeAppendable b, boolean isReferenced) {
		b.newLine();
		b.append("for (");
		internalToJavaExpression(expr.getInitial(), b);
		b.append(";");
		internalToJavaExpression(expr.getCondition(), b);
		b.append(";");
		internalToJavaExpression(expr.getIncrement(), b);
		b.append(")");
		internalToJavaStatement(expr.getStatment(), b, false);
	}

	/**
	 * @param isReferenced unused in this context but necessary for dispatch signature 
	 */
	protected void _toJavaStatement(XForEachStatment stat, ITreeAppendable b, boolean isReferenced) {
		b.append("for (");
		ITreeAppendable parameterAppendable = b.trace(stat.getDeclaredParam());
//		appendForLoopParameter(stat, parameterAppendable);
		b.append(" : ");
		internalToJavaExpression(stat.getExpression(), b);
		b.append(")").increaseIndentation();
		internalToJavaStatement(stat.getStatment(), b, false);
	}

//	protected void appendForLoopParameter(XForEachStatment expr, ITreeAppendable appendable) {
//		appendable.append("final ");
//		JvmTypeReference paramType = getForLoopParameterType(expr);
//		serialize(paramType, expr, appendable);
//		appendable.append(" ");
//		final String name = makeJavaIdentifier(expr.getDeclaredParam().getName());
//		String varName = appendable.declareVariable(expr.getDeclaredParam(), name);
//		appendable.trace(expr.getDeclaredParam(), TypesPackage.Literals.JVM_FORMAL_PARAMETER__NAME, 0).append(varName);
//	}

//	@SuppressWarnings("deprecation")
//	protected JvmTypeReference getForLoopParameterType(XForEachStatment expr) {
//		JvmTypeReference declaredType = expr.getDeclaredParam().getParameterType();
//		if (declaredType != null) {
//			return declaredType;
//		}
//		return getTypeProvider().getTypeForIdentifiable(expr.getDeclaredParam());
//	}


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
	
	protected void _toJavaExpression(XPostfixOperation expr, ITreeAppendable b) {
		internalToJavaExpression(expr.getOperand(), b);
		b.append("++");
	}
	
	protected void _toJavaExpression(XIndexer expr, ITreeAppendable b) {
		b.append("[");
//		internalToJavaExpression(expr.getIndex(), b);
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
	protected void _toJavaStatement(XReturnStatment stat, ITreeAppendable b, boolean isReferenced) {
		b.newLine();
		b.append("return ");
		if(stat.getExpression()!=null){
			internalToConvertedExpression(stat.getExpression(), b);
		}
		b.append(";");
	}
	
	protected void _toJavaExpression(XCastedExpression expr, ITreeAppendable b) {
//		b.append("((");
//		serialize(expr.getType(), expr, b);
//		b.append(") ");
//		internalToConvertedExpression(expr.getTarget(), b, expr.getType());
//		b.append(")");
		
		toJavaExpression(expr.getTarget(), b);
	}

	protected void _toJavaStatement(XIfStatment expr, ITreeAppendable b, boolean isReferenced) {
		b.newLine().append("if (");
		internalToConvertedExpression(expr.getIf(), b);
		b.append(")");
		internalToJavaStatement(expr.getThen(), b, false);
		if (expr.getElse() != null) {
			b.append(" else");
			internalToJavaStatement(expr.getElse(), b, false);
		}
	}

	protected void _toJavaStatement(XSwitchStatment expr, ITreeAppendable b, boolean isReferenced) {
		b.newLine();
		
		b.append("switch(");
		
		internalToJavaExpression(expr.getSwitch(), b);
		b.append(")");
		
		b.append(" {");
		for (XCasePart casePart : expr.getCases()) {
			b.increaseIndentation();
			b.newLine().append("case ");
			
			internalToJavaExpression(casePart.getCase(), b);
			b.append(":");
			b.newLine();
			internalToJavaStatement(casePart.getThen(), b, isReferenced);
		}
		if (expr.getDefault()!=null) {
			b.newLine();
			b.append("default: ");
			internalToJavaStatement(expr.getDefault(), b, isReferenced);
		}
		b.decreaseIndentation();
		b.newLine();
		b.append("}");
	}
	
	protected boolean isSimpleFeatureCall(XExpression switch1) {
		if (switch1 instanceof XFeatureCall)  {
			XFeatureCall featureCall = (XFeatureCall) switch1;
			return !(featureCall.getFeature() instanceof JvmOperation);
		}
		return false;
	}

	protected Object getSwitchExpressionKey(XSwitchStatment expr) {
		return new Pair<XSwitchStatment, String>(expr, "key");
	}
	
	@Override
	@Nullable
	protected String getReferenceName(XExpression expr, ITreeAppendable b) {
		if (expr instanceof XSwitchStatment) {
			Object key = getSwitchExpressionKey((XSwitchStatment) expr);
			if (b.hasName(key))
				return b.getName(key);
		}
		return super.getReferenceName(expr, b);
	}

	@Nullable
	protected ILocationData getLocationOfDefault(XSwitchStatment expression) {
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
	
	protected void _toJavaStatement(final XFunctionDeclaration function, final ITreeAppendable b, boolean isReferenced) {

		b.newLine();
		b.append("function ").append(function.getSimpleName()).append("(");
		
		boolean comma = false;
		for(JvmFormalParameter parameter : function.getFormalParameters()){
			if(comma){
				b.append(", ");
			}
			b.append(parameter.getSimpleName());
			comma = true;
		}
		b.append(")");
		toJavaStatement(function.getBody(), b, isReferenced);
	}
	
	protected ITreeAppendable toAnonymousClass(final XClosure closure, final ITreeAppendable b, JvmTypeReference type) {
		b.append(" function ");
		b.append("(");
		List<JvmFormalParameter> closureParams = closure.getFormalParameters();
		for (int i = 0; i < closureParams.size(); i++) {
			JvmFormalParameter closureParam = closureParams.get(i);
//			JvmTypeReference parameterType = getClosureOperationParameterType(type, operation, i);
			appendClosureParameter(closureParam, null, closure, b);
			if (i != closureParams.size() - 1)
				b.append(", ");
		}
		b.append(")");
//		if(!operation.getExceptions().isEmpty()) {
//			b.append(" throws ");
//			for (int i = 0; i < operation.getExceptions().size(); ++i) {
//				serialize(operation.getExceptions().get(i), closure, b, false, false, false, false);
//				if(i != operation.getExceptions().size() -1)
//					b.append(", ");
//			}
//		}
		b.append(" {");
		b.increaseIndentation();
//		reassignThisInClosure(b, type.getType());
//		compile(closure.getExpression(), b, operation.getReturnType(), newHashSet(operation.getExceptions()));
		b.decreaseIndentation();
		b.newLine().append("}");
		return b;
	}
	
	protected void appendClosureParameter(JvmFormalParameter closureParam, JvmTypeReference parameterType, final XClosure closure,
			final ITreeAppendable appendable) {
		final String proposedParamName = makeJavaIdentifier(closureParam.getSimpleName());
		String name = appendable.declareVariable(closureParam, proposedParamName);
		appendable.append(name);
	}

	protected void appendOperationVisibility(final ITreeAppendable b, JvmOperation operation) {
		b.newLine();
		JvmDeclaredType declaringType = operation.getDeclaringType();
		if (declaringType instanceof JvmGenericType && !(declaringType instanceof JvmInterfaceType)) {
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
//		if (b.hasName(closure)) {
//			b.trace(closure, false).append(getVarName(closure, b));
//		} else {
//			toAnonymousClass(closure, b.trace(closure, false), getType(closure));
//		}
		
		b.append("function(");
		
		boolean comma = false;
		for(JvmFormalParameter parameter : closure.getFormalParameters()){
			if(comma){
				b.append(", ");
			}
			b.append(parameter.getSimpleName());
			comma = true;
		}
		b.append(")");
		internalToJavaStatement(closure.getStatment(), b, false);
	
	}
	
	@Override
	protected boolean internalCanCompileToJavaExpression(XExpression expression, ITreeAppendable appendable) {
		if (expression instanceof XSwitchStatment) {
			XSwitchStatment switchExpression = (XSwitchStatment) expression;
			return appendable.hasName(getSwitchExpressionKey(switchExpression)) || !isVariableDeclarationRequired(expression, appendable);
		} else {
			return super.internalCanCompileToJavaExpression(expression, appendable);
		}
	}
	
	
	@Override
	protected boolean isVariableDeclarationRequired(XExpression expr, ITreeAppendable b) {
		if (expr instanceof JvmAnnotationReference) {
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
			|| (container instanceof XReturnStatment) 
			|| (container instanceof XThrowStatment)){
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
			b.append(makeJavaIdentifier(decl.getSimpleName()));
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
	
	protected void _toJavaExpression(XParenthesizedExpression obj, ITreeAppendable b) {
		b.append("(");
		internalToConvertedExpression(obj.getExpression(), b);
		b.append(")");
	}
	
	
	protected void _toJavaExpression(XCaller obj, ITreeAppendable b) {
		internalToConvertedExpression(obj.getExecutable(), b);
		b.append("(");
		boolean comma = false;
		for(XExpression argument : obj.getArguments()){
			if(comma){
				b.append(", ");
			}
			internalToConvertedExpression(argument, b);
			comma = true;
		}
		b.append(")");
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
	
	protected void _toJavaExpression(final JvmAnnotationReference annotation, final ITreeAppendable b) {
		b.append("@");
		b.append(annotation.getAnnotation());
		XExpression value = annotation.getValue();
		if (value != null) {
			b.append("(");
			internalToJavaExpression(value, b);
			b.append(")");
		} else {
			EList<JvmAnnotationValue> valuePairs = annotation.getValues();
			if (valuePairs.isEmpty())
				return;
			b.append("(");
			for (int i = 0; i < valuePairs.size(); i++) {
				JvmAnnotationValue pair = valuePairs.get(i);
				b.append(pair.getField().getSimpleName());
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
