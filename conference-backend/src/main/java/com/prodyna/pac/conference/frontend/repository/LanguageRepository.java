package com.prodyna.pac.conference.frontend.repository;

import com.prodyna.pac.conference.frontend.entity.Language;
import com.prodyna.pac.conference.frontend.entity.Talk;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@Repository
@RepositoryRestResource(path="/languages")
public interface LanguageRepository extends Neo4jRepository<Language,Long> {

}
