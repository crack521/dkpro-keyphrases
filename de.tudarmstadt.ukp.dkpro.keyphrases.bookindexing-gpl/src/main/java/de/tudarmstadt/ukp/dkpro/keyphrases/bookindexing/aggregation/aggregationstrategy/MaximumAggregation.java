/*******************************************************************************
 * Copyright 2013
 * Ubiquitous Knowledge Processing (UKP) Lab
 * Technische Universität Darmstadt
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 ******************************************************************************/
package de.tudarmstadt.ukp.dkpro.keyphrases.bookindexing.aggregation.aggregationstrategy;

import java.util.*;

import org.apache.uima.util.Level;

import com.google.common.collect.Table;

/**
 * Takes the maximum score of ranked phrases contained in all segments.
 *
 * @author Mateusz Parzonka
 *
 */
public class MaximumAggregation
	extends AggregationStrategy
{

	@Override
	public List<RankedPhrase> aggregatePhrases(
			Table<String, Integer, Double> phraseSegmentTable)
	{

		List<RankedPhrase> rankedPhrases = new ArrayList<RankedPhrase>();

		if (getLogger() != null && getLogger().isLoggable(Level.CONFIG))
			getLogger().log(
					Level.CONFIG,
					String.format(Locale.US, "Using AggregationStrategy: "
							+ this.getClass().getSimpleName()));

		for (String phrase : phraseSegmentTable.rowKeySet()) {
			Collection<Double> segmentScores = phraseSegmentTable.row(phrase)
					.values();
			Double newScore = maximum(segmentScores);

			if (getLogger() != null && getLogger().isLoggable(Level.FINEST))
				getLogger().log(
						Level.FINEST,
						String.format(Locale.US,
								"Maximum score for phrase %s in %d segments was %.3f.", phrase,
								segmentScores.size(), newScore));

			rankedPhrases.add(new RankedPhrase(phrase, newScore));
		}
		return rankedPhrases;

	}

	/**
	 * Calculates the maximum double in a collection of doubles.
	 *
	 * @param scores
	 *          collection of doubles
	 * @return the maximum double
	 */
	private Double maximum(Collection<Double> scores)
	{
		double max = 0D;
		for (Double score : scores) {
			if (score > max)
				max = score;
		}
		return max;
	}

}