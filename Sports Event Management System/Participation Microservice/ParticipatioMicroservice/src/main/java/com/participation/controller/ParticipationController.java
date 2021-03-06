package com.participation.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.participation.entity.Participation;
import com.participation.service.ParticipationServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

/*
 * Controller for Participation
 * 
 * @author (POD-4)
 * */

@RestController
@RequestMapping("/participation")
public class ParticipationController {

	@Autowired
	private ParticipationServiceImpl participationServiceImpl;

	@Autowired
	private Participation participation;

	@Operation(summary = "Health Check")
	@GetMapping("/health-check")
	public ResponseEntity<String> healthCheck() {
		return new ResponseEntity<>("Ok", HttpStatus.OK);
	}

	/*
	 * to add new Participation request
	 * 
	 * @param Participation Object
	 * 
	 * @return ResponseEntity<String>
	 */

	@Operation(summary = "To add new Participation request")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Successfully apply for paticipation", content = {
					@Content(mediaType = "application/json"), }),
			@ApiResponse(responseCode = "201", description = "Request has succeeded and apply for participation", content = {
					@Content(mediaType = "application/json") }) })

	@PostMapping("/addParticipation")
	public ResponseEntity<String> addParticipation(@RequestHeader(name = "Authorization") String token,
			@RequestBody Participation part) {
		if (participationServiceImpl.addParticipation(part)) {
			return new ResponseEntity<>("Participation Request added successfully. ", HttpStatus.CREATED);
		} else {
			return new ResponseEntity<>("Participation Request with participation Id: "
					+ participation.getParticipationId() + " is not added. ", HttpStatus.EXPECTATION_FAILED);
		}
	}

	/*
	 * to display all Participation request.
	 * 
	 * @return ResponseEntity<List<Participation>>
	 */

	@Operation(summary = "To display list of all Participations request")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Success", content = {
					@Content(mediaType = "application/json"), }),
			@ApiResponse(responseCode = "400", description = "Bad Request", content = {
					@Content(mediaType = "application/json") }),
			@ApiResponse(responseCode = "404", description = "No content available", content = {
					@Content(mediaType = "application/json") }) })

	@GetMapping("/participations")
	public ResponseEntity<List<Participation>> listAllParticipation() {
		List<Participation> pList = participationServiceImpl.listAllParticipation();
		if (pList.size() <= 0) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.of(Optional.of(pList));
	}

	/*
	 * to update the Participation request.
	 * 
	 * @return ResponseEntity<<String>>
	 */

	@Operation(summary = "To update the Participations request")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Success", content = {
					@Content(mediaType = "application/json"), }),
			@ApiResponse(responseCode = "400", description = "Bad Request", content = {
					@Content(mediaType = "application/json") }) })

	@PutMapping("/updateStatus/{partId}")
	public ResponseEntity<String> updateStatus(Participation participation, @PathVariable("partId") Long partId) {
		if (participationServiceImpl.updateStatus(participation, partId)) {
			return new ResponseEntity<>(
					"Participation with participation id: " + partId + " is successfullly Updated!!!", HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Participation id is Invalid!!!", HttpStatus.BAD_REQUEST);
		}
	}

	/*
	 * to display all Approved Participation request.
	 * 
	 * @return ResponseEntity<List<Participation>>
	 */

	@Operation(summary = "To display list of all Approved Participations")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Success", content = {
					@Content(mediaType = "application/json"), }),
			@ApiResponse(responseCode = "400", description = "Bad Request", content = {
					@Content(mediaType = "application/json") }),
			@ApiResponse(responseCode = "404", description = "No content available", content = {
					@Content(mediaType = "application/json") }) })

	@GetMapping("/approvedParticipations")
	public ResponseEntity<List<Participation>> listApprovedParticipations() {
		List<Participation> aList = participationServiceImpl.listApprovedParticipations();
		if (aList.size() <= 0) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.of(Optional.of(aList));
	}

	/*
	 * to display all Declined Participation request.
	 * 
	 * @return ResponseEntity<List<Participation>>
	 */

	@Operation(summary = "To display list of all Declined Participations")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Success", content = {
					@Content(mediaType = "application/json"), }),
			@ApiResponse(responseCode = "400", description = "Bad Request", content = {
					@Content(mediaType = "application/json") }),
			@ApiResponse(responseCode = "404", description = "No content available", content = {
					@Content(mediaType = "application/json") }) })

	@GetMapping("/declinedParticipations")
	public ResponseEntity<List<Participation>> listDeclinedParticipations() {
		List<Participation> dList = participationServiceImpl.listDeclinedParticipations();
		if (dList.size() <= 0) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.of(Optional.of(dList));

	}

	/*
	 * to display all Pending Participation request.
	 * 
	 * @return ResponseEntity<List<Participation>>
	 */

	@Operation(summary = "To display list of all Pending Participations")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Success", content = {
					@Content(mediaType = "application/json"), }),
			@ApiResponse(responseCode = "400", description = "Bad Request", content = {
					@Content(mediaType = "application/json") }),
			@ApiResponse(responseCode = "404", description = "No content available", content = {
					@Content(mediaType = "application/json") }) })

	@GetMapping("/pendingParticipations")
	public ResponseEntity<List<Participation>> listPendingParticipations() {
		List<Participation> pList = participationServiceImpl.listPendingParticipations();
		if (pList.size() <= 0) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.of(Optional.of(pList));

	}

}
