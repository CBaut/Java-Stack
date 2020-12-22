package com.codingdojo.counter.counter;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
    @RequestMapping("/")
    public String index(HttpSession session) {
        Integer count = (Integer) session.getAttribute("count");
        if (count == null) {
            count = 1;
        } else {
            count++;
        }
        session.setAttribute("count", count);
        return "index.jsp";
    }

    @RequestMapping("/counter")
    public String counter(HttpSession session) {
        Integer count = (Integer) session.getAttribute("count");
        if (count == null) {
            count = 1;
        } else {
            count++;
        }
        session.setAttribute("count", count);
        return "counter.jsp";
    }
}
