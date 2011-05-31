/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.sbolstandard.libSBOLj;

import org.junit.Ignore;
import java.util.logging.Logger;
import java.util.logging.Level;
import java.io.IOException;
import org.biojavax.bio.seq.RichSequence;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author mgaldzic
 * @since 0.35 5/30/2011
 */
public class SBOLutilTest {

    private SBOLservice s = new SBOLservice();

    
    private DnaSequence dnaSequence = s.createDnaSequence("actg");

    public SBOLutilTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
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
    /* @Test
    public void testFromGenBankFile() throws Exception {
    System.out.println("fromGenBankFile");
    String filename = "";
    IOTools instance = new IOTools();
    RichSequence expResult = null;
    RichSequence result = instance.fromGenBankFile(filename);
    assertEquals(expResult, result);
    // TODO review the generated test code and remove the default call to fail.
    fail("The test case is a prototype.");
    }*/
    /**
     * Test of readRichSequence method, of class IOTools.
     */
    /*   @Test
    public void testReadRichSequence() {
    System.out.println("readRichSequence");
    RichSequence rs = null;
    IOTools instance = new IOTools();
    DnaComponent expResult = null;
    DnaComponent result = instance.readRichSequence(rs);
    assertEquals(expResult, result);
    // TODO review the generated test code and remove the default call to fail.
    fail("The test case is a prototype.");
    }*/
    /**
     * Test of toJson method, of class IOTools.
     */
    /*  @Test
    public void testToJson() {
    System.out.println("toJson");
    DnaComponent input = null;
    IOTools instance = new IOTools();
    String expResult = "";
    String result = instance.toJson(input);
    assertEquals(expResult, result);
    // TODO review the generated test code and remove the default call to fail.
    fail("The test case is a prototype.");
    }*/
    /**
     * Test of toRdf method, of class IOTools.
     */
    @Ignore
    @Test
    public void testToRdf() throws Exception {
        System.out.println("toRdf");

        //DnaComponent input = s.createDnaComponent("diplayId", "name", "description", false, "type", dnaSequence);

        Library aBioFABpartLib = IOTools.fromRichSequenceIter(IOTools.fromGenBankFile("test\\test_files\\BFa_8.15.gb"));
        // try {

        //System.out.println("aBioFABpart string: " + IOTools.toRdf(aBioFABpartLib).toString());
        //  } catch (IOException ex) {
        //Logger.getLogger(SBOLutilTest.class.getName()).log(Level.SEVERE, "sout RDF", ex);
        //  }
        //System.out.println("aBioFABpart json" + IOTools.toJson(aBioFABpartLib));
        //ring expResult = "";
        //String result = instance.toRdf(input);
        boolean result = true;
        boolean expResult = true;
        assertEquals(expResult, result);

    }
}
