package com.prodyna.pac.conference.entity;

import lombok.*;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@NodeEntity
public class Talk {

    @Id
    @GeneratedValue
    public Long _id;

    @Relationship(type = "BY_PERSON")
    public Set<Person> persons;

    @Relationship(type = "IN_SLOT")
    public Set<Slot> slots;

    public String title;

}
