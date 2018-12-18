package com.prodyna.pac.conference.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import uk.co.blackpepper.bowman.annotation.LinkedResource;
import uk.co.blackpepper.bowman.annotation.RemoteResource;
import uk.co.blackpepper.bowman.annotation.ResourceId;

import java.net.URI;

@Data
@RemoteResource("/api/slots")
public class Slot {

    private URI _id;

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

    @ResourceId
    public URI get_id() {
        return _id;
    }

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
