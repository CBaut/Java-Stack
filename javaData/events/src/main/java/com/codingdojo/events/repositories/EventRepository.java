package com.codingdojo.events.repositories;

import java.util.Optional;

import com.codingdojo.events.models.Event;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventRepository extends CrudRepository<Event, Long> {
    Optional<Event> findById(Long id);
}
