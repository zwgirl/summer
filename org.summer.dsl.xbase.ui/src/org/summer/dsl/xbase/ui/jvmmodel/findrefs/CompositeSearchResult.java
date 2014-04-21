/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.summer.dsl.xbase.ui.jvmmodel.findrefs;

import static com.google.common.collect.Iterables.*;
import static com.google.common.collect.Lists.*;

import java.util.List;

import org.eclipse.core.runtime.Assert;
import org.eclipse.jdt.internal.ui.search.JavaSearchResult;
import org.eclipse.search.ui.ISearchQuery;
import org.eclipse.search.ui.ISearchResult;
import org.eclipse.search.ui.ISearchResultListener;
import org.eclipse.search.ui.SearchResultEvent;
import org.eclipse.search.ui.text.AbstractTextSearchResult;
import org.eclipse.search.ui.text.Match;
import org.eclipse.search.ui.text.RemoveAllEvent;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public class CompositeSearchResult extends JavaSearchResult {
	
	private CompositeSearchQuery query;
	private ISearchResultListener childListener;

	public CompositeSearchResult(CompositeSearchQuery compositeSearchQuery) {
		super(compositeSearchQuery);
		this.query = compositeSearchQuery;
		Assert.isLegal(!query.getChildren().isEmpty());
		childListener = new ISearchResultListener() {
			int removeAll = 0;
			public void searchResultChanged(SearchResultEvent e) {
				if(!(e instanceof RemoveAllEvent) || removeAll++%query.getChildren().size() == 0)
					fireChange(e);
			}
		};
		for(ISearchQuery child: query.getChildren()) 
			child.getSearchResult().addListener(childListener);
	}

	@Override
	public int getMatchCount(Object element) {
		int count = 0;
		for(ISearchQuery child: query.getChildren()) {
			ISearchResult childResult = child.getSearchResult();
			if(childResult instanceof AbstractTextSearchResult)
				count += ((AbstractTextSearchResult) childResult).getMatchCount(element);
		}
		return count;
	}

	@Override
	public int getMatchCount() {
		int count = 0;
		for(ISearchQuery child: query.getChildren()) {
			ISearchResult childResult = child.getSearchResult();
			if(childResult instanceof AbstractTextSearchResult)
				count += ((AbstractTextSearchResult) childResult).getMatchCount();
		}
		return count;
	}
	
	@Override
	public Match[] getMatches(Object element) {
		List<Match> matches = newArrayList();
		for(ISearchQuery child: query.getChildren()) {
			ISearchResult childResult = child.getSearchResult();
			if(childResult instanceof AbstractTextSearchResult) {
				for(Match match: ((AbstractTextSearchResult) childResult).getMatches(element)) 
					matches.add(match);
				
			}
		}
		return toArray(matches, Match.class);
	}
}