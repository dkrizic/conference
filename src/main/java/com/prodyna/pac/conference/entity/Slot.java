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
    private Event event;

    @Relationship(type = "IN_ROOM")
    private Room room;

    @Relationship(type="IN_SLOT", direction = Relationship.INCOMING)
    private Talk talk;

    private String datetime;

}
