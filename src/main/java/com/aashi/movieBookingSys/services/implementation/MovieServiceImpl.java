package com.aashi.movieBookingSys.services.implementation;

import com.aashi.movieBookingSys.Exceptions.MovieDetailsNotFoundException;
import com.aashi.movieBookingSys.dao.MovieDao;
import com.aashi.movieBookingSys.entities.Movie;
import com.aashi.movieBookingSys.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;


//@Component //to create bean
@Service
//internal of @Component: ask spring to create bean and put it into spring container
//Also indicates that it's a service layer class
public class MovieServiceImpl implements MovieService {

    /**
     * To talk with database I need the help of MovieDao
     */
    @Autowired
    private MovieDao movieDao;

    @Override
    public Movie acceptMovieDetails(Movie movie) {
        //with the help of MovieDao save into db
        return movieDao.save(movie);
    }

    @Override
    public Movie getMovieDetails(int id) throws MovieDetailsNotFoundException {
        /**
         * fetch movie details based on the id
         */
        return movieDao.findById(id)
                .orElseThrow(() ->
                        new MovieDetailsNotFoundException("Movie not found for id: " + id));
    }

    @Override
    public Movie updateMovieDetails(int id, Movie movie) throws MovieDetailsNotFoundException {
        /**
         * update the movie
         * */
        Movie savedMovie = movieDao.findById(id).orElseThrow(() ->
                new MovieDetailsNotFoundException("Movie not found" + id));

                /**
                 * read the attribute from the movie object &
                 * update it in saved movie
                 * */
                if(isNotNull(movie.getMovieName())){
                    savedMovie.setMovieName(movie.getMovieName());
                }

                if(isNotNull(movie.getMovieDescription())){
                    savedMovie.setMovieDescription(movie.getMovieDescription());
                }

                if(isNotNull(movie.getDuration())){
                    savedMovie.setDuration(movie.getDuration());
                }

                if(isNotNull(movie.getCoverPhotoUrl())){
                    savedMovie.setCoverPhotoUrl(movie.getCoverPhotoUrl());
                }

                if(isNotNull(movie.getReleaseDate())){
                    savedMovie.setReleaseDate(movie.getReleaseDate());
                }

                if(isNotNull(movie.getStatus())){
                    savedMovie.setStatus(movie.getStatus());
                }

                if(isNotNull(movie.getTrailerUrl())){
                    savedMovie.setTrailerUrl(movie.getTrailerUrl());
                }

                return movieDao.save(savedMovie);
    }

    private boolean isNotNull(Object obj){
        return obj != null;
    }

    @Override
    public boolean deleteMovie(int id) throws MovieDetailsNotFoundException {
        //first I find savedMovie, if it is present all fine, otherwise throw error
        Movie savedMovie = getMovieDetails(id);
        //if I found movie, delete the movie
        movieDao.delete(savedMovie);
        //then return true!!
        return true;
    }

    @Override
    public List<Movie> getAllMoviesDetails() {
        return movieDao.findAll();
    }
}
