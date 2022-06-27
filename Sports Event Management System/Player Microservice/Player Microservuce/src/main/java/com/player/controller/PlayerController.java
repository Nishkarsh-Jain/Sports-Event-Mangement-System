package com.player.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.player.entity.Player;
import com.player.service.PlayerService;

@RestController
@RequestMapping("/pm")
public class PlayerController {

	@Autowired
	private PlayerService ps;

	@PostMapping("/addPlayer")
	public String addPlayer(@RequestBody Player player) {
		return ps.addPlayer(player);
	}

	@DeleteMapping("/deletePlayer/{playerId}")
	public String deletePlayer(@PathVariable Long playerId) {
		return ps.deletePlayer(playerId);
	}

	@GetMapping("/players")
	public List<Player> listAllPlayers() {
		return ps.listAllPlayers();
	}

}
