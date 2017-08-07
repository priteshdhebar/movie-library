package com.microservices.dto;

import java.util.Date;
import java.util.Set;

import com.microservices.enums.CrewType;

public class CastAndCrewDTO {

	private Integer id;
	private String uuId;
	private CrewType type;
	private String name;
	private Date birthDate;
	private Set<MovieDTO> movieDTOs;
	
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
	public Set<MovieDTO> getMovieDTOs() {
		return movieDTOs;
	}
	public void setMovieDTOs(Set<MovieDTO> movieDTOs) {
		this.movieDTOs = movieDTOs;
	}
	
}
