package com.prodyna.pac.conference.entity;

import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;

import java.util.Set;

@NodeEntity
public class Talk {

    @Id
    @GeneratedValue
    public Long _id;

    public Set<Person> persons;
    public Set<Slot> slots;
    public String title;

}
