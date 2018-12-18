package com.prodyna.pac.conference.controller;

import com.prodyna.pac.conference.client.EventClient;
import com.prodyna.pac.conference.entity.*;
import com.prodyna.pac.conference.model.RoomModel;
import com.prodyna.pac.conference.model.SlotModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import uk.co.blackpepper.bowman.Client;
import uk.co.blackpepper.bowman.ClientFactory;
import uk.co.blackpepper.bowman.Configuration;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Controller
public class FrontendController {

    @Value("${conference.backend.url}")
    private String backendUrl;

    @GetMapping("/test")
    public String test( Map<String,Object> model ) {
        ClientFactory factory = Configuration.builder().setBaseUri(backendUrl).build()
                .buildClientFactory();
        Client<Event> eventClient = factory.create(Event.class);
        Iterable<Event> events = eventClient.getAll();
        model.put("title", "Test");
        model.put("message", "" + events );
        return "test";
    }

    @GetMapping("/events")
    public String events(Map<String,Object> model ) {
        ClientFactory factory = Configuration.builder().setBaseUri(backendUrl).build()
                .buildClientFactory();
        Client<Event> eventClient = factory.create(Event.class);
        Iterable<Event> events = eventClient.getAll();
        model.put("title", "Events");
        model.put("events", events );
        return "events";
    }

    @GetMapping("/events/{eventId}")
    public String event(Map<String,Object> model, @PathVariable Long eventId ) {
        ClientFactory factory = Configuration.builder().setBaseUri(backendUrl).build()
                .buildClientFactory();
        Client<Event> eventClient = factory.create(Event.class);
        Client<Location> locationClient = factory.create(Location.class);
        Client<Room> roomClient = factory.create(Room.class);

        // TODO: Get real event
        Event event;
        try {
            String url = backendUrl + "/api/events/" + eventId;
            System.out.println("url=" + url );
            event = eventClient.get(new URI( url ));
        } catch ( Exception e ) {
            throw new RuntimeException( e );
        }
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
        ClientFactory factory = Configuration.builder().setBaseUri(backendUrl).build()
                .buildClientFactory();
        Client<Talk> talkClient = factory.create(Talk.class);

        Talk talk = null;
        try {
            talk = talkClient.get( new URI(backendUrl + "/api/talks/" + talkId ));
        } catch (URISyntaxException e) {
            throw new RuntimeException( e );
        }
        System.out.println(talk);
        model.put( "title", talk.getTitle() );
        model.put( "talk", talk );
        return "talk";

    }

}
