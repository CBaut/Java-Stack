package com.codingdojo.authentication.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import com.codingdojo.authentication.models.User;
import com.codingdojo.authentication.services.UserService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Users {
    private final UserService userService;

    public Users(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("/registration")
    public String registerForm(@ModelAttribute("user") User user) {
        return "registrationPage.jsp";
    }

    @RequestMapping("/login")
    public String login() {
        return "loginPage.jsp";
    }

    @PostMapping("/registration")
    public String registerUser(@Valid @ModelAttribute("user") User user, BindingResult result, HttpSession session) {
        // [x] if result has errors, return the registration page (don't worry about
        // validations just now)
        // [x] else, save the user in the database, save the user id in session, and
        // [x] redirect them to the /home route
        if (result.hasErrors()) {
            return "/registration.jsp";
        } else {
            System.out.println("Yup, going for it");
            this.userService.registerUser(user);
            System.out.println("User created successfully");
            session.setAttribute("uuid", user.getId());
            System.out.println("User ID saved to session as: " + user.getId());
            return "redirect:/home";
        }
    }

    @PostMapping("/login")
    public String loginUser(@RequestParam("email") String email, @RequestParam("password") String password, Model model,
            HttpSession session) {
        // [x] if the user is authenticated, save their user id in session
        if (userService.authenticateUser(email, password)) {
            User thisUser = userService.findByEmail(email);
            session.setAttribute("uuid", thisUser.getId());
            System.out.println("User ID saved to session as: " + thisUser.getId());
        }
        // [x] else, add error messages and return the login page
        else {
            String error = "Email or Password incorrect";
            model.addAttribute("error", error);
            return "/loginPage.jsp";
        }
        return "redirect:/home";
    }

    @RequestMapping("/home")
    public String home(HttpSession session, Model model) {
        // [x] get user from session, save them in the model and return the home page
        User thisUser = userService.findUserById((Long) session.getAttribute("uuid"));
        model.addAttribute("user", thisUser);
        return "homePage.jsp";
    }

    @RequestMapping("/logout")
    public String logout(HttpSession session) {
        // [x] invalidate session
        session.removeAttribute("uuid");
        // [x] redirect to login page
        return "redirect:/";
    }
}
