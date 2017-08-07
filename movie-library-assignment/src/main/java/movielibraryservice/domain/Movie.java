package movielibraryservice.domain;

import java.util.Date;
import java.util.Set;

/**
 * A Movie.
 */
public class Movie {

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
