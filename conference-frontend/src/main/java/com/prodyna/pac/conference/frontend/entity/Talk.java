package com.prodyna.pac.conference.frontend.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import uk.co.blackpepper.bowman.annotation.LinkedResource;
import uk.co.blackpepper.bowman.annotation.RemoteResource;

import java.util.Set;

@Data
@RemoteResource("/api/talks")
public class Talk extends NumericEntity {

    private String title;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Set<Person> persons;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Set<Slot> slots;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Language language;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Set<Topic> topics;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Level level;

    @LinkedResource
    public Set<Person> getPersons() {
        return persons;
    }

    @LinkedResource
    public Set<Slot> getSlots() {
        return slots;
    }

    @LinkedResource
    public Language getLanguage() {
        return language;
    }

    @LinkedResource
    public Set<Topic> getTopics() {
        return topics;
    }

    @LinkedResource
    public Level getLevel() {
        return level;
    }
}
