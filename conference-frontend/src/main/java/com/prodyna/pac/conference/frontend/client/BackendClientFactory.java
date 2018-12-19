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


    @Autowired
    private BackendAddress backendAddress;

    @Bean
    public ClientFactory createClientFactory() {
        return Configuration.builder().setBaseUri(backendAddress.getURI()).build()
                .buildClientFactory();
    }

}
