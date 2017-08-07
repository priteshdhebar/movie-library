package com.microservices.dto;

import java.util.Date;
import java.util.Set;

import org.springframework.web.bind.annotation.Mapping;

import com.microservices.domain.CastAndCrew;
import com.microservices.domain.Genre;


public class MovieDTO {

	public static final String ENTITY_TAG = "MDTO";
	
	private Integer id;
	private String uuId;
	private String name;
	//OneToOne relationship with genre
	private GenreDTO genreDTO;
	//used for many to many relationship with CastAndCrew(create relationship table for mapping) when we persist data to Database using ORM
	private Set<CastAndCrewDTO> castAndCrewDTOs;
	private Date releaseDate;
	
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public GenreDTO getGenreDTO() {
		return genreDTO;
	}
	public void setGenreDTO(GenreDTO genreDTO) {
		this.genreDTO = genreDTO;
	}
	public Set<CastAndCrewDTO> getCastAndCrewDTOs() {
		return castAndCrewDTOs;
	}
	public void setCastAndCrewDTOs(Set<CastAndCrewDTO> castAndCrewDTOs) {
		this.castAndCrewDTOs = castAndCrewDTOs;
	}
	public Date getReleaseDate() {
		return releaseDate;
	}
	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}
	
}
