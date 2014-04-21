/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.summer.dsl.xbase.typesystem.internal;

import java.util.Set;

import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.jdt.annotation.NonNullByDefault;
import org.summer.dsl.model.types.JvmIdentifiableElement;
import org.summer.dsl.model.xbase.XAbstractFeatureCall;
import org.summer.dsl.model.xbase.XBinaryOperation;
import org.summer.dsl.model.xbase.XExpression;
import org.summer.dsl.model.xbase.XUnaryOperation;
import org.summer.dsl.model.xbase.XbasePackage;
import org.summer.dsl.xbase.typesystem.computation.IFeatureLinkingCandidate;
import org.summer.dsl.xbase.typesystem.computation.ILinkingCandidate;

import com.google.common.collect.Sets;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@NonNullByDefault
public class AmbiguousFeatureLinkingCandidate extends AbstractAmbiguousLinkingCandidate<FeatureLinkingCandidate> implements IFeatureLinkingCandidate{

	protected AmbiguousFeatureLinkingCandidate(FeatureLinkingCandidate first, AbstractPendingLinkingCandidate<?> second) {
		super(first, second);
	}
	
	@Override
	protected String getSyntaxDescriptions() {
		XExpression expression = getExpression();
		if (expression instanceof XBinaryOperation) {
			return "binary operation";
		} else if (expression instanceof XUnaryOperation) {
			return "unary operation";
		} else {
			return "feature call";
		}
	}
	
	@Override
	protected String getFeatureTypeName() {
		XExpression expression = getExpression();
		if (expression instanceof XBinaryOperation || expression instanceof XUnaryOperation) {
			return "operator declaration";
		}
		if (getPrimaryCandidate().isExtension()) {
			return "extension method";
		}
		return super.getFeatureTypeName();
	}

	public XAbstractFeatureCall getFeatureCall() {
		return getPrimaryCandidate().getFeatureCall();
	}

	public boolean isStatic() {
		return getPrimaryCandidate().isStatic();
	}

	public boolean isExtension() {
		return getPrimaryCandidate().isExtension();
	}

	public boolean isTypeLiteral() {
		return getPrimaryCandidate().isTypeLiteral();
	}
	
	@Override
	protected EStructuralFeature getFeatureToMark() {
		return XbasePackage.Literals.XABSTRACT_FEATURE_CALL__FEATURE;
	}

	@Override
	protected String[] getDiagnosticData() {
		FeatureLinkingCandidate primaryCandidate = getPrimaryCandidate();
		XAbstractFeatureCall expression = primaryCandidate.getExpression();
		if (expression.isExplicitOperationCallOrBuilderSyntax()) {
			return null;
		}
		Set<String> data = Sets.newLinkedHashSet();
		for (ILinkingCandidate candidate : getAlternatives()) {
			JvmIdentifiableElement feature = candidate.getFeature();
			String simpleName = feature.getSimpleName();
			data.add(simpleName + "()");
		}
		return data.toArray(new String[data.size()]);
	}

}
