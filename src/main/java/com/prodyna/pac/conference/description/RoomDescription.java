package com.prodyna.pac.conference.description;

import com.prodyna.pac.conference.entity.Location;
import com.prodyna.pac.conference.entity.Room;
import org.springframework.data.rest.core.config.Projection;

@Projection(types={Room.class})
public interface RoomDescription {

    String getName();

    Location getLocation();

}
