package movielibraryservice.domain;

/**
 * A Genre.
 */
public class Genre {

	private Integer id;
	private String uuId;
	private Genre genre;
	//ManyToOne relationship with movie when persist data to database
	private Movie movies;
	
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
	public Genre getGenre() {
		return genre;
	}
	public void setGenre(Genre genre) {
		this.genre = genre;
	}	
	
}
