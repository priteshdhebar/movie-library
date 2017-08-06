package com.assignment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class MovieLibraryAssignmentApplication {

	public static void main(String[] args) {
		// Tell Boot to look for registration-server.yml
	    System.setProperty("spring.config.name", "application-dev");
		SpringApplication.run(MovieLibraryAssignmentApplication.class, args);
	}
}
