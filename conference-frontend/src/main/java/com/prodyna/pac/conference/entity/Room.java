package com.prodyna.pac.conference.entity;

import lombok.Data;
import lombok.ToString;
import uk.co.blackpepper.bowman.annotation.LinkedResource;
import uk.co.blackpepper.bowman.annotation.ResourceId;

import java.net.URI;
import java.util.Set;

@Data
@ToString(exclude={"location","slots"})
public class Room {

    private URI _id;

    private Location location;

    public String name;

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
