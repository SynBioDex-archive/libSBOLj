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
 *
 * @author mgaldzic
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

    public String getDnaRef() {
        return dnaRef;
    }

    public void setDnaRef(String dnaRef) {
        this.dnaRef = dnaRef;
    }

    public String getDnaSequence() {
        return dnaSequence;
    }

    public void setDnaSequence(String dnaSequence) {
        this.dnaSequence = dnaSequence;
        setId();
    }

    public String getId() {
        return id;
    }

    private void setId() {
        IMessageDigest md = HashFactory.getInstance("sha-256");
        byte[] input = getDnaSequence().toLowerCase().getBytes();
        md.update(input, 0, input.length);
        this.id = new String(Hex.encodeHex(md.digest()));
    }

    public RdfKey getRdfId() {
        return mIdSupport.getRdfId();
    }

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
