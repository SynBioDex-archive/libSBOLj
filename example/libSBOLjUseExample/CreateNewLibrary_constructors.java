/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package libSBOLjUseExample;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.biojava.bio.BioException;
import org.sbolstandard.libSBOLj.DnaComponent;
import org.sbolstandard.libSBOLj.Library;
import org.sbolstandard.libSBOLj.SbolService;
import org.sbolstandard.libSBOLj.SequenceAnnotation;
import org.sbolstandard.libSBOLj.SequenceFeature;

/**
 * See Tutorial Example C. Create a New SBOL Library of DnaCompenents using SBOLservices (preferred method)
 * @author mgaldzic
 * @since 0.3
 */
public class CreateNewLibrary_constructors {

    public static void main(String[] args) {
        try {
            Library aLib = createLib();
        } catch (BioException ex) {
            Logger.getLogger(ReadRDFdata.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static Library createLib() throws BioException {

        SbolService s = new SbolService();
        Library aLib = s.createLibrary(
                "BioFabLib_1", //displayID
                "BIOAFAB Pilot Project", //name
                "Pilot Project Designs" + //description
                " see http://biofab.org/data");
        DnaComponent aDC = s.createDnaComponent(
                "BBa_R0040", //displayId
                "pTet", //name
                "TetR repressible promoter", //description
                false, //circular
                "promoter", //type
                s.createDnaSequence( //DNA sequence
                "tccctatcagtgatagagattgacatccctatcagtgatagagatactgagcac"));
        SequenceAnnotation aSA = s.createSequenceAnnotationForDnaComponent(
                127, //start
                181, //stop
                "+", //strand orientation
                aDC //DnaComponent
                );
        SequenceFeature aSF = s.createSequenceFeature(
                "BBa_R0062", //displayID
                "pLux", //name
                "Activated by LuxR in concert with HSL", //description
                "promoter" //type
                );
        SequenceAnnotation aSA_SF = s.addSequenceFeatureToSequenceAnnotation(aSF, aSA);
        aLib = s.addDnaComponentToLibrary(aDC, aLib);

        return aLib;
    }
}
