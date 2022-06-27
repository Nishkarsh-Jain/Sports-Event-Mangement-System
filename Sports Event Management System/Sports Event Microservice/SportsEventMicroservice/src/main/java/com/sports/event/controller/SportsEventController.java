package com.sports.event.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.sports.event.entity.Events;
import com.sports.event.entity.Sports;
import com.sports.event.service.SportsEventService;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping("/sem")
public class SportsEventController {

	@Autowired
	private SportsEventService ss;

	@GetMapping("/sports")
	public List<Sports> listAllSportsDetails() {
		log.info("Inside listAllSportsDetails method of the Sports Controller.");
		return ss.listAllSportsDetails();
	}

	@GetMapping("/sports/{sportName}")
	public Sports getSportsByName(@PathVariable("sportName") String sportName) {
		log.info("Inside getSportsByName method of the Sports Controller.");
		return ss.getSportsByName(sportName);
	}

	@PostMapping("/addEvent")
	public String addEvent(@RequestBody Events event) {
		log.info("Inside addEvent method of the Sports Controller.");
		return ss.addEvent(event);
	}

	@DeleteMapping("/deleteEvent/{eventId}")
	public String deleteEvent(@PathVariable("eventId") long eventId) {
		log.info("Inside delete method of the Sports Controller.");
		return ss.deleteEvent(eventId);

	}

	@GetMapping("/events")
	public List<Events> events() {
		log.info("Inside events method of the Sports Controller.");
		return ss.events();
	}

	@GetMapping("/events/{eventName}")
	public Events eventsByName(@PathVariable("eventName") String eventName) {
		log.info("Inside eventNyName method of the Sports Controller.");
		return ss.eventsByName(eventName);
	}

}
