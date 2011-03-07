/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.sbolstandard.libSBOLj;

import com.clarkparsia.empire.SupportsRdfId;
import com.clarkparsia.empire.annotation.Namespaces;
import com.clarkparsia.empire.annotation.RdfId;
import com.clarkparsia.empire.annotation.RdfProperty;
import com.clarkparsia.empire.annotation.RdfsClass;
import com.clarkparsia.empire.annotation.SupportsRdfIdImpl;
import gnu.crypto.hash.HashFactory;
import gnu.crypto.hash.IMessageDigest;
import javax.persistence.Entity;
import org.apache.commons.codec.binary.Hex;
import org.sbolstandard.libSBOLj.SBOLutil.SkipInJson;

/**
 * The SBOL data model's DnaSequence for RDF and Json.
 *
 * DNA Sequence holds either the actual sequence string or a reference pointer,
 * a URI to it. The SBOL data model is focused on the description of these DNA
 * sequences as they used in assembly of new synthetic biological systems.
 * Information specifying the exact base pair sequence of DNA components and
 * Sequence Features is very important for the ability to replicate synthetic
 * biology work. Both experimental work and theoretical sequence composition
 * research heavily depends on this information.
 *
 * @author mgaldzic
 * @since  0.1, 02/08/2011
 */
@Namespaces({"sbol", "http://sbols.org/sbol.owl#"})
@RdfsClass("sbol:DnaSequence")
@Entity
public class DnaSequence implements SupportsRdfId {
    @SkipInJson
    private SupportsRdfId mIdSupport = new SupportsRdfIdImpl();
    @RdfId(namespace = "http://sbols.org/sbol.owl#")
    private String id;
    @RdfProperty("sbol:DnaSequence")
    private String dnaSequence;
    @RdfProperty("sbol:DnaRef")
    private String dnaRef;

    /**
     * The URI which specifies the DNA sequence at another location.
     * TODO: currently this is not supported by a test case where both the
     * String DnaSequence and DnaRef are both specified. Only one should exist
     * according to the spec. The need for this field may be redundant with the
     * URI for the DnaSequence object (id). Should be re-examined when looking at
     * use cases.
     * @return
     */
    public String getDnaRef() {
        return dnaRef;
    }

    /**
     * The URI referencing an external source for the DNA sequence.
     * @param dnaRef URI which points to the DNA Sequence
     */
    public void setDnaRef(String dnaRef) {
        this.dnaRef = dnaRef;
    }

    /**
     * The sequence of DNA base pairs which are described.
     * @return a string representation of the DNA base-pair sequence
     * @see setDnaSequence
     */
    public String getDnaSequence() {
        return dnaSequence;
    }

    /**
     * The sequence of DNA base pairs which are going to be described.
     *
     *  a.The DNA sequence will use the IUPAC ambiguity recommendation. (See
     * http://www.genomatix.de/online_help/help/sequence_formats.html)
     * b.Blank lines, spaces, or other symbols must not be included in the
     * sequence text.
     * c.The sequence text must be in ASCII or UTF-8 encoding. For the alphabets
     * used, the two are identical.
     *
     * @param dnaSequence a sequence of [a|c|t|g] letters
     */
    public void setDnaSequence(String dnaSequence) {
        this.dnaSequence = dnaSequence;
        setId();
    }

    /**
     * sha-256 hash of the lowercase characters of getDnaSequence (see Tim Ham's
     * proposed BBF RFC on the subject no ref available yet)
     * @return the RDF id for the object
     */
    public String getId() {
        return id;
    }

    private void setId() {
        IMessageDigest md = HashFactory.getInstance("sha-256");
        byte[] input = getDnaSequence().toLowerCase().getBytes();
        md.update(input, 0, input.length);
        this.id = new String(Hex.encodeHex(md.digest()));
    }

    /**
     * a com.clarkparsia.empire required RDF id.
     * Not sure what the difference is in empire compared to {@link id}
     * @return the RdfId component of the URI for the DnaComponent
     */
    public RdfKey getRdfId() {
        return mIdSupport.getRdfId();
    }

    /**
     *
     * @param id  //note use .setID instead for now, it takes string
     */
    public void setRdfId(final RdfKey id) {
        mIdSupport.setRdfId(id);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final DnaSequence other = (DnaSequence) obj;
        if (getRdfId() != null) {
            return getRdfId().equals(other.getRdfId());
        } else {
            if ((this.dnaSequence == null) ? (other.dnaSequence != null) : !this.dnaSequence.equals(other.dnaSequence)) {
                return false;
            }
            if ((this.dnaRef == null) ? (other.dnaRef != null) : !this.dnaRef.equals(other.dnaRef)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public int hashCode() {
        return getRdfId() == null ? 0 : getRdfId().value().hashCode();
    }
}
