package com.cap.dev.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cap.dev.entities.Application;
import com.cap.dev.repositries.ApplicantRepo;
import com.cap.dev.repositries.ProgramsOfferedRepo;


@Service
public class ApplicantService {
	
	@Autowired
	private ApplicantRepo applicantrepo;
	
	
	public Application applyApplication(Application application) {
		
		return applicantrepo.save(application);
	}

	public String getApplicationStatus(int applicationId) {
	    return applicantrepo.findByApplicationId(applicationId);
	    
	}

	public Application getApplications(int scheduledProgramId) {
		return applicantrepo.getOne(scheduledProgramId);
		
	}

	
	 public Application acceptOrReject( Application application,int applicationId) { 
		 Application existingApplicant = (Application) applicantrepo.getOne(applicationId);
          existingApplicant.setApplicationId(applicationId);
	     BeanUtils.copyProperties(application, existingApplicant); int
	    status=applicantrepo.updateApplicantDetails(applicationId,existingApplicant.
	     getStatus()); return applicantrepo.getOne(applicationId); 
	     }
	 
	
	

	public List<Application> getApplicants(String status) {
		return applicantrepo.findByStatus(status);
	}

	

	

}

