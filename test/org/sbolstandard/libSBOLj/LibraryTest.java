/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.sbolstandard.libSBOLj;

import org.junit.Ignore;
import java.net.URI;
import com.clarkparsia.empire.SupportsRdfId.RdfKey;
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
 * @since 0.35 5/30/2011
 */
@Ignore
public class LibraryTest {

    public LibraryTest() {
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
     * Test of getComponents method, of class Library.
     */
    @Test
    public void testGetComponents() {
        System.out.println("getComponents");
        Library instance = new Library();
        Collection expResult = null;
        Collection result = instance.getComponents();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addComponent method, of class Library.
     */
    @Test
    public void testAddComponent() {
        System.out.println("addComponent");
        DnaComponent component = null;
        Library instance = new Library();
        instance.addComponent(component);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDescription method, of class Library.
     */
    @Test
    public void testGetDescription() {
        System.out.println("getDescription");
        Library instance = new Library();
        String expResult = "";
        String result = instance.getDescription();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDescription method, of class Library.
     */
    @Test
    public void testSetDescription() {
        System.out.println("setDescription");
        String description = "";
        Library instance = new Library();
        instance.setDescription(description);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDisplayId method, of class Library.
     */
    @Test
    public void testGetDisplayId() {
        System.out.println("getDisplayId");
        Library instance = new Library();
        String expResult = "";
        String result = instance.getDisplayId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDisplayId method, of class Library.
     */
    @Test
    public void testSetDisplayId() {
        System.out.println("setDisplayId");
        String displayId = "";
        Library instance = new Library();
        instance.setDisplayId(displayId);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getFeatures method, of class Library.
     */
    @Test
    public void testGetFeatures() {
        System.out.println("getFeatures");
        Library instance = new Library();
        Collection expResult = null;
        Collection result = instance.getFeatures();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addFeature method, of class Library.
     */
    @Test
    public void testAddFeature() {
        System.out.println("addFeature");
        SequenceFeature feature = null;
        Library instance = new Library();
        instance.addFeature(feature);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

 



}