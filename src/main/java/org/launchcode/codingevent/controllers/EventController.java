package org.launchcode.codingevent.controllers;

import org.launchcode.codingevent.data.EventData;
import org.launchcode.codingevent.models.Event;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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
    public String renderEventCreateForm(Model model){
        model.addAttribute("title","Create Event");
        return "events/create";
    }

    @PostMapping("create")
    public String createEvent(@ModelAttribute @Valid Event newEvent, Errors errors, Model model){
        if(errors.hasErrors()) {
            model.addAttribute("title","Create Event");
            model.addAttribute("errorMsg","invalid data");
            return "events/create";
        }
            EventData.addEvent(newEvent);
            return "redirect:";

    }

    @GetMapping("delete")
    public String displayDeleteEventForm(Model model){
        model.addAttribute("title","Delete Events");
        model.addAttribute("events",EventData.getAll());
        return "events/delete";
    }

    @PostMapping("delete")
    public String processDeleteEventForm(@RequestParam (required = false) int[] eventIds){
        if(eventIds != null) {
            for (int id : eventIds) {
                EventData.removeEvent(id);
            }
        }
        return "redirect:";
    }
}
