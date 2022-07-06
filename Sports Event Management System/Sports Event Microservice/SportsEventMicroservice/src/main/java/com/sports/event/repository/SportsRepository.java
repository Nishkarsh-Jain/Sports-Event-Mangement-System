package com.sports.event.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.sports.event.entities.Sports;

/*
 *  SportsRepository to perform CRUD operations
 *  */

@Repository
public interface SportsRepository extends CrudRepository<Sports, Long> {

	Sports findBySportsName(String sportName);

}
