package com.prodyna.pac.conference.frontend.entity;

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
public class Person extends AbstractEntity {

    private String id;

    private String name;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Set<Talk> talks;

    @LinkedResource
    public Set<Talk> getTalks() {
        return talks;
    }
}
