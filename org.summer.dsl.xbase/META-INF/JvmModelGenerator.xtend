/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.summer.dsl.xbase.compiler

import com.google.inject.Inject
import java.util.List
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.emf.ecore.util.EcoreUtil
import org.eclipse.xtend2.lib.StringConcatenation
import org.eclipse.xtext.EcoreUtil2
import org.summer.dsl.model.types.JvmAnnotationAnnotationValue
import org.summer.dsl.model.types.JvmAnnotationReference
import org.summer.dsl.model.types.JvmAnnotationType
import org.summer.dsl.model.types.JvmAnnotationValue
import org.summer.dsl.model.types.JvmBooleanAnnotationValue
import org.summer.dsl.model.types.JvmByteAnnotationValue
import org.summer.dsl.model.types.JvmCharAnnotationValue
import org.summer.dsl.model.types.JvmConstructor
import org.summer.dsl.model.types.JvmCustomAnnotationValue
import org.summer.dsl.model.types.JvmDeclaredType
import org.summer.dsl.model.types.JvmDoubleAnnotationValue
import org.summer.dsl.model.types.JvmEnumAnnotationValue
import org.summer.dsl.model.types.JvmEnumerationLiteral
import org.summer.dsl.model.types.JvmEnumerationType
import org.summer.dsl.model.types.JvmExecutable
import org.summer.dsl.model.types.JvmField
import org.summer.dsl.model.types.JvmFloatAnnotationValue
import org.summer.dsl.model.types.JvmFormalParameter
import org.summer.dsl.model.types.JvmGenericArrayTypeReference
import org.summer.dsl.model.types.JvmGenericType
import org.summer.dsl.model.types.JvmIdentifiableElement
import org.summer.dsl.model.types.JvmIntAnnotationValue
import org.summer.dsl.model.types.JvmLongAnnotationValue
import org.summer.dsl.model.types.JvmMember
import org.summer.dsl.model.types.JvmOperation
import org.summer.dsl.model.types.JvmShortAnnotationValue
import org.summer.dsl.model.types.JvmStringAnnotationValue
import org.summer.dsl.model.types.JvmType
import org.summer.dsl.model.types.JvmTypeAnnotationValue
import org.summer.dsl.model.types.JvmTypeParameter
import org.summer.dsl.model.types.JvmTypeParameterDeclarator
import org.summer.dsl.model.types.JvmTypeReference
import org.summer.dsl.model.types.JvmUpperBound
import org.summer.dsl.model.types.JvmVisibility
import org.summer.dsl.model.types.JvmVoid
import org.summer.dsl.model.types.util.TypeReferences
import org.eclipse.xtext.documentation.IEObjectDocumentationProvider
import org.eclipse.xtext.documentation.IEObjectDocumentationProviderExtension
import org.eclipse.xtext.documentation.IFileHeaderProvider
import org.eclipse.xtext.documentation.IJavaDocTypeReferenceProvider
import org.eclipse.xtext.generator.IFileSystemAccess
import org.eclipse.xtext.generator.IGenerator
import org.eclipse.xtext.generator.trace.ITraceURIConverter
import org.eclipse.xtext.generator.trace.LocationData
import org.eclipse.xtext.naming.IQualifiedNameConverter
import org.eclipse.xtext.nodemodel.INode
import org.eclipse.xtext.nodemodel.util.NodeModelUtils
import org.eclipse.xtext.resource.ILocationInFileProvider
import org.eclipse.xtext.scoping.IScopeProvider
import org.eclipse.xtext.util.ITextRegionWithLineInformation
import org.eclipse.xtext.util.Strings
import org.eclipse.xtext.validation.Issue
import org.summer.dsl.model.xbase.XBlockExpression
import org.summer.dsl.model.xbase.XExpression
import org.summer.dsl.xbase.compiler.output.ITreeAppendable
import org.summer.dsl.xbase.compiler.output.ImportingStringConcatenation
import org.summer.dsl.xbase.compiler.output.TreeAppendable
import org.summer.dsl.xbase.jvmmodel.IJvmModelAssociations
import org.summer.dsl.xbase.jvmmodel.IJvmModelInferrer
import org.summer.dsl.xbase.jvmmodel.ILogicalContainerProvider
import org.summer.dsl.xbase.jvmmodel.JvmTypeExtensions
import org.summer.dsl.xbase.typesystem.legacy.StandardTypeReferenceOwner
import org.summer.dsl.xbase.typesystem.util.CommonTypeComputationServices

import static org.summer.dsl.model.types.TypesPackage.Literals.*

/**
 * A generator implementation that processes the 
 * derived {@link IJvmModelInferrer JVM model}
 * and produces the respective java code.
 */
class JvmModelGenerator implements IGenerator {

	@Inject extension ILogicalContainerProvider
	@Inject extension TypeReferences 
	@Inject extension TreeAppendableUtil
	@Inject extension JvmTypeExtensions
	@Inject extension LoopExtensions
	@Inject extension ErrorSafeExtensions
	
