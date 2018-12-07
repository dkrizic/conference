package com.prodyna.pac.conference.entity;

import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.Index;
import org.neo4j.ogm.annotation.NodeEntity;

@NodeEntity
public class Person {

    @Id
    @GeneratedValue
    public Long _id;

    public String id;

    @Index(unique = true)
    public String name;

}
