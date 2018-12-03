package com.example.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.stream.StreamSupport;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PersonRepositoryIT {

    private Logger log = LoggerFactory.getLogger( getClass() );

    @Autowired
    private PersonRepository personRepository;

    @Test
    public void loadAllPersons() {
        Iterable<Person> persons = personRepository.findAll();
        long size = StreamSupport.stream( persons.spliterator(), true ).count();
        log.info("Found {} persons", size );
    }

}