	@Inject CommonTypeComputationServices commonServices
	@Inject XbaseCompiler compiler
	@Inject ILocationInFileProvider locationProvider
	@Inject IEObjectDocumentationProvider documentationProvider
	@Inject IFileHeaderProvider fileHeaderProvider
	@Inject IJvmModelAssociations jvmModelAssociations
	@Inject JavaKeywords keywords
	@Inject IGeneratorConfigProvider generatorConfigProvider
	@Inject ITraceURIConverter converter
	@Inject IJavaDocTypeReferenceProvider javaDocTypeReferenceProvider
	@Inject IScopeProvider scopeProvider
	@Inject IQualifiedNameConverter qualifiedNameConverter
	
	override void doGenerate(Resource input, IFileSystemAccess fsa) {
		for (obj : input.contents) {
			obj.internalDoGenerate(fsa)
		}
	}
	
	def dispatch void internalDoGenerate(EObject obj, IFileSystemAccess fsa) {}
	
	def dispatch void internalDoGenerate(JvmDeclaredType type, IFileSystemAccess fsa) {
		if (DisableCodeGenerationAdapter.isDisabled(type))
			return;
		if(type.qualifiedName != null)
			fsa.generateFile(type.qualifiedName.replace('.', '/') + '.js', type.generateType(generatorConfigProvider.get(type)))
	}
	
//	def CharSequence generateType(JvmDeclaredType type, GeneratorConfig config) {
//		val importManager = new ImportManager(true, type)
//		val bodyAppendable = createAppendable(type, importManager, config)
//		generateBody(type, bodyAppendable, config)
//		val importAppendable = createAppendable(type, importManager, config)
//        generateFileHeader(type, importAppendable, config)
//		if (type.packageName != null) {
//			importAppendable.append("package ").append(type.packageName).append(";");
//			importAppendable.newLine.newLine
//		}
//		for(i: importManager.imports) {
//			importAppendable.append("import ").append(i).append(";").newLine
//		}
//		if (!importManager.imports.empty)
//			importAppendable.newLine
//		importAppendable.append(bodyAppendable)
//		return importAppendable
//	}

	def CharSequence generateType(JvmDeclaredType type, GeneratorConfig config) {
		val importManager = new ImportManager(true, type)
		val bodyAppendable = createAppendable(type, importManager, config)
		generateBody(type, bodyAppendable, config)
		val importAppendable = createAppendable(type, importManager, config)
        generateFileHeader(type, importAppendable, config)
		if (type.packageName != null) {
			importAppendable.append("define(['dojo/_base/declare', 'system/Type' ");
			importAppendable.newLine.newLine
		}
		for(i: importManager.imports) {
			importAppendable.append(',')
			importAppendable.append(" ").append(i).append("").newLine
		}
		
		
		importAppendable.append("], function(declare, Type");
		
		for(i: importManager.imports) {
			importAppendable.append(',')
			importAppendable.append(" ").append(i).append("").newLine
		}
		
		importAppendable.append(') {')
		
		if (!importManager.imports.empty)
			importAppendable.newLine
		importAppendable.append(bodyAppendable)
		return importAppendable
	}
	
//	define(["dojo/_base/declare", "system/Type", "markup/MarkupExtension"], 
//		function(declare, Type, MarkupExtension){
	
	
//	def dispatch ITreeAppendable generateBody(JvmGenericType it, ITreeAppendable appendable, GeneratorConfig config) {
//		generateJavaDoc(appendable, config)
//		val childAppendable = appendable.trace(it)
//		if(config.generateSyntheticSuppressWarnings)
//			generateAnnotationsWithSyntheticSuppressWarnings(childAppendable, config)
//		else
//			annotations.generateAnnotations(childAppendable, true, config)
//		generateModifier(childAppendable, config)
//		if (isInterface) {
//			childAppendable.append("interface ")
//		} else {
//			childAppendable.append("class ")
//		}
//		childAppendable.traceSignificant(it).append(simpleName)
//		generateTypeParameterDeclaration(childAppendable, config)
//		if (typeParameters.empty)
//			childAppendable.append(" ")
//		generateExtendsClause(childAppendable, config)
//		childAppendable.append('{').increaseIndentation
//		childAppendable.forEach(membersToBeCompiled, [
//				separator = [ITreeAppendable it | newLine]
//			], [
//				val memberAppendable = childAppendable.traceWithComments(it)
//				memberAppendable.openScope
//				generateMember(memberAppendable, config)
//				memberAppendable.closeScope
//			])
//		childAppendable.decreaseIndentation.newLine.append('}')
//		appendable.newLine
//	}

//		var DataTrigger = declare("DataTrigger", TriggerBase,{
//			
//		}

