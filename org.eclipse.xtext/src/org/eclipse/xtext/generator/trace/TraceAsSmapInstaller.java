/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.generator.trace;

import static com.google.common.collect.Maps.*;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.xtext.LanguageInfo;
import org.eclipse.xtext.generator.trace.LineMappingProvider.LineMapping;
import org.eclipse.xtext.resource.IResourceServiceProvider;
import org.eclipse.xtext.smap.SDEInstaller;
import org.eclipse.xtext.smap.SmapGenerator;
import org.eclipse.xtext.smap.SmapStratum;

import com.google.inject.Inject;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class TraceAsSmapInstaller implements ITraceToBytecodeInstaller {

	@SuppressWarnings("unused")
	private static final Logger log = Logger.getLogger(TraceAsSmapInstaller.class);

	@Inject
	private LineMappingProvider lineMappingProvider;

	@Inject
	private IResourceServiceProvider.Registry serviceProviderRegistry;
	
	@Inject
	private ITraceURIConverter traceURIConverter; 

	protected String smap;

	protected @Nullable
	String generateSmap(AbstractTraceRegion rootTraceRegion, String outputFileName) {
		List<LineMapping> lineInfo = lineMappingProvider.getLineMapping(rootTraceRegion);
		if (lineInfo == null || lineInfo.isEmpty())
			return null;
		return toSmap(outputFileName, lineInfo);
	}

	protected String getPath(URI path) {
		return traceURIConverter.getURIForTrace(path).toString();
	}

	protected String getStratumName(final URI path) {
		IResourceServiceProvider provider = serviceProviderRegistry.getResourceServiceProvider(path.trimFragment());
		if (provider == null) {
			// it might happen that trace data is in the workspace but the corresponding language is not installed.
			// we use the file extension then.
			return path.fileExtension() != null ? path.fileExtension() : "unknown";
		}
		final LanguageInfo languageInfo = provider.get(LanguageInfo.class);
		String name = languageInfo.getShortName();
		return name;
	}

	public byte[] installTrace(byte[] javaClassBytecode) throws IOException {
		if (smap == null)
			return null;
		byte[] updatedByteCode = new SDEInstaller(javaClassBytecode, smap.getBytes()).getUpdatedByteCode();
		return updatedByteCode;
	}

	public void setTrace(String javaFileName, AbstractTraceRegion trace) {
		smap = generateSmap(trace, javaFileName);
	}

	protected String toSmap(String outputFileName, List<LineMapping> lineInfo) {
		SmapGenerator generator = new SmapGenerator();
		generator.setOutputFileName(outputFileName);
		Map<String, SmapStratum> strata = newHashMap();
		for (LineMapping lm : lineInfo) {
			String stratumName = getStratumName(lm.source);
			if (!"Java".equals(stratumName)) {
				final String path = getPath(lm.source);
				if (path != null) {
					SmapStratum stratum = strata.get(stratumName);
					if (stratum == null) {
						stratum = new SmapStratum(stratumName);
						strata.put(stratumName, stratum);
						generator.addStratum(stratum, true);
					}
					final String fileName = lm.source.lastSegment();
					stratum.addFile(fileName, path);
					stratum.addLineData(lm.sourceStartLine, fileName, 1, lm.targetStartLine + 1, lm.targetEndLine
							- lm.targetStartLine + 1);
				}
			}
		}
		return generator.getString();
	}
}
