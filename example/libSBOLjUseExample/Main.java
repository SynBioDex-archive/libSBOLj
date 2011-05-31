/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package libSBOLjUseExample;

import org.biojava.bio.BioException;
import org.biojavax.bio.seq.RichSequenceIterator;
import org.sbolstandard.libSBOLj.IOTools;
import org.sbolstandard.libSBOLj.Library;
import org.sbolstandard.libSBOLj.SBOLservice;

/**
 * Main serves as a simple example of use.
 *
 * It is a convenient place for a simple example, when developing something new.
 * @todo make a completely separate examples of use code base.
 *
 * @author mgaldzic
 * @since 0.2, 03/02/2011
 */
public class Main {

    /**
     * Run this to see what SBOL does now.
     * @param args the command line arguments
     */
    public static void main(String[] args) throws BioException {
  /*    The following should be moved to test and example:

        System.out.println("create BIOFAB Library");
        

        RichSequenceIterator aRsIter = IOTools.fromGenBankFile("config\\test_files\\BFa_8.15.gb");
        Library aBioFABlib = IOTools.fromRichSequenceIter(aRsIter);

        System.out.println("aBioFABlib json: \n" + IOTools.toJson(aBioFABlib));
        System.out.println("aBioFABlib RDF: \n"+ IOTools.toRDF(aBioFABlib));
        String rdfString = IOTools.toRDF(aBioFABlib);

        SBOLservice aS = IOTools.fromRDF(rdfString);
        Library lib = aS.getLibrary();
        System.out.println("lib Contains: "+lib.getComponents().iterator().next().getName());
   *
   */
    }
}
