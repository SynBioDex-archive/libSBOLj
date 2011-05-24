/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.sbolstandard.experiment;

/**
 *
 * @author cesarr
 */
public class DnaSequence
{
    protected String    nucleotides;


    public DnaSequence(String nucleotides)
    {
        //TODO Validate dnaSequence

        this.nucleotides = nucleotides;
    }

    
    /**
     * @return the dnaSequence
     */
    public String getNucleotides()
    {
        return nucleotides;
    }
}
