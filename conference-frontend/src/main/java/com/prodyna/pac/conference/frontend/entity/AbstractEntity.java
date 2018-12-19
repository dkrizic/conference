package com.prodyna.pac.conference.frontend.entity;

import lombok.Data;
import lombok.ToString;
import uk.co.blackpepper.bowman.annotation.ResourceId;

import java.net.URI;

@Data
public abstract class AbstractEntity {

    private URI _id;

    @ResourceId
    @ToString.Include
    public URI get_id() {
        return _id;
    }

    public void set_id(URI _id) {
        this._id = _id;
    }

    public long numericId() {
        String[] parts = get_id().getPath().toString().split("/");
        String numeric = parts[ parts.length - 1];
        return Long.parseLong( numeric );
    }

}
