package cmu.edu.hw;

import java.util.List;

import org.apache.uima.analysis_component.JCasAnnotator_ImplBase;
import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.jcas.JCas;

import cmu.edu.types.GeneMentionTag;

import com.aliasi.chunk.Chunk;



/**
 * @author niloyg
 *
 */

public class GeneAnnotator extends JCasAnnotator_ImplBase {
  
  @Override
  public void process( JCas jcas ) throws AnalysisEngineProcessException {
    LingPipeGeneEntityRecognizer entityR = new LingPipeGeneEntityRecognizer();
    String geneText = jcas.getDocumentText();
    if ( geneText == null ) return;
    String lineId = geneText.substring(0, geneText.indexOf(" ")); //Extracting the sentence ID
    geneText = geneText.substring(geneText.indexOf(" ")+1);
    
    List<Chunk> chunks = entityR.geneTag(geneText);
    
    for(Chunk geneChunk:chunks)
      createAnnotation( geneChunk, jcas, geneText,  lineId);
    
    
  }
  
  /**
   * 
   * @param geneChunk Gene Entity that has been chunked out by LingPipe
   * @param jcas The CAS object which contains the data (Sentence(
   * @param geneText The sentence stripped out of the ID
   * @param lineID The sentence ID
   * Creates a GeneMentionTag annotation and adds it to the CAS Index
   */
  private void createAnnotation(Chunk geneChunk,JCas jcas,String geneText, String lineID)
  {
    GeneMentionTag geneTag = new GeneMentionTag( jcas , geneChunk.start(), geneChunk.end() );
    geneTag.setTagBegin(geneText.substring(0,(geneChunk.start()-1)<0?0:geneChunk.start()-1).replaceAll("\\s","").length());
    geneTag.setTagEnd(geneText.substring(0,geneChunk.end()-1).replaceAll("\\s","").length());
    geneTag.setGeneTag(geneText.substring(geneChunk.start(), geneChunk.end()));
    geneTag.setLineID(lineID);
    geneTag.addToIndexes();
    
  }

}
