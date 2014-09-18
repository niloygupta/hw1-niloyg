

/* First created by JCasGen Sun Sep 14 22:41:02 EDT 2014 */
package cmu.edu.types;

import org.apache.uima.jcas.JCas; 
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.jcas.cas.TOP_Type;



/** 
 * Updated by JCasGen Sun Sep 14 22:41:02 EDT 2014
 * XML source: /home/niloygupta/Assignment/hw1-niloyg/src/main/resources/type_system/Gene_types.xml
 * @generated */
public class Sentence extends Annotation {
  /** @generated
   * @ordered 
   */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = JCasRegistry.register(Sentence.class);
  /** @generated
   * @ordered 
   */
  @SuppressWarnings ("hiding")
  public final static int type = typeIndexID;
  /** @generated
   * @return index of the type  
   */
  @Override
  public              int getTypeIndexID() {return typeIndexID;}
 
  /** Never called.  Disable default constructor
   * @generated */
  protected Sentence() {/* intentionally empty block */}
    
  /** Internal - constructor used by generator 
   * @generated
   * @param addr low level Feature Structure reference
   * @param type the type of this Feature Structure 
   */
  public Sentence(int addr, TOP_Type type) {
    super(addr, type);
    readObject();
  }
  
  /** @generated
   * @param jcas JCas to which this Feature Structure belongs 
   */
  public Sentence(JCas jcas) {
    super(jcas);
    readObject();   
  } 

  /** @generated
   * @param jcas JCas to which this Feature Structure belongs
   * @param begin offset to the begin spot in the SofA
   * @param end offset to the end spot in the SofA 
  */  
  public Sentence(JCas jcas, int begin, int end) {
    super(jcas);
    setBegin(begin);
    setEnd(end);
    readObject();
  }   

  /** 
   * <!-- begin-user-doc -->
   * Write your own initialization here
   * <!-- end-user-doc -->
   *
   * @generated modifiable 
   */
  private void readObject() {/*default - does nothing empty block */}
     
 
    
  //*--------------*
  //* Feature: GeneTag

  /** getter for GeneTag - gets 
   * @generated
   * @return value of the feature 
   */
  public String getGeneTag() {
    if (Sentence_Type.featOkTst && ((Sentence_Type)jcasType).casFeat_GeneTag == null)
      jcasType.jcas.throwFeatMissing("GeneTag", "cmu.edu.types.Sentence");
    return jcasType.ll_cas.ll_getStringValue(addr, ((Sentence_Type)jcasType).casFeatCode_GeneTag);}
    
  /** setter for GeneTag - sets  
   * @generated
   * @param v value to set into the feature 
   */
  public void setGeneTag(String v) {
    if (Sentence_Type.featOkTst && ((Sentence_Type)jcasType).casFeat_GeneTag == null)
      jcasType.jcas.throwFeatMissing("GeneTag", "cmu.edu.types.Sentence");
    jcasType.ll_cas.ll_setStringValue(addr, ((Sentence_Type)jcasType).casFeatCode_GeneTag, v);}    
   
    
  //*--------------*
  //* Feature: TagBegin

  /** getter for TagBegin - gets 
   * @generated
   * @return value of the feature 
   */
  public int getTagBegin() {
    if (Sentence_Type.featOkTst && ((Sentence_Type)jcasType).casFeat_TagBegin == null)
      jcasType.jcas.throwFeatMissing("TagBegin", "cmu.edu.types.Sentence");
    return jcasType.ll_cas.ll_getIntValue(addr, ((Sentence_Type)jcasType).casFeatCode_TagBegin);}
    
  /** setter for TagBegin - sets  
   * @generated
   * @param v value to set into the feature 
   */
  public void setTagBegin(int v) {
    if (Sentence_Type.featOkTst && ((Sentence_Type)jcasType).casFeat_TagBegin == null)
      jcasType.jcas.throwFeatMissing("TagBegin", "cmu.edu.types.Sentence");
    jcasType.ll_cas.ll_setIntValue(addr, ((Sentence_Type)jcasType).casFeatCode_TagBegin, v);}    
   
    
  //*--------------*
  //* Feature: TagEnd

  /** getter for TagEnd - gets 
   * @generated
   * @return value of the feature 
   */
  public int getTagEnd() {
    if (Sentence_Type.featOkTst && ((Sentence_Type)jcasType).casFeat_TagEnd == null)
      jcasType.jcas.throwFeatMissing("TagEnd", "cmu.edu.types.Sentence");
    return jcasType.ll_cas.ll_getIntValue(addr, ((Sentence_Type)jcasType).casFeatCode_TagEnd);}
    
  /** setter for TagEnd - sets  
   * @generated
   * @param v value to set into the feature 
   */
  public void setTagEnd(int v) {
    if (Sentence_Type.featOkTst && ((Sentence_Type)jcasType).casFeat_TagEnd == null)
      jcasType.jcas.throwFeatMissing("TagEnd", "cmu.edu.types.Sentence");
    jcasType.ll_cas.ll_setIntValue(addr, ((Sentence_Type)jcasType).casFeatCode_TagEnd, v);}    
   
    
  //*--------------*
  //* Feature: LineID

  /** getter for LineID - gets 
   * @generated
   * @return value of the feature 
   */
  public String getLineID() {
    if (Sentence_Type.featOkTst && ((Sentence_Type)jcasType).casFeat_LineID == null)
      jcasType.jcas.throwFeatMissing("LineID", "cmu.edu.types.Sentence");
    return jcasType.ll_cas.ll_getStringValue(addr, ((Sentence_Type)jcasType).casFeatCode_LineID);}
    
  /** setter for LineID - sets  
   * @generated
   * @param v value to set into the feature 
   */
  public void setLineID(String v) {
    if (Sentence_Type.featOkTst && ((Sentence_Type)jcasType).casFeat_LineID == null)
      jcasType.jcas.throwFeatMissing("LineID", "cmu.edu.types.Sentence");
    jcasType.ll_cas.ll_setStringValue(addr, ((Sentence_Type)jcasType).casFeatCode_LineID, v);}    
  }

    