package com.prodyna.pac.conference.model;

import com.prodyna.pac.conference.entity.Person;
import com.prodyna.pac.conference.entity.Room;
import com.prodyna.pac.conference.entity.Slot;
import com.prodyna.pac.conference.entity.Talk;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Data
@NoArgsConstructor
public class SlotModel {

    private String datetime;
    private List<RoomModel> roomModels = new ArrayList<>();

    public SlotModel(String datetime) {
        this.datetime = datetime;
    }
}
