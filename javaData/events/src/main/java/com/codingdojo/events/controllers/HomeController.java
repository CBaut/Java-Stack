package com.codingdojo.events.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import com.codingdojo.events.models.User;
import com.codingdojo.events.models.UserLogin;
import com.codingdojo.events.services.EventService;
import com.codingdojo.events.services.UserService;
import com.codingdojo.events.validator.UserValidator;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
    private final UserService userService;
    private final UserValidator userValidator;
    private final EventService eventService;

    public HomeController(UserService userService, UserValidator userValidator, EventService eventService) {
        this.userService = userService;
        this.eventService = eventService;
        this.userValidator = userValidator;
    }

    // index at / is the registration and login page
    @RequestMapping("/")
    public String index(@ModelAttribute("user") User user, @ModelAttribute("userLogin") UserLogin userLogin) {
        return "index.jsp";
    }

    // successful login routes to dashboard at /events
    @RequestMapping("/events")
    public String dashboard() {
        return "/events/dashboard.jsp";
    }

    @PostMapping("/registration")
    public String registerUser(@Valid @ModelAttribute("user") User user, BindingResult result, HttpSession session) {
        // [x] validate
        // [x] else, save the user in the database, save the user id in session, and
        // [x] redirect them to the /home route
        userValidator.validate(user, result);
        if (result.hasErrors()) {
            return "/index.jsp";
        } else {
            System.out.println("Yup, going for it");
            this.userService.registerUser(user);
            System.out.println("User created successfully");
            session.setAttribute("uuid", user.getId());
            System.out.println("User ID saved to session as: " + user.getId());
            return "redirect:/events";
        }
    }

    @PostMapping("/login")
    public String loginUser(@Valid @ModelAttribute("userLogin") UserLogin userLogin, BindingResult result, Model model,
            HttpSession session) {
        // [x] if the user is authenticated, save their user id in session
        if (userService.authenticateUser(userLogin.getLoginEmail(), userLogin.getLoginPassword())) {
            User thisUser = userService.findByEmail(userLogin.getLoginEmail());
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
