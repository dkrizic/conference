package com.prodyna.pac.conference.entity;

import lombok.Data;
import lombok.ToString;

import java.util.Set;

@Data
@ToString(exclude={"location","slots"})
public class Room {

    private Long _id;

    private Location location;

    public String name;

    private Set<Slot> slots;
}
