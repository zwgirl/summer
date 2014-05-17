/**
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.summer.ss.core.validation;

import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import com.google.inject.Inject;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.validation.AbstractDeclarativeValidator;
import org.eclipse.xtext.validation.Check;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.summer.dsl.model.types.JvmAnnotationType;
import org.summer.dsl.model.types.JvmEnumerationType;
import org.summer.dsl.model.types.JvmField;
import org.summer.dsl.model.types.JvmGenericArrayTypeReference;
import org.summer.dsl.model.types.JvmGenericType;
import org.summer.dsl.model.types.JvmMember;
import org.summer.dsl.model.types.JvmPrimitiveType;
import org.summer.dsl.model.types.JvmType;
import org.summer.dsl.model.types.JvmTypeReference;
import org.summer.dsl.model.types.TypesPackage;
import org.summer.dsl.model.xbase.XExpression;
import org.summer.dsl.model.xbase.XbasePackage;
import org.summer.ss.core.validation.AnnotationValueValidator;
import org.summer.ss.core.validation.IssueCodes;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
@SuppressWarnings("all")
public class AnnotationValidation extends AbstractDeclarativeValidator {
  @Inject
  private AnnotationValueValidator annotationValueValidator;
  
  protected List<EPackage> getEPackages() {
    ArrayList<EPackage> _newArrayList = CollectionLiterals.<EPackage>newArrayList(XbasePackage.eINSTANCE);
    return _newArrayList;
  }
  
  @Check
  public void checkAnnotation(final JvmAnnotationType it) {
    EList<JvmMember> _members = it.getMembers();
    Iterable<JvmField> _filter = Iterables.<JvmField>filter(_members, JvmField.class);
    for (final JvmField field : _filter) {
      {
        JvmTypeReference _type = field.getType();
        boolean _isValidAnnotationValueType = this.isValidAnnotationValueType(_type);
        boolean _not = (!_isValidAnnotationValueType);
        if (_not) {
          StringConcatenation _builder = new StringConcatenation();
          _builder.append("Invalid type ");
          JvmTypeReference _type_1 = field.getType();
          String _simpleName = _type_1.getSimpleName();
          _builder.append(_simpleName, "");
          _builder.append(" for the annotation attribute ");
          String _simpleName_1 = field.getSimpleName();
          _builder.append(_simpleName_1, "");
          _builder.append("; only primitive type, String, Class, annotation, enumeration are permitted or 1-dimensional arrays thereof");
          this.error(_builder.toString(), field, 
            TypesPackage.Literals.JVM_FIELD__TYPE, 
            IssueCodes.INVALID_ANNOTATION_VALUE_TYPE);
        }
        XExpression _defaultValue = field.getDefaultValue();
        boolean _notEquals = (!Objects.equal(_defaultValue, null));
        if (_notEquals) {
          XExpression _defaultValue_1 = field.getDefaultValue();
          this.annotationValueValidator.validateAnnotationValue(_defaultValue_1, this);
        }
      }
    }
  }
  
	public boolean isValidAnnotationValueType(final JvmTypeReference reference) {
		JvmTypeReference result = reference;
		if (reference instanceof JvmGenericArrayTypeReference) {
			JvmTypeReference componentType = ((JvmGenericArrayTypeReference) reference)
					.getComponentType();
			result = componentType;
		} 
		
		if (Objects.equal(result, null)) {
			return true;
		}

//		if ((result.getType() instanceof JvmPrimitiveType)) {
//			return true;
//		}
		if ((result.getType() instanceof JvmGenericType)) {
			if(result.getType().getSimpleName().equals("Integer") ||
					result.getType().getSimpleName().equals("Number")
					||result.getType().getSimpleName().equals("Double")
					||result.getType().getSimpleName().equals("Boolean")){
				return true;
			}
		}
		if ((result.getType() instanceof JvmEnumerationType)) {
			return true;
		}
		if ((result.getType() instanceof JvmAnnotationType)) {
			return true;
		}
		boolean _or = false;
		if (Objects.equal(result.getType().getQualifiedName(), "String")
				|| Objects.equal(result.getType().getQualifiedName(), "Class")) {
			return true;
		}
		return false;
	}
}
