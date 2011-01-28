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
    public DnaSequence createDnaSequence(String dnaSequence){
        DnaSequence aDS = new DnaSequence();
        aDS.setDnaSequence(dnaSequence);
        return aDS;
    }
    public SequenceFeature createSequenceFeature(String displayId, String name,
            String description, String type){
        SequenceFeature aSF = new SequenceFeature();
        aSF.setDisplayId(displayId);
        aSF.setName(name);
        aSF.setDescription(description);
        aSF.setType(URI.create("http://sbols.org/sbol.owl#" + type));
        return aSF;
    }
    public SequenceAnnotation createSequenceAnnotation(Integer start,
            Integer stop, String strand){
        SequenceAnnotation aSA = new SequenceAnnotation();
        aSA.setStart(start);
        aSA.setStop(stop);
        aSA.setStrand(strand);
        return aSA;
    }
    public SequenceAnnotation addSequenceFeatureToSequenceAnnotation(
            SequenceFeature feature, SequenceAnnotation annotation){
        annotation.addFeature(feature);
        return annotation;
    }

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

    public DnaComponent addSequenceAnnotationToDnaComponent(SequenceAnnotation annotation, DnaComponent component){
        annotation.setId(component);
        component.addAnnotation(annotation);
        return component;
    }
    public Library addDnaComponentToLibrary(DnaComponent component, Library library){
        library.addComponent(component);
        return library;
    }
    public Library addSequenceFeatureToLibrary(SequenceFeature feature, Library library){
        library.addFeature(feature);
        return library;
    }

    
}
