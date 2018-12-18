package com.prodyna.pac.conference.repository;

import com.prodyna.pac.conference.description.SlotDescription;
import com.prodyna.pac.conference.entity.Slot;
import com.prodyna.pac.conference.model.DatetimeModel;
import org.springframework.boot.actuate.endpoint.web.annotation.RestControllerEndpoint;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.Description;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RepositoryRestResource(path="/slots", excerptProjection = SlotDescription.class)
public interface SlotRepository extends Neo4jRepository<Slot,Long> {

    @RestResource(path="byDatetimeAndRoom",rel="byDatetimeAndRoom", description = @Description("Find slots for datetime and room"))
    @Query(value="match (r:Room)--(s:Slot) where id(r) = {roomId} and s.datetime = {datetime} return s")
    Slot findByDatetimeAndRoom( @Param("datetime") String datetime, @Param("roomId") long roomId );

}
