package com.microservices.domain;


/**
 * A Genre.
 */
public class Genre {

	public static final String ENTITY_TAG = "Gen";
	
	public Genre(){
		
	}
	
	public Genre(Integer id, String uuId, com.microservices.enums.Genre genre, Movie movie){
		this.id = id;
		this.uuId = uuId;
		this.genre = genre;
		this.movie = movie;
	}
	
	private Integer id;
	private String uuId;
	private com.microservices.enums.Genre genre;
	//ManyToOne relationship with movie when persist data to database
	private Movie movie;
	
	
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
	public com.microservices.enums.Genre getGenre() {
		return genre;
	}
	public void setGenre(com.microservices.enums.Genre genre) {
		this.genre = genre;
	}

	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}
	
}
