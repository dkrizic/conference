package com.prodyna.pac.conference.entity;

import org.junit.Assert;
import org.junit.Test;

import java.net.URI;
import java.net.URISyntaxException;

public class EventTest {

    @Test
    public void getNumericId() throws URISyntaxException {
        URI uri = new URI("http://hostname:1234/events/42");
        Event event = new Event();
        event.set_id( uri );

        Assert.assertEquals(42, event.getNumericId() );
    }

}
