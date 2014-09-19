package cmu.edu.hw;

import java.util.ArrayList;
import java.util.List;

import com.aliasi.chunk.Chunk;
import com.aliasi.chunk.Chunker;
import com.aliasi.chunk.Chunking;

public class LingPipeGeneEntityRecognizer {

  /**
   * @param geneText Data point i.e. a sentence in the input file
   * @return List of recognized genes
   */
  public List<Chunk> geneTag(String geneText)
  {
    
    List<Chunk> chunks = new ArrayList<Chunk>();
    Chunker chunker = GeneChunker.getInstance().getChunker();
   
    Chunking chunking = chunker.chunk(geneText);
    for(Chunk chunk:chunking.chunkSet())
      chunks.add(chunk);

    return chunks;
  }
  
}
