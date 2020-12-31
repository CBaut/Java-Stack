package com.codingdojo.dojosninjas.repositories;

import java.util.List;

import com.codingdojo.dojosninjas.models.Dojo;

import org.springframework.data.repository.CrudRepository;

public interface DojoRepository extends CrudRepository<Dojo, Long> {
    List<Dojo> findAll();
}
