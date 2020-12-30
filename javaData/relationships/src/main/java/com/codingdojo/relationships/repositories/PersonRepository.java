package com.codingdojo.relationships.repositories;

import java.util.List;

import com.codingdojo.relationships.models.Person;

import org.springframework.data.repository.CrudRepository;

public interface PersonRepository extends CrudRepository<Person, Long> {
    List<Person> findAll();

    List<Person> findByLicenseIdIsNull();
}
