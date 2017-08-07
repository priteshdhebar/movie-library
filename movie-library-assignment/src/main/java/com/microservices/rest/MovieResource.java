package com.microservices.rest;

import java.awt.print.Pageable;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Collection;
import java.util.Optional;

import javax.inject.Inject;
import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.microservices.dto.MovieDTO;
import com.microservices.rest.utils.HeaderUtil;
import com.microservices.service.MovieService;
import com.microservices.service.utils.UUIDGeneratorFactory;

@RestController
@RequestMapping("/services")
public class MovieResource {

	@Inject
	private UUIDGeneratorFactory uuIdGeneratorFactory;
	
	@Inject
	private MovieService movieService;
	
	
    @RequestMapping(value = "/movie",
        method = RequestMethod.POST,
        produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<MovieDTO> createMovie(@Valid @RequestBody MovieDTO movieDTO) throws URISyntaxException {
        if (movieDTO.getId() != null) {
            return ResponseEntity.badRequest().headers(HeaderUtil.createFailureAlert("movie", "idexists", "A new movie cannot already have an ID")).body(null);
        }
        MovieDTO result = null;
        try{
        	result = movieService.saveOrUpdate(movieDTO);
        }catch(Exception e){
        	System.out.println(e.getMessage());
        }
        
        return ResponseEntity.created(new URI("/services/movie/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert("movie", result.getId().toString()))
            .body(result);
    }

    @RequestMapping(value = "/movie",
        method = RequestMethod.PUT,
        produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<MovieDTO> updateMovie(@Valid @RequestBody MovieDTO movieDTO) throws URISyntaxException {
    	MovieDTO result = null;
    	try{
    		result = movieService.saveOrUpdate(movieDTO);
        }catch(Exception e){
        	System.out.println(e.getMessage());
        }
        
        return ResponseEntity.created(new URI("/services/movie/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert("movie", result.getId().toString()))
            .body(result);
    }

    @RequestMapping(value = "/movie",
        method = RequestMethod.GET,
        produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Collection<MovieDTO>> getAllMovies(Pageable pageable) throws URISyntaxException {
    	Collection<MovieDTO> movieDTOs = null;
    	try{
    		movieDTOs = movieService.getMovies();
        }catch(Exception e){
        	System.out.println(e.getMessage());
        }
        
        return Optional.ofNullable(movieDTOs)
                .map(result -> new ResponseEntity<>(
                    result,
                    HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @RequestMapping(value = "/movie/{id}",
        method = RequestMethod.GET,
        produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<MovieDTO> getMovie(@PathVariable Integer id) {
    	MovieDTO movieDTO = null;
    	try{
    		movieDTO = movieService.getMovie(id);
        }catch(Exception e){
        	System.out.println(e.getMessage());
        }
        
        return Optional.ofNullable(movieDTO)
            .map(result -> new ResponseEntity<>(
                result,
                HttpStatus.OK))
            .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @RequestMapping(value = "/movie/{id}",
        method = RequestMethod.DELETE,
        produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> deleteMovie(@PathVariable Integer id) {
    	try{
    		movieService.delete(id);
        }catch(Exception e){
        	System.out.println(e.getMessage());
        }        
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert("movie", id.toString())).build();
    }
	
}
