package com.aashi.movieBookingSys.services;

import com.aashi.movieBookingSys.Exceptions.UserDetailsNotFoundException;
import com.aashi.movieBookingSys.Exceptions.UserNameAlreadyExistException;
import com.aashi.movieBookingSys.Exceptions.UserTypeDetailsNotFoundException;
import com.aashi.movieBookingSys.entities.User;

public interface UserService {
    /**
     * Allow creation of users.
     * I should also not be allowed to
     * -> duplicate an existing user
     * -> create an existing user
     * -> to create a user of wrong type (normal user or admin user, nothing else)
     * */
    public User acceptUserDetails(User user)
            throws UserNameAlreadyExistException, UserTypeDetailsNotFoundException;

    /**
     * Fetch the user details based on user id
     * */
    public User getUserDetails(int id)
            throws UserDetailsNotFoundException;

    /**
     * Fetch user by its name
     * */
    public User getUserDetailsByUsername(String username)
            throws UserDetailsNotFoundException;

    /**
     * Update the user details
     * */
    public User updateUserDetails(int id, User user)
            throws UserDetailsNotFoundException, UserNameAlreadyExistException, UserTypeDetailsNotFoundException;


}
