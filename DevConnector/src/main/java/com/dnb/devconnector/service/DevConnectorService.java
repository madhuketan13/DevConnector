package com.dnb.devconnector.service;

import java.util.Optional;

import com.dnb.devconnector.dto.DevConnector;
import com.dnb.devconnector.dto.Profile;

public interface DevConnectorService {
	
	public DevConnector register(DevConnector user, Profile profile);
	
	public Optional<DevConnector> getUser(String emailAddress);
	
	public boolean delete(String emailAddress);
	
	public Iterable<DevConnector> getAllUsers();
	
	public DevConnector findByemailAddress(String emailAddress);
}
