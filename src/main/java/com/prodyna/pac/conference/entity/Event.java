package com.prodyna.pac.conference.entity;

import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;

import java.util.Date;

@NodeEntity
public class Event {

    @Id
    @GeneratedValue
    public Long _id;

    public Location location;

    public String name;

    public Date startDate;

    public long daysDuration;

}
