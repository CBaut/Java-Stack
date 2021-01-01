package com.codingdojo.dojooverflow.services;

import java.util.List;
import java.util.Optional;

import com.codingdojo.dojooverflow.models.Question;
import com.codingdojo.dojooverflow.repositories.QuestionRepository;

import org.springframework.stereotype.Service;

@Service
public class QuestionService {
    private final QuestionRepository questionRepository;

    public QuestionService(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    // returns all the questions
    public List<Question> findAllQuestions() {
        return questionRepository.findAll();
    }

    // retrieve a question
    public Question findQuestionById(Long id) {
        Optional<Question> optionalQuestion = questionRepository.findById(id);
        if (optionalQuestion.isPresent()) {
            return optionalQuestion.get();
        } else {
            return null;
        }
    }

    // create a question
    public Question createQuestion(Question q) {
        return questionRepository.save(q);
    }

    // update a question
    public Question updateQuestion(Question q) {
        return questionRepository.save(q);
    }
}
