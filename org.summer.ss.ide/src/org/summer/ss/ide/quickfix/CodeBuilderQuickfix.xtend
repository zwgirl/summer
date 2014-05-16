/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.summer.ss.ide.quickfix

import com.google.inject.Inject
import org.eclipse.core.runtime.NullProgressMonitor
import org.eclipse.emf.ecore.util.EcoreUtil
import org.eclipse.xtext.resource.XtextResource
import org.eclipse.xtext.ui.editor.IURIEditorOpener
import org.eclipse.xtext.ui.editor.XtextEditor
import org.eclipse.xtext.ui.editor.model.edit.IModification
import org.eclipse.xtext.ui.editor.quickfix.IssueResolutionAcceptor
import org.eclipse.xtext.validation.Issue
import org.summer.dsl.model.types.JvmDeclaredType
import org.summer.dsl.model.types.JvmVisibility
import org.summer.dsl.model.types.xtext.ui.JdtHyperlink
import org.summer.dsl.xbase.compiler.ImportManager
import org.summer.dsl.xbase.compiler.StringBuilderBasedAppendable
import org.summer.dsl.xbase.ui.contentassist.ReplacingAppendable
import org.summer.dsl.xbase.ui.document.DocumentSourceAppender.Factory.OptionalParameters
import org.summer.ss.ide.codebuilder.ICodeBuilder
import org.summer.ss.ide.codebuilder.JavaConstructorBuilder
import org.summer.ss.ide.codebuilder.JavaFieldBuilder
import org.summer.ss.ide.codebuilder.JavaMethodBuilder

/**
 * Creates quickfixes using {@link ICodeBuilder}s.
 * 
 * @author Sebastian Benz - Inspiration
 * @author Jan Koehnlein - Initial implementation and API
 */
class CodeBuilderQuickfix {
	
	@Inject IURIEditorOpener editorOpener
	@Inject ReplacingAppendable.Factory appendableFactory 
	
	def addQuickfix(ICodeBuilder builder, String label, Issue issue, IssueResolutionAcceptor acceptor) {
		if (builder.isValid) {
			val modification = switch builder {
				ICodeBuilder.Xtend: builder.xtendModification
				ICodeBuilder.Java: builder.javaModification
			} 
			acceptor.accept(issue, label, builder.preview, builder.image, modification)
		}
	}
	
	def protected getImage(ICodeBuilder builder) {
		switch builder.visibility {
			case JvmVisibility.PRIVATE: 'fix_private_obj.gif'
			case JvmVisibility.PUBLIC: 'fix_public_obj.gif'
//			case JvmVisibility.PROTECTED: 'fix_protected_obj.gif'  //cym comment
			default: 'fix_default_obj.gif'
		} 	
	}
	
	def protected isXtendSource(ICodeBuilder builder) {
		builder.ownerSource instanceof JvmDeclaredType
	}
	
	def protected IModification getXtendModification(ICodeBuilder.Xtend builder) {
		[
			val xtendClass = builder.xtendType
			val editor = editorOpener.open(EcoreUtil.getURI(xtendClass), false);
			if (!(editor instanceof XtextEditor)) {
				return
			}
			val xtextEditor = editor as XtextEditor;
			val document = xtextEditor.getDocument();
			var offset = builder.insertOffset

			val appendable = appendableFactory.create(document, xtendClass.eResource as XtextResource, offset, 0, new OptionalParameters => [
				baseIndentationLevel = builder.indentationLevel
				ensureEmptyLinesAround = true
			])
			builder.build(appendable)
			appendable.commitChanges
			xtextEditor.setHighlightRange(offset + 1, appendable.length, true)
		]
	}

	def protected IModification getJavaModification(ICodeBuilder.Java builder) {
		[
			val type = builder.IType
			val importManager = new ImportManager(true, ".".charAt(0))
			val content = new StringBuilderBasedAppendable(importManager)
			builder.build(content)
			importManager.imports.forEach [
				type.compilationUnit.createImport(it, null, new NullProgressMonitor)
			]
			val element = 
				switch(builder) {
					JavaFieldBuilder:  type.createField(content.toString, null, true, new NullProgressMonitor)
					JavaConstructorBuilder: type.createMethod(content.toString, null, true, new NullProgressMonitor)
					JavaMethodBuilder: type.createMethod(content.toString, null, true, new NullProgressMonitor)
					default: null
				}
			if(element != null)
				new JdtHyperlink => [
					javaElement = element
					open
				]
		]
	}
	
}