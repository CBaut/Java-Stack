package com.codingdojo.dojosninjas.services;

import java.util.List;
import java.util.Optional;

import com.codingdojo.dojosninjas.models.Ninja;
import com.codingdojo.dojosninjas.repositories.NinjaRepository;

import org.springframework.stereotype.Service;

@Service
public class NinjaService {
    private final NinjaRepository ninjaRepository;

    public NinjaService(NinjaRepository ninjaRepository) {
        this.ninjaRepository = ninjaRepository;
    }

    // returns all the people
    public List<Ninja> findAllNinjas() {
        return ninjaRepository.findAll();
    }

    // retrieve a person
    public Ninja findNinjaById(Long id) {
        Optional<Ninja> optionalNinja = ninjaRepository.findById(id);
        if (optionalNinja.isPresent()) {
            return optionalNinja.get();
        } else {
            return null;
        }
    }

    // create a Ninja
    public Ninja createNinja(Ninja ninja) {
        return ninjaRepository.save(ninja);
    }
}
