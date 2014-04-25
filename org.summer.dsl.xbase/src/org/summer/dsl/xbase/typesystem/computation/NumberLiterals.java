/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.summer.dsl.xbase.typesystem.computation;

import static org.eclipse.xtext.util.Strings.*;

import java.math.BigDecimal;
import java.math.BigInteger;

import org.summer.dsl.model.types.JvmType;
import org.summer.dsl.model.xbase.XNumberLiteral;
import org.summer.dsl.xbase.scoping.batch.BuildInTypes;
import org.summer.dsl.xbase.scoping.batch.Buildin;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public class NumberLiterals {

	public int getBase(XNumberLiteral literal) {
		if (isHex(literal))
			return 16;
		else
			return 10;
	}

	protected String getTypeQualifier(XNumberLiteral literal) {
		String valueAsLowerCase = literal.getValue().toLowerCase();
		switch (getBase(literal)) {
			case 16:
				int index = valueAsLowerCase.indexOf('#');
				if (index != -1)
					return valueAsLowerCase.substring(index + 1);
				else
					return "";
			case 10:
				if (valueAsLowerCase.endsWith("bi") || valueAsLowerCase.endsWith("bd"))
					return valueAsLowerCase.substring(valueAsLowerCase.length() - 2);
				char lastChar = valueAsLowerCase.charAt(literal.getValue().length() - 1);
				switch (lastChar) {
					case 'l':
					case 'd':
					case 'f':
						return Character.toString(lastChar);
					default:
						return "";
				}
			default:
				throw new IllegalArgumentException("Invalid number literal base " + getBase(literal));
		}
	}

	public String toJavaLiteral(XNumberLiteral literal) {
		if (getJavaType(literal).isPrimitive())
			return literal.getValue().replace("_", "").replace("#", "");
		else
			return null;
	}

	public String getDigits(XNumberLiteral literal) {
		return getXbaseDigits(literal).replace("_", "");
	}

	protected String getXbaseDigits(XNumberLiteral literal) {
		String value = literal.getValue();
		int length = value.length();
		String typeQualifier = getTypeQualifier(literal);
		switch (getBase(literal)) {
			case 10:
				return value.substring(0, length - typeQualifier.length());
			case 16:
				if (equal("", typeQualifier))
					return value.substring(2, length - typeQualifier.length());
				else
					return value.substring(2, length - typeQualifier.length() - 1);
			default:
				throw new IllegalArgumentException("Invalid number literal base " + getBase(literal));
		}
	}

	protected boolean isFloatingPoint(XNumberLiteral literal) {
		if (literal.getValue().indexOf('.') != -1) {
			return true;
		}
		String lowerCaseValue = literal.getValue().toLowerCase();
		switch (getBase(literal)) {
			case 16:
				return false;
			case 10:
				if (lowerCaseValue.indexOf('e') != -1)
					return true;
				char lastChar = lowerCaseValue.charAt(literal.getValue().length() - 1);
				return lastChar == 'd' || lastChar == 'f';
			default:
				throw new IllegalArgumentException("Invalid number literal base " + getBase(literal));
		}
	}

	//cym comment
	protected Class<? extends Number> getExplicitJavaType(XNumberLiteral literal) {
		String typeQualifier = getTypeQualifier(literal);
		if (equal("", typeQualifier))
			return null;
		else if (equal("f", typeQualifier))
			return Float.TYPE;
		else if (equal("l", typeQualifier))
			return Long.TYPE;
		else if (equal("d", typeQualifier))
			return Double.TYPE;
		else if (equal("bi", typeQualifier))
			return BigInteger.class;
		else if (equal("bd", typeQualifier))
			return BigDecimal.class;
		else
			throw new IllegalArgumentException("Invalid type qualifier " + typeQualifier);
	}
	
	//cym add
	protected JvmType getExplicitType(XNumberLiteral literal) {
		
		if(isFloatingPoint(literal)){
			BigDecimal bd = toBigDecimal(literal);
			double value = bd.doubleValue();
			if(value<Float.MAX_VALUE && value>Float.MIN_VALUE){
				return Buildin.Float.Type;
			}else{
				return Buildin.Float.Type;
			}
		}else{
			BigInteger bi = toBigInteger(literal);
			Long value = bi.longValue();
			if(value <Byte.MAX_VALUE  && value >Byte.MIN_VALUE){
				return Buildin.Byte.Type;
			} else if(value <Short.MAX_VALUE  && value >Short.MIN_VALUE){
				return Buildin.Short.Type;
			} else if(value <Integer.MAX_VALUE  && value >Integer.MIN_VALUE){
				return Buildin.Integer.Type;
			} 
			
			throw new IllegalArgumentException("Invalid type qualifier ");
		}
		
		
		
//		String typeQualifier = getTypeQualifier(literal);
//		if (equal("", typeQualifier))
//			return null;
//		else if (equal("f", typeQualifier))
//			return BuildInTypes.getInstance().getFloatType(literal.eResource());
////		else if (equal("l", typeQualifier))
////			return Long.TYPE;
//		else if (equal("d", typeQualifier))
//			return BuildInTypes.getInstance().getDoubleType(literal.eResource());
////		else if (equal("bi", typeQualifier))
////			return BigInteger.class;
////		else if (equal("bd", typeQualifier))
////			return BigDecimal.class;
//		else{
//			if(isFloatingPoint(literal)){
//				BigDecimal bd = toBigDecimal(literal);
//				double value = bd.doubleValue();
//				if(value>Float.MAX_VALUE || value<Float.MIN_VALUE){
//					return BuildInTypes.getInstance().getDoubleType(literal.eResource());
//				}else{
//					return BuildInTypes.getInstance().getFloatType(literal.eResource());
//				}
//			}else{
//				BigInteger bi = toBigInteger(literal);
//				Long value = bi.longValue();
//				if(value <Byte.MAX_VALUE  && value >Byte.MIN_VALUE){
//					return BuildInTypes.getInstance().getByteType(literal.eResource());
//				} else if(value <Short.MAX_VALUE  && value >Short.MIN_VALUE){
//					return BuildInTypes.getInstance().getShortType(literal.eResource());
//				} else if(value <Integer.MAX_VALUE  && value >Integer.MIN_VALUE){
//					return BuildInTypes.getInstance().getIntegerType(literal.eResource());
//				} 
//			}
//			throw new IllegalArgumentException("Invalid type qualifier " + typeQualifier);
//		}
			
	}

	public Class<? extends Number> getJavaType(XNumberLiteral literal) {
		Class<? extends Number> explicitType = getExplicitJavaType(literal);
		return (explicitType == null) ? (isFloatingPoint(literal)) ? Double.TYPE : Integer.TYPE : explicitType;
	}
	
	public JvmType getType(XNumberLiteral literal) {
		JvmType explicitType = getExplicitType(literal);
		return (explicitType == null) ? (isFloatingPoint(literal)) ? Buildin.Double.Type
				: Buildin.Integer.Type : explicitType;
	}

	public Number numberValue(XNumberLiteral literal, Class<?> numberType) {
		if (numberType == Integer.TYPE || numberType == Integer.class) {
			BigInteger asBigInt = toBigInteger(literal);
			BigInteger shiftRight = asBigInt.shiftRight(32);
			if (shiftRight.getLowestSetBit() != -1 || asBigInt.testBit(31) && getBase(literal) == 10)
				throw new NumberFormatException("Integer literal is out of range: " + literal.getValue());
			return asBigInt.intValue();
		} else if (numberType == Double.TYPE || numberType == Double.class)
			return Double.parseDouble(getDigits(literal));
		else if (numberType == Long.TYPE || numberType == Long.class) {
			BigInteger asBigInt = toBigInteger(literal);
			BigInteger shiftRight = asBigInt.shiftRight(64);
			if (shiftRight.getLowestSetBit() != -1 || asBigInt.testBit(63) && getBase(literal) == 10)
				throw new NumberFormatException("Long literal is out of range: " + literal.getValue());
			return asBigInt.longValue();
		} else if (numberType == Float.TYPE || numberType == Float.class)
			return Float.parseFloat(getDigits(literal));
		else if (numberType == Byte.TYPE || numberType == Byte.class)
			return Byte.parseByte(getDigits(literal));
		else if (numberType == BigInteger.class)
			return toBigInteger(literal);
		else if (numberType == BigDecimal.class)
			return toBigDecimal(literal);
		else
			throw new IllegalArgumentException("Cannot convert number literal to type" + numberType.getCanonicalName());
	}

	public BigInteger toBigInteger(XNumberLiteral literal) {
		if (isFloatingPoint(literal))
			return toBigDecimal(literal).toBigInteger();
		else
			return new BigInteger(getDigits(literal), getBase(literal));
	}
	
	public String getExponent(XNumberLiteral literal, String digits) {
		if (isHex(literal))
			return null;
		int e = digits.indexOf('e');
		if (e == -1) {
			e = digits.indexOf('E');
		}
		if (e != -1) {
			if (e != digits.length() - 1 && (digits.charAt(e + 1) == '+' || digits.charAt(e + 1) == '-')) {
				e++;
			}
			if (e < digits.length() - 1) {
				String exponent = digits.substring(e + 1);
				return exponent;
			}
		}
		return null;
	}

	protected boolean isHex(XNumberLiteral literal) {
		String text = literal.getValue();
		if (text.length() >= 2) {
			char second = text.charAt(1);
			return text.charAt(0) == '0' && (second == 'X' || second =='x');
		}
		return false;
	}

	public BigDecimal toBigDecimal(XNumberLiteral literal) {
		if (isFloatingPoint(literal)) {
			String digits = getDigits(literal);
			String exponent = getExponent(literal, digits);
			if (exponent != null && exponent.length() > 10) {
				throw new NumberFormatException("Too many nonzero exponent digits.");
			}
			return new BigDecimal(digits);
		} else {
			int base = getBase(literal);
			switch (base) {
				case 16:
					return new BigDecimal(new BigInteger(getDigits(literal), base));
				case 10:
					return new BigDecimal(getDigits(literal));
				default:
					throw new IllegalArgumentException("Invalid number literal base " + base);
			}
		}
	}
}
