package com.codingdojo.relationships.services;

import java.util.List;
import java.util.Optional;

import com.codingdojo.relationships.models.Person;
import com.codingdojo.relationships.repositories.PersonRepository;

import org.springframework.stereotype.Service;

@Service
public class PersonService {
    private final PersonRepository personRepository;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    // returns all the people
    public List<Person> findAllPersons() {
        return personRepository.findAll();
    }

    // create a person
    public Person createPerson(Person p) {
        return personRepository.save(p);
    }

    // retrieve a person
    public Person findPersonById(Long id) {
        Optional<Person> optionalPerson = personRepository.findById(id);
        if (optionalPerson.isPresent()) {
            return optionalPerson.get();
        } else {
            return null;
        }
    }

    public List<Person> getUnlicensedPeople() {
        return personRepository.findByLicenseIdIsNull();
    }
}
