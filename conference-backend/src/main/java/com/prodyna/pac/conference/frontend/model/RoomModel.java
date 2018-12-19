package com.prodyna.pac.conference.frontend.model;

import com.prodyna.pac.conference.frontend.entity.Room;
import com.prodyna.pac.conference.frontend.entity.Talk;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class RoomModel {

    private Room room;
    private Talk talk;

    public RoomModel(Room room, Talk talk) {
        this.room = room;
        this.talk = talk;
    }
}
