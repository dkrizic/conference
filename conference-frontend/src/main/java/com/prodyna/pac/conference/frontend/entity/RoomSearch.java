package com.prodyna.pac.conference.frontend.entity;

import uk.co.blackpepper.bowman.annotation.LinkedResource;
import uk.co.blackpepper.bowman.annotation.RemoteResource;

import java.util.List;

@RemoteResource("/api/rooms/search")
public interface RoomSearch {

    @LinkedResource
    List<Room> findRoomsForLocation(long locationId);

}
