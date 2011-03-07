/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.sbolstandard.libSBOLj;

import java.net.URI;
import java.util.Collection;
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
public class SbolServiceTest {

    public SbolServiceTest() {
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
     * Test of createDnaSequence method, of class SbolService.
     */
    @Test
    public void testCreateDnaSequence() {
        System.out.println("createDnaSequence");
        String dnaSequence = "actg";
        DnaSequence expResult = new DnaSequence();
        expResult.setDnaSequence(dnaSequence);

        SbolService instance = new SbolService();
        DnaSequence result = instance.createDnaSequence(dnaSequence);
        assertEquals(expResult, result);
    }

    /**
     * Test of createSequenceFeature method, of class SbolService.
     */
    @Test
    public void testCreateSequenceFeature() {
        System.out.println("createSequenceFeature");
        String displayId = "displayID";
        String name = "name";
        String description = "description";
        String type = "type";
        SbolService instance = new SbolService();
        SequenceFeature expResult = new SequenceFeature();
        expResult.setDisplayId(displayId);
        expResult.setName(name);
        expResult.setDescription(description);
        expResult.setType(URI.create("http://sbols.org/sbol.owl#"+type));
        SequenceFeature result = instance.createSequenceFeature(displayId, name, description, type);
        assertEquals(expResult, result);
    }

    /**
     * Test of createSequenceAnnotation method, of class SbolService.
     */
    @Test
    public void testCreateSequenceAnnotation() {
        System.out.println("createSequenceAnnotation");
        Integer start = 1;
        Integer stop = 2;
        String strand = "+";
        SbolService instance = new SbolService();
        SequenceAnnotation expResult = new SequenceAnnotation();
        expResult.setStart(start);
        expResult.setStop(stop);
        expResult.setStrand(strand);
        SequenceAnnotation result = instance.createSequenceAnnotationForDnaComponent(start, stop, strand,);
        assertEquals(expResult, result);
    }

    /**
     * Test of addSequenceFeatureToSequenceAnnotation method, of class SbolService.
     */
    @Test
    public void testAddSequenceFeatureToSequenceAnnotation() throws CloneNotSupportedException {
        System.out.println("addSequenceFeatureToSequenceAnnotation");
        SbolService instance = new SbolService();
        SequenceFeature feature = instance.createSequenceFeature("diplayID", "name", "description", "type");
        SequenceFeature expFeature = instance.createSequenceFeature("diplayID", "name", "description", "type");
        SequenceAnnotation annotation = instance.createSequenceAnnotation(1, 2, "+");
        SequenceAnnotation expAnnotation = instance.createSequenceAnnotation(1, 2, "+");

        SequenceAnnotation expResult = expAnnotation;
        expResult.addFeature(expFeature);
        SequenceAnnotation result = instance.addSequenceFeatureToSequenceAnnotation(feature, annotation);
        assertEquals(expResult, result);
       
    }

    /**
     * Test of createDnaComponent method, of class SbolService.
     */
    @Test
    public void testCreateDnaComponent() {
        System.out.println("createDnaComponent");
        String displayId = "displayID";
        String name = "name";
        String description = "description";
        Boolean isCircular = false;
        String type = "type";
        SbolService instance = new SbolService();
        DnaSequence dnaSequence = instance.createDnaSequence("actg");
        
        DnaComponent expResult = new DnaComponent();
        expResult.setDisplayId(displayId);
        expResult.setName(name);
        expResult.setDescription(description);
        expResult.setCircular(isCircular);
        expResult.setType(URI.create("http://sbols.org/sbol.owl#"+type));
        expResult.setDnaSequence(dnaSequence);

        DnaComponent result = instance.createDnaComponent(displayId, name, description, isCircular, type, dnaSequence);
        assertEquals(expResult, result);
    }

    /**
     * Test of addSequenceAnnotationToDnaComponent method, of class SbolService.
     */
    @Test
    public void testAddSequenceAnnotationToDnaComponent(){
        System.out.println("addSequenceAnnotationToDnaComponent");
        SbolService instance = new SbolService();
        SequenceAnnotation annotation = instance.createSequenceAnnotation(1, 2, "+");
        SequenceAnnotation expAnnotation = instance.createSequenceAnnotation(1, 2, "+");
        DnaSequence dnaSequence = instance.createDnaSequence("actg");
        DnaComponent component = instance.createDnaComponent("diplayId", "name", "description", false, "type", dnaSequence);
        DnaComponent expComponent = instance.createDnaComponent("diplayId", "name", "description", false, "type", dnaSequence);
        
        DnaComponent expResult = expComponent;
        expResult.addAnnotation(expAnnotation);
        DnaComponent result = instance.addSequenceAnnotationToDnaComponent(annotation, component);
        assertEquals(expResult, result);
    }
}