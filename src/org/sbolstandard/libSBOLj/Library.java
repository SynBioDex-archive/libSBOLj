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
import java.util.Collection;
import java.util.HashSet;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import org.sbolstandard.libSBOLj.SBOLutil.SkipInJson;

/**
* The SBOL data model's Library for RDF and Json.
 *
 * The objects of this type represent an organizational container which helps
 * users and developers conceptualize a set of DNA components and SequenceFeatures
 * as a group. Any combination of these objects can be added to a library,
 * annotated with a displayID, name and description and be shared on the web.
 * Such collections could be a set of restriction enzyme recognition
 * sites, such as the features commonly used for BBF RFC 10 BioBricks. A library
 * could contain all the DNA components used in a specific project, lab, or any
 * custom grouping specified by the user.
 *
 * COMMENT: Mike Galdzicki thinks Library is a Generic metadata object. This metadata
 * element, is a set. It would be best defined by queries, when there is information
 * that groups the collection. Arbitrary groupings and new Library objects should
 * not be created and named when the groupings are not defined, but also Libraries
 * should not be created whenever an arbitrary set is possible, only create if useful.
 * Extensions for useful computable objects should be proposed to help Library
 * definitions.
 *
 * @author mgaldzic
 * @since  0.32, 03/18/2011
 */
@Namespaces({"sbol", "http://sbols.org/sbol.owl#"})
@RdfsClass("sbol:Library")
@Entity
public class Library implements SupportsRdfId {

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
    @OneToMany(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @RdfProperty("sbol:component")
    private Collection<DnaComponent> component = new HashSet<DnaComponent>();
    @OneToMany(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @RdfProperty("sbol:SequenceFeature")
    private Collection<SequenceFeature> feature = new HashSet<SequenceFeature>();

    /**
     * Elements that are intended as engineering components in synthetic biology.
     *
     * For example, standard biological parts, BioBricks, oligo components,
     * vector plasmids, genomes, or any other DNA segment of interest as a building
     * block of biological systems.
     *
     * @return 0 or more <code>DnaComponent</code>[s] that are in this Library
     */
    public Collection<DnaComponent> getComponents() {
        return component;
    }
    /**
     * Defined DNA segment for engineering biological systems, which belongs to
     * this Library.
     *
     * Any one of the following, standard biological parts, BioBricks, oligo components,
     * vector plasmids, genomes, or any other DNA segment of interest as a building
     * block of biological systems.
     *
     * @param component a <code>DnaComponent</code> that should be a member of this library
     */
    public void addComponent(DnaComponent component) {
        if (!getComponents().contains(component)) {
            getComponents().add(component);
        }
    }

    /**
     * Text which is for users to read and interpret what this Library is.
     * (eg "Collecting parts which could be used to build honey production directly into
     * mouse-ear cress"; "T9002 and I7101 variants from Sleight 2010, designs aim to
     * improve stability over evolutionary time"; "features useful when working with
     * BBF RFC 10"; "Totally sick Parts I found browsing the web -- SBOL rules
     * -- organize these later").
     *
     * Informative description which allows human users to interpret the likely
     * members of this Library.
     * @return Human readable text describing the Library
     */
    public String getDescription() {
        return description;
    }

    /**
     * Text with an informative statement about the reason for grouping the Library members.
     * (eg "Collecting parts which could be used to build honey production directly into
     * mouse-ear cress"; "T9002 and I7101 variants from Sleight 2010, designs aim to
     * improve stability over evolutionary time"; "features useful when working with
     * BBF RFC 10"; "Totally sick Parts I found browsing the web -- SBOL rules
     * -- organize these later").
     *
     * @param description Human readable text describing the Library
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
     * Identifier to display to users.
     * @param displayId a human readable identifier
     */
    public void setDisplayId(String displayId) {
        this.displayId = displayId;
        setId(displayId);
    }

    /**
     * Descriptions for DNA component sequences.
     *
     * For example, pBAD, B0015, BioBrick Scar, Insertion Element, "Craig Venter's name".
     * @return 0 or more <code>SequenceFeatures</code>[s] that are in this Library
     */
    public Collection<SequenceFeature> getFeatures() {
        return feature;
    }

    /**
     * Defined DNA segment for engineering biological systems, which belongs to
     * this Library.
     *
     * Any one of the following, standard biological parts, BioBricks, oligo components,
     * vector plasmids, genomes, or any other DNA segment of interest as a building
     * block of biological systems.
     * @param feature
     */
    void addFeature(SequenceFeature feature) {
        if (!getFeatures().contains(feature)) {
            getFeatures().add(feature);
        }
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
     * @param id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Recognizable human identifier, it is often ambiguous.(eg. Mike's Arabidopsis Project A;
     * Sleight, et al. (2010) J.Bioeng; BBF RFC 10 features; Bookmarked Parts).
     * @return its name, commonly used to refer to this Library
     */
    public String getName() {
        return name;
    }

    /**
     * Common name of Library should confer what is contained in the Library.
     *(eg. Mike's Arabidopsis Project A;
     * Sleight, et al. (2010) J.Bioeng; BBF RFC 10 features; Bookmarked Parts).
     * @param name commonly used to refer to this Library (eg. Project A)
     */
    public void setName(String name) {
        this.name = name;
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
        final Library other = (Library) obj;
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
            if (this.component != other.component && (this.component == null || !this.component.equals(other.component))) {
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
