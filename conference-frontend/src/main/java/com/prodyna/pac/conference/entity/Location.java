package com.prodyna.pac.conference.entity;

import lombok.*;
import uk.co.blackpepper.bowman.annotation.LinkedResource;
import uk.co.blackpepper.bowman.annotation.RemoteResource;
import uk.co.blackpepper.bowman.annotation.ResourceId;

import java.net.URI;
import java.util.Set;

@Data
@RemoteResource("/api/location")
public class Location {

    private URI _id;

    private String name;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Set<Room> rooms;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
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
