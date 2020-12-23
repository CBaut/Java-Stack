package com.codingdojo.ninjagold.ninjagold;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.Random;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {
    @RequestMapping("/")
    public String index(HttpSession session) {
        Integer gold = (Integer) session.getAttribute("gold");
        if (gold == null) {
            session.setAttribute("gold", 0);
        }
        return "redirect:/Gold";
    }

    @RequestMapping("/Gold")
    public String gold(HttpSession session) {
        session.getAttribute("gold");
        return "gold.jsp";
    }

    @RequestMapping("/process")
    public String process(HttpSession session, @RequestParam(value = "process") String process) {
        session.setAttribute("process", process);
        Integer gold = (Integer) session.getAttribute("gold");
        if (process.equals("farm")) {

        }
        return "redirect:/Gold";
    }
}
