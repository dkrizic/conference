package com.prodyna.pac.conference.repository;

import com.prodyna.pac.conference.description.PersonDescription;
import com.prodyna.pac.conference.entity.Person;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RepositoryRestResource(path="/persons")
public interface PersonRepository extends Neo4jRepository<Person,Long> {
    // using default

    @RestResource(exported = false)
    @Query("match (p:Person) where p.id = {id} return p")
    Person findByOwnId( @Param("id") String id );

    Page<Person> findAll( Pageable p );

    Page<Person> findByName(@Param("name") String name, Pageable p );

}
