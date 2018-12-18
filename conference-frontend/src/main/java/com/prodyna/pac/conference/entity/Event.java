package com.prodyna.pac.conference.entity;

import lombok.*;
import uk.co.blackpepper.bowman.annotation.LinkedResource;
import uk.co.blackpepper.bowman.annotation.RemoteResource;
import uk.co.blackpepper.bowman.annotation.ResourceId;

import java.net.URI;
import java.util.Arrays;
import java.util.Set;

@Data
@RemoteResource("/api/events")
public class Event {

    private URI _id;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Location location;

    private String name;

    private String startDate;

    private String endDate;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Set<Slot> slots;

    @ResourceId
    public URI get_id() {
        return _id;
    }

    public void set_id(URI _id) {
        this._id = _id;
    }

    @LinkedResource
    public Set<Slot> getSlots() {
        return slots;
    }

    @LinkedResource
    public Location getLocation() {
        return location;
    }

    public long getNumericId() {
        String[] parts = get_id().getPath().toString().split("/");
        String numeric = parts[ parts.length - 1];
        return Long.parseLong( numeric );
    }

}
