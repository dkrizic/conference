package com.prodyna.pac.conference.repository;

import com.prodyna.pac.conference.description.RoomDescription;
import com.prodyna.pac.conference.entity.Room;
import com.prodyna.pac.conference.entity.Slot;
import com.prodyna.pac.conference.entity.Talk;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
@RepositoryRestResource(path="/rooms")
public interface RoomRepository extends Neo4jRepository<Room,Long> {

    @RestResource
    @Query("match (r:Room {id:{roomId}})--(s:Slot)--(t:Talk) return t")
    Page<Talk> findTalks(@Param("roomId") String roomId, Pageable p );

    @RestResource
    @Query(value = "match (l:Location)--(r:Room) where id(l) = {locationId} return r",
            countQuery = "match (l:Location)--(r:Room) where id(l) = {locationId} return count(r)")
    Page<Room> findRoomsForLocation( long locationId, Pageable p );

    @RestResource
    @Query(value="match (e:Event)--(l:Location)--(r:Room)--(s:Slot) where id(e) = {eventId} and id(r) = {roomId} return s order by s.datetime asc",
        countQuery="match (e:Event)--(l:Location)--(r:Room)--(s:Slot) where id(e) = {eventId} and id(r) = {roomId} return count(s)")
    Page<Slot> findSlotsForEventAndRoom(Long eventId, Long roomId, Pageable p);
}
