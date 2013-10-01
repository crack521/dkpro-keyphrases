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
package de.tudarmstadt.ukp.dkpro.keyphrases.bookindexing.type;

import org.apache.uima.jcas.JCas;
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.cas.impl.CASImpl;
import org.apache.uima.cas.impl.FSGenerator;
import org.apache.uima.cas.FeatureStructure;
import org.apache.uima.cas.impl.TypeImpl;
import org.apache.uima.cas.Type;
import org.apache.uima.cas.impl.FeatureImpl;
import org.apache.uima.cas.Feature;
import org.apache.uima.jcas.tcas.Annotation_Type;

/** 
 * Updated by JCasGen Thu Apr 18 17:31:58 CEST 2013
 * @generated */
public class BookIndexPhrase_Type extends Annotation_Type {
  /** @generated */
  @Override
  protected FSGenerator getFSGenerator() {return fsGenerator;}
  /** @generated */
  private final FSGenerator fsGenerator = 
    new FSGenerator() {
      public FeatureStructure createFS(int addr, CASImpl cas) {
  			 if (BookIndexPhrase_Type.this.useExistingInstance) {
  			   // Return eq fs instance if already created
  		     FeatureStructure fs = BookIndexPhrase_Type.this.jcas.getJfsFromCaddr(addr);
  		     if (null == fs) {
  		       fs = new BookIndexPhrase(addr, BookIndexPhrase_Type.this);
  			   BookIndexPhrase_Type.this.jcas.putJfsFromCaddr(addr, fs);
  			   return fs;
  		     }
  		     return fs;
        } else return new BookIndexPhrase(addr, BookIndexPhrase_Type.this);
  	  }
    };
  /** @generated */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = BookIndexPhrase.typeIndexID;
  /** @generated 
     @modifiable */
  @SuppressWarnings ("hiding")
  public final static boolean featOkTst = JCasRegistry.getFeatOkTst("de.tudarmstadt.ukp.dkpro.keyphrases.bookindexing.type.BookIndexPhrase");
 
  /** @generated */
  final Feature casFeat_score;
  /** @generated */
  final int     casFeatCode_score;
  /** @generated */ 
  public double getScore(int addr) {
        if (featOkTst && casFeat_score == null)
      jcas.throwFeatMissing("score", "de.tudarmstadt.ukp.dkpro.keyphrases.bookindexing.type.BookIndexPhrase");
    return ll_cas.ll_getDoubleValue(addr, casFeatCode_score);
  }
  /** @generated */    
  public void setScore(int addr, double v) {
        if (featOkTst && casFeat_score == null)
      jcas.throwFeatMissing("score", "de.tudarmstadt.ukp.dkpro.keyphrases.bookindexing.type.BookIndexPhrase");
    ll_cas.ll_setDoubleValue(addr, casFeatCode_score, v);}
    
  
 
  /** @generated */
  final Feature casFeat_phrase;
  /** @generated */
  final int     casFeatCode_phrase;
  /** @generated */ 
  public String getPhrase(int addr) {
        if (featOkTst && casFeat_phrase == null)
      jcas.throwFeatMissing("phrase", "de.tudarmstadt.ukp.dkpro.keyphrases.bookindexing.type.BookIndexPhrase");
    return ll_cas.ll_getStringValue(addr, casFeatCode_phrase);
  }
  /** @generated */    
  public void setPhrase(int addr, String v) {
        if (featOkTst && casFeat_phrase == null)
      jcas.throwFeatMissing("phrase", "de.tudarmstadt.ukp.dkpro.keyphrases.bookindexing.type.BookIndexPhrase");
    ll_cas.ll_setStringValue(addr, casFeatCode_phrase, v);}
    
  



  /** initialize variables to correspond with Cas Type and Features
	* @generated */
  public BookIndexPhrase_Type(JCas jcas, Type casType) {
    super(jcas, casType);
    casImpl.getFSClassRegistry().addGeneratorForType((TypeImpl)this.casType, getFSGenerator());

 
    casFeat_score = jcas.getRequiredFeatureDE(casType, "score", "uima.cas.Double", featOkTst);
    casFeatCode_score  = (null == casFeat_score) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_score).getCode();

 
    casFeat_phrase = jcas.getRequiredFeatureDE(casType, "phrase", "uima.cas.String", featOkTst);
    casFeatCode_phrase  = (null == casFeat_phrase) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_phrase).getCode();

  }
}



    