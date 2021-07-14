package org.launchcode.codingevent.data;

import org.launchcode.codingevent.models.EventCategory;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Chris Bay
 */
@Repository
public interface EventCategoryRepository extends CrudRepository<EventCategory, Integer> {

}
