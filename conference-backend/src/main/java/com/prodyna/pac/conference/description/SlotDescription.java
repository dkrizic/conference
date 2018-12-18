package com.prodyna.pac.conference.description;

import com.prodyna.pac.conference.entity.Event;
import com.prodyna.pac.conference.entity.Room;
import com.prodyna.pac.conference.entity.Slot;
import com.prodyna.pac.conference.entity.Talk;
import org.springframework.data.rest.core.config.Projection;

@Projection(name="detail",types={Slot.class})
public interface SlotDescription {

    String getDatetime();

    Room getRoom();

    Talk getTalk();

}
