/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.sbolstandard.experiment;

/**
 *
 * @author cesarr
 */
public class DnaComponent
{
    protected String        displayId;
    protected String        name;
    protected String        description;
    protected String        type;
    protected String        subtype;
    protected Design        design;
    protected Performance   performance;

    public DnaComponent(String displayId, String name, String description, String type, String subtype)
    {
        this.displayId = displayId;
        this.name = name;
        this.description = description;
        this.type = type;
        this.subtype = subtype;
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
     * @return the subtype
     */
    public String getSubtype()
    {
        return subtype;
    }

    /**
     * @param displayId the displayId to set
     */
    public void setDisplayId(String displayId) {
        this.displayId = displayId;
    }

    /**
     * @return the performance
     */
    public Performance getPerformance()
    {
        return performance;
    }

    /**
     * @param performance the performance to set
     */
    public void setPerformance(Performance performance)
    {
        this.performance = performance;
    }

    /**
     * @return the design
     */
    public Design getDesign()
    {
        return design;
    }

    /**
     * @param design the design to set
     */
    public void setDesign(Design design)
    {
        this.design = design;
    }
}
