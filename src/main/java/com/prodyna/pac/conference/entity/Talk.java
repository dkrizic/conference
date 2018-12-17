package com.prodyna.pac.conference.entity;

import lombok.*;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import java.util.Set;

@Data
@NodeEntity
@ToString(exclude={"persons","slots"})
public class Talk {

    @Id
    @GeneratedValue
    private Long _id;

    @Relationship(type = "BY_PERSON")
    private Set<Person> persons;

    @Relationship(type = "IN_SLOT")
    private Set<Slot> slots;

    public String title;

}
