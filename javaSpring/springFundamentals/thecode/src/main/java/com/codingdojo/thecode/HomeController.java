package com.codingdojo.thecode;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class HomeController {
    @RequestMapping("/")
    public String index() {
        return "index.jsp";
    }

    @RequestMapping(value = "/form", method = RequestMethod.POST)
    public String form(@RequestParam(value = "code") String code, HttpSession session,
            RedirectAttributes redirectAttributes) {
        session.setAttribute("code", code);
        if (code.equals("Bushido")) {
            session.setAttribute("success", true);
            return "redirect:/thecode";
        } else {
            redirectAttributes.addFlashAttribute("error", "You must train harder!");
            return "redirect:/";
        }
    }

    @RequestMapping("/thecode")
    public String theCode(HttpSession session) {
        Boolean success = (Boolean) session.getAttribute("success");
        if (success) {
            return "thecode.jsp";
        } else {
            return "redirect:/";
        }
    }
}
