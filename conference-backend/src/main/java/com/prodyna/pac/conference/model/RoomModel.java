package com.prodyna.pac.conference.model;

import com.prodyna.pac.conference.entity.Room;
import com.prodyna.pac.conference.entity.Talk;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

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
