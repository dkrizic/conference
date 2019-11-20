package com.prodyna.pac.conference.frontend.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import uk.co.blackpepper.bowman.annotation.LinkedResource;
import uk.co.blackpepper.bowman.annotation.RemoteResource;

@Data
@RemoteResource("/api/slots")
@EqualsAndHashCode(callSuper = true)
public class Slot extends NumericEntity {

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Event event;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Room room;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Talk talk;

    private String datetime;

    @LinkedResource
    public Event getEvent() {
        return event;
    }

    @LinkedResource
    public Room getRoom() {
        return room;
    }

    @LinkedResource
    public Talk getTalk() {
        return talk;
    }
}
