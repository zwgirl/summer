/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.summer.dsl.model.types.impl;

import java.util.List;

import org.summer.dsl.model.types.JvmLowerBound;
import org.summer.dsl.model.types.JvmParameterizedTypeReference;
import org.summer.dsl.model.types.JvmType;
import org.summer.dsl.model.types.JvmTypeConstraint;
import org.summer.dsl.model.types.JvmTypeReference;
import org.summer.dsl.model.types.JvmUpperBound;
import org.summer.dsl.model.types.JvmWildcardTypeReference;
import org.summer.dsl.model.types.TypesPackage;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
class NameConcatHelper {

	enum NameType {
		ID, QUALIFIED, SIMPLE, TO_STRING
	}
	
	static void appendConstraintsName(StringBuilder result, List<JvmTypeConstraint> constraints, char innerClassDelimiter, NameType nameType) {
		if (constraints == null || constraints.isEmpty())
			return;
		int wasLength = result.length();
		boolean hasLowerBound = false;
		if (nameType != NameType.ID) {
			for (JvmTypeConstraint constraint : constraints) {
				if (constraint instanceof JvmLowerBound) {
					hasLowerBound = true;
					break;
				}
			}
		}
		for (JvmTypeConstraint constraint : constraints) {
			if (result.length() != wasLength)
				result.append(" & ");
			if (!hasLowerBound || constraint instanceof JvmLowerBound || nameType == NameType.ID) {
				switch(nameType) {
					case ID: result.append(constraint.getIdentifier()); break;
					case QUALIFIED: result.append(constraint.getQualifiedName(innerClassDelimiter)); break;
					case SIMPLE: result.append(constraint.getSimpleName()); break;
					case TO_STRING: result.append(constraint.toString()); break;
				}
			}
		}
	}

	static String computeFor(JvmWildcardTypeReference typeReference, char innerClassDelimiter, NameType nameType) {
		if (typeReference.eIsSet(TypesPackage.Literals.JVM_CONSTRAINT_OWNER__CONSTRAINTS)) {
			if (typeReference.getConstraints().size() == 1) {
				JvmTypeConstraint onlyConstraint = typeReference.getConstraints().get(0);
				if (nameType != NameType.ID && nameType != NameType.TO_STRING) {
					JvmTypeReference reference = onlyConstraint.getTypeReference();
					if (reference == null || (onlyConstraint instanceof JvmUpperBound && 
							Object.class.getCanonicalName().equals(onlyConstraint.getTypeReference().getIdentifier()))) {
						return "?";
					}
				} else if (nameType == NameType.ID && onlyConstraint.getTypeReference() == null) {
					return "?";
				}
			}
			StringBuilder mutableResult = new StringBuilder(64);
			mutableResult.append("? ");
			appendConstraintsName(mutableResult, typeReference.getConstraints(), innerClassDelimiter, nameType);
			return mutableResult.toString();
		}
		return "?";
	}
	
	static String computeFor(JvmParameterizedTypeReference typeReference, char innerClassDelimiter, NameType nameType) {
		if (typeReference.eIsSet(TypesPackage.Literals.JVM_PARAMETERIZED_TYPE_REFERENCE__TYPE)) {
			StringBuilder mutableResult = new StringBuilder(64);
			JvmType type = typeReference.getType();
			switch(nameType) {
				case ID: mutableResult.append(type.getIdentifier()); break;
				case QUALIFIED: mutableResult.append(type.getQualifiedName(innerClassDelimiter)); break;
				case SIMPLE: mutableResult.append(type.getSimpleName()); break;
				case TO_STRING: mutableResult.append(type.getIdentifier()); break;
			}
			if (typeReference.eIsSet(TypesPackage.Literals.JVM_PARAMETERIZED_TYPE_REFERENCE__ARGUMENTS)) {
				mutableResult.append("<");
				appendArguments(mutableResult, typeReference.getArguments(), innerClassDelimiter, nameType);
				mutableResult.append(">");
				return mutableResult.toString();
			}
			return mutableResult.toString();
		}
		return null;
	}

	static void appendArguments(StringBuilder result, List<JvmTypeReference> arguments, char innerClassDelimiter, NameType nameType) {
		if (arguments == null || arguments.isEmpty())
			return;
		int wasLength = result.length();
		for (JvmTypeReference argument : arguments) {
			if (result.length() != wasLength)
				result.append(", ");
			switch(nameType) {
				case ID: result.append(argument.getIdentifier()); break;
				case QUALIFIED: result.append(argument.getQualifiedName(innerClassDelimiter)); break;
				case SIMPLE: result.append(argument.getSimpleName()); break;
				case TO_STRING: result.append(argument.toString()); break;
			}
		}
	}
	
}
