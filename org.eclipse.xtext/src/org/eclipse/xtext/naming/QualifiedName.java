/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.naming;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.ecore.resource.impl.BinaryResourceImpl.EObjectInputStream;
import org.eclipse.emf.ecore.resource.impl.BinaryResourceImpl.EObjectOutputStream;
import org.eclipse.xtext.util.Strings;

import com.google.common.base.Function;

/**
 * A datatype for dealing with qualified names. 
 * Instances are usually provided by a {@link IQualifiedNameProvider}.
 * 
 * @author Jan Koehnlein - Initial contribution and API
 * @author Sebastian Zarnekow
 */
public class QualifiedName implements Comparable<QualifiedName> {

	private final int hash;
	
	private final String[] segments;
	
	private QualifiedName lowerCase;

	public static final QualifiedName EMPTY = new QualifiedName() {
		@Override
		public QualifiedName append(QualifiedName relativeQualifiedName) {
			return relativeQualifiedName;
		}
		@Override
		public QualifiedName append(String segment) {
			return QualifiedName.create(segment);
		}
		@Override
		public QualifiedName toLowerCase() {
			return this;
		}
		@Override
		public QualifiedName toUpperCase() {
			return this;
		}
	};

	/**
	 * Low-level factory method. Consider using a {@link IQualifiedNameConverter} instead.
	 * 
	 * @param segments the segments of the to-be-created qualified name. 
	 * 	May be <code>null</code>, but may not contain <code>null</code> entries.
	 * @return a {@link QualifiedName}. Never <code>null</code>.
	 * @exception IllegalArgumentException
	 *                if any of the segments is null
	 */
	public static QualifiedName create(String... segments) {
		if (segments == null || segments.length == 0) {
			return EMPTY;
		}
		if (segments.length == 1) {
			return create(segments[0]);
		}
		for (int i = 0; i < segments.length; i++) {
			if (segments[i] == null) {
				throw new IllegalArgumentException("Segment cannot be null");
			}
		}
		return new QualifiedName(segments.clone());
	}
	
	/**
	 * Internal low level factory method.
	 * @noreference This method is not intended to be referenced by clients.
	 * @since 2.4
	 */
	public static QualifiedName createFromStream(EObjectInputStream eObjectInputStream) throws IOException{
		int segmentCount = eObjectInputStream.readCompressedInt();
		if (segmentCount == 0) {
			return QualifiedName.EMPTY;
		}
		String[] segments = new String[segmentCount];
		for (int i = 0; i < segmentCount; ++i) {
			segments[i] = eObjectInputStream.readSegmentedString();
		}
		return new QualifiedName(segments);
	}
	
	/**
	 * Internal low level serialization of QualifiedNames.
	 * @since 2.4
	 */
	public void writeToStream(EObjectOutputStream eObjectOutputStream) throws IOException {
		int segmentCount = getSegmentCount();
		eObjectOutputStream.writeCompressedInt(segmentCount);
		for (int i = 0; i < segmentCount; ++i) {
			eObjectOutputStream.writeSegmentedString(getSegment(i));
		}
	}

	/**
	 * Low-level factory method. Consider using a {@link IQualifiedNameConverter} instead.
	 * 
	 * @param segments
	 *            the segments of the to-be-created qualified name. May be <code>null</code>, but may not contain
	 *            <code>null</code> entries.
	 * @return a {@link QualifiedName}. Never <code>null</code>.
	 * @exception IllegalArgumentException
	 *                if any of the segments is null
	 * @since 2.3
	 */
	public static QualifiedName create(List<String> segments) {
		if (segments == null || segments.isEmpty())
			return QualifiedName.EMPTY;
		if (segments.size() == 1) {
			String singleSegment = segments.get(0);
			return QualifiedName.create(singleSegment);
		}
		String[] segmentArray = segments.toArray(new String[segments.size()]);
		for (int i = 0; i < segmentArray.length; i++) {
			if (segmentArray[i] == null) {
				throw new IllegalArgumentException("Segment cannot be null");
			}
		}
		return new QualifiedName(segmentArray);
	}

	/**
	 * Low-level factory method. Consider using a {@link IQualifiedNameConverter} instead.
	 * 
	 * @param singleSegment
	 *            the single segment of the newly created qualified name
	 * @exception IllegalArgumentException
	 *                if the singleSegment is null
	 * @since 2.3
	 */
	public static QualifiedName create(String singleSegment) {
		if (singleSegment == null) {
			throw new IllegalArgumentException("Segment cannot be null");
		}
		return new QualifiedName(singleSegment);
	}

	/**
	 * Wraps a name function to return a qualified name. Returns null if the name function returns null. 
	 */
	public static <F> Function<F, QualifiedName> wrapper(final Function<F, String> nameFunction) {
		return new Function<F, QualifiedName>() {
			public QualifiedName apply(F from) {
				String name = nameFunction.apply(from);
				if (name == null)
					return null;
				return QualifiedName.create(name);
			}
		};
	}

	protected QualifiedName(String... segments) {
		if (segments == null || segments.length == 0)
			this.segments = Strings.EMPTY_ARRAY;
		else
			this.segments = segments;
		hash = Arrays.hashCode(this.segments);
	}

	public boolean isEmpty() {
		return segments.length == 0;
	}

	public List<String> getSegments() {
		return Collections.unmodifiableList(Arrays.asList(segments));
	}

	public int getSegmentCount() {
		return segments.length;
	}

	public String getSegment(int index) {
		return segments[index];
	}

	public String getLastSegment() {
		return segments[segments.length - 1];
	}

	public String getFirstSegment() {
		return segments[0];
	}

