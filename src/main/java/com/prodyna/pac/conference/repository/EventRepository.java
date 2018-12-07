package com.prodyna.pac.conference.repository;

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
@RepositoryRestResource(path="/events")
public interface EventRepository extends Neo4jRepository<Event,Long> {

    @RestResource(path="talks")
    @Query("match (e:Event {id:{eventId}})--(s:Slot)--(t:Talk) return t")
    Page<Set<Talk>> findTalksForEvent(@Param("eventId") String eventId, Pageable p );

}
