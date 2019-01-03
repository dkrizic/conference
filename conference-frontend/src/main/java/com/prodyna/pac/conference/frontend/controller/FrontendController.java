package com.prodyna.pac.conference.frontend.controller;

import com.prodyna.pac.conference.frontend.converter.URIConverter;
import com.prodyna.pac.conference.frontend.entity.*;
import com.prodyna.pac.conference.frontend.model.EventModel;
import com.prodyna.pac.conference.frontend.model.RoomModel;
import com.prodyna.pac.conference.frontend.model.SlotModel;
import io.micrometer.core.annotation.Timed;
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
@Timed
public class FrontendController {

    @Autowired
    private Client<Event> eventClient;

    @Autowired
    private Client<EventSearch> eventSearchClient;

    @Autowired
    private Client<Room> roomClient;

    @Autowired
    private Client<Location> locationClient;

    @Autowired
    private Client<Talk> talkClient;

    @Autowired
    private Client<Topic> topicClient;

    @Autowired
    private Client<RoomSearch> roomSearchClient;

    @Autowired
    private Client<SlotSearch> slotSearchClient;

    @Autowired
    private Client<Person> personClient;

    @Autowired
    private Client<TopicSearch> topicSearchClient;

    @Autowired
    private URIConverter uriConverter;

    @GetMapping("/test")
    @Timed("conference.frontend.test")
    public String test( Map<String,Object> model ) {
        Iterable<Event> events = eventClient.getAll();
        model.put("title", "Test");
        model.put("message", "" + events );
        return "test";
    }

    @GetMapping("/events")
    @Timed("conference.frontend.events")
    public String events(Map<String,Object> model ) {
        List<EventModel> eventModels = new ArrayList<EventModel>();

        Iterable<Event> events = eventClient.getAll();
        for( Event event : events ) {
            log.info("Found event {}", event );
            int talkCount = 0; // eventSearchClient.get().talkCount( event.numericId() );
            Set<Language> languages = eventSearchClient.get().languages( event.numericId() );
            Set<Topic> topics = eventSearchClient.get().topics( event.numericId() );
            EventModel eventModel = new EventModel( event, talkCount, languages, topics );
            eventModels.add( eventModel );
        }

        model.put("title", "Events");
        model.put("eventModels", eventModels );
        return "events";
    }

    @GetMapping("/events/{eventId}")
    @Timed("conference.frontend.event")
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
            if( ! datetimes.contains( slot.getDatetime() ) ) {
                datetimes.add( slot.getDatetime());
            }
        }

        List<Room> rooms = roomSearchClient.get().findRoomsForLocation( location.numericId() );
        model.put("rooms", rooms );

        List<SlotModel> slotModels = new ArrayList<>();
        for( String datetime : datetimes ) {
            SlotModel slotModel = new SlotModel( datetime );
            slotModels.add( slotModel );

           for( Room room : rooms ) {
               RoomModel roomModel = new RoomModel( room, null );
                slotModel.getRoomModels().add( roomModel );
                log.info("Searching for slots for datetime {} and room {}", datetime, room.numericId() );
                Slot slot = slotSearchClient.get().byDatetimeAndRoom( datetime, room.numericId() );
                log.info("Found slot {}", slot );
                if( slot != null ) {
                    roomModel.setTalk( slot.getTalk() );
                }
            }
        }

        model.put("slots", slotModels );
        model.put("title", event.getName() );
        return "event";
    }

    @GetMapping("/talks/{talkId}")
    @Timed("conference.frontend.talk")
    public String talk( Map<String,Object> model, @PathVariable Long talkId ) {
        URI uri = uriConverter.convertToURI( Talk.class, talkId );
        Talk talk = talkClient.get( uri );
        log.info("Found talk {}", talk);
        model.put( "title", talk.getTitle() );
        model.put( "talk", talk );
        return "talk";
    }

    @Timed("conference.frontend.person")
    @GetMapping("/persons/{personId}")
    public String person( Map<String,Object> model, @PathVariable("personId") long personId ) {
        URI uri = uriConverter.convertToURI( Person.class, personId );
        Person person = personClient.get( uri );
        model.put( "title", person.getName() );
        model.put( "person", person );
        return "person";
    }

    @Timed("conference.frontend.talks")
    @GetMapping("/talks")
    public String talks( Map<String,Object> model ) {
        model.put( "title", "Talks" );
        model.put( "talks", talkClient.getAll() );
        return "talks";
    }

    @Timed("conference.frontend.locations")
    @GetMapping("/locations")
    public String locations( Map<String,Object> model ) {
        model.put( "title", "Locations" );
        model.put( "locations", locationClient.getAll() );
        return "locations";
    }

    @Timed("conference.frontend.persons")
    @GetMapping("/persons")
    public String persons( Map<String,Object> model ) {
        model.put( "persons", personClient.getAll() );
        model.put( "title", "Persons" );
        return "persons";
    }

    @Timed("conference.frontend.topics")
    @GetMapping("/topics")
    public String topics( Map<String,Object> model ) {
        model.put( "toplevel", topicSearchClient.get().toplevel() );
        model.put( "topicSearch", topicSearchClient.get() );
        model.put( "title", "Topics" );
        return "topics";
    }

    @Timed("conference.frontend.topic")
    @GetMapping("/topics/{topicId}")
    public String topic( Map<String,Object> model, @PathVariable("topicId") long topicId ) {
        URI uri = uriConverter.convertToURI( Topic.class, topicId );
        Topic topic = topicClient.get( uri );
        model.put( "title",  topic.getName() );
        model.put( "topic", topic );
        return "topic";
    }

}
