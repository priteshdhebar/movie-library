package com.microservices.mapper;

import java.util.Collection;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import com.microservices.domain.CastAndCrew;
import com.microservices.domain.Genre;
import com.microservices.domain.Movie;
import com.microservices.dto.MovieDTO;

@Mapper(componentModel = "spring", uses = {Genre.class,CastAndCrew.class})
public interface MovieMapper {
	
	@Mappings({@Mapping(source = "genre",target = "genreDTO"),
	@Mapping(source = "castAndCrew",target = "castAndCrewDTO")})
	MovieDTO movieToMovieDTO(Movie movie);
	
	@Mappings({@Mapping(source = "castAndCrewDTO",target = "castAndCrew"),
		@Mapping(source = "genreDTO",target = "genre")})
	Movie movieDTOToMovie(MovieDTO movieDTO);
	
	Collection<MovieDTO> moviesToMovieDTOs(Collection<Movie> movie);
	
}
