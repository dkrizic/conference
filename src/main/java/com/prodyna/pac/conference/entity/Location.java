package com.prodyna.pac.conference.entity;

import org.neo4j.ogm.annotation.*;
import org.springframework.hateoas.core.Relation;

import java.util.Set;

@NodeEntity
public class Location {

    @Id
    @GeneratedValue
    public Long _id;

    @Index(unique = true)
    public String name;

    @Relationship(type="IN_LOCATION", direction="INCOMING")
    public Set<Room> rooms;

}
