package org.launchcode.codingevent.models.dto;

import org.launchcode.codingevent.models.Event;
import org.launchcode.codingevent.models.Tag;

import javax.validation.constraints.NotNull;

public class eventTagDTO {
    @NotNull
    private Event event;
    @NotNull
    private Tag tag;

    public eventTagDTO(){}

    //getter and setter
    public Event getEvent() {
        return event;
    }
    public void setEvent(Event event) {
        this.event = event;
    }

    public Tag getTag() {
        return tag;
    }
    public void setTag(Tag tag) {
        this.tag = tag;
    }
}
