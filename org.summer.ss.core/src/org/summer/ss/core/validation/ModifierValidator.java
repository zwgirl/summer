/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.summer.ss.core.validation;

import static com.google.common.collect.Sets.newHashSet;
import static org.eclipse.xtext.util.Strings.equal;
import static org.summer.dsl.model.types.TypesPackage.Literals.JVM_MEMBER__MODIFIERS;

import java.util.List;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.validation.AbstractDeclarativeValidator;
import org.eclipse.xtext.validation.Check;
import org.summer.dsl.model.types.JvmMember;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public class ModifierValidator {

	private static final Set<String> visibilityModifers = newHashSet("public", "protected", "package", "private");
	
	private Set<String> allowedModifiers;
	private AbstractDeclarativeValidator validator;

	private String allowedModifiersAsString;

	
	public ModifierValidator(List<String> allowedModifiers, AbstractDeclarativeValidator validator) {
		this.allowedModifiers = newHashSet(allowedModifiers);
		this.validator = validator;
		StringBuilder buffer = new StringBuilder();
		
		boolean comma = false;
		for(int i=0; i<allowedModifiers.size(); ++i) {
			if(comma){
				buffer.append(", ");
			}
			
			buffer.append(allowedModifiers.get(i));
			comma = true;
		}
		allowedModifiersAsString = buffer.toString();
	}
	
	@Check
	protected void checkModifiers(JvmMember member, String memberName) {
		Set<String> seenModifiers = newHashSet();
		boolean visibilitySeen = false;
		boolean virtualSeen = false;

		for(int i=0; i<member.getModifiers().size(); ++i) {
			String modifier = member.getModifiers().get(i);
			if(!allowedModifiers.contains(modifier)) { 
				error("Illegal modifier for the " + memberName + "; only " + allowedModifiersAsString + " are permitted",
						member, i);
			}
			if(seenModifiers.contains(modifier)) 
				error("Duplicate modifier for the " + memberName, 
						member, i);
			else {
				seenModifiers.add(modifier);
				if(visibilityModifers.contains(modifier)) {
					if(visibilitySeen) 
						error("The " + memberName +" can only set one of public / package / protected / private", 
								member, i);
					visibilitySeen = true;
				}
			} 
			if(equal(modifier, "override")){
				if(virtualSeen) {
					error("The " + memberName + " can either be virtual or override, not both",
							member, i);
				}
				virtualSeen = true;
			} 
		}
	}
	
	protected void error(String message, EObject source, int index) {
		validator.acceptError(message, source, JVM_MEMBER__MODIFIERS, index, IssueCodes.INVALID_MODIFIER);
	}


}
