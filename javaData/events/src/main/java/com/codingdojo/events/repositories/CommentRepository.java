package com.codingdojo.events.repositories;

import java.util.Optional;

import com.codingdojo.events.models.Comment;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends CrudRepository<Comment, Long> {
    Optional<Comment> findById(Long id);
}
