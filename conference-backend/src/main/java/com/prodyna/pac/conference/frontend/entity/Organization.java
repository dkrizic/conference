package com.prodyna.pac.conference.frontend.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.neo4j.ogm.annotation.*;

import java.util.Set;

@Data
@NodeEntity
public class Organization {

    @Id
    @GeneratedValue
    private long _id;

    @Index(unique = true)
    private String id;

    private String name;

    @Relationship(type="WORKS_FOR",direction = Relationship.INCOMING)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Set<Person> persons;
}
