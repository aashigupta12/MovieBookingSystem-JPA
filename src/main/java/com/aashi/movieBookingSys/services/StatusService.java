package com.aashi.movieBookingSys.services;

import com.aashi.movieBookingSys.Exceptions.StatusDetailsNotFoundException;
import com.aashi.movieBookingSys.entities.Status;

import java.util.List;

public interface StatusService {
    public Status acceptStatusDetails(Status status);
    public Status getStatusDetails(int id) throws StatusDetailsNotFoundException;
    public Status getStatusDetailsByStatusName(String statusName) throws StatusDetailsNotFoundException;
    public boolean deleteStatus(int id) throws StatusDetailsNotFoundException;
    public List<Status> getAllStatusDetails();
}
