package com.codingdojo.dojooverflow.services;

import java.util.List;
import java.util.Optional;

import com.codingdojo.dojooverflow.models.Answer;
import com.codingdojo.dojooverflow.repositories.AnswerRepository;

import org.springframework.stereotype.Service;

@Service
public class AnswerService {
    private final AnswerRepository answerRepository;

    public AnswerService(AnswerRepository answerRepository) {
        this.answerRepository = answerRepository;
    }

    // return all the answers
    public List<Answer> findAllAnswers() {
        return answerRepository.findAll();
    }

    // retrieve an answer
    public Answer findAnswerById(Long id) {
        Optional<Answer> optionalAnswer = answerRepository.findById(id);
        if (optionalAnswer.isPresent()) {
            return optionalAnswer.get();
        } else {
            return null;
        }
    }

    // create an answer
    public Answer createAnswer(Answer answer) {
        return answerRepository.save(answer);
    }

    // update an answer
    public Answer updateAnswer(Answer answer) {
        return answerRepository.save(answer);
    }
}
