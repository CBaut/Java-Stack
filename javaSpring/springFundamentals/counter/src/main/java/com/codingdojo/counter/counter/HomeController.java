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
        // Integer count = (Integer) session.getAttribute("count");
        // if (count == null) {
        // count = 1;
        // } else {
        // count++;
        // }
        // session.setAttribute("count", count);
        session.getAttribute("count");
        return "counter.jsp";
    }

    @RequestMapping("/count2")
    public String count2(HttpSession session) {
        Integer count = (Integer) session.getAttribute("count");
        count += 2;
        session.setAttribute("count", count);
        return "counter.jsp";
    }

    @RequestMapping("/reset")
    public String reset(HttpSession session) {
        session.removeAttribute("count");
        return "counter.jsp";
    }
}
