package com.prodyna.pac.conference.frontend.client;

import com.prodyna.pac.conference.frontend.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import uk.co.blackpepper.bowman.Client;
import uk.co.blackpepper.bowman.ClientFactory;

@Service
public class EntityClientFactory {

    @Autowired
    private ClientFactory clientFactory;

    @Bean
    public Client<Event> eventClient() {
        return clientFactory.create( Event.class );
    }

    @Bean
    public Client<Location> locationClient() {
        return clientFactory.create( Location.class );
    }

    @Bean
    public Client<Room> roomClient() {
        return clientFactory.create( Room.class );
    }

    @Bean
    public Client<Talk> talkClient() {
        return clientFactory.create( Talk.class );
    }

    @Bean
    public Client<Person> personClient() {
        return clientFactory.create( Person.class );
    }

    @Bean
    public Client<RoomSearch> roomSearchClient() {
        return clientFactory.create( RoomSearch.class );
    }

    @Bean
    public Client<SlotSearch> slotSearchClient() {
        return clientFactory.create( SlotSearch.class );
    }

    @Bean
    public Client<TalkSearch> talkSearchClient() { return clientFactory.create( TalkSearch.class ); }

    @Bean
    public Client<EventSearch> eventSearchClient() { return clientFactory.create( EventSearch.class ); }

    @Bean
    public Client<Topic> topicClient() { return clientFactory.create( Topic.class ); }

    @Bean
    public Client<TopicSearch> topicSearchClient() { return clientFactory.create( TopicSearch.class ); }
}
