package com.aashi.movieBookingSys.services.impl;

import com.aashi.movieBookingSys.entities.Movie;
import com.aashi.movieBookingSys.entities.Status;
import com.aashi.movieBookingSys.services.implementation.MovieServiceImpl;
import com.aashi.movieBookingSys.services.implementation.StatusServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

/**
 * This class will be used to write the test cases
 * of the MovieServiceImpl class
 *
 * */
@SpringBootTest
//in order to make spring aware of this test folder,
//for creating beans, injections
public class MovieServiceImplTest {

    /**
     * @Autowired -> tells spring to inject the dependency
     *
     * */
    @Autowired
    private MovieServiceImpl movieService;
    @Autowired
    private StatusServiceImpl statusService;

    Movie movie;
    @BeforeEach
    public void beforeTest(){
        movie = new Movie();
        movie.setMovieName("test movie1");
        movie.setMovieDescription("desc 1");
        movie.setCoverPhotoUrl("test cover 1");
        movie.setReleaseDate(LocalDateTime.of(2003,2,2,9,8,8));
        movie.setDuration(120);
        movie.setTrailerUrl("url");

        Status status = new Status();
        status.setStatusName("RELEASED");
        statusService.acceptStatusDetails(status);
        movie.setStatus(status);
    }

    /**
     * Test acceptMovieDetails
     * */
    @Test
    public void testAcceptMovieDetails(){
//        System.out.println("MovieServiceObject "+ movieService);
        /**
         * check if this method is able to save the movie or not
         * */
        Movie savedMovie =  movieService.acceptMovieDetails(movie);

        Assertions.assertNotNull("TEST ->>>>>> " + savedMovie);
        Assertions.assertNotNull("TEST ->>>>>> " + savedMovie.getMovieId());
    }


    /**
     * Test getMovieDetails
     * */


    /**
     * Test updateMovieDetails
     * */


    /**
     * Test deleteMovie
     * */
}
