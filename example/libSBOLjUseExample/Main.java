/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package libSBOLjUseExample;

import org.biojava.bio.BioException;
import org.biojavax.bio.seq.RichSequenceIterator;
import org.sbolstandard.libSBOLj.SBOLutil;
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
        System.out.println("create BIOFAB Library");
        

        RichSequenceIterator aRsIter = SBOLutil.fromGenBankFile("test\\test_files\\BFa_8.15.gb");
        Library aBioFABlib = SBOLutil.fromRichSequenceIter(aRsIter);

        System.out.println("aBioFABlib json: \n" + SBOLutil.toJson(aBioFABlib));
        System.out.println("aBioFABlib RDF: \n"+ SBOLutil.toRDF(aBioFABlib));
        String rdfString = SBOLutil.toRDF(aBioFABlib);

        SBOLservice aS = SBOLutil.fromRDF(rdfString);
        Library lib = aS.getLibrary("BioFabLib_1");
        System.out.println("lib Contains: "+lib.getComponents().iterator().next().getName());
    }
}
