package com.prodyna.pac.conference.entity;

import lombok.*;
import org.neo4j.ogm.annotation.*;
import org.springframework.hateoas.core.Relation;

import java.util.Set;

@Getter
@Setter
@ToString(exclude = {"events"})
public class Location {

    private Long _id;

    private String name;

    private Set<Room> rooms;

    private Set<Event> events;

}
