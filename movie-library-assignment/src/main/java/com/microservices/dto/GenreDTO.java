package com.microservices.dto;

import java.util.Date;
import java.util.Set;

public class GenreDTO {

	private Integer id;
	private String uuId;
	private String name;
	private GenreDTO genreDTO;
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
