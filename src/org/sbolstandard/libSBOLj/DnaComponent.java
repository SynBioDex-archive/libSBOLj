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
import java.net.URI;
import java.util.Collection;
import java.util.HashSet;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import org.sbolstandard.libSBOLj.SBOLutil.SkipInJson;

/**
 *
 * @author mgaldzic
 */
@Namespaces({"sbol", "http://sbols.org/sbol.owl#"})
@RdfsClass("sbol:DnaComponent")
@Entity
public class DnaComponent implements SupportsRdfId {
    @SkipInJson
    private SupportsRdfId mIdSupport = new SupportsRdfIdImpl();
    @RdfId(namespace = "http://sbols.org/sbol.owl#")
    private String id;
    @RdfProperty("sbol:displayId")
    private String displayId;
    @RdfProperty("sbol:name")
    private String name;
    @RdfProperty("sbol:description")
    private String description;
    @RdfProperty("sbol:isCircular")
    private boolean isCircular;
    @RdfProperty("rdf:type")
    private URI type;
    @OneToOne(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @RdfProperty("sbol:dnaSequence")
    private DnaSequence dnaSequence;
    @OneToMany(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @RdfProperty("sbol:annotation")
    private Collection<SequenceAnnotation> annotation = new HashSet<SequenceAnnotation>();

    public Collection<SequenceAnnotation> getAnnotations() {
        return annotation;
    }

    public void addAnnotation(SequenceAnnotation annotation) {
        if (!getAnnotations().contains(annotation)) {
            getAnnotations().add(annotation);
            //this.feature.add(feature);
        }
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDisplayId() {
        return displayId;
    }

    public void setDisplayId(String displayId) {
        this.displayId = displayId;
        setId(displayId);
    }

    public DnaSequence getDnaSequence() {
        return dnaSequence;
    }

    public void setDnaSequence(DnaSequence dnaSequence) {
        this.dnaSequence = dnaSequence;
    }

    public String getId() {
        return id;
    }

    private void setId(String id) {
        this.id = id;
    }

    public boolean isCircular() {
        return isCircular;
    }

    public void setCircular(boolean isCircular) {
        this.isCircular = isCircular;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public URI getType() {
        return type;
    }

    public void setType(URI type) {
        this.type = type;
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
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        final DnaComponent other = (DnaComponent) obj;

        if (getRdfId() != null) {
            return getRdfId().equals(other.getRdfId());
        } else {
            if ((this.displayId == null) ? (other.displayId != null) : !this.displayId.equals(other.displayId)) {
                return false;
            }
            if ((this.name == null) ? (other.name != null) : !this.name.equals(other.name)) {
                return false;
            }
            if ((this.description == null) ? (other.description != null) : !this.description.equals(other.description)) {
                return false;
            }
            if (this.isCircular != other.isCircular) {
                return false;
            }
            if (this.type != other.type && (this.type == null || !this.type.equals(other.type))) {
                return false;
            }
            if (this.dnaSequence != other.dnaSequence && (this.dnaSequence == null || !this.dnaSequence.equals(other.dnaSequence))) {
                return false;
            }
            if (this.annotation != other.annotation && (this.annotation == null || !this.annotation.equals(other.annotation))) {
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
