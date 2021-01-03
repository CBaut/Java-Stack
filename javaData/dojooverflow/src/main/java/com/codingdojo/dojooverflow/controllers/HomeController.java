package com.codingdojo.dojooverflow.controllers;

import java.util.List;

import javax.validation.Valid;

import com.codingdojo.dojooverflow.models.Answer;
import com.codingdojo.dojooverflow.models.NewQuestion;
import com.codingdojo.dojooverflow.models.Question;
import com.codingdojo.dojooverflow.services.AnswerService;
import com.codingdojo.dojooverflow.services.QuestionService;
import com.codingdojo.dojooverflow.services.TagService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
    private final QuestionService questionService;
    private final AnswerService answerService;

    public HomeController(QuestionService questionService, TagService tagService, AnswerService answerService) {
        this.questionService = questionService;
        this.answerService = answerService;
    }

    @RequestMapping("/")
    public String index() {
        return "index.jsp";
    }

    @RequestMapping("/questions")
    public String dashboard(Model model) {
        List<Question> questions = questionService.findAllQuestions();
        model.addAttribute("questions", questions);
        return "/questions/dashboard.jsp";
    }

    @RequestMapping("/questions/new")
    public String newQuestion(@ModelAttribute("newQuestion") NewQuestion newQuestion) {
        return "/questions/new.jsp";
    }

    @PostMapping("/questions/new")
    public String createQuestion(@Valid @ModelAttribute("newQuestion") NewQuestion newQuestion, BindingResult result) {
        System.out.println("Trying to create the question...");
        System.out.println("Binding Result is: " + result);
        if (result.hasErrors()) {
            return "/questions/new.jsp";
        } else {
            System.out.println("Yup, going for it");
            this.questionService.createQuestion(newQuestion);
            System.out.println("Question created successfully");
            return "redirect:/questions/";
        }
    }

    @RequestMapping("/questions/{id}")
    public String dashboard(@PathVariable("id") Long id, Model model, @ModelAttribute("answer") Answer answer) {
        List<Question> questions = questionService.findAllQuestions();
        model.addAttribute("questions", questions);
        Question question = questionService.findQuestionById(id);
        model.addAttribute("question", question);
        return "/questions/show.jsp";
    }

    @PostMapping("/answers")
    public String createAnswer(@Valid @ModelAttribute("answer") Answer answer, BindingResult result, Model model) {
        System.out.println("Trying to create an answer now...");
        if (result.hasErrors()) {
            return "/questions/show.jsp";
        } else {
            System.out.println("Yup... going for the creation of the answer thing..");
            // get question by id
            Answer newAnswer = answerService.createAnswer(answer);
            System.out.println("Answer has been created.");
            return "redirect:/questions/" + newAnswer.getQuestion().getId();
        }
    }
}
