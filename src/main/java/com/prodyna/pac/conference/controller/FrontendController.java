package com.prodyna.pac.conference.controller;

import com.prodyna.pac.conference.description.SlotDescription;
import com.prodyna.pac.conference.entity.*;
import com.prodyna.pac.conference.model.RoomModel;
import com.prodyna.pac.conference.model.SlotModel;
import com.prodyna.pac.conference.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Controller
public class FrontendController {

    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private RoomRepository roomRepository;

    @Autowired
    private SlotRepository slotRepository;

    @Autowired
    private TalkRepository talkRepository;

    @Autowired
    private LocationRepository locationRepository;

    @GetMapping("/frontend/events")
    public String events(Map<String,Object> model ) {
        Iterable<Event> events = eventRepository.findAll();
        model.put("title", "Events");
        model.put("events", events );
        return "events";
    }

    @GetMapping("/frontend/events/{eventId}")
    public String event(Map<String,Object> model, @PathVariable Long eventId ) {

        Event event = eventRepository.findById( eventId ).get();
        model.put("title", event.getName() );
        model.put("event", event );

        Location location = locationRepository.findByEventId( eventId );
        model.put("location", location );

        Page<Room> rooms = roomRepository.findRoomsForLocation(location.get_id(), new PageRequest(0,100));
        model.put("rooms", rooms.getContent() );

        Page<String> uniqueSlots = slotRepository.findUniqueSlotsForEvent( event.get_id(), new PageRequest( 0, 100 ));

        List<SlotModel> slotModels = new ArrayList<>();
        for( String datetime : uniqueSlots ) {
            SlotModel slotModel = new SlotModel( datetime );
            slotModels.add( slotModel );

            for( Room room : rooms ) {
                RoomModel roomModel = new RoomModel( room, null );
                slotModel.getRoomModels().add( roomModel );
                Slot slot = slotRepository.findByDatetimeAndRoom( datetime, room.get_id() );
                if( slot != null ) {
                    Talk talk = talkRepository.findByEventAndSlot( event.get_id(), slot.get_id() );
                    roomModel.setTalk( talk );
                }
            }
        }

        model.put("slots", slotModels );

        return "event";
    }

    @GetMapping("/frontend/talks/{talkId}")
    public String talk( Map<String,Object> model, @PathVariable Long talkId ) {

        Talk talk = talkRepository.findById( talkId ).get();
        model.put( "title", talk.getTitle() );
        model.put( "talk", talk );
        return "talk";

    }


}
