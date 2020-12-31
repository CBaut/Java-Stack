package com.codingdojo.dojosninjas.services;

import java.util.List;
import java.util.Optional;

import com.codingdojo.dojosninjas.models.Dojo;
import com.codingdojo.dojosninjas.repositories.DojoRepository;

import org.springframework.stereotype.Service;

@Service
public class DojoService {
    private final DojoRepository dojoRepository;

    public DojoService(DojoRepository dojoRepository) {
        this.dojoRepository = dojoRepository;
    }

    // create a person
    public Dojo createDojo(Dojo dojo) {
        return dojoRepository.save(dojo);
    }

    // returns all the people
    public List<Dojo> findAllDojos() {
        return dojoRepository.findAll();
    }

    // retrieve a person
    public Dojo findDojoById(Long id) {
        Optional<Dojo> optionalDojo = dojoRepository.findById(id);
        if (optionalDojo.isPresent()) {
            return optionalDojo.get();
        } else {
            return null;
        }
    }
}