	def dispatch ITreeAppendable generateBody(JvmGenericType it, ITreeAppendable appendable, GeneratorConfig config) {
		generateJavaDoc(appendable, config)
		val childAppendable = appendable.trace(it)
//		if(config.generateSyntheticSuppressWarnings)
//			generateAnnotationsWithSyntheticSuppressWarnings(childAppendable, config)
//		else
//			annotations.generateAnnotations(childAppendable, true, config)
//		generateModifier(childAppendable, config)
//		if (isInterface) {
//			childAppendable.append("interface ")
//		} else {
//			childAppendable.append("class ")
//		}
		
		childAppendable.append('var ').append(simpleName).append(' = declare(null, )');
		

//		childAppendable.traceSignificant(it).append(simpleName)
//		generateTypeParameterDeclaration(childAppendable, config)
//		if (typeParameters.empty)
//			childAppendable.append(" ")
//		generateExtendsClause(childAppendable, config)
		childAppendable.append('{').increaseIndentation
		childAppendable.forEach(membersToBeCompiled, [
				separator = [ITreeAppendable it | newLine]
			], [
				val memberAppendable = childAppendable.traceWithComments(it)
				memberAppendable.openScope
				generateMember(memberAppendable, config)
				memberAppendable.closeScope
			])
		childAppendable.newLine.append('}')
		appendable.newLine
	}
	
	def generateAnnotationsWithSyntheticSuppressWarnings(JvmDeclaredType it, ITreeAppendable appendable, GeneratorConfig config) {
		val noSuppressWarningsFilter = [JvmAnnotationReference it | annotation?.identifier != SuppressWarnings.name]
		annotations.filter(noSuppressWarningsFilter).generateAnnotations(appendable, true, config)
		appendable.append('''@SuppressWarnings("all")''').newLine
	}

	def dispatch ITreeAppendable generateBody(JvmEnumerationType it, ITreeAppendable appendable, GeneratorConfig config) {
		generateJavaDoc(appendable, config)
		val childAppendable = appendable.trace(it)
		if(config.generateSyntheticSuppressWarnings)
			generateAnnotationsWithSyntheticSuppressWarnings(childAppendable, config)
		else
			annotations.generateAnnotations(childAppendable, true, config)
		generateModifier(childAppendable, config)
		childAppendable.append("enum ")
		childAppendable.traceSignificant(it).append(simpleName)
		childAppendable.append(" ")
		generateExtendsClause(childAppendable, config)
		childAppendable.append("{").increaseIndentation
		childAppendable.forEach(literals, [
				separator = [ITreeAppendable it | append(',').newLine]  suffix = ';'
			], [
				generateEnumLiteral(childAppendable.trace(it), config)
			])
		childAppendable.forEach(membersToBeCompiled.filter[!(it instanceof JvmEnumerationLiteral)], [
				separator = [ITreeAppendable it | newLine]
			], [ 
				generateMember(childAppendable.trace(it), config)
			])
		childAppendable.decreaseIndentation.newLine.append("}")
		appendable.newLine
	}
	
	def void generateEnumLiteral(JvmEnumerationLiteral it, ITreeAppendable appendable, GeneratorConfig config) {
		appendable.newLine
		generateJavaDoc(appendable, config)
		annotations.generateAnnotations(appendable, true, config)
		appendable.append(simpleName)
		// TODO: constructor args
	}
	
	def dispatch ITreeAppendable generateBody(JvmAnnotationType it, ITreeAppendable appendable, GeneratorConfig config) {
		generateJavaDoc(appendable, config)
		val childAppendable = appendable.trace(it)
		annotations.generateAnnotations(childAppendable, true, config)
		generateModifier(childAppendable, config)
		childAppendable.append("@interface ")
		childAppendable.traceSignificant(it).append(simpleName)
		childAppendable.append(" {")
		for (operation : membersToBeCompiled.filter(JvmOperation)) {
			generateAnnotationMethod(operation, childAppendable, config)
		}
		childAppendable.newLine.append("}")
		appendable.newLine
	}
	
	def generateAnnotationMethod(JvmOperation it, ITreeAppendable appendable, GeneratorConfig config) {
		appendable.increaseIndentation.newLine
		appendable.openScope
		generateJavaDoc(appendable, config)
		val tracedAppendable = appendable.trace(it)
		annotations.generateAnnotations(tracedAppendable, true, config)
		generateModifier(tracedAppendable, config)
		returnType.serializeSafely("Object", tracedAppendable)
		tracedAppendable.append(" ")
		if(it.static){
			tracedAppendable.traceSignificant(it).append(simpleName)	
		}else{
			tracedAppendable.traceSignificant(it).append(simpleName).append(":function")
		}

		tracedAppendable.append("()")
		generateDefaultExpression(tracedAppendable, config)
		tracedAppendable.append(";")
		appendable.decreaseIndentation
		appendable.closeScope
	}

	def void generateDefaultExpression(JvmOperation it, ITreeAppendable appendable, GeneratorConfig config) {
		if (compilationStrategy != null) {
			appendable.append(" default ")
			appendable.increaseIndentation
			compilationStrategy.apply(appendable)
			appendable.decreaseIndentation
		} else if (compilationTemplate != null) {
			appendable.append(" default ").increaseIndentation
			appendCompilationTemplate(appendable, it)
			appendable.decreaseIndentation
		} else if (config.generateExpressions) {
			val body = associatedExpression
			if(body != null) {
				if(body.hasErrors()) {
					appendable.append("/* skipped default expression with errors */")
				} else {
					appendable.append(" default ")
					compiler.compileAsJavaExpression(body, appendable, returnType)
				}
			} else if (defaultValue != null) {
				if(defaultValue.hasErrors()) {
					appendable.append("/* skipped default expression with errors */")
				} else {
					appendable.append(" default ")
					defaultValue.toJavaLiteral(appendable, config)
				}
			}
		}
	}
	
