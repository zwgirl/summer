/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.diagnostics;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.nodemodel.INode;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public abstract class AbstractDiagnostic implements Diagnostic {

	protected abstract INode getNode();
	
	public abstract String getCode();
	
	public abstract String[] getData();

	public int getLength() {
		INode node = getNode();
		if (node != null)
			return node.getLength();
		return 1;
	}

	public int getOffset() {
		INode node = getNode();
		if (node != null)
			return node.getOffset();
		return 0;
	}

	public int getColumn() {
		throw new UnsupportedOperationException();
	}

	public int getLine() {
		INode node = getNode();
		if (node != null)
			return node.getStartLine();
		return -1;
	}

	public String getLocation() {
		return null;
	}

	public URI getUriToProblem() {
		INode node = getNode();
		if (node == null)
			return null;
		EObject eObject = node.getSemanticElement();
		if (eObject==null || eObject.eResource()==null)
			return null;
		return EcoreUtil.getURI(eObject);
	}

	@Override
	public String toString() {
		StringBuffer b = new StringBuffer();
		b.append(getClass().getSimpleName());
		b.append(": ");
		b.append(getLocation());
		b.append(":");
		b.append(getLine());
		b.append(" ");
		b.append(getMessage());
		return b.toString();
	}

}