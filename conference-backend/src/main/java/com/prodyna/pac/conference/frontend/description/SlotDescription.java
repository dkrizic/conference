package com.prodyna.pac.conference.frontend.description;

import com.prodyna.pac.conference.frontend.entity.Room;
import com.prodyna.pac.conference.frontend.entity.Slot;
import com.prodyna.pac.conference.frontend.entity.Talk;
import org.springframework.data.rest.core.config.Projection;

@Projection(name="detail",types={Slot.class})
public interface SlotDescription {

    String getDatetime();

    Room getRoom();

    Talk getTalk();

}
