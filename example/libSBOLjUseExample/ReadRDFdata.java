/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package libSBOLjUseExample;

import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.biojava.bio.BioException;
import org.sbolstandard.libSBOLj.Library;
import org.sbolstandard.libSBOLj.SbolService;
import org.sbolstandard.libSBOLj.IOTools;


/**
 * See Tutorial Example B. Read SBOL RDF data into a Library object
 * @author mgaldzic
 * @since 0.3
 */
public class ReadRDFdata {
    public static void main(String[] args) throws FileNotFoundException {
        try {
            //readGenBankRoundTrip();
            readRdfString();
            //readRdfFile("test\\test_files\\test_file.rdf");
            readRdfFile("test\\test_files\\testFile1.rdf");
        } catch (BioException ex) {
            Logger.getLogger(ReadRDFdata.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static Library readRdfString() throws BioException{
        Library aLib = new Library();
        String newRdfString = IOTools.toRdfXml(CreateNewLibrary_constructors.createSfLib());
        FileUtil.writeFile("test\\test_files\\test_file.rdf", newRdfString);
        SbolService aS = IOTools.fromRdfXml(newRdfString);

        aLib =aS.getLibrary();

        Logger.getLogger("DnaComponent Name pre").log(Level.INFO, aLib.getFeatures().iterator().next().getName());
        Logger.getLogger("Library Name pre").log(Level.INFO, aLib.getName());
        
        return aLib;
    }
    public static Library readRdfFile(String path)throws BioException, FileNotFoundException{
        Library aLib = new Library();
        String aRdfFileString = FileUtil.readFile(path);
        //System.out.println("file: "+ aRdfFileString);
        SbolService aS = IOTools.fromRdfXml(aRdfFileString);

        aLib = aS.getLibrary();
        
        //Logger.getLogger("DnaComponent Name").log(Level.INFO, aLib.getComponents().iterator().next().getName());
        Logger.getLogger("s:").log(Level.INFO, IOTools.toRdfXml(aLib));
        Logger.getLogger("Library Name").log(Level.INFO, aLib.getName());
        Logger.getLogger("SequenceFeature Name").log(Level.INFO, aLib.getFeatures().iterator().next().getName());
      return aLib;
    }

    public static Library readGenBankRoundTrip()throws BioException{
        String rdfString = ReadGenBankFile.read();
        SbolService aS = IOTools.fromRdfXml(rdfString);
        
        Library aLib = aS.getLibrary();

        Logger.getLogger("DnaComponent Name").log(Level.INFO, aLib.getComponents().iterator().next().getName());
        return aLib;
    }

}
