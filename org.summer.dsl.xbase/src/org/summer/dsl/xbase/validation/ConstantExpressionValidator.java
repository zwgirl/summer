/**
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.summer.dsl.xbase.validation;

import java.util.Arrays;

import org.eclipse.xtext.xbase.lib.Extension;
import org.summer.dsl.model.types.JvmEnumerationLiteral;
import org.summer.dsl.model.types.JvmField;
import org.summer.dsl.model.types.JvmIdentifiableElement;
import org.summer.dsl.model.types.JvmOperation;
import org.summer.dsl.model.types.util.Primitives;
import org.summer.dsl.model.types.util.TypeReferences;
import org.summer.dsl.model.xbase.XAbstractFeatureCall;
import org.summer.dsl.model.xbase.XBooleanLiteral;
import org.summer.dsl.model.xbase.XCastedExpression;
import org.summer.dsl.model.xbase.XExpression;
import org.summer.dsl.model.xbase.XNumberLiteral;
import org.summer.dsl.model.xbase.XStringLiteral;
import org.summer.dsl.model.xbase.XTypeLiteral;
import org.summer.dsl.model.xbase.XVariableDeclaration;
import org.summer.dsl.model.xbase.XVariableDeclarationList;
import org.summer.dsl.xbase.util.XExpressionHelper;

import com.google.inject.Inject;

/**
 * Checks whether a given XExpression is a a constant expression.
 * 
 * @author Sven Efftinge - Initial contribution and API
 */
@SuppressWarnings("all")
public class ConstantExpressionValidator {
  @Inject
  @Extension
  private TypeReferences typeReferences;
  
  @Inject
  @Extension
  private Primitives primitives;
  
  @Inject
  @Extension
  private XExpressionHelper _xExpressionHelper;
  
  protected boolean _isConstant(final XExpression expression) {
    return false;
  }
  
  protected boolean _isConstant(final XStringLiteral expression) {
    return true;
  }
  
  protected boolean _isConstant(final XTypeLiteral expression) {
    return true;
  }
  
  protected boolean _isConstant(final XNumberLiteral expression) {
    return true;
  }
  
  protected boolean _isConstant(final XBooleanLiteral expression) {
    return true;
  }
  
  protected boolean _isConstant(final XCastedExpression expression) {
//    boolean _or = false;
//    JvmTypeReference _type = expression.getType();
//    boolean _isPrimitive = this._primitives.isPrimitive(expression.getType());
//    if (this._primitives.isPrimitive(expression.getType())) {
//      _or = true;
//    } else {
//      JvmTypeReference _type_1 = expression.getType();
//      boolean _is = this._typeReferences.is(expression.getType(), String.class);
//      _or = (this._primitives.isPrimitive(expression.getType()) || this._typeReferences.is(expression.getType(), String.class));
//    }
    return (this.primitives.isPrimitive(expression.getType()) || this.typeReferences.is(expression.getType(), String.class));
  }
  
	protected boolean _isConstant(final XAbstractFeatureCall expression) {
		// JvmIdentifiableElement _feature = expression.getFeature();
		final JvmIdentifiableElement feature = expression.getFeature();

		if (feature instanceof JvmEnumerationLiteral) {
			return true;
		}

		if (feature instanceof JvmField) {
			JvmField field = (JvmField) feature;
			if (field.isStatic() && field.isConst()) {
				return true;
			}

			return false;
		}

		if (feature instanceof JvmOperation) {
			JvmOperation operation = (JvmOperation) feature;
		}

		// JvmOperation : {
		// val annotationReference = expression.findInlineAnnotation
		// if (annotationReference == null) {
		// return false
		// }
		// if
		// (annotationReference.values.filter(JvmBooleanAnnotationValue).exists
		// [
		// valueName=='constantExpression' && values.head.booleanValue
		// ]) {
		// val receiverConstant = if (expression.actualReceiver == null) {
		// true
		// } else {
		// expression.actualReceiver.isConstant
		// }
		// return receiverConstant &&
		// expression.actualArguments.forall[isConstant]
		// }
		// }
		if (feature instanceof XVariableDeclaration) {
			XVariableDeclaration decl = (XVariableDeclaration) feature;
			return ((XVariableDeclarationList) decl.eContainer()).isReadonly();
		}

		if (feature.eIsProxy()) {
			throw new RuntimeException();
		}
		return false;
	}
  
  public boolean isConstant(final XExpression expression) {
    if (expression instanceof XAbstractFeatureCall) {
      return _isConstant((XAbstractFeatureCall)expression);
    } else if (expression instanceof XBooleanLiteral) {
      return _isConstant((XBooleanLiteral)expression);
    } else if (expression instanceof XCastedExpression) {
      return _isConstant((XCastedExpression)expression);
    } else if (expression instanceof XNumberLiteral) {
      return _isConstant((XNumberLiteral)expression);
    } else if (expression instanceof XStringLiteral) {
      return _isConstant((XStringLiteral)expression);
    } else if (expression instanceof XTypeLiteral) {
      return _isConstant((XTypeLiteral)expression);
    } else if (expression != null) {
      return _isConstant(expression);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(expression).toString());
    }
  }
}
