package com.prodyna.pac.conference.entity;

import lombok.Data;
import lombok.ToString;

import java.util.Set;

@Data
@ToString(exclude={"persons","slots"})
public class Talk {

    private Long _id;

    private Set<Person> persons;

    private Set<Slot> slots;

    public String title;

}
