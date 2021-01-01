package com.codingdojo.dojooverflow.repositories;

import java.util.List;

import com.codingdojo.dojooverflow.models.Answer;

import org.springframework.data.repository.CrudRepository;

public interface AnswerRepository extends CrudRepository<Answer, Long> {

    List<Answer> findAll();
}
