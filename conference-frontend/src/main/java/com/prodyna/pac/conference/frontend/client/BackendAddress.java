package com.prodyna.pac.conference.frontend.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

@Component
public class BackendAddress {

    @Value("${conference.backend.url}")
    private String backendUrl;

    public String getString() {
        return backendUrl;
    }

    public URI getURI() {
        try {
            return new URI( backendUrl );
        } catch (URISyntaxException e) {
            throw new IllegalStateException("Unable to convert " + backendUrl + " to valid URI", e );
        }
    }
}
