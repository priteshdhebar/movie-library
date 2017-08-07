package com.microservices.service.utils.cacheutil;

import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.inject.Inject;

import com.microservices.domain.CastAndCrew;
import com.microservices.domain.Genre;
import com.microservices.domain.Movie;
import com.microservices.enums.CrewType;
import com.microservices.service.utils.UUIDGeneratorFactory;

public class MovieCache {

	  private static MovieCache uniqueInstance;
	  
	  private static Map<Integer, Movie> movies = new HashMap<Integer, Movie>();
	  
	  private static Integer movieCount = 1;
	  private static Integer genreCount = 1;
	  private static Integer castAndCrewCount = 1;
	  
	  @Inject
	  private UUIDGeneratorFactory uuIdGeneratorFactory;

	  private MovieCache() {
		  getDefaultMovie();
	  }
	  
	  private void getDefaultMovie(){
		  Movie movie = new Movie(movieCount,uuIdGeneratorFactory.getUUIDGenerator().generate(Movie.ENTITY_TAG),"Tranporter",getDefaultGenre(),getDefaultCastAndCrew(),new Date());
		  movies.put(movie.getId(), movie);
	  }
	  
	  private Genre getDefaultGenre(){
		  Genre genre = new Genre();
		  genre.setId(1);
		  genre.setUuId(uuIdGeneratorFactory.getUUIDGenerator().generate(Genre.ENTITY_TAG));
		  genre.setGenre(com.microservices.enums.Genre.ACTION);
		  return genre;
	  }
	  
	  private Set<CastAndCrew> getDefaultCastAndCrew(){
		  Set<CastAndCrew> castAndCrew = new HashSet<>();
		  castAndCrew.add(new CastAndCrew(castAndCrewCount,uuIdGeneratorFactory.getUUIDGenerator().generate(CastAndCrew.ENTITY_TAG),CrewType.ACTOR,"Jason Statham",new Date(),null));
		  return castAndCrew;
	  }

	  public static synchronized MovieCache getInstance() {
	    if (uniqueInstance == null) {
	       uniqueInstance = new MovieCache();
	    }
	    return uniqueInstance;
	  }
	  
	  public Collection<Movie> getMovies(){
		  return movies.values();
	  }
	  
	  public Movie getMovie(Integer id){
		  return movies.get(id);
	  }
	  
	  public void deleteMovie(Integer id){
		  movieCount--;
		  genreCount--;
		  castAndCrewCount--;
		  movies.remove(id);
	  }
	  
	  public Movie saveOrupdateMovies(Movie movie){
		  movie.setId(movieCount++);
		  movie.setUuId(uuIdGeneratorFactory.getUUIDGenerator().generate(Movie.ENTITY_TAG));
		  movie.getGenre().setId(genreCount++);
		  movie.getGenre().setUuId(uuIdGeneratorFactory.getUUIDGenerator().generate(Genre.ENTITY_TAG));
		  for(CastAndCrew castAndCrew : movie.getCastAndCrews()){
			  castAndCrew.setId(castAndCrewCount++);
			  castAndCrew.setUuId(uuIdGeneratorFactory.getUUIDGenerator().generate(CastAndCrew.ENTITY_TAG));
		  }
		  movies.put(movie.getId(), movie);
		  return movie;
	  }
	  	  
}
