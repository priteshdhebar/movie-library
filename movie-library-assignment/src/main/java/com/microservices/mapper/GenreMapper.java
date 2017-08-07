package com.microservices.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.microservices.domain.CastAndCrew;
import com.microservices.domain.Genre;
import com.microservices.domain.Movie;
import com.microservices.dto.GenreDTO;

@Mapper(componentModel = "spring", uses = {Movie.class})
public interface GenreMapper {

	@Mapping(source = "movie",target = "movieDTO")
	GenreDTO genreToGenreDTO(Genre genre);
	
	@Mapping(source = "movieDTO",target = "movie")
	Genre genreDTOToGenre(GenreDTO genreDTO);
	
}
