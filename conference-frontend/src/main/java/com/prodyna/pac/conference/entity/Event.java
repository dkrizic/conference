package com.prodyna.pac.conference.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Set;

@Getter
@Setter
@ToString(exclude = {"slots"})
public class Event {

    private Long _id;

    private Location location;

    private String name;

    private String startDate;

    private String endDate;

    private Set<Slot> slots;

}
