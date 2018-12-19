package com.prodyna.pac.conference.frontend.description;

import com.prodyna.pac.conference.frontend.entity.Location;
import org.springframework.data.rest.core.config.Projection;

import java.util.Set;

@Projection(name="detail",types={Location.class})
public interface LocationDescription {

    String getName();

    Set<RoomDescription> getRooms();

    Set<EventDescription> getEvents();

}
