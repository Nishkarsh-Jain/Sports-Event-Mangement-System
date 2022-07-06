package com.player.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.player.entity.Player;
import com.player.repository.PlayerRepository;
import lombok.extern.slf4j.Slf4j;

/**
 * Service Implementation for Player
 */

@Service
@Slf4j
public class PlayerServiceImpl implements PlayerService {

	@Autowired
	private PlayerRepository playerRepository;

	/**
	 * service layer for add Player using player
	 * 
	 * @param Player object
	 * @return String value based on addition of player
	 */
	public String addPlayer(Player player) {
		log.info("Player details get saved");
		playerRepository.save(player);
		String result = player + " added successfully";
		return result;
	}

	/**
	 * service layer for delete Player using player id
	 * 
	 * @param player id
	 * @return String value based on deletion of player
	 */
	public String deletePlayer(Long playerId) {
		log.info("Player details get deleted");
		String result = playerRepository.findByPlayerId(playerId) + " removed successfully";
		playerRepository.deleteById(playerId);
		return result;
	}

	/**
	 * service layer to display the list of all players
	 * 
	 * @return list of Players.
	 */
	public List<Player> listAllPlayers() {
		log.info("To list all players along with their details");
		List<Player> pList = (List<Player>) playerRepository.findAll();
		return pList;
	}
}
