package com.aashi.movieBookingSys.services.implementation;

import com.aashi.movieBookingSys.Exceptions.MovieDetailsNotFoundException;
import com.aashi.movieBookingSys.Exceptions.UserDetailsNotFoundException;
import com.aashi.movieBookingSys.Exceptions.UserNameAlreadyExistException;
import com.aashi.movieBookingSys.Exceptions.UserTypeDetailsNotFoundException;
import com.aashi.movieBookingSys.dao.UserDao;
import com.aashi.movieBookingSys.entities.User;
import com.aashi.movieBookingSys.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    /**
     * To talk with database I need the help of UserDao
     */
    @Autowired
    private UserDao userDao;
    @Override
    public User acceptUserDetails(User user) throws UserNameAlreadyExistException, UserTypeDetailsNotFoundException {
        return userDao.save(user);
    }

    @Override
    public User getUserDetails(int id) throws UserDetailsNotFoundException {
        /**
         * fetch user details based on the id
         */
        return userDao.findById(id)
                .orElseThrow(() -> new UserDetailsNotFoundException("Customer not found with id: "+ id));
    }

    @Override
    public User getUserDetailsByName(String username) throws UserDetailsNotFoundException {
        System.out.println("Aashi is dumb");
        //System.out.println(username);
        return userDao.findByUsername(username)
                .orElseThrow(() -> new UserDetailsNotFoundException("Customer not found with username: " + username));
    }

    @Override
    public User updateUserDetails(int id, User user)
            throws UserDetailsNotFoundException, UserNameAlreadyExistException, UserTypeDetailsNotFoundException {

        User savedUser = getUserDetails(id);
        if (userDao.findByUsername(user.getUsername()).isPresent()) {
            throw new UserNameAlreadyExistException("This username is already taken.");
        }

        if (isNotNullOrZero(user.getFirstName())) {
            savedUser.setFirstName(user.getFirstName());
        }

        if (isNotNullOrZero(user.getLastName())) {
            savedUser.setLastName(user.getLastName());
        }

        if (isNotNullOrZero(user.getUsername())) {
            savedUser.setUsername(user.getUsername());
        }

        if (isNotNullOrZero(user.getPassword())) {
            savedUser.setPassword(user.getPassword());
        }

        if (isNotNullOrZero(user.getDateOfBirth())) {
            savedUser.setDateOfBirth(user.getDateOfBirth());
        }

        if (isNotNullOrZero(user.getPhoneNumbers())) {
            savedUser.setPhoneNumbers(user.getPhoneNumbers());
        }



        return userDao.save(savedUser);
    }

    private boolean isNotNullOrZero(Object obj) {
        return obj != null;
    }
   }


