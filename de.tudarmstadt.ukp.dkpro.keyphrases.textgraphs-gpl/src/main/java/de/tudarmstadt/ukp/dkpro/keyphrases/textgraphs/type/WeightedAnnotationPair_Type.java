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
package de.tudarmstadt.ukp.dkpro.keyphrases.textgraphs.type;

import org.apache.uima.jcas.JCas;
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.cas.impl.CASImpl;
import org.apache.uima.cas.impl.FSGenerator;
import org.apache.uima.cas.FeatureStructure;
import org.apache.uima.cas.impl.TypeImpl;
import org.apache.uima.cas.Type;
import org.apache.uima.cas.impl.FeatureImpl;
import org.apache.uima.cas.Feature;

/** 
 * Updated by JCasGen Wed May 22 14:44:24 CEST 2013
 * @generated */
public class WeightedAnnotationPair_Type extends AnnotationPair_Type {
  /** @generated */
  @Override
  protected FSGenerator getFSGenerator() {return fsGenerator;}
  /** @generated */
  private final FSGenerator fsGenerator = 
    new FSGenerator() {
      public FeatureStructure createFS(int addr, CASImpl cas) {
  			 if (WeightedAnnotationPair_Type.this.useExistingInstance) {
  			   // Return eq fs instance if already created
  		     FeatureStructure fs = WeightedAnnotationPair_Type.this.jcas.getJfsFromCaddr(addr);
  		     if (null == fs) {
  		       fs = new WeightedAnnotationPair(addr, WeightedAnnotationPair_Type.this);
  			   WeightedAnnotationPair_Type.this.jcas.putJfsFromCaddr(addr, fs);
  			   return fs;
  		     }
  		     return fs;
        } else return new WeightedAnnotationPair(addr, WeightedAnnotationPair_Type.this);
  	  }
    };
  /** @generated */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = WeightedAnnotationPair.typeIndexID;
  /** @generated 
     @modifiable */
  @SuppressWarnings ("hiding")
  public final static boolean featOkTst = JCasRegistry.getFeatOkTst("de.tudarmstadt.ukp.dkpro.keyphrases.textgraphs.type.WeightedAnnotationPair");
 
  /** @generated */
  final Feature casFeat_weight;
  /** @generated */
  final int     casFeatCode_weight;
  /** @generated */ 
  public double getWeight(int addr) {
        if (featOkTst && casFeat_weight == null)
      jcas.throwFeatMissing("weight", "de.tudarmstadt.ukp.dkpro.keyphrases.textgraphs.type.WeightedAnnotationPair");
    return ll_cas.ll_getDoubleValue(addr, casFeatCode_weight);
  }
  /** @generated */    
  public void setWeight(int addr, double v) {
        if (featOkTst && casFeat_weight == null)
      jcas.throwFeatMissing("weight", "de.tudarmstadt.ukp.dkpro.keyphrases.textgraphs.type.WeightedAnnotationPair");
    ll_cas.ll_setDoubleValue(addr, casFeatCode_weight, v);}
    
  



  /** initialize variables to correspond with Cas Type and Features
	* @generated */
  public WeightedAnnotationPair_Type(JCas jcas, Type casType) {
    super(jcas, casType);
    casImpl.getFSClassRegistry().addGeneratorForType((TypeImpl)this.casType, getFSGenerator());

 
    casFeat_weight = jcas.getRequiredFeatureDE(casType, "weight", "uima.cas.Double", featOkTst);
    casFeatCode_weight  = (null == casFeat_weight) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_weight).getCode();

  }
}



    