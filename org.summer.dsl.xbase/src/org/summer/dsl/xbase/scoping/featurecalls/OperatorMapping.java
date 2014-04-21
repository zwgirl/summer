/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.summer.dsl.xbase.scoping.featurecalls;

import static org.eclipse.xtext.naming.QualifiedName.*;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

import org.eclipse.xtext.naming.QualifiedName;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import com.google.inject.Singleton;

/**
 * The mapping of operators to their respective method names.
 * 
 * By default, the following mapping is applied.
 * <table>
 *   <tr><th>Operator</th><th>Method Name</th></tr>
 *   <tr><td>+</td><td>operator_plus</td></tr>
 *   <tr><td>-</td><td>operator_minus</td></tr>
 *   <tr><td>**</td><td>operator_power</td></tr>
 *   <tr><td>*</td><td>operator_multiply</td></tr>
 *   <tr><td>/</td><td>operator_divide</td></tr>
 *   <tr><td>%</td><td>operator_modulo</td></tr>
 *   <tr><td>&lt;&lt;</td><td>operator_doubleLessThan</td></tr>
 *   <tr><td>&gt;&gt;</td><td>operator_doubleGreaterThan</td></tr>
 *   <tr><td>&lt;&lt;&lt;</td><td>operator_tripleLessThan</td></tr>
 *   <tr><td>&gt;&gt;&gt;</td><td>operator_tripleGreaterThan</td></tr>
 *   <tr><td>?:</td><td>operator_elvis</td></tr>
 *   <tr><td>&lt;&gt;</td><td>operator_diamond</td></tr>
 *   <tr><td>&lt;=&gt;</td><td>operator_spaceship</td></tr>
 *   <tr><td>||</td><td>operator_or</td></tr>
 *   <tr><td>&&</td><td>operator_and</td></tr>
 *   <tr><td>+=</td><td>operator_add</td></tr>
 *   <tr><td>-=</td><td>operator_remove</td></tr>
 *   <tr><td>==</td><td>operator_equals</td></tr>
 *   <tr><td>===</td><td>operator_tripleEquals</td></tr>
 *   <tr><td>!==</td><td>operator_tripleNotEquals</td></tr>
 *   <tr><td>!=</td><td>operator_notEquals</td></tr>
 *   <tr><td>&lt;</td><td>operator_lessThan</td></tr>
 *   <tr><td>&lt;=</td><td>operator_lessEqualsThan</td></tr>
 *   <tr><td>&gt;</td><td>operator_greaterThan</td></tr>
 *   <tr><td>&gt;=</td><td>operator_greaterEqualsThan</td></tr>
 *   <tr><td>-&gt;</td><td>operator_mappedTo</td></tr>
 *   <tr><td>..</td><td>operator_upTo</td></tr>
 *   <tr><td>..&lt;</td><td>operator_doubleDotLessThan</td></tr>
 *   <tr><td>&gt;..</td><td>operator_greaterThanDoubleDot</td></tr>
 *   <tr><td>!</td><td>operator_not</td></tr>
 *   <tr><td>=&gt;</td><td>operator_doubleArrow</td></tr>
 * </table>
 * 
 * Clients may want to override {@link #initializeMapping()} to add other operators.
 * 
 * @author Sven Efftinge
 */
@Singleton
public class OperatorMapping {
	
	public static final QualifiedName PLUS = create("+");
	public static final QualifiedName MINUS = create("-");
	public static final QualifiedName POWER = create("**");
	public static final QualifiedName MULTIPLY = create("*");
	public static final QualifiedName DIVIDE = create("/");
	public static final QualifiedName MODULO = create("%");
	public static final QualifiedName DOUBLE_LESS_THAN = create("<<");
	public static final QualifiedName DOUBLE_GREATER_THAN = create(">>");
	public static final QualifiedName TRIPLE_LESS_THAN = create("<<<");
	public static final QualifiedName TRIPLE_GREATER_THAN = create(">>>");
	public static final QualifiedName ELVIS = create("?:");
	public static final QualifiedName DIAMOND = create("<>");
	public static final QualifiedName SPACESHIP = create("<=>");
	public static final QualifiedName OR = create("||");
	public static final QualifiedName AND = create("&&");
	public static final QualifiedName ADD = create("+=");
	public static final QualifiedName REMOVE = create("-=");
	public static final QualifiedName EQUALS = create("==");
	public static final QualifiedName TRIPLE_EQUALS = create("===");
	public static final QualifiedName TRIPLE_NOT_EQUALS = create("!==");
	public static final QualifiedName NOT_EQUALS = create("!=");
	public static final QualifiedName LESS_THAN = create("<");
	public static final QualifiedName LESS_EQUALS_THAN = create("<=");
	public static final QualifiedName GREATER_THAN = create(">");
	public static final QualifiedName GREATER_EQUALS_THAN = create(">=");
	public static final QualifiedName MAPPED_TO = create("->");
	public static final QualifiedName UP_TO = create("..");
	public static final QualifiedName DOUBLE_DOT_LESS_THAN = create("..<");
	public static final QualifiedName GREATER_THAN_DOUBLE_DOT = create(">..");
	public static final QualifiedName NOT = create("!");
	public static final QualifiedName DOUBLE_ARROW = create("++");
	
	//cym add
	public static final QualifiedName DOUBLE_ADD = create("++");
	public static final QualifiedName DOUBLE_SUB = create("--");
	public static final QualifiedName QUESTION = create("?");
	public static final QualifiedName INDEX = create("[");
	
