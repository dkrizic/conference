package com.prodyna.pac.conference.repository;

import com.prodyna.pac.conference.entity.Event;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@Repository
@RepositoryRestResource(path="/events")
public interface EventRepository extends Neo4jRepository<Event,Long> {

}
