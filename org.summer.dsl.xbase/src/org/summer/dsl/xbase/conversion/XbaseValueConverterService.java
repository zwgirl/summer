/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.summer.dsl.xbase.conversion;

import java.util.Set;

import org.eclipse.xtext.common.services.DefaultTerminalConverters;
import org.eclipse.xtext.conversion.IValueConverter;
import org.eclipse.xtext.conversion.ValueConverter;
import org.eclipse.xtext.conversion.ValueConverterException;
import org.eclipse.xtext.conversion.impl.AbstractValueConverter;
import org.eclipse.xtext.conversion.impl.INTValueConverter;
import org.eclipse.xtext.conversion.impl.KeywordAlternativeConverter;
import org.eclipse.xtext.conversion.impl.KeywordBasedValueConverter;
import org.eclipse.xtext.conversion.impl.QualifiedNameValueConverter;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.util.Strings;

import com.google.common.collect.ImmutableSet;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.Singleton;

/**
 * <p>The value converter service for Xbase. It registers
 * the {@link QualifiedNameValueConverter} and a {@link KeywordBasedValueConverter}
 * for each operator.</p>
 * <p>Clients, who extend Xbase should inherit from this value converter service.</p>
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@Singleton
public class XbaseValueConverterService extends DefaultTerminalConverters {
	
//	public static class OtherOperatorsValueConverter extends AbstractValueConverter<String> {
//
//		private final static Set<String> operators = ImmutableSet.of(
//			"->",
//			"..",
//			"..<",
//			">..",
//			"=>",
//			">>",
//			">>>",
//			"<<",
//			"<<<",
//			"<>",
//			"?:",
//			"<=>"
//			
//			,"?",
//			"++",
//			"--"
//				
//				);
//		
//		public String toValue(String string, INode node) throws ValueConverterException {
//			return string;
//		}
//
//		public String toString(String value) throws ValueConverterException {
//			if (!operators.contains(value))
//				throw new ValueConverterException("'" + value + "' is not a valid operator.", null, null);
//			return value;
//		}
//		
//	}
	
	public static class MultiAssignOperatorsValueConverter extends AbstractValueConverter<String> {

		private final static Set<String> operators = ImmutableSet.of(
			"+=",
			"-=",
			"*=",
			"/=",
			"&=",
			"|=",
			"^=",
			"%=",
			"<<=",
			">>=",
			">>>=");
		
		public String toValue(String string, INode node) throws ValueConverterException {
			return string;
		}

		public String toString(String value) throws ValueConverterException {
			if (!operators.contains(value))
				throw new ValueConverterException("'" + value + "' is not a valid operator.", null, null);
			return value;
		}
		
	}
	
	public static class ShiftOperatorsValueConverter extends AbstractValueConverter<String> {

		private final static Set<String> operators = ImmutableSet.of(
			"<<",
			">>",
			">>>");
		
		public String toValue(String string, INode node) throws ValueConverterException {
			return string;
		}

		public String toString(String value) throws ValueConverterException {
			if (!operators.contains(value))
				throw new ValueConverterException("'" + value + "' is not a valid operator.", null, null);
			return value;
		}
		
	}

	@Inject
	private XbaseQualifiedNameValueConverter qualifiedNameValueConverter;
	
	@Inject
	private Provider<KeywordBasedValueConverter> keywordBasedConverterProvider;
	
	@Inject
	private MultiAssignOperatorsValueConverter multiAssignOperatorsValueConverter;
	
	@Inject
	private ShiftOperatorsValueConverter shiftOperatorsValueConverter;
	
//	@Inject
//	private OtherOperatorsValueConverter otherOperatorsValueConverter;
	
	@Inject
	private KeywordAlternativeConverter validIDConverter;
	
	@Inject
	private KeywordAlternativeConverter featureCallIDConverter;
	
	@Inject
	private KeywordAlternativeConverter idOrSuperConverter;
	
	@ValueConverter(rule = "IdOrSuper")
	public IValueConverter<String> getIdOrSuperValueConverter() {
		return idOrSuperConverter;
	}
	
	@ValueConverter(rule = "ValidID")
	public IValueConverter<String> getValidIDConverter() {
		return validIDConverter;
	}
	
	@ValueConverter(rule = "FeatureCallID")
	public IValueConverter<String> getFeatureCallIDValueConverter() {
		return featureCallIDConverter;
	}
	
	@ValueConverter(rule = "QualifiedName")
	public IValueConverter<String> getQualifiedNameValueConverter() {
		return qualifiedNameValueConverter;
	}
	
	@ValueConverter(rule = "QualifiedNameWithWildcard")
	public IValueConverter<String> getQualifiedNameWithWildCardValueConverter() {
		return getQualifiedNameValueConverter();
	}
	
	@ValueConverter(rule = "OpSingleAssign")
	public IValueConverter<String> getOpSingleAssignConverter() {
		return keywordBasedConverterProvider.get();
	}
	
	//cym comment
//	@ValueConverter(rule = "OpMultiAssign")
//	public IValueConverter<String> getOpMultiAssignConverter() {
//		return keywordBasedConverterProvider.get();
//	}
	
	@ValueConverter(rule = "OpMultiAssign")
	public IValueConverter<String> getOpMultiAssignConverter() {
		return multiAssignOperatorsValueConverter;
	}
	
	@ValueConverter(rule = "OpOr")
	public IValueConverter<String> getOpOrConverter() {
		return keywordBasedConverterProvider.get();
	}
	
	@ValueConverter(rule = "OpAnd")
	public IValueConverter<String> getOpAndConverter() {
		return keywordBasedConverterProvider.get();
	}
	
	@ValueConverter(rule = "OpEquality")
	public IValueConverter<String> getOpEqualityConverter() {
		return keywordBasedConverterProvider.get();
	}
	
	@ValueConverter(rule = "OpCompare")
	public IValueConverter<String> getOpCompareConverter() {
		return keywordBasedConverterProvider.get();
	}
	
//	@ValueConverter(rule = "OpOther")
//	public IValueConverter<String> getOpOtherConverter() {
//		return otherOperatorsValueConverter;
//	}
	
	@ValueConverter(rule = "ShiftOp")
	public IValueConverter<String> getShiftOpConverter() {
		return shiftOperatorsValueConverter;
	}
	
	
	@ValueConverter(rule = "OpAdd")
	public IValueConverter<String> getOpAddConverter() {
		return keywordBasedConverterProvider.get();
	}
	
	@ValueConverter(rule = "OpMulti")
	public IValueConverter<String> getOpMultiConverter() {
		return keywordBasedConverterProvider.get();
	}
	
	@ValueConverter(rule = "OpUnary")
	public IValueConverter<String> getOpUnaryConverter() {
		return keywordBasedConverterProvider.get();
	}
	
	@Inject
	private IntUnderscoreValueConverter intUnderscoreValueConverter;
	
	@Override
	@ValueConverter(rule = "INT")
	public IValueConverter<Integer> INT() {
		return intUnderscoreValueConverter;
	}
	
	public static class IntUnderscoreValueConverter extends INTValueConverter {
		@Override
		public Integer toValue(String string, INode node) {
			if (Strings.isEmpty(string))
				throw new ValueConverterException("Couldn't convert empty string to an int value.", node, null);
			String withoutUnderscore = string.replace("_", "");
			if (Strings.isEmpty(withoutUnderscore))
				throw new ValueConverterException("Couldn't convert input '" + string + "' to an int value.", node, null);
			return super.toValue(withoutUnderscore, node);
		}
	}
}
