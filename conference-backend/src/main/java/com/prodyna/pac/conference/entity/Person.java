package com.prodyna.pac.conference.entity;

import lombok.*;
import org.neo4j.ogm.annotation.*;

import java.util.Set;

@NodeEntity
@Data
@ToString(exclude={"talks"})
public class Person {

    @Id
    @GeneratedValue
    private Long _id;

    private String id;

    @Index(unique = true)
    private String name;

    @Relationship(type="BY_PERSON", direction=Relationship.INCOMING)
    private Set<Talk> talks;

}
