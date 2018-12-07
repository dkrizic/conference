package com.example.demo.controller;

import com.example.demo.Person;
import com.example.demo.persistence.PersonRepository;
import io.micrometer.core.annotation.Timed;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/persons")
@Api(description = "Access to Persons")
public class PersonController {

    @Autowired
    private PersonRepository personRepository;

    @GetMapping
    @ApiOperation("Find all persons")
    @Timed("persons_findall")
    ResponseEntity<Iterable<Person>> findAllPersons() {
        return ResponseEntity.ok( personRepository.findAll() );
    }

    @PostMapping
    @ApiOperation("Create a person")
    @Timed("persons_create")
    ResponseEntity<Person> createPerson(Person person ) {
        return ResponseEntity.ok( personRepository.save( person ) );
    }

}
