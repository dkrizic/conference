package com.prodyna.pac.conference.repository;

import com.prodyna.pac.conference.entity.Location;
import org.springframework.data.domain.Page;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@Repository
@RepositoryRestResource(path="/locations")
public interface LocationRepository extends Neo4jRepository<Location,Long> {

    public Page<Location> findAll();

}
