package com.prodyna.pac.conference.entity;

import lombok.*;
import org.apache.commons.lang3.builder.HashCodeExclude;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.hateoas.core.Relation;

import java.util.Date;
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
