/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.sbolstandard.libSBOLj.experiment;

/**
 *
 * @author cesarr
 */
public class Measurement
{
    protected String    type;
    protected String    label;
    protected String    unit;
    protected String    definition;
    protected float     value;
    protected float     standardDeviation;
    protected String    constructId;

//  protected RawData            rawData;
//  protected AcquisitionInfo    acquisitionInfo;

    public Measurement(String type, String label, String unit, String definition, float value, float standardDeviation, String constructId)
    {
        this.type = type;
        this.label = label;
        this.unit = unit;
        this.definition = definition;
        this.value = value;
        this.standardDeviation = standardDeviation;
        this.constructId = constructId;
    }

    /**
     * @return the type
     */
    public String getType()
    {
        return type;
    }

    /**
     * @return the label
     */
    public String getLabel()
    {
        return label;
    }
    
    /**
     * @return the unit
     */
    public String getUnit()
    {
        return unit;
    }

    /**
     * @return the definition
     */
    public String getDefinition()
    {
        return definition;
    }

    /**
     * @return the value
     */
    public float getValue()
    {
        return value;
    }

    /**
     * @return the standardDeviation
     */
    public float getStandardDeviation()
    {
        return standardDeviation;
    }
    
    public String getConstructId()
    {
        return constructId;
    }
}
