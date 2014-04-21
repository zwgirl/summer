/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.com) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.resource;

import java.util.Collections;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.util.Strings;

/**
 * @author Sven Efftinge - Initial contribution and API
 * @author Jan Koehnlein - introduced QualifiedName
 */
public class EObjectDescription extends AbstractEObjectDescription {

	private final Map<String, String> userData;
	private final QualifiedName qualifiedName;
	private final EObject element;
	private URI normalizedURI;
	
	public EObjectDescription(QualifiedName qualifiedName, EObject element, Map<String, String> userData) {
		if (qualifiedName == null)
			throw new NullPointerException("qualified name may not be null");
		this.qualifiedName = qualifiedName;
		this.element = element;
		this.userData = userData;
	}

	public static IEObjectDescription create(String simpleName, EObject element, Map<String, String> userData) {
		return create(QualifiedName.create(simpleName), element, userData);
	}
	
	public static IEObjectDescription create(String simpleName, EObject element) {
		return create(QualifiedName.create(simpleName), element, Collections.<String,String>emptyMap());
	}
	
	public static IEObjectDescription create(QualifiedName qualifiedName, EObject element, Map<String, String> userData) {
		return new EObjectDescription(qualifiedName, element, userData);
	}
	
	public static IEObjectDescription create(QualifiedName qualifiedName, EObject element) {
		return create(qualifiedName, element, Collections.<String,String>emptyMap());
	}

	public EObject getEObjectOrProxy() {
		return element;
	}

	public URI getEObjectURI() {
		if (normalizedURI == null) {
			normalizedURI = normalize(element, EcoreUtil.getURI(element));
		}
		return normalizedURI; 
	}
	
	protected URI normalize(EObject element, URI uri) {
		if (uri != null && !uri.isPlatform() && element != null && element.eResource() != null) {
			ResourceSet resourceSet = element.eResource().getResourceSet();
			if (resourceSet != null)
				return resourceSet.getURIConverter().normalize(uri);
		}
		return uri;
	}

	public QualifiedName getName() {
		return qualifiedName;
	}
	
	public QualifiedName getQualifiedName() {
		return qualifiedName;
	}
	
	@Override
	public String getUserData(String name) {
		if (userData==null)
			return null;
		return userData.get(name);
	}
	
	@Override
	public String[] getUserDataKeys() {
		if (userData==null)
			return Strings.EMPTY_ARRAY;
		return userData.keySet().toArray(new String[userData.size()]);
	}

	public EClass getEClass() {
		return element.eClass();
	}

}
