package com.prodyna.pac.conference.frontend.model;

import com.prodyna.pac.conference.frontend.entity.Event;
import com.prodyna.pac.conference.frontend.entity.Language;
import com.prodyna.pac.conference.frontend.entity.Topic;
import lombok.Data;

import java.util.Set;

@Data
public class EventModel {
    private final Event event;
    private final int talkCount;
    private final Set<Language> languages;
    private final Set<Topic> topics;

    public EventModel(Event event, int talkCount, Set<Language> languages, Set<Topic> topics) {
        this.event = event;
        this.talkCount = talkCount;
        this.languages = languages;
        this.topics = topics;
    }
}
