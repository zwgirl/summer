/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.resource;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.resources.IProject;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.eclipse.emf.ecore.resource.impl.ExtensibleURIConverterImpl;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.XMLResource;

/**
 * A resource set that is capable of resolving classpath URIs.
 * 
 * It maintains a {@link #getURIResourceMap()} containing the resource's URI as well as the normalized version of it as a key.
 * The superset of actual and normalized resource URIs must be unique within the same resource set. 
 * 
 * @author Jan K�hnlein
 * @author Sven Efftinge
 * @author Sebastian Zarnekow - Default registration of {@link XtextPlatformResourceURIHandler}
 */
public class XtextResourceSet extends ResourceSetImpl {
	
	/**
	 * @since 2.3
	 */
	protected class UriChangeListener extends AdapterImpl {
		@Override
		public void notifyChanged(Notification notification) {
			final Map<URI, Resource> map = getURIResourceMap();
			if (map != null && notification.getFeatureID(Resource.class) == Resource.RESOURCE__URI && notification.getNotifier() instanceof Resource) {
				URI oldOne = (URI) notification.getOldValue();
				map.remove(oldOne);
				if (oldOne != null) {
					URI oldNormalized = getURIConverter().normalize(oldOne);
					if (!oldOne.equals(oldNormalized))
						map.remove(oldNormalized);
				}
				Resource resource = (Resource) notification.getNotifier();
				registerURI(resource);
			}
			super.notifyChanged(notification);
		}
	}

	private UriChangeListener uriChangeListener = new UriChangeListener();
	
	/**
	 * @since 2.3
	 */
	protected UriChangeListener getUriChangeListener() {
		return uriChangeListener;
	}
	
	/**
	 * @since 2.3
	 */
	protected void registerURI(Resource resource) {
		Map<URI, Resource> map = getURIResourceMap();
		if (map != null) {
			final URI uri = resource.getURI();
			if (uri != null) {
				URI normalized = getURIConverter().normalize(uri);
				if (!normalized.equals(uri)) {
					
					if(map.containsKey(normalized)){//cym add
						return;
					}
					Resource previous = map.put(normalized, resource);
					if (previous != null && previous != resource) {
						throw new IllegalStateException("A resource with the normalized URI '"+normalized+"' was already registered. The resource with the URI '"+previous+"' is no longer registered with the normalized form.");
					}
				}
			}
//			if(map.containsKey(uri)){ //cym add
//				return;
//			}
			Resource previous = map.put(uri, resource);
			if (previous != null && previous != resource) {
				throw new IllegalStateException("A different resource with the URI '"+uri+"' was already registered.");
			}
		}
	}
	/**
	 * adds the added resource to the {@link ResourceSetImpl#getURIResourceMap()}.
	 * 
	 * @since 2.3
	 */
	@SuppressWarnings("serial")
	protected class ResourcesList extends ResourceSetImpl.ResourcesEList<Resource> {
		@Override
		protected NotificationChain inverseAdd(Resource resource, NotificationChain notifications) {
			NotificationChain chain = super.inverseAdd(resource, notifications);
			resource.eAdapters().add(getUriChangeListener());
			registerURI(resource);
			return chain;
		}
		
		@Override
		protected NotificationChain inverseRemove(Resource resource, NotificationChain notifications) {
			final NotificationChain inverseRemove = super.inverseRemove(resource, notifications);
			resource.eAdapters().remove(getUriChangeListener());
			return inverseRemove;
		}
		
		/**
		 * @since 2.4
		 */
		@Override
		protected void doClear() {
			super.doClear();
			// don't iterate the values of the map per resource but just clear it all at once
			getURIResourceMap().clear();
		}

	}
	
    private IClasspathUriResolver resolver;

    private Object classpathURIContext;

    public XtextResourceSet() {
    	setURIResourceMap(new HashMap<URI,Resource>());
		resources = createResourceList();
		
		initializeDefaultLoadOptions();
    }

    /**
     * Adds a {@link XtextPlatformResourceURIHandler} to the default load
     * options of this resource set.
     * 
     * Clients who don't want this behavior can override this method.
     * 
     * @since 2.4
     */
	protected void initializeDefaultLoadOptions() {
		Map<Object, Object> defaultLoadOptions = getLoadOptions();
		XtextPlatformResourceURIHandler uriHandler = new XtextPlatformResourceURIHandler();
		uriHandler.setResourceSet(this);
		defaultLoadOptions.put(XMLResource.OPTION_URI_HANDLER, uriHandler);
	}

