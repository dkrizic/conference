package com.prodyna.pac.conference.frontend.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import uk.co.blackpepper.bowman.annotation.LinkedResource;
import uk.co.blackpepper.bowman.annotation.RemoteResource;

import java.util.Set;

@Data
@RemoteResource("/api/persons")
@EqualsAndHashCode(callSuper = true)
public class Person extends NumericEntity {

    private String id;

    private String name;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Set<Talk> talks;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Set<Role> roles;

    private Organization organization;

    @LinkedResource
    public Set<Talk> getTalks() {
        return talks;
    }

    @LinkedResource
    public Organization getOrganization() {
        return organization;
    }

    @LinkedResource
    public Set<Role> getRoles() { return roles; }
}
