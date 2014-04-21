/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.summer.dsl.xbase.compiler

import org.summer.dsl.xbase.compiler.output.ITreeAppendable

/**
 * @author Jan Koehnlein 
 */
class LoopExtensions {
	/**
	 * Iterates elements and execute the procedure.
	 * A prefix, a separator and a suffix can be initialized with the loopInitializer lambda. 
	 */
	def <T> void forEach(ITreeAppendable appendable, Iterable<T> elements,  
			(org.summer.dsl.xbase.compiler.LoopParams)=>void loopInitializer, (T)=>void procedure) {
		if(elements.empty)
			return
		val params = new org.summer.dsl.xbase.compiler.LoopParams => loopInitializer
		params.appendPrefix(appendable)
		elements.head => procedure
		elements.tail.forEach[
			params.appendSeparator(appendable)
			it => procedure
		]
		params.appendSuffix(appendable)
	}

	/**
	 * Uses curly braces and comma as delimiters. Doesn't use them for single valued iterables.
	 */
	def <T> void forEachWithShortcut(ITreeAppendable appendable, Iterable<T> elements,  
			(T)=>void procedure) {
		if(elements.size == 1)
			elements.head => procedure
		else 
			forEach(appendable, elements, [
				prefix= '{ ' separator = ', ' suffix = ' }'
			], procedure)
	}
}

class LoopParams {
	(ITreeAppendable)=>ITreeAppendable prefix
	(ITreeAppendable)=>ITreeAppendable separator
	(ITreeAppendable)=>ITreeAppendable suffix
	
	def setPrefix((ITreeAppendable)=>ITreeAppendable prefix) {
		this.prefix = prefix
	}
	
	def setSeparator((ITreeAppendable)=>ITreeAppendable separator) {
		this.separator = separator
	}
	
	def setSuffix((ITreeAppendable)=>ITreeAppendable suffix) {
		this.suffix = suffix
	}
	
	def setPrefix(String prefix) {
		this.prefix = [ append(prefix) ]
	}
	
	def setSeparator(String separator) {
		this.separator = [ append(separator) ]
	}
	
	def setSuffix(String suffix) {
		this.suffix = [ append(suffix) ]
	}
	
	def appendPrefix(ITreeAppendable app) {
		prefix?.apply(app)
		app
	}
	
	def appendSeparator(ITreeAppendable app) {
		separator?.apply(app)
		app
	}
	
	def appendSuffix(ITreeAppendable app) {
		suffix?.apply(app)
		app
	}
}