package com.prodyna.pac.conference.description;

import com.prodyna.pac.conference.entity.Event;
import com.prodyna.pac.conference.entity.Location;
import com.prodyna.pac.conference.entity.Slot;
import com.prodyna.pac.conference.entity.Talk;
import org.springframework.data.domain.Page;
import org.springframework.data.rest.core.config.Projection;

import java.util.Set;

@Projection(types={Event.class})
public interface EventDescription {

    String getName();

    String getStartDate();

    String getEndDate();

    Location getLocation();

}
