package org.launchcode.codingevent.data;

import org.launchcode.codingevent.models.Event;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class EventData {
    //need a place(any collection) to put all event we created
    private static final Map<Integer, Event> events = new HashMap<>();


    //add event in that place
    public static void addEvent(Event event){
        events.put(event.getId(),event);
    }




    //remove event from that place
    public static void removeEvent(int id){
        events.remove(id);
    }



    //get a single event using id
    public static Event getSingleEventById(int  id)
    {
        return events.get(id);
    }



    //get all events
    public static Collection<Event> getAll(){
    return events.values();
}


}
