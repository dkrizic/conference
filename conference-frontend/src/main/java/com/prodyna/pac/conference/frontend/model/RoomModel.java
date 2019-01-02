package com.prodyna.pac.conference.frontend.model;

import com.prodyna.pac.conference.frontend.entity.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

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
