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
package de.tudarmstadt.ukp.dkpro.keyphrases.lab.tasks;

import static de.tudarmstadt.ukp.dkpro.core.api.io.ResourceCollectionReaderBase.INCLUDE_PREFIX;
import static org.apache.uima.fit.factory.ExternalResourceFactory.createExternalResourceDescription;

import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import org.apache.uima.analysis_engine.AnalysisEngineDescription;
import org.apache.uima.collection.CollectionReaderDescription;
import org.apache.uima.resource.ResourceInitializationException;

import de.tudarmstadt.ukp.dkpro.core.api.segmentation.SegmenterBase;
import de.tudarmstadt.ukp.dkpro.core.api.segmentation.type.Compound.CompoundSplitLevel;
import de.tudarmstadt.ukp.dkpro.core.api.segmentation.type.Token;
import de.tudarmstadt.ukp.dkpro.core.decompounding.uima.annotator.CompoundAnnotator;
import de.tudarmstadt.ukp.dkpro.core.decompounding.uima.resource.AsvToolboxSplitterResource;
import de.tudarmstadt.ukp.dkpro.core.decompounding.uima.resource.FrequencyRankerResource;
import de.tudarmstadt.ukp.dkpro.core.decompounding.uima.resource.RankerResource;
import de.tudarmstadt.ukp.dkpro.core.decompounding.uima.resource.SharedDictionary;
import de.tudarmstadt.ukp.dkpro.core.decompounding.uima.resource.SharedFinder;
import de.tudarmstadt.ukp.dkpro.core.decompounding.uima.resource.SharedLinkingMorphemes;
import de.tudarmstadt.ukp.dkpro.core.decompounding.uima.resource.SplitterResource;
import de.tudarmstadt.ukp.dkpro.core.decompounding.web1t.LuceneIndexer;
import de.tudarmstadt.ukp.dkpro.core.frequency.tfidf.TfidfConsumer;
import de.tudarmstadt.ukp.dkpro.core.io.text.TextReader;
import de.tudarmstadt.ukp.dkpro.core.io.xmi.XmiWriter;
import de.tudarmstadt.ukp.dkpro.core.ngrams.NGramAnnotator;
import de.tudarmstadt.ukp.dkpro.core.posfilter.PosFilter;
import de.tudarmstadt.ukp.dkpro.core.stanfordnlp.StanfordCoreferenceResolver;
import de.tudarmstadt.ukp.dkpro.core.stanfordnlp.StanfordNamedEntityRecognizer;
import de.tudarmstadt.ukp.dkpro.core.stopwordremover.StopWordRemover;
import de.tudarmstadt.ukp.dkpro.core.treetagger.TreeTaggerChunkerTT4J;
import de.tudarmstadt.ukp.dkpro.core.treetagger.TreeTaggerPosLemmaTT4J;
import de.tudarmstadt.ukp.dkpro.keyphrases.decompounding.uima.annotator.CompoundPartTokenizer;
import de.tudarmstadt.ukp.dkpro.lab.engine.TaskContext;
import de.tudarmstadt.ukp.dkpro.lab.storage.StorageService.AccessMode;
import de.tudarmstadt.ukp.dkpro.lab.task.Discriminator;
import de.tudarmstadt.ukp.dkpro.lab.uima.task.impl.UimaTaskBase;
//import de.tudarmstadt.ukp.dkpro.core.stanfordnlp.StanfordParser;

