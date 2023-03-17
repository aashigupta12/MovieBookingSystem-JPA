package com.aashi.movieBookingSys.services;

import com.aashi.movieBookingSys.Exceptions.MovieDetailsNotFoundException;
import com.aashi.movieBookingSys.entities.Movie;

import java.util.List;

/**
 * this interface will define method supported
 * by MovieService
 */
public interface MovieService {
    /**
     * It should be able to take movie request
     * and save it to database
     */
    public Movie acceptMovieDetails(Movie movie);

    /**
     * I want to get the movie details
     * based on movie id
     * if the id is present it should give movie
     * otherwise throws (custom) exception!
     */
    public Movie getMovieDetails(int id) throws MovieDetailsNotFoundException;

    /**
     * I want to update the details of existing movie
     */
    public Movie updateMovieDetails(int id, Movie movie) throws MovieDetailsNotFoundException;

    /**
    * Delete a movie
    * */
    public boolean deleteMovie(int id) throws MovieDetailsNotFoundException;

    /**
     * get list of all movies
     * */
    public List<Movie> getAllMoviesDetails();
}
