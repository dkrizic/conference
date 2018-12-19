package com.prodyna.pac.conference.frontend.entity;

import uk.co.blackpepper.bowman.annotation.LinkedResource;
import uk.co.blackpepper.bowman.annotation.RemoteResource;

import java.util.List;

@RemoteResource("/api/slots/search")
public interface SlotSearch {

    @LinkedResource
    Slot byDatetimeAndRoom(String datetime, long roomId );

}
