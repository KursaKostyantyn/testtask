package com.example.testtask.services;

import com.example.testtask.models.Person;
import com.example.testtask.repositories.PersonRepository;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.time.LocalDate;

@DataJpaTest
public class PersonServiceTest {

    @Autowired
    private TestEntityManager testEntityManager;

    @Autowired
    private PersonRepository personRepository;

    @Test
    public void savePerson() {
        Person person = personRepository.save(new Person("Ivan", "Ivanov", LocalDate.of(1984, 11, 20)));

        assertThat(person).hasFieldOrPropertyWithValue("firstName", "Ivan");
        assertThat(person).hasFieldOrPropertyWithValue("lastName", "Ivanov");
        assertThat(person).hasFieldOrPropertyWithValue("birthDate", LocalDate.of(1984, 11, 20));
    }

    @Test
    public void getPersonById() {
        Person person1 = new Person("Ivan", "Ivanov", LocalDate.of(1984, 11, 20));
        testEntityManager.persist(person1);

        Person person2 = new Person("Mikola", "Koval", LocalDate.of(1995, 1, 10));
        testEntityManager.persist(person2);

        Person foundPerson = personRepository.findById(person2.getId()).get();

        assertThat(foundPerson).isEqualTo(person2);
    }
}
