/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.sbolstandard.libSBOLj;

import java.net.URI;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author mgaldzic
 */
public class SequenceFeatureTest {

    private DnaSequence testDnaSeq = new DnaSequence();
    private SequenceFeature testSF = new SequenceFeature();

    public SequenceFeatureTest() {
    }

    @Before
    public void setUp() {
        testDnaSeq.setDnaSequence("actg");
        testSF.setDnaSequence(testDnaSeq);
        testSF.setDisplayId("SeqFeat_DisplayID");
        testSF.setName("SeqFeat name");
        testSF.setDescription("SeqFeat description");
        testSF.setType(URI.create("http://sbols.org/sbol.owl#promoter"));
    }

    @After
    public void tearDown() {
    }
   
    /**
     * Test of getDescription method, of class SequenceFeature.
     */
    @Test
    public void testGetDescription() {
        System.out.println("getDescription");
        SequenceFeature instance = testSF;
        String result = instance.getDescription();

        String expResult = "SeqFeat description";
        assertEquals(expResult, result);
    }

    /**
     * Test of getDisplayId method, of class SequenceFeature.
     */
    @Test
    public void testGetDisplayId() {
        System.out.println("getDisplayId");
        SequenceFeature instance = testSF;
        String result = instance.getDisplayId();

        String expResult = "SeqFeat_DisplayID";
        assertEquals(expResult, result);
    }

    /**
     * Test of getDnaSequence method, of class SequenceFeature.
     */
    @Test
    public void testGetDnaSequence() {
        System.out.println("getDnaSequence");
        SequenceFeature instance = testSF;
        DnaSequence result = instance.getDnaSequence();

        DnaSequence expResult = testDnaSeq;
        assertEquals(expResult, result);
    }

    /**
     * Test of getName method, of class SequenceFeature.
     */
    @Test
    public void testGetName() {
        System.out.println("getName");
        SequenceFeature instance = new SequenceFeature();
        instance = testSF;
        String result = instance.getName();

        String expResult = "SeqFeat name";
        assertEquals(expResult, result);
    }
   
    /**
     * Test of getType method, of class SequenceFeature.
     */
    @Test
    public void testGetType() {
        System.out.println("getType");
        SequenceFeature instance = new SequenceFeature();
        instance = testSF;
        URI result = instance.getType();

        URI expResult =  URI.create("http://sbols.org/sbol.owl#promoter");
        assertEquals(expResult, result);
    }
}
