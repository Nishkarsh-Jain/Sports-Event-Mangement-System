package com.sports.event.entities;

/*
 * Sports Entity 
 * */

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Sports {

	@Id
	@Column(name = "sports_id")
	private Long sportId;
	private int noOfPlayers;
	private String sportsName;
	private String sportsType;

	@OneToMany(mappedBy = "sport")
	private List<Events> event;

	
}