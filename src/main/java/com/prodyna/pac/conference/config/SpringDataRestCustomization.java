package com.prodyna.pac.conference.config;

import com.prodyna.pac.conference.entity.Person;
import com.prodyna.pac.conference.repository.PersonRepository;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurerAdapter;
import org.springframework.stereotype.Component;

@Component
public class SpringDataRestCustomization extends RepositoryRestConfigurerAdapter {

    @Override
    public void configureRepositoryRestConfiguration( RepositoryRestConfiguration config ) {
        config.withEntityLookup().forRepository( PersonRepository.class, Person::getId, PersonRepository::findByOwnId );
    }

}
