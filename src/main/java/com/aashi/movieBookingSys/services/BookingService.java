package com.aashi.movieBookingSys.services;

import com.aashi.movieBookingSys.Exceptions.BookingDetailsNotFoundException;
import com.aashi.movieBookingSys.Exceptions.MovieTheatreDetailsNotFoundException;
import com.aashi.movieBookingSys.Exceptions.UserDetailsNotFoundException;
import com.aashi.movieBookingSys.entities.Booking;

import java.util.List;

public interface BookingService {
    public Booking acceptBookingDetails(Booking booking) throws MovieTheatreDetailsNotFoundException,
            UserDetailsNotFoundException;
    public Booking getBookingDetails(int id) throws BookingDetailsNotFoundException;
    public boolean deleteBooking(int id) throws BookingDetailsNotFoundException;
    public List<Booking> getAllBookingDetails();

}