	private def void appendCompilationTemplate(ITreeAppendable appendable, JvmIdentifiableElement it) {
		switch appendable {
			TreeAppendable: {
				val target = new ImportingStringConcatenation(appendable.state, new StandardTypeReferenceOwner(commonServices, it));
				target.append(compilationTemplate)
				appendable.append(target)			
			} 
		default: {
			throw new IllegalStateException("unexpected appendable: " + appendable.getClass.name)
		}
		
		}
	}
	
	def dispatch generateModifier(JvmGenericType it, ITreeAppendable appendable, GeneratorConfig config) {
		appendable.append(visibility.javaName)
		if (isAbstract)
			appendable.append("abstract ")
		if (isStatic)
			appendable.append("static ")
		if (isFinal)
			appendable.append("final ")
		if (isStrictFloatingPoint)
			appendable.append("strictfp ")
	}
	
	def dispatch generateModifier(JvmDeclaredType it, ITreeAppendable appendable, GeneratorConfig config) {
		appendable.append(visibility.javaName)
	}
	
	def dispatch generateModifier(JvmField it, ITreeAppendable appendable, GeneratorConfig config) {
		appendable.append(visibility.javaName)
		if (isFinal)
			appendable.append("final ")
		if (isStatic)
			appendable.append("static ")
		if (isTransient)
			appendable.append("transient ")
		if (isVolatile)
			appendable.append("volatile ")
	}
		
	def dispatch generateModifier(JvmOperation it, ITreeAppendable appendable, GeneratorConfig config) {
		appendable.append(visibility.javaName)
		if (isAbstract)
			appendable.append("abstract ")
		if (isStatic)
			appendable.append("static ")
		if (isFinal)
			appendable.append("final ")
		if (isSynchronized)
			appendable.append("synchronized ")
		if (isStrictFloatingPoint)
			appendable.append("strictfp ")
		if (isNative)
			appendable.append("native ")
	}
	
	def dispatch generateModifier(JvmConstructor it, ITreeAppendable appendable, GeneratorConfig config) {
		appendable.append(visibility.javaName)
	}
	
	/**
	 * Returns the visibility modifier and a space as suffix if not empty
	 */
	def javaName(JvmVisibility visibility) {
		if (visibility != null)
			return switch visibility {
					case JvmVisibility.PRIVATE : 'private '
					case JvmVisibility.PUBLIC : 'public '
//					case JvmVisibility.PROTECTED : 'protected '  //cym comment
//					case JvmVisibility.DEFAULT : '' //cym comment
				}
		else 
			return ''
	}
		
	def void generateExtendsClause(JvmDeclaredType it, ITreeAppendable appendable, GeneratorConfig config) {
//		val implicitSuperType = switch it {
//			JvmAnnotationType: 'java.lang.Annotation'
//			JvmEnumerationType: '''java.lang.Enum<�identifier�>'''.toString
//			default: 'java.lang.Object'
//		} 
//		if (it instanceof JvmAnnotationType || (it instanceof JvmGenericType && (it as JvmGenericType).isInterface)) {
//			val withoutObject = superTypes.filter [ typeRef | typeRef.identifier != implicitSuperType ]
//			appendable.forEachSafely(withoutObject, [
//					prefix = 'extends '	separator =  ', ' suffix =  ' '
//				], [
//					it, app | serializeSafely(app)
//				])
//		} else {
//			val withoutObject = superTypes.filter [ typeRef | typeRef.identifier != implicitSuperType ]
//			val superClazz = withoutObject.filter(typeRef | typeRef.type instanceof JvmGenericType && !(typeRef.type as JvmGenericType).isInterface).head
//			val superInterfaces = withoutObject.filter(typeRef | typeRef != superClazz)
//			if (superClazz != null) {
//				val hasErrors = superClazz.hasErrors()
//				if(hasErrors) 
//					appendable.append('/* ')
//				try {
//					appendable.append('extends ')
//					superClazz.serializeSafely(appendable)
//					appendable.append(' ')
//				} catch (Exception ignoreMe) {}
//				if(hasErrors) 
//					appendable.append(' */')
//			} 
//			appendable.forEachSafely(superInterfaces, [
//					prefix = 'implements ' separator = ', ' suffix = ' '
//				], [
//					it, app | serializeSafely(app)
//				])
//		}
	}
	
	def dispatch ITreeAppendable generateMember(JvmMember it, ITreeAppendable appendable, GeneratorConfig config) {
		throw new UnsupportedOperationException("generateMember not implemented for elements of type "
			+ it?.^class?.name
		)
	}
	
	def dispatch generateMember(JvmGenericType it, ITreeAppendable appendable, GeneratorConfig config) {
		appendable.newLine
		generateBody(it, appendable, config)
	}
	
