package com.prodyna.pac.conference.entity;

import lombok.*;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;
import org.springframework.hateoas.core.Relation;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@NodeEntity
public class Room {

    @Id
    @GeneratedValue
    public Long _id;

    @Relationship(type="IN_LOCATION")
    public Location location;

    public String name;

    @Relationship(type="IN_ROOM",direction = Relationship.INCOMING)
    public Set<Slot> slots;

}
