package org.launchcode.codingevent.models;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by Chris Bay
 */
@Entity
public class EventCategory extends AbstractEntity{

    //name field
    @Size(min=3, message="Name must be at least 3 characters long")
    private String name;

    @OneToMany(mappedBy = "eventCategory")
    private final List<Event> event = new  ArrayList<>();

    //constructor with parameters
    public EventCategory(@Size(min = 3, message = "Name must be at least 3 characters long") String name) {
        this.name = name;
    }

    //constructor without parameter
    public EventCategory() {}

    //getter and setter for name
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }


    //getter for list of events..no setter bcux field is already set as final
    public List<Event> getEvent() {
        return event;
    }

    @Override
    public String toString() {
        return name;
    }

}

