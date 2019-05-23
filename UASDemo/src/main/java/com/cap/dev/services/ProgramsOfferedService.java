package com.cap.dev.services;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cap.dev.entities.Application;
import com.cap.dev.entities.ProgramsOffered;
import com.cap.dev.repositries.ProgramsOfferedRepo;



@Service
public class ProgramsOfferedService {
	
	@Autowired
	private ProgramsOfferedRepo programsofferedrepo;

	
	public ProgramsOffered addProgramsOffered(ProgramsOffered programsOffered) {
		return programsofferedrepo.save(programsOffered);
	}

	public ProgramsOffered updateProgramsOffered(ProgramsOffered programsOffered, String programName) {
		return programsofferedrepo.save(programsOffered);
	}

	public String deleteProgramsOffered(String programName) {
		programsofferedrepo.deleteById(programName);
		return "Program got deleted";
	}

	public List<ProgramsOffered> getPrograms() {
		
		return programsofferedrepo.findAll();
	}

}
