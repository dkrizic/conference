package com.prodyna.pac.conference.frontend.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
public class SlotModel {

    private String datetime;
    private List<RoomModel> roomModels = new ArrayList<>();

    public SlotModel(String datetime) {
        this.datetime = datetime;
    }
}
