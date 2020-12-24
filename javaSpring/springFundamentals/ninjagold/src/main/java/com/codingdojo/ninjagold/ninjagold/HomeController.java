package com.codingdojo.ninjagold.ninjagold;

import java.util.ArrayList;
import java.util.Date;
import java.util.Random;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

// Keys in session:
// gold, activities, process, currentGold
@Controller
public class HomeController {
    @RequestMapping("/")
    public String index() {
        return "redirect:/Gold";
    }

    @RequestMapping("/Gold")
    public String gold(HttpSession session) {
        Integer gold = 0;
        if (session.getAttribute("gold") == null) {
            session.setAttribute("gold", gold);
        } else {
            gold = (Integer) session.getAttribute("gold");
        }
        if (session.getAttribute("activities") == null) {
            ArrayList<String> activities = new ArrayList<String>();
            // if no activities list in session, create new list
            session.setAttribute("activities", activities);
        }
        return "gold.jsp";
    }

    @RequestMapping("/process")
    public String process(HttpSession session, @RequestParam(value = "process") String process) {
        // receive requestPOST
        // initialize ArrayList to add to the activities
        // myArray.add(array[i]);
        // calculate random
        session.setAttribute("process", process);
        Integer currentGold = (Integer) session.getAttribute("gold");
        Integer gold = 0;
        if (process.equals("farm")) {
            gold = this.calculateGold(session, 10, 20);
        }
        if (process.equals("cave")) {
            gold = this.calculateGold(session, 5, 10);
        }
        if (process.equals("house")) {
            gold = this.calculateGold(session, 2, 5);
        }
        if (process.equals("casino")) {
            Random win = new Random();
            gold = this.calculateGold(session, 0, 50);
            Integer casino = win.nextInt(51);
            if (!win.nextBoolean()) {
                gold = -casino;
            } else {
                gold = casino;
            }
            System.out.println("went to casino.. gold is randomed at: " + gold);
        }
        System.out.println("********adding to currentGold: " + gold + " from " + process);
        session.setAttribute("gold", currentGold + gold);
        session.setAttribute("currentGold", gold);
        this.addActivity(session);
        return "redirect:/Gold";
    }

    @RequestMapping("/reset")
    public String reset(HttpSession session) {
        session.removeAttribute("gold");
        session.removeAttribute("activities");
        session.removeAttribute("process");
        session.removeAttribute("currentGold");
        System.out.println("We are ousting the session keys...");
        return "redirect:/";
    }

    private Integer calculateGold(HttpSession session, Integer lowerLimit, Integer upperLimit) {
        Random rand = new Random();
        Integer gold = rand.nextInt(upperLimit - lowerLimit + 1) + lowerLimit;
        return gold;
    }

    private void addActivity(HttpSession session) {
        ArrayList<String> activities = (ArrayList<String>) session.getAttribute("activities");
        Integer currentGold = (Integer) session.getAttribute("currentGold");
        String process = (String) session.getAttribute("process");
        String message = "";
        if (currentGold >= 0) {
            message = "You entered a " + process + " and earned " + currentGold + " gold. ";
        } else {
            message = "You entered a " + process + " and lost " + currentGold + " gold. Ouch... ";
        }
        Date timeStamp = new Date();
        activities.add(message + timeStamp);
        session.setAttribute("activities", activities);
    }
}
