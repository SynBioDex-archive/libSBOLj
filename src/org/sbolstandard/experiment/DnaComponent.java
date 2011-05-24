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
public class DnaComponent
{
    protected int                           collectionID;
    protected String                        displayID;
    protected String                        name;
    protected String                        description;
    protected String                        type;
    protected String                        subtype;
    protected boolean                       isCircular;
    protected DnaSequence                   dnaSequence;
    protected Performance                   performance;
    protected ArrayList<SequenceAnnotation> annotations;

    public DnaComponent(int collectionID, String displayId, String name, String description, String type, String subtype, boolean isCircular, DnaSequence dnaSequence)
    {
        this.collectionID = collectionID;
        this.displayID = displayId;
        this.name = name;
        this.description = description;
        this.type = type;
        this.subtype = subtype;
        this.isCircular = isCircular;
        this.dnaSequence = dnaSequence;
    }

    /**
     * @return the displayId
     */
    public String getDisplayID()
    {
        return displayID;
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
     * @return the subtype
     */
    public String getSubtype()
    {
        return subtype;
    }

    /**
     * @param displayId the displayId to set
     */
    public void setDisplayID(String displayID)
    {
        this.displayID = displayID;
    }

    /**
     * @return the performance
     */
    public Performance getPerformance()
    {
        if(performance == null)
        {
           performance = new Performance();
        }

        return performance;
    }

//    /**
//     * @param performance the performance to set
//     */
//    public void setPerformance(Performance performance)
//    {
//        this.performance = performance;
//    }

    /**
     * @return the DnaSequence
     */
    public DnaSequence getDnaSequence()
    {
        return dnaSequence;
    }

    /**
     * @return the collectionID
     */
    public int getCollectionID()
    {
        return collectionID;
    }

    /**
     * @param collectionID the collectionID to set
     */
    public void setCollectionID(int collectionID)
    {
        this.collectionID = collectionID;
    }

    public ArrayList<SequenceAnnotation> getAnnotations()
    {
        return annotations;
    }

    public void setAnnotations(ArrayList<SequenceAnnotation> annotations)
    {
        this.annotations = annotations;
    }

    /**
     * @return the isCircular
     */
    public boolean isCircular()
    {
        return isCircular;
    }
}
