package com.player.controller;

import java.util.List;
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
import com.player.entity.Player;
import com.player.service.PlayerServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

/**
 * @author (POD-4)
 * 
 *         Controller class for Player Microservice
 */

@RestController
@RequestMapping("/player")
@Tag(name = "Player")
public class PlayerController {

	@Autowired
	private PlayerServiceImpl playerServiceImpl;

	@GetMapping("/health-check")
	public ResponseEntity<String> healthCheck() {
		return new ResponseEntity<>("Ok", HttpStatus.OK);
	}

	/**
	 * To add player
	 * 
	 * @param token
	 * @param Player object
	 * @return String based on addition of player
	 */

	@Operation(summary = "To add new Player")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Player added Successfully", content = {
					@Content(mediaType = "application/json"), }),
			@ApiResponse(responseCode = "201", description = "Request has succeeded and a new player has been created", content = {
					@Content(mediaType = "application/json") }),
			@ApiResponse(responseCode = "401", description = "Request requires user authentication info", content = {
					@Content(mediaType = "application/json") }) })
	@PostMapping("/addPlayer")
	public String addPlayer(@RequestBody Player player) {
		return playerServiceImpl.addPlayer(player);
	}

	/**
	 * To delete Player
	 * 
	 * @param token
	 * @param playerId
	 * @return String based on deletion of player
	 */

	@Operation(summary = "To delete a Player")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Successfully deleted", content = {
					@Content(mediaType = "application/json"), }),
			@ApiResponse(responseCode = "201", description = "Request has succeeded and event is deleted", content = {
					@Content(mediaType = "application/json") }),
			@ApiResponse(responseCode = "401", description = "Request requires user authentication info", content = {
					@Content(mediaType = "application/json") }) })
	@DeleteMapping("/deletePlayer/{playerId}")
	public String deletePlayer(@PathVariable Long playerId) {
		return playerServiceImpl.deletePlayer(playerId);
	}

	/**
	 * display list of all Players
	 * 
	 * @param token
	 * @return list of players
	 */

	@Operation(summary = "To display list of players.")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Success", content = {
					@Content(mediaType = "application/json"), }),
			@ApiResponse(responseCode = "400", description = "Bad Request", content = {
					@Content(mediaType = "application/json") }),
			@ApiResponse(responseCode = "404", description = "No content available", content = {
					@Content(mediaType = "application/json") }) })
	@GetMapping("/players")
	public List<Player> listAllPlayers() {
		return playerServiceImpl.listAllPlayers();
	}

}
