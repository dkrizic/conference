package com.prodyna.pac.conference.frontend.repository;

import com.prodyna.pac.conference.frontend.description.SlotDescription;
import com.prodyna.pac.conference.frontend.entity.Slot;
import io.micrometer.core.annotation.Timed;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.Description;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RepositoryRestResource(path="slots", excerptProjection = SlotDescription.class)
@Timed
public interface SlotRepository extends Neo4jRepository<Slot,Long> {

    @RestResource(path="byDatetimeAndRoom",rel="byDatetimeAndRoom", description = @Description("Find slots for datetime and room"))
    @Query(value="match (r:Room)--(s:Slot) where id(r) = {roomId} and s.datetime = {datetime} return s")
    Slot findByDatetimeAndRoom( @Param("datetime") String datetime, @Param("roomId") long roomId );

}
