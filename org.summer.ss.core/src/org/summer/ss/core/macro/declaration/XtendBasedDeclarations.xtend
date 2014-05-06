/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
 
package org.summer.ss.core.macro.declaration

import com.google.common.collect.ImmutableList
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.InternalEObject
import org.summer.dsl.model.ss.XtendAnnotationTarget
import org.summer.dsl.model.ss.XtendAnnotationType
import org.summer.dsl.model.ss.XtendClass
import org.summer.dsl.model.ss.XtendConstructor
import org.summer.dsl.model.ss.XtendEnum
import org.summer.dsl.model.ss.XtendEnumLiteral
import org.summer.dsl.model.ss.XtendField
import org.summer.dsl.model.ss.XtendFunction
import org.summer.dsl.model.ss.XtendInterface
import org.summer.dsl.model.ss.XtendMember
import org.summer.dsl.model.ss.XtendParameter
import org.summer.dsl.model.ss.XtendTypeDeclaration
import org.summer.ss.lib.macro.declaration.AnnotationReference
import org.summer.ss.lib.macro.declaration.AnnotationTarget
import org.summer.ss.lib.macro.declaration.AnnotationTypeDeclaration
import org.summer.ss.lib.macro.declaration.AnnotationTypeElementDeclaration
import org.summer.ss.lib.macro.declaration.ClassDeclaration
import org.summer.ss.lib.macro.declaration.ConstructorDeclaration
import org.summer.ss.lib.macro.declaration.EnumerationTypeDeclaration
import org.summer.ss.lib.macro.declaration.EnumerationValueDeclaration
import org.summer.ss.lib.macro.declaration.ExecutableDeclaration
import org.summer.ss.lib.macro.declaration.FieldDeclaration
import org.summer.ss.lib.macro.declaration.InterfaceDeclaration
import org.summer.ss.lib.macro.declaration.MemberDeclaration
import org.summer.ss.lib.macro.declaration.MethodDeclaration
import org.summer.ss.lib.macro.declaration.ParameterDeclaration
import org.summer.ss.lib.macro.declaration.Type
import org.summer.ss.lib.macro.declaration.TypeDeclaration
import org.summer.ss.lib.macro.declaration.TypeParameterDeclaration
import org.summer.ss.lib.macro.declaration.TypeParameterDeclarator
import org.summer.ss.lib.macro.declaration.TypeReference
import org.summer.dsl.model.types.JvmAnnotationType
import org.summer.dsl.model.types.JvmType
import org.summer.dsl.model.types.JvmTypeParameter
import org.summer.dsl.model.types.JvmUpperBound
import org.summer.dsl.model.xannotation.XAnnotation

import static org.summer.dsl.model.xannotation.XannotationPackage.Literals.*
import org.summer.dsl.model.ss.XModule

abstract class XtendNamedElementImpl<T extends EObject> extends AbstractNamedElementImpl<T> {
	
}

abstract class XtendAnnotationTargetImpl<T extends XtendAnnotationTarget> extends XtendNamedElementImpl<T> implements AnnotationTarget {
	
	override getAnnotations() {
		ImmutableList.copyOf( this.delegate.annotations.map[compilationUnit.toAnnotationReference(it)] )
	}
	
	override findAnnotation(Type annotationType) {
		annotations.findFirst[it.annotationTypeDeclaration == annotationType]
	}
	
}

abstract class XtendMemberDeclarationImpl<T extends XtendMember> extends XtendAnnotationTargetImpl<T> implements MemberDeclaration {
	
	override getDocComment() {
		compilationUnit.documentationProvider.getDocumentation(delegate)
	}
	
	override getDeclaringType() {
		switch container : delegate.eContainer {
			XtendTypeDeclaration : compilationUnit.toXtendTypeDeclaration(container)
			default : null
		}
	}
	
	override getVisibility() {
		compilationUnit.toVisibility(delegate.visibility)
	}
	
}

abstract class XtendTypeDeclarationImpl<T extends XtendTypeDeclaration> extends XtendMemberDeclarationImpl<T> implements TypeDeclaration {
	
	def getPackageName() {
		return (delegate.eContainer as XModule).getPackage
	}
	
	override getSimpleName() {
		delegate.name
	}
	
	override getQualifiedName() {
		if (packageName != null)
			packageName+'.'+simpleName
		else 
			simpleName
	}
	
