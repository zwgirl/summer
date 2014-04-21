/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.serializer.impl;

import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.IGrammarAccess;
import org.eclipse.xtext.formatting.IFormatter;
import org.eclipse.xtext.formatting.IFormatterExtension;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.parsetree.reconstr.ITokenStream;
import org.eclipse.xtext.parsetree.reconstr.impl.TokenStringBuffer;
import org.eclipse.xtext.parsetree.reconstr.impl.WriterTokenStream;
import org.eclipse.xtext.resource.SaveOptions;
import org.eclipse.xtext.serializer.ISerializer;
import org.eclipse.xtext.serializer.acceptor.ISemanticSequenceAcceptor;
import org.eclipse.xtext.serializer.acceptor.ISequenceAcceptor;
import org.eclipse.xtext.serializer.acceptor.ISyntacticSequenceAcceptor;
import org.eclipse.xtext.serializer.acceptor.TokenStreamSequenceAdapter;
import org.eclipse.xtext.serializer.diagnostic.ISerializationDiagnostic;
import org.eclipse.xtext.serializer.sequencer.IContextFinder;
import org.eclipse.xtext.serializer.sequencer.IHiddenTokenSequencer;
import org.eclipse.xtext.serializer.sequencer.ISemanticSequencer;
import org.eclipse.xtext.serializer.sequencer.ISyntacticSequencer;
import org.eclipse.xtext.util.EmfFormatter;
import org.eclipse.xtext.util.ReplaceRegion;
import org.eclipse.xtext.validation.IConcreteSyntaxValidator;

import com.google.inject.Inject;
import com.google.inject.Provider;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class Serializer implements ISerializer {

	public String serialize(EObject obj) {
		return serialize(obj, SaveOptions.defaultOptions());
	}

	@Inject
	protected IFormatter formatter;

	@Inject
	protected Provider<ISemanticSequencer> semanticSequencerProvider;

	@Inject
	protected Provider<ISyntacticSequencer> syntacticSequencerProvider;

	@Inject
	protected Provider<IHiddenTokenSequencer> hiddenTokenSequencerProvider;

	@Inject
	protected IGrammarAccess grammar;

	@Inject
	protected IContextFinder contextFinder;

	@Inject
	protected IConcreteSyntaxValidator validator;

	protected void serialize(EObject semanticObject, EObject context, ISequenceAcceptor tokens,
			ISerializationDiagnostic.Acceptor errors) {
		ISemanticSequencer semantic = semanticSequencerProvider.get();
		ISyntacticSequencer syntactic = syntacticSequencerProvider.get();
		IHiddenTokenSequencer hidden = hiddenTokenSequencerProvider.get();
		semantic.init((ISemanticSequenceAcceptor) syntactic, errors);
		syntactic.init(context, semanticObject, (ISyntacticSequenceAcceptor) hidden, errors);
		hidden.init(context, semanticObject, tokens, errors);
		if (tokens instanceof TokenStreamSequenceAdapter)
			((TokenStreamSequenceAdapter) tokens).init(context);
		semantic.createSequence(context, semanticObject);
	}

	protected void serialize(EObject obj, ITokenStream tokenStream, SaveOptions options) throws IOException {

		// use the CSV as long as there are cases where is provides better messages than the serializer itself.
		if (options.isValidating()) {
			List<Diagnostic> diagnostics = new ArrayList<Diagnostic>();
			validator.validateRecursive(obj, new IConcreteSyntaxValidator.DiagnosticListAcceptor(diagnostics),
					new HashMap<Object, Object>());
			if (!diagnostics.isEmpty())
				throw new IConcreteSyntaxValidator.InvalidConcreteSyntaxException(
						"These errors need to be fixed before the model can be serialized.", diagnostics);
		}

		ISerializationDiagnostic.Acceptor errors = ISerializationDiagnostic.EXCEPTION_THROWING_ACCEPTOR;
		ITokenStream formatterTokenStream;
		if(formatter instanceof IFormatterExtension)
			formatterTokenStream = ((IFormatterExtension) formatter).createFormatterStream(obj, null, tokenStream, !options.isFormatting());
		else 
			formatterTokenStream = formatter.createFormatterStream(null, tokenStream, !options.isFormatting());
		EObject context = getContext(obj);
		ISequenceAcceptor acceptor = new TokenStreamSequenceAdapter(formatterTokenStream, errors);
		serialize(obj, context, acceptor, errors);
		formatterTokenStream.flush();
	}

	protected EObject getContext(EObject semanticObject) {
		Iterator<EObject> contexts = contextFinder.findContextsByContentsAndContainer(semanticObject, null).iterator();
		if (!contexts.hasNext())
			throw new RuntimeException("No Context for " + EmfFormatter.objPath(semanticObject) + " could be found");
		return contexts.next();
	}

	public String serialize(EObject obj, SaveOptions options) {
		TokenStringBuffer tokenStringBuffer = new TokenStringBuffer();
		try {
			serialize(obj, tokenStringBuffer, options);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		return tokenStringBuffer.toString();
	}

	public void serialize(EObject obj, Writer writer, SaveOptions options) throws IOException {
		serialize(obj, new WriterTokenStream(writer), options);
	}

	public ReplaceRegion serializeReplacement(EObject obj, SaveOptions options) {
		ICompositeNode node = NodeModelUtils.findActualNodeFor(obj);
		if (node == null) {
			throw new IllegalStateException("Cannot replace an obj that has no associated node");
		}
		String text = serialize(obj, options);
		return new ReplaceRegion(node.getTotalOffset(), node.getTotalLength(), text);
	}

}
