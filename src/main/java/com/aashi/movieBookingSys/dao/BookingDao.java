package com.aashi.movieBookingSys.dao;

import com.aashi.movieBookingSys.entities.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingDao extends JpaRepository<Booking, Integer> {
}
