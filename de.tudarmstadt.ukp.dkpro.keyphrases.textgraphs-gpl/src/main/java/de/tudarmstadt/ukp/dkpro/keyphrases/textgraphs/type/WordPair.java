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
import org.apache.uima.jcas.cas.TOP_Type;

import org.apache.uima.jcas.tcas.Annotation;
import de.tudarmstadt.ukp.dkpro.core.api.lexmorph.type.pos.POS;
import de.tudarmstadt.ukp.dkpro.core.api.segmentation.type.Token;


/** 
 * Updated by JCasGen Wed May 22 14:44:24 CEST 2013
 * XML source: /srv/workspace42/de.tudarmstadt.ukp.dkpro.keyphrases/de.tudarmstadt.ukp.dkpro.keyphrases.textgraphs/src/main/resources/desc/type/EdgeWeight.xml
 * @generated */
public class WordPair extends Annotation {
  /** @generated
   * @ordered 
   */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = JCasRegistry.register(WordPair.class);
  /** @generated
   * @ordered 
   */
  @SuppressWarnings ("hiding")
  public final static int type = typeIndexID;
  /** @generated  */
  @Override
  public              int getTypeIndexID() {return typeIndexID;}
 
  /** Never called.  Disable default constructor
   * @generated */
  protected WordPair() {/* intentionally empty block */}
    
  /** Internal - constructor used by generator 
   * @generated */
  public WordPair(int addr, TOP_Type type) {
    super(addr, type);
    readObject();
  }
  
  /** @generated */
  public WordPair(JCas jcas) {
    super(jcas);
    readObject();   
  } 

  /** @generated */  
  public WordPair(JCas jcas, int begin, int end) {
    super(jcas);
    setBegin(begin);
    setEnd(end);
    readObject();
  }   

  /** <!-- begin-user-doc -->
    * Write your own initialization here
    * <!-- end-user-doc -->
  @generated modifiable */
  private void readObject() {/*default - does nothing empty block */}
     
 
    
  //*--------------*
  //* Feature: Word1

  /** getter for Word1 - gets 
   * @generated */
  public String getWord1() {
    if (WordPair_Type.featOkTst && ((WordPair_Type)jcasType).casFeat_Word1 == null)
      jcasType.jcas.throwFeatMissing("Word1", "de.tudarmstadt.ukp.dkpro.keyphrases.textgraphs.type.WordPair");
    return jcasType.ll_cas.ll_getStringValue(addr, ((WordPair_Type)jcasType).casFeatCode_Word1);}
    
  /** setter for Word1 - sets  
   * @generated */
  public void setWord1(String v) {
    if (WordPair_Type.featOkTst && ((WordPair_Type)jcasType).casFeat_Word1 == null)
      jcasType.jcas.throwFeatMissing("Word1", "de.tudarmstadt.ukp.dkpro.keyphrases.textgraphs.type.WordPair");
    jcasType.ll_cas.ll_setStringValue(addr, ((WordPair_Type)jcasType).casFeatCode_Word1, v);}    
   
    
  //*--------------*
  //* Feature: Word2

  /** getter for Word2 - gets 
   * @generated */
  public String getWord2() {
    if (WordPair_Type.featOkTst && ((WordPair_Type)jcasType).casFeat_Word2 == null)
      jcasType.jcas.throwFeatMissing("Word2", "de.tudarmstadt.ukp.dkpro.keyphrases.textgraphs.type.WordPair");
    return jcasType.ll_cas.ll_getStringValue(addr, ((WordPair_Type)jcasType).casFeatCode_Word2);}
    
  /** setter for Word2 - sets  
   * @generated */
  public void setWord2(String v) {
    if (WordPair_Type.featOkTst && ((WordPair_Type)jcasType).casFeat_Word2 == null)
      jcasType.jcas.throwFeatMissing("Word2", "de.tudarmstadt.ukp.dkpro.keyphrases.textgraphs.type.WordPair");
    jcasType.ll_cas.ll_setStringValue(addr, ((WordPair_Type)jcasType).casFeatCode_Word2, v);}    
   
    
  //*--------------*
  //* Feature: Pos1

