package com.example.demo.controller;

import com.example.demo.Person;
import com.example.demo.persistence.PersonRepository;
import io.micrometer.core.annotation.Timed;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/persons")
@Api(description = "Access to Persons")
public class PersonController {

    @Autowired
    private PersonRepository personRepository;

    @GetMapping
    @ApiOperation("Find all persons")
    @Timed("persons_findall")
    Iterable<Person> findAllPersons() {
        return personRepository.findAll();
    }

}
