package com.codingdojo.relationships.repositories;

import java.util.List;

import com.codingdojo.relationships.models.License;

import org.springframework.data.repository.CrudRepository;

public interface LicenseRepository extends CrudRepository<License, Long> {
    List<License> findAll();
}
