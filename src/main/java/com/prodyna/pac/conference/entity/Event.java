package com.prodyna.pac.conference.entity;

import lombok.*;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.hateoas.core.Relation;

import java.util.Date;
import java.util.Set;

@NodeEntity
@Getter
@Setter
@ToString(exclude = {"slots"})
public class Event {

    @Id
    @GeneratedValue
    private Long _id;

    @Relationship(type="IN_LOCATION")
    private Location location;

    private String name;

    private String startDate;

    private String endDate;

    @Relationship(type="ON_EVENT",direction=Relationship.INCOMING)
    private Set<Slot> slots;

}
