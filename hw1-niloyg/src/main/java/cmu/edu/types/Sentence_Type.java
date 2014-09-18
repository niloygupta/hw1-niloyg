
/* First created by JCasGen Sun Sep 14 22:41:02 EDT 2014 */
package cmu.edu.types;

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
 * Updated by JCasGen Sun Sep 14 22:41:02 EDT 2014
 * @generated */
public class Sentence_Type extends Annotation_Type {
  /** @generated 
   * @return the generator for this type
   */
  @Override
  protected FSGenerator getFSGenerator() {return fsGenerator;}
  /** @generated */
  private final FSGenerator fsGenerator = 
    new FSGenerator() {
      public FeatureStructure createFS(int addr, CASImpl cas) {
  			 if (Sentence_Type.this.useExistingInstance) {
  			   // Return eq fs instance if already created
  		     FeatureStructure fs = Sentence_Type.this.jcas.getJfsFromCaddr(addr);
  		     if (null == fs) {
  		       fs = new Sentence(addr, Sentence_Type.this);
  			   Sentence_Type.this.jcas.putJfsFromCaddr(addr, fs);
  			   return fs;
  		     }
  		     return fs;
        } else return new Sentence(addr, Sentence_Type.this);
  	  }
    };
  /** @generated */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = Sentence.typeIndexID;
  /** @generated 
     @modifiable */
  @SuppressWarnings ("hiding")
  public final static boolean featOkTst = JCasRegistry.getFeatOkTst("cmu.edu.types.Sentence");
 
  /** @generated */
  final Feature casFeat_GeneTag;
  /** @generated */
  final int     casFeatCode_GeneTag;
  /** @generated
   * @param addr low level Feature Structure reference
   * @return the feature value 
   */ 
  public String getGeneTag(int addr) {
        if (featOkTst && casFeat_GeneTag == null)
      jcas.throwFeatMissing("GeneTag", "cmu.edu.types.Sentence");
    return ll_cas.ll_getStringValue(addr, casFeatCode_GeneTag);
  }
  /** @generated
   * @param addr low level Feature Structure reference
   * @param v value to set 
   */    
  public void setGeneTag(int addr, String v) {
        if (featOkTst && casFeat_GeneTag == null)
      jcas.throwFeatMissing("GeneTag", "cmu.edu.types.Sentence");
    ll_cas.ll_setStringValue(addr, casFeatCode_GeneTag, v);}
    
  
 
  /** @generated */
  final Feature casFeat_TagBegin;
  /** @generated */
  final int     casFeatCode_TagBegin;
  /** @generated
   * @param addr low level Feature Structure reference
   * @return the feature value 
   */ 
  public int getTagBegin(int addr) {
        if (featOkTst && casFeat_TagBegin == null)
      jcas.throwFeatMissing("TagBegin", "cmu.edu.types.Sentence");
    return ll_cas.ll_getIntValue(addr, casFeatCode_TagBegin);
  }
  /** @generated
   * @param addr low level Feature Structure reference
   * @param v value to set 
   */    
  public void setTagBegin(int addr, int v) {
        if (featOkTst && casFeat_TagBegin == null)
      jcas.throwFeatMissing("TagBegin", "cmu.edu.types.Sentence");
    ll_cas.ll_setIntValue(addr, casFeatCode_TagBegin, v);}
    
  
 
  /** @generated */
  final Feature casFeat_TagEnd;
  /** @generated */
  final int     casFeatCode_TagEnd;
  /** @generated
   * @param addr low level Feature Structure reference
   * @return the feature value 
   */ 
  public int getTagEnd(int addr) {
        if (featOkTst && casFeat_TagEnd == null)
      jcas.throwFeatMissing("TagEnd", "cmu.edu.types.Sentence");
    return ll_cas.ll_getIntValue(addr, casFeatCode_TagEnd);
  }
  /** @generated
   * @param addr low level Feature Structure reference
   * @param v value to set 
   */    
  public void setTagEnd(int addr, int v) {
        if (featOkTst && casFeat_TagEnd == null)
      jcas.throwFeatMissing("TagEnd", "cmu.edu.types.Sentence");
    ll_cas.ll_setIntValue(addr, casFeatCode_TagEnd, v);}
    
  
 
  /** @generated */
  final Feature casFeat_LineID;
  /** @generated */
  final int     casFeatCode_LineID;
  /** @generated
   * @param addr low level Feature Structure reference
   * @return the feature value 
   */ 
  public String getLineID(int addr) {
        if (featOkTst && casFeat_LineID == null)
      jcas.throwFeatMissing("LineID", "cmu.edu.types.Sentence");
    return ll_cas.ll_getStringValue(addr, casFeatCode_LineID);
  }
  /** @generated
   * @param addr low level Feature Structure reference
   * @param v value to set 
   */    
  public void setLineID(int addr, String v) {
        if (featOkTst && casFeat_LineID == null)
      jcas.throwFeatMissing("LineID", "cmu.edu.types.Sentence");
    ll_cas.ll_setStringValue(addr, casFeatCode_LineID, v);}
    
  



  /** initialize variables to correspond with Cas Type and Features
	 * @generated
	 * @param jcas JCas
	 * @param casType Type 
	 */
  public Sentence_Type(JCas jcas, Type casType) {
    super(jcas, casType);
    casImpl.getFSClassRegistry().addGeneratorForType((TypeImpl)this.casType, getFSGenerator());

 
    casFeat_GeneTag = jcas.getRequiredFeatureDE(casType, "GeneTag", "uima.cas.String", featOkTst);
    casFeatCode_GeneTag  = (null == casFeat_GeneTag) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_GeneTag).getCode();

 
    casFeat_TagBegin = jcas.getRequiredFeatureDE(casType, "TagBegin", "uima.cas.Integer", featOkTst);
    casFeatCode_TagBegin  = (null == casFeat_TagBegin) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_TagBegin).getCode();

 
    casFeat_TagEnd = jcas.getRequiredFeatureDE(casType, "TagEnd", "uima.cas.Integer", featOkTst);
    casFeatCode_TagEnd  = (null == casFeat_TagEnd) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_TagEnd).getCode();

 
    casFeat_LineID = jcas.getRequiredFeatureDE(casType, "LineID", "uima.cas.String", featOkTst);
    casFeatCode_LineID  = (null == casFeat_LineID) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_LineID).getCode();

  }
}



    