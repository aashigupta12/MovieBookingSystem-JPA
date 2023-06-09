package com.aashi.movieBookingSys.services;

import com.aashi.movieBookingSys.Exceptions.TheatreDetailsNotFoundException;
import com.aashi.movieBookingSys.entities.Theatre;

import java.util.List;

public interface TheatreService {
    public Theatre acceptTheatreDetails(Theatre theatre);
    public Theatre getTheatreDetails(int id) throws TheatreDetailsNotFoundException;
    public Theatre updateTheatreDetails(int id, Theatre theatre) throws TheatreDetailsNotFoundException;
    public boolean deleteTheatre(int id) throws TheatreDetailsNotFoundException;
    public List<Theatre> getAllTheatreDetails();
}
