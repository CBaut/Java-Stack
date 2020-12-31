package com.codingdojo.dojooverflow.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
    @RequestMapping("/")
    public String index() {
        return "index.jsp";
    }

    @RequestMapping("/questions")
    public String dashboard() {
        return "/questions/dashboard.jsp";
    }

    @RequestMapping("/questions/new")
    public String newQuestion() {
        return "/questions/new.jsp";
    }
}
