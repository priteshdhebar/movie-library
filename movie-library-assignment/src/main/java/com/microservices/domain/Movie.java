package com.microservices.domain;

import java.util.Date;
import java.util.Set;

/**
 * A Movie.
 */
public class Movie {

	public static final String ENTITY_TAG = "MDTO";
	
	public Movie(){
		
	}
	
	public Movie(Integer id,String uuId,String name,Genre genre,Set<CastAndCrew> castAndCrews,Date releaseDate){
		this.id = id;
		this.uuId = uuId;
		this.name = name;
		this.genre = genre;
		this.castAndCrews = castAndCrews;
		this.releaseDate = releaseDate;
	}
	
	private Integer id;
	private String uuId;
	private String name;
	//OneToOne relationship with genre
	private Genre genre;
	//used for many to many relationship with CastAndCrew(create relationship table for mapping) when we persist data to Database using ORM
	private Set<CastAndCrew> castAndCrews;
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
	public Genre getGenre() {
		return genre;
	}
	public void setGenre(Genre genre) {
		this.genre = genre;
	}
	public Set<CastAndCrew> getCastAndCrews() {
		return castAndCrews;
	}
	public void setCastAndCrews(Set<CastAndCrew> castAndCrews) {
		this.castAndCrews = castAndCrews;
	}
	public Date getReleaseDate() {
		return releaseDate;
	}
	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}
	
}
