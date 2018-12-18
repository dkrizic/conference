package com.prodyna.pac.conference.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import uk.co.blackpepper.bowman.annotation.LinkedResource;
import uk.co.blackpepper.bowman.annotation.ResourceId;

import java.net.URI;
import java.util.Set;

@Getter
@Setter
@ToString(exclude = {"events"})
public class Location {

    private URI _id;

    private String name;

    private Set<Room> rooms;

    private Set<Event> events;

    @ResourceId
    public URI get_id() {
        return _id;
    }

    @LinkedResource
    public Set<Room> getRooms() {
        return rooms;
    }

    @LinkedResource
    public Set<Event> getEvents() {
        return events;
    }
}
