package com.prodyna.pac.conference.repository;

import com.prodyna.pac.conference.entity.Talk;
import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface TalkRepository extends Neo4jRepository<Talk,Long> {
    // ok
}