	public QualifiedName append(String segment) {
		if (segment == null) {
			throw new IllegalArgumentException("Segment cannot be null");
		}
		String[] newSegments = new String[getSegmentCount() + 1];
		System.arraycopy(segments, 0, newSegments, 0, segments.length);
		newSegments[segments.length] = segment;
		return new QualifiedName(newSegments);
	}

	public QualifiedName append(QualifiedName relativeQualifiedName) {
		String[] newSegments = new String[getSegmentCount() + relativeQualifiedName.getSegmentCount()];
		for (int i = 0; i < getSegmentCount(); ++i)
			newSegments[i] = getSegment(i);
		for (int i = 0; i < relativeQualifiedName.getSegmentCount(); ++i)
			newSegments[i + getSegmentCount()] = relativeQualifiedName.getSegment(i);
		return new QualifiedName(newSegments);
	}

	public QualifiedName skipFirst(int skipCount) {
		if (skipCount == getSegmentCount()) {
			return EMPTY;
		}
		if (skipCount > getSegmentCount() || skipCount < 0) {
			throw new IllegalArgumentException("Cannot skip " + skipCount + " fragments from QualifiedName with "
					+ getSegmentCount() + " segments");
		}
		String[] newSegments = new String[segments.length - skipCount];
		System.arraycopy(segments, skipCount, newSegments, 0, newSegments.length);
		return new QualifiedName(newSegments);
	}

	public QualifiedName skipLast(int skipCount) {
		if (skipCount == getSegmentCount()) {
			return EMPTY;
		}
		if (skipCount > getSegmentCount() || skipCount < 0) {
			throw new IllegalArgumentException("Cannot skip " + skipCount + " fragments from QualifiedName with "
					+ getSegmentCount() + " segments");
		}
		String[] newSegments = new String[segments.length - skipCount];
		System.arraycopy(segments, 0, newSegments, 0, newSegments.length);
		return new QualifiedName(newSegments);
	}

	public QualifiedName toLowerCase() {
		if (lowerCase != null)
			return lowerCase;
		String[] newSegments = new String[segments.length];
		for (int i = 0; i < getSegmentCount(); ++i)
			newSegments[i] = segments[i].toLowerCase();
		lowerCase = new QualifiedName(newSegments) {
			@Override
			public QualifiedName toLowerCase() {
				return this;
			}
		};
		return lowerCase;
	}

	public QualifiedName toUpperCase() {
		String[] newSegments = new String[getSegmentCount()];
		for (int i = 0; i < getSegmentCount(); ++i)
			newSegments[i] = segments[i].toUpperCase();
		return new QualifiedName(newSegments);
	}

	@Override
	public int hashCode() {
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj==this)
			return true;
		if (obj instanceof QualifiedName) {
			QualifiedName other = (QualifiedName) obj;
			if (hash != other.hash)
				return false;
			return Arrays.equals(segments, other.segments);
		}
		return false;
	}

	public boolean equalsIgnoreCase(Object obj) {
		return obj instanceof QualifiedName && ((QualifiedName) obj).getSegmentCount() == getSegmentCount()
				&& startsWith((QualifiedName) obj, true);
	}

	public int compareTo(QualifiedName qualifiedName) {
		return compareTo(qualifiedName, false);
	}

	public int compareToIgnoreCase(QualifiedName qualifiedName) {
		return compareTo(qualifiedName, true);
	}

	protected int compareTo(QualifiedName qualifiedName, boolean ignoreCase) {
		for (int i = 0; i < Math.min(getSegmentCount(), qualifiedName.getSegmentCount()); ++i) {
			int result = (ignoreCase) ? getSegment(i).compareToIgnoreCase(qualifiedName.getSegment(i)) : getSegment(i)
					.compareTo(qualifiedName.getSegment(i));
			if (result != 0)
				return result;
		}
		return getSegmentCount() - qualifiedName.getSegmentCount();
	}

	public boolean startsWith(QualifiedName prefix) {
		return startsWith(prefix, false);
	}

	public boolean startsWithIgnoreCase(QualifiedName prefix) {
		return startsWith(prefix, true);
	}

	protected boolean startsWith(QualifiedName prefix, boolean ignoreCase) {
		if (prefix.getSegmentCount() > getSegmentCount())
			return false;
		for (int i = 0; i < prefix.getSegmentCount(); ++i) {
			if ((ignoreCase && !this.getSegment(i).equalsIgnoreCase(prefix.getSegment(i)))
					|| (!ignoreCase && !this.getSegment(i).equals(prefix.getSegment(i))))
				return false;
		}
		return true;
	}

	/**
	 * Returns a canonical String representation of this using '.' as namespace delimiter. For language specific
	 * conversion taking the concrete syntax into account see {@link IQualifiedNameConverter#toString(QualifiedName)}.
	 */
	@Override
	public String toString() {
		return toString(".");
	}
	
	/**
	 * Returns a String representation of this using {@code delimiter} as namespace delimiter.
	 * @param delimiter the delimiter to use. <code>null</code> will be represented as the String "<code>null</code>".
	 * @return the concatenated segments joined with the given {@code delimiter}
	 * @since 2.3
	 */
	public String toString(String delimiter) {
		int segmentCount = getSegmentCount();
		switch (segmentCount) {
			case 0: return "";
			case 1: return getFirstSegment();
			default:
				StringBuilder builder = new StringBuilder();
				for (int i = 0; i < segmentCount; i++) {
					if (i > 0)
						builder.append(delimiter);
					builder.append(segments[i]);
				}
				return builder.toString();
		}
	}
}
