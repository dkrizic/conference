package com.prodyna.pac.conference.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import uk.co.blackpepper.bowman.annotation.LinkedResource;
import uk.co.blackpepper.bowman.annotation.RemoteResource;
import uk.co.blackpepper.bowman.annotation.ResourceId;

import java.net.URI;
import java.util.Set;

@Data
@RemoteResource("/api/persons")
public class Person {

    private URI _id;

    private String id;

    private String name;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Set<Talk> talks;

    @ResourceId
    public URI get_id() {
        return _id;
    }

    @LinkedResource
    public Set<Talk> getTalks() {
        return talks;
    }
}
