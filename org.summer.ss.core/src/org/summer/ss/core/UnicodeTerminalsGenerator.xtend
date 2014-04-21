/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.summer.ss.core

import com.google.common.base.Strings
import java.io.PrintWriter
import java.io.StringWriter

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
package class UnicodeTerminalsGenerator {
	
	def static void main(String[] args) {
		println(generateUnicodeRules)
	}
	
	def static generateUnicodeRules() '''
		terminal fragment IDENTIFIER_START:
			�generateUnicodeRules [ Character.isJavaIdentifierStart(it) ] �
		;
		
		terminal fragment IDENTIFIER_PART:
			IDENTIFIER_START | IDENTIFIER_PART_IMPL
		;
		
		terminal fragment IDENTIFIER_PART_IMPL:
			�generateUnicodeRules [ Character.isJavaIdentifierPart(it) && !Character.isJavaIdentifierStart(it) ] �
		;
	'''
	
	def static generateUnicodeRules((int)=>boolean guard) {
		var Character prev = null;
		var run = false;
		var first = true;
		var char c = Character.MIN_VALUE
		val result = new StringWriter
		val printer = new PrintWriter(result, true)
		while(true) {
			if (guard.apply(c as int)) {
				if (!run) {
					prev = c;
					run = true;
				}
			} else {
				if (run) {
					if (!first) {
						printer.print("| ");
					} else {
						printer.print("  ");
						first = false;
					}
					printer.print("'\\u" + Strings.padStart(Integer.toHexString(prev).toUpperCase(), 4, '0') + "'"); 
					if (prev.charValue() == c - 1) {
						printer.println();
					} else {
						printer.println("..'\\u" + Strings.padStart(Integer.toHexString(c - 1).toUpperCase(), 4, '0') + "'");
					}
					prev = null;
					run = false;
				}
			}
			c = (c + 1) as char
			if (c == Character.MAX_VALUE) {
				return result;
			}
		}
		
	}
	
	
}
