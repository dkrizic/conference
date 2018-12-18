package com.prodyna.pac.conference.entity;

import lombok.Data;
import lombok.ToString;
import uk.co.blackpepper.bowman.annotation.LinkedResource;
import uk.co.blackpepper.bowman.annotation.ResourceId;

import java.net.URI;
import java.util.Set;

@Data
@ToString(exclude={"talks"})
public class Person {

    private URI _id;

    private String id;

    private String name;

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
