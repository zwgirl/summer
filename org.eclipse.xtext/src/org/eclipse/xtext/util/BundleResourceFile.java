package org.eclipse.xtext.util;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

import org.eclipse.core.resources.IEncodedStorage;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.PlatformObject;
import org.eclipse.emf.common.util.URI;

public class BundleResourceFile extends PlatformObject implements IEncodedStorage {

	private URL url;

	public BundleResourceFile(URI uri) {
		try {
			url = new URL(uri.toString());
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/* (non-Javadoc)
	 * @see org.eclipse.core.resources.IStorage#getContents()
	 */
	public InputStream getContents() throws CoreException {
//		return URIUtils.getFile(uri).getContents();
		try {
			return url.openStream();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}

	/* (non-Javadoc)
	 * @see org.eclipse.core.resources.IStorage#getFullPath()
	 */
	public IPath getFullPath() {
		return new Path(url.getPath());
	}

	/* (non-Javadoc)
	 * @see org.eclipse.core.resources.IStorage#getName()
	 */
	public String getName() {
		return getFullPath().lastSegment();
	}

	/* (non-Javadoc)
	 * @see org.eclipse.core.resources.IStorage#isReadOnly()
	 */
	public boolean isReadOnly() {
		return true;
	}

	public String toString() {
		return url.toString();
	}

	public boolean equals(Object obj) {
		if (!(obj instanceof BundleResourceFile))
			return false;
		return toString().equals(obj.toString());
	}

	@Override
	public String getCharset() throws CoreException {
		return "UTF-8";
	}

}