	override getVisibility() {
		return compilationUnit.toVisibility(delegate.visibility)
	}
	
	override getDeclaredMembers() {
		return delegate.members.map[compilationUnit.toXtendMemberDeclaration(it)]
	}
	
	override isAssignableFrom(Type otherType) {
		if (otherType == null)
			return false;
		val thisTypeRef = compilationUnit.typeReferenceProvider.newTypeReference(this)
		val thatTypeRef = compilationUnit.typeReferenceProvider.newTypeReference(otherType)
		return thisTypeRef.isAssignableFrom(thatTypeRef);
	}
	
	override findDeclaredConstructor(TypeReference... parameterTypes) {
		declaredConstructors.findFirst[constructor | constructor.parameters.map[type].toList == parameterTypes.toList]
	}
	
	override findDeclaredField(String name) {
		declaredFields.findFirst[field | field.simpleName == name]
	}
	
	override findDeclaredMethod(String name, TypeReference... parameterTypes) {
		declaredMethods.findFirst[method | method.simpleName == name && method.parameters.map[type].toList == parameterTypes.toList]
	}
	
	override getDeclaredMethods() {
		declaredMembers.filter(MethodDeclaration)
	}
	
	override getDeclaredFields() {
		declaredMembers.filter(FieldDeclaration)
	}
	
	override getDeclaredClasses() {
		declaredMembers.filter(ClassDeclaration)
	}
	
	override getDeclaredConstructors() {
		declaredMembers.filter(ConstructorDeclaration)
	}
	
	override getDeclaredInterfaces() {
		declaredMembers.filter(InterfaceDeclaration)
	}
	
}

class XtendClassDeclarationImpl extends XtendTypeDeclarationImpl<XtendClass> implements ClassDeclaration {
	
	override getImplementedInterfaces() {
		delegate.getImplements.map[compilationUnit.toTypeReference(it)]
	}
	
	override getExtendedClass() {
		compilationUnit.toTypeReference(delegate.getExtends)
	}
	
	override isAbstract() {
		delegate.isAbstract
	}
	
	override isFinal() {
		delegate.final
	}
	
	override isStatic() {
		true
	}
	
	override isStrictFloatingPoint() {
		false	
	}
	
	override getTypeParameters() {
		delegate.typeParameters.map[compilationUnit.toXtendTypeParameterDeclaration(it)]
	}

}

class XtendInterfaceDeclarationImpl extends XtendTypeDeclarationImpl<XtendInterface> implements InterfaceDeclaration {
	
	override getExtendedInterfaces() {
		delegate.extends.map[compilationUnit.toTypeReference(it)]
	}
	
	override getTypeParameters() {
		delegate.typeParameters.map[compilationUnit.toXtendTypeParameterDeclaration(it)]
	}

	override isStrictFloatingPoint() {
		false	
	}

}

class XtendEnumerationDeclarationImpl extends XtendTypeDeclarationImpl<XtendEnum> implements EnumerationTypeDeclaration {
	
	override findDeclaredValue(String name) {
		declaredValues.findFirst[value | value.simpleName == name]
	}
	
	override getDeclaredValues() {
		declaredMembers.filter(EnumerationValueDeclaration)
	}
	
}

class XtendAnnotationTypeDeclarationImpl extends XtendTypeDeclarationImpl<XtendAnnotationType> implements AnnotationTypeDeclaration {
	
	override findDeclaredAnnotationTypeElement(String name) {
		declaredAnnotationTypeElements.findFirst[simpleName == name]
	}
	
	override getDeclaredAnnotationTypeElements() {
		delegate.members.map[compilationUnit.toXtendMemberDeclaration(it)].filter(AnnotationTypeElementDeclaration)
	}
	
}

class XtendMethodDeclarationImpl extends XtendMemberDeclarationImpl<XtendFunction> implements MethodDeclaration {
	
	override isAbstract() {
		delegate.expression == null
	}
	
	override isFinal() {
		delegate.final
	}
	
	//TODO declare in interface
	def isOverride() {
		delegate.isOverride
	}
	
	override isStatic() {
		delegate.isStatic
	}
	
	override isSynchronized() {
		false
	}

	override isDefault() {
		false
	}
	
	override isStrictFloatingPoint() {
		false	
	}
	
	override isNative() {
		false	
	}
	
