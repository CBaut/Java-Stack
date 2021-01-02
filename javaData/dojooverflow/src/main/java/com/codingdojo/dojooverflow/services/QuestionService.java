package com.codingdojo.dojooverflow.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.codingdojo.dojooverflow.models.NewQuestion;
import com.codingdojo.dojooverflow.models.Question;
import com.codingdojo.dojooverflow.models.Tag;
import com.codingdojo.dojooverflow.repositories.QuestionRepository;
import com.codingdojo.dojooverflow.repositories.TagRepository;

import org.springframework.stereotype.Service;

@Service
public class QuestionService {
    private final QuestionRepository questionRepository;
    private final TagRepository tagRepository;

    public QuestionService(QuestionRepository questionRepository, TagRepository tagRepository) {
        this.questionRepository = questionRepository;
        this.tagRepository = tagRepository;
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
    public Question createQuestion(NewQuestion newQ) {
        List<Tag> questionsTags = new ArrayList<>();
        for (String subject : newQ.splitTags()) {
            Tag tag = this.tagRepository.findBySubject(subject).orElse(null);
            if (tag == null) {
                tag = new Tag(subject);
                this.tagRepository.save(tag);
            }
            // prevent dupe tags
            if (!questionsTags.contains(tag))
                questionsTags.add(tag);
        }
        Question newQuestion = new Question(newQ.getQuestion(), questionsTags);
        System.out.println("made newQuestion: " + newQuestion.getQuestion() + newQuestion.getTags());
        return this.questionRepository.save(newQuestion);
    }

    // update a question
    public Question updateQuestion(Question q) {
        return questionRepository.save(q);
    }
}
