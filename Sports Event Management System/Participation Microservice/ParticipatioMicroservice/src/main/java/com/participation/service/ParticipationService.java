package com.participation.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.participation.entity.Participation;

/*
 * Interface for Participation
 * */

@Service
public interface ParticipationService {

	public boolean addParticipation(Participation part);

	public boolean updateStatus(Participation part, Long partId);

	public List<Participation> listAllParticipation();

	public List<Participation> listApprovedParticipations();

	public List<Participation> listDeclinedParticipations();

	public List<Participation> listPendingParticipations();
}
