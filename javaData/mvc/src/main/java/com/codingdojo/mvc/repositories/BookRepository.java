package com.codingdojo.mvc.repositories;

import java.util.List;

import com.codingdojo.mvc.models.Book;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends CrudRepository<Book, Long> {
    List<Book> findAll();

    List<Book> findByDescriptionContaining(String search);

    Long countByTitleCointaining(String search);

    Long deleteByTitleStartingWith(String search);
}