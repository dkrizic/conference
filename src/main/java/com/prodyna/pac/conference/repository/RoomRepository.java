package com.prodyna.pac.conference.repository;

import com.prodyna.pac.conference.entity.Room;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@Repository
@RepositoryRestResource(path="/rooms")
public interface RoomRepository extends Neo4jRepository<Room,Long> {
}
