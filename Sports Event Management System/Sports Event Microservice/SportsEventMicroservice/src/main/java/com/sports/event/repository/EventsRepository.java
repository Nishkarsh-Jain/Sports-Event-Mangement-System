package com.sports.event.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.sports.event.entities.Events;

/*
 * EventsRepository to perform CRUD operations
 * */

@Repository
public interface EventsRepository extends JpaRepository<Events, Long> {

	Events findByEventName(String eventName);
	Events findByEventId(Long id);

}
