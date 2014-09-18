package cmu.edu.hw;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.aliasi.chunk.Chunk;
import com.aliasi.chunk.Chunker;
import com.aliasi.chunk.Chunking;
import com.aliasi.util.AbstractExternalizable;

public class LingPipeGeneEntityRecognizer {

  private final String trainedGeneERModel = "src/main/resources/ne-en-bio-genetag.HmmChunker"; 
  public List<Chunk> geneTag(String geneText)
  {
    File modelFile = new File(trainedGeneERModel);
    List<Chunk> chunks = new ArrayList<Chunk>();
    // System.out.println("Reading chunker from file=" + modelFile);
    Chunker chunker = null;
    try {
      chunker = (Chunker) AbstractExternalizable.readObject(modelFile);
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }

    Chunking chunking = chunker.chunk(geneText);
    for(Chunk chunk:chunking.chunkSet())
      chunks.add(chunk);

    return chunks;
  }
  
}
