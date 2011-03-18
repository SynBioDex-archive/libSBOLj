/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package libSBOLjUseExample;

import java.util.Collection;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.biojava.bio.BioException;
import org.sbolstandard.libSBOLj.DnaComponent;
import org.sbolstandard.libSBOLj.DnaSequence;
import org.sbolstandard.libSBOLj.Library;
import org.sbolstandard.libSBOLj.SbolService;
import org.sbolstandard.libSBOLj.SequenceAnnotation;
import org.sbolstandard.libSBOLj.SequenceFeature;

/**
 * See Tutorial Example E. Access members of Library
 * @author mgaldzic
 * @since 0.3
 */
public class AccessLibrary {

    public static void main(String[] args) {
        try {
            Library aLib = CreateNewLibrary_indi_objects.createLib();
            accessLib(aLib);
        } catch (BioException ex) {
            Logger.getLogger(ReadRDFdata.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void accessLib(Library inputLib) throws BioException {

        SbolService s = new SbolService();
        s.insertLibrary(inputLib);

        //Get Library
        Library theLib = s.getLibrary("BioFabLib_1");

        //Print Library object fields
        System.out.println("-----------------------");
        System.out.println("Library");
        System.out.println("-----------------------");
        System.out.println("DisplayId: " + theLib.getDisplayId());
        System.out.println("Name: " + theLib.getName());
        System.out.println("Description: " + theLib.getDescription());
        
        //Get DnaComponents
        Collection c = theLib.getComponents();
        for (Iterator<DnaComponent> i = theLib.getComponents().iterator(); i.hasNext();) {
            DnaComponent oneDC = i.next();
            //Print DnaComponent Fields
            System.out.println("-----------------------");
            System.out.println("DnaComponent(s)");
            System.out.println("-----------------------");
            System.out.println("DisplayId: " + oneDC.getDisplayId());
            System.out.println("Name: " + oneDC.getName());
            System.out.println("Description: " + oneDC.getDescription());

            //Get DnaSequence
            DnaSequence itsSeq = oneDC.getDnaSequence();

            //Print DnaSequence

            System.out.println("DnaSequence: " + itsSeq.getDnaSequence());
            
            //Get SequenceAnnotations
            System.out.println("-----------------------");
            System.out.println("Annotation(s)");
            System.out.println("-----------------------");
            for (Iterator<SequenceAnnotation> ai = oneDC.getAnnotations().iterator(); ai.hasNext();) {
                SequenceAnnotation oneSA = ai.next();

                //Get SequenceFeatures
                for (Iterator<SequenceFeature> fi = oneSA.getFeatures().iterator(); fi.hasNext();) {
                    SequenceFeature oneSF = fi.next();
                    
                    //Print SequenceAnnotatations and Features
                    System.out.println("Feature Name: "+oneSF.getName() +    //name
                                       "\nPosition: ("+ oneSA.getStart()+    //Start position
                                       ","+oneSA.getStop()+                  //Stop position
                                       ") Strand:["+oneSA.getStrand()+"]\n"+ //Strand
                                       "Feature Description: "+
                                       oneSF.getDescription());              //Description
                   System.out.println("-----------------------");

                } // end SequenceFeatures
            } //end SequenceAnnotations
        }// end DnaComponents

    }
}
