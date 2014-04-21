/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.summer.ss.core.macro.declaration

import com.google.common.base.Preconditions
import com.google.common.collect.ImmutableList
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.util.EcoreUtil
import org.summer.ss.lib.macro.declaration.CompilationStrategy
import org.summer.ss.lib.macro.declaration.MutableAnnotationReference
import org.summer.ss.lib.macro.declaration.MutableAnnotationTarget
import org.summer.ss.lib.macro.declaration.MutableAnnotationTypeDeclaration
import org.summer.ss.lib.macro.declaration.MutableAnnotationTypeElementDeclaration
import org.summer.ss.lib.macro.declaration.MutableClassDeclaration
import org.summer.ss.lib.macro.declaration.MutableConstructorDeclaration
import org.summer.ss.lib.macro.declaration.MutableElement
import org.summer.ss.lib.macro.declaration.MutableEnumerationTypeDeclaration
import org.summer.ss.lib.macro.declaration.MutableEnumerationValueDeclaration
import org.summer.ss.lib.macro.declaration.MutableExecutableDeclaration
import org.summer.ss.lib.macro.declaration.MutableFieldDeclaration
import org.summer.ss.lib.macro.declaration.MutableInterfaceDeclaration
import org.summer.ss.lib.macro.declaration.MutableMemberDeclaration
import org.summer.ss.lib.macro.declaration.MutableMethodDeclaration
import org.summer.ss.lib.macro.declaration.MutableNamedElement
import org.summer.ss.lib.macro.declaration.MutableParameterDeclaration
import org.summer.ss.lib.macro.declaration.MutableTypeDeclaration
import org.summer.ss.lib.macro.declaration.MutableTypeParameterDeclaration
import org.summer.ss.lib.macro.declaration.MutableTypeParameterDeclarator
import org.summer.ss.lib.macro.declaration.Type
import org.summer.ss.lib.macro.declaration.TypeReference
import org.summer.ss.lib.macro.declaration.Visibility
import org.summer.ss.lib.macro.expression.Expression
import org.summer.ss2.lib.StringConcatenationClient
import org.summer.dsl.model.types.JvmAnnotationTarget
import org.summer.dsl.model.types.JvmAnnotationType
import org.summer.dsl.model.types.JvmConstructor
import org.summer.dsl.model.types.JvmDeclaredType
import org.summer.dsl.model.types.JvmEnumerationLiteral
import org.summer.dsl.model.types.JvmEnumerationType
import org.summer.dsl.model.types.JvmExecutable
import org.summer.dsl.model.types.JvmField
import org.summer.dsl.model.types.JvmFormalParameter
import org.summer.dsl.model.types.JvmGenericType
import org.summer.dsl.model.types.JvmIdentifiableElement
import org.summer.dsl.model.types.JvmMember
import org.summer.dsl.model.types.JvmOperation
import org.summer.dsl.model.types.JvmVisibility
import org.summer.dsl.model.types.TypesFactory
import org.summer.dsl.model.types.impl.JvmMemberImplCustom
import org.summer.dsl.xbase.compiler.DocumentationAdapter
import org.summer.dsl.xbase.lib.Procedures.Procedure1

import static org.summer.ss.core.macro.ConditionUtils.*

abstract class JvmElementImpl<T extends EObject> extends AbstractElementImpl<T> implements MutableElement {
	
	override remove() {
		if (delegate.eContainer == null)
			return;
		EcoreUtil.remove(delegate)
		if (delegate.eContainer != null)
			throw new IllegalStateException("Couldn't remove "+delegate.toString)
	}
	
}

abstract class JvmNamedElementImpl<T extends JvmIdentifiableElement> extends JvmElementImpl<T> implements MutableNamedElement {
	
	override getSimpleName() {
		delegate.simpleName
	}
	
	override toString() {
		class.name+"["+simpleName+"]"
	}
	
}

abstract class JvmAnnotationTargetImpl<T extends JvmAnnotationTarget> extends JvmNamedElementImpl<T> implements MutableAnnotationTarget {
	override getAnnotations() {
		ImmutableList.copyOf(delegate.annotations.map[compilationUnit.toAnnotationReference(it)])
	}	
	
