package com.prodyna.pac.conference.entity;

import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;


import java.util.Date;

@NodeEntity
public class Slot {

    @Id
    @GeneratedValue
    public Long _id;

    public Event event;
    public Room room;
    public Date time;

}
