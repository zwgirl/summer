package org.summer.dsl.xbase.ui.labeling

import com.google.inject.Inject
import org.summer.dsl.model.types.JvmConstructor
import org.summer.dsl.model.types.JvmDeclaredType
import org.summer.dsl.model.types.JvmExecutable
import org.summer.dsl.model.types.JvmField
import org.summer.dsl.model.types.JvmIdentifiableElement
import org.summer.dsl.model.types.JvmOperation
import org.summer.dsl.xbase.typesystem.^override.OverrideHelper

import static org.eclipse.jdt.ui.JavaElementImageDescriptor.*

import static extension org.summer.dsl.model.types.util.DeprecationUtil.*

class XbaseImageAdornments {
	
	@Inject extension OverrideHelper
	  
	def dispatch get(JvmDeclaredType it) {
		0	
			.or(abstract, ABSTRACT)
			.or(final, FINAL) 
			.or(static, STATIC)
			.or(deprecated, DEPRECATED)
	}
	
	def dispatch get(JvmField it) {
		0	
			.or(final, FINAL) 
			.or(static, STATIC) 
			.or(deprecated, DEPRECATED)
			.or(volatile, VOLATILE)
			.or(transient, TRANSIENT)
	}
	
	def dispatch get(JvmConstructor it) {
		CONSTRUCTOR	
			.or(deprecated, DEPRECATED)
	}
	
	def dispatch get(JvmOperation it) {
		val adornment = 0	
			.or(abstract, ABSTRACT)
			.or(final, FINAL) 
			.or(synchronized, SYNCHRONIZED) 
			.or(static, STATIC) 
			.or(deprecated, DEPRECATED)
			.or(native, 0x4000) // JavaElementImageDescription.NATIVE not available before 3.7
			
		if(eResource?.resourceSet != null) {
			val overriddenOperation = findOverriddenOperation
			if(overriddenOperation != null) 
				return adornment.bitwiseOr(getOverrideAdornment(overriddenOperation))
		}
		return adornment
	}
	
	def dispatch get(Void it) {
		0
	}

	def getOverrideAdornment(JvmExecutable overriddenOperation) {
		switch overriddenOperation {
			JvmOperation: if(overriddenOperation.abstract) IMPLEMENTS else OVERRIDES
			default: 0
		}
	}
	
	def dispatch get(JvmIdentifiableElement it) {
		0
	}
	
	protected def or(int adornment, boolean condition, int oredValue) {
		if(condition) 
			adornment.bitwiseOr(oredValue)
		else
			adornment
	} 
}