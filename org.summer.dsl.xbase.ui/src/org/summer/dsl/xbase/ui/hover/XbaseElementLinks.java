/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.summer.dsl.xbase.ui.hover;

import java.net.URI;

import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.jdt.internal.ui.viewsupport.JavaElementLinks;
import org.eclipse.swt.browser.LocationEvent;
import org.eclipse.swt.browser.LocationListener;
import org.eclipse.xtext.ui.editor.hover.html.XtextElementLinks;

/**
 * @author Holger Schill - Initial contribution and API
 * @since 2.3
 */
public class XbaseElementLinks extends XtextElementLinks {

	public interface IXbaseLinkHandler extends ILinkHandler {
		
		/**
		 * Handle normal kind of link to given target.
		 *
		 * @param target the target to show
		 */
		void handleInlineJavadocLink(IJavaElement target);
	}
	
	public LocationListener createLocationListener(IXbaseLinkHandler handler) {
		return new XbaseLinkAdapter(handler);
	}
	
	protected class XbaseLinkAdapter extends XtextLinkAdapter{
		protected  IXbaseLinkHandler handler;
		protected XbaseLinkAdapter(IXbaseLinkHandler handler) {
			super(handler);
			this.handler = handler;
		}
		
		@Override
		public void changing(LocationEvent event) {
			URI uri = initURI(event);
			if(uri == null)
				return;
			String scheme= uri.getScheme();
			if (JavaElementLinks.JAVADOC_SCHEME.equals(scheme)) {
				IJavaElement linkTarget= JavaElementLinks.parseURI(uri);
				if (linkTarget == null)
					return;
				handler.handleInlineJavadocLink(linkTarget);
				return;
			}
			super.changing(event);
			
		}
		
	}
	
}
