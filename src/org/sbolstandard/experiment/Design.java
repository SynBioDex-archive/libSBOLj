/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.sbolstandard.experiment;

import java.util.ArrayList;

/**
 *
 * @author cesarr
 */
public class Design
{
    protected String                        dnaSequence;
    protected ArrayList<SequenceAnnotation> annotations;


    public Design(String dnaSequence)
    {
        //TODO Validate dnaSequence

        this.dnaSequence = dnaSequence;
    }

    
    /**
     * @return the dnaSequence
     */
    public String getDnaSequence()
    {
        return dnaSequence;
    }

    public ArrayList<SequenceAnnotation> getAnnotations()
    {
        return annotations;
    }

    public void setAnnotations(ArrayList<SequenceAnnotation> annotations)
    {
        this.annotations = annotations;
    }
}
