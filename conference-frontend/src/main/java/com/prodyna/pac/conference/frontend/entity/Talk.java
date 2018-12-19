package com.prodyna.pac.conference.frontend.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import uk.co.blackpepper.bowman.annotation.LinkedResource;
import uk.co.blackpepper.bowman.annotation.RemoteResource;

import java.util.Set;

@Data
@RemoteResource("/api/talks")
public class Talk extends NumericEntity {

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Set<Person> persons;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Set<Slot> slots;

    public String title;

    @LinkedResource
    public Set<Person> getPersons() {
        return persons;
    }

    @LinkedResource
    public Set<Slot> getSlots() {
        return slots;
    }
}
