package com.prodyna.pac.conference.repository;

import com.prodyna.pac.conference.description.EventDescription;
import com.prodyna.pac.conference.entity.Event;
import com.prodyna.pac.conference.entity.Talk;
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
public interface EventRepository extends Neo4jRepository<Event,Long> {

    @RestResource(path="talks",rel = "talks")
    @Query(value = "match (e:Event)--(s:Slot)--(t:Talk) where id(e) = {eventId} return t",countQuery = "match (e:Event)--(s:Slot)--(t:Talk) where id(e) = {eventId} return count(t)")
    Page<Talk> findTalksForEvent(@Param("eventId") int eventId, Pageable p );

}
