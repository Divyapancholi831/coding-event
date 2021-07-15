package org.launchcode.codingevent.models;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity
public class Event extends AbstractEntity{


    @NotBlank(message="Name is required")
    @Size(min=3,max=50,message = "Name must be between 3 and 50 characters")
    private String name;

    @Size(max=500,message = "Description is too long")
    private String description;

    @NotBlank(message="Email is required")
    @Email(message = "invalid email,try again !")
    private String contactEmail;

    //EventType is enum class type
    //private EventType type;

    //replace enum type with eventCategory which is simple java class for event category.

    @NotNull(message = "Category is required")
    @ManyToOne
    private EventCategory eventCategory;

    //constructor with arguments
    public Event(String name,String description,String contactEmail,EventCategory eventCategory) {
       //this();
       this.name = name;
       this.description=description;
       this.contactEmail=contactEmail;
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

    //getter setter for description
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    //getter setter for contact email
    public String getContactEmail() {
        return contactEmail;
    }
    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
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

    @Override
    public String toString() {
        return name;
    }

}
