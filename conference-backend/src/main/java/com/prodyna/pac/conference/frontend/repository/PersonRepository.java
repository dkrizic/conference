package com.prodyna.pac.conference.frontend.repository;

import com.prodyna.pac.conference.frontend.entity.Person;
import io.micrometer.core.annotation.Timed;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

@Repository
@RepositoryRestResource(path="/persons")
@Timed
public interface PersonRepository extends Neo4jRepository<Person,Long> {
    // using default

    @RestResource(exported = true)
    @Query("match (p:Person {id:{id}}) return p")
    Person findByOwnId( @Param("id") String id );

    @RestResource
    Page<Person> findAll( Pageable p );

    @RestResource
    Person findByName(@Param("name") String name );

}
