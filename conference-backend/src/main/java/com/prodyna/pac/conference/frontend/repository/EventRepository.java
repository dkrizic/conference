package com.prodyna.pac.conference.frontend.repository;

import com.prodyna.pac.conference.frontend.description.EventDescription;
import com.prodyna.pac.conference.frontend.entity.Event;
import com.prodyna.pac.conference.frontend.entity.Talk;
import io.micrometer.core.annotation.Timed;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

@Repository
@RepositoryRestResource(path="/events",excerptProjection = EventDescription.class)
@Timed
public interface EventRepository extends Neo4jRepository<Event,Long> {

    @Override
    @Timed("conference.backend.events.findall")
    Iterable<Event> findAll();

    @Timed("conference.backend.events.findtalksforevent")
    @RestResource(path="talks",rel = "talks")
    @Query(value = "match (e:Event)--(s:Slot)--(t:Talk) where id(e) = {eventId} return t",countQuery = "match (e:Event)--(s:Slot)--(t:Talk) where id(e) = {eventId} return count(t)")
    Page<Talk> findTalksForEvent(@Param("eventId") int eventId, Pageable p );

}
