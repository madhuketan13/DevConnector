package com.dnb.devconnector.dto;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import com.dnb.devconnector.utils.CustomEducationIdGenerator;
import com.dnb.devconnector.utils.CustomExperienceIdGenerator;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity
public class Experience {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "experience_seq")
	@GenericGenerator(name = "account_seq", strategy = "com.dnb.jdbcdemo.utils.CustomExperienceIdGenerator",
	parameters = {@Parameter(name = CustomExperienceIdGenerator.INCREMENT_PARAM, value = "50"),
	@Parameter(name = CustomExperienceIdGenerator.VALUE_PREFIX_PARAMETER, value = "exp_"),
	@Parameter(name = CustomExperienceIdGenerator.NUMBER_FORMAT_PARAMETER, value = "%05d")})
	private String experienceId;
	private String jobTitle;
	private String company;
	private String location;
	private String fromDate;
	private String toDate;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "profile_id")
	private Profile profile;
}
