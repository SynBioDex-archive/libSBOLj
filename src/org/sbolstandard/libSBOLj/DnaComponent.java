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
 * The SBOL data model's DnaComponent for RDF and Json.
 *
 * This objects of this type represent DNA components for biological engineering
 * which can be described by SequenceAnnotation objects and must specify their
 * DnaSequence object. DnaComponents are expected to be found inside
 * a SBOL Library object.
 *
 * @author mgaldzic
 * @version 0.1, 02/08/2011
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

    /**
     * Positions and directions of <code>SequenceFeature</code>[s] that describe
     * the DNA sequence.
     * @return 0 or more <code>SequenceAnnotation</code>[s] that describe the 
     * DNA composition
     * @see addAnnotation
     */
    public Collection<SequenceAnnotation> getAnnotations() {
        return annotation;
    }

    /**
     * New position and direction of a <code>SequenceFeature</code> that
     * describes the DNA sequence.
     * The DnaComponent could be left un-annotated, but that condition is not a very useful to users.
     * @param annotation a <code>SequenceAnnotation</code> that describes the DNA composition
     */
    public void addAnnotation(SequenceAnnotation annotation) {
        if (!getAnnotations().contains(annotation)) {
            getAnnotations().add(annotation);
            //this.feature.add(feature);
        }
    }

    /**
     * Text which is for users to read and interpret what this component is.
     * (eg. engineered Lac promoter, repressible by LacI).
     * Could be lengthy, so it is the responsibility of the user application to
     * format and allow for arbitrary length.
     * @return Human readable text describing the component
     * @see setDescription
     */
    public String getDescription() {
        return description;
    }

    /**
     * Text which is written for users to read and interpret. 
     * It should describe what the component is used for and/or what it does.
     * Suggestion: it should provide information that cannot yet be represented in
     * the rest of the DNA components computable fields. Do not include <> tags
     * such as HTML or XML inside as that may break the RDF. Don't include {}
     * tags as that may break the Json.
     * @param description human readable text describing the component
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Identifier to display to users.
     * @return a human readable identifier
     */
    public String getDisplayId() {
        return displayId;
    }

    /**
     * Identifier that users will see as reference to the DNA construct.
     * It should be unambiguous and is likely imported from source data. Otherwise
     * it should be generated.
     * TODO: It should be restricted to alphanumeric/underscore and starting with a
     * letter or underscore.
     * @param displayId a human readable identifier
     */
    public void setDisplayId(String displayId) {
        this.displayId = displayId;
        setId(displayId);
    }

    /**
     * DNA sequence which this DnaComponent object represents.
     * @return 1 {@link DnaSequence} specifying the DNA sequence of this DnaComponent
     * @see DnaSequence
     */
    public DnaSequence getDnaSequence() {
        return dnaSequence;
    }

    /**
     * DNA sequence which this DnaComponent object represents.
     * @param dnaSequence specify the DnaSequence of this DnaComponent
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
    public void setId(String id) {
        this.id = id;
    }

    /**
     * If circular the DnaSequence should be interpreted as circular.
     * Circularity has implications in terms of positions, physical DNA type,
     * and potential for molecular manipulation. If not circular, then it must
     * be linear. Note: Other structures are not considered as a simplification.
     *
     * <p>MOVE TO NOTES: If a use case comes up that requires complex physical forms,
     * some new solution will have to implemented.
     * For example: in an integration use case where we want to establish identity
     * between a component which is a plasmid and a sequence identical one which 
     * has been cut and is now linear. Furthermore, what are subcomponents of 
     * a circular component? Do they inherit circularity? That would be weird.
     * If a PhysicalDna class is established, we can then perform physical operations
     * independently of the dna component concept. This separation of physical 
     * molecules would also allow their physical properties, such as mass, or 
     * their changes in identity (eg amplicon to plasmid) to be independent of the
     * information content (dna component). more scattered thoughts: For example, 
     * Borrelia burgdorfer, a prokaryote has linear chromosomes. For example,
     * if a mobius strip like dna formation have implications on
     * its replication?</p>
     *
     * @return <code>true</code> if DNA is circular
     *         <code>false</code> if DNA is linear
     */
    public boolean isCircular() {
        return isCircular;
    }

    /**
     * Specify circularity <code>true</code> or linearity <code>false</code>.
     * Helps to interpret the positions of features.
     * @param isCircular  <code>true</code> if the DnaComponent's DNA sequence
     * should be interpreted as circular
     *         <code>false</code> if theDnaComponents's DNA sequence should be
     * interpreted as linear
     */
    public void setCircular(boolean isCircular) {
        this.isCircular = isCircular;
    }

    /**
     * The name is the most recognizable known identifier, it is often ambiguous.
     * (eg. pLac-O1) Useful for display to carry common meaning, see work on "shared
     * understanding" in CSCW field for more.
     * @return its name, commonly used to refer to this DnaComponent
     */
    public String getName() {
        return name;
    }

    /**
     * Common name of DNA component, confers meaning of what it is.
     * (eg. pLac-O1) Often this name is the short meaningful string that is
     * informally used to identify the DNA component. Sometimes it is an acronym
     * which makes it likely to be short.
     * @param name its name, commonly used to refer to this DnaComponent (eg. pLac-O1)
     * @see getName
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Sequence Ontology vocabulary provides a defined term for types of DNA
     * components.
     * TO DO: implement use of SO within libSBOLj.
     * @return a Sequence Ontology (SO) vocabulary term to describe the type of DnaComponent.
     * TODO: When serialized to RDF this is a URI, so when read from persistence it should become
     * one of the SO human readable vocabulary terms. Note:I should allow many types
     */
    public URI getType() {
        return type;
    }

    /**
     * Sequence Ontology vocabulary provides a defined term for types of DNA
     * components.
     *
     * @param type Sequence Ontology URI specifying the type of the DnaComponent
     * @see setType
     */
    public void setType(URI type) {
        this.type = type;
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
     * @param id //note use .setID instead for now, it takes string
     *
     */
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
