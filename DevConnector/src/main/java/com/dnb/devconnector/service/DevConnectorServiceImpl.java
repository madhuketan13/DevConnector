package com.dnb.devconnector.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dnb.devconnector.dto.DevConnector;
import com.dnb.devconnector.dto.Profile;
import com.dnb.devconnector.repo.DevConnectorRepository;

@Service
public class DevConnectorServiceImpl implements DevConnectorService {
	
	@Autowired
	DevConnectorRepository devConnectorRepository;

	@Override
	public DevConnector register(DevConnector user , Profile profile) {
		
		// TODO Auto-generated method stub
		profile.setUser(user);
		user.setProfile(profile);
		return devConnectorRepository.save(user);
	}

	@Override
	public Optional<DevConnector> getUser(String emailAddress) {
		// TODO Auto-generated method stub
		return devConnectorRepository.findById(emailAddress);
	}

	@Override
	public boolean delete(String emailAddress) {
		if(devConnectorRepository.existsById(emailAddress)) {
			devConnectorRepository.deleteById(emailAddress);
			return true;
		}
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterable<DevConnector> getAllUsers() {
		// TODO Auto-generated method stub
		return devConnectorRepository.findAll();
	}
	
	public DevConnector findByemailAddress(String emailAddress) {
		return devConnectorRepository.findByemailAddress(emailAddress);
	}

}
