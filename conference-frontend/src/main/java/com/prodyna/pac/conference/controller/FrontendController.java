package com.prodyna.pac.conference.controller;

import com.prodyna.pac.conference.client.EventClient;
import com.prodyna.pac.conference.entity.Event;
import com.prodyna.pac.conference.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import uk.co.blackpepper.bowman.Client;
import uk.co.blackpepper.bowman.ClientFactory;
import uk.co.blackpepper.bowman.Configuration;

import java.util.Map;

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

        for( Event event : events ) {
            System.out.println( event.getName() );
        }

        model.put("title", "Test");
        model.put("message", "" + events.iterator().next().getName() );
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
//
//    @GetMapping("/events/{eventId}")
//    public String event(Map<String,Object> model, @PathVariable Long eventId ) {
//
//        Event event = eventRepository.findById( eventId ).get();
//        model.put("event", event );

//
//        Location location = locationRepository.findByEventId( eventId );
//        model.put("location", location );
//
//        Page<Room> rooms = roomRepository.findRoomsForLocation(location.get_id(), new PageRequest(0,100));
//        model.put("rooms", rooms.getContent() );
//
//        Page<String> uniqueSlots = slotRepository.findUniqueSlotsForEvent( event.get_id(), new PageRequest( 0, 100 ));
//
//        List<SlotModel> slotModels = new ArrayList<>();
//        for( String datetime : uniqueSlots ) {
//            SlotModel slotModel = new SlotModel( datetime );
//            slotModels.add( slotModel );
//
//            for( Room room : rooms ) {
//                RoomModel roomModel = new RoomModel( room, null );
//                slotModel.getRoomModels().add( roomModel );
//                Slot slot = slotRepository.findByDatetimeAndRoom( datetime, room.get_id() );
//                if( slot != null ) {
//                    Talk talk = talkRepository.findByEventAndSlot( event.get_id(), slot.get_id() );
//                    roomModel.setTalk( talk );
//                }
//            }
//        }
//
//        model.put("slots", slotModels );
//
//        return "event";
//    }
//
//    @GetMapping("/talks/{talkId}")
//    public String talk( Map<String,Object> model, @PathVariable Long talkId ) {
//
//        Talk talk = talkRepository.findById( talkId ).get();
//        model.put( "title", talk.getTitle() );
//        model.put( "talk", talk );
//        return "talk";
//
//    }
//

}
