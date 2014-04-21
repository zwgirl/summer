package org.summer.ss.ide.codebuilder

import com.google.inject.Inject
import org.summer.ss.core.jvmmodel.IXtendJvmAssociations
import org.summer.dsl.model.ss.XtendClass
import org.summer.dsl.model.types.JvmConstructor
import org.summer.dsl.model.types.JvmDeclaredType
import org.summer.dsl.model.types.JvmExecutable
import org.summer.dsl.model.types.JvmGenericType
import org.summer.dsl.model.types.JvmLowerBound
import org.summer.dsl.model.types.JvmOperation
import org.summer.dsl.model.types.JvmUpperBound
import org.summer.dsl.model.types.TypesFactory
import org.summer.dsl.model.types.util.AnnotationLookup
import org.summer.dsl.xbase.compiler.ISourceAppender
import org.summer.dsl.xbase.lib.Extension
import org.summer.dsl.xbase.typesystem.legacy.StandardTypeReferenceOwner
import org.summer.dsl.xbase.typesystem.references.ParameterizedTypeReference
import org.summer.dsl.xbase.typesystem.util.CommonTypeComputationServices
import org.summer.dsl.xbase.typesystem.util.DeclaratorTypeArgumentCollector
import org.summer.dsl.xbase.typesystem.util.StandardTypeParameterSubstitutor

class MemberFromSuperImplementor {
	
	@Inject IXtendJvmAssociations associations

	@Inject CodeBuilderFactory codeBuilderFactory

	@Inject AnnotationLookup annotationLookup 

	@Inject extension TypesFactory typesFactory

	@Inject CommonTypeComputationServices services

	def void appendOverrideFunction(XtendClass overrider, JvmOperation overriddenOperation, ISourceAppender appendable) {
		val inferredType = associations.getInferredType(overrider)
		val methodBuilder = codeBuilderFactory.createMethodBuilder(inferredType)
		val substitutor = createSubstitutor(inferredType)
		initializeExecutableBuilder(methodBuilder, inferredType, overriddenOperation, substitutor)
		methodBuilder.overrideFlag = true
		methodBuilder.methodName = overriddenOperation.simpleName
		methodBuilder.returnType = substitutor.substitute(overriddenOperation.returnType)
		if(!overriddenOperation.typeParameters.empty) {
			val typeParameters = newArrayList
			typeParameters.addAll(
				overriddenOperation.typeParameters.map [
					val typeParameter = createJvmTypeParameter
					typeParameter.name = name
					for(constraint: constraints) {
						if(constraint instanceof JvmUpperBound) {
							val upperBound = createJvmUpperBound
							upperBound.typeReference = substitutor.substitute(constraint.typeReference).toTypeReference
							typeParameter.constraints += upperBound
						} else if(constraint instanceof JvmLowerBound) {
							val upperBound = createJvmLowerBound
							upperBound.typeReference = substitutor.substitute(constraint.typeReference).toTypeReference
							typeParameter.constraints += upperBound
						}
					}
					typeParameter
				])
			methodBuilder.typeParameters = typeParameters
		}
		if(!overriddenOperation.abstract)
			methodBuilder.body = '''super.�
				FOR typeParam: overriddenOperation.typeParameters BEFORE '<' SEPARATOR ',' AFTER '>'��
					typeParam.simpleName��
				ENDFOR
				��overriddenOperation.simpleName�(�overriddenOperation.parameters.map[simpleName].join(', ')�)'''
		if(methodBuilder.isValid)
			methodBuilder.build(appendable)
	}

	def void appendConstructorFromSuper(XtendClass overrider, JvmConstructor superConstructor, ISourceAppender appendable) {
		val inferredType = associations.getInferredType(overrider)
		val constructorBuilder = codeBuilderFactory.createConstructorBuilder(inferredType)
		val substitutor = createSubstitutor(inferredType)
		initializeExecutableBuilder(constructorBuilder, inferredType, superConstructor, substitutor)
		constructorBuilder.body = if(superConstructor.parameters.empty) 
				'' 
			else 
				'''super(�superConstructor.parameters.map[simpleName].join(', ')�)'''
		if(constructorBuilder.isValid)
			constructorBuilder.build(appendable)
	}
	
	protected def initializeExecutableBuilder(AbstractExecutableBuilder builder, JvmDeclaredType overrider, JvmExecutable overridden, StandardTypeParameterSubstitutor substitutor) {
		builder.context = overrider
		builder.visibility = overridden.visibility
		overridden.parameters.forEach [it, index |
			val parameterBuilder = builder.newParameterBuilder
			parameterBuilder.name = simpleName
			parameterBuilder.type = substitutor.substitute(overridden.parameters.get(index).parameterType)
			parameterBuilder.extensionFlag = annotationLookup.findAnnotation(it, Extension) != null
		]
		builder.varArgsFlag = overridden.varArgs
		builder.exceptions = overridden.exceptions.map[substitutor.substitute(it)]
	}
	
	protected def createSubstitutor(JvmDeclaredType jvmOverrider) {
		val owner = new StandardTypeReferenceOwner(services, jvmOverrider)
		val lightweightOverrider = new ParameterizedTypeReference(owner, jvmOverrider)
		if(jvmOverrider instanceof JvmGenericType) {
			(jvmOverrider as JvmGenericType).typeParameters.forEach[
				lightweightOverrider.addTypeArgument(new ParameterizedTypeReference(owner, it))
			]
		}
		val parameterMapping = new DeclaratorTypeArgumentCollector().getTypeParameterMapping(lightweightOverrider)
		new StandardTypeParameterSubstitutor(parameterMapping, owner)
	}
}
