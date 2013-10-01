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
package de.tudarmstadt.ukp.dkpro.keyphrases.bookindexing.evaluation.matchingstrategy;

/**
 *
 * @author Mateusz Parzonka
 * 
 */
public class MatchingExact
	extends MatchingStrategy
{

	@Override
	public boolean isMatch(String phrase, String goldPhrase)
	{
		return phrase.equals(goldPhrase);
	}

}
