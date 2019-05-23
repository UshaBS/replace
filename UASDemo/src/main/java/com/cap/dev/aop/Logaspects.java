package com.cap.dev.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cap.dev.Exception.UniversityAdmissionException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

public class Logaspects {

	private final Logger slf4jLogger = LoggerFactory.getLogger(this.getClass());
	 
	private ObjectMapper mapper = new ObjectMapper();

	@Before("execution(* com.cap.dev.services.ApplicantServ..*(..))")
	public void applicationServLogging(JoinPoint joint) throws UniversityAdmissionException {
		mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
		try {
			slf4jLogger.info("Begin of - " + joint.getStaticPart().getSignature().getName() + " method");
			slf4jLogger.info("Info Input Parameters -:\n " + mapper.writerWithDefaultPrettyPrinter().writeValueAsString(joint.getArgs()));
		} catch (JsonProcessingException e) {
			throw new UniversityAdmissionException(400, e.getMessage());
		}

	}
	
	@Before("execution(* com.cap.dev.services.ProgramsOfferedServ..*(..))")
	public void programsOfferedServLogging(JoinPoint joint) throws UniversityAdmissionException {
		mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
		try {
			slf4jLogger.info("Begin of - " + joint.getStaticPart().getSignature().getName() + " method");
			slf4jLogger.info("Info Input Parameters -:\n " + mapper.writerWithDefaultPrettyPrinter().writeValueAsString(joint.getArgs()));
		} catch (JsonProcessingException e) {
			throw new UniversityAdmissionException(400, e.getMessage());
		}

	}
	@Before("execution(* com.cap.dev.services.ProgramsScheduledServ..*(..))")
	public void ProgramsScheduledServLogging(JoinPoint joint) throws UniversityAdmissionException {
		mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
		try {
			slf4jLogger.info("Begin of - " + joint.getStaticPart().getSignature().getName() + " method");
			slf4jLogger.info("Info Input Parameters -:\n " + mapper.writerWithDefaultPrettyPrinter().writeValueAsString(joint.getArgs()));
		} catch (JsonProcessingException e) {
			throw new UniversityAdmissionException(400, e.getMessage());
		}

	}
	@AfterReturning(pointcut = "execution(* com.cap.dev.services.ApplicantServ.*(..))", returning = "result")
	public void applicationServAfterLogging(JoinPoint joint, Object result) throws UniversityAdmissionException {
		mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
		try {

			slf4jLogger.info("Info Output Parameters -: \n "
					+ mapper.writerWithDefaultPrettyPrinter().writeValueAsString(null != result ? result : ""));
			slf4jLogger.debug("end of  - " + joint.getStaticPart().getSignature().getName() + " method");
		} catch (JsonProcessingException e) {
			throw new UniversityAdmissionException(400, e.getMessage());
		}
	}
	@AfterReturning(pointcut = "execution(* com.cap.dev.services.ProgramsOfferedServ.*(..))", returning = "result")
	public void programsOfferedServAfterLogging(JoinPoint joint, Object result) throws UniversityAdmissionException {
		mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
		try {

			slf4jLogger.info("Info Output Parameters -: \n "
					+ mapper.writerWithDefaultPrettyPrinter().writeValueAsString(null != result ? result : ""));
			slf4jLogger.debug("end of  - " + joint.getStaticPart().getSignature().getName() + " method");
		} catch (JsonProcessingException e) {
			throw new UniversityAdmissionException(400, e.getMessage());
		}
	}
	@AfterReturning(pointcut = "execution(* com.cap.dev.services.ProgramsOfferedServ.*(..))", returning = "result")
	public void programsScheduledServAfterLogging(JoinPoint joint, Object result) throws UniversityAdmissionException {
		mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
		try {

			slf4jLogger.info("Info Output Parameters -: \n "
					+ mapper.writerWithDefaultPrettyPrinter().writeValueAsString(null != result ? result : ""));
			slf4jLogger.debug("end of  - " + joint.getStaticPart().getSignature().getName() + " method");
		} catch (JsonProcessingException e) {
			throw new UniversityAdmissionException(400, e.getMessage());
		}
	}
	
	
	
	
	
	
}
