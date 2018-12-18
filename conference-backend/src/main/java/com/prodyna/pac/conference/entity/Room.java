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
@ToString(exclude={"location","slots"})
public class Room {

    @Id
    @GeneratedValue
    private Long _id;

    @Relationship(type="IN_LOCATION")
    private Location location;

    private String name;

    @Relationship(type="IN_ROOM",direction = Relationship.INCOMING)
    private Set<Slot> slots;
}
