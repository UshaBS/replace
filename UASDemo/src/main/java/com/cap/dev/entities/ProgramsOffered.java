package com.cap.dev.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import lombok.Data;
@Data
@Entity
@JsonSerialize(include=JsonSerialize.Inclusion.NON_NULL)
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class ProgramsOffered {
	
@Id	
@Column
@NotNull(message = "Program name is mandatory")
private String programName;

@NotNull(message = "Description is mandatory")
private String description;

@NotNull(message = "Applicant eligibility is mandatory")
private String applicantEligibility;

@NotNull(message = "Duration is mandatory")
public int duration;

@NotNull(message = "Degree certificate is mandatory")
public String degreeCertificateOffered;

	
 @JsonIgnore
 @OneToMany(mappedBy ="programsOffered")
 private List<ProgramsScheduled> programScheduled;




}