	override addAnnotation(Type annotationType) {
		switch annotationType { 
			JvmAnnotationTypeDeclarationImpl : {
				val result = TypesFactory.eINSTANCE.createJvmAnnotationReference
				result.setAnnotation(annotationType.delegate)
				this.delegate.annotations.add(result)
				return compilationUnit.toAnnotationReference(result)
			}
			default : throw new IllegalArgumentException(""+annotationType+" is not an annotation type.")
		}
	}
	
	override findAnnotation(Type annotationType) {
		annotations.findFirst[annotationTypeDeclaration == annotationType]
	}

}

abstract class JvmMemberDeclarationImpl<T extends JvmMember> extends JvmAnnotationTargetImpl<T> implements MutableMemberDeclaration {
	
	override getDocComment() {
		val adapter = EcoreUtil.getAdapter(delegate.eAdapters(), DocumentationAdapter) as DocumentationAdapter;
		return adapter?.getDocumentation();
	}
	
	override setDocComment(String docComment) {
		var adapter = EcoreUtil.getAdapter(delegate.eAdapters(), DocumentationAdapter) as DocumentationAdapter;
		if (adapter == null) {
			adapter = new DocumentationAdapter
			delegate.eAdapters += adapter
		}
		adapter.setDocumentation(docComment)
	}
	
	override getVisibility() {
		compilationUnit.toVisibility(delegate.visibility)
	}
	
	override setVisibility(Visibility visibility) {
		delegate.visibility = switch visibility {
//			case Visibility.DEFAULT : JvmVisibility.DEFAULT //cym comment
			case Visibility.PUBLIC : JvmVisibility.PUBLIC
			case Visibility.PRIVATE : JvmVisibility.PRIVATE
//			case Visibility.PROTECTED : JvmVisibility.PROTECTED //cym comment
		}
	}
	
	override getDeclaringType() {
		compilationUnit.toTypeDeclaration(delegate.declaringType)
	}
	
	override setSimpleName(String name) {
		checkJavaIdentifier(name, "name");
		switch (it: delegate) {
			JvmMemberImplCustom : clearIdentifierCache
		}
		delegate.simpleName = name
	}
	
}

abstract class JvmTypeDeclarationImpl<T extends JvmDeclaredType> extends JvmMemberDeclarationImpl<T> implements MutableTypeDeclaration {
	
	override getDeclaredMembers() {
		ImmutableList.copyOf(delegate.members.map[compilationUnit.toMemberDeclaration(it)])
	}
	
	override getSimpleName() {
		delegate.simpleName
	}
	
	override getQualifiedName() {
		delegate.identifier
	}
	
	override isAssignableFrom(Type otherType) {
		if (otherType == null)
			return false;
		val thisTypeRef = compilationUnit.typeReferenceProvider.newTypeReference(this)
		val thatTypeRef = compilationUnit.typeReferenceProvider.newTypeReference(otherType)
		return thisTypeRef.isAssignableFrom(thatTypeRef);
	}
	
	override addConstructor(Procedure1<MutableConstructorDeclaration> initializer) {
		Preconditions.checkArgument(initializer != null, "initializer cannot be null")
		// remove default constructor
		val constructor = delegate.members.filter(JvmConstructor).findFirst[compilationUnit.typeExtensions.isSingleSyntheticDefaultConstructor(it)]
		if (constructor != null) {
			EcoreUtil.remove(constructor)
		}
		val newConstructor = TypesFactory.eINSTANCE.createJvmConstructor
		newConstructor.visibility = JvmVisibility.PUBLIC
		newConstructor.simpleName = simpleName
		delegate.members.add(newConstructor)
		val mutableConstructorDeclaration = compilationUnit.toMemberDeclaration(newConstructor) as MutableConstructorDeclaration
		initializer.apply(mutableConstructorDeclaration)
		return mutableConstructorDeclaration
	}
	
	override addField(String name, Procedure1<MutableFieldDeclaration> initializer) {
		checkJavaIdentifier(name, "name")
		Preconditions.checkArgument(initializer != null, "initializer cannot be null")
		val newField = TypesFactory.eINSTANCE.createJvmField
		newField.simpleName = name
		newField.visibility = JvmVisibility.PRIVATE
		delegate.members.add(newField)
		val mutableFieldDeclaration = compilationUnit.toMemberDeclaration(newField) as MutableFieldDeclaration
		initializer.apply(mutableFieldDeclaration)
		return mutableFieldDeclaration
	}
	
