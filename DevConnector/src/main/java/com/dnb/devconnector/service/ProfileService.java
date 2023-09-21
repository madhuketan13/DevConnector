package com.dnb.devconnector.service;

import java.util.Optional;

import com.dnb.devconnector.dto.Profile;

public interface ProfileService {
	
	public Profile createProfile(Profile profile);
	
	public Optional<Profile> getProfile(String userName);
	
	public Iterable<Profile> getAllProfiles();
}
