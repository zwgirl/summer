package org.summer.dsl.xbase.jvmmodel

import com.google.inject.Inject
import org.eclipse.emf.common.notify.impl.AdapterImpl
import org.summer.dsl.model.types.JvmConstructor
import org.summer.dsl.model.types.JvmIdentifiableElement
import org.summer.dsl.xbase.compiler.CompilationStrategyAdapter
import org.summer.dsl.xbase.compiler.output.ITreeAppendable
import org.eclipse.emf.ecore.util.EcoreUtil
import org.summer.ss2.lib.StringConcatenationClient
import org.summer.dsl.xbase.compiler.CompilationTemplateAdapter

class JvmTypeExtensions {
	
	@Inject extension ILogicalContainerProvider 
	
	def (ITreeAppendable)=>void getCompilationStrategy(JvmIdentifiableElement it) {
		val adapter = eAdapters.filter(CompilationStrategyAdapter).head
		return adapter?.compilationStrategy
	}
	
	def StringConcatenationClient getCompilationTemplate(JvmIdentifiableElement it) {
		val adapter = eAdapters.filter(CompilationTemplateAdapter).head
		return adapter?.compilationTemplate
	}
	
	def isSingleSyntheticDefaultConstructor(JvmConstructor it) {
		return parameters.empty && 
			associatedExpression == null && 
			compilationStrategy == null && 
			compilationTemplate == null &&
			declaringType.members.filter(JvmConstructor).size == 1
	}
	
	def isSynthetic(JvmIdentifiableElement element) {
		element.metaData.synthetic
	}
	
	def void setSynthetic(JvmIdentifiableElement element, boolean isSynthetic) {
		element.metaData.synthetic = isSynthetic
	}
	
	def protected JvmIdentifiableMetaData getMetaData(JvmIdentifiableElement element) {
		var metaData = EcoreUtil.getAdapter(element.eAdapters, JvmIdentifiableMetaData) as JvmIdentifiableMetaData
		if (metaData == null) {
			metaData = new JvmIdentifiableMetaData
			element.eAdapters += metaData
		}
		return metaData
	}
	
}

class JvmIdentifiableMetaData extends AdapterImpl {
	@Property boolean synthetic
	
	override isAdapterForType(Object type) {
		JvmIdentifiableMetaData == type
	}
	
}