package com.aashi.movieBookingSys.dao;

import com.aashi.movieBookingSys.entities.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarDao extends JpaRepository<Car, Integer> {

}
