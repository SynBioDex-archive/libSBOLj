/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package libSBOLjUseExample;

import java.net.URI;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.biojava.bio.BioException;
import org.sbolstandard.libSBOLj.DnaComponent;
import org.sbolstandard.libSBOLj.Library;
import org.sbolstandard.libSBOLj.SBOLservice;
import org.sbolstandard.libSBOLj.SequenceAnnotation;
import org.sbolstandard.libSBOLj.SequenceFeature;

/**
 * See Tutorial Example D. Create a New SBOL Library of DnaCompenents making individual objects (more control)
 * @author mgaldzic
 * @since 0.3
 */
public class CreateNewLibrary_indi_objects {

    public static void main(String[] args) {
        try {
            Library aLib = createLib();
        } catch (BioException ex) {
            Logger.getLogger(ReadRDFdata.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static Library createLib() throws BioException {

        SBOLservice s = new SBOLservice();

        Library aLib = new Library();
        aLib.setDisplayId("BioFabLib_1");
        aLib.setName("BIOFAB Pilot Project");
        aLib.setDescription("Pilot Project Designs see http://biofab.org/data");
        s.insertLibrary(aLib);

        DnaComponent aDC = new DnaComponent();
        aDC.setDisplayId("BBa_R0040");
        aDC.setName("pTet");
        aDC.setDescription("TetR repressible promoter");
        aDC.setCircular(false);
        aDC.addType(URI.create("http://purl.org/obo/owl/SO#" + "promoter"));
        aDC.setDnaSequence(s.createDnaSequence(
                "tccctatcagtgatagagattgacatccctatcagtgatagagatactgagcac"));
        s.insertDnaComponent(aDC);

        SequenceAnnotation aSA = new SequenceAnnotation();
        aSA.setStart(127);
        aSA.setStop(181);
        aSA.setStrand("+");
        aSA.setId(aDC);
        s.insertSequenceAnnotation(aSA);

        SequenceFeature aSF = new SequenceFeature();
        aSF.setDisplayId("BBa_R0062");
        aSF.setName("pLux");
        aSF.setDescription("Activated by LuxR in concert with HSL");
        aSF.addType(URI.create("http://purl.org/obo/owl/SO#" + "promoter"));
        s.insertSequenceFeature(aSF);

        SequenceAnnotation anot_feat = s.addSequenceFeatureToSequenceAnnotation(aSF, aSA);

        DnaComponent dc_anot_feat = s.addSequenceAnnotationToDnaComponent(anot_feat,aDC);

        aLib = s.addDnaComponentToLibrary(dc_anot_feat, aLib);

        return aLib;
    }
}
