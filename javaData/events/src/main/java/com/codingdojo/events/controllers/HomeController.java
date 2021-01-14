package com.codingdojo.events.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import com.codingdojo.events.models.User;
import com.codingdojo.events.models.Comment;
import com.codingdojo.events.models.Event;
import com.codingdojo.events.models.State;
import com.codingdojo.events.services.EventService;
import com.codingdojo.events.services.UserService;
import com.codingdojo.events.validator.EventValidator;
import com.codingdojo.events.validator.UserValidator;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class HomeController {
    private final UserService userService;
    private final UserValidator userValidator;
    private final EventService eventService;
    private final EventValidator eventValidator;

    public HomeController(UserService userService, UserValidator userValidator, EventService eventService,
            EventValidator eventValidator) {
        this.userService = userService;
        this.eventService = eventService;
        this.userValidator = userValidator;
        this.eventValidator = eventValidator;
    }

    // index at / is the registration and login page
    @RequestMapping("/")
    public String index(@ModelAttribute("registration") User user, HttpSession session, Model model) {
        if (session.getAttribute("uuid") != null) {
            return "redirect:/events";
        } else {
            model.addAttribute("states", State.states);
            return "index.jsp";
        }
    }

    @PostMapping("/registration")
    public String registerUser(@Valid @ModelAttribute("registration") User user, BindingResult result,
            HttpSession session, Model model) {
        // [x] validate
        // [x] else, save the user in the database, save the user id in session, and
        // [x] redirect them to the /home route
        System.out.println("hit the registration button and running validations now");
        userValidator.validate(user, result);
        System.out.println("ran validations and now evaluating if errors...");
        if (result.hasErrors()) {
            System.out.println("evaulated that there are errors... should render index.jsp");
            model.addAttribute("states", State.states);
            return "index.jsp";
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
    public String loginUser(@Valid @ModelAttribute("registration") User user, BindingResult result,
            @RequestParam("email") String email, @RequestParam("password") String password, Model model,
            HttpSession session, RedirectAttributes redirectAttributes) {
        System.out.println("entered post request for login...");
        // [x] if the user is authenticated, save their user id in session
        if (userService.authenticateUser(email, password)) {
            User thisUser = userService.findByEmail(email);
            session.setAttribute("uuid", thisUser.getId());
            System.out.println("User ID saved to session as: " + thisUser.getId());
            return "redirect:/events";
        }
        // [x] else, add error messages and return the login page
        else {
            String error = "Email or Password incorrect";
            model.addAttribute("error", error);
            model.addAttribute("states", State.states);
            return "index.jsp";
        }
    }

    // successful login routes to dashboard at /events
    @RequestMapping("/events")
    public String dashboard(HttpSession session, Model model, @ModelAttribute("newEvent") Event event) {
        // [x] check if uud is in session
        // [x] get user from session, save them in the model and return the home page
        if (session.getAttribute("uuid") == null) {
            return "redirect:/";
        }
        // get user from session
        User thisUser = userService.findUserById((Long) session.getAttribute("uuid"));
        // query all events in state of user
        List<Event> allEventsInState = eventService.findEventByState(thisUser.getState());
        // query all events not in user state
        List<Event> allEventsNotInState = eventService.findEventByStateNot(thisUser.getState());
        model.addAttribute("user", thisUser);
        model.addAttribute("states", State.states);
        model.addAttribute("eventsInState", allEventsInState);
        model.addAttribute("eventsNotInState", allEventsNotInState);
        return "/events/dashboard.jsp";
    }

    // receiving form post for creating new event
    @PostMapping("/events")
    public String newEvent(@Valid @ModelAttribute("newEvent") Event event, BindingResult result, HttpSession session,
            Model model) {
        System.out.println("Trying to create a new event... made it to the Post Form function!");
        eventValidator.validate(event, result);
        System.out.println("ran validations and now evaluating if errors...");
        if (result.hasErrors()) {
            System.out.println("found some errors... rendering dashboard.jsp with error messages");
            // get user from session
            User thisUser = userService.findUserById((Long) session.getAttribute("uuid"));
            // query all events in state of user
            List<Event> allEventsInState = eventService.findEventByState(thisUser.getState());
            // query all events not in user state
            List<Event> allEventsNotInState = eventService.findEventByStateNot(thisUser.getState());
            model.addAttribute("user", thisUser);
            model.addAttribute("states", State.states);
            model.addAttribute("eventsInState", allEventsInState);
            model.addAttribute("eventsNotInState", allEventsNotInState);
            return "/events/dashboard.jsp";
        }
        // set session user as host
        User user = userService.findUserById((Long) session.getAttribute("uuid"));
        event.setHost(user);
        System.out.println("Applying current User as Host...");
        System.out.println("going for the creation of Event");
        this.eventService.createEvent(event);
        System.out.println("new event was successfully created");
        return "redirect:/events";
    }

    // edit event page
    @RequestMapping("/events/{id}/edit")
    public String editEvent(@PathVariable(value = "id") Long eventId, @ModelAttribute("updateEvent") Event event,
            HttpSession session, Model model) {
        if (session.getAttribute("uuid") == null) {
            return "redirect:/";
        }
        User user = userService.findUserById((Long) session.getAttribute("uuid"));
        model.addAttribute("user", user);
        // edit form needs prefilled event info
        Event thisEvent = eventService.findEventById(eventId);
        model.addAttribute("states", State.states);
        model.addAttribute("event", thisEvent);
        return "/events/edit.jsp";
    }

    @PostMapping("/events/{id}/edit")
    public String updateEvent(@PathVariable(value = "id") Long eventId, @ModelAttribute("updateEvent") Event event,
            BindingResult result, HttpSession session, Model model) {
        System.out.println("Trying to edit event... made it to the Post Form function!");
        eventValidator.validate(event, result);
        System.out.println("ran validations and now evaluating if errors...");
        if (result.hasErrors()) {
            System.out.println("found some errors... rendering edit.jsp with error messages");
            User user = userService.findUserById((Long) session.getAttribute("uuid"));
            model.addAttribute("user", user);
            // edit form needs prefilled event info
            Event thisEvent = eventService.findEventById(eventId);
            model.addAttribute("states", State.states);
            model.addAttribute("event", thisEvent);
            return "/events/edit.jsp";
        }
        System.out.println("made it to the PostMapping method to edit the event...");
        eventService.updateEvent(eventId, event);
        System.out.println("Event Service performing the updates....");
        return "redirect:/events/" + event.getId();
    }

    // show event details including Message Wall feature
    @RequestMapping("/events/{id}")
    public String showEvent(@PathVariable(value = "id") Long eventId, HttpSession session, Model model,
            @ModelAttribute("comments") Comment comment) {
        if (session.getAttribute("uuid") == null) {
            return "redirect:/";
        }
        User user = userService.findUserById((Long) session.getAttribute("uuid"));
        model.addAttribute("user", user);
        Event thisEvent = eventService.findEventById(eventId);
        model.addAttribute("event", thisEvent);
        return "/events/info.jsp";
    }

    // create comment by user and add to event
    @PostMapping("/events/{id}/addcomment")
    public String addComment(@PathVariable(value = "id") Long eventId, HttpSession session, Model model,
            @Valid @ModelAttribute("comments") Comment comment, BindingResult result) {
        if (result.hasErrors()) {
            System.out.println("found some errors... rendering info.jsp with error messages");
            User user = userService.findUserById((Long) session.getAttribute("uuid"));
            model.addAttribute("user", user);
            Event thisEvent = eventService.findEventById(eventId);
            model.addAttribute("event", thisEvent);
            return "/events/info.jsp";
        }
        System.out.println("made it here to create comment!");
        Event thisEvent = eventService.findEventById(eventId);
        User thisUser = userService.findUserById((Long) session.getAttribute("uuid"));
        eventService.createComment(comment, thisEvent, thisUser);
        System.out.println("saved comment! now redirecting to events info");
        return "redirect:/events/" + eventId;
    }

    @RequestMapping("/events/{id}/join")
    public String joinEvent(@PathVariable(value = "id") Long eventId, HttpSession session) {
        System.out.println("Activating join function...");
        User thisUser = userService.findUserById((Long) session.getAttribute("uuid"));
        Event thisEvent = eventService.findEventById(eventId);
        eventService.addUserToEvent(thisUser, thisEvent);
        System.out.println("added user to this event... now redirecting back to dashboard");
        return "redirect:/events";
    }

    @RequestMapping("/events/{id}/unjoin")
    public String unJoinEvent(@PathVariable(value = "id") Long eventId, HttpSession session) {
        System.out.println("Activating unjoin function...");
        User thisUser = userService.findUserById((Long) session.getAttribute("uuid"));
        Event thisEvent = eventService.findEventById(eventId);
        eventService.removeUserFromEvent(thisUser, thisEvent);
        System.out.println("removed user from this event... now redirecting back to dashboard");
        return "redirect:/events";
    }

    @PostMapping("/events/{id}/delete")
    public String deleteEvent(@PathVariable(value = "id") Long eventId, HttpSession session) {
        System.out.println("Activating deletion of event...");
        eventService.deleteEvent(eventId);
        System.out.println("Event has been successfuly deleted");
        return "redirect:/events";
    }

    @RequestMapping("/logout")
    public String logout(HttpSession session) {
        // [x] invalidate session
        System.out.println("Invalidating Session...");
        session.invalidate();
        // [x] redirect to login page
        return "redirect:/";
    }

}
