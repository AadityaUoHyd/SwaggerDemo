package org.aadi.openAPI_Demo.controller;

import java.util.List;

import org.aadi.openAPI_Demo.exception.MovieIdMismatchException;
import org.aadi.openAPI_Demo.exception.MovieNotFoundException;
import org.aadi.openAPI_Demo.model.Movie;
import org.aadi.openAPI_Demo.repo.MovieRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController()
@RequestMapping("/movie")
public class MovieController {

    @Autowired
    private MovieRepo movieRepo;

    //Enter & Save few movies records(id,title,price) in H2 Database before hitting these Mappings URL in browser. e.g.
    // INSERT INTO Movie VALUES(1, 'Sholay', 'Ramesh Sippi', '100');
    
    @Operation(summary = "This is to fetch All the Movies stored in Db")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
            description = "Fetched All the Movies form Db",
            content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "404",
            description = "NOt Available",
            content = @Content)
    })
    @GetMapping("/allMovies")
    public List<Movie> allMovies() {
        return movieRepo.findAll();
    }

    @PostMapping("/post")
    @ResponseStatus(HttpStatus.CREATED)
    public Movie create(@RequestBody Movie movie)
    {
        return movieRepo.save(movie);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable long id)
    {
    	movieRepo.findById(id)
                .orElseThrow(MovieNotFoundException::new);
    	movieRepo.deleteById(id);
    }

    @PutMapping("/put/{id}")
    public Movie updateMovie(@RequestBody Movie movie, @PathVariable Long id) {
        if (movie.getId() != id) {
            throw new MovieIdMismatchException();
        }
        movieRepo.findById(id)
                .orElseThrow(MovieNotFoundException::new);
        return movieRepo.save(movie);
    }


    @GetMapping("/{id}")
    public Movie find(@PathVariable Long id) {
        return movieRepo.findById(id)
                .orElseThrow(MovieNotFoundException::new);
    }

}