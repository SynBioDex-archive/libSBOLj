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
import org.sbolstandard.libSBOLj.IOTools.SkipInJson;

/**
 * The SBOL data model's SequenceFeature for RDF and Json.
 *
 * The objects of this type represent DNA features which describe DnaComponents
 * found in the Library. They are associated with DnaComponents via the position
 * and strand information found in the SequenceAnnotation. They SHOULD have a
 * DnaSequence object which corresponds to the sequence of the DnaComponent
 * starting and ending at the SequenceAnnotation position in the direction given
 * by the strand. DnaComponents are EXPECTED to be found inside
 * a SBOL Library object.
 *
 * @todo SHOULD, EXPECTED above
 *
 * @author mgaldzic
 * @since  0.1, 02/08/2011
 */
@Namespaces({"sbol", "http://sbols.org/sbol.owl#"})
@RdfsClass("sbol:SequenceFeature")
@Entity
public class SequenceFeature implements SupportsRdfId {

    static final String DATA_NAMESPACE_DEFAULT = "http://sbols.org/data#";

    @SkipInJson
    private SupportsRdfId mIdSupport = new SupportsRdfIdImpl();
    @RdfId(namespace = DATA_NAMESPACE_DEFAULT)
    private String id;
    @RdfProperty("sbol:displayId")
    private String displayId;
    @RdfProperty("sbol:name")
    private String name;
    @RdfProperty("sbol:description")
    private String description;
    @OneToMany(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @RdfProperty("rdf:type")
    private Collection<URI> type = new HashSet<URI>();
    @OneToOne(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @RdfProperty("sbol:dnaSequence")
    private DnaSequence dnaSequence;

    /**
     * Text which is for users to read and interpret what this feature is.
     * (eg. engineered Lac promoter, repressible by LacI).
     * Could be lengthy, so it is the responsibility of the user application to
     * format and allow for arbitrary length.
     * @return Human readable text describing the feature
     * @see #setDescription
     */
    public String getDescription() {
        return description;
    }

    /**
     * Text which is written for users to read and interpret.
     * It should describe what the feature is used for and/or what it does.
     * Suggestion: it should provide information that cannot yet be represented in
     * the rest of the feature's computable fields. Do not include <> tags
     * such as HTML or XML inside as that may break the RDF. Don't include {}
     * tags as that may break the Json.
     * @param description Human readable text describing the feature
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Identifier to display to users.
     * @return A human readable identifier
     */
    public String getDisplayId() {
        return displayId;
    }

    /**
     * Identifier that users will see as reference to this feature.
     * It should be unambiguous and is likely imported from source data. Otherwise
     * it SHOULD be generated.
     * @todo It should be restricted to alphanumeric/underscore and starting with a
     * letter or underscore.
     * @todo SHOULD
     * @param displayId A human readable identifier
     */
    public void setDisplayId(String displayId) {
        this.displayId = displayId;
        this.generateId();
    }

    /**
     * DNA sequence which this Feature object represents.
     * @return 1 {@link DnaSequence} specifying the DNA sequence of this SequenceFeature
     * @see DnaSequence
     */
    public DnaSequence getDnaSequence() {
        return dnaSequence;
    }

    /**
     * DNA sequence which this feature object represents.
     * @param dnaSequence specify the DNA sequence of this feature
     */
    public void setDnaSequence(DnaSequence dnaSequence) {
        this.dnaSequence = dnaSequence;
    }

    /**
     * The ID portion of the URI which identifies this object
     * @return the RDF id for the object
     */
    public String getId() {
        return id;
    }

    /**
     * A unique identifier which will be used as the ID portion of the URI
     * @param id the RDF id for the object
     */
    private void generateId() {
        String idString = this.getClass().toString()+getDisplayId();
        this.id = IdentifierUtils.encryptSHA(idString);;
    }

    /**
     * The name is the most recognizable known identifier, it is often ambiguous.
     * (eg. pLac-O1) Useful for display to carry common meaning, see work on "shared
     * understanding" in CSCW field for more.
     * @return its name, commonly used to refer to this SequenceFeature
     */
    public String getName() {
        return name;
    }

    /**
     * Common name of SequenceFeature, confers meaning of what it is.
     * (eg. pLac-O1) Often this name is the short meaningful string that is
     * informally used to identify the feature. Sometimes it is an acronym
     * which makes it likely to be short.
     * @param name its name, commonly used to refer to this SequenceFeature (eg. pLac-O1)
     * @see getName
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Sequence Ontology vocabulary provides a defined term for types of
     * SequenceFeature.
     * @todo implement use of SO within libSBOLj.
     * @return a Sequence Ontology (SO) vocabulary term to describe the type of SequenceFeature.
     * @todo When serialized to RDF this is a URI, so when read from persistence it should become
     * one of the SO human readable vocabulary terms. Note: should allow many types
     */
    public Collection<URI> getTypes() {
        return type;
    }

    /**
     * Sequence Ontology vocabulary provides a defined term for types of
     * SequenceFeature.
     *
     * @param type Sequence Ontology URI specifying the type of the SequenceFeature
     * @see setType
     */
    public void addType(URI type) {
        if (!getTypes().contains(type)) {
            getTypes().add(type);
        }

        //Setting the default_type for SequenceFeatures to create uniform behavior.
        //Sequence Features are always of type sbol:SequenceFeature
        //This default makes SF objects read and SF objects created equal.
        //the other option would be to by default remove sbol:SF from type when
        //reading however other applications would then beahave differently.
        URI default_type = URI.create("http://sbols.org/sbol.owl#SequenceFeature");
        if (!getTypes().contains(default_type)){
            getTypes().add(default_type);
        }
    }

    /**
     * a com.clarkparsia.empire required RDF id.
     * Not sure what the difference is in empire compared to {@link id}
     * @return the RdfId component of the URI for the SequenceFeature
     */
    public RdfKey getRdfId() {
        return mIdSupport.getRdfId();
    }

    /**
     *
     * @param id //note use .setID instead for now, it takes string
     * @depricated
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
        final SequenceFeature other = (SequenceFeature) obj;
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
            if (this.type != other.type && (this.type == null || !this.type.equals(other.type))) {
                return false;
            }
            if (this.dnaSequence != other.dnaSequence && (this.dnaSequence == null || !this.dnaSequence.equals(other.dnaSequence))) {
                return false;
            }
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 1;
        hash = hash * 31 + this.getClass().hashCode();
        hash = hash * 31 + (displayId == null ? 0 : displayId.hashCode());
        hash = hash * 31 + (name == null ? 0: name.hashCode());
        hash = hash * 31 + (description == null ? 0 : description.hashCode());
        hash = hash * 31 + (type == null ? 0 : type.hashCode());
        hash = hash * 31 + (dnaSequence == null ? 0 : dnaSequence.hashCode());

        //int hash = getRdfId() == null ? 0 : getRdfId().value().hashCode();
        return hash;
    }

}
