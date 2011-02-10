/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.sbolstandard.libSBOLj;

import java.net.URI;

/**
 *
 * @author mgaldzic
 */
public class SbolService {
    /**
     *
     * @param dnaSequence
     * @return
     */
    public DnaSequence createDnaSequence(String dnaSequence){
        DnaSequence aDS = new DnaSequence();
        aDS.setDnaSequence(dnaSequence);
        return aDS;
    }
    /**
     *
     * @param displayId
     * @param name
     * @param description
     * @param type
     * @return
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
     *
     * @param start
     * @param stop
     * @param strand
     * @return
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
     *
     * @param feature
     * @param annotation
     * @return
     */
    public SequenceAnnotation addSequenceFeatureToSequenceAnnotation(
            SequenceFeature feature, SequenceAnnotation annotation){
        annotation.addFeature(feature);
        return annotation;
    }

    /**
     *
     * @param displayId
     * @param name
     * @param description
     * @param isCircular
     * @param type
     * @param dnaSequence
     * @return
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
     *
     * @param annotation
     * @param component
     * @return
     */
    public DnaComponent addSequenceAnnotationToDnaComponent(SequenceAnnotation annotation, DnaComponent component){
        annotation.setId(component);
        component.addAnnotation(annotation);
        return component;
    }
    /**
     *
     * @param component
     * @param library
     * @return
     */
    public Library addDnaComponentToLibrary(DnaComponent component, Library library){
        library.addComponent(component);
        return library;
    }
    /**
     *
     * @param feature
     * @param library
     * @return
     */
    public Library addSequenceFeatureToLibrary(SequenceFeature feature, Library library){
        library.addFeature(feature);
        return library;
    }

    
}