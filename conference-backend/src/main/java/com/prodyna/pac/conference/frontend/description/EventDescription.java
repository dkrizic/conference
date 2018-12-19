package com.prodyna.pac.conference.frontend.description;

import com.prodyna.pac.conference.frontend.entity.Event;
import com.prodyna.pac.conference.frontend.entity.Location;
import com.prodyna.pac.conference.frontend.entity.Slot;
import org.springframework.data.rest.core.config.Projection;

import java.util.Set;

@Projection(name="detail",types={Event.class})
public interface EventDescription {

    String getName();

    String getStartDate();

    String getEndDate();

    Location getLocation();

    Set<Slot> getSlots();

}
