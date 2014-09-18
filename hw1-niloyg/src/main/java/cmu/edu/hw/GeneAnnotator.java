package cmu.edu.hw;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.uima.UimaContext;
import org.apache.uima.analysis_component.JCasAnnotator_ImplBase;
import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.cas.FSIterator;
import org.apache.uima.cas.text.AnnotationIndex;
import org.apache.uima.jcas.JCas;
import org.apache.uima.jcas.cas.FSArray;
import org.apache.uima.resource.ResourceInitializationException;

import com.aliasi.chunk.Chunk;

import cmu.edu.types.Sentence;



public class GeneAnnotator extends JCasAnnotator_ImplBase {

  @Override
  public void process( JCas jcas ) throws AnalysisEngineProcessException {
   // PosTagNamedEntityRecognizer geneEntityRecognizer = new PosTagNamedEntityRecognizer();
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

  private void createSentence( JCas jcas, String docLine , int begin , int end, LingPipeGeneEntityRecognizer entityR, int lineNo ) {
    if ( docLine == null ) return;
    String lineId = docLine.substring(0, docLine.indexOf(" "));
    docLine = docLine.substring(docLine.indexOf(" ")+1);
    /*Map<Integer,Integer> geneTags = geneEntityRecognizer.getGeneSpans(docLine);
    
    for(Integer tagBegin:geneTags.keySet())
    {
      Sentence geneLine = new Sentence( jcas , tagBegin, geneTags.get(tagBegin) );
      geneLine.setTagBegin(tagBegin);
      geneLine.setTagEnd(geneTags.get(tagBegin));
      geneLine.setGeneTag(docLine.substring(tagBegin, geneTags.get(tagBegin)));
      geneLine.setLineID(lineId);
      geneLine.setCasProcessorId( this.getClass().getName() );
      geneLine.setConfidence( 1.0d );
      geneLine.addToIndexes(); 
    } */
    
    List<Chunk> chunks = entityR.geneTag(docLine);
    
    for(Chunk geneChunk:chunks)
    {
      Sentence geneLine = new Sentence( jcas , geneChunk.start(), geneChunk.end() );
      geneLine.setTagBegin(docLine.substring(0,(geneChunk.start()-1)<0?0:geneChunk.start()-1).replaceAll("\\s","").length());
      geneLine.setTagEnd(docLine.substring(0,geneChunk.end()-1).replaceAll("\\s","").length());
      geneLine.setGeneTag(docLine.substring(geneChunk.start(), geneChunk.end()));
     // System.out.println(docLine.substring(chunk.start(), chunk.end()));
      geneLine.setLineID(lineId);
      geneLine.setBegin(lineNo);
      geneLine.setEnd(docLine.length()-geneChunk.start());
      geneLine.setCasProcessorId( this.getClass().getName() );
      geneLine.setConfidence( 1.0d );
      geneLine.addToIndexes(); 
    }

  }

}
