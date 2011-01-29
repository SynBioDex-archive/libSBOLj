/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package libsboljexample;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.biojava.bio.BioException;
import org.sbolstandard.libSBOLj.SBOLutil;
import org.sbolstandard.libSBOLj.Library;

/**
 *
 * @author mgaldzic
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws BioException {
       System.out.println("createDnaComponent");
        SBOLutil s = new SBOLutil();
        Library aBioFABlib = s.fromRichSequenceIter(s.fromGenBankFile("test\\test_files\\BFa_8.15.gb"));
        try {
           
                System.out.println("aBioFABpart string: " + s.toRDF(aBioFABpart).toString());
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, "sout RDF", ex);
        }
        System.out.println("aBioFABpart json"+s.toJson(aBioFABpart));
        //DnaComponent result = s.createDnaComponent(displayId, name, description, isCircular, type);
    }

}
