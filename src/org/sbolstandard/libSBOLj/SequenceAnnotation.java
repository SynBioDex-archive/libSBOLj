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
import java.util.Collection;
import java.util.HashSet;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import org.apache.commons.codec.binary.Hex;
import org.sbolstandard.libSBOLj.SBOLutil.SkipInJson;

/**
 *
 * @author mgaldzic
 */
@Namespaces({"sbol", "http://sbols.org/sbol.owl#"})
@RdfsClass("sbol:SequenceAnnotation")
@Entity
class SequenceAnnotation implements SupportsRdfId {
    @SkipInJson
    private SupportsRdfId mIdSupport = new SupportsRdfIdImpl();
    @RdfId(namespace = "http://sbols.org/sbol.owl#")
    private String id;
    @RdfProperty("sbol:start")
    private Integer start;
    @RdfProperty("sbol:stop")
    private Integer stop;
    @RdfProperty("sbol:strand")
    private String strand;
    @OneToMany(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @RdfProperty("sbol:feature")
    private Collection<SequenceFeature> feature = new HashSet<SequenceFeature>();

    public Collection<SequenceFeature> getFeature() {
        return feature;
    }

    public void setFeature(Collection<SequenceFeature> feature) {
        this.feature = feature;
    }

    public void addFeature(SequenceFeature feature) {
        if (!getFeatures().contains(feature)) {
            getFeatures().add(feature);
            //this.feature.add(feature);
        }
    }

    public Collection<SequenceFeature> getFeatures() {
        return feature;
    }

    public String getId() {
        return id;
    }

    public void setId(DnaComponent parentDnaComp) {
        String newId;
        if (this.id == null) {
            String idString = start + stop + strand + parentDnaComp.hashCode();
            IMessageDigest md = HashFactory.getInstance("sha-256");
            byte[] input = idString.getBytes();
            md.update(input, 0, input.length);
            newId = new String(Hex.encodeHex(md.digest()));
        } else {
            newId = this.id;
        }
        this.id = newId;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public Integer getStop() {
        return stop;
    }

    public void setStop(Integer stop) {
        this.stop = stop;
    }

    public String getStrand() {
        return strand;
    }

    public void setStrand(String strand) {
        this.strand = strand;
    }

    /**
     * @inheritDoc
     */
    public RdfKey getRdfId() {
        return mIdSupport.getRdfId();
    }

    /**
     * @inheritDoc
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
        final SequenceAnnotation other = (SequenceAnnotation) obj;
        if (getRdfId() != null) {
            return getRdfId().equals(other.getRdfId());
        } else {
            if (this.start != other.start) {
                return false;
            }
            if ((this.stop == null) ? (other.stop != null) : !this.stop.equals(other.stop)) {
                return false;
            }
            if ((this.strand == null) ? (other.strand != null) : !this.strand.equals(other.strand)) {
                return false;
            }
            if (this.feature != other.feature && (this.feature == null || !this.feature.equals(other.feature))) {
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
