package com.prodyna.pac.conference.frontend.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import uk.co.blackpepper.bowman.annotation.LinkedResource;
import uk.co.blackpepper.bowman.annotation.RemoteResource;

import java.util.Set;

@Data
@RemoteResource("/api/topics")
public class Topic extends NumericEntity {

    private String id;
    private String name;

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Set<Topic> parents;

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Set<Topic> children;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Set<Talk> talks;

    @LinkedResource
    public Set<Topic> getParents() {
        return parents;
    }

    @LinkedResource
    public Set<Topic> getChildren() {
        return children;
    }

    @LinkedResource
    public Set<Talk> getTalks() {
        return talks;
    }
}
