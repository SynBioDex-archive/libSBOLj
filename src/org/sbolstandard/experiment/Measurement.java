/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.sbolstandard.experiment;

/**
 *
 * @author cesarr
 */
public class Measurement
{
    protected String    type;
    protected String    label;
    protected String    definition;
    protected float     value;
    protected float     standardDeviation;

//  protected RawData            rawData;
//  protected AcquisitionInfo    acquisitionInfo;

    public Measurement(String type, String label, String definition, float value, float standardDeviation)
    {
        this.type = type;
        this.label = label;
        this.definition = definition;
        this.value = value;
        this.standardDeviation = standardDeviation;
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
}