	override addMethod(String name, Procedure1<MutableMethodDeclaration> initializer) {
		checkJavaIdentifier(name, "name")
		Preconditions.checkArgument(initializer != null, "initializer cannot be null")
		val newMethod = TypesFactory.eINSTANCE.createJvmOperation
		newMethod.visibility = JvmVisibility.PUBLIC
		newMethod.simpleName = name
		newMethod.returnType = compilationUnit.toJvmTypeReference(compilationUnit.typeReferenceProvider.primitiveVoid)
		delegate.members.add(newMethod)
		val mutableMethodDeclaration = compilationUnit.toMemberDeclaration(newMethod) as MutableMethodDeclaration
		initializer.apply(mutableMethodDeclaration)
		return mutableMethodDeclaration
	}
	
	override findDeclaredConstructor(TypeReference... parameterTypes) {
		checkIterable(parameterTypes, "parameterTypes")
		declaredConstructors.findFirst[constructor | constructor.parameters.map[type].toList == parameterTypes.toList]
	}
	
	override findDeclaredField(String name) {
		declaredFields.findFirst[field | field.simpleName == name]
	}
	
	override findDeclaredMethod(String name, TypeReference... parameterTypes) {
		checkIterable(parameterTypes, "parameterTypes")
		declaredMethods.findFirst[method | method.simpleName == name && method.parameters.map[type].toList == parameterTypes.toList]
	}
	
	override getDeclaredMethods() {
		declaredMembers.filter(MutableMethodDeclaration)
	}
	
	override getDeclaredFields() {
		declaredMembers.filter(MutableFieldDeclaration)
	}
	
	override getDeclaredClasses() {
		declaredMembers.filter(MutableClassDeclaration)
	}
	
	override getDeclaredConstructors() {
		declaredMembers.filter(MutableConstructorDeclaration)
	}
	
	override getDeclaredInterfaces() {
		declaredMembers.filter(MutableInterfaceDeclaration)
	}
	
	override setSimpleName(String name) {
		throw new UnsupportedOperationException("The type cannot be renamed.")
	}
	
}

class JvmInterfaceDeclarationImpl extends JvmTypeDeclarationImpl<JvmGenericType> implements MutableInterfaceDeclaration {
	
	override getExtendedInterfaces() {
		val filtered = delegate.superTypes.filter[(it.type as JvmGenericType).interface]
		filtered.map[compilationUnit.toTypeReference(it)].toList
	}
	
	override setExtendedInterfaces(Iterable<? extends TypeReference> superinterfaces) {
		checkIterable(superinterfaces, "superinterfaces")
		delegate.superTypes.clear
		for (typeRef : superinterfaces) {
			switch typeRef { TypeReferenceImpl : {
				delegate.superTypes += typeRef.delegate.toJavaCompliantTypeReference
			}}
		}
	}
	
	override getTypeParameters() {
		delegate.typeParameters.map[compilationUnit.toTypeParameterDeclaration(it)]
	}
	
	override setStrictFloatingPoint(boolean isStrictFloatingPoint) {
		delegate.setStrictFloatingPoint(isStrictFloatingPoint)
	}
	
	override isStrictFloatingPoint() {
		delegate.isStrictFloatingPoint	
	}
	
	override addMethod(String name, Procedure1<MutableMethodDeclaration> initializer) {
		val result = super.addMethod(name, initializer)
		result.setAbstract(true)
		return result;
	}
	
	override addConstructor(Procedure1<MutableConstructorDeclaration> initializer) {
		throw new UnsupportedOperationException("The interface '"+simpleName+"' cannot declare any constructors.")
	}
	
	override addTypeParameter(String name, TypeReference... upperBounds) {
		checkJavaIdentifier(name, "name");
		checkIterable(upperBounds, "upperBounds")
		val param = TypesFactory.eINSTANCE.createJvmTypeParameter
		param.name = name
		delegate.typeParameters.add(param)
		for (upper : upperBounds) {
			val typeRef = compilationUnit.toJvmTypeReference(upper)
			val jvmUpperBound = TypesFactory.eINSTANCE.createJvmUpperBound
			jvmUpperBound.setTypeReference(typeRef)
			param.constraints.add(jvmUpperBound)
		}
		return compilationUnit.toTypeParameterDeclaration(param)
	}

}

class JvmAnnotationTypeDeclarationImpl extends JvmTypeDeclarationImpl<JvmAnnotationType> implements MutableAnnotationTypeDeclaration {
	
