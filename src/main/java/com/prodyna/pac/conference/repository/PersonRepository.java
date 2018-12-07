package com.prodyna.pac.conference.repository;

import com.prodyna.pac.conference.entity.Person;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RepositoryRestResource(path="/persons")
public interface PersonRepository extends Neo4jRepository<Person,Long> {
    // using default

    List<Person> findAll();

    List<Person> findByName( String name );

}
