package com.prodyna.pac.conference.frontend.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import uk.co.blackpepper.bowman.annotation.LinkedResource;
import uk.co.blackpepper.bowman.annotation.RemoteResource;
import uk.co.blackpepper.bowman.annotation.ResourceId;

import java.net.URI;

@Data
@RemoteResource("/api/slots")
public class Slot extends AbstractEntity {

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
