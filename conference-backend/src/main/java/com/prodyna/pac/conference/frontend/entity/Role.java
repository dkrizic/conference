package com.prodyna.pac.conference.frontend.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.neo4j.ogm.annotation.*;

import java.util.Set;

@Data
@NodeEntity
public class Role {

    @Id
    @GeneratedValue
    private long _id;

    @Index(unique = true)
    private String id;

    @Index(unique = true)
    private String name;

    @Relationship(type="MEMBER_OF",direction = Relationship.INCOMING)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Set<Person> persons;

}
