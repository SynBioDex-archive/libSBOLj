/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.sbol.libsbol.json.performance;

import java.util.ArrayList;

/**
 *
 * @author cesarr
 */
public class Performance
{
    protected ArrayList<Measurement>    measurements;

    public Performance()
    {
        this.measurements = new ArrayList<Measurement>();
    }

    /**
     * @return the measurements
     */
    public ArrayList<Measurement> getMeasurements()
    {
        return measurements;
    }

    /**
     * @param measurements the measurements to set
     */
    public void setMeasurements(ArrayList<Measurement> measurements)
    {
        this.measurements = measurements;
    }
}
