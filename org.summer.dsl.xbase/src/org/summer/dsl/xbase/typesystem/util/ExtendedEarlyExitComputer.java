/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.summer.dsl.xbase.typesystem.util;

import java.util.List;

import org.eclipse.jdt.annotation.Nullable;
import org.summer.dsl.model.xbase.XAbstractWhileExpression;
import org.summer.dsl.model.xbase.XBlockExpression;
import org.summer.dsl.model.xbase.XCasePart;
import org.summer.dsl.model.xbase.XCatchClause;
import org.summer.dsl.model.xbase.XExpression;
import org.summer.dsl.model.xbase.XForLoopExpression;
import org.summer.dsl.model.xbase.XIfExpression;
import org.summer.dsl.model.xbase.XReturnExpression;
import org.summer.dsl.model.xbase.XSwitchExpression;
import org.summer.dsl.model.xbase.XThrowExpression;
import org.summer.dsl.model.xbase.XTryCatchFinallyExpression;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class ExtendedEarlyExitComputer {
	
	// TODO discuss / improve
	/**
	 * Returns <code>true</code> for expressions that seem to be early exit expressions, e.g.
	 * <pre>
	 *   while(condition) {
	 *     if (anotherCondition)
	 *       return value
	 *     changeResultOfFirstCondition
	 *   }
	 * </pre>
	 */
	public boolean isIntentionalEarlyExit(@Nullable XExpression expression) {
		if (expression == null) {
			return true;
		}
		if (expression instanceof XBlockExpression) {
			XBlockExpression block = (XBlockExpression) expression;
			List<XExpression> children = block.getExpressions();
			for(XExpression child: children) {
				if (isIntentionalEarlyExit(child)) {
					return true;
				}
			}
		} else if (expression instanceof XIfExpression) {
			return isIntentionalEarlyExit(((XIfExpression) expression).getThen()) && isIntentionalEarlyExit(((XIfExpression) expression).getElse());
		} else if (expression instanceof XTryCatchFinallyExpression) {
			XTryCatchFinallyExpression tryCatchFinally = (XTryCatchFinallyExpression) expression;
			
			//cym comment
//			if (isIntentionalEarlyExit(tryCatchFinally.getExpression())) {
//				for(XCatchClause catchClause: tryCatchFinally.getCatchClauses()) {
//					if (!isIntentionalEarlyExit(catchClause.getExpression()))
//						return false;
//				}
//				return true;
//			}
			
			if (isIntentionalEarlyExit(tryCatchFinally.getExpression())) {
				XCatchClause catchClause = tryCatchFinally.getCatchClause();
				if (!isIntentionalEarlyExit(catchClause.getExpression()))
					return false;
				
				return true;
			}
			return false;
		} else if (expression instanceof XAbstractWhileExpression) {
			return isIntentionalEarlyExit(((XAbstractWhileExpression) expression).getBody());
		} else if (expression instanceof XForLoopExpression) {
			return isIntentionalEarlyExit(((XForLoopExpression) expression).getEachExpression());
		}
		return expression instanceof XReturnExpression || expression instanceof XThrowExpression;
	}

	public boolean isDefiniteEarlyExit(XExpression expression) {
		// TODO further improvements
		if (expression instanceof XIfExpression) {
			XIfExpression ifExpression = (XIfExpression) expression;
			return isDefiniteEarlyExit(ifExpression.getThen()) && isDefiniteEarlyExit(ifExpression.getElse());
		} else if (expression instanceof XSwitchExpression) {
			XSwitchExpression switchExpression = (XSwitchExpression) expression;
			if (isDefiniteEarlyExit(switchExpression.getDefault())) {
				for(XCasePart caseExpression: switchExpression.getCases()) {
					if (!isDefiniteEarlyExit(caseExpression.getThen())) {
						return false;
					}
				}
				return true;
			}
			return false;
		} else if (expression instanceof XTryCatchFinallyExpression) {
			XTryCatchFinallyExpression tryExpression = (XTryCatchFinallyExpression) expression;
			if (isDefiniteEarlyExit(tryExpression.getFinallyExpression())) {
				return true;
			}
			
			//cym comment
//			if (isDefiniteEarlyExit(tryExpression.getExpression())) {
//				for(XCatchClause catchClause: tryExpression.getCatchClauses()) {
//					if (!isDefiniteEarlyExit(catchClause.getExpression())) {
//						return false;
//					}
//				}
//				return true;
//			}
			
			if (isDefiniteEarlyExit(tryExpression.getExpression())) {
				XCatchClause catchClause = tryExpression.getCatchClause();
				if (!isDefiniteEarlyExit(catchClause.getExpression())) {
					return false;
				}
				
				return true;
			}
			return false;
		} else if (expression instanceof XBlockExpression) {
			List<XExpression> expressions = ((XBlockExpression) expression).getExpressions();
			for(int i = expressions.size() - 1; i >= 0; i--) {
				if (isDefiniteEarlyExit(expressions.get(i))) {
					return true;
				}
			}
		}
		return expression instanceof XReturnExpression || expression instanceof XThrowExpression;
	}
	
}
