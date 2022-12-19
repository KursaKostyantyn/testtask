package com.example.testtask.repositories;

import com.example.testtask.models.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface PersonRepository extends JpaRepository<Person,Integer> {

}
