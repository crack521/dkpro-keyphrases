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
package de.tudarmstadt.ukp.dkpro.keyphrases.bookindexing.aggregation.aggregationstrategy;

import java.util.List;

import org.apache.uima.fit.component.Resource_ImplBase;

import com.google.common.collect.Table;

/**
 * The aggregation strategy defines the method of extracting and merging ranked
 * phrases from segments. Segments are modeled as columns in tables.
 *
 * @author Mateusz Parzonka
 *
 */
public abstract class AggregationStrategy
	extends Resource_ImplBase
{

	/**
	 * The phrases are aggregated and extracted from the Segments and added to the
	 * document.
	 *
	 * @param phrasesPerSegmentTable the number of phrases per segment table
	 * @return the aggregated phrases
	 */
	public abstract List<RankedPhrase> aggregatePhrases(
			Table<String, Integer, Double> phrasesPerSegmentTable);

	@Override
	public String toString()
	{
		return this.getClass().getSimpleName();
	}

	public final static class RankedPhrase
	{

		private final String phrase;
		private final Double score;

		public RankedPhrase(final String phrase, final Double score)
		{
			super();
			this.phrase = phrase;
			this.score = score;
		}

		/**
		 * @return the phrase
		 */
		public String getPhrase()
		{
			return phrase;
		}

		/**
		 * @return the score
		 */
		public Double getScore()
		{
			return score;
		}

	}

}
