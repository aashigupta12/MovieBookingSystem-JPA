package com.aashi.movieBookingSys.services.impl;

import com.aashi.movieBookingSys.dao.MovieDao;
import com.aashi.movieBookingSys.entities.Movie;
import com.aashi.movieBookingSys.entities.Status;
import com.aashi.movieBookingSys.services.implementation.MovieServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

@SpringBootTest
public class MovieServiceImplUnitTest {
    /**
     * MovieServiceImpl, depends on MovieDao
     *
     * 1. We need to create a dummy of MovieDao
     * 2. replace original MovieDao present in MovieServiceImpl
     * */

    //if I wanted original MovieDao, I would have used @Autowired
    // but for dummy MovieDao, @Mock
    /**
     * This is dummy or mocked MovieDao
     **/
    @Mock
    private MovieDao movieDao;

    /**
     * This creates the movieServiceImpl object with mocked movieDao
     * */
    @InjectMocks
    private MovieServiceImpl movieService;

    Movie movie;
    @BeforeEach
    public void beforeTest() {
        movie = new Movie();
        movie.setMovieId(1);
        movie.setMovieName("test movie1");
        movie.setMovieDescription("desc 1");
        movie.setCoverPhotoUrl("test cover 1");
        movie.setReleaseDate(LocalDateTime.of(2003, 2, 2, 9, 8, 8));
        movie.setDuration(120);
        movie.setTrailerUrl("url");

        Status status = new Status();
        status.setStatusName("RELEASED");
        movie.setStatus(status);

        /**
         * ->> original MovieDao has all functionality but in dummy we have to add
         * adding the functionality on MovieDao
         *
         * It says to movieDao, when save method is called, just return the object back
         *
         * This doesn't involve actual calling of the database
         * */
        //whenever "movieDao.save" method is called, return movie Object
        Mockito.when(movieDao.save(movie)).thenReturn(movie);
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

}
