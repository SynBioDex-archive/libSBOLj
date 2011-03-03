/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.sbolstandard.libSBOLj;

import java.net.URI;

/**
 * SbolService provides the methods for making new SBOL objects and adding SBOL
 * data.
 *
 * Use methods of SbolService when creating new SBOL objects and adding data.
 * It is called a service as it performs operations on the SBOL objects that do
 * not really belong to the class itself. These convenience methods SHOLD include
 * an entity manager from empire, delete methods, creating entities SHOULD check
 * for previously existing objects and eventually should be the only way most
 * applications interact with the SBOL API.
 * 
 * inspired by examples on: http://www.java2s.com/Code/Java/JPA
 * it should do more of the things found in the intro to jpa:
 * http://www.javaworld.com/javaworld/jw-01-2008/jw-01-jpa1.html
 *
 * @author mgaldzic
 * @since 0.2, 03/2/2011
 */
public class SbolService {
    /**
     * Builds a new DnaSequence using a string of dna sequence is input.
     *
     * @param dnaSequence a string with a sequence of [a|c|t|g] letters
     *
     * @see DnaSequence#setDnaSequence
     * 
     * @return DnaSequence can be used as the sequence of a DnaComponent or
     * SequenceFeature
     */
    public DnaSequence createDnaSequence(String dnaSequence){
        DnaSequence aDS = new DnaSequence();
        aDS.setDnaSequence(dnaSequence);
        return aDS;
    }
    /**
     * Builds a new SequenceFeature which SequenceAnnotations can point to.
     *
     * @param displayId A human readable identifier
     * @param name commonly used to refer to this SequenceFeature (eg. pLac-O1)
     * @param description human readable text describing the feature
     * @param type Sequence Ontology vocabulary term describing the kind of thing
     * the feature is
     * @return a SequenceFeature which can be used to describe a SequenceAnnotation
     *
     * @see SequenceFeature
     */
    public SequenceFeature createSequenceFeature(String displayId, String name,
            String description, String type){
        SequenceFeature aSF = new SequenceFeature();
        aSF.setDisplayId(displayId);
        aSF.setName(name);
        aSF.setDescription(description);
        aSF.setType(URI.create("http://sbols.org/sbol.owl#" + type));
        return aSF;
    }
    /**
     * Builds a new SequenceAnnotation which can be used to describe a segment
     * of a DnaComponent.
     *
     * Can only describe one DnaComponent. (SequenceFeatures are to be re-used,
     * when the same one is reused to describe multiple DnaCompenents)
     *
     * @param start coordinate of first base of the SequenceFeature
     * @param stop coordinate of last base of the SequenceFeature
     * @param strand <code>+</code> if feature aligns in same direction as DnaComponent,
     *               <code>-</code> if feature aligns in opposite direction as DnaComponent.
     * @return a SequenceAnnotation made to annotate a DnaComponent
     *
     * @see SequenceAnnotation#setStrand(java.lang.String)
     */
    public SequenceAnnotation createSequenceAnnotation(Integer start,
            Integer stop, String strand){
        SequenceAnnotation aSA = new SequenceAnnotation();
        aSA.setStart(start);
        aSA.setStop(stop);
        aSA.setStrand(strand);
        return aSA;
    }
    /**
     * Links SequenceFeature to its SequenceAnnotation.
     *
     * @param feature description of the position
     * @param annotation position information for a DnaComponent being describes
     * @return The linked SequenceAnnotation. //WHY? here is an example of when
     * objects should be kept in a entity manager
     */
    public SequenceAnnotation addSequenceFeatureToSequenceAnnotation(
            SequenceFeature feature, SequenceAnnotation annotation){
        annotation.addFeature(feature);
        return annotation;
    }

    /**
     * Builds a new DnaComponent to describe and add to Library
     *
     * @param displayId    human readable identifier
     * @param name         commonly used to refer to this DnaComponent
     *                     (eg. pLac-O1)
     * @param description  human readable text describing the component
     * @param isCircular   <code>true</code> if DNA is circular
     *                     <code>false</code> if DNA is linear
     * @param type         Sequence Ontology vocabulary term specifying the kind
     *                     of thing the DnaComponent is
     * @param dnaSequence  previously created DnaSequence of this DnaComponent
     *

     * @return DnaComponent which should be added to a Library
     * @see DnaComponent#setDisplayId(java.lang.String)
     * @see DnaComponent#setName(java.lang.String)
     * @see DnaComponent#setDescription(java.lang.String)
     * @see DnaComponent#setCircular(boolean)
     * @see DnaComponent#setDnaSequence(org.sbolstandard.libSBOLj.DnaSequence)
     */
    public DnaComponent createDnaComponent(String displayId, String name,
            String description, Boolean isCircular, String type,
            DnaSequence dnaSequence) {
        DnaComponent aDC = new DnaComponent();
        aDC.setDisplayId(displayId);
        aDC.setName(name);
        aDC.setDescription(description);
        aDC.setCircular(isCircular);

        aDC.setType(URI.create("http://sbols.org/sbol.owl#" + type));
        aDC.setDnaSequence(dnaSequence);
        return aDC;
    }

    /**
     * Links a SequenceAnnotation to the DnaComponent it describes.
     *
     * @param annotation position and strand of the feature that was added to the
     *                   annotation
     * @param component the DnaComponent being described by the annotation
     *
     * @return the now annotated DnaComponent //WHY? as for the annotation-feature
     * link this should be maintained by a entity manager
     * TODO: add an enity manager to the SbolService class
     */
    public DnaComponent addSequenceAnnotationToDnaComponent(SequenceAnnotation annotation, DnaComponent component){
        annotation.setId(component);
        component.addAnnotation(annotation);
        return component;
    }
    /**
     * Link the DnaComponent into a Library for organizing it as a list of components
     * that can be re-used, exchanged with another application, or published on the web.
     *
     * @param component a DnaComponent that is to be part of the Library
     * @param library a Library which will hold this DnaComponent
     * @return the Library with the DnaComponent inside
     */
    public Library addDnaComponentToLibrary(DnaComponent component, Library library){
        library.addComponent(component);
        return library;
    }
    /**
     * Link the SequenceFeature into a Library for organizing it as a list of
     * features that can be re-used, exchanged with another application, or published
     * on the web.
     *
     * Features do not have to describe components. They are useful on their own
     * if you want to take a library of features and annotate your own DnaComponents,
     * also known as, DNA constructs, with them.
     *
     * @param feature SequenceFeature to be added to a Library
     * @param library Library that will hold the SequenceFeature
     * @return
     */
    public Library addSequenceFeatureToLibrary(SequenceFeature feature, Library library){
        library.addFeature(feature);
        return library;
    }

    
}
