package org.launchcode.codingevent.models;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Objects;

public class Event {
    private int id;
    private static int nextId=1;

    @NotBlank(message="Name is required")
    @Size(min=3,max=50,message = "Name must be between 3 and 50 characters")
    private String name;

    @Size(max=500,message = "Description is too long")
    private String description;

    @NotBlank(message="Email is required")
    @Email(message = "invalid email,try again !")
    private String contactEmail;

    //EventType is enum class type
    private EventType type;

    //constructor with arguments
    public Event(String name,String description,String contactEmail,EventType type) {
       this();
       this.name = name;
       this.description=description;
       this.contactEmail=contactEmail;
       this.type=type;

   }

   //constructor without arguments
    public Event(){
        this.id=nextId;
        nextId++;
    }

   public int getId() {
        return id;
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
    public EventType getType() { return type; }
    public void setType(EventType type) { this.type = type; }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Event event = (Event) o;
        return id == event.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
