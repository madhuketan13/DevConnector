package com.dnb.devconnector.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dnb.devconnector.dto.DevConnector;

@Repository
public interface DevConnectorRepository extends CrudRepository<DevConnector, String>{
	
	DevConnector findByemailAddress(String emailAddress);
}
