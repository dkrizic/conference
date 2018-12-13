package com.prodyna.pac.conference.repository;

import com.prodyna.pac.conference.description.SlotDescription;
import com.prodyna.pac.conference.entity.Slot;
import org.springframework.boot.actuate.endpoint.web.annotation.RestControllerEndpoint;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RepositoryRestResource(path="/slots",excerptProjection = SlotDescription.class)
public interface SlotRepository extends Neo4jRepository<Slot,Long> {
    // ok
}
