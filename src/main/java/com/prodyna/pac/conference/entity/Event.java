package com.prodyna.pac.conference.entity;

import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;
import org.springframework.hateoas.core.Relation;

import java.util.Date;

@NodeEntity
public class Event {

    @Id
    @GeneratedValue
    public Long _id;

    @Relationship(type="IN_LOCATION")
    public Location location;

    public String name;

    public Date startDate;

    public long daysDuration;

}
