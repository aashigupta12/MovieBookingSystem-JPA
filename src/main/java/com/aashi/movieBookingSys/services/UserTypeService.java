package com.aashi.movieBookingSys.services;

import com.aashi.movieBookingSys.Exceptions.UserTypeDetailsNotFoundException;
import com.aashi.movieBookingSys.entities.UserType;

import java.util.List;

public interface UserTypeService {
    public UserType acceptUserTypeDetails(UserType userType);
    public UserType getUserTypeDetails(int id) throws UserTypeDetailsNotFoundException;
    public UserType getUserTypeDetailsFromUserTypeName(String userTypeName) throws UserTypeDetailsNotFoundException;
    public boolean deleteUserType(int id) throws UserTypeDetailsNotFoundException;
    public List<UserType> getAllUserTypeDetails();

}
