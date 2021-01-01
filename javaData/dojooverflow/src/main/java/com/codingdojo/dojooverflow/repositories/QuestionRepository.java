package com.codingdojo.dojooverflow.repositories;

import java.util.List;

import com.codingdojo.dojooverflow.models.Question;
import com.codingdojo.dojooverflow.models.Tag;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionRepository extends CrudRepository<Question, Long> {

    List<Question> findAll();

    // List<Question> findByTagsNotContains(Tag tag);
}
