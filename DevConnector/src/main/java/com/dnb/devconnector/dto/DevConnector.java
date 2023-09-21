package com.dnb.devconnector.dto;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import com.dnb.devconnector.utils.CustomUserIdGenerator;

import jakarta.annotation.Generated;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class DevConnector {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_seq")
	@GenericGenerator(name = "account_seq", strategy = "com.dnb.jdbcdemo.utils.CustomUserIdGenerator",
	parameters = {@Parameter(name = CustomUserIdGenerator.INCREMENT_PARAM, value = "50"),
	@Parameter(name = CustomUserIdGenerator.VALUE_PREFIX_PARAMETER, value = "user_"),
	@Parameter(name = CustomUserIdGenerator.NUMBER_FORMAT_PARAMETER, value = "%05d")})
	@Column private Long userId;
	private String userName;
	private String emailAddress;
	private String password;
	
	@OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private Profile profile;
}
