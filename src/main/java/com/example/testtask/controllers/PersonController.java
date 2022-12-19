package com.example.testtask.controllers;

import com.example.testtask.models.Person;
import com.example.testtask.services.PersonService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@CrossOrigin(origins = "http://localhost:8080")
@RestController
@AllArgsConstructor
public class PersonController {

    private PersonService personService;

    @GetMapping("/persons/{id}")
    public Person getPersonById(@PathVariable int id) {
        return personService.getPersonById(id);
    }
}
