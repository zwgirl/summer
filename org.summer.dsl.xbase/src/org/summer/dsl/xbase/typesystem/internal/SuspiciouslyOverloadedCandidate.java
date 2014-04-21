/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.summer.dsl.xbase.typesystem.internal;

import java.util.List;

import org.eclipse.jdt.annotation.NonNullByDefault;
import org.eclipse.jdt.annotation.Nullable;
import org.summer.dsl.model.types.JvmConstructor;
import org.summer.dsl.model.types.JvmIdentifiableElement;
import org.summer.dsl.model.types.JvmMember;
import org.summer.dsl.model.types.JvmType;
import org.eclipse.xtext.diagnostics.AbstractDiagnostic;
import org.eclipse.xtext.util.IAcceptor;
import org.eclipse.xtext.validation.EObjectDiagnosticImpl;
import org.summer.dsl.model.xbase.XAbstractFeatureCall;
import org.summer.dsl.model.xbase.XExpression;
import org.summer.dsl.model.xbase.XbasePackage;
import org.summer.dsl.xbase.typesystem.computation.IFeatureLinkingCandidate;
import org.summer.dsl.xbase.typesystem.computation.ILinkingCandidate;
import org.summer.dsl.xbase.typesystem.computation.ISuspiciouslyOverloadedCandidate;
import org.summer.dsl.xbase.typesystem.internal.util.FeatureKinds;
import org.summer.dsl.xbase.typesystem.references.LightweightTypeReference;
import org.summer.dsl.xbase.validation.IssueCodes;

/**
 * A linking candidate that was picked from an implicit {@code this} receiver
 * though an overloaded candidate on {@code it} exists.
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@NonNullByDefault
public class SuspiciouslyOverloadedCandidate implements IFeatureLinkingCandidate, ISuspiciouslyOverloadedCandidate {
	
	private final FeatureLinkingCandidate rejectedCandidate;
	private final FeatureLinkingCandidate chosenCandidate;
	
	protected SuspiciouslyOverloadedCandidate(FeatureLinkingCandidate chosenCandidate, FeatureLinkingCandidate rejectedCandidate) {
		this.chosenCandidate = chosenCandidate;
		this.rejectedCandidate = rejectedCandidate;
	}
	
	public FeatureLinkingCandidate getChosenCandidate() {
		return chosenCandidate;
	}
	
	public FeatureLinkingCandidate getRejectedCandidate() {
		return rejectedCandidate;
	}
	
	public ILinkingCandidate getPreferredCandidate(ILinkingCandidate other) {
		if (other instanceof FeatureLinkingCandidate) {
			FeatureLinkingCandidate right = (FeatureLinkingCandidate) other;
			CandidateCompareResult candidateCompareResult = compareTo(right);
			switch(candidateCompareResult) {
				case EQUALLY_INVALID:
					throw new IllegalStateException();
				case AMBIGUOUS:
					return chosenCandidate.createAmbiguousLinkingCandidate(right);
				case THIS:
					return this;
				case SUSPICIOUS_OTHER:
				default:
					return new SuspiciouslyOverloadedCandidate(right, rejectedCandidate);
				
			}
		}
		throw new IllegalArgumentException("other was " + other);
	}
	
	protected CandidateCompareResult compareTo(AbstractPendingLinkingCandidate<?> right) {
		CandidateCompareResult result = chosenCandidate.compareTo(right);
		return result;
	}
	
	public void applyToComputationState() {
		chosenCandidate.getState().getResolvedTypes().reassignLinkingInformation(chosenCandidate.getExpression(), this);
		chosenCandidate.applyToComputationState();
	}

	public void applyToModel() {
		chosenCandidate.applyToModel();
	}

	public boolean validate(IAcceptor<? super AbstractDiagnostic> result) {
		if (chosenCandidate.validate(result)) {
			StringBuilder messageBuilder = new StringBuilder("Suspiciously overloaded method.\n");
			messageBuilder.append("The ").append(getFeatureTypeName()).append("\n\t");
			appendCandidate(chosenCandidate, messageBuilder);
			messageBuilder.append("\noverloads the ").append(getFeatureTypeName()).append("\n\t");
			appendCandidate(rejectedCandidate, messageBuilder);
			messageBuilder.append(".");
			AbstractDiagnostic diagnostic = new EObjectDiagnosticImpl(chosenCandidate.getState().getSeverity(IssueCodes.SUSPICIOUSLY_OVERLOADED_FEATURE),
					IssueCodes.SUSPICIOUSLY_OVERLOADED_FEATURE, messageBuilder.toString(), getExpression(),
					XbasePackage.Literals.XABSTRACT_FEATURE_CALL__FEATURE, -1, null);
			result.accept(diagnostic);
		}
		return false;
	}

	protected void appendCandidate(FeatureLinkingCandidate candidate, StringBuilder result) {
		if (!candidate.getDeclaredTypeParameters().isEmpty()) {
			result.append(candidate.getFeatureTypeParametersAsString(true)).append(' ');
		}
		JvmIdentifiableElement feature = candidate.getFeature();
		result.append(feature.getSimpleName());
		result.append(candidate.getFeatureParameterTypesAsString());
		XAbstractFeatureCall receiver = (XAbstractFeatureCall) candidate.getImplicitReceiver();
		JvmIdentifiableElement element = receiver.getFeature();
		String declarator = getDeclaratorSimpleName(feature);
		if (declarator != null) {
			result.append(" in ");
			if (!(element instanceof JvmType)) {
				if (candidate.isExtension()) {
					result.append(FeatureKinds.getTypeName(element));
					result.append(" extension ");
				}
			}
			result.append(declarator);
		}
		if (element instanceof JvmType) {
			result.append(" on 'this'");
		} else {
			String simpleName = element.getSimpleName();
			if (simpleName.charAt(0) != '_') {
				result.append(" on ").append(FeatureKinds.getTypeName(element)).append(" '").append(simpleName).append("'");
			}
		}
	}
	
	protected String getFeatureTypeName() {
		return chosenCandidate.getFeatureTypeName();
	}

	@Nullable
	protected String getDeclaratorSimpleName(JvmIdentifiableElement element) {
		if (element instanceof JvmConstructor) {
			return null;
		}
		if (element instanceof JvmMember) {
			return ((JvmMember) element).getDeclaringType().getSimpleName();
		}
		return null;
	}
	
	@Nullable
	public JvmIdentifiableElement getFeature() {
		return chosenCandidate.getFeature();
	}

	public XExpression getExpression() {
		return chosenCandidate.getExpression();
	}

	public List<LightweightTypeReference> getTypeArguments() {
		return chosenCandidate.getTypeArguments();
	}

	public XAbstractFeatureCall getFeatureCall() {
		return chosenCandidate.getFeatureCall();
	}

	public boolean isStatic() {
		return chosenCandidate.isStatic();
	}

	public boolean isExtension() {
		return chosenCandidate.isExtension();
	}

	public boolean isTypeLiteral() {
		return chosenCandidate.isTypeLiteral();
	}
}
