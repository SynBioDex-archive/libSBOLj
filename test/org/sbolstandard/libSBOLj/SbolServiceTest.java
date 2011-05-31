/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.sbolstandard.libSBOLj;


import org.junit.Ignore;
import java.net.URI;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author mgaldzic
 * @since 0.35 5/30/2011
 */
public class SbolServiceTest {

    public SbolServiceTest() {
    }
    private Library aLib = new Library();
    //private Library aLib_DC_seq_SA_SF_seq = new Library(); //fully connected
    private DnaSequence aDS = new DnaSequence(); //just dna
    private SequenceFeature aSF = new SequenceFeature(); //just feature
    private DnaComponent aDC = new DnaComponent(); //just component
    private SequenceAnnotation aSA = new SequenceAnnotation(); //just annotation

    @Before
    public void setUp() {
        aLib.setDisplayId("id");
        aLib.setName("name");
        aLib.setDescription("desc");

        aDS.setDnaSequence("actg");

        aDC.setDisplayId("id");
        aDC.setName("name");
        aDC.setDescription("desc");
        aDC.setCircular(false);
        aDC.setDnaSequence(aDS);

        aSA.setStart(1);
        aSA.setStop(2);
        aSA.setStrand("+");
        aSA.generateId(aDC);

        aSF.setDisplayId("id");
        aSF.setName("name");
        aSF.setDescription("desc");
        aSF.addType(URI.create("http://purl.org/obo/owl/SO#" + "so_id"));





        
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
        SbolService instance = new SbolService();

        DnaSequence expResult = aDS;
        //DnaSequence expResult = new DnaSequence();
        //expResult.setDnaSequence("actg");

        //test
        DnaSequence result = instance.createDnaSequence(dnaSequence);
        assertEquals(expResult, result);
    }

