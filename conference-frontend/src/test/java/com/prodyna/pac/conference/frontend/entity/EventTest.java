package com.prodyna.pac.conference.frontend.entity;

import org.junit.Assert;
import org.junit.Test;

import java.net.URI;
import java.net.URISyntaxException;

public class EventTest {

    @Test
    public void getNumericId() throws URISyntaxException {
        URI uri = new URI("http://hostname:1234/events/43");
        Event event = new Event();
        event.set_id( uri );

        Assert.assertEquals(43, event.numericId() );
    }

}