	override addConstructor(Procedure1<MutableConstructorDeclaration> initializer) {
		throw new UnsupportedOperationException("The annotation '"+simpleName+"' cannot declare any constructors.")
	}
	
	override addField(String name, Procedure1<MutableFieldDeclaration> initializer) {
		throw new UnsupportedOperationException("The annotation '"+simpleName+"' cannot declare any fields.")
	}
	
	override addMethod(String name, Procedure1<MutableMethodDeclaration> initializer) {
		throw new UnsupportedOperationException("The annotation '"+simpleName+"' cannot declare any methods.")
	}
	
	override MutableAnnotationTypeElementDeclaration addAnnotationTypeElement(String name, Procedure1<MutableAnnotationTypeElementDeclaration> initializer) {
		checkJavaIdentifier(name, "name")
		Preconditions.checkArgument(initializer != null, "initializer cannot be null")
		val newAnnotationElement = TypesFactory.eINSTANCE.createJvmOperation
		newAnnotationElement.simpleName = name
		newAnnotationElement.visibility = JvmVisibility.PUBLIC
		delegate.members.add(newAnnotationElement)
		val mutableAnnotationTypeElementDeclaration = compilationUnit.toMemberDeclaration(newAnnotationElement) as MutableAnnotationTypeElementDeclaration
		initializer.apply(mutableAnnotationTypeElementDeclaration)
		return mutableAnnotationTypeElementDeclaration
	}
	
	override MutableAnnotationTypeElementDeclaration findDeclaredAnnotationTypeElement(String name) {
		declaredAnnotationTypeElements.findFirst[simpleName == name]
	}
	
	override Iterable<? extends MutableAnnotationTypeElementDeclaration> getDeclaredAnnotationTypeElements() {
		delegate.members.map[compilationUnit.toMemberDeclaration(it)].filter(MutableAnnotationTypeElementDeclaration)
	}
	
}

class JvmEnumerationTypeDeclarationImpl extends JvmTypeDeclarationImpl<JvmEnumerationType> implements MutableEnumerationTypeDeclaration {
	
	override getDeclaredValues() {
		declaredMembers.filter(MutableEnumerationValueDeclaration)
	}
	
	override addValue(String name, Procedure1<MutableEnumerationValueDeclaration> initializer) {
		checkJavaIdentifier(name, "name")
		Preconditions.checkArgument(initializer != null, "initializer cannot be null")
		val jvmLiteral = TypesFactory.eINSTANCE.createJvmEnumerationLiteral
		jvmLiteral.simpleName = name
		jvmLiteral.visibility = JvmVisibility.PUBLIC
		delegate.members.add(jvmLiteral)
		val mutableEnumerationValueDeclaration = compilationUnit.toMemberDeclaration(jvmLiteral) as MutableEnumerationValueDeclaration
		initializer.apply(mutableEnumerationValueDeclaration)
		return mutableEnumerationValueDeclaration
	}
	
	override findDeclaredValue(String name) {
		declaredValues.findFirst[value | value.simpleName == name]
	}
	
}

class JvmClassDeclarationImpl extends JvmTypeDeclarationImpl<JvmGenericType> implements MutableClassDeclaration {
	
	override getImplementedInterfaces() {
		val filtered = delegate.superTypes.filter[(it.type as JvmGenericType).interface]
		filtered.map[compilationUnit.toTypeReference(it)].toList
	}
	
	override getExtendedClass() {
		compilationUnit.toTypeReference(delegate.superTypes.findFirst[
			switch it: type {
				JvmGenericType case !interface : true
				default : false
			}
		])
	}
	
	override isAbstract() {
		delegate.isAbstract
	}
	
	override isFinal() {
		delegate.isFinal
	}
	
	override isStatic() {
		delegate.isStatic
	}
	
	override isStrictFloatingPoint() {
		delegate.isStrictFloatingPoint	
	}
	
	override setStrictFloatingPoint(boolean isStrictFloatingPoint) {
		delegate.setStrictFloatingPoint(isStrictFloatingPoint)
	}

	override getTypeParameters() {
		delegate.typeParameters.map[compilationUnit.toTypeParameterDeclaration(it)]
	}

	override setAbstract(boolean isAbstract) {
		delegate.setAbstract(isAbstract)
	}
	
