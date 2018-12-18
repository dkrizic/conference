package com.prodyna.pac.conference.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.apache.commons.lang3.builder.HashCodeExclude;
import uk.co.blackpepper.bowman.annotation.LinkedResource;
import uk.co.blackpepper.bowman.annotation.RemoteResource;
import uk.co.blackpepper.bowman.annotation.ResourceId;

import java.net.URI;
import java.util.Set;

@Data
@RemoteResource("/api/talks")
public class Talk {

    private URI _id;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Set<Person> persons;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
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
