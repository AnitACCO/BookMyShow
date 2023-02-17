package com.bookmyshow.BMS.services;

import com.bookmyshow.BMS.model.Movie;
import com.bookmyshow.BMS.model.User;
import com.bookmyshow.BMS.reposistory.MovieReposistory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.Access;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class MovieServicesImp implements MovieServices{

    @Autowired
    private MovieReposistory movieReposistory;

    @Override
    public Movie createMovie(Movie movie) {
        return movieReposistory.save(movie);
    }

    @Override
    public Movie updateMovie(Movie movie) {
        Optional<Movie> movieObj = this.movieReposistory.findById(movie.getMovieid());
        if(movieObj.isPresent()){
            Movie movieUpdate = movieObj.get();
            movieUpdate.setMovieid(movie.getMovieid());
            movieUpdate.setMovieName(movie.getMovieName());
            movieUpdate.setMovieGenre(movie.getMovieGenre());
            movieUpdate.setMovieLanguage(movie.getMovieLanguage());
            return this.movieReposistory.save(movieUpdate);
        }else {
            throw new RuntimeException("No Movie found with + " + movie.getMovieid());
        }
    }

    @Override
    public List<Movie> getAllMovie() {
        return this.movieReposistory.findAll();
    }

    @Override
    public Movie getMoviebyId(long movieid) {
        Optional<Movie> movieObj = this.movieReposistory.findById(movieid);
        if(movieObj.isPresent()){
            return movieObj.get();
        }
        else {
            throw new RuntimeException("No Movie found with id " + movieid);
        }
    }

    @Override
    public void deleteMovie(long movieid) {
        Optional<Movie> movieObj = this.movieReposistory.findById(movieid);
        if(movieObj.isPresent()){
            movieReposistory.delete(getMoviebyId(movieid));
        }
        else {
            throw new RuntimeException("No Product found with id " + movieid);
        }
    }
}
