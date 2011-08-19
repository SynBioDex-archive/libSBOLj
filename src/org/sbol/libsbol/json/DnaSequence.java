/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.sbol.libsbol.json;

/**
 *
 * @author cesarr
 * 
 */

public class DnaSequence
{
    protected String    nucleotides;
    protected boolean   isCircular;


    public DnaSequence(String nucleotides, boolean isCircular)
    {
        //TODO Validate dnaSequence

        this.nucleotides = nucleotides;
        this.isCircular = isCircular;
    }

    /**
     * @return the dnaSequence
     */
    public String getNucleotides()
    {
        return nucleotides;
    }
    
    /**
     * @return isCircular
     */
    public boolean isCircular()
    {
        return isCircular;
    }
}
