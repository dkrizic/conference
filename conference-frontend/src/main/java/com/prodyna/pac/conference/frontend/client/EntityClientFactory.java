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
    public Client<Event> createEventClient() {
        return clientFactory.create( Event.class );
    }

    @Bean
    public Client<Location> createLocationClient() {
        return clientFactory.create( Location.class );
    }

    @Bean
    public Client<Room> createRoomClient() {
        return clientFactory.create( Room.class );
    }

    @Bean
    public Client<Talk> createTalkClient() {
        return clientFactory.create( Talk.class );
    }

    @Bean
    public Client<Person> createPersonClient() {
        return clientFactory.create( Person.class );
    }

    @Bean
    public Client<RoomSearch> createRoomSearchClient() {
        return clientFactory.create( RoomSearch.class );
    }

    @Bean
    public Client<SlotSearch> createSlotSearchClient() {
        return clientFactory.create( SlotSearch.class );
    }

    @Bean
    public Client<TalkSearch> createTalkSearchClient() { return clientFactory.create( TalkSearch.class ); }

    @Bean
    public Client<EventSearch> createEventSearchClient() { return clientFactory.create( EventSearch.class ); }

    @Bean
    public Client<Topic> createTopicClient() { return clientFactory.create( Topic.class ); }

    @Bean
    public Client<TopicSearch> createTopicSearchClient() { return clientFactory.create( TopicSearch.class ); }
}
