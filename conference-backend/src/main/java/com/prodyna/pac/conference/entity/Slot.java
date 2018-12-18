package com.prodyna.pac.conference.entity;

import lombok.*;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;
import org.neo4j.ogm.annotation.typeconversion.DateLong;
import org.springframework.hateoas.core.Relation;


import java.util.Date;

@NodeEntity
@Data
public class Slot {

    @Id
    @GeneratedValue
    private Long _id;

    @Relationship(type = "ON_EVENT")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Event event;

    @Relationship(type = "IN_ROOM")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Room room;

    @Relationship(type="IN_SLOT", direction = Relationship.INCOMING)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Talk talk;

    private String datetime;

}
