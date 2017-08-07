package com.microservices.service.utils;

import javax.inject.Inject;

import org.springframework.stereotype.Component;

@Component
public class UUIDGeneratorFactory {

	@Inject
	private UUIDGenerator uuidGenerator;

	public UUIDGenerator getUUIDGenerator(){
		return this.uuidGenerator;
	}
	
}
