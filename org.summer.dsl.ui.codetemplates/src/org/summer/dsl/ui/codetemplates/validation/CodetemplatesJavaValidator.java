package org.summer.dsl.ui.codetemplates.validation;

import org.eclipse.xtext.validation.Check;
import org.summer.dsl.ui.codetemplates.templates.Dollar;
import org.summer.dsl.ui.codetemplates.templates.Variable;
 

public class CodetemplatesJavaValidator extends AbstractCodetemplatesJavaValidator {

	@Check
	public void checkDollarEscaped(Dollar dollar) {
		if (!dollar.isEscaped())
			error("Invalid escape sequence '$'", null);
	}
	
	@Override
	public boolean isLanguageSpecific() {
		return false;
	}

	/**
	 * @since 2.3
	 */
	@Check
	public void checkParameterListIsNotEmpty(Variable variable) {
		if (variable.isExpectingParameters()) {
			if (variable.getParameters().isEmpty()) {
				error("Parameter list may not be empty", null);
			}
		}
	}
	
}
