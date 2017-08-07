package com.microservices.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.microservices.dto.MovieDTO;

@Service
public class ClientMovieLibraryService {

	@Autowired
	@LoadBalanced
	protected RestTemplate restTemplate;

	protected String serviceUrl;

	public ClientMovieLibraryService(String serviceUrl) {
		this.serviceUrl = serviceUrl.startsWith("http") ? serviceUrl
				: "http://" + serviceUrl;
	}
	
	public void delete(Integer id) throws Exception{
		restTemplate.delete(serviceUrl + "/services/movie/{id}", id);
	}
	
	public MovieDTO getMovie(Integer id) throws Exception{
		return restTemplate.getForObject(serviceUrl + "/services/movie/{id}",
				MovieDTO.class, id);
	}

}
