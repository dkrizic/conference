package com.prodyna.pac.conference.entity;

import lombok.Data;

@Data
public class Slot {

    private Long _id;

    private Event event;

    private Room room;

    private Talk talk;

    private String datetime;

}
