package com.prodyna.pac.conference.frontend.entity;

import lombok.*;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import java.util.Set;

@Data
@NodeEntity
public class Talk {

    @Id
    @GeneratedValue
    private Long _id;

    @Relationship(type = "BY_PERSON")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Set<Person> persons;

    @Relationship(type = "IN_SLOT")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Set<Slot> slots;

    public String title;

}
