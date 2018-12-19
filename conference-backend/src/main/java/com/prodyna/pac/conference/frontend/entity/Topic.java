package com.prodyna.pac.conference.frontend.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import java.util.Set;

@Data
@NodeEntity
public class Topic {

    @Id
    @GeneratedValue
    private Long _id;

    private String id;

    private String name;

    @Relationship(type="IS_ABOUT", direction = Relationship.INCOMING)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Set<Talk> talks;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @Relationship(type="PART_OF", direction = Relationship.OUTGOING)
    private Set<Topic> parents;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @Relationship(type="PART_OF", direction = Relationship.INCOMING)
    private Set<Topic> children;
}
