package com.prodyna.pac.conference.frontend.repository;

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
@RepositoryRestResource(path="/talks")
@Timed
public interface TalkRepository extends Neo4jRepository<Talk,Long> {

    @RestResource
    @Query("match (t:Talk)--(s:Slot)--(e:Event) where id(t) = {talkId} return e")
    Page<Event> findEventsForTalk(@Param("talkId") int talkId, Pageable p );

    @RestResource
    @Query("match (e:Event)--(s:Slot)--(t:Talk) where id(e) = {eventId} and id(s) = {slotId} return t")
    Talk findByEventAndSlot(@Param("eventId") Long eventId, @Param("slotId") Long slotId);
}
