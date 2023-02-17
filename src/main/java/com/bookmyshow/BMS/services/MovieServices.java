package com.bookmyshow.BMS.services;

import com.bookmyshow.BMS.model.Movie;
import com.bookmyshow.BMS.model.User;

import java.util.List;

public interface MovieServices {
    Movie createMovie(Movie movie);
    Movie updateMovie(Movie movie);
    List<Movie> getAllMovie();
    Movie getMoviebyId(long movieid);
    void deleteMovie(long movieid);
}
