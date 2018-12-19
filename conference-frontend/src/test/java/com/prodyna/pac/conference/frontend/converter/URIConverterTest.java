package com.prodyna.pac.conference.frontend.converter;

import com.prodyna.pac.conference.frontend.client.BackendAddress;
import com.prodyna.pac.conference.frontend.entity.Event;
import com.prodyna.pac.conference.frontend.entity.Person;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.net.URI;

@RunWith(SpringRunner.class)
@SpringBootTest
public class URIConverterTest {

    @Autowired
    private URIConverter uriConverter;

    @Test
    public void testConversion() throws Exception {
        Assert.assertEquals(new URI("http://conference.192.168.99.100.nip.io/api/events/77"), uriConverter.convertToURI( Event.class, 77 ));
    }

    @Test
    public void testConversion2() throws Exception {
        Assert.assertEquals(new URI("http://conference.192.168.99.100.nip.io/api/persons/dkrizic"), uriConverter.convertToURI( Person.class, "dkrizic" ));
    }

}
