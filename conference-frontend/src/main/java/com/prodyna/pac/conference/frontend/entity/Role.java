package com.prodyna.pac.conference.frontend.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import uk.co.blackpepper.bowman.annotation.LinkedResource;
import uk.co.blackpepper.bowman.annotation.RemoteResource;

import java.util.Set;

@Data
@RemoteResource("/api/roles")
@EqualsAndHashCode(callSuper = true)
public class Role extends NumericEntity {

    private String id;

    private String name;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Set<Person> persons;

    @LinkedResource
    public Set<Person> getPersons() {
        return persons;
    }

}
