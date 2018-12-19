package com.prodyna.pac.conference.frontend.converter;

import com.prodyna.pac.conference.frontend.client.BackendAddress;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import uk.co.blackpepper.bowman.annotation.RemoteResource;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.net.URI;
import java.net.URISyntaxException;

@Slf4j
@Component
public class URIConverter {

    @Autowired
    private BackendAddress backendURL;

    public URI convertToURI( Class clazz, long id ) {
        log.debug("Creating uri for type {}, id {}", clazz, id );
        String relative;
        try {
            RemoteResource annotation = (RemoteResource) clazz.getAnnotation( RemoteResource.class );
            relative = annotation.value();
        } catch( Exception e ) {
            throw new IllegalStateException("Unable to read annotation value of class " + clazz + " that must be annotated with " + RemoteResource.class.getName(), e);
        }
        String uriString = backendURL.getString() + relative + "/" + id ;
        try {
            URI uri = new URI(uriString);
            return uri;
        } catch( URISyntaxException e ) {
            throw new IllegalStateException("Unable to create URI for type " + clazz + " and base URL " + uriString );
        }
    }

}
