package com.prodyna.pac.conference.frontend.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import java.util.Set;

@Data
@NodeEntity
public class Language {

    @Id
    @GeneratedValue
    private Long _id;

    private String id;

    private String name;

    @Relationship(value = "IN_LANGUAGE",direction = Relationship.INCOMING)
    private Set<Talk> talks;

}
