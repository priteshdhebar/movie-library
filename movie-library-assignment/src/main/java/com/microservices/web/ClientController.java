package com.microservices.web;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.microservices.dto.MovieDTO;
import com.microservices.rest.utils.HeaderUtil;

@Controller
public class ClientController {

	@Autowired
	protected ClientMovieLibraryService clientMovieLibraryService;

	public ClientController(ClientMovieLibraryService clientMovieLibraryService) {
		this.clientMovieLibraryService = clientMovieLibraryService;
	}

    @RequestMapping(value = "/movie/{id}",
        method = RequestMethod.GET,
        produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<MovieDTO> getMovie(@PathVariable Integer id) {
        return Optional.ofNullable(clientMovieLibraryService.getMovie(id))
            .map(result -> new ResponseEntity<>(
                result,
                HttpStatus.OK))
            .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @RequestMapping(value = "/movie/{id}",
        method = RequestMethod.DELETE,
        produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> deleteMovie(@PathVariable Integer id) {
    	clientMovieLibraryService.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert("movie", id.toString())).build();
    }	
	
}