	def dispatch generateMember(JvmField it, ITreeAppendable appendable, GeneratorConfig config) {
		appendable.newLine
		generateJavaDoc(appendable, config)
		val tracedAppendable = appendable.trace(it)
		annotations.generateAnnotations(tracedAppendable, true, config)
		generateModifier(tracedAppendable, config)
		type.serializeSafely("Object", tracedAppendable)
		tracedAppendable.append(" ")
		tracedAppendable.traceSignificant(it).append(simpleName)
		generateInitialization(tracedAppendable, config)
		tracedAppendable.append(";")
	}
	
	def dispatch generateMember(JvmOperation it, ITreeAppendable appendable, GeneratorConfig config) {
		appendable.newLine
		appendable.openScope
		generateJavaDoc(appendable, config)
		val tracedAppendable = appendable.trace(it)
		annotations.generateAnnotations(tracedAppendable, true, config)
//		generateModifier(tracedAppendable, config)
//		generateTypeParameterDeclaration(tracedAppendable, config)
//		if (returnType == null) {
//			tracedAppendable.append("void")
//		} else {
//			returnType.serializeSafely("Object", tracedAppendable)
//		}
		tracedAppendable.append(" ")
		if(it.static){
			tracedAppendable.traceSignificant(it).append(" function ").append(simpleName)	
		}else{
			tracedAppendable.traceSignificant(it).append(simpleName).append(":function")
		}
		tracedAppendable.append("(")
		generateParameters(tracedAppendable, config)
		tracedAppendable.append(")")
		generateThrowsClause(tracedAppendable, config)
		if (isAbstract || !hasBody) {
			tracedAppendable.append(";")
		} else {
			tracedAppendable.append(" ")
			generateExecutableBody(tracedAppendable, config)
		}
		appendable.closeScope
		appendable
	}
	
//	def dispatch generateMember(JvmConstructor it, ITreeAppendable appendable, GeneratorConfig config) {
//		appendable.newLine
//		appendable.openScope
//		generateJavaDoc(appendable, config)
//		val tracedAppendable = appendable.trace(it)
//		annotations.generateAnnotations(tracedAppendable, true, config)
//		generateModifier(tracedAppendable, config)
//		generateTypeParameterDeclaration(tracedAppendable, config)
//		tracedAppendable.traceSignificant(it).append(simpleName)
//		tracedAppendable.append("(")
//		generateParameters(tracedAppendable, config)
//		tracedAppendable.append(")")
//		generateThrowsClause(tracedAppendable, config)
//		tracedAppendable.append(" ")
//		generateExecutableBody(tracedAppendable, config)
//		appendable.closeScope
//		appendable
//	}

	def dispatch generateMember(JvmConstructor it, ITreeAppendable appendable, GeneratorConfig config) {
		appendable.newLine
		appendable.openScope
		generateJavaDoc(appendable, config)
		val tracedAppendable = appendable.trace(it)
//		annotations.generateAnnotations(tracedAppendable, true, config)
//		generateModifier(tracedAppendable, config)
//		generateTypeParameterDeclaration(tracedAppendable, config)
		tracedAppendable.traceSignificant(it).append("constructor")
		tracedAppendable.append(":function(")
		generateParameters(tracedAppendable, config)
		tracedAppendable.append(")")
//		generateThrowsClause(tracedAppendable, config)
		tracedAppendable.append(" ")
		generateExecutableBody(tracedAppendable, config)
		appendable.closeScope
		appendable
	}
	
	def void generateInitialization(JvmField it, ITreeAppendable appendable, GeneratorConfig config) {
		if (compilationStrategy != null) {
			appendable.append(" = ")
			appendable.increaseIndentation
			compilationStrategy.apply(appendable)
			appendable.decreaseIndentation
		} else if (compilationTemplate != null) {
			appendable.append(" = ").increaseIndentation
			appendCompilationTemplate(appendable, it)
			appendable.decreaseIndentation
		} else {
			val expression = associatedExpression
			if (expression != null && config.generateExpressions) {
				if(expression.hasErrors()) {
					appendable.append(" /* Skipped initializer because of errors */")
				} else {
					appendable.append(" = ")
					compiler.compileAsJavaExpression(expression, appendable, type)
				}
			}
		}
	}
		
	def void generateTypeParameterDeclaration(JvmTypeParameterDeclarator it, ITreeAppendable appendable, GeneratorConfig config) {
		appendable.forEach(typeParameters, [
				prefix = '<' separator = ', ' suffix = '> '
			], [
				it| generateTypeParameterDeclaration(appendable, config)
			])
	}
	
	def void generateTypeParameterDeclaration(JvmTypeParameter it, ITreeAppendable appendable, GeneratorConfig config) {
		val tracedAppendable = appendable.trace(it)
		tracedAppendable.traceSignificant(it).append(name)
		generateTypeParameterConstraints(tracedAppendable, config)
	}
	
