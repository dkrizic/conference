package com.prodyna.pac.conference.entity;

import lombok.Data;
import lombok.ToString;
import uk.co.blackpepper.bowman.annotation.LinkedResource;
import uk.co.blackpepper.bowman.annotation.ResourceId;

import java.net.URI;
import java.util.Set;

@Data
@ToString(exclude={"persons","slots"})
public class Talk {

    private URI _id;

    private Set<Person> persons;

    private Set<Slot> slots;

    public String title;

    @ResourceId
    public URI get_id() {
        return _id;
    }

    @LinkedResource
    public Set<Person> getPersons() {
        return persons;
    }

    @LinkedResource
    public Set<Slot> getSlots() {
        return slots;
    }
}
