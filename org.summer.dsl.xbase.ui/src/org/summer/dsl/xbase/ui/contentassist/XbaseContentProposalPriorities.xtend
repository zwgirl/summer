/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.summer.dsl.xbase.ui.contentassist

import org.eclipse.jface.text.contentassist.ICompletionProposal
import org.eclipse.xtext.ui.editor.contentassist.ConfigurableCompletionProposal
import org.eclipse.xtext.ui.editor.contentassist.ContentProposalPriorities
import org.summer.dsl.xbase.scoping.featurecalls.JvmFeatureDescription
import org.summer.dsl.model.types.JvmField
import org.summer.dsl.model.types.JvmExecutable
import org.summer.dsl.xbase.scoping.featurecalls.LocalVarDescription

/**
 * @author Sven Efftinge - Initial contribution and API
 */
class XbaseContentProposalPriorities extends ContentProposalPriorities {
	
	override adjustCrossReferencePriority(ICompletionProposal proposal, String prefix) {
		switch proposal {
			ConfigurableCompletionProposal : {
				switch desc : proposal.getAdditionalData(XbaseProposalProvider.DESCRIPTION_KEY) {
					JvmFeatureDescription : {
						switch feature : desc.jvmFeature {
							JvmField : {
								adjustPriority(proposal, prefix, 550)
								return;
							}
							JvmExecutable : {
								adjustPriority(proposal, prefix, 520)
								return;
							}
						}
					}
					LocalVarDescription case proposal.replacementString != 'this' && proposal.replacementString != 'super': {
						adjustPriority(proposal, prefix, 570)
						return;
					}
				} 
			}
		}
		super.adjustCrossReferencePriority(proposal, prefix)
	}
	
}