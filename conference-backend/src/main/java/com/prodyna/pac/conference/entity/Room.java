package com.prodyna.pac.conference.entity;

import lombok.*;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;
import org.springframework.hateoas.core.Relation;

import java.util.Set;

@NodeEntity
@Data
public class Room {

    @Id
    @GeneratedValue
    private Long _id;

    @Relationship(type="IN_LOCATION")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Location location;

    private String name;

    @Relationship(type="IN_ROOM",direction = Relationship.INCOMING)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Set<Slot> slots;
}
