package com.codingdojo.dojosninjas.repositories;

import java.util.List;

import com.codingdojo.dojosninjas.models.Ninja;

import org.springframework.data.repository.CrudRepository;

public interface NinjaRepository extends CrudRepository<Ninja, Long> {
    List<Ninja> findAll();
}
