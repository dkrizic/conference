package com.prodyna.pac.conference.description;

import com.prodyna.pac.conference.entity.Person;
import com.prodyna.pac.conference.entity.Talk;
import org.springframework.data.domain.Page;
import org.springframework.data.rest.core.config.Projection;

import java.util.Set;

@Projection(types={Person.class})
public interface PersonDescription {

    String getName();
    Set<Talk> getTalks();

}