	public static final QualifiedName DOUBLE_LEF_ARROW_EQUAL = create("<<=");
	public static final QualifiedName DOUBLE_RIGHT_ARROW_EQUAL = create(">>=");
	public static final QualifiedName THREE_ARROW_EQUAL = create(">>>=");
	
	protected BiMap<QualifiedName, QualifiedName> map = HashBiMap.create();
	
	{
		initializeMapping();
	}
	
	public final static String OP_PREFIX="operator_";
	
	protected void initializeMapping() {
		map.put(PLUS, create(OP_PREFIX+"plus"));
		map.put(MINUS, create(OP_PREFIX+"minus"));
		map.put(POWER, create(OP_PREFIX+"power"));
		map.put(MULTIPLY, create(OP_PREFIX+"multiply"));
		map.put(DIVIDE, create(OP_PREFIX+"divide"));
		map.put(MODULO, create(OP_PREFIX+"modulo"));
		map.put(DOUBLE_LESS_THAN, create(OP_PREFIX + "doubleLessThan"));
		map.put(DOUBLE_GREATER_THAN, create(OP_PREFIX + "doubleGreaterThan"));
		map.put(TRIPLE_LESS_THAN, create(OP_PREFIX + "tripleLessThan"));
		map.put(TRIPLE_GREATER_THAN, create(OP_PREFIX + "tripleGreaterThan"));
		map.put(ELVIS, create(OP_PREFIX + "elvis"));
		map.put(DIAMOND, create(OP_PREFIX + "diamond"));
		map.put(SPACESHIP, create(OP_PREFIX + "spaceship"));
		map.put(OR, create(OP_PREFIX+"or"));
		map.put(AND, create(OP_PREFIX+"and"));
		map.put(ADD, create(OP_PREFIX+"add"));
		map.put(REMOVE, create(OP_PREFIX+"remove"));
		map.put(EQUALS, create(OP_PREFIX+"equals"));
		map.put(TRIPLE_EQUALS, create(OP_PREFIX+"tripleEquals"));
		map.put(TRIPLE_NOT_EQUALS, create(OP_PREFIX+"tripleNotEquals"));
		map.put(NOT_EQUALS, create(OP_PREFIX+"notEquals"));
		map.put(LESS_THAN, create(OP_PREFIX+"lessThan"));
		map.put(LESS_EQUALS_THAN, create(OP_PREFIX+"lessEqualsThan"));
		map.put(GREATER_THAN, create(OP_PREFIX+"greaterThan"));
		map.put(GREATER_EQUALS_THAN, create(OP_PREFIX+"greaterEqualsThan"));
		map.put(MAPPED_TO, create(OP_PREFIX+"mappedTo"));
		map.put(UP_TO, create(OP_PREFIX+"upTo"));
		map.put(DOUBLE_DOT_LESS_THAN, create(OP_PREFIX+"doubleDotLessThan"));
		map.put(GREATER_THAN_DOUBLE_DOT, create(OP_PREFIX+"greaterThanDoubleDot"));
		map.put(NOT, create(OP_PREFIX+"not"));
		map.put(DOUBLE_ARROW, create(OP_PREFIX+"doubleArrow"));
		
		//cym add
		map.put(DOUBLE_ADD, create(OP_PREFIX+"doubleAdd"));
		map.put(DOUBLE_SUB, create(OP_PREFIX+"doubleSub"));
		map.put(QUESTION, create(OP_PREFIX+"question"));
		map.put(INDEX, create(OP_PREFIX+"index"));
		map.put(QUESTION, create(OP_PREFIX+"question"));
		map.put(INDEX, create(OP_PREFIX+"index"));
		
		map.put(DOUBLE_LEF_ARROW_EQUAL, create(OP_PREFIX+"doubleRightArrowEqual"));
		map.put(DOUBLE_RIGHT_ARROW_EQUAL, create(OP_PREFIX+"doubleArrow"));
		map.put(THREE_ARROW_EQUAL, create(OP_PREFIX+"ThreeArrowEqual"));
	}
	
	public QualifiedName getMethodName(QualifiedName operator) {
		return map.get(operator);
	}
	
	public QualifiedName getOperator(QualifiedName methodName) {
		return map.inverse().get(methodName);
	}
	
	/**
	 * Small utility to keep the JavaDoc in sync.
	 */
	@SuppressWarnings("unused")
	private static class JavaDocGenerator { 
		public static void main(String[] args) throws Exception {
			System.out.println(" * <table>");
			System.out.println(" *   <tr><th>Operator</th><th>Method Name</th></tr>");
			Field[] fields = OperatorMapping.class.getFields();
			BiMap<QualifiedName, QualifiedName> map = new OperatorMapping().map;
			for(Field field: fields) {
				if (Modifier.isStatic(field.getModifiers()) && field.getType().equals(QualifiedName.class) ) {
					Object operator = field.get(null);
					QualifiedName methodName = map.get(operator);
					System.out.println(" *   <tr><td>"+ toHtml(operator) + "</td><td>" + toHtml(methodName) + "</td></tr>");
				}
			}
			System.out.println(" * </table>");
		}
		
		private static String toHtml(Object object) {
			String result = String.valueOf(object);
			result = result.replace("<", "&lt;").replace(">", "&gt;");
			return result;
		}
	}
}	
