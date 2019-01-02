package com.prodyna.pac.conference.frontend.repository;

import com.prodyna.pac.conference.frontend.description.EventDescription;
import com.prodyna.pac.conference.frontend.entity.Event;
import com.prodyna.pac.conference.frontend.entity.Language;
import com.prodyna.pac.conference.frontend.entity.Talk;
import com.prodyna.pac.conference.frontend.entity.Topic;
import io.micrometer.core.annotation.Timed;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
@RepositoryRestResource(path="/events",excerptProjection = EventDescription.class)
@Timed
public interface EventRepository extends Neo4jRepository<Event,Long> {

    @Override
    @Timed("conference.backend.events.findall")
    Iterable<Event> findAll();

    @Timed("conference.backend.events.talks")
    @RestResource(path="talks",rel = "talks")
    @Query(value = "match (e:Event)--(s:Slot)--(t:Talk) where id(e) = {eventId} return t",countQuery = "match (e:Event)--(s:Slot)--(t:Talk) where id(e) = {eventId} return count(t)")
    Page<Talk> findTalksForEvent(@Param("eventId") long eventId, Pageable p );

    @Query("match (e:Event)--(s:Slot)--(t:Talk) where id(e) = {eventId} return count(t)")
    @RestResource(path="talkCount",rel="talkCount")
    @Timed("conference.backend.events.talkcount")
    int countTalksForEvent(@Param("eventId") long eventId );

    @Timed("conference.backend.events.languages")
    @RestResource(path="languages",rel = "languages")
    @Query("match (e:Event)--(s:Slot)--(t:Talk)--(l:Language) return distinct(l)")
    Set<Language> findLanguagesForEvent(@Param("eventId") long eventId );

    @Timed("conference.backend.events.topics")
    @RestResource(path="topics",rel="topics")
    @Query("match (e:Event)--(s:Slot)--(t:Talk)--(to:Topic) where id(e) = {eventId} return distinct(to)")
    Set<Topic> findTopicsForEvent(@Param("eventId") long eventId );

}
