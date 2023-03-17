package com.aashi.movieBookingSys.dao;

import com.aashi.movieBookingSys.entities.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

//generics -> type safety

//JpaRepository<Movie,Integer> -> <> -> generics
public interface MovieDao extends JpaRepository<Movie,Integer> {

    /*
    * I also want to support the search based on the movie name
    */

    //spring data is doing this
    //{AOP, Reflection APIs, Dynamic Proxy}
//    public Movie findByMovieName(String movieName);
    public List<Movie> findByMovieName(String movieName);


    //I want to query based on multiple columns
    //query based on name and duration
    public List<Movie> findByMovieNameAndDuration(String name, int duration);

    //I want to find the movie with duration greater than given hour
    public List<Movie> findByDurationGreaterThanEqual(int duration);
//    public Optional<Movie> findByDurationGreaterThanEqual(int duration);

    public List<Movie> findByDurationLessThan(int duration);


}