	override getReturnType() {
		compilationUnit.toTypeReference(delegate.returnType)
	}

	override getVisibility() {
		compilationUnit.toVisibility(delegate.visibility)
	}
	
	override getSimpleName() {
		delegate.name
	}
	
	override getBody() {
		if (delegate.expression == null)
			return null
		return compilationUnit.toExpression(delegate.expression)
	}
	
	override isVarArgs() {
		delegate.parameters.exists[varArgs]
	}
	
	override getTypeParameters() {
		delegate.typeParameters.map[compilationUnit.toXtendTypeParameterDeclaration(it)]
	}
	
	override getExceptions() {
		delegate.exceptions.map[compilationUnit.toTypeReference(it)]
	}
	
	override getParameters() {
		delegate.parameters.map[compilationUnit.toXtendParameterDeclaration(it)]
	}
	
}

class XtendConstructorDeclarationImpl extends XtendMemberDeclarationImpl<XtendConstructor> implements ConstructorDeclaration {
	
	override getBody() {
		if (delegate.expression == null)
			return null
		return compilationUnit.toExpression(delegate.expression)
	}

	override getVisibility() {
		compilationUnit.toVisibility(delegate.visibility)
	}
	
	override getSimpleName() {
		declaringType.simpleName
	}
	
	override isVarArgs() {
		delegate.parameters.exists[varArgs]
	}
	
	override getExceptions() {
		delegate.exceptions.map[compilationUnit.toTypeReference(it)]
	}
	
	override getParameters() {
		delegate.parameters.map[compilationUnit.toXtendParameterDeclaration(it)]
	}

	override getTypeParameters() {
		emptyList
	}
	
}

class XtendParameterDeclarationImpl extends XtendAnnotationTargetImpl<XtendParameter> implements ParameterDeclaration {

	override getType() {
		compilationUnit.toTypeReference(delegate.parameterType)
	}
	
	override getSimpleName() {
		delegate.name
	}

	override getDeclaringExecutable() {
		compilationUnit.toXtendMemberDeclaration(delegate.eContainer as XtendMember) as ExecutableDeclaration
	}
	
}

class XtendFieldDeclarationImpl extends XtendMemberDeclarationImpl<XtendField> implements FieldDeclaration {
	
	override getVisibility() {
		compilationUnit.toVisibility(delegate.visibility)
	}
	
	override getSimpleName() {
		delegate.name
	}
	
	override getInitializer() {
		if (delegate.initialValue == null)
			return null
		return compilationUnit.toExpression(delegate.initialValue)
	}
	
	override isFinal() {
		delegate.isFinal
	}
	
	override isStatic() {
		delegate.isStatic
	}
	
	override isTransient() {
		return false;
	}

	override isVolatile() {
		return false;
	}
	
	override getType() {
		compilationUnit.toTypeReference(delegate.type)
	}
	
	override ClassDeclaration getDeclaringType() {
		super.getDeclaringType() as ClassDeclaration
	}
	
}

class XtendEnumerationValueDeclarationImpl extends XtendMemberDeclarationImpl<XtendEnumLiteral> implements EnumerationValueDeclaration {
	
	override getSimpleName() {
		delegate.name
	}
	
	override EnumerationTypeDeclaration getDeclaringType() {
		super.getDeclaringType() as EnumerationTypeDeclaration
	}
	
}

class XtendAnnotationTypeElementDeclarationImpl extends XtendMemberDeclarationImpl<XtendField> implements AnnotationTypeElementDeclaration {
	
	override getSimpleName() {
		delegate.name
	}
	
	override getDefaultValue() {
		if (delegate.initialValue == null)
			return null
		compilationUnit.evaluate(delegate.initialValue, delegate.type)
	}
	
	override getDefaultValueExpression() {
		if (delegate.initialValue == null)
			return null
		compilationUnit.toExpression(delegate.initialValue) 
	}
	
	override getType() {
		compilationUnit.toTypeReference(delegate.type)
	}
	
}

class XtendTypeParameterDeclarationImpl extends AbstractElementImpl<JvmTypeParameter> implements TypeParameterDeclaration {
	
	override getUpperBounds() {
		delegate.constraints.filter(JvmUpperBound).map[compilationUnit.toTypeReference(typeReference)].toList
	}
	
	override getSimpleName() {
		delegate.name
	}
	
	override getQualifiedName() {
		simpleName
	}
	
