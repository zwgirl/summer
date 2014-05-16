package org.summer.ss.ide.labeling

import com.google.inject.Inject
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider
import org.eclipse.jface.viewers.StyledString
import org.summer.dsl.model.types.JvmAnnotationType
import org.summer.dsl.model.types.JvmConstructor
import org.summer.dsl.model.types.JvmDeclaredType
import org.summer.dsl.model.types.JvmEnumerationType
import org.summer.dsl.model.types.JvmField
import org.summer.dsl.model.types.JvmGenericType
import org.summer.dsl.model.types.JvmInterfaceType
import org.summer.dsl.model.types.JvmModule
import org.summer.dsl.model.types.JvmOperation
import org.summer.dsl.model.types.JvmTypeReference
import org.summer.dsl.xbase.ui.labeling.XbaseImageAdornments
import org.summer.dsl.xbase.ui.labeling.XbaseLabelProvider
import org.summer.dsl.xbase.validation.UIStrings
import org.summer.ss.core.jvmmodel.DispatchHelper
import org.summer.ss.core.jvmmodel.IXtendJvmAssociations
import org.summer.dsl.model.types.JvmEnumerationLiteral

/**
 * Provides labels for Xtend elements.
 * 
 * @author Jan Koehnlein
 */
public class SsLabelProvider extends XbaseLabelProvider {
	
	@Inject UIStrings uiStrings

	@Inject SsImages images

	@Inject extension IXtendJvmAssociations
	
	@Inject XbaseImageAdornments adornments
	
	@Inject extension DispatchHelper

	@Inject
	new(AdapterFactoryLabelProvider delegate) {
		super(delegate)
	}

	protected def dispatch imageDescriptor(JvmModule element) {
		images.forFile
	}
	
	protected def dispatch imageDescriptor(JvmEnumerationLiteral element) {
		images.forField(element.visibility, adornments.get(element))
	}
	
	protected def text(JvmModule element) {
		element.eResource.URI.trimFileExtension.lastSegment
	}

	protected def text(JvmDeclaredType element) {
		element.simpleName
	}

	protected def JvmTypeReference getDisplayedType(JvmField field) {
		if (field != null) {
			return field.getType
		} else {
			val i = field.jvmElements.iterator
			if(i.hasNext) {
				val next = i.next
				if(next instanceof JvmOperation)
					return (next as JvmOperation).getReturnType
			}
		}
		null
	}
}
