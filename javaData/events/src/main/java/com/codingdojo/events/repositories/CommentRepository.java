package com.codingdojo.events.repositories;

import java.util.List;
import java.util.Optional;

import com.codingdojo.events.models.Comment;
import com.codingdojo.events.models.User;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends CrudRepository<Comment, Long> {
    Optional<Comment> findById(Long id);

    List<Comment> findByUser(User user);

    List<Comment> findByUserNot(User user);
}
