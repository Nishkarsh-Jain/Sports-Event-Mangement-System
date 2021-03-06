package com.sports.event.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.sports.event.entities.Events;
import com.sports.event.entities.Sports;
import com.sports.event.service.SportsEventServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

/**
 * Controller class for SportsEventMicroservice
 * 
 * @author POD-4
 */

@RestController
@RequestMapping("/sem")
public class SportsEventController {

	@Autowired
	private SportsEventServiceImpl sportsEventServiceImpl;

	@Operation(summary = "Health Check")
	@GetMapping("/health-check")
	public ResponseEntity<String> healthCheck() {
		return new ResponseEntity<>("Ok", HttpStatus.OK);
	}

	/**
	 * to add sport using sports object
	 * 
	 * @param token
	 * @param sports object
	 * @return ResponseEntity<String>
	 */

	@Operation(summary = "To add new Sport")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Sport added Successfully", content = {
					@Content(mediaType = "application/json"), }),
			@ApiResponse(responseCode = "201", description = "Request has succeeded and a new sport has been created", content = {
					@Content(mediaType = "application/json") }),
			@ApiResponse(responseCode = "401", description = "Request requires user authentication info", content = {
					@Content(mediaType = "application/json") }) })
	@GetMapping("/addSport")
	public ResponseEntity<String> addSport(@RequestBody Sports sport) {
		if (sportsEventServiceImpl.addSport(sport)) {
			return new ResponseEntity<>(sport.getSportsName() + " added successfully. ", HttpStatus.CREATED);
		} else {
			return new ResponseEntity<>(sport.getSportsName() + " not added. ", HttpStatus.BAD_REQUEST);
		}
	}

	/**
	 * list all the sports
	 * 
	 * @param token
	 * @return ResponseEntity<List<Sports>>
	 */

	@Operation(summary = "To display all the Sports.")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Success", content = {
					@Content(mediaType = "application/json"), }),
			@ApiResponse(responseCode = "400", description = "Bad Request", content = {
					@Content(mediaType = "application/json") }),
			@ApiResponse(responseCode = "404", description = "No content available", content = {
					@Content(mediaType = "application/json") }) })
	@GetMapping("/sports")
	public ResponseEntity<List<Sports>> sports() {
		List<Sports> sList = sportsEventServiceImpl.sports();
		if (sList.size() <= 0) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.of(Optional.of(sList));
	}

	/**
	 * to search sport by its name
	 * 
	 * @param token
	 * @param sport name
	 * @return ResponseEntity<Sports>
	 */

	@Operation(summary = "To get specific Sport by its name.")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Success", content = {
					@Content(mediaType = "application/json"), }),
			@ApiResponse(responseCode = "400", description = "Bad Request", content = {
					@Content(mediaType = "application/json") }),
			@ApiResponse(responseCode = "404", description = "No content available", content = {
					@Content(mediaType = "application/json") }) })
	@GetMapping("/sports/{sportName}")
	public ResponseEntity<Sports> sportsByName(@PathVariable("sportName") String sportName) {
		Sports sport = sportsEventServiceImpl.sportsByName(sportName);
		if (sport == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.of(Optional.of(sport));
	}

	/**
	 * to add event using events object
	 * 
	 * @param token
	 * @param events object
	 * @return ResponseEntity<String>
	 */

	@Operation(summary = "To add new Event")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Success", content = {
					@Content(mediaType = "application/json"), }),
			@ApiResponse(responseCode = "201", description = "Request has succeeded and a new event has been created", content = {
					@Content(mediaType = "application/json") }),
			@ApiResponse(responseCode = "401", description = "Request requires user authentication info", content = {
					@Content(mediaType = "application/json") }) })
	@PostMapping("/addEvent")
	public ResponseEntity<String> addEvent(@RequestBody Events event) {
		if (sportsEventServiceImpl.addEvent(event)) {
			return new ResponseEntity<>(event.getEventName() + " added successfully. ", HttpStatus.CREATED);
		} else {
			return new ResponseEntity<>(event.getEventName() + " not added. ", HttpStatus.BAD_REQUEST);
		}
	}

	/**
	 * to delete event using event Id
	 * 
	 * @param token
	 * @param event id
	 * @return ResponseEntity<String>
	 */

	@Operation(summary = "To delete an Event")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Successfully deleted", content = {
					@Content(mediaType = "application/json"), }),
			@ApiResponse(responseCode = "201", description = "Request has succeeded and event is deleted", content = {
					@Content(mediaType = "application/json") }),
			@ApiResponse(responseCode = "401", description = "Request requires user authentication info", content = {
					@Content(mediaType = "application/json") }) })
	@DeleteMapping("/deleteEvent/{eventId}")
	public ResponseEntity<String> deleteEvent(@PathVariable("eventId") long eventId) {
		if (sportsEventServiceImpl.deleteEvent(eventId)) {
			return new ResponseEntity<>("Event with eventId: " + eventId + " deleted successfully. ", HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Event with eventId: " + eventId + " not get deleted. ",
					HttpStatus.EXPECTATION_FAILED);
		}
	}

	/**
	 * to list all the events
	 * 
	 * @param token
	 * @return ResponseEntity<List<Events>>
	 */

	@Operation(summary = "To display all the Events.")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Success", content = {
					@Content(mediaType = "application/json"), }),
			@ApiResponse(responseCode = "400", description = "Bad Request", content = {
					@Content(mediaType = "application/json") }),
			@ApiResponse(responseCode = "404", description = "No content available", content = {
					@Content(mediaType = "application/json") }) })
	@GetMapping("/events")
	public ResponseEntity<List<Events>> events() {
		List<Events> eList = sportsEventServiceImpl.events();
		if (eList.size() <= 0) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.of(Optional.of(eList));
	}

	/**
	 * to search event by its name
	 * 
	 * @param token
	 * @param event name
	 * @return ResponseEntity<Events>
	 */

	@Operation(summary = "To get specific Event by its name.")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Success", content = {
					@Content(mediaType = "application/json"), }),
			@ApiResponse(responseCode = "400", description = "Bad Request", content = {
					@Content(mediaType = "application/json") }),
			@ApiResponse(responseCode = "404", description = "No content available", content = {
					@Content(mediaType = "application/json") }) })
	@GetMapping("/events/{eventName}")
	public ResponseEntity<Events> eventsByName(@PathVariable("eventName") String eventName) {
		Events event = sportsEventServiceImpl.eventsByName(eventName);
		if (event == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.of(Optional.of(event));
	}

}
