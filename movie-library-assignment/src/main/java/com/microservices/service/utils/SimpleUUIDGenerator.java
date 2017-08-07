package com.microservices.service.utils;

import java.util.UUID;

import org.springframework.stereotype.Component;

@Component
public class SimpleUUIDGenerator implements UUIDGenerator{

	@Override
	public String generate(String keyPrefix) {
		StringBuffer sb = new StringBuffer(keyPrefix.substring(0,3));
		return sb.append('-')
				.append(UUID.randomUUID().toString()).toString();
	}
}
