package com.prodyna.pac.conference.frontend.description;

import com.prodyna.pac.conference.frontend.entity.Location;
import com.prodyna.pac.conference.frontend.entity.Room;
import org.springframework.data.rest.core.config.Projection;

@Projection(name="detail",types={Room.class})
public interface RoomDescription {

    String getName();

    Location getLocation();

}
