package org.summer.ss.core.macro.declaration

import org.summer.ss.lib.macro.expression.Expression
import org.summer.dsl.model.xbase.XExpression
import org.eclipse.xtext.nodemodel.util.NodeModelUtils

class ExpressionImpl extends AbstractElementImpl<XExpression> implements Expression {
	
	override toString() {
		NodeModelUtils.getNode(delegate).text.trim
	}
	
}