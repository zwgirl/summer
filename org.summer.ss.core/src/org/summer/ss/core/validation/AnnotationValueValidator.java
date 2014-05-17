/**
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.summer.ss.core.validation;

import java.util.Arrays;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.validation.ValidationMessageAcceptor;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.summer.dsl.model.types.JvmAnnotationReference;
import org.summer.dsl.model.xbase.XAbstractFeatureCall;
import org.summer.dsl.model.xbase.XExpression;
import org.summer.dsl.model.xbase.XListLiteral;
import org.summer.dsl.xbase.validation.ConstantExpressionValidator;
import org.summer.dsl.xbase.validation.IssueCodes;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@SuppressWarnings("all")
public class AnnotationValueValidator extends ConstantExpressionValidator {
  public void validateAnnotationValue(final XExpression value, final ValidationMessageAcceptor acceptor) {
    boolean _isValidAnnotationValue = this.isValidAnnotationValue(value);
    boolean _not = (!_isValidAnnotationValue);
    if (_not) {
      acceptor.acceptError("The value for an annotation attribute must be a constant expression", value, null, 
        ValidationMessageAcceptor.INSIGNIFICANT_INDEX, IssueCodes.ANNOTATIONS_ILLEGAL_ATTRIBUTE);
    }
  }
  
  protected boolean _isValidAnnotationValue(final XExpression expression) {
    return super.isConstant(expression);
  }
  
  protected boolean _isValidAnnotationValue(final Void nullValue) {
    return true;
  }
  
  protected boolean _isValidAnnotationValue(final XListLiteral expression) {
    boolean _or = false;
    EList<XExpression> _elements = expression.getElements();
    boolean _isEmpty = _elements.isEmpty();
    if (_isEmpty) {
      _or = true;
    } else {
      EList<XExpression> _elements_1 = expression.getElements();
      final Function1<XExpression,Boolean> _function = new Function1<XExpression,Boolean>() {
        public Boolean apply(final XExpression it) {
          boolean _isValidAnnotationValue = AnnotationValueValidator.this.isValidAnnotationValue(it);
          return Boolean.valueOf(_isValidAnnotationValue);
        }
      };
      boolean _forall = IterableExtensions.<XExpression>forall(_elements_1, _function);
      _or = (_isEmpty || _forall);
    }
    return _or;
  }
  
  protected boolean _isValidAnnotationValue(final JvmAnnotationReference expression) {
    return true;
  }
  
  protected boolean _isValidAnnotationValue(final XAbstractFeatureCall expression) {
    boolean _isTypeLiteral = expression.isTypeLiteral();
    if (_isTypeLiteral) {
      return true;
    }
    return super.isConstant(expression);
  }
  
  protected boolean isValidAnnotationValue(final EObject expression) {
    if (expression instanceof XListLiteral) {
      return _isValidAnnotationValue((XListLiteral)expression);
    } else if (expression instanceof XAbstractFeatureCall) {
      return _isValidAnnotationValue((XAbstractFeatureCall)expression);
    } else if (expression instanceof JvmAnnotationReference) {
      return _isValidAnnotationValue((JvmAnnotationReference)expression);
    } else if (expression instanceof XExpression) {
      return _isValidAnnotationValue((XExpression)expression);
    } else if (expression == null) {
      return _isValidAnnotationValue((Void)null);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(expression).toString());
    }
  }
}
