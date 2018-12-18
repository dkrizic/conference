package com.prodyna.pac.conference.repository;

import com.prodyna.pac.conference.description.LocationDescription;
import com.prodyna.pac.conference.entity.Location;
import org.springframework.data.domain.Page;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@Repository
@RepositoryRestResource(path="/locations",excerptProjection = LocationDescription.class)
public interface LocationRepository extends Neo4jRepository<Location,Long> {

    public Page<Location> findAll();

    @Query("match (e:Event)--(l:Location) where id(e) = {eventId} return distinct(l)")
    Location findByEventId(Long eventId);
}
