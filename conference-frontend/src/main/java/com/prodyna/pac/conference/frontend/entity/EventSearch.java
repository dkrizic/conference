package com.prodyna.pac.conference.frontend.entity;


import uk.co.blackpepper.bowman.annotation.LinkedResource;
import uk.co.blackpepper.bowman.annotation.RemoteResource;

import java.util.Set;

@RemoteResource("/api/events/search")
public interface EventSearch {

    @LinkedResource
    int talkCount( long eventId );

    @LinkedResource
    Set<Language> languages(long eventId );

    @LinkedResource
    Set<Talk> talks( long eventId );

    @LinkedResource
    Set<Topic> topics(long eventId );
}
