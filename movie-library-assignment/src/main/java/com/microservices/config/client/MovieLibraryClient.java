package com.microservices.config.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import com.microservices.web.ClientController;
import com.microservices.web.ClientMovieLibraryService;

@SpringBootApplication
@EnableDiscoveryClient
public class MovieLibraryClient {

	public static final String MOVIE_LIBRARY_SERVICE_URL = "http://MOVIE-SERVICE";
	
	
	public static void main(String[] args) {
	    System.setProperty("spring.config.name", "movie-library-service");
		SpringApplication.run(MovieLibraryClient.class, args);
	}
	
	@LoadBalanced
	@Bean
	RestTemplate restTemplate() {
		return new RestTemplate();
	}

	@Bean
	public ClientMovieLibraryService accountsService() {
		return new ClientMovieLibraryService(MOVIE_LIBRARY_SERVICE_URL);
	}

	@Bean
	public ClientController accountsController() {
		return new ClientController(accountsService());
	}
	
}
