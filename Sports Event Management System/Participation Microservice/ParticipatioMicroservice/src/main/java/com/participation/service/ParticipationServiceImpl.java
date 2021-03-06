package com.participation.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.participation.entity.Participation;
import com.participation.exception.ParticipationAlreadyAppliedException;
import com.participation.repository.ParticipationRepository;

import lombok.extern.slf4j.Slf4j;

/*
 * Service for Participation
 * */

@Service
@Slf4j
public class ParticipationServiceImpl implements ParticipationService {

	@Autowired
	private ParticipationRepository participationRepository;

	@Autowired
	private Participation participation;

	public boolean addParticipation(Participation part) {
		log.info("Request for Participation get added.");
		participationRepository.save(part);
		return true;
	}

	public List<Participation> listAllParticipation() {
		List<Participation> pList = (List<Participation>) participationRepository.findAll();
		log.info("To list all Participations");
		return pList;
	}

	public boolean updateStatus(Participation partObj, Long partId) {
		Boolean status = false;
		if (participationRepository.findByParticipationId(partId) != null) {
			participationRepository.deleteById(partId);
			participation.setParticipationId(partId);
			participationRepository.save(partObj);
			status = true;
		}
		return status;
	}

	public List<Participation> listApprovedParticipations() {
		List<Participation> aList = participationRepository.findByStatus("Approved");
		log.info("To list all Approved Participations");
		return aList;
	}

	public List<Participation> listDeclinedParticipations() {
		List<Participation> dList = participationRepository.findByStatus("Declined");
		log.info("To list all Decline Participations");
		return dList;
	}

	public List<Participation> listPendingParticipations() {
		List<Participation> pList = participationRepository.findByStatus("Pending");
		log.info("To list all Pending Participations");
		return pList;
	}

}
