package com.cap.dev.services;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cap.dev.controller.AppController;
import com.cap.dev.entities.ProgramsScheduled;

import com.cap.dev.repositries.ProgramsScheduledRepo;


@Service
public class ProgramsScheduledervice{
	private Logger LOG = LoggerFactory.getLogger(ProgramsScheduledervice.class);
	@Autowired
	private ProgramsScheduledRepo programsscheduledrepo;
	
	public List<ProgramsScheduled> getAllPrograms() {
		LOG.info(programsscheduledrepo.toString());
		return programsscheduledrepo.findAll();
	}

	
	public ProgramsScheduled addProgramsScheduled(ProgramsScheduled programscheduled) {
		
		return programsscheduledrepo.save(programscheduled);
	}


	public ProgramsScheduled updateProgramsScheduled(ProgramsScheduled programscheduled) {
	    return programsscheduledrepo.save(programscheduled);
	}


	public String deleteProgramsScheduled(int scheduledProgramId) {
		programsscheduledrepo.deleteById(scheduledProgramId);
		return "Program got deleted successfully";
	}


	
	 public ProgramsScheduled getParticularProgram(String startDate, String endDate) 
	 { 
		 return programsscheduledrepo.getParticularProgram(startDate,endDate); }
	 

	

}
