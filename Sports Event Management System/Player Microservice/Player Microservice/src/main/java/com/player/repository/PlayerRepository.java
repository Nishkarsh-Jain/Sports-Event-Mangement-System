package com.player.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.player.entity.Player;

/**
 * Repository for adding, fetching and manipulating players
 */

@Repository
public interface PlayerRepository extends CrudRepository<Player, Long> {

	Player findByPlayerId(Long playerId);
}
