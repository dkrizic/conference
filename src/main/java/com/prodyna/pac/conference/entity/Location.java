package com.prodyna.pac.conference.entity;

import lombok.*;
import org.neo4j.ogm.annotation.*;
import org.springframework.hateoas.core.Relation;

import java.util.Set;

@NodeEntity
public class Location {

    @Id
    @GeneratedValue
    private Long _id;

    @Index(unique = true)
    private String name;

    @Relationship(type="IN_LOCATION", direction=Relationship.INCOMING)
    private Set<Room> rooms;

    @Relationship(type="IN_LOCATION", direction = Relationship.INCOMING)
    private Set<Event> events;

    public Long get_id() {
        return _id;
    }

    public void set_id(Long _id) {
        this._id = _id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Room> getRooms() {
        return rooms;
    }

    public void setRooms(Set<Room> rooms) {
        this.rooms = rooms;
    }

    public Set<Event> getEvents() {
        return events;
    }

    public void setEvents(Set<Event> events) {
        this.events = events;
    }
}
