/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package libSBOLjUseExample;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.biojava.bio.BioException;
import org.biojavax.bio.seq.RichSequenceIterator;
import org.sbolstandard.libSBOLj.Library;
import org.sbolstandard.libSBOLj.SBOLutil;

/**
 * See Tutorial Example A. Write SBOL RDF or Json data from a GenBank File
 * @author mgaldzic
 * @since 0.3
 */
public class ReadGenBankFile {

    public static void main(String[] args){
        try {
            read();
        } catch (BioException ex) {
            Logger.getLogger(ReadGenBankFile.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
public static String read() throws BioException {
        RichSequenceIterator aRSiter = SBOLutil.fromGenBankFile("config\\test_files\\BFa_8.15.gb");
        Library aBioFABlib = SBOLutil.fromRichSequenceIter(aRSiter);
        String jsonString = SBOLutil.toJson(aBioFABlib);
        String rdfString = SBOLutil.toRDF(aBioFABlib);

        Logger.getLogger("Json").log(Level.INFO, jsonString);
        Logger.getLogger("RDF").log(Level.INFO, rdfString);
        return rdfString;
    }
}
