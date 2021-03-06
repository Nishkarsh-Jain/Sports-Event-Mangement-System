package com.sports.event.entities;

import java.util.List;

/*
 * Events Entity
 * */

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Events {

	@Id
	@Column(name = "event_id")
	private Long eventId;
	private String eventDate;
	private String eventName;
	private int noofSlots;
	private String sportName;
	@ManyToOne
	private Sports sport;
	
}
