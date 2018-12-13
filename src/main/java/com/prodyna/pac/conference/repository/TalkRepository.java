package com.prodyna.pac.conference.repository;

import com.prodyna.pac.conference.description.TalkDescription;
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

@Repository
@RepositoryRestResource(path="/talks")
public interface TalkRepository extends Neo4jRepository<Talk,Long> {

    @RestResource(path="events",rel="events")
    @Query("match (t:Talk)--(s:Slot)--(e:Event) where id(t) = {talkId} return e")
    Page<Event> findEventsForTalk(@Param("talkId") int talkId, Pageable p );

}
