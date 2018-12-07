package com.prodyna.pac.conference.entity;

import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.Index;
import org.neo4j.ogm.annotation.NodeEntity;

import java.util.Set;

@NodeEntity
public class Location {

    @Id
    @GeneratedValue
    public Long _id;

    @Index(unique = true)
    public String name;

    public Set<Room> rooms;

}
