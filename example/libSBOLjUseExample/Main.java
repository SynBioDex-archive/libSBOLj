/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package libSBOLjUseExample;

import org.biojava.bio.BioException;
import org.biojavax.bio.seq.RichSequenceIterator;
import org.sbolstandard.libSBOLj.SBOLutil;
import org.sbolstandard.libSBOLj.Library;

/**
 * Main serves as a simple example of use.
 *
 * It is a convenient place for a simple example, when developing something new.
 * TODO: make a completely separate examples of use code base.
 *
 * @author mgaldzic
 * @version 0.1, 02/10/2011
 */
public class Main {

    /**
     * Run this to see what SBOL does now.
     * @param args the command line arguments
     */
    public static void main(String[] args) throws BioException {
        System.out.println("createLibrary");
        SBOLutil s = new SBOLutil();

        RichSequenceIterator aRsIter = s.fromGenBankFile("test\\test_files\\BFa_8.15.gb");
        Library aBioFABlib = s.fromRichSequenceIter(aRsIter);

        System.out.println("aBioFABlib json: \n" + s.toJson(aBioFABlib));
        System.out.println("aBioFABlib RDF: \n"+ s.toRDF(aBioFABlib));
        
    }
}
