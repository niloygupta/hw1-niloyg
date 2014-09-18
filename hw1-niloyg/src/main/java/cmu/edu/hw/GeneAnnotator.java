package cmu.edu.hw;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
    String testElement = jcas.getDocumentText();
    int begin = 0 ; 
    int end = 0;
    Pattern eol = Pattern.compile( "\n" );
    Matcher matcher = eol.matcher( testElement );
    int lineNo=0;
    while ( matcher.find() ) {
      end = matcher.start();
      String line = testElement.substring( begin , end );
      createSentence( jcas , line , begin , end,entityR,++lineNo );
      begin = matcher.end();
    }
  }

  /**
   * @param jcas CAS whcih will contain the 
   * annotations (i.e. gene entities )
   * @param docLine 
   * @param begin
   * @param end
   * @param entityR
   * @param lineNo
   */
  private void createSentence( JCas jcas, String docLine , int begin , int end, LingPipeGeneEntityRecognizer entityR, int lineNo ) {
    if ( docLine == null ) return;
    String lineId = docLine.substring(0, docLine.indexOf(" "));
    docLine = docLine.substring(docLine.indexOf(" ")+1);
    
    List<Chunk> chunks = entityR.geneTag(docLine);
    
    for(Chunk geneChunk:chunks)
      createAnnotation( geneChunk, jcas, docLine,  lineId,  lineNo);
    

  }
  
  /**
   * 
   * @param geneChunk
   * @param jcas
   * @param docLine
   * @param lineID
   * @param lineNo
   */
  private void createAnnotation(Chunk geneChunk,JCas jcas,String docLine, String lineID, int lineNo)
  {
    GeneMentionTag geneTag = new GeneMentionTag( jcas , geneChunk.start(), geneChunk.end() );
    geneTag.setTagBegin(docLine.substring(0,(geneChunk.start()-1)<0?0:geneChunk.start()-1).replaceAll("\\s","").length());
    geneTag.setTagEnd(docLine.substring(0,geneChunk.end()-1).replaceAll("\\s","").length());
    geneTag.setGeneTag(docLine.substring(geneChunk.start(), geneChunk.end()));
    geneTag.setLineID(lineID);
    geneTag.setBegin(lineNo);
    geneTag.setEnd(docLine.length()-geneChunk.start());
    geneTag.addToIndexes();
    
  }

}
