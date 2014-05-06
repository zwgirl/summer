package org.summer.ss.ide.labeling

import com.google.inject.Inject
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider
import org.eclipse.jface.viewers.StyledString
import org.summer.ss.core.jvmmodel.DispatchHelper
import org.summer.ss.core.jvmmodel.IXtendJvmAssociations
import org.summer.dsl.model.ss.XtendAnnotationType
import org.summer.dsl.model.ss.XtendClass
import org.summer.dsl.model.ss.XtendConstructor
import org.summer.dsl.model.ss.XtendEnum
import org.summer.dsl.model.ss.XtendEnumLiteral
import org.summer.dsl.model.ss.XtendField
import org.summer.dsl.model.ss.XtendFunction
import org.summer.dsl.model.ss.XtendInterface
import org.summer.dsl.model.types.JvmOperation
import org.summer.dsl.model.types.JvmTypeReference
import org.summer.dsl.xbase.ui.labeling.XbaseImageAdornments
import org.summer.dsl.xbase.ui.labeling.XbaseLabelProvider
import org.summer.dsl.xbase.validation.UIStrings
import org.summer.dsl.model.ss.XtendTypeDeclaration
import org.summer.dsl.model.ss.XModule

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

	protected def dispatch imageDescriptor(XModule element) {
		images.forFile
	}

	protected def dispatch imageDescriptor(XtendClass element) {
		images.forClass(element.visibility, adornments.get(element.inferredType))
	}

	protected def dispatch imageDescriptor(XtendInterface element) {
		images.forInterface(element.visibility, adornments.get(element.inferredType))
	}

	protected def dispatch imageDescriptor(XtendEnum element) {
		images.forEnum(element.visibility, adornments.get(element.inferredType))
	}

	protected def dispatch imageDescriptor(XtendAnnotationType element) {
		images.forAnnotation(element.visibility, adornments.get(element.inferredType))
	}

	protected def dispatch imageDescriptor(XtendFunction element) {
		images.forOperation(element.visibility, adornments.get(element.directlyInferredOperation))
	}

	protected override dispatch imageDescriptor(JvmOperation operation) {
		if(operation.dispatcherFunction) 
			images.forDispatcherFunction(operation.visibility, adornments.get(operation))
		else 
			images.forOperation(operation.visibility, adornments.get(operation))
	}
	
	protected def dispatch imageDescriptor(XtendConstructor element) {
		images.forConstructor(element.visibility, adornments.get(element.inferredConstructor))
	}

	protected def dispatch imageDescriptor(XtendField element) {
		images.forField(element.visibility, adornments.get(element.jvmField))
	}
	
	protected def dispatch imageDescriptor(XtendEnumLiteral element) {
		images.forField(element.visibility, adornments.get(element.jvmField))
	}
	
	protected def text(XModule element) {
		element.eResource.URI.trimFileExtension.lastSegment
	}

	protected def text(XtendClass element) {
		element.name + if(element.typeParameters.empty)  
			"" 
		else 
			uiStrings.typeParameters(element.typeParameters)
	}

	protected def text(XtendInterface element) {
		element.name + if(element.typeParameters.empty)  
			"" 
		else 
			uiStrings.typeParameters(element.typeParameters)
	}

	protected def text(XtendTypeDeclaration element) {
		element.name
	}

	protected def text(XtendConstructor element) {
		"new" + uiStrings.parameters(element.inferredConstructor)
	}
	
	protected def text(XtendFunction element) {
		signature(element.name, element.directlyInferredOperation)
	}
	
	protected def text(XtendField element) {
		if (element.name == null && element.extension) 
			return new StyledString(uiStrings.referenceToString(element.type, "extension"), StyledString.DECORATIONS_STYLER)
		val fieldType = element.displayedType
		if (fieldType != null) {
			val type = uiStrings.referenceToString(fieldType, "")
			if (type.length != 0) {
				return new StyledString(element.name).append(new StyledString(" : " + type,StyledString.DECORATIONS_STYLER))
			}
		}
		new StyledString(element.name)
	}

	protected def text(XtendEnumLiteral element) {
		element.name
	}

	protected def JvmTypeReference getDisplayedType(XtendField field) {
		val jvmField = field.jvmField
		if (jvmField != null) {
			return jvmField.getType
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
