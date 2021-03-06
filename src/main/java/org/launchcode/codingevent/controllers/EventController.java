package org.launchcode.codingevent.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("events")
public class EventController {

    @GetMapping
    public String displayAllEvents(Model model){
        List<String> events = new ArrayList<>();
        events.add("code with pride");
        events.add("strange loop");
        events.add("apple");
        events.add("windows");
        events.add("linux");
        model.addAttribute("events",events);
        return "events/index";
    }
}
