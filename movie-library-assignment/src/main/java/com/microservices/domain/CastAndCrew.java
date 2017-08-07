package com.microservices.domain;

import java.util.Date;
import java.util.Set;

import com.microservices.enums.CrewType;

/**
 * A CastAndCrew.
 */
public class CastAndCrew {

	public static final String ENTITY_TAG = "CAC";
	
	public CastAndCrew(){
		
	}
	
	public CastAndCrew(Integer id, String uuId, CrewType type, String name, Date birthDate, Set<Movie> movies){
		this.id = id;
		this.uuId = uuId;
		this.type = type;
		this.name = name;
		this.birthDate = birthDate;
		this.movies = movies;
	}
	
	private Integer id;
	private String uuId;
	private CrewType type;
	private String name;
	private Date birthDate;
	//used for many to many relationship with movies(create relationship table for mapping) when we persist data to Database using ORM 
	private Set<Movie> movies;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUuId() {
		return uuId;
	}
	public void setUuId(String uuId) {
		this.uuId = uuId;
	}
	public CrewType getType() {
		return type;
	}
	public void setType(CrewType type) {
		this.type = type;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	public Set<Movie> getMovies() {
		return movies;
	}
	public void setMovies(Set<Movie> movies) {
		this.movies = movies;
	}	
	
}
