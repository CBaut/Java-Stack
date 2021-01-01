package com.codingdojo.dojooverflow.controllers;

import java.util.List;

import javax.validation.Valid;

import com.codingdojo.dojooverflow.models.NewQuestion;
import com.codingdojo.dojooverflow.models.Question;
import com.codingdojo.dojooverflow.models.Tag;
import com.codingdojo.dojooverflow.services.AnswerService;
import com.codingdojo.dojooverflow.services.QuestionService;
import com.codingdojo.dojooverflow.services.TagService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
    private final QuestionService questionService;
    private final TagService tagService;
    private final AnswerService answerService;

    public HomeController(QuestionService questionService, TagService tagService, AnswerService answerService) {
        this.questionService = questionService;
        this.tagService = tagService;
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
        if (result.hasErrors())
            return "/questions/new.jsp";
        this.questionService.createQuestion(newQuestion);
        return "redirect:/questions/";
    }
}
