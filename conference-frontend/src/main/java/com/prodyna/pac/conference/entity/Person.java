package com.prodyna.pac.conference.entity;

import lombok.*;
import org.neo4j.ogm.annotation.*;

import java.util.Set;

@Data
@ToString(exclude={"talks"})
public class Person {

    private Long _id;

    private String id;

    private String name;

    private Set<Talk> talks;

}