	def void generateTypeParameterConstraints(JvmTypeParameter it, ITreeAppendable appendable, GeneratorConfig config) {
		val upperBounds = constraints.filter(JvmUpperBound)
		appendable.forEachSafely(upperBounds, [
				prefix = ' extends ' separator = ' & '
			], [
				it, app | typeReference.serializeSafely(app)
			])
	}
	
	def void generateThrowsClause(JvmExecutable it, ITreeAppendable appendable, GeneratorConfig config) {
		val toBeGenerated = <JvmType, JvmTypeReference> newLinkedHashMap
		exceptions.forEach[if(!toBeGenerated.containsKey(type)) toBeGenerated.put(type, it)]
		appendable.forEachSafely(toBeGenerated.values, [
				prefix = ' throws ' separator = ', '
			], [
				it, app |  app.trace(it).append(it.type)
			])
	}
	
	def void generateParameters(JvmExecutable it, ITreeAppendable appendable, GeneratorConfig config) {
		if (!parameters.isEmpty) {
			for (i : 0 .. parameters.size - 1) {
				val last = i + 1 == parameters.size
				val p = parameters.get(i)
				p.generateParameter(appendable, last && it.varArgs, config)
				if (!last)
					appendable.append(", ")
			}
		}
	}
	
	def void generateParameter(JvmFormalParameter it, ITreeAppendable appendable, boolean vararg, GeneratorConfig config) {
//		val tracedAppendable = appendable.trace(it)
//		annotations.generateAnnotations(tracedAppendable, false, config)
//		appendable.append("final ")
//		if (vararg) {
//			if (! (parameterType instanceof JvmGenericArrayTypeReference)) {
//				appendable.append("/* Internal Error: Parameter was vararg but not an array type. */");
//			} else {
//				(parameterType as JvmGenericArrayTypeReference).componentType.serializeSafely("Object", appendable)
//			}
//			appendable.append("...")
//		} else {
//			parameterType.serializeSafely("Object", appendable)
//		}
		appendable.append(" ")
		val name = appendable.declareVariable(it, makeJavaIdentifier(simpleName))
		appendable.traceSignificant(it).append(name)
	}
	
	def hasBody(JvmExecutable it) {
		compilationTemplate != null || compilationStrategy != null || associatedExpression != null
	}

	def void generateExecutableBody(JvmExecutable op, ITreeAppendable appendable, GeneratorConfig config) {
		if (op.compilationStrategy != null) {
			val errors = op.errors
			if(errors.empty) {
				appendable.increaseIndentation.append("{").newLine
				op.compilationStrategy.apply(appendable)
				appendable.decreaseIndentation.newLine.append("}")
			} else {
				generateBodyWithIssues(appendable, errors)
			}
		} else if (op.compilationTemplate != null) {
			val errors = op.errors
			if(errors.empty) {
				appendable.increaseIndentation.append("{").newLine
				appendCompilationTemplate(appendable, op)
				appendable.decreaseIndentation.newLine.append("}")
			} else {
				generateBodyWithIssues(appendable, errors)
			}
		} else {
			val expression = op.getAssociatedExpression
			if (expression != null && config.generateExpressions) {
				val errors = expression.errors
				if(errors.empty) {
					val returnType = switch(op) { 
						JvmOperation: op.returnType
						JvmConstructor: Void.TYPE.getTypeForName(op) 
						default: null
					}
					if (expression instanceof XBlockExpression && (expression as XBlockExpression).expressions.size != 1 && returnType instanceof JvmVoid) {
						val block = expression as XBlockExpression
						if (block.expressions.isEmpty()) {
							appendable.append("{}")		
						} else {
							compiler.compile(expression, appendable, returnType, op.exceptions.toSet)
						}
					} else {
						appendable.append("{").increaseIndentation
						compiler.compile(expression, appendable, returnType, op.exceptions.toSet)
						appendable.decreaseIndentation.newLine.append("}")
					}
				} else {
					generateBodyWithIssues(appendable, errors)	
				}
			} else if(op instanceof JvmOperation) {
				appendable.increaseIndentation.append("{").newLine
				appendable.append('throw new UnsupportedOperationException("')
				appendable.append(op.simpleName)
				appendable.append(' is not implemented");')
				appendable.decreaseIndentation.newLine.append("}")
			} else if (op instanceof JvmConstructor) {
				appendable.append("{").newLine.append("}")
			}
		}
	}

	def generateBodyWithIssues(ITreeAppendable appendable, Iterable<Issue> errors) {
		appendable.append('{').increaseIndentation.newLine
			.append('throw new Error("Unresolved compilation problems:"')
		appendable.increaseIndentation
		errors.forEach[appendable.newLine.append('+ "\\n').append(doConvertToJavaString(message)).append('"')]
		appendable.append(');').decreaseIndentation.decreaseIndentation.newLine
		    .append('}')
	}
	
	/**
	 * Convert a given input string to a Java string. Non-ascii characters will
	 * be replaced by a unicode escape sequence by default.
	 */
	protected def doConvertToJavaString(String input) {
		Strings.convertToJavaString(input, true)
	}
	
