package com.prodyna.pac.conference.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import uk.co.blackpepper.bowman.annotation.LinkedResource;
import uk.co.blackpepper.bowman.annotation.RemoteResource;
import uk.co.blackpepper.bowman.annotation.ResourceId;

import java.net.URI;
import java.util.Set;

@Data
@RemoteResource("/api/rooms")
public class Room {

    private URI _id;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Location location;

    public String name;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Set<Slot> slots;

    @ResourceId
    public URI get_id() {
        return _id;
    }

    @LinkedResource
    public Set<Slot> getSlots() {
        return slots;
    }

}
