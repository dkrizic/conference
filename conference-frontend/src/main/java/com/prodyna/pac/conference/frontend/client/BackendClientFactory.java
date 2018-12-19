package com.prodyna.pac.conference.frontend.client;

import com.prodyna.pac.conference.frontend.entity.Event;
import com.prodyna.pac.conference.frontend.entity.Location;
import com.prodyna.pac.conference.frontend.entity.Room;
import com.prodyna.pac.conference.frontend.entity.Talk;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import uk.co.blackpepper.bowman.Client;
import uk.co.blackpepper.bowman.ClientFactory;
import uk.co.blackpepper.bowman.Configuration;

@Component
public class BackendClientFactory {

    @Value("${conference.backend.url}")
    private String url;

    @Autowired
    private ClientFactory clientFactory;

    @Bean
    public ClientFactory createClientFactory() {
        return Configuration.builder().setBaseUri(url).build()
                .buildClientFactory();
    }

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

}
