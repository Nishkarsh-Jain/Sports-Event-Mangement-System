package com.player.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.player.entity.Player;

/**
 * Service interface for Player
 */

@Service
public interface PlayerService {

	public String addPlayer(Player player);

	public String deletePlayer(Long playerId);

	public List<Player> listAllPlayers();
}
