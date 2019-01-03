package com.prodyna.pac.conference.frontend.entity;


import uk.co.blackpepper.bowman.annotation.LinkedResource;
import uk.co.blackpepper.bowman.annotation.RemoteResource;

import java.util.Set;

@RemoteResource("/api/topics/search")
public interface TopicSearch {

    @LinkedResource
    Set<Topic> toplevel();

    @LinkedResource
    Set<Talk> subtalks( long topicId );

}
