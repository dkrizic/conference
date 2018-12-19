package com.prodyna.pac.conference.frontend.entity;

import lombok.*;
import uk.co.blackpepper.bowman.annotation.LinkedResource;
import uk.co.blackpepper.bowman.annotation.RemoteResource;

import java.util.Set;

@Data
@RemoteResource("/api/events")
public class Event extends NumericEntity {

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Location location;

    private String name;

    private String startDate;

    private String endDate;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Set<Slot> slots;

    @LinkedResource
    public Set<Slot> getSlots() {
        return slots;
    }

    @LinkedResource
    public Location getLocation() {
        return location;
    }


}
