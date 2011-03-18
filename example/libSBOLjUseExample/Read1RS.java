/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package libSBOLjUseExample;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.biojava.bio.BioException;
import org.biojavax.bio.seq.RichSequence;
import org.biojavax.bio.seq.RichSequenceIterator;
import org.sbolstandard.libSBOLj.DnaComponent;
import org.sbolstandard.libSBOLj.Library;
import org.sbolstandard.libSBOLj.SBOLservice;
import org.sbolstandard.libSBOLj.SBOLutil;

/**
 * See Tutorial Example B. Read SBOL RDF data into a Library object
 * @author mgaldzic
 * @since 0.31
 */
public class Read1RS {

    public static void main(String[] args) {
        try {
            RichSequenceIterator aRSiter = SBOLutil.fromGenBankFile("test\\test_files\\BFa_8.15.gb");
            while (aRSiter.hasNext()) {
                RichSequence rs = aRSiter.nextRichSequence();
                read(rs);
            }
        } catch (BioException ex) {
            Logger.getLogger(Read1RS.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void read(RichSequence rs) throws BioException {

        SBOLservice s = new SBOLservice();
        Library library = s.createLibrary("BioFabLib_1", "BIOAFAB Pilot Project",
                "Pilot Project Designs, see http://biofab.org/data");


        DnaComponent dnaComponent = SBOLutil.readRichSequence(rs);
        library = s.addDnaComponentToLibrary(dnaComponent, library);
        String jsonString = SBOLutil.toJson(library);
        String rdfString = SBOLutil.toRDF(library);

        Logger.getLogger("Json").log(Level.INFO, jsonString);
        Logger.getLogger("RDF").log(Level.INFO, rdfString);




        /*
        String rdfString = ReadGenBankFile.read();
        SBOLservice aS = SBOLutil.fromRDF(rdfString);
        
        Library aLib = aS.getLibrary("BioFabLib_1");

        Logger.getLogger("DnaComponent Name").log(Level.INFO, aLib.getComponents().iterator().next().getName());

        return aLib;
         *
         */
    }
}
