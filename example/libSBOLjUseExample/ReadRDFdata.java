/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package libSBOLjUseExample;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.biojava.bio.BioException;
import org.sbolstandard.libSBOLj.Library;
import org.sbolstandard.libSBOLj.foobar;
import org.sbolstandard.libSBOLj.SBOLutil;

/**
 * See Tutorial Example B. Read SBOL RDF data into a Library object
 * @author mgaldzic
 * @since 0.3
 */
public class ReadRDFdata {
    public static void main(String[] args) {
        try {
            read();
        } catch (BioException ex) {
            Logger.getLogger(ReadRDFdata.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static Library read()throws BioException{
        String rdfString = ReadGenBankFile.read();
        foobar aS = SBOLutil.fromRDF(rdfString);
        
        Library aLib = aS.getLibrary("BioFabLib_1");

        Logger.getLogger("DnaComponent Name").log(Level.INFO, aLib.getComponents().iterator().next().getName());
        return aLib;
    }

}