	def void generateFileHeader(JvmDeclaredType it, ITreeAppendable appendable, GeneratorConfig config) {
        val fileHeaderAdapter = it.eAdapters.filter(FileHeaderAdapter).head
        if(!fileHeaderAdapter?.headerText.nullOrEmpty) {
			generateDocumentation(fileHeaderAdapter.headerText, fileHeaderProvider.getFileHeaderNodes(eResource), appendable, config)
        }
    }

	def void generateJavaDoc(EObject it, ITreeAppendable appendable, GeneratorConfig config) {
		val adapter = it.eAdapters.filter(DocumentationAdapter).head
		if(!adapter?.documentation.nullOrEmpty) {
			// TODO we should track the source of the documentation in the documentation adapter
			val sourceElements = jvmModelAssociations.getSourceElements(it)
			if (sourceElements.size == 1 && documentationProvider instanceof IEObjectDocumentationProviderExtension) {
				val documentationNodes = (documentationProvider as IEObjectDocumentationProviderExtension).getDocumentationNodes(sourceElements.head)
				addJavaDocImports(appendable, documentationNodes)
				generateDocumentation(adapter.documentation, documentationNodes, appendable, config)
			} else {
				generateDocumentation(adapter.documentation, emptyList, appendable, config)
			}
		}
	} 
	
	def addJavaDocImports(EObject it, ITreeAppendable appendable,List<INode> documentationNodes) {
		for(node : documentationNodes){
			for(region : javaDocTypeReferenceProvider.computeTypeRefRegions(node)) {
				val text = region.text
				if(text != null && text.length > 0){
					val fqn = qualifiedNameConverter.toQualifiedName(text)
					val context = NodeModelUtils.findActualSemanticObjectFor(node)
					if(fqn.segmentCount == 1 && context != null){
						val scope = scopeProvider.getScope(context, JVM_PARAMETERIZED_TYPE_REFERENCE__TYPE)
						val candidate = scope.getSingleElement(fqn)
						if(candidate != null) {
							val jvmType = 	(
											if(candidate.EObjectOrProxy.eIsProxy)
												EcoreUtil.resolve(candidate.EObjectOrProxy, context)
											else
												candidate.EObjectOrProxy
											) as JvmType
							if(jvmType instanceof JvmDeclaredType && !jvmType.eIsProxy) {
								val referencedType = jvmType as JvmDeclaredType
								val contextDeclarator = EcoreUtil2.getContainerOfType(it,JvmDeclaredType)
								if(referencedType.packageName != contextDeclarator.packageName){
									val importManager = getImportManager(appendable)
									importManager.addImportFor(jvmType)
								}
							}
						}
					}
				}
			}
		}
	}

	def getImportManager(ITreeAppendable appendable) {
		val stateField = appendable.getClass.getDeclaredField("state")
		stateField.setAccessible(true)
		val stateValue = stateField.get(appendable)
		val importManagerField = stateValue.getClass.getDeclaredField("importManager")
		importManagerField.setAccessible(true)
		importManagerField.get(stateValue) as ImportManager
	}

	def protected generateDocumentation(String text, List<INode> documentationNodes, ITreeAppendable appendable, GeneratorConfig config) {
		val doc = '''/**''' as StringConcatenation
			doc.newLine
			doc.append(" * ")
			doc.append(text, " * ")
			doc.newLine
			doc.append(" */")
		if (!documentationNodes.empty) {
			var documentationTrace = ITextRegionWithLineInformation.EMPTY_REGION
			for(node: documentationNodes) {
				documentationTrace = documentationTrace.merge(node.textRegionWithLineInformation) 
			}
			appendable.trace(new LocationData(documentationTrace, null)).append(doc.toString)
			appendable.newLine

		} else {
			appendable.append(doc.toString).newLine
		}
	}
	
	def void generateAnnotations(Iterable<JvmAnnotationReference> annotations, ITreeAppendable appendable, boolean withLineBreak, GeneratorConfig config) {
		val sep = [ITreeAppendable it |  if(withLineBreak) newLine else append(' ') ]
		appendable.forEachSafely(annotations, [
				separator = sep suffix = sep
			], [
				it, app | it.generateAnnotation(app, config)
			])
	}

	def void generateAnnotation(JvmAnnotationReference it, ITreeAppendable appendable, GeneratorConfig config) {
		appendable.append("@")
		appendable.append(annotation)
		appendable.forEach(values, [
				prefix = '(' separator = ', ' suffix = ')'
			], [
				toJava(appendable, config)
			])
	}
	 
	def void toJava(JvmAnnotationValue it, ITreeAppendable appendable, GeneratorConfig config) {
		if (operation != null) {
			appendable.append(operation.simpleName)
			appendable.append(" = ")
		} else if ((eContainer as JvmAnnotationReference).values.size > 1) { // more than one value
			appendable.append("value = ")
		}
		toJavaLiteral(appendable, config)
	}
		
	def dispatch void toJavaLiteral(JvmAnnotationAnnotationValue value, ITreeAppendable appendable, GeneratorConfig config) {
		appendable.forEachWithShortcut(value.values, [generateAnnotation(appendable, config)])
	}
		
