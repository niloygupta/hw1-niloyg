package cmu.edu.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.aliasi.chunk.Chunk;

import cmu.edu.hw.LingPipeGeneEntityRecognizer;
import cmu.edu.types.Sentence;

public class LingPipeTest {

  @Test
  public void test() {
    LingPipeGeneEntityRecognizer entityR = new LingPipeGeneEntityRecognizer();
    String docLine ="P00001606T0076 Comparison with alkaline phosphatases and 5-nucleotidase.";
    if ( docLine == null ) return;
    String lineId = docLine.substring(0, docLine.indexOf(" "));
    docLine = docLine.substring(docLine.indexOf(" ")+1);
    List<Chunk> chunks = entityR.geneTag(docLine);
    for(Chunk chunk:chunks)
    {
      int startOffest = docLine.substring(0,chunk.start()-1).replaceAll("\\s","").length();
      int endOffest = docLine.substring(0,chunk.end()-1).replaceAll("\\s","").length();
      System.out.println(lineId+"|"+startOffest+" "+endOffest+"|"+docLine.substring(chunk.start(), chunk.end()));
     // System.out.println(docLine.substring(chunk.start(), chunk.end()));
     
    }
  
  }

}
