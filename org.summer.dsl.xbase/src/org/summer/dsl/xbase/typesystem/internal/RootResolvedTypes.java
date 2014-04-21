/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.summer.dsl.xbase.typesystem.internal;

import java.util.EnumSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jdt.annotation.NonNullByDefault;
import org.eclipse.jdt.annotation.Nullable;
import org.summer.dsl.model.types.JvmFormalParameter;
import org.summer.dsl.model.types.JvmIdentifiableElement;
import org.summer.dsl.model.types.JvmMember;
import org.summer.dsl.model.types.JvmTypeReference;
import org.eclipse.xtext.diagnostics.AbstractDiagnostic;
import org.eclipse.xtext.diagnostics.Severity;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.util.IAcceptor;
import org.eclipse.xtext.validation.EObjectDiagnosticImpl;
import org.eclipse.xtext.validation.IssueSeverities;
import org.summer.dsl.model.xbase.XExpression;
import org.summer.dsl.model.xbase.XbasePackage;
import org.summer.dsl.xbase.typesystem.computation.ILinkingCandidate;
import org.summer.dsl.xbase.typesystem.computation.ITypeExpectation;
import org.summer.dsl.xbase.typesystem.conformance.ConformanceHint;
import org.summer.dsl.xbase.typesystem.references.LightweightTypeReference;
import org.summer.dsl.xbase.typesystem.references.UnboundTypeReference;
import org.summer.dsl.xbase.typesystem.util.ExtendedEarlyExitComputer;
import org.summer.dsl.xbase.validation.IssueCodes;

import com.google.common.collect.Sets;

/**
 * The root resolved types are the effective result of a type computation.
 * They don't have a parent and should never yield unresolved type references
 * when clients query for types of expressions or identifiables.
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 * @author Moritz Eysholdt - Configurable issue severity, support for checked exceptions
 * 
 * TODO guard against unresolved type references
 * TODO toString
 */
@NonNullByDefault
public class RootResolvedTypes extends ResolvedTypes {

	private Set<XExpression> toBeInferredRootExpressions;
	
	private IssueSeverities issueSeverities;
	
	protected RootResolvedTypes(DefaultReentrantTypeResolver resolver) {
		super(resolver);
		this.issueSeverities = resolver.getIssueSeverities();
	}

	public void resolveUnboundTypeParameters() {
		for(UnboundTypeReference unbound: basicGetTypeParameters().values()) {
			unbound.resolve();
		}
	}

	public void resolveProxies() {
		Map<XExpression, ILinkingCandidate> candidates = basicGetLinkingCandidates();
		for(ILinkingCandidate candidate: candidates.values()) {
			candidate.applyToModel();
		}
		for(Map.Entry<JvmIdentifiableElement, LightweightTypeReference> entry: basicGetTypes().entrySet()) {
			JvmIdentifiableElement identifiable = entry.getKey();
			if (identifiable instanceof JvmFormalParameter && identifiable.eContainingFeature() == XbasePackage.Literals.XCLOSURE__IMPLICIT_PARAMETER) {
				final JvmFormalParameter implicitLambdaParameter = (JvmFormalParameter) identifiable;
				JvmTypeReference typeReference = entry.getValue().toTypeReference();
				// is unset in XbaseLazyLinker again
				implicitLambdaParameter.setParameterType(typeReference);
			}
		}
	}
	
	@Override
	@Nullable
	protected LightweightTypeReference getExpectedTypeForAssociatedExpression(JvmMember member, XExpression expression) {
		if (toBeInferredRootExpressions != null && toBeInferredRootExpressions.contains(expression)) {
			return null;
		}
		return getActualType(member);
	}
	
	@Override
	protected void markToBeInferred(XExpression expression) {
		if (toBeInferredRootExpressions == null) {
			toBeInferredRootExpressions = Sets.newHashSet();
		}
		toBeInferredRootExpressions.add(expression);
	}

	public void addDiagnostics(final Resource resource) {
		if (resource instanceof XtextResource) {
			if (((XtextResource) resource).isValidationDisabled())
				return;
		}
		class DiagnosticAcceptor implements IAcceptor<AbstractDiagnostic> {

			public void accept(@Nullable AbstractDiagnostic diagnostic) {
				if (diagnostic instanceof EObjectDiagnosticImpl) {
					Severity severity = ((EObjectDiagnosticImpl) diagnostic).getSeverity();
					if (severity == Severity.ERROR) {
						resource.getErrors().add(diagnostic);
					} else if (severity == Severity.WARNING) {
						resource.getWarnings().add(diagnostic);
					}
				} else {
					resource.getErrors().add(diagnostic);
				}
			}
			
		}
		DiagnosticAcceptor acceptor = new DiagnosticAcceptor();
		addQueuedDiagnostics(acceptor);
		addLinkingDiagnostics(acceptor);
		addTypeDiagnostics(acceptor);
	}

