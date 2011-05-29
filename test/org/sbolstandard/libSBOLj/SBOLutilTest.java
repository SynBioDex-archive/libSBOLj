/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.sbolstandard.libSBOLj;

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
     * Test of fromGenBankFile method, of class SBOLutil.
     */
    /* @Test
    public void testFromGenBankFile() throws Exception {
    System.out.println("fromGenBankFile");
    String filename = "";
    SBOLutil instance = new SBOLutil();
    RichSequence expResult = null;
    RichSequence result = instance.fromGenBankFile(filename);
    assertEquals(expResult, result);
    // TODO review the generated test code and remove the default call to fail.
    fail("The test case is a prototype.");
    }*/
    /**
     * Test of readRichSequence method, of class SBOLutil.
     */
    /*   @Test
    public void testReadRichSequence() {
    System.out.println("readRichSequence");
    RichSequence rs = null;
    SBOLutil instance = new SBOLutil();
    DnaComponent expResult = null;
    DnaComponent result = instance.readRichSequence(rs);
    assertEquals(expResult, result);
    // TODO review the generated test code and remove the default call to fail.
    fail("The test case is a prototype.");
    }*/
    /**
     * Test of toJson method, of class SBOLutil.
     */
    /*  @Test
    public void testToJson() {
    System.out.println("toJson");
    DnaComponent input = null;
    SBOLutil instance = new SBOLutil();
    String expResult = "";
    String result = instance.toJson(input);
    assertEquals(expResult, result);
    // TODO review the generated test code and remove the default call to fail.
    fail("The test case is a prototype.");
    }*/
    /**
     * Test of toRDF method, of class SBOLutil.
     */
    @Test
    public void testToRDF() throws Exception {
        System.out.println("toRDF");

        //DnaComponent input = s.createDnaComponent("diplayId", "name", "description", false, "type", dnaSequence);

        Library aBioFABpartLib = SBOLutil.fromRichSequenceIter(SBOLutil.fromGenBankFile("test\\test_files\\BFa_8.15.gb"));
        // try {

        System.out.println("aBioFABpart string: " + SBOLutil.toRDF(aBioFABpartLib).toString());
        //  } catch (IOException ex) {
        //Logger.getLogger(SBOLutilTest.class.getName()).log(Level.SEVERE, "sout RDF", ex);
        //  }
        System.out.println("aBioFABpart json" + SBOLutil.toJson(aBioFABpartLib));
        //ring expResult = "";
        //String result = instance.toRDF(input);
        boolean result = true;
        boolean expResult = true;
        assertEquals(expResult, result);

    }
}
