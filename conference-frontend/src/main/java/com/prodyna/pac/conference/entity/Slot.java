package com.prodyna.pac.conference.entity;

import lombok.Data;
import uk.co.blackpepper.bowman.annotation.LinkedResource;
import uk.co.blackpepper.bowman.annotation.ResourceId;

import java.net.URI;

@Data
public class Slot {

    private URI _id;

    private Event event;

    private Room room;

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
