package com.example.testtask.services;

import com.example.testtask.models.Person;
import com.example.testtask.repositories.PersonRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@Service
public class PersonService {
    private PersonRepository personRepository;

    @Bean
    private void autoCreateUsers() {
        List<Person> allPersons = personRepository.findAll();
        if (allPersons.size() == 0) {
            for (int i = 0; i < 29; i++) {
                savePerson(new Person("Kolya" + i, "Kovalev" + i, LocalDate.of(1984, 01, i + 1)));
            }
        }
    }


    public void savePerson(Person person) {
        personRepository.save(person);
    }


    public Person getPersonById(int id) {
        return personRepository.findById(id).orElse(new Person());
    }
}