	override setFinal(boolean isFinal) {
		delegate.setFinal(isFinal)
	}
	
	override setStatic(boolean isStatic) {
		delegate.setStatic(isStatic)
	}
	
	override setExtendedClass(TypeReference superclass) {
		val newTypeRef = 
			switch superclass {
				TypeReferenceImpl : superclass.delegate.toJavaCompliantTypeReference
				case null : compilationUnit.typeReferences.getTypeForName(Object, compilationUnit.xtendFile)
			}
		val oldType = delegate.superTypes.findFirst[it.type instanceof JvmGenericType && !(type as JvmGenericType).isInterface]
		if (oldType != null)
			delegate.superTypes.remove(oldType)
		delegate.superTypes.add(newTypeRef)
	}
	
	override setImplementedInterfaces(Iterable<? extends TypeReference> superInterfaces) {
		checkIterable(superInterfaces, "superIntefaces")
		val oldInterfaces = delegate.superTypes.filter[it.type instanceof JvmGenericType && (type as JvmGenericType).isInterface]
		delegate.superTypes.removeAll(oldInterfaces)
		delegate.superTypes.addAll(superInterfaces.filter(TypeReferenceImpl).map[delegate.toJavaCompliantTypeReference])
	}

	override findDeclaredField(String name) {
		declaredMembers.filter(MutableFieldDeclaration).findFirst[it.simpleName == name]
	}
	
	override findDeclaredMethod(String name, TypeReference[] parameterTypes) {
		checkIterable(parameterTypes, "parameterTypes")
		declaredMembers.filter(MutableMethodDeclaration).findFirst[
			it.simpleName == name 
			&& it.parameters.map[type].toList == parameterTypes.toList
		]
	}
	
	override addTypeParameter(String name, TypeReference... upperBounds) {
		checkJavaIdentifier(name, "name")
		checkIterable(upperBounds, "upperBounds")
		val param = TypesFactory.eINSTANCE.createJvmTypeParameter
		param.name = name
		delegate.typeParameters.add(param)
		for (upper : upperBounds) {
			val typeRef = compilationUnit.toJvmTypeReference(upper)
			val jvmUpperBound = TypesFactory.eINSTANCE.createJvmUpperBound
			jvmUpperBound.setTypeReference(typeRef)
			param.constraints.add(jvmUpperBound)
		}
		return compilationUnit.toTypeParameterDeclaration(param)
	}
	
}

abstract class JvmExecutableDeclarationImpl<T extends JvmExecutable> extends JvmMemberDeclarationImpl<T> implements MutableExecutableDeclaration {
	
	override getTypeParameters() {
		delegate.typeParameters.map[compilationUnit.toTypeParameterDeclaration(it)]
	}
	
	override isVarArgs() {
		delegate.varArgs
	}
	
	override getParameters() {
		delegate.parameters.map[compilationUnit.toParameterDeclaration(it)]
	}
	
	override getExceptions() {
		delegate.exceptions.map[compilationUnit.toTypeReference(it)]
	}
	
	override getBody() {
		val expression = compilationUnit.jvmTypesBuilder.getExpression(delegate)
		compilationUnit.toExpression(expression)
	}
	
	override setBody(Expression body) {
		if (body == null) {
			compilationUnit.jvmTypesBuilder.removeExistingBody(delegate)
		} else {
			compilationUnit.jvmTypesBuilder.setBody(delegate, (body as ExpressionImpl).delegate)
		}
	}
	
	override setExceptions(TypeReference... exceptions) {
		checkIterable(exceptions, "exceptions")
		delegate.exceptions.clear
		for (exceptionType : exceptions) {
			if (exceptionType != null) {
				delegate.exceptions.add(compilationUnit.toJvmTypeReference(exceptionType))
			}
		}
	}
	
	override setVarArgs(boolean isVarArgs) {
		delegate.setVarArgs(isVarArgs)
	}
	
	override addTypeParameter(String name, TypeReference... upperBounds) {
		checkJavaIdentifier(name, "name")
		checkIterable(upperBounds, "upperBounds")
		val param = TypesFactory.eINSTANCE.createJvmTypeParameter
		param.name = name
		delegate.typeParameters.add(param)
		for (upper : upperBounds) {
			val typeRef = compilationUnit.toJvmTypeReference(upper)
			val jvmUpperBound = TypesFactory.eINSTANCE.createJvmUpperBound
			jvmUpperBound.setTypeReference(typeRef)
			param.constraints.add(jvmUpperBound)
		}
		return compilationUnit.toTypeParameterDeclaration(param)
	}
	
