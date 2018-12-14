package com.prodyna.pac.conference.entity;

import lombok.*;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;
import org.neo4j.ogm.annotation.typeconversion.DateLong;
import org.springframework.hateoas.core.Relation;


import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@NodeEntity
public class Slot {

    @Id
    @GeneratedValue
    public Long _id;

    @Relationship(type = "ON_EVENT")
    public Event event;

    @Relationship(type = "IN_ROOM")
    public Room room;

    @Relationship(type="IN_SLOT", direction = Relationship.INCOMING)
    public Talk talk;

    public String datetime;

}
