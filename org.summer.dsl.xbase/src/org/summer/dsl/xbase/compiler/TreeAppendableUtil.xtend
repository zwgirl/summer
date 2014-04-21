package org.summer.dsl.xbase.compiler

import org.summer.dsl.xbase.compiler.output.ITreeAppendable
import org.eclipse.emf.ecore.EObject
import org.eclipse.xtext.util.ITextRegionWithLineInformation
import org.eclipse.xtext.generator.trace.LocationData
import org.eclipse.xtext.resource.ILocationInFileProviderExtension
import org.eclipse.xtext.resource.ILocationInFileProvider
import com.google.inject.Inject
import org.summer.dsl.xbase.compiler.output.TreeAppendable

class TreeAppendableUtil {
	
	@Inject ILocationInFileProvider locationProvider
	
	def traceSignificant(ITreeAppendable appendable, EObject source) {
		traceSignificant(appendable, source, false)
	}
	
	def traceSignificant(ITreeAppendable appendable, EObject source, boolean useForDebugging) {
		if (appendable instanceof TreeAppendable) {
			(appendable as TreeAppendable).trace(source, ILocationInFileProviderExtension.RegionDescription.SIGNIFICANT, useForDebugging)
		} else {
			val it = locationProvider.getSignificantTextRegion(source) as ITextRegionWithLineInformation
			if (it != null)
				appendable.trace(new LocationData(offset, length, lineNumber, endLineNumber, null), useForDebugging)
			else
				appendable
		}
	}
	
	def traceWithComments(ITreeAppendable appendable, EObject source) {
		if (appendable instanceof TreeAppendable) {
			(appendable as TreeAppendable).trace(source, ILocationInFileProviderExtension.RegionDescription.INCLUDING_COMMENTS, false)
		} else {
			val it = switch(locationProvider) {
				ILocationInFileProviderExtension: locationProvider.getTextRegion(source, ILocationInFileProviderExtension.RegionDescription.INCLUDING_COMMENTS)
				default: locationProvider.getFullTextRegion(source)
			} as ITextRegionWithLineInformation
			if (it != null)
				appendable.trace(new LocationData(offset, length, lineNumber, endLineNumber, null))
			else
				appendable
		}
	}
	
}