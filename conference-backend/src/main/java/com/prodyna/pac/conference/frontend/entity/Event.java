package com.prodyna.pac.conference.frontend.entity;

import lombok.*;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import java.util.Set;

@Data
@NodeEntity
public class Event {

    @Id
    @GeneratedValue
    private Long _id;

    @Relationship(type="IN_LOCATION")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Location location;

    private String name;

    private String startDate;

    private String endDate;

    @Relationship(type="ON_EVENT",direction=Relationship.INCOMING)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Set<Slot> slots;

}