	/**
	 * Create the concrete list that will contain the resources. 
	 * @since 2.4
	 */
	protected ResourcesList createResourceList() {
		return new ResourcesList();
	}

    private URI resolveClasspathURI(URI uri) {
        return getClasspathUriResolver().resolve(getClasspathURIContext(), uri);
    }
    
    public void addLoadOption(Object key, Object value) {
    	getLoadOptions().put(key, value);
    }
    
    public void removeLoadOption(Object key) {
    	getLoadOptions().remove(key);
    }
    
    @Override
	public Resource getResource(URI uri, boolean loadOnDemand) {
		Map<URI, Resource> map = getURIResourceMap();
		if (map == null)
			return super.getResource(uri, loadOnDemand);
		Resource resource = map.get(uri);
		if (resource == null) {
			URI normalizedURI = getURIConverter().normalize(uri);
			resource = map.get(normalizedURI);
		}
		if (resource != null) {
			if (loadOnDemand && !resource.isLoaded()) {
				demandLoadHelper(resource);
			}
			return resource;
		}
		
	    Resource delegatedResource = delegatedGetResource(uri, loadOnDemand);
	    if (delegatedResource != null)
	    {
	      return delegatedResource;
	    }

	    if (loadOnDemand)
	    {
	      resource = demandCreateResource(uri);
	      if (resource == null) {
	        throw new RuntimeException("Cannot create a resource for '" + uri + "'; a registered resource factory is needed");
	      }

	      demandLoadHelper(resource);

	      return resource;
	    }

	    return null;
	}
    
    @Override
    public URIConverter getURIConverter() {
        if (uriConverter == null) {
            uriConverter = new ExtensibleURIConverterImpl() {
                @Override
                public URI normalize(URI uri) {
                    if (ClasspathUriUtil.isClasspathUri(uri)) {
                        URI result = XtextResourceSet.this.resolveClasspathURI(uri);
                        if (ClasspathUriUtil.isClasspathUri(result))
                        	throw new ClasspathUriResolutionException(result);
                        result = super.normalize(result);
                        return result;
                    }
                    return super.normalize(uri);
                }
                
				@Override
                public InputStream createInputStream(URI uri, Map<?, ?> options) throws IOException {
					// timeout is set here because e.g. SAXXMIHandler.resolveEntity(String,String) calls it without a timeout
					// causing the builder to wait too long...
                	options = addTimeout(options);
                	return super.createInputStream(uri, options);
                }
				
				@Override
				public Map<String, ?> contentDescription(URI uri, Map<?, ?> options) throws IOException {
					options = addTimeout(options);
					return super.contentDescription(uri, options);
				}

            };
        }
        return uriConverter;
    }
    
    /**
     * returns a copy of the given map containing a timeout of 500ms 
     * if the given option map did not already specify a {@link URIConverter#OPTION_TIMEOUT}
     * 
     * @since 2.4
     */
    protected Map<?, ?> addTimeout(Map<?, ?> options) {
    	if (options == null || !options.containsKey(URIConverter.OPTION_TIMEOUT)) {
    		HashMap<Object, Object> newOptions = options != null ? new HashMap<Object, Object>(options) : new HashMap<Object, Object>();
    		newOptions.put(URIConverter.OPTION_TIMEOUT, 500);
    		options = newOptions;
    	}
    	return options;
    }
    
    public Object getClasspathURIContext() {
        return classpathURIContext;
    }

    public void setClasspathURIContext(Object classpathURIContext) {
        this.classpathURIContext = classpathURIContext;
    }

    public IClasspathUriResolver getClasspathUriResolver() {
        if (resolver == null) {
            resolver = new ClassloaderClasspathUriResolver();
        }
        return resolver;
    }

    public void setClasspathUriResolver(IClasspathUriResolver resolver) {
        this.resolver = resolver;
    }
    
    
    private IProject project;
    public void setProject(IProject project){
    	this.project = project;
    }
    
    public IProject getProject(){
    	return this.project;
    }

}
