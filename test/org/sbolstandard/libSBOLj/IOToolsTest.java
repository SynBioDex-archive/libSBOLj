/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.sbolstandard.libSBOLj;

import org.junit.Ignore;
import org.biojavax.bio.seq.RichSequence;
import org.biojavax.bio.seq.RichSequenceIterator;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author mgaldzic
 */
public class IOToolsTest {

    public IOToolsTest() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of fromGenBankFile method, of class IOTools.
     */
    @Test
    public void testFromGenBankFile() throws Exception {
        System.out.println("fromGenBankFile");
        String filename = "test\\test_files\\testFromGenBankFile.gb";
        RichSequenceIterator expResult = null;
        RichSequenceIterator aRSiter = IOTools.fromGenBankFile(filename);
        Library result = IOTools.fromRichSequenceIter(aRSiter);
        System.out.println("ttl: "+IOTools.toRdfTurtle(result));
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
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
    public void testToRdfXml() {
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
    public void testToRdfTurtle() {
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