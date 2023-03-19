package com.aashi.movieBookingSys.services.implementation;

import com.aashi.movieBookingSys.Exceptions.BookingDetailsNotFoundException;
import com.aashi.movieBookingSys.Exceptions.MovieTheatreDetailsNotFoundException;
import com.aashi.movieBookingSys.Exceptions.UserDetailsNotFoundException;
import com.aashi.movieBookingSys.dao.BookingDao;
import com.aashi.movieBookingSys.entities.Booking;
import com.aashi.movieBookingSys.services.BookingService;
import com.aashi.movieBookingSys.services.MovieTheatreService;
import com.aashi.movieBookingSys.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingServiceImpl implements BookingService {

    @Autowired
    public MovieTheatreService movieTheatreService;
    @Autowired
    public UserService userService;
    @Autowired
    public BookingDao bookingDao;
    @Override
    public Booking acceptBookingDetails(Booking booking) throws MovieTheatreDetailsNotFoundException, UserDetailsNotFoundException {
        movieTheatreService.getMovieTheatreDetails(booking.getMovieTheatre().getMovieTheatreId());
        userService.getUserDetails(booking.getUser().getCustomerId());
        return bookingDao.save(booking);
    }

    @Override
    public Booking getBookingDetails(int id) throws BookingDetailsNotFoundException {
        return bookingDao.findById(id)
                .orElseThrow(
                        () -> new BookingDetailsNotFoundException("Booking not found for id: " + id)
                );
    }

    @Override
    public boolean deleteBooking(int id) throws BookingDetailsNotFoundException {
        Booking booking = getBookingDetails(id);
        bookingDao.delete(booking);
        return true;
    }

    @Override
    public List<Booking> getAllBookingDetails() {
        return bookingDao.findAll();
    }
}
