package com.prodyna.pac.conference.frontend.entity;

import lombok.*;
import uk.co.blackpepper.bowman.annotation.LinkedResource;
import uk.co.blackpepper.bowman.annotation.RemoteResource;

import java.util.Set;

@Data
@EqualsAndHashCode(callSuper=true)
@RemoteResource("/api/locations")
public class Location extends NumericEntity {

    private String name;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Set<Room> rooms;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Set<Event> events;

    @LinkedResource
    public Set<Room> getRooms() {
        return rooms;
    }

    @LinkedResource
    public Set<Event> getEvents() {
        return events;
    }
}
