package com.cap.dev.controller;

import java.io.PrintWriter;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cap.dev.Exception.UniversityAdmissionException;
import com.cap.dev.entities.Application;
import com.cap.dev.entities.ProgramsOffered;
import com.cap.dev.entities.ProgramsScheduled;
import com.cap.dev.repositries.ProgramsScheduledRepo;
import com.cap.dev.services.ApplicantService;
import com.cap.dev.services.ProgramsOfferedService;
import com.cap.dev.services.ProgramsScheduledervice;

@RestController
public class AppController {

	private Logger LOG = LoggerFactory.getLogger(AppController.class);

	@Autowired
	private ApplicantService applicantServ;

	@Autowired
	private ProgramsScheduledervice programsScheduledServ;

	@Autowired
	private ProgramsOfferedService programsOfferedServ;
	@Autowired
	private ProgramsScheduledRepo programsscheduledrepo;
	
	@Value("${logging.file}")
	String path;

	/************************************
	 * Applicant services
	 *********************************************/

	@GetMapping("/exception")
	public String getException() {
		String ex = null;
		try {
			LOG.info("Exception LOgged");
			throw new Exception("Exception throwed");
		} catch (Exception e) {
			LOG.error("Exception---" + e.toString());
			ex = e.toString();
		}

		return ex;
	}

	@RequestMapping(value = "/scheduledprograms")
	public List<ProgramsScheduled> getAllPrograms() throws UniversityAdmissionException {
		try {
			LOG.info("getAllPrograms");
			return programsScheduledServ.getAllPrograms();
		} catch (Exception e) {
			throw new UniversityAdmissionException(204, e.getMessage());
		}
	}

	@RequestMapping(value = "/applyapplication", method = RequestMethod.POST)
	public Application applyApplication(@RequestBody Application application) throws UniversityAdmissionException {
		try {
			LOG.info("applyApplication");
			LOG.info(application.toString());
			return applicantServ.applyApplication(application);
		} catch (Exception e) {
			throw new UniversityAdmissionException(500, e.getMessage());
		}
	}

	@RequestMapping(value = "/getapplicationstatus/{applicationId}")
	public String getApplicationStatus(@PathVariable int applicationId) throws UniversityAdmissionException {
		try {
			LOG.info("getApplicationStatus----" + applicationId);
			String status = applicantServ.getApplicationStatus(applicationId);
			LOG.info("Status-----" + status);
			return status;
		} catch (Exception e) {
			throw new UniversityAdmissionException(204, e.getMessage());
		}

	}

	/***************************
	 * MAC Services
	 ***************************************/

	@RequestMapping(value = "/getapplication/{scheduledProgramId}")
	public Application getApplications(@PathVariable int scheduledProgramId) throws UniversityAdmissionException {
		try {
			LOG.info("getApplications---------" + scheduledProgramId);
			Application application = applicantServ.getApplications(scheduledProgramId);
			LOG.info(application.toString());
			return application;
		} catch (Exception e) {
			throw new UniversityAdmissionException(204, e.getMessage());
		}
	}

	@RequestMapping(value = "/applicationstatus/{applicationId}", method = RequestMethod.PUT)
	public Application acceptOrReject(@RequestBody Application application, @PathVariable int applicationId)
			throws UniversityAdmissionException {
		try {
			return applicantServ.acceptOrReject(application, applicationId);
		} catch (Exception e) {
			throw new UniversityAdmissionException(204, e.getMessage());
		}
	}

	/********************************
	 * Administration Services
	 ********************************************************/

	/*****************************************
	 * ProgramsScheduled
	 *****************************************/

	@RequestMapping(value = "/programsScheduled", method = RequestMethod.POST)
	public ProgramsScheduled addProgramsScheduled(@RequestBody ProgramsScheduled programscheduled)
			throws UniversityAdmissionException {
		try {
			LOG.info("addProgramsScheduled");
			LOG.info(programscheduled.toString());
			return programsScheduledServ.addProgramsScheduled(programscheduled);
		} catch (Exception e) {
			throw new UniversityAdmissionException(400, e.getMessage());
		}
	}

	@RequestMapping(value = "/programsScheduled", method = RequestMethod.PUT)
	public ProgramsScheduled updateProgramsScheduled(@RequestBody ProgramsScheduled programscheduled)
			throws UniversityAdmissionException {
		try {
			return programsScheduledServ.updateProgramsScheduled(programscheduled);
		} catch (Exception e) {
			throw new UniversityAdmissionException(204, e.getMessage());
		}
	}

	@RequestMapping(value = "/programsScheduled/{scheduledProgramId}", method = RequestMethod.DELETE)
	public String deleteProgramsScheduled(@PathVariable int scheduledProgramId) throws UniversityAdmissionException {
		try {
			return programsScheduledServ.deleteProgramsScheduled(scheduledProgramId);
		} catch (Exception e) {
			throw new UniversityAdmissionException(204, e.getMessage());
		}

	}

	/*****************************************
	 * ProgramsOffered
	 ******************************************/

	@RequestMapping(value = "/programsOfferedpost", method = RequestMethod.POST)
	public ProgramsOffered addProgramsOffered(@RequestBody ProgramsOffered programsOffered)
			throws UniversityAdmissionException {
		try {
			  
			LOG.info("addProgramsOffered");
			LOG.info(programsOffered.toString());
			return programsOfferedServ.addProgramsOffered(programsOffered);
		} catch (Exception e) {
			throw new UniversityAdmissionException(204, e.getMessage());
		}
	}

	@RequestMapping(value = "/programsOffered/{programName}", method = RequestMethod.PUT)
	public ProgramsOffered updateProgramsOffered(@RequestBody ProgramsOffered programsOffered,
			@PathVariable String programName) throws UniversityAdmissionException {
		try {
			return programsOfferedServ.updateProgramsOffered(programsOffered, programName);
		} catch (Exception e) {
			throw new UniversityAdmissionException(204, e.getMessage());
		}
	}

	@RequestMapping(value = "/programsOffered/{programName}", method = RequestMethod.DELETE)
	public String deleteProgramsOffered(@PathVariable String programName) throws UniversityAdmissionException {
		try {
			return programsOfferedServ.deleteProgramsOffered(programName);
		} catch (Exception e) {
			throw new UniversityAdmissionException(204, e.getMessage());
		}
	}

	@RequestMapping(value = "/programsOffered")
	public List<ProgramsOffered> getPrograms() throws UniversityAdmissionException {
		try {
			return programsOfferedServ.getPrograms();
		} catch (Exception e) {
			throw new UniversityAdmissionException(204, e.getMessage());
		}
	}

	/*************************** Applicant ******************************/

	@RequestMapping(value = "/applicationGet/{status}", method = RequestMethod.GET)
	public List<Application> getAllApplicants(@PathVariable String status) throws UniversityAdmissionException {
		try {
			return applicantServ.getApplicants(status);
		} catch (Exception e) {
			throw new UniversityAdmissionException(204, e.getMessage());
		}
	}

	@RequestMapping(value = "/ProgramsScheduledProgram/{startDate}/{endDate}")
	public ProgramsScheduled getParticularProgram(@PathVariable String startDate, @PathVariable String endDate)
			throws UniversityAdmissionException {
		startDate = startDate.replace('/', '-');
		endDate = endDate.replace('/', '-');
		try {
			return programsScheduledServ.getParticularProgram(startDate, endDate);
		} catch (Exception e) {
			throw new UniversityAdmissionException(204, e.getMessage());
		}
	}

}
