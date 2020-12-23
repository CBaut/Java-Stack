package com.codingdojo.dojosurvey.dojosurvey;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {
    @RequestMapping("/")
    public String index() {
        return "index.jsp";
    }

    @RequestMapping("/survey")
    public String surveyPost(HttpSession session, @RequestParam(value = "name") String name,
            @RequestParam(value = "location") String location, @RequestParam(value = "language") String language,
            @RequestParam(value = "comment") String comment) {
        session.setAttribute("name", name);
        session.setAttribute("location", location);
        session.setAttribute("language", language);
        session.setAttribute("comment", comment);
        return "redirect:/results";
    }

    @RequestMapping("/results")
    public String results(HttpSession session) {
        Object getLang = session.getAttribute("language");
        if (getLang.equals("Java")) {
            return "java.jsp";
        } else {
            return "results.jsp";
        }
    }
}
