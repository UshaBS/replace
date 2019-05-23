package com.cap.dev.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import lombok.Data;

@Data
@Entity

@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
@SequenceGenerator(name = "seq", sequenceName = "seq", initialValue = 100, allocationSize = 1)
public class Application {
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
	private int applicationId;

	@NotNull(message = "This field is manadatory")
	private String fullName;
	@NotNull(message = "This field is manadatory")
	private String dateOfBirth;
	@NotNull(message = "This field is manadatory")
	private String highestQualification;
	@NotNull(message = "This field is manadatory")
	private double marksObtained;
	@NotNull(message = "This field is manadatory")
	private String goals;
	@NotNull(message = "This field is manadatory")
	private String emailId;
	@NotNull(message = "This field is manadatory")
	private int scheduledProgramId;

	private String status = "applied";
	private String dateOfInterview = null;

	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "scheduledProgramId", insertable = false, updatable = false)
	private ProgramsScheduled programsScheduled;

	@Override
	public String toString() {
		return "Application [applicationId=" + applicationId + ", fullName=" + fullName + ", dateOfBirth=" + dateOfBirth
				+ ", highestQualification=" + highestQualification + ", marksObtained=" + marksObtained + ", goals="
				+ goals + ", emailId=" + emailId + ", scheduledProgramId=" + scheduledProgramId + ", status=" + status
				+ ", dateOfInterview=" + dateOfInterview + ", programsScheduled=" + programsScheduled + "]";
	}

}
