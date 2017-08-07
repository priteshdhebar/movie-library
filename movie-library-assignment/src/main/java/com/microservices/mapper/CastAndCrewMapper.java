package com.microservices.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.microservices.domain.CastAndCrew;
import com.microservices.domain.Genre;
import com.microservices.domain.Movie;
import com.microservices.dto.CastAndCrewDTO;
import com.microservices.dto.GenreDTO;

@Mapper(componentModel = "spring", uses = {Movie.class})
public interface CastAndCrewMapper {

	@Mapping(source = "movie",target = "movieDTO")
	CastAndCrewDTO castAndCrewToCastAndCrewDTO(CastAndCrew castAndCrew);
	
	@Mapping(source = "movieDTO",target = "movie")
	CastAndCrew castAndCrewDTOTocastAndCrew(CastAndCrewDTO castAndCrewDTO);
	
}
