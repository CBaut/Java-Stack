package com.codingdojo.dojooverflow.repositories;

import java.util.List;

import com.codingdojo.dojooverflow.models.Question;
import com.codingdojo.dojooverflow.models.Tag;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TagRepository extends CrudRepository<Tag, Long> {

    List<Tag> findAll();

    List<Tag> findByQuestionsNotContains(Question question);
}
