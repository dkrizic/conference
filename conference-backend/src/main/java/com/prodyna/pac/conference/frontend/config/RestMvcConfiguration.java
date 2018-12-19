package com.prodyna.pac.conference.frontend.config;

import com.prodyna.pac.conference.frontend.entity.Person;
import com.prodyna.pac.conference.frontend.repository.PersonRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurerAdapter;

@Configuration
public class RestMvcConfiguration {

    @Bean
    public RepositoryRestConfigurer repositoryRestConfigurer() {
        return new RepositoryRestConfigurerAdapter() {

            @Override
            public void configureRepositoryRestConfiguration( RepositoryRestConfiguration config ) {
                config
                        .setBasePath("/api")
                        /*.withEntityLookup()
                        .forRepository( PersonRepository.class, Person::getId, PersonRepository::findByOwnId )*/;

            }
        };
    }

}