    /**
     * Test of createSequenceFeature method, of class SbolService.
     */
    @Test
    public void testCreateSequenceFeature() {
        System.out.println("createSequenceFeature");
        String displayId = "id";
        String name = "name";
        String description = "desc";
        String type = "so_id";
        SbolService instance = new SbolService();

        SequenceFeature expResult = aSF;

        //test
        SequenceFeature result = instance.createSequenceFeature(displayId, name, description, type);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of createSequenceAnnotationForDnaComponent method, of class SbolService.
     */
    @Test
    public void testCreateSequenceAnnotationForDnaComponent() {
        System.out.println("createSequenceAnnotationForDnaComponent");
        Integer start = 1;
        Integer stop = 2;
        String strand = "+";
        SequenceFeature feature = aSF;
        DnaComponent component = aDC;
        DnaSequence sequence = aDS;
        component.setDnaSequence(sequence);
        SbolService instance = new SbolService();

        //SequenceAnnotation w SequenceFeature connected
        SequenceAnnotation aSA_SF = new SequenceAnnotation(); //full annotation
        aSA_SF = aSA;
        aSA_SF.addFeature(aSF);
        SequenceAnnotation expResult = aSA_SF;

        //test
        SequenceAnnotation result = instance.createSequenceAnnotationForDnaComponent(
                start, stop, strand, feature, component);
        assertEquals(expResult, result);
    }

    /**
     * Test of addSequenceFeatureToSequenceAnnotation method, of class SbolService.
     */
    @Test
    public void testAddSequenceFeatureToSequenceAnnotation() {
        System.out.println("addSequenceFeatureToSequenceAnnotation");
        SequenceFeature feature = aSF;
        SequenceAnnotation annotation = aSA;
        SbolService instance = new SbolService();

        
        
        SequenceAnnotation aSA_SF = new SequenceAnnotation(); //full annotation
        aSA_SF = aSA;
        aSA_SF.addFeature(aSF);
        SequenceAnnotation expResult = aSA_SF;

        //test
        SequenceAnnotation result = instance.addSequenceFeatureToSequenceAnnotation(feature, annotation);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of createDnaComponent method, of class SbolService.
     */
    @Test
    public void testCreateDnaComponent() {
        System.out.println("createDnaComponent");
        String displayId = "id";
        String name = "name";
        String description = "desc";
        Boolean isCircular = false;
        String type = "so_id";
        DnaSequence dnaSequence = aDS;
        SbolService instance = new SbolService();

        DnaComponent expResult = aDC;

        //test
        DnaComponent result = instance.createDnaComponent(displayId, name, description, isCircular, type, dnaSequence);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of createLibrary method, of class SbolService.
     */
    @Test
    public void testCreateLibrary() {
        System.out.println("createLibrary");
        String displayId = "id";
        String name = "name";
        String description = "desc";
        SbolService instance = new SbolService();

        Library expResult = aLib;

        //test
        Library result = instance.createLibrary(displayId, name, description);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of addDnaComponentToLibrary method, of class SbolService.
     */
    @Test
    public void testAddDnaComponentToLibrary() {
        System.out.println("addDnaComponentToLibrary");
        DnaComponent component = aDC;
        Library library = aLib;
        SbolService instance = new SbolService();

        //Library w a DnaComponent - a Virtual Part
        Library aLib_DC = new Library(); //virtual part
        aLib_DC = aLib;
        aLib_DC.addComponent(aDC);
        Library expResult = aLib_DC;

        //test
        Library result = instance.addDnaComponentToLibrary(component, library);
        assertEquals(expResult, result);
    }

    /**
     * Test of addSequenceFeatureToLibrary method, of class SbolService.
     */
    @Test
    public void testAddSequenceFeatureToLibrary() {
        System.out.println("addSequenceFeatureToLibrary");
        SequenceFeature feature = aSF;
        Library library = aLib;
        SbolService instance = new SbolService();

        //Library w a SequenceFeature - False SF Library
        Library aLib_SF = new Library(); //false_SF library
        aLib_SF = aLib;
        aLib_SF.addFeature(aSF);
        Library expResult = aLib_SF;

        //test
        Library result = instance.addSequenceFeatureToLibrary(feature, library);
        assertEquals(expResult, result);
    }

    /**
     * Test of getAllAsRdf method, of class SbolService.
     */
    @Ignore
    @Test
    public void testGetAllAsRDF() {
        System.out.println("getAllAsRDF");
        SbolService instance = new SbolService();
        String expResult = "";
        String result = instance.getAllAsRdf();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getLibrary method, of class SbolService.
     */
    @Test
    public void testGetLibrary() {
        System.out.println("getLibrary");
        String id = "id";
        SbolService instance = new SbolService();
        instance.createLibrary("id", "name", "desc");

        Library expResult = aLib;

        //test
        Library result = instance.getLibrary();
        assertEquals(expResult, result);
    }

    /**
     * Test of addSequenceAnnotationToDnaComponent method, of class SbolService.
     */
    @Test
    public void testAddSequenceAnnotationToDnaComponent() {
        System.out.println("addSequenceAnnotationToDnaComponent");
        SequenceAnnotation annotation = aSA;
        DnaComponent component = aDC;
        SbolService instance = new SbolService();

        //DnaComponent w a SequenceAnnotation connected
        SequenceAnnotation aSA_SF = new SequenceAnnotation(); //full annotation
        aSA_SF = aSA;
        aSA_SF.addFeature(aSF);

        DnaComponent aDC_SA_SF = new DnaComponent(); //Annotated component
        aDC_SA_SF = aDC;
        aDC_SA_SF.addAnnotation(aSA_SF);
        DnaComponent expResult = aDC_SA_SF;
        
        //test
        DnaComponent result = instance.addSequenceAnnotationToDnaComponent(annotation, component);
        assertEquals(expResult, result);
    }

    /**
     * Test of insertLibrary method, of class SbolService.
     */
    @Test
    public void testInsertLibrary() {
        System.out.println("insertLibrary");
        Library lib = aLib;
        SbolService instance = new SbolService();

        Library expResult = aLib;
        
        //test
        instance.insertLibrary(lib);
        Library result = instance.getLibrary();
        assertEquals(expResult, result);
    }

    /**
     * Test of insertDnaComponent method, of class SbolService.
     */
    @Test
    public void testInsertDnaComponent() {
        System.out.println("insertDnaComponent");
        DnaComponent comp = new DnaComponent();
        comp.setDisplayId("id");
        comp.setName("name");
        comp.setDescription("desc");
        comp.setCircular(false);
        comp.setDnaSequence(aDS);
        SbolService instance = new SbolService();

        DnaComponent expResult = aDC;

        //test
        instance.insertDnaComponent(comp);
        aLib = instance.addDnaComponentToLibrary(comp, aLib);
        Library libWresult = instance.getLibrary();
        DnaComponent result = libWresult.getComponents().iterator().next();
        assertEquals(expResult, result);
    }

    /**
     * Test of insertSequenceAnnotation method, of class SbolService.
     */
    @Test
    public void testInsertSequenceAnnotation() {
        System.out.println("insertSequenceAnnotation");
        SequenceAnnotation anotSF = new SequenceAnnotation();
        anotSF.setStart(1);
        anotSF.setStop(2);
        anotSF.setStrand("+");
        anotSF.addFeature(aSF);
        anotSF.generateId(aDC);
        SbolService instance = new SbolService();

        //Library w a DnaComponent - a Virtual Part
        Library aLib_DC = new Library(); //virtual part
        aLib_DC = aLib;
        aLib_DC.addComponent(aDC);
        instance.insertLibrary(aLib_DC);

        SequenceAnnotation expResult =aSA;
        expResult.addFeature(aSF);

        //test
        instance.insertSequenceAnnotation(anotSF);
       
        instance.addSequenceAnnotationToDnaComponent(anotSF, aDC);
        instance.addSequenceFeatureToSequenceAnnotation(aSF, anotSF);
        SequenceAnnotation result = instance.getLibrary().getComponents()
                .iterator().next().getAnnotations().iterator().next();
        assertEquals(expResult, result);
    }

    /**
     * Test of insertSequenceFeature method, of class SbolService.
     */
    @Test
    public void testInsertSequenceFeature() {
        System.out.println("insertSequenceFeature");
        SequenceFeature feat = aSF;
        //Make a Library w a DnaComponent and a SequenceAnnotation
        SbolService instance = new SbolService();
        instance.addDnaComponentToLibrary(aDC, aLib);
        //Annotated component
        instance.addSequenceAnnotationToDnaComponent(aSA, aDC);  //empty promise

        SequenceFeature expResult = aSF;

        //test
        instance.insertSequenceFeature(feat);
        instance.addSequenceFeatureToSequenceAnnotation(feat, aSA);
        SequenceFeature result = instance.getLibrary().getComponents()
                .iterator().next().getAnnotations()
                .iterator().next().getFeatures().iterator().next();
        assertEquals(expResult, result);
    }

}