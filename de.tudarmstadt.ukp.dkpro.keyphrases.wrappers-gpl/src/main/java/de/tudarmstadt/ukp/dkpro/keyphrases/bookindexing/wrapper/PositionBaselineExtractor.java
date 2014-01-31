/*******************************************************************************
 * Copyright 2013
 * Ubiquitous Knowledge Processing (UKP) Lab
 * Technische Universität Darmstadt
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Public License v3.0
 * which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/gpl-3.0.txt
 ******************************************************************************/
package de.tudarmstadt.ukp.dkpro.keyphrases.bookindexing.wrapper;

import static org.apache.uima.fit.factory.AnalysisEngineFactory.createEngineDescription;

import org.apache.uima.analysis_engine.AnalysisEngineDescription;
import org.apache.uima.resource.ResourceInitializationException;

import de.tudarmstadt.ukp.dkpro.keyphrases.core.ranking.PositionRanking;

/**
 * Provides a baseline for book-index-phrase-extraction by ranking the phrases
 * highest, that appear first in a segment.
 * 
 * @author Mateusz Parzonka
 * 
 */
public class PositionBaselineExtractor
	extends BookIndexPhraseExtractor_BaseImpl
{

	@Override
	protected AnalysisEngineDescription createRanker()
		throws ResourceInitializationException
	{
		return createEngineDescription(PositionRanking.class);
	}

}