	protected void addTypeDiagnostics(IAcceptor<? super AbstractDiagnostic> acceptor) {
		for(Map.Entry<XExpression, List<TypeData>> entry: basicGetExpressionTypes().entrySet()) {
			XExpression expression = entry.getKey();
			if (!isPropagatedType(expression))
				addTypeDiagnostic(expression, mergeTypeData(expression, entry.getValue(), false, false), acceptor);
		}
	}

	protected void addTypeDiagnostic(XExpression expression, @Nullable TypeData typeData, IAcceptor<? super AbstractDiagnostic> acceptor) {
		if (typeData != null) {
			LightweightTypeReference actualType = typeData.getActualType();
			ITypeExpectation expectation = typeData.getExpectation();
			if (!typeData.getConformanceHints().contains(ConformanceHint.NO_IMPLICIT_RETURN) && !typeData.getConformanceHints().contains(ConformanceHint.PROPAGATED_TYPE)) {
				if (actualType.isPrimitiveVoid() && isIntentionalEarlyExit(expression)) {
					return;
				}
				LightweightTypeReference expectedType = expectation.getExpectedType();
				if (expectedType != null) {
					if (!expectedType.isPrimitiveVoid()) {
						EnumSet<ConformanceHint> conformanceHints = getConformanceHints(typeData, false);
						if (!isSuccess(conformanceHints)) {
							AbstractDiagnostic diagnostic = createTypeDiagnostic(expression, actualType, expectedType);
							acceptor.accept(diagnostic);
						}
					}
				} else if (!expectation.isVoidTypeAllowed() && actualType.isPrimitiveVoid()) {
					AbstractDiagnostic diagnostic = new EObjectDiagnosticImpl(Severity.ERROR, IssueCodes.INCOMPATIBLE_TYPES, 
							"Type mismatch: type void is not applicable at this location", expression, null, -1,
							null);
					acceptor.accept(diagnostic);
				}
			}
		}
	}

	// TODO discuss / improve
	/**
	 * Returns <code>true</code> for expressions that seem to be early exit expressions, e.g.
	 * <pre>
	 *   while(condition) {
	 *     if (anotherCondition)
	 *       return value
	 *     changeResultOfFirstCondition
	 *   }
	 * </pre>
	 */
	protected boolean isIntentionalEarlyExit(@Nullable XExpression expression) {
		ExtendedEarlyExitComputer earlyExitComputer = getReferenceOwner().getServices().getEarlyExitComputer();
		return earlyExitComputer.isIntentionalEarlyExit(expression);
	}
	
	protected AbstractDiagnostic createTypeDiagnostic(XExpression expression, LightweightTypeReference actualType, LightweightTypeReference expectedType) {
		if (!expectedType.isAny()) {
			if (expression.eContainingFeature() == XbasePackage.Literals.XABSTRACT_FEATURE_CALL__IMPLICIT_FIRST_ARGUMENT) {
				return new EObjectDiagnosticImpl(Severity.ERROR, IssueCodes.INCOMPATIBLE_TYPES, String.format(
						"Type mismatch: cannot convert implicit first argument from %s to %s", actualType.getSimpleName(), expectedType.getSimpleName()),
						expression, null, -1, null);
			} else {
				return new EObjectDiagnosticImpl(Severity.ERROR, IssueCodes.INCOMPATIBLE_TYPES, String.format(
						"Type mismatch: cannot convert from %s to %s", actualType.getSimpleName(), expectedType.getSimpleName()),
						expression, null, -1, null);
			}
		} else {
			return new EObjectDiagnosticImpl(Severity.ERROR, IssueCodes.INCOMPATIBLE_TYPES, String.format(
					"Type mismatch: type %s is not applicable at this location", actualType.getSimpleName()), expression, null, -1,
					null);
		}
	}

	protected boolean isSuccess(EnumSet<ConformanceHint> conformanceHints) {
		if (!conformanceHints.contains(ConformanceHint.SUCCESS)) {
			return false;
		}
		if (conformanceHints.contains(ConformanceHint.NO_IMPLICIT_RETURN)) {
			return true;
		}
		return true;
	}
	
	protected void addLinkingDiagnostics(IAcceptor<? super AbstractDiagnostic> acceptor) {
		Map<XExpression, ILinkingCandidate> candidates = basicGetLinkingCandidates();
		for(ILinkingCandidate candidate: candidates.values()) {
			candidate.validate(acceptor);
		}
	}

	protected void addQueuedDiagnostics(IAcceptor<? super AbstractDiagnostic> acceptor) {
		for(AbstractDiagnostic diagnostic: getQueuedDiagnostics()) {
			acceptor.accept(diagnostic);
		}
	}
	
	@Override
	protected IssueSeverities getSeverities() {
		return issueSeverities;
	}

}
