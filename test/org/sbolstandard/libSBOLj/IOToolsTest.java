/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.sbolstandard.libSBOLj;

import java.io.IOException;
import java.net.URI;
import org.junit.Ignore;
import org.biojavax.bio.seq.RichSequence;
import org.biojavax.bio.seq.RichSequenceIterator;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.openrdf.rio.RDFParseException;

/**
 *
 * @author mgaldzic
 */
public class IOToolsTest {

    private SbolService s = new SbolService();
    public IOToolsTest() {
    }

    @Before
    public void setUp() {
        Library aLib = new Library();
        aLib.setDisplayId("id");
        aLib.setName("name");
        aLib.setDescription("desc");

        DnaSequence aDS = new DnaSequence();
        aDS.setDnaSequence("actg");

        DnaComponent aDC = new DnaComponent();
        aDC.setDisplayId("id");
        aDC.setName("name");
        aDC.setDescription("desc");
        aDC.setCircular(false);
        aDC.setDnaSequence(aDS);

        SequenceAnnotation aSA = new SequenceAnnotation();
        aSA.setStart(1);
        aSA.setStop(2);
        aSA.setStrand("+");
        aSA.generateId(aDC);

        SequenceFeature aSF = new SequenceFeature();
        aSF.setDisplayId("id");
        aSF.setName("name");
        aSF.setDescription("desc");
        aSF.addType(URI.create("http://purl.org/obo/owl/SO#" + "so_id"));

        
        //Make a Library w a DnaComponent a SequenceAnnotation and a SequenceFeature
        s.addDnaComponentToLibrary(aDC, aLib);
        //Annotated component
        s.addSequenceAnnotationToDnaComponent(aSA, aDC);  //empty promise
        s.addSequenceFeatureToSequenceAnnotation(aSF, aSA);
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of fromGenBankFile method, of class IOTools.
     */
    @Ignore
    @Test
    public void testFromGenBankFile() throws Exception {
        System.out.println("fromGenBankFile");
        String filename = "test\\test_files\\testFromGenBankFile.gb";

        Library expResult = s.getLibrary();

        RichSequenceIterator aRSiter = IOTools.fromGenBankFile(filename);
        Library result = IOTools.fromRichSequenceIter(aRSiter);
        System.out.println("ttl: " + IOTools.toRdfTurtle(result));
        assertEquals(expResult, result);
    }

    /**
     * Test of fromRichSequenceIter method, of class IOTools.
     */
    @Ignore
    @Test
    public void testFromRichSequenceIter() throws Exception {
        System.out.println("fromRichSequenceIter");
        RichSequenceIterator rsi = null;
        Library expResult = null;
        Library result = IOTools.fromRichSequenceIter(rsi);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of readRichSequence method, of class IOTools.
     */
    @Ignore
    @Test
    public void testReadRichSequence() {
        System.out.println("readRichSequence");
        RichSequence rs = null;
        DnaComponent expResult = null;
        DnaComponent result = IOTools.readRichSequence(rs);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toJson method, of class IOTools.
     */
    @Ignore
    @Test
    public void testToJson() {
        System.out.println("toJson");
        Library input = null;
        String expResult = "";
        String result = IOTools.toJson(input);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toRdfXml method, of class IOTools.
     */
    @Ignore
    @Test
    public void testToRdfXml() throws RDFParseException, IOException {
        System.out.println("toRdfXml");
        Library input = null;
        String expResult = "";
        String result = IOTools.toRdfXml(input);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toRdfTurtle method, of class IOTools.
     */
    @Ignore
    @Test
    public void testToRdfTurtle() throws IOException, RDFParseException {
        System.out.println("toRdfTurtle");
        Library input = null;
        String expResult = "";
        String result = IOTools.toRdfTurtle(input);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of fromRdfXml method, of class IOTools.
     */
    @Ignore
    @Test
    public void testFromRdfXml() {
        System.out.println("fromRdfXml");
        String rdfString = "";
        SbolService expResult = null;
        SbolService result = IOTools.fromRdfXml(rdfString);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of readFile method, of class IOTools.
     */
    @Ignore
    @Test
    public void testReadFile() throws Exception {
        System.out.println("readFile");
        String infilename = "";
        String expResult = "";
        String result = IOTools.readFile(infilename);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of writeFile method, of class IOTools.
     */
    @Ignore
    @Test
    public void testWriteFile() {
        System.out.println("writeFile");
        String outfilename = "";
        String content = "";
        IOTools.writeFile(outfilename, content);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of touchfile method, of class IOTools.
     */
    @Ignore
    @Test
    public void testTouchfile() {
        System.out.println("touchfile");
        String filename = "";
        IOTools.touchfile(filename);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
