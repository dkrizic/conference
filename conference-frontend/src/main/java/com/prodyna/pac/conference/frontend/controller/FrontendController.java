package com.prodyna.pac.conference.frontend.controller;

import com.prodyna.pac.conference.frontend.converter.URIConverter;
import com.prodyna.pac.conference.frontend.entity.*;
import com.prodyna.pac.conference.frontend.model.SlotModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import uk.co.blackpepper.bowman.Client;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Controller
@Slf4j
public class FrontendController {

    @Autowired
    private Client<Event> eventClient;

    @Autowired
    private Client<Room> roomClient;

    @Autowired
    private Client<Location> locationClient;

    @Autowired
    private Client<Talk> talkClient;

    @Autowired
    private URIConverter uriConverter;

    @GetMapping("/test")
    public String test( Map<String,Object> model ) {
        Iterable<Event> events = eventClient.getAll();
        model.put("title", "Test");
        model.put("message", "" + events );
        return "test";
    }

    @GetMapping("/events")
    public String events(Map<String,Object> model ) {
        Iterable<Event> events = eventClient.getAll();
        for( Event event : events ) {
            log.info("Found event {}", event );
        }
        model.put("title", "Events");
        model.put("events", events );
        return "events";
    }

    @GetMapping("/events/{eventId}")
    public String event(Map<String,Object> model, @PathVariable Long eventId ) {

        URI uri = uriConverter.convertToURI( Event.class, eventId );
        Event event = eventClient.get( uri );
        model.put("event", event );

        // Get location
        Location location = event.getLocation();
        model.put("location", location );

        // Create list of unique datetimes of all slots
        Set<Slot> slots = event.getSlots();
        List<String> datetimes = new ArrayList<>();
        for( Slot slot : slots ) {
            if( datetimes.contains( slot.getDatetime() ) ) {
                // skip
            } else {
                datetimes.add( slot.getDatetime());
            }
        }

        // Page<Room> rooms = roomRepository.findRoomsForLocation(location.get_id(), new PageRequest(0,100));
        model.put("rooms", new ArrayList<Room>() );

        List<SlotModel> slotModels = new ArrayList<>();
        for( String datetime : datetimes ) {
            SlotModel slotModel = new SlotModel( datetime );
            slotModels.add( slotModel );

//            for( Room room : rooms ) {
//                RoomModel roomModel = new RoomModel( room, null );
//                slotModel.getRoomModels().add( roomModel );
//                Slot slot = slotRepository.findByDatetimeAndRoom( datetime, room.get_id() );
//                if( slot != null ) {
//                    Talk talk = talkRepository.findByEventAndSlot( event.get_id(), slot.get_id() );
//                    roomModel.setTalk( talk );
//                }
//            }
        }

        model.put("slots", slotModels );

        return "event";
    }

    @GetMapping("/talks/{talkId}")
    public String talk( Map<String,Object> model, @PathVariable Long talkId ) {
        URI uri = uriConverter.convertToURI( Talk.class, talkId );
        Talk talk = talkClient.get( uri );
        log.info("Found talk {}", talk);
        model.put( "title", talk.getTitle() );
        model.put( "talk", talk );
        return "talk";

    }

}
