package com.sports.event.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.sports.event.entities.Events;
import com.sports.event.entities.Sports;

/*
 * Service based on SportsEventService 
 * */

@Service
public interface SportsEventService {

	public boolean addSport(Sports sport);

	public List<Sports> sports();

	public Sports sportsByName(String sportName);

	public boolean addEvent(Events event);

	public boolean deleteEvent(Long eventId);

	public List<Events> events();

	public Events eventsByName(String eventName);

}
