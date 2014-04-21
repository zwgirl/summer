/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.serializer.diagnostic;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.serializer.analysis.ISyntacticSequencerPDAProvider.ISynAbsorberState;
import org.eclipse.xtext.serializer.analysis.ISyntacticSequencerPDAProvider.ISynNavigable;
import org.eclipse.xtext.serializer.analysis.ISyntacticSequencerPDAProvider.ISynState;
import org.eclipse.xtext.serializer.sequencer.RuleCallStack;

import com.google.inject.ImplementedBy;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */

@ImplementedBy(SyntacticSequencerDiagnosticProvider.class)
public interface ISyntacticSequencerDiagnosticProvider {
	
	String 	INVALID_FOLLOWING_ABSORBER = "invalid following absorber",
			UNEXPECTED_STACK_TRACE = "unexpected stack trace",
			UNEXPECTED_EMITTER_DIAGNOSTIC = "unexepcted emitter diagnostic";
	
	ISerializationDiagnostic createInvalidFollowingAbsorberDiagnostic(EObject context, EObject semanticObject,
			ISynAbsorberState from, AbstractElement to);

	ISerializationDiagnostic createUnexpectedStackStateDiagnostic(EObject semanticObject, RuleCallStack stack,
			RuleCall popped, ISynState toConsume);

	ISerializationDiagnostic createUnexpectedEmitterDiagnostic(ISynNavigable currentState, AbstractElement target,
			RuleCallStack stack);
}
