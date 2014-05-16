/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/

package org.summer.ss.core.macro

import com.google.inject.Inject
import com.google.inject.Provider
import java.util.concurrent.CancellationException
import java.util.concurrent.atomic.AtomicBoolean
import org.eclipse.xtext.util.CancelIndicator
import org.eclipse.xtext.util.internal.Stopwatches
import org.summer.dsl.model.types.JvmFormalParameter
import org.summer.dsl.model.types.JvmMember
import org.summer.dsl.xbase.jvmmodel.IJvmDeclaredTypeAcceptor
import org.summer.ss.lib.macro.RegisterGlobalsParticipant
import org.summer.ss.lib.macro.TransformationParticipant
import org.summer.ss.lib.macro.declaration.MutableNamedElement
import org.summer.ss.lib.macro.declaration.NamedElement

/**
 * It checks whether the files contain macro annotations and calls their register and processing functions.
 * 
 * @author Sven Efftinge
 */
class AnnotationProcessor {
	
	@Inject Provider<TransformationContextImpl> modifyContextProvider
	@Inject Provider<RegisterGlobalsContextImpl> registerGlobalsContextProvider

	/**
	 * gets called from Xtend compiler, during "model inference", i.e. translation of Xtend AST to Java AST
	 */
	def indexingPhase(ActiveAnnotationContext ctx, IJvmDeclaredTypeAcceptor acceptor, CancelIndicator monitor) {
		val task = Stopwatches.forTask('[macros] indexingPhase (AnnotationProcessor.indexingPhase)')
		task.start
		try {
			switch processor : ctx.processorInstance {
				RegisterGlobalsParticipant<NamedElement>: {
					val registerGlobalsCtx = registerGlobalsContextProvider.get
					registerGlobalsCtx.acceptor = acceptor
					registerGlobalsCtx.compilationUnit = ctx.compilationUnit
					
					runWithCancelIndiciator(ctx, monitor) [|
						processor.doRegisterGlobals(ctx.annotatedSourceElements.map[ctx.compilationUnit.toXtendMemberDeclaration(it as JvmMember)], registerGlobalsCtx)
					]
				}
			}
		} finally {
			task.stop
		}
	}

	def inferencePhase(ActiveAnnotationContext ctx, CancelIndicator monitor) {
		val task = Stopwatches.forTask('[macros] inferencePhase (AnnotationProcessor.inferencePhase)')
		task.start
		try {
			switch processor : ctx.processorInstance{
				TransformationParticipant<MutableNamedElement>: {
					val modifyCtx = modifyContextProvider.get
					modifyCtx.unit = ctx.compilationUnit
					
					runWithCancelIndiciator(ctx, monitor) [|
						val map = ctx.annotatedSourceElements.map[
							val xtendMember = switch it {
								JvmMember : ctx.compilationUnit.toXtendMemberDeclaration(it)
								JvmFormalParameter : ctx.compilationUnit.toXtendParameterDeclaration(it)
							}
							return modifyCtx.getPrimaryGeneratedJavaElement(xtendMember)
						]
						processor.doTransform(map, modifyCtx)
					]
				}
			}
		} finally {
			task.stop
		}
	}
	
	/**
	 * runs the given runnable and another thread in parallel, that sets the timeout property on the compilation unit to true
	 * when the given amount of milliseconds have passed by.
	 */
	private def runWithCancelIndiciator(ActiveAnnotationContext ctx, CancelIndicator cancelIndicator, Runnable runnable) {
		val AtomicBoolean isFinished = new AtomicBoolean(false)
		new Thread ([|
			while (!isFinished.get) {
				if (cancelIndicator.canceled) {
					ctx.compilationUnit.canceled = true
					return;
				}
				Thread.sleep(100)
			}
		]).start
		try {
			runnable.run
		} catch (CancellationException e) {
		} finally {
			isFinished.set(true)
		}
	}
	
}

