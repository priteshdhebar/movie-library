package com.microservices.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableDiscoveryClient
@ComponentScan(useDefaultFilters = false) // Disable component scanner
public class ClientMovieLibraryDiscovery {

	public static final String ACCOUNTS_SERVICE_URL = "http://ACCOUNTS-SERVICE";

	public static void main(String[] args) {
		System.setProperty("spring.config.name", "web-server");
		SpringApplication.run(ClientMovieLibraryDiscovery.class, args);
	}

	@LoadBalanced
	@Bean
	RestTemplate restTemplate() {
		return new RestTemplate();
	}

	@Bean
	public ClientMovieLibraryService accountsService() {
		return new ClientMovieLibraryService(ACCOUNTS_SERVICE_URL);
	}

	@Bean
	public ClientController accountsController() {
		return new ClientController(accountsService());
	}
	
}