	override setBody(CompilationStrategy compilationStrategy) {
		Preconditions.checkArgument(compilationStrategy != null, "compilationStrategy cannot be null")
		compilationUnit.setCompilationStrategy(delegate, compilationStrategy)
	}
	
	override setBody(StringConcatenationClient compilationTemplate) {
		Preconditions.checkArgument(compilationTemplate != null, "compilationTemplate cannot be null")
		compilationUnit.setCompilationTemplate(delegate, compilationTemplate)
	}
	
	override addParameter(String name, TypeReference type) {
		checkJavaIdentifier(name, "name");
		Preconditions.checkArgument(type != null, "type cannot be null");
		val param = TypesFactory.eINSTANCE.createJvmFormalParameter
		param.name = name
		param.parameterType = compilationUnit.toJvmTypeReference(type)
		delegate.parameters.add(param)
		return compilationUnit.toParameterDeclaration(param)
	}
	
}

class JvmParameterDeclarationImpl extends JvmAnnotationTargetImpl<JvmFormalParameter> implements MutableParameterDeclaration {

	override getType() {
		compilationUnit.toTypeReference(delegate.parameterType)
	}
	
	override getDeclaringExecutable() {
		compilationUnit.toMemberDeclaration(delegate.eContainer as JvmMember) as MutableExecutableDeclaration
	}
	
	override setSimpleName(String name) {
		checkJavaIdentifier(name, "name");
		delegate.name = name
	}
	
}

class JvmMethodDeclarationImpl extends JvmExecutableDeclarationImpl<JvmOperation> implements MutableMethodDeclaration {
	
	override isAbstract() {
		delegate.isAbstract
	}
	
	override isFinal() {
		delegate.isFinal
	}
	
//	override isOverride() {
//		throw new UnsupportedOperationException("Auto-Jvm function stub")
//	}
	
	override isStatic() {
		delegate.isStatic
	}
	
	override isSynchronized() {
		delegate.isSynchronized
	}
	
	override isDefault() {
		delegate.isDefault
	}
	
	override isStrictFloatingPoint() {
		delegate.isStrictFloatingPoint	
	}
	
	override setStrictFloatingPoint(boolean isStrictFloatingPoint) {
		delegate.setStrictFloatingPoint(isStrictFloatingPoint)
	}
	
	override isNative() {
		delegate.isNative	
	}

	override setNative(boolean isNative) {
		delegate.setNative(isNative)
	}
	
	override getReturnType() {
		compilationUnit.toTypeReference(delegate.returnType)
	}

	override setReturnType(TypeReference type) {
		Preconditions.checkArgument(type != null, "returnType cannot be null");
		delegate.setReturnType((type as TypeReferenceImpl).lightWeightTypeReference.toJavaCompliantTypeReference)
	}
	
	override setAbstract(boolean isAbstract) {
		delegate.setAbstract(isAbstract)
	}
	
	override setFinal(boolean isFinal) {
		delegate.setFinal(isFinal)
	}
	
//	override setOverride(boolean isOverride) {
//		delegate.setOverride(isOverride)
//	}
	
	override setStatic(boolean isStatic) {
		delegate.setStatic(isStatic)
	}
	
	override setSynchronized(boolean isSynchronized) {
		delegate.setSynchronized(isSynchronized)
	}
	
	override setDefault(boolean isDefault) {
		delegate.setDefault(isDefault)
	}
	
}

class JvmConstructorDeclarationImpl extends JvmExecutableDeclarationImpl<JvmConstructor> implements MutableConstructorDeclaration {
	
	override getSimpleName() {
		declaringType.simpleName
	}
	
}

class JvmEnumerationValueDeclarationImpl extends JvmMemberDeclarationImpl<JvmEnumerationLiteral> implements MutableEnumerationValueDeclaration {
	
	override setVisibility(Visibility visibility) {
		throw new UnsupportedOperationException("It is not possible to change visibility of enumeration value.")
	}
	
	override MutableEnumerationTypeDeclaration getDeclaringType() {
		super.getDeclaringType() as MutableEnumerationTypeDeclaration
	}

}

class JvmFieldDeclarationImpl extends JvmMemberDeclarationImpl<JvmField> implements MutableFieldDeclaration {
	