	override getTypeParameterDeclarator() {
		val eContainer = delegate.eContainer
		compilationUnit.toXtendMemberDeclaration(eContainer as XtendMember) as TypeParameterDeclarator
	}
	
	override getAnnotations() {
		emptyList
	}
	
	override findAnnotation(Type annotationType) {
		null
	}
	
	override isAssignableFrom(Type otherType) {
		if (otherType == null)
			return false;
		val thisTypeRef = compilationUnit.typeReferenceProvider.newTypeReference(this)
		val thatTypeRef = compilationUnit.typeReferenceProvider.newTypeReference(otherType)
		return thisTypeRef.isAssignableFrom(thatTypeRef);
	}
	
}

class XtendAnnotationReferenceImpl extends AbstractElementImpl<XAnnotation> implements AnnotationReference {
	
	override getAnnotationTypeDeclaration() {
		switch type: getAnnotationType() {
			JvmAnnotationType: compilationUnit.toTypeDeclaration(type) as AnnotationTypeDeclaration
			default: null
		}
	}
	
	def getAnnotationType() {
		if (!compilationUnit.indexing) {
			return delegate.annotationType	
		}
		switch proxy : delegate.eGet(XANNOTATION__ANNOTATION_TYPE, false) {
			EObject case proxy.eIsProxy: {
				val uri = (proxy as InternalEObject).eProxyURI
				return delegate.eResource.resourceSet.getEObject(uri, true) as JvmType
			}
			JvmType: {
				proxy
			}
		}
	}
	
	override getExpression(String property) {
		if (property == 'value' && delegate.value != null) {
			return compilationUnit.toExpression(delegate.value)
		}
		val expression = delegate.elementValuePairs.findFirst[element.simpleName == property]?.value
		if (expression != null)
			return compilationUnit.toExpression(expression)
		return null
	}
	
	override getValue(String property) {
		if (property == 'value' && delegate.value != null) {
			return compilationUnit.evaluate(delegate.value, null)
		}
		val annoValue = delegate.elementValuePairs.findFirst[element.simpleName == property]
		val expression = annoValue?.value
		if (expression != null)
			return compilationUnit.evaluate(expression, annoValue.element?.returnType)
		return annotationTypeDeclaration.findDeclaredAnnotationTypeElement(property).defaultValue
	}
	
		override getAnnotationValue(String name) {
		getValue(name) as AnnotationReference
	}
	
	override getAnnotationArrayValue(String name) {
		getValue(name) as AnnotationReference[]
	}
	
	override getBooleanArrayValue(String name) {
		getValue(name) as boolean[]
	}
	
	override getBooleanValue(String name) {
		getValue(name) as Boolean
	}
	
	override getByteArrayValue(String name) {
		getValue(name) as byte[]
	}
	
	override getByteValue(String name) {
		getValue(name) as Byte
	}
	
	override getCharArrayValue(String name) {
		getValue(name) as char[]
	}
	
	override getCharValue(String name) {
		getValue(name) as Character
	}
	
	override getClassValue(String name) {
		getValue(name) as TypeReference
	}
	
	override getClassArrayValue(String name) {
		getValue(name) as TypeReference[]
	}
	
	override getDoubleArrayValue(String name) {
		getValue(name) as double[]
	}
	
	override getDoubleValue(String name) {
		getValue(name) as Double
	}
	
	override getEnumValue(String name) {
		getValue(name) as EnumerationValueDeclaration
	}
	
	override getEnumArrayValue(String name) {
		getValue(name) as EnumerationValueDeclaration[]
	}
	
	override getFloatArrayValue(String name) {
		getValue(name) as float[]
	}
	
	override getFloatValue(String name) {
		getValue(name) as Float
	}
	
	override getIntArrayValue(String name) {
		getValue(name) as int[]
	}
	
	override getIntValue(String name) {
		getValue(name) as Integer
	}
	
	override getLongArrayValue(String name) {
		getValue(name) as long[]
	}
	
	override getLongValue(String name) {
		getValue(name) as Long
	}
	
	override getShortArrayValue(String name) {
		getValue(name) as short[]
	}
	
	override getShortValue(String name) {
		getValue(name) as Short
	}
	
	override getStringArrayValue(String name) {
		getValue(name) as String[]
	}
	
	override getStringValue(String name) {
		getValue(name) as String
	}
	
}