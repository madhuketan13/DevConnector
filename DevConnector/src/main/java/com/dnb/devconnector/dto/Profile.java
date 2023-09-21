package com.dnb.devconnector.dto;

import java.util.List;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.springframework.data.repository.query.Param;

import com.dnb.devconnector.utils.CustomProfileIdGenerator;
import com.dnb.devconnector.utils.CustomUserIdGenerator;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class Profile {	
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "profile_seq")
	@GenericGenerator(name = "account_seq", strategy = "com.dnb.jdbcdemo.utils.CustomProfileIdGenerator",
	parameters = {@Parameter(name = CustomProfileIdGenerator.INCREMENT_PARAM, value = "50"),
	@Parameter(name = CustomProfileIdGenerator.VALUE_PREFIX_PARAMETER, value = "profile_"),
	@Parameter(name = CustomProfileIdGenerator.NUMBER_FORMAT_PARAMETER, value = "%05d")})
	@Column private Long profileId;
	@Column private String professionalStatus;
	@Column private String company;
	@Column private String website;
	@Column private String location;
	@Column private String skills;
	@Column private String githubUsername;
	
	@OneToOne
	@JoinColumn(name = "user_id")
	private DevConnector user;
	
	@OneToMany(mappedBy = "profile", cascade = CascadeType.ALL)
	List<Experience> experience;
	
	@OneToMany(mappedBy = "profile", cascade = CascadeType.ALL)
	List<Education> education;

}
