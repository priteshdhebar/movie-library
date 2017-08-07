package com.microservices.service;

import java.util.Collection;
import java.util.Set;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.microservices.domain.Movie;
import com.microservices.dto.MovieDTO;
import com.microservices.mapper.MovieMapper;
import com.microservices.service.utils.cacheutil.MovieCache;

@Service
public class MovieService {

	@Inject
	private MovieMapper movieMapper;
	
	@Inject
	private MovieCache movieCache;
	
    public MovieDTO saveOrUpdate(MovieDTO movieDTO) throws Exception{
        Movie movie = movieMapper.movieDTOToMovie(movieDTO);
        MovieDTO result = movieMapper.movieToMovieDTO(movieCache.saveOrupdateMovies(movie));
        return result;
    }
    
    public Collection<MovieDTO> saveOrUpdate() throws Exception{        
        return movieMapper.moviesToMovieDTOs(movieCache.getMovies());
    }
    
    public void delete(Integer movieId) throws Exception{        
        movieCache.deleteMovie(movieId);
    }
    
    public MovieDTO getMovie(Integer movieId) throws Exception{        
        return movieMapper.movieToMovieDTO(movieCache.getMovie(movieId));
    }
    
    public Collection<MovieDTO> getMovies() throws Exception{        
        return movieMapper.moviesToMovieDTOs(movieCache.getMovies());
    }
	
}
