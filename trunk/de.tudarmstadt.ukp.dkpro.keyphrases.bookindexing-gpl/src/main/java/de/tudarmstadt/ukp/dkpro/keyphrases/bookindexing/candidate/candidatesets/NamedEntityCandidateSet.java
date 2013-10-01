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
package de.tudarmstadt.ukp.dkpro.keyphrases.bookindexing.candidate.candidatesets;

import org.apache.uima.analysis_engine.AnalysisEngineDescription;
import org.apache.uima.fit.factory.AggregateBuilder;
import org.apache.uima.fit.factory.AnalysisEngineFactory;
import org.apache.uima.jcas.tcas.Annotation;
import org.apache.uima.resource.ResourceInitializationException;

import de.tudarmstadt.ukp.dkpro.core.api.ner.type.NamedEntity;
import de.tudarmstadt.ukp.dkpro.core.stanfordnlp.StanfordNamedEntityRecognizer;
import de.tudarmstadt.ukp.dkpro.keyphrases.bookindexing.candidate.candidatesets.base.OverlappingCandidateSet_BaseImpl;

/**
 * Creates an aggregate description used to produce a candidate annotation based
 * on named entities using a state-of-the-art named entity recognizer.
 *
 * @author Mateusz Parzonka
 *
 */
public class NamedEntityCandidateSet
	extends OverlappingCandidateSet_BaseImpl
{

	@Override
	public Class<? extends Annotation> getType()
	{
		return NamedEntity.class;
	}

	protected AnalysisEngineDescription getNamedEntityAnnotator()
		throws ResourceInitializationException
	{
		return AnalysisEngineFactory.createPrimitiveDescription(StanfordNamedEntityRecognizer.class,
				StanfordNamedEntityRecognizer.PARAM_MODEL_LOCATION,
				"classpath:/resources/StanfordNLP/ner-eng-ie.crf-3-all2008.ser.gz");
	}

	@Override
	public AnalysisEngineDescription createPreprocessingComponents(String language)
		throws ResourceInitializationException
	{
		AggregateBuilder builder = new AggregateBuilder();
		builder.add(getTokenizer(language));
		builder.add(getTagger(language));
		builder.add(getNamedEntityAnnotator());
		builder.add(getCandidateAnnotator());
		return builder.createAggregateDescription();
	}

	@Override
	public String toString()
	{
		return "CandidateType: NamedEntity" + LF + super.toString();
	}

}
