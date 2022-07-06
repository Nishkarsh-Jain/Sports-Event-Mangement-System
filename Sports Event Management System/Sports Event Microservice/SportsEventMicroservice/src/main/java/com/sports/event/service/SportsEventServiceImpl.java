package com.sports.event.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sports.event.entities.Events;
import com.sports.event.entities.Sports;
import com.sports.event.exceptions.EventAlreadyExistException;
import com.sports.event.exceptions.EventNotFoundException;
import com.sports.event.exceptions.SportAlreadyExistException;
import com.sports.event.exceptions.SportsNotFoundException;
import com.sports.event.repository.EventsRepository;
import com.sports.event.repository.SportsRepository;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class SportsEventServiceImpl {

	@Autowired
	private SportsRepository sportsRepository;
	@Autowired
	private EventsRepository eventsRepository;

	/*
	 * to add sport
	 * 
	 * @param sports object
	 * 
	 * @return boolean
	 */
	public boolean addSport(Sports sport) {
		boolean status = sportsRepository.existsById(sport.getSportId());
		if (!status) {
			log.info("Sport details saved.");
			sportsRepository.save(sport);
			return true;
		} else {
			log.info("Sport details already exists.");
			throw new SportAlreadyExistException("Sport already exists with sportId: " + sport.getSportId());
		}

	}

	/*
	 * to list all the sports
	 * 
	 * @return list<Sports>
	 */
	public List<Sports> sports() {
		log.info("list of all sports");
		List<Sports> sList = (List<Sports>) sportsRepository.findAll();
		if (sList.size() <= 0) {
			throw new SportsNotFoundException("No Sport is available.");
		} else {
			return sList;
		}

	}

	/*
	 * to find sport by its name
	 * 
	 * @param sport name
	 * 
	 * @return sports object
	 */
	public Sports sportsByName(String sportName) {
		log.info("Sports by its name");
		return sportsRepository.findBySportsName(sportName);

	}

	/*
	 * to add event
	 * 
	 * @param events object
	 * 
	 * @return boolean
	 */
	public boolean addEvent(Events event) {
		boolean status = sportsRepository.existsById(event.getEventId());
		if (!status) {
			log.info("Event details saved.");
			eventsRepository.save(event);
			return true;
		} else {
			log.info("Event details already exits.");
			throw new EventAlreadyExistException("Event already exists with sportId: " + event.getEventId());
		}
	}

	/*
	 * to delete event
	 * 
	 * @param event id
	 * 
	 * @return boolean
	 */
	public boolean deleteEvent(Long eventId) {
		Events event = eventsRepository.findByEventId(eventId);
		if (event!=null) {
			log.info("Event get deleted.");
			eventsRepository.deleteById(eventId);
			return true;
		} else {
			log.info("Event does not exits.");
			throw new EventNotFoundException("Event does not exists with eventId: " + eventId);
		}
	}

	/*
	 * to list all the events
	 * 
	 * @return List<Events>
	 */
	public List<Events> events() {
		log.info("list all the events");
		List<Events> eList = (List<Events>) eventsRepository.findAll();
		if (eList.size() <= 0) {
			throw new SportsNotFoundException("No Event is available.");
		} else {
			return eList;
		}

	}

	/*
	 * to find event by its name
	 * 
	 * @param event name
	 * 
	 * @return events object
	 */
	public Events eventsByName(String eventName) {
		log.info("Event by its name");
		Events events = eventsRepository.findByEventName(eventName);
		return events;
	}

}
