package com.example.spring_cinema.controllers;

import com.example.spring_cinema.models.Movie;
import com.example.spring_cinema.services.MovieService;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/movies")
public class MovieController {

    @Autowired
    MovieService movieService;

//    GET MOVIES - ALL
    @GetMapping(value = "/{id}")
    public ResponseEntity getMovieId(@PathVariable long id){
        Optional<Movie> movie = movieService.getMovieById(id);
        return new ResponseEntity<>(movie, HttpStatus.OK);
    }

//    GET MOVIES
    @GetMapping
    public ResponseEntity<List<Movie>> getMovies(){
        List<Movie> movie = movieService.getAllMovies();
        return new ResponseEntity<>(movie, HttpStatus.OK);
    }

//    POST MOVIES
    @PostMapping
    public ResponseEntity<Movie> postMovies(@RequestBody Movie movie){
        movieService.addMovie(movie);
        return new ResponseEntity<Movie>(HttpStatus.OK);

    }







}
