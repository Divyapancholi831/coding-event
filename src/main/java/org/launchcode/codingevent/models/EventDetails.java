package org.launchcode.codingevent.models;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
public class EventDetails extends AbstractEntity{

    @Size(max=500,message = "Description is too long")
    private String description;

    @NotBlank(message="Email is required")
    @Email(message = "invalid email,try again !")
    private String contactEmail;

    @OneToOne(mappedBy = "eventDetails")
    private Event event;

    //constructor with parameters
    public EventDetails(@Size(max=500,message = "Description is too long") String description, String contactEmail) {
        this.description = description;
        this.contactEmail = contactEmail;
    }

    //constructor without parameter
    public EventDetails(){}

    //getter setter for description field
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    //getter setter for contactEmail field
    public String getContactEmail() {
        return contactEmail;
    }
    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }
}

