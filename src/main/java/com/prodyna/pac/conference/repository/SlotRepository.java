package com.prodyna.pac.conference.repository;

import com.prodyna.pac.conference.description.SlotDescription;
import com.prodyna.pac.conference.entity.Slot;
import org.springframework.boot.actuate.endpoint.web.annotation.RestControllerEndpoint;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RepositoryRestResource(path="/slots")
public interface SlotRepository extends Neo4jRepository<Slot,Long> {
    // ok

    @Query(value="match (e:Event)--(s:Slot) where id(e) = {eventId} return distinct( s.datetime ) order by s.datetime",
        countQuery="match (e:Event)--(s:Slot) where id(e) = {eventId} return count(distinct( s.datetime ))")
    Page<String> findUniqueSlotsForEvent(@Param("eventId") long eventId, Pageable p);

    @Query(value="match (r:Room)--(s:Slot) where id(r) = {roomId} and s.datetime = {datetime} return s")
    Slot findByDatetimeAndRoom( @Param("datetime") String datetime, @Param("roomId") long roomId );

}
