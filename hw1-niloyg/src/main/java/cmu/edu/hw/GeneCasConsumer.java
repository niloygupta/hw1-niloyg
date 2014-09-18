/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package cmu.edu.hw;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

import org.apache.uima.cas.CAS;
import org.apache.uima.cas.CASException;
import org.apache.uima.cas.FSIterator;
import org.apache.uima.collection.CasConsumer_ImplBase;
import org.apache.uima.jcas.JCas;
import org.apache.uima.jcas.tcas.Annotation;
import org.apache.uima.resource.ResourceInitializationException;
import org.apache.uima.resource.ResourceProcessException;

import cmu.edu.types.GeneMentionTag;

/**
 * A simple CAS consumer that writes the CAS to XMI format.
 * <p>
 * This CAS Consumer takes one parameter:
 * <ul>
 * <li><code>OutputDirectory</code> - path to directory into which output files will be written</li>
 * </ul>
 */
public class GeneCasConsumer extends CasConsumer_ImplBase {
  /**
   * Name of configuration parameter that must be set to the path of a directory into which the
   * output files will be written.
   */
  public static final String PARAM_OUTPUTDIR = "OutputFile";

  private File mOutputFile;

  private int mDocNum;

  public void initialize() throws ResourceInitializationException {
    mDocNum = 0;
    mOutputFile = new File((String) getConfigParameterValue(PARAM_OUTPUTDIR));
  }

  /**
   * Processes the CAS which was populated by the TextAnalysisEngines. <br>
   * In this case, the CAS is converted to XMI and written into the output file .
   * 
   * @param aCAS
   *          a CAS which has been populated by the TAEs
   * 
   * @throws ResourceProcessException
   *           if there is an error in processing the Resource
   * 
   * @see org.apache.uima.collection.base_cpm.CasObjectProcessor#processCas(org.apache.uima.cas.CAS)
   */
  public void processCas(CAS aCAS) throws ResourceProcessException {
    JCas jcas;
    try {
      jcas = aCAS.getJCas();
    } catch (CASException e) {
      throw new ResourceProcessException(e);
    }
    PrintWriter writer = null;
    try {
      writer = new PrintWriter(mOutputFile, "UTF-8");
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (UnsupportedEncodingException e) {
      e.printStackTrace();
    }
    
    FSIterator<Annotation> it = jcas.getAnnotationIndex(GeneMentionTag.type).iterator();
    
    while (it.hasNext()) {
      GeneMentionTag sentence = (GeneMentionTag) it.next();
      writer.println(sentence.getLineID()+"|"+sentence.getTagBegin()+" "+sentence.getTagEnd()+"|"+sentence.getGeneTag());
    }
    writer.close();
  }

}
