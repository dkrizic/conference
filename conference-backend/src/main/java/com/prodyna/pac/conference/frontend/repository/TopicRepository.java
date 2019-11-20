package com.prodyna.pac.conference.frontend.repository;

import com.prodyna.pac.conference.frontend.entity.Event;
import com.prodyna.pac.conference.frontend.entity.Talk;
import com.prodyna.pac.conference.frontend.entity.Topic;
import io.micrometer.core.annotation.Timed;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
@RepositoryRestResource(path="topics")
@Timed
public interface TopicRepository extends Neo4jRepository<Topic,Long> {

    @RestResource(path = "toplevel",rel="toplevel")
    @Query("match (t:Topic) optional match (t)-[r:PART_OF]->(p:Topic) with t, count(r) as rc where rc = 0 return t")
    Set<Topic> findTopLevel(@Param("eventId") Long eventId, @Param("slotId") Long slotId);

    @RestResource(path = "subtalks",rel="subtalks")
    @Query("match (t:Topic)<-[*0..5]-(t2:Topic)<--(ta:Talk) where id(t) = {topicId} return ta")
    Set<Talk> findSubTalks(@Param("topicId") Long topicId);

}
