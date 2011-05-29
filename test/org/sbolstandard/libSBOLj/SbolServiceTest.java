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
 */
public class SBOLserviceTest {

    public SBOLserviceTest() {
    }
    private Library aLib = new Library();
    private Library aLib_DC_seq_SA_SF_seq = new Library(); //fully connected
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
        aDC.addType(URI.create("http://purl.org/obo/owl/SO#" + "so_id"));
        aDC.setDnaSequence(aDS);

        aSA.setStart(1);
        aSA.setStop(2);
        aSA.setStrand("+");
        aSA.setId(aDC);

        aSF.setDisplayId("id");
        aSF.setName("name");
        aSF.setDescription("desc");
        aSF.addType(URI.create("http://purl.org/obo/owl/SO#" + "so_id"));





        
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of createDnaSequence method, of class SBOLservice.
     */
    @Test
    public void testCreateDnaSequence() {
        System.out.println("createDnaSequence");
        String dnaSequence = "actg";
        SBOLservice instance = new SBOLservice();

        DnaSequence expResult = aDS;
        //DnaSequence expResult = new DnaSequence();
        //expResult.setDnaSequence("actg");

        //test
        DnaSequence result = instance.createDnaSequence(dnaSequence);
        assertEquals(expResult, result);
    }

    /**
     * Test of createSequenceFeature method, of class SBOLservice.
     */
    @Test
    public void testCreateSequenceFeature() {
        System.out.println("createSequenceFeature");
        String displayId = "id";
        String name = "name";
        String description = "desc";
        String type = "so_id";
        SBOLservice instance = new SBOLservice();

        SequenceFeature expResult = aSF;

        //test
        SequenceFeature result = instance.createSequenceFeature(displayId, name, description, type);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of createSequenceAnnotationForDnaComponent method, of class SBOLservice.
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
        SBOLservice instance = new SBOLservice();

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
     * Test of addSequenceFeatureToSequenceAnnotation method, of class SBOLservice.
     */
    @Test
    public void testAddSequenceFeatureToSequenceAnnotation() {
        System.out.println("addSequenceFeatureToSequenceAnnotation");
        SequenceFeature feature = aSF;
        SequenceAnnotation annotation = aSA;
        SBOLservice instance = new SBOLservice();

        
        
        SequenceAnnotation aSA_SF = new SequenceAnnotation(); //full annotation
        aSA_SF = aSA;
        aSA_SF.addFeature(aSF);
        SequenceAnnotation expResult = aSA_SF;

        //test
        SequenceAnnotation result = instance.addSequenceFeatureToSequenceAnnotation(feature, annotation);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of createDnaComponent method, of class SBOLservice.
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
        SBOLservice instance = new SBOLservice();

        DnaComponent expResult = aDC;

        //test
        DnaComponent result = instance.createDnaComponent(displayId, name, description, isCircular, type, dnaSequence);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of createLibrary method, of class SBOLservice.
     */
    @Test
    public void testCreateLibrary() {
        System.out.println("createLibrary");
        String displayId = "id";
        String name = "name";
        String description = "desc";
        SBOLservice instance = new SBOLservice();

        Library expResult = aLib;

        //test
        Library result = instance.createLibrary(displayId, name, description);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of addDnaComponentToLibrary method, of class SBOLservice.
     */
    @Test
    public void testAddDnaComponentToLibrary() {
        System.out.println("addDnaComponentToLibrary");
        DnaComponent component = aDC;
        Library library = aLib;
        SBOLservice instance = new SBOLservice();

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
     * Test of addSequenceFeatureToLibrary method, of class SBOLservice.
     */
    @Test
    public void testAddSequenceFeatureToLibrary() {
        System.out.println("addSequenceFeatureToLibrary");
        SequenceFeature feature = aSF;
        Library library = aLib;
        SBOLservice instance = new SBOLservice();

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
     * Test of getAllAsRDF method, of class SBOLservice.
     */
    @Ignore
    @Test
    public void testGetAllAsRDF() {
        System.out.println("getAllAsRDF");
        SBOLservice instance = new SBOLservice();
        String expResult = "";
        String result = instance.getAllAsRDF();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getLibrary method, of class SBOLservice.
     */
    @Test
    public void testGetLibrary() {
        System.out.println("getLibrary");
        String id = "id";
        SBOLservice instance = new SBOLservice();
        instance.createLibrary("id", "name", "desc");

        Library expResult = aLib;

        //test
        Library result = instance.getLibrary();
        assertEquals(expResult, result);
    }

    /**
     * Test of addSequenceAnnotationToDnaComponent method, of class SBOLservice.
     */
    @Test
    public void testAddSequenceAnnotationToDnaComponent() {
        System.out.println("addSequenceAnnotationToDnaComponent");
        SequenceAnnotation annotation = aSA;
        DnaComponent component = aDC;
        SBOLservice instance = new SBOLservice();

        //DnaComponent w a SequenceAnnotation connected
        SequenceAnnotation aSA_SF = new SequenceAnnotation(); //full annotation
        aSA_SF = aSA;
        aSA_SF.addFeature(aSF);

        DnaComponent aDC_SA_SF = new DnaComponent(); //Annotated component
        aDC_SA_SF = aDC;
        aDC_SA_SF.addAnnotation(aSA_SF);
        DnaComponent expResult = aDC_SA_SF;

        System.out.println("has "+ aDC_SA_SF.hashCode());
        
        //test
        DnaComponent result = instance.addSequenceAnnotationToDnaComponent(annotation, component);
        assertEquals(expResult, result);
    }

    /**
     * Test of insertLibrary method, of class SBOLservice.
     */
    @Test
    public void testInsertLibrary() {
        System.out.println("insertLibrary");
        Library lib = aLib;
        SBOLservice instance = new SBOLservice();

        Library expResult = aLib;
        
        //test
        instance.insertLibrary(lib);
        Library result = instance.getLibrary();
        assertEquals(expResult, result);
    }

    /**
     * Test of insertDnaComponent method, of class SBOLservice.
     */
    @Test
    public void testInsertDnaComponent() {
        System.out.println("insertDnaComponent");
        DnaComponent comp = new DnaComponent();
        comp.setDisplayId("id");
        comp.setName("name");
        comp.setDescription("desc");
        comp.setCircular(false);
        comp.addType(URI.create("http://purl.org/obo/owl/SO#" + "so_id"));
        comp.setDnaSequence(aDS);
        SBOLservice instance = new SBOLservice();
        //instance.insertLibrary(aLib);
        //DnaComponent result = instance.getLibrary("id").getComponents().iterator().next();
        
        DnaComponent expResult = aDC;

        //test
        
        //aLib.addComponent(comp);
        System.out.println("comp aL1 " + aLib.getComponents().contains(comp));
        instance.insertLibrary(aLib);
        instance.insertDnaComponent(comp);
        aLib = instance.addDnaComponentToLibrary(comp, aLib);
        System.out.println("comp aL2 " + aLib.getComponents().contains(comp));
        String a = instance.getAllAsRDF();
        System.out.println("rdf: " +a+"\n");
        Library result1 = instance.getLibrary();
        System.out.println("\nres lib "+result1.getId());
        System.out.println("comp res " + result1.getComponents().contains(comp));
        
        for ( DnaComponent i : result1.getComponents()){
            System.out.println("comp? " +i.getRdfId() );
        }

        DnaComponent result = result1.getComponents().iterator().next();
        assertEquals(expResult, result);
    }

    /**
     * Test of insertSequenceAnnotation method, of class SBOLservice.
     */
    @Test
    public void testInsertSequenceAnnotation() {
        System.out.println("insertSequenceAnnotation");
        SequenceAnnotation anot = aSA; //p
        SBOLservice instance = new SBOLservice();
        //Library w a DnaComponent - a Virtual Part
        Library aLib_DC = new Library(); //virtual part
        aLib_DC = aLib;
        aLib_DC.addComponent(aDC);
        instance.insertLibrary(aLib_DC);

        SequenceAnnotation expResult = aSA;

        //test
        instance.insertSequenceAnnotation(anot);
        SequenceAnnotation result = instance.getLibrary().getComponents()
                .iterator().next().getAnnotations().iterator().next();
        assertEquals(expResult, result);
    }

    /**
     * Test of insertSequenceFeature method, of class SBOLservice.
     */
    @Test
    public void testInsertSequenceFeature() {
        System.out.println("insertSequenceFeature");
        SequenceFeature feat = aSF;
        SBOLservice instance = new SBOLservice();

        //Library w a DnaComponent and a SequenceAnnotation
        Library aLib_DC_SA_SF = new Library(); //empty promise
        aLib_DC_SA_SF = aLib;
        DnaComponent aDC_SA_SF = new DnaComponent(); //Annotated component
        //aDC_SA_SF.addAnnotation(aSA_SF);
        //DnaComponent expResult = aDC_SA_SF;
        aLib_DC_SA_SF.addComponent(aDC_SA_SF);
        instance.insertLibrary(aLib_DC_SA_SF);
        
        SequenceFeature expResult = aSF;

        //test
        instance.insertSequenceFeature(feat);
        // fails no linking SA-SF
        SequenceFeature result = instance.getLibrary().getComponents()
                .iterator().next().getAnnotations()
                .iterator().next().getFeatures().iterator().next();
        assertEquals(expResult, result);
    }

}