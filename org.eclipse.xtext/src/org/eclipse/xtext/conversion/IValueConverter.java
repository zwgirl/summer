/*******************************************************************************
 * Copyright (c) itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.conversion;

import org.eclipse.xtext.AbstractRule;
import org.eclipse.xtext.nodemodel.INode;

/**
 * A {@link ValueConverter} is used to create a semantic value from 
 * an input string or node and vice versa.
 * 
 * @author Sven Efftinge - Initial contribution and API
 */
public interface IValueConverter<Type> {
	
	IValueConverter<? extends Object> NO_OP_CONVERTER = new IValueConverter<String>() {
		public String toString(String value) {
			return value;
		}
		public String toValue(String string, INode node) {
			return string;
		}
	};
	
	/**
	 * <p>Creates a value from the given input. The input is conformant
	 * to a data type or terminal rule.</p> 
	 * 
	 * <p>The given <code>string</code>
	 * or <code>node</code> may be null but not both of them.</p>
	 * 
	 * @param string the string that was inferred from the node. Usually the node's text
	 * but may be reduced to the parts of the node that are not 
	 * {@link org.eclipse.xtext.nodemodel.ILeafNode#isHidden() hidden}.
	 * 
	 * @param node the parsed node including hidden parts.
	 * @return the new value or <code>null</code>.
	 * @throws ValueConverterException indicates that the string or node did not fulfil
	 * the expected format.
	 */
	Type toValue(String string, INode node) throws ValueConverterException;
	
	/**
	 * Transforms the given value to a string that is conformant to the expected
	 * terminal or data type rule.
	 * @param value the to-be-transformed value
	 * @return a string represenation for that value.
	 * @throws ValueConverterException indicates that the value cannot be converted to a valid string.
	 */
	String toString(Type value) throws ValueConverterException;
	
	/**
	 * Value converters that rely on information about the actual rule
	 * that is converted, may implement this interface. The framework will
	 * set the rule according to the annotation of the method that provides
	 * the value converter.
	 */
	interface RuleSpecific {
		void setRule(AbstractRule rule);
	}
}
