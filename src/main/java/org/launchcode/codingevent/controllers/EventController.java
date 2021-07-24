package org.launchcode.codingevent.controllers;

import org.launchcode.codingevent.data.EventCategoryRepository;
import org.launchcode.codingevent.data.EventRepository;
import org.launchcode.codingevent.data.TagRepository;
import org.launchcode.codingevent.models.Event;
import org.launchcode.codingevent.models.EventCategory;
import org.launchcode.codingevent.models.Tag;
import org.launchcode.codingevent.models.dto.eventTagDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.Optional;


@Controller
@RequestMapping("events")
public class EventController {

   // private static List<Event> events = new ArrayList<>();

    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private EventCategoryRepository eventCategoryRepository;

    @Autowired
    private TagRepository tagRepository;

    //find,findbyid,save

    @GetMapping
    public String displayAllEvents(@RequestParam (required = false) Integer categoryId, Model model){
        if(categoryId==null) {
            model.addAttribute("title","All Events");
            model.addAttribute("events", eventRepository.findAll());
        }
        else{
           Optional<EventCategory> result= eventCategoryRepository.findById(categoryId);
           if(result.isEmpty()){
            model.addAttribute("title" ,"Invalid Category Id " + categoryId);
           }
           else
           {
                EventCategory category =result.get();
                model.addAttribute("title","Events in Category " + category.getName());
                model.addAttribute("events",category.getEvent());
           }
        }
        return "events/index";
    }


    //lives at events/create
    @GetMapping("create")
    public String renderEventCreateForm(Model model){
        model.addAttribute("title","Create Event");
        model.addAttribute(new Event());
        model.addAttribute("categories",eventCategoryRepository.findAll());
        return "events/create";
    }

    @PostMapping("create")
    public String createEvent(@ModelAttribute @Valid Event newEvent,
                              Errors errors, Model model) {
        if(errors.hasErrors()) {
            model.addAttribute("title", "Create Event");
            return "events/create";
        }

        eventRepository.save(newEvent);
        return "redirect:";
    }

    @GetMapping("delete")
    public String displayDeleteEventForm(Model model){
        model.addAttribute("title","Delete Events");
        model.addAttribute("events",eventRepository.findAll());
        return "events/delete";
    }

    @PostMapping("delete")
    public String processDeleteEventForm(@RequestParam (required = false) int[] eventIds){
        if(eventIds != null) {
            for (int id : eventIds) {
                //EventData.removeEvent(id);
                eventRepository.deleteById(id);
            }
        }
        return "redirect:";
    }
    @GetMapping("detail")
    public String displayEventDetails(@RequestParam Integer eventId, Model model) {

        Optional<Event> result = eventRepository.findById(eventId);

        if (result.isEmpty()) {
            model.addAttribute("title", "Invalid Event ID: " + eventId);
        } else {
            Event event = result.get();
            model.addAttribute("title", event.getName() + " Details");
            model.addAttribute("event", event);
            model.addAttribute("tags",event.getTags());
        }

        return "events/detail";
    }


    //lives at events/add-tag?eventId=13
    @GetMapping("add-tag")
    public String displayAddTagForm(@RequestParam Integer eventId,Model model){
        Optional<Event> result = eventRepository.findById(eventId);
        Event event= result.get();
        model.addAttribute("title","Add tag to : " + event.getName() );
        model.addAttribute("tags",tagRepository.findAll());
        eventTagDTO eventTag = new eventTagDTO();
        eventTag.setEvent(event);
        model.addAttribute("eventTag",new eventTagDTO());
        return "events/add-tag.html";
    }

    @PostMapping("add-tag")
    public String processAddTagForm(@ModelAttribute @Valid eventTagDTO eventTag,
                                    Errors errors,
                                    Model model){

        if(!errors.hasErrors()){
            Event event= eventTag.getEvent();
            Tag tag = eventTag.getTag();
            if(!event.getTags().contains(tag)){
                event.addTag(tag);
                eventRepository.save(event);
            }
            return "redirect:detail?eventId= " + event.getId();
        }

        return "redirect:add-tag";
    }

}
