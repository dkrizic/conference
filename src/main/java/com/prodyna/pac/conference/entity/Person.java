package com.prodyna.pac.conference.entity;

import lombok.*;
import org.neo4j.ogm.annotation.*;

import java.util.Set;

@NodeEntity
public class Person {

    @Id
    @GeneratedValue
    private Long _id;

    private String id;

    @Index(unique = true)
    private String name;

    @Relationship(type="BY_PERSON", direction=Relationship.INCOMING)
    private Set<Talk> talks;

    public String getId() {
        return id;
    }

    public Long get_id() {
        return _id;
    }

    public void set_id(Long _id) {
        this._id = _id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Talk> getTalks() {
        return talks;
    }

    public void setTalks(Set<Talk> talks) {
        this.talks = talks;
    }

}
