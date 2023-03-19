package com.aashi.movieBookingSys.services;


import com.aashi.movieBookingSys.Exceptions.MovieTheatreDetailsNotFoundException;
import com.aashi.movieBookingSys.Exceptions.UserDetailsNotFoundException;
import com.aashi.movieBookingSys.Exceptions.UserNameAlreadyExistException;
import com.aashi.movieBookingSys.Exceptions.UserTypeDetailsNotFoundException;

/**
 * this will be used to initialize data in all the tables of
 * the mobile booking system
 * */
public interface InitService {
    /**
     * this method when called, will initialize the data in the database
     * */
    public void init() throws UserNameAlreadyExistException, UserTypeDetailsNotFoundException, MovieTheatreDetailsNotFoundException, UserDetailsNotFoundException;
}