public class PreprocessingTask
extends UimaTaskBase
{
	public static final String KEY_INPUT_TXT_DOC = "TXT_DOC";
	public static final String KEY_OUTPUT_XMI = "XMI";

	@Discriminator
	private String includePrefix;
	@Discriminator
	private String language;
	@Discriminator
	private String tfidfFeaturePath;
	@Discriminator
	private boolean shouldLowercaseCandidates;
	@Discriminator
	private String dfModelFile;
	@Discriminator
	private String datasetPath;
	@Discriminator
	private String nGramFolder;
	@Discriminator
	private CompoundSplitLevel compoundSplitLevel;
	@Discriminator
	private Class<? extends SegmenterBase> segmenterClass;
	@Discriminator
	private boolean usePosFilter;


	private static final String NE_CLASSIFIER = "/de/tudarmstadt/ukp/dkpro/core/stanfordnlp/lib/"
			+ "ner-en-all.3class.distsim.crf.ser.gz";

	@Override
	public CollectionReaderDescription getCollectionReaderDescription(TaskContext aContext)
			throws ResourceInitializationException, IOException
			{
		return createReader(TextReader.class, TextReader.PARAM_PATH, datasetPath,
				TextReader.PARAM_PATTERNS, new String[] { INCLUDE_PREFIX + includePrefix },
				TextReader.PARAM_LANGUAGE, language);
			}

	@Override
	public AnalysisEngineDescription getAnalysisEngineDescription(TaskContext aContext)
			throws ResourceInitializationException, IOException
			{

		List<AnalysisEngineDescription> engines = new LinkedList<AnalysisEngineDescription>();

		engines.add(createEngine(segmenterClass));

		engines.add(createEngine(TreeTaggerPosLemmaTT4J.class));

		engines.add(createEngine(TreeTaggerChunkerTT4J.class));

		if(language.equals("en")){
			engines.add(createEngine(
					StanfordNamedEntityRecognizer.class,
					StanfordNamedEntityRecognizer.PARAM_MODEL_LOCATION, "classpath:" + NE_CLASSIFIER));
			
			engines.add(createEngine(
					StanfordCoreferenceResolver.class));
		}

		engines.add(createEngine(
				StopWordRemover.class,
				StopWordRemover.PARAM_STOP_WORD_LIST_FILE_NAMES, new String[] {
					"[de]classpath:/stopwords/german_stopwords.txt",
					"[en]classpath:/stopwords/english_stopwords.txt",
				"[en]classpath:/stopwords/english_keyphrase_stopwords.txt"}));

		if(usePosFilter){
			engines.add(createEngine(
					PosFilter.class,
					PosFilter.PARAM_TYPE_TO_REMOVE, Token.class,
					PosFilter.PARAM_ADJ, true,
					PosFilter.PARAM_N, true));
		}


		//Decompounding
		if(compoundSplitLevel != CompoundSplitLevel.NONE){
			//Only prepare indexes if they are needed
			File source = new File(nGramFolder);
			File index = new File(
					"target/decompounding/index");
			index.mkdirs();
			LuceneIndexer indexer = new LuceneIndexer(source, index);
			try {
				indexer.index();
			}
			catch (InterruptedException e) {
				throw new ResourceInitializationException(e);
			}

			engines.add(createEngine(
					CompoundAnnotator.class,
					CompoundAnnotator.PARAM_SPLITTING_ALGO,
					createExternalResourceDescription(AsvToolboxSplitterResource.class,
							SplitterResource.PARAM_DICT_RESOURCE,
							createExternalResourceDescription(SharedDictionary.class),
							SplitterResource.PARAM_MORPHEME_RESOURCE,
							createExternalResourceDescription(SharedLinkingMorphemes.class)),
							CompoundAnnotator.PARAM_RANKING_ALGO,
							createExternalResourceDescription(
									FrequencyRankerResource.class,
									RankerResource.PARAM_FINDER_RESOURCE,
									createExternalResourceDescription(SharedFinder.class,
											SharedFinder.PARAM_INDEX_PATH, index.getAbsolutePath(),
											SharedFinder.PARAM_NGRAM_LOCATION, nGramFolder))));
			engines.add(createEngine(
					CompoundPartTokenizer.class,
					CompoundPartTokenizer.PARAM_COMPOUND_SPLIT_LEVEL, compoundSplitLevel));

		}


		//        AnalysisEngineDescription parser = createPrimitiveDescription(StanfordParser.class,
		//                StanfordParser.PARAM_WRITE_CONSTITUENT, true,
		//                StanfordParser.PARAM_WRITE_DEPENDENCY, true,
		//                StanfordParser.PARAM_WRITE_PENN_TREE,
		//                true, StanfordParser.PARAM_WRITE_POS, true);

		engines.add(createEngine(NGramAnnotator.class,
				NGramAnnotator.PARAM_N, 5));

		engines.add(createEngine(TfidfConsumer.class,
				TfidfConsumer.PARAM_FEATURE_PATH, tfidfFeaturePath, TfidfConsumer.PARAM_LOWERCASE,
				shouldLowercaseCandidates, TfidfConsumer.PARAM_OUTPUT_PATH, dfModelFile));

		File xmiOutputRoot = aContext.getStorageLocation(KEY_OUTPUT_XMI, AccessMode.ADD_ONLY);
		engines.add(createEngine(XmiWriter.class,
				XmiWriter.PARAM_TARGET_LOCATION, xmiOutputRoot,
				XmiWriter.PARAM_COMPRESSION, "GZIP"));

		return createEngine(engines);

			}

}
