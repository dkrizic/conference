package com.prodyna.pac.conference.frontend.description;

import com.prodyna.pac.conference.frontend.entity.Person;
import com.prodyna.pac.conference.frontend.entity.Slot;
import com.prodyna.pac.conference.frontend.entity.Talk;
import org.springframework.data.rest.core.config.Projection;

import java.util.Set;

@Projection(name="detail",types={Talk.class})
public interface TalkDescription {

    String getTitle();

    Set<Slot> getSlots();

    Set<Person> getPersons();

}
