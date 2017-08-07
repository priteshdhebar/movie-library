package com.microservices.config;

import com.microservices.config.client.MovieLibraryClient;
import com.microservices.config.discovery.MovieLibraryDiscovery;

public class StartService {

	public static final String REGISTRATION_SERVER = "server";
	public static final String MOVIE_LIBRARY_SERVICE = "movielibraryservice";
	
	public static void main(String[] args) {

		String serverName = args[0].toLowerCase();

		if (serverName.equals(REGISTRATION_SERVER)) {
			MovieLibraryDiscovery.main(args);
		} else if (serverName.equals(MOVIE_LIBRARY_SERVICE)) {
			MovieLibraryClient.main(args);
		}
	}
	
}
