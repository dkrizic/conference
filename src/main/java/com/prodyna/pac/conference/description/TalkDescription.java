package com.prodyna.pac.conference.description;

import com.prodyna.pac.conference.entity.Person;
import com.prodyna.pac.conference.entity.Slot;
import com.prodyna.pac.conference.entity.Talk;
import org.springframework.data.domain.Page;
import org.springframework.data.rest.core.config.Projection;

import java.util.Set;

@Projection(name="detail",types={Talk.class})
public interface TalkDescription {

    String getTitle();

    Set<Slot> getSlots();

    Set<Person> getPersons();

}
