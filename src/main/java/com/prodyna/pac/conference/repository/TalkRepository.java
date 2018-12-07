package com.prodyna.pac.conference.repository;

import com.prodyna.pac.conference.entity.Talk;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@Repository
@RepositoryRestResource(path="/talks")
public interface TalkRepository extends Neo4jRepository<Talk,Long> {
    // ok
}
