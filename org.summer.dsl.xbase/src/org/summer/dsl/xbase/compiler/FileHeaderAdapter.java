/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.summer.dsl.xbase.compiler;

import org.eclipse.emf.common.notify.impl.AdapterImpl;

/**
 * @author Michael Clay - Initial contribution and API
 */
public class FileHeaderAdapter extends AdapterImpl {

	private String headerText;

	public String getHeaderText() {
		return headerText;
	}

	public void setHeaderText(String documentation) {
		this.headerText = documentation;
	}
	
	@Override
	public boolean isAdapterForType(Object type) {
		return type == FileHeaderAdapter.class;
	}
}
