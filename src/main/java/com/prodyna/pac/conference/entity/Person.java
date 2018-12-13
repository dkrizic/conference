package com.prodyna.pac.conference.entity;

import lombok.*;
import org.neo4j.ogm.annotation.*;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@NodeEntity
public class Person {

    @Id
    @GeneratedValue
    public Long _id;

    public String id;

    @Index(unique = true)
    public String name;

    @Relationship(type="BY_PERSON", direction=Relationship.INCOMING)
    public Set<Talk> talks;

    public String getId() {
        return id;
    }
}
