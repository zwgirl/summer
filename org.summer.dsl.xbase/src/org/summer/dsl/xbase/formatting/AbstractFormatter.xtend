package org.summer.dsl.xbase.formatting

import org.eclipse.emf.ecore.EObject
import org.eclipse.xtext.resource.XtextResource

abstract class AbstractFormatter implements IBasicFormatter {

	@Property boolean allowIdentityEdits = false
	@Property boolean diagnoseConflicts = true
	boolean conflictOccurred = false

	override format(XtextResource res, int offset, int length, FormattingPreferenceValues cfg) {
		val doc = res.parseResult.rootNode.text
		val format = new org.summer.dsl.xbase.formatting.FormattableDocument(cfg, doc)
		format(res.contents.head, format)
		if (isDiagnoseConflicts && format.isConflictOccurred) {
			val debug = new org.summer.dsl.xbase.formatting.FormattableDocument(cfg, doc)
			debug.rootTrace = new RuntimeException
			format(res.contents.head, debug)
		}
		conflictOccurred = format.isConflictOccurred
		val edits = format.renderToEdits(offset, length)

		if (isAllowIdentityEdits)
			edits
		else
			edits.filter[doc.substring(it.getOffset, it.getOffset + it.getLength) != getText].toList
	}
	
	def isConflictOccurred() {
		conflictOccurred
	}

	def protected dispatch void format(Void expr, org.summer.dsl.xbase.formatting.FormattableDocument format) {
	}

	def protected dispatch void format(EObject expr, org.summer.dsl.xbase.formatting.FormattableDocument format) {
	}

}
