package com.bookmyshow.BMS.controller;

import com.bookmyshow.BMS.model.Movie;
import com.bookmyshow.BMS.model.Theater;
import com.bookmyshow.BMS.services.MovieServices;
import com.bookmyshow.BMS.services.TheaterServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MovieController {
    @Autowired
    private MovieServices movieService;

    @GetMapping("/movie/{movieid}")
    private Movie getMovieById(@PathVariable long movieid){
        return this.movieService.getMoviebyId(movieid);
    }

    @GetMapping("/movie")
    private ResponseEntity<List<Movie>> getAllMovie(){
        return ResponseEntity.ok().body(this.movieService.getAllMovie());
    }

    @PostMapping("/addMovie")
    private ResponseEntity<Movie> saveMovie(@RequestBody Movie movie){
        return ResponseEntity.ok().body(this.movieService.createMovie(movie));
    }

    @PutMapping("/updateMovie/{movieid}")
    private ResponseEntity<Movie> updateMovie(@PathVariable long movieid, @RequestBody Movie movie){
        movie.setMovieid(movieid);
        return ResponseEntity.ok().body(this.movieService.updateMovie(movie));
    }

    @DeleteMapping("/deleteMovie/{movieid}")
    private HttpStatus deleteMovie(@PathVariable long movieid) {
        this.movieService.deleteMovie(movieid);
        return HttpStatus.OK;
    }


}
