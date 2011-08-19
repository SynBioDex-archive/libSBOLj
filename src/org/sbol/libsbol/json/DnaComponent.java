/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.sbol.libsbol.json;

import java.util.ArrayList;

/**
 *
 * @author cesarr
 */
public class DnaComponent
{
    protected String                        displayId;
    protected String                        name;
    protected String                        description;
    protected String                        type;
    protected DnaSequence                   dnaSequence;
    protected ArrayList<SequenceAnnotation> annotations;

    public DnaComponent(String displayId, String name, String description, String type)
    {
        this.displayId = displayId;
        this.name = name;
        this.description = description;
        this.type = type;
        this.dnaSequence = null;
    }
    
    public DnaComponent(String displayId, String name, String description, String type, DnaSequence dnaSequence)
    {
        this.displayId = displayId;
        this.name = name;
        this.description = description;
        this.type = type;
        this.dnaSequence = dnaSequence;
    }

    /**
     * @return the displayId
     */
    public String getDisplayId()
    {
        return displayId;
    }

    /**
     * @return the name
     */
    public String getName()
    {
        return name;
    }

    /**
     * @return the description
     */
    public String getDescription()
    {
        return description;
    }

    /**
     * @return the type
     */
    public String getType()
    {
        return type;
    }

    /**
     * @return the DnaSequence
     */
    public DnaSequence getDnaSequence()
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