	def dispatch void toJavaLiteral(JvmShortAnnotationValue it, ITreeAppendable appendable, GeneratorConfig config) {
		appendable.forEachWithShortcut(values, [appendable.append(toString)])
	}
	
	def dispatch void toJavaLiteral(JvmIntAnnotationValue it, ITreeAppendable appendable, GeneratorConfig config) {
		appendable.forEachWithShortcut(values, [appendable.append(toString)])
	}
	
	def dispatch void toJavaLiteral(JvmLongAnnotationValue it, ITreeAppendable appendable, GeneratorConfig config) {
		appendable.forEachWithShortcut(values, [appendable.append(toString)])
	}
	
	def dispatch void toJavaLiteral(JvmByteAnnotationValue it, ITreeAppendable appendable, GeneratorConfig config) {
		appendable.forEachWithShortcut(values, [appendable.append(toString)])
	}
	
	def dispatch void toJavaLiteral(JvmDoubleAnnotationValue it, ITreeAppendable appendable, GeneratorConfig config) {
		appendable.forEachWithShortcut(values, [
			appendable.append(
				switch(it) {
					case Double.isNaN(it) : "Double.NaN"
					case Double.POSITIVE_INFINITY : "Double.POSITIVE_INFINITY" 
					case Double.NEGATIVE_INFINITY : "Double.NEGATIVE_INFINITY"
					default: toString + "d" 
				})
		])
	}
	
	def dispatch void toJavaLiteral(JvmFloatAnnotationValue it, ITreeAppendable appendable, GeneratorConfig config) {
		appendable.forEachWithShortcut(values, [
			appendable.append(
				switch(it) {
					case Float.isNaN(it) : "Float.NaN"
					case Float.POSITIVE_INFINITY : "Float.POSITIVE_INFINITY" 
					case Float.NEGATIVE_INFINITY : "Float.NEGATIVE_INFINITY"
					default: toString + "f" 
				})
		])
	}
	
	def dispatch void toJavaLiteral(JvmCharAnnotationValue it, ITreeAppendable appendable, GeneratorConfig config) {
		appendable.forEachWithShortcut(values, [
			appendable.append("'" + doConvertToJavaString(toString) + "'")
		])
	}
		
	def dispatch void toJavaLiteral(JvmStringAnnotationValue it, ITreeAppendable appendable, GeneratorConfig config) {
		appendable.forEachWithShortcut(values, [
			appendable.append('"' + doConvertToJavaString(toString) + '"')
		])
	}
		
	def dispatch void toJavaLiteral(JvmTypeAnnotationValue it, ITreeAppendable appendable, GeneratorConfig config) {
		appendable.forEachWithShortcut(values, [
			appendable.append(type).append(".class")
		])
	} 
	
	def dispatch void toJavaLiteral(JvmEnumAnnotationValue it, ITreeAppendable appendable, GeneratorConfig config) {
		appendable.forEachWithShortcut(values, [
			appendable.append(declaringType)
			appendable.append(".")
			appendable.append(simpleName)
		])
	} 
		
	def dispatch void toJavaLiteral(JvmBooleanAnnotationValue it, ITreeAppendable appendable, GeneratorConfig config) {
		appendable.forEachWithShortcut(values, [
			appendable.append(toString)			
		])
	} 
	
	def dispatch void toJavaLiteral(JvmCustomAnnotationValue it, ITreeAppendable appendable, GeneratorConfig config) {
		if(values.isEmpty)
			appendable.append('{}')
		else 
			appendable.forEachWithShortcut(values.filter(XExpression), [
				compiler.toJavaExpression(it, appendable)
			])
	}
		
	def TreeAppendable createAppendable(EObject context, ImportManager importManager, GeneratorConfig config) {
		val appendable = new TreeAppendable(importManager, converter, locationProvider, jvmModelAssociations, context, "  ", "\n")
		val type = context.containerType
		if( type != null) {
			appendable.declareVariable(context.containerType, "this")
			val superType = context.containerType.extendedClass
			if (superType != null)
				appendable.declareVariable(superType.type, "super")
		}
		return appendable
	}
	
	def JvmGenericType containerType(EObject context) {
		if(context == null) 
			null
		else if(context instanceof JvmGenericType)
			context
		else containerType(context.eContainer)
	}
	
	def protected String makeJavaIdentifier(String name) {
		if (name == null) {
			return "__unknown__";
		} else if (keywords.isJavaKeyword(name)) {
			name+"_"
		} else {
			name
		}
	}
	
	def dispatch Iterable<JvmMember> getMembersToBeCompiled(JvmEnumerationType type) {
		val syntheticEnumMethods = #{ type.identifier + "." + 'valueOf(java.lang.String)', type.identifier + "." + 'values()' }
		type.members.filter[
			!(it instanceof JvmOperation && syntheticEnumMethods.contains(identifier))  
		]
	}

	def dispatch Iterable<JvmMember> getMembersToBeCompiled(JvmDeclaredType it) {
		members.filter[
			!(it instanceof JvmConstructor && (it as JvmConstructor).singleSyntheticDefaultConstructor)
		]
	}
}