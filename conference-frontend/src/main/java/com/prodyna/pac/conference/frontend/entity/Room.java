package com.prodyna.pac.conference.frontend.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import uk.co.blackpepper.bowman.annotation.LinkedResource;
import uk.co.blackpepper.bowman.annotation.RemoteResource;

import java.util.Set;

@Data
@RemoteResource("/api/rooms")
@EqualsAndHashCode(callSuper = true)
public class Room extends NumericEntity {

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Location location;

    public String name;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Set<Slot> slots;

    @LinkedResource
    public Set<Slot> getSlots() {
        return slots;
    }

}
