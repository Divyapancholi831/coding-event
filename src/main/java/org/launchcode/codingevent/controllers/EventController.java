package org.launchcode.codingevent.controllers;

import org.launchcode.codingevent.data.EventData;
import org.launchcode.codingevent.models.Event;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("events")
public class EventController {

   // private static List<Event> events = new ArrayList<>();

    @GetMapping
    public String displayAllEvents(Model model){
        model.addAttribute("events", EventData.getAll());
        return "events/index";
    }


    //lives at events/create
    @GetMapping("create")
    public String renderEventCreateForm(){
        return "events/create";
    }

    @PostMapping("create")
    public String createEvent(@RequestParam String eventName,@RequestParam String eventDescription){
        EventData.addEvent(new Event(eventName,eventDescription));
        return "redirect:";
    }

}
