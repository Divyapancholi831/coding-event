package org.launchcode.codingevent.models;

import org.hibernate.annotations.Cascade;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity
public class Event extends AbstractEntity{


    @NotBlank(message="Name is required")
    @Size(min=3,max=50,message = "Name must be between 3 and 50 characters")
    private String name;

    //EventType is enum class type
    //private EventType type;

    //replace enum type with eventCategory which is simple java class for event category.
    @NotNull(message = "Category is required")
    @ManyToOne
    private EventCategory eventCategory;

    @OneToOne(cascade = CascadeType.ALL)
    @Valid
    @NotNull
    private EventDetails eventDetails;

    //constructor with arguments
    public Event(String name,EventCategory eventCategory) {
       //this();
       this.name = name;
       this.eventCategory=eventCategory;

   }

   //constructor without arguments
    public Event(){
       // this.id=nextId;
       // nextId++;
    }


    //getter setter for name
    public String getName() {
        return name;
    }
   public void setName(String name) {
        this.name = name;
    }

    //getter setter for type(enum class)
   // public EventType getType() { return type; }
    // public void setType(EventType type) { this.type = type; }

    //getter and setter for eventCategory
    public EventCategory getEventCategory() {
        return eventCategory;
    }
    public void setEventCategory(EventCategory eventCategory) {
        this.eventCategory = eventCategory;
    }

    //getter and setter for eventDetails
    public EventDetails getEventDetails() {
        return eventDetails;
    }
    public void setEventDetails(EventDetails eventDetails) {
        this.eventDetails = eventDetails;
    }

    @Override
    public String toString() {
        return name;
    }

}
