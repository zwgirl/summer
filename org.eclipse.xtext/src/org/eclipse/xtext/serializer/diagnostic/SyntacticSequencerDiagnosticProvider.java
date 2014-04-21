/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.serializer.diagnostic;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.grammaranalysis.impl.GrammarElementTitleSwitch;
import org.eclipse.xtext.serializer.analysis.ISyntacticSequencerPDAProvider.ISynAbsorberState;
import org.eclipse.xtext.serializer.analysis.ISyntacticSequencerPDAProvider.ISynNavigable;
import org.eclipse.xtext.serializer.analysis.ISyntacticSequencerPDAProvider.ISynState;
import org.eclipse.xtext.serializer.analysis.ISyntacticSequencerPDAProvider.ISynTransition;
import org.eclipse.xtext.serializer.sequencer.RuleCallStack;

import com.google.common.base.Joiner;
import com.google.common.collect.Lists;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class SyntacticSequencerDiagnosticProvider implements ISyntacticSequencerDiagnosticProvider {

	public ISerializationDiagnostic createInvalidFollowingAbsorberDiagnostic(EObject context, EObject semanticObject,
			ISynAbsorberState from, AbstractElement to) {
		GrammarElementTitleSwitch fmt = new GrammarElementTitleSwitch().showAssignments().showQualified();
		String fromName = from.toString(fmt);
		String toName = to == null ? "stop" : fmt.doSwitch(to);

		List<String> targets = Lists.newArrayList();
		for (ISynTransition trans : from.getOutTransitions())
			targets.add(trans.getTarget().toString(fmt));

		StringBuilder msg = new StringBuilder();
		msg.append("State '" + toName + "' may not follow '" + fromName + "'.\n");
		msg.append("Valid followers are: " + Joiner.on(", ").join(targets));

		return new SerializationDiagnostic(INVALID_FOLLOWING_ABSORBER, semanticObject, context, msg.toString());
	}

	public ISerializationDiagnostic createUnexpectedEmitterDiagnostic(ISynNavigable currentState,
			AbstractElement target, RuleCallStack stack) {
		return null;
	}

	public ISerializationDiagnostic createUnexpectedStackStateDiagnostic(EObject semanticObject, RuleCallStack stack,
			RuleCall popped, ISynState toConsume) {
		String poppedStr = popped == null ? "null" : new GrammarElementTitleSwitch().showAssignments().doSwitch(popped);
		StringBuilder buf = new StringBuilder();
		buf.append("Unexpected stack state.\n");
		buf.append("Found on top of the stack: " + poppedStr + "\n");
		buf.append("Expected: " + toConsume + "\n");
		buf.append("Rest of the stack: " + stack + "\n");
		return new SerializationDiagnostic(UNEXPECTED_STACK_TRACE, semanticObject, toConsume.getContext(), buf.toString());
	}
}
