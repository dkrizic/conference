package com.prodyna.pac.conference.description;

import com.prodyna.pac.conference.entity.Event;
import com.prodyna.pac.conference.entity.Location;
import com.prodyna.pac.conference.entity.Room;
import org.springframework.data.rest.core.config.Projection;

import java.util.Set;

@Projection(name="detail",types={Location.class})
public interface LocationDescription {

    String getName();

    Set<RoomDescription> getRooms();

    Set<EventDescription> getEvents();

}