  /** getter for Pos1 - gets 
   * @generated */
  public POS getPos1() {
    if (WordPair_Type.featOkTst && ((WordPair_Type)jcasType).casFeat_Pos1 == null)
      jcasType.jcas.throwFeatMissing("Pos1", "de.tudarmstadt.ukp.dkpro.keyphrases.textgraphs.type.WordPair");
    return (POS)(jcasType.ll_cas.ll_getFSForRef(jcasType.ll_cas.ll_getRefValue(addr, ((WordPair_Type)jcasType).casFeatCode_Pos1)));}
    
  /** setter for Pos1 - sets  
   * @generated */
  public void setPos1(POS v) {
    if (WordPair_Type.featOkTst && ((WordPair_Type)jcasType).casFeat_Pos1 == null)
      jcasType.jcas.throwFeatMissing("Pos1", "de.tudarmstadt.ukp.dkpro.keyphrases.textgraphs.type.WordPair");
    jcasType.ll_cas.ll_setRefValue(addr, ((WordPair_Type)jcasType).casFeatCode_Pos1, jcasType.ll_cas.ll_getFSRef(v));}    
   
    
  //*--------------*
  //* Feature: Pos2

  /** getter for Pos2 - gets 
   * @generated */
  public POS getPos2() {
    if (WordPair_Type.featOkTst && ((WordPair_Type)jcasType).casFeat_Pos2 == null)
      jcasType.jcas.throwFeatMissing("Pos2", "de.tudarmstadt.ukp.dkpro.keyphrases.textgraphs.type.WordPair");
    return (POS)(jcasType.ll_cas.ll_getFSForRef(jcasType.ll_cas.ll_getRefValue(addr, ((WordPair_Type)jcasType).casFeatCode_Pos2)));}
    
  /** setter for Pos2 - sets  
   * @generated */
  public void setPos2(POS v) {
    if (WordPair_Type.featOkTst && ((WordPair_Type)jcasType).casFeat_Pos2 == null)
      jcasType.jcas.throwFeatMissing("Pos2", "de.tudarmstadt.ukp.dkpro.keyphrases.textgraphs.type.WordPair");
    jcasType.ll_cas.ll_setRefValue(addr, ((WordPair_Type)jcasType).casFeatCode_Pos2, jcasType.ll_cas.ll_getFSRef(v));}    
   
    
  //*--------------*
  //* Feature: Token1

  /** getter for Token1 - gets 
   * @generated */
  public Token getToken1() {
    if (WordPair_Type.featOkTst && ((WordPair_Type)jcasType).casFeat_Token1 == null)
      jcasType.jcas.throwFeatMissing("Token1", "de.tudarmstadt.ukp.dkpro.keyphrases.textgraphs.type.WordPair");
    return (Token)(jcasType.ll_cas.ll_getFSForRef(jcasType.ll_cas.ll_getRefValue(addr, ((WordPair_Type)jcasType).casFeatCode_Token1)));}
    
  /** setter for Token1 - sets  
   * @generated */
  public void setToken1(Token v) {
    if (WordPair_Type.featOkTst && ((WordPair_Type)jcasType).casFeat_Token1 == null)
      jcasType.jcas.throwFeatMissing("Token1", "de.tudarmstadt.ukp.dkpro.keyphrases.textgraphs.type.WordPair");
    jcasType.ll_cas.ll_setRefValue(addr, ((WordPair_Type)jcasType).casFeatCode_Token1, jcasType.ll_cas.ll_getFSRef(v));}    
   
    
  //*--------------*
  //* Feature: Token2

  /** getter for Token2 - gets 
   * @generated */
  public Token getToken2() {
    if (WordPair_Type.featOkTst && ((WordPair_Type)jcasType).casFeat_Token2 == null)
      jcasType.jcas.throwFeatMissing("Token2", "de.tudarmstadt.ukp.dkpro.keyphrases.textgraphs.type.WordPair");
    return (Token)(jcasType.ll_cas.ll_getFSForRef(jcasType.ll_cas.ll_getRefValue(addr, ((WordPair_Type)jcasType).casFeatCode_Token2)));}
    
  /** setter for Token2 - sets  
   * @generated */
  public void setToken2(Token v) {
    if (WordPair_Type.featOkTst && ((WordPair_Type)jcasType).casFeat_Token2 == null)
      jcasType.jcas.throwFeatMissing("Token2", "de.tudarmstadt.ukp.dkpro.keyphrases.textgraphs.type.WordPair");
    jcasType.ll_cas.ll_setRefValue(addr, ((WordPair_Type)jcasType).casFeatCode_Token2, jcasType.ll_cas.ll_getFSRef(v));}    
  }

    