package com.dnb.devconnector.dto;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.springframework.data.repository.query.Param;

import com.dnb.devconnector.utils.CustomEducationIdGenerator;

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
public class Education {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "education_seq")
	@GenericGenerator(name = "account_seq", strategy = "com.dnb.jdbcdemo.utils.CustomAccountIdGenerator",
	parameters = {@Parameter(name = CustomEducationIdGenerator.INCREMENT_PARAM, value = "50"),
	@Parameter(name = CustomEducationIdGenerator.VALUE_PREFIX_PARAMETER, value = "edu_"),
	@Parameter(name = CustomEducationIdGenerator.NUMBER_FORMAT_PARAMETER, value = "%05d")})
	private String educationId;
	private String schoolName;
	private String startDate;
	private String endDate;
	private boolean currentSchool = false;
	private String degree;
	private String fieldOfStudy;
	private String description;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "profile_id")
	private Profile profile;

}
