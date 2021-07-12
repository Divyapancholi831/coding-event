package org.launchcode.codingevent.data;

import org.launchcode.codingevent.models.Event;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface eventRepository extends CrudRepository<Event,Integer>{

}