	override getInitializer() {
		compilationUnit.toExpression(compilationUnit.jvmTypesBuilder.getExpression(delegate))
	}
	
	override setInitializer(Expression initializer) {
		if (initializer == null) {
			compilationUnit.jvmTypesBuilder.removeExistingBody(delegate)
		} else {
			compilationUnit.jvmTypesBuilder.setInitializer(delegate, (initializer as ExpressionImpl).delegate)
		}
	}
	
	override setInitializer(CompilationStrategy initializer) {
		Preconditions.checkArgument(initializer != null, "initializer cannot be null")
		compilationUnit.setCompilationStrategy(delegate, initializer)
	}
	
	override setInitializer(StringConcatenationClient template) {
		Preconditions.checkArgument(template != null, "template cannot be null")
		compilationUnit.setCompilationTemplate(delegate, template)
	}
	
	override isFinal() {
		delegate.isFinal
	}
	
	override isStatic() {
		delegate.isStatic
	}
	
	override isTransient() {
		delegate.isTransient
	}
	
	override isVolatile() {
		delegate.isVolatile
	}
	
	override getType() {
		compilationUnit.toTypeReference(delegate.type)
	}

	override setFinal(boolean isFinal) {
		delegate.setFinal(isFinal)
	}
	
	override setStatic(boolean isStatic) {
		delegate.setStatic(isStatic)
	}
	
	override setTransient(boolean isTransient) {
		delegate.setTransient(isTransient)
	}
	
	override setVolatile(boolean isVolatile) {
		delegate.setVolatile(isVolatile)
	}
	
	override setType(TypeReference type) {
		Preconditions.checkArgument(type != null, "type cannot be null");
		delegate.setType((type as TypeReferenceImpl).lightWeightTypeReference.toJavaCompliantTypeReference)
	}
	
}

class JvmTypeParameterDeclarationImpl extends TypeParameterDeclarationImpl implements MutableAnnotationTarget, MutableTypeParameterDeclaration {
	
	override MutableTypeParameterDeclarator getTypeParameterDeclarator() {
		compilationUnit.toMemberDeclaration(delegate.eContainer as JvmExecutable) as MutableTypeParameterDeclarator
	}
	
	override setSimpleName(String name) {
		checkJavaIdentifier(name, "name");
		delegate.name = name
	}
	
	override remove() {
		if (delegate.eContainer == null)
			return;
		EcoreUtil.remove(delegate)
		if (delegate.eContainer != null)
			throw new IllegalStateException("Couldn't remove "+delegate.toString)
	}
	
	override isAssignableFrom(Type otherType) {
		if (otherType == null)
			return false;
		val thisTypeRef = compilationUnit.typeReferenceProvider.newTypeReference(this)
		val thatTypeRef = compilationUnit.typeReferenceProvider.newTypeReference(otherType)
		return thisTypeRef.isAssignableFrom(thatTypeRef);
	}
	
	override addAnnotation(Type annotationType) {
		throw new UnsupportedOperationException("TODO: auto-generated method stub")
	}
	
	override MutableAnnotationReference findAnnotation(Type annotationType) {
		return null
	}
	
	override Iterable<? extends MutableAnnotationReference> getAnnotations() {
		return emptyList
	}
	
	override getQualifiedName() {
		delegate.identifier
	}
	
	override setUpperBounds(Iterable<? extends TypeReference> upperBounds) {
		checkIterable(upperBounds, "upperBounds")
		delegate.constraints.clear
		for (upper : upperBounds) {
			val typeRef = compilationUnit.toJvmTypeReference(upper)
			val jvmUpperBound = TypesFactory.eINSTANCE.createJvmUpperBound
			jvmUpperBound.setTypeReference(typeRef)
			delegate.constraints.add(jvmUpperBound)
		}
	}
	
}

class JvmAnnotationTypeElementDeclarationImpl extends JvmMemberDeclarationImpl<JvmOperation> implements MutableAnnotationTypeElementDeclaration {
	
	override getDefaultValue() {
		return compilationUnit.translateAnnotationValue(delegate.defaultValue, compilationUnit.typeReferences.isArray(delegate.returnType))
	}
	
	override getType() {
		compilationUnit.toTypeReference( delegate.returnType )
	}
	
	override getDefaultValueExpression() {
		return null
	}
	
}

