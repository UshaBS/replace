package com.cap.dev;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.cap.dev.entities.Application;
import com.cap.dev.entities.ProgramsOffered;
import com.cap.dev.entities.ProgramsScheduled;
import com.cap.dev.repositries.ApplicantRepo;
import com.cap.dev.repositries.ProgramsOfferedRepo;
import com.cap.dev.repositries.ProgramsScheduledRepo;
import com.cap.dev.services.ApplicantService;
import com.cap.dev.services.ProgramsOfferedService;
import com.cap.dev.services.ProgramsScheduledervice;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UasDemoApplicationTests {
	@Mock
	private ApplicantRepo applicantrepo;
	
	@Mock
	private ProgramsOfferedRepo programsofferedrepo;
	
	@Mock
	private ProgramsScheduledRepo programsscheduledrepo;
	
	@InjectMocks
	private ApplicantService applicantservice;
	
	@InjectMocks
	private ProgramsOfferedService programsofferedservice;
	
	@InjectMocks
	private ProgramsScheduledervice programsscheduledservice;

	@Test
	public void applyPostTest() throws Exception{
		
		Application application=new Application();
		application.setApplicationId(123);
		application.setDateOfBirth("02/01/1996");
		application.setFullName("Usha");
		application.setEmailId("usha@gmail.com");
		application.setGoals("Developer");
		application.setHighestQualification("BE");
		application.setMarksObtained(700);
		application.setStatus("applied");
		ProgramsScheduled programsScheduled = new ProgramsScheduled();
		programsScheduled.setScheduledProgramId(1000);
		application.setProgramsScheduled(programsScheduled);
		when(programsscheduledrepo.getOne(1000)).thenReturn(programsScheduled);
		when(applicantrepo.save(application)).thenReturn(application);
		Application expectedApplication = applicantservice.applyApplication(application);
		System.out.println(application.toString());
		System.out.println(expectedApplication.toString());
		assertEquals(application, expectedApplication);
		
	}
	
	
	
	@Test
	public void addPostTest() throws Exception{
		ProgramsScheduled programsscheduled = new ProgramsScheduled();
		programsscheduled.setScheduledProgramId(1000);
		programsscheduled.setProgramName("java");
		programsscheduled.setLocation("Bangalore");
		programsscheduled.setStartDate("1/03/2018");
		programsscheduled.setEndDate("1/04/2018");
		programsscheduled.setSessionsPerWeek(3);
		when(programsscheduledrepo.save(programsscheduled)).thenReturn(programsscheduled);
		ProgramsScheduled excepted=programsscheduledservice.addProgramsScheduled(programsscheduled);
		System.out.println(programsscheduled.toString());
		System.out.println(excepted.toString());
		assertEquals(excepted, programsscheduled);
	  }
	
	
	
	  @Test public void applyUpdateTest() throws Exception{ ProgramsScheduled
	  programsscheduled=new ProgramsScheduled();
	  programsscheduled.setScheduledProgramId(1000);
	  programsscheduled.setProgramName("Python");
	  programsscheduled.setLocation("Hyderabad");
	  programsscheduled.setStartDate("1/03/2018");
	  programsscheduled.setEndDate("1/04/2018");
	  programsscheduled.setSessionsPerWeek(3); 
	 
	  when(programsscheduledrepo.getOne(1000)).thenReturn(programsscheduled);
	  
	  ProgramsScheduled programsscheduledExpected=programsscheduledservice.updateProgramsScheduled(programsscheduled);
	  assertNotEquals(programsscheduledExpected,programsscheduled);
	 
	 }
	 
	
	
}
	
	
	
	
	
	
	
	
	


