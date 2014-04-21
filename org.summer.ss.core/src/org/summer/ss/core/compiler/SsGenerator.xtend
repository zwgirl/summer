/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.summer.ss.core.compiler

import org.eclipse.emf.ecore.resource.Resource
import org.summer.ss.core.macro.ActiveAnnotationContexts
import org.summer.ss.core.macro.CodeGenerationContextImpl
import org.summer.dsl.model.ss.XtendMember
import org.summer.ss.lib.macro.CodeGenerationParticipant
import org.summer.ss.lib.macro.declaration.NamedElement
import org.eclipse.xtext.generator.IFileSystemAccess
import org.eclipse.xtext.util.Strings
import org.summer.dsl.xbase.compiler.JvmModelGenerator

/**
 * @author Sven Efftinge - Initial contribution and API
 */
class XtendGenerator extends JvmModelGenerator {
	
	override doGenerate(Resource input, IFileSystemAccess fsa) {
		super.doGenerate(input, fsa)
		callMacroProcessors(input)
	}
	
	def void callMacroProcessors(Resource input) {
		val ctxs = ActiveAnnotationContexts.find(input);
		if (ctxs == null)
			return;
		for (context : ctxs.contexts.values) {
			try {
				switch processor : context.processorInstance {
					CodeGenerationParticipant<NamedElement> : {
						val codeGenServices = new CodeGenerationContextImpl => [
							fileSystemSupport = context.compilationUnit.fileSystemSupport
							fileLocations = context.compilationUnit.fileLocations
						]
						val elements = context.annotatedSourceElements.map[context.compilationUnit.toXtendMemberDeclaration(it as XtendMember)]
						processor.doGenerateCode(elements, codeGenServices)
					}
				}
			} catch (Throwable t) {
				context.handleProcessingError(input, t)
			}
		}
	}
	
	/**
	 * Convert a given input string to a Java string.
	 * 
	 * Unicode escaping is handled by the {@link UnicodeAwarePostProcessor}.
	 */
	override doConvertToJavaString(String input) {
		Strings.convertToJavaString(input, false)
	}
	
}